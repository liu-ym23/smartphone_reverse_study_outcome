package l7a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.core.resource.LynxResourceLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ LynxResourceLoader f;

    public final void a() {
        com.lynx.tasm.i r0 = this.f.e.get();
        if (r0 != null) goto L5;
        return;
    L5:
        LynxError r1 = new LynxError(this.a, String.format("%s %s failed, the error message is: %s", new Object[]{"LynxResourceLoader", this.b, this.c}), LynxError.LYNX_ERROR_SUGGESTION_REF_OFFICIAL_SITE, "error");
        r1.setRootCause(this.d);
        r1.addCustomInfo(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, this.e);
        r0.onErrorOccurred(r1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(LynxResourceLoader r1, int r2, String r3, String r4, String r5, String r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
