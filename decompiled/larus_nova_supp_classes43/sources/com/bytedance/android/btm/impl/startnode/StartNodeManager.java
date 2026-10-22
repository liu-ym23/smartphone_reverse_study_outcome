package com.bytedance.android.btm.impl.startnode;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.p;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.thread.ThreadUtils;
import com.bytedance.android.btm.impl.util.SharedPreferenceUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class StartNodeManager {
    public static p a;
    public static Object b;
    public static Object c;
    public static String d;
    public static Object e;
    public static Runnable f;
    public static final Handler g = null;
    public static final CopyOnWriteArrayList<a> h = null;
    public static final Lazy i = null;

    public static final class PageRunnable implements Runnable {
        public final boolean a;

        public final void a() {
            ALogger.d.b("StartNodeManager_PageRunnable", false, new StartNodeManager$PageRunnable$run$1(this));
            if (StartNodeManager.b != null) goto L8;
            Object r0 = StartNodeManager.e;
            if (r0 == null) goto L8;
            StartNodeManager.b = r0;
            StartNodeManager.e = null;
            StartNodeManager.f = null;
        L8:
            if (this.a == true) goto L10;
            return;
        L10:
            if (StartNodeManager.b == null) goto L14;
            StartNodeManager.h(StartNodeManager.b);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public PageRunnable(boolean r1) {
            this.a = r1;
        }
    }

    static {
        g = ThreadUtils.a();
        h = new CopyOnWriteArrayList();
        i = LazyKt.lazy(StartNodeManager$sharePreference$2.INSTANCE);
    }

    public static boolean a() {
        if (BtmSetting.d.c().c().p() != 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void f() {
        if (a() == false) goto L6;
        ALogger.d.b("StartNodeManager_saveToCache", false, StartNodeManager$saveToCache$1.INSTANCE);
        return;
    L6:
        p r0 = a;
        if (r0 == null) goto L13;
        final String r1 = r0.save();
        SharedPreferenceUtil r10 = (SharedPreferenceUtil) i.getValue();
        if (r10 == null) goto L11;
        r10.a("key_start_node_info", r1);
    L11:
        ALogger.d.b("StartNodeManager_saveToCache", false, new StartNodeManager$saveToCache$2$1(r1));
    L13:
        if (a != null) goto L16;
        ALogger.d.b("StartNodeManager_saveToCache", false, StartNodeManager$saveToCache$3.INSTANCE);
        return;
    }

    public static void c(Object r10) {
        ALogger r0 = ALogger.d;
        r0.b("StartNodeManager_onPageDestroy", false, StartNodeManager$onPageDestroy$1.INSTANCE);
        if (a() == false) goto L7;
        r0.b("StartNodeManager_onPageDestroy", false, StartNodeManager$onPageDestroy$2.INSTANCE);
        return;
    L7:
        if (a != null) goto L11;
        r0.b("StartNodeManager_onPageDestroy", false, StartNodeManager$onPageDestroy$3.INSTANCE);
        return;
    L11:
        if (c != r10) goto L14;
        c = null;
    L14:
        if (Intrinsics.areEqual(b, r10) == false) goto L19;
        b = null;
        p r11 = a;
        if (r11 == null) goto L20;
        r11.a = true;
        return;
    L20:
        return;
    }

    public static void g(p r10) {
        ALogger r0 = ALogger.d;
        r0.b("StartNodeManager_setStartNodeInfo", false, StartNodeManager$setStartNodeInfo$1.INSTANCE);
        if (a() == false) goto L6;
        r0.b("StartNodeManager_setStartNodeInfo", false, StartNodeManager$setStartNodeInfo$2.INSTANCE);
        return;
    L6:
        b = null;
        c = null;
        e = null;
        f = null;
        p r1 = a;
        if (r1 == null) goto L9;
        r1.a = true;
    L9:
        r0.b("StartNodeManager_reset", false, StartNodeManager$reset$1.INSTANCE);
        a = r10;
        if (r10 == null) goto L12;
        r10.a = false;
    L12:
        r0.b("StartNodeManager_setStartNodeInfo", false, StartNodeManager$setStartNodeInfo$3.INSTANCE);
    }

    public static void h(final Object r10) {
        ALogger r0 = ALogger.d;
        r0.b("StartNodeManager_setTargetPageInfo", false, new StartNodeManager$setTargetPageInfo$1(r10));
        String r1 = null;
        if (r10 == null) goto L11;
        c = r10;
        String r11 = BtmPageRecorder.a;
        PageInfo r12 = BtmPageRecorder.j(r10);
        if (r12 == null) goto L7;
        r1 = r12.getPageId();
    L7:
        d = r1;
        final String r13 = r10.getClass().getName();
        r0.b("StartNodeManager_setTargetPageInfo", false, new StartNodeManager$setTargetPageInfo$2(r13));
        Iterator<a> r14 = h.iterator();
    L9:
        if (r14.hasNext() == false) goto L14;
        r14.next().a();
        goto L9
    L14:
        return;
    L11:
        c = null;
        d = null;
    }

    public static void b(Object r10, Bundle r11) {
        final String r0 = r10.getClass().getName();
        ALogger r1 = ALogger.d;
        r1.b("StartNodeManager_onPageCreate", false, new StartNodeManager$onPageCreate$1(r0));
        if (a() == false) goto L5;
        return;
    L5:
        if (r11 == null) goto L14;
        final boolean r12 = r11.getBoolean("is_target_page", false);
        r1.b("StartNodeManager_onPageCreate", false, new StartNodeManager$onPageCreate$2$1(r12));
        if (r12 == false) goto L9;
        h(r10);
    L9:
        final boolean r13 = r11.getBoolean("is_next_page", false);
        if (r13 == false) goto L12;
        b = r10;
    L12:
        r1.b("StartNodeManager_onPageCreate", false, new StartNodeManager$onPageCreate$2$2(r13));
        return;
    }

    public static void d(Object r10, boolean r11) {
        ALogger r0 = ALogger.d;
        r0.b("StartNodeManager_onPageResume", false, StartNodeManager$onPageResume$1.INSTANCE);
        if (a() == false) goto L6;
        r0.b("StartNodeManager_onPageResume", false, StartNodeManager$onPageResume$2.INSTANCE);
        return;
    L6:
        p r1 = a;
        if (r1 != null) goto L9;
    L51:
        r0.b("StartNodeManager_onPageResume", false, StartNodeManager$onPageResume$3.INSTANCE);
        return;
    L9:
        if (r1.a == true) goto L51;
        if (c == null) goto L16;
        if (b != null) goto L51;
    L16:
        if (b == null) goto L23;
        r0.b("StartNodeManager_onPageResume", false, StartNodeManager$onPageResume$4.INSTANCE);
        if (c != null) goto L53;
        if (r11 == false) goto L54;
        r0.b("StartNodeManager_onPageResume", false, StartNodeManager$onPageResume$5.INSTANCE);
        h(r10);
        return;
    L54:
        return;
    L53:
        return;
    L23:
        if ((r10 instanceof Activity) == true) goto L27;
        if (r11 == true) goto L27;
        r0.b("StartNodeManager_onPageResume", false, StartNodeManager$onPageResume$6.INSTANCE);
        return;
    L27:
        if (r11 == false) goto L46;
        if (r1 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        r1.getClass();
        if (TextUtils.isEmpty(null) == true) goto L46;
        String r12 = BtmPageRecorder.a;
        final PageInfo r13 = BtmPageRecorder.j(r10);
        r0.b("StartNodeManager_onPageResume", false, new StartNodeManager$onPageResume$7(r13));
        if (r13 == null) goto L46;
        if (r13.getPageBtm() == null) goto L46;
        String r14 = r13.getPageBtm();
        if (r14 != null) goto L39;
        Intrinsics.throwNpe();
    L39:
        p r15 = a;
        if (r15 != null) goto L42;
        Intrinsics.throwNpe();
    L42:
        r15.getClass();
        if (StringsKt.contains(r14, "null", false) == false) goto L46;
        b = r10;
        h(r10);
        return;
    L46:
        e = r10;
        Runnable r16 = f;
        if (r16 == null) goto L49;
        g.removeCallbacks(r16);
    L49:
        PageRunnable r17 = new PageRunnable(r11);
        f = r17;
        g.postDelayed(r17, BtmSetting.d.c().c().I());
    }

    public static void e(Object r10, Bundle r11) {
        boolean r1 = false;
        if (a() == false) goto L6;
        ALogger.d.b("StartNodeManager_onPageSaveInstance", false, StartNodeManager$onPageSaveInstance$1.INSTANCE);
        return;
    L6:
        Object r0 = c;
        if (r10 != r0) goto L12;
        if (r10 != r0) goto L10;
        boolean r12 = true;
    L11:
        r11.putBoolean("is_target_page", r12);
        goto L12
    L10:
        r12 = false;
    L12:
        Object r13 = b;
        if (r10 != r13) goto L18;
        if (r10 != r13) goto L16;
        r1 = true;
    L16:
        r11.putBoolean("is_next_page", r1);
        return;
    }
}
