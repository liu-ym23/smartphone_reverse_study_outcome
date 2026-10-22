package com.obric.memorydata.middleware.impl.abtest;

import android.content.Context;
import com.bytedance.ies.abmock.datacenter.plugin.BaseConfigPlugin;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.w;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/middleware/impl/abtest/PluginAbMockConfigRegistrar;", "", "<init>", "()V", "GENERATED_CONFIG_CLASS", "", "registeredPlugin", "Lcom/bytedance/ies/abmock/datacenter/plugin/BaseConfigPlugin;", "register", "", "pluginContext", "Landroid/content/Context;", "isRegistered", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f11679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static BaseConfigPlugin f11680b;

    static {
        f11679a = new d();
    }

    private d() {
    }

    private static final Unit a(Exception r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        ((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin")).a("abmock_plugin_registration_failed", "ABMock plugin config registration failed", new e(null, null, null, 7, null), new g().a());
        return Unit.INSTANCE;
    }

    private static final Unit b(Context r7) {
        Object r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin")).getClassLoader().loadClass("plugin.abmock.ConfigPluginImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (ZeusTransformUtils.instanceOf(r8, BaseConfigPlugin.class) == false) goto L10;
        com.bytedance.ies.abmock.datacenter.plugin.a.a().a((BaseConfigPlugin) ZeusTransformUtils.preCheckCast(r8, BaseConfigPlugin.class, "com.obric.memorydata.plugin"));
        f11680b = (BaseConfigPlugin) ZeusTransformUtils.preCheckCast(r8, BaseConfigPlugin.class, "com.obric.memorydata.plugin");
        o r9 = (o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin");
        e r6 = new e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L8;
        g r0 = new g();
        Unit r1 = Unit.INSTANCE;
        r9.a("ABMock plugin config registered", r6, r0.a());
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("Generated ABMock config has unexpected type".toString());
    }

    public static /* synthetic */ Unit lambda$UUfUOJbelASQYR9LsKiHLAnHNQc(Context r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$t1FDN-PvLHn_9uuhg-RcE6aX0O0, reason: not valid java name */
    public static /* synthetic */ Unit m1012lambda$t1FDNPvLHn_9uuhgRcE6aX0O0(Exception r0) {
        return a(r0);
    }

    public final synchronized void a(Context r3) {
        monitor-enter(this);
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r4, "pluginContext");     // Catch: Throwable -> L10
        if (a() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        y.a($$Lambda$d$t1FDNPvLHn_9uuhgRcE6aX0O0.INSTANCE, new $$Lambda$d$UUfUOJbelASQYR9LsKiHLAnHNQc(r4));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a() {
        monitor-enter(this);
        BaseConfigPlugin r0 = f11680b;     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        boolean r1 = com.bytedance.ies.abmock.datacenter.plugin.a.a().b().containsKey(r0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L6:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }
}
