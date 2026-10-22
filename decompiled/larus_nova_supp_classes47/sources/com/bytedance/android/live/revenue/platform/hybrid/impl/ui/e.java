package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.revenue.platform.container.impl.d0;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.LynxView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends BaseHybridComponentContainer<HybridCard> implements zy0.b {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class e() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("m.l.lynx.svs.svsimpl.LynxSoLibLoader");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("m.l.lynx.svs.svsimpl.LynxSoLibLoader");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("m.l.lynx.svs.svsimpl.LynxSoLibLoader");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("m.l.lynx.svs.svsimpl.LynxSoLibLoader");
    }

    @Override // zy0.b
    public final View c() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revenue.common.j
    public final void d() {
        ((ArrayList) this.c).clear();
        this.d.release();
    }

    @Override // zy0.b
    public final void x() {
        HybridCard r0 = this.d;
        if (r0 == null) goto L26;
        View r1 = r0.getHybridView();
        if (r1 == null) goto L27;
    L19:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        Unit r2 = Unit.INSTANCE;
        return;
    L7:
        if ((r1 instanceof LynxView) == true) goto L9;
        return;
    L9:
        Class r3 = e();     // Catch: Exception -> L19
        Method[] r4 = r3.getDeclaredMethods();     // Catch: Exception -> L19
        int r5 = r4.length;     // Catch: Exception -> L19
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L15;
        Method r7 = r4[r6];     // Catch: Exception -> L19
        if (Intrinsics.areEqual(r7.getName(), "onLynxViewCreated") == true) goto L16;
        r6 = r6 + 1;     // Catch: Exception -> L19
    L16:
        if (r7 == null) goto L28;
        r7.invoke(Reflect.on(r3).field("INSTANCE", new Class[]{r3}).get(), new Object[]{r1});     // Catch: Exception -> L19
        return;
    L28:
        return;
    L15:
        r7 = null;
        goto L16
    L27:
        return;
    }

    public e(HybridCard r2, bz0.d r3) {
        Intrinsics.checkNotNullParameter(r2, "originalCard");
        Intrinsics.checkNotNullParameter(r3, "model");
        super(r2, r3);
    }

    public final void b(String r3, d0 r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "method");
        xy0.a<?> r0 = g();
        if (r0 == null) goto L6;
        com.bytedance.android.live.revenue.platform.hybrid.impl.component.d r1 = (com.bytedance.android.live.revenue.platform.hybrid.impl.component.d) r0;
        r1.registerMethod(r3, new d(r4));
        return;
    }

    public final void sendJsEvent(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        xy0.a<?> r0 = g();
        if (r0 == null) goto L6;
        ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r0).sendJsEvent(r2, r3);
        return;
    }
}
