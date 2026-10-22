package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.utils.HostEnv;
import com.bytedance.android.livesdk.utils.x0;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends me.drakeet.multitype.b<a, PkNormalApplyTitleViewHolder> {
    public final com.bytedance.android.live.livepkaudience.presenter.b b;
    public final LinkedList<?> c;

    public static final class a {
        public final int a;

        public a() {
            this.a = 2;
        }
    }

    public l(com.bytedance.android.live.livepkaudience.presenter.b r1, LinkedList<?> r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        final PkNormalApplyTitleViewHolder r6 = (PkNormalApplyTitleViewHolder) r4;
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        if (r7.a != 2) goto L30;
        ((RecyclerView.ViewHolder) r6).itemView.setBackgroundColor(s1.h(2131107196));
        boolean r8 = r6.e;
        if (r8 == false) goto L22;
        if (r8 == true) goto L8;
    L14:
        ((TextView) r6.a.getValue()).setText(2131896066);
        TextView r9 = (TextView) r6.c.getValue();
        Integer r10 = (Integer) com.bytedance.android.livesdk.sharedpref.c.x1.getValue();
        if (r10 != null) goto L18;
    L20:
        int r11 = 2131912776;
    L21:
        r9.setText(r11);
        return;
    L18:
        if (r10.intValue() != 41) goto L20;
        r11 = 2131912772;
        goto L21
    L8:
        if (HostEnv.c() == false) goto L10;
    L13:
        ((ImageView) r6.d.getValue()).setVisibility(8);
        a1.n((TextView) r6.c.getValue(), s1.f(0.0f));
        goto L14
    L10:
        if (HostEnv.a() == true) goto L13;
        ((FrameLayout) r6.b.getValue()).setOnClickListener(x0.a(new PkNormalApplyTitleViewHolder$initSortView$1(r6)));
        goto L14
    L22:
        ((ImageView) r6.d.getValue()).setVisibility(8);
        a1.n((TextView) r6.c.getValue(), s1.f(0.0f));
        ((TextView) r6.a.getValue()).setText(2131894405);
        TextView r12 = (TextView) r6.c.getValue();
        Integer r13 = (Integer) com.bytedance.android.livesdk.sharedpref.c.x1.getValue();
        if (r13 != null) goto L26;
    L28:
        int r14 = 2131923706;
    L29:
        r12.setText(r14);
        return;
    L26:
        if (r13.intValue() != 41) goto L28;
        r14 = 2131897296;
        goto L29
    L30:
        r6.getClass();
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new PkNormalApplyTitleViewHolder(r3.inflate(2131566357, r4, false), this.b, this.c);
    }
}
