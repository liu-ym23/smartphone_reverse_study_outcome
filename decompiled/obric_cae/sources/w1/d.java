package w1;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.DPoint;
import com.obric.cae.cloud.CloudServiceConstants;
import org.json.JSONObject;
import qa.u3;
import qa.w3;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f12956e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f12958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DPoint f12959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DPoint f12960d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12961a = null;

        static {
            int[] r8 = new int[b.values().length];
            f12961a = r8;
            b r10 = b.f12962a;     // Catch: NoSuchFieldError -> L16
            r8[0] = 1;     // Catch: NoSuchFieldError -> L16
        L33:
            int[] r11 = f12961a;     // Catch: NoSuchFieldError -> L17
            b r12 = b.f12962a;     // Catch: NoSuchFieldError -> L17
            r11[1] = 2;     // Catch: NoSuchFieldError -> L17
        L23:
            int[] r13 = f12961a;     // Catch: NoSuchFieldError -> L18
            b r14 = b.f12962a;     // Catch: NoSuchFieldError -> L18
            r13[2] = 3;     // Catch: NoSuchFieldError -> L18
        L31:
            int[] r15 = f12961a;     // Catch: NoSuchFieldError -> L19
            b r16 = b.f12962a;     // Catch: NoSuchFieldError -> L19
            r15[3] = 4;     // Catch: NoSuchFieldError -> L19
        L29:
            int[] r17 = f12961a;     // Catch: NoSuchFieldError -> L20
            b r18 = b.f12962a;     // Catch: NoSuchFieldError -> L20
            r17[4] = 5;     // Catch: NoSuchFieldError -> L20
        L35:
            int[] r19 = f12961a;     // Catch: NoSuchFieldError -> L21
            b r20 = b.f12962a;     // Catch: NoSuchFieldError -> L21
            r19[5] = 6;     // Catch: NoSuchFieldError -> L21
        L27:
            int[] r21 = f12961a;     // Catch: NoSuchFieldError -> L22
            b r22 = b.f12962a;     // Catch: NoSuchFieldError -> L22
            r21[6] = 7;     // Catch: NoSuchFieldError -> L22
            return;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12962a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ b[] f12963b = null;

        static {
            b r8 = new b("BAIDU", 0);
            b r10 = new b("MAPBAR", 1);
            b r11 = new b("MAPABC", 2);
            b r12 = new b("SOSOMAP", 3);
            b r13 = new b("ALIYUN", 4);
            b r14 = new b("GOOGLE", 5);
            b r15 = new b("GPS", 6);
            f12962a = r15;
            f12963b = new b[]{r8, r10, r11, r12, r13, r14, r15};
        }

        public b(String r8, int r10) {
            super(r8, r10);
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f12963b.clone();
        }
    }

    public d(Context r8) {
        this.f12958b = null;
        this.f12959c = null;
        this.f12960d = null;
        this.f12957a = r8;
    }

    public final synchronized DPoint a() {
        monitor-enter(this);
        b r8 = this.f12958b;     // Catch: Throwable -> L67
        if (r8 == null) goto L66;
        DPoint r10 = this.f12959c;     // Catch: Throwable -> L67
        if (r10 == null) goto L64;
        double r11 = r10.f3677a;     // Catch: Throwable -> L67
        if (r11 > 180.0d) goto L62;
        if (r11 < (-180.0d)) goto L62;
        double r12 = r10.f3678b;     // Catch: Throwable -> L67
        if (r12 > 90.0d) goto L60;
        if (r12 < (-90.0d)) goto L60;
        boolean r13 = true;
        String r14 = null;
        switch(a.f12961a[r8.ordinal()]) {
            case 1: goto L47;
            case 2: goto L44;
            case 3: goto L39;
            case 4: goto L34;
            case 5: goto L29;
            case 6: goto L24;
            case 7: goto L18;
            default: goto L50;
        };     // Catch: Throwable -> L67
    L18:
        int r15 = f12956e;     // Catch: Throwable -> L67
        if ((r15 & 64) != 0) goto L21;
        r14 = CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS;
        f12956e = r15 | 64;     // Catch: Throwable -> L67
    L22:
        DPoint r16 = u3.b(this.f12957a, this.f12959c);     // Catch: Throwable -> L67
    L23:
        this.f12960d = r16;     // Catch: Throwable -> L67
    L51:
        if (r13 == false) goto L56;
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L67
        if (TextUtils.isEmpty(r14) == true) goto L55;
        r17.put("amap_loc_coordinate", r14);     // Catch: Throwable -> L67
    L55:
        w3.j(this.f12957a, "O021", r17);     // Catch: Throwable -> L67
    L56:
        DPoint r18 = this.f12960d;     // Catch: Throwable -> L67
        monitor-exit(this);
        return r18;
    L21:
        r13 = false;
        goto L22
    L24:
        int r19 = f12956e;     // Catch: Throwable -> L67
        if ((r19 & 32) != 0) goto L27;
        r14 = "google";
        f12956e = r19 | 32;     // Catch: Throwable -> L67
    L28:
        r16 = this.f12959c;     // Catch: Throwable -> L67
        goto L23
    L27:
        r13 = false;
        goto L28
    L29:
        int r20 = f12956e;     // Catch: Throwable -> L67
        if ((r20 & 16) != 0) goto L32;
        r14 = "aliyun";
        f12956e = r20 | 16;     // Catch: Throwable -> L67
    L33:
        r16 = this.f12959c;     // Catch: Throwable -> L67
        goto L23
    L32:
        r13 = false;
        goto L33
    L34:
        int r21 = f12956e;     // Catch: Throwable -> L67
        if ((r21 & 8) != 0) goto L37;
        r14 = "sosomap";
        f12956e = r21 | 8;     // Catch: Throwable -> L67
    L38:
        r16 = this.f12959c;     // Catch: Throwable -> L67
        goto L23
    L37:
        r13 = false;
        goto L38
    L39:
        int r22 = f12956e;     // Catch: Throwable -> L67
        if ((r22 & 4) != 0) goto L42;
        r14 = "mapabc";
        f12956e = r22 | 4;     // Catch: Throwable -> L67
    L43:
        r16 = this.f12959c;     // Catch: Throwable -> L67
        goto L23
    L42:
        r13 = false;
        goto L43
    L44:
        this.f12960d = u3.e(this.f12957a, this.f12959c);     // Catch: Throwable -> L67
        int r23 = f12956e;     // Catch: Throwable -> L67
        if ((r23 & 2) != 0) goto L50;
        r14 = "mapbar";
        f12956e = r23 | 2;     // Catch: Throwable -> L67
        goto L51
    L47:
        this.f12960d = u3.c(this.f12959c);     // Catch: Throwable -> L67
        int r24 = f12956e;     // Catch: Throwable -> L67
        if ((r24 & 1) != 0) goto L50;
        r14 = "baidu";
        f12956e = r24 | 1;     // Catch: Throwable -> L67
    L50:
        r13 = false;
    L60:
        throw new IllegalArgumentException("请传入合理纬度");     // Catch: Throwable -> L67
    L62:
        throw new IllegalArgumentException("请传入合理经度");     // Catch: Throwable -> L67
    L64:
        throw new IllegalArgumentException("转换坐标源不能为空");     // Catch: Throwable -> L67
    L66:
        throw new IllegalArgumentException("转换坐标类型不能为空");     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(DPoint r8) {
        monitor-enter(this);
        double r10 = r8.f3677a;     // Catch: Throwable -> L18
        if (r10 > 180.0d) goto L17;
        if (r10 < (-180.0d)) goto L17;
        double r11 = r8.f3678b;     // Catch: Throwable -> L18
        if (r11 > 90.0d) goto L15;
        if (r11 < (-90.0d)) goto L15;
        this.f12959c = r8;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L15:
        throw new IllegalArgumentException("请传入合理纬度");     // Catch: Throwable -> L18
    L17:
        throw new IllegalArgumentException("请传入合理经度");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
