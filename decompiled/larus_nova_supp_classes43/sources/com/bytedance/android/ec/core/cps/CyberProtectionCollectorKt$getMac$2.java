package com.bytedance.android.ec.core.cps;

import com.bytedance.bpea.cert.token.TokenCert;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Enumeration;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt$getMac$2", f = "CyberProtectionCollector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionCollectorKt$getMac$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    public CyberProtectionCollectorKt$getMac$2(Continuation r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        return new CyberProtectionCollectorKt$getMac$2(r10);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r12);
        int r13 = com.bytedance.bpea.entry.api.device.info.c.a;     // Catch: Throwable -> L32
        Enumeration r14 = com.bytedance.bpea.entry.api.device.info.c.a.a(TokenCert.Companion.with("bpea-commercialize_utils_HardwareUtils_net"));     // Catch: Throwable -> L32
        String r0 = b.n();     // Catch: Throwable -> L32
    L6:
        if (r14 == null) goto L28;
        if (r14.hasMoreElements() != true) goto L28;
        NetworkInterface r1 = (NetworkInterface) r14.nextElement();     // Catch: Throwable -> L32
        byte[] r10 = b.l(r1);     // Catch: Throwable -> L32
        if (r10 == null) goto L6;
        boolean r11 = false;
        if (r10.length != 0) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == true) goto L6;
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L32
        int r17 = r10.length;     // Catch: Throwable -> L32
        int r18 = 0;
    L18:
        if (r18 >= r17) goto L21;
        byte r19 = r10[r18];     // Catch: Throwable -> L32
        StringCompanionObject r20 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L32
        r16.append(String.format("%02X:", Arrays.copyOf(new Object[]{Byte.valueOf(r19)}, 1)));     // Catch: Throwable -> L32
        r18 = r18 + 1;     // Catch: Throwable -> L32
        goto L18
    L21:
        if (r16.length() <= 0) goto L23;
        r11 = true;
    L23:
        if (r11 == false) goto L25;
        r16.deleteCharAt(r16.length() - 1);     // Catch: Throwable -> L32
    L25:
        String r21 = r16.toString();     // Catch: Throwable -> L32
        if (Intrinsics.areEqual(r1.getName(), r0) == false) goto L6;
        return r21;
    L14:
        r15 = false;
    L28:
        return null;
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
