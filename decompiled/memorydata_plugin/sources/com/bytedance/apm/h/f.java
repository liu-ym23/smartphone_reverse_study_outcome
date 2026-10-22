package com.bytedance.apm.h;

import android.content.IntentFilter;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PluginBroadcastReceiver f1360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IntentFilter f1361b;
    private float c;
    private int d;
    private int e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f1363a = null;

        static {
            f1363a = new f(null);
        }

        static /* synthetic */ f a() {
            return f1363a;
        }
    }

    private f() {
        d();
    }

    /* synthetic */ f(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ float a(f r0, float r1) {
        r0.c = r1;
        return r1;
    }

    static /* synthetic */ int a(f r0, int r1) {
        r0.d = r1;
        return r1;
    }

    public static f a() {
        return a.a();
    }

    static /* synthetic */ int b(f r0, int r1) {
        r0.e = r1;
        return r1;
    }

    private void d() {
        this.f1360a = new AnonymousClass1(this);
        this.f1361b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public float b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }
}
