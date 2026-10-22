package ac;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import com.obric.cae.R;
import com.obric.cae.smartNetwork.AppQoEManager.AIMediaEventSchema;
import com.sdk.bwdl.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f275f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f276g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f277h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f278i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f279j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f280k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap<Integer, Pair<Integer, Integer>> f281l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f282m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static TypedValue f283n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f288e;

    static {
        String r8 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"ro.pvr.product.name", "Phoenix"});     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r8) == true) goto L5;
    L6:
        f276g = r8;
        f277h = "Phoenix".equals(r8);
        f278i = "Phoenix".equals(r8);
        f279j = true;
        f280k = -1;
        f281l = new HashMap();
        f282m = false;
        return;
    L5:
        r8 = "Phoenix";
        goto L6
    }

    public f(View r8) {
        boolean r10 = true;
        this.f285b = true;
        this.f286c = true;
        this.f287d = true;
        this.f284a = new WeakReference(r8);
        Context r11 = r8.getContext();
        if (f283n != null) goto L5;
        f283n = new TypedValue();
    L5:
        r11.getTheme().resolveAttribute(R.attr.oui_effect_enabled, f283n, true);
        if (f283n.data != 0) goto L9;
        r10 = false;
    L9:
        this.f288e = r10;
    }

    public static int b(String r8, JSONObject r10) {
        return r10.getInt(r8);
    L4:
        return -1;
    }

    public static boolean c(String r8) {
        String[] r10 = r8.split(",");
        if (r10.length <= 0) goto L11;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        if (f276g.equals(r10[r12]) == true) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public final void a(boolean r10) {
        WeakReference<View> r8 = this.f284a;
        if (r8.get() == null) goto L37;
        int r11 = !r10 ? 1 : 0;
        if (f279j == false) goto L16;
        if (this.f286c == false) goto L16;
        r8.get().getContext();
        int r12 = f280k;
        if (f277h == false) goto L16;
        if (r12 < 100000) goto L16;
        if (f282m == false) goto L16;
        Log.i("OUIEffectHelper", "onVibrate: effectType=" + r11 + ", deviceId=" + r12);
    L16:
        if (this.f287d == false) goto L38;
        Context r13 = r8.get().getContext();
        int r14 = f280k;
        if (f278i == false) goto L39;
        if (r14 < 100000) goto L42;
        Pair<Integer, Integer> r15 = f281l.get(Integer.valueOf(r14));
        AudioManager r16 = (AudioManager) r13.getSystemService(AIMediaEventSchema.MEDIA_TYPE_AUDIO);
        if (r15 != null) goto L27;
        if (f282m == false) goto L40;
        Log.i("OUIEffectHelper", "playSoundEffect: pair is empty");
        return;
    L40:
        return;
    L27:
        if (f282m == false) goto L29;
        Log.i("OUIEffectHelper", "playSoundEffect: effectType=" + r11 + ", deviceId=" + r14);
    L29:
        if (r11 != 0) goto L31;
        Object r17 = r15.first;
    L33:
        int r18 = ((Integer) r17).intValue();
    L35:
        r16.playSoundEffect(r18, 1.0f);
        return;
    L31:
        if (r11 != 1) goto L34;
        r17 = r15.second;
        goto L33
    L34:
        r18 = 10;
        goto L35
    L42:
        return;
    L39:
        return;
    L38:
        return;
    }

    public final void d(int r13) {
        String r8 = "";
        if (r13 != 0) goto L75;
        View r14 = this.f284a.get();
        if (r14 != null) goto L7;
        return;
    L7:
        if (r14.getContext() != null) goto L9;
        return;
    L9:
        if (f275f == true) goto L104;
        f275f = true;
        Context r15 = r14.getContext();
        HashMap<Integer, Pair<Integer, Integer>> r10 = f281l;
        r10.clear();
        Settings.Global.getInt(r15.getContentResolver(), "controller_vibration_level", 0);
        if (Settings.Global.getInt(r15.getContentResolver(), "system_vibration_enabled", 1) != 1) goto L14;
        boolean r11 = true;
    L15:
        f279j = r11;
        String r16 = Settings.Global.getString(r15.getContentResolver(), "pvr_ui_config");
        if (TextUtils.isEmpty(r16) == true) goto L69;
        JSONObject r12 = new JSONObject(r16);     // Catch: JSONException -> L64
        JSONObject r17 = r12.getJSONObject("vibration");     // Catch: JSONException -> L30
        b("def_hover_fre", r17);     // Catch: JSONException -> L30
        b("def_hover_level", r17);     // Catch: JSONException -> L30
        b("def_hover_dur", r17);     // Catch: JSONException -> L30
        b("def_press_fre", r17);     // Catch: JSONException -> L30
        b("def_press_level", r17);     // Catch: JSONException -> L30
        b("def_press_dur", r17);     // Catch: JSONException -> L30
        b("weak_hover_fre", r17);     // Catch: JSONException -> L30
        b("weak_hover_level", r17);     // Catch: JSONException -> L30
        b("weak_hover_dur", r17);     // Catch: JSONException -> L30
        b("weak_press_fre", r17);     // Catch: JSONException -> L30
        b("weak_press_level", r17);     // Catch: JSONException -> L30
        b("weak_press_dur", r17);     // Catch: JSONException -> L30
        b("strong_hover_fre", r17);     // Catch: JSONException -> L30
        b("strong_hover_level", r17);     // Catch: JSONException -> L30
        b("strong_hover_dur", r17);     // Catch: JSONException -> L30
        b("strong_press_fre", r17);     // Catch: JSONException -> L30
        b("strong_press_level", r17);     // Catch: JSONException -> L30
        b("strong_press_dur", r17);     // Catch: JSONException -> L30
        String r18 = r17.getString("device_allowed");     // Catch: JSONException -> L21
    L85:
        boolean r19 = r17.getBoolean(BuildConfig.BUILD_TYPE);     // Catch: JSONException -> L25
    L26:
        f282m = r19;     // Catch: JSONException -> L30
        if (TextUtils.isEmpty(r18) == true) goto L91;
        f277h = c(r18);     // Catch: JSONException -> L30
    L91:
        JSONObject r20 = r12.getJSONObject("sound");     // Catch: JSONException -> L59
        String r21 = r20.getString("device_allowed");     // Catch: JSONException -> L37
    L39:
        if (TextUtils.isEmpty(r21) == true) goto L89;
        f278i = c(r21);     // Catch: JSONException -> L59
    L89:
        r8 = r20.getString("device_id_effect_type");     // Catch: JSONException -> L79
    L44:
        if (TextUtils.isEmpty(r8) == true) goto L69;
        String[] r22 = r8.split(";");     // Catch: JSONException -> L59
        if (r22.length <= 0) goto L69;
        int r23 = r22.length;     // Catch: JSONException -> L59
        int r24 = 0;
    L48:
        if (r24 >= r23) goto L69;
        String[] r25 = r22[r24].split(",");     // Catch: JSONException -> L59
    L51:
        if (r25.length != 3) goto L58;
        r10.put(Integer.valueOf(Integer.parseInt(r25[0])), new Pair(Integer.valueOf(Integer.parseInt(r25[1])), Integer.valueOf(Integer.parseInt(r25[2]))));     // Catch: Exception -> L54
    L54:
        e = move-exception;
        if (f282m == false) goto L58;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration device_id_effect_type error=" + e);     // Catch: JSONException -> L59
    L58:
        r24 = r24 + 1;
    L37:
        r21 = "";
    L59:
        e = move-exception;
        if (f282m == false) goto L69;
        Log.e("OUIEffectHelper", "onWindowShow: parse sound error=" + e);     // Catch: JSONException -> L64
    L25:
        r19 = false;
    L21:
        r18 = "";
    L30:
        e = move-exception;
        if (f282m == false) goto L91;
        Log.e("OUIEffectHelper", "onWindowShow: parse vibration error=" + e);     // Catch: JSONException -> L64
    L64:
        e = move-exception;
        if (f282m == false) goto L69;
        Log.e("OUIEffectHelper", "onWindowShow: parse uiConfig error=" + e);
    L69:
        if (f282m == false) goto L72;
        StringBuilder r110 = defpackage.b.h("updateConfig: ", r16, ", sIsDeviceVibrateAllowed=");
        r110.append(f277h);
        r110.append(", sIsDeviceSoundAllowed=");
        r110.append(f278i);
        r110.append(", sDeviceType=");
        r110.append(f276g);
        Log.i("OUIEffectHelper", r110.toString());
    L72:
        if (f282m == false) goto L102;
        Log.i("OUIEffectHelper", "onWindowShow: mAppEffectEnabled=" + this.f288e);
        return;
    L102:
        return;
    L14:
        r11 = false;
        goto L15
    L104:
        return;
    L75:
        if (f282m == false) goto L77;
        Log.i("OUIEffectHelper", "onWindowHide: ");
    L77:
        f275f = false;
    }

    public final void e(boolean r8) {
        if (this.f288e == true) goto L5;
        return;
    L5:
        View r10 = this.f284a.get();
        if (r10 != null) goto L9;
        return;
    L9:
        if ((r10.isPressed() ^ r8) == false) goto L14;
        if (r8 == false) goto L12;
        a(false);
        this.f285b = false;
        return;
    L12:
        r10.postDelayed(new com.ttnet.org.chromium.net.a(this, 1), 20);
        return;
    }
}
