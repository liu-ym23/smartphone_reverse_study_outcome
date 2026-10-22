package d4;

import android.content.SharedPreferences;
import android.text.TextUtils;
import c4.e;
import c4.l;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import i4.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k5.n;
import org.json.JSONException;
import org.json.JSONObject;
import u3.g;
import v4.f;
import v4.i;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<String> f6773h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f6774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f6775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f6777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile JSONObject f6778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedPreferences f6779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r3.c f6780g;

    public class a implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f6781a;

        public a(d r8) {
            this.f6781a = r8;
        }

        @Override // c4.e.b
        public final JSONObject a() {
            JSONObject r8 = new JSONObject();
            v4.e.b(this.f6781a.f6778e, r8);
            r8.put("appId", this.f6781a.f6780g.f11401i);     // Catch: Throwable -> L5
        L6:
            return r8;
        L5:
            this.f6781a.f6780g.f11417y.b(k.X, 1);
            goto L6
        }
    }

    static {
        f6773h = Collections.singletonList("DeviceManager");
    }

    public d(r3.c r8, c r10, u3.e r11) {
        this.f6776c = false;
        this.f6780g = r8;
        this.f6777d = r10;
        this.f6774a = r11;
        this.f6779f = r10.f6761e;
        this.f6778e = new JSONObject();
    }

    public static boolean c(JSONObject r8) {
        if (r8 == null) goto L8;
        String r10 = r8.optString("device_id", "");
        String r11 = r8.optString("install_id", "");
        if (i.a(r10) == false) goto L8;
        if (i.a(r11) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final JSONObject a() {
        return i.e(this.f6778e);
    }

    public final Object b(String r8, JSONObject r10) {
        if ("custom".equals(r8) == false) goto L6;
        this.f6780g.getClass();
    L6:
        return r10.opt(r8);
    }

    public final void d(JSONObject r8) {
        List<String> r10 = f6773h;
        r3.c r11 = this.f6780g;
        boolean r12 = f.f12727a.b(new Object[0]).booleanValue();
        if (r12 == false) goto L6;
        String r13 = "Harmony";
    L18:
        r8.put(WsConstants.KEY_PLATFORM, r13);     // Catch: JSONException -> L9
    L11:
        if (r12 == true) goto L20;
        return;
    L20:
        r8.put("harmony_os_api", n.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L15
        r8.put("harmony_os_version", n.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L15
        r8.put("harmony_release_type", n.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        r11.H.l(0, r10, "loadHarmonyInfo failed", new Object[]{th});
        return;
    L9:
        e = move-exception;
        r11.H.i(r10, "loadHarmonyInfo failed", e, new Object[0]);
        goto L11
    L6:
        r13 = LocationInfoConst.SYSTEM;
        goto L18
    }

    public final void e(JSONObject r10) {
        this.f6780g.H.l(0, f6773h, "updateHeader: {}", new Object[]{r10});
        JSONObject r8 = new JSONObject();
        r3.c r11 = this.f6780g;
        if (r11.f11405m != null) goto L5;
        String r12 = null;
    L6:
        monitor-enter(this);
        i.d(r8, this.f6778e);     // Catch: Throwable -> L36
        Iterator<String> r13 = r10.keys();     // Catch: Throwable -> L36
    L9:
        if (r13.hasNext() == false) goto L39;
        String r14 = r13.next();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r14) == true) goto L9;
        r8.put(r14, b(r14, r10));     // Catch: JSONException -> L15 Throwable -> L36
    L15:
        e = move-exception;
        this.f6780g.H.i(null, "updateHeader put header key:{} value failed", null, new Object[]{r14, e});     // Catch: Throwable -> L36
        goto L9
    L39:
        r8.put("sdk_version", 5071590);     // Catch: Throwable -> L24
        r8.put("sdk_version_code", v4.g.f12728a);     // Catch: Throwable -> L24
        r8.put("sdk_version_name", "5.7.15");     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r12) == true) goto L22;
        r8.put("ab_sdk_version", r12);     // Catch: Throwable -> L24
    L22:
        d(r8);     // Catch: Throwable -> L24
    L26:
        Iterator r15 = this.f6780g.J.iterator();     // Catch: Throwable -> L36
    L28:
        if (r15.hasNext() == false) goto L30;
        r8.remove((String) r15.next());     // Catch: Throwable -> L36
        goto L28
    L30:
        this.f6778e = r8;     // Catch: Throwable -> L36
        this.f6775b = true;     // Catch: Throwable -> L36
        this.f6776c = c(this.f6778e);     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L36
        SharedPreferences.Editor r16 = this.f6779f.edit();
        r16.putLong("version_code", this.f6778e.optLong("version_code", 0));
        r16.putString("channel", this.f6778e.optString("channel", ""));
        r16.apply();
        if (l.b() == true) goto L51;
        l.c("set_header", new a(this));
        return;
    L51:
        return;
    L24:
        th = move-exception;
        this.f6780g.H.i(null, "updateHeader put header sdk version or load harmony info failed", th, new Object[0]);     // Catch: Throwable -> L36
        this.f6780g.f11417y.b(k.X, 1);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L5:
        String.valueOf(r11.f11405m.f13945u.f13975a);
        r12 = r11.b();
        goto L6
    }
}
