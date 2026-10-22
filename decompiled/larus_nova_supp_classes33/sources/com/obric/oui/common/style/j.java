package com.obric.oui.common.style;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static boolean f;
    public static final String g = null;
    public static boolean h;
    public static boolean i;
    public static boolean j;
    public static int k;
    public static final HashMap<Integer, Pair<Integer, Integer>> l = null;
    public static boolean m;
    public static TypedValue n;
    public final WeakReference<View> a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final boolean e;

    static {
        String r0 = (String) a().getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"ro.pvr.product.name", "Phoenix"});     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r0) == true) goto L5;
    L6:
        g = r0;
        h = "Phoenix".equals(r0);
        i = "Phoenix".equals(r0);
        j = true;
        k = -1;
        l = new HashMap();
        m = false;
        return;
    L5:
        r0 = "Phoenix";
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public j(View r4) {
        boolean r0 = true;
        this.b = true;
        this.c = true;
        this.d = true;
        this.a = new WeakReference(r4);
        Context r5 = r4.getContext();
        if (n != null) goto L5;
        n = new TypedValue();
    L5:
        r5.getTheme().resolveAttribute(2130973130, n, true);
        if (n.data != 0) goto L9;
        r0 = false;
    L9:
        this.e = r0;
    }

    public static boolean d(String r5) {
        String[] r6 = r5.split(",");
        if (r6.length <= 0) goto L11;
        int r0 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        String r3 = r6[r2];
        if (g.equals(r3) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public final void b(boolean r6) {
        if (this.a.get() == null) goto L34;
        boolean r7 = !r6;
        if (j == false) goto L16;
        if (this.c == false) goto L16;
        this.a.get().getContext();
        int r1 = k;
        if (h == false) goto L16;
        if (r1 < 100000) goto L16;
        if (m == true) goto L16;
    L16:
        if (this.d == false) goto L35;
        Context r2 = this.a.get().getContext();
        int r3 = k;
        if (i == false) goto L36;
        if (r3 < 100000) goto L37;
        Pair<Integer, Integer> r4 = l.get(Integer.valueOf(r3));
        AudioManager r5 = (AudioManager) r2.getSystemService("audio");
        if (r4 != null) goto L25;
        return;
    L25:
        if (m == true) goto L27;
    L27:
        if (r7 == true) goto L29;
        int r8 = ((Integer) r4.first).intValue();
    L32:
        r5.playSoundEffect(r8, 1.0f);
        return;
    L29:
        if (r7 != true) goto L31;
        r8 = ((Integer) r4.second).intValue();
        goto L32
    L31:
        r8 = 10;
        goto L32
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    public final void e(boolean r2) {
        if (this.e == true) goto L5;
        return;
    L5:
        if (r2 == true) goto L7;
        return;
    L7:
        if (this.b == false) goto L11;
        b(true);
        return;
    }

    public final void f(int r11) {
        String r0 = "";
        if (r11 != 0) goto L77;
        if (this.e == false) goto L106;
        View r12 = this.a.get();
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.getContext() != null) goto L12;
        return;
    L12:
        if (f == true) goto L107;
        f = true;
        Context r13 = r12.getContext();
        l.clear();
        Settings.Global.getInt(r13.getContentResolver(), "controller_vibration_level", 0);
        if (Settings.Global.getInt(r13.getContentResolver(), "system_vibration_enabled", 1) != 1) goto L17;
        boolean r4 = true;
    L18:
        j = r4;
        String r14 = Settings.Global.getString(r13.getContentResolver(), "pvr_ui_config");
        if (TextUtils.isEmpty(r14) == false) goto L86;
    L71:
        boolean r15 = m;
        if (r15 == true) goto L74;
    L74:
        if (r15 == true) goto L105;
        return;
    L105:
        return;
    L86:
        JSONObject r5 = new JSONObject(r14);     // Catch: JSONException -> L67
        JSONObject r16 = JSONObjectProtectorUtils.getJSONObject(r5, "vibration");     // Catch: JSONException -> L33
        c(r16, "def_hover_fre");     // Catch: JSONException -> L33
        c(r16, "def_hover_level");     // Catch: JSONException -> L33
        c(r16, "def_hover_dur");     // Catch: JSONException -> L33
        c(r16, "def_press_fre");     // Catch: JSONException -> L33
        c(r16, "def_press_level");     // Catch: JSONException -> L33
        c(r16, "def_press_dur");     // Catch: JSONException -> L33
        c(r16, "weak_hover_fre");     // Catch: JSONException -> L33
        c(r16, "weak_hover_level");     // Catch: JSONException -> L33
        c(r16, "weak_hover_dur");     // Catch: JSONException -> L33
        c(r16, "weak_press_fre");     // Catch: JSONException -> L33
        c(r16, "weak_press_level");     // Catch: JSONException -> L33
        c(r16, "weak_press_dur");     // Catch: JSONException -> L33
        c(r16, "strong_hover_fre");     // Catch: JSONException -> L33
        c(r16, "strong_hover_level");     // Catch: JSONException -> L33
        c(r16, "strong_hover_dur");     // Catch: JSONException -> L33
        c(r16, "strong_press_fre");     // Catch: JSONException -> L33
        c(r16, "strong_press_level");     // Catch: JSONException -> L33
        c(r16, "strong_press_dur");     // Catch: JSONException -> L33
        String r6 = JSONObjectProtectorUtils.getString(r16, "device_allowed");     // Catch: JSONException -> L24
    L91:
        boolean r17 = JSONObjectProtectorUtils.getBoolean(r16, "debug");     // Catch: JSONException -> L28
    L29:
        m = r17;     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r6) == true) goto L89;
        h = d(r6);     // Catch: JSONException -> L33
    L89:
        JSONObject r18 = JSONObjectProtectorUtils.getJSONObject(r5, "sound");     // Catch: JSONException -> L62
        String r3 = JSONObjectProtectorUtils.getString(r18, "device_allowed");     // Catch: JSONException -> L40
    L42:
        if (TextUtils.isEmpty(r3) == true) goto L84;
        i = d(r3);     // Catch: JSONException -> L62
    L84:
        r0 = JSONObjectProtectorUtils.getString(r18, "device_id_effect_type");     // Catch: JSONException -> L81
    L47:
        if (TextUtils.isEmpty(r0) == true) goto L71;
        String[] r19 = r0.split(";");     // Catch: JSONException -> L62
        if (r19.length <= 0) goto L71;
        int r1 = r19.length;     // Catch: JSONException -> L62
        int r7 = 0;
    L51:
        if (r7 >= r1) goto L71;
        String[] r8 = r19[r7].split(",");     // Catch: JSONException -> L62
    L54:
        if (r8.length != 3) goto L61;
        l.put(Integer.valueOf(CastIntegerProtector.parseInt(r8[0])), new Pair(Integer.valueOf(CastIntegerProtector.parseInt(r8[1])), Integer.valueOf(CastIntegerProtector.parseInt(r8[2]))));     // Catch: Exception -> L57
    L57:
        e = move-exception;
        if (m == false) goto L61;
        e.toString();     // Catch: JSONException -> L62
    L61:
        r7 = r7 + 1;
    L40:
        r3 = "";
    L62:
        e = move-exception;
        if (m == false) goto L71;
        e.toString();     // Catch: JSONException -> L67
    L28:
        r17 = false;
    L24:
        r6 = "";
    L33:
        e = move-exception;
        if (m == false) goto L89;
        e.toString();     // Catch: JSONException -> L67
    L67:
        e = move-exception;
        if (m == false) goto L71;
        e.toString();
        goto L71
    L17:
        r4 = false;
        goto L18
    L107:
        return;
    L106:
        return;
    L77:
        if (this.e == false) goto L108;
        f = false;
        return;
    }

    public final void g(boolean r4) {
        if (this.e == true) goto L5;
        return;
    L5:
        View r0 = this.a.get();
        if (r0 != null) goto L9;
        return;
    L9:
        if ((r0.isPressed() ^ r4) == false) goto L14;
        if (r4 == false) goto L12;
        b(false);
        this.b = false;
        return;
    L12:
        r0.postDelayed(new i(this), 20);
        return;
    }

    public final void h(MotionEvent r2) {
        if (this.e == true) goto L5;
        return;
    L5:
        k = r2.getDeviceId();
    }

    public static int c(JSONObject r0, String r1) {
        return JSONObjectProtectorUtils.getInt(r0, r1);
    L4:
        return -1;
    }
}
