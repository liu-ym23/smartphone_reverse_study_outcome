package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h extends i {
    private static final String j = "h";
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private boolean p;
    private int q;
    private int r;
    private boolean s;

    static {
    }

    public h() {
        this.p = false;
        this.q = -555;
        this.r = 100;
        this.s = false;
    }

    private boolean a(String r5, String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return false;
    L6:
        if (r5.equals(r6) == false) goto L9;
        return true;
    L9:
        if (r5.equals("http") == true) goto L13;
        if (r5.equals(LocationInfoConst.HTTPS) == true) goto L13;
    L18:
        if (r5.equals("ws") == true) goto L22;
        if (r5.equals("wss") == true) goto L22;
    L26:
        return false;
    L22:
        if (r6.equals("ws") == false) goto L24;
    L27:
        return true;
    L24:
        if (r6.equals("wss") == false) goto L26;
    L13:
        if (r6.equals("http") == true) goto L27;
        if (r6.equals(LocationInfoConst.HTTPS) == false) goto L18;
        goto L27
    }

    private boolean h() {
        int r0 = this.r;
        if (r0 < 100) goto L6;
        return true;
    L6:
        if (r0 > 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(100) >= this.r) goto L12;
        return true;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(j, "tc drop action was probabilistic discard");
    L14:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.i
    public BaseDispatchAction.DispatchResultEnum a(k r4, String r5, List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d(j, "tc action");
    L5:
        Uri r8 = Uri.parse(r5);
        if (this.s == false) goto L8;
    L53:
        r7.set(0, r5);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L8:
        if (a(r8) == false) goto L53;
        r7.set(0, r5);
        if (this.p == false) goto L22;
        if (Logger.debug() == false) goto L16;
        Logger.d(j, "drop action");
    L16:
        if (h() == false) goto L20;
        r7.set(0, "");
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP;
    L20:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L22:
        if (this.l.isEmpty() == false) goto L37;
        if (this.k.isEmpty() == false) goto L37;
        if (this.m.isEmpty() == false) goto L37;
        if (TextUtils.isEmpty(this.o) == true) goto L35;
        if (TextUtils.isEmpty(this.n) == true) goto L35;
        r7.set(0, r5.replaceAll(this.n, this.o));
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
    L35:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L37:
        if (r8.getScheme() == null) goto L42;
        if (a(r8.getScheme(), this.k) == false) goto L42;
        r5 = r5.replaceFirst(r8.getScheme(), this.k);
    L42:
        if (r8.getHost() == null) goto L47;
        if (TextUtils.isEmpty(this.l) == true) goto L47;
        r5 = r5.replaceFirst(r8.getHost(), this.l);
    L47:
        if (r8.getPath() != null) goto L49;
    L51:
        r7.set(0, r5);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
    L49:
        if (TextUtils.isEmpty(this.m) == true) goto L51;
        r5 = r5.replaceFirst(r8.getPath(), this.m);
        goto L51
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.i
    public boolean a(JSONObject r2, List<Boolean> r3, String r4, long r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        a(r2);
        this.h = r2.optString("service_name");
        this.k = r2.optString("scheme_replace");
        this.l = r2.optString("host_replace");
        this.m = r2.optString("path_replace");
        String r7 = r2.optString("replace");
        this.o = r7;
        if (TextUtils.isEmpty(r7) == true) goto L10;
        String r8 = r2.optString("regex");
        if (a(r8) == false) goto L7;
        this.n = r8;
        goto L10
    L7:
        this.s = true;
        return true;
    L10:
        if (r2.optInt("drop") != 1) goto L12;
        boolean r9 = true;
    L13:
        this.p = r9;
        int r10 = r2.optInt("drop_code", -1);
        if (r10 != (-555)) goto L16;
    L19:
        this.q = r10;
    L20:
        int r11 = r2.optInt("possibility", 100);
        if (r11 < 0) goto L25;
        if (r11 > 100) goto L25;
        this.r = r11;
    L25:
        if (this.f2507b.isEmpty() == false) goto L35;
        if (this.c.isEmpty() == false) goto L35;
        if (this.d.isEmpty() == false) goto L35;
        if (this.e.isEmpty() == false) goto L35;
        if (this.f.isEmpty() == false) goto L35;
    L44:
        this.s = true;
    L45:
        r6.set(0, false);
        return true;
    L35:
        if (this.p == true) goto L45;
        if (this.k.isEmpty() == false) goto L45;
        if (this.l.isEmpty() == false) goto L45;
        if (this.m.isEmpty() == false) goto L45;
        if (this.o.isEmpty() == false) goto L45;
    L16:
        if (r10 < (-5559)) goto L20;
        if (r10 > (-5551)) goto L20;
    L12:
        r9 = false;
        goto L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.i
    public int e() {
        return -1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.i
    public int f() {
        return this.q;
    }
}
