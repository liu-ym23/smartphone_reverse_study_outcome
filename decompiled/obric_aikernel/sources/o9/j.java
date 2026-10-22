package o9;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static boolean A = false;
    private static int B = 0;
    private static boolean C = false;
    private static int D = 0;
    private static HashMap<Integer, Pair<Integer, Integer>> E = null;
    public static boolean F = false;
    private static TypedValue G = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f11526f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f11527g = 177;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f11528h = 33;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f11529i = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f11530j = 127;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f11531k = 204;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f11532l = 15;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f11533m = 355;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f11534n = 38;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f11535o = 6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f11536p = 255;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static int f11537q = 102;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f11538r = 18;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static int f11539s = 88;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static int f11540t = 76;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static int f11541u = 5;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static int f11542v = 63;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static int f11543w = 204;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static int f11544x = 8;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f11545y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static boolean f11546z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f11547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11551e;

    static {
        String r10 = i("ro.pvr.product.name", "Phoenix");
        f11545y = r10;
        f11546z = "Phoenix".equals(r10);
        A = "Phoenix".equals(f11545y);
        B = 0;
        C = true;
        D = -1;
        E = new HashMap();
        F = false;
    }

    public j(View r10) {
        this.f11548b = true;
        this.f11549c = true;
        this.f11550d = true;
        this.f11547a = new WeakReference(r10);
        this.f11551e = e(r10.getContext(), u8.b.oui_effect_enabled);
    }

    public static /* synthetic */ void a(j r10) {
        r10.l();
    }

    private void b(boolean r10) {
        if (this.f11547a.get() == null) goto L13;
        int r11 = !r10 ? 1 : 0;
        if (C == false) goto L10;
        if (this.f11549c == false) goto L10;
        p(this.f11547a.get().getContext(), r11, D);
    L10:
        if (this.f11550d == false) goto L14;
        t(this.f11547a.get().getContext(), r11, D);
        return;
    L14:
        return;
    }

    private static boolean e(Context r10, int r11) {
        if (G != null) goto L5;
        G = new TypedValue();
    L5:
        r10.getTheme().resolveAttribute(r11, G, true);
        if (G.data != 0) goto L10;
        return false;
    L10:
        return true;
    }

    private static boolean f(JSONObject r10, String r11) {
        return r10.getBoolean(r11);
    L4:
        return false;
    }

    private static int g(JSONObject r10, String r11) {
        return r10.getInt(r11);
    L4:
        return -1;
    }

    private static String h(JSONObject r10, String r11) {
        return r10.getString(r11);
    L4:
        return "";
    }

    public static String i(String r10, String r11) {
        String r12 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r10, r11});     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r12) == false) goto L7;
        return r11;
    L7:
        return r12;
    L12:
        return r11;
    }

    private static void j(Context r10, int r11, int[] r12) {
        int r13 = B;
        if (r13 != 2) goto L8;
        if (r11 != 0) goto L6;
        r12[0] = f11540t;
        r12[1] = f11539s;
        r12[2] = f11541u;
        return;
    L6:
        if (r11 != 1) goto L19;
        r12[0] = f11543w;
        r12[1] = f11542v;
        r12[2] = f11544x;
        return;
    L19:
        return;
    L8:
        if (r13 != 1) goto L13;
        if (r11 != 0) goto L11;
        r12[0] = f11534n;
        r12[1] = f11533m;
        r12[2] = f11535o;
        return;
    L11:
        if (r11 != 1) goto L22;
        r12[0] = f11537q;
        r12[1] = f11536p;
        r12[2] = f11538r;
        return;
    L22:
        return;
    L13:
        if (r11 != 0) goto L15;
        r12[0] = f11528h;
        r12[1] = f11527g;
        r12[2] = f11529i;
        return;
    L15:
        if (r11 != 1) goto L25;
        r12[0] = f11531k;
        r12[1] = f11530j;
        r12[2] = f11532l;
        return;
    }

    private static boolean k(String r10) {
        String[] r11 = r10.split(",");
        if (r11.length <= 0) goto L11;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        if (f11545y.equals(r11[r13]) == true) goto L8;
        r13 = r13 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    private /* synthetic */ void l() {
        this.f11548b = true;
    }

    public static void p(Context r10, int r11, int r12) {
        if (f11546z == true) goto L5;
        return;
    L5:
        if (r12 >= 100000) goto L8;
        return;
    L8:
        if (F == false) goto L11;
        Log.i("OUIEffectHelper", "onVibrate: effectType=" + r11 + ", deviceId=" + r12);
    L11:
        if (r12 != 100001) goto L14;
    L15:
        j(r10, r11, new int[3]);
        return;
    L14:
        if (r12 == 100002) goto L15;
    }

    public static void t(Context r10, int r11, int r12) {
        if (A == true) goto L5;
        return;
    L5:
        if (r12 < 100000) goto L27;
        Pair<Integer, Integer> r13 = E.get(Integer.valueOf(r12));
        AudioManager r14 = (AudioManager) r10.getSystemService("audio");
        if (r13 != null) goto L14;
        if (F == false) goto L25;
        Log.i("OUIEffectHelper", "playSoundEffect: pair is empty");
        return;
    L25:
        return;
    L14:
        if (F == false) goto L16;
        Log.i("OUIEffectHelper", "playSoundEffect: effectType=" + r11 + ", deviceId=" + r12);
    L16:
        int r15 = 10;
        if (r11 != 0) goto L21;
        Object r16 = r13.first;
    L19:
        r15 = ((Integer) r16).intValue();
    L23:
        r14.playSoundEffect(r15, 1.0f);
        return;
    L21:
        if (r11 != 1) goto L23;
        r16 = r13.second;
        goto L19
    }

    public static void x(Context r12) {
        E.clear();
        B = Settings.Global.getInt(r12.getContentResolver(), "controller_vibration_level", 0);
        if (Settings.Global.getInt(r12.getContentResolver(), "system_vibration_enabled", 1) != 1) goto L5;
        boolean r10 = true;
    L6:
        C = r10;
        String r13 = Settings.Global.getString(r12.getContentResolver(), "pvr_ui_config");
        if (TextUtils.isEmpty(r13) == true) goto L46;
        JSONObject r11 = new JSONObject(r13);     // Catch: JSONException -> L41
        JSONObject r14 = r11.getJSONObject("vibration");     // Catch: JSONException -> L13
        f11527g = g(r14, "def_hover_fre");     // Catch: JSONException -> L13
        f11528h = g(r14, "def_hover_level");     // Catch: JSONException -> L13
        f11529i = g(r14, "def_hover_dur");     // Catch: JSONException -> L13
        f11530j = g(r14, "def_press_fre");     // Catch: JSONException -> L13
        f11531k = g(r14, "def_press_level");     // Catch: JSONException -> L13
        f11532l = g(r14, "def_press_dur");     // Catch: JSONException -> L13
        f11533m = g(r14, "weak_hover_fre");     // Catch: JSONException -> L13
        f11534n = g(r14, "weak_hover_level");     // Catch: JSONException -> L13
        f11535o = g(r14, "weak_hover_dur");     // Catch: JSONException -> L13
        f11536p = g(r14, "weak_press_fre");     // Catch: JSONException -> L13
        f11537q = g(r14, "weak_press_level");     // Catch: JSONException -> L13
        f11538r = g(r14, "weak_press_dur");     // Catch: JSONException -> L13
        f11539s = g(r14, "strong_hover_fre");     // Catch: JSONException -> L13
        f11540t = g(r14, "strong_hover_level");     // Catch: JSONException -> L13
        f11541u = g(r14, "strong_hover_dur");     // Catch: JSONException -> L13
        f11542v = g(r14, "strong_press_fre");     // Catch: JSONException -> L13
        f11543w = g(r14, "strong_press_level");     // Catch: JSONException -> L13
        f11544x = g(r14, "strong_press_dur");     // Catch: JSONException -> L13
        String r15 = h(r14, "device_allowed");     // Catch: JSONException -> L13
        F = f(r14, "debug");     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r15) == true) goto L49;
        f11546z = k(r15);     // Catch: JSONException -> L13
    L49:
        JSONObject r16 = r11.getJSONObject("sound");     // Catch: JSONException -> L36
        String r17 = h(r16, "device_allowed");     // Catch: JSONException -> L36
        if (TextUtils.isEmpty(r17) == true) goto L20;
        A = k(r17);     // Catch: JSONException -> L36
    L20:
        String r18 = h(r16, "device_id_effect_type");     // Catch: JSONException -> L36
        if (TextUtils.isEmpty(r18) == true) goto L46;
        String[] r19 = r18.split(";");     // Catch: JSONException -> L36
        if (r19.length <= 0) goto L46;
        int r20 = r19.length;     // Catch: JSONException -> L36
        int r21 = 0;
    L25:
        if (r21 >= r20) goto L46;
        String[] r22 = r19[r21].split(",");     // Catch: JSONException -> L36
    L28:
        if (r22.length != 3) goto L35;
        E.put(Integer.valueOf(Integer.parseInt(r22[0])), new Pair(Integer.valueOf(Integer.parseInt(r22[1])), Integer.valueOf(Integer.parseInt(r22[2]))));     // Catch: Exception -> L31
    L31:
        e = move-exception;
        if (F == false) goto L35;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration device_id_effect_type error=" + e);     // Catch: JSONException -> L36
    L35:
        r21 = r21 + 1;
    L36:
        e = move-exception;
        if (F == false) goto L46;
        Log.e("OUIEffectHelper", "onWindowShow: parse sound error=" + e);     // Catch: JSONException -> L41
    L13:
        e = move-exception;
        if (F == false) goto L49;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration error=" + e);     // Catch: JSONException -> L41
    L41:
        e = move-exception;
        if (F == false) goto L46;
        Log.e("OUIEffectHelper", "onWindowShow: parse uiConfig error=" + e);
    L46:
        if (F == false) goto L62;
        Log.i("OUIEffectHelper", "updateConfig: " + r13 + ", sIsDeviceVibrateAllowed=" + f11546z + ", sIsDeviceSoundAllowed=" + A + ", sDeviceType=" + f11545y);
        return;
    L62:
        return;
    L5:
        r10 = false;
        goto L6
    }

    private void y(MotionEvent r10) {
        D = r10.getDeviceId();
    }

    public void c(MotionEvent r10) {
        y(r10);
    }

    public void d(MotionEvent r10) {
        y(r10);
    }

    public void m() {
    }

    public void n() {
    }

    public void o(boolean r10) {
        if (this.f11551e == true) goto L5;
        return;
    L5:
        if (r10 == true) goto L7;
        return;
    L7:
        if (this.f11548b == false) goto L11;
        b(true);
        return;
    }

    public void q() {
        if (F == false) goto L5;
        Log.i("OUIEffectHelper", "onWindowHide: ");
    L5:
        f11526f = false;
    }

    public void r() {
        View r10 = this.f11547a.get();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getContext() != null) goto L7;
        return;
    L7:
        if (f11526f == true) goto L16;
        f11526f = true;
        x(r10.getContext());
        if (F == false) goto L15;
        Log.i("OUIEffectHelper", "onWindowShow: mAppEffectEnabled=" + this.f11551e);
        return;
    L15:
        return;
    }

    public void s(int r10) {
        if (r10 != 0) goto L4;
        r();
        return;
    L4:
        q();
    }

    public void u(boolean r10) {
        if (this.f11551e == true) goto L5;
        return;
    L5:
        View r11 = this.f11547a.get();
        if (r11 != null) goto L9;
        return;
    L9:
        if ((r11.isPressed() ^ r10) == false) goto L14;
        if (r10 == false) goto L12;
        b(false);
        this.f11548b = false;
        return;
    L12:
        r11.postDelayed(new i(this), 20);
        return;
    }

    public void v(boolean r10) {
        this.f11550d = r10;
    }

    public void w(boolean r10) {
        this.f11549c = r10;
    }
}
