package s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<b> f12714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f12716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static c f12717d;

    /* JADX INFO: renamed from: s.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0289a {
    }

    public interface b {
        void a(boolean r10);
    }

    private static class c extends BroadcastReceiver {
        private c() {
        }

        /* synthetic */ c(C0289a r10) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            String r12 = r11.getAction();
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(r12) == false) goto L9;
            a.b(true);
            Iterator r13 = a.c().iterator();
        L6:
            if (r13.hasNext() == false) goto L17;
            ((b) r13.next()).a(a.a());
            goto L6
        L17:
            return;
        L9:
            if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(r12) == false) goto L14;
            a.b(false);
            Iterator r14 = a.c().iterator();
        L12:
            if (r14.hasNext() == false) goto L18;
            ((b) r14.next()).a(a.a());
            goto L12
        L18:
            return;
        }
    }

    static {
        f12714a = new ArrayList();
        f12715b = false;
    }

    static /* synthetic */ boolean a() {
        return f12716c;
    }

    static /* synthetic */ boolean b(boolean r10) {
        f12716c = r10;
        return r10;
    }

    static /* synthetic */ List c() {
        return f12714a;
    }

    public static boolean d(Context r10, b r11) {
        if (r11 == null) goto L9;
        f12714a.add(r11);
        if (f12715b == true) goto L7;
        f(r10);
        f12715b = true;
    L7:
        return f12716c;
    L9:
        throw new IllegalArgumentException("chargeListener can't be null");
    }

    public static boolean e(Context r10) {
        if (f12715b == true) goto L5;
        Intent r11 = r10.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r11 == null) goto L15;
        int r12 = r11.getIntExtra("status", -1);
        if (r12 != 2) goto L11;
        return true;
    L11:
        if (r12 == 5) goto L17;
        return false;
    L17:
        return true;
    L15:
        return true;
    L5:
        return f12716c;
    }

    private static void f(Context r10) {
        IntentFilter r11 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");     // Catch: Throwable -> L4
        r11.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");     // Catch: Throwable -> L4
        c r12 = new c(null);     // Catch: Throwable -> L4
        f12717d = r12;     // Catch: Throwable -> L4
        r10.registerReceiver(r12, r11);     // Catch: Throwable -> L4
        f12716c = e(r10);     // Catch: Throwable -> L4
        return;
    L4:
        f12716c = true;
    }

    public static void g(Context r10, b r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        f12714a.remove(r11);
        if (f12714a.isEmpty() == false) goto L12;
        r10.unregisterReceiver(f12717d);     // Catch: Throwable -> L9
    L7:
        f12715b = false;
        return;
    }
}
