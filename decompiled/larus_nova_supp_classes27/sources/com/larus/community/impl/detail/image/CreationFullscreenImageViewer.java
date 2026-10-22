package com.larus.community.impl.detail.image;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001;B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cJ\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020&H\u0002J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0013H\u0002J\b\u0010.\u001a\u00020&H\u0002J\u0006\u0010/\u001a\u00020\u0010J\b\u00100\u001a\u00020&H\u0014J\b\u00101\u001a\u00020&H\u0016J \u00102\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u00103\u001a\u00020&H\u0016J\u0018\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0013H\u0016J\u0018\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u0013H\u0016J\b\u0010:\u001a\u00020&H\u0016R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006<"}, d2 = {"Lcom/larus/community/impl/detail/image/CreationFullscreenImageViewer;", "Landroid/widget/FrameLayout;", "Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView$OnZoomListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fullscreenContainer", "fullscreenBackground", "fullscreenImageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "isFullscreenMode", "", "isAnimating", "currentScale", "", "focusX", "focusY", "translateX", "translateY", "originalRect", "Landroid/graphics/Rect;", "sourceViewEntryPosition", "sourceView", "Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView;", "animatorSet", "Landroid/animation/AnimatorSet;", "viewerListener", "Lcom/larus/community/impl/detail/image/CreationFullscreenImageViewer$OnViewerListener;", "getViewerListener", "()Lcom/larus/community/impl/detail/image/CreationFullscreenImageViewer$OnViewerListener;", "setViewerListener", "(Lcom/larus/community/impl/detail/image/CreationFullscreenImageViewer$OnViewerListener;)V", "setSourceView", "", "view", "showFullscreenImage", "copyImageFromSource", "hideFullscreenImage", "updateFullscreenImagePosition", "updateFullscreenScale", "scale", "animateToOriginal", "onBackPressed", "onDetachedFromWindow", "onZoomStart", "onZooming", "onZoomEnd", "onDragStart", "x", "y", "onDragging", "dx", "dy", "onDragEnd", "OnViewerListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationFullscreenImageViewer extends FrameLayout implements CreationZoomableDraweeView.c {
    public static final /* synthetic */ int m = 0;
    public final FrameLayout a;
    public final FrameLayout b;
    public final SimpleDraweeView c;
    public boolean d;
    public boolean e;
    public float f;
    public float g;
    public Rect h;
    public Rect i;
    public CreationZoomableDraweeView j;
    public final AnimatorSet k;
    public a l;

    public interface a {
        void a(boolean r1);
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ CreationFullscreenImageViewer a;

        public b(CreationFullscreenImageViewer r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.e = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            CreationFullscreenImageViewer r5 = this.a;
            if (r5.d == false) goto L16;
            r5.d = false;
            CreationZoomableDraweeView r1 = r5.j;
            if (r1 == null) goto L8;
            r1.setFullscreenMode(false);
        L8:
            SimpleDraweeView r2 = r5.j;
            if (r2 == null) goto L11;
            r2.setVisibility(0);
        L11:
            r5.f = 0.0f;
            r5.g = 0.0f;
            r5.e = false;
            r5.i = null;
            r5.a.setVisibility(8);
            a r6 = r5.l;
            if (r6 == null) goto L15;
            r6.a(false);
            return;
        L15:
            return;
        }
    }

    public CreationFullscreenImageViewer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CreationFullscreenImageViewer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.community.impl.detail.image.CreationZoomableDraweeView.c
    public final void b() {
    }

    @Override // com.larus.community.impl.detail.image.CreationZoomableDraweeView.c
    public final void onDragStart() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.community.impl.detail.image.CreationZoomableDraweeView.c
    public final void d() {
        Rect r0 = this.i;
        Rect r1 = null;
        if (r0 != null) goto L10;
        SimpleDraweeView r2 = this.j;
        if (r2 == null) goto L7;
        int[] r5 = new int[2];
        r2.getLocationOnScreen(r5);
        int r7 = r5[0];
        r0 = new Rect(r7, r5[1], r2.getWidth() + r7, r5[1] + r2.getHeight());
    L8:
        if (r0 != null) goto L10;
        r0 = new Rect(0, 0, 0, 0);
        goto L10
    L7:
        r0 = null;
    L10:
        this.h = r0;
        int[] r3 = new int[2];
        getLocationOnScreen(r3);
        Rect r4 = this.h;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r4 = null;
    L13:
        int r6 = r4.left - r3[0];
        Rect r8 = this.h;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r8 = null;
    L16:
        int r9 = r8.top - r3[1];
        this.c.setTranslationX(r6);
        this.c.setTranslationY(r9);
        ViewGroup.LayoutParams r10 = this.c.getLayoutParams();
        Rect r11 = this.h;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r11 = null;
    L19:
        r10.width = r11.width();
        Rect r12 = this.h;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
    L23:
        r10.height = r1.height();
        this.c.setLayoutParams(r10);
        this.f = 0.0f;
        this.g = 0.0f;
        return;
    L22:
        r1 = r12;
        goto L23
    }

    public final void e() {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        this.k.cancel();
        final float r3 = this.c.getTranslationX();
        final float r5 = this.c.getTranslationY();
        final int r7 = this.c.getWidth();
        final int r9 = this.c.getHeight();
        int[] r2 = new int[2];
        getLocationOnScreen(r2);
        Rect r4 = this.h;
        Rect r6 = null;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r4 = null;
    L8:
        int r8 = r4.left - r2[0];
        Rect r10 = this.h;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r10 = null;
    L11:
        final float r11 = r8;
        final float r12 = r10.top - r2[1];
        Rect r13 = this.h;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r13 = null;
    L14:
        final int r14 = r13.width();
        Rect r15 = this.h;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
    L18:
        final int r16 = r6.height();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.addUpdateListener(new q(r3, r11, r5, r12, r7, r14, r9, r16, this));
        this.k.playTogether(new Animator[]{r1});
        this.k.setDuration(250);
        this.k.setInterpolator(new AccelerateDecelerateInterpolator());
        this.k.addListener(new b(this));
        this.k.start();
        return;
    L17:
        r6 = r15;
        goto L18
    }

    @Override // com.larus.community.impl.detail.image.CreationZoomableDraweeView.c
    public final void onDragEnd() {
        if (this.e == false) goto L6;
        return;
    L6:
        if (this.d == false) goto L9;
        e();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k.cancel();
    }

    public final a getViewerListener() {
        return this.l;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.community.impl.detail.image.CreationZoomableDraweeView.c
    public final void a(float r11) {
        if (this.e == false) goto L5;
        return;
    L5:
        boolean r0 = this.d;
        Rect r4 = null;
        if (r0 == true) goto L51;
        if (r0 == true) goto L51;
        this.d = true;
        CreationZoomableDraweeView r1 = this.j;
        if (r1 == null) goto L12;
        r1.setFullscreenMode(true);
    L12:
        SimpleDraweeView r2 = this.j;
        if (r2 == null) goto L15;
        int[] r5 = new int[2];
        r2.getLocationOnScreen(r5);
        int r7 = r5[0];
        Rect r6 = new Rect(r7, r5[1], r2.getWidth() + r7, r5[1] + r2.getHeight());
    L16:
        this.i = r6;
        SimpleDraweeView r3 = this.j;
        if (r3 == null) goto L19;
        r3.setVisibility(4);
    L19:
        SimpleDraweeView r8 = this.j;
        if (r8 != null) goto L73;
    L46:
        this.a.setVisibility(0);
        a r9 = this.l;
        if (r9 == null) goto L49;
        r9.a(true);
    L49:
        this.b.setAlpha(0.0f);
        this.b.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        goto L51
    L73:
        Drawable r10 = r8.getDrawable();     // Catch: Exception -> L44
        if (r10 == null) goto L25;
        this.c.setImageDrawable(r10);     // Catch: Exception -> L44
        goto L46
    L25:
        Object r12 = r8.getTag(2131377234);     // Catch: Exception -> L44
        if ((r12 instanceof Uri) == false) goto L29;
        ImageLoaderKt.s(this.c, (Uri) r12, "creation_detail_image");     // Catch: Exception -> L44
        goto L46
    L29:
        Object r13 = r8.getTag();     // Catch: Exception -> L44
        if (r13 == null) goto L32;
        String r14 = r13.toString();     // Catch: Exception -> L44
    L33:
        if (r14 == null) goto L46;
        if (r14.length() <= 0) goto L37;
        boolean r15 = true;
    L38:
        if (r15 == false) goto L46;
        ImageLoaderKt.s(this.c, UriProtector.parse(r14), "creation_detail_image");     // Catch: Exception -> L41
    L41:
        e = move-exception;
        FLogger.a.e("FullscreenViewer", "Failed to parse URI: ".concat(r14), e);     // Catch: Exception -> L44
        goto L46
    L37:
        r15 = false;
        goto L38
    L32:
        r14 = null;
    L44:
        e = move-exception;
        FLogger.a.e("FullscreenViewer", "Error copying image", e);
        goto L46
    L15:
        r6 = null;
    L51:
        if (this.d == false) goto L76;
        Rect r16 = this.h;
        if (r16 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r16 = null;
    L55:
        float r17 = r16.width() * r11;
        Rect r18 = this.h;
        if (r18 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r18 = null;
    L58:
        float r20 = r18.height() * r11;
        int[] r110 = new int[2];
        getLocationOnScreen(r110);
        Rect r21 = this.h;
        if (r21 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r21 = null;
    L61:
        int r22 = r21.left - r110[0];
        Rect r23 = this.h;
        if (r23 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r23 = null;
    L64:
        int r24 = r23.top - r110[1];
        float r111 = r22;
        Rect r25 = this.h;
        if (r25 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
        r25 = null;
    L67:
        float r26 = 2;
        float r112 = (r111 - ((r17 - r25.width()) / r26)) + this.f;
        float r27 = r24;
        Rect r28 = this.h;
        if (r28 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("originalRect");
    L71:
        float r30 = (r27 - ((r20 - r4.height()) / r26)) + this.g;
        this.c.setTranslationX(r112);
        this.c.setTranslationY(r30);
        ViewGroup.LayoutParams r113 = this.c.getLayoutParams();
        r113.width = (int) r17;
        r113.height = (int) r20;
        this.c.setLayoutParams(r113);
        return;
    L70:
        r4 = r28;
        goto L71
    }

    public final void setSourceView(CreationZoomableDraweeView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.j = r2;
        r2.setZoomListener(this);
    }

    public final void setViewerListener(a r1) {
        this.l = r1;
    }

    @Override // com.larus.community.impl.detail.image.CreationZoomableDraweeView.c
    public final void c(float r3, float r4) {
        if (this.e == false) goto L6;
        return;
    L6:
        if (this.d == false) goto L9;
        this.f += r3;
        this.g += r4;
        SimpleDraweeView r0 = this.c;
        r0.setTranslationX(r0.getTranslationX() + r3);
        SimpleDraweeView r5 = this.c;
        r5.setTranslationY(r5.getTranslationY() + r4);
        return;
    }

    public CreationFullscreenImageViewer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = new AnimatorSet();
        LayoutInflater.from(r2).inflate(2131561943, this, true);
        FrameLayout r5 = (FrameLayout) findViewById(2131373350);
        this.a = r5;
        this.c = findViewById(2131373351);
        this.b = (FrameLayout) findViewById(2131373347);
        r5.setVisibility(8);
        r5.setOnClickListener(new p(this));
    }

    public /* synthetic */ CreationFullscreenImageViewer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
