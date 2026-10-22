package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SeekBar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/slider/SeekBarCompat;", "Lcom/obric/oui/slider/TickMarkSeekBar;", "", "toRealValue", "toWrapValue", "getProgress", "getMinRealValue", "getMaxRealValue", "minValue", "", "setMinValue", "maxValue", "setMaxValue", "progress", "setProgress", "", "animate", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "l", "setOnSeekBarChangeListener", TypedValues.CycleType.S_WAVE_OFFSET, "I", "onSeekBarChangeListener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class SeekBarCompat extends TickMarkSeekBar {
    private int offset;
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SeekBarCompat f7435a;

        a(SeekBarCompat r10) {
            this.f7435a = r10;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar r10, int r11, boolean r12) {
            Log.i("SeekBarCompat", String.valueOf(r11));
            SeekBar.OnSeekBarChangeListener r13 = SeekBarCompat.access$getOnSeekBarChangeListener$p(this.f7435a);
            if (r13 == null) goto L6;
            r13.onProgressChanged(r10, SeekBarCompat.access$toRealValue(this.f7435a, r11), r12);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar r10) {
            SeekBar.OnSeekBarChangeListener r11 = SeekBarCompat.access$getOnSeekBarChangeListener$p(this.f7435a);
            if (r11 == null) goto L6;
            r11.onStartTrackingTouch(r10);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar r10) {
            SeekBar.OnSeekBarChangeListener r11 = SeekBarCompat.access$getOnSeekBarChangeListener$p(this.f7435a);
            if (r11 == null) goto L6;
            r11.onStopTrackingTouch(r10);
            return;
        }
    }

    @JvmOverloads
    public SeekBarCompat(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public SeekBarCompat(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public SeekBarCompat(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ SeekBarCompat(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ SeekBar.OnSeekBarChangeListener access$getOnSeekBarChangeListener$p(SeekBarCompat r10) {
        return r10.onSeekBarChangeListener;
    }

    public static final /* synthetic */ void access$setOnSeekBarChangeListener$p(SeekBarCompat r10, SeekBar.OnSeekBarChangeListener r11) {
        r10.onSeekBarChangeListener = r11;
    }

    public static final /* synthetic */ int access$toRealValue(SeekBarCompat r10, int r11) {
        return r10.toRealValue(r11);
    }

    private final int toRealValue(int r10) {
        return r10 + this.offset;
    }

    private final int toWrapValue(int r10) {
        return r10 - this.offset;
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

    public final void setMaxValue(int r10) {
        setMax(toWrapValue(r10));
    }

    public final void setMinValue(int r10) {
        this.offset = r10;
        setMax(toWrapValue(getMax()));
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r10) {
        this.onSeekBarChangeListener = r10;
        super.setOnSeekBarChangeListener(new a(this));
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r10) {
        super.setProgress(toWrapValue(r10));
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r10, boolean r11) {
        super.setProgress(toWrapValue(r10), r11);
    }
}
