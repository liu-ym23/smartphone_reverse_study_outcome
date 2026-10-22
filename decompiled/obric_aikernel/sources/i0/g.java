package i0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f9347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9349c;

    class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f9350a;

        a(g r10) {
            this.f9350a = r10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            g.a(this.f9350a, r11.getIntExtra("temperature", 0) / 10.0f);
            g.b(this.f9350a, r11.getIntExtra("status", 1));
            g.c(this.f9350a, r11.getIntExtra("plugged", -1));
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f9351a = null;

        static {
            f9351a = new g(null);
        }

        static /* synthetic */ g a() {
            return f9351a;
        }
    }

    private g() {
        g();
    }

    /* synthetic */ g(a r10) {
        this();
    }

    static /* synthetic */ float a(g r10, float r11) {
        r10.f9347a = r11;
        return r11;
    }

    static /* synthetic */ int b(g r10, int r11) {
        r10.f9348b = r11;
        return r11;
    }

    static /* synthetic */ int c(g r10, int r11) {
        r10.f9349c = r11;
        return r11;
    }

    public static g d() {
        return b.a();
    }

    private void g() {
        new a(this);
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public int e() {
        return this.f9348b;
    }

    public float f() {
        return this.f9347a;
    }
}
