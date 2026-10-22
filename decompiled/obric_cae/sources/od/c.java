package od;

import com.bytedance.applog.monitor.Monitor;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Monitor f9780a = null;

    static {
        f9780a = new Monitor(null, null, "applog_");
    }

    public static void a(String r8, e r10) {
        Monitor r11 = f9780a;
        if (r11 != null) goto L6;
        return;
    L6:
        if ("event_v3".equals(r8) == false) goto L8;
        d[] r12 = d.f9781a;
        r11.record("event_v3", r10.name());
        return;
    L8:
        d[] r13 = d.f9781a;
        r11.record("event", r10.name());
    }
}
