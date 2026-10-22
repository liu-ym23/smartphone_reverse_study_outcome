package com.obric.oui.common.style;

import ai.j0;
import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.obric.common.oui.R$attr;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static boolean f = false;
    public static final String g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f12469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f12470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f12471j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f12472k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap f12473l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f12474m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static TypedValue f12475n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f12476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12478c;
    public boolean d;
    public final boolean e;

    static {
        String r5 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"ro.pvr.product.name", "Phoenix"});     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r5) == true) goto L5;
    L6:
        g = r5;
        f12469h = "Phoenix".equals(r5);
        f12470i = "Phoenix".equals(r5);
        f12471j = true;
        f12472k = -1;
        f12473l = new HashMap();
        f12474m = false;
        return;
    L5:
        r5 = "Phoenix";
        goto L6
    }

    public h(View r5) {
        boolean r10 = true;
        this.f12477b = true;
        this.f12478c = true;
        this.d = true;
        this.f12476a = new WeakReference(r5);
        Context r11 = r5.getContext();
        int r12 = R$attr.oui_effect_enabled;
        if (f12475n != null) goto L5;
        f12475n = new TypedValue();
    L5:
        r11.getTheme().resolveAttribute(r12, f12475n, true);
        if (f12475n.data != 0) goto L9;
        r10 = false;
    L9:
        this.e = r10;
    }

    public static int b(String r5, JSONObject r10) {
        return r10.getInt(r5);
    L4:
        return -1;
    }

    public static boolean c(String r5) {
        String[] r10 = r5.split(",");
        if (r10.length <= 0) goto L11;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        if (g.equals(r10[r12]) == true) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public final void a(boolean r10) {
        WeakReference r5 = this.f12476a;
        if (r5.get() == null) goto L37;
        int r11 = !r10 ? 1 : 0;
        if (f12471j == false) goto L16;
        if (this.f12478c == false) goto L16;
        ((View) r5.get()).getContext();
        int r12 = f12472k;
        if (f12469h == false) goto L16;
        if (r12 < 100000) goto L16;
        if (f12474m == false) goto L16;
        Log.i("OUIEffectHelper", "onVibrate: effectType=" + r11 + ", deviceId=" + r12);
    L16:
        if (this.d == false) goto L38;
        Context r13 = ((View) r5.get()).getContext();
        int r14 = f12472k;
        if (f12470i == false) goto L39;
        if (r14 < 100000) goto L42;
        Pair r15 = (Pair) f12473l.get(Integer.valueOf(r14));
        AudioManager r16 = (AudioManager) r13.getSystemService("audio");
        if (r15 != null) goto L27;
        if (f12474m == false) goto L40;
        Log.i("OUIEffectHelper", "playSoundEffect: pair is empty");
        return;
    L40:
        return;
    L27:
        if (f12474m == false) goto L29;
        Log.i("OUIEffectHelper", "playSoundEffect: effectType=" + r11 + ", deviceId=" + r14);
    L29:
        if (r10 == false) goto L32;
        int r17 = ((Integer) r15.first).intValue();
    L35:
        r16.playSoundEffect(r17, 1.0f);
        return;
    L32:
        if (r11 != 1) goto L34;
        r17 = ((Integer) r15.second).intValue();
        goto L35
    L34:
        r17 = 10;
        goto L35
    L42:
        return;
    L39:
        return;
    L38:
        return;
    }

    public final void d(boolean r5) {
        if (this.e == true) goto L5;
        return;
    L5:
        if (r5 == true) goto L7;
        return;
    L7:
        if (this.f12477b == false) goto L11;
        a(true);
        return;
    }

    public final void e(int r13) {
        String r5 = "";
        boolean r10 = this.e;
        if (r13 != 0) goto L79;
        if (r10 == false) goto L111;
        View r12 = (View) this.f12476a.get();
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.getContext() != null) goto L11;
        return;
    L11:
        if (f == true) goto L112;
        f = true;
        Context r14 = r12.getContext();
        HashMap r11 = f12473l;
        r11.clear();
        Settings.Global.getInt(r14.getContentResolver(), "controller_vibration_level", 0);
        if (Settings.Global.getInt(r14.getContentResolver(), "system_vibration_enabled", 1) != 1) goto L16;
        boolean r15 = true;
    L17:
        f12471j = r15;
        String r16 = Settings.Global.getString(r14.getContentResolver(), "pvr_ui_config");
        if (TextUtils.isEmpty(r16) == true) goto L74;
        JSONObject r17 = new JSONObject(r16);     // Catch: JSONException -> L37
        JSONObject r18 = r17.getJSONObject("vibration");     // Catch: JSONException -> L32
        b("def_hover_fre", r18);     // Catch: JSONException -> L32
        b("def_hover_level", r18);     // Catch: JSONException -> L32
        b("def_hover_dur", r18);     // Catch: JSONException -> L32
        b("def_press_fre", r18);     // Catch: JSONException -> L32
        b("def_press_level", r18);     // Catch: JSONException -> L32
        b("def_press_dur", r18);     // Catch: JSONException -> L32
        b("weak_hover_fre", r18);     // Catch: JSONException -> L32
        b("weak_hover_level", r18);     // Catch: JSONException -> L32
        b("weak_hover_dur", r18);     // Catch: JSONException -> L32
        b("weak_press_fre", r18);     // Catch: JSONException -> L32
        b("weak_press_level", r18);     // Catch: JSONException -> L32
        b("weak_press_dur", r18);     // Catch: JSONException -> L32
        b("strong_hover_fre", r18);     // Catch: JSONException -> L32
        b("strong_hover_level", r18);     // Catch: JSONException -> L32
        b("strong_hover_dur", r18);     // Catch: JSONException -> L32
        b("strong_press_fre", r18);     // Catch: JSONException -> L32
        b("strong_press_level", r18);     // Catch: JSONException -> L32
        b("strong_press_dur", r18);     // Catch: JSONException -> L32
        String r19 = r18.getString("device_allowed");     // Catch: JSONException -> L23
    L96:
        boolean r20 = r18.getBoolean("debug");     // Catch: JSONException -> L27
    L28:
        f12474m = r20;     // Catch: JSONException -> L32
        if (TextUtils.isEmpty(r19) == true) goto L100;
        f12469h = c(r19);     // Catch: JSONException -> L32
    L100:
        JSONObject r21 = r17.getJSONObject("sound");     // Catch: JSONException -> L46
        String r22 = r21.getString("device_allowed");     // Catch: JSONException -> L42
    L44:
        if (TextUtils.isEmpty(r22) == true) goto L94;
        f12470i = c(r22);     // Catch: JSONException -> L46
    L94:
        r5 = r21.getString("device_id_effect_type");     // Catch: JSONException -> L86
    L51:
        if (TextUtils.isEmpty(r5) == true) goto L74;
        String[] r23 = r5.split(";");     // Catch: JSONException -> L46
        if (r23.length <= 0) goto L74;
        int r24 = r23.length;     // Catch: JSONException -> L46
        int r25 = 0;
    L55:
        if (r25 >= r24) goto L74;
        String[] r26 = r23[r25].split(",");     // Catch: JSONException -> L46
    L58:
        if (r26.length != 3) goto L65;
        r11.put(Integer.valueOf(Integer.parseInt(r26[0])), new Pair(Integer.valueOf(Integer.parseInt(r26[1])), Integer.valueOf(Integer.parseInt(r26[2]))));     // Catch: Exception -> L61
    L61:
        e = move-exception;
        if (f12474m == false) goto L65;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration device_id_effect_type error=" + e);     // Catch: JSONException -> L46
    L65:
        r25 = r25 + 1;
    L42:
        r22 = "";
    L46:
        e = move-exception;
        if (f12474m == false) goto L74;
        Log.e("OUIEffectHelper", "onWindowShow: parse sound error=" + e);     // Catch: JSONException -> L37
    L27:
        r20 = false;
    L23:
        r19 = "";
    L32:
        e = move-exception;
        if (f12474m == false) goto L100;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration error=" + e);     // Catch: JSONException -> L37
    L37:
        e = move-exception;
        if (f12474m == false) goto L74;
        Log.e("OUIEffectHelper", "onWindowShow: parse uiConfig error=" + e);
    L74:
        if (f12474m == false) goto L77;
        StringBuilder r110 = j0.x("updateConfig: ", r16, ", sIsDeviceVibrateAllowed=");
        r110.append(f12469h);
        r110.append(", sIsDeviceSoundAllowed=");
        r110.append(f12470i);
        r110.append(", sDeviceType=");
        r110.append(g);
        Log.i("OUIEffectHelper", r110.toString());
    L77:
        if (f12474m == false) goto L109;
        Log.i("OUIEffectHelper", "onWindowShow: mAppEffectEnabled=" + r10);
        return;
    L109:
        return;
    L16:
        r15 = false;
        goto L17
    L112:
        return;
    L111:
        return;
    L79:
        if (r10 == true) goto L82;
        return;
    L82:
        if (f12474m == false) goto L84;
        Log.i("OUIEffectHelper", "onWindowHide: ");
    L84:
        f = false;
    }

    public final void f(boolean r5) {
        if (this.e == true) goto L5;
        return;
    L5:
        View r10 = (View) this.f12476a.get();
        if (r10 != null) goto L9;
        return;
    L9:
        if ((r10.isPressed() ^ r5) == false) goto L14;
        if (r5 == false) goto L12;
        a(false);
        this.f12477b = false;
        return;
    L12:
        r10.postDelayed(new androidx.fragment.app.d(this, 29), 20);
        return;
    }

    public final void g(MotionEvent r5) {
        if (this.e == true) goto L5;
        return;
    L5:
        f12472k = r5.getDeviceId();
    }
}
