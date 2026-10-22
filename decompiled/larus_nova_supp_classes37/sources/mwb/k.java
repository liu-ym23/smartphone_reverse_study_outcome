package mwb;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k {
    public static final /* synthetic */ int d = 0;
    public final View a;
    public final TextView b;
    public final TextView c;

    public static final class a {
    }

    static {
    }

    public k(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131375672);
        if (r0 == null) goto L11;
        this.b = (TextView) r0;
        View r4 = r3.findViewById(2131375673);
        if (r4 == null) goto L9;
        this.c = (TextView) r4;
        return;
    L9:
        throw new IllegalStateException("Required view not found, id=2131375673, type=".concat(TextView.class.getSimpleName()));
    L11:
        throw new IllegalStateException("Required view not found, id=2131375672, type=".concat(TextView.class.getSimpleName()));
    }
}
