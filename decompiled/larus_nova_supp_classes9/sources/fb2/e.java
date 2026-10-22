package fb2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(IBaseUser r6) {
        int r0 = -1;
        if (r6 == null) goto L5;
        int r1 = r6.getGender();
    L6:
        if (r6 == null) goto L8;
        r0 = r6.getAgeRange();
    L8:
        int r7 = 5;
        if (r1 == 1) goto L37;
        if (r1 == 2) goto L24;
        if (r0 == 0) goto L23;
        if (r0 == 1) goto L22;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L20;
        if (r0 == 4) goto L19;
        if (r0 == 5) goto L18;
        r7 = 21;
    L50:
        return String.valueOf(r7);
    L18:
        r7 = 20;
        goto L50
    L19:
        r7 = 19;
        goto L50
    L20:
        r7 = 18;
        goto L50
    L21:
        r7 = 17;
        goto L50
    L22:
        r7 = 16;
        goto L50
    L23:
        r7 = 15;
        goto L50
    L24:
        if (r0 == 0) goto L36;
        if (r0 == 1) goto L35;
        if (r0 == 2) goto L34;
        if (r0 == 3) goto L33;
        if (r0 == 4) goto L32;
        if (r0 == 5) goto L31;
        r7 = 14;
        goto L50
    L31:
        r7 = 13;
        goto L50
    L32:
        r7 = 12;
        goto L50
    L33:
        r7 = 11;
        goto L50
    L34:
        r7 = 10;
        goto L50
    L35:
        r7 = 9;
        goto L50
    L36:
        r7 = 8;
        goto L50
    L37:
        if (r0 == 0) goto L48;
        if (r0 == 1) goto L47;
        if (r0 == 2) goto L46;
        if (r0 == 3) goto L45;
        if (r0 == 4) goto L50;
        if (r0 == 5) goto L44;
        r7 = 7;
        goto L50
    L44:
        r7 = 6;
        goto L50
    L45:
        r7 = 4;
        goto L50
    L46:
        r7 = 3;
        goto L50
    L47:
        r7 = 2;
        goto L50
    L48:
        r7 = 1;
        goto L50
    L5:
        r1 = -1;
        goto L6
    }
}
