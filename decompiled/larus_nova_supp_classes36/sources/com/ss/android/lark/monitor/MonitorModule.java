package com.ss.android.lark.monitor;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.jato.JatoXL;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MonitorModule {
    public static volatile MonitorModule h;
    public final ConcurrentLinkedDeque<String> a;
    public final ArrayList<e> b;
    public boolean c;
    public boolean d;
    public ScheduledFuture e;
    public ScheduledFuture f;
    public ScheduledFuture g;

    public static final enum Behaviour extends Enum<Behaviour> {
        public static final /* synthetic */ Behaviour[] a = null;
        public static final Behaviour open_page = null;
        public static final Behaviour open_tab = null;
        public static final Behaviour scroll_list = null;

        static {
            Behaviour r0 = new Behaviour("scroll_list", 0);
            scroll_list = r0;
            Behaviour r1 = new Behaviour("open_page", 1);
            open_page = r1;
            Behaviour r3 = new Behaviour("open_tab", 2);
            open_tab = r3;
            a = new Behaviour[]{r0, r1, r3};
        }

        public static Behaviour[] values() {
            return (Behaviour[]) a.clone();
        }

        public static Behaviour valueOf(String r1) {
            return (Behaviour) r27.a.a(Behaviour.class, r1);
        }

        public Behaviour(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum Business extends Enum<Business> {
        public static final /* synthetic */ Business[] a = null;
        public static final Business ccm = null;
        public static final Business common = null;
        public static final Business little_app = null;
        public static final Business messenger = null;
        public static final Business minutes = null;
        public static final Business vc = null;

        static {
            Business r0 = new Business("vc", 0);
            vc = r0;
            Business r1 = new Business(IImBrowserService.LINK_SCENE_MESSENGER, 1);
            messenger = r1;
            Business r3 = new Business("ccm", 2);
            ccm = r3;
            Business r5 = new Business("little_app", 3);
            little_app = r5;
            Business r7 = new Business("minutes", 4);
            minutes = r7;
            Business r9 = new Business("common", 5);
            common = r9;
            a = new Business[]{r0, r1, r3, r5, r7, r9};
        }

        public static Business[] values() {
            return (Business[]) a.clone();
        }

        public static Business valueOf(String r1) {
            return (Business) r27.a.a(Business.class, r1);
        }

        public Business(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static MonitorModule e() {
        if (h != null) goto L15;
        monitor-enter(MonitorModule.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (h != null) goto L9;
        h = new MonitorModule();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MonitorModule.class);     // Catch: Throwable -> L11
    L15:
        return h;
    }

    public final void a() {
        ScheduledFuture r0 = this.g;
        if (r0 == null) goto L6;
        r0.cancel(false);
        this.g = null;
    L6:
        if (DevicePerfManager.b.a.e.h == true) goto L8;
        return;
    L8:
        if (this.d == true) goto L10;
        this.d = true;
        CoreThreadPool.setAppCoreScene(true);
        JatoXL.startBlockGc("coreScene");
        JatoXL.lightJitBlockStart();
    L10:
        this.g = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new q(this), 5000, TimeUnit.MILLISECONDS);
    }

    public final void b() {
        ScheduledFuture r0 = this.g;
        if (r0 == null) goto L6;
        r0.cancel(false);
        this.g = null;
    L6:
        if (DevicePerfManager.b.a.e.h == true) goto L8;
        return;
    L8:
        if (this.d == false) goto L12;
        this.g = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new m(this), 500, TimeUnit.MILLISECONDS);
        return;
    }

    public final String d() {
        String r0 = this.a.peek();
        if (this.c == true) goto L5;
        return "StartUp";
    L5:
        if (TextUtils.isEmpty(r0) == false) goto L13;
        Activity r1 = AppLifecycle.a.a.f();
        if (r1 != null) goto L14;
        return "background";
    L14:
        return r1.getClass().getName();
    L13:
        return r0.split("#hash")[0];
    }

    public MonitorModule() {
        this.a = new ConcurrentLinkedDeque();
        this.b = new ArrayList();
        this.c = false;
        this.d = false;
    }

    public static int c(ViewGroup r4) {
        int r0 = 0;
        if (r4 == null) goto L11;
        int r1 = r4.getChildCount();
        int r2 = 0;
    L5:
        if (r0 >= r1) goto L10;
        if ((r4.getChildAt(r0) instanceof ViewGroup) == false) goto L9;
        r2 = r2 + c((ViewGroup) r4.getChildAt(r0));
    L9:
        r0 = r0 + 1;
        goto L5
    L10:
        return r2;
    L11:
        return 0;
    }

    public final void g(final String r3) {
        if (this.c == true) goto L5;
        return;
    L5:
        Log.i("ScenePerfMonitor", "startScene:" + r3);
        CoreThreadPool.getNonblockingHandler().post(new o(this, r3));
    }

    public final void f(Business r2, String r3) {
        String r4 = r2.name() + "_" + r3;
        g(r4);
        ApmAgent.startBatteryCollect(r4);
    }

    public final void h(Business r2, String r3) {
        String r4 = r2.name() + "_" + r3;
        j(r4, null);
        ApmAgent.stopBatteryCollect(r4);
    }

    public final void j(final String r3, final JSONObject r4) {
        Log.i("ScenePerfMonitor", "stopScene:" + r3);
        if (this.c == true) goto L5;
        return;
    L5:
        CoreThreadPool.getNonblockingHandler().post(new l(this, r3, r4));
    }

    public final void i(Business r2, String r3, JSONObject r4) {
        String r5 = r2.name() + "_" + r3;
        j(r5, r4);
        ApmAgent.stopBatteryCollect(r5);
    }
}
