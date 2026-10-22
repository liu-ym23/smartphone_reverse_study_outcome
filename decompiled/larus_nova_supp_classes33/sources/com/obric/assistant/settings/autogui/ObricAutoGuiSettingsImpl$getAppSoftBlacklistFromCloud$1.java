package com.obric.assistant.settings.autogui;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl", f = "ObricAutoGuiSettingsImpl.kt", i = {0, 0, 0, 0}, l = {414}, m = "getAppSoftBlacklistFromCloud", n = {"this_$iv", "methodName$iv", "startTime$iv", "success$iv"}, s = {"L$0", "L$1", "J$0", "I$0"})
final class ObricAutoGuiSettingsImpl$getAppSoftBlacklistFromCloud$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$getAppSoftBlacklistFromCloud$1(ObricAutoGuiSettingsImpl r1, Continuation<? super ObricAutoGuiSettingsImpl$getAppSoftBlacklistFromCloud$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r15) {
        this.result = r15;
        this.label |= Integer.MIN_VALUE;
        ObricAutoGuiSettingsImpl r16 = this.this$0;
        r16.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        ObricAutoGuiSettingsImpl$getAppSoftBlacklistFromCloud$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        boolean r5 = true;
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L15;
        int r17 = r0.I$0;
        long r6 = r0.J$0;
        String r8 = (String) r0.L$1;
        ObricAutoGuiSettingsImpl r7 = (ObricAutoGuiSettingsImpl) r0.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L12
    L21:
        List<com.obric.assistant.settings.r> r18 = ((ObricAutoGuiSettingsImpl$d) r2).b;     // Catch: Throwable -> L12
        long r9 = SystemClock.elapsedRealtime() - r6;
        FLogger.a.i("ObricAutoGuiSettingsImpl", r8 + ", cost = " + r9 + "ms, success = true");
        r7.getClass();
        ObricAutoGuiSettingsImpl.t(r8, r9, true);
        return r18;
    L12:
        th = move-exception;
        long r12 = r6;
        Throwable r10 = th;
        String r11 = r8;
        long r13 = r12;
    L27:
        long r14 = SystemClock.elapsedRealtime() - r13;
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder();
        r20.append(r11);
        r20.append(", cost = ");
        r20.append(r14);
        r20.append("ms, success = ");
        if (r17 == 0) goto L30;
        boolean r21 = true;
    L31:
        r20.append(r21);
        r19.i("ObricAutoGuiSettingsImpl", r20.toString());
        if (r17 != 0) goto L35;
        r5 = false;
    L35:
        r7.getClass();
        ObricAutoGuiSettingsImpl.t(r11, r14, r5);
        throw r10;
    L30:
        r21 = false;
        goto L31
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        r11 = "getAppSoftBlacklistFromCloud";
        r13 = SystemClock.elapsedRealtime();
        r0.L$0 = r16;     // Catch: Throwable -> L25
        r0.L$1 = "getAppSoftBlacklistFromCloud";     // Catch: Throwable -> L25
        r0.J$0 = r13;     // Catch: Throwable -> L25
        r0.I$0 = 0;     // Catch: Throwable -> L25
        r0.label = 1;     // Catch: Throwable -> L25
        Object r22 = r16.o(r16.l(), r0);     // Catch: Throwable -> L25
        if (r22 == r3) goto L41;
        r6 = r13;
        r8 = "getAppSoftBlacklistFromCloud";
        r2 = r22;
        r7 = r16;
        goto L21
    L41:
        return r3;
    L25:
        th = move-exception;
        r10 = th;
        r7 = r16;
        r17 = 0;
        goto L27
    L5:
        r0 = new ObricAutoGuiSettingsImpl$getAppSoftBlacklistFromCloud$1(r16, this);
        goto L6
    }
}
