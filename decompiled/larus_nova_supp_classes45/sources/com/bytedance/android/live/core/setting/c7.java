package com.bytedance.android.live.core.setting;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c7 {
    public static final /* synthetic */ int a = 0;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public static Context getContext() {
        if (d6.b() != null) goto L11;
        return (Application) a().getMethod("currentApplication", new Class[0]).invoke(null, null);
    L7:
        e = move-exception;
        d7.a("reflection application failed", e);
        return null;
    L11:
        return d6.b();
    }

    static {
        PublishSubject.create();
    }

    public static String c(SettingKey r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        v60.a r1 = v60.a.a;
        Object r4 = v60.a.h(r3.getName(), r3.getDefaultValue(), r3.getType());
        if (r4 != null) goto L8;
        return null;
    L8:
        return GsonProtectorUtils.toJson(t6.a, r4);
    }

    public static Object d(String r1) {
        if (SettingUtil.isLocalTest() == false) goto L8;
        v60.a r0 = v60.a.a;
        Intrinsics.checkNotNullParameter(r1, "key");
        if (SettingIncStrategy.a.a(r1) == false) goto L8;
        return b(v60.a.g(r1), r1);
    L8:
        v60.a r2 = v60.a.a;
        return b(v60.a.e(r1), r1);
    }

    public static Object b(Object r2, String r3) {
        v60.a r1 = v60.a.a;     // Catch: Exception -> L16
        Object r4 = v60.a.e("__origin_Type__" + r3);     // Catch: Exception -> L16
        if ((r4 instanceof Integer) == true) goto L6;
    L15:
        return r2;
    L6:
        if ((r2 instanceof String) == false) goto L15;
        int r5 = ((Integer) r4).intValue();     // Catch: Exception -> L16
        if (r5 != 0) goto L12;
        return new JSONObject(String.valueOf(r2));
    L12:
        if (r5 != 1) goto L15;
        return new JSONArray(String.valueOf(r2));
    L16:
        e = move-exception;
        d6.a("SettingCache", e);
        return r2;
    }

    public static Object e(String r7, Type r8, Object r9, boolean r11, boolean r12) {
        if (r12 == false) goto L5;
        v60.a r13 = v60.a.a;
        int r14 = d6.a;
        return v60.a.i(r7, r8, wa1.d.b);
    L5:
        v60.a r0 = v60.a.a;
        int r15 = d6.a;
        return r0.k(r7, r9, r8, r11, wa1.d.b, false);
    }
}
