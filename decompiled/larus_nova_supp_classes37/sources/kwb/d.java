package kwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final /* synthetic */ int g = 0;
    public final View a;
    public final View b;
    public final TextView c;
    public final TextView d;
    public final ImageView e;
    public final View f;

    public static final class a {
    }

    static {
    }

    public d(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131388777);
        if (r0 == null) goto L23;
        this.b = r0;
        View r1 = r3.findViewById(2131390084);
        if (r1 == null) goto L21;
        this.c = (TextView) r1;
        View r2 = r3.findViewById(2131390079);
        if (r2 == null) goto L19;
        this.d = (TextView) r2;
        View r4 = r3.findViewById(2131375905);
        if (r4 == null) goto L17;
        this.e = (ImageView) r4;
        View r5 = r3.findViewById(2131369197);
        if (r5 == null) goto L15;
        this.f = r5;
        return;
    L15:
        throw new IllegalStateException("Required view not found, id=2131369197, type=".concat(View.class.getSimpleName()));
    L17:
        throw new IllegalStateException("Required view not found, id=2131375905, type=".concat(ImageView.class.getSimpleName()));
    L19:
        throw new IllegalStateException("Required view not found, id=2131390079, type=".concat(TextView.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131390084, type=".concat(TextView.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131388777, type=".concat(View.class.getSimpleName()));
    }
}
