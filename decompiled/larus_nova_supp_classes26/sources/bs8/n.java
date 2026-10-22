package bs8;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n {
    public final String a;
    public final Map<String, String> b;

    public n() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "TaskSkillMessageSnapshot(queryPrefix=" + this.a + ", messageExt=" + this.b + ')';
    }

    public /* synthetic */ n(int r2) {
        this("", MapsKt.emptyMap());
    }

    public final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        if (StringsKt.trim(r3).toString().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r3;
    L9:
        return this.a + r3;
    L5:
        r0 = false;
        goto L6
    }

    public n(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "queryPrefix");
        Intrinsics.checkNotNullParameter(r3, "messageExt");
        this.a = r2;
        this.b = r3;
    }
}
