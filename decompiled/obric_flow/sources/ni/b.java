package ni;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IDLXBridgeMethod.Access f20265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f20266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f20267c;

    public b() {
        IDLXBridgeMethod.Access r5 = IDLXBridgeMethod.Access.f7464b;
        LinkedHashSet r10 = new LinkedHashSet();
        LinkedHashSet r11 = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(r5, "access");
        Intrinsics.checkNotNullParameter(r10, "includedMethods");
        Intrinsics.checkNotNullParameter(r11, "excludedMethods");
        this.f20265a = r5;
        this.f20266b = r10;
        this.f20267c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        if (this.f20265a == r10.f20265a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20266b, r10.f20266b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20267c, r10.f20267c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f20265a.hashCode() * 31;
        int r10 = (this.f20266b.hashCode() + r5) * 31;
        return this.f20267c.hashCode() + r10;
    }

    public final String toString() {
        return "PermissionRule(access=" + this.f20265a + ", includedMethods=" + this.f20266b + ", excludedMethods=" + this.f20267c + ')';
    }
}
