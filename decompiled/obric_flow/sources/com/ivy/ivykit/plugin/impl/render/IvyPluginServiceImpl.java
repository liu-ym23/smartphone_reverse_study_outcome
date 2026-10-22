package com.ivy.ivykit.plugin.impl.render;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.lynx.service.LynxServiceInitializer;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IvyPluginService;
import com.ss.android.ugc.aweme.framework.services.annotation.ServiceImpl;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@ServiceImpl
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/ivy/ivykit/plugin/impl/render/IvyPluginServiceImpl;", "Lcom/ivy/ivykit/api/plugin/IvyPluginService;", "<init>", "()V", "Lcom/ivy/ivykit/api/plugin/h;", "pluginConfig", "", "initContainer", "(Lcom/ivy/ivykit/api/plugin/h;)V", "", "hasInit", "()Z", "Landroid/content/Context;", "context", "", "templateUrl", "Lol/b;", "loadingView", "Lol/c;", "pluginViewLifeCycle", "initData", "Lql/a;", "createPluginView", "(Landroid/content/Context;Ljava/lang/String;Lol/b;Lol/c;Ljava/lang/String;)Lql/a;", "", "schemaList", "preload", "(Ljava/util/List;)V", "url", "openSchema", "(Landroid/content/Context;Ljava/lang/String;)V", "Lpl/a;", "config", "setLynxVerifyConfig", "(Lpl/a;)V", "ivy_plugin_impl_bullet_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IvyPluginServiceImpl implements IvyPluginService {
    public IvyPluginServiceImpl() {
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public ql.a createPluginView(Context r5, String r10, ol.b r11, ol.c r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "templateUrl");
        return new f(r5, r10, r12, r13);
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public boolean hasInit() {
        return true;
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public void initContainer(com.ivy.ivykit.api.plugin.h r14) {
        Intrinsics.checkNotNullParameter(r14, "pluginConfig");
        Application r5 = k5.d.s;
        com.bytedance.ies.bullet.settings.a r10 = null;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("application");
        r5 = null;
    L6:
        Intrinsics.checkNotNullParameter(r5, "application");
        Intrinsics.checkNotNullParameter(r14, "pluginConfig");
        LynxServiceInitializer r13 = LynxServiceInitializer.INSTANCE;
        com.bytedance.lynx.service.model.a r11 = new com.bytedance.lynx.service.model.a(r5);
        String r12 = String.valueOf(0);
        Intrinsics.checkNotNullParameter(r12, Constant.APPID);
        r11.f6830a = r12;
        String r15 = k5.d.f18606k;
        Intrinsics.checkNotNullParameter(r15, "appVersion");
        r11.f6831b = r15;
        String r16 = k5.d.f18610o;
        Intrinsics.checkNotNullParameter(r16, "deviceId");
        if (r16.length() != 0) goto L9;
        r11.d = "0";
    L10:
        String r17 = k5.d.f18608m;
        Intrinsics.checkNotNullParameter(r17, "updateVersionCode");
        r11.f6832c = r17;
        Intrinsics.checkNotNullParameter("", LynxMonitorService.KEY_CHANNEL);
        r13.initialize(new com.bytedance.lynx.service.model.b(r5, r11.f6830a, r11.f6831b, r11.f6832c, r11.d, r11.e));
        ul.d r18 = jm.c.f18359c;
        if (r18 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("geckoConfigs");
        r18 = null;
    L14:
        com.bytedance.android.monitorV2.h.e().c(r5);
        String r19 = String.valueOf(0);
        String r20 = k5.d.f18604i;
        String r21 = k5.d.f18610o;
        String r22 = k5.d.f18607l;
        String r23 = k5.d.f18608m;
        if (r20 == null) goto L27;
        if ("".equals(r20) == true) goto L27;
        a5.c r24 = new a5.c();
        r24.f98a = r19;
        r24.f99b = r20;
        r24.f100c = "Android";
        r24.d = String.valueOf(Build.VERSION.RELEASE);
        r24.e = r21;
        r24.f = "";
        r24.g = r22;
        r24.f101h = r23;
        r24.f102i = "CN";
        r24.f103j = "zh";
        r24.f104k = null;
        r24.f105l = null;
        com.bytedance.android.monitorV2.h.e().b(r24);
        r14.getClass();
        com.bytedance.ies.bullet.base.c r25 = com.ivy.ivykit.plugin.impl.utils.a.a(r5, "default_bid", "bullet_custom_bid", r18, r14);
        Intrinsics.checkNotNullParameter(r25, "config");
        com.bytedance.ies.bullet.base.b.b(r25);
        ConcurrentHashMap r26 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        Object r27 = yc.a.a(xc.e.class, "default_bid");
        if ((r27 instanceof com.bytedance.ies.bullet.settings.a) == false) goto L21;
        r10 = (com.bytedance.ies.bullet.settings.a) r27;
    L21:
        String r28 = String.valueOf(0);
        String r29 = k5.d.f18610o;
        com.ivy.ivykit.plugin.impl.applet.e r30 = new com.ivy.ivykit.plugin.impl.applet.e(new xc.a(r28, k5.d.f18606k, r29, r29), r10);
        Intrinsics.checkNotNullParameter(r30, NotificationCompat.CATEGORY_SERVICE);
        yc.a.b(xc.e.class, r30, "default_bid");
        String r31 = k5.d.f18613r;
        com.bytedance.ies.bullet.base.c r110 = com.ivy.ivykit.plugin.impl.utils.a.a(r5, r31, r31, r18, r14);
        Intrinsics.checkNotNullParameter(r110, "config");
        com.bytedance.ies.bullet.base.b.b(r110);
        if (zg.b.f23438a == null) goto L24;
        return;
    L24:
        zg.b.f23438a = r5;
        return;
    L27:
        throw new RuntimeException("host is undefined");
    L9:
        r11.d = r16;
        goto L10
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public void openSchema(Context r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "url");
        com.bytedance.ies.bullet.base.b.d(r5, Uri.parse(r10));
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public void preload(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaList");
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public void setLynxVerifyConfig(pl.a r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
    }
}
