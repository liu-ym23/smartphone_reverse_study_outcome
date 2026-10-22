package wz7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.avatar.AvatarType;
import com.larksuite.component.ui.imageview.LKUIBadgeDrawable2;
import kotlin.jvm.internal.Intrinsics;
import sz7.q;
import sz7.v;
import wz7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class c<T extends d> implements b08.b<View, T> {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AvatarType.values().length];
            r0[AvatarType.THRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AvatarType.TOPIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AvatarType.MICROAPP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public c() {
    }

    @Override // b08.b
    public final void unbind(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        int r0 = LKUIBadgeDrawable2.i;
        LKUIBadgeDrawable2.a.a(r2, 1).setVisible(false, false);
    }

    public Drawable a(Context r13, T r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        if (r14 == null) goto L26;
        AvatarType r0 = r14.a;
        boolean r1 = v.a;
        int r2 = -1;
        if (v.a.a() == false) goto L19;
        if (r0 != null) goto L9;
        int r3 = -1;
    L10:
        if (r3 != 1) goto L12;
        r2 = 2131237826;
        goto L19
    L12:
        if (r3 != 2) goto L14;
        r2 = 2131237827;
        goto L19
    L14:
        if (r3 != 3) goto L19;
        r2 = 2131237823;
        goto L19
    L9:
        r3 = a.a[r0.ordinal()];
    L19:
        if (r2 <= 0) goto L22;
        return AppCompatResources.getDrawable(r13, r2);
    L22:
        if (TextUtils.isEmpty(r14.c) == true) goto L24;
    L25:
        int r8 = r14.d.getPxValue(r13);
        q r4 = new q(r13, false);
        r4.h = true;
        q.d(r4, r14.c, null, r8, r8, r14.b, false, null);
        return r4;
    L24:
        if (r14.b != null) goto L25;
    L26:
        return null;
    }

    @Override // b08.b
    public final void bind(View r10, Object r11) {
        d r12 = (d) r11;
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r12, "model");
        Context r0 = r10.getContext();
        Intrinsics.checkNotNull(r0);
        Drawable r1 = a(r0, r12);
        if (r1 == null) goto L12;
        int r13 = r12.d.getPxValue(r0);
        int r5 = (int) j08.b.a(r0, 1.5f);
        GradientDrawable r6 = new GradientDrawable();
        r6.setShape(1);
        if (r13 <= 0) goto L10;
        int r7 = Math.max(r1.getIntrinsicWidth(), r1.getIntrinsicHeight());
        int r8 = r5 * 2;
        if ((r7 + r8) <= r13) goto L10;
        int r9 = r13 - r8;
        r1.setBounds(0, 0, r9, r9);
        r6.setSize(r13, r13);
    L11:
        r6.setColor(ContextCompat.getColor(r0, 2131103455));
    L13:
        if (r1 == null) goto L16;
        if (r6 == null) goto L16;
        int r14 = LKUIBadgeDrawable2.i;
        LKUIBadgeDrawable2.b r15 = LKUIBadgeDrawable2.a.a(r10, 1).c();
        r15.j = 2;
        r15.i = r6;
        r15.g = r1;
        r15.l.setVisible(true, false);
        r15.a();
        return;
    L16:
        int r16 = LKUIBadgeDrawable2.i;
        LKUIBadgeDrawable2.b r17 = LKUIBadgeDrawable2.a.a(r10, 1).c();
        r17.l.setVisible(false, false);
        r17.a();
        return;
    L10:
        int r19 = r5 * 2;
        r6.setSize(r1.getIntrinsicWidth() + r19, r1.getIntrinsicWidth() + r19);
        goto L11
    L12:
        r6 = null;
        goto L13
    }
}
