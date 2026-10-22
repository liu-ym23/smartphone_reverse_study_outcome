package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final View.OnClickListener mButtonHandler;
    private final int mButtonIconDimen;
    Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    int mCheckedItem;
    private final Context mContext;
    private View mCustomTitleView;
    final AppCompatDialog mDialog;
    Handler mHandler;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified;
    private int mViewSpacingTop;
    private final Window mWindow;

    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId;
        public int mIconId;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified;
        public int mViewSpacingTop;

        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView r10);
        }

        public AlertParams(Context r10) {
            this.mIconId = 0;
            this.mIconAttrId = 0;
            this.mViewSpacingSpecified = false;
            this.mCheckedItem = -1;
            this.mRecycleOnMeasure = true;
            this.mContext = r10;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) r10.getSystemService("layout_inflater");
        }

        private void createListView(final AlertController r11) {
            final RecycleListView r10 = (RecycleListView) this.mInflater.inflate(r11.mListLayout, null);
            if (this.mIsMultiChoice == false) goto L9;
            if (this.mCursor != null) goto L7;
            final Context r12 = this.mContext;
            final int r13 = r11.mMultiChoiceItemLayout;
            final int r14 = R.id.text1;
            final CharSequence[] r15 = this.mItems;
            ListAdapter r16 = new AnonymousClass1(this, r12, r13, r14, r15, r10);
        L19:
            OnPrepareListViewListener r17 = this.mOnPrepareListViewListener;
            if (r17 == null) goto L22;
            r17.onPrepareListView(r10);
        L22:
            r11.mAdapter = r16;
            r11.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener == null) goto L27;
            AdapterView.OnItemClickListener r18 = new AnonymousClass3(this, r11);
        L25:
            r10.setOnItemClickListener(r18);
        L29:
            AdapterView.OnItemSelectedListener r19 = this.mOnItemSelectedListener;
            if (r19 == null) goto L33;
            r10.setOnItemSelectedListener(r19);
        L33:
            if (this.mIsSingleChoice == false) goto L36;
            r10.setChoiceMode(1);
        L38:
            r11.mListView = r10;
            return;
        L36:
            if (this.mIsMultiChoice == false) goto L38;
            r10.setChoiceMode(2);
            goto L38
        L27:
            if (this.mOnCheckboxClickListener == null) goto L29;
            r18 = new AnonymousClass4(this, r10, r11);
            goto L25
        L7:
            final Context r20 = this.mContext;
            final Cursor r21 = this.mCursor;
            final boolean r22 = false;
            r16 = new AnonymousClass2(this, r20, r21, r22, r10, r11);
            goto L19
        L9:
            if (this.mIsSingleChoice == false) goto L11;
            int r23 = r11.mSingleChoiceItemLayout;
        L12:
            int r24 = r23;
            if (this.mCursor == null) goto L15;
            r16 = new SimpleCursorAdapter(this.mContext, r24, this.mCursor, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
            goto L19
        L15:
            r16 = this.mAdapter;
            if (r16 != null) goto L19;
            r16 = new CheckedItemAdapter(this.mContext, r24, R.id.text1, this.mItems);
            goto L19
        L11:
            r23 = r11.mListItemLayout;
            goto L12
        }

        public void apply(AlertController r14) {
            View r10 = this.mCustomTitleView;
            if (r10 == null) goto L5;
            r14.setCustomTitle(r10);
        L17:
            CharSequence r11 = this.mMessage;
            if (r11 == null) goto L20;
            r14.setMessage(r11);
        L20:
            CharSequence r12 = this.mPositiveButtonText;
            if (r12 == null) goto L23;
        L24:
            r14.setButton(-1, r12, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
        L25:
            CharSequence r13 = this.mNegativeButtonText;
            if (r13 == null) goto L28;
        L29:
            r14.setButton(-2, r13, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
        L30:
            CharSequence r15 = this.mNeutralButtonText;
            if (r15 == null) goto L33;
        L34:
            r14.setButton(-3, r15, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
        L36:
            if (this.mItems == null) goto L38;
        L41:
            createListView(r14);
        L42:
            View r16 = this.mView;
            if (r16 != null) goto L45;
            int r17 = this.mViewLayoutResId;
            if (r17 == 0) goto L54;
            r14.setView(r17);
            return;
        L54:
            return;
        L45:
            if (this.mViewSpacingSpecified == false) goto L47;
            r14.setView(r16, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            return;
        L47:
            r14.setView(r16);
            return;
        L38:
            if (this.mCursor != null) goto L41;
            if (this.mAdapter == null) goto L42;
        L33:
            if (this.mNeutralButtonIcon == null) goto L36;
        L28:
            if (this.mNegativeButtonIcon == null) goto L30;
        L23:
            if (this.mPositiveButtonIcon == null) goto L25;
        L5:
            CharSequence r18 = this.mTitle;
            if (r18 == null) goto L8;
            r14.setTitle(r18);
        L8:
            Drawable r19 = this.mIcon;
            if (r19 == null) goto L11;
            r14.setIcon(r19);
        L11:
            int r20 = this.mIconId;
            if (r20 == 0) goto L14;
            r14.setIcon(r20);
        L14:
            int r21 = this.mIconAttrId;
            if (r21 == 0) goto L17;
            r14.setIcon(r14.getIconAttributeResId(r21));
            goto L17
        }
    }

    private static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface r10) {
            this.mDialog = new WeakReference(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r10.obj).onClick(this.mDialog.get(), r10.what);
            return;
        L5:
            if (r11 == (-2)) goto L12;
            if (r11 == (-1)) goto L12;
            if (r11 != 1) goto L15;
            ((DialogInterface) r10.obj).dismiss();
            return;
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context r10, int r11, int r12, CharSequence[] r13) {
            super(r10, r11, r12, r13);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context r10) {
            this(r10, null);
        }

        public RecycleListView(Context r10, AttributeSet r11) {
            super(r10, r11);
            TypedArray r12 = r10.obtainStyledAttributes(r11, androidx.appcompat.R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = r12.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = r12.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean r10, boolean r11) {
            if (r11 == false) goto L4;
            if (r10 == false) goto L4;
            return;
        L4:
            int r12 = getPaddingLeft();
            if (r10 == false) goto L7;
            int r13 = getPaddingTop();
        L8:
            int r14 = getPaddingRight();
            if (r11 == false) goto L11;
            int r15 = getPaddingBottom();
        L12:
            setPadding(r12, r13, r14, r15);
            return;
        L11:
            r15 = this.mPaddingBottomNoButtons;
            goto L12
        L7:
            r13 = this.mPaddingTopNoTitle;
            goto L8
        }
    }

    public AlertController(Context r10, AppCompatDialog r11, Window r12) {
        this.mViewSpacingSpecified = false;
        this.mIconId = 0;
        this.mCheckedItem = -1;
        this.mButtonPanelLayoutHint = 0;
        this.mButtonHandler = new AnonymousClass1(this);
        this.mContext = r10;
        this.mDialog = r11;
        this.mWindow = r12;
        this.mHandler = new ButtonHandler(r11);
        TypedArray r13 = r10.obtainStyledAttributes(null, androidx.appcompat.R.styleable.AlertDialog, androidx.appcompat.R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = r13.getResourceId(androidx.appcompat.R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = r13.getResourceId(androidx.appcompat.R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = r13.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = r13.getResourceId(androidx.appcompat.R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = r13.getResourceId(androidx.appcompat.R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = r13.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = r13.getBoolean(androidx.appcompat.R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = r13.getDimensionPixelSize(androidx.appcompat.R.styleable.AlertDialog_buttonIconDimen, 0);
        r13.recycle();
        r11.supportRequestWindowFeature(1);
    }

    static boolean canTextInput(View r10) {
        if (r10.onCheckIsTextEditor() == false) goto L6;
        return true;
    L6:
        if ((r10 instanceof ViewGroup) == true) goto L8;
        return false;
    L8:
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
    L9:
        if (r12 <= 0) goto L13;
        r12 = r12 - 1;
        if (canTextInput(r11.getChildAt(r12)) == false) goto L9;
        return true;
    L13:
        return false;
    }

    private void centerButton(Button r10) {
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) r10.getLayoutParams();
        r11.gravity = 1;
        r11.weight = 0.5f;
        r10.setLayoutParams(r11);
    }

    static void manageScrollIndicators(View r10, View r11, View r12) {
        int r13 = 0;
        if (r11 != null) goto L5;
    L9:
        if (r12 != null) goto L11;
        return;
    L11:
        if (r10.canScrollVertically(1) == true) goto L14;
        r13 = 4;
    L14:
        r12.setVisibility(r13);
        return;
    L5:
        if (r10.canScrollVertically(-1) == false) goto L7;
        int r14 = 0;
    L8:
        r11.setVisibility(r14);
        goto L9
    L7:
        r14 = 4;
        goto L8
    }

    @Nullable
    private ViewGroup resolvePanel(@Nullable View r10, @Nullable View r11) {
        if (r10 == null) goto L4;
        if (r11 == null) goto L13;
        ViewParent r12 = r11.getParent();
        if ((r12 instanceof ViewGroup) == false) goto L13;
        ((ViewGroup) r12).removeView(r11);
    L13:
        if ((r10 instanceof ViewStub) == false) goto L16;
        r10 = ((ViewStub) r10).inflate();
    L16:
        return (ViewGroup) r10;
    L4:
        if ((r11 instanceof ViewStub) == false) goto L7;
        r11 = ((ViewStub) r11).inflate();
    L7:
        return (ViewGroup) r11;
    }

    private int selectContentView() {
        int r10 = this.mButtonPanelSideLayout;
        if (r10 != 0) goto L7;
        return this.mAlertDialogLayout;
    L7:
        if (this.mButtonPanelLayoutHint != 1) goto L10;
        return r10;
    L10:
        return this.mAlertDialogLayout;
    }

    private void setScrollIndicators(ViewGroup r10, View r11, int r12, int r13) {
        final View r14 = this.mWindow.findViewById(androidx.appcompat.R.id.scrollIndicatorUp);
        final View r15 = this.mWindow.findViewById(androidx.appcompat.R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT < 23) goto L10;
        ViewCompat.setScrollIndicators(r11, r12, r13);
        if (r14 == null) goto L7;
        r10.removeView(r14);
    L7:
        if (r15 == null) goto L30;
    L8:
        r10.removeView(r15);
        return;
    L30:
        return;
    L10:
        if (r14 != null) goto L12;
    L14:
        if (r15 != null) goto L16;
    L18:
        if (r14 != null) goto L21;
        if (r15 != null) goto L21;
        return;
    L21:
        if (this.mMessage == null) goto L23;
        this.mScrollView.setOnScrollChangeListener(new AnonymousClass2(this, r14, r15));
        this.mScrollView.post(new AnonymousClass3(this, r14, r15));
        return;
    L23:
        ListView r16 = this.mListView;
        if (r16 == null) goto L26;
        r16.setOnScrollListener(new AnonymousClass4(this, r14, r15));
        this.mListView.post(new AnonymousClass5(this, r14, r15));
        return;
    L26:
        if (r14 == null) goto L28;
        r10.removeView(r14);
    L28:
        if (r15 != null) goto L8;
        return;
    L16:
        if ((r12 & 2) != 0) goto L18;
        r10.removeView(r15);
        r15 = null;
        goto L18
    L12:
        if ((r12 & 1) != 0) goto L14;
        r10.removeView(r14);
        r14 = null;
        goto L14
    }

    private void setupButtons(ViewGroup r10) {
        Button r11 = (Button) r10.findViewById(R.id.button1);
        this.mButtonPositive = r11;
        r11.setOnClickListener(this.mButtonHandler);
        boolean r12 = true;
        if (TextUtils.isEmpty(this.mButtonPositiveText) == true) goto L5;
    L7:
        this.mButtonPositive.setText(this.mButtonPositiveText);
        Drawable r13 = this.mButtonPositiveIcon;
        if (r13 == null) goto L10;
        int r14 = this.mButtonIconDimen;
        r13.setBounds(0, 0, r14, r14);
        this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
    L10:
        this.mButtonPositive.setVisibility(0);
        int r15 = 1;
    L11:
        Button r16 = (Button) r10.findViewById(R.id.button2);
        this.mButtonNegative = r16;
        r16.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNegativeText) == true) goto L14;
    L16:
        this.mButtonNegative.setText(this.mButtonNegativeText);
        Drawable r17 = this.mButtonNegativeIcon;
        if (r17 == null) goto L19;
        int r18 = this.mButtonIconDimen;
        r17.setBounds(0, 0, r18, r18);
        this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
    L19:
        this.mButtonNegative.setVisibility(0);
        r15 = r15 | 2;
    L20:
        Button r19 = (Button) r10.findViewById(R.id.button3);
        this.mButtonNeutral = r19;
        r19.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNeutralText) == true) goto L23;
    L25:
        this.mButtonNeutral.setText(this.mButtonNeutralText);
        Drawable r20 = this.mButtonNeutralIcon;
        if (r20 == null) goto L28;
        int r21 = this.mButtonIconDimen;
        r20.setBounds(0, 0, r21, r21);
        this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
    L28:
        this.mButtonNeutral.setVisibility(0);
        r15 = r15 | 4;
    L30:
        if (shouldCenterSingleButton(this.mContext) == false) goto L40;
        if (r15 != 1) goto L35;
        Button r22 = this.mButtonPositive;
    L33:
        centerButton(r22);
        goto L40
    L35:
        if (r15 != 2) goto L38;
        r22 = this.mButtonNegative;
        goto L33
    L38:
        if (r15 != 4) goto L40;
        r22 = this.mButtonNeutral;
    L40:
        if (r15 != 0) goto L43;
        r12 = false;
    L43:
        if (r12 == true) goto L46;
        r10.setVisibility(8);
        return;
    L46:
        return;
    L23:
        if (this.mButtonNeutralIcon != null) goto L25;
        this.mButtonNeutral.setVisibility(8);
        goto L30
    L14:
        if (this.mButtonNegativeIcon != null) goto L16;
        this.mButtonNegative.setVisibility(8);
        goto L20
    L5:
        if (this.mButtonPositiveIcon != null) goto L7;
        this.mButtonPositive.setVisibility(8);
        r15 = 0;
        goto L11
    }

    private void setupContent(ViewGroup r10) {
        NestedScrollView r11 = (NestedScrollView) this.mWindow.findViewById(androidx.appcompat.R.id.scrollView);
        this.mScrollView = r11;
        r11.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        TextView r12 = (TextView) r10.findViewById(R.id.message);
        this.mMessageView = r12;
        if (r12 != null) goto L5;
        return;
    L5:
        CharSequence r13 = this.mMessage;
        if (r13 == null) goto L8;
        r12.setText(r13);
        return;
    L8:
        r12.setVisibility(8);
        this.mScrollView.removeView(this.mMessageView);
        if (this.mListView == null) goto L11;
        ViewGroup r14 = (ViewGroup) this.mScrollView.getParent();
        int r15 = r14.indexOfChild(this.mScrollView);
        r14.removeViewAt(r15);
        r14.addView(this.mListView, r15, new ViewGroup.LayoutParams(-1, -1));
        return;
    L11:
        r10.setVisibility(8);
    }

    private void setupCustomContent(ViewGroup r10) {
        View r11 = this.mView;
        boolean r12 = false;
        if (r11 == null) goto L6;
    L9:
        if (r11 == null) goto L11;
        r12 = true;
    L11:
        if (r12 == true) goto L13;
    L14:
        this.mWindow.setFlags(131072, 131072);
    L15:
        if (r12 == false) goto L22;
        FrameLayout r13 = (FrameLayout) this.mWindow.findViewById(androidx.appcompat.R.id.custom);
        r13.addView(r11, new ViewGroup.LayoutParams(-1, -1));
        if (this.mViewSpacingSpecified == false) goto L20;
        r13.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
    L20:
        if (this.mListView == null) goto L24;
        ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) r10.getLayoutParams())).weight = 0.0f;
        return;
    L24:
        return;
    L22:
        r10.setVisibility(8);
        return;
    L13:
        if (canTextInput(r11) == true) goto L15;
    L6:
        if (this.mViewLayoutResId == 0) goto L8;
        r11 = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, r10, false);
        goto L9
    L8:
        r11 = null;
        goto L9
    }

    private void setupTitle(ViewGroup r10) {
        if (this.mCustomTitleView == null) goto L5;
        r10.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
        this.mWindow.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
        return;
    L5:
        this.mIconView = (ImageView) this.mWindow.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(this.mTitle)) == true) goto L8;
    L16:
        this.mWindow.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
        this.mIconView.setVisibility(8);
        r10.setVisibility(8);
        return;
    L8:
        if (this.mShowTitle == false) goto L16;
        TextView r11 = (TextView) this.mWindow.findViewById(androidx.appcompat.R.id.alertTitle);
        this.mTitleView = r11;
        r11.setText(this.mTitle);
        int r12 = this.mIconId;
        if (r12 == 0) goto L12;
        this.mIconView.setImageResource(r12);
        return;
    L12:
        Drawable r13 = this.mIcon;
        if (r13 == null) goto L15;
        this.mIconView.setImageDrawable(r13);
        return;
    L15:
        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
        this.mIconView.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupView() {
        View r10 = this.mWindow.findViewById(androidx.appcompat.R.id.parentPanel);
        int r11 = androidx.appcompat.R.id.topPanel;
        View r12 = r10.findViewById(r11);
        int r13 = androidx.appcompat.R.id.contentPanel;
        View r14 = r10.findViewById(r13);
        int r15 = androidx.appcompat.R.id.buttonPanel;
        View r16 = r10.findViewById(r15);
        ViewGroup r17 = (ViewGroup) r10.findViewById(androidx.appcompat.R.id.customPanel);
        setupCustomContent(r17);
        View r18 = r17.findViewById(r11);
        View r19 = r17.findViewById(r13);
        View r20 = r17.findViewById(r15);
        ViewGroup r21 = resolvePanel(r18, r12);
        ViewGroup r22 = resolvePanel(r19, r14);
        ViewGroup r23 = resolvePanel(r20, r16);
        setupContent(r22);
        setupButtons(r23);
        setupTitle(r21);
        int r24 = 0;
        if (r17.getVisibility() == 8) goto L5;
        boolean r25 = true;
    L6:
        if (r21 != null) goto L8;
    L10:
        boolean r26 = 0;
    L11:
        if (r23 != null) goto L13;
    L15:
        boolean r27 = false;
    L16:
        if (r27 == true) goto L21;
        if (r22 == null) goto L21;
        View r28 = r22.findViewById(androidx.appcompat.R.id.textSpacerNoButtons);
        if (r28 == null) goto L21;
        r28.setVisibility(0);
    L21:
        if (r26 == 0) goto L32;
        NestedScrollView r29 = this.mScrollView;
        if (r29 == null) goto L25;
        r29.setClipToPadding(true);
    L25:
        View r30 = null;
        if (this.mMessage == null) goto L28;
    L29:
        r30 = r21.findViewById(androidx.appcompat.R.id.titleDividerNoCustom);
    L30:
        if (r30 == null) goto L36;
        r30.setVisibility(0);
    L36:
        ListView r31 = this.mListView;
        if ((r31 instanceof RecycleListView) == false) goto L39;
        ((RecycleListView) r31).setHasDecor(r26, r27);
    L39:
        if (r25 == true) goto L48;
        View r32 = this.mListView;
        if (r32 != null) goto L44;
        r32 = this.mScrollView;
    L44:
        if (r32 == null) goto L48;
        if (r27 == false) goto L47;
        r24 = 2;
    L47:
        setScrollIndicators(r22, r32, r26 | r24, 3);
    L48:
        ListView r33 = this.mListView;
        if (r33 == null) goto L56;
        ListAdapter r34 = this.mAdapter;
        if (r34 == null) goto L57;
        r33.setAdapter(r34);
        int r35 = this.mCheckedItem;
        if (r35 <= (-1)) goto L58;
        r33.setItemChecked(r35, true);
        r33.setSelection(r35);
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L28:
        if (this.mListView == null) goto L30;
    L32:
        if (r22 == null) goto L36;
        View r36 = r22.findViewById(androidx.appcompat.R.id.textSpacerNoTitle);
        if (r36 == null) goto L36;
        r36.setVisibility(0);
        goto L36
    L13:
        if (r23.getVisibility() == 8) goto L15;
        r27 = true;
        goto L16
    L8:
        if (r21.getVisibility() == 8) goto L10;
        r26 = 1;
        goto L11
    L5:
        r25 = false;
        goto L6
    }

    private static boolean shouldCenterSingleButton(Context r10) {
        TypedValue r11 = new TypedValue();
        r10.getTheme().resolveAttribute(androidx.appcompat.R.attr.alertDialogCenterButtons, r11, true);
        if (r11.data != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public Button getButton(int r10) {
        if (r10 == (-3)) goto L15;
        if (r10 == (-2)) goto L13;
        if (r10 == (-1)) goto L11;
        return null;
    L11:
        return this.mButtonPositive;
    L13:
        return this.mButtonNegative;
    L15:
        return this.mButtonNeutral;
    }

    public int getIconAttributeResId(int r10) {
        TypedValue r11 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(r10, r11, true);
        return r11.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        int r10 = selectContentView();
        this.mDialog.setContentView(r10);
        setupView();
    }

    public boolean onKeyDown(int r10, KeyEvent r11) {
        NestedScrollView r12 = this.mScrollView;
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.executeKeyEvent(r11) == false) goto L7;
        return true;
    }

    public boolean onKeyUp(int r10, KeyEvent r11) {
        NestedScrollView r12 = this.mScrollView;
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.executeKeyEvent(r11) == false) goto L7;
        return true;
    }

    public void setButton(int r10, CharSequence r11, DialogInterface.OnClickListener r12, Message r13, Drawable r14) {
        if (r13 != null) goto L6;
        if (r12 == null) goto L6;
        r13 = this.mHandler.obtainMessage(r10, r12);
    L6:
        if (r10 != (-3)) goto L8;
        this.mButtonNeutralText = r11;
        this.mButtonNeutralMessage = r13;
        this.mButtonNeutralIcon = r14;
        return;
    L8:
        if (r10 != (-2)) goto L10;
        this.mButtonNegativeText = r11;
        this.mButtonNegativeMessage = r13;
        this.mButtonNegativeIcon = r14;
        return;
    L10:
        if (r10 != (-1)) goto L13;
        this.mButtonPositiveText = r11;
        this.mButtonPositiveMessage = r13;
        this.mButtonPositiveIcon = r14;
        return;
    L13:
        throw new IllegalArgumentException("Button does not exist");
    }

    public void setButtonPanelLayoutHint(int r10) {
        this.mButtonPanelLayoutHint = r10;
    }

    public void setCustomTitle(View r10) {
        this.mCustomTitleView = r10;
    }

    public void setIcon(int r10) {
        this.mIcon = null;
        this.mIconId = r10;
        ImageView r11 = this.mIconView;
        if (r11 == null) goto L8;
        if (r10 == 0) goto L6;
        r11.setVisibility(0);
        this.mIconView.setImageResource(this.mIconId);
        return;
    L6:
        r11.setVisibility(8);
        return;
    }

    public void setIcon(Drawable r10) {
        this.mIcon = r10;
        this.mIconId = 0;
        ImageView r11 = this.mIconView;
        if (r11 == null) goto L8;
        if (r10 == null) goto L6;
        r11.setVisibility(0);
        this.mIconView.setImageDrawable(r10);
        return;
    L6:
        r11.setVisibility(8);
        return;
    }

    public void setMessage(CharSequence r10) {
        this.mMessage = r10;
        TextView r11 = this.mMessageView;
        if (r11 == null) goto L6;
        r11.setText(r10);
        return;
    }

    public void setTitle(CharSequence r10) {
        this.mTitle = r10;
        TextView r11 = this.mTitleView;
        if (r11 == null) goto L6;
        r11.setText(r10);
        return;
    }

    public void setView(int r10) {
        this.mView = null;
        this.mViewLayoutResId = r10;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View r10) {
        this.mView = r10;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View r10, int r11, int r12, int r13, int r14) {
        this.mView = r10;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = r11;
        this.mViewSpacingTop = r12;
        this.mViewSpacingRight = r13;
        this.mViewSpacingBottom = r14;
    }
}
