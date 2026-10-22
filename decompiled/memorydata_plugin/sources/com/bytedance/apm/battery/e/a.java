package com.bytedance.apm.battery.e;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<InterfaceC0086a> f1171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1172b;
    private static boolean c;
    private static b d;

    /* JADX INFO: renamed from: com.bytedance.apm.battery.e.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.apm.battery.e.a$a, reason: collision with other inner class name */
    public interface InterfaceC0086a {
        void b(boolean r1);
    }

    private static class b extends PluginBroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        public void onReceive(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            String r4 = r3.getAction();
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(r4) == false) goto L9;
            a.a(true);
            Iterator r5 = a.a().iterator();
        L6:
            if (r5.hasNext() == false) goto L17;
            ((InterfaceC0086a) ZeusTransformUtils.preCheckCast(r5.next(), InterfaceC0086a.class, "com.obric.memorydata.plugin")).b(a.b());
            goto L6
        L17:
            return;
        L9:
            if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(r4) == false) goto L14;
            a.a(false);
            Iterator r6 = a.a().iterator();
        L12:
            if (r6.hasNext() == false) goto L18;
            ((InterfaceC0086a) ZeusTransformUtils.preCheckCast(r6.next(), InterfaceC0086a.class, "com.obric.memorydata.plugin")).b(a.b());
            goto L12
        L18:
            return;
        }
    }

    static {
        f1171a = new ArrayList();
        f1172b = false;
    }

    static /* synthetic */ List a() {
        return f1171a;
    }

    public static boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (f1172b == true) goto L5;
        Intent r5 = ZeusTransformUtils.registerReceiver(r4, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        int r6 = r5.getIntExtra("status", -1);
        if (r6 != 2) goto L11;
        return true;
    L11:
        if (r6 == 5) goto L17;
        return false;
    L17:
        return true;
    L15:
        return true;
    L5:
        return c;
    }

    public static boolean a(Context r2, InterfaceC0086a r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        InterfaceC0086a r5 = (InterfaceC0086a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0086a.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L10;
        f1171a.add(r5);
        if (f1172b == true) goto L8;
        b(r4);
        f1172b = true;
    L8:
        return c;
    L10:
        throw new IllegalArgumentException("chargeListener can't be null");
    }

    static /* synthetic */ boolean a(boolean r0) {
        c = r0;
        return r0;
    }

    private static void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        IntentFilter r0 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");     // Catch: Throwable -> L5
        r0.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");     // Catch: Throwable -> L5
        b r2 = new b(null);     // Catch: Throwable -> L5
        d = r2;     // Catch: Throwable -> L5
        ZeusTransformUtils.registerReceiver(r5, r2, r0, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        c = a(r5);     // Catch: Throwable -> L5
        return;
    L5:
        c = true;
    }

    public static void b(Context r2, InterfaceC0086a r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        InterfaceC0086a r5 = (InterfaceC0086a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0086a.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        f1171a.remove(r5);
        if (f1171a.isEmpty() == false) goto L13;
        ZeusTransformUtils.unregisterReceiver(r4, d, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L8:
        f1172b = false;
        return;
    }

    static /* synthetic */ boolean b() {
        return c;
    }
}
