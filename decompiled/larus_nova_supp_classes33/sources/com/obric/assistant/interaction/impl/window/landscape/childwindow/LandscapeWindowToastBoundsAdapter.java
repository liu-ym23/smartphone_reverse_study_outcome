package com.obric.assistant.interaction.impl.window.landscape.childwindow;

import android.graphics.Rect;
import android.view.WindowManager;
import com.obric.assistant.interaction.impl.window.WindowHost;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeWindowToastBoundsAdapter;", "", "<init>", "()V", "landscapeRestrictionActiveResolver", "Lkotlin/Function0;", "", "getLandscapeRestrictionActiveResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function0;", "setLandscapeRestrictionActiveResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function0;)V", "hostVisibleBoundsResolver", "Landroid/graphics/Rect;", "getHostVisibleBoundsResolver$impl_mainlandRelease", "setHostVisibleBoundsResolver$impl_mainlandRelease", "applyIfNeeded", "", "params", "Landroid/view/WindowManager$LayoutParams;", "applyIfNeeded$impl_mainlandRelease", "replaceHorizontalGravityPreservingVertical", "", "originalGravity", "horizontalGravity", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeWindowToastBoundsAdapter {
    public static final LandscapeWindowToastBoundsAdapter INSTANCE = null;
    private static Function0<Rect> hostVisibleBoundsResolver;
    private static Function0<Boolean> landscapeRestrictionActiveResolver;

    private LandscapeWindowToastBoundsAdapter() {
    }

    public static /* synthetic */ boolean a() {
        return landscapeRestrictionActiveResolver$lambda$0();
    }

    public static /* synthetic */ Rect b() {
        return hostVisibleBoundsResolver$lambda$1();
    }

    private final int replaceHorizontalGravityPreservingVertical(int r2, int r3) {
        return ((r2 & (-8)) & (-8388616)) | r3;
    }

    static {
        INSTANCE = new LandscapeWindowToastBoundsAdapter();
        landscapeRestrictionActiveResolver = new p();
        hostVisibleBoundsResolver = new q();
    }

    private static final Rect hostVisibleBoundsResolver$lambda$1() {
        return WindowHost.INSTANCE.getLandscapeWindowVisibleBounds$impl_mainlandRelease();
    }

    private static final boolean landscapeRestrictionActiveResolver$lambda$0() {
        return WindowHost.INSTANCE.isLandscapeRestrictionActive();
    }

    public final Function0<Rect> getHostVisibleBoundsResolver$impl_mainlandRelease() {
        return hostVisibleBoundsResolver;
    }

    public final Function0<Boolean> getLandscapeRestrictionActiveResolver$impl_mainlandRelease() {
        return landscapeRestrictionActiveResolver;
    }

    public final void applyIfNeeded$impl_mainlandRelease(WindowManager.LayoutParams r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (((Boolean) landscapeRestrictionActiveResolver.invoke()).booleanValue() == true) goto L7;
        return;
    L7:
        Rect r0 = (Rect) hostVisibleBoundsResolver.invoke();
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.isEmpty() == false) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == true) goto L18;
        r0 = null;
    L18:
        if (r0 == null) goto L23;
        r3.width = r0.width();
        r3.x = r0.left;
        r3.gravity = replaceHorizontalGravityPreservingVertical(r3.gravity, 3);
        return;
    L23:
        return;
    L12:
        if (r0.width() <= 0) goto L14;
        r1 = true;
        goto L15
    }

    public final void setHostVisibleBoundsResolver$impl_mainlandRelease(Function0<Rect> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        hostVisibleBoundsResolver = r2;
    }

    public final void setLandscapeRestrictionActiveResolver$impl_mainlandRelease(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        landscapeRestrictionActiveResolver = r2;
    }
}
