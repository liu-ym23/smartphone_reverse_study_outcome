package r69;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b extends a {
    public final int a;
    public final String b;
    public final Integer c;
    public final Integer d;

    @Override // r69.a
    public final ConstraintLayout a(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        int r2 = 0;
        ConstraintLayout r12 = LayoutInflater.from(r11).inflate(2131562303, null, false);
        ConstraintLayout r0 = r12;
        int r1 = 2131375311;
        if (((LinearLayout) ViewBindings.findChildViewById(r12, 2131375311)) == null) goto L43;
        r1 = 2131377773;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r12, 2131377773);
        if (r3 == null) goto L43;
        r1 = 2131377780;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r12, 2131377780);
        if (r4 == null) goto L43;
        r1 = 2131377814;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r12, 2131377814);
        if (r5 == null) goto L43;
        r1 = 2131384584;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, 2131384584);
        if (r6 == null) goto L43;
        r1 = 2131384632;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, 2131384632);
        if (r7 == null) goto L43;
        r1 = 2131388918;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r12, 2131388918);
        if (r8 == null) goto L43;
        r4.setImageResource(this.a);
        r8.setText(this.b);
        boolean r9 = true;
        if (this.c == null) goto L19;
        boolean r13 = true;
    L20:
        StringBuilder r10 = new StringBuilder();
        r10.append(this.c);
        r10.append('%');
        r5.setText(r10.toString());
        if (r13 == false) goto L23;
        int r14 = 0;
    L24:
        r5.setVisibility(r14);
        if (r13 == false) goto L27;
        int r15 = 0;
    L28:
        r3.setVisibility(r15);
        if (this.d != null) goto L32;
        r9 = false;
    L32:
        StringBuilder r16 = new StringBuilder();
        r16.append(this.d);
        r16.append('%');
        r7.setText(r16.toString());
        if (r9 == false) goto L35;
        int r17 = 0;
    L36:
        r7.setVisibility(r17);
        if (r9 == true) goto L40;
        r2 = 8;
    L40:
        r6.setVisibility(r2);
        return r0;
    L35:
        r17 = 8;
        goto L36
    L27:
        r15 = 8;
        goto L28
    L23:
        r14 = 8;
        goto L24
    L19:
        r13 = false;
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r1)));
    }

    public b(String r2, Integer r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.a = 2131240639;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
