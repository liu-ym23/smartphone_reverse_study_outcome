package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetClipToWindowEnabledMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static int getMaxAvailableHeight(PopupWindow r5, View r10, int r11, boolean r12) {
            return r5.getMaxAvailableHeight(r10, r11, r12);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void setEpicenterBounds(PopupWindow r5, Rect r10) {
            r5.setEpicenterBounds(r10);
        }

        @DoNotInline
        public static void setIsClippedToScreen(PopupWindow r5, boolean r10) {
            r5.setIsClippedToScreen(r10);
        }
    }

    public class ListSelectorHider implements Runnable {
        final /* synthetic */ ListPopupWindow this$0;

        public ListSelectorHider(ListPopupWindow r5) {
            this.this$0 = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.clearListSelection();
        }
    }

    public class PopupDataSetObserver extends DataSetObserver {
        final /* synthetic */ ListPopupWindow this$0;

        public PopupDataSetObserver(ListPopupWindow r5) {
            this.this$0 = r5;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.this$0.isShowing() == false) goto L6;
            this.this$0.show();
            return;
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.dismiss();
        }
    }

    public class PopupScrollListener implements AbsListView.OnScrollListener {
        final /* synthetic */ ListPopupWindow this$0;

        public PopupScrollListener(ListPopupWindow r5) {
            this.this$0 = r5;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView r5, int r10, int r11, int r12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView r5, int r10) {
            if (r10 == 1) goto L5;
            return;
        L5:
            if (this.this$0.isInputMethodNotNeeded() == false) goto L7;
            return;
        L7:
            if (this.this$0.mPopup.getContentView() == null) goto L12;
            ListPopupWindow r11 = this.this$0;
            r11.mHandler.removeCallbacks(r11.mResizePopupRunnable);
            this.this$0.mResizePopupRunnable.run();
            return;
        }
    }

    public class PopupTouchInterceptor implements View.OnTouchListener {
        final /* synthetic */ ListPopupWindow this$0;

        public PopupTouchInterceptor(ListPopupWindow r5) {
            this.this$0 = r5;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r5, MotionEvent r10) {
            int r11 = r10.getAction();
            int r12 = (int) r10.getX();
            int r13 = (int) r10.getY();
            if (r11 != 0) goto L16;
            PopupWindow r14 = this.this$0.mPopup;
            if (r14 == null) goto L16;
            if (r14.isShowing() == false) goto L16;
            if (r12 < 0) goto L16;
            if (r12 >= this.this$0.mPopup.getWidth()) goto L16;
            if (r13 < 0) goto L16;
            if (r13 >= this.this$0.mPopup.getHeight()) goto L16;
            ListPopupWindow r15 = this.this$0;
            r15.mHandler.postDelayed(r15.mResizePopupRunnable, 250);
            return false;
        L16:
            if (r11 != 1) goto L21;
            ListPopupWindow r16 = this.this$0;
            r16.mHandler.removeCallbacks(r16.mResizePopupRunnable);
            return false;
        L21:
            return false;
        }
    }

    public class ResizePopupRunnable implements Runnable {
        final /* synthetic */ ListPopupWindow this$0;

        public ResizePopupRunnable(ListPopupWindow r5) {
            this.this$0 = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView r5 = this.this$0.mDropDownList;
            if (r5 != null) goto L5;
            return;
        L5:
            if (ViewCompat.isAttachedToWindow(r5) == true) goto L7;
            return;
        L7:
            if (this.this$0.mDropDownList.getCount() <= this.this$0.mDropDownList.getChildCount()) goto L14;
            int r10 = this.this$0.mDropDownList.getChildCount();
            ListPopupWindow r11 = this.this$0;
            if (r10 > r11.mListItemExpandMaximum) goto L15;
            r11.mPopup.setInputMethodMode(2);
            this.this$0.show();
            return;
        L15:
            return;
        }
    }

    public ListPopupWindow(@NonNull Context r5) {
        this(r5, null, R.attr.listPopupWindowStyle);
    }

    private int buildDropDown() {
        boolean r5 = true;
        if (this.mDropDownList != null) goto L25;
        Context r10 = this.mContext;
        this.mShowDropDownRunnable = new AnonymousClass2(this);
        DropDownListView r11 = createDropDownListView(r10, !this.mModal);
        this.mDropDownList = r11;
        Drawable r12 = this.mDropDownListHighlight;
        if (r12 == null) goto L7;
        r11.setSelector(r12);
    L7:
        this.mDropDownList.setAdapter(this.mAdapter);
        this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
        this.mDropDownList.setFocusable(true);
        this.mDropDownList.setFocusableInTouchMode(true);
        this.mDropDownList.setOnItemSelectedListener(new AnonymousClass3(this));
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        AdapterView.OnItemSelectedListener r13 = this.mItemSelectedListener;
        if (r13 == null) goto L10;
        this.mDropDownList.setOnItemSelectedListener(r13);
    L10:
        DropDownListView r14 = this.mDropDownList;
        View r15 = this.mPromptView;
        if (r15 == null) goto L23;
        LinearLayout r16 = new LinearLayout(r10);
        r16.setOrientation(1);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        int r18 = this.mPromptPosition;
        if (r18 == 0) goto L17;
        if (r18 == 1) goto L16;
        Log.e(TAG, "Invalid hint position " + this.mPromptPosition);
    L18:
        int r19 = this.mDropDownWidth;
        if (r19 < 0) goto L21;
        int r20 = Integer.MIN_VALUE;
    L22:
        r15.measure(View.MeasureSpec.makeMeasureSpec(r19, r20), 0);
        LinearLayout.LayoutParams r21 = (LinearLayout.LayoutParams) r15.getLayoutParams();
        int r22 = (r15.getMeasuredHeight() + r21.topMargin) + r21.bottomMargin;
        View r23 = r16;
    L24:
        this.mPopup.setContentView(r23);
    L29:
        Drawable r24 = this.mPopup.getBackground();
        if (r24 == null) goto L34;
        r24.getPadding(this.mTempRect);
        Rect r25 = this.mTempRect;
        int r26 = r25.top;
        int r27 = r25.bottom + r26;
        if (this.mDropDownVerticalOffsetSet == true) goto L36;
        this.mDropDownVerticalOffset = -r26;
    L36:
        if (this.mPopup.getInputMethodMode() == 2) goto L39;
        r5 = false;
    L39:
        int r28 = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, r5);
        if (this.mDropDownAlwaysVisible == true) goto L58;
        if (this.mDropDownHeight == (-1)) goto L58;
        int r29 = this.mDropDownWidth;
        if (r29 != (-2)) goto L47;
        int r30 = this.mContext.getResources().getDisplayMetrics().widthPixels;
        Rect r31 = this.mTempRect;
        int r32 = View.MeasureSpec.makeMeasureSpec(r30 - (r31.left + r31.right), Integer.MIN_VALUE);
    L52:
        int r33 = this.mDropDownList.measureHeightOfChildrenCompat(r32, 0, -1, r28 - r22, -1);
        if (r33 <= 0) goto L56;
        r22 = r22 + ((this.mDropDownList.getPaddingBottom() + this.mDropDownList.getPaddingTop()) + r27);
    L56:
        return r33 + r22;
    L47:
        if (r29 == (-1)) goto L50;
        r32 = View.MeasureSpec.makeMeasureSpec(r29, BasicMeasure.EXACTLY);
        goto L52
    L50:
        int r34 = this.mContext.getResources().getDisplayMetrics().widthPixels;
        Rect r35 = this.mTempRect;
        r32 = View.MeasureSpec.makeMeasureSpec(r34 - (r35.left + r35.right), BasicMeasure.EXACTLY);
    L58:
        return r28 + r27;
    L34:
        this.mTempRect.setEmpty();
        r27 = 0;
        goto L36
    L21:
        r19 = 0;
        r20 = 0;
        goto L22
    L16:
        r16.addView(r14, r17);
        r16.addView(r15);
        goto L18
    L17:
        r16.addView(r15);
        r16.addView(r14, r17);
        goto L18
    L23:
        r22 = 0;
        r23 = r14;
        goto L24
    L25:
        ViewGroup r36 = (ViewGroup) this.mPopup.getContentView();
        View r37 = this.mPromptView;
        if (r37 == null) goto L28;
        LinearLayout.LayoutParams r38 = (LinearLayout.LayoutParams) r37.getLayoutParams();
        r22 = (r37.getMeasuredHeight() + r38.topMargin) + r38.bottomMargin;
        goto L29
    L28:
        r22 = 0;
        goto L29
    }

    private int getMaxAvailableHeight(View r5, int r10, boolean r11) {
        return Api24Impl.getMaxAvailableHeight(this.mPopup, r5, r10, r11);
    }

    private static boolean isConfirmKey(int r5) {
        if (r5 != 66) goto L5;
    L8:
        return true;
    L5:
        if (r5 == 23) goto L8;
        return false;
    }

    private void removePromptView() {
        View r5 = this.mPromptView;
        if (r5 == null) goto L8;
        ViewParent r10 = r5.getParent();
        if ((r10 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r10).removeView(this.mPromptView);
        return;
    L9:
        return;
    }

    private void setPopupClipToScreenEnabled(boolean r5) {
        Api29Impl.setIsClippedToScreen(this.mPopup, r5);
    }

    public void clearListSelection() {
        DropDownListView r5 = this.mDropDownList;
        if (r5 == null) goto L6;
        r5.setListSelectionHidden(true);
        r5.requestLayout();
        return;
    }

    public View.OnTouchListener createDragToOpenListener(final View r5) {
        return new AnonymousClass1(this, r5);
    }

    @NonNull
    public DropDownListView createDropDownListView(Context r5, boolean r10) {
        return new DropDownListView(r5, r10);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    @Nullable
    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    @StyleRes
    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    @Nullable
    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    @Nullable
    public Rect getEpicenterBounds() {
        if (this.mEpicenterBounds != null) goto L7;
        return null;
    L7:
        return new Rect(this.mEpicenterBounds);
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    @Nullable
    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    @Nullable
    public Object getSelectedItem() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (isShowing() == true) goto L7;
        return Long.MIN_VALUE;
    L7:
        return this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (isShowing() == true) goto L7;
        return -1;
    L7:
        return this.mDropDownList.getSelectedItemPosition();
    }

    @Nullable
    public View getSelectedView() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.mDropDownList.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (this.mDropDownVerticalOffsetSet == true) goto L7;
        return 0;
    L7:
        return this.mDropDownVerticalOffset;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        if (this.mPopup.getInputMethodMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isModal() {
        return this.mModal;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int r10, @NonNull KeyEvent r11) {
        if (isShowing() == true) goto L5;
    L49:
        return false;
    L5:
        if (r10 == 62) goto L49;
        if (this.mDropDownList.getSelectedItemPosition() < 0) goto L9;
    L10:
        int r5 = this.mDropDownList.getSelectedItemPosition();
        boolean r12 = this.mPopup.isAboveAnchor();
        ListAdapter r13 = this.mAdapter;
        if (r13 == null) goto L19;
        boolean r14 = r13.areAllItemsEnabled();
        if (r14 == false) goto L15;
        int r15 = 0;
    L16:
        if (r14 == false) goto L18;
        int r16 = r13.getCount() - 1;
    L21:
        if (r12 == true) goto L25;
        if (r10 != 19) goto L25;
        if (r5 > r15) goto L25;
    L28:
        clearListSelection();
        this.mPopup.setInputMethodMode(1);
        show();
        return true;
    L25:
        if (r12 == false) goto L30;
        if (r10 != 20) goto L30;
        if (r5 >= r16) goto L28;
    L30:
        this.mDropDownList.setListSelectionHidden(false);
        if (this.mDropDownList.onKeyDown(r10, r11) == false) goto L41;
        this.mPopup.setInputMethodMode(2);
        this.mDropDownList.requestFocusFromTouch();
        show();
        if (r10 == 19) goto L40;
        if (r10 == 20) goto L40;
        if (r10 == 23) goto L40;
        if (r10 != 66) goto L49;
    L40:
        return true;
    L41:
        if (r12 == true) goto L45;
        if (r10 != 20) goto L45;
        if (r5 != r16) goto L49;
        return true;
    L45:
        if (r12 == false) goto L49;
        if (r10 != 19) goto L49;
        if (r5 != r15) goto L49;
        return true;
    L18:
        r16 = this.mDropDownList.lookForSelectablePosition(r13.getCount() - 1, false);
        goto L21
    L15:
        r15 = this.mDropDownList.lookForSelectablePosition(0, true);
        goto L16
    L19:
        r15 = Integer.MAX_VALUE;
        r16 = Integer.MIN_VALUE;
        goto L21
    L9:
        if (isConfirmKey(r10) == true) goto L49;
        goto L10
    }

    public boolean onKeyPreIme(int r5, @NonNull KeyEvent r10) {
        if (r5 == 4) goto L5;
        return false;
    L5:
        if (isShowing() == false) goto L27;
        View r11 = this.mDropDownAnchorView;
        if (r10.getAction() != 0) goto L15;
        if (r10.getRepeatCount() != 0) goto L15;
        KeyEvent.DispatcherState r12 = r11.getKeyDispatcherState();
        if (r12 == null) goto L13;
        r12.startTracking(r10, this);
    L13:
        return true;
    L15:
        if (r10.getAction() != 1) goto L28;
        KeyEvent.DispatcherState r13 = r11.getKeyDispatcherState();
        if (r13 == null) goto L20;
        r13.handleUpEvent(r10);
    L20:
        if (r10.isTracking() == true) goto L22;
        return false;
    L22:
        if (r10.isCanceled() == true) goto L30;
        dismiss();
        return true;
    L30:
        return false;
    L28:
        return false;
    L27:
        return false;
    }

    public boolean onKeyUp(int r5, @NonNull KeyEvent r10) {
        if (isShowing() == true) goto L5;
        return false;
    L5:
        if (this.mDropDownList.getSelectedItemPosition() < 0) goto L14;
        boolean r11 = this.mDropDownList.onKeyUp(r5, r10);
        if (r11 == true) goto L9;
    L11:
        return r11;
    L9:
        if (isConfirmKey(r5) == false) goto L11;
        dismiss();
        goto L11
    L14:
        return false;
    }

    public boolean performItemClick(int r10) {
        if (isShowing() == true) goto L5;
        return false;
    L5:
        if (this.mItemClickListener == null) goto L11;
        DropDownListView r5 = this.mDropDownList;
        View r11 = r5.getChildAt(r10 - r5.getFirstVisiblePosition());
        ListAdapter r12 = r5.getAdapter();
        this.mItemClickListener.onItemClick(r5, r11, r10, r12.getItemId(r10));
        return true;
    L11:
        return true;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(@Nullable ListAdapter r5) {
        DataSetObserver r10 = this.mObserver;
        if (r10 != null) goto L5;
        this.mObserver = new PopupDataSetObserver(this);
    L8:
        this.mAdapter = r5;
        if (r5 == null) goto L11;
        r5.registerDataSetObserver(this.mObserver);
    L11:
        DropDownListView r11 = this.mDropDownList;
        if (r11 == null) goto L15;
        r11.setAdapter(this.mAdapter);
        return;
    L15:
        return;
    L5:
        ListAdapter r12 = this.mAdapter;
        if (r12 == null) goto L8;
        r12.unregisterDataSetObserver(r10);
        goto L8
    }

    public void setAnchorView(@Nullable View r5) {
        this.mDropDownAnchorView = r5;
    }

    public void setAnimationStyle(@StyleRes int r5) {
        this.mPopup.setAnimationStyle(r5);
    }

    public void setBackgroundDrawable(@Nullable Drawable r5) {
        this.mPopup.setBackgroundDrawable(r5);
    }

    public void setContentWidth(int r5) {
        Drawable r10 = this.mPopup.getBackground();
        if (r10 == null) goto L5;
        r10.getPadding(this.mTempRect);
        Rect r11 = this.mTempRect;
        this.mDropDownWidth = (r11.left + r11.right) + r5;
        return;
    L5:
        setWidth(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean r5) {
        this.mDropDownAlwaysVisible = r5;
    }

    public void setDropDownGravity(int r5) {
        this.mDropDownGravity = r5;
    }

    public void setEpicenterBounds(@Nullable Rect r5) {
        if (r5 == null) goto L4;
        Rect r10 = new Rect(r5);
    L5:
        this.mEpicenterBounds = r10;
        return;
    L4:
        r10 = null;
        goto L5
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean r5) {
        this.mForceIgnoreOutsideTouch = r5;
    }

    public void setHeight(int r5) {
        if (r5 < 0) goto L4;
    L10:
        this.mDropDownHeight = r5;
        return;
    L4:
        if ((-2) == r5) goto L10;
        if ((-1) == r5) goto L10;
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void setHorizontalOffset(int r5) {
        this.mDropDownHorizontalOffset = r5;
    }

    public void setInputMethodMode(int r5) {
        this.mPopup.setInputMethodMode(r5);
    }

    public void setListItemExpandMax(int r5) {
        this.mListItemExpandMaximum = r5;
    }

    public void setListSelector(Drawable r5) {
        this.mDropDownListHighlight = r5;
    }

    public void setModal(boolean r5) {
        this.mModal = r5;
        this.mPopup.setFocusable(r5);
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener r5) {
        this.mPopup.setOnDismissListener(r5);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener r5) {
        this.mItemClickListener = r5;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r5) {
        this.mItemSelectedListener = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean r5) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = r5;
    }

    public void setPromptPosition(int r5) {
        this.mPromptPosition = r5;
    }

    public void setPromptView(@Nullable View r5) {
        boolean r10 = isShowing();
        if (r10 == false) goto L5;
        removePromptView();
    L5:
        this.mPromptView = r5;
        if (r10 == false) goto L9;
        show();
        return;
    }

    public void setSelection(int r5) {
        DropDownListView r10 = this.mDropDownList;
        if (isShowing() == false) goto L9;
        if (r10 == null) goto L10;
        r10.setListSelectionHidden(false);
        r10.setSelection(r5);
        if (r10.getChoiceMode() == 0) goto L11;
        r10.setItemChecked(r5, true);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setSoftInputMode(int r5) {
        this.mPopup.setSoftInputMode(r5);
    }

    public void setVerticalOffset(int r5) {
        this.mDropDownVerticalOffset = r5;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int r5) {
        this.mDropDownWidth = r5;
    }

    public void setWindowLayoutType(int r5) {
        this.mDropDownWindowLayoutType = r5;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int r5 = buildDropDown();
        boolean r10 = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        boolean r11 = true;
        if (this.mPopup.isShowing() == true) goto L5;
        int r12 = this.mDropDownWidth;
        if (r12 != (-1)) goto L48;
        r12 = -1;
    L50:
        int r13 = this.mDropDownHeight;
        if (r13 != (-1)) goto L53;
        r5 = -1;
    L56:
        this.mPopup.setWidth(r12);
        this.mPopup.setHeight(r5);
        setPopupClipToScreenEnabled(true);
        PopupWindow r14 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch == false) goto L59;
    L61:
        r11 = false;
    L62:
        r14.setOutsideTouchable(r11);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        if (this.mOverlapAnchorSet == false) goto L65;
        PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
    L65:
        Api29Impl.setEpicenterBounds(this.mPopup, this.mEpicenterBounds);
        PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if (this.mModal == true) goto L68;
    L69:
        clearListSelection();
    L71:
        if (this.mModal == true) goto L75;
        this.mHandler.post(this.mHideSelector);
        return;
    L75:
        return;
    L68:
        if (this.mDropDownList.isInTouchMode() == false) goto L71;
    L59:
        if (this.mDropDownAlwaysVisible == true) goto L61;
    L53:
        if (r13 == (-2)) goto L56;
        r5 = r13;
        goto L56
    L48:
        if (r12 != (-2)) goto L50;
        r12 = getAnchorView().getWidth();
        goto L50
    L5:
        if (ViewCompat.isAttachedToWindow(getAnchorView()) == true) goto L7;
        return;
    L7:
        int r15 = this.mDropDownWidth;
        if (r15 != (-1)) goto L10;
        r15 = -1;
    L12:
        int r16 = this.mDropDownHeight;
        if (r16 != (-1)) goto L28;
        if (r10 == true) goto L17;
        r5 = -1;
    L17:
        if (r10 == false) goto L23;
        PopupWindow r17 = this.mPopup;
        if (this.mDropDownWidth != (-1)) goto L21;
        int r18 = -1;
    L22:
        r17.setWidth(r18);
        this.mPopup.setHeight(0);
    L31:
        PopupWindow r19 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch == false) goto L34;
    L36:
        r11 = false;
    L37:
        r19.setOutsideTouchable(r11);
        PopupWindow r20 = this.mPopup;
        View r21 = getAnchorView();
        int r22 = this.mDropDownHorizontalOffset;
        int r110 = this.mDropDownVerticalOffset;
        if (r15 >= 0) goto L40;
        int r111 = -1;
    L41:
        if (r5 >= 0) goto L43;
        int r112 = -1;
    L44:
        r20.update(r21, r22, r110, r111, r112);
        return;
    L43:
        r112 = r5;
        goto L44
    L40:
        r111 = r15;
        goto L41
    L34:
        if (this.mDropDownAlwaysVisible == true) goto L36;
    L21:
        r18 = 0;
        goto L22
    L23:
        PopupWindow r23 = this.mPopup;
        if (this.mDropDownWidth != (-1)) goto L26;
        int r24 = -1;
    L27:
        r23.setWidth(r24);
        this.mPopup.setHeight(-1);
        goto L31
    L26:
        r24 = 0;
        goto L27
    L28:
        if (r16 == (-2)) goto L31;
        r5 = r16;
        goto L31
    L10:
        if (r15 != (-2)) goto L12;
        r15 = getAnchorView().getWidth();
        goto L12
    }

    public ListPopupWindow(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11) {
        this(r5, r10, r11, 0);
    }

    public ListPopupWindow(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = PointerIconCompat.TYPE_HAND;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable(this);
        this.mTouchInterceptor = new PopupTouchInterceptor(this);
        this.mScrollListener = new PopupScrollListener(this);
        this.mHideSelector = new ListSelectorHider(this);
        this.mTempRect = new Rect();
        this.mContext = r5;
        this.mHandler = new Handler(r5.getMainLooper());
        TypedArray r13 = r5.obtainStyledAttributes(r10, R.styleable.ListPopupWindow, r11, r12);
        this.mDropDownHorizontalOffset = r13.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int r14 = r13.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.mDropDownVerticalOffset = r14;
        if (r14 == 0) goto L5;
        this.mDropDownVerticalOffsetSet = true;
    L5:
        r13.recycle();
        AppCompatPopupWindow r15 = new AppCompatPopupWindow(r5, r10, r11, r12);
        this.mPopup = r15;
        r15.setInputMethodMode(1);
    }
}
