package y4;

import android.graphics.Rect;
import com.bytedance.applet.model.floating.i;
import com.bytedance.applet.model.floating.j;
import com.bytedance.applet.model.floating.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final Function2<Boolean, Boolean, Unit> a;
    public final Function0<Rect> b;
    public final Function1<byte[], Unit> c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ChatSpeakVisualizerAbility(switchStatus=" + this.a + ", globalVisibleRect=" + this.b + ", setAudioData=" + this.c + ')';
    }

    public b(i r10, j r11, k r12) {
        Intrinsics.checkNotNullParameter(r10, "switchStatus");
        Intrinsics.checkNotNullParameter(r11, "globalVisibleRect");
        Intrinsics.checkNotNullParameter(r12, "setAudioData");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
