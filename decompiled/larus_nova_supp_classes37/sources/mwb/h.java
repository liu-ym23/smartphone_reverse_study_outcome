package mwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public static final /* synthetic */ int i = 0;
    public final View a;
    public final ImageView b;
    public final TextView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;

    public static final class a {
    }

    static {
    }

    public h(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131375905);
        if (r0 == null) goto L31;
        this.b = (ImageView) r0;
        View r1 = r3.findViewById(2131390086);
        if (r1 == null) goto L29;
        this.c = (TextView) r1;
        View r2 = r3.findViewById(2131375918);
        if (r2 == null) goto L27;
        this.d = (ImageView) r2;
        View r4 = r3.findViewById(2131375895);
        if (r4 == null) goto L25;
        this.e = (ImageView) r4;
        View r5 = r3.findViewById(2131375943);
        if (r5 == null) goto L23;
        this.f = (ImageView) r5;
        View r6 = r3.findViewById(2131375920);
        if (r6 == null) goto L21;
        this.g = (ImageView) r6;
        View r7 = r3.findViewById(2131375944);
        if (r7 == null) goto L19;
        this.h = (ImageView) r7;
        return;
    L19:
        throw new IllegalStateException("Required view not found, id=2131375944, type=".concat(ImageView.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131375920, type=".concat(ImageView.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131375943, type=".concat(ImageView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131375895, type=".concat(ImageView.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131375918, type=".concat(ImageView.class.getSimpleName()));
    L29:
        throw new IllegalStateException("Required view not found, id=2131390086, type=".concat(TextView.class.getSimpleName()));
    L31:
        throw new IllegalStateException("Required view not found, id=2131375905, type=".concat(ImageView.class.getSimpleName()));
    }
}
