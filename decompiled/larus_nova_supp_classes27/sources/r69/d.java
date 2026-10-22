package r69;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import com.larus.utils.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d extends a {
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;
    public final boolean h;

    @Override // r69.a
    public final ConstraintLayout a(Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        boolean r2 = false;
        ConstraintLayout r16 = LayoutInflater.from(r15).inflate(2131562304, null, false);
        ConstraintLayout r0 = r16;
        int r1 = 2131369552;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r16, 2131369552);
        if (r3 == null) goto L50;
        r1 = 2131369553;
        LottieAnimationView r4 = ViewBindings.findChildViewById(r16, 2131369553);
        if (r4 == null) goto L50;
        r1 = 2131369554;
        if (((FrameLayout) ViewBindings.findChildViewById(r16, 2131369554)) == null) goto L50;
        r1 = 2131369555;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r16, 2131369555);
        if (r5 == null) goto L50;
        r1 = 2131369556;
        AppCompatTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131369556);
        if (r6 == null) goto L50;
        r1 = 2131369557;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r16, 2131369557);
        if (r7 == null) goto L50;
        r1 = 2131369600;
        if (ViewBindings.findChildViewById(r16, 2131369600) == null) goto L50;
        r1 = 2131369601;
        LottieAnimationView r8 = ViewBindings.findChildViewById(r16, 2131369601);
        if (r8 == null) goto L50;
        r1 = 2131369602;
        if (((FrameLayout) ViewBindings.findChildViewById(r16, 2131369602)) == null) goto L50;
        r1 = 2131369603;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r16, 2131369603);
        if (r9 == null) goto L50;
        r1 = 2131369604;
        AppCompatTextView r10 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131369604);
        if (r10 == null) goto L50;
        r1 = 2131369605;
        if (ViewBindings.findChildViewById(r16, 2131369605) == null) goto L50;
        r1 = 2131369606;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r16, 2131369606);
        if (r11 == null) goto L50;
        r1 = 2131369607;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r16, 2131369607);
        if (r12 == null) goto L50;
        r1 = 2131369608;
        AppCompatTextView r13 = (DoraTextView) ViewBindings.findChildViewById(r16, 2131369608);
        if (r13 == null) goto L50;
        r12.setImageResource(this.a);
        r13.setText(this.b);
        int r17 = this.d;
        if (r17 < 0) goto L36;
        if (r17 >= 101) goto L36;
        boolean r18 = true;
    L38:
        if (r18 == false) goto L40;
        Intrinsics.checkNotNull(r11);
        e1.x(r11);
        r11.setImageResource(this.c);
        e1.o(r9);
        Intrinsics.checkNotNull(r8);
        e1.x(r8);
        q69.d.a(r8, this.d, this.e);
        Intrinsics.checkNotNull(r10);
        e1.x(r10);
        StringBuilder r110 = new StringBuilder();
        r110.append(this.d);
        r110.append('%');
        r10.setText(r110.toString());
        Intrinsics.checkNotNull(r10);
    L41:
        int r111 = this.g;
        if (r111 < 0) goto L45;
        if (r111 >= 101) goto L45;
        r2 = true;
    L45:
        if (r2 == false) goto L47;
        Intrinsics.checkNotNull(r7);
        e1.x(r7);
        r7.setImageResource(this.f);
        e1.o(r5);
        Intrinsics.checkNotNull(r4);
        e1.x(r4);
        q69.d.a(r4, this.g, this.h);
        Intrinsics.checkNotNull(r6);
        e1.x(r6);
        StringBuilder r112 = new StringBuilder();
        r112.append(this.g);
        r112.append('%');
        r6.setText(r112.toString());
    L48:
        return r0;
    L47:
        e1.o(r3);
        goto L48
    L40:
        Intrinsics.checkNotNull(r9);
        e1.x(r9);
        r9.setImageResource(2131240508);
        int r113 = j0.a;
        r9.setColorFilter(j0.a(2131103140), PorterDuff.Mode.SRC_IN);
        e1.o(r8);
        e1.o(r10);
    L36:
        r18 = false;
    L50:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r1)));
    }

    public d(int r2, String r3, int r4, int r5, boolean r6, int r7, int r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r3, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
