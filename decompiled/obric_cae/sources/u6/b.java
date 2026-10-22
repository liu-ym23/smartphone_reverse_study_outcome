package u6;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f12483b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f12484m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f12485n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f12486o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ b[] f12487p = null;

    static {
        b r8 = new b("POOR", 0);
        f12482a = r8;
        b r10 = new b("MODERATE", 1);
        f12483b = r10;
        b r11 = new b("GOOD", 2);
        f12484m = r11;
        b r12 = new b("EXCELLENT", 3);
        f12485n = r12;
        b r13 = new b(BdimCategoryConstants.VALUE_UNKNOWN, 4);
        f12486o = r13;
        f12487p = new b[]{r8, r10, r11, r12, r13};
    }

    public b(String r8, int r10) {
        super(r8, r10);
    }

    public static b valueOf(String r8) {
        return (b) Enum.valueOf(b.class, r8);
    }

    public static b[] values() {
        return (b[]) f12487p.clone();
    }
}
