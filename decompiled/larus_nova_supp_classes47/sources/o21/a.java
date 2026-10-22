package o21;

import com.bytedance.android.live.link.player.MultiPlayerScene;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.transfer.monitor.PlayerStatus;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final MultiPlayerScene a;
    public final PlayerStatus b;
    public final Float c;
    public final Float d;
    public final Float e;
    public final Float f;
    public final String g;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.e, this.f});
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("playerScene = " + this.a + ", errorCode = " + this.b);
        if (this.c == null) goto L6;
        r0.append(", ratioLeft = " + this.c);
    L6:
        if (this.d == null) goto L9;
        r0.append(", ratioTop = " + this.d);
    L9:
        if (this.e == null) goto L12;
        r0.append(", ratioRight = " + this.e);
    L12:
        if (this.f == null) goto L15;
        r0.append(", ratioBottom = " + this.f);
    L15:
        if (this.g == null) goto L18;
        r0.append(", message = " + this.g);
    L18:
        return r0.toString();
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
        if (r5 == null) goto L36;
        a r6 = (a) r5;
        if (this.a == r6.a) goto L17;
        return false;
    L17:
        if (this.b == r6.b) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.c, r6.c)) == false) goto L23;
        return false;
    L23:
        if ((!Intrinsics.areEqual(this.d, r6.d)) == false) goto L26;
        return false;
    L26:
        if ((!Intrinsics.areEqual(this.e, r6.e)) == false) goto L29;
        return false;
    L29:
        if ((!Intrinsics.areEqual(this.f, r6.f)) == false) goto L32;
        return false;
    L32:
        if ((!Intrinsics.areEqual(this.g, r6.g)) == false) goto L34;
        return false;
    L34:
        return true;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.multianchor.dialog.transfer.monitor.MultiPlayerMessage");
    L8:
        r2 = null;
        goto L10
    }

    public /* synthetic */ a(MultiPlayerScene r9, PlayerStatus r10) {
        this(r9, r10, null, null, null, null, null);
    }

    public a(MultiPlayerScene r2, PlayerStatus r3, Float r4, Float r5, Float r6, Float r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "playerScene");
        Intrinsics.checkNotNullParameter(r3, "playerStatus");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
