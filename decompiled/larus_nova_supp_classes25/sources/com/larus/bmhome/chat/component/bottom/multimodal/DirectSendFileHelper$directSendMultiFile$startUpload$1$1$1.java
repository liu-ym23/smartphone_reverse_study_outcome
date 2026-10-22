package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.action.DirectSendData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import ns8.b;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.DirectSendFileHelper$directSendMultiFile$startUpload$1$1$1", f = "DirectSendFileHelper.kt", i = {}, l = {DoraCallStateCode.DOUBAO_FOCUS_CHANGED, DoraCallStateCode.DOUBAO_STOP_SI_BY_NOTIFICATION, DoraCallStateCode.RTOS_STOP_SI_BY_GESTURE}, m = "invokeSuspend", n = {}, s = {})
public final class DirectSendFileHelper$directSendMultiFile$startUpload$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DirectSendData $directSendData;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ b $processConfig;
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.q $tryFileUploadParam;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.DirectSendFileHelper$directSendMultiFile$startUpload$1$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.DirectSendFileHelper$directSendMultiFile$startUpload$1$1$1$1", f = "DirectSendFileHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DirectSendData $directSendData;
        int label;

        public AnonymousClass1(DirectSendData r1, Continuation<? super AnonymousClass1> r2) {
            this.$directSendData = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$directSendData, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r3);
            DirectSendData r4 = this.$directSendData;
            if (r4 == null) goto L12;
            t1a.b r5 = r4.getVContext();
            if (r5 == null) goto L12;
            com.larus.bmhome.chat.component.bottom.attachment.g1 r6 = r5.getAbility(com.larus.bmhome.chat.component.bottom.attachment.g1.class);
            if (r6 == null) goto L12;
            com.larus.bmhome.chat.component.bottom.attachment.g1.a.a(r6, null, 7);
        L12:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DirectSendFileHelper$directSendMultiFile$startUpload$1$1$1(UplinkFileEntity r1, b r2, com.larus.bmhome.chat.component.bottom.multimodal.upload.q r3, DirectSendData r4, Continuation<? super DirectSendFileHelper$directSendMultiFile$startUpload$1$1$1> r5) {
        this.$entity = r1;
        this.$processConfig = r2;
        this.$tryFileUploadParam = r3;
        this.$directSendData = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DirectSendFileHelper$directSendMultiFile$startUpload$1$1$1(this.$entity, this.$processConfig, this.$tryFileUploadParam, this.$directSendData, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r13);
    L43:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);
    L39:
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$directSendData, null);
        this.label = 3;
        if (BuildersKt.withContext(r14, r2, this) != r0) goto L43;
        return r0;
    L11:
        ResultKt.throwOnFailure(r13);
    L25:
        Map<String, List<String>> r15 = DirectSendFileHelper.a;
        DirectSendData r16 = this.$directSendData;
        List r3 = CollectionsKt.listOf(this.$entity);
        if (r16 == null) goto L36;
        t1a.b r17 = r16.getVContext();
        if (r17 == null) goto L36;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r18 = r17.getAbility(com.larus.bmhome.chat.component.bottom.attachment.g1.class);
        if (r18 == null) goto L36;
        Iterator r4 = r3.iterator();
    L34:
        if (r4.hasNext() == false) goto L36;
        r18.bD((UplinkFileEntity) r4.next());
    L36:
        this.label = 2;
        if (DelayKt.delay(200, this) != r0) goto L39;
        return r0;
    L12:
        ResultKt.throwOnFailure(r13);
        if (n1.e(this.$entity) == false) goto L16;
        ResourceCenter r19 = ResourceCenter.a;
        String r5 = this.$entity.getFileIdentifier();
        FlowResourceScene r6 = FlowResourceScene.VideoUpload;
        r19.getClass();
        ResourceCenter.k(r5, r6);
    L16:
        if (Intrinsics.areEqual(this.$entity.isOriginalImageChecked(), Boxing.boxBoolean(true)) == false) goto L21;
        b r110 = this.$processConfig;
        if (r110 == null) goto L20;
        b r111 = b.a(r110, true, false, 126);
    L22:
        FileUploader r7 = FileUploader.a;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.q r8 = this.$tryFileUploadParam;
        this.label = 1;
        if (FileUploader.g(r8, r111, this, 4) != r0) goto L25;
        return r0;
    L20:
        r111 = new b(true, false, false, false, false, 126);
        goto L22
    L21:
        r111 = this.$processConfig;
        goto L22
    }
}
