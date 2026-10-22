package com.obric.assistant.interaction.impl.window.landscape.childwindow;

import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001;B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010%\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0002J(\u0010&\u001a\u0004\u0018\u00010'2\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00182\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J(\u0010+\u001a\u0004\u0018\u00010'2\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010,\u001a\u0004\u0018\u00010\u00182\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u0012\u0010-\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010.\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010/\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00100\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00101\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00102\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00103\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00104\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00105\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00106\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00107\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u00108\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0007J\r\u00109\u001a\u00020\"H\u0000¢\u0006\u0002\b:R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006<"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildPopupWindowBoundsAdapter;", "", "<init>", "()V", "rewrittenPopups", "Ljava/util/WeakHashMap;", "Landroid/widget/PopupWindow;", "", "directCenteredPopups", "pendingDropdownRewritePopups", "showAtLocationBypassPopup", "Ljava/lang/ThreadLocal;", "directUpdateBypassPopup", "landscapeRestrictionActiveResolver", "Lkotlin/Function0;", "getLandscapeRestrictionActiveResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function0;", "setLandscapeRestrictionActiveResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function0;)V", "windowTokenResolver", "Landroid/os/IBinder;", "getWindowTokenResolver$impl_mainlandRelease", "setWindowTokenResolver$impl_mainlandRelease", "decorViewResolver", "Landroid/view/View;", "getDecorViewResolver$impl_mainlandRelease", "setDecorViewResolver$impl_mainlandRelease", "viewWindowTokenResolver", "Lkotlin/Function1;", "getViewWindowTokenResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setViewWindowTokenResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "markNextDropdownRewrite", "", "popupWindow", "hasPendingDropdownRewrite", "consumePendingDropdownRewrite", "resolveRewriteDecision", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildPopupWindowBoundsAdapter$RewriteDecision;", "anchor", "source", "Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "resolveDirectShowAtLocationDecision", "parent", "markRewriteSucceeded", "hasRewriteSucceeded", "markDirectCenterManaged", "clearDirectCenterManaged", "isDirectCenterManaged", "shouldRewriteDirectCenteredUpdate", "beginShowAtLocationBypass", "endShowAtLocationBypass", "isShowAtLocationBypassTarget", "beginDirectUpdateBypass", "endDirectUpdateBypass", "isDirectUpdateBypassTarget", "clearForTest", "clearForTest$impl_mainlandRelease", "RewriteDecision", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeChildPopupWindowBoundsAdapter {
    public static final LandscapeChildPopupWindowBoundsAdapter INSTANCE = null;
    private static Function0<? extends View> decorViewResolver;
    private static final WeakHashMap<PopupWindow, Boolean> directCenteredPopups = null;
    private static final ThreadLocal<PopupWindow> directUpdateBypassPopup = null;
    private static Function0<Boolean> landscapeRestrictionActiveResolver;
    private static final WeakHashMap<PopupWindow, Boolean> pendingDropdownRewritePopups = null;
    private static final WeakHashMap<PopupWindow, Boolean> rewrittenPopups = null;
    private static final ThreadLocal<PopupWindow> showAtLocationBypassPopup = null;
    private static Function1<? super View, ? extends IBinder> viewWindowTokenResolver;
    private static Function0<? extends IBinder> windowTokenResolver;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildPopupWindowBoundsAdapter$RewriteDecision;", "", "parent", "Landroid/view/View;", "gravity", "", "x", "y", "<init>", "(Landroid/view/View;III)V", "getParent", "()Landroid/view/View;", "getGravity", "()I", "getX", "getY", "component1", "component2", "component3", "component4", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RewriteDecision {
        private final int gravity;
        private final View parent;
        private final int x;
        private final int y;

        public static /* synthetic */ RewriteDecision copy$default(RewriteDecision r0, View r1, int r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.parent;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.gravity;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.x;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.y;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final View component1() {
            return this.parent;
        }

        public final int component2() {
            return this.gravity;
        }

        public final int component3() {
            return this.x;
        }

        public final int component4() {
            return this.y;
        }

        public final RewriteDecision copy(View r2, int r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            return new RewriteDecision(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof RewriteDecision) == true) goto L8;
            return false;
        L8:
            RewriteDecision r6 = (RewriteDecision) r5;
            if (Intrinsics.areEqual(this.parent, r6.parent) == true) goto L12;
            return false;
        L12:
            if (this.gravity == r6.gravity) goto L15;
            return false;
        L15:
            if (this.x == r6.x) goto L18;
            return false;
        L18:
            if (this.y == r6.y) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.parent.hashCode() * 31) + this.gravity) * 31) + this.x) * 31) + this.y;
        }

        public String toString() {
            return "RewriteDecision(parent=" + this.parent + ", gravity=" + this.gravity + ", x=" + this.x + ", y=" + this.y + ')';
        }

        public final int getGravity() {
            return this.gravity;
        }

        public final View getParent() {
            return this.parent;
        }

        public final int getX() {
            return this.x;
        }

        public final int getY() {
            return this.y;
        }

        public RewriteDecision(View r2, int r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            this.parent = r2;
            this.gravity = r3;
            this.x = r4;
            this.y = r5;
        }
    }

    private LandscapeChildPopupWindowBoundsAdapter() {
    }

    public static /* synthetic */ boolean a() {
        return landscapeRestrictionActiveResolver$lambda$0();
    }

    public static /* synthetic */ View b() {
        return decorViewResolver$lambda$2();
    }

    public static /* synthetic */ IBinder c(View r0) {
        return viewWindowTokenResolver$lambda$3(r0);
    }

    public static /* synthetic */ IBinder d() {
        return windowTokenResolver$lambda$1();
    }

    @JvmStatic
    public static final RewriteDecision resolveDirectShowAtLocationDecision(PopupWindow r0, View r1, OverlaySource r2) {
        return null;
    }

    static {
        INSTANCE = new LandscapeChildPopupWindowBoundsAdapter();
        rewrittenPopups = new WeakHashMap();
        directCenteredPopups = new WeakHashMap();
        pendingDropdownRewritePopups = new WeakHashMap();
        showAtLocationBypassPopup = new ThreadLocal();
        directUpdateBypassPopup = new ThreadLocal();
        landscapeRestrictionActiveResolver = new l();
        windowTokenResolver = new m();
        decorViewResolver = new n();
        viewWindowTokenResolver = new o();
    }

    private static final View decorViewResolver$lambda$2() {
        return WindowHost.INSTANCE.getDecorView();
    }

    private static final boolean landscapeRestrictionActiveResolver$lambda$0() {
        return WindowHost.INSTANCE.isLandscapeRestrictionActive();
    }

    private static final IBinder windowTokenResolver$lambda$1() {
        return WindowHost.INSTANCE.getWindowToken();
    }

    public final void clearForTest$impl_mainlandRelease() {
        rewrittenPopups.clear();
        directCenteredPopups.clear();
        pendingDropdownRewritePopups.clear();
        showAtLocationBypassPopup.remove();
        directUpdateBypassPopup.remove();
    }

    public final Function0<View> getDecorViewResolver$impl_mainlandRelease() {
        return decorViewResolver;
    }

    public final Function0<Boolean> getLandscapeRestrictionActiveResolver$impl_mainlandRelease() {
        return landscapeRestrictionActiveResolver;
    }

    public final Function1<View, IBinder> getViewWindowTokenResolver$impl_mainlandRelease() {
        return viewWindowTokenResolver;
    }

    public final Function0<IBinder> getWindowTokenResolver$impl_mainlandRelease() {
        return windowTokenResolver;
    }

    @JvmStatic
    public static final void beginDirectUpdateBypass(PopupWindow r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        directUpdateBypassPopup.set(r1);
    }

    @JvmStatic
    public static final void beginShowAtLocationBypass(PopupWindow r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        showAtLocationBypassPopup.set(r1);
    }

    @JvmStatic
    public static final void clearDirectCenterManaged(PopupWindow r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        directCenteredPopups.remove(r1);
    }

    private final boolean consumePendingDropdownRewrite(PopupWindow r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (pendingDropdownRewritePopups.remove(r3) == null) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final void endDirectUpdateBypass(PopupWindow r2) {
        ThreadLocal<PopupWindow> r0 = directUpdateBypassPopup;
        PopupWindow r1 = r0.get();
        if (r1 == null) goto L5;
        if (r1 == r2) goto L5;
        return;
    L5:
        r0.remove();
    }

    @JvmStatic
    public static final void endShowAtLocationBypass(PopupWindow r2) {
        ThreadLocal<PopupWindow> r0 = showAtLocationBypassPopup;
        PopupWindow r1 = r0.get();
        if (r1 == null) goto L5;
        if (r1 == r2) goto L5;
        return;
    L5:
        r0.remove();
    }

    @JvmStatic
    public static final boolean hasPendingDropdownRewrite(PopupWindow r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return pendingDropdownRewritePopups.containsKey(r1);
    }

    @JvmStatic
    public static final boolean hasRewriteSucceeded(PopupWindow r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return rewrittenPopups.containsKey(r1);
    }

    @JvmStatic
    public static final boolean isDirectCenterManaged(PopupWindow r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        WeakHashMap<PopupWindow, Boolean> r1 = directCenteredPopups;
        if (r1.containsKey(r3) == true) goto L9;
        return false;
    L9:
        if (r3.isShowing() == true) goto L12;
        r1.remove(r3);
        return false;
    L12:
        return true;
    }

    @JvmStatic
    public static final boolean isDirectUpdateBypassTarget(PopupWindow r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (directUpdateBypassPopup.get() != r2) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean isShowAtLocationBypassTarget(PopupWindow r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (showAtLocationBypassPopup.get() != r2) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final void markDirectCenterManaged(PopupWindow r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isShowing() == false) goto L8;
        directCenteredPopups.put(r2, Boolean.TRUE);
        return;
    }

    @JvmStatic
    public static final void markNextDropdownRewrite(PopupWindow r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        pendingDropdownRewritePopups.put(r2, Boolean.TRUE);
    }

    @JvmStatic
    public static final void markRewriteSucceeded(PopupWindow r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        rewrittenPopups.put(r2, Boolean.TRUE);
    }

    @JvmStatic
    public static final boolean shouldRewriteDirectCenteredUpdate(PopupWindow r2) {
        if (isDirectCenterManaged(r2) == true) goto L6;
        return false;
    L6:
        if (((Boolean) landscapeRestrictionActiveResolver.invoke()).booleanValue() == true) goto L9;
        clearDirectCenterManaged(r2);
        return false;
    L9:
        return true;
    }

    private static final IBinder viewWindowTokenResolver$lambda$3(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        return r1.getWindowToken();
    }

    public final void setDecorViewResolver$impl_mainlandRelease(Function0<? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        decorViewResolver = r2;
    }

    public final void setLandscapeRestrictionActiveResolver$impl_mainlandRelease(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        landscapeRestrictionActiveResolver = r2;
    }

    public final void setViewWindowTokenResolver$impl_mainlandRelease(Function1<? super View, ? extends IBinder> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        viewWindowTokenResolver = r2;
    }

    public final void setWindowTokenResolver$impl_mainlandRelease(Function0<? extends IBinder> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        windowTokenResolver = r2;
    }

    @JvmStatic
    public static final RewriteDecision resolveRewriteDecision(PopupWindow r2, View r3, OverlaySource r4) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (INSTANCE.consumePendingDropdownRewrite(r2) == true) goto L8;
        return null;
    L8:
        if (r3 != null) goto L11;
        return null;
    L11:
        if (r4 == OverlaySource.WINDOW) goto L14;
        return null;
    L14:
        if (((Boolean) landscapeRestrictionActiveResolver.invoke()).booleanValue() == true) goto L17;
        return null;
    L17:
        if (r2.isShowing() == false) goto L20;
        return null;
    L20:
        if (hasRewriteSucceeded(r2) == false) goto L22;
        return null;
    L22:
        IBinder r5 = (IBinder) windowTokenResolver.invoke();
        if (r5 != null) goto L26;
        return null;
    L26:
        if (viewWindowTokenResolver.invoke(r3) == r5) goto L28;
        return null;
    L28:
        View r6 = (View) decorViewResolver.invoke();
        if (r6 != null) goto L32;
        return null;
    L32:
        if (viewWindowTokenResolver.invoke(r6) == r5) goto L35;
        return null;
    L35:
        return new RewriteDecision(r6, 17, 0, 0);
    }
}
