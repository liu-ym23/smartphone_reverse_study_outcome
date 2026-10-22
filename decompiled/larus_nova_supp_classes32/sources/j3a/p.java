package j3a;

import com.larus.voicecall.impl.ui.utils.NewThemeSwitchAvatar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p {
    public final boolean a;
    public final NewThemeSwitchAvatar.AvatarType b;

    public p() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "RealtimeInterviewStatus(subtitleOpen=" + this.a + ", showAvatarType=" + this.b + ')';
    }

    public /* synthetic */ p(int r2) {
        this(false, NewThemeSwitchAvatar.AvatarType.BUBBLE);
    }

    public p(boolean r2, NewThemeSwitchAvatar.AvatarType r3) {
        Intrinsics.checkNotNullParameter(r3, "showAvatarType");
        this.a = r2;
        this.b = r3;
    }
}
