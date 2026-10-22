package com.larus.canvas.feature.component.title.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.canvas.impl.databinding.LarusCanvasTitleBinding;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ly8.a;
import ly8.b;
import ly8.c;
import ly8.d;
import ly8.e;
import ly8.f;
import v19.c7;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0015\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0019J'\u0010\u001b\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001eJ\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001eJ\u0018\u0010#\u001a\u00020\u00102\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0018\u0010%\u001a\u00020\u00102\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0018\u0010&\u001a\u00020\u00102\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0018\u0010'\u001a\u00020\u00102\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/canvas/feature/component/title/widget/CanvasTitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/canvas/impl/databinding/LarusCanvasTitleBinding;", "getBinding", "()Lcom/larus/canvas/impl/databinding/LarusCanvasTitleBinding;", "onClickLeftIcon", "Lkotlin/Function0;", "", "onClickRightIcon", "onClickCenterText", "onLongClickCenterText", "setCenterText", ShareType.TEXT, "", "setCenterImgResource", "resId", "(Ljava/lang/Integer;)V", "setLeftIcon", "setRightButton", "textColor", "showLoading", "", "(Ljava/lang/String;Ljava/lang/Integer;Z)V", "setRightVisibility", "visible", "setCenterVisibility", "setOnClickLeftIcon", "block", "setOnClickRightIcon", "setOnClickCenterText", "setOnLongClickCenterText", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasTitleView extends ConstraintLayout {
    public static final /* synthetic */ int f = 0;
    public final LarusCanvasTitleBinding a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public Function0<Unit> d;
    public Function0<Unit> e;

    public CanvasTitleView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CanvasTitleView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final LarusCanvasTitleBinding getBinding() {
        return this.a;
    }

    public final void setCenterImgResource(Integer r3) {
        if (r3 != null) goto L4;
        this.a.b.setVisibility(8);
        return;
    L4:
        this.a.b.setVisibility(0);
        this.a.b.setImageResource(r3.intValue());
    }

    public final void setCenterText(String r2) {
        this.a.c.setText(r2);
    }

    public final void setCenterVisibility(boolean r5) {
        TextView r0 = this.a.c;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        ImageView r2 = this.a.b;
        if (r5 == true) goto L10;
        r1 = 8;
    L10:
        r2.setVisibility(r1);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setLeftIcon(Integer r7) {
        if (r7 != null) goto L4;
        this.a.d.setVisibility(8);
        return;
    L4:
        boolean r1 = false;
        this.a.d.setVisibility(0);
        AppCompatImageView r0 = this.a.d;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L24;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r7.intValue() != 2131240992) goto L10;
        r1 = true;
    L10:
        if (r1 == false) goto L12;
        int r5 = 36;
    L13:
        r3.width = c7.b(r5);
        if (r1 == false) goto L16;
        int r4 = 36;
    L17:
        r3.height = c7.b(r4);
        if (r1 == false) goto L20;
        int r6 = 12;
    L21:
        r3.setMarginStart(c7.b(Integer.valueOf(r6)));
        r0.setLayoutParams(r3);
        this.a.d.setImageResource(r7.intValue());
        return;
    L20:
        r6 = 16;
        goto L21
    L16:
        r4 = 44;
        goto L17
    L12:
        r5 = 44;
        goto L13
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setOnClickCenterText(Function0<Unit> r1) {
        this.d = r1;
    }

    public final void setOnClickLeftIcon(Function0<Unit> r1) {
        this.b = r1;
    }

    public final void setOnClickRightIcon(Function0<Unit> r1) {
        this.c = r1;
    }

    public final void setOnLongClickCenterText(Function0<Unit> r1) {
        this.e = r1;
    }

    public final void setRightVisibility(boolean r2) {
        TextView r0 = this.a.f;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CanvasTitleView(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        LayoutInflater.from(r12).inflate(2131561861, this);
        int r15 = 2131365417;
        ImageView r16 = (ImageView) ViewBindings.findChildViewById(this, 2131365417);
        if (r16 == null) goto L22;
        r15 = 2131365424;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131365424);
        if (r7 == null) goto L22;
        r15 = 2131377782;
        AppCompatImageView r8 = ViewBindings.findChildViewById(this, 2131377782);
        if (r8 == null) goto L22;
        r15 = 2131384605;
        ProgressBar r9 = (ProgressBar) ViewBindings.findChildViewById(this, 2131384605);
        if (r9 == null) goto L22;
        r15 = 2131384632;
        TextView r10 = (TextView) ViewBindings.findChildViewById(this, 2131384632);
        if (r10 == null) goto L22;
        this.a = new LarusCanvasTitleBinding(this, r16, r7, r8, r9, r10);
        if (Build.VERSION.SDK_INT >= 28) goto L15;
        r7.setTypeface(r7.getTypeface(), 1);
    L15:
        r7.getPaint().setFakeBoldText(true);
        e1.d(r8, new a(this));
        e1.d(r10, new b(this));
        e1.d(r7, new c(this));
        e1.d(r16, new d(this));
        r7.setOnLongClickListener(new e(this));
        r16.setOnLongClickListener(new f(this));
        r7.setHapticFeedbackEnabled(false);
        r16.setHapticFeedbackEnabled(false);
        boolean r17 = h.a;
        if (h.a(null) == false) goto L18;
        Drawable r18 = ContextCompat.getDrawable(r12, 2131241078);
    L19:
        r9.setIndeterminateDrawable(r18);
        return;
    L18:
        r18 = ContextCompat.getDrawable(r12, 2131241079);
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r15)));
    }

    public /* synthetic */ CanvasTitleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
