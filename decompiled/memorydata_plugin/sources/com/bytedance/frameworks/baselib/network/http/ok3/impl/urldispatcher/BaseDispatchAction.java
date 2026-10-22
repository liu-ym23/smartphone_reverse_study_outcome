package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDispatchAction {
    private static final String j = "BaseDispatchAction";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<String> f2506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<String> f2507b;
    protected List<String> c;
    protected List<String> d;
    protected List<String> e;
    protected List<String> f;
    protected List<String> g;
    protected String h;
    protected int i;
    private long k;
    private long l;
    private int m;
    private long n;
    private List<String> o;

    public static final enum DispatchResultEnum extends Enum<DispatchResultEnum> {
        private static final /* synthetic */ DispatchResultEnum[] $VALUES = null;
        public static final DispatchResultEnum DISPATCH_DELAY = null;
        public static final DispatchResultEnum DISPATCH_DROP = null;
        public static final DispatchResultEnum DISPATCH_HIT = null;
        public static final DispatchResultEnum DISPATCH_NONE = null;

        static {
            DispatchResultEnum r0 = new DispatchResultEnum("DISPATCH_NONE", 0);
            DISPATCH_NONE = r0;
            DispatchResultEnum r1 = new DispatchResultEnum("DISPATCH_HIT", 1);
            DISPATCH_HIT = r1;
            DispatchResultEnum r3 = new DispatchResultEnum("DISPATCH_DROP", 2);
            DISPATCH_DROP = r3;
            DispatchResultEnum r5 = new DispatchResultEnum("DISPATCH_DELAY", 3);
            DISPATCH_DELAY = r5;
            $VALUES = new DispatchResultEnum[]{r0, r1, r3, r5};
        }

        private DispatchResultEnum(String r1, int r2) {
            super(r1, r2);
        }

        public static DispatchResultEnum valueOf(String r2) {
            return (DispatchResultEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(DispatchResultEnum.class, r2), DispatchResultEnum.class, "com.obric.memorydata.plugin");
        }

        public static DispatchResultEnum[] values() {
            return (DispatchResultEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DispatchResultEnum[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    public BaseDispatchAction() {
        this.f2506a = new ArrayList();
        this.f2507b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.o = new ArrayList();
    }

    public static BaseDispatchAction a(String r8, JSONObject r9, int r10, long r11, long r13, long r15, String r17, long r18, List<String> r20, int r21) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        if (r8.equals("tc") == false) goto L5;
        BaseDispatchAction r2 = new h();
    L7:
        if (r8.equals("dispatch") == false) goto L10;
        r2 = new e();
    L10:
        if (r8.equals("delay") == false) goto L12;
        r2 = new b();
    L12:
        if (r2 != null) goto L14;
        return null;
    L14:
        r2.a(r10);
        r2.a(r11, r13);
        r2.a(r15);
        r2.a(r1);
        r2.b(r21);
        if (r2.a(r9, r17, r18) == false) goto L17;
        return r2;
    L17:
        return null;
    L5:
        r2 = null;
        goto L7
    }

    private void a(int r1) {
        this.m = r1;
    }

    private void a(long r1) {
        this.n = r1;
    }

    private void a(long r1, long r3) {
        this.k = r1;
        this.l = r3;
    }

    private void a(List<String> r3) {
        this.o = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    private void a(JSONObject r2, String r3, List<String> r4, boolean r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        JSONArray r6 = r2.optJSONArray(r3);
        if (r6 == null) goto L14;
        int r7 = 0;
    L6:
        if (r7 >= r6.length()) goto L19;
        String r8 = r6.optString(r7);
        if (TextUtils.isEmpty(r8) == true) goto L13;
        if (r5 == true) goto L11;
    L12:
        r1.add(r8);
        goto L13
    L11:
        if (a(r8) == true) goto L12;
    L13:
        r7 = r7 + 1;
        goto L6
    L19:
        return;
    }

    public static boolean a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return false;
    L9:
        Pattern.compile(r2);     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }

    private void b(int r1) {
        if (r1 >= 0) goto L4;
        r1 = Integer.MAX_VALUE;
    L4:
        this.i = r1;
    }

    private boolean e() {
        long r0 = this.k;
        if (r0 != 0) goto L8;
        if (this.l != 0) goto L8;
        return true;
    L8:
        if (r0 != (-1)) goto L10;
    L20:
        return false;
    L10:
        if (this.l == (-1)) goto L20;
        long r2 = System.currentTimeMillis();
        if (r2 <= this.k) goto L18;
        if (r2 >= this.l) goto L18;
        return true;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d(j, "current time is out action lifecycle");
        goto L20
    }

    public int a() {
        return this.m;
    }

    public void a(JSONObject r5) {
        a(r5, "host_group", this.f2506a, false);
        a(r5, "equal_group", this.f2507b, false);
        a(r5, "prefixes_group", this.c, false);
        a(r5, "contain_group", this.d, false);
        a(r5, "pattern_group", this.e, true);
        a(r5, "url_group", this.f, true);
        a(r5, "path_contain", this.g, false);
    }

    public boolean a(Uri r8) {
        if (this.f2506a.isEmpty() == false) goto L5;
    L4:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        String r1 = r8.getPath();
        if (TextUtils.isEmpty(r1) == false) goto L21;
        return false;
    L21:
        if (this.f2507b.isEmpty() == true) goto L32;
        Iterator<String> r4 = this.f2507b.iterator();
    L24:
        if (r4.hasNext() == false) goto L32;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        if (r1.equals(r5) == false) goto L24;
        if (Logger.debug() == false) goto L30;
        Logger.d(j, "path equal hit: " + r5);
    L30:
        return true;
    L32:
        if (this.c.isEmpty() == true) goto L43;
        Iterator<String> r6 = this.c.iterator();
    L35:
        if (r6.hasNext() == false) goto L43;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        if (r1.startsWith(r7) == false) goto L35;
        if (Logger.debug() == false) goto L41;
        Logger.d(j, "path prefix hit: " + r7);
    L41:
        return true;
    L43:
        if (this.d.isEmpty() == true) goto L54;
        Iterator<String> r9 = this.d.iterator();
    L46:
        if (r9.hasNext() == false) goto L54;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (r1.contains(r10) == false) goto L46;
        if (Logger.debug() == false) goto L52;
        Logger.d(j, "path contain hit: " + r10);
    L52:
        return true;
    L54:
        if (this.e.isEmpty() == true) goto L65;
        Iterator<String> r11 = this.e.iterator();
    L57:
        if (r11.hasNext() == false) goto L65;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        if (r1.matches(r12) == false) goto L57;
        if (Logger.debug() == false) goto L63;
        Logger.d(j, "path pattern hit: " + r12);
    L63:
        return true;
    L65:
        if (this.f.isEmpty() == false) goto L67;
    L86:
        return false;
    L67:
        if (this.g.isEmpty() == true) goto L77;
        Iterator<String> r13 = this.g.iterator();
    L70:
        if (r13.hasNext() == false) goto L74;
        if (r1.contains((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L70;
        boolean r2 = true;
    L75:
        if (r2 == true) goto L77;
        return false;
    L74:
        r2 = false;
    L77:
        Iterator<String> r14 = this.f.iterator();
    L79:
        if (r14.hasNext() == false) goto L86;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        if (r8.toString().matches(r3) == false) goto L79;
        if (Logger.debug() == false) goto L85;
        Logger.d(j, "full url hit: " + r3);
    L85:
        return true;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(j, "host group is not match");
    L16:
        return false;
    L5:
        Iterator<String> r15 = this.f2506a.iterator();
    L7:
        if (r15.hasNext() == false) goto L11;
        if (com.bytedance.frameworks.baselib.network.http.util.k.a(r8.getHost(), (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L7;
    L11:
        r0 = false;
        goto L12
    }

    public boolean a(k r5) {
        if (r5.c() <= this.m) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(j, "jump action: " + this.h + ", dispatchPriority: " + r5.c() + ", actionPriority: " + this.m);
    L7:
        return false;
    L9:
        if (this.o.isEmpty() == true) goto L19;
        if (TextUtils.isEmpty(r5.a()) == true) goto L19;
        if (this.o.contains(r5.a()) == true) goto L19;
        if (Logger.debug() == false) goto L17;
        Logger.d(j, "request method not support: " + r5.a());
    L17:
        return false;
    L19:
        return e();
    }

    public abstract boolean a(JSONObject r1, String r2, long r3);

    public long b() {
        return this.n;
    }

    public String c() {
        return this.h;
    }

    public boolean d() {
        return e();
    }
}
