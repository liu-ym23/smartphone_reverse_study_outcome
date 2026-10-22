package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void drawableHotspotChanged(View r10, float r11, float r12) {
            r10.drawableHotspotChanged(r11, r12);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private static boolean sHasMethods;
        private static Method sPositionSelector;
        private static Method sSetNextSelectedPositionInt;
        private static Method sSetSelectedPositionInt;

        static {
            Class r10 = Integer.TYPE;     // Catch: NoSuchMethodException -> L4
            Class r11 = Float.TYPE;     // Catch: NoSuchMethodException -> L4
            Method r12 = AbsListView.class.getDeclaredMethod("positionSelector", new Class[]{r10, View.class, Boolean.TYPE, r11, r11});     // Catch: NoSuchMethodException -> L4
            sPositionSelector = r12;     // Catch: NoSuchMethodException -> L4
            r12.setAccessible(true);     // Catch: NoSuchMethodException -> L4
            Method r13 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", new Class[]{r10});     // Catch: NoSuchMethodException -> L4
            sSetSelectedPositionInt = r13;     // Catch: NoSuchMethodException -> L4
            r13.setAccessible(true);     // Catch: NoSuchMethodException -> L4
            Method r14 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{r10});     // Catch: NoSuchMethodException -> L4
            sSetNextSelectedPositionInt = r14;     // Catch: NoSuchMethodException -> L4
            r14.setAccessible(true);     // Catch: NoSuchMethodException -> L4
            sHasMethods = true;     // Catch: NoSuchMethodException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        private Api30Impl() {
        }

        static boolean canPositionSelectorForHoveredItem() {
            return sHasMethods;
        }

        @SuppressLint({"BanUncheckedReflection"})
        static void positionSelectorForHoveredItem(DropDownListView r10, int r11, View r12) {
            sPositionSelector.invoke(r10, new Object[]{Integer.valueOf(r11), r12, Boolean.FALSE, -1, -1});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
            sSetSelectedPositionInt.invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
            sSetNextSelectedPositionInt.invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
        L12:
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
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static boolean isSelectedChildViewEnabled(AbsListView r10) {
            return r10.isSelectedChildViewEnabled();
        }

        @DoNotInline
        static void setSelectedChildViewEnabled(AbsListView r10, boolean r11) {
            r10.setSelectedChildViewEnabled(r11);
        }
    }

    private static class GateKeeperDrawable extends DrawableWrapperCompat {
        private boolean mEnabled;

        GateKeeperDrawable(Drawable r10) {
            super(r10);
            this.mEnabled = true;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void draw(Canvas r10) {
            if (this.mEnabled == false) goto L6;
            super.draw(r10);
            return;
        }

        void setEnabled(boolean r10) {
            this.mEnabled = r10;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void setHotspot(float r10, float r11) {
            if (this.mEnabled == false) goto L6;
            super.setHotspot(r10, r11);
            return;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void setHotspotBounds(int r10, int r11, int r12, int r13) {
            if (this.mEnabled == false) goto L6;
            super.setHotspotBounds(r10, r11, r12, r13);
            return;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public boolean setState(int[] r10) {
            if (this.mEnabled == true) goto L5;
            return false;
        L5:
            return super.setState(r10);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public boolean setVisible(boolean r10, boolean r11) {
            if (this.mEnabled == true) goto L5;
            return false;
        L5:
            return super.setVisible(r10, r11);
        }
    }

    static class PreApi33Impl {
        private static final Field sIsChildViewEnabled = null;

        static {
            Field r10 = null;
            r10 = AbsListView.class.getDeclaredField("mIsChildViewEnabled");     // Catch: NoSuchFieldException -> L5
            r10.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        L7:
            sIsChildViewEnabled = r10;
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        private PreApi33Impl() {
        }

        static boolean isSelectedChildViewEnabled(AbsListView r10) {
            Field r11 = sIsChildViewEnabled;
            if (r11 == null) goto L12;
            return r11.getBoolean(r10);
        L6:
            e = move-exception;
            e.printStackTrace();
            return false;
        L12:
            return false;
        }

        static void setSelectedChildViewEnabled(AbsListView r10, boolean r11) {
            Field r12 = sIsChildViewEnabled;
            if (r12 == null) goto L11;
            r12.set(r10, Boolean.valueOf(r11));     // Catch: IllegalAccessException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }
    }

    private class ResolveHoverRunnable implements Runnable {
        final /* synthetic */ DropDownListView this$0;

        ResolveHoverRunnable(DropDownListView r10) {
            this.this$0 = r10;
        }

        public void cancel() {
            DropDownListView r10 = this.this$0;
            r10.mResolveHoverRunnable = null;
            r10.removeCallbacks(this);
        }

        public void post() {
            this.this$0.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView r10 = this.this$0;
            r10.mResolveHoverRunnable = null;
            r10.drawableStateChanged();
        }
    }

    DropDownListView(@NonNull Context r10, boolean r11) {
        super(r10, null, R.attr.dropDownListViewStyle);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mHijackFocus = r11;
        setCacheColorHint(0);
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View r10 = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (r10 == null) goto L5;
        r10.setPressed(false);
    L5:
        ViewPropertyAnimatorCompat r11 = this.mClickAnimation;
        if (r11 == null) goto L9;
        r11.cancel();
        this.mClickAnimation = null;
        return;
    }

    private void clickPressedItem(View r10, int r11) {
        performItemClick(r10, r11, getItemIdAtPosition(r11));
    }

    private void drawSelectorCompat(Canvas r10) {
        if (this.mSelectorRect.isEmpty() == true) goto L8;
        Drawable r11 = getSelector();
        if (r11 == null) goto L9;
        r11.setBounds(this.mSelectorRect);
        r11.draw(r10);
        return;
    L9:
        return;
    }

    private void positionSelectorCompat(int r10, View r11) {
        Rect r12 = this.mSelectorRect;
        r12.set(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom());
        r12.left -= this.mSelectionLeftPadding;
        r12.top -= this.mSelectionTopPadding;
        r12.right += this.mSelectionRightPadding;
        r12.bottom += this.mSelectionBottomPadding;
        boolean r13 = superIsSelectedChildViewEnabled();
        if (r11.isEnabled() == r13) goto L8;
        superSetSelectedChildViewEnabled(!r13);
        if (r10 == (-1)) goto L9;
        refreshDrawableState();
        return;
    L9:
        return;
    }

    private void positionSelectorLikeFocusCompat(int r10, View r11) {
        Drawable r12 = getSelector();
        boolean r13 = true;
        if (r12 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        if (r14 == false) goto L10;
        r12.setVisible(false, false);
    L10:
        positionSelectorCompat(r10, r11);
        if (r14 == false) goto L18;
        Rect r15 = this.mSelectorRect;
        float r16 = r15.exactCenterX();
        float r17 = r15.exactCenterY();
        if (getVisibility() == 0) goto L16;
        r13 = false;
    L16:
        r12.setVisible(r13, false);
        DrawableCompat.setHotspot(r12, r16, r17);
        return;
    L18:
        return;
    L5:
        if (r10 == (-1)) goto L7;
        r14 = true;
        goto L8
    }

    private void positionSelectorLikeTouchCompat(int r10, View r11, float r12, float r13) {
        positionSelectorLikeFocusCompat(r10, r11);
        Drawable r14 = getSelector();
        if (r14 != null) goto L5;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        DrawableCompat.setHotspot(r14, r12, r13);
        return;
    }

    private void setPressedItem(View r10, int r11, float r12, float r13) {
        this.mDrawsInPressedState = true;
        int r14 = Build.VERSION.SDK_INT;
        if (r14 < 21) goto L6;
        Api21Impl.drawableHotspotChanged(this, r12, r13);
    L6:
        if (isPressed() == true) goto L8;
        setPressed(true);
    L8:
        layoutChildren();
        int r15 = this.mMotionPosition;
        if (r15 == (-1)) goto L16;
        View r16 = getChildAt(r15 - getFirstVisiblePosition());
        if (r16 == null) goto L16;
        if (r16 == r10) goto L16;
        if (r16.isPressed() == false) goto L16;
        r16.setPressed(false);
    L16:
        this.mMotionPosition = r11;
        float r17 = r12 - r10.getLeft();
        float r18 = r13 - r10.getTop();
        if (r14 < 21) goto L20;
        Api21Impl.drawableHotspotChanged(r10, r17, r18);
    L20:
        if (r10.isPressed() == true) goto L22;
        r10.setPressed(true);
    L22:
        positionSelectorLikeTouchCompat(r11, r10, r12, r13);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void setSelectorEnabled(boolean r10) {
        GateKeeperDrawable r11 = this.mSelector;
        if (r11 == null) goto L6;
        r11.setEnabled(r10);
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
    private void superSetSelectedChildViewEnabled(boolean r10) {
        if (BuildCompat.isAtLeastT() == false) goto L5;
        Api33Impl.setSelectedChildViewEnabled(this, r10);
        return;
    L5:
        PreApi33Impl.setSelectedChildViewEnabled(this, r10);
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        Drawable r10 = getSelector();
        if (r10 != null) goto L5;
        return;
    L5:
        if (touchModeDrawsInPressedStateCompat() == true) goto L7;
        return;
    L7:
        if (isPressed() == false) goto L12;
        r10.setState(getDrawableState());
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r10) {
        drawSelectorCompat(r10);
        super.dispatchDraw(r10);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
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

    public int lookForSelectablePosition(int r10, boolean r11) {
        ListAdapter r12 = getAdapter();
        if (r12 != null) goto L5;
    L29:
        return -1;
    L5:
        if (isInTouchMode() == true) goto L29;
        int r13 = r12.getCount();
        if (getAdapter().areAllItemsEnabled() == true) goto L25;
        if (r11 == false) goto L15;
        int r14 = Math.max(0, r10);
    L11:
        if (r14 >= r13) goto L20;
        if (r12.isEnabled(r14) == true) goto L20;
        r14 = r14 + 1;
    L20:
        if (r14 < 0) goto L24;
        if (r14 >= r13) goto L24;
        return r14;
    L24:
        return -1;
    L15:
        r14 = Math.min(r10, r13 - 1);
    L16:
        if (r14 < 0) goto L20;
        if (r12.isEnabled(r14) == true) goto L20;
        r14 = r14 - 1;
        goto L16
    L25:
        if (r10 < 0) goto L29;
        if (r10 >= r13) goto L29;
        return r10;
    }

    public int measureHeightOfChildrenCompat(int r11, int r12, int r13, int r14, int r15) {
        int r16 = getListPaddingTop();
        int r17 = getListPaddingBottom();
        int r10 = getDividerHeight();
        Drawable r18 = getDivider();
        ListAdapter r19 = getAdapter();
        int r110 = r16 + r17;
        if (r19 != null) goto L6;
        return r110;
    L6:
        if (r10 <= 0) goto L9;
        if (r18 == null) goto L9;
    L10:
        int r20 = r19.getCount();
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
        View r24 = null;
    L11:
        if (r21 >= r20) goto L37;
        int r25 = r19.getItemViewType(r21);
        if (r25 == r22) goto L15;
        r24 = null;
        r22 = r25;
    L15:
        r24 = r19.getView(r21, r24, this);
        ViewGroup.LayoutParams r26 = r24.getLayoutParams();
        if (r26 != null) goto L18;
        r26 = generateDefaultLayoutParams();
        r24.setLayoutParams(r26);
    L18:
        int r27 = r26.height;
        if (r27 <= 0) goto L21;
        int r28 = View.MeasureSpec.makeMeasureSpec(r27, 1073741824);
    L22:
        r24.measure(r11, r28);
        r24.forceLayout();
        if (r21 <= 0) goto L25;
        r110 = r110 + r10;
    L25:
        r110 = r110 + r24.getMeasuredHeight();
        if (r110 >= r14) goto L27;
        if (r15 < 0) goto L36;
        if (r21 < r15) goto L36;
        r23 = r110;
    L36:
        r21 = r21 + 1;
        goto L11
    L27:
        if (r15 < 0) goto L43;
        if (r21 <= r15) goto L44;
        if (r23 <= 0) goto L45;
        if (r110 != r14) goto L32;
        return r14;
    L32:
        return r23;
    L45:
        return r14;
    L44:
        return r14;
    L43:
        return r14;
    L21:
        r28 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L22
    L37:
        return r110;
    L9:
        r10 = 0;
        goto L10
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    public boolean onForwardedEvent(MotionEvent r10, int r11) {
        int r12 = r10.getActionMasked();
        if (r12 != 1) goto L5;
        boolean r13 = false;
    L12:
        int r14 = r10.findPointerIndex(r11);
        if (r14 < 0) goto L9;
        int r15 = (int) r10.getX(r14);
        int r16 = (int) r10.getY(r14);
        int r17 = pointToPosition(r15, r16);
        if (r17 != (-1)) goto L18;
        boolean r18 = true;
    L21:
        if (r13 == false) goto L23;
        if (r18 == true) goto L23;
    L24:
        if (r13 == true) goto L26;
        ListViewAutoScrollHelper r19 = this.mScrollHelper;
        if (r19 == null) goto L32;
        r19.setEnabled(false);
    L32:
        return r13;
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
        View r20 = getChildAt(r17 - getFirstVisiblePosition());
        setPressedItem(r20, r17, r15, r16);
        if (r12 == 1) goto L20;
    L8:
        r18 = false;
        r13 = true;
        goto L21
    L20:
        clickPressedItem(r20, r17);
    L9:
        r18 = false;
        r13 = false;
        goto L21
    L5:
        if (r12 != 2) goto L7;
        r13 = true;
        goto L12
    L7:
        if (r12 == 3) goto L9;
        goto L8
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 26) goto L5;
        int r12 = r10.getActionMasked();
        if (r12 == 10) goto L9;
    L11:
        boolean r13 = super.onHoverEvent(r10);
        if (r12 != 9) goto L14;
    L17:
        int r14 = pointToPosition((int) r10.getX(), (int) r10.getY());
        if (r14 != (-1)) goto L20;
    L30:
        return r13;
    L20:
        if (r14 == getSelectedItemPosition()) goto L30;
        View r15 = getChildAt(r14 - getFirstVisiblePosition());
        if (r15.isEnabled() == false) goto L29;
        requestFocus();
        if (r11 >= 30) goto L26;
    L28:
        setSelectionFromTop(r14, r15.getTop() - getTop());
        goto L29
    L26:
        if (Api30Impl.canPositionSelectorForHoveredItem() == false) goto L28;
        Api30Impl.positionSelectorForHoveredItem(this, r14, r15);
    L29:
        updateSelectorStateCompat();
        goto L30
    L14:
        if (r12 == 7) goto L17;
        setSelection(-1);
        goto L30
    L9:
        if (this.mResolveHoverRunnable != null) goto L11;
        ResolveHoverRunnable r16 = new ResolveHoverRunnable(this);
        this.mResolveHoverRunnable = r16;
        r16.post();
        goto L11
    L5:
        return super.onHoverEvent(r10);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (r10.getAction() != 0) goto L6;
        this.mMotionPosition = pointToPosition((int) r10.getX(), (int) r10.getY());
    L6:
        ResolveHoverRunnable r11 = this.mResolveHoverRunnable;
        if (r11 == null) goto L10;
        r11.cancel();
    L10:
        return super.onTouchEvent(r10);
    }

    void setListSelectionHidden(boolean r10) {
        this.mListSelectionHidden = r10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable r10) {
        if (r10 == null) goto L4;
        GateKeeperDrawable r11 = new GateKeeperDrawable(r10);
    L5:
        this.mSelector = r11;
        super.setSelector(r11);
        Rect r12 = new Rect();
        if (r10 == null) goto L8;
        r10.getPadding(r12);
    L8:
        this.mSelectionLeftPadding = r12.left;
        this.mSelectionTopPadding = r12.top;
        this.mSelectionRightPadding = r12.right;
        this.mSelectionBottomPadding = r12.bottom;
        return;
    L4:
        r11 = null;
        goto L5
    }
}
