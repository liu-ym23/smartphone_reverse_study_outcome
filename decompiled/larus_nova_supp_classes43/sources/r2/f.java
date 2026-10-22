package r2;

import com.bytedance.ai.applet.components.input.AppletChatPanelState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public final int a;
    public final AppletChatPanelState b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "AppletChatPanelInfo(height=" + this.a + ", state=" + this.b + ')';
    }

    public f(int r10, AppletChatPanelState r11) {
        Intrinsics.checkNotNullParameter(r11, "state");
        this.a = r10;
        this.b = r11;
    }
}
