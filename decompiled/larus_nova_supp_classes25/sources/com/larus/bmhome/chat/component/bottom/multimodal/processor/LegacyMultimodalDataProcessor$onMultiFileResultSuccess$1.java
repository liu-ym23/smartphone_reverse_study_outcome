package com.larus.bmhome.chat.component.bottom.multimodal.processor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.collection.LruCache;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.DirectSendFileHelper;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.component.bottom.p1$a;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.list.u7$a;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalCommonParamManager;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.bmhome.utils.FileMimeTypeUtils;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.z2;
import com.larus.trace.audioattachment.AudioAttachmentUploadEvent;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.m0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tx9.y3;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.processor.LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1", f = "LegacyMultimodalDataProcessor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {964, 1128, 1255}, m = "invokeSuspend", n = {"$this$launch", "replacementAttachmentLocalMsgId", "thisTimeAttachmentEntityList", "thisTimeAttachmentEntityTotalSize", "existImageFile", "existAudioFile", "existTypeDisallow", "existImageSizeDisallow", "existFileSizeDisallow", "existAudioDurationDisallow", "existCountDisallow", "audioWarningMessage", "driveFileDenyReason", "hasFile", "enterMethod", "isMultiChooseMode", "enterMethodForSendMessage", "actionBarTemplateName", "uri", "isImageType", "fileIdentifier", "isAudioType", "isVideoType", "driveAttachment", "audioTracker", "fileInfo", "isModeDraftReplacement", "isOpenedHasImgAttachInstruct", "enableLarkAudioAbility", "isHitMultipleAudio", "attachmentEntityPreCount", "index$iv", "index", "isAudioEntity", "$this$launch", "replacementAttachmentLocalMsgId", "thisTimeAttachmentEntityList", "thisTimeAttachmentEntityTotalSize", "existImageFile", "existAudioFile", "existTypeDisallow", "existImageSizeDisallow", "existFileSizeDisallow", "existAudioDurationDisallow", "existCountDisallow", "audioWarningMessage", "driveFileDenyReason", "hasFile", "enterMethod", "isMultiChooseMode", "enterMethodForSendMessage", "actionBarTemplateName", "uri", "isImageType", "fileIdentifier", "isAudioType", "isVideoType", "driveAttachment", "audioTracker", "fileInfo", "isModeDraftReplacement", "isOpenedHasImgAttachInstruct", "enableLarkAudioAbility", "isHitMultipleAudio", "attachmentEntityPreCount", "index$iv", "index", "isAudioEntity", "useVideoEntity", "isAudioCountLegal", "isAttachmentEntitiesCountLegal", "isMultiFile", "$this$launch", "replacementAttachmentLocalMsgId", "thisTimeAttachmentEntityList", "thisTimeAttachmentEntityTotalSize", "existImageFile", "existAudioFile", "existTypeDisallow", "existImageSizeDisallow", "existFileSizeDisallow", "existAudioDurationDisallow", "existCountDisallow", "audioWarningMessage", "driveFileDenyReason", "hasFile", "enterMethod", "isMultiChooseMode", "enterMethodForSendMessage", "actionBarTemplateName", "uri", "fileIdentifier", "driveAttachment", "$this$invokeSuspend_u24lambda_u2422_u24lambda_u2417", "$this$invokeSuspend_u24lambda_u2422_u24lambda_u2417_u24lambda_u2416", "token", "isModeDraftReplacement", "isOpenedHasImgAttachInstruct", "enableLarkAudioAbility", "isHitMultipleAudio", "attachmentEntityPreCount", "index$iv", "entityType"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "Z$0", "I$0", "Z$1", "Z$2", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "Z$0", "I$0", "Z$1", "Z$2", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "I$7", "I$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$27", "L$28", "L$29", "L$32", "L$34", "L$36", "Z$0", "I$0", "Z$1", "Z$2", "I$1", "I$2", "I$3"})
final class LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.larus.bmhome.chat.component.bottom.multimodal.a> $attachmentList;
    final /* synthetic */ long $attachmentSelectionEditedAt;
    final /* synthetic */ Integer $cameraType;
    final /* synthetic */ DirectSendData $directSendData;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ String $fromScene;
    final /* synthetic */ ns8.b $imageProcessConfig;
    final /* synthetic */ boolean $isFromDrive;
    final /* synthetic */ boolean $isFromFileBrowser;
    final /* synthetic */ List<Boolean> $isImagesAiCreation;
    final /* synthetic */ List<Boolean> $isImagesCropped;
    final /* synthetic */ List<Boolean> $isImagesMarked;
    final /* synthetic */ boolean $isOriginalImageChecked;
    final /* synthetic */ boolean $replaceModeDraftAfterValidation;
    final /* synthetic */ String $replacementToken;
    final /* synthetic */ List<String> $resultSource;
    final /* synthetic */ String $uploadTaskShareTag;
    final /* synthetic */ List<Uri> $uriList;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    int I$6;
    int I$7;
    int I$8;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$18;
    Object L$19;
    Object L$2;
    Object L$20;
    Object L$21;
    Object L$22;
    Object L$23;
    Object L$24;
    Object L$25;
    Object L$26;
    Object L$27;
    Object L$28;
    Object L$29;
    Object L$3;
    Object L$30;
    Object L$31;
    Object L$32;
    Object L$33;
    Object L$34;
    Object L$35;
    Object L$36;
    Object L$37;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    boolean Z$4;
    boolean Z$5;
    int label;
    final /* synthetic */ LegacyMultimodalDataProcessor this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.processor.LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.processor.LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$4", f = "LegacyMultimodalDataProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $audioWarningMessage;
        final /* synthetic */ Ref.ObjectRef<FlowDriveFileType> $driveFileDenyReason;
        final /* synthetic */ boolean $enableSupportAudio;
        final /* synthetic */ Ref.BooleanRef $existAudioDurationDisallow;
        final /* synthetic */ Ref.BooleanRef $existAudioFile;
        final /* synthetic */ Ref.BooleanRef $existCountDisallow;
        final /* synthetic */ Ref.BooleanRef $existFileSizeDisallow;
        final /* synthetic */ Ref.BooleanRef $existImageFile;
        final /* synthetic */ Ref.BooleanRef $existImageSizeDisallow;
        final /* synthetic */ Ref.BooleanRef $existTypeDisallow;
        final /* synthetic */ Ref.BooleanRef $hasFile;
        final /* synthetic */ boolean $isFromFileBrowser;
        final /* synthetic */ boolean $isHitMultipleAudio;
        final /* synthetic */ boolean $isModeDraftReplacement;
        int label;
        final /* synthetic */ LegacyMultimodalDataProcessor this$0;

        public AnonymousClass4(LegacyMultimodalDataProcessor r4, boolean r5, boolean r6, Ref.BooleanRef r7, Ref.BooleanRef r8, Ref.BooleanRef r9, Ref.BooleanRef r10, Ref.BooleanRef r11, Ref.BooleanRef r12, Ref.BooleanRef r13, boolean r14, Ref.ObjectRef<FlowDriveFileType> r15, Ref.BooleanRef r16, Ref.ObjectRef<String> r17, boolean r18, Continuation<? super AnonymousClass4> r19) {
            this.this$0 = r4;
            this.$enableSupportAudio = r5;
            this.$isHitMultipleAudio = r6;
            this.$existAudioFile = r7;
            this.$existImageFile = r8;
            this.$existTypeDisallow = r9;
            this.$existImageSizeDisallow = r10;
            this.$existFileSizeDisallow = r11;
            this.$existAudioDurationDisallow = r12;
            this.$existCountDisallow = r13;
            this.$isFromFileBrowser = r14;
            this.$driveFileDenyReason = r15;
            this.$hasFile = r16;
            this.$audioWarningMessage = r17;
            this.$isModeDraftReplacement = r18;
            super(2, r19);
        }

        public final Continuation<Unit> create(Object r20, Continuation<?> r21) {
            return new AnonymousClass4(this.this$0, this.$enableSupportAudio, this.$isHitMultipleAudio, this.$existAudioFile, this.$existImageFile, this.$existTypeDisallow, this.$existImageSizeDisallow, this.$existFileSizeDisallow, this.$existAudioDurationDisallow, this.$existCountDisallow, this.$isFromFileBrowser, this.$driveFileDenyReason, this.$hasFile, this.$audioWarningMessage, this.$isModeDraftReplacement, r21);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r18);
            if (this.this$0.a.a.isAdded() == false) goto L7;
            LegacyMultimodalDataProcessor.x(this.this$0, this.$enableSupportAudio, this.$isHitMultipleAudio, this.$existAudioFile.element, this.$existImageFile.element, this.$existTypeDisallow.element, this.$existImageSizeDisallow.element, this.$existFileSizeDisallow.element, this.$existAudioDurationDisallow.element, this.$existCountDisallow.element, this.$isFromFileBrowser, (FlowDriveFileType) this.$driveFileDenyReason.element, this.$hasFile.element, (String) this.$audioWarningMessage.element, this.$isModeDraftReplacement);
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowDriveFileType.values().length];
            r0[FlowDriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FlowDriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FlowDriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1(String r4, boolean r5, List<? extends Uri> r6, boolean r7, LegacyMultimodalDataProcessor r8, boolean r9, List<? extends com.larus.bmhome.chat.component.bottom.multimodal.a> r10, Map<String, String> r11, Integer r12, DirectSendData r13, String r14, ns8.b r15, String r16, long r17, boolean r19, List<Boolean> r20, List<Boolean> r21, List<Boolean> r22, List<String> r23, Continuation<? super LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1> r24) {
        this.$fromScene = r4;
        this.$isFromFileBrowser = r5;
        this.$uriList = r6;
        this.$replaceModeDraftAfterValidation = r7;
        this.this$0 = r8;
        this.$isFromDrive = r9;
        this.$attachmentList = r10;
        this.$ext = r11;
        this.$cameraType = r12;
        this.$directSendData = r13;
        this.$replacementToken = r14;
        this.$imageProcessConfig = r15;
        this.$uploadTaskShareTag = r16;
        this.$attachmentSelectionEditedAt = r17;
        this.$isOriginalImageChecked = r19;
        this.$isImagesMarked = r20;
        this.$isImagesCropped = r21;
        this.$isImagesAiCreation = r22;
        this.$resultSource = r23;
        super(2, r24);
    }

    public final Continuation<Unit> create(Object r26, Continuation<?> r27) {
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 r15 = new LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1(this.$fromScene, this.$isFromFileBrowser, this.$uriList, this.$replaceModeDraftAfterValidation, this.this$0, this.$isFromDrive, this.$attachmentList, this.$ext, this.$cameraType, this.$directSendData, this.$replacementToken, this.$imageProcessConfig, this.$uploadTaskShareTag, this.$attachmentSelectionEditedAt, this.$isOriginalImageChecked, this.$isImagesMarked, this.$isImagesCropped, this.$isImagesAiCreation, this.$resultSource, r27);
        r15.L$0 = r26;
        return r15;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r24v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r25v37 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r26v12 */
    /* JADX WARN: Type inference failed for: r26v45 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r29v15 */
    /* JADX WARN: Type inference failed for: r29v19 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r2v190 */
    /* JADX WARN: Type inference failed for: r3v73 */
    /* JADX WARN: Type inference failed for: r3v74, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v83 */
    /* JADX WARN: Type inference failed for: r6v52, types: [com.larus.bmhome.chat.component.bottom.multimodal.processor.w] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:606:0x17ed -> B:607:0x1830). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:608:0x187e -> B:609:0x18c5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:653:0x19ac -> B:654:0x19eb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:689:0x1ae2 -> B:690:0x1b18). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r130) {
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 r1 = this;
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r1.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        int r3 = r1.I$3;
        int r6 = r1.I$2;
        boolean r7 = r1.Z$5;
        boolean r9 = r1.Z$4;
        boolean r8 = r1.Z$3;
        int r4 = r1.I$1;
        boolean r14 = r1.Z$2;
        boolean r12 = r1.Z$1;
        int r5 = r1.I$0;
        boolean r22 = r1.Z$0;
        VideoExtension r10 = (VideoExtension) r1.L$37;
        String r11 = (String) r1.L$36;
        UplinkFileInfo r25 = (UplinkFileInfo) r1.L$35;
        VideoExtension r26 = (VideoExtension) r1.L$34;
        VideoExtension r13 = (VideoExtension) r1.L$33;
        UplinkEntityContent r28 = (UplinkEntityContent) r1.L$32;
        UplinkEntityContent r29 = (UplinkEntityContent) r1.L$31;
        Map<String, String> r30 = (Map) r1.L$30;
        Ref.ObjectRef r31 = (Ref.ObjectRef) r1.L$29;
        String r32 = (String) r1.L$28;
        Uri r15 = (Uri) r1.L$27;
        Iterator r16 = (Iterator) r1.L$26;
        List<String> r35 = (List) r1.L$25;
        List<Boolean> r36 = (List) r1.L$24;
        List<Boolean> r17 = (List) r1.L$23;
        List<Boolean> r18 = (List) r1.L$22;
        String r19 = (String) r1.L$21;
        LegacyMultimodalDataProcessor r20 = (LegacyMultimodalDataProcessor) r1.L$20;
        List<Uri> r41 = (List) r1.L$19;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r42 = (List) r1.L$18;
        String r43 = (String) r1.L$17;
        String r44 = (String) r1.L$16;
        String r45 = (String) r1.L$15;
        String r46 = (String) r1.L$14;
        Ref.BooleanRef r47 = (Ref.BooleanRef) r1.L$13;
        Ref.ObjectRef r21 = (Ref.ObjectRef) r1.L$12;
        Ref.ObjectRef r23 = (Ref.ObjectRef) r1.L$11;
        Ref.BooleanRef r24 = (Ref.BooleanRef) r1.L$10;
        Ref.BooleanRef r51 = (Ref.BooleanRef) r1.L$9;
        Ref.BooleanRef r52 = (Ref.BooleanRef) r1.L$8;
        Ref.BooleanRef r27 = (Ref.BooleanRef) r1.L$7;
        Ref.BooleanRef r33 = (Ref.BooleanRef) r1.L$6;
        Ref.BooleanRef r34 = (Ref.BooleanRef) r1.L$5;
        Ref.BooleanRef r56 = (Ref.BooleanRef) r1.L$4;
        Ref.LongRef r57 = (Ref.LongRef) r1.L$3;
        List<UplinkFileEntity> r58 = (List) r1.L$2;
        String r59 = (String) r1.L$1;
        CoroutineScope r37 = (CoroutineScope) r1.L$0;
        ResultKt.throwOnFailure(r130);
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 r124 = r1;
        String r38 = "";
        List<Boolean> r110 = r17;
        Ref.ObjectRef r39 = r21;
        boolean r310 = r12;
        List<Boolean> r48 = r18;
        LegacyMultimodalDataProcessor r111 = r20;
        String r311 = " ";
        Object r112 = "1";
        boolean r113 = r7;
        int r40 = r5;
        int r49 = r3;
        Object r50 = r130;
        CoroutineScope r312 = r37;
        VideoExtension r53 = r10;
        Ref.ObjectRef r210 = r23;
        Iterator r410 = r16;
        Ref.BooleanRef r313 = r34;
        boolean r55 = r9;
        int r54 = r6;
        String r60 = "LegacyMultimodalDataProcessor";
        String r61 = r19;
        int r510 = r4;
        VideoExtension r62 = r13;
        Ref.BooleanRef r211 = r27;
        boolean r511 = r14;
        Object r114 = r0;
        Object r212 = "ext_is_from_drive";
        boolean r115 = r8;
        String r63 = r11;
        Ref.BooleanRef r213 = r24;
        Uri r131 = r15;
        Ref.BooleanRef r314 = r33;
    L607:
        r53.setDownloadUrl((String) r50);
        String r116 = r61;
        int r118 = r54;
        boolean r119 = r113;
        LegacyMultimodalDataProcessor r64 = r111;
        Object r117 = r114;
        Object r120 = r212;
        boolean r1110 = r22;
        String r65 = r32;
        List<String> r121 = r35;
        boolean r122 = r310;
        CoroutineScope r123 = r312;
        List<Uri> r1111 = r41;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r1112 = r42;
        String r1113 = r43;
        String r109 = r44;
        String r108 = r45;
        String r214 = r46;
        Ref.BooleanRef r215 = r47;
        List<Boolean> r66 = r48;
        Iterator r1114 = r410;
        boolean r125 = r511;
        int r1115 = r510;
        boolean r126 = r55;
        Ref.BooleanRef r315 = r56;
        VideoExtension r67 = r62;
        String r316 = r60;
        int r411 = r40;
        String r412 = r63;
        r62 = r26;
        UplinkEntityContent r68 = r28;
        UplinkEntityContent r69 = r29;
        Ref.ObjectRef r70 = r31;
        String r216 = r311;
        Ref.BooleanRef r217 = r52;
        Ref.ObjectRef r218 = r39;
        UplinkFileInfo r71 = r25;
        Ref.BooleanRef r219 = r51;
        Object r127 = r112;
    L610:
        if (r412.length() <= 0) goto L612;
        boolean r317 = true;
    L613:
        if (r317 == false) goto L615;
        String r318 = FlowDriveSdkService.a.f(LegacyMultimodalDataProcessor.o(r64), r412, 480, 480, null, null);
    L616:
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r72 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r72 == null) goto L621;
        Uri r73 = r72.b();
        if (r73 == null) goto L621;
        String r610 = r73.toString();
    L622:
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r74 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r74 == null) goto L636;
        String r75 = r74.j();
        if (r75 == null) goto L636;
        if (r75.length() <= 0) goto L629;
        boolean r319 = true;
    L630:
        if (r319 == true) goto L633;
        r75 = null;
    L633:
        if (r75 == null) goto L636;
        String r611 = r75;
    L637:
        ImageObj r76 = new ImageObj(r611, 0, 0, null, null, 30, null);
        UplinkFileInfo r320 = r71;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r77 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r77 == null) goto L651;
        String r78 = r77.i();
        if (r78 == null) goto L651;
        if (r78.length() <= 0) goto L644;
        boolean r321 = true;
    L645:
        if (r321 == true) goto L648;
        r78 = null;
    L648:
        if (r78 == null) goto L651;
        String r79 = r78;
    L652:
        ImageObj r612 = new ImageObj(r79, 0, 0, null, null, 30, null);
        LinkedHashMap r80 = new LinkedHashMap();
        r80.put(r120, r127);
        Unit r81 = Unit.INSTANCE;
        r62.setCover(new Image(r610, null, r76, r612, null, null, null, r80, null, null, null, null, null, null, 16242, null));
        r62 = r67;
        int r82 = r49;
        r312 = r123;
        boolean r83 = r115;
        List<String> r128 = r121;
        Ref.ObjectRef r84 = r210;
        String r129 = r216;
        UplinkFileInfo r85 = r320;
        r111 = r64;
        UplinkEntityContent r1210 = r68;
        UplinkEntityContent r86 = r69;
        r69 = r1210;
        Object r132 = r127;
        Object r133 = r120;
    L654:
        Unit r220 = Unit.INSTANCE;
        r85.setVideo(r62);
        Map<String, String> r87 = r30;
        Ref.LongRef r88 = r57;
        Object r322 = r132;
        List<Boolean> r134 = r36;
    L656:
        if (r83 == false) goto L686;
        int r135 = r82;
        UplinkFileInfo r89 = r69.getUplinkFileInfo();
        Map<String, String> r221 = r87;
        if (r89 == null) goto L666;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r90 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r90 == null) goto L664;
        Uri r91 = r90.b();
        if (r91 == null) goto L664;
        String r92 = r91.toString();
    L665:
        r89.setTosKey(r92);
        Unit r93 = Unit.INSTANCE;
    L664:
        r92 = null;
    L666:
        UplinkFileInfo r94 = r69.getUplinkFileInfo();
        if (r94 == null) goto L673;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r95 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r95 == null) goto L671;
        String r96 = r95.e();
    L672:
        r94.setFileName(r96);
        Unit r97 = Unit.INSTANCE;
        goto L673
    L671:
        r96 = null;
    L673:
        UplinkFileInfo r99 = r69.getUplinkFileInfo();
        if (r99 == null) goto L680;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r100 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r100 == null) goto L678;
        Long r101 = r100.f();
    L679:
        r99.setSize(r101);
        Unit r102 = Unit.INSTANCE;
        goto L680
    L678:
        r101 = null;
    L680:
        UplinkFileInfo r103 = r69.getUplinkFileInfo();
        if (r103 == null) goto L683;
        r103.setMd5(r129);
        Unit r104 = Unit.INSTANCE;
    L683:
        UplinkFileInfo r105 = r69.getUplinkFileInfo();
        if (r105 == null) goto L687;
        r105.setLocalResPath(r129);
        Unit r106 = Unit.INSTANCE;
    L687:
        r82 = r135;
        UplinkEntityContent r613 = r86;
        String r136 = r129;
        Object r413 = r133;
        Map<String, String> r710 = r221;
        Ref.ObjectRef r107 = r218;
        String r1010 = r316;
        Ref.BooleanRef r137 = r314;
        CoroutineScope r138 = r312;
        List<UplinkFileEntity> r139 = r58;
        int r1011 = r118;
        Object r323 = r322;
    L690:
        UplinkFileEntity r140 = new UplinkFileEntity(Boxing.boxInt(r82), r613, r65, null, null, null, null, null, Boxing.boxBoolean(false), false, r131, null, Boxing.boxBoolean(r119), r710, 2808, null);
        if (r83 == false) goto L703;
        Map r141 = r140.getExtra();
        if (r141 != null) goto L695;
        r141 = MapsKt.emptyMap();
    L695:
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r142 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r142 == null) goto L699;
        Map<String, String> r143 = r142.d();
        if (r143 == null) goto L699;
    L700:
        r140.setExtra(MapsKt.plus(r141, r143));
    L699:
        r143 = MapsKt.emptyMap();
    L703:
        if (r83 == false) goto L779;
        r140.setFileReviewStatus(Boxing.boxInt(FileReviewState.ACCESS.getValue()));
        r140.setFileParsedStatus(Boxing.boxInt(FileParseState.SUCCESS.getValue()));
        r140.setUpLinkProcess(Boxing.boxInt(100));
        r140.setUpLinkStatus(Boxing.boxInt(UpLinkState.SUCCESS.getValue()));
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r144 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r144 == null) goto L709;
        Map<String, String> r145 = r144.d();
        if (r145 == null) goto L709;
        String r146 = r145.get("upload_from");
    L711:
        if (Intrinsics.areEqual(r146, "local") == true) goto L778;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r147 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r147 == null) goto L715;
        int r414 = r147.c();
    L716:
        FlowDriveSdkService r148 = FlowDriveSdkService.a;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r149 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        Ref.LongRef r222 = r88;
        if (r149 == null) goto L721;
        Map<String, String> r150 = r149.d();
        if (r150 == null) goto L721;
        String r151 = r150.get("drive_uplink_info");
    L722:
        r148.getClass();
        DriveUplinkInfo r152 = FlowDriveSdkService.C(r151);
        if (r152 == null) goto L731;
        String r153 = r152.getUrl();
        if (r153 == null) goto L731;
        if ((!StringsKt.isBlank(r153)) == true) goto L730;
        r153 = null;
    L730:
        if (r153 == null) goto L731;
    L734:
        String r415 = r153;
    L736:
        if (r152 == null) goto L744;
        String r154 = r152.getFileToken();
        if (r154 == null) goto L744;
        if ((!StringsKt.isBlank(r154)) == true) goto L743;
        r154 = null;
    L743:
        if (r154 == null) goto L744;
    L749:
        String r416 = r154;
    L751:
        if (r152 == null) goto L759;
        String r155 = r152.getFileName();
        if (r155 == null) goto L759;
        if ((!StringsKt.isBlank(r155)) == true) goto L758;
        r155 = null;
    L758:
        if (r155 == null) goto L759;
    L762:
        String r417 = r155;
    L764:
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r156 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r156 == null) goto L770;
        Map<String, String> r157 = r156.d();
        if (r157 == null) goto L770;
        String r158 = r157.get("upload_way");
        if (r158 == null) goto L770;
    L772:
        String r418 = r158;
    L774:
        DriveUplinkInfo r159 = new DriveUplinkInfo(r415, r416, r417, r414, r414, r418);
        Map r160 = r140.getExtra();
        if (r160 != null) goto L777;
        r160 = MapsKt.emptyMap();
    L777:
        r140.setExtra(MapsKt.plus(r160, MapsKt.mapOf(TuplesKt.to("drive_uplink_info", r159.toString()))));
    L786:
        MultimodalCommonParamManager.b(r65);
        r139.add(r140);
        if (r1110 == false) goto L789;
    L796:
        Unit r161 = Unit.INSTANCE;
        Ref.ObjectRef r614 = r107;
        Ref.ObjectRef r711 = r84;
        Ref.BooleanRef r162 = r137;
        List<String> r910 = r128;
        Ref.BooleanRef r615 = r215;
        List<Boolean> r419 = r66;
        Ref.BooleanRef r616 = r213;
        Ref.BooleanRef r617 = r219;
        Ref.BooleanRef r618 = r217;
        Ref.LongRef r163 = r222;
        String r324 = r136;
        Object r325 = r323;
        int r619 = r411;
        String r164 = r59;
        String r620 = r109;
        String r712 = r1113;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r165 = r1112;
        List<Uri> r166 = r1111;
        String r167 = r116;
        Iterator r168 = r1114;
        Object r169 = r117;
        int r326 = r1115;
        boolean r1012 = r119;
        boolean r810 = r126;
        boolean r170 = r125;
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 r1013 = r124;
        boolean r171 = r83;
        String r420 = r214;
        boolean r172 = r1110;
        LegacyMultimodalDataProcessor r1211 = r111;
        List<UplinkFileEntity> r173 = r139;
        LegacyMultimodalDataProcessor r174 = r1211;
    L810:
        String r421 = r167;
        boolean r327 = r172;
        List<Boolean> r328 = r134;
        Object r329 = r169;
        List<Boolean> r422 = r110;
        Ref.BooleanRef r423 = r211;
        Ref.BooleanRef r175 = r313;
        Ref.BooleanRef r176 = r315;
        Object r330 = r413;
        List<Boolean> r424 = r419;
        boolean r177 = r170;
        String r178 = r38;
        List<String> r331 = r910;
        r1 = r1013;
        int r179 = r1011;
        boolean r332 = r1012;
        String r425 = r108;
        boolean r333 = r122;
        int r621 = r619;
        String r622 = r1010;
    L817:
        r178 = r178;
        boolean r1310 = r810;
        r325 = r325;
        r330 = r330;
    L68:
        if (r168.hasNext() == false) goto L818;
        Object r223 = r168.next();
        Iterator r426 = r168;
        int r180 = r179 + 1;
        if (r179 >= 0) goto L72;
        CollectionsKt.throwIndexOverflow();
    L72:
        int r427 = r180;
        Uri r181 = (Uri) r223;
        Ref.BooleanRef r428 = r162;
        String r182 = UUID.randomUUID().toString();
        Ref.BooleanRef r429 = r175;
        Ref.BooleanRef r183 = new Ref.BooleanRef();
        ImFileUtil.a.getClass();
        Ref.BooleanRef r512 = r176;
        r183.element = ImFileUtil.w(r181);
        Ref.BooleanRef r184 = new Ref.BooleanRef();
        Ref.LongRef r513 = r163;
        r184.element = ImFileUtil.s(r181);
        Ref.BooleanRef r185 = new Ref.BooleanRef();
        List<UplinkFileEntity> r514 = r173;
        r185.element = ImFileUtil.y(r181);
        if (r165 == null) goto L75;
        com.larus.bmhome.chat.component.bottom.multimodal.a r186 = (com.larus.bmhome.chat.component.bottom.multimodal.a) CollectionsKt.getOrNull(r165, r179);
    L77:
        if ((r186 instanceof com.larus.bmhome.chat.component.bottom.multimodal.a.b) == false) goto L79;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r187 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r186;
    L80:
        if (r187 == null) goto L89;
        if (r171 == false) goto L85;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r224 = r187;
        if (r187.g() != FlowDriveFileType.AUDIO) goto L86;
        boolean r188 = true;
    L87:
        if (r188 == false) goto L89;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r189 = r224;
    L91:
        if (r184.element == true) goto L95;
        if (r189 != null) goto L95;
        ux9.a r190 = null;
    L96:
        Ref.ObjectRef r515 = new Ref.ObjectRef();
        if (r171 == false) goto L140;
        if (r165 == null) goto L110;
        CoroutineScope r516 = r138;
        boolean r517 = r177;
        if (r165.size() != r166.size()) goto L111;
        boolean r191 = true;
    L112:
        if (r191 == false) goto L141;
        Object r192 = ListProtector.get(r165, r179);     // Catch: Throwable -> L105
        if ((r192 instanceof com.larus.bmhome.chat.component.bottom.multimodal.a.b) == false) goto L116;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r193 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r192;     // Catch: Throwable -> L105
    L117:
        if (r193 == null) goto L138;
        r515.element = r193;     // Catch: Throwable -> L105
        Uri r194 = r193.b();     // Catch: Throwable -> L105
        if (r194 == null) goto L121;
        String r713 = r194.toString();     // Catch: Throwable -> L105
    L122:
        String r714 = r193.e();     // Catch: Throwable -> L105
        int r195 = a.a[r193.g().ordinal()];     // Catch: Throwable -> L105
        r515 = r515;
        if (r195 != 1) goto L125;
        r183.element = true;     // Catch: Throwable -> L105
        String r715 = ImFileUtil.e(r193.e());     // Catch: Throwable -> L105
    L133:
        Long r196 = r193.f();     // Catch: Throwable -> L105
        if (r196 == null) goto L136;
        long r716 = r196.longValue();     // Catch: Throwable -> L105
    L137:
        m0 r197 = new m0(r713, r714, r716, r715, null, r193.g(), null, 15344);     // Catch: Throwable -> L105
    L142:
        boolean r198 = r333;
        if (r198 == true) goto L145;
    L155:
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r334 = r165;
    L156:
        ux9.a r199 = r190;
    L157:
        if (r517 == true) goto L170;
        if (r198 == true) goto L160;
    L169:
        int r1100 = 0;
    L171:
        if (r1310 == 0) goto L186;
        if (r171 == true) goto L186;
        if (r185.element == false) goto L184;
        CoroutineDispatcher r1101 = Dispatchers.getIO();
        String r518 = r178;
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$useVideoEntity$1 r200 = new LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$useVideoEntity$1(r181, r197, r182, null);
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 r1102 = r1;
        r1102.L$0 = r516;
        r1102.L$1 = r164;
        r1102.L$2 = r514;
        r1102.L$3 = r513;
        r1102.L$4 = r512;
        r1102.L$5 = r429;
        r1102.L$6 = r428;
        Ref.BooleanRef r201 = r423;
        r1102.L$7 = r201;
        Ref.BooleanRef r225 = r201;
        Ref.BooleanRef r202 = r618;
        r1102.L$8 = r202;
        Ref.BooleanRef r226 = r202;
        Ref.BooleanRef r203 = r617;
        r1102.L$9 = r203;
        Ref.BooleanRef r204 = r616;
        r1102.L$10 = r204;
        Ref.ObjectRef r205 = r711;
        r1102.L$11 = r205;
        Ref.ObjectRef r519 = r205;
        Ref.ObjectRef r206 = r614;
        r1102.L$12 = r206;
        Ref.ObjectRef r623 = r206;
        Ref.BooleanRef r207 = r615;
        r1102.L$13 = r207;
        r1102.L$14 = r420;
        r1102.L$15 = r425;
        String r208 = r620;
        r1102.L$16 = r208;
        String r624 = r208;
        String r209 = r712;
        r1102.L$17 = r209;
        r1102.L$18 = r334;
        r1102.L$19 = r166;
        r1102.L$20 = r174;
        String r227 = r421;
        r1102.L$21 = r227;
        List<Boolean> r228 = r424;
        r1102.L$22 = r228;
        List<Boolean> r229 = r422;
        r1102.L$23 = r229;
        List<Boolean> r230 = r328;
        r1102.L$24 = r230;
        List<Boolean> r231 = r230;
        List<String> r232 = r331;
        r1102.L$25 = r232;
        List<String> r233 = r232;
        r1102.L$26 = r426;
        r1102.L$27 = r181;
        r1102.L$28 = r183;
        r1102.L$29 = r182;
        r1102.L$30 = r184;
        r1102.L$31 = r185;
        r1102.L$32 = r515;
        r1102.L$33 = r199;
        r1102.L$34 = r197;
        m0 r335 = r197;
        r1102.L$35 = null;
        r1102.L$36 = null;
        r1102.L$37 = null;
        boolean r234 = r327;
        r1102.Z$0 = r234;
        int r235 = r621;
        r1102.I$0 = r235;
        r1102.Z$1 = r198;
        String r336 = r182;
        boolean r236 = r517;
        r1102.Z$2 = r236;
        ux9.a r337 = r199;
        int r237 = r326;
        r1102.I$1 = r237;
        r1102.Z$3 = r171;
        r1102.Z$4 = r1310;
        r1102.Z$5 = r332;
        r1102.I$2 = r427;
        r1102.I$3 = r179;
        r1102.I$4 = r1100;
        r1102.label = 1;
        int r1311 = r179;
        Object r238 = BuildersKt.withContext(r1101, r200, r1102);
        Object r239 = r329;
        if (r238 != r239) goto L178;
        return r239;
    L178:
        int r338 = r235;
        boolean r240 = r198;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r430 = r334;
        String r431 = r425;
        Ref.BooleanRef r241 = r428;
        Ref.BooleanRef r432 = r204;
        String r433 = r209;
        int r1103 = r237;
        List<Boolean> r339 = r229;
        m0 r242 = r335;
        int r243 = r1311;
        String r340 = r227;
        int r244 = r1100;
        boolean r1104 = r236;
        Ref.ObjectRef r245 = r515;
        String r520 = r164;
        Ref.BooleanRef r521 = r429;
        Ref.BooleanRef r434 = r203;
        Ref.BooleanRef r435 = r207;
        boolean r246 = r1310;
        boolean r247 = r332;
        Uri r341 = r181;
        Ref.BooleanRef r248 = r185;
        String r1212 = r324;
        List<Boolean> r342 = r228;
        String r249 = r1212;
        Object r343 = r325;
        Object r344 = r330;
    L180:
        if (((Boolean) r238).booleanValue() == false) goto L183;
        Ref.BooleanRef r811 = r241;
        Ref.ObjectRef r911 = r245;
        int r1014 = r243;
        Object r812 = r239;
        r1012 = r247;
        List<Uri> r813 = r166;
        int r912 = r1103;
        boolean r1015 = r171;
        r1013 = r1102;
        Ref.BooleanRef r250 = r183;
        r198 = r240;
        String r625 = r249;
        m0 r251 = r242;
        List<Boolean> r913 = r231;
        r910 = r233;
        Ref.BooleanRef r914 = r225;
        Ref.BooleanRef r915 = r226;
        Uri r252 = r341;
        List<Boolean> r814 = r339;
        List<Boolean> r815 = r342;
        String r1105 = r336;
        ux9.a r253 = r337;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r816 = r430;
        String r522 = r420;
        String r523 = r431;
        Ref.BooleanRef r254 = r435;
        Iterator r916 = r426;
        r1011 = r427;
        Ref.BooleanRef r1016 = r432;
        Ref.BooleanRef r917 = r434;
        Ref.LongRef r918 = r513;
        List<UplinkFileEntity> r1312 = r514;
        CoroutineScope r919 = r516;
        String r255 = r520;
        Ref.ObjectRef r817 = r519;
        Ref.ObjectRef r1017 = r623;
        String r1018 = r622;
        String r818 = r624;
        boolean r256 = true;
        boolean r1106 = r234;
        boolean r257 = r246;
        r170 = r1104;
        int r258 = r244;
        Ref.BooleanRef r259 = r248;
        r619 = r338;
        Object r524 = r344;
        String r1107 = r340;
        String r525 = r433;
        Ref.BooleanRef r626 = r512;
        Ref.BooleanRef r526 = r521;
        r38 = r518;
        Object r345 = r343;
    L182:
        Object r527 = r345;
        Object r528 = r524;
    L188:
        if (r250.element == false) goto L190;
    L193:
        boolean r260 = false;
    L194:
        if (r253 == null) goto L201;
        String r1108 = r251.c();
        if (r1108 == null) goto L198;
        String r1109 = StringsKt.substringAfterLast(r1108, '.', r38);
    L199:
        ux9.a.g(r253, r1109, Boxing.boxLong(r251.d()));
        Unit r261 = Unit.INSTANCE;
        goto L201
    L198:
        r1109 = null;
    L201:
        if (r260 == false) goto L203;
    L206:
        boolean r262 = true;
    L207:
        r254.element = r262;
        int r263 = MultimodalSendCostTrace.a;
        if (r255 != null) goto L213;
        g1 r264 = LegacyMultimodalDataProcessor.e(r174);
        if (r264 == null) goto L212;
        String r265 = r264.uM();
    L214:
        wc9.e r1116 = LegacyMultimodalDataProcessor.h(r174);
        if (r1116 == null) goto L217;
        String r1117 = r1116.c();
    L218:
        MultimodalSendCostTrace.c(r1105, r265, r1117, r1107, AttachmentAreaType.MULTI_ATTACHMENT);
        if (r1106 == false) goto L221;
        int r266 = r1312.size();
    L225:
        if (r170 == false) goto L227;
        ImFileUtil.a.getClass();
        int r267 = ImFileUtil.k();
    L236:
        if (r198 == false) goto L274;
        if (r258 == 0) goto L274;
        if (r1106 == false) goto L252;
        List<UplinkFileEntity> r268 = r1312;
        List<UplinkFileEntity> r1118 = r268;
        boolean r1313 = r198;
        if ((r1118 instanceof Collection) == true) goto L242;
    L244:
        Iterator r1119 = r1118.iterator();
        int r1120 = 0;
    L246:
        if (r1119.hasNext() == false) goto L270;
        if (n1.a((UplinkFileEntity) r1119.next()) == false) goto L246;
        r1120 = r1120 + 1;
        if (r1120 >= 0) goto L246;
        CollectionsKt.throwCountOverflow();
    L270:
        ImFileUtil.a.getClass();
        if (r1120 < ImFileUtil.k()) goto L275;
        int r269 = 0;
    L276:
        if (r266 >= r267) goto L279;
        if (r269 == 0) goto L279;
        int r270 = 1;
    L280:
        if (r619 != 0) goto L290;
        ICoreInputAbility r271 = LegacyMultimodalDataProcessor.i(r174);
        if (r271 != null) goto L284;
    L286:
        boolean r272 = false;
    L287:
        if (r272 == true) goto L290;
        ?? r273 = 0;
    L291:
        if (r258 == 0) goto L293;
        Function3 r1121 = new LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$isDisallowedEntityTypeMethod$1(r174);
    L294:
        if (r258 == 0) goto L296;
        Function3 r274 = new LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$isFileOverSizeEntityMethod$1(ImFileUtil.a);
    L297:
        boolean r627 = r1106;
        boolean r1122 = ((Boolean) r1121.invoke(Boxing.boxBoolean(r257), r251, Boxing.boxBoolean(r250.element))).booleanValue();
        com.larus.bmhome.chat.component.bottom.multimodal.g r1123 = LegacyMultimodalDataProcessor.p(r174);
        if (r1123 != null) goto L300;
    L302:
        boolean r1124 = false;
    L303:
        boolean r628 = r257;
        Ref.BooleanRef r1125 = r259;
        if (r257 == true) goto L306;
    L308:
        boolean r275 = r1015;
        if (r275 == true) goto L314;
        if (r1124 == true) goto L314;
        if (r1125.element == false) goto L314;
        boolean r1126 = true;
    L315:
        if (r1122 == false) goto L317;
        if (r256 == true) goto L317;
    L318:
        if (r253 == null) goto L328;
        ux9.a.c r276 = r253.e();
        if (r276 == null) goto L328;
        if (r170 == true) goto L325;
        ImFileUtil r277 = ImFileUtil.a;
        String r1127 = r251.c();
        String r1128 = r251.e();
        r277.getClass();
        if (ImFileUtil.u(r1127, r1128) == true) goto L325;
        AudioAttachmentUploadEvent.Result r278 = AudioAttachmentUploadEvent.Result.MIXED_TYPE;
    L326:
        ux9.a.c.e(r276, r278, null, null, 6);
        Unit r279 = Unit.INSTANCE;
    L325:
        r278 = AudioAttachmentUploadEvent.Result.UNSUPPORTED_TYPE;
    L328:
        if (r250.element == false) goto L330;
        Ref.BooleanRef r1129 = r626;
        boolean r280 = true;
        r1129.element = true;
    L331:
        Ref.BooleanRef r1130 = r184;
        if (r1130.element == false) goto L334;
        Ref.BooleanRef r281 = r526;
        r281.element = r280;
    L335:
        if (r258 == 0) goto L341;
        Ref.ObjectRef r282 = r817;
        String r1131 = (String) r282.element;
        if (r1131 != null) goto L340;
        r1131 = LegacyMultimodalDataProcessor.g(r174).getString(2131907890);
    L340:
        r282.element = r1131;
    L342:
        Ref.BooleanRef r1132 = r811;
        r1132.element = true;
        Ref.ObjectRef r629 = r282;
        Ref.BooleanRef r630 = r254;
        String r283 = r1018;
        FLogger.a.w(r283, "[onMultiFileResultSuccess] isDisallowedEntityTypeMethod, existImageFile:" + r1129.element + ", existAudioFile:" + r281.element);
        LruCache r284 = ko8.a.a;
        BotModel r285 = LegacyMultimodalDataProcessor.c(r174);
        if (r285 == null) goto L345;
        String r286 = r285.getBotId();
    L346:
        boolean r287 = r1130.element;
        boolean r1133 = r1125.element;
        boolean r288 = r250.element;
        String r346 = r251.c();
        String r347 = LegacyMultimodalDataProcessor.s(r174);
        sr9.b r1134 = sr9.b.b;
        String r348 = r1134.c(r252.toString());
        String r349 = r1134.f(r252.toString());
        String r350 = r1134.h(r252.toString());
        com.larus.bmhome.chat.component.bottom.reference.a r1135 = LegacyMultimodalDataProcessor.q(r174);
        if (r1135 == null) goto L349;
        String r436 = r1135.wf();
    L350:
        com.larus.bmhome.chat.component.bottom.reference.a r1136 = LegacyMultimodalDataProcessor.q(r174);
        if (r1136 == null) goto L355;
        ReferenceInfo r1137 = r1136.T6();
        if (r1137 == null) goto L355;
        String r437 = r1137.referencedMessageId;
    L356:
        ko8.a.m(r286, null, r273, "copy error", r288, r287, r1133, false, null, r346, r347, r522, r523, r525, r348, r349, r350, null, null, r436, r437, null, null, null, null, null, null, null, null, null, null, 2145779970);
        int r289 = com.larus.bmhome.chat.trace.multimodal.a.a;
        com.larus.bmhome.chat.trace.multimodal.a.c(r1105, ProcessFileResultCode.PREPARE_TYPE_NO_MATCH, r251, 8);
        Unit r290 = Unit.INSTANCE;
        boolean r717 = r275;
        Ref.BooleanRef r631 = r281;
        List<UplinkFileEntity> r718 = r268;
        r122 = r1313;
        r211 = r914;
        r1010 = r283;
        r164 = r255;
        r108 = r523;
        r420 = r522;
        r325 = r527;
        r413 = r528;
        r167 = r1107;
        r324 = r625;
        r172 = r627;
        r810 = r628;
        r162 = r1132;
        r313 = r631;
        r315 = r1129;
        r171 = r717;
        r620 = r818;
        r169 = r812;
        r165 = r816;
        r166 = r813;
        r419 = r815;
        r110 = r814;
        r134 = r913;
        r168 = r916;
        r138 = r919;
        r326 = r912;
        r617 = r917;
        r614 = r1017;
        r618 = r915;
        r712 = r525;
        r615 = r630;
        r163 = r918;
        r616 = r1016;
        r711 = r629;
        r173 = r718;
    L355:
        r437 = null;
        goto L356
    L349:
        r436 = null;
        goto L350
    L345:
        r286 = null;
        goto L346
    L341:
        r1107 = r1107;
        r282 = r817;
        goto L342
    L334:
        r281 = r526;
        goto L335
    L330:
        r1129 = r626;
        r280 = true;
    L317:
        if (r1126 == true) goto L318;
        Ref.BooleanRef r632 = r254;
        Ref.BooleanRef r1138 = r184;
        Ref.BooleanRef r633 = r526;
        Ref.BooleanRef r1139 = r626;
        Ref.BooleanRef r634 = r811;
        String r291 = r1018;
        String r635 = r1107;
        r170 = r170;
        Ref.ObjectRef r1140 = r817;
        List<UplinkFileEntity> r719 = r268;
        if (((Boolean) r274.invoke(Boxing.boxBoolean(r273), Boxing.boxLong(r251.d()), Boxing.boxBoolean(r250.element))).booleanValue() == false) goto L399;
        if (r256 != 0) goto L399;
        if (r275 == true) goto L399;
        if (r253 == null) goto L370;
        ux9.a.c r292 = r253.e();
        if (r292 == null) goto L370;
        if (r251.d() > 0) goto L367;
        AudioAttachmentUploadEvent.Result r293 = AudioAttachmentUploadEvent.Result.EMPTY_DATA;
    L368:
        ux9.a.c.e(r292, r293, null, null, 6);
        Unit r294 = Unit.INSTANCE;
        goto L370
    L367:
        r293 = AudioAttachmentUploadEvent.Result.OVERSIZE;
    L370:
        if (r251.d() > 0) goto L372;
        r250 = r250;
        r275 = r275;
        Ref.BooleanRef r295 = r914;
        Ref.BooleanRef r296 = r915;
    L383:
        FLogger.a.w(r291, "[onMultiFileResultSuccess] isFileOverSizeEntityMethod, existImageSizeDisallow:" + r295.element + ", existFileSizeDisallow:" + r296.element);
        LruCache r297 = ko8.a.a;
        BotModel r298 = LegacyMultimodalDataProcessor.c(r174);
        if (r298 == null) goto L386;
        String r299 = r298.getBotId();
    L387:
        boolean r300 = r250.element;
        String r351 = r251.c();
        String r352 = LegacyMultimodalDataProcessor.s(r174);
        boolean r301 = r1138.element;
        boolean r302 = r1125.element;
        sr9.b r1141 = sr9.b.b;
        String r353 = r1141.c(r252.toString());
        String r354 = r1141.f(r252.toString());
        String r355 = r1141.h(r252.toString());
        com.larus.bmhome.chat.component.bottom.reference.a r1142 = LegacyMultimodalDataProcessor.q(r174);
        if (r1142 == null) goto L390;
        String r438 = r1142.wf();
    L391:
        com.larus.bmhome.chat.component.bottom.reference.a r1143 = LegacyMultimodalDataProcessor.q(r174);
        if (r1143 == null) goto L396;
        ReferenceInfo r1144 = r1143.T6();
        if (r1144 == null) goto L396;
        String r439 = r1144.referencedMessageId;
    L397:
        ko8.a.m(r299, null, r273, "file over size", r300, r301, r302, false, null, r351, r352, r522, r523, r525, r353, r354, r355, null, null, r438, r439, null, null, null, null, null, null, null, null, null, null, 2145779970);
        int r303 = com.larus.bmhome.chat.trace.multimodal.a.a;
        com.larus.bmhome.chat.trace.multimodal.a.c(r1105, ProcessFileResultCode.PREPARE_OVER_SIZE, r251, 8);
        Unit r304 = Unit.INSTANCE;
        r122 = r1313;
        r211 = r295;
        r1010 = r291;
        r164 = r255;
        r108 = r523;
        r420 = r522;
        r325 = r527;
        r413 = r528;
        r167 = r635;
        r324 = r625;
        r172 = r627;
        r810 = r628;
        r162 = r634;
        r313 = r633;
        r315 = r1139;
        r171 = r275;
        r620 = r818;
        r169 = r812;
        r165 = r816;
        r166 = r813;
        r419 = r815;
        r110 = r814;
        r134 = r913;
        r168 = r916;
        r138 = r919;
        r326 = r912;
        r617 = r917;
        r614 = r1017;
        r618 = r296;
        r712 = r525;
        r615 = r632;
        r163 = r918;
        r616 = r1016;
        r711 = r1140;
        r173 = r719;
    L396:
        r439 = null;
        goto L397
    L390:
        r438 = null;
        goto L391
    L386:
        r299 = null;
        goto L387
    L372:
        if (r250.element == false) goto L374;
        r295 = r914;
        int r305 = 1;
        r295.element = true;
        r296 = r915;
    L375:
        if (r258 == 0) goto L381;
        String r1145 = (String) r1140.element;
        if (r1145 != null) goto L380;
        Context r1146 = LegacyMultimodalDataProcessor.g(r174);
        Object[] r1147 = new Object[r305];
        ImFileUtil.a.getClass();
        long r2100 = ((Number) ImFileUtil.o.getValue()).longValue();
        StringBuilder r306 = new StringBuilder();
        long r307 = 1024;
        r306.append((r2100 / r307) / r307);
        r306.append("MB");
        r1147[0] = r306.toString();
        r1145 = r1146.getString(2131907893, r1147);
    L380:
        r1140.element = r1145;
        goto L383
    L381:
        r250 = r250;
        r275 = r275;
        goto L383
    L374:
        r295 = r914;
        r296 = r915;
        r305 = 1;
        r296.element = true;
    L399:
        Ref.BooleanRef r1148 = r250;
        boolean r720 = r275;
        Ref.BooleanRef r308 = r914;
        Ref.BooleanRef r309 = r915;
        if (r258 == 0) goto L436;
        ImFileUtil r356 = ImFileUtil.a;
        Context r357 = LegacyMultimodalDataProcessor.g(r174);
        CoroutineScope r358 = r919;
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 r1149 = r1013;
        r1149.L$0 = r358;
        r1149.L$1 = r255;
        r1149.L$2 = r719;
        Ref.LongRef r359 = r918;
        r1149.L$3 = r359;
        r1149.L$4 = r1139;
        r1149.L$5 = r633;
        r1149.L$6 = r634;
        r1149.L$7 = r308;
        r1149.L$8 = r309;
        Ref.BooleanRef r360 = r917;
        r1149.L$9 = r360;
        Ref.BooleanRef r361 = r1016;
        r1149.L$10 = r361;
        r1149.L$11 = r1140;
        Ref.ObjectRef r362 = r1017;
        r1149.L$12 = r362;
        r1149.L$13 = r632;
        String r363 = r522;
        r1149.L$14 = r363;
        String r364 = r523;
        r1149.L$15 = r364;
        String r365 = r818;
        r1149.L$16 = r365;
        String r366 = r525;
        r1149.L$17 = r366;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r367 = r816;
        r1149.L$18 = r367;
        List<Uri> r368 = r813;
        r1149.L$19 = r368;
        r1149.L$20 = r174;
        r1149.L$21 = r635;
        List<Boolean> r369 = r815;
        r1149.L$22 = r369;
        List<Boolean> r370 = r814;
        r1149.L$23 = r370;
        List<Boolean> r371 = r913;
        r1149.L$24 = r371;
        List<String> r372 = r910;
        r1149.L$25 = r372;
        Iterator r373 = r916;
        r1149.L$26 = r373;
        Uri r374 = r252;
        r1149.L$27 = r374;
        r1149.L$28 = r1148;
        r1149.L$29 = r1105;
        r1149.L$30 = r1138;
        r1149.L$31 = r1125;
        Ref.ObjectRef r375 = r911;
        r1149.L$32 = r375;
        r1149.L$33 = r253;
        r1149.L$34 = r251;
        ux9.a r2101 = r253;
        r1149.L$35 = null;
        r1149.L$36 = null;
        r1149.L$37 = null;
        r1149.Z$0 = r627;
        int r376 = r619;
        r1149.I$0 = r376;
        r1149.Z$1 = r1313;
        r1149.Z$2 = r170;
        int r377 = r912;
        r1149.I$1 = r377;
        r1149.Z$3 = r720;
        r1149.Z$4 = r628;
        boolean r378 = r1012;
        r1149.Z$5 = r378;
        int r379 = r1011;
        r1149.I$2 = r379;
        int r380 = r1014;
        r1149.I$3 = r380;
        int r440 = r380;
        r1149.I$4 = r258;
        r1149.I$5 = r256 ? 1 : 0;
        r1149.I$6 = r269;
        int r381 = r270;
        r1149.I$7 = r381;
        r1149.I$8 = r273;
        ?? r2102 = r273;
        r1149.label = 2;
        r356.getClass();
        Object r382 = ImFileUtil.t(r357, r374, r1149);
        Object r383 = r812;
        if (r382 != r383) goto L404;
        return r383;
    L404:
        boolean r529 = r1313;
        String r636 = r255;
        Ref.BooleanRef r721 = r309;
        r1013 = r1149;
        String r384 = r1105;
        Ref.BooleanRef r385 = r1148;
        Ref.BooleanRef r1150 = r1125;
        String r1151 = r291;
        Ref.LongRef r722 = r359;
        Ref.BooleanRef r530 = r308;
        Ref.ObjectRef r723 = r362;
        String r724 = r365;
        String r386 = r366;
        List<Uri> r1152 = r368;
        List<Boolean> r1153 = r369;
        Iterator r531 = r373;
        int r532 = r376;
        int r1314 = r377;
        boolean r725 = r378;
        int r726 = r379;
        Object r727 = r527;
        Object r728 = r528;
        String r819 = r625;
        String r820 = r38;
        r810 = r628;
        Ref.BooleanRef r533 = r1139;
        boolean r821 = r720;
        Uri r387 = r374;
        LegacyMultimodalDataProcessor r637 = r174;
        ux9.a r2103 = r2101;
        CoroutineScope r638 = r358;
        Ref.BooleanRef r534 = r361;
        String r388 = r363;
        List<Boolean> r639 = r370;
        List<Boolean> r640 = r371;
        List<String> r729 = r372;
        int r2104 = r381;
        m0 r389 = r251;
        Ref.ObjectRef r390 = r1140;
        Ref.BooleanRef r391 = r1138;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r1154 = r367;
        Object r1155 = r383;
        Ref.BooleanRef r392 = r360;
        Ref.ObjectRef r393 = r375;
        String r394 = r364;
        ?? r2105 = r256;
    L406:
        if (((Boolean) r382).booleanValue() == false) goto L435;
        if (r2103 == null) goto L412;
        ux9.a.c r395 = r2103.e();
        if (r395 == null) goto L412;
        ux9.a.c.e(r395, AudioAttachmentUploadEvent.Result.OVER_DURATION, null, null, 6);
        Unit r396 = Unit.INSTANCE;
    L412:
        r392.element = true;
        String r397 = (String) r390.element;
        if (r397 != null) goto L416;
        Context r398 = LegacyMultimodalDataProcessor.g(r637);
        ImFileUtil.a.getClass();
        long r1156 = 60;
        r397 = r398.getString(2131907359, new Object[]{String.valueOf((int) (((((Number) ImFileUtil.p.getValue()).longValue() / ((long) 1000)) / r1156) / r1156))});
    L416:
        r390.element = r397;
        FLogger.a.w(r1151, "[onMultiFileResultSuccess] existAudioDurationDisallow");
        LruCache r399 = ko8.a.a;
        BotModel r400 = LegacyMultimodalDataProcessor.c(r637);
        if (r400 == null) goto L419;
        String r2106 = r400.getBotId();
    L420:
        boolean r401 = r385.element;
        String r3100 = r389.c();
        String r3101 = LegacyMultimodalDataProcessor.s(r637);
        boolean r402 = r391.element;
        boolean r403 = r1150.element;
        sr9.b r1157 = sr9.b.b;
        String r1158 = r1157.c(r387.toString());
        String r3102 = r1157.f(r387.toString());
        String r3103 = r1157.h(r387.toString());
        com.larus.bmhome.chat.component.bottom.reference.a r1159 = LegacyMultimodalDataProcessor.q(r637);
        if (r1159 == null) goto L423;
        String r441 = r1159.wf();
    L424:
        com.larus.bmhome.chat.component.bottom.reference.a r1160 = LegacyMultimodalDataProcessor.q(r637);
        if (r1160 == null) goto L429;
        ReferenceInfo r1161 = r1160.T6();
        if (r1161 == null) goto L429;
        String r442 = r1161.referencedMessageId;
    L431:
        if (r2102 == 0) goto L1054;
        ko8.a.m(r2106, null, true, "audio file over duration", r401, r402, r403, false, null, r3100, r3101, r388, r394, r386, r1158, r3102, r3103, null, null, r441, r442, null, null, null, null, null, null, null, null, null, null, 2145779970);
        int r404 = com.larus.bmhome.chat.trace.multimodal.a.a;
        com.larus.bmhome.chat.trace.multimodal.a.c(r384, ProcessFileResultCode.PREPARE_OVER_DURATION, r389, 8);
        Unit r405 = Unit.INSTANCE;
        r326 = r1314;
        r420 = r388;
        r108 = r394;
        r1010 = r1151;
        r168 = r531;
        r211 = r530;
        r122 = r529;
        r315 = r533;
        r138 = r638;
        r174 = r637;
        r172 = r627;
        r110 = r639;
        r162 = r634;
        r313 = r633;
        r134 = r640;
        r173 = r719;
        r910 = r729;
        r618 = r721;
        r614 = r723;
        r163 = r722;
        r620 = r724;
        r1011 = r726;
        r1012 = r725;
        r325 = r727;
        r413 = r728;
        r324 = r819;
        r171 = r821;
        r38 = r820;
        r169 = r1155;
        r165 = r1154;
        r419 = r1153;
        r617 = r392;
        r711 = r390;
        r712 = r386;
        r167 = r635;
        r164 = r636;
        r615 = r632;
        r166 = r1152;
        r619 = r532;
        r616 = r534;
        goto L810
    L1054:
        ko8.a.m(r2106, null, false, "audio file over duration", r401, r402, r403, false, null, r3100, r3101, r388, r394, r386, r1158, r3102, r3103, null, null, r441, r442, null, null, null, null, null, null, null, null, null, null, 2145779970);
        int r406 = com.larus.bmhome.chat.trace.multimodal.a.a;
        com.larus.bmhome.chat.trace.multimodal.a.c(r384, ProcessFileResultCode.PREPARE_OVER_DURATION, r389, 8);
        Unit r407 = Unit.INSTANCE;
        r326 = r1314;
        r420 = r388;
        r108 = r394;
        r1010 = r1151;
        r168 = r531;
        r211 = r530;
        r122 = r529;
        r315 = r533;
        r138 = r638;
        r174 = r637;
        r172 = r627;
        r110 = r639;
        r162 = r634;
        r313 = r633;
        r134 = r640;
        r173 = r719;
        r910 = r729;
        r618 = r721;
        r614 = r723;
        r163 = r722;
        r620 = r724;
        r1011 = r726;
        r1012 = r725;
        r325 = r727;
        r413 = r728;
        r324 = r819;
        r171 = r821;
        r38 = r820;
        r169 = r1155;
        r165 = r1154;
        r419 = r1153;
        r617 = r392;
        r711 = r390;
        r712 = r386;
        r167 = r635;
        r164 = r636;
        r615 = r632;
        r166 = r1152;
        r619 = r532;
        r616 = r534;
    L429:
        r442 = null;
        goto L431
    L423:
        r441 = null;
        goto L424
    L419:
        r2106 = null;
        goto L420
    L435:
        Object r822 = r1155;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r823 = r1154;
        List<Uri> r824 = r1152;
        List<Boolean> r825 = r1153;
        r1115 = r1314;
        Ref.BooleanRef r1213 = r391;
        r108 = r394;
        r1113 = r386;
        m0 r408 = r389;
        r1148 = r385;
        r316 = r1151;
        int r2107 = r2104;
        int r3104 = r269;
        ux9.a r3105 = r2103;
        r70 = r393;
        r131 = r387;
        int r409 = r440;
        r1114 = r531;
        r211 = r530;
        r122 = r529;
        r125 = r170;
        r315 = r533;
        r213 = r534;
        r116 = r635;
        r312 = r638;
        String r3106 = r636;
        LegacyMultimodalDataProcessor r443 = r637;
        r1110 = r627;
        r110 = r639;
        r314 = r634;
        r215 = r632;
        r313 = r633;
        r134 = r640;
        List<UplinkFileEntity> r3107 = r719;
        r128 = r729;
        r217 = r721;
        r109 = r724;
        r118 = r726;
        r119 = r725;
        Object r444 = r727;
        Object r1162 = r728;
        r126 = r810;
        r136 = r819;
        r83 = r821;
        r38 = r820;
        r117 = r822;
        r1112 = r823;
        r1111 = r824;
        r124 = r1013;
        r214 = r388;
        r65 = r384;
        int r3108 = r258;
        ?? r2108 = r2105;
        Ref.LongRef r445 = r722;
        r66 = r825;
        r219 = r392;
        r210 = r390;
        int r446 = r532;
        Ref.ObjectRef r447 = r723;
    L437:
        r413 = r1162;
        if (r83 == false) goto L449;
        FlowDriveFileType r1163 = LegacyMultimodalDataProcessor.u(r443, r408);
        if (r1163 == null) goto L442;
        r447.element = r1163;
    L443:
        if (r1163 == null) goto L449;
        if (r3105 == null) goto L448;
        ux9.a.c r448 = r3105.e();
        if (r448 == null) goto L448;
        ux9.a.c.e(r448, AudioAttachmentUploadEvent.Result.UNSUPPORTED_TYPE, null, null, 6);
        Unit r449 = Unit.INSTANCE;
    L448:
        Ref.ObjectRef r2109 = r447;
        r419 = r66;
        Ref.LongRef r450 = r445;
        int r451 = r446;
        r169 = r117;
        r616 = r213;
        r1011 = r118;
        r711 = r210;
        r167 = r116;
        r1013 = r124;
        r910 = r128;
        r174 = r443;
        r615 = r215;
        r617 = r219;
        r618 = r217;
        r614 = r2109;
        r324 = r136;
        r1010 = r316;
        r162 = r314;
        r173 = r3107;
        r164 = r3106;
        r138 = r312;
        r108 = r108;
        r619 = r451;
        r163 = r450;
        r620 = r109;
        r712 = r1113;
        r165 = r1112;
        r166 = r1111;
        r168 = r1114;
        r122 = r122;
        r170 = r125;
        r326 = r1115;
        r810 = r126;
        r1012 = r119;
        r171 = r83;
        r420 = r214;
        r325 = r444;
        r172 = r1110;
        goto L810
    L442:
        r1163 = null;
    L449:
        if (r2107 == 0) goto L797;
        r111 = r443;
        r218 = r447;
        r445.element += r408.d();
        if (r1148.element == true) goto L455;
        if (r446 != 0) goto L455;
        r82 = UplinkEntityType.EntityTypeFile.getValue();
    L456:
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r452 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r452 == null) goto L459;
        Map<String, String> r453 = r452.d();
    L460:
        r411 = r446;
        r69 = new UplinkEntityContent(null, null, 3, null);
        if (r82 != UplinkEntityType.EntityTypeImage.getValue()) goto L545;
        r69.setUplinkImageInfo(new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null));
        Image r454 = r69.getUplinkImageInfo();
        if (r454 == null) goto L466;
        LinkedHashMap r1164 = new LinkedHashMap();
        r1164.put("is_marked", sr9.b.b.a(r131.toString()));
        Unit r455 = Unit.INSTANCE;
        r454.ext = r1164;
    L466:
        if (r66 != null) goto L468;
    L472:
        if (r110 != null) goto L474;
    L478:
        if (r134 != null) goto L480;
    L484:
        if (r128 != null) goto L486;
    L490:
        if (r83 == false) goto L543;
        Image r456 = r69.getUplinkImageInfo();
        if (r456 == null) goto L498;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r457 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r457 == null) goto L496;
        String r458 = r457.j();
    L497:
        r456.imageThumb = new ImageObj(r458, 0, 0, null, null, 30, null);
        Unit r459 = Unit.INSTANCE;
        goto L498
    L496:
        r458 = null;
    L498:
        Image r460 = r69.getUplinkImageInfo();
        if (r460 == null) goto L505;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r461 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r461 == null) goto L503;
        String r462 = r461.i();
    L504:
        r460.imageOri = new ImageObj(r462, 0, 0, null, null, 30, null);
        Unit r463 = Unit.INSTANCE;
        goto L505
    L503:
        r462 = null;
    L505:
        Image r464 = r69.getUplinkImageInfo();
        if (r464 == null) goto L514;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r465 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r465 == null) goto L512;
        Uri r466 = r465.b();
        if (r466 == null) goto L512;
        String r467 = r466.toString();
    L513:
        r464.key = r467;
        Unit r468 = Unit.INSTANCE;
    L512:
        r467 = null;
    L514:
        Image r469 = r69.getUplinkImageInfo();
        if (r469 == null) goto L517;
        r469.md5 = r136;
        Unit r470 = Unit.INSTANCE;
    L517:
        Image r471 = r69.getUplinkImageInfo();
        if (r471 == null) goto L520;
        r471.localResPath = r136;
        Unit r472 = Unit.INSTANCE;
    L520:
        Image r473 = r69.getUplinkImageInfo();
        if (r473 == null) goto L523;
        r473.identifier = r65;
        Unit r474 = Unit.INSTANCE;
    L523:
        Image r475 = r69.getUplinkImageInfo();
        if (r475 == null) goto L526;
        Map r476 = r475.ext;
    L528:
        if (TypeIntrinsics.isMutableMap(r476) == true) goto L531;
        r476 = null;
    L531:
        if (r476 != null) goto L540;
        Image r477 = r69.getUplinkImageInfo();
        if (r477 == null) goto L537;
        Map r478 = r477.ext;
        if (r478 == null) goto L537;
        r476 = MapsKt.toMutableMap(r478);
    L538:
        if (r476 != null) goto L540;
        r476 = new LinkedHashMap();
    L537:
        r476 = null;
    L540:
        Object r479 = r444;
        Object r480 = r413;
        r476.put(r480, r479);
        Image r481 = r69.getUplinkImageInfo();
        Object r482 = r479;
        Object r483 = r480;
        if (r481 == null) goto L688;
        r481.ext = r476;
        Unit r484 = Unit.INSTANCE;
        r482 = r479;
        r483 = r480;
    L688:
        Object r3109 = r482;
        Object r485 = r483;
    L689:
        r1011 = r118;
        r116 = r116;
        r613 = r69;
        r124 = r124;
        r117 = r117;
        r84 = r210;
        r107 = r218;
        r710 = r453;
        r1010 = r316;
        r137 = r314;
        r139 = r3107;
        r59 = r3106;
        r138 = r312;
        r108 = r108;
        r88 = r445;
        r109 = r109;
        r1113 = r1113;
        r1112 = r1112;
        r1111 = r1111;
        r66 = r66;
        r1114 = r1114;
        r1110 = r1110;
        r122 = r122;
        r125 = r125;
        r1115 = r1115;
        r126 = r126;
        r119 = r119;
        r323 = r3109;
        r413 = r485;
        goto L690
    L526:
        r476 = null;
        goto L528
    L543:
        r3109 = r444;
        r485 = r413;
        goto L689
    L486:
        if (r409 >= r128.size()) goto L490;
        Image r486 = r69.getUplinkImageInfo();
        if (r486 == null) goto L490;
        r486.source = (String) ListProtector.get(r128, r409);
        Unit r487 = Unit.INSTANCE;
        goto L490
    L480:
        if (r409 >= r134.size()) goto L484;
        Image r488 = r69.getUplinkImageInfo();
        if (r488 == null) goto L484;
        r488.aiCreationImage = (Boolean) ListProtector.get(r134, r409);
        Unit r489 = Unit.INSTANCE;
        goto L484
    L474:
        if (r409 >= r110.size()) goto L478;
        Image r490 = r69.getUplinkImageInfo();
        if (r490 == null) goto L478;
        r490.setCropped((Boolean) ListProtector.get(r110, r409));
        Unit r491 = Unit.INSTANCE;
        goto L478
    L468:
        if (r409 >= r66.size()) goto L472;
        Image r492 = r69.getUplinkImageInfo();
        if (r492 == null) goto L472;
        r492.setMarked((Boolean) ListProtector.get(r66, r409));
        Unit r493 = Unit.INSTANCE;
        goto L472
    L545:
        r453 = r453;
        r445 = r445;
        Object r494 = r444;
        Object r495 = r413;
        r482 = r494;
        r483 = r495;
        if (r82 != UplinkEntityType.EntityTypeFile.getValue()) goto L688;
        if (r3108 == 0) goto L550;
        boolean r1165 = true;
    L551:
        r322 = r494;
        if (r2108 == 0) goto L554;
        boolean r496 = true;
    L555:
        r69.setUplinkFileInfo(new UplinkFileInfo(null, null, null, Boxing.boxInt(LegacyMultimodalDataProcessor.k(r111, r1165, r496)), null, null, null, null, null, null, 1015, null));
        if (r83 == true) goto L558;
    L562:
        if (r2108 == 0) goto L655;
        UplinkFileInfo r497 = r69.getUplinkFileInfo();
        if (r497 == null) goto L655;
        r62 = new VideoExtension(null, null, null, null, null, null, null, null, null, null, 1023, null);
        if (r128 != null) goto L568;
    L570:
        sr9.b r498 = sr9.b.b;
        Pair r1166 = r498.b(r131.toString());
        if (r1166 == null) goto L573;
        Integer r1167 = (Integer) r1166.getFirst();
    L574:
        r62.setWidth(r1167);
        Pair r499 = r498.b(r131.toString());
        if (r499 == null) goto L577;
        Integer r500 = (Integer) r499.getSecond();
    L578:
        r62.setHeight(r500);
        if (r83 == false) goto L653;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r501 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r501 == null) goto L585;
        Uri r502 = r501.b();
        if (r502 == null) goto L585;
        String r503 = r502.toString();
    L586:
        r62.setVid(r503);
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r504 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r504 == null) goto L589;
        Float r505 = Boxing.boxFloat(r504.k());
    L590:
        r62.setDuration(r505);
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r506 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r506 == null) goto L595;
        Uri r507 = r506.b();
        if (r507 == null) goto L595;
        r63 = r507.toString();
    L596:
        if (r63 != null) goto L599;
        r63 = r38;
    L599:
        if (r63.length() <= 0) goto L601;
        boolean r1168 = true;
    L602:
        if (r1168 == false) goto L608;
        CoroutineDispatcher r1169 = Dispatchers.getIO();
        String r2110 = r136;
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1 r508 = new LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$entity$1$2$1(r63, null);
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 r1170 = r124;
        r1170.L$0 = r312;
        r1170.L$1 = r3106;
        r1170.L$2 = r3107;
        r1170.L$3 = r445;
        r1170.L$4 = r315;
        r1170.L$5 = r313;
        r1170.L$6 = r314;
        r1170.L$7 = r211;
        r1170.L$8 = r217;
        r1170.L$9 = r219;
        r1170.L$10 = r213;
        r1170.L$11 = r210;
        r1170.L$12 = r218;
        r1170.L$13 = r215;
        r1170.L$14 = r214;
        String r509 = r108;
        r1170.L$15 = r509;
        String r535 = r109;
        r1170.L$16 = r535;
        r44 = r535;
        String r536 = r1113;
        r1170.L$17 = r536;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r537 = r1112;
        r1170.L$18 = r537;
        List<Uri> r538 = r1111;
        r1170.L$19 = r538;
        r1170.L$20 = r111;
        r61 = r116;
        r1170.L$21 = r61;
        r1170.L$22 = r66;
        r1170.L$23 = r110;
        r1170.L$24 = r134;
        r1170.L$25 = r128;
        r48 = r66;
        Iterator r539 = r1114;
        r1170.L$26 = r539;
        r410 = r539;
        Uri r540 = r131;
        r1170.L$27 = r540;
        r1170.L$28 = r65;
        r1170.L$29 = r70;
        r131 = r540;
        r1170.L$30 = r453;
        r1170.L$31 = r69;
        r1170.L$32 = r69;
        r1170.L$33 = r62;
        r1170.L$34 = r62;
        r1170.L$35 = r497;
        r1170.L$36 = r63;
        r1170.L$37 = r62;
        boolean r541 = r1110;
        r1170.Z$0 = r541;
        r1170.I$0 = r411;
        boolean r542 = r122;
        r1170.Z$1 = r542;
        boolean r543 = r125;
        r1170.Z$2 = r543;
        r511 = r543;
        int r544 = r1115;
        r1170.I$1 = r544;
        r1170.Z$3 = r83;
        r510 = r544;
        boolean r545 = r126;
        r1170.Z$4 = r545;
        r55 = r545;
        boolean r546 = r119;
        r1170.Z$5 = r546;
        int r547 = r118;
        r1170.I$2 = r547;
        r1170.I$3 = r82;
        r1170.label = 3;
        r50 = BuildersKt.withContext(r1169, r508, r1170);
        r114 = r117;
        if (r50 != r114) goto L606;
        return r114;
    L606:
        r124 = r1170;
        r36 = r134;
        r112 = r322;
        r30 = r453;
        r58 = r3107;
        r59 = r3106;
        r57 = r445;
        r43 = r536;
        r310 = r542;
        r113 = r546;
        r31 = r70;
        r52 = r217;
        r311 = r2110;
        r60 = r316;
        r56 = r315;
        r45 = r509;
        r26 = r62;
        r29 = r69;
        r32 = r65;
        r35 = r128;
        r54 = r547;
        r115 = r83;
        r39 = r218;
        r49 = r82;
        r53 = r26;
        r28 = r29;
        r40 = r411;
        r42 = r537;
        r46 = r214;
        r212 = r495;
        r41 = r538;
        r47 = r215;
        r22 = r541;
        r51 = r219;
        r25 = r497;
        goto L607
    L608:
        r131 = r131;
        r216 = r136;
        r36 = r134;
        r127 = r322;
        r30 = r453;
        r58 = r3107;
        r59 = r3106;
        r123 = r312;
        r120 = r495;
        r57 = r445;
        r71 = r497;
        r67 = r62;
        r412 = r63;
        r68 = r69;
        boolean r1214 = r83;
        r49 = r82;
        r64 = r111;
        r121 = r128;
        r115 = r1214;
        goto L610
    L601:
        r1168 = false;
    L595:
        r63 = null;
        goto L596
    L589:
        r505 = null;
    L585:
        r503 = null;
        goto L586
    L653:
        r131 = r131;
        r86 = r69;
        r36 = r134;
        r84 = r210;
        r129 = r136;
        r132 = r322;
        r30 = r453;
        r58 = r3107;
        r59 = r3106;
        r133 = r495;
        r57 = r445;
        r85 = r497;
        goto L654
    L577:
        r500 = null;
        goto L578
    L573:
        r1167 = null;
        goto L574
    L568:
        if (r409 >= r128.size()) goto L570;
        r62.setSource((String) ListProtector.get(r128, r409));
        goto L570
    L655:
        r131 = r131;
        r118 = r118;
        r116 = r116;
        r86 = r69;
        r124 = r124;
        r117 = r117;
        r84 = r210;
        r129 = r136;
        r87 = r453;
        r58 = r3107;
        r59 = r3106;
        r108 = r108;
        r133 = r495;
        r88 = r445;
        r109 = r109;
        r1113 = r1113;
        r1112 = r1112;
        r1111 = r1111;
        r66 = r66;
        r1114 = r1114;
        r1110 = r1110;
        r122 = r122;
        r125 = r125;
        r1115 = r1115;
        r126 = r126;
        r119 = r119;
        goto L656
    L1056:
        r131 = r131;
        r118 = r118;
        r116 = r116;
        r86 = r69;
        r124 = r124;
        r117 = r117;
        r84 = r210;
        r129 = r136;
        r87 = r453;
        r58 = r3107;
        r59 = r3106;
        r108 = r108;
        r133 = r495;
        r88 = r445;
        r109 = r109;
        r1113 = r1113;
        r1112 = r1112;
        r1111 = r1111;
        r66 = r66;
        r1114 = r1114;
        r1110 = r1110;
        r122 = r122;
        r125 = r125;
        r1115 = r1115;
        r126 = r126;
        r119 = r119;
        goto L656
    L558:
        if (r1213.element == false) goto L562;
        UplinkFileInfo r548 = r69.getUplinkFileInfo();
        if (r548 == null) goto L562;
        r548.setFileType(Boxing.boxInt(FileType.FileTypeAudio.getValue()));
        Unit r549 = Unit.INSTANCE;
        goto L562
    L554:
        r496 = false;
        goto L555
    L550:
        r1165 = false;
        goto L551
    L459:
        r453 = null;
    L455:
        r82 = UplinkEntityType.EntityTypeImage.getValue();
        goto L456
    L797:
        LegacyMultimodalDataProcessor r1171 = r443;
        Ref.ObjectRef r2111 = r447;
        r419 = r66;
        Ref.LongRef r4100 = r445;
        int r4101 = r446;
        String r2112 = r136;
        Object r3110 = r444;
        String r4102 = r108;
        String r4103 = r109;
        String r4104 = r1113;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r4105 = r1112;
        List<Uri> r4106 = r1111;
        String r550 = r116;
        Iterator r4107 = r1114;
        boolean r551 = r1110;
        r169 = r117;
        int r552 = r1115;
        int r553 = r118;
        boolean r554 = r119;
        boolean r555 = r126;
        boolean r556 = r122;
        boolean r557 = r125;
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 r1172 = r124;
        if (r3105 == null) goto L802;
        ux9.a.c r558 = r3105.e();
        if (r558 == null) goto L802;
        ux9.a.c.e(r558, AudioAttachmentUploadEvent.Result.COUNT_EXCEEDED, null, null, 6);
        Unit r559 = Unit.INSTANCE;
    L802:
        Ref.BooleanRef r560 = r213;
        r560.element = true;
        Ref.ObjectRef r561 = r210;
        if (r3104 != 0) goto L808;
        String r562 = (String) r561.element;
        if (r562 != null) goto L807;
        Context r563 = LegacyMultimodalDataProcessor.g(r1171);
        ImFileUtil.a.getClass();
        r562 = r563.getString(2131900065, new Object[]{String.valueOf(ImFileUtil.k())});
    L807:
        r561.element = r562;
    L808:
        Unit r564 = Unit.INSTANCE;
        r616 = r560;
        r1011 = r553;
        r711 = r561;
        r167 = r550;
        r1013 = r1172;
        r910 = r128;
        r174 = r1171;
        r615 = r215;
        r617 = r219;
        r618 = r217;
        r614 = r2111;
        r324 = r2112;
        r1010 = r316;
        r162 = r314;
        r173 = r3107;
        r164 = r3106;
        r138 = r312;
        r108 = r4102;
        r619 = r4101;
        r163 = r4100;
        r620 = r4103;
        r712 = r4104;
        r165 = r4105;
        r166 = r4106;
        r168 = r4107;
        r122 = r556;
        r170 = r557;
        r326 = r552;
        r810 = r555;
        r1012 = r554;
        r171 = r83;
        r420 = r214;
        r325 = r3110;
        r172 = r551;
        goto L810
    L436:
        Uri r565 = r252;
        r70 = r911;
        ux9.a r2113 = r253;
        int r566 = r270;
        r122 = r1313;
        r117 = r812;
        r131 = r565;
        r443 = r174;
        r217 = r309;
        r124 = r1013;
        r65 = r1105;
        r1213 = r1138;
        r445 = r918;
        r447 = r1017;
        r108 = r523;
        r109 = r818;
        r1113 = r525;
        r1112 = r816;
        r1111 = r813;
        r66 = r815;
        r110 = r814;
        r134 = r913;
        r128 = r910;
        r1114 = r916;
        r1115 = r912;
        r119 = r1012;
        r118 = r1011;
        r409 = r1014;
        r125 = r170;
        r444 = r527;
        r116 = r635;
        r136 = r625;
        r1110 = r627;
        r126 = r628;
        r313 = r633;
        r315 = r1139;
        r3107 = r719;
        r2107 = r566;
        r3106 = r255;
        r316 = r291;
        r312 = r919;
        r3104 = r269;
        r211 = r308;
        r213 = r1016;
        r446 = r619;
        r215 = r632;
        r408 = r251;
        r3105 = r2113;
        r2108 = r256;
        r219 = r917;
        r214 = r522;
        r314 = r634;
        r83 = r720;
        r3108 = r258;
        r210 = r1140;
        r1162 = r528;
    L314:
        r1126 = false;
        goto L315
    L306:
        if (r1125.element == false) goto L308;
        r1126 = r1122;
        r275 = r1015;
        goto L315
    L300:
        if (com.larus.bmhome.chat.component.bottom.multimodal.g.a.a(r1123) != true) goto L302;
        r1124 = true;
        goto L303
    L296:
        r274 = new v();
        goto L297
    L293:
        r1121 = new LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$isDisallowedEntityTypeMethod$2(r174);
        goto L294
    L284:
        if (r271.gj() != true) goto L286;
        r272 = true;
    L290:
        r273 = 1;
    L279:
        r270 = 0;
    L275:
        r269 = 1;
        goto L276
    L242:
        if (r1118.isEmpty() == false) goto L244;
    L269:
        r1120 = 0;
        goto L270
    L252:
        r268 = r1312;
        r1313 = r198;
        g1 r1173 = LegacyMultimodalDataProcessor.e(r174);
        if (r1173 == null) goto L269;
        List<UplinkFileEntity> r1174 = r1173.q1();
        if (r1174 == null) goto L269;
        List<UplinkFileEntity> r1175 = r1174;
        if ((r1175 instanceof Collection) == true) goto L259;
    L261:
        Iterator r1176 = r1175.iterator();
        r1120 = 0;
    L263:
        if (r1176.hasNext() == false) goto L270;
        if (n1.a((UplinkFileEntity) r1176.next()) == false) goto L263;
        r1120 = r1120 + 1;
        if (r1120 >= 0) goto L263;
        CollectionsKt.throwCountOverflow();
        goto L263
    L259:
        if (r1175.isEmpty() == false) goto L261;
    L274:
        r268 = r1312;
        r1313 = r198;
        goto L275
    L227:
        if (r1106 == false) goto L229;
        Integer r567 = Boxing.boxInt(LegacyMultimodalDataProcessor.j(r174, r257, r260));
    L233:
        if (r567 == null) goto L235;
        r267 = r567.intValue();
        goto L236
    L235:
        r267 = LegacyMultimodalDataProcessor.m(r174);
        goto L236
    L229:
        com.larus.bmhome.chat.component.bottom.multimodal.g r568 = LegacyMultimodalDataProcessor.p(r174);
        if (r568 == null) goto L232;
        r567 = Boxing.boxInt(r568.zv(r257, Boxing.boxBoolean(r260)));
        goto L233
    L232:
        r567 = null;
        goto L233
    L221:
        g1 r569 = LegacyMultimodalDataProcessor.e(r174);
        if (r569 == null) goto L224;
        r266 = g1.a.b(r569);
        goto L225
    L224:
        r266 = 0;
        goto L225
    L217:
        r1117 = null;
        goto L218
    L212:
        r265 = null;
        goto L214
    L213:
        r265 = r255;
        goto L214
    L203:
        if (r254.element == true) goto L206;
        r262 = false;
        goto L207
    L190:
        if (r184.element == true) goto L193;
        if (r256 == true) goto L193;
        r260 = true;
        goto L194
    L183:
        r179 = r243;
        r326 = r1103;
        Ref.BooleanRef r1177 = r248;
        r621 = r338;
        Uri r2114 = r341;
        r253 = r337;
        r712 = r433;
        r615 = r435;
        r616 = r432;
        r617 = r434;
        r429 = r521;
        r164 = r520;
        r711 = r519;
        r614 = r623;
        String r641 = r624;
        r428 = r241;
        r515 = r245;
        r332 = r247;
        r1310 = r246;
        Ref.BooleanRef r642 = r226;
        String r570 = r336;
        int r571 = r427;
        Ref.LongRef r572 = r513;
        String r2115 = r249;
        boolean r2116 = r240;
        Ref.BooleanRef r2117 = r184;
        Ref.BooleanRef r1178 = r183;
        r170 = r1104;
        boolean r1179 = r171;
        Object r1180 = r239;
        boolean r573 = r234;
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 r574 = r1102;
        int r1181 = r244;
        String r2118 = r340;
        m0 r3111 = r242;
        List<Boolean> r2119 = r339;
        r334 = r430;
        Object r3112 = r343;
        Object r3113 = r344;
    L185:
        r1014 = r179;
        r1013 = r574;
        r1011 = r571;
        r257 = r1310;
        r813 = r166;
        r918 = r572;
        r812 = r1180;
        r1015 = r1179;
        r250 = r1178;
        r184 = r2117;
        r1107 = r2118;
        r814 = r2119;
        r913 = r231;
        r910 = r233;
        r252 = r2114;
        r914 = r225;
        r625 = r2115;
        r1012 = r332;
        r912 = r326;
        r528 = r3113;
        r816 = r334;
        r815 = r342;
        r522 = r420;
        r523 = r431;
        r916 = r426;
        r811 = r428;
        r626 = r512;
        r1312 = r514;
        r255 = r164;
        r919 = r516;
        r911 = r515;
        r38 = r518;
        r1018 = r622;
        r619 = r621;
        r915 = r642;
        r818 = r641;
        r917 = r617;
        r1016 = r616;
        r1017 = r614;
        r254 = r615;
        r817 = r711;
        r525 = r712;
        r256 = false;
        r1105 = r570;
        r259 = r1177;
        r198 = r2116;
        r527 = r3112;
        r526 = r429;
        r258 = r1181;
        r1106 = r573;
        r251 = r3111;
        goto L188
    L184:
        r2114 = r181;
        r518 = r178;
        r233 = r331;
        r231 = r328;
        r2119 = r422;
        r2118 = r421;
        r225 = r423;
        r3111 = r197;
        r2117 = r184;
        r253 = r199;
        r431 = r425;
        r571 = r427;
        r1178 = r183;
        r641 = r620;
        r170 = r517;
        r642 = r618;
        r2115 = r324;
        r570 = r182;
        r342 = r424;
        r2116 = r198;
        r1177 = r185;
        r572 = r513;
        r573 = r327;
        r574 = r1;
        r1181 = r1100;
        r1179 = r171;
        r1180 = r329;
        r3112 = r325;
        r3113 = r330;
    L186:
        String r575 = r178;
        boolean r576 = r517;
        r1014 = r179;
        r912 = r326;
        r812 = r329;
        r813 = r166;
        r1015 = r171;
        r1013 = r1;
        r815 = r424;
        r814 = r422;
        r913 = r328;
        r910 = r331;
        r252 = r181;
        r914 = r423;
        r915 = r618;
        r1012 = r332;
        r816 = r334;
        r251 = r197;
        r1105 = r182;
        r253 = r199;
        r522 = r420;
        r917 = r617;
        r916 = r426;
        r1011 = r427;
        r811 = r428;
        r918 = r513;
        r1312 = r514;
        r255 = r164;
        r1016 = r616;
        r919 = r516;
        r911 = r515;
        r817 = r711;
        r1017 = r614;
        r1018 = r622;
        r818 = r620;
        r525 = r712;
        r1106 = r327;
        r619 = r621;
        r257 = r1310;
        r258 = r1100;
        r1107 = r421;
        r524 = r330;
        r523 = r425;
        r526 = r429;
        r626 = r512;
        r254 = r615;
        r256 = r185.element;
        r259 = r185;
        r250 = r183;
        r625 = r324;
        r38 = r575;
        r170 = r576;
        r345 = r325;
        goto L182
    L160:
        if (r184.element == false) goto L169;
        ICoreInputAbility r577 = LegacyMultimodalDataProcessor.i(r174);
        if (r577 != null) goto L164;
    L166:
        boolean r578 = false;
    L167:
        if (r578 == false) goto L169;
    L164:
        if (r577.wy() != true) goto L166;
        r578 = true;
    L170:
        r1100 = 1;
        goto L171
    L145:
        if (r197.b() != null) goto L155;
        HashMap r1182 = FileMimeTypeUtils.a;
        String r1183 = r197.c();
        r334 = r165;
        if (r1183 == null) goto L149;
        String r1184 = StringsKt.substringAfterLast(r1183, '.', r178);
    L151:
        if (FileMimeTypeUtils.a(r1184) == FileMimeTypeUtils.AudioMineTypeAbbr.UNCLEAR) goto L156;
        r184.element = true;
        r183.element = false;
        r185.element = false;
        if (r190 != null) goto L156;
        r199 = a(r182, r174, r326, r166, r171, r189, r1310, r420, r198);
        goto L157
    L149:
        r1184 = null;
        goto L151
    L136:
        r716 = 0;
        goto L137
    L125:
        if (r195 != 2) goto L127;
        r185.element = true;     // Catch: Throwable -> L105
    L131:
        r715 = null;
        goto L133
    L127:
        if (r195 != 3) goto L131;
        r184.element = true;     // Catch: Throwable -> L105
        goto L131
    L121:
        r713 = null;
        goto L122
    L138:
        r515 = r515;
        r197 = ImFileUtil.f(r181);     // Catch: Throwable -> L105
        goto L142
    L116:
        r193 = null;
    L141:
        r197 = ImFileUtil.f(r181);     // Catch: Throwable -> L105
    L111:
        r191 = false;
    L105:
        th = th;
        boolean r579 = r517;
    L109:
        int r580 = r621;
        Ref.BooleanRef r2120 = r618;
        String r643 = r620;
        Ref.BooleanRef r4108 = r617;
        Ref.BooleanRef r581 = r616;
        Ref.ObjectRef r644 = r614;
        Ref.BooleanRef r645 = r615;
        Ref.ObjectRef r582 = r711;
        String r646 = r712;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r3114 = r165;
        boolean r583 = r1310;
        if (r190 == null) goto L815;
        ux9.a.c r584 = r190.e();
        if (r584 == null) goto L815;
        Object r1185 = r329;
        ux9.a.c.e(r584, AudioAttachmentUploadEvent.Result.EMPTY_DATA, null, th.getClass().getSimpleName(), 2);
        Unit r585 = Unit.INSTANCE;
        EnsureManager.ensureNotReachHere(th, "onMultiFileResultSuccess getFileInfoFromUri exception");
        r327 = r327;
        r621 = r580;
        r326 = r326;
        r810 = r583;
        r1 = r1;
        r329 = r1185;
        r421 = r421;
        r424 = r424;
        r422 = r422;
        r328 = r328;
        r331 = r331;
        r165 = r3114;
        r617 = r4108;
        r168 = r426;
        r179 = r427;
        r175 = r429;
        r176 = r512;
        r163 = r513;
        r173 = r514;
        r164 = r164;
        r616 = r581;
        r711 = r582;
        r614 = r644;
        r615 = r645;
        r712 = r646;
        r177 = r579;
        r333 = r333;
        r423 = r423;
        r162 = r428;
        r138 = r516;
        r620 = r643;
        r618 = r2120;
    L815:
        Object r1186 = r329;
        EnsureManager.ensureNotReachHere(th, "onMultiFileResultSuccess getFileInfoFromUri exception");
        r327 = r327;
        r621 = r580;
        r326 = r326;
        r810 = r583;
        r1 = r1;
        r329 = r1186;
        r421 = r421;
        r424 = r424;
        r422 = r422;
        r328 = r328;
        r331 = r331;
        r165 = r3114;
        r617 = r4108;
        r168 = r426;
        r179 = r427;
        r175 = r429;
        r176 = r512;
        r163 = r513;
        r173 = r514;
        r164 = r164;
        r616 = r581;
        r711 = r582;
        r614 = r644;
        r615 = r645;
        r712 = r646;
        r177 = r579;
        r333 = r333;
        r423 = r423;
        r162 = r428;
        r138 = r516;
        r620 = r643;
        r618 = r2120;
    L107:
        th = th;
        r579 = r177;
        goto L109
    L110:
        r516 = r138;
        r517 = r177;
        goto L111
    L140:
        r516 = r138;
        r517 = r177;
    L95:
        r190 = a(r182, r174, r326, r166, r171, r189, r1310, r420, r333);
    L86:
        r188 = false;
        goto L87
    L85:
        r224 = r187;
    L89:
        r189 = null;
        goto L91
    L79:
        r187 = null;
        goto L80
    L75:
        r186 = null;
        goto L77
    L818:
        Ref.BooleanRef r4109 = r162;
        final String r586 = r164;
        String r587 = r178;
        Ref.LongRef r588 = r163;
        List<UplinkFileEntity> r589 = r173;
        boolean r590 = r177;
        Ref.BooleanRef r4110 = r175;
        Ref.BooleanRef r591 = r176;
        int r592 = r326;
        Ref.BooleanRef r2121 = r423;
        int r593 = r621;
        Ref.BooleanRef r2122 = r618;
        String r647 = r620;
        Ref.BooleanRef r4111 = r617;
        Ref.BooleanRef r594 = r616;
        Ref.ObjectRef r648 = r614;
        Ref.BooleanRef r649 = r615;
        Ref.ObjectRef r595 = r711;
        String r650 = r712;
        LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1 r1187 = r1;
        boolean r596 = r327;
        if (r594.element == false) goto L825;
        BotModel r597 = LegacyMultimodalDataProcessor.c(r1187.this$0);
        if (r597 == null) goto L823;
        String r598 = r597.getBotId();
    L824:
        y3.b(r598, "file count over limit", Boxing.boxInt(r1187.$uriList.size() + r592));
        goto L825
    L823:
        r598 = null;
    L825:
        ImFileUtil r599 = ImFileUtil.a;
        long r600 = r588.element;
        r599.getClass();
        if (ImFileUtil.x(r600) == false) goto L844;
        Iterator r601 = r589.iterator();
    L829:
        if (r601.hasNext() == false) goto L835;
        ux9.a r602 = ux9.a.i.c(((UplinkFileEntity) r601.next()).getFileIdentifier());
        if (r602 == null) goto L829;
        ux9.a.c r603 = r602.e();
        if (r603 == null) goto L829;
        ux9.a.c.e(r603, AudioAttachmentUploadEvent.Result.INSUFFICIENT_STORAGE, null, null, 6);
        Unit r604 = Unit.INSTANCE;
        goto L829
    L835:
        LegacyMultimodalDataProcessor.t(r1187.this$0, r589, !r596);
        if (r596 == false) goto L843;
        z2 r605 = z2.a;
        if (z2.c4() == false) goto L843;
        p1 r606 = LegacyMultimodalDataProcessor.f(r1187.this$0);
        if (r606 == null) goto L843;
        r606.cb(true);
        Boxing.boxBoolean(true);
    L843:
        return Unit.INSTANCE;
    L844:
        ICoreInputAbility r607 = LegacyMultimodalDataProcessor.i(r1187.this$0);
        if (r607 != null) goto L847;
    L849:
        boolean r2123 = false;
    L850:
        FragmentActivity r608 = LegacyMultimodalDataProcessor.l(r1187.this$0).getActivity();
        if (r608 == null) goto L856;
        LifecycleCoroutineScope r609 = LifecycleOwnerKt.getLifecycleScope(r608);
        if (r609 == null) goto L856;
        r609.launchWhenResumed(new AnonymousClass4(r1187.this$0, r2123, r590, r4110, r591, r4109, r2121, r2122, r4111, r594, r1187.$isFromFileBrowser, r648, r649, r595, r596, null));
    L856:
        if (r589.isEmpty() == false) goto L863;
        if (r596 == false) goto L862;
        p1 r651 = LegacyMultimodalDataProcessor.f(r1187.this$0);
        if (r651 == null) goto L862;
        p1$a.a(r651);
        Boxing.boxBoolean(true);
    L862:
        return Unit.INSTANCE;
    L863:
        if (r596 == true) goto L865;
    L882:
        String r652 = r622;
        if (r596 == false) goto L889;
        de8.c r653 = (de8.c) r1187.this$0.b.getValue();
        if (r653 == null) goto L889;
        Bundle r654 = r653.j();
        if (r654 == null) goto L889;
        String r4112 = r654.getString("input_text");
    L890:
        List<UplinkFileEntity> r655 = r589;
        LegacyMultimodalDataProcessor r656 = r1187.this$0;
        Iterator r657 = r655.iterator();
    L892:
        if (r657.hasNext() == false) goto L909;
        ux9.a r658 = ux9.a.i.c(((UplinkFileEntity) r657.next()).getFileIdentifier());
        if (r658 == null) goto L892;
        if (r586 != null) goto L900;
        g1 r659 = LegacyMultimodalDataProcessor.e(r656);
        if (r659 == null) goto L899;
        String r660 = r659.uM();
    L901:
        if (r596 == false) goto L903;
        int r661 = r589.size();
    L907:
        r658.d(r660, Boxing.boxInt(r661));
        Unit r662 = Unit.INSTANCE;
        goto L892
    L903:
        g1 r663 = LegacyMultimodalDataProcessor.e(r656);
        if (r663 == null) goto L906;
        r661 = g1.a.b(r663);
        goto L907
    L906:
        r661 = r589.size();
        goto L907
    L899:
        r660 = null;
        goto L901
    L900:
        r660 = r586;
        goto L901
    L909:
        if ((r655 instanceof Collection) == true) goto L911;
    L913:
        Iterator r664 = r655.iterator();
    L915:
        if (r664.hasNext() == false) goto L919;
        if (n1.d((UplinkFileEntity) r664.next()) == true) goto L915;
        boolean r1188 = false;
    L921:
        if (LegacyMultimodalDataProcessor.y(r1187.this$0, r1187.$fromScene, r1188, r1187.$cameraType, r1187.$directSendData, r596) == false) goto L1017;
        FLogger r665 = FLogger.a;
        r665.i(r652, "[onMultiFileResultSuccess] skipAttachment");
        if (r596 == false) goto L952;
        p1 r666 = LegacyMultimodalDataProcessor.f(r1187.this$0);
        if (r666 == null) goto L934;
        j1 r3115 = r666.Y3();
        if (r3115 == null) goto L934;
        if (r586 != null) goto L930;
        String r4113 = r587;
    L932:
        if (j1.a.a(r3115, r4113, null, r589, false, true, r4112, r1187.$replacementToken, null, null, 394) != true) goto L934;
        boolean r667 = true;
    L935:
        if (r667 == true) goto L941;
        r665.w(r652, "shared attachment draft replacement was not persisted");
        p1 r668 = LegacyMultimodalDataProcessor.f(r1187.this$0);
        if (r668 == null) goto L940;
        p1$a.a(r668);
        Boxing.boxBoolean(true);
    L940:
        return Unit.INSTANCE;
    L941:
        de8.c r669 = (de8.c) r1187.this$0.b.getValue();
        if (r669 == null) goto L946;
        Bundle r670 = r669.j();
        if (r670 == null) goto L946;
        r670.remove("entry_draft_replacement_token");
        Unit r671 = Unit.INSTANCE;
    L946:
        p1 r672 = LegacyMultimodalDataProcessor.f(r1187.this$0);
        if (r672 == null) goto L949;
        p1$a.a(r672);
        Boxing.boxBoolean(true);
    L949:
        u7 r673 = (u7) r1187.this$0.h.getValue();
        if (r673 == null) goto L952;
        u7$a.d(r673);
        Unit r674 = Unit.INSTANCE;
        goto L952
    L930:
        r4113 = r586;
    L934:
        r667 = false;
    L952:
        final ArrayList r675 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r655, 10));
        Iterator r676 = r655.iterator();
    L954:
        if (r676.hasNext() == false) goto L959;
        String r677 = ((UplinkFileEntity) r676.next()).getFileIdentifier();
        if (r677 != null) goto L958;
        r677 = r587;
    L958:
        r675.add(r677);
        goto L954
    L959:
        final LegacyMultimodalDataProcessor r678 = r1187.this$0;
        ?? r679 = new w(r678, r586, r675);
        wc9.e r4114 = LegacyMultimodalDataProcessor.h(r678);
        if (r4114 == null) goto L1015;
        if (r596 == true) goto L963;
    L965:
        LegacyMultimodalDataProcessor.b(r1187.this$0);
        com.larus.bmhome.chat.component.bottom.reference.a r680 = LegacyMultimodalDataProcessor.q(r1187.this$0);
        if (r680 != null) goto L968;
    L970:
        boolean r681 = false;
    L971:
        if (r681 == false) goto L989;
        DirectSendData r682 = r1187.$directSendData;
        if (r682 == null) goto L975;
        String r1189 = r682.getDisplayName();
    L977:
        if (o0.d(r1189) == false) goto L989;
        com.larus.bmhome.chat.component.bottom.reference.a r683 = LegacyMultimodalDataProcessor.q(r1187.this$0);
        if (r683 == null) goto L981;
        ReferenceInfo r1190 = r683.T6();
    L982:
        com.larus.bmhome.chat.component.bottom.reference.a r684 = LegacyMultimodalDataProcessor.q(r1187.this$0);
        if (r684 == null) goto L985;
        r684.sZ();
        Unit r685 = Unit.INSTANCE;
    L985:
        com.larus.bmhome.chat.component.bottom.reference.a r686 = LegacyMultimodalDataProcessor.q(r1187.this$0);
        if (r686 == null) goto L988;
        r686.Ek(false);
        Unit r687 = Unit.INSTANCE;
    L988:
        ReferenceInfo r4115 = r1190;
    L990:
        if (r593 != 0) goto L1000;
        ICoreInputAbility r688 = LegacyMultimodalDataProcessor.i(r1187.this$0);
        if (r688 != null) goto L994;
    L996:
        boolean r689 = false;
    L997:
        if (r689 == false) goto L1000;
        boolean r4116 = false;
    L1001:
        Map<String, List<String>> r690 = DirectSendFileHelper.a;
        BotModel r691 = LegacyMultimodalDataProcessor.c(r1187.this$0);
        if (r691 == null) goto L1004;
        String r1191 = r691.getBotId();
    L1005:
        if (r1191 != null) goto L1007;
        String r4117 = r587;
    L1008:
        String r4118 = LegacyMultimodalDataProcessor.s(r1187.this$0);
        String r4119 = LegacyMultimodalDataProcessor.r(r1187.this$0, r1187.$fromScene, r1187.$directSendData);
        com.larus.bmhome.chat.component.bottom.reference.a r692 = LegacyMultimodalDataProcessor.q(r1187.this$0);
        if (r692 == null) goto L1011;
        String r4120 = r692.wf();
    L1012:
        DirectSendFileHelper.a(r589, r4116, r4114, r4117, r1187.$fromScene, r4118, r4119, r650, r1187.$directSendData, r4120, r4115, r1187.$imageProcessConfig);
        g1 r693 = LegacyMultimodalDataProcessor.e(r1187.this$0);
        if (r693 == null) goto L1048;
        g1.a.a(r693, null, 7);
        Unit r694 = Unit.INSTANCE;
    L1048:
        return Unit.INSTANCE;
    L1011:
        r4120 = null;
        goto L1012
    L1007:
        r4117 = r1191;
        goto L1008
    L1004:
        r1191 = null;
        goto L1005
    L994:
        if (r688.gj() != true) goto L996;
        r689 = true;
    L1000:
        r4116 = true;
        goto L1001
    L981:
        r1190 = null;
        goto L982
    L975:
        r1189 = null;
    L989:
        r4115 = null;
        goto L990
    L968:
        if (r680.LX() != true) goto L970;
        r681 = true;
        goto L971
    L963:
        if (((Boolean) r679.invoke()).booleanValue() == true) goto L965;
    L1015:
        FLogger.a.w(r652, "skip direct send because shared attachment draft identity changed");
        return Unit.INSTANCE;
    L1017:
        g1 r695 = LegacyMultimodalDataProcessor.e(r1187.this$0);
        if (r695 == null) goto L1020;
        r695.x2(r1187.$imageProcessConfig);
        Unit r696 = Unit.INSTANCE;
    L1020:
        g1 r2124 = LegacyMultimodalDataProcessor.e(r1187.this$0);
        if (r2124 == null) goto L1029;
        boolean r697 = r1187.$isFromFileBrowser;
        String r1192 = r1187.$fromScene;
        String r2125 = LegacyMultimodalDataProcessor.s(r1187.this$0);
        boolean r1193 = r1187.$isFromDrive;
        String r1194 = r1187.$uploadTaskShareTag;
        String r1195 = r1187.$replacementToken;
        Long r1196 = Boxing.boxLong(r1187.$attachmentSelectionEditedAt);
        r1196.longValue();
        if (r596 == true) goto L1025;
        Long r3116 = r1196;
    L1027:
        if (r2124.w50(r589, r697, r1192, r2125, r420, r425, r650, r647, r1193, r1194, r586, r596, r4112, r1195, r3116) != true) goto L1029;
        boolean r698 = true;
    L1030:
        if (r698 == true) goto L1037;
        if (r596 == false) goto L1037;
        FLogger.a.w(r652, "shared attachment draft replacement was not persisted");
        p1 r699 = LegacyMultimodalDataProcessor.f(r1187.this$0);
        if (r699 == null) goto L1036;
        p1$a.a(r699);
        Boxing.boxBoolean(true);
    L1036:
        return Unit.INSTANCE;
    L1037:
        if (r596 == false) goto L1046;
        de8.c r700 = (de8.c) r1187.this$0.b.getValue();
        if (r700 == null) goto L1043;
        Bundle r701 = r700.j();
        if (r701 == null) goto L1043;
        r701.remove("entry_draft_replacement_token");
        Unit r702 = Unit.INSTANCE;
    L1043:
        u7 r703 = (u7) r1187.this$0.h.getValue();
        if (r703 == null) goto L1046;
        u7$a.d(r703);
        Unit r704 = Unit.INSTANCE;
    L1046:
        Unit r705 = Unit.INSTANCE;
        goto L1048
    L1025:
        r3116 = null;
    L1029:
        r698 = false;
    L919:
        r1188 = true;
        goto L921
    L911:
        if (r655.isEmpty() == false) goto L913;
    L889:
        r4112 = null;
        goto L890
    L865:
        if (LegacyMultimodalDataProcessor.f(r1187.this$0) != null) goto L867;
    L877:
        FLogger.a.w(r622, "skip shared attachment draft replacement because ability is unavailable");
        p1 r706 = LegacyMultimodalDataProcessor.f(r1187.this$0);
        if (r706 == null) goto L881;
        p1$a.a(r706);
        Boxing.boxBoolean(true);
    L881:
        return Unit.INSTANCE;
    L867:
        if (LegacyMultimodalDataProcessor.e(r1187.this$0) == null) goto L877;
        if (LegacyMultimodalDataProcessor.h(r1187.this$0) == null) goto L877;
        if (r586 != null) goto L872;
    L875:
        boolean r707 = true;
    L876:
        if (r707 == false) goto L882;
    L872:
        if (StringsKt.isBlank(r586) == true) goto L875;
        r707 = false;
        goto L876
    L847:
        if (r607.wy() != true) goto L849;
        r2123 = true;
        goto L850
    L789:
        if (sr9.b.b.g(r131.toString()) == true) goto L793;
        g1 r708 = LegacyMultimodalDataProcessor.e(r111);
        if (r708 == null) goto L796;
        r708.f50(r140);
        Unit r709 = Unit.INSTANCE;
        goto L796
    L793:
        g1 r730 = LegacyMultimodalDataProcessor.e(r111);
        if (r730 == null) goto L796;
        r730.EC(r140);
        Unit r731 = Unit.INSTANCE;
    L770:
        if (r152 == null) goto L773;
        r158 = r152.getUplinkWay();
        goto L772
    L773:
        r418 = null;
    L759:
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r732 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r732 == null) goto L763;
        r155 = r732.e();
        goto L762
    L763:
        r417 = null;
    L744:
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r733 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r733 == null) goto L750;
        Uri r734 = r733.b();
        if (r734 == null) goto L750;
        r154 = r734.toString();
    L750:
        r416 = null;
    L731:
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r735 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r70.element;
        if (r735 == null) goto L735;
        r153 = r735.h();
        goto L734
    L735:
        r415 = null;
    L721:
        r151 = null;
        goto L722
    L715:
        r414 = 12;
        goto L716
    L778:
        r222 = r88;
    L709:
        r146 = null;
        goto L711
    L779:
        r66 = r66;
        r222 = r88;
        if (r126 == false) goto L786;
        if (r83 == true) goto L786;
        Map r736 = r140.getExtra();
        if (r736 != null) goto L785;
        r736 = MapsKt.emptyMap();
    L785:
        r140.setExtra(MapsKt.plus(r736, MapsKt.mapOf(TuplesKt.to("upload_way", "browser_folder"))));
        goto L786
    L686:
        r135 = r82;
        r221 = r87;
        goto L687
    L644:
        r321 = false;
    L651:
        r79 = r318;
        goto L652
    L629:
        r319 = false;
    L636:
        r611 = r318;
    L621:
        r610 = null;
        goto L622
    L615:
        r318 = null;
        goto L616
    L612:
        r317 = false;
        goto L613
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r737 = r1.I$8;
        int r738 = r1.I$7;
        int r739 = r1.I$6;
        int r740 = r1.I$5;
        int r741 = r1.I$4;
        int r742 = r1.I$3;
        int r743 = r1.I$2;
        boolean r744 = r1.Z$5;
        boolean r1197 = r1.Z$4;
        boolean r1198 = r1.Z$3;
        int r745 = r1.I$1;
        boolean r746 = r1.Z$2;
        boolean r747 = r1.Z$1;
        int r748 = r1.I$0;
        boolean r749 = r1.Z$0;
        m0 r750 = (m0) r1.L$34;
        r2103 = (ux9.a) r1.L$33;
        r393 = (Ref.ObjectRef) r1.L$32;
        Ref.BooleanRef r751 = (Ref.BooleanRef) r1.L$31;
        Ref.BooleanRef r752 = (Ref.BooleanRef) r1.L$30;
        String r753 = (String) r1.L$29;
        Ref.BooleanRef r754 = (Ref.BooleanRef) r1.L$28;
        r387 = (Uri) r1.L$27;
        Iterator r755 = (Iterator) r1.L$26;
        List<String> r756 = (List) r1.L$25;
        List<Boolean> r757 = (List) r1.L$24;
        List<Boolean> r758 = (List) r1.L$23;
        List<Boolean> r759 = (List) r1.L$22;
        String r760 = (String) r1.L$21;
        LegacyMultimodalDataProcessor r761 = (LegacyMultimodalDataProcessor) r1.L$20;
        List<Uri> r762 = (List) r1.L$19;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r763 = (List) r1.L$18;
        String r764 = (String) r1.L$17;
        String r765 = (String) r1.L$16;
        String r766 = (String) r1.L$15;
        String r767 = (String) r1.L$14;
        Ref.BooleanRef r768 = (Ref.BooleanRef) r1.L$13;
        Ref.ObjectRef r769 = (Ref.ObjectRef) r1.L$12;
        Ref.ObjectRef r770 = (Ref.ObjectRef) r1.L$11;
        Ref.BooleanRef r771 = (Ref.BooleanRef) r1.L$10;
        Ref.BooleanRef r772 = (Ref.BooleanRef) r1.L$9;
        Ref.BooleanRef r773 = (Ref.BooleanRef) r1.L$8;
        r530 = (Ref.BooleanRef) r1.L$7;
        Ref.BooleanRef r774 = (Ref.BooleanRef) r1.L$6;
        Ref.BooleanRef r775 = (Ref.BooleanRef) r1.L$5;
        r533 = (Ref.BooleanRef) r1.L$4;
        Ref.LongRef r776 = (Ref.LongRef) r1.L$3;
        List<UplinkFileEntity> r777 = (List) r1.L$2;
        String r778 = (String) r1.L$1;
        CoroutineScope r779 = (CoroutineScope) r1.L$0;
        ResultKt.throwOnFailure(r130);
        r1013 = r1;
        r726 = r743;
        r725 = r744;
        r727 = "1";
        r728 = "ext_is_from_drive";
        r810 = r1197;
        r819 = " ";
        r821 = r1198;
        r820 = "";
        r1155 = r0;
        r627 = r749;
        r389 = r750;
        r1150 = r751;
        r385 = r754;
        r729 = r756;
        r640 = r757;
        r639 = r758;
        r1153 = r759;
        r637 = r761;
        r1152 = r762;
        r1154 = r763;
        r724 = r765;
        r632 = r768;
        r723 = r769;
        r392 = r772;
        r721 = r773;
        r634 = r774;
        r633 = r775;
        r722 = r776;
        r719 = r777;
        r636 = r778;
        r638 = r779;
        r2104 = r738;
        r269 = r739;
        r1151 = "LegacyMultimodalDataProcessor";
        r170 = r746;
        r529 = r747;
        r532 = r748;
        r384 = r753;
        r531 = r755;
        r635 = r760;
        r388 = r767;
        r390 = r770;
        r534 = r771;
        r382 = r130;
        r2105 = r740;
        r440 = r742;
        r2102 = r737;
        r1314 = r745;
        r391 = r752;
        r386 = r764;
        r258 = r741;
        r394 = r766;
        goto L406
    L11:
        int r780 = r1.I$4;
        int r781 = r1.I$3;
        int r782 = r1.I$2;
        boolean r783 = r1.Z$5;
        boolean r784 = r1.Z$4;
        boolean r785 = r1.Z$3;
        int r786 = r1.I$1;
        boolean r787 = r1.Z$2;
        boolean r1199 = r1.Z$1;
        int r1200 = r1.I$0;
        r244 = r780;
        boolean r788 = r1.Z$0;
        r242 = (m0) r1.L$34;
        ux9.a r789 = (ux9.a) r1.L$33;
        Ref.ObjectRef r790 = (Ref.ObjectRef) r1.L$32;
        r248 = (Ref.BooleanRef) r1.L$31;
        Ref.BooleanRef r791 = (Ref.BooleanRef) r1.L$30;
        String r792 = (String) r1.L$29;
        Ref.BooleanRef r793 = (Ref.BooleanRef) r1.L$28;
        r341 = (Uri) r1.L$27;
        Iterator r794 = (Iterator) r1.L$26;
        List<String> r795 = (List) r1.L$25;
        List<Boolean> r796 = (List) r1.L$24;
        r339 = (List) r1.L$23;
        r342 = (List) r1.L$22;
        r340 = (String) r1.L$21;
        LegacyMultimodalDataProcessor r797 = (LegacyMultimodalDataProcessor) r1.L$20;
        List<Uri> r798 = (List) r1.L$19;
        r430 = (List) r1.L$18;
        r433 = (String) r1.L$17;
        String r799 = (String) r1.L$16;
        r431 = (String) r1.L$15;
        String r800 = (String) r1.L$14;
        r435 = (Ref.BooleanRef) r1.L$13;
        Ref.ObjectRef r801 = (Ref.ObjectRef) r1.L$12;
        Ref.ObjectRef r802 = (Ref.ObjectRef) r1.L$11;
        r432 = (Ref.BooleanRef) r1.L$10;
        r434 = (Ref.BooleanRef) r1.L$9;
        Ref.BooleanRef r803 = (Ref.BooleanRef) r1.L$8;
        Ref.BooleanRef r804 = (Ref.BooleanRef) r1.L$7;
        Ref.BooleanRef r805 = (Ref.BooleanRef) r1.L$6;
        r521 = (Ref.BooleanRef) r1.L$5;
        Ref.BooleanRef r806 = (Ref.BooleanRef) r1.L$4;
        Ref.LongRef r807 = (Ref.LongRef) r1.L$3;
        List<UplinkFileEntity> r808 = (List) r1.L$2;
        r520 = (String) r1.L$1;
        CoroutineScope r809 = (CoroutineScope) r1.L$0;
        ResultKt.throwOnFailure(r130);
        r622 = "LegacyMultimodalDataProcessor";
        r518 = "";
        r184 = r791;
        r624 = r799;
        r420 = r800;
        r623 = r801;
        r519 = r802;
        r225 = r804;
        r513 = r807;
        r516 = r809;
        r243 = r781;
        r427 = r782;
        r245 = r790;
        r426 = r794;
        r233 = r795;
        r241 = r805;
        r514 = r808;
        r238 = r130;
        r343 = "1";
        r1103 = r786;
        r174 = r797;
        r336 = r792;
        r226 = r803;
        r512 = r806;
        r1102 = r1;
        r234 = r788;
        r249 = " ";
        r247 = r783;
        r239 = r0;
        r240 = r1199;
        r1104 = r787;
        r246 = r784;
        r171 = r785;
        r166 = r798;
        r337 = r789;
        r231 = r796;
        r344 = "ext_is_from_drive";
        r338 = r1200;
        r183 = r793;
        goto L180
    L12:
        ResultKt.throwOnFailure(r130);
        CoroutineScope r826 = (CoroutineScope) r1.L$0;
        FLogger.a.i("LegacyMultimodalDataProcessor", "[onMultiFileResultSuccess] fromScene:" + r1.$fromScene + ", isFromFileBrowser:" + r1.$isFromFileBrowser + ", uriList(" + r1.$uriList.size() + "):" + r1.$uriList);
        boolean r827 = r1.$replaceModeDraftAfterValidation;
        Boolean r828 = Boxing.boxBoolean(r827);
        if (r828.booleanValue() == true) goto L16;
        r828 = null;
    L16:
        if (r828 == null) goto L18;
        r828.booleanValue();
        String r829 = wf9.b.a();
    L19:
        if (r827 == true) goto L28;
        com.larus.bmhome.instruction.g r830 = LegacyMultimodalDataProcessor.n(r1.this$0);
        if (r830 != null) goto L23;
    L25:
        boolean r831 = false;
    L26:
        if (r831 == false) goto L28;
        int r832 = 1;
    L29:
        boolean r833 = z2.a.getFlowMultiUploadConfig().c();
        LegacyMultimodalDataProcessor r834 = r1.this$0;
        List<Uri> r835 = r1.$uriList;
        String r836 = r1.$fromScene;
        if (r1.$isFromDrive == false) goto L32;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r2126 = r1.$attachmentList;
    L33:
        boolean r837 = LegacyMultimodalDataProcessor.v(r834, r835, r836, r2126, r833, r827);
        ArrayList r838 = new ArrayList();
        r163 = new Ref.LongRef();
        if (r827 == true) goto L39;
        g1 r1201 = LegacyMultimodalDataProcessor.e(r1.this$0);
        if (r1201 == null) goto L39;
        int r1202 = g1.a.b(r1201);
    L40:
        Ref.BooleanRef r1203 = new Ref.BooleanRef();
        Ref.BooleanRef r2127 = new Ref.BooleanRef();
        Ref.BooleanRef r2128 = new Ref.BooleanRef();
        Ref.BooleanRef r2129 = new Ref.BooleanRef();
        Ref.BooleanRef r2130 = new Ref.BooleanRef();
        Ref.BooleanRef r2131 = new Ref.BooleanRef();
        Ref.BooleanRef r2132 = new Ref.BooleanRef();
        Ref.ObjectRef r2133 = new Ref.ObjectRef();
        Ref.ObjectRef r2134 = new Ref.ObjectRef();
        Ref.BooleanRef r3117 = new Ref.BooleanRef();
        Map<String, String> r839 = r1.$ext;
        String r3118 = r829;
        if (r839 == null) goto L43;
        String r840 = r839.get("enter_method");
    L44:
        Map<String, String> r841 = r1.$ext;
        String r3119 = r840;
        if (r841 == null) goto L47;
        String r842 = r841.get("is_multi_choose_mode");
    L48:
        Map<String, String> r843 = r1.$ext;
        String r3120 = r842;
        if (r843 == null) goto L52;
        String r844 = r843.get("enter_method_trace");
        if (r844 == null) goto L52;
    L53:
        LegacyMultimodalDataProcessor.w(r1.this$0, "");
        Map<String, String> r845 = r1.$ext;
        String r3121 = r844;
        if (r845 == null) goto L63;
        String r846 = r845.get("upload_file_click_from");
        if (r846 == null) goto L63;
        LegacyMultimodalDataProcessor r847 = r1.this$0;
        if (r846.length() <= 0) goto L60;
        boolean r3122 = true;
    L61:
        if (r3122 == false) goto L63;
        LegacyMultimodalDataProcessor.w(r847, r846);
        goto L63
    L60:
        r3122 = false;
    L63:
        if (r827 == false) goto L65;
        String r848 = null;
    L66:
        List<Uri> r849 = r1.$uriList;
        String r3123 = r848;
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r850 = r1.$attachmentList;
        boolean r851 = r1.$isFromDrive;
        LegacyMultimodalDataProcessor r852 = r1.this$0;
        boolean r853 = r1.$isFromFileBrowser;
        String r854 = r1.$fromScene;
        boolean r855 = r1.$isOriginalImageChecked;
        List<Boolean> r856 = r1.$isImagesMarked;
        List<Boolean> r857 = r1.$isImagesCropped;
        List<Boolean> r858 = r1.$isImagesAiCreation;
        List<String> r859 = r1.$resultSource;
        r622 = "LegacyMultimodalDataProcessor";
        r621 = r832;
        r178 = "";
        r618 = r2130;
        r617 = r2131;
        r616 = r2132;
        r711 = r2133;
        r614 = r2134;
        r615 = r3117;
        r164 = r3118;
        r620 = r3121;
        r712 = r3123;
        r332 = r855;
        r330 = "ext_is_from_drive";
        r324 = " ";
        r176 = r1203;
        r329 = r0;
        r175 = r2127;
        r420 = r3119;
        r171 = r851;
        r327 = r827;
        r177 = r837;
        r326 = r1202;
        r168 = r849.iterator();
        r166 = r849;
        r333 = r833;
        r173 = r838;
        r162 = r2128;
        r165 = r850;
        r174 = r852;
        r328 = r858;
        r331 = r859;
        r423 = r2129;
        r179 = 0;
        r138 = r826;
        r1310 = r853;
        r422 = r857;
        r425 = r3120;
        r325 = "1";
        r421 = r854;
        r424 = r856;
        goto L68
    L65:
        r848 = LegacyMultimodalDataProcessor.d(r1.this$0);
    L52:
        r844 = "";
        goto L53
    L47:
        r842 = null;
        goto L48
    L43:
        r840 = null;
    L39:
        r1202 = 0;
        goto L40
    L32:
        r2126 = null;
        goto L33
    L23:
        if (r830.Wa() != true) goto L25;
        r831 = true;
    L28:
        r832 = 0;
        goto L29
    L18:
        r829 = null;
        goto L19
    }

    public static final ux9.a a(String r10, LegacyMultimodalDataProcessor r11, int r12, List<? extends Uri> r13, boolean r14, com.larus.bmhome.chat.component.bottom.multimodal.a.b r15, boolean r16, String r17, boolean r18) {
        ux9.a.a r1 = ux9.a.i;
        int r2 = LegacyMultimodalDataProcessor.q;
        y r3 = (y) r11.d.getValue();
        if (r3 == null) goto L5;
        String r4 = r3.Y1();
    L6:
        BotModel r5 = r11.B();
        if (r5 == null) goto L9;
        String r6 = r5.getBotId();
    L10:
        int r7 = r13.size() + r12;
        if (r14 == false) goto L13;
        String r8 = "drive";
    L14:
        String r9 = r8;
        if (r15 == null) goto L20;
        Map<String, String> r0 = r15.n;
        if (r0 == null) goto L20;
        String r19 = r0.get("upload_way");
        if (r19 == null) goto L20;
    L22:
        String r20 = r19;
    L25:
        return r1.e(r10, r4, r6, r7, r9, r20, r17, r18, new x());
    L20:
        if (r16 == false) goto L23;
        r19 = "browser_folder";
        goto L22
    L23:
        r20 = null;
        goto L25
    L13:
        r8 = "local";
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
