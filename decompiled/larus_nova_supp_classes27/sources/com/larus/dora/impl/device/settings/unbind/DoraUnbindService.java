package com.larus.dora.impl.device.settings.unbind;

import com.bytedance.dora.device.DoraDevice;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraUnbindService {
    public static final DoraUnbindService a = null;
    public static DoraUnbindStep b;

    public DoraUnbindService() {
    }

    static {
        a = new DoraUnbindService();
        b = DoraUnbindStep.API;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0066 -> B:22:0x0069). Please report as a decompilation issue!!! */
    public final Object a(Continuation<? super DoraUnbindState> r7) {
        if ((r7 instanceof DoraUnbindService$unbind$1) == false) goto L7;
        DoraUnbindService$unbind$1 r0 = (DoraUnbindService$unbind$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        DoraDevice r4 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L22:
        DoraUnbindState r9 = (DoraUnbindState) r8;
        DoraUnbindState r5 = DoraUnbindState.UNBIND_SUCCESS;
        if (r9 == r5) goto L25;
        return r9;
    L25:
        DoraUnbindStep r10 = b.next();
        if (r10 != null) goto L29;
        g49.d.d("DoraUnbindService", "unbind finished");
        b = DoraUnbindStep.API;
        return r5;
    L29:
        b = r10;
    L19:
        g49.d.d("DoraUnbindService", "unbind step: " + b);
        DoraUnbindStep r11 = b;
        r0.L$0 = r4;
        r0.label = 1;
        r8 = r11.step(r4, r0);
        if (r8 != r2) goto L22;
        return r2;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        DoraDevice r12 = kj4.a.g().c();
        if (r12 == null) goto L17;
        r4 = r12;
        goto L19
    L17:
        return DoraUnbindState.NO_DEVICE_CONNECTED;
    L7:
        r0 = new DoraUnbindService$unbind$1(this, r7);
        goto L8
    }
}
