package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import android.app.Activity;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.LifecycleHandler;
import com.ss.android.lark.appcontext.applifecycle.t;
import com.ss.android.lark.appcontext.applifecycle.w;
import com.ss.android.lark.appreciablelib.NetStatus;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImSdkAppProxy implements okb.a {
    public final CopyOnWriteArrayList<okb.a.b> a;
    public final CopyOnWriteArrayList<okb.a.a> b;
    public final Lazy c;

    public static final class a implements t {
        public final /* synthetic */ ImSdkAppProxy a;

        public a(ImSdkAppProxy r1) {
            this.a = r1;
        }

        public final void a(Activity r3) {
            Iterator<okb.a.a> r0 = this.a.b.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            okb.a.a r1 = r0.next();
            Intrinsics.checkNotNull(r3);
            r1.b();
            goto L4
        }
    }

    public static final class b implements w {
        public final /* synthetic */ ImSdkAppProxy a;

        public b(ImSdkAppProxy r1) {
            this.a = r1;
        }

        public final void a(Class r2) {
            Iterator<okb.a.b> r3 = this.a.a.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r3.next().a();
            goto L4
        }
    }

    public static final class c implements NetworkLevelListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void a(NetworkLevelListener.NetworkLevel r8) {
            NetStatus r0 = NetStatus.EVALUATING;
            NetStatus[] r1 = NetStatus.values();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L8;
            NetStatus r4 = r1[r3];
            if (r4.getValue() == r8.getValue()) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            r0 = r4;
        L8:
            if (r0 == null) goto L10;
            MonitorMessageSendCallback.q.set(r0.getValue());
            return;
        L10:
            AtomicInteger r9 = MonitorMessageSendCallback.q;
        }
    }

    public final long a() {
        return cac.b.a.a.a(MmUploadRetryConfigSetting.MAX_INTERVAL_MS);
    }

    public final boolean b() {
        return com.ss.android.lark.appcontext.applifecycle.c.a.a.a;
    }

    public final Locale c() {
        return ((apb.a) this.c.getValue()).c();
    }

    public final Locale getCacheLanguageSetting() {
        return ((apb.a) this.c.getValue()).getLanguageSetting();
    }

    public final int getCurNetWorkLevel() {
        List r0 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.a;
        com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.a.getClass();
        Object r1 = LarkNetworkLevelManager.d;
        return LarkNetworkLevelManager.a.a().getCurNetWorkLevel().getValue();
    }

    public final Activity getTopActivity() {
        return AppLifecycle.a.a.f();
    }

    public ImSdkAppProxy() {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        b r0 = new b(this);
        a r1 = new a(this);
        c r2 = c.a;
        this.c = LazyKt.lazy(LazyThreadSafetyMode.NONE, ImSdkAppProxy$globalLanguageService$2.INSTANCE);
        ((CopyOnWriteArrayList) LifecycleHandler.b).add(r0);
        ((CopyOnWriteArrayList) LifecycleHandler.a).add(r1);
        List r3 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.a;
        com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.a.getClass();
        Object r4 = LarkNetworkLevelManager.d;
        LarkNetworkLevelManager.a.a().w0(r2);
    }

    public final boolean isDebug() {
        return DevEnvUtil.isDebugMode(LarkContext.getApplication());
    }

    public final void d(okb.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.a.contains(r2) == false) goto L5;
        return;
    L5:
        this.a.add(r2);
    }

    public final void e(okb.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.remove(r2);
    }

    public final void f(MonitorMessageSendCallback.b r2) {
        Intrinsics.checkNotNullParameter(r2, "eventListener");
        if (this.b.contains(r2) == false) goto L5;
        return;
    L5:
        this.b.add(r2);
    }
}
