package kwb;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int d = 0;
    public final View a;
    public final View b;
    public final TextView c;

    /* JADX INFO: renamed from: kwb.a$a, reason: collision with other inner class name */
    public static final class C0161a {
    }

    static {
    }

    public a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131363629);
        if (r0 == null) goto L11;
        this.b = r0;
        View r4 = r3.findViewById(2131362224);
        if (r4 == null) goto L9;
        this.c = (TextView) r4;
        return;
    L9:
        throw new IllegalStateException("Required view not found, id=2131362224, type=".concat(TextView.class.getSimpleName()));
    L11:
        throw new IllegalStateException("Required view not found, id=2131363629, type=".concat(View.class.getSimpleName()));
    }
}
