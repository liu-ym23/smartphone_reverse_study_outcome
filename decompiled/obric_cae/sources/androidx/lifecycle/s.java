package androidx.lifecycle;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.work.impl.WorkDatabase;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.oui.calendar.CalendarDay;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;
import x4.s0;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class s implements x4.b0, yb.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static s f2193c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2194b;

    public s(int r8) {
        if (r8 != 3) goto L5;
        c4.i r10 = new c4.i();
        this.f2194b = r10;
        r10.f3345g = System.currentTimeMillis();
        return;
    L5:
        if (r8 != 4) goto L7;
        this.f2194b = new CopyOnWriteArrayList();
        h4.a.f7906a.add(this);
        return;
    L7:
        if (r8 != 5) goto L9;
        this.f2194b = new CopyOnWriteArrayList();
        return;
    L9:
        if (r8 != 6) goto L11;
        this.f2194b = new x4.o();
        return;
    L11:
        if (r8 == 9) goto L14;
        this.f2194b = new HashMap();
        return;
    L14:
        this.f2194b = BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 3);
    }

    @Override // yb.f
    public final CharSequence a(CalendarDay r8) {
        return new SpannableStringBuilder().append(((CharSequence[]) this.f2194b)[r8.w() - 1]).append(" ").append(String.valueOf(r8.x()));
    }

    public final void b(JSONObject r8, x4.s r10) {
        int r11 = 2;
        if (r10.f13378a == false) goto L5;
        r8.put("scene", 2);
    L5:
        r8.put("device_platform", "android");
        boolean r12 = k5.j.f8942a.b(new Object[0]).booleanValue();
        if (r12 == false) goto L9;
        Object r13 = "Harmony";
    L67:
        r8.put("os", r13);     // Catch: JSONException -> L12
    L14:
        if (r12 == false) goto L25;
        JSONObject r14 = new JSONObject();
        r14.put("os_api", k5.n.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L19
        r14.put(CloudServiceConstants.OCloud.HEADER_OS_VERSION, k5.n.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L19
        r14.put("release_type", k5.n.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L19
    L59:
        r8.put("harmony", r14);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = move-exception;
        th.printStackTrace();
    L25:
        r8.put("git_hash", "b416399");
        r8.put("sdk_version_code", x4.r.f13543a);
        r8.put("sdk_target_version", 30);
        r8.put("req_id", (String) k5.i.f8941a.b(new Object[0]));
        r8.put("sdk_version", "4.3.2-rc.13");
        x4.j0 r15 = (x4.j0) this.f2194b;
        r8.put("guest_mode", r15.f13480r ? 1 : 0);
        r8.put("sdk_flavor", "cnInner");
        if (k5.a.a(r15.f13465c, r15).getBoolean("is_migrate", false) == false) goto L34;
        String r16 = k5.a.a(r15.f13465c, r15).getString("old_did", null);
        if (TextUtils.isEmpty(r16) == false) goto L65;
        r16 = "";
    L65:
        r8.put("old_did", r16);     // Catch: JSONException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L34:
        Context r17 = r15.f13465c;
        PackageInfo r18 = r17.getPackageManager().getPackageInfo(r17.getPackageName(), 0);     // Catch: Throwable -> L43
        if (r18 == null) goto L45;
        r8.put("apk_first_install_time", r18.firstInstallTime);     // Catch: Throwable -> L43
        if ((r18.applicationInfo.flags & 1) != 1) goto L40;
        int r19 = 1;
    L41:
        r8.put("is_system_app", r19);     // Catch: Throwable -> L43
        goto L45
    L40:
        r19 = 0;
    L45:
        i5.c r20 = (i5.c) i5.d.a(i5.c.class, String.valueOf(r15.f13463a));
        if (r20 == null) goto L48;
        r20.b();
    L48:
        b5.c r21 = k5.c.b().d(r15.f13463a);
        b5.a r22 = k5.c.b().a(r15.f13463a);
        if (r10.f13378a == false) goto L52;
    L55:
        r21.f3070i = r11;
        r22.f3058h = r11;
        if (r20 == null) goto L69;
        r21.f3069h = r20.a() ? 1 : 0;
        r22.f3057g = r20.a() ? 1 : 0;
        return;
    L69:
        return;
    L52:
        if (r15.f13480r == false) goto L54;
        r11 = 1;
        goto L55
    L54:
        r11 = 0;
    L43:
        th = move-exception;
        th.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L9:
        r13 = LocationInfoConst.SYSTEM;
        goto L67
    }

    public final BaseLocate c(int r8) {
        if (BDLocationConfig.isMockEnable() == false) goto L7;
        return BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 4);
    L7:
        if (r8 != 3) goto L9;
        BaseLocate r10 = (BaseLocate) this.f2194b;
    L10:
        if (r10 == null) goto L12;
        return r10;
    L12:
        return BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), r8);
    L9:
        r10 = null;
        goto L10
    }

    @Override // x4.b0
    public final String get(String r8, Map r10) {
        ((x4.o) this.f2194b).getClass();
        f5.a r11 = x4.o.a(0, r8, (HashMap) r10, null);
        if (r11 != null) goto L5;
        return "";
    L5:
        return (String) r11.f7328e;
    }

    @Override // x4.b0
    public final String post(String r8, byte[] r10, Map r11) {
        ((x4.o) this.f2194b).getClass();
        f5.a r12 = x4.o.a(1, r8, (HashMap) r11, r10);
        if (r12 != null) goto L5;
        return "";
    L5:
        return (String) r12.f7328e;
    }

    @Override // x4.b0
    public final byte[] postStream(String r8, byte[] r10, Map r11) {
        ((x4.o) this.f2194b).getClass();
        int r12 = x4.r.f13543a;
        x4.o.a r13 = new x4.o.a();
        ByteArrayOutputStream r14 = null;
        HttpURLConnection r15 = (HttpURLConnection) new URL(r8).openConnection();     // Catch: Throwable -> L43
        r15.setDoOutput(true);     // Catch: Throwable -> L43
        r15.setRequestMethod(x4.o.f13533a[1]);     // Catch: Throwable -> L43
        HashMap r16 = (HashMap) r11;     // Catch: Throwable -> L43
        if (r16.isEmpty() == true) goto L14;
        Iterator r17 = r16.entrySet().iterator();     // Catch: Throwable -> L43
    L7:
        if (r17.hasNext() == false) goto L14;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L43
        if (TextUtils.isEmpty((CharSequence) r18.getKey()) == true) goto L13;
        if (TextUtils.isEmpty((CharSequence) r18.getValue()) == true) goto L13;
        r15.addRequestProperty((String) r18.getKey(), (String) r18.getValue());     // Catch: Throwable -> L43
    L13:
        int r19 = x4.r.f13543a;     // Catch: Throwable -> L43
    L14:
        r15.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L43
        if (r10 != null) goto L17;
    L20:
        DataOutputStream r20 = null;
    L21:
        int r21 = r15.getResponseCode();     // Catch: Throwable -> L41
        if (r21 != 200) goto L40;
        InputStream r22 = r15.getInputStream();     // Catch: Throwable -> L41
        if ("gzip".equalsIgnoreCase(r15.getContentEncoding()) == true) goto L26;
    L60:
        ByteArrayOutputStream r23 = new ByteArrayOutputStream();     // Catch: Throwable -> L37
        byte[] r24 = new byte[1024];     // Catch: Throwable -> L35
    L30:
        int r25 = r22.read(r24);     // Catch: Throwable -> L35
        if (r25 == (-1)) goto L33;
        r23.write(r24, 0, r25);     // Catch: Throwable -> L35
        goto L30
    L33:
        r13.f13534a = r23.toByteArray();     // Catch: Throwable -> L35
    L48:
        x0.c(r20);
        x0.c(r22);
        x0.c(r23);
        return r13.f13534a;
    L35:
        s0 th = th;
        r14 = r23;
    L55:
        int r26 = x4.r.f13543a;     // Catch: Throwable -> L52
        if ((th instanceof s0) == true) goto L51;
        r23 = r14;
        goto L48
    L51:
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        x0.c(r20);
        x0.c(r22);
        x0.c(r14);
        throw th;
    L37:
        th = move-exception;
        th = th;
        goto L55
    L26:
        r22 = new GZIPInputStream(r22);     // Catch: Throwable -> L41
        goto L60
    L40:
        throw new s0(r21, r15.getResponseMessage());     // Catch: Throwable -> L41
    L17:
        if (r10.length <= 0) goto L20;
        r20 = new DataOutputStream(r15.getOutputStream());     // Catch: Throwable -> L43
        r20.write(r10);     // Catch: Throwable -> L41
        r20.flush();     // Catch: Throwable -> L41
        r20.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th = th;
        r22 = null;
    L43:
        th = move-exception;
        th = th;
        r22 = null;
        r20 = null;
        goto L55
    }

    public s(ViewGroup r8) {
        this.f2194b = r8.getOverlay();
    }

    public s(WorkDatabase r8) {
        he.i.f(r8, "workDatabase");
        this.f2194b = r8;
    }

    public /* synthetic */ s(Object r8) {
        this.f2194b = r8;
    }

    public s(CharSequence[] r8) {
        if (r8 == null) goto L11;
        if (r8.length < 12) goto L9;
        this.f2194b = r8;
        return;
    L9:
        throw new IllegalArgumentException("Label array is too short");
    L11:
        throw new IllegalArgumentException("Label array cannot be null");
    }
}
