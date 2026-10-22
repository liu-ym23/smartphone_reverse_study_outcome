package x4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f13411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f13413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f13414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f13415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k5.g f13416f;

    public f(v r8) {
        this.f13411a = false;
        this.f13412b = 36;
        this.f13414d = new ConcurrentHashMap();
        this.f13415e = new ConcurrentHashMap();
        this.f13413c = r8;
    }

    public static void b(ConcurrentHashMap r8, LinkedHashMap r10) {
        if (r8 != null) goto L20;
        return;
    L20:
        if (r8.isEmpty() == true) goto L33;
        Iterator r11 = r8.entrySet().iterator();     // Catch: Exception -> L19
    L7:
        if (r11.hasNext() == false) goto L35;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Exception -> L19
        if (r12 == null) goto L7;
        String r13 = (String) r12.getKey();     // Catch: Exception -> L19
        String r14 = (String) r12.getValue();     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r13) == true) goto L7;
        if (TextUtils.isEmpty(r14) == true) goto L7;
        r10.put(r13, r14);     // Catch: Exception -> L19
    L35:
        return;
    L33:
        return;
    }

    public final String a(Context r18, StringBuilder r19, o0 r20) {
        String r8 = r19.toString();
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return r8;
    L5:
        Uri r10 = Uri.parse(r8);
        Set<String> r11 = r10.getQueryParameterNames();
        Uri.Builder r12 = r10.buildUpon();
        LinkedHashMap r13 = new LinkedHashMap(this.f13412b);
        String r14 = "android";
        r13.put("device_platform", "android");
        k5.j.a r15 = k5.j.f8942a;
        if (r15.b(new Object[0]).booleanValue() == false) goto L8;
        r14 = "harmony";
    L8:
        r13.put("os", r14);
    L13:
        th = move-exception;
        th.printStackTrace();
    L15:
        r13.put("ssmix", "a");
        r13.put("_rticket", String.valueOf(System.currentTimeMillis()));
        j0 r16 = ((j) this.f13413c).f13451a;
        this.f13413c.getClass();
        String r17 = m.b(r16);
        TextUtils.isEmpty(r17);
        if (TextUtils.isEmpty(r17) == true) goto L18;
        r13.put("cdid", r17);
    L18:
        if (r16 == null) goto L20;
        r6.d r110 = new r6.d(r16);
    L21:
        if (r110 == null) goto L70;
        j0 r111 = (j0) r110.f11536c;
        if (r111 == null) goto L27;
        String r112 = r111.f13470h;
        if (TextUtils.isEmpty(r112) == false) goto L29;
        r112 = r111.f13469g;
    L29:
        if (TextUtils.isEmpty(r112) == true) goto L31;
        r13.put("channel", r112);
    L31:
        j0 r113 = (j0) r110.f11536c;
        long r114 = 0;
        if (r113 == null) goto L34;
        long r115 = r113.f13463a;
    L35:
        r13.put(WsConstants.KEY_APP_ID, String.valueOf(r115));
        j0 r116 = (j0) r110.f11536c;
        if (r116 == null) goto L38;
        String r117 = r116.f13468f;
    L39:
        if (r117 == null) goto L41;
        r13.put("app_name", r117);
    L42:
        j0 r118 = (j0) r110.f11536c;
        if (r118 == null) goto L45;
        long r119 = r118.d();
    L46:
        r13.put("version_code", String.valueOf(r119));
        j0 r120 = (j0) r110.f11536c;
        if (r120 == null) goto L49;
        String r121 = r120.c();
    L50:
        if (r121 == null) goto L52;
        r13.put("version_name", r121);
    L52:
        j0 r122 = (j0) r110.f11536c;
        if (r122 == null) goto L59;
        g r123 = r122.f13476n;
        long r124 = r123.f13423e;
        if (r124 != 0) goto L60;
        PackageInfo r21 = r123.f13425g.b(new Object[0]);
        if (r21 == null) goto L60;
        r124 = r21.versionCode;
    L60:
        r13.put("manifest_version_code", String.valueOf(r124));
        j0 r22 = (j0) r110.f11536c;
        if (r22 == null) goto L68;
        g r23 = r22.f13476n;
        long r125 = r23.f13422d;
        if (r125 != 0) goto L67;
        PackageInfo r24 = r23.f13425g.b(new Object[0]);
        if (r24 == null) goto L67;
        r125 = r24.versionCode;
    L67:
        r114 = r125;
    L69:
        r13.put("update_version_code", String.valueOf(r114));
        goto L70
    L68:
        defpackage.b.l(r110.f11535b);
        goto L69
    L59:
        defpackage.b.l(r110.f11535b);
        r124 = 0;
        goto L60
    L49:
        defpackage.b.l(r110.f11535b);
        r121 = null;
        goto L50
    L45:
        defpackage.b.l(r110.f11535b);
        r119 = 0;
        goto L46
    L41:
        new IllegalArgumentException("app_name is null");
        int r126 = r.f13543a;
        goto L42
    L38:
        defpackage.b.l(r110.f11535b);
        r117 = null;
        goto L39
    L34:
        defpackage.b.l(r110.f11535b);
        r115 = 0;
        goto L35
    L27:
        defpackage.b.l(r110.f11535b);
        r112 = null;
    L70:
        if (r16 == null) goto L75;
        i5.c r25 = (i5.c) i5.d.a(i5.c.class, String.valueOf(r16.f13463a));
        if (r25 == null) goto L75;
        r25.d();
    L75:
        if (TextUtils.isEmpty(k5.q.f8957a) == false) goto L88;
        if (r18 == null) goto L88;
        DisplayMetrics r26 = r18.getResources().getDisplayMetrics();
        if (r26 != null) goto L80;
        int r27 = 0;
    L81:
        DisplayMetrics r127 = r18.getResources().getDisplayMetrics();
        if (r127 != null) goto L84;
        int r128 = 0;
    L85:
        if (r27 <= 0) goto L88;
        if (r128 <= 0) goto L88;
        k5.q.f8957a = r27 + "*" + r128;
        goto L88
    L84:
        r128 = r127.heightPixels;
        goto L85
    L80:
        r27 = r26.widthPixels;
    L88:
        String r28 = k5.q.f8957a;
        if (TextUtils.isEmpty(r28) == true) goto L92;
        r13.put("resolution", r28);
    L92:
        if (k5.q.f8958b != (-1)) goto L95;
        if (r18 == null) goto L95;
        k5.q.f8958b = r18.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
    L95:
        int r29 = k5.q.f8958b;
        if (r29 <= 0) goto L98;
        r13.put("dpi", String.valueOf(r29));
    L98:
        String r30 = Build.BRAND;
        if (r30.equals("Pico") == false) goto L101;
        String r129 = k5.j.a();
    L102:
        r13.put("device_type", r129);
        r13.put(LocationMonitorConst.DEVICE_BRAND, r30);
        r13.put("language", Locale.getDefault().getLanguage());
        r13.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String r31 = Build.VERSION.RELEASE;     // Catch: Exception -> L225
        if (r31 != null) goto L106;
    L108:
        r13.put(CloudServiceConstants.OCloud.HEADER_OS_VERSION, r31);     // Catch: Exception -> L225
        goto L110
    L106:
        if (r31.length() <= 10) goto L108;
        r31 = r31.substring(0, 10);     // Catch: Exception -> L225
    L110:
        if (this.f13416f == null) goto L114;
        String r32 = k5.g.f8938d.name();
        if (TextUtils.isEmpty(r32) == false) goto L116;
    L117:
        b(this.f13414d, r13);
        o0 r33 = o0.f13535a;
        if (r20 != r33) goto L120;
        b(this.f13415e, r13);
    L120:
        boolean r130 = x0.f(r18);
        i0 r131 = ((j) this.f13413c).b();
        boolean r132 = true;
        if (r130 == false) goto L127;
        boolean r133 = this.f13411a;
        if (r133 == true) goto L134;
        r133 = k5.a.a(r18, r16).getBoolean("_install_started_v2", false);
        if (r133 == false) goto L134;
        this.f13411a = true;
    L134:
        if (r133 == true) goto L136;
    L207:
        if (r16 == null) goto L215;
        String r34 = r16.a();
        y4.a r35 = h.f13429a;
        j r36 = j.c(r34);
        if (r36 == null) goto L215;
        boolean r37 = r36.f13452b.F();
        if (r130 == false) goto L215;
        if (r37 == false) goto L215;
        g5.k.c(r18).b();
    L215:
        this.f13413c.getClass();
        Iterator r38 = r13.entrySet().iterator();
    L217:
        if (r38.hasNext() == false) goto L223;
        Map.Entry r39 = (Map.Entry) r38.next();
        String r40 = (String) r39.getKey();
        String r41 = (String) r39.getValue();
        if (r11.contains(r40) == true) goto L217;
        if (TextUtils.isEmpty(r41) == true) goto L217;
        r12.appendQueryParameter(r40, (String) r39.getValue());
        goto L217
    L223:
        r19.delete(0, r19.length());
        r19.append(r12.build().toString());
        this.f13412b = r13.size();
        return r19.toString();
    L136:
        if (r131 != null) goto L138;
    L156:
        if (r20 != r33) goto L207;
        if (r16 == null) goto L182;
        if (r16.f13480r == true) goto L182;
        k5.k.a r42 = k5.k.f8943a;
        String r43 = k5.k.f8947e.b(new Object[]{r18, String.valueOf(r16.f13463a), r16});
        if (TextUtils.isEmpty(r43) == true) goto L163;
        r13.put("mac_address", r43);
    L163:
        String r44 = k5.k.f8943a.b(new Object[]{r18, r16});
        if (TextUtils.isEmpty(r44) == false) goto L167;
    L179:
        if (r132 == true) goto L182;
        r13.put("uuid", r44);
        goto L182
    L167:
        if (r44.equalsIgnoreCase("unknown") == true) goto L179;
        if (r44.equalsIgnoreCase("None") == true) goto L179;
        int r45 = 0;
    L174:
        if (r45 >= r44.length()) goto L179;
        if (r44.charAt(r45) != '0') goto L177;
        r45 = r45 + 1;
        goto L174
    L177:
        r132 = false;
    L182:
        if (d5.a.f6782b == null) goto L184;
    L193:
        String r46 = d5.a.f6782b.f6783a;
        if (TextUtils.isEmpty(r46) == true) goto L196;
        r13.put("aliyun_uuid", r46);
    L196:
        if (r130 == false) goto L207;
        g5.k r47 = g5.k.c(r18);     // Catch: Throwable -> L205
        r47.b();     // Catch: Throwable -> L205
        g5.n r48 = r47.f7662h;     // Catch: Throwable -> L205
        if (r48 == null) goto L200;
        String r49 = r48.f7669a;     // Catch: Throwable -> L205
    L201:
        int r50 = r.f13543a;     // Catch: Throwable -> L205
        if (TextUtils.isEmpty(r49) == true) goto L207;
        r13.put("oaid", r49);     // Catch: Throwable -> L205
        goto L207
    L200:
        r49 = null;
    L205:
        th = move-exception;
        th.printStackTrace();
        goto L207
    L184:
        monitor-enter(d5.a.class);
    L190:
        th = move-exception;
        throw th;
    L186:
        if (d5.a.f6782b != null) goto L188;
        d5.a.f6782b = new d5.a();     // Catch: Throwable -> L190
    L188:
        monitor-exit(d5.a.class);     // Catch: Throwable -> L190
        goto L193
    L138:
        if (TextUtils.isEmpty(null) == true) goto L141;
        r13.put("klink_edi", null);
    L141:
        if (TextUtils.isEmpty(null) == true) goto L144;
        r13.put("klink_eii", null);
    L144:
        if (TextUtils.isEmpty(r131.f13444b) == true) goto L147;
        r13.put(WsConstants.KEY_INSTALL_ID, r131.f13444b);
    L147:
        if (TextUtils.isEmpty(r131.f13443a) == true) goto L150;
        r13.put("device_id", r131.f13443a);
    L150:
        if (TextUtils.isEmpty(r131.f13448p) == true) goto L152;
        r13.put("klink_egdi", r131.f13448p);
    L152:
        if (r20 != r33) goto L156;
        String r134 = r131.f13445m;
        if (TextUtils.isEmpty(r134) == true) goto L156;
        r13.put("openudid", r134);
        goto L156
    L127:
        if (r131 != null) goto L129;
    L133:
        r133 = false;
        goto L134
    L129:
        if (TextUtils.isEmpty(r131.f13443a) == true) goto L133;
        if (TextUtils.isEmpty(r131.f13444b) == true) goto L133;
        r133 = true;
    L116:
        r13.put("ac", r32);
        int r51 = r.f13543a;
        goto L117
    L114:
        r32 = r5.e.b(r18);
        if (TextUtils.isEmpty(r32) == true) goto L117;
    L101:
        r129 = Build.MODEL;
        goto L102
    L20:
        r110 = null;
        goto L21
    L10:
        if (r15.b(new Object[0]).booleanValue() == false) goto L15;
        r13.put("sub_os_api", String.valueOf(k5.n.a("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L13
        goto L15
    }
}
