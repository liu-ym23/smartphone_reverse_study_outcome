package e7;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f7146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f7147b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f7148m;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7149a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7150b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f7151m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f7152n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f7153o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f7154p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f7155q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ a[] f7156r = null;

        static {
            a r8 = new a(BdimCategoryConstants.VALUE_UNKNOWN, 0);
            f7149a = r8;
            a r10 = new a("HTTPDNS_CACHE", 1);
            f7150b = r10;
            a r11 = new a("HTTPDNS_STALE_CACHE", 2);
            f7151m = r11;
            a r12 = new a("HTTPDNS_REQUEST", 3);
            f7152n = r12;
            a r13 = new a("LOCALDNS_REQUEST", 4);
            f7153o = r13;
            a r14 = new a("LOCALDNS_CACHE", 5);
            f7154p = r14;
            a r15 = new a("HARDCODE_IPS", 6);
            f7155q = r15;
            f7156r = new a[]{r8, r10, r11, r12, r13, r14, r15};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f7156r.clone();
        }
    }

    public b() {
        this.f7146a = new ArrayList();
        this.f7147b = new ArrayList();
        this.f7148m = a.f7150b;
    }
}
