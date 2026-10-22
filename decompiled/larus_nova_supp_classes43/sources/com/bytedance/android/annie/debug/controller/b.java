package com.bytedance.android.annie.debug.controller;

import android.app.Activity;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ e a;

    public b(e r1) {
        this.a = r1;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("com.bytedance.android.livesdk.chatroom.debug.LiveDebugDialog");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.chatroom.debug.LiveDebugDialog");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.chatroom.debug.LiveDebugDialog");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("com.bytedance.android.livesdk.chatroom.debug.LiveDebugDialog");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.chatroom.debug.LiveDebugDialog");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.chatroom.debug.LiveDebugDialog");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.livesdk.chatroom.debug.LiveDebugDialog");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        e r11 = this.a;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = a().getConstructor(new Class[]{Activity.class}).newInstance(new Object[]{r11.a});     // Catch: Throwable -> L5
        Object r13 = Result.constructor-impl(r12.getClass().getMethod("show", new Class[0]).invoke(r12, new Object[0]));     // Catch: Throwable -> L5
    L7:
        Result.exceptionOrNull-impl(r13);
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
