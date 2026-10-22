package rs8;

import android.view.View;
import com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.c2;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n implements g {
    public final String a;
    public final int b;
    public final CharSequence c;
    public final String d;
    public final String e;
    public final int f;
    public final int g;
    public final MessageActionBarAlign h;
    public final ActionStyle i;
    public final String j;
    public final Function1<View, Unit> k;

    public n() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
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
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((((((((((((((((r1 * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f) * 31) + this.g) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "LottieAction(actionBarKey=" + this.a + ", id=" + this.b + ", description=" + this.c + ", imageAssetFolder=" + this.d + ", lottieFile=" + this.e + ", repeatCount=" + this.f + ", repeatMode=" + this.g + ", messageActionBarAlign=" + this.h + ", style=" + this.i + ", accessibilityContent=" + this.j + ", onClick=" + this.k + ')';
    }

    @Override // rs8.g
    public final String a() {
        return this.a;
    }

    @Override // rs8.g
    public final MessageActionBarAlign b() {
        return this.h;
    }

    @Override // rs8.g
    public final Function1<View, Unit> c() {
        return this.k;
    }

    @Override // rs8.g
    public final String d() {
        return this.j;
    }

    @Override // rs8.g
    public final CharSequence getDescription() {
        return this.c;
    }

    @Override // rs8.g
    public final int getId() {
        return this.b;
    }

    @Override // rs8.g
    public final ActionStyle getStyle() {
        return this.i;
    }

    public n(MessageActionBarAlign r5, String r6, c2 r7) {
        ActionStyle r0 = ActionStyle.NORMAL;
        Intrinsics.checkNotNullParameter("", "description");
        Intrinsics.checkNotNullParameter("", "imageAssetFolder");
        Intrinsics.checkNotNullParameter("lottie/text_msg_voice_playing.json", "lottieFile");
        Intrinsics.checkNotNullParameter(r5, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r0, "style");
        Intrinsics.checkNotNullParameter(r6, "accessibilityContent");
        Intrinsics.checkNotNullParameter(r7, "onClick");
        this.a = "tts";
        this.b = 2131380350;
        this.c = "";
        this.d = "";
        this.e = "lottie/text_msg_voice_playing.json";
        this.f = -1;
        this.g = 1;
        this.h = r5;
        this.i = r0;
        this.j = r6;
        this.k = r7;
    }
}
