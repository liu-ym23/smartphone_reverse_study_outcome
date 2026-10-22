package nn;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.utils.j;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20272c;
    public final WeakReference d;

    public a(LynxResourceLoader r5, String r10, long r11) {
        super(r10);
        this.d = new WeakReference(r5);
        this.f20272c = r11;
    }

    public final void b(boolean r21, byte[] r22) {
        if (a() == false) goto L22;
        if (r21 == false) goto L14;
        LynxLog.b(2, "LynxResourceLoader", "loadExternalResourceAsync onSuccess.");
        if (r22 != null) goto L9;
    L12:
        int r10 = 30301;
        String r11 = "get null data for provider.";
    L13:
        LynxResourceLoader.nativeInvokeCallback(this.f20272c, r22, 0, null, r10, r11);
        String r5 = null;
        int r12 = r10;
        String r13 = r11;
    L15:
        if (r12 == 0) goto L20;
        LynxResourceLoader r14 = (LynxResourceLoader) this.d.get();
        if (r14 == null) goto L21;
        j.a().post(new com.lynx.tasm.fontface.c(r14, r12, "loadExternalResource", r13, r5, this.f20275b));
        return;
    L21:
        return;
    L20:
        return;
    L9:
        if (r22.length == 0) goto L12;
        r10 = 0;
        r11 = null;
        goto L13
    L14:
        LynxResourceLoader.nativeInvokeCallback(this.f20272c, null, 0, null, 30301, "Error when fetch script: Error when fetch script");
        r13 = "Error when fetch script";
        r5 = r13;
        r12 = 30301;
        goto L15
    }
}
