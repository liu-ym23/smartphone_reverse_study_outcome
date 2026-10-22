package l7a;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends c {
    public final long c;
    public final WeakReference<LynxResourceLoader> d;

    public a(LynxResourceLoader r1, String r2, long r3) {
        super(r2);
        this.d = new WeakReference(r1);
        this.c = r3;
    }

    public final void b(boolean r9, byte[] r10, String r11) {
        if (a() == true) goto L5;
        return;
    L5:
        int r0 = 30301;
        if (r9 == false) goto L15;
        LLog.i("LynxResourceLoader", "loadExternalResourceAsync onSuccess.");
        if (r10 != null) goto L10;
    L13:
        String r12 = "get null data for provider.";
    L14:
        LynxResourceLoader.a(this.c, r10, r0, r12);
        String r5 = r12;
        int r3 = r0;
        String r6 = null;
    L16:
        if (r3 == 0) goto L21;
        LynxResourceLoader r2 = this.d.get();
        if (r2 == null) goto L22;
        UIThreadUtils.runOnUiThread(new d(r2, r3, "loadExternalResource", r5, r6, this.b));
        return;
    L22:
        return;
    L21:
        return;
    L10:
        if (r10.length == 0) goto L13;
        r0 = 0;
        r12 = null;
        goto L14
    L15:
        LynxResourceLoader.a(this.c, null, 30301, "Error when fetch script: " + r11);
        r5 = "Error when fetch script";
        r6 = r11;
        r3 = 30301;
        goto L16
    }
}
