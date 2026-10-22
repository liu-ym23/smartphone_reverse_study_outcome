package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0007\u001a\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG", "", "setupSelectableText", "", "Landroid/widget/TextView;", "findClickableSpanAt", "Landroid/text/style/ClickableSpan;", "event", "Landroid/view/MotionEvent;", "markdown_lite_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"TextViewExtKt$setupSelectableText$2", "Landroid/view/ActionMode$Callback;", "originalCallback", "Landroid/view/Window$Callback;", "actionMode", "Landroid/view/ActionMode;", "onCreateActionMode", "", "mode", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "installTouchInterceptor", "uninstallTouchInterceptor", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f16371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Window.Callback f16372b;
        private ActionMode c;

        /* JADX INFO: renamed from: g$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000o\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\b\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\r0\rH\u0096\u0001¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\r0\rH\u0096\u0001¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0010\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0014\u001a\u00020\u00032\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00032\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0018\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u0096\u0001J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u001b2\r\b\u0001\u0010\u001c\u001a\u00070\u001d¢\u0006\u0002\b\u001eH\u0096\u0001J\u0018\u0010\u001f\u001a\t\u0018\u00010 ¢\u0006\u0002\b\u001e2\u0006\u0010\t\u001a\u00020\u001bH\u0097\u0001J\t\u0010!\u001a\u00020\u0003H\u0096\u0001J \u0010\"\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u001b2\r\b\u0001\u0010\u001c\u001a\u00070#¢\u0006\u0002\b\u001eH\u0096\u0001J \u0010$\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u001b2\r\b\u0001\u0010\u001c\u001a\u00070\u001d¢\u0006\u0002\b\u001eH\u0096\u0001J \u0010%\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u001b2\r\b\u0001\u0010\u001c\u001a\u00070\u001d¢\u0006\u0002\b\u001eH\u0096\u0001J1\u0010&\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u001b2\u000f\b\u0001\u0010\u001c\u001a\t\u0018\u00010 ¢\u0006\u0002\b\u001e2\r\b\u0001\u0010'\u001a\u00070\u001d¢\u0006\u0002\b\u001eH\u0096\u0001J\t\u0010(\u001a\u00020\u0007H\u0096\u0001J\u001e\u0010(\u001a\u00020\u00072\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010)0)H\u0096\u0001¢\u0006\u0002\u0010*J\u001e\u0010+\u001a\u00020\u00032\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010,0,H\u0096\u0001¢\u0006\u0002\u0010-J\u0011\u0010.\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0096\u0001J%\u0010/\u001a\t\u0018\u00010\u0015¢\u0006\u0002\b\u001e2\u000e\u0010\t\u001a\n \n*\u0004\u0018\u00010000H\u0097\u0001¢\u0006\u0002\u00101J-\u0010/\u001a\t\u0018\u00010\u0015¢\u0006\u0002\b\u001e2\u000e\u0010\t\u001a\n \n*\u0004\u0018\u000100002\u0006\u0010\u001c\u001a\u00020\u001bH\u0097\u0001¢\u0006\u0002\u00102¨\u00063"}, d2 = {"TextViewExtKt$setupSelectableText$2$installTouchInterceptor$1", "Landroid/view/Window$Callback;", "finishSelectionIfOutsideTextView", "", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "", "dispatchGenericMotionEvent", "p0", "kotlin.jvm.PlatformType", "(Landroid/view/MotionEvent;)Z", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "(Landroid/view/KeyEvent;)Z", "dispatchKeyShortcutEvent", "dispatchPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "(Landroid/view/accessibility/AccessibilityEvent;)Z", "dispatchTrackballEvent", "onActionModeFinished", "Landroid/view/ActionMode;", "(Landroid/view/ActionMode;)V", "onActionModeStarted", "onAttachedToWindow", "onContentChanged", "onCreatePanelMenu", "", "p1", "Landroid/view/Menu;", "Lkotlin/jvm/internal/EnhancedNullability;", "onCreatePanelView", "Landroid/view/View;", "onDetachedFromWindow", "onMenuItemSelected", "Landroid/view/MenuItem;", "onMenuOpened", "onPanelClosed", "onPreparePanel", "p2", "onSearchRequested", "Landroid/view/SearchEvent;", "(Landroid/view/SearchEvent;)Z", "onWindowAttributesChanged", "Landroid/view/WindowManager$LayoutParams;", "(Landroid/view/WindowManager$LayoutParams;)V", "onWindowFocusChanged", "onWindowStartingActionMode", "Landroid/view/ActionMode$Callback;", "(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;", "(Landroid/view/ActionMode$Callback;I)Landroid/view/ActionMode;", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class WindowCallbackC0854a implements Window.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f16373a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TextView f16374b;
            private final /* synthetic */ Window.Callback c;

            WindowCallbackC0854a(a r1, TextView r2) {
                this.f16373a = r1;
                this.f16374b = r2;
                Window.Callback r3 = a.a(r1);
                Intrinsics.checkNotNull(r3);
                this.c = r3;
            }

            private final void a(MotionEvent r9) {
                Rect r0 = new Rect();
                this.f16374b.getGlobalVisibleRect(r0);
                if (r0.contains((int) r9.getRawX(), (int) r9.getRawY()) == false) goto L5;
                return;
            L5:
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SelectableTextView", "outside down, finish actionMode", false, 4, null);
                ActionMode r10 = a.b(this.f16373a);
                if (r10 == null) goto L8;
                r10.finish();
            L8:
                this.f16374b.clearFocus();
                CharSequence r8 = this.f16374b.getText();
                if (ZeusTransformUtils.instanceOf(r8, Spannable.class) == false) goto L11;
                Spannable r11 = (Spannable) ZeusTransformUtils.preCheckCast(r8, Spannable.class, "com.obric.memorydata.plugin");
            L12:
                if (r11 == null) goto L15;
                Selection.removeSelection(r11);
                return;
            L15:
                return;
            L11:
                r11 = null;
                goto L12
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
                Window.Callback r0 = a.a(this.f16373a);
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

        a(TextView r1) {
            this.f16371a = r1;
        }

        public static final /* synthetic */ Window.Callback a(a r0) {
            return r0.f16372b;
        }

        private final void a() {
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f16371a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
            Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L5;
            return;
        L5:
            Window r2 = ZeusTransformUtils.getWindow(r1, "com.obric.memorydata.plugin");
            this.f16372b = r2.getCallback();
            r2.setCallback((Window.Callback) ZeusTransformUtils.preCheckCast(new WindowCallbackC0854a(this, this.f16371a), Window.Callback.class, "com.obric.memorydata.plugin"));
        }

        public static final /* synthetic */ ActionMode b(a r0) {
            return r0.c;
        }

        private final void b() {
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f16371a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
            Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L5;
            return;
        L5:
            Window.Callback r2 = this.f16372b;
            if (r2 == null) goto L8;
            ZeusTransformUtils.getWindow(r1, "com.obric.memorydata.plugin").setCallback(r2);
        L8:
            this.f16372b = null;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
            MenuItem r1 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r1, "item");
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "mode");
            Intrinsics.checkNotNullParameter(r5, "menu");
            this.c = r3;
            a();
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r2) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            b();
            this.c = null;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            Menu r1 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r1, "menu");
            return true;
        }
    }

    private static final ClickableSpan a(TextView r6, MotionEvent r7) {
        CharSequence r0 = r6.getText();
        if (ZeusTransformUtils.instanceOf(r0, Spannable.class) == false) goto L5;
        Spannable r1 = (Spannable) ZeusTransformUtils.preCheckCast(r0, Spannable.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        Layout r2 = r6.getLayout();
        if (r2 != null) goto L11;
        return null;
    L11:
        int r4 = (int) ((r7.getX() - r6.getTotalPaddingLeft()) + r6.getScrollX());
        int r8 = r2.getLineForVertical((int) ((r7.getY() - r6.getTotalPaddingTop()) + r6.getScrollY()));
        float r9 = r4;
        int r5 = r2.getOffsetForHorizontal(r8, r9);
        if (r9 >= r2.getLineLeft(r8)) goto L14;
    L18:
        return null;
    L14:
        if (r9 > r2.getLineRight(r8)) goto L18;
        Object[] r10 = r1.getSpans(r5, r5, ClickableSpan.class);
        Intrinsics.checkNotNullExpressionValue(r10, "getSpans(...)");
        return (ClickableSpan) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r10), ClickableSpan.class, "com.obric.memorydata.plugin");
    L5:
        r1 = null;
        goto L6
    }

    private static final Unit a(final Ref.ObjectRef r4, final TextView r5, final Ref.BooleanRef r6) {
        final MotionEvent r0 = (MotionEvent) ZeusTransformUtils.preCheckCast(r4.element, MotionEvent.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r5.postDelayed(new $$Lambda$g$NmnYYVjrnRb8DpammWF9fs6Um3k(r5, r0, r4, r6), 50);
    L6:
        return Unit.INSTANCE;
    }

    public static final void a(final TextView r23) {
        Intrinsics.checkNotNullParameter(r23, "<this>");
        r23.setTextIsSelectable(true);
        final int r12 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        final long r10 = ViewConfiguration.getLongPressTimeout();
        final Ref.FloatRef r9 = new Ref.FloatRef();
        final Ref.FloatRef r15 = new Ref.FloatRef();
        final Ref.LongRef r16 = new Ref.LongRef();
        final Ref.ObjectRef r17 = new Ref.ObjectRef();
        final Ref.BooleanRef r8 = new Ref.BooleanRef();
        final Ref.BooleanRef r18 = new Ref.BooleanRef();
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        final $$Lambda$g$JN9kPfnWMbmqktWgsAPXFnyfC0 r19 = new $$Lambda$g$JN9kPfnWMbmqktWgsAPXFnyfC0(r17, r8, r18, r7, r23, r9, r15, new $$Lambda$g$5plmpSbU92V2X8sQPgk5V2POeUE(r7, r23, r8));
        r23.setOnTouchListener(new $$Lambda$g$TIoWNeVxukunjyPUr6jQbPmkTvU(r9, r15, r16, r17, r8, r18, r7, r23, r19, r10, r12));
        r23.setCustomSelectionActionModeCallback((ActionMode.Callback) ZeusTransformUtils.preCheckCast(new a(r23), ActionMode.Callback.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(TextView r0, MotionEvent r1, Ref.ObjectRef r2, Ref.BooleanRef r3) {
        r0.onTouchEvent(r1);
        r1.recycle();
        r2.element = null;
        r0.postDelayed(new $$Lambda$g$4vTpCR6frM2_TZWZP67rBcxxYGw(r3, r0), 100);
    }

    private static final void a(TextView r6, Ref.BooleanRef r7, Function0 r8) {
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Method r2 = TextView.class.getDeclaredMethod("startSelectionActionMode", new Class[0]);     // Catch: Exception -> L5
        r2.setAccessible(true);     // Catch: Exception -> L5
        r2.invoke(r6, new Object[0]);     // Catch: Exception -> L5
    L7:
        r7.element = true;
        r9.invoke();
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("SelectableTextView", "[TouchListener] startSelectionActionMode 失败", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    private static final void a(Ref.BooleanRef r0, TextView r1) {
        if (r0.element == false) goto L6;
        a(r1);
        return;
    }

    private static final void a(Ref.ObjectRef r15, final Ref.BooleanRef r16, final Ref.BooleanRef r17, final Ref.ObjectRef r18, final TextView r19, Ref.FloatRef r20, Ref.FloatRef r21, Function0 r22) {
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r22, Function0.class, "com.obric.memorydata.plugin");
        r15.element = null;
        r16.element = true;
        r17.element = false;
        MotionEvent r5 = (MotionEvent) ZeusTransformUtils.preCheckCast(r18.element, MotionEvent.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        r5.recycle();
    L5:
        r18.element = null;
        r19.setOnTouchListener(null);
        long r9 = System.currentTimeMillis();
        MotionEvent r6 = MotionEvent.obtain(r9, r9, 0, r20.element, r21.element, 0);
        r19.onTouchEvent(r6);
        r6.recycle();
        r19.setOnTouchListener(new $$Lambda$g$jmsyk98oL3u6DOOyPjvsDnVb28(r19, r17, r18, r16));
        r19.postDelayed(new $$Lambda$g$usKq84sbYATFl3fy7TP9Gr8T6U(r19, r17, r4), 20);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, android.view.MotionEvent] */
    private static final boolean a(final TextView r4, Ref.BooleanRef r5, Ref.ObjectRef r6, final Ref.BooleanRef r7, View r8, MotionEvent r9) {
        int r10 = r9.getAction();
        if (r10 == 1) goto L16;
        if (r10 != 2) goto L7;
    L14:
        r4.onTouchEvent(r9);
    L22:
        return true;
    L7:
        if (r10 != 3) goto L14;
        r4.onTouchEvent(r9);
        MotionEvent r11 = (MotionEvent) ZeusTransformUtils.preCheckCast(r6.element, MotionEvent.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L12;
        r11.recycle();
    L12:
        r6.element = null;
        Runnable r12 = new $$Lambda$g$NFitCGeARaziAziawMJBYS968oA(r7, r4);
    L13:
        r4.postDelayed(r12, 100);
        goto L22
    L16:
        if (r5.element == false) goto L18;
        r4.onTouchEvent(r9);
        r12 = new $$Lambda$g$WEA7RBBYfe5hPvzCwN95kkFWDLA(r7, r4);
        goto L13
    L18:
        MotionEvent r13 = (MotionEvent) ZeusTransformUtils.preCheckCast(r6.element, MotionEvent.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L21;
        r13.recycle();
    L21:
        r6.element = MotionEvent.obtain(r9);
        goto L22
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, android.text.style.ClickableSpan] */
    private static final boolean a(Ref.FloatRef r16, Ref.FloatRef r17, Ref.LongRef r18, Ref.ObjectRef r19, Ref.BooleanRef r20, Ref.BooleanRef r21, Ref.ObjectRef r22, TextView r23, Runnable r24, long r25, int r27, View r28, MotionEvent r29) {
        Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r24, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type android.widget.TextView");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r28, TextView.class, "com.obric.memorydata.plugin");
        CharSequence r11 = r8.getText();
        if (ZeusTransformUtils.instanceOf(r11, Spannable.class) == false) goto L5;
        Spannable r12 = (Spannable) ZeusTransformUtils.preCheckCast(r11, Spannable.class, "com.obric.memorydata.plugin");
    L6:
        int r13 = r29.getAction();
        if (r13 == 0) goto L44;
        if (r13 != 1) goto L10;
        r23.getHandler().removeCallbacks(r9);
        long r14 = System.currentTimeMillis() - r18.element;
        float r0 = Math.abs(r29.getX() - r16.element);
        float r1 = Math.abs(r29.getY() - r17.element);
        if (r19.element != 0) goto L29;
    L35:
        boolean r2 = false;
    L36:
        if (r2 == false) goto L43;
        ClickableSpan r3 = (ClickableSpan) ZeusTransformUtils.preCheckCast(r19.element, ClickableSpan.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L40;
        r3.onClick((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
    L40:
        r19.element = null;
        return true;
    L43:
        r19.element = null;
        return false;
    L29:
        if (r14 >= r25) goto L35;
        float r4 = r27;
        if (r0 >= r4) goto L35;
        if (r1 >= r4) goto L35;
        r2 = true;
        goto L36
    L10:
        if (r13 == 2) goto L17;
        if (r13 != 3) goto L61;
        r23.getHandler().removeCallbacks(r9);
        r19.element = null;
    L61:
        return false;
    L17:
        if (r19.element == 0) goto L61;
        float r5 = Math.abs(r29.getX() - r16.element);
        float r6 = Math.abs(r29.getY() - r17.element);
        float r7 = r27;
        if (r5 <= r7) goto L21;
    L24:
        r23.getHandler().removeCallbacks(r9);
        r19.element = null;
        return false;
    L21:
        if (r6 > r7) goto L24;
        return true;
    L44:
        r16.element = r29.getX();
        r17.element = r29.getY();
        r18.element = System.currentTimeMillis();
        r19.element = null;
        r20.element = false;
        r21.element = false;
        MotionEvent r10 = (MotionEvent) ZeusTransformUtils.preCheckCast(r22.element, MotionEvent.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L47;
        r10.recycle();
    L47:
        r22.element = null;
        if (r12 != null) goto L50;
        boolean r15 = false;
    L56:
        if (r15 == false) goto L58;
        return false;
    L58:
        Intrinsics.checkNotNull(r29);
        r19.element = a(r8, r29);
        if (r19.element == 0) goto L63;
        r23.getHandler().postDelayed(r9, r25);
        return true;
    L63:
        return false;
    L50:
        if (Selection.getSelectionStart((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == Selection.getSelectionEnd((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"))) goto L52;
        boolean r26 = true;
    L53:
        r15 = r26;
        goto L56
    L52:
        r26 = false;
        goto L53
    L5:
        r12 = null;
        goto L6
    }

    private static final void b(final TextView r2, final Ref.BooleanRef r3, Function0 r4) {
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if (r2.performLongClick() == true) goto L5;
        r2.postDelayed(new $$Lambda$g$x2TirgqVszCo5JSgRrM3l2lN2BU(r2, r3, r5), 20);
        return;
    L5:
        r3.element = true;
        r5.invoke();
    }

    private static final void b(Ref.BooleanRef r0, TextView r1) {
        if (r0.element == false) goto L6;
        a(r1);
        return;
    }

    private static final void c(Ref.BooleanRef r0, TextView r1) {
        if (r0.element == false) goto L6;
        a(r1);
        return;
    }

    public static /* synthetic */ void lambda$4vTpCR6frM2_TZWZP67rBcxxYGw(Ref.BooleanRef r0, TextView r1) {
        a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$5plmpSbU92V2X8sQPgk5V2POeUE(Ref.ObjectRef r0, TextView r1, Ref.BooleanRef r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$JN9kPfnWMbmq-ktWgsAPXFnyfC0, reason: not valid java name */
    public static /* synthetic */ void m1412lambda$JN9kPfnWMbmqktWgsAPXFnyfC0(Ref.ObjectRef r0, Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef r3, TextView r4, Ref.FloatRef r5, Ref.FloatRef r6, Function0 r7) {
        a(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void lambda$NFitCGeARaziAziawMJBYS968oA(Ref.BooleanRef r0, TextView r1) {
        c(r0, r1);
    }

    public static /* synthetic */ void lambda$NmnYYVjrnRb8DpammWF9fs6Um3k(TextView r0, MotionEvent r1, Ref.ObjectRef r2, Ref.BooleanRef r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean lambda$TIoWNeVxukunjyPUr6jQbPmkTvU(Ref.FloatRef r0, Ref.FloatRef r1, Ref.LongRef r2, Ref.ObjectRef r3, Ref.BooleanRef r4, Ref.BooleanRef r5, Ref.ObjectRef r6, TextView r7, Runnable r8, long r9, int r11, View r12, MotionEvent r13) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13);
    }

    public static /* synthetic */ void lambda$WEA7RBBYfe5hPvzCwN95kkFWDLA(Ref.BooleanRef r0, TextView r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$jm-syk98oL3u6DOOyPjvsDnVb28, reason: not valid java name */
    public static /* synthetic */ boolean m1413lambda$jmsyk98oL3u6DOOyPjvsDnVb28(TextView r0, Ref.BooleanRef r1, Ref.ObjectRef r2, Ref.BooleanRef r3, View r4, MotionEvent r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$usKq84sbYATFl3fy7TP9-Gr8T6U, reason: not valid java name */
    public static /* synthetic */ void m1414lambda$usKq84sbYATFl3fy7TP9Gr8T6U(TextView r0, Ref.BooleanRef r1, Function0 r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$x2TirgqVszCo5JSgRrM3l2lN2BU(TextView r0, Ref.BooleanRef r1, Function0 r2) {
        a(r0, r1, r2);
    }
}
