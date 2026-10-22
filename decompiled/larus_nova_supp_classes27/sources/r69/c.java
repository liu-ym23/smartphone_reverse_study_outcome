package r69;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.view.DoraTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends a {
    public final Drawable a;
    public final String b;
    public final String c;

    @Override // r69.a
    public final ConstraintLayout a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        ConstraintLayout r7 = LayoutInflater.from(r6).cloneInContext(r6).inflate(2131562302, null, false);
        ConstraintLayout r0 = r7;
        int r1 = 2131369588;
        if (ViewBindings.findChildViewById(r7, 2131369588) == null) goto L13;
        r1 = 2131369589;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r7, 2131369589);
        if (r2 == null) goto L13;
        r1 = 2131369590;
        AppCompatTextView r3 = (DoraTextView) ViewBindings.findChildViewById(r7, 2131369590);
        if (r3 == null) goto L13;
        r1 = 2131369591;
        AppCompatTextView r4 = (DoraTextView) ViewBindings.findChildViewById(r7, 2131369591);
        if (r4 == null) goto L13;
        r2.setImageDrawable(this.a);
        r4.setText(this.b);
        r3.setText(this.c);
        return r0;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r1)));
    }

    public c(Drawable r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "deviceName");
        Intrinsics.checkNotNullParameter(r4, "subtitle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
