package com.bytedance.android.ec.core.anchorv3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PdpMessageOpt {
    public static final boolean a = false;
    public static final i b = null;
    public static String c;
    public static BasePdpMessageOptWorker d;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r11, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            boolean r11 = PdpMessageOpt.a;
            Intrinsics.checkNotNullParameter("call onActivityDestroyed", MessageIndication.MESSAGE_TYPE_MSG);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            boolean r11 = PdpMessageOpt.a;
            Intrinsics.checkNotNullParameter("call onActivityPaused", MessageIndication.MESSAGE_TYPE_MSG);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            boolean r11 = PdpMessageOpt.a;
            Intrinsics.checkNotNullParameter("call onActivityResumed", MessageIndication.MESSAGE_TYPE_MSG);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            boolean r11 = PdpMessageOpt.a;
            Intrinsics.checkNotNullParameter("call onActivityStarted", MessageIndication.MESSAGE_TYPE_MSG);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            boolean r11 = PdpMessageOpt.a;
            Intrinsics.checkNotNullParameter("call onActivityStopped", MessageIndication.MESSAGE_TYPE_MSG);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r10) {
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            boolean r11 = PdpMessageOpt.a;
            Intrinsics.checkNotNullParameter("call onActivityCreated", MessageIndication.MESSAGE_TYPE_MSG);
        }
    }

    public static void e(String r1) {
        Intrinsics.checkNotNullParameter(r1, MessageIndication.MESSAGE_TYPE_MSG);
    }

    static {
        ECAppInfoService r0 = ECAppInfoService.e;
        boolean r1 = r0.isLocalTest();
        a = r1;
        i r10 = ECSettingKeys.w0();
        b = r10;
        if (r1 == false) goto L16;
        e("call init isEnableOptV2=" + r10.g());
        Context r11 = r0.getApplicationContext();
        Context r12 = null;
        if (r11 == null) goto L7;
        Context r13 = r11.getApplicationContext();
    L9:
        if ((r13 instanceof Application) == false) goto L12;
        r12 = r13;
    L12:
        Application r14 = (Application) r12;
        if (r14 == null) goto L17;
        r14.registerActivityLifecycleCallbacks(new a());
        return;
    L17:
        return;
    L7:
        r13 = null;
        goto L9
    }

    public static boolean b() {
        return b.b();
    }

    public static boolean c() {
        i r0 = b;
        Boolean r1 = r0.d();
        if (r1 == null) goto L6;
        return r1.booleanValue();
    L6:
        return r0.g();
    }

    public static boolean d() {
        i r0 = b;
        Boolean r1 = r0.f();
        if (r1 == null) goto L6;
        return r1.booleanValue();
    L6:
        return r0.g();
    }

    public static void f(String r1) {
        if (Intrinsics.areEqual(r1, c) == false) goto L9;
        BasePdpMessageOptWorker r10 = d;
        if (r10 == null) goto L7;
        Field r0 = BasePdpMessageOptWorker.f;
        r10.i();
    L7:
        d = null;
        return;
    }

    public static void a(String r1, Object r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
        if (Intrinsics.areEqual(r1, c) == false) goto L8;
        BasePdpMessageOptWorker r11 = d;
        if (r11 == null) goto L9;
        r11.a(r10);
        return;
    L9:
        return;
    }

    public static void g(String r1, boolean r10) {
        if (Intrinsics.areEqual(r1, c) == false) goto L8;
        BasePdpMessageOptWorker r11 = d;
        if (r11 == null) goto L9;
        r11.c(r10);
        return;
    L9:
        return;
    }

    public static void h(String r1, boolean r10) {
        if (Intrinsics.areEqual(r1, c) == false) goto L12;
        e("call onGetPack isCache=" + r10);
        if (r10 == true) goto L7;
        return;
    L7:
        if (b.g() == true) goto L14;
        BasePdpMessageOptWorker r11 = d;
        if (r11 == null) goto L15;
        r11.i();
        return;
    L15:
        return;
    L14:
        return;
    }

    public static void i(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        i r0 = b;
        if (r0.b() == true) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(c, r10)) == false) goto L15;
        BasePdpMessageOptWorker r1 = d;
        if (r1 == null) goto L10;
        Field r12 = BasePdpMessageOptWorker.f;
        r1.i();
    L10:
        c = r10;
        if (r0.g() == false) goto L13;
        BasePdpMessageOptWorker r13 = new PdpMessageOptWorkerV2(r11);
        PdpMessageOpt$startOpt$1$1 r14 = PdpMessageOpt$startOpt$1$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r14, "callback");
        ((ArrayList) r13.e).add(r14);
    L14:
        d = r13;
        goto L15
    L13:
        r13 = new j(r11);
        PdpMessageOpt$startOpt$2$1 r15 = PdpMessageOpt$startOpt$2$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r15, "callback");
        ((ArrayList) r13.e).add(r15);
    L15:
        BasePdpMessageOptWorker r16 = d;
        if (r16 == null) goto L19;
        r16.g();
        return;
    }
}
