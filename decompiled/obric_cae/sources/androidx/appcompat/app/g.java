package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.obric.cae.CaeReceiver;
import com.obric.cae.utils.ALogUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f647b;

    public /* synthetic */ g(Context r8, int r10) {
        this.f646a = r10;
        this.f647b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f646a;
        Context r10 = this.f647b;
        switch(r8) {
            case 0: goto L10;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L38;
        };
    L5:
        CaeReceiver.b(r10);
        return;
    L7:
        androidx.profileinstaller.c.b(r10, new v0.d(1), androidx.profileinstaller.c.f2224a, false);
        return;
    L38:
        ALogUtil.a(r10);
        return;
    L10:
        if (Build.VERSION.SDK_INT < 33) goto L36;
        ComponentName r11 = new ComponentName(r10, "androidx.appcompat.app.AppLocalesMetadataHolderService");
        if (r10.getPackageManager().getComponentEnabledSetting(r11) == 1) goto L36;
        if (f0.a.a() == false) goto L26;
        Iterator<WeakReference<h>> r12 = h.f654q.iterator();
    L16:
        n.g.a r13 = (n.g.a) r12;
        if (r13.hasNext() == false) goto L23;
        h r14 = (h) ((WeakReference) r13.next()).get();
        if (r14 == null) goto L16;
        Context r15 = r14.f();
        if (r15 == null) goto L16;
        Object r16 = r15.getSystemService("locale");
    L24:
        if (r16 == null) goto L29;
        f0.e r17 = new f0.e(new f0.g(h.b.a(r16)));
    L31:
        if (r17.f7237a.isEmpty() == false) goto L35;
        String r18 = s.b(r10);
        Object r19 = r10.getSystemService("locale");
        if (r19 == null) goto L35;
        h.b.b(r19, h.a.a(r18));
    L35:
        r10.getPackageManager().setComponentEnabledSetting(r11, 1, 1);
    L29:
        r17 = f0.e.f7236b;
        goto L31
    L23:
        r16 = null;
        goto L24
    L26:
        r17 = h.f650m;
        if (r17 == null) goto L29;
    L36:
        h.f653p = true;
    }
}
