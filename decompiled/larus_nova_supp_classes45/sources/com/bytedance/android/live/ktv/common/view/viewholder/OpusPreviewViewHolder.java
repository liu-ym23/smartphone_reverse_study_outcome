package com.bytedance.android.live.ktv.common.view.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.i;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/viewholder/OpusPreviewViewHolder;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/IMvPreviewViewHolder;", "Lcom/bytedance/android/livesdk/message/model/od;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpusPreviewViewHolder extends IMvPreviewViewHolder<od> {
    public final TextView c;
    public HSImageView d;
    public final int e;
    public FrameLayout f;
    public od g;
    public View h;
    public final Function3<Integer, od, OpusPreviewViewHolder, Unit> i;

    public final View V3() {
        View r0 = new View(((RecyclerView.ViewHolder) this).itemView.getContext());
        this.h = r0;
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.setBackgroundResource(2131247402);
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r1 instanceof ViewGroup) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L8;
        r2.addView(r0);
    L8:
        return r0;
    }

    public final void W3() {
        FrameLayout r0 = this.f;
        if (r0 == null) goto L10;
        ViewParent r2 = r0.getParent();
        if ((r2 instanceof ViewGroup) == true) goto L7;
        r2 = null;
    L7:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L10;
        r3.removeView(r0);
    L10:
        this.f = null;
    }

    public final void U3(HSImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void X3(boolean r11) {
        FrameLayout r0 = this.f;
        FrameLayout r1 = r0;
        if (r0 != null) goto L15;
        FrameLayout r2 = new FrameLayout(((RecyclerView.ViewHolder) this).itemView.getContext());
        this.f = r2;
        View r3 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r3 instanceof ViewGroup) == true) goto L7;
        r3 = null;
    L7:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 == null) goto L10;
        ViewGroup.MarginLayoutParams r5 = new ViewGroup.MarginLayoutParams(-1, -1);
        int r6 = this.e;
        r5.topMargin = r6;
        r5.leftMargin = r6;
        r5.bottomMargin = r6;
        r5.rightMargin = r6;
        Unit r7 = Unit.INSTANCE;
        r4.addView(r2, r5);
    L10:
        r2.setBackgroundColor(ColorProtector.parseColor("#a1000000"));
        LinearLayout r8 = new LinearLayout(((RecyclerView.ViewHolder) this).itemView.getContext());
        r8.setOrientation(1);
        View r9 = new View(((RecyclerView.ViewHolder) this).itemView.getContext());
        r9.setBackgroundResource(2131252119);
        Unit r12 = Unit.INSTANCE;
        int r13 = s1.f(32.0f);
        int r14 = s1.f(32.0f);
        r8.setGravity(17);
        r8.addView(r9, new ViewGroup.LayoutParams(r13, r14));
        TextView r15 = new TextView(((RecyclerView.ViewHolder) this).itemView.getContext());
        r15.setTextSize(1, 15.0f);
        r15.setTextColor(-1);
        if (r11 == false) goto L13;
        int r16 = 2131918502;
    L14:
        r15.setText(r16);
        ViewGroup.LayoutParams r17 = new ViewGroup.LayoutParams(-2, -2);
        r8.setGravity(17);
        r8.addView(r15, r17);
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-2, -2);
        r18.gravity = 17;
        r2.addView(r8, r18);
        r1 = r2;
        goto L15
    L13:
        r16 = 2131918500;
    L15:
        r1.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OpusPreviewViewHolder(View r2, Function3<? super Integer, ? super od, ? super OpusPreviewViewHolder, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "onBindListener");
        super(r2);
        this.i = r3;
        this.e = s1.f(2.0f);
        this.c = (TextView) r2.findViewById(2131391586);
    }

    public final void T3(final int r6, Object r7) {
        final od r8 = (od) r7;
        Intrinsics.checkNotNullParameter(r8, "info");
        this.g = r8;
        TextView r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mThumbupCount");
    L6:
        if (r8.g() == false) goto L8;
        int r2 = 8;
    L9:
        r0.setVisibility(r2);
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new OpusPreviewViewHolder$onBind$1(this, r6, r8));
        i r1 = ((IMvPreviewViewHolder) this).a;
        if (r1 != null) goto L12;
    L17:
        View r3 = this.h;
        if (r3 == null) goto L20;
        r3.setVisibility(8);
    L20:
        this.i.invoke(Integer.valueOf(r6), r8, this);
        String r9 = r8.c();
        if (r9 == null) goto L26;
        HSImageView r4 = this.d;
        if (r4 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverBg");
    L25:
        r4.setImageURI(r9);
    L26:
        Integer r11 = r8.b();
        if (r11 == null) goto L33;
        int r12 = r11.intValue();
        TextView r13 = this.c;
        if (r13 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mThumbupCount");
    L31:
        r13.setText(String.valueOf(r12));
        return;
    L33:
        return;
    L12:
        if (r1.G70(r6, r8) != true) goto L17;
        View r5 = this.h;
        if (r5 != null) goto L16;
        r5 = V3();
    L16:
        r5.setVisibility(0);
        goto L20
    L8:
        r2 = 0;
        goto L9
    }
}
