package com.bytedance.android.anniex.container.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends s26.a implements q26.f {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class G0() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("com.bytedance.android.anniex.container.AnnieXHostActivity");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.anniex.container.AnnieXHostActivity");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.anniex.container.AnnieXHostActivity");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("com.bytedance.android.anniex.container.AnnieXHostActivity");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.anniex.container.AnnieXHostActivity");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.anniex.container.AnnieXHostActivity");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.anniex.container.AnnieXHostActivity");
    }

    public f() {
    }

    public final boolean u0(Context r10, Uri r11, q26.k r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "config");
        Unit r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Class<AnnieXDefaultActivity> r13 = G0();     // Catch: Throwable -> L8
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L12:
        if (Result.isSuccess-impl(r14) == false) goto L15;
        if (r13 != null) goto L16;
        r13 = AnnieXDefaultActivity.class;
    L16:
        Intent r15 = new Intent();
        r15.setComponent(new ComponentName(r10, r13));
        r15.setData(r11);
        boolean r16 = r10 instanceof Activity;
        if (r16 == true) goto L19;
        r15.addFlags(268435456);
    L19:
        Integer r17 = r12.a;
        if (r17 == null) goto L22;
        r15.addFlags(r17.intValue());
    L22:
        r12.d.putString("bundle_annie_x_bid", ((s26.a) this).a);
        r15.putExtras(r12.d);
        if (r16 == false) goto L33;
        Integer r18 = r12.f;
        if (r18 == null) goto L33;
        int r19 = r18.intValue();
        Bundle r20 = r12.e;
        if (r20 == null) goto L29;
        ((Activity) r10).startActivityForResult(r15, r19, r20);
        Unit r21 = Unit.INSTANCE;
    L30:
        if (r21 != null) goto L32;
        ((Activity) r10).startActivityForResult(r15, r19);
    L32:
        boolean r22 = true;
    L34:
        if (r22 == true) goto L40;
        Bundle r23 = r12.e;
        if (r23 == null) goto L38;
        r10.startActivity(r15, r23);
        r0 = Unit.INSTANCE;
    L38:
        if (r0 != null) goto L40;
        r10.startActivity(r15);
    L40:
        HybridLogger r24 = HybridLogger.a;
        Map r25 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r11.toString()));
        com.bytedance.ies.bullet.base.utils.logger.a r26 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r26.a(com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, r12.b);
        r26.a("callId", r12.c);
        Unit r110 = Unit.INSTANCE;
        HybridLogger.k("XRouter", "create page container successfully", r25, r26);
        return true;
    L29:
        r21 = null;
    L33:
        r22 = false;
        goto L34
    L15:
        HybridLogger r27 = HybridLogger.a;
        HybridLogger.m("XRouter", "get custom page container failed,use default container,url:" + r11, null, null, 12);
        r13 = AnnieXDefaultActivity.class;
    L6:
        Throwable th2 = th;
    L10:
        Result.Companion r28 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th2));
    L8:
        th = move-exception;
        th2 = th;
        r13 = null;
        goto L10
    }
}
