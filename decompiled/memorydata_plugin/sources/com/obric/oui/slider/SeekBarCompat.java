package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SeekBar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\f\u0010\u001a\u001a\u00020\u0007*\u00020\u0007H\u0002J\f\u0010\u001b\u001a\u00020\u0007*\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/slider/SeekBarCompat;", "Lcom/obric/oui/slider/TickMarkSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", TypedValues.CycleType.S_WAVE_OFFSET, "onSeekBarChangeListener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "getMaxRealValue", "getMinRealValue", "getProgress", "setMaxValue", "", "maxValue", "setMinValue", "minValue", "setOnSeekBarChangeListener", "l", "setProgress", "progress", "animate", "", "toRealValue", "toWrapValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SeekBarCompat extends TickMarkSeekBar {
    private int offset;
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/obric/oui/slider/SeekBarCompat$setOnSeekBarChangeListener$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SeekBarCompat f14492a;

        a(SeekBarCompat r1) {
            this.f14492a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar r3, int r4, boolean r5) {
            Log.i("SeekBarCompat", String.valueOf(r4));
            SeekBar.OnSeekBarChangeListener r0 = SeekBarCompat.access$getOnSeekBarChangeListener$p(this.f14492a);
            if (r0 == null) goto L7;
            r0.onProgressChanged(r3, SeekBarCompat.access$toRealValue(this.f14492a, r4), r5);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar r1) {
            SeekBar.OnSeekBarChangeListener r0 = SeekBarCompat.access$getOnSeekBarChangeListener$p(this.f14492a);
            if (r0 == null) goto L7;
            r0.onStartTrackingTouch(r1);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar r1) {
            SeekBar.OnSeekBarChangeListener r0 = SeekBarCompat.access$getOnSeekBarChangeListener$p(this.f14492a);
            if (r0 == null) goto L7;
            r0.onStopTrackingTouch(r1);
            return;
        }
    }

    public SeekBarCompat(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public SeekBarCompat(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public SeekBarCompat(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
    }

    public /* synthetic */ SeekBarCompat(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ SeekBar.OnSeekBarChangeListener access$getOnSeekBarChangeListener$p(SeekBarCompat r0) {
        return r0.onSeekBarChangeListener;
    }

    public static final /* synthetic */ int access$toRealValue(SeekBarCompat r0, int r1) {
        return r0.toRealValue(r1);
    }

    private final int toRealValue(int r1) {
        return r1 + this.offset;
    }

    private final int toWrapValue(int r1) {
        return r1 - this.offset;
    }

    public final int getMaxRealValue() {
        return toRealValue(getMax());
    }

    public final int getMinRealValue() {
        return toRealValue(0);
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return toRealValue(super.getProgress());
    }

    public final void setMaxValue(int r1) {
        setMax(toWrapValue(r1));
    }

    public final void setMinValue(int r1) {
        this.offset = r1;
        setMax(toWrapValue(getMax()));
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r3) {
        this.onSeekBarChangeListener = (SeekBar.OnSeekBarChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, SeekBar.OnSeekBarChangeListener.class, "com.obric.memorydata.plugin");
        super.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) ZeusTransformUtils.preCheckCast(new a(this), SeekBar.OnSeekBarChangeListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public void setProgress(int r1) {
        super.setProgress(toWrapValue(r1));
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public void setProgress(int r1, boolean r2) {
        super.setProgress(toWrapValue(r1), r2);
    }
}
