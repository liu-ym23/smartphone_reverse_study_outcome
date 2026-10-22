package p52;

import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(r r2) {
        String r0 = String.valueOf(r2.getType());
        String r3 = r2.getLabelText();
        if (r3 != null) goto L6;
        r3 = BuildConfig.FLAVOR;
    L6:
        return r0 + "_" + r3;
    }

    public static String b(List r5) {
        List r0 = r5;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return null;
    L12:
        Iterator r6 = r5.iterator();
        String r2 = BuildConfig.FLAVOR;
    L14:
        if (r6.hasNext() == false) goto L22;
        r r3 = (r) r6.next();
        if (r2.length() != 0) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == true) goto L20;
        r2 = r2 + "|" + a(r3);
        goto L14
    L20:
        r2 = r2 + a(r3);
        goto L14
    L18:
        r4 = false;
        goto L19
    L22:
        return r2;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean c(b4 r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r5, "message");
        List r7 = r5.G1();
        Object r2 = null;
        if (r7 == null) goto L14;
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L13;
        Object r3 = r8.next();
        if (((r) r3).getType() != r6) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
        r2 = r3;
        goto L13
    L10:
        r4 = false;
    L13:
        r2 = (r) r2;
    L14:
        if (r2 == null) goto L22;
        return true;
    L22:
        return false;
    }
}
