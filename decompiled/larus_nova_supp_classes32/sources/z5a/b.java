package z5a;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public WeakReference<LynxContext> a;
    public WeakReference<LynxBackgroundRuntime> b;

    public b() {
        this.a = new WeakReference(null);
        this.b = new WeakReference(null);
    }

    public final void a(String r2, JavaOnlyArray r3) {
        LynxContext r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.sendGlobalEvent(r2, r3);
        return;
    L6:
        LynxBackgroundRuntime r1 = this.b.get();
        if (r1 == null) goto L10;
        r1.f(r2, r3);
        return;
    }
}
