package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ AudioPopupWindowImpl a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ AudioPopupWindowImpl b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r3) {
            this.a.removeOnAttachStateChangeListener(this);
            AudioPopupWindowImpl r4 = this.b;
            ViewCompat.setOnApplyWindowInsetsListener(r4.d, new b(r4));
            ViewCompat.requestApplyInsets(this.b.d);
        }

        public a(View r1, AudioPopupWindowImpl r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements OnApplyWindowInsetsListener {
        public final /* synthetic */ AudioPopupWindowImpl a;

        public b(AudioPopupWindowImpl r1) {
            this.a = r1;
        }

        public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r6) {
            Intrinsics.checkNotNullParameter(r5, "<unused var>");
            Intrinsics.checkNotNullParameter(r6, "insets");
            Insets r7 = r6.getInsets(WindowInsetsCompat.Type.systemBars());
            FrameLayout r0 = this.a.d;
            int r8 = r7.bottom;
            r0.setPadding(r0.getPaddingLeft(), r0.getPaddingTop(), r0.getPaddingRight(), r8);
            return r6;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.c$c, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0158c implements View.OnClickListener {
        public static final ViewOnClickListenerC0158c a = null;

        static {
            a = new ViewOnClickListenerC0158c();
        }

        public ViewOnClickListenerC0158c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public final void a() {
        AudioPopupWindowImpl r0 = this.a;
        ViewGroup r2 = null;
        if (r0.i != this) goto L5;
        r0.i = null;
    L5:
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a r1 = r0.e;
        if (r1 == null) goto L8;
        View r3 = r1.getContentView();
    L10:
        if (this.a.isShown() == false) goto L12;
        return;
    L12:
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a r4 = this.a.e;
        if (r4 == null) goto L16;
        Pair<Integer, Integer> r5 = r4.getLayoutParamAttributes();
        if (r5 == null) goto L16;
    L17:
        if (r3 == null) goto L19;
        ViewParent r6 = r3.getParent();
    L21:
        if ((r6 instanceof ViewGroup) == false) goto L23;
        ViewGroup r7 = (ViewGroup) r6;
    L24:
        if (r7 == null) goto L26;
        r7.removeView(r3);
    L26:
        this.a.c.removeAllViews();
        if (r3 == null) goto L32;
        AudioPopupWindowImpl r8 = this.a;
        if (r3.isAttachedToWindow() == false) goto L31;
        ViewCompat.setOnApplyWindowInsetsListener(r8.d, new b(r8));
        ViewCompat.requestApplyInsets(r8.d);
        goto L32
    L31:
        r3.addOnAttachStateChangeListener(new a(r3, r8));
    L32:
        AudioPopupWindowImpl r9 = this.a;
        AudioPopupWindowImpl.b r10 = r9.c;
        FrameLayout r11 = r9.d;
        r11.addView(r3, new FrameLayout.LayoutParams(((Number) r5.getFirst()).intValue(), ((Number) r5.getSecond()).intValue(), 80));
        r11.setOnClickListener(ViewOnClickListenerC0158c.a);
        r10.addView(r11, new AudioPopupWindowImpl.b.a(((Number) r5.getFirst()).intValue(), ((Number) r5.getSecond()).intValue(), this.b, this.c));
        AudioPopupWindowImpl r12 = this.a;
        Drawable r13 = r12.f;
        if (r13 == null) goto L35;
        r12.c.setBackground(r13);
    L35:
        ViewParent r14 = this.a.c.getParent();
        if ((r14 instanceof ViewGroup) == false) goto L38;
        r2 = (ViewGroup) r14;
    L38:
        if (r2 == null) goto L40;
        r2.removeView(this.a.c);
    L40:
        ViewGroup r15 = this.a.b.a();
        if (r15 == null) goto L43;
        r15.addView(this.a.c, new ViewGroup.LayoutParams(-1, -1));
    L43:
        this.a.c.setFocusableInTouchMode(true);
        this.a.c.requestFocus();
        return;
    L23:
        r7 = null;
        goto L24
    L19:
        r6 = null;
    L16:
        r5 = new Pair(-1, -2);
        goto L17
    L8:
        r3 = null;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(AudioPopupWindowImpl r1) {
        this.a = r1;
        this.b = 8388691;
        this.c = 0;
    }
}
