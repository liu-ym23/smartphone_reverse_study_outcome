package tib;

import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProvider;
import com.suite.lark.platform.feature.forward.doubao.assembly.dependency.ForwardNewDependency;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final ExternalTargetAvatarProvider a;
    public final String b;
    public final Integer c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Integer r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ExternalTargetItem(avatarProvider=" + this.a + ", name=" + this.b + ", insertPosition=" + this.c + ')';
    }

    public a(ForwardNewDependency.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "avatarProvider");
        Intrinsics.checkNotNullParameter(r3, "name");
        this.a = r2;
        this.b = r3;
        this.c = null;
    }
}
