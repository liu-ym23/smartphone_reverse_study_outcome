package com.larus.drive.sdk.impl.component.chat;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadDelegate;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.c;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import ic8.n0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/UplinkFileEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$materializePreviewAttachment$2", f = "DriveChatReceiveComponent.kt", i = {}, l = {701}, m = "invokeSuspend", n = {}, s = {})
final class DriveChatReceiveComponent$materializePreviewAttachment$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UplinkFileEntity>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ UplinkFileEntity $entity;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ DriveChatReceiveComponent this$0;

    public static final class a implements c {
        public final /* synthetic */ Ref.ObjectRef<UplinkFileEntity> a;

        public final void b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "localMsgId");
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        }

        public a(Ref.ObjectRef<UplinkFileEntity> r1) {
            this.a = r1;
        }

        public final UplinkFileEntity a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "localMsgId");
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            return (UplinkFileEntity) this.a.element;
        }

        public final void c(String r2, UplinkFileEntity r3) {
            Intrinsics.checkNotNullParameter(r2, "localMsgId");
            Intrinsics.checkNotNullParameter(r3, "entity");
            this.a.element = r3;
        }

        public final void e(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "localMsgId");
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            ((UplinkFileEntity) this.a.element).setUpLinkStatus(Integer.valueOf(UpLinkState.FAIL.getValue()));
        }

        public final void g(String r2, UplinkFileEntity r3) {
            Intrinsics.checkNotNullParameter(r2, "localMsgId");
            Intrinsics.checkNotNullParameter(r3, "entity");
            this.a.element = r3;
        }

        public final void f(String r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "localMsgId");
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            ((UplinkFileEntity) this.a.element).setUpLinkProcess(Integer.valueOf(r4));
            ((UplinkFileEntity) this.a.element).setUpLinkStatus(Integer.valueOf(UpLinkState.PROCESSING.getValue()));
        }

        public final void d(String r9, UplinkFileEntity r10, String r11, mr9.l r12, Boolean r13, Boolean r14) {
            Intrinsics.checkNotNullParameter(r9, "localMsgId");
            Intrinsics.checkNotNullParameter(r10, "entity");
            Intrinsics.checkNotNullParameter(r11, "fileIdentifier");
            Intrinsics.checkNotNullParameter(r12, "uploadResult");
            this.a.element = r10;
            UplinkEntityContent r15 = r10.getUplinkEntityContent();
            if (r15 == null) goto L14;
            Image r16 = r15.getUplinkImageInfo();
            if (r16 == null) goto L14;
            Ref.ObjectRef<UplinkFileEntity> r17 = this.a;
            r16.key = r12.a;
            r16.md5 = l1.e((UplinkFileEntity) r17.element);
            r16.resourceId = r12.c;
            mr9.d r18 = r12.d;
            if (r18 == null) goto L9;
            int r2 = r18.b;
        L10:
            if (r18 == null) goto L12;
            int r3 = r18.a;
        L13:
            r16.imageOri = new ImageObj(null, r2, r3, null, null, 25, null);
            r16.setMarked(r13);
            r16.setCropped(r14);
            goto L14
        L12:
            r3 = 0;
            goto L13
        L9:
            r2 = 0;
        L14:
            UplinkEntityContent r20 = ((UplinkFileEntity) this.a.element).getUplinkEntityContent();
            if (r20 == null) goto L19;
            UplinkFileInfo r21 = r20.getUplinkFileInfo();
            if (r21 == null) goto L19;
            Ref.ObjectRef<UplinkFileEntity> r110 = this.a;
            r21.setTosKey(r12.a);
            r21.setMd5(l1.e((UplinkFileEntity) r110.element));
            r21.setResourceId(r12.c);
        L19:
            UplinkFileEntity r22 = (UplinkFileEntity) this.a.element;
            ResourceUploadInstantInfo r111 = r12.g;
            if (r111 == null) goto L22;
            String r112 = GsonProtectorUtils.toJson(new Gson(), r111);
        L23:
            r22.setInstantUploadInfoJson(r112);
            ((UplinkFileEntity) this.a.element).setUpLinkProcess(100);
            ((UplinkFileEntity) this.a.element).setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
            return;
        L22:
            r112 = null;
            goto L23
        }
    }

    public static final class b implements com.larus.bmhome.chat.component.bottom.multimodal.upload.m {
        public final /* synthetic */ com.larus.bmhome.chat.component.bottom.multimodal.upload.m a;
        public final /* synthetic */ kotlinx.coroutines.i<UplinkFileEntity> b;
        public final /* synthetic */ Ref.ObjectRef<UplinkFileEntity> c;

        public final void c(boolean r2) {
            this.a.c(r2);
            if (r2 == true) goto L5;
            return;
        L5:
            if (this.b.isActive() == false) goto L9;
            this.b.resumeWith(Result.constructor-impl(null));
            return;
        }

        public final void d(n0 r3) {
            Intrinsics.checkNotNullParameter(r3, "processResult");
            this.a.d(r3);
            ProcessFileResultCode r4 = r3.b;
            boolean r0 = false;
            if (r4 != null) goto L5;
        L7:
            if (r0 == false) goto L9;
            return;
        L9:
            if (this.b.isActive() == false) goto L13;
            this.b.resumeWith(Result.constructor-impl(null));
            return;
        L13:
            return;
        L5:
            if (r4.isSuccess() != true) goto L7;
            r0 = true;
            goto L7
        }

        public final void a(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
            this.a.a(r2, r4);
        }

        public final void b(mr9.l r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "uploadResult");
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            this.a.b(r2, r3);
            if (this.b.isActive() == false) goto L6;
            kotlinx.coroutines.i<UplinkFileEntity> r4 = this.b;
            Result.Companion r5 = Result.Companion;
            r4.resumeWith(Result.constructor-impl(this.c.element));
            return;
        }

        public b(com.larus.bmhome.chat.component.bottom.multimodal.upload.m r1, kotlinx.coroutines.j r2, Ref.ObjectRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void e(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            this.a.e(r2, r3, r4);
            if (this.b.isActive() == false) goto L6;
            this.b.resumeWith(Result.constructor-impl(null));
            return;
        }
    }

    public DriveChatReceiveComponent$materializePreviewAttachment$2(UplinkFileEntity r1, String r2, String r3, DriveChatReceiveComponent r4, Continuation<? super DriveChatReceiveComponent$materializePreviewAttachment$2> r5) {
        this.$entity = r1;
        this.$conversationId = r2;
        this.$botId = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DriveChatReceiveComponent$materializePreviewAttachment$2(this.$entity, this.$conversationId, this.$botId, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super UplinkFileEntity> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        DriveChatReceiveComponent r3 = (DriveChatReceiveComponent) this.L$3;
        String r4 = (String) this.L$2;
        String r5 = (String) this.L$1;
        UplinkFileEntity r6 = (UplinkFileEntity) this.L$0;
        ResultKt.throwOnFailure(r25);
        return r25;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r25);
        UplinkFileEntity r7 = this.$entity;
        String r15 = this.$conversationId;
        String r14 = this.$botId;
        DriveChatReceiveComponent r13 = this.this$0;
        this.L$0 = r7;
        this.L$1 = r15;
        this.L$2 = r14;
        this.L$3 = r13;
        this.label = 1;
        kotlinx.coroutines.j r12 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r12.C();
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = r7;
        a r10 = new a(r11);
        FileUploadDelegate r8 = FileUploadDelegate.b;
        String r9 = r7.getFileIdentifier();
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        b r16 = new b(r8.c(r9, r7, r15, r14, true, "file", null, null, null, null, r10), r12, r11);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r13), Dispatchers.getIO(), null, new DriveChatReceiveComponent$materializePreviewAttachment$2$1$1(r15, r16, r7, r14, r12, null), 2, null);
        Object r17 = r12.B();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(this);
    L14:
        if (r17 != r1) goto L17;
        return r1;
    L17:
        return r17;
    }
}
