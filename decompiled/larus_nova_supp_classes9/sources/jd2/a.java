package jd2;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final String a;
    public final int b;
    public final List<k> c;

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ChorusUserInfoData(chorusNumStr='" + this.a + "', chorusNum=" + this.b + ", chorusUserAvatarList=" + this.c + ')';
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L24;
        a r6 = (a) r5;
        if ((!Intrinsics.areEqual(this.a, r6.a)) == false) goto L17;
        return false;
    L17:
        if (this.b == r6.b) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.c, r6.c)) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvapi.model.ChorusUserInfoData");
    L8:
        r2 = null;
        goto L10
    }

    public a(String r2, int r3, List<? extends k> r4) {
        Intrinsics.checkNotNullParameter(r2, "chorusNumStr");
        Intrinsics.checkNotNullParameter(r4, "chorusUserAvatarList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
