package g7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f7698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f7699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f7700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f7701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f7702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f7704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<String> f7707m;

    /* JADX INFO: renamed from: g7.a$a, reason: collision with other inner class name */
    public static final enum EnumC0079a extends Enum<EnumC0079a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0079a f7708a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0079a f7709b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final EnumC0079a f7710m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final EnumC0079a f7711n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ EnumC0079a[] f7712o = null;

        static {
            EnumC0079a r8 = new EnumC0079a("DISPATCH_NONE", 0);
            f7708a = r8;
            EnumC0079a r10 = new EnumC0079a("DISPATCH_HIT", 1);
            f7709b = r10;
            EnumC0079a r11 = new EnumC0079a("DISPATCH_DROP", 2);
            f7710m = r11;
            EnumC0079a r12 = new EnumC0079a("DISPATCH_DELAY", 3);
            f7711n = r12;
            f7712o = new EnumC0079a[]{r8, r10, r11, r12};
        }

        public EnumC0079a(String r8, int r10) {
            super(r8, r10);
        }

        public static EnumC0079a valueOf(String r8) {
            return (EnumC0079a) Enum.valueOf(EnumC0079a.class, r8);
        }

        public static EnumC0079a[] values() {
            return (EnumC0079a[]) f7712o.clone();
        }
    }

    public a() {
        this.f7695a = new ArrayList();
        this.f7696b = new ArrayList();
        this.f7697c = new ArrayList();
        this.f7698d = new ArrayList();
        this.f7699e = new ArrayList();
        this.f7700f = new ArrayList();
        this.f7707m = new ArrayList();
    }

    public static a a(String r8, JSONObject r10, int r11, long r12, long r13, long r14, String r15, long r16, ArrayList r18, int r19) {
        if (r8.equals("tc") == false) goto L5;
        a r17 = new h();
    L7:
        if (r8.equals("dispatch") == false) goto L10;
        r17 = new f();
    L10:
        if (r8.equals("delay") == false) goto L12;
        r17 = new c();
    L12:
        if (r17 != null) goto L14;
        return null;
    L14:
        r17.f7703i = r11;
        r17.f7701g = r12;
        r17.f7702h = r13;
        r17.f7704j = r14;
        r17.f7707m = r18;
        if (r19 >= 0) goto L17;
        int r20 = Integer.MAX_VALUE;
    L18:
        r17.f7706l = r20;
        if (r17.b(r16, r15, r10) == false) goto L21;
        return r17;
    L21:
        return null;
    L17:
        r20 = r19;
        goto L18
    L5:
        r17 = null;
        goto L7
    }

    public static void f(String r8, ArrayList r10, JSONObject r11) {
        JSONArray r12 = r11.optJSONArray(r8);
        if (r12 == null) goto L11;
        int r13 = 0;
    L6:
        if (r13 >= r12.length()) goto L15;
        String r14 = r12.optString(r13);
        if (TextUtils.isEmpty(r14) == true) goto L10;
        r10.add(r14);
    L10:
        r13 = r13 + 1;
        goto L6
    L15:
        return;
    }

    public abstract boolean b(long r8, String r10, JSONObject r11);

    public final boolean c() {
        long r8 = this.f7701g;
        if (r8 != 0) goto L8;
        if (this.f7702h != 0) goto L8;
        return true;
    L8:
        if (r8 != (-1)) goto L10;
    L18:
        return false;
    L10:
        if (this.f7702h == (-1)) goto L18;
        long r10 = System.currentTimeMillis();
        if (r10 > this.f7701g) goto L15;
    L17:
        Logger.d("a", "current time is out action lifecycle");
        goto L18
    L15:
        if (r10 >= this.f7702h) goto L17;
        return true;
    }

    public final boolean d(Uri r8) {
        ArrayList r10 = this.f7695a;
        if (r10.isEmpty() == true) goto L10;
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        if (l7.g.b(r8.getHost(), (String) r11.next()) == false) goto L7;
    L11:
        boolean r12 = false;
    L13:
        if (r12 == true) goto L16;
        Logger.d("a", "host group is not match");
        return false;
    L16:
        String r13 = r8.getPath();
        if (r13 == null) goto L51;
        ArrayList r14 = this.f7696b;
        if (r14.isEmpty() == true) goto L26;
        Iterator r15 = r14.iterator();
    L22:
        if (r15.hasNext() == false) goto L26;
        String r16 = (String) r15.next();
        if (r13.equals(r16) == false) goto L22;
        StringBuilder r17 = new StringBuilder("path equal hit: ");
    L50:
        r17.append(r16);
    L59:
        Logger.d("a", r17.toString());
        return true;
    L26:
        ArrayList r18 = this.f7697c;
        if (r18.isEmpty() == true) goto L34;
        Iterator r19 = r18.iterator();
    L30:
        if (r19.hasNext() == false) goto L34;
        r16 = (String) r19.next();
        if (r13.startsWith(r16) == false) goto L30;
        r17 = new StringBuilder("path prefix hit: ");
    L34:
        ArrayList r20 = this.f7698d;
        if (r20.isEmpty() == true) goto L42;
        Iterator r21 = r20.iterator();
    L38:
        if (r21.hasNext() == false) goto L42;
        r16 = (String) r21.next();
        if (r13.contains(r16) == false) goto L38;
        r17 = new StringBuilder("path contain hit: ");
    L42:
        ArrayList r22 = this.f7699e;
        if (r22.isEmpty() == true) goto L51;
        Iterator r23 = r22.iterator();
    L46:
        if (r23.hasNext() == false) goto L51;
        r16 = (String) r23.next();
        if (r13.matches(r16) == false) goto L46;
        r17 = new StringBuilder("path pattern hit: ");
    L51:
        ArrayList r24 = this.f7700f;
        if (r24.isEmpty() == true) goto L61;
        Iterator r25 = r24.iterator();
    L55:
        if (r25.hasNext() == false) goto L61;
        String r26 = (String) r25.next();
        if (r8.toString().matches(r26) == false) goto L55;
        r17 = new StringBuilder("full url hit: ");
        r17.append(r26);
    L61:
        return false;
    L10:
        r12 = true;
        goto L13
    }

    public final void e(JSONObject r8) {
        f("host_group", this.f7695a, r8);
        f("equal_group", this.f7696b, r8);
        f("prefixes_group", this.f7697c, r8);
        f("contain_group", this.f7698d, r8);
        f("pattern_group", this.f7699e, r8);
        f("url_group", this.f7700f, r8);
    }
}
