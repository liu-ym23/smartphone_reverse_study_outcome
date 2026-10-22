package com.larus.uaigc.createpage.bussiness.remove.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.viewbinding.ViewBindings;
import com.larus.uaigc.impl.databinding.LarusWidgetPaintSizeControllerBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaintSizeControllerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetPaintSizeControllerBinding;", "config", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaintSizeControllerView$Config;", "offset", "step", "setConfig", "", "setProgress", "progress", "currentProgress", "Config", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PaintSizeControllerView extends LinearLayout {
    public final LarusWidgetPaintSizeControllerBinding a;
    public b b;
    public int c;

    public static final class a implements SeekBar.OnSeekBarChangeListener {
        public final /* synthetic */ PaintSizeControllerView a;

        public a(PaintSizeControllerView r1) {
            this.a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r2) {
            SeekBar.OnSeekBarChangeListener r0 = this.a.b.c;
            if (r0 == null) goto L6;
            r0.onStartTrackingTouch(r2);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r2) {
            SeekBar.OnSeekBarChangeListener r0 = this.a.b.c;
            if (r0 == null) goto L6;
            r0.onStopTrackingTouch(r2);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r3, int r4, boolean r5) {
            PaintSizeControllerView r0 = this.a;
            SeekBar.OnSeekBarChangeListener r1 = r0.b.c;
            if (r1 == null) goto L6;
            r1.onProgressChanged(r3, r4 + r0.c, r5);
            return;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final SeekBar.OnSeekBarChangeListener c;

        public b(int r1, int r2, SeekBar.OnSeekBarChangeListener r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public PaintSizeControllerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PaintSizeControllerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setConfig(b r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        this.b = r4;
        int r0 = r4.a;
        this.c = r0;
        this.a.d.setMax(r4.b + r0);
        RangesKt.coerceAtLeast(1, (r4.b - r4.a) / 5);
        invalidate();
    }

    public final void setProgress(int r3) {
        this.a.d.setProgress(r3 - this.c);
    }

    public PaintSizeControllerView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(2131563263, this);
        int r6 = 2131377773;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(this, 2131377773);
        if (r7 == null) goto L11;
        r6 = 2131384584;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(this, 2131384584);
        if (r8 == null) goto L11;
        r6 = 2131385750;
        SeekBar r0 = (SeekBar) ViewBindings.findChildViewById(this, 2131385750);
        if (r0 == null) goto L11;
        this.a = new LarusWidgetPaintSizeControllerBinding(this, r7, r8, r0);
        this.b = new b(0, 100, null);
        r0.setOnSeekBarChangeListener(new a(this));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r6)));
    }

    public /* synthetic */ PaintSizeControllerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
