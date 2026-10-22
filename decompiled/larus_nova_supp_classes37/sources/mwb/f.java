package mwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmCoveredEditTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public static final /* synthetic */ int k = 0;
    public final View a;
    public final View b;
    public final MmCoveredEditTextView c;
    public final TextView d;
    public final ImageView e;
    public final TextView f;
    public final ImageView g;
    public final TextView h;
    public final ImageView i;
    public final View j;

    public static final class a {
    }

    static {
    }

    public f(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131388843);
        if (r0 == null) goto L35;
        this.b = r0;
        Object r1 = r3.findViewById(2131390025);
        if (r1 == null) goto L33;
        this.c = (MmCoveredEditTextView) r1;
        View r2 = r3.findViewById(2131390088);
        if (r2 == null) goto L31;
        this.d = (TextView) r2;
        View r4 = r3.findViewById(2131375948);
        if (r4 == null) goto L29;
        this.e = (ImageView) r4;
        View r5 = r3.findViewById(2131390082);
        if (r5 == null) goto L27;
        this.f = (TextView) r5;
        View r6 = r3.findViewById(2131375919);
        if (r6 == null) goto L25;
        this.g = (ImageView) r6;
        View r7 = r3.findViewById(2131390047);
        if (r7 == null) goto L23;
        this.h = (TextView) r7;
        View r8 = r3.findViewById(2131375904);
        if (r8 == null) goto L21;
        this.i = (ImageView) r8;
        this.j = r3.findViewById(2131369204);
        return;
    L21:
        throw new IllegalStateException("Required view not found, id=2131375904, type=".concat(ImageView.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131390047, type=".concat(TextView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131375919, type=".concat(ImageView.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131390082, type=".concat(TextView.class.getSimpleName()));
    L29:
        throw new IllegalStateException("Required view not found, id=2131375948, type=".concat(ImageView.class.getSimpleName()));
    L31:
        throw new IllegalStateException("Required view not found, id=2131390088, type=".concat(TextView.class.getSimpleName()));
    L33:
        throw new IllegalStateException("Required view not found, id=2131390025, type=MmCoveredEditTextView");
    L35:
        throw new IllegalStateException("Required view not found, id=2131388843, type=".concat(View.class.getSimpleName()));
    }
}
