package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u0019\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/slider/SeekBarCompat;", "Lcom/obric/oui/slider/TickMarkSeekBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getProgress", "()I", "getMinRealValue", "getMaxRealValue", "minValue", "", "setMinValue", "(I)V", "maxValue", "setMaxValue", NotificationCompat.CATEGORY_PROGRESS, "setProgress", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "l", "setOnSeekBarChangeListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SeekBarCompat extends TickMarkSeekBar {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f14529a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public SeekBar.OnSeekBarChangeListener f14530b0;

    @JvmOverloads
    public SeekBarCompat(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final int getMaxRealValue() {
        return getMax() + this.f14529a0;
    }

    public final int getMinRealValue() {
        return this.f14529a0;
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return super.getProgress() + this.f14529a0;
    }

    public final void setMaxValue(int r5) {
        setMax(r5 - this.f14529a0);
    }

    public final void setMinValue(int r5) {
        this.f14529a0 = r5;
        setMax(getMax() - this.f14529a0);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r5) {
        this.f14530b0 = r5;
        super.setOnSeekBarChangeListener(new a(this, 0));
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public void setProgress(int r5) {
        super.setProgress(r5 - this.f14529a0);
    }

    @JvmOverloads
    public SeekBarCompat(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ SeekBarCompat(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public final void setProgress(int r5, boolean r10) {
        super.setProgress(r5 - this.f14529a0, r10);
    }

    @JvmOverloads
    public SeekBarCompat(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
    }
}
