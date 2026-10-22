package dr9;

import com.larus.platform.model.preview.MediaEntry;
import com.larus.platform.model.preview.MediaEntryScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final MediaEntryScene a;
    public final MediaEntry b;
    public final String c;
    public final String d;
    public final Integer e;
    public final Integer f;
    public final String g;
    public final c h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        c r14 = this.h;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
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
        return "MediaEntryContext(scene=" + this.a + ", entry=" + this.b + ", sourceNodeId=" + this.c + ", conversationId=" + this.d + ", botConversationType=" + this.e + ", instructionType=" + this.f + ", cameraScene=" + this.g + ", hostAbility=" + this.h + ')';
    }

    public b(MediaEntryScene r3, MediaEntry r4, String r5, String r6, Integer r7, c r8, int r9) {
        if ((r9 & 8) == 0) goto L6;
        r6 = null;
    L6:
        if ((r9 & 32) == 0) goto L9;
        r7 = null;
    L9:
        if ((r9 & 128) == 0) goto L11;
        r8 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "entry");
        Intrinsics.checkNotNullParameter(r5, "sourceNodeId");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = null;
        this.f = r7;
        this.g = null;
        this.h = r8;
    }
}
