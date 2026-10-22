package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.loc.ev;
import com.loc.ey;
import com.loc.fb;
import com.loc.fd;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CoordinateConverter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f485b = 0;
    private static int c = 1;
    private static int d = 2;
    private static int e = 4;
    private static int f = 8;
    private static int g = 16;
    private static int h = 32;
    private static int i = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    DPoint f486a;
    private Context j;
    private CoordType k;
    private DPoint l;

    /* JADX INFO: renamed from: com.amap.api.location.CoordinateConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f487a = null;

        static {
            int[] r0 = new int[CoordType.values().length];
            f487a = r0;
            r0[CoordType.BAIDU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f487a[CoordType.MAPBAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f487a[CoordType.MAPABC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f487a[CoordType.SOSOMAP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f487a[CoordType.ALIYUN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f487a[CoordType.GOOGLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f487a[CoordType.GPS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final enum CoordType extends Enum<CoordType> {
        public static final CoordType ALIYUN = null;
        public static final CoordType BAIDU = null;
        public static final CoordType GOOGLE = null;
        public static final CoordType GPS = null;
        public static final CoordType MAPABC = null;
        public static final CoordType MAPBAR = null;
        public static final CoordType SOSOMAP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ CoordType[] f488a = null;

        static {
            CoordType r0 = new CoordType("BAIDU", 0);
            BAIDU = r0;
            CoordType r1 = new CoordType("MAPBAR", 1);
            MAPBAR = r1;
            CoordType r3 = new CoordType("MAPABC", 2);
            MAPABC = r3;
            CoordType r5 = new CoordType("SOSOMAP", 3);
            SOSOMAP = r5;
            CoordType r7 = new CoordType("ALIYUN", 4);
            ALIYUN = r7;
            CoordType r9 = new CoordType("GOOGLE", 5);
            GOOGLE = r9;
            CoordType r11 = new CoordType("GPS", 6);
            GPS = r11;
            f488a = new CoordType[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private CoordType(String r1, int r2) {
            super(r1, r2);
        }

        public static CoordType valueOf(String r2) {
            return (CoordType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CoordType.class, r2), CoordType.class, "com.obric.memorydata.plugin");
        }

        public static CoordType[] values() {
            return (CoordType[]) ZeusTransformUtils.preCheckCast(f488a.clone(), CoordType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    public CoordinateConverter(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.k = null;
        this.l = null;
        this.f486a = null;
        this.j = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    public static float a(DPoint r0, DPoint r1) {
        return fd.a(r0, r1);
    L4:
        return 0.0f;
    }

    public static boolean a(double r0, double r2) {
        return ev.a(r0, r2);
    }

    public synchronized CoordinateConverter a(CoordType r1) {
        monitor-enter(this);
        this.k = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized CoordinateConverter a(DPoint r5) {
        monitor-enter(this);
        if (r5 == null) goto L22;
        if (r5.getLongitude() > 180.0d) goto L18;
        if (r5.getLongitude() < (-180.0d)) goto L18;
        if (r5.getLatitude() > 90.0d) goto L16;
        if (r5.getLatitude() < (-90.0d)) goto L16;
        this.l = r5;     // Catch: Throwable -> L19
        monitor-exit(this);
        return this;
    L16:
        throw new IllegalArgumentException("请传入合理纬度");     // Catch: Throwable -> L19
    L18:
        throw new IllegalArgumentException("请传入合理经度");     // Catch: Throwable -> L19
    L22:
        throw new IllegalArgumentException("传入经纬度对象为空");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized DPoint a() {
        monitor-enter(this);
    L62:
        th = move-exception;
        throw th;
    L4:
        if (this.k == null) goto L61;
        DPoint r0 = this.l;     // Catch: Throwable -> L62
        if (r0 == null) goto L59;
        if (r0.getLongitude() > 180.0d) goto L57;
        if (this.l.getLongitude() < (-180.0d)) goto L57;
        if (this.l.getLatitude() > 90.0d) goto L55;
        if (this.l.getLatitude() < (-90.0d)) goto L55;
        boolean r1 = false;
        String r2 = null;
        switch(AnonymousClass1.f487a[this.k.ordinal()]) {
            case 1: goto L42;
            case 2: goto L39;
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L27;
            case 6: goto L23;
            case 7: goto L18;
            default: goto L46;
        };     // Catch: Throwable -> L62
    L18:
        int r3 = f485b;     // Catch: Throwable -> L62
        int r4 = i;     // Catch: Throwable -> L62
        if ((r3 & r4) != 0) goto L21;
        r2 = "gps";
        f485b = r3 | r4;     // Catch: Throwable -> L62
        r1 = true;
    L21:
        DPoint r5 = ey.a(this.j, this.l);     // Catch: Throwable -> L62
    L22:
        this.f486a = r5;     // Catch: Throwable -> L62
        goto L46
    L23:
        int r6 = f485b;     // Catch: Throwable -> L62
        int r7 = h;     // Catch: Throwable -> L62
        if ((r6 & r7) != 0) goto L26;
        r2 = "google";
        f485b = r6 | r7;     // Catch: Throwable -> L62
        r1 = true;
    L26:
        r5 = this.l;     // Catch: Throwable -> L62
        goto L22
    L27:
        int r8 = f485b;     // Catch: Throwable -> L62
        int r9 = g;     // Catch: Throwable -> L62
        if ((r8 & r9) != 0) goto L30;
        r2 = "aliyun";
        f485b = r8 | r9;     // Catch: Throwable -> L62
        r1 = true;
    L30:
        r5 = this.l;     // Catch: Throwable -> L62
        goto L22
    L31:
        int r10 = f485b;     // Catch: Throwable -> L62
        int r11 = f;     // Catch: Throwable -> L62
        if ((r10 & r11) != 0) goto L34;
        r2 = "sosomap";
        f485b = r10 | r11;     // Catch: Throwable -> L62
        r1 = true;
    L34:
        r5 = this.l;     // Catch: Throwable -> L62
        goto L22
    L35:
        int r12 = f485b;     // Catch: Throwable -> L62
        int r13 = e;     // Catch: Throwable -> L62
        if ((r12 & r13) != 0) goto L38;
        r2 = "mapabc";
        f485b = r12 | r13;     // Catch: Throwable -> L62
        r1 = true;
    L38:
        r5 = this.l;     // Catch: Throwable -> L62
        goto L22
    L39:
        this.f486a = ey.b(this.j, this.l);     // Catch: Throwable -> L62
        int r14 = f485b;     // Catch: Throwable -> L62
        int r15 = d;     // Catch: Throwable -> L62
        if ((r14 & r15) != 0) goto L46;
        r2 = "mapbar";
    L45:
        f485b = r14 | r15;     // Catch: Throwable -> L62
        r1 = true;
        goto L46
    L42:
        this.f486a = ey.a(this.l);     // Catch: Throwable -> L62
        r14 = f485b;     // Catch: Throwable -> L62
        r15 = c;     // Catch: Throwable -> L62
        if ((r14 & r15) != 0) goto L46;
        r2 = "baidu";
    L46:
        if (r1 == false) goto L51;
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r2) == true) goto L50;
        r16.put("amap_loc_coordinate", r2);     // Catch: Throwable -> L62
    L50:
        fb.a(this.j, "O021", r16);     // Catch: Throwable -> L62
    L51:
        DPoint r17 = this.f486a;     // Catch: Throwable -> L62
        monitor-exit(this);
        return r17;
    L55:
        throw new IllegalArgumentException("请传入合理纬度");     // Catch: Throwable -> L62
    L57:
        throw new IllegalArgumentException("请传入合理经度");     // Catch: Throwable -> L62
    L59:
        throw new IllegalArgumentException("转换坐标源不能为空");     // Catch: Throwable -> L62
    L61:
        throw new IllegalArgumentException("转换坐标类型不能为空");     // Catch: Throwable -> L62
    }
}
