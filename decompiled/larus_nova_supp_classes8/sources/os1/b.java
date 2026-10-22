package os1;

import com.bytedance.android.livesdk.config.cv;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static c b() {
        return cv.a.getValue();
    }

    static {
    }

    public static boolean a(EXTERNAL_CONFIG_TYPE r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        int r5 = a.a[r3.ordinal()];
        if (r5 != 1) goto L5;
        d r6 = b().e();
        if (r6 != null) goto L65;
        return false;
    L65:
        if (r6.a() == false) goto L101;
        if (r4 != null) goto L70;
    L87:
        return true;
    L70:
        switch(r4.hashCode()) {
            case -426274807: goto L85;
            case 3744723: goto L82;
            case 114203431: goto L79;
            case 1834031882: goto L76;
            case 2102464948: goto L73;
            default: goto L87;
        };
    L73:
        if (r4.equals("leftScroll") == false) goto L87;
        return r6.b();
    L76:
        if (r4.equals("upDownScroll") == false) goto L87;
        return r6.e();
    L79:
        if (r4.equals("longPress") == false) goto L87;
        return r6.c();
    L82:
        if (r4.equals("zoom") == false) goto L87;
        return r6.f();
    L85:
        if (r4.equals("rightScroll") == false) goto L87;
        return r6.d();
    L101:
        return false;
    L5:
        if (r5 == 2) goto L60;
        if (r5 != 3) goto L9;
        e r7 = b().f();
        if (r7 != null) goto L41;
        return false;
    L41:
        if (r7.c() == false) goto L94;
        if (r4 == null) goto L57;
        int r0 = r4.hashCode();
        if (r0 == (-2035066464)) goto L54;
        if (r0 != (-165568835)) goto L57;
        if (r4.equals("gravitySensing") == false) goto L57;
        boolean r8 = r7.a();
    L92:
        return r8;
    L54:
        if (r4.equals("orientationChange") == false) goto L57;
        r8 = r7.b();
    L57:
        return true;
    L94:
        return false;
    L9:
        if (r5 == 4) goto L36;
        if (r5 == 5) goto L13;
        return true;
    L13:
        f r9 = b().g();
        if (r9 != null) goto L17;
        return false;
    L17:
        if (r9.b() == false) goto L91;
        if (r4 == null) goto L33;
        int r1 = r4.hashCode();
        if (r1 == (-1434007100)) goto L30;
        if (r1 != 2123221204) goto L33;
        if (r4.equals("uvService") == false) goto L33;
        boolean r10 = r9.c();
    L89:
        return r10;
    L30:
        if (r4.equals("followService") == false) goto L33;
        r10 = r9.a();
    L33:
        return true;
    L91:
        return false;
    L36:
        return b().d();
    L60:
        return b().a();
    }
}
