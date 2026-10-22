package m0a;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.ugc.feed.impl.mapper.CreationFeedPlatformRepositoryAdapter;
import kotlin.jvm.internal.Intrinsics;
import zp9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g implements h {
    public final l a;
    public final k b;
    public final o0a.a c;
    public final s d;
    public final RecyclerView.RecycledViewPool e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        k r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        s r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        RecyclerView.RecycledViewPool r8 = this.e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationFeedInitDependencyAndroid(repository=" + this.a + ", actionInterceptor=" + this.b + ", tracker=" + this.c + ", creationMenusCreator=" + this.d + ", sharedRecycledViewPool=" + this.e + ')';
    }

    @Override // m0a.h
    public final o0a.a R0() {
        return this.c;
    }

    @Override // m0a.h
    public final k a() {
        return this.b;
    }

    @Override // m0a.h
    public final l b() {
        return this.a;
    }

    public g(CreationFeedPlatformRepositoryAdapter r2, com.larus.ugc.feed.impl.mapper.b r3, o0a.a r4, s r5, RecyclerView.RecycledViewPool r6) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r4, "tracker");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
