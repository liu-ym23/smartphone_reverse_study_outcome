package com.bytedance.android.ec.core.cps;

import com.bytedance.security.Sword.Sword;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionInjectorKt$encodeByBDSword$2", f = "CyberProtectionInjector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionInjectorKt$encodeByBDSword$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $data;
    int label;

    public CyberProtectionInjectorKt$encodeByBDSword$2(String r1, Continuation r10) {
        this.$data = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new CyberProtectionInjectorKt$encodeByBDSword$2(this.$data, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r10);
        String r11 = this.$data;
        Charset r0 = Charsets.UTF_8;
        if (r11 == null) goto L17;
        byte[] r12 = r11.getBytes(r0);
        String r13 = Sword.clientPackedBase64(r12, r12.length);
        if (r13 != null) goto L9;
    L14:
        return null;
    L9:
        if (r13.length() <= 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return r13;
    L11:
        r1 = false;
        goto L12
    L17:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
