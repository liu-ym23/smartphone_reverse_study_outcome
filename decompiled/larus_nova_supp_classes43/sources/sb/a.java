package sb;

import com.bytedance.android.scope.m;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void call(String r10) {
        Intrinsics.checkNotNullParameter(r10, "group");
        int r0 = r10.hashCode();
        if (r0 == (-1734888178)) goto L16;
        if (r0 == (-1068799377)) goto L13;
        if (r0 == 1434631203) goto L10;
        return;
    L10:
        if (r10.equals("settings") == false) goto L19;
        int r11 = tm3.a.a;
        int r12 = vm3.a.a;
        int r13 = wm3.a.a;
        int r14 = xm3.a.a;
        int r15 = bn3.a.a;
        en3.a.a();
        int r16 = gn3.a.a;
        return;
    L19:
        return;
    L13:
        if (r10.equals("modelx") == false) goto L21;
        kx2.a.g.b();
        return;
    L21:
        return;
    L16:
        if (r10.equals("scope-modules") == false) goto L23;
        i03.a r17 = i03.a.a;
        m r18 = m.e;
        i03.a r1 = i03.a.a;
        r18.getClass();
        m.e(r1);
        m.e(k03.a.a);
        m.e(l03.a.b);
        m.e(m03.a.b);
        p03.a r19 = p03.a.a;
        r18.getClass();
        m.e(r19);
        s03.a r20 = s03.a.a;
        r18.getClass();
        m.e(r20);
        u03.a r21 = u03.a.a;
        r18.getClass();
        m.e(r21);
        return;
    }
}
