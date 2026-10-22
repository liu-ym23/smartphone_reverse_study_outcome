package vz7;

import android.view.View;
import com.larksuite.component.ui.imageview.LKUIBadgeDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements b08.b<View, b> {
    public a() {
    }

    @Override // b08.b
    public final void unbind(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        int r1 = LKUIBadgeDrawable2.i;
        Intrinsics.checkNotNullParameter(r3, "view");
        LKUIBadgeDrawable2.a.a(r3, 0).setVisible(false, false);
    }

    @Override // b08.b
    public final void bind(View r3, b r4) {
        b r5 = r4;
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r5, "model");
        int r1 = LKUIBadgeDrawable2.i;
        Intrinsics.checkNotNullParameter(r3, "view");
        LKUIBadgeDrawable2.b r6 = LKUIBadgeDrawable2.a.a(r3, 0).c();
        r6.j = r5.g;
        r6.i = r5.f;
        r6.k = r5.h;
        r6.g = null;
        r6.h = 0.0f;
        r6.b = r5.a;
        r6.f = r5.e;
        r6.c = r5.b;
        r6.e = r5.d;
        r6.d = r5.c;
        boolean r7 = r5.i;
        r6.l.setVisible(r7, false);
        r6.a();
    }
}
