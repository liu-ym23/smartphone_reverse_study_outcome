package n0a;

import com.larus.ugc.feed.api.model.UserCreationModelKmp;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final List<UserCreationModelKmp> a;
    public final d b;
    public final e c;
    public final b d;
    public final Long e;
    public final c f;

    public a() {
        this(0);
    }

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        e r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        b r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        c r11 = this.f;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationFeedUiState(creationModelList=" + this.a + ", pageState=" + this.b + ", refreshState=" + this.c + ", moreState=" + this.d + ", invokeLoadMoreEvent=" + this.e + ", invokeNotifyDataList=" + this.f + ')';
    }

    public /* synthetic */ a(int r8) {
        this(CollectionsKt.emptyList(), d.e.a, null, null, null, null);
    }

    public a(List<UserCreationModelKmp> r2, d r3, e r4, b r5, Long r6, c r7) {
        Intrinsics.checkNotNullParameter(r2, "creationModelList");
        Intrinsics.checkNotNullParameter(r3, "pageState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public static a a(a r7, List r8, d r9, e r10, b r11, Long r12, c r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        List r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.b;
    L8:
        d r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.c;
    L11:
        e r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = r7.d;
    L14:
        b r4 = r11;
        if ((r14 & 16) == 0) goto L17;
        r12 = r7.e;
    L17:
        Long r5 = r12;
        if ((r14 & 32) == 0) goto L20;
        r13 = r7.f;
    L20:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "creationModelList");
        Intrinsics.checkNotNullParameter(r2, "pageState");
        return new a(r1, r2, r3, r4, r5, r13);
    }
}
