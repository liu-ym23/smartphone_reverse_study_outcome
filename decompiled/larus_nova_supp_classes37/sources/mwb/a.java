package mwb;

import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int i = 0;
    public final View a;
    public final MmTitleBarView b;
    public final View c;
    public final View d;
    public final TextView e;
    public final TextView f;
    public final View g;
    public final View h;

    /* JADX INFO: renamed from: mwb.a$a, reason: collision with other inner class name */
    public static final class C0167a {
    }

    static {
    }

    public a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        Object r0 = r3.findViewById(2131388775);
        if (r0 == null) goto L31;
        this.b = (MmTitleBarView) r0;
        View r1 = r3.findViewById(2131363396);
        if (r1 == null) goto L29;
        this.c = r1;
        View r2 = r3.findViewById(2131363390);
        if (r2 == null) goto L27;
        this.d = r2;
        View r4 = r3.findViewById(2131363398);
        if (r4 == null) goto L25;
        this.e = (TextView) r4;
        View r5 = r3.findViewById(2131363391);
        if (r5 == null) goto L23;
        this.f = (TextView) r5;
        View r6 = r3.findViewById(2131363395);
        if (r6 == null) goto L21;
        this.g = r6;
        View r7 = r3.findViewById(2131363389);
        if (r7 == null) goto L19;
        this.h = r7;
        return;
    L19:
        throw new IllegalStateException("Required view not found, id=2131363389, type=".concat(View.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131363395, type=".concat(View.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131363391, type=".concat(TextView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131363398, type=".concat(TextView.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131363390, type=".concat(View.class.getSimpleName()));
    L29:
        throw new IllegalStateException("Required view not found, id=2131363396, type=".concat(View.class.getSimpleName()));
    L31:
        throw new IllegalStateException("Required view not found, id=2131388775, type=MmTitleBarView");
    }
}
