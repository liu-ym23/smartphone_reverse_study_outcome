package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0003H\u0002J\u0016\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/slider/SeekBarFloatCompat;", "Lcom/obric/oui/slider/SeekBarCompat;", "", "", "toWrapValue", "toRealValue", "decimals", "round", "minValue", "", "setMinValue", "maxValue", "setMaxValue", "progress", "setProgress", "process", "", "animate", "getMinValue", "getMaxValue", "getFloatProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SeekBarFloatCompat extends SeekBarCompat {
    public static final a Companion = null;
    private static final int MULTIPLE = 100;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    @JvmOverloads
    public SeekBarFloatCompat(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public SeekBarFloatCompat(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public SeekBarFloatCompat(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ SeekBarFloatCompat(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final float round(float r10, int r11) {
        String r12 = String.format(Locale.CHINA, "%." + r11 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r10)}, 1));
        Intrinsics.checkNotNullExpressionValue(r12, "format(locale, this, *args)");
        return Float.parseFloat(r12);
    }

    static /* synthetic */ float round$default(SeekBarFloatCompat r10, float r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r12 = 2;
    L6:
        return r10.round(r11, r12);
    }

    private final float toRealValue(int r10) {
        return round$default(this, r10 / 100, 0, 1, null);
    }

    private final int toWrapValue(float r10) {
        return (int) (r10 * 100);
    }

    public final float getFloatProgress() {
        return toRealValue(super.getProgress());
    }

    public final float getMaxValue() {
        return toRealValue(getMaxRealValue());
    }

    public final float getMinValue() {
        return toRealValue(getMinRealValue());
    }

    public final void setMaxValue(float r10) {
        super.setMaxValue(toWrapValue(r10));
    }

    public final void setMinValue(float r10) {
        super.setMinValue(toWrapValue(r10));
    }

    public final void setProgress(float r10) {
        super.setProgress(toWrapValue(r10));
    }

    public final void setProgress(float r10, boolean r11) {
        super.setProgress(toWrapValue(r10), r11);
    }
}
