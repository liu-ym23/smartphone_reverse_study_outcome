package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0004\b+\u0010,J$\u0010\n\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014J0\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0014R\u001d\u0010\u001d\u001a\u00020\u00038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u00020\u00038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001d\u0010#\u001a\u00020\u00038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006/"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/obric/oui/picker/reels/views/WheelView;", "Lx9/a;", "reel", "", "colIndex", "maxColIndex", "", "configure", "Landroid/view/View;", "asView", "col", "getReelView", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "wv3$delegate", "Lkotlin/Lazy;", "getWv3", "()Lcom/obric/oui/picker/reels/views/WheelView;", "wv3", "wv2$delegate", "getWv2", "wv2", "wv1$delegate", "getWv1", "wv1", "reelsCount", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OReelPickerThreeReels extends ConstraintLayout {
    public static final a Companion = null;
    private static final String TAG = "OReelPickerThreeReels";
    private int reelsCount;
    private final Lazy wv1$delegate;
    private final Lazy wv2$delegate;
    private final Lazy wv3$delegate;

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
    public OReelPickerThreeReels(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OReelPickerThreeReels(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OReelPickerThreeReels(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.wv1$delegate = LazyKt.lazy(new OReelPickerThreeReels$wv1$2(this));
        this.wv2$delegate = LazyKt.lazy(new OReelPickerThreeReels$wv2$2(this));
        this.wv3$delegate = LazyKt.lazy(new OReelPickerThreeReels$wv3$2(this));
        LayoutInflater.from(r10).inflate(h.o_reel_picker_3_reels, this);
    }

    public /* synthetic */ OReelPickerThreeReels(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ void access$configure(OReelPickerThreeReels r10, WheelView r11, x9.a r12, int r13, int r14) {
        r10.configure(r11, r12, r13, r14);
    }

    public static final /* synthetic */ int access$getReelsCount$p(OReelPickerThreeReels r10) {
        return r10.reelsCount;
    }

    public static final /* synthetic */ WheelView access$getWv1$p(OReelPickerThreeReels r10) {
        return r10.getWv1();
    }

    public static final /* synthetic */ WheelView access$getWv2$p(OReelPickerThreeReels r10) {
        return r10.getWv2();
    }

    public static final /* synthetic */ WheelView access$getWv3$p(OReelPickerThreeReels r10) {
        return r10.getWv3();
    }

    public static final /* synthetic */ void access$setReelsCount$p(OReelPickerThreeReels r10, int r11) {
        r10.reelsCount = r11;
    }

    private final void configure(WheelView r10, x9.a r11, int r12, int r13) {
        r10.setVisibility(0);
        throw null;
    }

    private final WheelView getWv1() {
        return (WheelView) this.wv1$delegate.getValue();
    }

    private final WheelView getWv2() {
        return (WheelView) this.wv2$delegate.getValue();
    }

    private final WheelView getWv3() {
        return (WheelView) this.wv3$delegate.getValue();
    }

    public View asView() {
        return this;
    }

    public void configure(int r10, x9.a r11) {
        Intrinsics.checkNotNullParameter(r11, "reel");
        WheelView r12 = getReelView(r10);
        if (r12 == null) goto L6;
        configure(r12, r11, r10, this.reelsCount - 1);
        return;
    }

    public WheelView getReelView(int r10) {
        if (r10 == 0) goto L11;
        if (r10 == 1) goto L14;
        if (r10 == 2) goto L13;
        return null;
    L13:
        return getWv3();
    L14:
        return getWv2();
    L11:
        return getWv1();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }
}
