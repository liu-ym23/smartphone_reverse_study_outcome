package com.lynx.tasm.behavior.ui.krypton;

import androidx.annotation.Keep;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c;
import com.lynx.tasm.u;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LynxKryptonModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f10497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f10498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxKryptonHelper f10499c;
    public long d;

    @Keep
    public LynxKryptonModule(LynxContext r5, u r10, c r11) {
        this.f10497a = r5;
        this.f10498b = r10;
        this.d = 0;
        this.f10499c = new LynxKryptonHelper();
        this.d = nativeCreate();
        LynxLog.b(2, "LynxKryptonModule", "LynxKryptonModule create");
    }

    private native long nativeCreate();

    private native void nativeDestroy(long r5);

    private native long nativeGetExtensionDelegatePtr(long r5, long r10);

    public final void a() {
        CanvasRuntimeMediator r5 = this.f10499c.f10495a;
        nativeDestroy(this.d);
        this.d = 0;
    }

    public final long b() {
        if (this.d != 0) goto L6;
        LynxLog.b(4, "LynxKryptonModule", "native ptr is 0");
        return 0;
    L6:
        CanvasRuntimeMediator r5 = new CanvasRuntimeMediator(this.f10497a);
        LynxKryptonHelper r10 = this.f10499c;
        r10.getClass();
        LynxLog.b(2, "LynxKryptonHelper", "[Krypton] Register new CanvasRuntimeMediator." + r5);
        r10.f10495a = r5;
        Iterator r11 = r10.f10496b.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) r11.next();
        CanvasRuntimeMediator r13 = r10.f10495a;
        r13.f10493a.put((Class) r12.getKey(), r12.getValue());
        goto L8
    L10:
        long r14 = r5.a();
        if (r14 != 0) goto L14;
        LynxLog.b(4, "LynxKryptonModule", "mediator ptr is 0");
        return 0;
    L14:
        long r15 = nativeGetExtensionDelegatePtr(this.d, r14);
        r5.b(r14);
        return r15;
    }
}
