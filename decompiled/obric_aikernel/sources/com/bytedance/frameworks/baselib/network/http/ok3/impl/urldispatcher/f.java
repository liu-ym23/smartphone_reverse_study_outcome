package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.net.NetError;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends g {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f1828z = "f";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f1829q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f1830r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f1831s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f1832t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f1833u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f1834v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f1835w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f1836x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f1837y;

    static {
    }

    public f() {
        this.f1834v = false;
        this.f1835w = NetError.ERR_TTNET_TRAFFIC_CONTROL_DROP;
        this.f1836x = 100;
        this.f1837y = false;
    }

    private boolean x(String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return false;
    L6:
        if (r10.equals(r11) == false) goto L9;
        return true;
    L9:
        if (r10.equals("http") == true) goto L13;
        if (r10.equals("https") == true) goto L13;
    L18:
        if (r10.equals("ws") == true) goto L22;
        if (r10.equals("wss") == true) goto L22;
    L26:
        return false;
    L22:
        if (r11.equals("ws") == false) goto L24;
    L27:
        return true;
    L24:
        if (r11.equals("wss") == false) goto L26;
    L13:
        if (r11.equals("http") == true) goto L27;
        if (r11.equals("https") == false) goto L18;
        goto L27
    }

    private boolean y() {
        int r10 = this.f1836x;
        if (r10 < 100) goto L6;
        return true;
    L6:
        if (r10 > 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(100) >= this.f1836x) goto L12;
        return true;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(f1828z, "tc drop action was probabilistic discard");
    L14:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g
    public BaseDispatchAction.DispatchResultEnum r(y2.c r10, String r11, List<String> r12) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f1828z, "tc action");
    L5:
        Uri r13 = Uri.parse(r11);
        if (this.f1837y == false) goto L8;
    L53:
        r12.set(0, r11);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L8:
        if (i(r13) == false) goto L53;
        r12.set(0, r11);
        if (this.f1834v == false) goto L22;
        if (Logger.debug() == false) goto L16;
        Logger.d(f1828z, "drop action");
    L16:
        if (y() == false) goto L20;
        r12.set(0, "");
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP;
    L20:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L22:
        if (this.f1830r.isEmpty() == false) goto L37;
        if (this.f1829q.isEmpty() == false) goto L37;
        if (this.f1831s.isEmpty() == false) goto L37;
        if (TextUtils.isEmpty(this.f1833u) == true) goto L35;
        if (TextUtils.isEmpty(this.f1832t) == true) goto L35;
        r12.set(0, r11.replaceAll(this.f1832t, this.f1833u));
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
    L35:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L37:
        if (r13.getScheme() == null) goto L42;
        if (x(r13.getScheme(), this.f1829q) == false) goto L42;
        r11 = r11.replaceFirst(r13.getScheme(), this.f1829q);
    L42:
        if (r13.getHost() == null) goto L47;
        if (TextUtils.isEmpty(this.f1830r) == true) goto L47;
        r11 = r11.replaceFirst(r13.getHost(), this.f1830r);
    L47:
        if (r13.getPath() != null) goto L49;
    L51:
        r12.set(0, r11);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
    L49:
        if (TextUtils.isEmpty(this.f1831s) == true) goto L51;
        r11 = r11.replaceFirst(r13.getPath(), this.f1831s);
        goto L51
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g
    public int s() {
        return -1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g
    public int t() {
        return this.f1835w;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g
    protected boolean u(JSONObject r10, List<Boolean> r11, String r12, long r13) {
        k(r10);
        this.f1812l = r10.optString("service_name");
        this.f1829q = r10.optString("scheme_replace");
        this.f1830r = r10.optString("host_replace");
        this.f1831s = r10.optString("path_replace");
        String r14 = r10.optString("replace");
        this.f1833u = r14;
        if (TextUtils.isEmpty(r14) == true) goto L10;
        String r15 = r10.optString("regex");
        if (BaseDispatchAction.j(r15) == false) goto L7;
        this.f1832t = r15;
        goto L10
    L7:
        this.f1837y = true;
        return true;
    L10:
        if (r10.optInt("drop") != 1) goto L12;
        boolean r16 = true;
    L13:
        this.f1834v = r16;
        int r17 = r10.optInt("drop_code", -1);
        if (r17 != (-555)) goto L16;
    L19:
        this.f1835w = r17;
    L20:
        int r18 = r10.optInt("possibility", 100);
        if (r18 < 0) goto L25;
        if (r18 > 100) goto L25;
        this.f1836x = r18;
    L25:
        if (this.f1802b.isEmpty() == false) goto L35;
        if (this.f1803c.isEmpty() == false) goto L35;
        if (this.f1804d.isEmpty() == false) goto L35;
        if (this.f1805e.isEmpty() == false) goto L35;
        if (this.f1806f.isEmpty() == false) goto L35;
    L44:
        this.f1837y = true;
    L45:
        r11.set(0, Boolean.FALSE);
        return true;
    L35:
        if (this.f1834v == true) goto L45;
        if (this.f1829q.isEmpty() == false) goto L45;
        if (this.f1830r.isEmpty() == false) goto L45;
        if (this.f1831s.isEmpty() == false) goto L45;
        if (this.f1833u.isEmpty() == false) goto L45;
    L16:
        if (r17 < (-5559)) goto L20;
        if (r17 > (-5551)) goto L20;
    L12:
        r16 = false;
        goto L13
    }
}
