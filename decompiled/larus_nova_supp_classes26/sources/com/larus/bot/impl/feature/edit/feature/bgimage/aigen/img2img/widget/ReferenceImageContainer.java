package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bot.impl.common.util.j;
import com.larus.bot.impl.databinding.LarusLayoutBotEditImageDragAjustBinding;
import com.larus.utils.e1;
import com.larus.utils.w0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;
import yu8.a;
import yu8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\"\u0010\u0017\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0013\u0010\u0018\u001a\u00020\u000f2\u000b\u0010\u0019\u001a\u00070\u0007¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/widget/ReferenceImageContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bot/impl/databinding/LarusLayoutBotEditImageDragAjustBinding;", "centerMargin", "onClickPlus", "Lkotlin/Function0;", "", "onClickDelete", "preUIState", "getPreUIState$annotations", "()V", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "initListener", "refreshState", "state", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/widget/ReferenceImageContainer$ReferenceImageUIState;", "getIllustrationHeight", "width", "showEmpty", "showUploading", "onImageFilled", "ReferenceImageUIState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferenceImageContainer extends ConstraintLayout {
    public static final /* synthetic */ int f = 0;
    public final LarusLayoutBotEditImageDragAjustBinding a;
    public final int b;
    public Function0<Unit> c;
    public Function0<Unit> d;
    public int e;

    @Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/widget/ReferenceImageContainer$ReferenceImageUIState;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ReferenceImageUIState {
        public static final a Companion = null;
        public static final int EMPTY = 0;
        public static final int FILLED = 2;
        public static final int UPLOADING = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public ReferenceImageContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ReferenceImageContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @ReferenceImageUIState
    private static /* synthetic */ void getPreUIState$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(int r3) {
        if (this.e != r3) goto L5;
        return;
    L5:
        this.e = r3;
        if (r3 != 0) goto L8;
        this.a.c.setEnabled(true);
        e1.o(this.a.d);
        e1.x(this.a.b);
        e1.o(this.a.h);
        e1.x(this.a.g);
        LarusLayoutBotEditImageDragAjustBinding r4 = this.a;
        r4.e.setText(r4.a.getContext().getString(2131908727));
        this.a.e.setTextColor(ContextCompat.getColor(getContext(), 2131103203));
        this.a.f.setText(getContext().getString(2131905497));
        return;
    L8:
        if (r3 != 1) goto L10;
        this.a.c.setEnabled(false);
        e1.x(this.a.b);
        e1.o(this.a.d);
        e1.o(this.a.g);
        e1.x(this.a.h);
        this.a.e.setText(getContext().getString(2131908728));
        this.a.e.setTextColor(ContextCompat.getColor(getContext(), 2131103140));
        return;
    L10:
        if (r3 != 2) goto L18;
        this.a.c.setEnabled(false);
        e1.o(this.a.b);
        e1.x(this.a.d);
        this.a.f.setText(getContext().getString(2131908919));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r7, int r8) {
        int r0 = View.MeasureSpec.getSize(r7);
        int r1 = View.MeasureSpec.getSize(r8);
        int r2 = j.b(this.a.f, getContext().getString(2131905497), r0).getHeight();
        int r3 = RangesKt.coerceAtMost(r0 - c7.b(32), (r1 - r2) - this.b);
        MyClickablePassThroughView r4 = this.a.c;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L7;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        r6.width = r3;
        r6.height = r3;
        r4.setLayoutParams(r6);
        w0.e(this.a.c, (int) ((((double) r3) * 0.1d) + 0.5d));
        super.onMeasure(r7, r8);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReferenceImageContainer(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        LayoutInflater.from(r10).inflate(2131562756, this);
        int r13 = 2131365401;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(this, 2131365401);
        if (r2 == null) goto L19;
        r13 = 2131368298;
        MyClickablePassThroughView r14 = (MyClickablePassThroughView) ViewBindings.findChildViewById(this, 2131368298);
        if (r14 == null) goto L19;
        r13 = 2131368785;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(this, 2131368785);
        if (r15 == null) goto L19;
        r13 = 2131368819;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131368819);
        if (r5 == null) goto L19;
        r13 = 2131374912;
        TextView r6 = (TextView) ViewBindings.findChildViewById(this, 2131374912);
        if (r6 == null) goto L19;
        r13 = 2131382495;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(this, 2131382495);
        if (r7 == null) goto L19;
        r13 = 2131391940;
        ProgressBar r8 = (ProgressBar) ViewBindings.findChildViewById(this, 2131391940);
        if (r8 == null) goto L19;
        this.a = new LarusLayoutBotEditImageDragAjustBinding(this, r2, r14, r15, r5, r6, r7, r8);
        this.b = c7.b(16);
        Function0<Unit> r16 = new a(this);
        Intrinsics.checkNotNullParameter(r16, "onInvoke");
        r14.e = r16;
        e1.d(r15, new b(this));
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r13)));
    }

    public /* synthetic */ ReferenceImageContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
