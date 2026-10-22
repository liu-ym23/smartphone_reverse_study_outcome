package com.larus.bmhome.chat.component.bottom.attachment;

import android.net.Uri;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.z2;
import com.larus.trace.audioattachment.AudioAttachmentUploadEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$handleUploadAttachments$6$1", f = "AttachmentPanelComponent.kt", i = {}, l = {2218, 2220}, m = "invokeSuspend", n = {}, s = {})
public final class AttachmentPanelComponent$handleUploadAttachments$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $draftLocalMsgId;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ boolean $isFromDrive;
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.q $tryAttachmentUploadParam;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$handleUploadAttachments$6$1(boolean r1, UplinkFileEntity r2, AttachmentPanelComponent r3, String r4, com.larus.bmhome.chat.component.bottom.multimodal.upload.q r5, Continuation<? super AttachmentPanelComponent$handleUploadAttachments$6$1> r6) {
        this.$isFromDrive = r1;
        this.$entity = r2;
        this.this$0 = r3;
        this.$draftLocalMsgId = r4;
        this.$tryAttachmentUploadParam = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AttachmentPanelComponent$handleUploadAttachments$6$1(this.$isFromDrive, this.$entity, this.this$0, this.$draftLocalMsgId, this.$tryAttachmentUploadParam, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [com.larus.bmhome.chat.component.bottom.attachment.z0] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.larus.bmhome.chat.component.bottom.attachment.a1] */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L108:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r14);
        String r2 = "";
        if (this.$isFromDrive == false) goto L96;
        ux9.a r15 = ux9.a.i.c(this.$entity.getFileIdentifier());
        Integer r3 = null;
        List r4 = null;
        r3 = null;
        if (r15 == null) goto L15;
        final ux9.a.c r16 = r15.c();
    L17:
        if (r16 == null) goto L19;
        ux9.a.c.e(r16, AudioAttachmentUploadEvent.Result.WITHOUT_DURATION, null, null, 6);
    L19:
        if (r16 == null) goto L21;
        ux9.a.c.e(r16, AudioAttachmentUploadEvent.Result.REMOTE_CACHE_SKIPPED, null, null, 6);
    L21:
        if (r16 == null) goto L23;
        ux9.a.c.e(r16, AudioAttachmentUploadEvent.Result.UPLOAD_DISPATCHED, null, null, 6);
    L23:
        if (r16 == null) goto L25;
        r16.a(AudioAttachmentUploadEvent.Result.DRIVE_REUSE);
    L25:
        Integer r5 = this.$entity.getUpLinkStatus();
        int r6 = UpLinkState.SUCCESS.getValue();
        if (r5 != null) goto L29;
    L65:
        if (r16 == null) goto L67;
        r16.d();
    L67:
        FlowDriveSdkService r7 = FlowDriveSdkService.a;
        Uri r8 = this.$entity.getUri();
        if (r8 == null) goto L73;
        String r9 = r8.toString();
        if (r9 == null) goto L73;
        String r10 = r9;
    L74:
        UplinkEntityContent r11 = this.$entity.getUplinkEntityContent();
        if (r11 == null) goto L79;
        UplinkFileInfo r12 = r11.getUplinkFileInfo();
        if (r12 == null) goto L79;
        r3 = r12.getFileType();
    L79:
        int r13 = FileType.FileTypeVideo.getValue();
        if (r3 != null) goto L83;
    L86:
        int r17 = FileType.FileTypeAudio.getValue();
        if (r3 != null) goto L90;
    L92:
        FlowDriveFileType r18 = FlowDriveFileType.FILE;
    L93:
        com.larus.platform.api.s r19 = new com.larus.platform.api.s("", r10, 0, r18, null, 244);
        LifecycleCoroutineScope r20 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        final UplinkFileEntity r21 = this.$entity;
        final String r22 = this.$draftLocalMsgId;
        final AttachmentPanelComponent r23 = this.this$0;
        r7.t(r19, r20, new z0(r16, r21, r22, r23), new a1(r16, r22, r21, r23));
    L95:
        return Unit.INSTANCE;
    L90:
        if (r3.intValue() != r17) goto L92;
        r18 = FlowDriveFileType.AUDIO;
        goto L93
    L83:
        if (r3.intValue() != r13) goto L86;
        r18 = FlowDriveFileType.VIDEO;
    L73:
        r10 = "";
        goto L74
    L29:
        if (r5.intValue() != r6) goto L65;
        UplinkEntityContent r24 = this.$entity.getUplinkEntityContent();
        if (r24 == null) goto L33;
        UplinkFileInfo r25 = r24.getUplinkFileInfo();
    L34:
        if (r16 == null) goto L51;
        if (r25 == null) goto L37;
        String r26 = r25.getTosKey();
    L38:
        if (r25 == null) goto L40;
        String r27 = r25.getResourceId();
    L41:
        if (r25 == null) goto L43;
        String r28 = r25.getResourceId();
    L44:
        if (r28 != null) goto L46;
    L49:
        boolean r29 = true;
    L50:
        r16.b(r26, r27, !r29);
        goto L51
    L46:
        if (StringsKt.isBlank(r28) == true) goto L49;
        r29 = false;
        goto L50
    L43:
        r28 = null;
        goto L44
    L40:
        r27 = null;
        goto L41
    L37:
        r26 = null;
    L51:
        z2 r110 = z2.a;
        if (z2.c4() == false) goto L62;
        AttachmentPanelComponent r111 = this.this$0;
        int r30 = AttachmentPanelComponent.g2;
        j1 r31 = r111.Y3();
        if (r31 == null) goto L95;
        String r32 = this.$draftLocalMsgId;
        NestedFileContent r112 = NestedFileCacheManagerService.b.b6(r32);
        if (r112 == null) goto L58;
        r4 = r112.getEntities();
    L58:
        if (r4 != null) goto L60;
        List r33 = CollectionsKt.emptyList();
    L61:
        Boxing.boxBoolean(j1.a.a(r31, r32, null, r33, true, false, null, null, null, this.$entity.getFileIdentifier(), 242));
        goto L95
    L60:
        r33 = r4;
        goto L61
    L62:
        AttachmentPanelComponent r113 = this.this$0;
        int r34 = AttachmentPanelComponent.g2;
        j1 r35 = r113.Y3();
        if (r35 == null) goto L95;
        Boxing.boxBoolean(j1.a.a(r35, this.$draftLocalMsgId, this.$entity, null, false, false, null, null, null, null, 508));
        goto L95
    L33:
        r25 = null;
        goto L34
    L15:
        r16 = null;
        goto L17
    L96:
        AttachmentPanelComponent r114 = this.this$0;
        int r36 = AttachmentPanelComponent.g2;
        r114.getClass();
        AttachmentPanelComponent r115 = this.this$0;
        UplinkFileEntity r37 = this.$entity;
        String r38 = r37.getFileIdentifier();
        if (r38 == null) goto L100;
        r2 = r38;
    L100:
        AttachmentPanelComponent.c r39 = r115.V0.get(r2);
        if (r39 == null) goto L103;
        ns8.b r40 = r39.a;
    L104:
        ns8.b r116 = AttachmentPanelComponent.m3(r115, r37, r40);
        FileUploader r41 = FileUploader.a;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.q r42 = this.$tryAttachmentUploadParam;
        final AttachmentPanelComponent r43 = this.this$0;
        final UplinkFileEntity r44 = this.$entity;
        Function0<Unit> r45 = new b1(r43, r44);
        this.label = 2;
        if (r41.f(r42, r116, r45, this) != r0) goto L108;
        return r0;
    L103:
        r40 = r115.P0;
        goto L104
    }
}
