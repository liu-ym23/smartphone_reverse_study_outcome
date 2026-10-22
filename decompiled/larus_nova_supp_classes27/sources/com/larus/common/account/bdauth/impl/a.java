package com.larus.common.account.bdauth.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.view.FlowBDAuthorizeActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final Context a;
    public final List<db7.a> b;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.app.Activity");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.Activity");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.Activity");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.app.Activity");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.Activity");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.Activity");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.Activity");
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r2, "mContext");
        this.a = r2;
        ArrayList r3 = new ArrayList();
        this.b = r3;
        r3.add(new eb7.a());
    }

    public final boolean b(Intent r8, FlowBDAuthorizeActivity.d r9) {
        Intrinsics.checkNotNullParameter(r8, "intent");
        Intrinsics.checkNotNullParameter(r9, "eventHandler");
        Bundle r0 = r8.getExtras();
        if (r0 != null) goto L7;
        r9.a(r8);
        return false;
    L7:
        if ((r9 instanceof Activity) == false) goto L29;
        Activity r2 = (Activity) r9;
        String r4 = r2.getCallingPackage();
        if (TextUtils.isEmpty(r4) == true) goto L37;
    L14:
        fb7.c r5 = new fb7.c(r0);
        if (TextUtils.isEmpty(r4) == true) goto L20;
        if (StringsKt.equals(r4, ((fb7.a) r5).a, true) == true) goto L20;
    L24:
        boolean r3 = false;
    L26:
        if (r3 == true) goto L29;
        r9.a(r8);
        return false;
    L20:
        if (TextUtils.isEmpty(((fb7.a) r5).a) == false) goto L22;
    L25:
        r3 = true;
        goto L26
    L22:
        if (StringsKt.equals(((fb7.a) r5).a, r2.getPackageName(), true) == true) goto L24;
    L37:
        Field r6 = a().getDeclaredField("mReferrer");     // Catch: Exception -> L12
        r6.setAccessible(true);     // Catch: Exception -> L12
        Object r7 = r6.get(r2);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L12
        r4 = (String) r7;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        r4 = null;
    L29:
        int r10 = r0.getInt("_bytedance_params_type");
        Iterator r11 = ((ArrayList) this.b).iterator();
    L31:
        if (r11.hasNext() == false) goto L35;
        if (((db7.a) r11.next()).a(r10, r0, r9) == false) goto L31;
        return true;
    L35:
        r9.a(r8);
        return false;
    }

    public final boolean c(fb7.c r5, fb7.b r6) {
        if (r5 != null) goto L5;
        return false;
    L5:
        String r1 = ((fb7.a) r5).a;
        String r7 = ((fb7.a) r5).b;
        if (TextUtils.isEmpty(r1) == true) goto L18;
        if (r6 != null) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r7) == true) goto L20;
        Bundle r2 = new Bundle();
        r6.a(r2);
        Intent r8 = new Intent();
        r8.setComponent(new ComponentName(r1, r7));
        r8.putExtras(r2);
        r8.addFlags(67108864);
        r8.addFlags(536870912);
        this.a.startActivity(r8);     // Catch: Exception -> L15
        return true;
    L21:
        return false;
    L20:
        return false;
    L18:
        return false;
    }
}
