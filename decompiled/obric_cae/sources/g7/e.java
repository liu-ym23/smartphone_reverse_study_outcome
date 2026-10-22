package g7;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f7724b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7725a;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7726a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7727b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ a[] f7728m = null;

        static {
            a r8 = new a("UNKNOWN_DISPATCH_STRATEGY", 0);
            f7726a = r8;
            a r10 = new a("STATIC_DISPATCH_STRATEGY", 1);
            f7727b = r10;
            f7728m = new a[]{r8, r10, new a("WRR_DISPATCH_STRATEGY", 2), new a("CONSERVATIVE_DISPATCH_STRATEGY", 3), new a("OPTIMIZED_DISPATCH_STRATEGY", 4), new a("ROUTE_SELECTION_DISPATCH_STRATEGY", 5), new a("DISPATCH_STRATEGY_SUPPORTED_LAST", 6)};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f7728m.clone();
        }
    }

    public e(a r8) {
        this.f7725a = r8;
    }

    public abstract String a(Uri r8);

    public abstract void b();
}
