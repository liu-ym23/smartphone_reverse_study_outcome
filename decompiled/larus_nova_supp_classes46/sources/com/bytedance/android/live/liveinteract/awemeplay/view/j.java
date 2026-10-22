package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends me.drakeet.multitype.b<sd0.a, LiveVideoCommentSelectPanelVideoViewHolder> {
    public static final float d = 0.0f;
    public static final int e = 0;
    public static final float f = 0.0f;
    public final boolean b;
    public final l c;

    public static final class a {
    }

    static {
        d = UtilityKotlinExtentionsKt.h(1);
        e = 3;
        f = 1.3333334f;
    }

    public j(boolean r1, l r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void b(RecyclerView.ViewHolder r13, Object r14) {
        LiveVideoCommentSelectPanelVideoViewHolder r15 = (LiveVideoCommentSelectPanelVideoViewHolder) r13;
        sd0.a r16 = (sd0.a) r14;
        Intrinsics.checkNotNullParameter(r15, "holder");
        Intrinsics.checkNotNullParameter(r16, "item");
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "awemeVideo");
        l r0 = r15.f;
        if (r0 == null) goto L5;
        sd0.a r1 = r0.J9();
    L7:
        if (r15.e == false) goto L14;
        ImageView r2 = r15.b;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        View r3 = r15.d;
        if (r3 == null) goto L29;
        r3.setVisibility(8);
    L29:
        HSImageView r4 = r15.a;
        if (r4 == null) goto L34;
        GenericDraweeHierarchy r5 = r4.getHierarchy();
        if (r5 == null) goto L34;
        r5.setPlaceholderImage(2131108477);
    L34:
        ImageLoader.bindImage(r15.a, r16.a());
        TextView r6 = r15.c;
        if (r6 == null) goto L61;
        Long r7 = r16.d();
        if (r7 == null) goto L56;
        long r8 = r7.longValue();
        long r9 = 10000;
        if (r8 >= r9) goto L41;
        StringBuilder r10 = new StringBuilder();
        r10.append(r8);
        r10.append(' ');
        String r11 = r10.toString();
    L57:
        if (r11 == null) goto L60;
        r6.setText(StringsKt.trim(r11).toString());
        goto L61
    L60:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L41:
        long r12 = 99999999;
        if (r9 <= r8) goto L45;
    L50:
        long r17 = 100000000;
        if (r8 < r17) goto L56;
        if ((r8 / r17) < 1000) goto L55;
        r11 = ((int) Math.ceil(r8 / ((double) 100000000))) + " 亿";
        goto L57
    L55:
        DecimalFormat r18 = new DecimalFormat();
        r18.setMaximumFractionDigits(1);
        r11 = r18.format(r8 / ((double) 100000000)) + " 亿";
        goto L57
    L45:
        if (r12 < r8) goto L50;
        if ((r8 / r9) < 1000) goto L49;
        r11 = ((int) Math.ceil(r8 / ((double) 10000))) + " 万";
        goto L57
    L49:
        DecimalFormat r19 = new DecimalFormat();
        r19.setMaximumFractionDigits(1);
        r11 = r19.format(r8 / ((double) 10000)) + " 万";
    L56:
        r11 = "";
    L61:
        ((RecyclerView.ViewHolder) r15).itemView.setOnClickListener(new k(r15, r1, r16));
        return;
    L14:
        if (r1 != null) goto L16;
    L23:
        View r20 = r15.d;
        if (r20 == null) goto L26;
        r20.setVisibility(8);
    L26:
        ImageView r21 = r15.b;
        if (r21 == null) goto L29;
        r21.setBackgroundResource(2131253238);
        goto L29
    L16:
        if (Intrinsics.areEqual(r1.b(), r16.b()) == false) goto L23;
        View r22 = r15.d;
        if (r22 == null) goto L20;
        r22.setVisibility(0);
    L20:
        ImageView r23 = r15.b;
        if (r23 == null) goto L29;
        r23.setBackgroundResource(2131253237);
        goto L29
    L5:
        r1 = null;
        goto L7
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        View r6 = r4.inflate(2131567580, r5, false);
        float r7 = s1.y();
        int r0 = e;
        int r8 = (int) ((r7 - ((r0 - 1) * d)) / r0);
        int r1 = (int) (r8 * f);
        r6.getLayoutParams().width = r8;
        r6.getLayoutParams().height = r1;
        View r2 = r6.findViewById(2131375721);
        if (r2 == null) goto L7;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L7;
        r3.width = r8;
    L7:
        if (r2 == null) goto L12;
        ViewGroup.LayoutParams r9 = r2.getLayoutParams();
        if (r9 == null) goto L12;
        r9.height = r1;
    L12:
        return new LiveVideoCommentSelectPanelVideoViewHolder(r6, this.b, this.c);
    }
}
