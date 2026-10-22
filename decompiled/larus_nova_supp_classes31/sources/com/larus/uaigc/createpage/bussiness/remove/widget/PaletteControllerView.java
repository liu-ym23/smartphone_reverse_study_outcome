package com.larus.uaigc.createpage.bussiness.remove.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.uaigc.createpage.bussiness.remove.i;
import com.larus.uaigc.impl.databinding.LarusWidgetImageEditPaletteControllerBinding;
import com.tencent.open.log.TraceLevel;
import jz9.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\u0013\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0007J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteControllerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetImageEditPaletteControllerBinding;", "config", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteControllerView$Config;", "longUndoHandler", "Landroid/os/Handler;", "isRepeatingUndo", "", "repeatUndoRunnable", "com/larus/uaigc/createpage/bussiness/remove/widget/PaletteControllerView$repeatUndoRunnable$1", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteControllerView$repeatUndoRunnable$1;", "setConfig", "", "refreshUndo", "enable", "refreshRedo", "currentProgress", "onDetachedFromWindow", "startRepeatUndo", "stopRepeatUndo", "Config", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PaletteControllerView extends LinearLayout {
    public static final /* synthetic */ int f = 0;
    public final LarusWidgetImageEditPaletteControllerBinding a;
    public b b;
    public final Handler c;
    public boolean d;
    public final c e;

    public static final class a {
    }

    public static final class b {
        public final PaintSizeControllerView.b a;
        public final Function0<Unit> b;
        public final Function0<Unit> c;

        public b(PaintSizeControllerView.b r1, com.larus.uaigc.createpage.bussiness.remove.a r2, i r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ PaletteControllerView a;

        @Override // java.lang.Runnable
        public final void run() {
            PaletteControllerView r0 = this.a;     // Catch: Throwable -> L15
            if (r0.d == true) goto L5;
        L13:
            PaletteControllerView r1 = this.a;     // Catch: Throwable -> L15
            r1.d = false;     // Catch: Throwable -> L15
            r1.c.removeCallbacks(r1.e);     // Catch: Throwable -> L15
            return;
        L5:
            if (r0.a.d.isEnabled() == false) goto L13;
            b r2 = this.a.b;     // Catch: Throwable -> L15
            if (r2 == null) goto L12;
            Function0<Unit> r3 = r2.b;     // Catch: Throwable -> L15
            if (r3 == null) goto L12;
            r3.invoke();     // Catch: Throwable -> L15
        L12:
            this.a.c.postDelayed(this, 100);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }

        public c(PaletteControllerView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public PaletteControllerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PaletteControllerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.d = false;
        this.c.removeCallbacks(this.e);
        super.onDetachedFromWindow();
    }

    public final void setConfig(b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.b = r2;
        PaintSizeControllerView.b r3 = r2.a;
        if (r3 == null) goto L6;
        this.a.b.setConfig(r3);
        return;
    }

    public PaletteControllerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131563249, this);
        int r5 = 2131381844;
        PaintSizeControllerView r6 = (PaintSizeControllerView) ViewBindings.findChildViewById(this, 2131381844);
        if (r6 == null) goto L11;
        r5 = 2131384117;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(this, 2131384117);
        if (r7 == null) goto L11;
        r5 = 2131391854;
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(this, 2131391854);
        if (r0 == null) goto L11;
        this.a = new LarusWidgetImageEditPaletteControllerBinding(this, r6, r7, r0);
        this.c = new Handler(Looper.getMainLooper());
        this.e = new c(this);
        r0.setOnClickListener(new jz9.a(this));
        r0.setOnLongClickListener(new jz9.b(this));
        r0.setOnTouchListener(new jz9.c(this));
        r7.setOnClickListener(new d(this));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ PaletteControllerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
