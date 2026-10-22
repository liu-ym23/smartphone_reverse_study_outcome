package com.larus.chat.gallery.impl.preview.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0014J\b\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/toolbar/PreviewToolbarItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "loadingView", "currentItem", "Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarButtonItem;", "currentMode", "Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarLayoutMode;", "isEmphasized", "", "bind", "", "item", "mode", "emphasized", "updateState", "setPressed", "pressed", "updateContentAlpha", "setLoading", "loading", "getOrCreateLoadingView", "bindText", "bindSelectStyle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewToolbarItemView extends FrameLayout {
    public ImageView a;
    public TextView b;
    public ImageView c;
    public j d;
    public ToolbarLayoutMode e;
    public boolean f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToolbarLayoutMode.values().length];
            r0[ToolbarLayoutMode.VERTICAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ToolbarLayoutMode.HORIZONTAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public PreviewToolbarItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PreviewToolbarItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.widget.FrameLayout, com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarItemView] */
    private final ImageView getOrCreateLoadingView() {
        ImageView r0 = this.c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.f == false) goto L8;
        int r1 = i5.A();
        int r2 = 2131241742;
    L16:
        ImageView r3 = new ImageView(getContext());
        r3.setImageResource(r2);
        r3.setVisibility(8);
        if (this.f == false) goto L19;
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r1, r1);
        r4.gravity = 17;
        r3.setLayoutParams(r4);
        addView(r3);
    L33:
        this.c = r3;
        return r3;
    L19:
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(r1, r1);
        r5.gravity = 1;
        r3.setLayoutParams(r5);
        ImageView r6 = this.a;
        ?? r7 = 0;
        if (r6 == null) goto L22;
        ViewParent r8 = r6.getParent();
    L24:
        if ((r8 instanceof ViewGroup) == false) goto L26;
        r7 = (ViewGroup) r8;
    L26:
        if (r7 != 0) goto L28;
        r7 = this;
    L28:
        int r9 = r7.indexOfChild(this.a);
        if (r9 >= 0) goto L32;
        r9 = 0;
    L32:
        r7.addView(r3, r9);
        goto L33
    L22:
        r8 = null;
        goto L24
    L8:
        int r10 = b.a[this.e.ordinal()];
        if (r10 != 1) goto L11;
        r1 = i5.Q();
        r2 = 2131241741;
        goto L16
    L11:
        if (r10 != 2) goto L14;
        r1 = i5.A();
        r2 = 2131241743;
        goto L16
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void a() {
        j r0 = this.d;
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        float r1 = 0.5f;
        if ((!r2) == true) goto L11;
    L16:
        setAlpha(r1);
        return;
    L11:
        if (isPressed() == true) goto L13;
    L15:
        r1 = 1.0f;
        goto L16
    L13:
        if (isClickable() == false) goto L15;
    L5:
        if (r0.g == true) goto L7;
        r2 = true;
        goto L7
    }

    public final void setLoading(boolean r10) {
        if (r10 == true) goto L5;
        ImageView r11 = this.c;
        if (r11 == null) goto L16;
        r11.clearAnimation();
    L16:
        ImageView r12 = this.c;
        if (r12 == null) goto L20;
        r12.setVisibility(8);
    L20:
        if (this.f == false) goto L24;
        TextView r13 = this.b;
        if (r13 == null) goto L27;
        r13.setVisibility(0);
    L27:
        setClickable(true);
        a();
        return;
    L24:
        ImageView r14 = this.a;
        if (r14 == null) goto L27;
        r14.setVisibility(0);
        goto L27
    L5:
        if (this.f == false) goto L9;
        TextView r15 = this.b;
        if (r15 == null) goto L12;
        r15.setVisibility(4);
    L12:
        ImageView r16 = getOrCreateLoadingView();
        r16.setVisibility(0);
        RotateAnimation r0 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r0.setDuration(500);
        r0.setRepeatCount(-1);
        r0.setInterpolator(new LinearInterpolator());
        r16.startAnimation(r0);
        setClickable(false);
        a();
        return;
    L9:
        ImageView r17 = this.a;
        if (r17 == null) goto L12;
        r17.setVisibility(8);
        goto L12
    }

    @Override // android.view.View
    public void setPressed(boolean r1) {
        super.setPressed(r1);
        a();
    }

    public PreviewToolbarItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = ToolbarLayoutMode.VERTICAL;
    }

    public /* synthetic */ PreviewToolbarItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
