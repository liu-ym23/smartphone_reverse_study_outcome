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
import android.os.Build;
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
    private static final class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void removeOnGlobalLayoutListener(@NonNull ViewTreeObserver r10, @Nullable ViewTreeObserver.OnGlobalLayoutListener r11) {
            r10.removeOnGlobalLayoutListener(r11);
        }
    }

    @RequiresApi(17)
    private static final class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static int getTextAlignment(@NonNull View r10) {
            return r10.getTextAlignment();
        }

        @DoNotInline
        static int getTextDirection(@NonNull View r10) {
            return r10.getTextDirection();
        }

        @DoNotInline
        static void setTextAlignment(@NonNull View r10, int r11) {
            r10.setTextAlignment(r11);
        }

        @DoNotInline
        static void setTextDirection(@NonNull View r10, int r11) {
            r10.setTextDirection(r11);
        }
    }

    @RequiresApi(23)
    private static final class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void setDropDownViewTheme(@NonNull android.widget.ThemedSpinnerAdapter r10, @Nullable Resources.Theme r11) {
            if (ObjectsCompat.equals(r10.getDropDownViewTheme(), r11) == true) goto L6;
            r10.setDropDownViewTheme(r11);
            return;
        }
    }

    @VisibleForTesting
    class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private ListAdapter mListAdapter;

        @VisibleForTesting
        AlertDialog mPopup;
        private CharSequence mPrompt;
        final /* synthetic */ AppCompatSpinner this$0;

        DialogPopup(AppCompatSpinner r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void dismiss() {
            AlertDialog r10 = this.mPopup;
            if (r10 == null) goto L6;
            r10.dismiss();
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
            AlertDialog r10 = this.mPopup;
            if (r10 != null) goto L7;
            return false;
        L7:
            return r10.isShowing();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            this.this$0.setSelection(r11);
            if (this.this$0.getOnItemClickListener() == null) goto L5;
            this.this$0.performItemClick(null, r11, this.mListAdapter.getItemId(r11));
        L5:
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r10) {
            this.mListAdapter = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setBackgroundDrawable(Drawable r10) {
            Log.e(AppCompatSpinner.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOffset(int r10) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r10) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r10) {
            this.mPrompt = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setVerticalOffset(int r10) {
            Log.e(AppCompatSpinner.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r10, int r11) {
            if (this.mListAdapter != null) goto L5;
            return;
        L5:
            AlertDialog.Builder r12 = new AlertDialog.Builder(this.this$0.getPopupContext());
            CharSequence r13 = this.mPrompt;
            if (r13 == null) goto L8;
            r12.setTitle(r13);
        L8:
            AlertDialog r14 = r12.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).create();
            this.mPopup = r14;
            ListView r15 = r14.getListView();
            if (Build.VERSION.SDK_INT < 17) goto L11;
            Api17Impl.setTextDirection(r15, r10);
            Api17Impl.setTextAlignment(r15, r11);
        L11:
            this.mPopup.show();
        }
    }

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(@Nullable SpinnerAdapter r10, @Nullable Resources.Theme r11) {
            this.mAdapter = r10;
            if ((r10 instanceof ListAdapter) == false) goto L5;
            this.mListAdapter = (ListAdapter) r10;
        L5:
            if (r11 != null) goto L7;
            return;
        L7:
            if (Build.VERSION.SDK_INT < 23) goto L12;
            if ((r10 instanceof android.widget.ThemedSpinnerAdapter) == false) goto L12;
            Api23Impl.setDropDownViewTheme((android.widget.ThemedSpinnerAdapter) r10, r11);
            return;
        L12:
            if ((r10 instanceof ThemedSpinnerAdapter) == false) goto L19;
            ThemedSpinnerAdapter r12 = (ThemedSpinnerAdapter) r10;
            if (r12.getDropDownViewTheme() != null) goto L20;
            r12.setDropDownViewTheme(r11);
            return;
        L20:
            return;
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter r10 = this.mListAdapter;
            if (r10 != null) goto L5;
            return true;
        L5:
            return r10.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter r10 = this.mAdapter;
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int r10, View r11, ViewGroup r12) {
            SpinnerAdapter r13 = this.mAdapter;
            if (r13 != null) goto L6;
            return null;
        L6:
            return r13.getDropDownView(r10, r11, r12);
        }

        @Override // android.widget.Adapter
        public Object getItem(int r10) {
            SpinnerAdapter r11 = this.mAdapter;
            if (r11 != null) goto L6;
            return null;
        L6:
            return r11.getItem(r10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            SpinnerAdapter r11 = this.mAdapter;
            if (r11 != null) goto L6;
            return -1;
        L6:
            return r11.getItemId(r10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int r10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            return getDropDownView(r10, r11, r12);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter r10 = this.mAdapter;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.hasStableIds() == false) goto L7;
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
        public boolean isEnabled(int r10) {
            ListAdapter r11 = this.mListAdapter;
            if (r11 != null) goto L5;
            return true;
        L5:
            return r11.isEnabled(r10);
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver r10) {
            SpinnerAdapter r11 = this.mAdapter;
            if (r11 == null) goto L6;
            r11.registerDataSetObserver(r10);
            return;
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver r10) {
            SpinnerAdapter r11 = this.mAdapter;
            if (r11 == null) goto L6;
            r11.unregisterDataSetObserver(r10);
            return;
        }
    }

    @VisibleForTesting
    class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        ListAdapter mAdapter;
        private CharSequence mHintText;
        private int mOriginalHorizontalOffset;
        private final Rect mVisibleRect;
        final /* synthetic */ AppCompatSpinner this$0;

        public DropdownPopup(final AppCompatSpinner r10, Context r11, AttributeSet r12, int r13) {
            this.this$0 = r10;
            super(r11, r12, r13);
            this.mVisibleRect = new Rect();
            setAnchorView(r10);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AnonymousClass1(this, r10));
        }

        static /* synthetic */ void access$001(DropdownPopup r10) {
            super.show();
        }

        void computeContentWidth() {
            Drawable r10 = getBackground();
            int r11 = 0;
            if (r10 == null) goto L9;
            r10.getPadding(this.this$0.mTempRect);
            if (ViewUtils.isLayoutRtl(this.this$0) == false) goto L7;
            int r12 = this.this$0.mTempRect.right;
        L8:
            r11 = r12;
        L10:
            int r13 = this.this$0.getPaddingLeft();
            int r14 = this.this$0.getPaddingRight();
            int r15 = this.this$0.getWidth();
            AppCompatSpinner r16 = this.this$0;
            int r17 = r16.mDropDownWidth;
            if (r17 != (-2)) goto L17;
            int r18 = r16.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
            int r19 = this.this$0.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect r20 = this.this$0.mTempRect;
            int r21 = (r19 - r20.left) - r20.right;
            if (r18 <= r21) goto L15;
            r18 = r21;
        L15:
            int r22 = Math.max(r18, (r15 - r13) - r14);
        L19:
            setContentWidth(r22);
        L22:
            if (ViewUtils.isLayoutRtl(this.this$0) == false) goto L24;
            int r23 = r11 + (((r15 - r14) - getWidth()) - getHorizontalOriginalOffset());
        L25:
            setHorizontalOffset(r23);
            return;
        L24:
            r23 = r11 + (r13 + getHorizontalOriginalOffset());
            goto L25
        L17:
            if (r17 != (-1)) goto L20;
            r22 = (r15 - r13) - r14;
            goto L19
        L20:
            setContentWidth(r17);
            goto L22
        L7:
            r12 = -this.this$0.mTempRect.left;
            goto L8
        L9:
            Rect r24 = this.this$0.mTempRect;
            r24.right = 0;
            r24.left = 0;
            goto L10
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.mHintText;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return this.mOriginalHorizontalOffset;
        }

        boolean isVisibleToUser(View r10) {
            if (ViewCompat.isAttachedToWindow(r10) == true) goto L5;
        L7:
            return false;
        L5:
            if (r10.getGlobalVisibleRect(this.mVisibleRect) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r10) {
            super.setAdapter(r10);
            this.mAdapter = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r10) {
            this.mOriginalHorizontalOffset = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r10) {
            this.mHintText = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r10, int r11) {
            boolean r12 = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            ListView r13 = getListView();
            r13.setChoiceMode(1);
            if (Build.VERSION.SDK_INT < 17) goto L5;
            Api17Impl.setTextDirection(r13, r10);
            Api17Impl.setTextAlignment(r13, r11);
        L5:
            setSelection(this.this$0.getSelectedItemPosition());
            if (r12 == false) goto L8;
            return;
        L8:
            ViewTreeObserver r14 = this.this$0.getViewTreeObserver();
            if (r14 == null) goto L12;
            final ViewTreeObserver.OnGlobalLayoutListener r15 = new AnonymousClass2(this);
            r14.addOnGlobalLayoutListener(r15);
            setOnDismissListener(new AnonymousClass3(this, r15));
            return;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mShowDropdown;

        static {
            CREATOR = new AnonymousClass1();
        }

        SavedState(Parcel r10) {
            super(r10);
            if (r10.readByte() == 0) goto L5;
            boolean r11 = true;
        L6:
            this.mShowDropdown = r11;
            return;
        L5:
            r11 = false;
            goto L6
        }

        SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeByte(this.mShowDropdown ? 1 : 0);
        }
    }

    @VisibleForTesting
    interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getHorizontalOriginalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter r10);

        void setBackgroundDrawable(Drawable r10);

        void setHorizontalOffset(int r10);

        void setHorizontalOriginalOffset(int r10);

        void setPromptText(CharSequence r10);

        void setVerticalOffset(int r10);

        void show(int r10, int r11);
    }

    static {
        ATTRS_ANDROID_SPINNERMODE = new int[]{R.attr.spinnerMode};
    }

    public AppCompatSpinner(@NonNull Context r10) {
        this(r10, null);
    }

    public AppCompatSpinner(@NonNull Context r10, int r11) {
        this(r10, null, androidx.appcompat.R.attr.spinnerStyle, r11);
    }

    public AppCompatSpinner(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, androidx.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, r12, -1);
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
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, android.widget.Spinner, androidx.appcompat.widget.AppCompatSpinner] */
    public AppCompatSpinner(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13, Resources.Theme r14) {
        super(r10, r11, r12);
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TintTypedArray r15 = TintTypedArray.obtainStyledAttributes(r10, r11, androidx.appcompat.R.styleable.Spinner, r12, 0);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        if (r14 == null) goto L6;
        ContextThemeWrapper r16 = new ContextThemeWrapper(r10, r14);
    L5:
        this.mPopupContext = r16;
    L10:
        ?? r17 = -1;
        ?? r18 = 0;
        if (r13 != (-1)) goto L32;
        TypedArray r19 = r10.obtainStyledAttributes(r11, ATTRS_ANDROID_SPINNERMODE, r12, 0);     // Catch: Throwable -> L19 Exception -> L21
        boolean r20 = r19.hasValue(0);     // Catch: Exception -> L17 Throwable -> L26
        r17 = r19;
        if (r20 == false) goto L16;
        r13 = r19.getInt(0, 0);     // Catch: Exception -> L17 Throwable -> L26
        r17 = r19;
    L16:
        r17.recycle();
    L17:
        e = e;
    L23:
        Log.i(TAG, "Could not read android:spinnerMode", e);     // Catch: Throwable -> L26
        r17 = r19;
        if (r19 == null) goto L32;
    L21:
        e = e;
        r19 = null;
    L19:
        th = th;
    L28:
        if (r18 == 0) goto L30;
        r18.recycle();
    L30:
        throw th;
    L32:
        if (r13 == 0) goto L36;
        if (r13 != 1) goto L37;
        final DropdownPopup r110 = new DropdownPopup(this, this.mPopupContext, r11, r12);
        TintTypedArray r21 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, r11, androidx.appcompat.R.styleable.Spinner, r12, 0);
        this.mDropDownWidth = r21.getLayoutDimension(androidx.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
        r110.setBackgroundDrawable(r21.getDrawable(androidx.appcompat.R.styleable.Spinner_android_popupBackground));
        r110.setPromptText(r15.getString(androidx.appcompat.R.styleable.Spinner_android_prompt));
        r21.recycle();
        this.mPopup = r110;
        this.mForwardingListener = new AnonymousClass1(this, this, r110);
    L37:
        CharSequence[] r111 = r15.getTextArray(androidx.appcompat.R.styleable.Spinner_android_entries);
        if (r111 == null) goto L40;
        ArrayAdapter r22 = new ArrayAdapter(r10, R.layout.simple_spinner_item, r111);
        r22.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        setAdapter(r22);
    L40:
        r15.recycle();
        this.mPopupSet = true;
        SpinnerAdapter r23 = this.mTempAdapter;
        if (r23 == null) goto L43;
        setAdapter(r23);
        this.mTempAdapter = null;
    L43:
        this.mBackgroundTintHelper.loadFromAttributes(r11, r12);
        return;
    L36:
        DialogPopup r112 = new DialogPopup(this);
        this.mPopup = r112;
        r112.setPromptText(r15.getString(androidx.appcompat.R.styleable.Spinner_android_prompt));
    L26:
        th = th;
        r18 = r17;
        goto L28
    L6:
        int r113 = r15.getResourceId(androidx.appcompat.R.styleable.Spinner_popupTheme, 0);
        if (r113 == 0) goto L9;
        r16 = new ContextThemeWrapper(r10, r113);
        goto L5
    L9:
        this.mPopupContext = r10;
        goto L10
    }

    int compatMeasureContentWidth(SpinnerAdapter r11, Drawable r12) {
        int r10 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r13 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r14 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r15 = Math.max(0, getSelectedItemPosition());
        int r16 = Math.min(r11.getCount(), r15 + 15);
        int r17 = Math.max(0, r15 - (15 - (r16 - r15)));
        View r18 = null;
        int r19 = 0;
    L6:
        if (r17 >= r16) goto L14;
        int r20 = r11.getItemViewType(r17);
        if (r20 == r10) goto L10;
        r18 = null;
        r10 = r20;
    L10:
        r18 = r11.getView(r17, r18, this);
        if (r18.getLayoutParams() != null) goto L13;
        r18.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L13:
        r18.measure(r13, r14);
        r19 = Math.max(r19, r18.getMeasuredWidth());
        r17 = r17 + 1;
        goto L6
    L14:
        if (r12 == null) goto L20;
        r12.getPadding(this.mTempRect);
        Rect r110 = this.mTempRect;
        return r19 + (r110.left + r110.right);
    L20:
        return r19;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L6;
        r10.applySupportBackgroundTint();
        return;
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup r10 = this.mPopup;
        if (r10 == null) goto L7;
        return r10.getHorizontalOffset();
    L7:
        if (Build.VERSION.SDK_INT >= 16) goto L9;
        return 0;
    L9:
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup r10 = this.mPopup;
        if (r10 == null) goto L7;
        return r10.getVerticalOffset();
    L7:
        if (Build.VERSION.SDK_INT >= 16) goto L9;
        return 0;
    L9:
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup == null) goto L7;
        return this.mDropDownWidth;
    L7:
        if (Build.VERSION.SDK_INT >= 16) goto L9;
        return 0;
    L9:
        return super.getDropDownWidth();
    }

    @VisibleForTesting
    final SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup r10 = this.mPopup;
        if (r10 == null) goto L7;
        return r10.getBackground();
    L7:
        if (Build.VERSION.SDK_INT >= 16) goto L9;
        return null;
    L9:
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup r10 = this.mPopup;
        if (r10 == null) goto L6;
        return r10.getHintText();
    L6:
        return super.getPrompt();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r10 = this.mBackgroundTintHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup r10 = this.mPopup;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isShowing() == false) goto L9;
        this.mPopup.dismiss();
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (this.mPopup != null) goto L5;
        return;
    L5:
        if (View.MeasureSpec.getMode(r10) != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(r10)), getMeasuredHeight());
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        if (r11.mShowDropdown == false) goto L8;
        ViewTreeObserver r12 = getViewTreeObserver();
        if (r12 == null) goto L9;
        r12.addOnGlobalLayoutListener(new AnonymousClass2(this));
        return;
    L9:
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        SpinnerPopup r11 = this.mPopup;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        r10.mShowDropdown = r12;
        return r10;
    L5:
        if (r11.isShowing() == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        ForwardingListener r11 = this.mForwardingListener;
        if (r11 == null) goto L9;
        if (r11.onTouch(this, r10) == false) goto L9;
        return true;
    L9:
        return super.onTouchEvent(r10);
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        SpinnerPopup r10 = this.mPopup;
        if (r10 == null) goto L10;
        if (r10.isShowing() == true) goto L11;
        showPopup();
        return true;
    L11:
        return true;
    L10:
        return super.performClick();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r10) {
        setAdapter((SpinnerAdapter) r10);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter r10) {
        if (this.mPopupSet == true) goto L6;
        this.mTempAdapter = r10;
        return;
    L6:
        super.setAdapter(r10);
        if (this.mPopup == null) goto L13;
        Context r11 = this.mPopupContext;
        if (r11 != null) goto L11;
        r11 = getContext();
    L11:
        this.mPopup.setAdapter(new DropDownAdapter(r10, r11.getTheme()));
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable r10) {
        super.setBackgroundDrawable(r10);
        AppCompatBackgroundHelper r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.onSetBackgroundDrawable(r10);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        super.setBackgroundResource(r10);
        AppCompatBackgroundHelper r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.onSetBackgroundResource(r10);
        return;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int r10) {
        SpinnerPopup r11 = this.mPopup;
        if (r11 == null) goto L6;
        r11.setHorizontalOriginalOffset(r10);
        this.mPopup.setHorizontalOffset(r10);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        super.setDropDownHorizontalOffset(r10);
        return;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int r10) {
        SpinnerPopup r11 = this.mPopup;
        if (r11 == null) goto L6;
        r11.setVerticalOffset(r10);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        super.setDropDownVerticalOffset(r10);
        return;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int r10) {
        if (this.mPopup == null) goto L6;
        this.mDropDownWidth = r10;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        super.setDropDownWidth(r10);
        return;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable r10) {
        SpinnerPopup r11 = this.mPopup;
        if (r11 == null) goto L6;
        r11.setBackgroundDrawable(r10);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 16) goto L10;
        super.setPopupBackgroundDrawable(r10);
        return;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int r10) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), r10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence r10) {
        SpinnerPopup r11 = this.mPopup;
        if (r11 == null) goto L5;
        r11.setPromptText(r10);
        return;
    L5:
        super.setPrompt(r10);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        AppCompatBackgroundHelper r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.setSupportBackgroundTintList(r10);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        AppCompatBackgroundHelper r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.setSupportBackgroundTintMode(r10);
        return;
    }

    void showPopup() {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        this.mPopup.show(Api17Impl.getTextDirection(this), Api17Impl.getTextAlignment(this));
        return;
    L5:
        this.mPopup.show(-1, -1);
    }
}
