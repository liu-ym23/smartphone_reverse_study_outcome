package com.larus.bmhome.view.actionbar.edit.component;

import android.app.Application;
import android.net.Uri;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.utils.logger.FLogger;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.ReferenceImageUploadWidget$tryReferenceImageUpload$1", f = "ReferenceImageUploadWidget.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3}, l = {318, 321, 326, 336}, m = "invokeSuspend", n = {"$this$launch", "tempUploaderIdentifier", "$this$launch", "tempUploaderIdentifier", "processResult", "$this$launch", "tempUploaderIdentifier", "processResult", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0"})
final class ReferenceImageUploadWidget$tryReferenceImageUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ReferenceImageUploadWidget this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.component.ReferenceImageUploadWidget$tryReferenceImageUpload$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.ReferenceImageUploadWidget$tryReferenceImageUpload$1$1", f = "ReferenceImageUploadWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            t19.s r3 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            r3.getClass();
            t19.s.s(r0, 2131906513);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.component.ReferenceImageUploadWidget$tryReferenceImageUpload$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.ReferenceImageUploadWidget$tryReferenceImageUpload$1$2", f = "ReferenceImageUploadWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ic8.n0 $processResult;
        int label;
        final /* synthetic */ ReferenceImageUploadWidget this$0;

        public AnonymousClass2(ReferenceImageUploadWidget r1, ic8.n0 r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$processResult = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$processResult, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            v1 r3 = this.this$0.g;
            if (r3 == null) goto L7;
            r3.b(this.$processResult);
            return Unit.INSTANCE;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ReferenceImageUploadWidget$tryReferenceImageUpload$1(Uri r1, ReferenceImageUploadWidget r2, Continuation<? super ReferenceImageUploadWidget$tryReferenceImageUpload$1> r3) {
        this.$uri = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ReferenceImageUploadWidget$tryReferenceImageUpload$1 r0 = new ReferenceImageUploadWidget$tryReferenceImageUpload$1(this.$uri, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r39) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r39);
    L47:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ic8.n0 r2 = (ic8.n0) this.L$2;
        final String r3 = (String) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r39);
    L26:
        ProcessFileResultCode r5 = r2.b;
        if (r5 != null) goto L29;
    L31:
        boolean r6 = false;
    L32:
        if (r6 == true) goto L35;
        FLogger.a.w("ReferenceImageUploadWidget", "tryAttachmentUpload ProcessResult for not Success");
        return Unit.INSTANCE;
    L35:
        ic8.m0 r7 = r2.a;
        if (r7 == null) goto L45;
        String r8 = r7.e;
        if (r8 == null) goto L45;
        final ReferenceImageUploadWidget r10 = this.this$0;
        this.L$0 = r4;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 4;
        int r11 = ReferenceImageUploadWidget.k;
        r10.getClass();
        String r27 = r3;
        Object r12 = ResourceUploader.a.j(new mr9.j(r8, "bot_chat", UploadDataType.IMAGE, new x1(r10, r3), new y1(r10, r3), new z1(r3, r10), false, null, null, null, r27, false, new CountDownLatch(1), null, null, null, null, null, null, null, 2081728), this);
        if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L43;
        r12 = Unit.INSTANCE;
    L43:
        if (r12 != r9) goto L47;
        return r9;
    L45:
        FLogger.a.w("ReferenceImageUploadWidget", "tryAttachmentUpload localAppPath is null");
        goto L47
    L29:
        if (r5.isSuccess() != true) goto L31;
        r6 = true;
        goto L32
    L12:
        r2 = (ic8.n0) this.L$2;
        r3 = (String) this.L$1;
        r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r39);
    L23:
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        AnonymousClass2 r14 = new AnonymousClass2(this.this$0, r2, null);
        this.L$0 = r4;
        this.L$1 = r3;
        this.L$2 = r2;
        this.label = 3;
        if (BuildersKt.withContext(r13, r14, this) != r9) goto L26;
        return r9;
    L13:
        String r15 = (String) this.L$1;
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r39);
        r4 = r16;
        r3 = r15;
        Object r17 = r39;
    L18:
        r2 = (ic8.n0) r17;
        if (r2.b != ProcessFileResultCode.PREPARE_OVER_SIZE) goto L23;
        FLogger.a.w("ReferenceImageUploadWidget", "tryAttachmentUpload ProcessResult for OverSize");
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        AnonymousClass1 r19 = new AnonymousClass1(null);
        this.L$0 = r4;
        this.L$1 = r3;
        this.L$2 = r2;
        this.label = 2;
        if (BuildersKt.withContext(r18, r19, this) != r9) goto L23;
        return r9;
    L14:
        ResultKt.throwOnFailure(r39);
        CoroutineScope r20 = (CoroutineScope) this.L$0;
        String r21 = UUID.randomUUID().toString();
        IAIChatUploadMediaService.Companion r22 = IAIChatUploadMediaService.a;
        Uri r23 = this.$uri;
        this.L$0 = r20;
        this.L$1 = r21;
        this.label = 1;
        r17 = IAIChatUploadMediaService.a.a(r22, r23, null, false, false, null, this, 56);
        if (r17 != r9) goto L17;
        return r9;
    L17:
        r3 = r21;
        r4 = r20;
        goto L18
    }
}
