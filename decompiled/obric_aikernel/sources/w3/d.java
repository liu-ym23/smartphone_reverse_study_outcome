package w3;

import android.app.Service;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements Handler.Callback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static d f13324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static c f13325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Map<IBinder, Service> f13326i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler.Callback f13327c;

    static {
        f13324g = new d();
        f13325h = null;
    }

    private d() {
    }

    public static void a() {
        f13325h = null;
    }

    public static c b() {
        return f13325h;
    }

    public static d c() {
        return f13324g;
    }

    public synchronized String d(IBinder r10) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (f13326i == null) goto L20;
    L6:
        Map<IBinder, Service> r11 = f13326i;     // Catch: Throwable -> L14
        String r12 = null;
        if (r11 != null) goto L9;
    L12:
        monitor-exit(this);
        return r12;
    L9:
        if (r11.get(r10) == null) goto L12;
        r12 = f13326i.get(r10).getClass().getName();     // Catch: Throwable -> L14
        goto L12
    L20:
        Object r13 = x3.a.c();     // Catch: Throwable -> L17
        f13326i = (Map) a.a(r13.getClass(), "mServices").get(r13);     // Catch: Throwable -> L17
        goto L6
    }

    public void e() {
        Handler r10 = (Handler) x3.a.f();     // Catch: Throwable -> L4
        Field r11 = a.a(Handler.class, "mCallback");     // Catch: Throwable -> L4
        this.f13327c = (Handler.Callback) r11.get(r10);     // Catch: Throwable -> L4
        r11.set(r10, this);     // Catch: Throwable -> L4
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        if (b.a(r10) == false) goto L5;
        f13325h = c.a(r10);     // Catch: Throwable -> L11
    L5:
        Handler.Callback r11 = this.f13327c;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.handleMessage(r10);
    }
}
