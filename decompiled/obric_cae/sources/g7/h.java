package g7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h extends i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f7731o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f7732p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f7733q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f7734r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f7735s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7736t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f7737u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f7738v;

    public h() {
        this.f7736t = false;
        this.f7737u = 100;
        this.f7738v = false;
    }

    @Override // g7.i
    public final a.EnumC0079a g(String r10, ArrayList r11) {
        Logger.d("h", "tc action");
        boolean r8 = this.f7738v;
        r11.set(0, r10);
        if (r8 == true) goto L5;
        Uri r12 = Uri.parse(r10);
        boolean r13 = true;
        if (this.f7736t == false) goto L26;
        Logger.d("h", "drop action");
        int r14 = this.f7737u;
        if (r14 >= 100) goto L18;
        if (r14 > 0) goto L14;
    L17:
        r13 = false;
        goto L18
    L14:
        if (new Random().nextInt(100) < this.f7737u) goto L18;
        Logger.d("h", "tc drop action was probabilistic discard");
    L18:
        if (r13 == false) goto L24;
        if (d(r12) == false) goto L24;
        r11.set(0, "");
        return a.EnumC0079a.f7710m;
    L24:
        return a.EnumC0079a.f7708a;
    L26:
        if (this.f7732p.isEmpty() == false) goto L55;
        if (this.f7731o.isEmpty() == false) goto L55;
        if (this.f7733q.isEmpty() == false) goto L55;
        Logger.d("h", "tc full url change");
        ArrayList r15 = this.f7700f;
        if (r15.size() == 1) goto L37;
        return a.EnumC0079a.f7708a;
    L37:
        if (this.f7735s.isEmpty() == true) goto L45;
        if (r12.getPath() == null) goto L45;
        if (r12.getPath().contains(this.f7735s) == true) goto L45;
        return a.EnumC0079a.f7708a;
    L45:
        if (TextUtils.isEmpty(this.f7734r) == true) goto L47;
        String r16 = r10.replaceAll((String) r15.get(0), this.f7734r);
    L49:
        if (r16.equals(r10) == true) goto L51;
        r11.set(0, r16);
        return a.EnumC0079a.f7709b;
    L51:
        return a.EnumC0079a.f7708a;
    L47:
        r16 = r10;
    L55:
        if (d(r12) == false) goto L98;
        if (r12.getScheme() == null) goto L86;
        String r17 = r12.getScheme();
        String r18 = this.f7731o;
        if (TextUtils.isEmpty(r18) == false) goto L62;
    L82:
        r13 = false;
    L83:
        if (r13 == false) goto L86;
        r10 = r10.replaceFirst(r12.getScheme(), this.f7731o);
        goto L86
    L62:
        if (r17.equals(r18) == true) goto L83;
        if (r17.equals("http") == true) goto L69;
        if (r17.equals(LocationInfoConst.HTTPS) == true) goto L69;
    L74:
        if (r17.equals("ws") == true) goto L78;
        if (r17.equals("wss") == false) goto L82;
    L78:
        if (r18.equals("ws") == true) goto L83;
        if (r18.equals("wss") == false) goto L82;
    L69:
        if (r18.equals("http") == true) goto L83;
        if (r18.equals(LocationInfoConst.HTTPS) == false) goto L74;
    L86:
        if (r12.getHost() == null) goto L91;
        if (TextUtils.isEmpty(this.f7732p) == true) goto L91;
        r10 = r10.replaceFirst(r12.getHost(), this.f7732p);
    L91:
        if (r12.getPath() != null) goto L93;
    L95:
        r11.set(0, r10);
        return a.EnumC0079a.f7709b;
    L93:
        if (TextUtils.isEmpty(this.f7733q) == true) goto L95;
        r10 = r10.replaceFirst(r12.getPath(), this.f7733q);
        goto L95
    L98:
        return a.EnumC0079a.f7708a;
    L5:
        return a.EnumC0079a.f7708a;
    }

    @Override // g7.i
    public final int h() {
        return -1;
    }

    @Override // g7.i
    public final boolean i(JSONObject r8, ArrayList r10) {
        e(r8);
        this.f7705k = r8.optString("service_name");
        this.f7731o = r8.optString("scheme_replace");
        this.f7732p = r8.optString("host_replace");
        this.f7733q = r8.optString("path_replace");
        this.f7735s = r8.optString("url_contain");
        this.f7734r = r8.optString("replace");
        if (r8.optInt("drop") != 1) goto L5;
        boolean r11 = true;
    L6:
        this.f7736t = r11;
        int r12 = r8.optInt("possibility", 100);
        if (r12 < 0) goto L11;
        if (r12 > 100) goto L11;
        this.f7737u = r12;
    L11:
        if (this.f7696b.isEmpty() == false) goto L21;
        if (this.f7697c.isEmpty() == false) goto L21;
        if (this.f7698d.isEmpty() == false) goto L21;
        if (this.f7699e.isEmpty() == false) goto L21;
        if (this.f7700f.isEmpty() == false) goto L21;
    L30:
        this.f7738v = true;
    L31:
        r10.set(0, Boolean.FALSE);
        return true;
    L21:
        if (this.f7736t == true) goto L31;
        if (this.f7731o.isEmpty() == false) goto L31;
        if (this.f7732p.isEmpty() == false) goto L31;
        if (this.f7733q.isEmpty() == false) goto L31;
        if (this.f7734r.isEmpty() == false) goto L31;
    L5:
        r11 = false;
        goto L6
    }
}
