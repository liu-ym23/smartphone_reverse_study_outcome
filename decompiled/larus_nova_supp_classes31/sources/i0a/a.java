package i0a;

import com.larus.platform.api.creation.UserCreation;
import com.larus.ugc.feed.api.model.CreationFeedTrackParamsKmp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final CreationFeedTrackParamsKmp a;
    public final boolean b;
    public final UserCreation c;
    public final boolean d;
    public final boolean e;
    public final Integer f;
    public final boolean g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;

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
        if (this.b == r6.b) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        UserCreation r4 = this.c;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        if (this.d == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        if (this.e == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        Integer r12 = this.f;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        if (this.g == true) goto L26;
        r2 = 1237;
    L26:
        int r15 = (r14 + r2) * 31;
        String r16 = this.h;
        if (r16 != null) goto L29;
        int r17 = 0;
    L30:
        int r18 = (r15 + r17) * 31;
        String r19 = this.i;
        if (r19 != null) goto L33;
        int r20 = 0;
    L34:
        int r21 = (r18 + r20) * 31;
        String r22 = this.j;
        if (r22 != null) goto L37;
        int r23 = 0;
    L38:
        int r24 = (r21 + r23) * 31;
        String r25 = this.k;
        if (r25 == null) goto L43;
        r5 = r25.hashCode();
    L43:
        return r24 + r5;
    L37:
        r23 = r22.hashCode();
        goto L38
    L33:
        r20 = r19.hashCode();
        goto L34
    L29:
        r17 = r16.hashCode();
        goto L30
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = 1237;
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
        return "CreationDetailBottomToolsInitParamsKmp(trackParams=" + this.a + ", ignoreTplInfo=" + this.b + ", userCreation=" + this.c + ", isFromAnchor=" + this.d + ", openNewChatPageOnSend=" + this.e + ", creationDoSameLandingType=" + this.f + ", isSendFromDetail=" + this.g + ", refImgUrl=" + this.h + ", refFaceNum=" + this.i + ", refWidth=" + this.j + ", refHeight=" + this.k + ')';
    }

    public a(CreationFeedTrackParamsKmp r2, UserCreation r3, boolean r4, Integer r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "trackParams");
        this.a = r2;
        this.b = false;
        this.c = r3;
        this.d = false;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }
}
