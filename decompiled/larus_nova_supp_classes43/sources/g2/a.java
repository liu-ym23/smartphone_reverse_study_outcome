package g2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.applet.model.floating.o;
import com.bytedance.applet.model.floating.r;
import com.bytedance.applet.model.floating.s;
import com.bytedance.applet.model.floating.t;
import com.bytedance.applet.model.floating.u;
import com.bytedance.applet.model.floating.v;
import com.bytedance.applet.model.floating.w;
import com.bytedance.applet.model.floating.x;
import com.bytedance.applet.model.floating.y;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final Function0<String> a;
    public final Function1<ViewGroup, Unit> b;
    public final Function1<ViewGroup, Unit> c;
    public final Function1<ConstraintLayout, Pair<y4.a, y4.b>> d;
    public final Function1<TextView, Unit> e;
    public final Function1<EditText, Unit> f;
    public final Function1<Context, View> g;
    public final Function1<Context, View> h;
    public final Function1<Context, View> i;
    public final Function1<y4.c, Boolean> j;
    public final Function1<y4.c, Unit> k;
    public final Function1<y4.c, Unit> l;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r11.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r11.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r11.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode();
    }

    public final String toString() {
        return "FloatingSpeakerConfig(placeHolder=" + this.a + ", setChatInputContainerStyle=" + this.b + ", setChatInputStyle=" + this.c + ", setSpeakerContainerStyle=" + this.d + ", setSpeakTextStyle=" + this.e + ", setInputTextStyle=" + this.f + ", actionInputView=" + this.g + ", actionSpeakView=" + this.h + ", actionSendView=" + this.i + ", onSpeak=" + this.j + ", onSpeakSubmit=" + this.k + ", onSpeakCancel=" + this.l + ')';
    }

    public a(com.bytedance.applet.model.floating.d r10, s r11, t r12, u r13, v r14, w r15, x r16, y r17, com.bytedance.applet.model.floating.e r18, com.bytedance.applet.model.floating.f r19, o r110, r r111) {
        Intrinsics.checkNotNullParameter(r10, "placeHolder");
        Intrinsics.checkNotNullParameter(r11, "setChatInputContainerStyle");
        Intrinsics.checkNotNullParameter(r12, "setChatInputStyle");
        Intrinsics.checkNotNullParameter(r13, "setSpeakerContainerStyle");
        Intrinsics.checkNotNullParameter(r14, "setSpeakTextStyle");
        Intrinsics.checkNotNullParameter(r15, "setInputTextStyle");
        Intrinsics.checkNotNullParameter(r16, "actionInputView");
        Intrinsics.checkNotNullParameter(r17, "actionSpeakView");
        Intrinsics.checkNotNullParameter(r18, "actionSendView");
        Intrinsics.checkNotNullParameter(r19, "onSpeak");
        Intrinsics.checkNotNullParameter(r110, "onSpeakSubmit");
        Intrinsics.checkNotNullParameter(r111, "onSpeakCancel");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
        this.l = r111;
    }
}
