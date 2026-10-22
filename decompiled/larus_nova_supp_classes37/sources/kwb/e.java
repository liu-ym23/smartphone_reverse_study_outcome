package kwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final /* synthetic */ int e = 0;
    public final View a;
    public final TextView b;
    public final ImageView c;
    public final View d;

    public static final class a {
    }

    static {
    }

    public e(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131390084);
        if (r0 == null) goto L15;
        this.b = (TextView) r0;
        View r1 = r3.findViewById(2131375905);
        if (r1 == null) goto L13;
        this.c = (ImageView) r1;
        View r4 = r3.findViewById(2131369197);
        if (r4 == null) goto L11;
        this.d = r4;
        return;
    L11:
        throw new IllegalStateException("Required view not found, id=2131369197, type=".concat(View.class.getSimpleName()));
    L13:
        throw new IllegalStateException("Required view not found, id=2131375905, type=".concat(ImageView.class.getSimpleName()));
    L15:
        throw new IllegalStateException("Required view not found, id=2131390084, type=".concat(TextView.class.getSimpleName()));
    }
}
