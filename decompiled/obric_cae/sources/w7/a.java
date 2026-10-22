package w7;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f13030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f13031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f13033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f13034f;

    /* JADX INFO: renamed from: w7.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0188a implements b {
    }

    public interface b {
    }

    public interface c {
    }

    public a(Context r8, t7.a.C0162a r10, t7.a.b r11) {
        this.f13030b = r10;
        this.f13033e = r11;
        String r12 = android.aimedia.a.i(new StringBuilder(), r10.f12292a, "sdk_monitor");
        this.f13029a = r12;
        if (TextUtils.isEmpty(r12) == true) goto L21;
        if (d.f13042e == null) goto L7;
    L16:
        d r13 = d.f13042e;
        this.f13031c = r13;
        if (r13.f13045c.get() == true) goto L24;
        r13.f13043a.put(r12, this);
        return;
    L24:
        return;
    L7:
        monitor-enter(d.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (d.f13042e != null) goto L11;
        d.f13042e = new d(r8);     // Catch: Throwable -> L13
    L11:
        monitor-exit(d.class);     // Catch: Throwable -> L13
        goto L16
    L21:
        throw new IllegalArgumentException("type is empty.");
    }

    public abstract boolean a(String r8, byte[] r10);
}
