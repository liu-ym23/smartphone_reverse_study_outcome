package d7;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
public final enum t extends Enum<t> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f6941b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final t f6942m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final t f6943n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ t[] f6944o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6945a;

    static {
        t r8 = new t(BdimCategoryConstants.VALUE_UNKNOWN, 0, -1);
        f6941b = r8;
        t r10 = new t("SOURCE_HTTPDNS", 1, 3);
        f6942m = r10;
        t r11 = new t("SOURCE_PROC", 2, 6);
        f6943n = r11;
        f6944o = new t[]{r8, r10, r11, new t("SOURCE_PRELOAD_BATCH_HTTPDNS", 3, 7), new t("SOURCE_ASYNC_BATCH_HTTPDNS", 4, 8)};
    }

    public t(String r8, int r10, int r11) {
        super(r8, r10);
        this.f6945a = r11;
    }

    public static t valueOf(String r8) {
        return (t) Enum.valueOf(t.class, r8);
    }

    public static t[] values() {
        return (t[]) f6944o.clone();
    }
}
