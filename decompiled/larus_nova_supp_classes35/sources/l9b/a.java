package l9b;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final boolean a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final Function0<Unit> g;
    public final Function0<Unit> h;
    public final Function0<Unit> i;
    public final Function0<Unit> j;

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
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.e == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.f == true) goto L18;
        r1 = 1237;
    L18:
        int r7 = (r6 + r1) * 31;
        Function0<Unit> r8 = this.g;
        int r9 = 0;
        if (r8 != null) goto L21;
        int r10 = 0;
    L22:
        int r11 = (r7 + r10) * 31;
        Function0<Unit> r12 = this.h;
        if (r12 != null) goto L25;
        int r13 = 0;
    L26:
        int r14 = (r11 + r13) * 31;
        Function0<Unit> r15 = this.i;
        if (r15 != null) goto L29;
        int r16 = 0;
    L30:
        int r17 = (r14 + r16) * 31;
        Function0<Unit> r18 = this.j;
        if (r18 == null) goto L35;
        r9 = r18.hashCode();
    L35:
        return r17 + r9;
    L29:
        r16 = r15.hashCode();
        goto L30
    L25:
        r13 = r12.hashCode();
        goto L26
    L21:
        r10 = r8.hashCode();
        goto L22
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeContactHeaderConfig(showNewFriendEntry=" + this.a + ", newFriendBadgeCount=" + this.b + ", newFriendSubtitle=" + this.c + ", showProfileCardEntry=" + this.d + ", showExternalContactEntry=" + this.e + ", showOrgContactsTitle=" + this.f + ", onNewFriendClick=" + this.g + ", onGroupChatClick=" + this.h + ", onProfileCardClick=" + this.i + ", onExternalContactClick=" + this.j + ')';
    }

    public /* synthetic */ a(int r12) {
        this(false, BuildConfig.FLAVOR, BuildConfig.FLAVOR, false, false, false, null, null, null, null);
    }

    public a(boolean r2, String r3, String r4, boolean r5, boolean r6, boolean r7, Function0<Unit> r8, Function0<Unit> r9, Function0<Unit> r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r3, "newFriendBadgeCount");
        Intrinsics.checkNotNullParameter(r4, "newFriendSubtitle");
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
    }
}
