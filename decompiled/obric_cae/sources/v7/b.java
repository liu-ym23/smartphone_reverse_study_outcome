package v7;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f12768a = 0;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12769b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f12770m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f12771n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f12772o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f12773p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final /* synthetic */ a[] f12774q = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12775a;

        static {
            a r8 = new a(BdimCategoryConstants.VALUE_UNKNOWN, 0, -1);
            a r10 = new a(BdimCategoryConstants.VALUE_NONE, 1, 0);
            f12769b = r10;
            a r11 = new a("MOBILE", 2, 1);
            f12770m = r11;
            a r12 = new a("MOBILE_2G", 3, 2);
            a r13 = new a("MOBILE_3G", 4, 3);
            f12771n = r13;
            a r14 = new a("WIFI", 5, 4);
            f12772o = r14;
            a r15 = new a("MOBILE_4G", 6, 5);
            f12773p = r15;
            f12774q = new a[]{r8, r10, r11, r12, r13, r14, r15};
        }

        public a(String r8, int r10, int r11) {
            super(r8, r10);
            this.f12775a = r11;
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f12774q.clone();
        }
    }

    static {
        a r8 = a.f12769b;
    }
}
