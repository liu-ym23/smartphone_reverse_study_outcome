package li;

import ai.j0;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuthConfigType f19633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f19634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f19635c;
    public final AuthBridgeAccess d;
    public final List e;
    public final List f;
    public final LinkedHashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f19636h;

    public a(AuthConfigType r5, List r10, l r11, AuthBridgeAccess r12, List r13, List r14, LinkedHashMap r15, int r16) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r10, "safe_urls");
        Intrinsics.checkNotNullParameter(r11, "public_key");
        Intrinsics.checkNotNullParameter(r12, "group");
        Intrinsics.checkNotNullParameter(r13, "included_methods");
        Intrinsics.checkNotNullParameter(r14, "excluded_methods");
        this.f19633a = r5;
        this.f19634b = r10;
        this.f19635c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f19636h = r16;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        AuthConfigType r11 = r10.f19633a;
        if (this.f19633a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19634b, r10.f19634b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19635c, r10.f19635c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.f19636h == r10.f19636h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f19633a.hashCode() * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.f(this.f19634b, r5, 31);
        int r11 = kk.a.b(this.f19635c.f19671a, r10, 31);
        int r12 = (this.d.hashCode() + r11) * 31;
        int r13 = androidx.constraintlayout.motion.widget.a.f(this.e, r12, 31);
        int r14 = androidx.constraintlayout.motion.widget.a.f(this.f, r13, 31);
        int r15 = (this.g.hashCode() + r14) * 31;
        return Integer.hashCode(this.f19636h) + r15;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("AuthConfigBean(type=");
        r5.append(this.f19633a);
        r5.append(", safe_urls=");
        r5.append(this.f19634b);
        r5.append(", public_key=");
        r5.append(this.f19635c);
        r5.append(", group=");
        r5.append(this.d);
        r5.append(", included_methods=");
        r5.append(this.e);
        r5.append(", excluded_methods=");
        r5.append(this.f);
        r5.append(", method_call_limits=");
        r5.append(this.g);
        r5.append(", fe_secure_auth_version=");
        return j0.n(r5, this.f19636h, ')');
    }
}
