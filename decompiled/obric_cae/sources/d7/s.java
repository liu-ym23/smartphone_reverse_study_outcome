package d7;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
public final enum s extends Enum<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f6935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f6936b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final s f6937m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final s f6938n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final s f6939o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ s[] f6940p = null;

    static {
        s r8 = new s(BdimCategoryConstants.VALUE_UNKNOWN, 0);
        f6935a = r8;
        s r10 = new s("SUCCESS", 1);
        f6936b = r10;
        s r11 = new s("IO_PENDING", 2);
        f6937m = r11;
        s r12 = new s("CANCELED", 3);
        f6938n = r12;
        s r13 = new s("FAILED", 4);
        f6939o = r13;
        f6940p = new s[]{r8, r10, r11, r12, r13};
    }

    public s(String r8, int r10) {
        super(r8, r10);
    }

    public static s valueOf(String r8) {
        return (s) Enum.valueOf(s.class, r8);
    }

    public static s[] values() {
        return (s[]) f6940p.clone();
    }
}
