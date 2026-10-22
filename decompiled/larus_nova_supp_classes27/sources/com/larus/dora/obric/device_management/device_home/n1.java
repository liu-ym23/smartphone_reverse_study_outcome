package com.larus.dora.obric.device_management.device_home;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraItemObricDeviceHomeQuickActionBinding;
import com.larus.dora.impl.resource.DoraDrawableDensity;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.obric.oui.image.OImage;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n1 extends com.obric.oui.orecyclerview.widget.w<m1, b> {
    public final Function1<DoraObricDeviceHomeQuickActionType, Unit> d;

    public static final class a extends com.obric.oui.orecyclerview.widget.q.e<m1> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean a(Object r2, Object r3) {
            m1 r4 = (m1) r2;
            m1 r5 = (m1) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean b(Object r2, Object r3) {
            m1 r4 = (m1) r2;
            m1 r5 = (m1) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            if (r4.getType() != r5.getType()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public final class b extends RecyclerView.y {
        public final LarusDoraItemObricDeviceHomeQuickActionBinding u;
        public final /* synthetic */ n1 v;

        public b(n1 r2, LarusDoraItemObricDeviceHomeQuickActionBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.v = r2;
            super(r3.a);
            this.u = r3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n1(Function1<? super DoraObricDeviceHomeQuickActionType, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onActionClick");
        super(a.a);
        this.d = r2;
    }

    public final void c(RecyclerView.y r8, int r9) {
        b r10 = (b) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        final m1 r11 = (m1) ListProtector.get(((com.obric.oui.orecyclerview.widget.w) this).c.f, r9);
        Intrinsics.checkNotNullParameter(r11, "item");
        DoraResourceDeviceType r3 = r11.e;
        if (r3 == null) goto L7;
        String r4 = r11.d;
        if (r4 == null) goto L7;
        Drawable r1 = com.larus.dora.impl.resource.j0.f(com.larus.dora.impl.resource.j0.a, r10.u.a.getContext(), r3, r4, DoraDrawableDensity.MDPI, 8);
    L8:
        if (r1 == null) goto L10;
        r10.u.b.setImageDrawable(r1);
    L14:
        r10.u.c.setText(r11.b);
        r10.u.a.setContentDescription(r11.b);
        OUICardConstraintLayout r0 = r10.u.a;
        final n1 r12 = r10.v;
        r0.setOnClickListener(new o1(r12, r11));
        return;
    L10:
        int r2 = r11.c;
        if (r2 == 0) goto L13;
        r10.u.b.setImageResource(r2);
        goto L14
    L13:
        r10.u.b.setImageDrawable(null);
    L7:
        r1 = null;
        goto L8
    }

    public final RecyclerView.y d(RecyclerView r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        OUICardConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131562220, r3, false);
        int r6 = 2131369816;
        OImage r0 = ViewBindings.findChildViewById(r5, 2131369816);
        if (r0 == null) goto L9;
        r6 = 2131369817;
        OTextView r1 = ViewBindings.findChildViewById(r5, 2131369817);
        if (r1 == null) goto L9;
        return new b(this, new LarusDoraItemObricDeviceHomeQuickActionBinding(r5, r0, r1));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
