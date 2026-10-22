package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.obric.cae.R;
import com.obric.cae.smartNetwork.trafficMonitor.TrafficMonitorUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<h> f1610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<o> f1611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<h> f1612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f1613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f1614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f1617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f1618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f1622n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Bundle f1623o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1624p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f1625q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f1626r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Notification f1627s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Deprecated
    public final ArrayList<String> f1628t;

    public j(Context r8, String r10) {
        this.f1610b = new ArrayList();
        this.f1611c = new ArrayList();
        this.f1612d = new ArrayList();
        this.f1616h = true;
        this.f1624p = 0;
        Notification r11 = new Notification();
        this.f1627s = r11;
        this.f1609a = r8;
        this.f1625q = r10;
        r11.when = System.currentTimeMillis();
        r11.audioStreamType = -1;
        this.f1615g = 0;
        this.f1628t = new ArrayList();
        this.f1626r = true;
    }

    public static CharSequence c(CharSequence r8) {
        if (r8 != null) goto L5;
        return r8;
    L5:
        if (r8.length() > 5120) goto L7;
        return r8;
    L7:
        return r8.subSequence(0, TrafficMonitorUtil.THRESHOLD_5GB);
    }

    public final void a(String r14, PendingIntent r15) {
        this.f1610b.add(new h(IconCompat.a("", R.drawable.ic_launcher_foreground), r14, r15, new Bundle(), null, null, true, 0, true, false, false));
    }

    public final Notification b() {
        l r8 = new l(this);
        j r10 = r8.f1631b;
        k r11 = r10.f1617i;
        Notification.Builder r12 = r8.f1630a;
        if (r11 == null) goto L5;
        new Notification.BigTextStyle(r12).setBigContentTitle(null).bigText(((i) r11).f1608b);
    L5:
        Notification r13 = r12.build();
        if (r11 == null) goto L8;
        r10.f1617i.getClass();
    L8:
        if (r11 == null) goto L12;
        Bundle r14 = r13.extras;
        if (r14 == null) goto L12;
        r14.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
    L12:
        return r13;
    }

    public final void d(CharSequence r8) {
        this.f1614f = c(r8);
    }

    public final void e(CharSequence r8) {
        this.f1613e = c(r8);
    }

    public final void f(int r8, boolean r10) {
        Notification r11 = this.f1627s;
        if (r10 == false) goto L5;
        int r12 = r8 | r11.flags;
    L6:
        r11.flags = r12;
        return;
    L5:
        int r13 = r11.flags;
        r12 = (~r8) & r13;
        goto L6
    }

    public final void g(i r8) {
        if (this.f1617i == r8) goto L8;
        this.f1617i = r8;
        if (r8.f1629a == this) goto L9;
        r8.f1629a = this;
        g(r8);
        return;
    L9:
        return;
    }
}
