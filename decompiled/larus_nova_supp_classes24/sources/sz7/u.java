package sz7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.imageview.LKUIBadgeDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u<T extends ImageView> extends z {
    public final T a;

    public u(T r2) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        this.a = r2;
    }

    public final void a(a r11) {
        Intrinsics.checkNotNullParameter(r11, "iconViewData");
        Drawable r0 = r11.a;
        if (r0 == null) goto L5;
        this.a.setImageDrawable(r0);
        return;
    L5:
        String r1 = r11.b;
        boolean r2 = true;
        if (r1 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L22;
        int r4 = t.a;
        s r5 = t.a.a(this.a.getContext());
        int r6 = r11.f;
        int r7 = r11.g;
        r5.c = r6;
        r5.d = r7;
        r5.e = r11.b;
        r5.f = r11.c;
        r5.g = r11.d;
        r5.h = r11.e;
        T r9 = this.a;
        Intrinsics.checkNotNullParameter(r9, "target");
        String r8 = r5.e;
        if (r8 != null) goto L16;
    L19:
        if (r2 == false) goto L21;
        r9.setImageDrawable(r5.h);
        return;
    L21:
        r5.b.a(r5.a, r8, r5.g, r5.c, r5.d, r9);
        return;
    L16:
        if (r8.length() == 0) goto L19;
        r2 = false;
        goto L19
    L22:
        this.a.setImageDrawable(r11.e);
        return;
    L8:
        if (r1.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    public final void b(x r12) {
        Intrinsics.checkNotNullParameter(r12, "miniIconViewData");
        int r0 = LKUIBadgeDrawable2.i;
        T r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "view");
        LKUIBadgeDrawable2.b r2 = LKUIBadgeDrawable2.a.a(r1, 0).c();
        Drawable r3 = r12.a;
        if (r3 == null) goto L13;
        Context r4 = this.a.getContext();
        int r5 = (int) j08.b.a(r4, 1.5f);
        GradientDrawable r6 = new GradientDrawable();
        r6.setShape(1);
        if (r12.b <= 0) goto L10;
        int r7 = Math.max(r3.getIntrinsicWidth(), r3.getIntrinsicHeight());
        int r9 = r5 * 2;
        int r8 = r7 + r9;
        int r10 = r12.b;
        if (r8 <= r10) goto L10;
        int r11 = r10 - r9;
        r3.setBounds(0, 0, r11, r11);
        int r13 = r12.b;
        r6.setSize(r13, r13);
    L11:
        r6.setColor(ContextCompat.getColor(r4, 2131103455));
        r2.g = r3;
        r2.j = 2;
        r2.i = r6;
        r2.l.setVisible(true, false);
        if (r2.a() == null) goto L13;
        return;
    L10:
        int r14 = r5 * 2;
        r6.setSize(r3.getIntrinsicWidth() + r14, r3.getIntrinsicWidth() + r14);
    L13:
        r2.l.setVisible(false, false);
        r2.a();
    }
}
