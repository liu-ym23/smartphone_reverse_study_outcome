package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.common.apphost.AppHost;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v0 extends ImageSpan implements gw8.d, q0 {
    public final boolean a;
    public Drawable b;
    public Integer c;
    public final boolean d;
    public final WeakReference<View> e;
    public boolean f;
    public boolean g;
    public final Lazy h;
    public final ValueAnimator i;
    public int j;
    public boolean k;
    public final u0 l;
    public boolean m;
    public boolean n;
    public boolean o;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final WeakReference<v0> a;

        public a(v0 r2) {
            Intrinsics.checkNotNullParameter(r2, "span");
            this.a = new WeakReference(r2);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            v0 r0 = this.a.get();
            if (r0 != null) goto L6;
            r4.cancel();
            return;
        L6:
            Object r5 = r4.getAnimatedValue();
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
            r0.j = ((Integer) r5).intValue();
            WeakReference<View> r6 = r0.e;
            if (r6 == null) goto L27;
            View r7 = r6.get();
            if (r7 == null) goto L29;
            Unit r1 = null;
            if ((r7 instanceof ViewGroup) == false) goto L14;
            ViewGroup r2 = (ViewGroup) r7;
        L15:
            if (r2 == null) goto L25;
            View r3 = r2.getChildAt(r2.getChildCount() - 1);
            if ((r3 instanceof FrameLayout) == false) goto L19;
            FrameLayout r8 = (FrameLayout) r3;
        L20:
            if (r8 == null) goto L24;
            View r9 = r8.getChildAt(0);
            if (r9 == null) goto L24;
            r9.invalidate();
            r1 = Unit.INSTANCE;
        L24:
            if (r1 == null) goto L25;
            return;
        L19:
            r8 = null;
        L25:
            r7.invalidate();
            return;
        L14:
            r2 = null;
            goto L15
        L29:
            return;
        }
    }

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppBackground() {
        this.n = false;
        a();
    }

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppForeground() {
        this.n = true;
        b();
    }

    public final void a() {
        this.i.cancel();
        if (((Boolean) this.h.getValue()).booleanValue() == false) goto L6;
        com.larus.utils.t0.a.removeCallbacks(this.l);
        return;
    }

    public final void b() {
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.o == true) goto L30;
        WeakReference<View> r0 = this.e;
        if (r0 == null) goto L9;
        View r1 = r0.get();
    L11:
        if (this.d == false) goto L16;
        if (r1 != null) goto L14;
    L15:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L21;
        a();
        return;
    L21:
        if (this.i.isRunning() == false) goto L23;
        return;
    L23:
        if (this.m == true) goto L26;
        CopyOnWriteArrayList<WeakReference<q0>> r3 = s0.a;
        s0.a(this);
        this.n = !AppHost.a.a().isAppBackground();
        this.m = true;
    L26:
        if (this.n == false) goto L32;
        this.i.start();
        return;
    L32:
        return;
    L14:
        if (r1.isAttachedToWindow() == false) goto L15;
    L16:
        r2 = false;
        goto L17
    L9:
        r1 = null;
        goto L11
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        Drawable r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Drawable r1 = super.getDrawable();
        if (r1 == null) goto L8;
        Drawable r2 = r1.mutate();
    L9:
        this.b = r2;
        if (r2 == null) goto L17;
        Integer r3 = this.c;
        if (r3 == null) goto L15;
        DrawableCompat.setTint(r2, r3.intValue());
        goto L17
    L15:
        DrawableCompat.setTintList(r2, null);
    L17:
        return this.b;
    L8:
        r2 = null;
        goto L9
    }

    public /* synthetic */ v0(View r7, int r8, Context r9) {
        this(r7, r8, r9, false, null);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.bmhome.chat.layout.widget.u0] */
    public v0(View r1, int r2, Context r3, boolean r4, Integer r5) {
        if (r3 == null) goto L5;
        Context r6 = r3.getApplicationContext();
        if (r6 == null) goto L5;
    L6:
        super(r6, r2);
        this.a = r4;
        this.c = r5;
        if (r1 == null) goto L9;
        boolean r7 = true;
    L10:
        this.d = r7;
        if (r1 == null) goto L13;
        WeakReference<View> r8 = new WeakReference(r1);
    L14:
        this.e = r8;
        this.h = LazyKt.lazy(new t0());
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{0, 255});
        r9.setDuration(400);
        r9.setRepeatCount(-1);
        r9.setRepeatMode(2);
        r9.addUpdateListener(new a(this));
        this.i = r9;
        this.l = new u0(this);
        this.n = true;
        return;
    L13:
        r8 = null;
        goto L14
    L9:
        r7 = false;
    L5:
        r6 = AppHost.a.getApplication();
        goto L6
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        int r6 = 0;
        if (this.g == false) goto L5;
        return 0;
    L5:
        Drawable r7 = getDrawable();
        if (r7 == null) goto L11;
        Rect r8 = r7.getBounds();
        if (r8 == null) goto L11;
        r6 = r8.right;
    L11:
        return r6 + i5.e0();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r9, "paint");
        if (this.g == false) goto L5;
        return;
    L5:
        WeakReference<View> r10 = this.e;
        io.noties.markwon.core.spans.o r11 = null;
        if (r10 == null) goto L8;
        View r12 = r10.get();
    L9:
        int r13 = 0;
        if (this.d == false) goto L15;
        if (r12 != null) goto L13;
    L14:
        boolean r14 = true;
    L16:
        if (r14 == false) goto L20;
        a();
        return;
    L20:
        if ((r2 instanceof SpannableString) == false) goto L22;
        SpannableString r15 = (SpannableString) r2;
    L23:
        if (r15 == null) goto L28;
        io.noties.markwon.core.spans.o[] r16 = (io.noties.markwon.core.spans.o[]) r15.getSpans(0, ((SpannableString) r2).length(), io.noties.markwon.core.spans.o.class);
        if (r16 == null) goto L28;
        r11 = (io.noties.markwon.core.spans.o) ArraysKt.lastOrNull(r16);
    L28:
        if (this.a == true) goto L31;
        if (r11 == null) goto L31;
        return;
    L31:
        Drawable r17 = getDrawable();
        if (r17 != null) goto L34;
        return;
    L34:
        Paint.FontMetricsInt r18 = r9.getFontMetricsInt();
        int r19 = ((((r18.descent + r7) + r7) + r18.ascent) / 2) - (r17.getBounds().bottom / 2);
        r1.save();
        if (this.f == true) goto L38;
        r13 = i5.e0();
    L38:
        r1.translate(r5 + r13, r19);
        r17.setAlpha(this.j);
        r17.draw(r1);
        r1.restore();
        return;
    L22:
        r15 = null;
        goto L23
    L13:
        if (r12.isAttachedToWindow() == false) goto L14;
    L15:
        r14 = false;
        goto L16
    L8:
        r12 = null;
        goto L9
    }
}
