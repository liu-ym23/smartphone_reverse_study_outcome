package com.larus.avlink.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.video.VideoPlayView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0014J\u0006\u0010\u0013\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0018H\u0002J$\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¨\u0006\u001d"}, d2 = {"Lcom/larus/avlink/gallery/DoraGalleryVideoPlayView;", "Lcom/larus/common_ui/video/VideoPlayView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "updateEnterTransitionState", "", "running", "", "syncTransitionLayout", "containerWidth", "containerHeight", "onLoadCoverImageBefore", "setupCoverViewParams", "clearAndHideCoverView", "applyResolvedVideoDisplaySize", "width", "height", "calculateCoverSize", "Lkotlin/Pair;", "calculateDisplaySize", "applyCenteredLayout", "view", "Landroid/view/View;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraGalleryVideoPlayView extends VideoPlayView {
    public DoraGalleryVideoPlayView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DoraGalleryVideoPlayView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L() {
        if (getWidth() > 0) goto L5;
    L11:
        super.L();
        return;
    L5:
        if (getHeight() <= 0) goto L11;
        if (getMVideoAspectRatio() <= 0.0f) goto L11;
        Pair<Integer, Integer> r0 = R(getWidth(), getHeight());
        int r1 = ((Number) r0.component1()).intValue();
        int r2 = ((Number) r0.component2()).intValue();
        Q(getMCoverView(), r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u() {
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() > 0) goto L7;
        return;
    L7:
        if (getMVideoAspectRatio() <= 0.0f) goto L12;
        m();
        return;
    }

    public final Pair<Integer, Integer> R(int r8, int r9) {
        boolean r0 = true;
        int r10 = RangesKt.coerceAtLeast(r8, 1);
        int r11 = RangesKt.coerceAtLeast(r9, 1);
        float r1 = r10;
        float r2 = r11;
        float r3 = r1 / RangesKt.coerceAtLeast(r2, 1.0f);
        com.larus.common_ui.video.b r4 = getDisplayMode();
        if (r4 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == false) goto L14;
        if (getMVideoAspectRatio() < r3) goto L16;
        return TuplesKt.to(Integer.valueOf(r10), Integer.valueOf(MathKt.roundToInt(r1 / getMVideoAspectRatio())));
    L16:
        return TuplesKt.to(Integer.valueOf(MathKt.roundToInt(r2 * getMVideoAspectRatio())), Integer.valueOf(r11));
    L14:
        return TuplesKt.to(Integer.valueOf(r10), Integer.valueOf(MathKt.roundToInt(r1 / getMVideoAspectRatio())));
    L5:
        if (r4.c != 3) goto L7;
        goto L7
    }

    public final void S(int r3, int r4) {
        if (r3 <= 0) goto L18;
        if (r4 > 0) goto L5;
        return;
    L5:
        if (getMVideoAspectRatio() <= 0.0f) goto L20;
        com.larus.common_ui.video.b r0 = getDisplayMode();
        if (r0 != null) goto L10;
    L12:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L16;
        Q(getMVideoView(), -1, -1);
        Q(getMCoverView(), -1, -1);
        return;
    L16:
        Pair<Integer, Integer> r5 = R(r3, r4);
        int r6 = ((Number) r5.component1()).intValue();
        int r7 = ((Number) r5.component2()).intValue();
        Q(getMVideoView(), r6, r7);
        Q(getMCoverView(), r6, r7);
        return;
    L10:
        if (r0.c != 4) goto L12;
        r1 = true;
        goto L13
    L20:
        return;
    }

    public DoraGalleryVideoPlayView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public static void Q(View r2, int r3, int r4) {
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
    L6:
        if (r1 != null) goto L8;
        r1 = new FrameLayout.LayoutParams(r3, r4);
    L8:
        r1.width = r3;
        r1.height = r4;
        r1.gravity = 17;
        r2.setLayoutParams(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public /* synthetic */ DoraGalleryVideoPlayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
