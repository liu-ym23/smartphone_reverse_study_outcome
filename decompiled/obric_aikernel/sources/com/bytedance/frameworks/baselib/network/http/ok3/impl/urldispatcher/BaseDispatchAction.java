package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDispatchAction {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f1800o = "BaseDispatchAction";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<String> f1801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<String> f1802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<String> f1803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<String> f1804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected List<String> f1805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected List<String> f1806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected List<String> f1807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f1808h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f1809i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1810j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f1811k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected String f1812l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f1813m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List<String> f1814n;

    public static final enum DispatchResultEnum extends Enum<DispatchResultEnum> {
        private static final /* synthetic */ DispatchResultEnum[] $VALUES = null;
        public static final DispatchResultEnum DISPATCH_DELAY = null;
        public static final DispatchResultEnum DISPATCH_DROP = null;
        public static final DispatchResultEnum DISPATCH_HIT = null;
        public static final DispatchResultEnum DISPATCH_NONE = null;

        static {
            DispatchResultEnum r10 = new DispatchResultEnum("DISPATCH_NONE", 0);
            DISPATCH_NONE = r10;
            DispatchResultEnum r11 = new DispatchResultEnum("DISPATCH_HIT", 1);
            DISPATCH_HIT = r11;
            DispatchResultEnum r12 = new DispatchResultEnum("DISPATCH_DROP", 2);
            DISPATCH_DROP = r12;
            DispatchResultEnum r13 = new DispatchResultEnum("DISPATCH_DELAY", 3);
            DISPATCH_DELAY = r13;
            $VALUES = new DispatchResultEnum[]{r10, r11, r12, r13};
        }

        private DispatchResultEnum(String r10, int r11) {
            super(r10, r11);
        }

        public static DispatchResultEnum valueOf(String r10) {
            return (DispatchResultEnum) Enum.valueOf(DispatchResultEnum.class, r10);
        }

        public static DispatchResultEnum[] values() {
            return (DispatchResultEnum[]) $VALUES.clone();
        }
    }

    static {
    }

    public BaseDispatchAction() {
        this.f1801a = new ArrayList();
        this.f1802b = new ArrayList();
        this.f1803c = new ArrayList();
        this.f1804d = new ArrayList();
        this.f1805e = new ArrayList();
        this.f1806f = new ArrayList();
        this.f1807g = new ArrayList();
        this.f1814n = new ArrayList();
    }

    public static BaseDispatchAction a(String r10, JSONObject r11, int r12, long r13, long r14, long r15, String r16, long r17, List<String> r19, int r20) {
        if (r10.equals("tc") == false) goto L5;
        BaseDispatchAction r18 = new f();
    L7:
        if (r10.equals("dispatch") == false) goto L10;
        r18 = new c();
    L10:
        if (r10.equals("delay") == false) goto L12;
        r18 = new b();
    L12:
        if (r18 != null) goto L14;
        return null;
    L14:
        r18.n(r12);
        r18.m(r13, r14);
        r18.o(r15);
        r18.q(r19);
        r18.p(r20);
        if (r18.e(r11, r16, r17) == false) goto L17;
        return r18;
    L17:
        return null;
    L5:
        r18 = null;
        goto L7
    }

    private boolean h() {
        long r10 = this.f1808h;
        if (r10 != 0) goto L8;
        if (this.f1809i != 0) goto L8;
        return true;
    L8:
        if (r10 != (-1)) goto L10;
    L20:
        return false;
    L10:
        if (this.f1809i == (-1)) goto L20;
        long r11 = System.currentTimeMillis();
        if (r11 <= this.f1808h) goto L18;
        if (r11 >= this.f1809i) goto L18;
        return true;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d(f1800o, "current time is out action lifecycle");
        goto L20
    }

    public static boolean j(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L9;
        return false;
    L9:
        Pattern.compile(r10);     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }

    private void l(JSONObject r10, String r11, List<String> r12, boolean r13) {
        JSONArray r14 = r10.optJSONArray(r11);
        if (r14 == null) goto L14;
        int r15 = 0;
    L6:
        if (r15 >= r14.length()) goto L19;
        String r16 = r14.optString(r15);
        if (TextUtils.isEmpty(r16) == true) goto L13;
        if (r13 == true) goto L11;
    L12:
        r12.add(r16);
        goto L13
    L11:
        if (j(r16) == true) goto L12;
    L13:
        r15 = r15 + 1;
        goto L6
    L19:
        return;
    }

    private void m(long r10, long r11) {
        this.f1808h = r10;
        this.f1809i = r11;
    }

    private void n(int r10) {
        this.f1810j = r10;
    }

    private void o(long r10) {
        this.f1811k = r10;
    }

    private void p(int r10) {
        if (r10 >= 0) goto L4;
        r10 = Integer.MAX_VALUE;
    L4:
        this.f1813m = r10;
    }

    private void q(List<String> r10) {
        this.f1814n = r10;
    }

    public int b() {
        return this.f1810j;
    }

    public long c() {
        return this.f1811k;
    }

    public String d() {
        return this.f1812l;
    }

    public abstract boolean e(JSONObject r10, String r11, long r12);

    public boolean f(y2.c r10) {
        if (r10.a() <= this.f1810j) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(f1800o, "jump action: " + this.f1812l + ", dispatchPriority: " + r10.a() + ", actionPriority: " + this.f1810j);
    L7:
        return false;
    L9:
        if (this.f1814n.isEmpty() == true) goto L19;
        if (TextUtils.isEmpty(r10.c()) == true) goto L19;
        if (this.f1814n.contains(r10.c()) == true) goto L19;
        if (Logger.debug() == false) goto L17;
        Logger.d(f1800o, "request method not support: " + r10.c());
    L17:
        return false;
    L19:
        return h();
    }

    public boolean g() {
        return h();
    }

    protected boolean i(Uri r10) {
        if (this.f1801a.isEmpty() == false) goto L5;
    L4:
        boolean r11 = true;
    L12:
        if (r11 == false) goto L14;
        String r12 = r10.getPath();
        if (TextUtils.isEmpty(r12) == false) goto L21;
        return false;
    L21:
        if (this.f1802b.isEmpty() == true) goto L32;
        Iterator<String> r13 = this.f1802b.iterator();
    L24:
        if (r13.hasNext() == false) goto L32;
        String r14 = r13.next();
        if (r12.equals(r14) == false) goto L24;
        if (Logger.debug() == false) goto L30;
        Logger.d(f1800o, "path equal hit: " + r14);
    L30:
        return true;
    L32:
        if (this.f1803c.isEmpty() == true) goto L43;
        Iterator<String> r15 = this.f1803c.iterator();
    L35:
        if (r15.hasNext() == false) goto L43;
        String r16 = r15.next();
        if (r12.startsWith(r16) == false) goto L35;
        if (Logger.debug() == false) goto L41;
        Logger.d(f1800o, "path prefix hit: " + r16);
    L41:
        return true;
    L43:
        if (this.f1804d.isEmpty() == true) goto L54;
        Iterator<String> r17 = this.f1804d.iterator();
    L46:
        if (r17.hasNext() == false) goto L54;
        String r18 = r17.next();
        if (r12.contains(r18) == false) goto L46;
        if (Logger.debug() == false) goto L52;
        Logger.d(f1800o, "path contain hit: " + r18);
    L52:
        return true;
    L54:
        if (this.f1805e.isEmpty() == true) goto L65;
        Iterator<String> r19 = this.f1805e.iterator();
    L57:
        if (r19.hasNext() == false) goto L65;
        String r20 = r19.next();
        if (r12.matches(r20) == false) goto L57;
        if (Logger.debug() == false) goto L63;
        Logger.d(f1800o, "path pattern hit: " + r20);
    L63:
        return true;
    L65:
        if (this.f1806f.isEmpty() == false) goto L67;
    L86:
        return false;
    L67:
        if (this.f1807g.isEmpty() == true) goto L77;
        Iterator<String> r21 = this.f1807g.iterator();
    L70:
        if (r21.hasNext() == false) goto L74;
        if (r12.contains(r21.next()) == false) goto L70;
        boolean r22 = true;
    L75:
        if (r22 == true) goto L77;
        return false;
    L74:
        r22 = false;
    L77:
        Iterator<String> r23 = this.f1806f.iterator();
    L79:
        if (r23.hasNext() == false) goto L86;
        String r24 = r23.next();
        if (r10.toString().matches(r24) == false) goto L79;
        if (Logger.debug() == false) goto L85;
        Logger.d(f1800o, "full url hit: " + r24);
    L85:
        return true;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(f1800o, "host group is not match");
    L16:
        return false;
    L5:
        Iterator<String> r25 = this.f1801a.iterator();
    L7:
        if (r25.hasNext() == false) goto L11;
        if (k.i(r10.getHost(), r25.next()) == false) goto L7;
    L11:
        r11 = false;
        goto L12
    }

    protected void k(JSONObject r10) {
        l(r10, "host_group", this.f1801a, false);
        l(r10, "equal_group", this.f1802b, false);
        l(r10, "prefixes_group", this.f1803c, false);
        l(r10, "contain_group", this.f1804d, false);
        l(r10, "pattern_group", this.f1805e, true);
        l(r10, "url_group", this.f1806f, true);
        l(r10, "path_contain", this.f1807g, false);
    }
}
