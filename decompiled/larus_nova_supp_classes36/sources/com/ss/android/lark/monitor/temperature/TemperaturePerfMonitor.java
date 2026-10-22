package com.ss.android.lark.monitor.temperature;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.e;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TemperaturePerfMonitor extends e {
    public boolean a;
    public final List<d> b;
    public ScheduledFuture<?> c;

    public static final class a implements xpc.a {
        public final /* synthetic */ TemperaturePerfMonitor a;

        /* JADX INFO: renamed from: com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor$a$a, reason: collision with other inner class name */
        public static final class RunnableC0187a implements Runnable {
            public final /* synthetic */ TemperaturePerfMonitor a;
            public final /* synthetic */ Ref.IntRef b;

            public RunnableC0187a(TemperaturePerfMonitor r1, Ref.IntRef r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator<d> r0 = this.a.b.iterator();     // Catch: Throwable -> L8
            L4:
                if (r0.hasNext() == false) goto L6;
                r0.next().onThermalStatusChanged(this.b.element);     // Catch: Throwable -> L8
                goto L4
            L6:
                TemperaturePerfMonitor r1 = this.a;     // Catch: Throwable -> L8
                int r2 = this.b.element;     // Catch: Throwable -> L8
                r1.getClass();     // Catch: Throwable -> L8
                TemperaturePerfMonitor.b(r2);     // Catch: Throwable -> L8
                return;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }
        }

        public a(TemperaturePerfMonitor r1) {
            this.a = r1;
        }

        public final void a(int r6, Bundle r7) {
            if (r6 == 2) goto L6;
            return;
        L6:
            if (r7.getString("value") == null) goto L22;
            TemperaturePerfMonitor r8 = this.a;
            Ref.IntRef r9 = new Ref.IntRef();     // Catch: Exception -> L17
            xpc.c r2 = xpc.c.b.a;     // Catch: Exception -> L17
            Integer r3 = StringsKt.toIntOrNull(xpc.c.a(CastIntegerProtector.parseInt(Conf$StickerSetManagerPosition.STICKER_SET_SHOP)));     // Catch: Exception -> L17
            if (r3 == null) goto L11;
            int r4 = r3.intValue();     // Catch: Exception -> L17
        L12:
            r9.element = r4;     // Catch: Exception -> L17
            Log.i("TemperatureMonitor", "vivo ThermalStatusListener cpu temperateure level is " + r9.element);     // Catch: Exception -> L17
            ScheduledFuture<?> r1 = r8.c;     // Catch: Exception -> L17
            if (r1 == null) goto L15;
            r1.cancel(true);     // Catch: Exception -> L17
        L15:
            r8.c = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new RunnableC0187a(r8, r9), 60, TimeUnit.SECONDS);     // Catch: Exception -> L17
            return;
        L11:
            r4 = 0;
        L17:
            e = move-exception;
            Log.e("TemperatureMonitor", "parse bundle exception", e);
            return;
        }
    }

    public static final class b implements PowerManager.OnThermalStatusChangedListener {
        public final /* synthetic */ TemperaturePerfMonitor a;

        public b(TemperaturePerfMonitor r1) {
            this.a = r1;
        }

        @Override // android.os.PowerManager.OnThermalStatusChangedListener
        public final void onThermalStatusChanged(int r4) {
            Log.i("TemperatureMonitor", "ThermalStatusListener status:" + r4);
            TemperaturePerfMonitor r0 = this.a;
            if (r0.a == false) goto L8;
            Iterator<d> r1 = r0.b.iterator();
        L6:
            if (r1.hasNext() == false) goto L8;
            r1.next().onThermalStatusChanged(r4 - 1);
        L8:
            this.a.getClass();
            TemperaturePerfMonitor.b(r4);
        }
    }

    public static final class c {
    }

    public interface d {
        void a(float r1);

        void onThermalStatusChanged(int r1);
    }

    static {
    }

    @Override // com.ss.android.lark.monitor.e
    public final void pauseScene(String r1) {
    }

    @Override // com.ss.android.lark.monitor.e
    public final void startScene(String r1) {
    }

    @Override // com.ss.android.lark.monitor.e
    public final void stopScene(String r1, JSONObject r2) {
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor$3] */
    public TemperaturePerfMonitor() {
        this.a = true;
        this.b = Collections.synchronizedList(new ArrayList());
        xpc.c r1 = xpc.c.b.a;
        Object[] r2 = xpc.b.d.b("checkPermission", new Object[]{"0467dacf1f5560a49c10d4fa055a8fa675e58eace6a6c60fa059387e856946f5"});     // Catch: Exception -> L7
        if (r2.length <= 0) goto L8;
        boolean r3 = ((Boolean) r2[0]).booleanValue();     // Catch: Exception -> L7
    L9:
        if (r3 == false) goto L12;
        Log.i("TemperatureMonitor", "vivo sdk init");
        xpc.c.b.a.a = new a(this);
        xpc.b.d.b("callback_register", new Object[]{2, new xpc.c.a()});
    L19:
        a(LarkContext.getApplication(), new AnonymousClass3(this), new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Exception -> L16
        return;
    L21:
        return;
    L12:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        Object r0 = LarkContext.getApplication().getSystemService("power");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");
        ((PowerManager) r0).addThermalStatusListener(new b(this));
    L8:
        r3 = false;
        goto L9
    }

    public static void b(int r3) {
        if (r3 > 2) goto L10;
        return;
    L10:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L7
        r0.put("scene", MonitorModule.e().d());     // Catch: Throwable -> L7
        r0.put("temperatureType", "cpu");     // Catch: Throwable -> L7
        r0.put("level", r3);     // Catch: Throwable -> L7
        isb.a.c("scene_temperature_info", r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.e("ScenePerfMonitor", th);
    }

    @Override // com.ss.android.lark.monitor.d
    public final void onAppFrontStateChanged(boolean r1) {
        this.a = r1;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Application r8, AnonymousClass3 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
