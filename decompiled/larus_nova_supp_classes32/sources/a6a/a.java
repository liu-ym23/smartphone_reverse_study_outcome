package a6a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.LynxEngineProxy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Runnable {
    public final /* synthetic */ WeakReference a;
    public final /* synthetic */ WeakReference b;
    public final /* synthetic */ ReadableMap c;
    public final /* synthetic */ String d;

    @Override // java.lang.Runnable
    public final void run() {
        LynxModuleWrapper r0 = (LynxModuleWrapper) this.a.get();     // Catch: Throwable -> L8
        LynxEngineProxy r1 = (LynxEngineProxy) this.b.get();     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        b.a(r0, r1, this.c, this.d);     // Catch: Throwable -> L8
    L13:
        return;
    L6:
        LLog.i("LynxLepusModule", "triggerLepusBridgeAsync failed, LynxModule or LynxEngine has been released.");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public a(WeakReference r1, WeakReference r2, ReadableMap r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
