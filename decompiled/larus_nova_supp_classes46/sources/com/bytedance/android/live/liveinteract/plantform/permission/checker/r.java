package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IToolsPluginInstallCallback;
import com.bytedance.android.livehostapi.foundation.depend.NewPluginType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r implements qh0.a<rh0.a>, qh0.d<rh0.a> {
    public static final /* synthetic */ int d = 0;
    public qh0.d<rh0.a> a;
    public final qh0.f.C0257f b;
    public final qh0.a<rh0.a> c;

    public static final class a {
        public static boolean a() {
            if (rf2.a.a() == false) goto L6;
            return true;
        L6:
            return !((Boolean) vm2.h.n0.getValue(null, vm2.h.a[64])).booleanValue();
        }
    }

    public static final class b implements IToolsPluginInstallCallback {
        public final /* synthetic */ r a;
        public final /* synthetic */ rh0.a b;

        public final void onSuccess() {
            ALogger.i("interact_plugin_check", "tools plugin install success");
            if (this.a.b.d == false) goto L5;
            f2.c("直播功能加载成功", 0);
        L5:
            qh0.d<rh0.a> r0 = this.a.a;
            if (r0 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("consumer");
        L8:
            r0.onResult(this.b);
        }

        public final void onFailure(Throwable r10) {
            Intrinsics.checkNotNullParameter(r10, "throwable");
            ALogger.e("interact_plugin_check", "tools plugin install failed");
            if (this.a.b.d == false) goto L5;
            f2.c("直播功能加载失败", 0);
        L5:
            qh0.d<rh0.a> r11 = this.a.a;
            if (r11 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("consumer");
        L8:
            qh0.f.C0257f r1 = this.a.b;
            r11.b(new BaseCheckException(r1.c, r1.b, BaseCheckException.CheckType.InteractPlugin, "tools plugin install failed", null, 16, null));
        }

        public b(r r1, rh0.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements IHostPlugin.Callback {
        public final /* synthetic */ r a;
        public final /* synthetic */ long b;
        public final /* synthetic */ rh0.a c;

        public final void onCancel(String r10) {
            if (this.a.b.d == false) goto L5;
            f2.c("直播功能加载失败", 0);
        L5:
            qh0.d<rh0.a> r11 = this.a.a;
            if (r11 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("consumer");
        L8:
            qh0.f.C0257f r1 = this.a.b;
            r11.b(new BaseCheckException(r1.c, r1.b, BaseCheckException.CheckType.InteractPlugin, "check interact plugin installed be cancel.", null, 16, null));
        }

        public final void onSuccess(String r5) {
            com.bytedance.android.live.liveinteract.api.utils.g.q(System.currentTimeMillis() - this.b, vm2.d.d());
            if (this.a.b.d == false) goto L5;
            f2.c("直播功能加载成功", 0);
        L5:
            qh0.d<rh0.a> r6 = this.a.a;
            if (r6 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("consumer");
        L8:
            r6.onResult(this.c);
        }

        public c(r r1, long r2, rh0.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }
    }

    static {
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
        this.a = r2;
        qh0.a<rh0.a> r3 = this.c;
        if (r3 == null) goto L5;
        r3.a(this);
        return;
    L5:
        c(null);
    }

    @Override // qh0.d
    public final void b(BaseCheckException r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        qh0.d<rh0.a> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.b(r3);
    }

    public final void c(rh0.a r14) {
        String r0 = com.bytedance.android.live.liveinteract.api.utils.g.a;
        HashMap r1 = new HashMap();
        r1.put("pluginName", "live_resource");
        LiveSlardarMonitor.monitorStatusAndDuration(com.bytedance.android.live.liveinteract.api.utils.g.a, 0, 0, r1);
        long r2 = System.currentTimeMillis();
        if (a.a() == true) goto L5;
        NewPluginType r3 = NewPluginType.LiveResource;
        if (r3.isInstalled() == false) goto L45;
        com.bytedance.android.live.liveinteract.api.utils.g.q(System.currentTimeMillis() - r2, vm2.d.d());
        IHostBusiness r4 = jc1.k.f(IHostBusiness.class);
        if (r4 == null) goto L17;
        boolean r5 = r4.isDouyinPreInstall();
    L18:
        if (r5 == false) goto L20;
    L25:
        ReadOnlyProperty r6 = vm2.h.S5;
        KProperty[] r7 = vm2.h.a;
        if (((Boolean) r6.getValue(null, r7[355(0x163, float:4.97E-43)])).booleanValue() == true) goto L28;
    L40:
        qh0.d<rh0.a> r8 = this.a;
        if (r8 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L43:
        r8.onResult(r14);
        return;
    L28:
        if (((Boolean) vm2.h.T5.getValue(null, r7[356(0x164, float:4.99E-43)])).booleanValue() == true) goto L30;
    L36:
        ALogger.w("interact_plugin_check", "tools plugin is not ready try install");
        if (this.b.d == false) goto L39;
        f2.c("功能加载中，请稍等", 0);
    L39:
        jc1.k.n(IMiddlewareHostApp.class).installToolsPlugin(this.b.getContext(), new b(this, r14));
        return;
    L30:
        if (jc1.k.n(IMiddlewareHostApp.class).isToolsPluginReady() == false) goto L36;
        ALogger.i("interact_plugin_check", "tools plugin is ready");
        qh0.d<rh0.a> r9 = this.a;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L34:
        r9.onResult(r14);
        return;
    L20:
        if (tb1.c.c == true) goto L25;
        if (tb1.c.e == true) goto L25;
        if (tb1.c.f == false) goto L40;
    L17:
        r5 = false;
        goto L18
    L45:
        if (this.b.d == false) goto L47;
        f2.c("功能加载中，请稍等", 0);
    L47:
        r3.checkInstall(this.b.getContext(), "interact", new c(this, r2, r14));
        return;
    L5:
        if (this.b.d == false) goto L7;
        f2.b(2131916746, 0);
    L7:
        qh0.d<rh0.a> r15 = this.a;
        if (r15 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L10:
        qh0.f.C0257f r10 = this.b;
        r15.b(new BaseCheckException(r10.c, r10.b, BaseCheckException.CheckType.InteractPlugin, "check interact plugin installed be cancel.", null, 16, null));
    }

    @Override // qh0.d
    public final /* bridge */ /* synthetic */ void onResult(rh0.a r1) {
        c(r1);
    }

    public r(qh0.f.C0257f r2, qh0.a<rh0.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.b = r2;
        this.c = r3;
    }
}
