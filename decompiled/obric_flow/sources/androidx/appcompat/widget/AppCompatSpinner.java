package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {

    @SuppressLint({"ResourceType"})
    @StyleableRes
    private static final int[] ATTRS_ANDROID_SPINNERMODE = null;
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private SpinnerPopup mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    @RequiresApi(16)
    public static final class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static void removeOnGlobalLayoutListener(@NonNull ViewTreeObserver r5, @Nullable ViewTreeObserver.OnGlobalLayoutListener r10) {
            r5.removeOnGlobalLayoutListener(r10);
        }
    }

    @RequiresApi(17)
    public static final class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static int getTextAlignment(@NonNull View r5) {
            return r5.getTextAlignment();
        }

        @DoNotInline
        public static int getTextDirection(@NonNull View r5) {
            return r5.getTextDirection();
        }

        @DoNotInline
        public static void setTextAlignment(@NonNull View r5, int r10) {
            r5.setTextAlignment(r10);
        }

        @DoNotInline
        public static void setTextDirection(@NonNull View r5, int r10) {
            r5.setTextDirection(r10);
        }
    }

    @RequiresApi(23)
    public static final class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void setDropDownViewTheme(@NonNull android.widget.ThemedSpinnerAdapter r5, @Nullable Resources.Theme r10) {
            if (ObjectsCompat.equals(r5.getDropDownViewTheme(), r10) == true) goto L6;
            r5.setDropDownViewTheme(r10);
            return;
        }
    }

    @VisibleForTesting
    public class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private ListAdapter mListAdapter;

        @VisibleForTesting
        AlertDialog mPopup;
        private CharSequence mPrompt;
        final /* synthetic */ AppCompatSpinner this$0;

        public DialogPopup(AppCompatSpinner r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void dismiss() {
            AlertDialog r5 = this.mPopup;
            if (r5 == null) goto L6;
            r5.dismiss();
            this.mPopup = null;
            return;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.mPrompt;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public boolean isShowing() {
            AlertDialog r5 = this.mPopup;
            if (r5 != null) goto L7;
            return false;
        L7:
            return r5.isShowing();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r5, int r10) {
            this.this$0.setSelection(r10);
            if (this.this$0.getOnItemClickListener() == null) goto L5;
            this.this$0.performItemClick(null, r10, this.mListAdapter.getItemId(r10));
        L5:
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r5) {
            this.mListAdapter = r5;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setBackgroundDrawable(Drawable r5) {
            Log.e(AppCompatSpinner.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOffset(int r5) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r5) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r5) {
            this.mPrompt = r5;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setVerticalOffset(int r5) {
            Log.e(AppCompatSpinner.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r5, int r10) {
            if (this.mListAdapter != null) goto L5;
            return;
        L5:
            AlertDialog.Builder r11 = new AlertDialog.Builder(this.this$0.getPopupContext());
            CharSequence r12 = this.mPrompt;
            if (r12 == null) goto L8;
            r11.setTitle(r12);
        L8:
            AlertDialog r13 = r11.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).create();
            this.mPopup = r13;
            ListView r14 = r13.getListView();
            Api17Impl.setTextDirection(r14, r5);
            Api17Impl.setTextAlignment(r14, r10);
            this.mPopup.show();
        }
    }

    public static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(@Nullable SpinnerAdapter r5, @Nullable Resources.Theme r10) {
            this.mAdapter = r5;
            if ((r5 instanceof ListAdapter) == false) goto L5;
            this.mListAdapter = (ListAdapter) r5;
        L5:
            if (r10 != null) goto L7;
            return;
        L7:
            if ((r5 instanceof android.widget.ThemedSpinnerAdapter) == false) goto L10;
            Api23Impl.setDropDownViewTheme((android.widget.ThemedSpinnerAdapter) r5, r10);
            return;
        L10:
            if ((r5 instanceof ThemedSpinnerAdapter) == false) goto L17;
            ThemedSpinnerAdapter r11 = (ThemedSpinnerAdapter) r5;
            if (r11.getDropDownViewTheme() != null) goto L18;
            r11.setDropDownViewTheme(r10);
            return;
        L18:
            return;
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter r5 = this.mListAdapter;
            if (r5 != null) goto L5;
            return true;
        L5:
            return r5.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter r5 = this.mAdapter;
            if (r5 != null) goto L6;
            return 0;
        L6:
            return r5.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int r5, View r10, ViewGroup r11) {
            SpinnerAdapter r12 = this.mAdapter;
            if (r12 != null) goto L6;
            return null;
        L6:
            return r12.getDropDownView(r5, r10, r11);
        }

        @Override // android.widget.Adapter
        public Object getItem(int r5) {
            SpinnerAdapter r10 = this.mAdapter;
            if (r10 != null) goto L6;
            return null;
        L6:
            return r10.getItem(r5);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r5) {
            SpinnerAdapter r10 = this.mAdapter;
            if (r10 != null) goto L6;
            return -1;
        L6:
            return r10.getItemId(r5);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int r5) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r10, ViewGroup r11) {
            return getDropDownView(r5, r10, r11);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter r5 = this.mAdapter;
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if (r5.hasStableIds() == false) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            if (getCount() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int r5) {
            ListAdapter r10 = this.mListAdapter;
            if (r10 != null) goto L5;
            return true;
        L5:
            return r10.isEnabled(r5);
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver r5) {
            SpinnerAdapter r10 = this.mAdapter;
            if (r10 == null) goto L6;
            r10.registerDataSetObserver(r5);
            return;
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver r5) {
            SpinnerAdapter r10 = this.mAdapter;
            if (r10 == null) goto L6;
            r10.unregisterDataSetObserver(r5);
            return;
        }
    }

    @VisibleForTesting
    public class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        ListAdapter mAdapter;
        private CharSequence mHintText;
        private int mOriginalHorizontalOffset;
        private final Rect mVisibleRect;
        final /* synthetic */ AppCompatSpinner this$0;

        public DropdownPopup(final AppCompatSpinner r5, Context r10, AttributeSet r11, int r12) {
            this.this$0 = r5;
            super(r10, r11, r12);
            this.mVisibleRect = new Rect();
            setAnchorView(r5);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AnonymousClass1(this, r5));
        }

        public static /* synthetic */ void access$001(DropdownPopup r5) {
            super.show();
        }

        public void computeContentWidth() {
            Drawable r5 = getBackground();
            if (r5 == null) goto L8;
            r5.getPadding(this.this$0.mTempRect);
            if (ViewUtils.isLayoutRtl(this.this$0) == false) goto L7;
            int r10 = this.this$0.mTempRect.right;
        L9:
            int r11 = this.this$0.getPaddingLeft();
            int r12 = this.this$0.getPaddingRight();
            int r13 = this.this$0.getWidth();
            AppCompatSpinner r14 = this.this$0;
            int r15 = r14.mDropDownWidth;
            if (r15 != (-2)) goto L16;
            int r16 = r14.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
            int r17 = this.this$0.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect r18 = this.this$0.mTempRect;
            int r19 = (r17 - r18.left) - r18.right;
            if (r16 <= r19) goto L14;
            r16 = r19;
        L14:
            setContentWidth(Math.max(r16, (r13 - r11) - r12));
        L20:
            if (ViewUtils.isLayoutRtl(this.this$0) == false) goto L22;
            int r20 = (((r13 - r12) - getWidth()) - getHorizontalOriginalOffset()) + r10;
        L23:
            setHorizontalOffset(r20);
            return;
        L22:
            r20 = (r11 + getHorizontalOriginalOffset()) + r10;
            goto L23
        L16:
            if (r15 != (-1)) goto L18;
            setContentWidth((r13 - r11) - r12);
            goto L20
        L18:
            setContentWidth(r15);
            goto L20
        L7:
            r10 = -this.this$0.mTempRect.left;
            goto L9
        L8:
            Rect r21 = this.this$0.mTempRect;
            r21.right = 0;
            r21.left = 0;
            r10 = 0;
            goto L9
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.mHintText;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return this.mOriginalHorizontalOffset;
        }

        public boolean isVisibleToUser(View r5) {
            if (ViewCompat.isAttachedToWindow(r5) == true) goto L5;
        L7:
            return false;
        L5:
            if (r5.getGlobalVisibleRect(this.mVisibleRect) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r5) {
            super.setAdapter(r5);
            this.mAdapter = r5;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r5) {
            this.mOriginalHorizontalOffset = r5;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r5) {
            this.mHintText = r5;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r5, int r10) {
            boolean r11 = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            ListView r12 = getListView();
            r12.setChoiceMode(1);
            Api17Impl.setTextDirection(r12, r5);
            Api17Impl.setTextAlignment(r12, r10);
            setSelection(this.this$0.getSelectedItemPosition());
            if (r11 == false) goto L5;
            return;
        L5:
            ViewTreeObserver r13 = this.this$0.getViewTreeObserver();
            if (r13 == null) goto L9;
            final ViewTreeObserver.OnGlobalLayoutListener r14 = new AnonymousClass2(this);
            r13.addOnGlobalLayoutListener(r14);
            setOnDismissListener(new AnonymousClass3(this, r14));
            return;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mShowDropdown;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeByte(this.mShowDropdown ? 1 : 0);
        }

        public SavedState(Parcel r5) {
            super(r5);
            if (r5.readByte() == 0) goto L5;
            boolean r10 = true;
        L6:
            this.mShowDropdown = r10;
            return;
        L5:
            r10 = false;
            goto L6
        }
    }

    @VisibleForTesting
    public interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getHorizontalOriginalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter r5);

        void setBackgroundDrawable(Drawable r5);

        void setHorizontalOffset(int r5);

        void setHorizontalOriginalOffset(int r5);

        void setPromptText(CharSequence r5);

        void setVerticalOffset(int r5);

        void show(int r5, int r10);
    }

    static {
        ATTRS_ANDROID_SPINNERMODE = new int[]{R.attr.spinnerMode};
    }

    public AppCompatSpinner(@NonNull Context r5) {
        this(r5, null);
    }

    public int compatMeasureContentWidth(SpinnerAdapter r11, Drawable r12) {
        int r5 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r10 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r13 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r14 = Math.max(0, getSelectedItemPosition());
        int r15 = Math.min(r11.getCount(), r14 + 15);
        int r16 = Math.max(0, r14 - (15 - (r15 - r14)));
        View r17 = null;
        int r18 = 0;
    L6:
        if (r16 >= r15) goto L14;
        int r19 = r11.getItemViewType(r16);
        if (r19 == r5) goto L10;
        r17 = null;
        r5 = r19;
    L10:
        r17 = r11.getView(r16, r17, this);
        if (r17.getLayoutParams() != null) goto L13;
        r17.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L13:
        r17.measure(r10, r13);
        r18 = Math.max(r18, r17.getMeasuredWidth());
        r16 = r16 + 1;
        goto L6
    L14:
        if (r12 == null) goto L20;
        r12.getPadding(this.mTempRect);
        Rect r110 = this.mTempRect;
        return r18 + (r110.left + r110.right);
    L20:
        return r18;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r5 = this.mBackgroundTintHelper;
        if (r5 == null) goto L6;
        r5.applySupportBackgroundTint();
        return;
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup r5 = this.mPopup;
        if (r5 == null) goto L7;
        return r5.getHorizontalOffset();
    L7:
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup r5 = this.mPopup;
        if (r5 == null) goto L7;
        return r5.getVerticalOffset();
    L7:
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup == null) goto L7;
        return this.mDropDownWidth;
    L7:
        return super.getDropDownWidth();
    }

    @VisibleForTesting
    public final SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup r5 = this.mPopup;
        if (r5 == null) goto L7;
        return r5.getBackground();
    L7:
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup r5 = this.mPopup;
        if (r5 == null) goto L6;
        return r5.getHintText();
    L6:
        return super.getPrompt();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r5 = this.mBackgroundTintHelper;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r5 = this.mBackgroundTintHelper;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup r5 = this.mPopup;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isShowing() == false) goto L9;
        this.mPopup.dismiss();
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        if (this.mPopup != null) goto L5;
        return;
    L5:
        if (View.MeasureSpec.getMode(r5) != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(r5)), getMeasuredHeight());
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        if (r10.mShowDropdown == false) goto L8;
        ViewTreeObserver r11 = getViewTreeObserver();
        if (r11 == null) goto L9;
        r11.addOnGlobalLayoutListener(new AnonymousClass2(this));
        return;
    L9:
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        SpinnerPopup r10 = this.mPopup;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        r5.mShowDropdown = r11;
        return r5;
    L5:
        if (r10.isShowing() == false) goto L7;
        r11 = true;
        goto L8
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        ForwardingListener r10 = this.mForwardingListener;
        if (r10 == null) goto L9;
        if (r10.onTouch(this, r5) == false) goto L9;
        return true;
    L9:
        return super.onTouchEvent(r5);
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        SpinnerPopup r5 = this.mPopup;
        if (r5 == null) goto L10;
        if (r5.isShowing() == true) goto L11;
        showPopup();
        return true;
    L11:
        return true;
    L10:
        return super.performClick();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r5) {
        setAdapter((SpinnerAdapter) r5);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable r5) {
        super.setBackgroundDrawable(r5);
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L6;
        r10.onSetBackgroundDrawable(r5);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r5) {
        super.setBackgroundResource(r5);
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L6;
        r10.onSetBackgroundResource(r5);
        return;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int r5) {
        SpinnerPopup r10 = this.mPopup;
        if (r10 == null) goto L5;
        r10.setHorizontalOriginalOffset(r5);
        this.mPopup.setHorizontalOffset(r5);
        return;
    L5:
        super.setDropDownHorizontalOffset(r5);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int r5) {
        SpinnerPopup r10 = this.mPopup;
        if (r10 == null) goto L5;
        r10.setVerticalOffset(r5);
        return;
    L5:
        super.setDropDownVerticalOffset(r5);
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int r5) {
        if (this.mPopup == null) goto L5;
        this.mDropDownWidth = r5;
        return;
    L5:
        super.setDropDownWidth(r5);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable r5) {
        SpinnerPopup r10 = this.mPopup;
        if (r10 == null) goto L5;
        r10.setBackgroundDrawable(r5);
        return;
    L5:
        super.setPopupBackgroundDrawable(r5);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int r5) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), r5));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence r5) {
        SpinnerPopup r10 = this.mPopup;
        if (r10 == null) goto L5;
        r10.setPromptText(r5);
        return;
    L5:
        super.setPrompt(r5);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r5) {
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L6;
        r10.setSupportBackgroundTintList(r5);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L6;
        r10.setSupportBackgroundTintMode(r5);
        return;
    }

    public void showPopup() {
        this.mPopup.show(Api17Impl.getTextDirection(this), Api17Impl.getTextAlignment(this));
    }

    public AppCompatSpinner(@NonNull Context r5, int r10) {
        this(r5, null, androidx.appcompat.R.attr.spinnerStyle, r10);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter r5) {
        if (this.mPopupSet == true) goto L6;
        this.mTempAdapter = r5;
        return;
    L6:
        super.setAdapter(r5);
        if (this.mPopup == null) goto L13;
        Context r10 = this.mPopupContext;
        if (r10 != null) goto L11;
        r10 = getContext();
    L11:
        this.mPopup.setAdapter(new DropDownAdapter(r5, r10.getTheme()));
        return;
    }

    public AppCompatSpinner(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, androidx.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        this(r5, r10, r11, -1);
    }

    public AppCompatSpinner(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        this(r10, r11, r12, r13, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.AppCompatSpinner] */
    public AppCompatSpinner(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13, Resources.Theme r14) {
        super(r10, r11, r12);
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TintTypedArray r5 = TintTypedArray.obtainStyledAttributes(r10, r11, androidx.appcompat.R.styleable.Spinner, r12, 0);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        if (r14 == null) goto L5;
        this.mPopupContext = new ContextThemeWrapper(r10, r14);
    L9:
        ?? r15 = -1;
        ?? r16 = 0;
        if (r13 != (-1)) goto L32;
        TypedArray r17 = r10.obtainStyledAttributes(r11, ATTRS_ANDROID_SPINNERMODE, r12, 0);     // Catch: Throwable -> L21 Exception -> L23
        boolean r18 = r17.hasValue(0);     // Catch: Throwable -> L16 Exception -> L18
        r15 = r17;
        if (r18 == false) goto L20;
        r13 = r17.getInt(0, 0);     // Catch: Throwable -> L16 Exception -> L18
        r15 = r17;
    L20:
        r15.recycle();
    L18:
        e = e;
    L25:
        Log.i(TAG, "Could not read android:spinnerMode", e);     // Catch: Throwable -> L16
        r15 = r17;
        if (r17 == null) goto L32;
    L23:
        e = e;
        r17 = null;
    L21:
        th = th;
    L28:
        if (r16 == 0) goto L30;
        r16.recycle();
    L30:
        throw th;
    L32:
        if (r13 == 0) goto L36;
        if (r13 != 1) goto L37;
        final DropdownPopup r19 = new DropdownPopup(this, this.mPopupContext, r11, r12);
        TintTypedArray r20 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, r11, androidx.appcompat.R.styleable.Spinner, r12, 0);
        this.mDropDownWidth = r20.getLayoutDimension(androidx.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
        r19.setBackgroundDrawable(r20.getDrawable(androidx.appcompat.R.styleable.Spinner_android_popupBackground));
        r19.setPromptText(r5.getString(androidx.appcompat.R.styleable.Spinner_android_prompt));
        r20.recycle();
        this.mPopup = r19;
        this.mForwardingListener = new AnonymousClass1(this, this, r19);
    L37:
        CharSequence[] r110 = r5.getTextArray(androidx.appcompat.R.styleable.Spinner_android_entries);
        if (r110 == null) goto L40;
        ArrayAdapter r21 = new ArrayAdapter(r10, R.layout.simple_spinner_item, r110);
        r21.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        setAdapter(r21);
    L40:
        r5.recycle();
        this.mPopupSet = true;
        SpinnerAdapter r22 = this.mTempAdapter;
        if (r22 == null) goto L43;
        setAdapter(r22);
        this.mTempAdapter = null;
    L43:
        this.mBackgroundTintHelper.loadFromAttributes(r11, r12);
        return;
    L36:
        DialogPopup r111 = new DialogPopup(this);
        this.mPopup = r111;
        r111.setPromptText(r5.getString(androidx.appcompat.R.styleable.Spinner_android_prompt));
    L16:
        th = th;
        r16 = r15;
        goto L28
    L5:
        int r112 = r5.getResourceId(androidx.appcompat.R.styleable.Spinner_popupTheme, 0);
        if (r112 == 0) goto L8;
        this.mPopupContext = new ContextThemeWrapper(r10, r112);
        goto L9
    L8:
        this.mPopupContext = r10;
        goto L9
    }
}
