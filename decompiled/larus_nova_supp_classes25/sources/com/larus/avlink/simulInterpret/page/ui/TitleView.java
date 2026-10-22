package com.larus.avlink.simulInterpret.page.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LayoutTitleViewBinding;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010 \u001a\u00020\u0012J\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0012J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0016\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020\u000fJ\u0010\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u000fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/TitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutTitleViewBinding;", "thumbAnimator", "Landroid/animation/ValueAnimator;", "isCurrentThumbRight", "", "onBackButtonClick", "Lkotlin/Function0;", "", "getOnBackButtonClick", "()Lkotlin/jvm/functions/Function0;", "setOnBackButtonClick", "(Lkotlin/jvm/functions/Function0;)V", "onSettingIconClick", "getOnSettingIconClick", "setOnSettingIconClick", "onSwitchButtonClick", "Lkotlin/Function1;", "getOnSwitchButtonClick", "()Lkotlin/jvm/functions/Function1;", "setOnSwitchButtonClick", "(Lkotlin/jvm/functions/Function1;)V", "updateForOnBoarding", "updateForListening", "updateForTranslating", "updateSwitchButtonTextColor", "isThumbRight", "applyThumbPositionWhenLaidOut", "setTitleBar", "deviceType", "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "animateThumbTo", "toRight", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TitleView extends ConstraintLayout {
    public static final /* synthetic */ int g = 0;
    public final LayoutTitleViewBinding a;
    public ValueAnimator b;
    public boolean c;
    public Function0<Unit> d;
    public Function0<Unit> e;
    public Function1<? super Boolean, Unit> f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraDeviceType.values().length];
            r0[DoraDeviceType.DEVICE_G.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public TitleView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TitleView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final Function0<Unit> getOnBackButtonClick() {
        return this.d;
    }

    public final Function0<Unit> getOnSettingIconClick() {
        return this.e;
    }

    public final Function1<Boolean, Unit> getOnSwitchButtonClick() {
        return this.f;
    }

    public final void R5(final boolean r9) {
        ValueAnimator r0 = this.b;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        if (r9 == false) goto L7;
        TextView r1 = this.a.d;
    L8:
        Intrinsics.checkNotNull(r1);
        if (r1.getWidth() != 0) goto L11;
    L15:
        this.a.b.post(new v(this, r9));
        return;
    L11:
        if (this.a.b.getWidth() == 0) goto L15;
        S5(r9);
        final int r5 = r1.getWidth();
        final int r7 = r1.getLeft();
        final int r4 = this.a.e.getWidth();
        final int r6 = this.a.e.getLeft();
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.setDuration(300);
        r10.setInterpolator(new AccelerateDecelerateInterpolator());
        r10.addUpdateListener(new w(this, r4, r5, r6, r7));
        r10.start();
        this.b = r10;
        return;
    L7:
        r1 = this.a.c;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(boolean r6) {
        int r0 = ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136));
        int r1 = ContextCompat.getColor(getContext(), v19.c.b(2130972081, getContext(), 2131103143));
        if (r6 == false) goto L5;
        this.a.c.setTextColor(r1);
        this.a.d.setTextColor(r0);
        return;
    L5:
        this.a.c.setTextColor(r0);
        this.a.d.setTextColor(r1);
    }

    public final void setOnBackButtonClick(Function0<Unit> r1) {
        this.d = r1;
    }

    public final void setOnSettingIconClick(Function0<Unit> r1) {
        this.e = r1;
    }

    public final void setOnSwitchButtonClick(Function1<? super Boolean, Unit> r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TitleView(Context r19, AttributeSet r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super(r19, r20, r21);
        ConstraintLayout r1 = LayoutInflater.from(r19).inflate(2131563416, this, false);
        addView(r1);
        int r2 = 2131363772;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r1, 2131363772);
        if (r3 == null) goto L23;
        r2 = 2131384623;
        ImageView r15 = (ImageView) ViewBindings.findChildViewById(r1, 2131384623);
        if (r15 == null) goto L23;
        r2 = 2131387881;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r1, 2131387881);
        if (r8 == null) goto L23;
        r2 = 2131387883;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r1, 2131387883);
        if (r14 == null) goto L23;
        r2 = 2131387885;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r1, 2131387885);
        if (r13 == null) goto L23;
        r2 = 2131387886;
        View r11 = ViewBindings.findChildViewById(r1, 2131387886);
        if (r11 == null) goto L23;
        r2 = 2131389083;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r1, 2131389083);
        if (r12 == null) goto L23;
        r2 = 2131389084;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r1, 2131389084);
        if (r16 == null) goto L23;
        r2 = 2131389085;
        ConstraintLayout r17 = ViewBindings.findChildViewById(r1, 2131389085);
        if (r17 == null) goto L23;
        this.a = new LayoutTitleViewBinding(r1, r3, r15, r8, r14, r13, r11, r12, r16, r17);
        r3.setOnClickListener(new r(this));
        r15.setOnClickListener(new s(this));
        r14.setOnClickListener(new t(this));
        r13.setOnClickListener(new u(this));
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public /* synthetic */ TitleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
