package m0a;

import com.larus.ugc.feed.api.model.CommunityCreateLaunchModeKmp;
import com.larus.ugc.feed.api.model.FabVisibilityStateKmp;
import com.larus.ugc.feed.api.model.TabItemInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final CommunityCreateLaunchModeKmp a;
    public final boolean b;
    public final String c;
    public final int d;
    public final List<TabItemInfoKmp> e;
    public final int f;
    public final TabItemInfoKmp g;
    public final FabVisibilityStateKmp h;
    public final boolean i;
    public final UserCreationKmp j;
    public final boolean k;
    public final String l;
    public final String m;

    public f() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f) * 31;
        TabItemInfoKmp r4 = this.g;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r3 + r6) * 31) + this.h.hashCode()) * 31;
        if (this.i == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        UserCreationKmp r10 = this.j;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.k == true) goto L22;
        r2 = 1237;
    L22:
        int r13 = (r12 + r2) * 31;
        String r14 = this.l;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (r13 + r15) * 31;
        String r17 = this.m;
        if (r17 == null) goto L31;
        r5 = r17.hashCode();
    L31:
        return r16 + r5;
    L25:
        r15 = r14.hashCode();
        goto L26
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "CommunityCreateUiStateKmp(launchMode=" + this.a + ", isMultiTab=" + this.b + ", currentPage=" + this.c + ", recommendType=" + this.d + ", tabList=" + this.e + ", currentTabIndex=" + this.f + ", lastTabItemInfo=" + this.g + ", fabVisibility=" + this.h + ", showAvatar=" + this.i + ", pendingPublishedCreation=" + this.j + ", hasResumedBefore=" + this.k + ", lastEnterMethod=" + this.l + ", previousPage=" + this.m + ')';
    }

    public /* synthetic */ f(int r15) {
        this(CommunityCreateLaunchModeKmp.STANDALONE, false, "community_create", 1, CollectionsKt.emptyList(), 0, null, FabVisibilityStateKmp.VISIBLE, false, null, false, null, null);
    }

    public f(CommunityCreateLaunchModeKmp r2, boolean r3, String r4, int r5, List<TabItemInfoKmp> r6, int r7, TabItemInfoKmp r8, FabVisibilityStateKmp r9, boolean r10, UserCreationKmp r11, boolean r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r2, "launchMode");
        Intrinsics.checkNotNullParameter(r4, "currentPage");
        Intrinsics.checkNotNullParameter(r6, "tabList");
        Intrinsics.checkNotNullParameter(r9, "fabVisibility");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }

    public static f a(f r14, CommunityCreateLaunchModeKmp r15, boolean r16, String r17, int r18, List r19, int r20, TabItemInfoKmp r21, FabVisibilityStateKmp r22, boolean r23, UserCreationKmp r24, boolean r25, String r26, String r27, int r28) {
        if ((r28 & 1) == 0) goto L5;
        CommunityCreateLaunchModeKmp r2 = r14.a;
    L7:
        if ((r28 & 2) == 0) goto L9;
        boolean r3 = r14.b;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = r14.c;
    L15:
        if ((r28 & 8) == 0) goto L17;
        int r5 = r14.d;
    L19:
        if ((r28 & 16) == 0) goto L21;
        List r6 = r14.e;
    L23:
        if ((r28 & 32) == 0) goto L25;
        int r7 = r14.f;
    L27:
        if ((r28 & 64) == 0) goto L29;
        TabItemInfoKmp r8 = r14.g;
    L31:
        if ((r28 & 128) == 0) goto L33;
        FabVisibilityStateKmp r9 = r14.h;
    L35:
        if ((r28 & 256) == 0) goto L37;
        boolean r10 = r14.i;
    L39:
        if ((r28 & 512) == 0) goto L41;
        UserCreationKmp r11 = r14.j;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        boolean r12 = r14.k;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r13 = r14.l;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        String r1 = r14.m;
    L54:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r2, "launchMode");
        Intrinsics.checkNotNullParameter(r4, "currentPage");
        Intrinsics.checkNotNullParameter(r6, "tabList");
        Intrinsics.checkNotNullParameter(r9, "fabVisibility");
        return new f(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r27;
        goto L54
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }
}
