package com.obric.memorydata.memory.ui;

import android.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Rect;
import android.text.Selection;
import android.text.Spannable;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ba;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0007\u001a\u001a\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f\u001a\u0018\u0010\u0010\u001a\u00020\u0005*\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u0002*\u00020\u0015H\u0002\u001a\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u0015H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0011H\u0002\u001a\"\u0010\u0018\u001a\u00020\u0005*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0005*\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0002\u001a\u0016\u0010!\u001a\u00020\u0005*\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020\u000fH\u0007\u001a\u001e\u0010#\u001a\u0004\u0018\u00010$*\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000fH\u0002\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"hasVerticalOffset", "", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "isOverscrollActive", "snapToCurrentItem", "", "Landroidx/viewpager2/widget/ViewPager2;", "Lcom/obric/oui/viewpager2/widget/ViewPager2;", "addLeftButton", "Lcom/obric/oui/button/OButton;", "Lcom/obric/oui/titlebar/OCTitleBar;", "style", "", "stringId", "SELECTABLE_TEXT_TOUCH_TAG", "", "setupSelectableTextWithAutoDismiss", "Landroid/widget/TextView;", "parentScrollView", "Landroid/view/ViewGroup;", "findParentRecyclerView", "Landroid/view/View;", "findScrollContainer", "hasExpandedTextSelection", "forwardVerticalDragToParentScroll", "shouldForward", "Lkotlin/Function0;", "cancelCurrentTouch", "event", "Landroid/view/MotionEvent;", "offsetEventToAncestor", "child", "ancestor", "makeSelectableWithClickableSpan", LocationMonitorConst.TAG, "findClickableSpanAt", "Landroid/text/style/ClickableSpan;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class m {

    @Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"com/obric/memorydata/memory/ui/ViewExtKt$setupSelectableTextWithAutoDismiss$2", "Landroid/view/ActionMode$Callback;", "originalCallback", "Landroid/view/Window$Callback;", "actionMode", "Landroid/view/ActionMode;", "scrollContainer", "Landroid/view/ViewGroup;", "originalOverScrollMode", "", "Ljava/lang/Integer;", "bounceRecyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "finishSelectionPosted", "", "onCreateActionMode", "mode", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "guardAgainstSelectionBounce", "restoreSelectionBounce", "installTouchInterceptor", "uninstallTouchInterceptor", "finishSelection", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f11343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f11344b;
        final /* synthetic */ ViewGroup c;
        private Window.Callback d;
        private ActionMode e;
        private ViewGroup f;
        private Integer g;
        private RecyclerView h;
        private boolean i;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.m$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000o\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\b\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\r0\rH\u0096\u0001¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\r0\rH\u0096\u0001¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0010\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0014\u001a\u00020\u00032\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00032\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0018\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u0096\u0001J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u001b2\r\b\u0001\u0010\u001c\u001a\u00070\u001d¢\u0006\u0002\b\u001eH\u0096\u0001J\u0018\u0010\u001f\u001a\t\u0018\u00010 ¢\u0006\u0002\b\u001e2\u0006\u0010\t\u001a\u00020\u001bH\u0097\u0001J\t\u0010!\u001a\u00020\u0003H\u0096\u0001J \u0010\"\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u001b2\r\b\u0001\u0010\u001c\u001a\u00070#¢\u0006\u0002\b\u001eH\u0096\u0001J \u0010$\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u001b2\r\b\u0001\u0010\u001c\u001a\u00070\u001d¢\u0006\u0002\b\u001eH\u0096\u0001J \u0010%\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u001b2\r\b\u0001\u0010\u001c\u001a\u00070\u001d¢\u0006\u0002\b\u001eH\u0096\u0001J1\u0010&\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u001b2\u000f\b\u0001\u0010\u001c\u001a\t\u0018\u00010 ¢\u0006\u0002\b\u001e2\r\b\u0001\u0010'\u001a\u00070\u001d¢\u0006\u0002\b\u001eH\u0096\u0001J\t\u0010(\u001a\u00020\u0007H\u0096\u0001J\u001e\u0010(\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010)0)H\u0096\u0001¢\u0006\u0002\u0010*J\u001e\u0010+\u001a\u00020\u00032\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010,0,H\u0096\u0001¢\u0006\u0002\u0010-J\u0011\u0010.\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0096\u0001J%\u0010/\u001a\t\u0018\u00010\u0015¢\u0006\u0002\b\u001e2\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010000H\u0097\u0001¢\u0006\u0002\u00101J-\u0010/\u001a\t\u0018\u00010\u0015¢\u0006\u0002\b\u001e2\u000e\u0010\t\u001a\n \n*\u0004\u0018\u000100002\u0006\u0010\u001c\u001a\u00020\u001bH\u0097\u0001¢\u0006\u0002\u00102¨\u00063"}, d2 = {"com/obric/memorydata/memory/ui/ViewExtKt$setupSelectableTextWithAutoDismiss$2$installTouchInterceptor$1", "Landroid/view/Window$Callback;", "finishSelectionIfOutsideTextView", "", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "", "dispatchGenericMotionEvent", "p0", "kotlin.jvm.PlatformType", "(Landroid/view/MotionEvent;)Z", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "(Landroid/view/KeyEvent;)Z", "dispatchKeyShortcutEvent", "dispatchPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "(Landroid/view/accessibility/AccessibilityEvent;)Z", "dispatchTrackballEvent", "onActionModeFinished", "Landroid/view/ActionMode;", "(Landroid/view/ActionMode;)V", "onActionModeStarted", "onAttachedToWindow", "onContentChanged", "onCreatePanelMenu", "", "p1", "Landroid/view/Menu;", "Lkotlin/jvm/internal/EnhancedNullability;", "onCreatePanelView", "Landroid/view/View;", "onDetachedFromWindow", "onMenuItemSelected", "Landroid/view/MenuItem;", "onMenuOpened", "onPanelClosed", "onPreparePanel", "p2", "onSearchRequested", "Landroid/view/SearchEvent;", "(Landroid/view/SearchEvent;)Z", "onWindowAttributesChanged", "Landroid/view/WindowManager$LayoutParams;", "(Landroid/view/WindowManager$LayoutParams;)V", "onWindowFocusChanged", "onWindowStartingActionMode", "Landroid/view/ActionMode$Callback;", "(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;", "(Landroid/view/ActionMode$Callback;I)Landroid/view/ActionMode;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class WindowCallbackC0609a implements Window.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f11345a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TextView f11346b;
            private final /* synthetic */ Window.Callback c;

            WindowCallbackC0609a(a r1, TextView r2) {
                this.f11345a = r1;
                this.f11346b = r2;
                Window.Callback r3 = a.a(r1);
                Intrinsics.checkNotNull(r3);
                this.c = r3;
            }

            private final void a(MotionEvent r7) {
                Rect r0 = new Rect();
                this.f11346b.getGlobalVisibleRect(r0);
                if (r0.contains((int) r7.getRawX(), (int) r7.getRawY()) == false) goto L5;
                return;
            L5:
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SelectableTextTouch", "outside down, finish actionMode", false, 4, null);
                a.b(this.f11345a);
            }

            @Override // android.view.Window.Callback
            public boolean dispatchGenericMotionEvent(MotionEvent r1) {
                return this.c.dispatchGenericMotionEvent(r1);
            }

            @Override // android.view.Window.Callback
            public boolean dispatchKeyEvent(KeyEvent r1) {
                return this.c.dispatchKeyEvent(r1);
            }

            @Override // android.view.Window.Callback
            public boolean dispatchKeyShortcutEvent(KeyEvent r1) {
                return this.c.dispatchKeyShortcutEvent(r1);
            }

            @Override // android.view.Window.Callback
            public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
                return this.c.dispatchPopulateAccessibilityEvent(r1);
            }

            @Override // android.view.Window.Callback
            public boolean dispatchTouchEvent(MotionEvent r3) {
                Intrinsics.checkNotNullParameter(r3, "event");
                Window.Callback r0 = a.a(this.f11345a);
                if (r0 != null) goto L7;
                return false;
            L7:
                if (r3.getAction() != 0) goto L10;
                a(r3);
            L10:
                return r0.dispatchTouchEvent(r3);
            }

            @Override // android.view.Window.Callback
            public boolean dispatchTrackballEvent(MotionEvent r1) {
                return this.c.dispatchTrackballEvent(r1);
            }

            @Override // android.view.Window.Callback
            public void onActionModeFinished(ActionMode r1) {
                this.c.onActionModeFinished(r1);
            }

            @Override // android.view.Window.Callback
            public void onActionModeStarted(ActionMode r1) {
                this.c.onActionModeStarted(r1);
            }

            @Override // android.view.Window.Callback
            public void onAttachedToWindow() {
                this.c.onAttachedToWindow();
            }

            @Override // android.view.Window.Callback
            public void onContentChanged() {
                this.c.onContentChanged();
            }

            @Override // android.view.Window.Callback
            public boolean onCreatePanelMenu(int r3, Menu r4) {
                Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "p1");
                return this.c.onCreatePanelMenu(r3, r5);
            }

            @Override // android.view.Window.Callback
            public View onCreatePanelView(int r1) {
                return this.c.onCreatePanelView(r1);
            }

            @Override // android.view.Window.Callback
            public void onDetachedFromWindow() {
                this.c.onDetachedFromWindow();
            }

            @Override // android.view.Window.Callback
            public boolean onMenuItemSelected(int r3, MenuItem r4) {
                MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "p1");
                return this.c.onMenuItemSelected(r3, r5);
            }

            @Override // android.view.Window.Callback
            public boolean onMenuOpened(int r3, Menu r4) {
                Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "p1");
                return this.c.onMenuOpened(r3, r5);
            }

            @Override // android.view.Window.Callback
            public void onPanelClosed(int r3, Menu r4) {
                Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r5, "p1");
                this.c.onPanelClosed(r3, r5);
            }

            @Override // android.view.Window.Callback
            public boolean onPreparePanel(int r3, View r4, Menu r5) {
                Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r6, "p2");
                return this.c.onPreparePanel(r3, r4, r6);
            }

            @Override // android.view.Window.Callback
            public boolean onSearchRequested() {
                return this.c.onSearchRequested();
            }

            @Override // android.view.Window.Callback
            public boolean onSearchRequested(SearchEvent r1) {
                return this.c.onSearchRequested(r1);
            }

            @Override // android.view.Window.Callback
            public void onWindowAttributesChanged(WindowManager.LayoutParams r1) {
                this.c.onWindowAttributesChanged(r1);
            }

            @Override // android.view.Window.Callback
            public void onWindowFocusChanged(boolean r1) {
                this.c.onWindowFocusChanged(r1);
            }

            @Override // android.view.Window.Callback
            public ActionMode onWindowStartingActionMode(ActionMode.Callback r3) {
                ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.memorydata.plugin");
                return this.c.onWindowStartingActionMode(r4);
            }

            @Override // android.view.Window.Callback
            public ActionMode onWindowStartingActionMode(ActionMode.Callback r3, int r4) {
                ActionMode.Callback r5 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.memorydata.plugin");
                return this.c.onWindowStartingActionMode(r5, r4);
            }
        }

        a(Ref.BooleanRef r1, TextView r2, ViewGroup r3) {
            this.f11343a = r1;
            this.f11344b = r2;
            this.c = r3;
        }

        public static final /* synthetic */ Window.Callback a(a r0) {
            return r0.d;
        }

        private final void a() {
            ViewGroup r0 = this.c;
            Integer r2 = null;
            if (ZeusTransformUtils.instanceOf(r0, RecyclerView.class) == false) goto L5;
            RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r0, RecyclerView.class, "com.obric.memorydata.plugin");
        L6:
            if (r1 != null) goto L8;
            r1 = m.a((View) ZeusTransformUtils.preCheckCast(this.f11344b, View.class, "com.obric.memorydata.plugin"));
        L8:
            ViewGroup r3 = this.c;
            if (r3 != null) goto L13;
            if (r1 == null) goto L12;
            r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.memorydata.plugin");
            goto L13
        L12:
            r3 = m.b((View) ZeusTransformUtils.preCheckCast(this.f11344b, View.class, "com.obric.memorydata.plugin"));
        L13:
            this.f = r3;
            if (r3 == null) goto L16;
            r2 = Integer.valueOf(r3.getOverScrollMode());
        L16:
            this.g = r2;
            if (r3 == null) goto L19;
            r3.setOverScrollMode(2);
        L19:
            this.h = r1;
            if (r1 == null) goto L23;
            final TextView r4 = this.f11344b;
            r1.setOnBounceTranslationListener(new $$Lambda$m$a$ZaVTLAyezHz9O9wg22Yvja8KfRg(this, r4));
            return;
        L23:
            return;
        L5:
            r1 = null;
            goto L6
        }

        private static final void a(final a r1, TextView r2, float r3) {
            if (r3 != 0.0f) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == false) goto L8;
            return;
        L8:
            if (r1.i == true) goto L12;
            r1.i = true;
            r2.post(new $$Lambda$m$a$ePz6zmnZftHGOiu6TbZj5LyoPaM(r1));
            return;
        L12:
            return;
        L5:
            r4 = false;
            goto L6
        }

        private final void b() {
            RecyclerView r0 = this.h;
            if (r0 == null) goto L5;
            r0.setOnBounceTranslationListener(null);
        L5:
            this.h = null;
            this.i = false;
            ViewGroup r1 = this.f;
            Integer r2 = this.g;
            if (r1 == null) goto L9;
            if (r2 == null) goto L9;
            r1.setOverScrollMode(r2.intValue());
        L9:
            this.f = null;
            this.g = null;
        }

        public static final /* synthetic */ void b(a r0) {
            r0.e();
        }

        private final void c() {
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f11344b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
            Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L5;
            return;
        L5:
            Window r2 = ZeusTransformUtils.getWindow(r1, "com.obric.memorydata.plugin");
            this.d = r2.getCallback();
            r2.setCallback((Window.Callback) ZeusTransformUtils.preCheckCast(new WindowCallbackC0609a(this, this.f11344b), Window.Callback.class, "com.obric.memorydata.plugin"));
        }

        private static final void c(a r7) {
            r7.i = false;
            if (r7.e == null) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SelectableTextTouch", "bounce translation detected, finish actionMode", false, 4, null);
            r7.e();
            return;
        }

        private final void d() {
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f11344b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
            Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L5;
            return;
        L5:
            Window.Callback r2 = this.d;
            if (r2 == null) goto L8;
            ZeusTransformUtils.getWindow(r1, "com.obric.memorydata.plugin").setCallback(r2);
        L8:
            this.d = null;
        }

        private final void e() {
            ActionMode r0 = this.e;
            if (r0 == null) goto L5;
            r0.finish();
        L5:
            this.f11344b.clearFocus();
            CharSequence r2 = this.f11344b.getText();
            if (ZeusTransformUtils.instanceOf(r2, Spannable.class) == false) goto L8;
            Spannable r3 = (Spannable) ZeusTransformUtils.preCheckCast(r2, Spannable.class, "com.obric.memorydata.plugin");
        L9:
            if (r3 == null) goto L12;
            Selection.removeSelection(r3);
            return;
        L12:
            return;
        L8:
            r3 = null;
            goto L9
        }

        public static /* synthetic */ void lambda$ZaVTLAyezHz9O9wg22Yvja8KfRg(a r0, TextView r1, float r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$ePz6zmnZftHGOiu6TbZj5LyoPaM(a r0) {
            c(r0);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r5, MenuItem r6) {
            MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r6, MenuItem.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "mode");
            Intrinsics.checkNotNullParameter(r7, "item");
            if (k.f10970a.a(r7.getItemId(), R.id.copy) == true) goto L5;
            return false;
        L5:
            int r8 = this.f11344b.getSelectionStart();
            int r2 = this.f11344b.getSelectionEnd();
            if (r8 < 0) goto L13;
            if (r2 < 0) goto L13;
            if (r8 != r2) goto L11;
            return false;
        L11:
            CharSequence r9 = this.f11344b.getText().subSequence(Math.min(r8, r2), Math.max(r8, r2));
            Object r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f11344b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("clipboard");
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) ZeusTransformUtils.preCheckCast(r4, ClipboardManager.class, "com.obric.memorydata.plugin")).setPrimaryClip(ClipData.newPlainText(null, r9));
            r5.finish();
            return true;
        L13:
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "mode");
            Intrinsics.checkNotNullParameter(r5, "menu");
            this.f11343a.element = true;
            this.e = r3;
            a();
            c();
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r2) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            d();
            b();
            this.e = null;
            this.f11343a.element = false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r1, "menu");
            return true;
        }
    }

    public static final /* synthetic */ RecyclerView a(View r0) {
        return c(r0);
    }

    private static final void a(MotionEvent r2, View r3, View r4) {
        int[] r1 = new int[2];
        int[] r0 = new int[2];
        r3.getLocationOnScreen(r1);
        r4.getLocationOnScreen(r0);
        r2.offsetLocation(r1[0] - r0[0], r1[1] - r0[1]);
    }

    private static final void a(View r1, MotionEvent r2) {
        MotionEvent r3 = MotionEvent.obtain(r2);
        r3.setAction(3);
        r1.onTouchEvent(r3);
        r3.recycle();
    }

    public static final void a(final TextView r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.setTextIsSelectable(true);
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        if (r3 == null) goto L5;
        a(r2, r3, new $$Lambda$m$GlDAbZtQ5ry8RNXgssTZ6XytlaE(r0, r2));
    L5:
        r2.setCustomSelectionActionModeCallback((ActionMode.Callback) ZeusTransformUtils.preCheckCast(new a(r0, r2, r3), ActionMode.Callback.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void a(TextView r0, ViewGroup r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        a(r0, r1);
    }

    private static final void a(TextView r2, ViewGroup r3, MotionEvent r4, int r5) {
        MotionEvent r6 = MotionEvent.obtain(r4);
        r6.setAction(r5);
        Intrinsics.checkNotNull(r6);
        a(r6, (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        if (r5 != 0) goto L5;
    L7:
        r3.onInterceptTouchEvent(r6);
    L8:
        r3.onTouchEvent(r6);
        r6.recycle();
        return;
    L5:
        if (r5 == 2) goto L7;
        goto L7
    }

    private static final void a(final TextView r11, final ViewGroup r12, Function0<Boolean> r13) {
        final Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        final int r8 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        final Ref.FloatRef r3 = new Ref.FloatRef();
        final Ref.FloatRef r4 = new Ref.FloatRef();
        final Ref.BooleanRef r5 = new Ref.BooleanRef();
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        r11.setOnTouchListener(new $$Lambda$m$r4r12VZTymWiFPRyY4Bf1q9710Q(r3, r4, r5, r6, r7, r8, r11, r12));
    }

    public static final void a(ViewPager2 r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.getCurrentItem();
        View r2 = r5.getChildAt(0);
        if (ZeusTransformUtils.instanceOf(r2, androidx.recyclerview.widget.RecyclerView.class) == false) goto L5;
        androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) ZeusTransformUtils.preCheckCast(r2, androidx.recyclerview.widget.RecyclerView.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 == null) goto L8;
        r3.stopScroll();
        r3.scrollToPosition(r0);
    L8:
        r5.a(r0, false);
        return;
    L5:
        r3 = null;
        goto L6
    }

    private static final boolean a(TextView r1) {
        int r0 = r1.getSelectionStart();
        int r2 = r1.getSelectionEnd();
        if (r0 < 0) goto L7;
        if (r2 < 0) goto L7;
        if (r0 == r2) goto L7;
        return true;
    L7:
        return false;
    }

    public static final /* synthetic */ boolean a(RecyclerView r0) {
        return c(r0);
    }

    private static final boolean a(Ref.BooleanRef r0, TextView r1) {
        if (r0.element == false) goto L5;
    L7:
        return false;
    L5:
        if (a(r1) == true) goto L7;
        return true;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [T, android.view.MotionEvent] */
    private static final boolean a(Ref.FloatRef r5, Ref.FloatRef r6, Ref.BooleanRef r7, Ref.ObjectRef r8, Function0 r9, int r10, TextView r11, ViewGroup r12, View r13, MotionEvent r14) {
        Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        int r0 = r14.getActionMasked();
        if (r0 == 0) goto L32;
        if (r0 != 1) goto L6;
    L25:
        boolean r2 = r7.element;
        if (r7.element == false) goto L28;
        Intrinsics.checkNotNull(r14);
        a(r11, r12, r14, r14.getAction());
    L28:
        r7.element = false;
        MotionEvent r16 = (MotionEvent) ZeusTransformUtils.preCheckCast(r8.element, MotionEvent.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L31;
        r16.recycle();
    L31:
        r8.element = null;
        return r2;
    L6:
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L25;
        return r7.element;
    L11:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L14;
        return false;
    L14:
        if (r7.element == true) goto L23;
        float r17 = Math.abs(r14.getX() - r5.element);
        float r18 = Math.abs(r14.getY() - r6.element);
        if (r18 <= r10) goto L23;
        if (r18 <= r17) goto L23;
        r7.element = true;
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNull(r14);
        a(r13, r14);
        MotionEvent r19 = (MotionEvent) ZeusTransformUtils.preCheckCast(r8.element, MotionEvent.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L23;
        a(r11, r12, r19, 0);
    L23:
        if (r7.element == false) goto L37;
        Intrinsics.checkNotNull(r14);
        a(r11, r12, r14, r14.getAction());
        return true;
    L37:
        return false;
    L32:
        r5.element = r14.getX();
        r6.element = r14.getY();
        r7.element = false;
        MotionEvent r20 = (MotionEvent) ZeusTransformUtils.preCheckCast(r8.element, MotionEvent.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L35;
        r20.recycle();
    L35:
        r8.element = MotionEvent.obtain(r14);
        goto L37
    }

    public static final /* synthetic */ ViewGroup b(View r0) {
        return d(r0);
    }

    public static final /* synthetic */ boolean b(RecyclerView r0) {
        return d(r0);
    }

    private static final RecyclerView c(View r2) {
        ViewParent r3 = r2.getParent();
    L4:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, RecyclerView.class) == true) goto L8;
        r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin")).getParent();
        goto L4
    L8:
        return (RecyclerView) ZeusTransformUtils.preCheckCast(r3, RecyclerView.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    }

    private static final boolean c(RecyclerView r0) {
        if (r0.computeVerticalScrollOffset() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final ViewGroup d(View r2) {
        ViewParent r3 = r2.getParent();
    L4:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L10;
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin")).isScrollContainer() == true) goto L8;
        r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin")).getParent();
        goto L4
    L8:
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    }

    private static final boolean d(RecyclerView r1) {
        if (r1.getTranslationY() != 0.0f) goto L5;
        boolean r2 = true;
    L7:
        return !r2;
    L5:
        r2 = false;
        goto L7
    }

    public static /* synthetic */ boolean lambda$GlDAbZtQ5ry8RNXgssTZ6XytlaE(Ref.BooleanRef r0, TextView r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$r4r12VZTymWiFPRyY4Bf1q9710Q(Ref.FloatRef r0, Ref.FloatRef r1, Ref.BooleanRef r2, Ref.ObjectRef r3, Function0 r4, int r5, TextView r6, ViewGroup r7, View r8, MotionEvent r9) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
