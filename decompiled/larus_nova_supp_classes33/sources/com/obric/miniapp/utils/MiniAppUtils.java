package com.obric.miniapp.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Vibrator;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.view.CalendarMiniAppActivity;
import com.obric.miniapp.view.MiniAppBaseActivity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MiniAppUtils {
    public static final MiniAppUtils a = null;
    public static volatile String b;
    public static volatile String c;
    public static Job d;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    public MiniAppUtils() {
    }

    static {
        a = new MiniAppUtils();
        e = LazyKt.lazy(new s0());
        f = LazyKt.lazy(new t0());
        g = LazyKt.lazy(new u0());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("bytedanceos.api.VibratorSmt");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("bytedanceos.api.VibratorSmt");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("bytedanceos.api.VibratorSmt");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("bytedanceos.api.VibratorSmt");
    }

    public static void f(String r6) {
        Intrinsics.checkNotNullParameter(r6, "effect");
        FLogger.a.i("MiniAppUtils", "performVibratorSmtFeedback ".concat(r6));
        Class r0 = (Class) f.getValue();     // Catch: Exception -> L8
        if (r0 == null) goto L10;
        Field r7 = r0.getField(r6);     // Catch: Exception -> L8
        if (r7 == null) goto L10;
        Integer r8 = Integer.valueOf(r7.getInt(null));     // Catch: Exception -> L8
    L11:
        if (r8 == null) goto L20;
        int r9 = r8.intValue();     // Catch: Exception -> L8
        Method r1 = (Method) g.getValue();     // Catch: Exception -> L8
        if (r1 == null) goto L21;
        r1.invoke(null, new Object[]{(Vibrator) e.getValue(), Integer.valueOf(r9)});     // Catch: Exception -> L8
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r8 = null;
    L8:
        e = move-exception;
        FLogger.a.e("MiniAppUtils", "vibrator invoke failed", e);
    }

    public static void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        String r1 = b;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r1, "appletId");
        if (Intrinsics.areEqual(r1, "com.flow.music.auth") == false) goto L9;
        r2 = "//flow/applet/music";
    L12:
        if (r2.length() <= 0) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == false) goto L23;
        Job r3 = d;
        if (r3 != null) goto L19;
    L21:
        String r4 = c;
        d = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MiniAppUtils$routeToApplet$2(r10, r2, r4, null), 3, null);
        return;
    L19:
        if (r3.isCompleted() == true) goto L21;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
        goto L21
    L23:
        return;
    L14:
        r0 = false;
        goto L15
    L9:
        if (Intrinsics.areEqual(r1, "com.flow.calendar") == false) goto L12;
        r2 = "//flow/applet/calendar";
        goto L12
    }

    public static void d(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "appletId");
        SharedPreferences r4 = r2.getSharedPreferences("com.obric.miniapp.sp", 0);
        Intrinsics.checkNotNull(r4);
        SharedPreferences.Editor r5 = r4.edit();
        r5.remove("enter_count_" + r3);
        r5.apply();
    }

    public static boolean e(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "appletId");
        if (Build.VERSION.SDK_INT < 25) goto L15;
        ShortcutManager r6 = (ShortcutManager) r4.getSystemService(ShortcutManager.class);
        if (r6 == null) goto L22;
        Iterator<ShortcutInfo> r7 = r6.getPinnedShortcuts().iterator();
    L8:
        if (r7.hasNext() == false) goto L23;
        ShortcutInfo r0 = r7.next();
        if (Intrinsics.areEqual(r0.getId(), "miniapp." + r5) == true) goto L13;
        if (Intrinsics.areEqual(r0.getId(), r5) == false) goto L8;
        return true;
    L13:
        return true;
    L23:
        return false;
    L22:
        return false;
    L15:
        return false;
    }

    public static void g(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "appletId");
        SharedPreferences r5 = r3.getSharedPreferences("com.obric.miniapp.sp", 0);
        String r6 = "enter_count_" + r4;
        int r0 = r5.getInt(r6, 0) + 1;
        Intrinsics.checkNotNull(r5);
        SharedPreferences.Editor r7 = r5.edit();
        r7.putInt(r6, r0);
        r7.apply();
    }

    public static boolean i(ComponentActivity r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r14, "appletId");
        if (Intrinsics.areEqual(r14, "com.flow.calendar") == false) goto L5;
        Pair r1 = new Pair(2131911819, 2131237731);
    L6:
        int r4 = ((Number) r1.component1()).intValue();
        int r2 = ((Number) r1.component2()).intValue();
        if (r4 == 0) goto L38;
        if (r2 == 0) goto L38;
        int r7 = com.larus.utils.j0.a;
        String r5 = com.larus.utils.j0.d(r4);
        Drawable r3 = ContextCompat.getDrawable(r13.getApplication(), r2);
        if ((r3 instanceof BitmapDrawable) == false) goto L12;
        Bitmap r6 = ((BitmapDrawable) r3).getBitmap();
    L35:
        if (r6 == null) goto L38;
        r13.setTaskDescription(new ActivityManager.TaskDescription(r5, r6, 0));
        return true;
    L12:
        if (r3 != null) goto L14;
        r6 = null;
        goto L35
    L14:
        Integer r8 = Integer.valueOf(r3.getIntrinsicWidth());
        if (r8.intValue() <= 0) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == true) goto L21;
        r8 = null;
    L21:
        if (r8 == null) goto L23;
        int r10 = r8.intValue();
    L24:
        Integer r11 = Integer.valueOf(r3.getIntrinsicHeight());
        if (r11.intValue() <= 0) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == true) goto L31;
        r11 = null;
    L31:
        if (r11 == null) goto L33;
        int r15 = r11.intValue();
    L34:
        Bitmap r16 = Bitmap.createBitmap(r10, r15, Bitmap.Config.ARGB_8888);
        Canvas r17 = new Canvas(r16);
        r3.setBounds(0, 0, r17.getWidth(), r17.getHeight());
        r3.draw(r17);
        r6 = r16;
        goto L35
    L33:
        r15 = 1;
        goto L34
    L27:
        r12 = false;
        goto L28
    L23:
        r10 = 1;
        goto L24
    L17:
        r9 = false;
    L38:
        AppletRuntimeManager.INSTANCE.getClass();
        AppletRuntime r0 = AppletRuntimeManager.i("SYSTEM_CVS_ID", "SYSTEM_CVS_ID", r14);
        if (r0 == null) goto L41;
        AIPackage r18 = r0.h;
    L42:
        if (r18 == null) goto L50;
        String r19 = r18.a;
        Icons r20 = r18.g;
        if (r20 == null) goto L50;
        String r21 = r20.get3x();
        if (r21 == null) goto L50;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r13), Dispatchers.getIO(), null, new MiniAppUtils$updateTaskDescription$1$1(r18, r21, r13, r19, null), 2, null);
        return true;
    L50:
        return false;
    L41:
        r18 = null;
        goto L42
    L5:
        r1 = new Pair(0, 0);
        goto L6
    }

    public final void c(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        if (Intrinsics.areEqual(r11, "com.flow.calendar") == false) goto L6;
        b(this, r10, r11, 2131911819, null, 2131237731, null, 40);
        return;
    }

    public static void b(MiniAppUtils r5, Context r6, String r7, int r8, String r9, int r10, Bitmap r11, int r12) {
        boolean r1 = false;
        if ((r12 & 4) == 0) goto L6;
        r8 = 0;
    L6:
        if ((r12 & 8) == 0) goto L9;
        r9 = null;
    L9:
        if ((r12 & 16) == 0) goto L12;
        r10 = 0;
    L12:
        if ((r12 & 32) == 0) goto L14;
        r11 = null;
    L14:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "appletId");
        if (Intrinsics.areEqual(r7, "com.flow.calendar") == false) goto L17;
        Class r13 = CalendarMiniAppActivity.class;
    L18:
        Intent r0 = new Intent(r6.getApplicationContext(), r13);
        r0.putExtra("fromLauncher", true);
        r0.putExtra("appletId", r7);
        r0.setData(com.larus.utils.y0.j(r7));
        r0.setAction("android.intent.action.VIEW");
        int r14 = Build.VERSION.SDK_INT;
        if (r14 < 25) goto L45;
        ShortcutManager r15 = (ShortcutManager) ContextCompat.getSystemService(r6, ShortcutManager.class);
        if (r15 != null) goto L23;
        return;
    L23:
        if (r14 >= 26) goto L25;
        return;
    L25:
        if (r15.isRequestPinShortcutSupported() == false) goto L48;
        if (r9 != null) goto L28;
    L29:
        r1 = true;
    L30:
        if (r1 == false) goto L35;
        if (r8 == 0) goto L34;
        r9 = r6.getString(r8);
        goto L35
    L34:
        r9 = "unknown";
    L35:
        if (r11 == null) goto L37;
        Icon r16 = Icon.createWithBitmap(r11);
    L42:
        if (r16 == null) goto L49;
        r15.requestPinShortcut(new ShortcutInfo.Builder(r6, "miniapp." + r7).setShortLabel(r9).setIcon(r16).setIntent(r0).build(), null);
        return;
    L49:
        return;
    L37:
        if (r10 != 0) goto L39;
    L41:
        r16 = null;
        goto L42
    L39:
        if (Intrinsics.areEqual(r6.getResources().getResourceTypeName(r10), "drawable") == false) goto L41;
        r16 = Icon.createWithResource(r6, r10);
        goto L42
    L28:
        if (r9.length() != 0) goto L30;
    L48:
        return;
    L45:
        return;
    L17:
        r13 = MiniAppBaseActivity.class;
        goto L18
    }
}
