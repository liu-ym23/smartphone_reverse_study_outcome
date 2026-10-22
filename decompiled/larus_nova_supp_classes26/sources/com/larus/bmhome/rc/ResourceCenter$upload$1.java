package com.larus.bmhome.rc;

import com.larus.platform.model.upload.ResourceUploadError;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.rc.ResourceCenter$upload$1", f = "ResourceCenter.kt", i = {0}, l = {250}, m = "invokeSuspend", n = {"wrappedParam"}, s = {"L$0"})
final class ResourceCenter$upload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $param;
    final /* synthetic */ Function1<j, Unit> $uploadToTos;
    Object L$0;
    int label;

    public ResourceCenter$upload$1(j r1, Function1<? super j, Unit> r2, Continuation<? super ResourceCenter$upload$1> r3) {
        this.$param = r1;
        this.$uploadToTos = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ResourceCenter$upload$1(this.$param, this.$uploadToTos, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.bmhome.rc.c] */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.larus.bmhome.rc.d] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.bmhome.rc.b] */
    public final Object invokeSuspend(Object r15) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r4 = "";
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        j r3 = (j) this.L$0;
        ResultKt.throwOnFailure(r15);
    L18:
        PrepareUploadResult r16 = (PrepareUploadResult) r15;
        if (r16.getResourceUploadToken() == null) goto L21;
        ms8.b.c(ms8.b.a, this.$param, "prepare_upload", "success", null, null, 24);
        r3.h = r16.getResourceUploadToken();
        this.$uploadToTos.invoke(r3);
    L29:
        return Unit.INSTANCE;
    L21:
        String r17 = r16.getFailReason();
        if (r17 == null) goto L25;
        r4 = r17;
    L25:
        ResourceUploadError r5 = new ResourceUploadError("upload_get_auth_token_error", r4);
        ms8.b r18 = ms8.b.a;
        ms8.b.c(r18, this.$param, "prepare_upload", "fail", r5, null, 16);
        this.$param.f.invoke(r5);     // Catch: Throwable -> L30
        ms8.b.g(r18, this.$param, "callback_fail", "fail", null, r5, 40);
        ms8.b.d(r18, this.$param, "fail", r5, 8);
    L30:
        th = move-exception;
        ms8.b r10 = ms8.b.a;
        ms8.b.g(r10, this.$param, "callback_fail", "fail", null, r5, 40);
        ms8.b.d(r10, this.$param, "fail", r5, 8);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        j r6 = this.$param;
        a r19 = new a(r6.d, r6.e, r6.f);
        ConcurrentHashMap<String, String> r7 = ResourceCenter.d;
        String r8 = r7.get(this.$param.l);
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        ResourceCenter r9 = ResourceCenter.a;
        final j r11 = this.$param;
        CoroutineScope r12 = ResourceCenter.c;
        j r13 = this.$param;
        mr9.h r14 = r13.o;
        final ResourceCenterUploadDelegate r20 = new ResourceCenterUploadDelegate(r12, new h(r13, r14.b, r14.c, r8), r19);
        r9.getClass();
        j r110 = j.a(r11, null, new b(r11, r20), new c(r20), new d(r20), null, 2097095);
        ms8.b r21 = ms8.b.a;
        j r22 = this.$param;
        r21.getClass();
        ms8.b.i(r22, "prepare_upload");
        j r23 = this.$param;
        this.L$0 = r110;
        this.label = 1;
        String r24 = r7.get(r23.l);
        if (r24 != null) goto L14;
        r24 = "";
    L14:
        Object r25 = r9.j(com.larus.bmhome.upload.a.a(r23), r24, this);
        if (r25 != r1) goto L17;
        return r1;
    L17:
        r3 = r110;
        r15 = r25;
        goto L18
    }
}
