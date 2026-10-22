package com.bytedance.android.ec.core.cps;

import com.bytedance.common.profilesdk.util.CmdUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt$runShell$2", f = "CyberProtectionCollector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionCollectorKt$runShell$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String[] $cmd;
    int label;

    public CyberProtectionCollectorKt$runShell$2(String[] r1, Continuation r10) {
        this.$cmd = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new CyberProtectionCollectorKt$runShell$2(this.$cmd, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r10);
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L19
        InputStream r0 = CmdUtils.exec(this.$cmd).getInputStream();     // Catch: Exception -> L19
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r0));     // Catch: Exception -> L19
    L23:
        String r12 = r1.readLine();     // Catch: Throwable -> L14
        if (r12 == null) goto L8;
        r11.append(r12);     // Catch: Throwable -> L14
    L8:
        if (r0 == null) goto L10;
        r0.close();     // Catch: Exception -> L19
    L10:
        r1.close();     // Catch: Exception -> L19
        return r11.toString();
    L14:
        th = move-exception;
        if (r0 == null) goto L17;
        r0.close();     // Catch: Exception -> L19
    L17:
        r1.close();     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L19:
        return null;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
