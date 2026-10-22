package li;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AuthBridgeAccess f19638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f19639c;
    public final List d;
    public final Long e;

    public b(String r5, AuthBridgeAccess r10, List r11, List r12, Long r13) {
        Intrinsics.checkNotNullParameter(r5, "pattern");
        Intrinsics.checkNotNullParameter(r10, "access");
        Intrinsics.checkNotNullParameter(r11, "included_methods");
        Intrinsics.checkNotNullParameter(r12, "excluded_methods");
        this.f19637a = r5;
        this.f19638b = r10;
        this.f19639c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        String r11 = r10.f19637a;
        if (Intrinsics.areEqual(this.f19637a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f19638b == r10.f19638b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19639c, r10.f19639c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f19637a.hashCode() * 31;
        int r10 = (this.f19638b.hashCode() + r5) * 31;
        int r11 = androidx.constraintlayout.motion.widget.a.f(this.f19639c, r10, 31);
        int r12 = androidx.constraintlayout.motion.widget.a.f(this.d, r11, 31);
        Long r13 = this.e;
        if (r13 != null) goto L5;
        int r14 = 0;
    L7:
        return r12 + r14;
    L5:
        r14 = r13.hashCode();
        goto L7
    }

    public final String toString() {
        return "AuthConfigV1Bean(pattern=" + this.f19637a + ", access=" + this.f19638b + ", included_methods=" + this.f19639c + ", excluded_methods=" + this.d + ", feId=" + this.e + ')';
    }
}
