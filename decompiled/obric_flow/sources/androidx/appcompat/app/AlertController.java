package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
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
import android.widget.AbsListView;
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

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$2, reason: invalid class name */
    public class AnonymousClass2 implements NestedScrollView.OnScrollChangeListener {
        final /* synthetic */ AlertController this$0;
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        public AnonymousClass2(AlertController r5, View r10, View r11) {
            this.this$0 = r5;
            this.val$top = r10;
            this.val$bottom = r11;
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView r5, int r10, int r11, int r12, int r13) {
            AlertController.manageScrollIndicators(r5, this.val$top, this.val$bottom);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ AlertController this$0;
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        public AnonymousClass3(AlertController r5, View r10, View r11) {
            this.this$0 = r5;
            this.val$top = r10;
            this.val$bottom = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.manageScrollIndicators(this.this$0.mScrollView, this.val$top, this.val$bottom);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$4, reason: invalid class name */
    public class AnonymousClass4 implements AbsListView.OnScrollListener {
        final /* synthetic */ AlertController this$0;
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        public AnonymousClass4(AlertController r5, View r10, View r11) {
            this.this$0 = r5;
            this.val$top = r10;
            this.val$bottom = r11;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView r5, int r10, int r11, int r12) {
            AlertController.manageScrollIndicators(r5, this.val$top, this.val$bottom);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView r5, int r10) {
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$5, reason: invalid class name */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ AlertController this$0;
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        public AnonymousClass5(AlertController r5, View r10, View r11) {
            this.this$0 = r5;
            this.val$top = r10;
            this.val$bottom = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.manageScrollIndicators(this.this$0.mListView, this.val$top, this.val$bottom);
        }
    }

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
            void onPrepareListView(ListView r5);
        }

        public AlertParams(Context r5) {
            this.mIconId = 0;
            this.mIconAttrId = 0;
            this.mViewSpacingSpecified = false;
            this.mCheckedItem = -1;
            this.mRecycleOnMeasure = true;
            this.mContext = r5;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) r5.getSystemService("layout_inflater");
        }

        private void createListView(final AlertController r10) {
            final RecycleListView r5 = (RecycleListView) this.mInflater.inflate(r10.mListLayout, null);
            if (this.mIsMultiChoice == false) goto L9;
            if (this.mCursor != null) goto L7;
            final Context r11 = this.mContext;
            final int r12 = r10.mMultiChoiceItemLayout;
            final int r13 = R.id.text1;
            final CharSequence[] r14 = this.mItems;
            ListAdapter r15 = new AnonymousClass1(this, r11, r12, r13, r14, r5);
        L20:
            OnPrepareListViewListener r16 = this.mOnPrepareListViewListener;
            if (r16 == null) goto L23;
            r16.onPrepareListView(r5);
        L23:
            r10.mAdapter = r15;
            r10.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener == null) goto L27;
            r5.setOnItemClickListener(new AnonymousClass3(this, r10));
        L29:
            AdapterView.OnItemSelectedListener r17 = this.mOnItemSelectedListener;
            if (r17 == null) goto L33;
            r5.setOnItemSelectedListener(r17);
        L33:
            if (this.mIsSingleChoice == false) goto L36;
            r5.setChoiceMode(1);
        L38:
            r10.mListView = r5;
            return;
        L36:
            if (this.mIsMultiChoice == false) goto L38;
            r5.setChoiceMode(2);
            goto L38
        L27:
            if (this.mOnCheckboxClickListener == null) goto L29;
            r5.setOnItemClickListener(new AnonymousClass4(this, r5, r10));
            goto L29
        L7:
            final Context r18 = this.mContext;
            final Cursor r19 = this.mCursor;
            final boolean r20 = false;
            r15 = new AnonymousClass2(this, r18, r19, r20, r5, r10);
            goto L20
        L9:
            if (this.mIsSingleChoice == false) goto L12;
            int r21 = r10.mSingleChoiceItemLayout;
        L11:
            int r22 = r21;
            if (this.mCursor == null) goto L16;
            r15 = new SimpleCursorAdapter(this.mContext, r22, this.mCursor, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
            goto L20
        L16:
            r15 = this.mAdapter;
            if (r15 != null) goto L20;
            r15 = new CheckedItemAdapter(this.mContext, r22, R.id.text1, this.mItems);
            goto L20
        L12:
            r21 = r10.mListItemLayout;
            goto L11
        }

        public void apply(AlertController r14) {
            View r5 = this.mCustomTitleView;
            if (r5 == null) goto L5;
            r14.setCustomTitle(r5);
        L17:
            CharSequence r10 = this.mMessage;
            if (r10 == null) goto L20;
            r14.setMessage(r10);
        L20:
            CharSequence r11 = this.mPositiveButtonText;
            if (r11 == null) goto L23;
        L24:
            r14.setButton(-1, r11, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
        L25:
            CharSequence r12 = this.mNegativeButtonText;
            if (r12 == null) goto L28;
        L29:
            r14.setButton(-2, r12, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
        L30:
            CharSequence r13 = this.mNeutralButtonText;
            if (r13 == null) goto L33;
        L34:
            r14.setButton(-3, r13, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
        L36:
            if (this.mItems == null) goto L38;
        L41:
            createListView(r14);
        L42:
            View r15 = this.mView;
            if (r15 != null) goto L45;
            int r16 = this.mViewLayoutResId;
            if (r16 == 0) goto L54;
            r14.setView(r16);
            return;
        L54:
            return;
        L45:
            if (this.mViewSpacingSpecified == false) goto L47;
            r14.setView(r15, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            return;
        L47:
            r14.setView(r15);
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
            CharSequence r17 = this.mTitle;
            if (r17 == null) goto L8;
            r14.setTitle(r17);
        L8:
            Drawable r18 = this.mIcon;
            if (r18 == null) goto L11;
            r14.setIcon(r18);
        L11:
            int r19 = this.mIconId;
            if (r19 == 0) goto L14;
            r14.setIcon(r19);
        L14:
            int r20 = this.mIconAttrId;
            if (r20 == 0) goto L17;
            r14.setIcon(r14.getIconAttributeResId(r20));
            goto L17
        }
    }

    public static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface r5) {
            this.mDialog = new WeakReference(r5);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            int r10 = r5.what;
            if (r10 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r5.obj).onClick(this.mDialog.get(), r5.what);
            return;
        L5:
            if (r10 == (-2)) goto L12;
            if (r10 == (-1)) goto L12;
            if (r10 != 1) goto L15;
            ((DialogInterface) r5.obj).dismiss();
            return;
        }
    }

    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context r5, int r10, int r11, CharSequence[] r12) {
            super(r5, r10, r11, r12);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int r5) {
            return r5;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context r5) {
            this(r5, null);
        }

        public void setHasDecor(boolean r5, boolean r10) {
            if (r10 == false) goto L4;
            if (r5 == false) goto L4;
            return;
        L4:
            int r11 = getPaddingLeft();
            if (r5 == false) goto L7;
            int r12 = getPaddingTop();
        L8:
            int r13 = getPaddingRight();
            if (r10 == false) goto L11;
            int r14 = getPaddingBottom();
        L12:
            setPadding(r11, r12, r13, r14);
            return;
        L11:
            r14 = this.mPaddingBottomNoButtons;
            goto L12
        L7:
            r12 = this.mPaddingTopNoTitle;
            goto L8
        }

        public RecycleListView(Context r5, AttributeSet r10) {
            super(r5, r10);
            TypedArray r11 = r5.obtainStyledAttributes(r10, androidx.appcompat.R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = r11.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = r11.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public AlertController(Context r5, AppCompatDialog r10, Window r11) {
        this.mViewSpacingSpecified = false;
        this.mIconId = 0;
        this.mCheckedItem = -1;
        this.mButtonPanelLayoutHint = 0;
        this.mButtonHandler = new AnonymousClass1(this);
        this.mContext = r5;
        this.mDialog = r10;
        this.mWindow = r11;
        this.mHandler = new ButtonHandler(r10);
        TypedArray r12 = r5.obtainStyledAttributes(null, androidx.appcompat.R.styleable.AlertDialog, androidx.appcompat.R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = r12.getResourceId(androidx.appcompat.R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = r12.getResourceId(androidx.appcompat.R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = r12.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = r12.getResourceId(androidx.appcompat.R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = r12.getResourceId(androidx.appcompat.R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = r12.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = r12.getBoolean(androidx.appcompat.R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = r12.getDimensionPixelSize(androidx.appcompat.R.styleable.AlertDialog_buttonIconDimen, 0);
        r12.recycle();
        r10.supportRequestWindowFeature(1);
    }

    public static boolean canTextInput(View r5) {
        if (r5.onCheckIsTextEditor() == false) goto L6;
        return true;
    L6:
        if ((r5 instanceof ViewGroup) == true) goto L8;
        return false;
    L8:
        ViewGroup r10 = (ViewGroup) r5;
        int r11 = r10.getChildCount();
    L9:
        if (r11 <= 0) goto L13;
        r11 = r11 - 1;
        if (canTextInput(r10.getChildAt(r11)) == false) goto L9;
        return true;
    L13:
        return false;
    }

    private void centerButton(Button r5) {
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r5.getLayoutParams();
        r10.gravity = 1;
        r10.weight = 0.5f;
        r5.setLayoutParams(r10);
    }

    public static void manageScrollIndicators(View r5, View r10, View r11) {
        int r12 = 4;
        if (r10 != null) goto L5;
    L9:
        if (r11 != null) goto L11;
        return;
    L11:
        if (r5.canScrollVertically(1) == false) goto L13;
        r12 = 0;
    L13:
        r11.setVisibility(r12);
        return;
    L5:
        if (r5.canScrollVertically(-1) == false) goto L7;
        int r13 = 0;
    L8:
        r10.setVisibility(r13);
        goto L9
    L7:
        r13 = 4;
        goto L8
    }

    @Nullable
    private ViewGroup resolvePanel(@Nullable View r5, @Nullable View r10) {
        if (r5 == null) goto L4;
        if (r10 == null) goto L13;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L13;
        ((ViewGroup) r11).removeView(r10);
    L13:
        if ((r5 instanceof ViewStub) == false) goto L16;
        r5 = ((ViewStub) r5).inflate();
    L16:
        return (ViewGroup) r5;
    L4:
        if ((r10 instanceof ViewStub) == false) goto L7;
        r10 = ((ViewStub) r10).inflate();
    L7:
        return (ViewGroup) r10;
    }

    private int selectContentView() {
        int r5 = this.mButtonPanelSideLayout;
        if (r5 != 0) goto L7;
        return this.mAlertDialogLayout;
    L7:
        if (this.mButtonPanelLayoutHint != 1) goto L10;
        return r5;
    L10:
        return this.mAlertDialogLayout;
    }

    private void setScrollIndicators(ViewGroup r5, View r10, int r11, int r12) {
        View r13 = this.mWindow.findViewById(androidx.appcompat.R.id.scrollIndicatorUp);
        View r14 = this.mWindow.findViewById(androidx.appcompat.R.id.scrollIndicatorDown);
        ViewCompat.setScrollIndicators(r10, r11, r12);
        if (r13 == null) goto L5;
        r5.removeView(r13);
    L5:
        if (r14 == null) goto L8;
        r5.removeView(r14);
        return;
    }

    private void setupButtons(ViewGroup r10) {
        Button r5 = (Button) r10.findViewById(R.id.button1);
        this.mButtonPositive = r5;
        r5.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonPositiveText) == true) goto L5;
    L7:
        this.mButtonPositive.setText(this.mButtonPositiveText);
        Drawable r11 = this.mButtonPositiveIcon;
        if (r11 == null) goto L10;
        int r12 = this.mButtonIconDimen;
        r11.setBounds(0, 0, r12, r12);
        this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
    L10:
        this.mButtonPositive.setVisibility(0);
        int r13 = 1;
    L11:
        Button r14 = (Button) r10.findViewById(R.id.button2);
        this.mButtonNegative = r14;
        r14.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNegativeText) == true) goto L14;
    L16:
        this.mButtonNegative.setText(this.mButtonNegativeText);
        Drawable r15 = this.mButtonNegativeIcon;
        if (r15 == null) goto L19;
        int r16 = this.mButtonIconDimen;
        r15.setBounds(0, 0, r16, r16);
        this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
    L19:
        this.mButtonNegative.setVisibility(0);
        r13 = r13 | 2;
    L20:
        Button r17 = (Button) r10.findViewById(R.id.button3);
        this.mButtonNeutral = r17;
        r17.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNeutralText) == true) goto L23;
    L25:
        this.mButtonNeutral.setText(this.mButtonNeutralText);
        Drawable r18 = this.mButtonNeutralIcon;
        if (r18 == null) goto L28;
        int r19 = this.mButtonIconDimen;
        r18.setBounds(0, 0, r19, r19);
        this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
    L28:
        this.mButtonNeutral.setVisibility(0);
        r13 = r13 | 4;
    L30:
        if (shouldCenterSingleButton(this.mContext) == false) goto L39;
        if (r13 != 1) goto L34;
        centerButton(this.mButtonPositive);
        goto L39
    L34:
        if (r13 != 2) goto L37;
        centerButton(this.mButtonNegative);
        goto L39
    L37:
        if (r13 != 4) goto L39;
        centerButton(this.mButtonNeutral);
    L39:
        if (r13 != 0) goto L43;
        r10.setVisibility(8);
        return;
    L43:
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
        r13 = 0;
        goto L11
    }

    private void setupContent(ViewGroup r5) {
        NestedScrollView r10 = (NestedScrollView) this.mWindow.findViewById(androidx.appcompat.R.id.scrollView);
        this.mScrollView = r10;
        r10.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        TextView r11 = (TextView) r5.findViewById(R.id.message);
        this.mMessageView = r11;
        if (r11 != null) goto L5;
        return;
    L5:
        CharSequence r12 = this.mMessage;
        if (r12 == null) goto L8;
        r11.setText(r12);
        return;
    L8:
        r11.setVisibility(8);
        this.mScrollView.removeView(this.mMessageView);
        if (this.mListView == null) goto L11;
        ViewGroup r13 = (ViewGroup) this.mScrollView.getParent();
        int r14 = r13.indexOfChild(this.mScrollView);
        r13.removeViewAt(r14);
        r13.addView(this.mListView, r14, new ViewGroup.LayoutParams(-1, -1));
        return;
    L11:
        r5.setVisibility(8);
    }

    private void setupCustomContent(ViewGroup r10) {
        View r5 = this.mView;
        boolean r11 = false;
        if (r5 == null) goto L6;
    L9:
        if (r5 == null) goto L11;
        r11 = true;
    L11:
        if (r11 == true) goto L13;
    L14:
        this.mWindow.setFlags(131072, 131072);
    L15:
        if (r11 == false) goto L22;
        FrameLayout r12 = (FrameLayout) this.mWindow.findViewById(androidx.appcompat.R.id.custom);
        r12.addView(r5, new ViewGroup.LayoutParams(-1, -1));
        if (this.mViewSpacingSpecified == false) goto L20;
        r12.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
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
        if (canTextInput(r5) == true) goto L15;
    L6:
        if (this.mViewLayoutResId == 0) goto L8;
        r5 = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, r10, false);
        goto L9
    L8:
        r5 = null;
        goto L9
    }

    private void setupTitle(ViewGroup r10) {
        if (this.mCustomTitleView == null) goto L5;
        ViewGroup.LayoutParams r5 = new ViewGroup.LayoutParams(-1, -2);
        r10.addView(this.mCustomTitleView, 0, r5);
        this.mWindow.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
        return;
    L5:
        this.mIconView = (ImageView) this.mWindow.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.mTitle) == false) goto L8;
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
        View r5 = this.mWindow.findViewById(androidx.appcompat.R.id.parentPanel);
        View r10 = r5.findViewById(androidx.appcompat.R.id.topPanel);
        View r11 = r5.findViewById(androidx.appcompat.R.id.contentPanel);
        View r12 = r5.findViewById(androidx.appcompat.R.id.buttonPanel);
        ViewGroup r13 = (ViewGroup) r5.findViewById(androidx.appcompat.R.id.customPanel);
        setupCustomContent(r13);
        View r14 = r13.findViewById(androidx.appcompat.R.id.topPanel);
        View r15 = r13.findViewById(androidx.appcompat.R.id.contentPanel);
        View r16 = r13.findViewById(androidx.appcompat.R.id.buttonPanel);
        ViewGroup r17 = resolvePanel(r14, r10);
        ViewGroup r18 = resolvePanel(r15, r11);
        ViewGroup r19 = resolvePanel(r16, r12);
        setupContent(r18);
        setupButtons(r19);
        setupTitle(r17);
        int r20 = 0;
        if (r13.getVisibility() == 8) goto L5;
        boolean r21 = true;
    L6:
        if (r17 != null) goto L8;
    L10:
        boolean r22 = 0;
    L11:
        if (r19 != null) goto L13;
    L15:
        boolean r23 = false;
    L16:
        if (r23 == true) goto L21;
        if (r18 == null) goto L21;
        View r24 = r18.findViewById(androidx.appcompat.R.id.textSpacerNoButtons);
        if (r24 == null) goto L21;
        r24.setVisibility(0);
    L21:
        if (r22 == 0) goto L34;
        NestedScrollView r25 = this.mScrollView;
        if (r25 == null) goto L26;
        r25.setClipToPadding(true);
    L26:
        if (this.mMessage == null) goto L28;
    L31:
        View r26 = r17.findViewById(androidx.appcompat.R.id.titleDividerNoCustom);
    L32:
        if (r26 == null) goto L38;
        r26.setVisibility(0);
    L38:
        ListView r27 = this.mListView;
        if ((r27 instanceof RecycleListView) == false) goto L41;
        ((RecycleListView) r27).setHasDecor(r22, r23);
    L41:
        if (r21 == true) goto L50;
        View r28 = this.mListView;
        if (r28 != null) goto L46;
        r28 = this.mScrollView;
    L46:
        if (r28 == null) goto L50;
        if (r23 == false) goto L49;
        r20 = 2;
    L49:
        setScrollIndicators(r18, r28, r22 | r20, 3);
    L50:
        ListView r29 = this.mListView;
        if (r29 == null) goto L58;
        ListAdapter r30 = this.mAdapter;
        if (r30 == null) goto L59;
        r29.setAdapter(r30);
        int r31 = this.mCheckedItem;
        if (r31 <= (-1)) goto L60;
        r29.setItemChecked(r31, true);
        r29.setSelection(r31);
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L28:
        if (this.mListView != null) goto L31;
        r26 = null;
        goto L32
    L34:
        if (r18 == null) goto L38;
        View r32 = r18.findViewById(androidx.appcompat.R.id.textSpacerNoTitle);
        if (r32 == null) goto L38;
        r32.setVisibility(0);
        goto L38
    L13:
        if (r19.getVisibility() == 8) goto L15;
        r23 = true;
        goto L16
    L8:
        if (r17.getVisibility() == 8) goto L10;
        r22 = 1;
        goto L11
    L5:
        r21 = false;
        goto L6
    }

    private static boolean shouldCenterSingleButton(Context r5) {
        TypedValue r10 = new TypedValue();
        r5.getTheme().resolveAttribute(androidx.appcompat.R.attr.alertDialogCenterButtons, r10, true);
        if (r10.data != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public Button getButton(int r5) {
        if (r5 == (-3)) goto L15;
        if (r5 == (-2)) goto L13;
        if (r5 == (-1)) goto L11;
        return null;
    L11:
        return this.mButtonPositive;
    L13:
        return this.mButtonNegative;
    L15:
        return this.mButtonNeutral;
    }

    public int getIconAttributeResId(int r5) {
        TypedValue r10 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(r5, r10, true);
        return r10.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        int r5 = selectContentView();
        this.mDialog.setContentView(r5);
        setupView();
    }

    public boolean onKeyDown(int r5, KeyEvent r10) {
        NestedScrollView r11 = this.mScrollView;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.executeKeyEvent(r10) == false) goto L7;
        return true;
    }

    public boolean onKeyUp(int r5, KeyEvent r10) {
        NestedScrollView r11 = this.mScrollView;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.executeKeyEvent(r10) == false) goto L7;
        return true;
    }

    public void setButton(int r5, CharSequence r10, DialogInterface.OnClickListener r11, Message r12, Drawable r13) {
        if (r12 != null) goto L6;
        if (r11 == null) goto L6;
        r12 = this.mHandler.obtainMessage(r5, r11);
    L6:
        if (r5 != (-3)) goto L8;
        this.mButtonNeutralText = r10;
        this.mButtonNeutralMessage = r12;
        this.mButtonNeutralIcon = r13;
        return;
    L8:
        if (r5 != (-2)) goto L10;
        this.mButtonNegativeText = r10;
        this.mButtonNegativeMessage = r12;
        this.mButtonNegativeIcon = r13;
        return;
    L10:
        if (r5 != (-1)) goto L13;
        this.mButtonPositiveText = r10;
        this.mButtonPositiveMessage = r12;
        this.mButtonPositiveIcon = r13;
        return;
    L13:
        throw new IllegalArgumentException("Button does not exist");
    }

    public void setButtonPanelLayoutHint(int r5) {
        this.mButtonPanelLayoutHint = r5;
    }

    public void setCustomTitle(View r5) {
        this.mCustomTitleView = r5;
    }

    public void setIcon(int r5) {
        this.mIcon = null;
        this.mIconId = r5;
        ImageView r10 = this.mIconView;
        if (r10 == null) goto L8;
        if (r5 == 0) goto L6;
        r10.setVisibility(0);
        this.mIconView.setImageResource(this.mIconId);
        return;
    L6:
        r10.setVisibility(8);
        return;
    }

    public void setMessage(CharSequence r5) {
        this.mMessage = r5;
        TextView r10 = this.mMessageView;
        if (r10 == null) goto L6;
        r10.setText(r5);
        return;
    }

    public void setTitle(CharSequence r5) {
        this.mTitle = r5;
        TextView r10 = this.mTitleView;
        if (r10 == null) goto L6;
        r10.setText(r5);
        return;
    }

    public void setView(int r5) {
        this.mView = null;
        this.mViewLayoutResId = r5;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View r5) {
        this.mView = r5;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setIcon(Drawable r5) {
        this.mIcon = r5;
        this.mIconId = 0;
        ImageView r10 = this.mIconView;
        if (r10 == null) goto L8;
        if (r5 == null) goto L6;
        r10.setVisibility(0);
        this.mIconView.setImageDrawable(r5);
        return;
    L6:
        r10.setVisibility(8);
        return;
    }

    public void setView(View r5, int r10, int r11, int r12, int r13) {
        this.mView = r5;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = r10;
        this.mViewSpacingTop = r11;
        this.mViewSpacingRight = r12;
        this.mViewSpacingBottom = r13;
    }
}
