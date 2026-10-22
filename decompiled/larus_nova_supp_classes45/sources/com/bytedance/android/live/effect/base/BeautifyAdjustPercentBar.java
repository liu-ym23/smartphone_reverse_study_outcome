package com.bytedance.android.live.effect.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR#\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0017\u001a\n \r*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001f\u001a\n \r*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u001b¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/effect/base/BeautifyAdjustPercentBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "percent", "", "setPercent", "", "enable", "setEnableSingeAdjust", "Lcom/bytedance/android/live/effect/base/AdjustPercentBar$d;", "onLevelChangeListener", "setOnLevelChangeListener", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getBeautifyTitleTextView", "()Landroid/widget/TextView;", "beautifyTitleTextView", "Lcom/bytedance/android/live/effect/base/AdjustPercentBar;", "b", "getAdjustPercentBar", "()Lcom/bytedance/android/live/effect/base/AdjustPercentBar;", "adjustPercentBar", "Landroid/widget/ImageView;", "c", "getMinusIcon", "()Landroid/widget/ImageView;", "minusIcon", "d", "getPlusIcon", "plusIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautifyAdjustPercentBar extends ConstraintLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final int e;
    public final int f;
    public AdjustPercentBar.d g;
    public final a h;

    public static final class a implements AdjustPercentBar.d {
        public final /* synthetic */ BeautifyAdjustPercentBar a;

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void a(int r1) {
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void b() {
        }

        public a(BeautifyAdjustPercentBar r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void onChanged(int r5) {
            ImageView r0 = BeautifyAdjustPercentBar.S5(this.a);
            boolean r1 = true;
            if (r0 == null) goto L12;
            AdjustPercentBar r3 = BeautifyAdjustPercentBar.R5(this.a);
            if (r3 == null) goto L7;
            int r4 = r3.getMinPercent();
        L8:
            if (r5 <= r4) goto L10;
            boolean r6 = true;
        L11:
            r0.setEnabled(r6);
            goto L12
        L10:
            r6 = false;
            goto L11
        L7:
            r4 = 0;
        L12:
            ImageView r2 = BeautifyAdjustPercentBar.T5(this.a);
            if (r2 == null) goto L23;
            AdjustPercentBar r7 = BeautifyAdjustPercentBar.R5(this.a);
            if (r7 == null) goto L17;
            int r8 = r7.getMaxPercent();
        L18:
            if (r5 < r8) goto L21;
            r1 = false;
        L21:
            r2.setEnabled(r1);
            return;
        L17:
            r8 = 0;
            goto L18
        }
    }

    public static final class b implements AdjustPercentBar.d {
        public final /* synthetic */ BeautifyAdjustPercentBar a;

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void b() {
            AdjustPercentBar.d r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.b();
        L5:
            this.a.h.getClass();
        }

        public b(BeautifyAdjustPercentBar r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void a(int r2) {
            AdjustPercentBar.d r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.a(r2);
        L5:
            this.a.h.getClass();
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void onChanged(int r2) {
            AdjustPercentBar.d r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.onChanged(r2);
        L5:
            this.a.h.onChanged(r2);
        }
    }

    public BeautifyAdjustPercentBar(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BeautifyAdjustPercentBar(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final AdjustPercentBar getAdjustPercentBar() {
        return (AdjustPercentBar) this.b.getValue();
    }

    private final TextView getBeautifyTitleTextView() {
        return (TextView) this.a.getValue();
    }

    private final ImageView getMinusIcon() {
        return (ImageView) this.c.getValue();
    }

    private final ImageView getPlusIcon() {
        return (ImageView) this.d.getValue();
    }

    public final void Z5() {
        AdjustPercentBar r0 = getAdjustPercentBar();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.getPercent();
    L6:
        ImageView r3 = getMinusIcon();
        if (r3 == null) goto L16;
        AdjustPercentBar r4 = getAdjustPercentBar();
        if (r4 == null) goto L11;
        int r5 = r4.getMinPercent();
    L12:
        if (r2 <= r5) goto L14;
        boolean r6 = true;
    L15:
        r3.setEnabled(r6);
        goto L16
    L14:
        r6 = false;
        goto L15
    L11:
        r5 = 0;
    L16:
        ImageView r7 = getPlusIcon();
        if (r7 == null) goto L26;
        AdjustPercentBar r8 = getAdjustPercentBar();
        if (r8 == null) goto L21;
        int r9 = r8.getMaxPercent();
    L22:
        if (r2 >= r9) goto L24;
        r1 = true;
    L24:
        r7.setEnabled(r1);
        return;
    L21:
        r9 = 0;
        goto L22
    L26:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public static final /* synthetic */ AdjustPercentBar R5(BeautifyAdjustPercentBar r0) {
        return r0.getAdjustPercentBar();
    }

    public static final /* synthetic */ ImageView S5(BeautifyAdjustPercentBar r0) {
        return r0.getMinusIcon();
    }

    public static final /* synthetic */ ImageView T5(BeautifyAdjustPercentBar r0) {
        return r0.getPlusIcon();
    }

    public final void setEnableSingeAdjust(boolean r2) {
        if (r2 == false) goto L9;
        ImageView r3 = getMinusIcon();
        if (r3 == null) goto L6;
        r3.setVisibility(0);
    L6:
        ImageView r4 = getPlusIcon();
        if (r4 == null) goto L16;
        r4.setVisibility(0);
        return;
    L16:
        return;
    L9:
        ImageView r5 = getMinusIcon();
        if (r5 == null) goto L12;
        r5.setVisibility(8);
    L12:
        ImageView r6 = getPlusIcon();
        if (r6 == null) goto L18;
        r6.setVisibility(8);
        return;
    }

    public final void setOnLevelChangeListener(AdjustPercentBar.d r2) {
        Intrinsics.checkNotNullParameter(r2, "onLevelChangeListener");
        this.g = r2;
    }

    public final void setPercent(int r2) {
        AdjustPercentBar r0 = getAdjustPercentBar();
        if (r0 == null) goto L5;
        r0.setPercent(r2);
    L5:
        Z5();
    }

    public final void V5(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "title");
        if (r2 == false) goto L13;
        TextView r4 = getBeautifyTitleTextView();
        if (r4 == null) goto L7;
        r4.setVisibility(0);
    L7:
        ImageView r5 = getMinusIcon();
        if (r5 == null) goto L10;
        a1.m(r5, this.e);
    L10:
        TextView r6 = getBeautifyTitleTextView();
        if (r6 == null) goto L20;
        r6.setText(r3);
        return;
    L20:
        return;
    L13:
        TextView r7 = getBeautifyTitleTextView();
        if (r7 == null) goto L16;
        r7.setVisibility(8);
    L16:
        ImageView r8 = getMinusIcon();
        if (r8 == null) goto L22;
        a1.m(r8, this.f);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeautifyAdjustPercentBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new BeautifyAdjustPercentBar$beautifyTitleTextView$2(this));
        this.b = LazyKt.lazy(new BeautifyAdjustPercentBar$adjustPercentBar$2(this));
        this.c = LazyKt.lazy(new BeautifyAdjustPercentBar$minusIcon$2(this));
        this.d = LazyKt.lazy(new BeautifyAdjustPercentBar$plusIcon$2(this));
        this.e = s1.f(7.0f);
        this.f = s1.f(14.0f);
        this.h = new a(this);
        b r5 = new b(this);
        ViewGroup.inflate(r2, 2131565841, this);
        ImageView r6 = getMinusIcon();
        if (r6 == null) goto L5;
        r6.setOnClickListener(new c(this));
    L5:
        ImageView r7 = getPlusIcon();
        if (r7 == null) goto L8;
        r7.setOnClickListener(new d(this));
    L8:
        Z5();
        AdjustPercentBar r8 = getAdjustPercentBar();
        if (r8 == null) goto L11;
        r8.setOnLevelChangeListener(r5);
    L11:
        AdjustPercentBar r9 = getAdjustPercentBar();
        if (r9 == null) goto L15;
        r9.setDefaultCircleConfig(2131109391);
        return;
    }

    public final void U5(int r2, int r3, int r4) {
        AdjustPercentBar r0 = getAdjustPercentBar();
        if (r0 == null) goto L5;
        r0.c(r2, r3, r4);
    L5:
        AdjustPercentBar r5 = getAdjustPercentBar();
        if (r5 == null) goto L9;
        r5.setDefaultCircleConfig(2131109391);
        return;
    }

    public /* synthetic */ BeautifyAdjustPercentBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void Y5(int r2, int r3, int r4, boolean r5) {
        AdjustPercentBar r0 = getAdjustPercentBar();
        if (r0 == null) goto L5;
        r0.e(r2, r3, r4, r5);
    L5:
        Z5();
    }
}
