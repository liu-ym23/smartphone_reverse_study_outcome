package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class DropDownListView extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding;
    private int mSelectionLeftPadding;
    private int mSelectionRightPadding;
    private int mSelectionTopPadding;
    private GateKeeperDrawable mSelector;
    private final Rect mSelectorRect;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void drawableHotspotChanged(View r5, float r10, float r11) {
            r5.drawableHotspotChanged(r10, r11);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private static boolean sHasMethods;
        private static Method sPositionSelector;
        private static Method sSetNextSelectedPositionInt;
        private static Method sSetSelectedPositionInt;

        static {
            Class r5 = Integer.TYPE;     // Catch: NoSuchMethodException -> L5
            Class r10 = Boolean.TYPE;     // Catch: NoSuchMethodException -> L5
            Class r11 = Float.TYPE;     // Catch: NoSuchMethodException -> L5
            Method r12 = AbsListView.class.getDeclaredMethod("positionSelector", new Class[]{r5, View.class, r10, r11, r11});     // Catch: NoSuchMethodException -> L5
            sPositionSelector = r12;     // Catch: NoSuchMethodException -> L5
            r12.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r13 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", new Class[]{r5});     // Catch: NoSuchMethodException -> L5
            sSetSelectedPositionInt = r13;     // Catch: NoSuchMethodException -> L5
            r13.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r14 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{r5});     // Catch: NoSuchMethodException -> L5
            sSetNextSelectedPositionInt = r14;     // Catch: NoSuchMethodException -> L5
            r14.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            sHasMethods = true;     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        private Api30Impl() {
        }

        public static boolean canPositionSelectorForHoveredItem() {
            return sHasMethods;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static void positionSelectorForHoveredItem(DropDownListView r5, int r10, View r11) {
            sPositionSelector.invoke(r5, new Object[]{Integer.valueOf(r10), r11, Boolean.FALSE, -1, -1});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
            sSetSelectedPositionInt.invoke(r5, new Object[]{Integer.valueOf(r10)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
            sSetNextSelectedPositionInt.invoke(r5, new Object[]{Integer.valueOf(r10)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
        L14:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static boolean isSelectedChildViewEnabled(AbsListView r5) {
            return r5.isSelectedChildViewEnabled();
        }

        @DoNotInline
        public static void setSelectedChildViewEnabled(AbsListView r5, boolean r10) {
            r5.setSelectedChildViewEnabled(r10);
        }
    }

    public static class GateKeeperDrawable extends DrawableWrapperCompat {
        private boolean mEnabled;

        public GateKeeperDrawable(Drawable r5) {
            super(r5);
            this.mEnabled = true;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void draw(Canvas r5) {
            if (this.mEnabled == false) goto L6;
            super.draw(r5);
            return;
        }

        public void setEnabled(boolean r5) {
            this.mEnabled = r5;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void setHotspot(float r5, float r10) {
            if (this.mEnabled == false) goto L6;
            super.setHotspot(r5, r10);
            return;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void setHotspotBounds(int r5, int r10, int r11, int r12) {
            if (this.mEnabled == false) goto L6;
            super.setHotspotBounds(r5, r10, r11, r12);
            return;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public boolean setState(int[] r5) {
            if (this.mEnabled == true) goto L5;
            return false;
        L5:
            return super.setState(r5);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public boolean setVisible(boolean r5, boolean r10) {
            if (this.mEnabled == true) goto L5;
            return false;
        L5:
            return super.setVisible(r5, r10);
        }
    }

    public static class PreApi33Impl {
        private static final Field sIsChildViewEnabled = null;

        static {
            Field r5 = null;
            r5 = AbsListView.class.getDeclaredField("mIsChildViewEnabled");     // Catch: NoSuchFieldException -> L5
            r5.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        L7:
            sIsChildViewEnabled = r5;
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        private PreApi33Impl() {
        }

        public static boolean isSelectedChildViewEnabled(AbsListView r5) {
            Field r10 = sIsChildViewEnabled;
            if (r10 == null) goto L12;
            return r10.getBoolean(r5);
        L6:
            e = move-exception;
            e.printStackTrace();
            return false;
        L12:
            return false;
        }

        public static void setSelectedChildViewEnabled(AbsListView r5, boolean r10) {
            Field r11 = sIsChildViewEnabled;
            if (r11 == null) goto L11;
            r11.set(r5, Boolean.valueOf(r10));     // Catch: IllegalAccessException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }
    }

    public class ResolveHoverRunnable implements Runnable {
        final /* synthetic */ DropDownListView this$0;

        public ResolveHoverRunnable(DropDownListView r5) {
            this.this$0 = r5;
        }

        public void cancel() {
            DropDownListView r5 = this.this$0;
            r5.mResolveHoverRunnable = null;
            r5.removeCallbacks(this);
        }

        public void post() {
            this.this$0.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView r5 = this.this$0;
            r5.mResolveHoverRunnable = null;
            r5.drawableStateChanged();
        }
    }

    public DropDownListView(@NonNull Context r5, boolean r10) {
        super(r5, null, R.attr.dropDownListViewStyle);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mHijackFocus = r10;
        setCacheColorHint(0);
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View r5 = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (r5 == null) goto L5;
        r5.setPressed(false);
    L5:
        ViewPropertyAnimatorCompat r10 = this.mClickAnimation;
        if (r10 == null) goto L9;
        r10.cancel();
        this.mClickAnimation = null;
        return;
    }

    private void clickPressedItem(View r5, int r10) {
        performItemClick(r5, r10, getItemIdAtPosition(r10));
    }

    private void drawSelectorCompat(Canvas r5) {
        if (this.mSelectorRect.isEmpty() == true) goto L8;
        Drawable r10 = getSelector();
        if (r10 == null) goto L9;
        r10.setBounds(this.mSelectorRect);
        r10.draw(r5);
        return;
    L9:
        return;
    }

    private void positionSelectorCompat(int r10, View r11) {
        Rect r5 = this.mSelectorRect;
        r5.set(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom());
        r5.left -= this.mSelectionLeftPadding;
        r5.top -= this.mSelectionTopPadding;
        r5.right += this.mSelectionRightPadding;
        r5.bottom += this.mSelectionBottomPadding;
        boolean r12 = superIsSelectedChildViewEnabled();
        if (r11.isEnabled() == r12) goto L8;
        superSetSelectedChildViewEnabled(!r12);
        if (r10 == (-1)) goto L9;
        refreshDrawableState();
        return;
    L9:
        return;
    }

    private void positionSelectorLikeFocusCompat(int r5, View r10) {
        Drawable r11 = getSelector();
        boolean r12 = true;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L10;
        r11.setVisible(false, false);
    L10:
        positionSelectorCompat(r5, r10);
        if (r13 == false) goto L18;
        Rect r14 = this.mSelectorRect;
        float r15 = r14.exactCenterX();
        float r16 = r14.exactCenterY();
        if (getVisibility() == 0) goto L16;
        r12 = false;
    L16:
        r11.setVisible(r12, false);
        DrawableCompat.setHotspot(r11, r15, r16);
        return;
    L18:
        return;
    L5:
        if (r5 == (-1)) goto L7;
        r13 = true;
        goto L8
    }

    private void positionSelectorLikeTouchCompat(int r5, View r10, float r11, float r12) {
        positionSelectorLikeFocusCompat(r5, r10);
        Drawable r13 = getSelector();
        if (r13 != null) goto L5;
        return;
    L5:
        if (r5 == (-1)) goto L9;
        DrawableCompat.setHotspot(r13, r11, r12);
        return;
    }

    private void setPressedItem(View r5, int r10, float r11, float r12) {
        this.mDrawsInPressedState = true;
        Api21Impl.drawableHotspotChanged(this, r11, r12);
        if (isPressed() == true) goto L5;
        setPressed(true);
    L5:
        layoutChildren();
        int r13 = this.mMotionPosition;
        if (r13 == (-1)) goto L13;
        View r14 = getChildAt(r13 - getFirstVisiblePosition());
        if (r14 == null) goto L13;
        if (r14 == r5) goto L13;
        if (r14.isPressed() == false) goto L13;
        r14.setPressed(false);
    L13:
        this.mMotionPosition = r10;
        Api21Impl.drawableHotspotChanged(r5, r11 - r5.getLeft(), r12 - r5.getTop());
        if (r5.isPressed() == true) goto L16;
        r5.setPressed(true);
    L16:
        positionSelectorLikeTouchCompat(r10, r5, r11, r12);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void setSelectorEnabled(boolean r5) {
        GateKeeperDrawable r10 = this.mSelector;
        if (r10 == null) goto L6;
        r10.setEnabled(r5);
        return;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    private boolean superIsSelectedChildViewEnabled() {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return Api33Impl.isSelectedChildViewEnabled(this);
    L7:
        return PreApi33Impl.isSelectedChildViewEnabled(this);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    private void superSetSelectedChildViewEnabled(boolean r5) {
        if (BuildCompat.isAtLeastT() == false) goto L5;
        Api33Impl.setSelectedChildViewEnabled(this, r5);
        return;
    L5:
        PreApi33Impl.setSelectedChildViewEnabled(this, r5);
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        Drawable r5 = getSelector();
        if (r5 != null) goto L5;
        return;
    L5:
        if (touchModeDrawsInPressedStateCompat() == true) goto L7;
        return;
    L7:
        if (isPressed() == false) goto L12;
        r5.setState(getDrawableState());
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        drawSelectorCompat(r5);
        super.dispatchDraw(r5);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.mResolveHoverRunnable == null) goto L5;
        return;
    L5:
        super.drawableStateChanged();
        setSelectorEnabled(true);
        updateSelectorStateCompat();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        if (this.mHijackFocus == false) goto L5;
    L8:
        return true;
    L5:
        if (super.hasFocus() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        if (this.mHijackFocus == false) goto L5;
    L8:
        return true;
    L5:
        if (super.hasWindowFocus() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (this.mHijackFocus == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isFocused() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if (this.mHijackFocus == false) goto L7;
        if (this.mListSelectionHidden == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isInTouchMode() == true) goto L8;
        return false;
    }

    public int lookForSelectablePosition(int r5, boolean r10) {
        ListAdapter r11 = getAdapter();
        if (r11 != null) goto L5;
    L29:
        return -1;
    L5:
        if (isInTouchMode() == true) goto L29;
        int r12 = r11.getCount();
        if (getAdapter().areAllItemsEnabled() == true) goto L25;
        if (r10 == false) goto L15;
        int r13 = Math.max(0, r5);
    L11:
        if (r13 >= r12) goto L20;
        if (r11.isEnabled(r13) == true) goto L20;
        r13 = r13 + 1;
    L20:
        if (r13 < 0) goto L24;
        if (r13 >= r12) goto L24;
        return r13;
    L24:
        return -1;
    L15:
        r13 = Math.min(r5, r12 - 1);
    L16:
        if (r13 < 0) goto L20;
        if (r11.isEnabled(r13) == true) goto L20;
        r13 = r13 - 1;
        goto L16
    L25:
        if (r5 < 0) goto L29;
        if (r5 >= r12) goto L29;
        return r5;
    }

    public int measureHeightOfChildrenCompat(int r11, int r12, int r13, int r14, int r15) {
        int r16 = getListPaddingTop();
        int r17 = getListPaddingBottom();
        int r5 = getDividerHeight();
        Drawable r10 = getDivider();
        ListAdapter r18 = getAdapter();
        if (r18 == null) goto L5;
        int r19 = r16 + r17;
        if (r5 <= 0) goto L10;
        if (r10 == null) goto L10;
    L11:
        int r20 = r18.getCount();
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
        View r24 = null;
    L12:
        if (r21 >= r20) goto L38;
        int r25 = r18.getItemViewType(r21);
        if (r25 == r22) goto L16;
        r24 = null;
        r22 = r25;
    L16:
        r24 = r18.getView(r21, r24, this);
        ViewGroup.LayoutParams r26 = r24.getLayoutParams();
        if (r26 != null) goto L19;
        r26 = generateDefaultLayoutParams();
        r24.setLayoutParams(r26);
    L19:
        int r27 = r26.height;
        if (r27 <= 0) goto L22;
        int r28 = View.MeasureSpec.makeMeasureSpec(r27, BasicMeasure.EXACTLY);
    L23:
        r24.measure(r11, r28);
        r24.forceLayout();
        if (r21 <= 0) goto L26;
        r19 = r19 + r5;
    L26:
        r19 = r19 + r24.getMeasuredHeight();
        if (r19 >= r14) goto L28;
        if (r15 < 0) goto L37;
        if (r21 < r15) goto L37;
        r23 = r19;
    L37:
        r21 = r21 + 1;
        goto L12
    L28:
        if (r15 < 0) goto L44;
        if (r21 <= r15) goto L45;
        if (r23 <= 0) goto L46;
        if (r19 != r14) goto L33;
        return r14;
    L33:
        return r23;
    L46:
        return r14;
    L45:
        return r14;
    L44:
        return r14;
    L22:
        r28 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L23
    L38:
        return r19;
    L10:
        r5 = 0;
        goto L11
    L5:
        return r16 + r17;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    public boolean onForwardedEvent(MotionEvent r10, int r11) {
        int r5 = r10.getActionMasked();
        if (r5 != 1) goto L5;
        boolean r12 = false;
    L12:
        int r13 = r10.findPointerIndex(r11);
        if (r13 < 0) goto L9;
        int r14 = (int) r10.getX(r13);
        int r15 = (int) r10.getY(r13);
        int r16 = pointToPosition(r14, r15);
        if (r16 != (-1)) goto L18;
        boolean r17 = true;
    L21:
        if (r12 == false) goto L23;
        if (r17 == true) goto L23;
    L24:
        if (r12 == true) goto L26;
        ListViewAutoScrollHelper r18 = this.mScrollHelper;
        if (r18 == null) goto L32;
        r18.setEnabled(false);
    L32:
        return r12;
    L26:
        if (this.mScrollHelper != null) goto L28;
        this.mScrollHelper = new ListViewAutoScrollHelper(this);
    L28:
        this.mScrollHelper.setEnabled(true);
        this.mScrollHelper.onTouch(this, r10);
    L23:
        clearPressedItem();
        goto L24
    L18:
        View r19 = getChildAt(r16 - getFirstVisiblePosition());
        setPressedItem(r19, r16, r14, r15);
        if (r5 == 1) goto L20;
    L8:
        r12 = true;
        r17 = false;
        goto L21
    L20:
        clickPressedItem(r19, r16);
    L9:
        r17 = false;
        r12 = false;
        goto L21
    L5:
        if (r5 != 2) goto L7;
        r12 = true;
        goto L12
    L7:
        if (r5 == 3) goto L9;
        goto L8
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent r5) {
        int r10 = r5.getActionMasked();
        if (r10 == 10) goto L5;
    L7:
        boolean r11 = super.onHoverEvent(r5);
        if (r10 != 9) goto L10;
    L13:
        int r12 = pointToPosition((int) r5.getX(), (int) r5.getY());
        if (r12 != (-1)) goto L16;
    L24:
        return r11;
    L16:
        if (r12 == getSelectedItemPosition()) goto L24;
        View r13 = getChildAt(r12 - getFirstVisiblePosition());
        if (r13.isEnabled() == false) goto L23;
        requestFocus();
        if (Api30Impl.canPositionSelectorForHoveredItem() == false) goto L22;
        Api30Impl.positionSelectorForHoveredItem(this, r12, r13);
        goto L23
    L22:
        setSelectionFromTop(r12, r13.getTop() - getTop());
    L23:
        updateSelectorStateCompat();
        goto L24
    L10:
        if (r10 == 7) goto L13;
        setSelection(-1);
        goto L24
    L5:
        if (this.mResolveHoverRunnable != null) goto L7;
        ResolveHoverRunnable r14 = new ResolveHoverRunnable(this);
        this.mResolveHoverRunnable = r14;
        r14.post();
        goto L7
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        if (r5.getAction() != 0) goto L6;
        this.mMotionPosition = pointToPosition((int) r5.getX(), (int) r5.getY());
    L6:
        ResolveHoverRunnable r10 = this.mResolveHoverRunnable;
        if (r10 == null) goto L10;
        r10.cancel();
    L10:
        return super.onTouchEvent(r5);
    }

    public void setListSelectionHidden(boolean r5) {
        this.mListSelectionHidden = r5;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable r5) {
        if (r5 == null) goto L4;
        GateKeeperDrawable r10 = new GateKeeperDrawable(r5);
    L5:
        this.mSelector = r10;
        super.setSelector(r10);
        Rect r11 = new Rect();
        if (r5 == null) goto L8;
        r5.getPadding(r11);
    L8:
        this.mSelectionLeftPadding = r11.left;
        this.mSelectionTopPadding = r11.top;
        this.mSelectionRightPadding = r11.right;
        this.mSelectionBottomPadding = r11.bottom;
        return;
    L4:
        r10 = null;
        goto L5
    }
}
