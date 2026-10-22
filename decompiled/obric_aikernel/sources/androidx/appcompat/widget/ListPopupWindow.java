package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static int getMaxAvailableHeight(PopupWindow r10, View r11, int r12, boolean r13) {
            return r10.getMaxAvailableHeight(r11, r12, r13);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setEpicenterBounds(PopupWindow r10, Rect r11) {
            r10.setEpicenterBounds(r11);
        }

        @DoNotInline
        static void setIsClippedToScreen(PopupWindow r10, boolean r11) {
            r10.setIsClippedToScreen(r11);
        }
    }

    private class ListSelectorHider implements Runnable {
        final /* synthetic */ ListPopupWindow this$0;

        ListSelectorHider(ListPopupWindow r10) {
            this.this$0 = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.clearListSelection();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        final /* synthetic */ ListPopupWindow this$0;

        PopupDataSetObserver(ListPopupWindow r10) {
            this.this$0 = r10;
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

    private class PopupScrollListener implements AbsListView.OnScrollListener {
        final /* synthetic */ ListPopupWindow this$0;

        PopupScrollListener(ListPopupWindow r10) {
            this.this$0 = r10;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView r10, int r11, int r12, int r13) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView r10, int r11) {
            if (r11 == 1) goto L5;
            return;
        L5:
            if (this.this$0.isInputMethodNotNeeded() == false) goto L7;
            return;
        L7:
            if (this.this$0.mPopup.getContentView() == null) goto L12;
            ListPopupWindow r12 = this.this$0;
            r12.mHandler.removeCallbacks(r12.mResizePopupRunnable);
            this.this$0.mResizePopupRunnable.run();
            return;
        }
    }

    private class PopupTouchInterceptor implements View.OnTouchListener {
        final /* synthetic */ ListPopupWindow this$0;

        PopupTouchInterceptor(ListPopupWindow r10) {
            this.this$0 = r10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            int r12 = r11.getAction();
            int r13 = (int) r11.getX();
            int r14 = (int) r11.getY();
            if (r12 != 0) goto L16;
            PopupWindow r15 = this.this$0.mPopup;
            if (r15 == null) goto L16;
            if (r15.isShowing() == false) goto L16;
            if (r13 < 0) goto L16;
            if (r13 >= this.this$0.mPopup.getWidth()) goto L16;
            if (r14 < 0) goto L16;
            if (r14 >= this.this$0.mPopup.getHeight()) goto L16;
            ListPopupWindow r16 = this.this$0;
            r16.mHandler.postDelayed(r16.mResizePopupRunnable, 250);
            return false;
        L16:
            if (r12 != 1) goto L21;
            ListPopupWindow r17 = this.this$0;
            r17.mHandler.removeCallbacks(r17.mResizePopupRunnable);
            return false;
        L21:
            return false;
        }
    }

    private class ResizePopupRunnable implements Runnable {
        final /* synthetic */ ListPopupWindow this$0;

        ResizePopupRunnable(ListPopupWindow r10) {
            this.this$0 = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView r10 = this.this$0.mDropDownList;
            if (r10 != null) goto L5;
            return;
        L5:
            if (ViewCompat.isAttachedToWindow(r10) == true) goto L7;
            return;
        L7:
            if (this.this$0.mDropDownList.getCount() <= this.this$0.mDropDownList.getChildCount()) goto L14;
            int r11 = this.this$0.mDropDownList.getChildCount();
            ListPopupWindow r12 = this.this$0;
            if (r11 > r12.mListItemExpandMaximum) goto L15;
            r12.mPopup.setInputMethodMode(2);
            this.this$0.show();
            return;
        L15:
            return;
        }
    }

    static {
        if (Build.VERSION.SDK_INT > 28) goto L11;
        sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
    L18:
        sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});     // Catch: NoSuchMethodException -> L9
    L9:
        Log.i(TAG, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
    L6:
        Log.i(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
    L11:
        if (Build.VERSION.SDK_INT > 23) goto L22;
        sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});     // Catch: NoSuchMethodException -> L14
        return;
    L14:
        Log.i(TAG, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        return;
    }

    public ListPopupWindow(@NonNull Context r10) {
        this(r10, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        this(r10, r11, r12, 0);
    }

    public ListPopupWindow(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
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
        this.mContext = r10;
        this.mHandler = new Handler(r10.getMainLooper());
        TypedArray r14 = r10.obtainStyledAttributes(r11, R.styleable.ListPopupWindow, r12, r13);
        this.mDropDownHorizontalOffset = r14.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int r15 = r14.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.mDropDownVerticalOffset = r15;
        if (r15 == 0) goto L5;
        this.mDropDownVerticalOffsetSet = true;
    L5:
        r14.recycle();
        AppCompatPopupWindow r16 = new AppCompatPopupWindow(r10, r11, r12, r13);
        this.mPopup = r16;
        r16.setInputMethodMode(1);
    }

    private int buildDropDown() {
        int r10 = Integer.MIN_VALUE;
        boolean r11 = true;
        if (this.mDropDownList != null) goto L25;
        Context r12 = this.mContext;
        this.mShowDropDownRunnable = new AnonymousClass2(this);
        DropDownListView r13 = createDropDownListView(r12, !this.mModal);
        this.mDropDownList = r13;
        Drawable r14 = this.mDropDownListHighlight;
        if (r14 == null) goto L7;
        r13.setSelector(r14);
    L7:
        this.mDropDownList.setAdapter(this.mAdapter);
        this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
        this.mDropDownList.setFocusable(true);
        this.mDropDownList.setFocusableInTouchMode(true);
        this.mDropDownList.setOnItemSelectedListener(new AnonymousClass3(this));
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        AdapterView.OnItemSelectedListener r15 = this.mItemSelectedListener;
        if (r15 == null) goto L10;
        this.mDropDownList.setOnItemSelectedListener(r15);
    L10:
        DropDownListView r16 = this.mDropDownList;
        View r17 = this.mPromptView;
        if (r17 == null) goto L23;
        LinearLayout r18 = new LinearLayout(r12);
        r18.setOrientation(1);
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        int r20 = this.mPromptPosition;
        if (r20 == 0) goto L17;
        if (r20 == 1) goto L16;
        Log.e(TAG, "Invalid hint position " + this.mPromptPosition);
    L18:
        int r21 = this.mDropDownWidth;
        if (r21 < 0) goto L21;
        int r22 = Integer.MIN_VALUE;
    L22:
        r17.measure(View.MeasureSpec.makeMeasureSpec(r21, r22), 0);
        LinearLayout.LayoutParams r23 = (LinearLayout.LayoutParams) r17.getLayoutParams();
        int r24 = (r17.getMeasuredHeight() + r23.topMargin) + r23.bottomMargin;
        View r25 = r18;
    L24:
        this.mPopup.setContentView(r25);
    L29:
        Drawable r26 = this.mPopup.getBackground();
        if (r26 == null) goto L34;
        r26.getPadding(this.mTempRect);
        Rect r27 = this.mTempRect;
        int r28 = r27.top;
        int r29 = r27.bottom + r28;
        if (this.mDropDownVerticalOffsetSet == true) goto L36;
        this.mDropDownVerticalOffset = -r28;
    L36:
        if (this.mPopup.getInputMethodMode() == 2) goto L39;
        r11 = false;
    L39:
        int r30 = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, r11);
        if (this.mDropDownAlwaysVisible == true) goto L56;
        if (this.mDropDownHeight == (-1)) goto L56;
        int r31 = this.mDropDownWidth;
        if (r31 == (-2)) goto L49;
        r10 = 1073741824;
        if (r31 == (-1)) goto L49;
        int r32 = View.MeasureSpec.makeMeasureSpec(r31, 1073741824);
    L50:
        int r33 = this.mDropDownList.measureHeightOfChildrenCompat(r32, 0, -1, r30 - r24, -1);
        if (r33 <= 0) goto L54;
        r24 = r24 + (r29 + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom()));
    L54:
        return r33 + r24;
    L49:
        int r34 = this.mContext.getResources().getDisplayMetrics().widthPixels;
        Rect r35 = this.mTempRect;
        r32 = View.MeasureSpec.makeMeasureSpec(r34 - (r35.left + r35.right), r10);
    L56:
        return r30 + r29;
    L34:
        this.mTempRect.setEmpty();
        r29 = 0;
        goto L36
    L21:
        r21 = 0;
        r22 = 0;
        goto L22
    L16:
        r18.addView(r16, r19);
        r18.addView(r17);
        goto L18
    L17:
        r18.addView(r17);
        r18.addView(r16, r19);
        goto L18
    L23:
        r24 = 0;
        r25 = r16;
        goto L24
    L25:
        ViewGroup r36 = (ViewGroup) this.mPopup.getContentView();
        View r37 = this.mPromptView;
        if (r37 == null) goto L28;
        LinearLayout.LayoutParams r38 = (LinearLayout.LayoutParams) r37.getLayoutParams();
        r24 = (r37.getMeasuredHeight() + r38.topMargin) + r38.bottomMargin;
        goto L29
    L28:
        r24 = 0;
        goto L29
    }

    private int getMaxAvailableHeight(View r10, int r11, boolean r12) {
        if (Build.VERSION.SDK_INT > 23) goto L12;
        Method r13 = sGetMaxAvailableHeightMethod;
        if (r13 == null) goto L10;
        return ((Integer) r13.invoke(this.mPopup, new Object[]{r10, Integer.valueOf(r11), Boolean.valueOf(r12)})).intValue();
    L8:
        Log.i(TAG, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
    L10:
        return this.mPopup.getMaxAvailableHeight(r10, r11);
    L12:
        return Api24Impl.getMaxAvailableHeight(this.mPopup, r10, r11, r12);
    }

    private static boolean isConfirmKey(int r10) {
        if (r10 != 66) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 23) goto L8;
        return false;
    }

    private void removePromptView() {
        View r10 = this.mPromptView;
        if (r10 == null) goto L8;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r11).removeView(this.mPromptView);
        return;
    L9:
        return;
    }

    private void setPopupClipToScreenEnabled(boolean r10) {
        if (Build.VERSION.SDK_INT > 28) goto L9;
        Method r11 = sSetClipToWindowEnabledMethod;
        if (r11 == null) goto L13;
        r11.invoke(this.mPopup, new Object[]{Boolean.valueOf(r10)});     // Catch: Exception -> L8
        return;
    L8:
        Log.i(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
        return;
    L13:
        return;
    L9:
        Api29Impl.setIsClippedToScreen(this.mPopup, r10);
    }

    public void clearListSelection() {
        DropDownListView r10 = this.mDropDownList;
        if (r10 == null) goto L6;
        r10.setListSelectionHidden(true);
        r10.requestLayout();
        return;
    }

    public View.OnTouchListener createDragToOpenListener(final View r10) {
        return new AnonymousClass1(this, r10);
    }

    @NonNull
    DropDownListView createDropDownListView(Context r10, boolean r11) {
        return new DropDownListView(r10, r11);
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
        int r12 = this.mDropDownList.getSelectedItemPosition();
        boolean r13 = !this.mPopup.isAboveAnchor();
        ListAdapter r14 = this.mAdapter;
        int r15 = Integer.MAX_VALUE;
        int r16 = Integer.MIN_VALUE;
        if (r14 == null) goto L21;
        boolean r17 = r14.areAllItemsEnabled();
        if (r17 == false) goto L15;
        int r18 = 0;
    L16:
        if (r17 == false) goto L18;
        int r19 = r14.getCount() - 1;
    L19:
        r15 = r18;
        r16 = r19;
        goto L21
    L18:
        r19 = this.mDropDownList.lookForSelectablePosition(r14.getCount() - 1, false);
        goto L19
    L15:
        r18 = this.mDropDownList.lookForSelectablePosition(0, true);
    L21:
        if (r13 == false) goto L25;
        if (r10 != 19) goto L25;
        if (r12 > r15) goto L25;
    L28:
        clearListSelection();
        this.mPopup.setInputMethodMode(1);
        show();
        return true;
    L25:
        if (r13 == true) goto L30;
        if (r10 != 20) goto L30;
        if (r12 >= r16) goto L28;
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
        if (r13 == false) goto L45;
        if (r10 != 20) goto L45;
        if (r12 != r16) goto L49;
        return true;
    L45:
        if (r13 == true) goto L49;
        if (r10 != 19) goto L49;
        if (r12 != r15) goto L49;
        return true;
    L9:
        if (isConfirmKey(r10) == true) goto L49;
        goto L10
    }

    public boolean onKeyPreIme(int r10, @NonNull KeyEvent r11) {
        if (r10 == 4) goto L5;
        return false;
    L5:
        if (isShowing() == false) goto L27;
        View r12 = this.mDropDownAnchorView;
        if (r11.getAction() != 0) goto L15;
        if (r11.getRepeatCount() != 0) goto L15;
        KeyEvent.DispatcherState r13 = r12.getKeyDispatcherState();
        if (r13 == null) goto L13;
        r13.startTracking(r11, this);
    L13:
        return true;
    L15:
        if (r11.getAction() != 1) goto L28;
        KeyEvent.DispatcherState r14 = r12.getKeyDispatcherState();
        if (r14 == null) goto L20;
        r14.handleUpEvent(r11);
    L20:
        if (r11.isTracking() == true) goto L22;
        return false;
    L22:
        if (r11.isCanceled() == true) goto L30;
        dismiss();
        return true;
    L30:
        return false;
    L28:
        return false;
    L27:
        return false;
    }

    public boolean onKeyUp(int r10, @NonNull KeyEvent r11) {
        if (isShowing() == true) goto L5;
        return false;
    L5:
        if (this.mDropDownList.getSelectedItemPosition() < 0) goto L14;
        boolean r12 = this.mDropDownList.onKeyUp(r10, r11);
        if (r12 == true) goto L9;
    L11:
        return r12;
    L9:
        if (isConfirmKey(r10) == false) goto L11;
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
        DropDownListView r11 = this.mDropDownList;
        View r12 = r11.getChildAt(r10 - r11.getFirstVisiblePosition());
        ListAdapter r13 = r11.getAdapter();
        this.mItemClickListener.onItemClick(r11, r12, r10, r13.getItemId(r10));
        return true;
    L11:
        return true;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(@Nullable ListAdapter r10) {
        DataSetObserver r11 = this.mObserver;
        if (r11 != null) goto L5;
        this.mObserver = new PopupDataSetObserver(this);
    L8:
        this.mAdapter = r10;
        if (r10 == null) goto L11;
        r10.registerDataSetObserver(this.mObserver);
    L11:
        DropDownListView r12 = this.mDropDownList;
        if (r12 == null) goto L15;
        r12.setAdapter(this.mAdapter);
        return;
    L15:
        return;
    L5:
        ListAdapter r13 = this.mAdapter;
        if (r13 == null) goto L8;
        r13.unregisterDataSetObserver(r11);
        goto L8
    }

    public void setAnchorView(@Nullable View r10) {
        this.mDropDownAnchorView = r10;
    }

    public void setAnimationStyle(@StyleRes int r10) {
        this.mPopup.setAnimationStyle(r10);
    }

    public void setBackgroundDrawable(@Nullable Drawable r10) {
        this.mPopup.setBackgroundDrawable(r10);
    }

    public void setContentWidth(int r10) {
        Drawable r11 = this.mPopup.getBackground();
        if (r11 == null) goto L5;
        r11.getPadding(this.mTempRect);
        Rect r12 = this.mTempRect;
        this.mDropDownWidth = (r12.left + r12.right) + r10;
        return;
    L5:
        setWidth(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean r10) {
        this.mDropDownAlwaysVisible = r10;
    }

    public void setDropDownGravity(int r10) {
        this.mDropDownGravity = r10;
    }

    public void setEpicenterBounds(@Nullable Rect r10) {
        if (r10 == null) goto L4;
        Rect r11 = new Rect(r10);
    L5:
        this.mEpicenterBounds = r11;
        return;
    L4:
        r11 = null;
        goto L5
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean r10) {
        this.mForceIgnoreOutsideTouch = r10;
    }

    public void setHeight(int r10) {
        if (r10 < 0) goto L4;
    L10:
        this.mDropDownHeight = r10;
        return;
    L4:
        if ((-2) == r10) goto L10;
        if ((-1) == r10) goto L10;
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void setHorizontalOffset(int r10) {
        this.mDropDownHorizontalOffset = r10;
    }

    public void setInputMethodMode(int r10) {
        this.mPopup.setInputMethodMode(r10);
    }

    void setListItemExpandMax(int r10) {
        this.mListItemExpandMaximum = r10;
    }

    public void setListSelector(Drawable r10) {
        this.mDropDownListHighlight = r10;
    }

    public void setModal(boolean r10) {
        this.mModal = r10;
        this.mPopup.setFocusable(r10);
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener r10) {
        this.mPopup.setOnDismissListener(r10);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener r10) {
        this.mItemClickListener = r10;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r10) {
        this.mItemSelectedListener = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean r10) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = r10;
    }

    public void setPromptPosition(int r10) {
        this.mPromptPosition = r10;
    }

    public void setPromptView(@Nullable View r10) {
        boolean r11 = isShowing();
        if (r11 == false) goto L5;
        removePromptView();
    L5:
        this.mPromptView = r10;
        if (r11 == false) goto L9;
        show();
        return;
    }

    public void setSelection(int r10) {
        DropDownListView r11 = this.mDropDownList;
        if (isShowing() == false) goto L9;
        if (r11 == null) goto L10;
        r11.setListSelectionHidden(false);
        r11.setSelection(r10);
        if (r11.getChoiceMode() == 0) goto L11;
        r11.setItemChecked(r10, true);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setSoftInputMode(int r10) {
        this.mPopup.setSoftInputMode(r10);
    }

    public void setVerticalOffset(int r10) {
        this.mDropDownVerticalOffset = r10;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int r10) {
        this.mDropDownWidth = r10;
    }

    public void setWindowLayoutType(int r10) {
        this.mDropDownWindowLayoutType = r10;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int r10 = buildDropDown();
        boolean r11 = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        boolean r12 = true;
        if (this.mPopup.isShowing() == true) goto L5;
        int r13 = this.mDropDownWidth;
        if (r13 != (-1)) goto L48;
        r13 = -1;
    L50:
        int r14 = this.mDropDownHeight;
        if (r14 != (-1)) goto L53;
        r10 = -1;
    L56:
        this.mPopup.setWidth(r13);
        this.mPopup.setHeight(r10);
        setPopupClipToScreenEnabled(true);
        PopupWindow r15 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch == false) goto L59;
    L61:
        boolean r16 = false;
    L62:
        r15.setOutsideTouchable(r16);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        if (this.mOverlapAnchorSet == false) goto L66;
        PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
    L66:
        if (Build.VERSION.SDK_INT > 28) goto L73;
        Method r17 = sSetEpicenterBoundsMethod;
        if (r17 != null) goto L83;
    L74:
        PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if (this.mModal == true) goto L77;
    L78:
        clearListSelection();
    L80:
        if (this.mModal == true) goto L86;
        this.mHandler.post(this.mHideSelector);
        return;
    L86:
        return;
    L77:
        if (this.mDropDownList.isInTouchMode() == false) goto L80;
    L83:
        r17.invoke(this.mPopup, new Object[]{this.mEpicenterBounds});     // Catch: Exception -> L71
    L71:
        e = move-exception;
        Log.e(TAG, "Could not invoke setEpicenterBounds on PopupWindow", e);
        goto L74
    L73:
        Api29Impl.setEpicenterBounds(this.mPopup, this.mEpicenterBounds);
        goto L74
    L59:
        if (this.mDropDownAlwaysVisible == true) goto L61;
        r16 = true;
        goto L62
    L53:
        if (r14 == (-2)) goto L56;
        r10 = r14;
        goto L56
    L48:
        if (r13 != (-2)) goto L50;
        r13 = getAnchorView().getWidth();
        goto L50
    L5:
        if (ViewCompat.isAttachedToWindow(getAnchorView()) == true) goto L7;
        return;
    L7:
        int r18 = this.mDropDownWidth;
        if (r18 != (-1)) goto L10;
        r18 = -1;
    L12:
        int r19 = this.mDropDownHeight;
        if (r19 != (-1)) goto L28;
        if (r11 == true) goto L17;
        r10 = -1;
    L17:
        if (r11 == false) goto L23;
        PopupWindow r20 = this.mPopup;
        if (this.mDropDownWidth != (-1)) goto L21;
        int r21 = -1;
    L22:
        r20.setWidth(r21);
        this.mPopup.setHeight(0);
    L31:
        PopupWindow r22 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch == false) goto L34;
    L36:
        r12 = false;
    L37:
        r22.setOutsideTouchable(r12);
        PopupWindow r23 = this.mPopup;
        View r24 = getAnchorView();
        int r25 = this.mDropDownHorizontalOffset;
        int r110 = this.mDropDownVerticalOffset;
        if (r18 >= 0) goto L40;
        int r111 = -1;
    L41:
        if (r10 >= 0) goto L43;
        int r112 = -1;
    L44:
        r23.update(r24, r25, r110, r111, r112);
        return;
    L43:
        r112 = r10;
        goto L44
    L40:
        r111 = r18;
        goto L41
    L34:
        if (this.mDropDownAlwaysVisible == true) goto L36;
    L21:
        r21 = 0;
        goto L22
    L23:
        PopupWindow r26 = this.mPopup;
        if (this.mDropDownWidth != (-1)) goto L26;
        int r27 = -1;
    L27:
        r26.setWidth(r27);
        this.mPopup.setHeight(-1);
        goto L31
    L26:
        r27 = 0;
        goto L27
    L28:
        if (r19 == (-2)) goto L31;
        r10 = r19;
        goto L31
    L10:
        if (r18 != (-2)) goto L12;
        r18 = getAnchorView().getWidth();
        goto L12
    }
}
