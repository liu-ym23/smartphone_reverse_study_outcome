package ld;

import com.ivy.ivykit.plugin.impl.utils.DefaultBulletActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        ((a) r5).getClass();
        if (Intrinsics.areEqual(DefaultBulletActivity.class, DefaultBulletActivity.class) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return DefaultBulletActivity.class.hashCode();
    }

    public final String toString() {
        return "PageConfig(activityCls=" + DefaultBulletActivity.class + ')';
    }
}
