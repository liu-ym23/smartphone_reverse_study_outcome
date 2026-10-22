package b6;

import a6.d;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f885c;

    public a(String r5) {
        this.f884b = j.d();
        this.f883a = ActivityLifeObserver.getInstance().isForeground();
        c6.a.a();
    }

    public final void a(boolean r5, boolean r10) {
        if (this.f884b == false) goto L18;
        boolean r11 = j.f3887a;     // Catch: Throwable -> L7
        throw null;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (j.f3887a == false) goto L12;
        Log.i("<monitor><battery>", f.o(new String[]{"handleTrafficMonitor error: " + th.getCause()}));
    L12:
        if (this.f885c == true) goto L17;
        oo.j.h(th, "BatteryTrafficAllInterface");
        this.f885c = true;
        return;
    L17:
        return;
    }

    public final void b(d r5, m6.a r10) {
        boolean r11 = r10.f20011a;
        long r12 = r10.f;
        if (r11 == false) goto L11;
        if (TextUtils.equals(null, "source_bytes") == false) goto L8;
        r5.f121k += r12;
        return;
    L8:
        if (TextUtils.equals(null, "source_packets") == false) goto L18;
        r5.f122l += r12;
        return;
    L18:
        return;
    L11:
        if (TextUtils.equals(null, "source_bytes") == false) goto L14;
        r5.f129t += r12;
        return;
    L14:
        if (TextUtils.equals(null, "source_packets") == false) goto L21;
        r5.f130u += r12;
        return;
    }
}
