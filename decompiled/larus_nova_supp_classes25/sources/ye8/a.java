package ye8;

import com.larus.bmhome.chat.input.ChatInputPlaceholderMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final ChatInputPlaceholderMode d;
    public final String e;

    public a() {
        this(null, false, true, ChatInputPlaceholderMode.KEYBOARD, null);
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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.b == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.c == true) goto L14;
        r4 = 1237;
    L14:
        int r7 = (((r6 + r4) * 31) + this.d.hashCode()) * 31;
        String r8 = this.e;
        if (r8 == null) goto L19;
        r1 = r8.hashCode();
    L19:
        return r7 + r1;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatInputPlaceholderConfig(hint=" + this.a + ", showActionEntrance=" + this.b + ", showPlusMenu=" + this.c + ", mode=" + this.d + ", speakHint=" + this.e + ')';
    }

    public a(String r2, boolean r3, boolean r4, ChatInputPlaceholderMode r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "mode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
