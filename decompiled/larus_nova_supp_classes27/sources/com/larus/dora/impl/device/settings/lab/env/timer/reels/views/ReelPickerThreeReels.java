package com.larus.dora.impl.device.settings.lab.env.timer.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t49.b;
import v49.c;
import v49.d;
import v49.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001,B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\u0018\u001a\u00020\u0019*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0014J0\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0014R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/ReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/ReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "wv1", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/WheelView;", "getWv1", "()Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/WheelView;", "wv1$delegate", "Lkotlin/Lazy;", "wv2", "getWv2", "wv2$delegate", "wv3", "getWv3", "wv3$delegate", "reelsCount", "configure", "", "reel", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/ReelPicker$Reel;", "colIndex", "maxColIndex", "asView", "Landroid/view/View;", "getReelView", "col", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "left", "top", "right", "bottom", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ReelPickerThreeReels extends ConstraintLayout {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
        public final int a;
        public final List<b> b;

        public a(int r1) {
            this.a = r1;
            this.b = new ArrayList();
        }

        public final void a(b r2) {
            Intrinsics.checkNotNullParameter(r2, "reel");
            ((ArrayList) this.b).add(r2);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.larus.dora.impl.device.settings.lab.env.timer.reels.views.ReelPickerThreeReels] */
        public final ReelPickerThreeReels b(Context r5, AttributeSet r6, int r7) {
            Intrinsics.checkNotNullParameter(r5, "context");
            ?? r0 = new ReelPickerThreeReels(r5, r6, r7);
            List<b> r8 = this.b;
            int r9 = ((ArrayList) r8).size();
            if (r9 != 0) goto L5;
        L11:
            r0.setLayoutParams(new LinearLayout.LayoutParams(-1, this.a));
            return r0;
        L5:
            if (r9 != 1) goto L7;
            ReelPickerThreeReels.R5(r0, ReelPickerThreeReels.S5(r0), (b) ListProtector.get(r8, 0), 0, 0);
            ReelPickerThreeReels.T5(r0).setVisibility(8);
            ReelPickerThreeReels.U5(r0).setVisibility(8);
            goto L11
        L7:
            if (r9 == 2) goto L9;
            ReelPickerThreeReels.R5(r0, ReelPickerThreeReels.S5(r0), (b) ListProtector.get(r8, 0), 0, 2);
            ReelPickerThreeReels.R5(r0, ReelPickerThreeReels.T5(r0), (b) ListProtector.get(r8, 1), 1, 2);
            ReelPickerThreeReels.R5(r0, ReelPickerThreeReels.U5(r0), (b) ListProtector.get(r8, 2), 2, 2);
            goto L11
        L9:
            ReelPickerThreeReels.R5(r0, ReelPickerThreeReels.S5(r0), (b) ListProtector.get(r8, 0), 0, 1);
            ReelPickerThreeReels.R5(r0, ReelPickerThreeReels.T5(r0), (b) ListProtector.get(r8, 1), 1, 1);
            ReelPickerThreeReels.U5(r0).setVisibility(8);
            goto L11
        }
    }

    public ReelPickerThreeReels(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ReelPickerThreeReels(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final WheelView getWv1() {
        return (WheelView) this.a.getValue();
    }

    private final WheelView getWv2() {
        return (WheelView) this.b.getValue();
    }

    private final WheelView getWv3() {
        return (WheelView) this.c.getValue();
    }

    public final WheelView V5() {
        return getWv1();
    }

    public static final /* synthetic */ WheelView S5(ReelPickerThreeReels r0) {
        return r0.getWv1();
    }

    public static final /* synthetic */ WheelView T5(ReelPickerThreeReels r0) {
        return r0.getWv2();
    }

    public static final /* synthetic */ WheelView U5(ReelPickerThreeReels r0) {
        return r0.getWv3();
    }

    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReelPickerThreeReels(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new v49.b(this));
        this.b = LazyKt.lazy(new c(this));
        this.c = LazyKt.lazy(new d(this));
        LayoutInflater.from(r2).inflate(2131562298, this);
    }

    public /* synthetic */ ReelPickerThreeReels(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final void R5(ReelPickerThreeReels r3, WheelView r4, b r5, int r6, int r7) {
        r4.setVisibility(0);
        CharSequence r0 = r5.c;
        if (r0 == null) goto L5;
        r4.setTagText(r0);
    L5:
        r4.setLayoutParams(new LinearLayout.LayoutParams(0, -1, r5.d));
        r4.setOnWheelChangedListener(new e(r5));
        r4.setEntries(r5.b);
        int r1 = r5.e;
        if (r1 < 0) goto L8;
        r4.b(Math.min(r1, r5.b.size() - 1), false);
    L8:
        if (r6 != 0) goto L10;
        r4.setShowTopLeftCorner(true);
        r4.setShowBottomLeftCorner(true);
    L10:
        if (1 > r6) goto L13;
        if (r6 >= r7) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L16;
        r4.setShowTopLeftCorner(false);
        r4.setShowBottomLeftCorner(false);
        r4.setShowTopRightCorner(false);
        r4.setShowBottomRightCorner(false);
    L16:
        if (r6 != r7) goto L19;
        r4.setShowTopRightCorner(true);
        r4.setShowBottomRightCorner(true);
        return;
    L19:
        return;
    L13:
        r8 = false;
        goto L14
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
