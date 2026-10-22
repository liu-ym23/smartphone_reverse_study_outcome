package com.obric.assistant.interaction.impl.window;

import android.graphics.Rect;
import java.util.List;
import jba.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJE\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007¢\u0006\u0002\u0010\u0018J'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bJ3\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010#J.\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*JH\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\b\b\u0002\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u0007J\f\u00104\u001a\u000205*\u00020\u001aH\u0002J\f\u00106\u001a\u00020\u001a*\u000205H\u0002¨\u00067"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowHostLayoutCalculator;", "", "<init>", "()V", "resolveLayoutSpec", "Lcom/obric/assistant/interaction/impl/window/WindowHostLayoutSpec;", "orientation", "", "displayWidth", "displayHeight", "cutoutInsets", "Lcom/obric/assistant/interaction/impl/window/HorizontalCutoutInsets;", "landscapeRightMarginPx", "landscapeVerticalMarginPx", "consumedNavigationBarInsets", "Lcom/obric/assistant/interaction/impl/window/ConsumedNavigationBarInsets;", "resolveConsumedNavigationBarInsets", "navigationMode", "navigationBarsVisible", "", "navigationBarLeft", "navigationBarTop", "navigationBarRight", "navigationBarBottom", "(ILjava/lang/Integer;ZIIII)Lcom/obric/assistant/interaction/impl/window/ConsumedNavigationBarInsets;", "snapshot", "Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;", "(ILjava/lang/Integer;Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;)Lcom/obric/assistant/interaction/impl/window/ConsumedNavigationBarInsets;", "resolveStableNavigationBarInsetsSnapshot", "currentSnapshot", "previousSnapshot", "(ILjava/lang/Integer;Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;)Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;", "resolveNavigationMode", "secureNavigationMode", "resourceNavigationMode", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;", "resolveLegacyNavigationBarInsetsSnapshot", "systemWindowInsetLeft", "systemWindowInsetTop", "systemWindowInsetRight", "systemWindowInsetBottom", "source", "", "resolveHorizontalCutoutInsets", "sdkInt", "safeInsetLeft", "safeInsetRight", "boundingRects", "", "Landroid/graphics/Rect;", "boundsLeftInset", "boundsRightInset", "toSharedSnapshot", "Lcom/obric/assistant/activation/presentation/runtime/window/ObricNavigationBarInsetsSnapshot;", "toWindowHostSnapshot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHostLayoutCalculator {
    public static final WindowHostLayoutCalculator INSTANCE = null;

    static {
        INSTANCE = new WindowHostLayoutCalculator();
    }

    private WindowHostLayoutCalculator() {
    }

    public final Integer resolveNavigationMode(Integer r1, Integer r2) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return r2;
    }

    private final jba.f toSharedSnapshot(NavigationBarInsetsSnapshot r9) {
        return new jba.f(r9.getLeft(), r9.getTop(), r9.getRight(), r9.getBottom(), r9.getVisible(), r9.getSource());
    }

    private final NavigationBarInsetsSnapshot toWindowHostSnapshot(jba.f r9) {
        return new NavigationBarInsetsSnapshot(r9.a, r9.b, r9.c, r9.d, r9.e, r9.f);
    }

    public final ConsumedNavigationBarInsets resolveConsumedNavigationBarInsets(int r2, Integer r3, NavigationBarInsetsSnapshot r4) {
        int r0 = jba.d.a;
        if (r4 == null) goto L5;
        jba.f r5 = toSharedSnapshot(r4);
    L6:
        a r6 = jba.d.a(r2, r3, r5);
        return new ConsumedNavigationBarInsets(r6.a, r6.b);
    L5:
        r5 = null;
        goto L6
    }

    public final NavigationBarInsetsSnapshot resolveStableNavigationBarInsetsSnapshot(int r2, Integer r3, NavigationBarInsetsSnapshot r4, NavigationBarInsetsSnapshot r5) {
        int r0 = jba.d.a;
        if (r4 == null) goto L5;
        jba.f r6 = toSharedSnapshot(r4);
    L6:
        if (r5 == null) goto L8;
        jba.f r7 = toSharedSnapshot(r5);
    L9:
        jba.f r8 = jba.d.e(r2, r3, r6, r7);
        if (r8 != null) goto L12;
        return null;
    L12:
        return toWindowHostSnapshot(r8);
    L8:
        r7 = null;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    public final NavigationBarInsetsSnapshot resolveLegacyNavigationBarInsetsSnapshot(int r8, int r9, int r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "source");
        int r3 = RangesKt.coerceAtLeast(r10, 0);
        int r1 = RangesKt.coerceAtLeast(r8, 0);
        int r2 = RangesKt.coerceAtLeast(r9, 0);
        if (r3 <= 0) goto L5;
        boolean r5 = true;
    L7:
        return new NavigationBarInsetsSnapshot(r1, r2, r3, 0, r5, r12);
    L5:
        r5 = false;
        goto L7
    }

    public final ConsumedNavigationBarInsets resolveConsumedNavigationBarInsets(int r9, Integer r10, boolean r11, int r12, int r13, int r14, int r15) {
        return resolveConsumedNavigationBarInsets(r9, r10, new NavigationBarInsetsSnapshot(RangesKt.coerceAtLeast(r12, 0), RangesKt.coerceAtLeast(r13, 0), RangesKt.coerceAtLeast(r14, 0), RangesKt.coerceAtLeast(r15, 0), r11, "raw"));
    }

    public final HorizontalCutoutInsets resolveHorizontalCutoutInsets(int r2, int r3, int r4, int r5, List<Rect> r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "boundingRects");
        jba.b r9 = jba.d.c(r2, r3, r4, r5, r6, r7, r8);
        return new HorizontalCutoutInsets(r9.a, r9.b);
    }

    public final WindowHostLayoutSpec resolveLayoutSpec(int r9, int r10, int r11, HorizontalCutoutInsets r12, int r13, int r14, ConsumedNavigationBarInsets r15) {
        Intrinsics.checkNotNullParameter(r12, "cutoutInsets");
        Intrinsics.checkNotNullParameter(r15, "consumedNavigationBarInsets");
        int r0 = jba.d.a;
        jba.e r16 = jba.d.d(r9, r10, r11, new jba.b(r12.getLeft(), r12.getRight()), r13, r14, new a(r15.getRight(), r15.getBottom()));
        return new WindowHostLayoutSpec(r16.a, r16.b, r16.c, r16.d, r16.e, r16.f);
    }

    public static /* synthetic */ HorizontalCutoutInsets resolveHorizontalCutoutInsets$default(WindowHostLayoutCalculator r10, int r11, int r12, int r13, int r14, List r15, int r16, int r17, int r18, Object r19) {
        if ((r18 & 32) == 0) goto L5;
        int r8 = 0;
    L7:
        if ((r18 & 64) == 0) goto L9;
        int r9 = 0;
    L11:
        return r10.resolveHorizontalCutoutInsets(r11, r12, r13, r14, r15, r8, r9);
    L9:
        r9 = r17;
        goto L11
    L5:
        r8 = r16;
        goto L7
    }

    public static /* synthetic */ WindowHostLayoutSpec resolveLayoutSpec$default(WindowHostLayoutCalculator r10, int r11, int r12, int r13, HorizontalCutoutInsets r14, int r15, int r16, ConsumedNavigationBarInsets r17, int r18, Object r19) {
        if ((r18 & 16) == 0) goto L5;
        int r7 = 0;
    L7:
        if ((r18 & 32) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r18 & 64) == 0) goto L13;
        ConsumedNavigationBarInsets r9 = new ConsumedNavigationBarInsets(0, 0, 3, null);
    L15:
        return r10.resolveLayoutSpec(r11, r12, r13, r14, r7, r8, r9);
    L13:
        r9 = r17;
        goto L15
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }
}
