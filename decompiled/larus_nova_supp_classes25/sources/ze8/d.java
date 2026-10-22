package ze8;

import com.larus.bmhome.chat.input.swipe.InputContentMode;
import com.larus.bmhome.chat.model.ChatDraftItem;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final boolean f;
    public final Integer g;
    public final c h;
    public final InputContentMode i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.d) * 31) + this.e) * 31;
        if (this.f == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        Integer r7 = this.g;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        c r10 = this.h;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        InputContentMode r13 = this.i;
        if (r13 == null) goto L23;
        r2 = r13.hashCode();
    L23:
        return r12 + r2;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "InputContentSpec(key=" + this.a + ", text=" + this.b + ", hint=" + this.c + ", selectionStart=" + this.d + ", selectionEnd=" + this.e + ", showSendButton=" + this.f + ", actionSendImageResId=" + this.g + ", actionVisibility=" + this.h + ", inputMode=" + this.i + ')';
    }

    public d(String r3, String r4, String r5, int r6, int r7, Integer r8, c r9, InputContentMode r10) {
        boolean r0 = !StringsKt.isBlank(r4);
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, ChatDraftItem.TYPE_TEXT);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r0;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
