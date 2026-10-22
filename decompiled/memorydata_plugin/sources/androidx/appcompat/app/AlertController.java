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
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
            void onPrepareListView(ListView r1);
        }

        public AlertParams(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.mIconId = 0;
            this.mIconAttrId = 0;
            this.mViewSpacingSpecified = false;
            this.mCheckedItem = -1;
            this.mRecycleOnMeasure = true;
            this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) ZeusTransformUtils.preCheckCast(r5.getSystemService("layout_inflater"), LayoutInflater.class, "com.obric.memorydata.plugin");
        }

        private void createListView(final AlertController r11) {
            final RecycleListView r0 = (RecycleListView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(this.mInflater, r11.mListLayout, null, "com.obric.memorydata.plugin"), RecycleListView.class, "com.obric.memorydata.plugin");
            if (this.mIsMultiChoice == false) goto L9;
            if (this.mCursor != null) goto L7;
            final Context r3 = this.mContext;
            final int r4 = r11.mMultiChoiceItemLayout;
            final int r5 = R.id.text1;
            final CharSequence[] r6 = this.mItems;
            ListAdapter r9 = new AnonymousClass1(this, r3, r4, r5, r6, r0);
        L19:
            OnPrepareListViewListener r1 = this.mOnPrepareListViewListener;
            if (r1 == null) goto L22;
            r1.onPrepareListView(r0);
        L22:
            r11.mAdapter = r9;
            r11.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener == null) goto L27;
            AdapterView.OnItemClickListener r2 = new AnonymousClass3(this, r11);
        L25:
            r0.setOnItemClickListener(r2);
        L29:
            AdapterView.OnItemSelectedListener r7 = this.mOnItemSelectedListener;
            if (r7 == null) goto L33;
            r0.setOnItemSelectedListener(r7);
        L33:
            if (this.mIsSingleChoice == false) goto L36;
            r0.setChoiceMode(1);
        L38:
            r11.mListView = r0;
            return;
        L36:
            if (this.mIsMultiChoice == false) goto L38;
            r0.setChoiceMode(2);
            goto L38
        L27:
            if (this.mOnCheckboxClickListener == null) goto L29;
            r2 = new AnonymousClass4(this, r0, r11);
            goto L25
        L7:
            final Context r8 = this.mContext;
            final Cursor r10 = this.mCursor;
            final boolean r12 = false;
            r9 = new AnonymousClass2(this, r8, r10, r12, r0, r11);
            goto L19
        L9:
            if (this.mIsSingleChoice == false) goto L11;
            int r13 = r11.mSingleChoiceItemLayout;
        L12:
            int r14 = r13;
            if (this.mCursor == null) goto L15;
            r9 = new SimpleCursorAdapter(this.mContext, r14, this.mCursor, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
            goto L19
        L15:
            r9 = this.mAdapter;
            if (r9 != null) goto L19;
            r9 = new CheckedItemAdapter(this.mContext, r14, R.id.text1, this.mItems);
            goto L19
        L11:
            r13 = r11.mListItemLayout;
            goto L12
        }

        public void apply(AlertController r14) {
            View r0 = this.mCustomTitleView;
            if (r0 == null) goto L5;
            r14.setCustomTitle(r0);
        L17:
            CharSequence r1 = this.mMessage;
            if (r1 == null) goto L20;
            r14.setMessage(r1);
        L20:
            CharSequence r3 = this.mPositiveButtonText;
            if (r3 == null) goto L23;
        L24:
            r14.setButton(-1, r3, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
        L25:
            CharSequence r9 = this.mNegativeButtonText;
            if (r9 == null) goto L28;
        L29:
            r14.setButton(-2, r9, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
        L30:
            CharSequence r2 = this.mNeutralButtonText;
            if (r2 == null) goto L33;
        L34:
            r14.setButton(-3, r2, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
        L36:
            if (this.mItems == null) goto L38;
        L41:
            createListView(r14);
        L42:
            View r4 = this.mView;
            if (r4 != null) goto L45;
            int r13 = this.mViewLayoutResId;
            if (r13 == 0) goto L54;
            r14.setView(r13);
            return;
        L54:
            return;
        L45:
            if (this.mViewSpacingSpecified == false) goto L47;
            r14.setView(r4, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            return;
        L47:
            r14.setView(r4);
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
            CharSequence r5 = this.mTitle;
            if (r5 == null) goto L8;
            r14.setTitle(r5);
        L8:
            Drawable r6 = this.mIcon;
            if (r6 == null) goto L11;
            r14.setIcon(r6);
        L11:
            int r7 = this.mIconId;
            if (r7 == 0) goto L14;
            r14.setIcon(r7);
        L14:
            int r8 = this.mIconAttrId;
            if (r8 == 0) goto L17;
            r14.setIcon(r14.getIconAttributeResId(r8));
            goto L17
        }
    }

    private static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface r3) {
            this.mDialog = new WeakReference((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            int r0 = r4.what;
            if (r0 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(r4.obj, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin")).onClick((DialogInterface) ZeusTransformUtils.preCheckCast(this.mDialog.get(), DialogInterface.class, "com.obric.memorydata.plugin"), r4.what);
            return;
        L5:
            if (r0 == (-2)) goto L12;
            if (r0 == (-1)) goto L12;
            if (r0 != 1) goto L15;
            ((DialogInterface) ZeusTransformUtils.preCheckCast(r4.obj, DialogInterface.class, "com.obric.memorydata.plugin")).dismiss();
            return;
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context r3, int r4, int r5, CharSequence[] r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context r3) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
        }

        public RecycleListView(Context r4, AttributeSet r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r6, r7);
            TypedArray r8 = r6.obtainStyledAttributes(r7, com.obric.memorydata.plugin.R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.RecycleListView_paddingBottomNoButtons, "styleable", "RecycleListView_paddingBottomNoButtons"), -1);
            this.mPaddingTopNoTitle = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.RecycleListView_paddingTopNoTitle, "styleable", "RecycleListView_paddingTopNoTitle"), -1);
        }

        public void setHasDecor(boolean r3, boolean r4) {
            if (r4 == false) goto L4;
            if (r3 == false) goto L4;
            return;
        L4:
            int r0 = getPaddingLeft();
            if (r3 == false) goto L7;
            int r5 = getPaddingTop();
        L8:
            int r1 = getPaddingRight();
            if (r4 == false) goto L11;
            int r6 = getPaddingBottom();
        L12:
            setPadding(r0, r5, r1, r6);
            return;
        L11:
            r6 = this.mPaddingBottomNoButtons;
            goto L12
        L7:
            r5 = this.mPaddingTopNoTitle;
            goto L8
        }
    }

    public AlertController(Context r5, AppCompatDialog r6, Window r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.mViewSpacingSpecified = false;
        this.mIconId = 0;
        this.mCheckedItem = -1;
        this.mButtonPanelLayoutHint = 0;
        this.mButtonHandler = new AnonymousClass1(this);
        this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.mDialog = r6;
        this.mWindow = r7;
        this.mHandler = new ButtonHandler(r6);
        TypedArray r9 = r8.obtainStyledAttributes(null, com.obric.memorydata.plugin.R.styleable.AlertDialog, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.alertDialogStyle, "attr", "alertDialogStyle"), 0);
        this.mAlertDialogLayout = r9.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.AlertDialog_android_layout, "styleable", "AlertDialog_android_layout"), 0);
        this.mButtonPanelSideLayout = r9.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.AlertDialog_buttonPanelSideLayout, "styleable", "AlertDialog_buttonPanelSideLayout"), 0);
        this.mListLayout = r9.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.AlertDialog_listLayout, "styleable", "AlertDialog_listLayout"), 0);
        this.mMultiChoiceItemLayout = r9.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.AlertDialog_multiChoiceItemLayout, "styleable", "AlertDialog_multiChoiceItemLayout"), 0);
        this.mSingleChoiceItemLayout = r9.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.AlertDialog_singleChoiceItemLayout, "styleable", "AlertDialog_singleChoiceItemLayout"), 0);
        this.mListItemLayout = r9.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.AlertDialog_listItemLayout, "styleable", "AlertDialog_listItemLayout"), 0);
        this.mShowTitle = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.AlertDialog_showTitle, "styleable", "AlertDialog_showTitle"), true);
        this.mButtonIconDimen = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.AlertDialog_buttonIconDimen, "styleable", "AlertDialog_buttonIconDimen"), 0);
        r9.recycle();
        r6.supportRequestWindowFeature(1);
    }

    static boolean canTextInput(View r4) {
        if (r4.onCheckIsTextEditor() == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == true) goto L8;
        return false;
    L8:
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
        int r0 = r5.getChildCount();
    L9:
        if (r0 <= 0) goto L13;
        r0 = r0 - 1;
        if (canTextInput(r5.getChildAt(r0)) == false) goto L9;
        return true;
    L13:
        return false;
    }

    private void centerButton(Button r3) {
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r2.gravity = 1;
        r2.weight = 0.5f;
        r3.setLayoutParams(r2);
    }

    static void manageScrollIndicators(View r3, View r4, View r5) {
        int r0 = 0;
        if (r4 != null) goto L5;
    L9:
        if (r5 != null) goto L11;
        return;
    L11:
        if (r3.canScrollVertically(1) == true) goto L14;
        r0 = 4;
    L14:
        r5.setVisibility(r0);
        return;
    L5:
        if (r3.canScrollVertically(-1) == false) goto L7;
        int r2 = 0;
    L8:
        r4.setVisibility(r2);
        goto L9
    L7:
        r2 = 4;
        goto L8
    }

    private ViewGroup resolvePanel(View r3, View r4) {
        if (r3 == null) goto L5;
        if (r4 == null) goto L15;
        ViewParent r0 = r4.getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L15;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(r4);
    L15:
        if (ZeusTransformUtils.instanceOf(r3, ViewStub.class) == false) goto L17;
        r3 = ((ViewStub) ZeusTransformUtils.preCheckCast(r3, ViewStub.class, "com.obric.memorydata.plugin")).inflate();
    L17:
        Object r2 = ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin");
    L9:
        return (ViewGroup) r2;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ViewStub.class) == false) goto L7;
        r4 = ((ViewStub) ZeusTransformUtils.preCheckCast(r4, ViewStub.class, "com.obric.memorydata.plugin")).inflate();
    L7:
        r2 = ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
        goto L9
    }

    private int selectContentView() {
        int r0 = this.mButtonPanelSideLayout;
        if (r0 != 0) goto L7;
        return this.mAlertDialogLayout;
    L7:
        if (this.mButtonPanelLayoutHint != 1) goto L10;
        return r0;
    L10:
        return this.mAlertDialogLayout;
    }

    private void setScrollIndicators(ViewGroup r6, View r7, int r8, int r9) {
        final View r0 = this.mWindow.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.scrollIndicatorUp, OaidModel.KEY_ID, "scrollIndicatorUp"));
        final View r1 = this.mWindow.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.scrollIndicatorDown, OaidModel.KEY_ID, "scrollIndicatorDown"));
        if (Build.VERSION.SDK_INT < 23) goto L10;
        ViewCompat.setScrollIndicators(r7, r8, r9);
        if (r0 == null) goto L7;
        r6.removeView(r0);
    L7:
        if (r1 == null) goto L30;
    L8:
        r6.removeView(r1);
        return;
    L30:
        return;
    L10:
        if (r0 != null) goto L12;
    L14:
        if (r1 != null) goto L16;
    L18:
        if (r0 != null) goto L21;
        if (r1 != null) goto L21;
        return;
    L21:
        if (this.mMessage == null) goto L23;
        this.mScrollView.setOnScrollChangeListener(new AnonymousClass2(this, r0, r1));
        this.mScrollView.post(new AnonymousClass3(this, r0, r1));
        return;
    L23:
        ListView r10 = this.mListView;
        if (r10 == null) goto L26;
        r10.setOnScrollListener(new AnonymousClass4(this, r0, r1));
        this.mListView.post(new AnonymousClass5(this, r0, r1));
        return;
    L26:
        if (r0 == null) goto L28;
        r6.removeView(r0);
    L28:
        if (r1 != null) goto L8;
        return;
    L16:
        if ((r8 & 2) != 0) goto L18;
        r6.removeView(r1);
        r1 = null;
        goto L18
    L12:
        if ((r8 & 1) != 0) goto L14;
        r6.removeView(r0);
        r0 = null;
        goto L14
    }

    private void setupButtons(ViewGroup r9) {
        Button r0 = (Button) ZeusTransformUtils.preCheckCast(r9.findViewById(R.id.button1), Button.class, "com.obric.memorydata.plugin");
        this.mButtonPositive = r0;
        r0.setOnClickListener(this.mButtonHandler);
        boolean r1 = true;
        if (TextUtils.isEmpty(this.mButtonPositiveText) == true) goto L5;
    L7:
        this.mButtonPositive.setText(this.mButtonPositiveText);
        Drawable r2 = this.mButtonPositiveIcon;
        if (r2 == null) goto L10;
        int r6 = this.mButtonIconDimen;
        r2.setBounds(0, 0, r6, r6);
        this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
    L10:
        this.mButtonPositive.setVisibility(0);
        int r3 = 1;
    L11:
        Button r7 = (Button) ZeusTransformUtils.preCheckCast(r9.findViewById(R.id.button2), Button.class, "com.obric.memorydata.plugin");
        this.mButtonNegative = r7;
        r7.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNegativeText) == true) goto L14;
    L16:
        this.mButtonNegative.setText(this.mButtonNegativeText);
        Drawable r8 = this.mButtonNegativeIcon;
        if (r8 == null) goto L19;
        int r10 = this.mButtonIconDimen;
        r8.setBounds(0, 0, r10, r10);
        this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
    L19:
        this.mButtonNegative.setVisibility(0);
        r3 = r3 | 2;
    L20:
        Button r4 = (Button) ZeusTransformUtils.preCheckCast(r9.findViewById(R.id.button3), Button.class, "com.obric.memorydata.plugin");
        this.mButtonNeutral = r4;
        r4.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNeutralText) == true) goto L23;
    L25:
        this.mButtonNeutral.setText(this.mButtonNeutralText);
        Drawable r5 = this.mButtonNeutralIcon;
        if (r5 == null) goto L28;
        int r11 = this.mButtonIconDimen;
        r5.setBounds(0, 0, r11, r11);
        this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
    L28:
        this.mButtonNeutral.setVisibility(0);
        r3 = r3 | 4;
    L30:
        if (shouldCenterSingleButton(this.mContext) == false) goto L40;
        if (r3 != 1) goto L35;
        Button r12 = this.mButtonPositive;
    L33:
        centerButton(r12);
        goto L40
    L35:
        if (r3 != 2) goto L38;
        r12 = this.mButtonNegative;
        goto L33
    L38:
        if (r3 != 4) goto L40;
        r12 = this.mButtonNeutral;
    L40:
        if (r3 != 0) goto L43;
        r1 = false;
    L43:
        if (r1 == true) goto L46;
        r9.setVisibility(8);
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
        r3 = 0;
        goto L11
    }

    private void setupContent(ViewGroup r5) {
        NestedScrollView r0 = (NestedScrollView) ZeusTransformUtils.preCheckCast(this.mWindow.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.scrollView, OaidModel.KEY_ID, "scrollView")), NestedScrollView.class, "com.obric.memorydata.plugin");
        this.mScrollView = r0;
        r0.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(R.id.message), TextView.class, "com.obric.memorydata.plugin");
        this.mMessageView = r1;
        if (r1 != null) goto L5;
        return;
    L5:
        CharSequence r2 = this.mMessage;
        if (r2 == null) goto L8;
        r1.setText(r2);
        return;
    L8:
        r1.setVisibility(8);
        this.mScrollView.removeView(this.mMessageView);
        if (this.mListView == null) goto L11;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mScrollView.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        int r3 = r6.indexOfChild(this.mScrollView);
        r6.removeViewAt(r3);
        r6.addView(this.mListView, r3, new ViewGroup.LayoutParams(-1, -1));
        return;
    L11:
        r5.setVisibility(8);
    }

    private void setupCustomContent(ViewGroup r7) {
        View r0 = this.mView;
        boolean r1 = false;
        if (r0 == null) goto L6;
    L9:
        if (r0 == null) goto L11;
        r1 = true;
    L11:
        if (r1 == true) goto L13;
    L14:
        this.mWindow.setFlags(131072, 131072);
    L15:
        if (r1 == false) goto L22;
        FrameLayout r2 = (FrameLayout) ZeusTransformUtils.preCheckCast(this.mWindow.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.custom, OaidModel.KEY_ID, "custom")), FrameLayout.class, "com.obric.memorydata.plugin");
        r2.addView(r0, new ViewGroup.LayoutParams(-1, -1));
        if (this.mViewSpacingSpecified == false) goto L20;
        r2.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
    L20:
        if (this.mListView == null) goto L24;
        ((LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r7.getLayoutParams(), LinearLayoutCompat.LayoutParams.class, "com.obric.memorydata.plugin")).weight = 0.0f;
        return;
    L24:
        return;
    L22:
        r7.setVisibility(8);
        return;
    L13:
        if (canTextInput(r0) == true) goto L15;
    L6:
        if (this.mViewLayoutResId == 0) goto L8;
        r0 = ZeusTransformUtils.inflate(LayoutInflater.from(this.mContext), this.mViewLayoutResId, r7, false, "com.obric.memorydata.plugin");
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    private void setupTitle(ViewGroup r7) {
        if (this.mCustomTitleView == null) goto L5;
        r7.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
        this.mWindow.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.title_template, OaidModel.KEY_ID, "title_template")).setVisibility(8);
        return;
    L5:
        this.mIconView = (ImageView) ZeusTransformUtils.preCheckCast(this.mWindow.findViewById(R.id.icon), ImageView.class, "com.obric.memorydata.plugin");
        if ((!TextUtils.isEmpty(this.mTitle)) == true) goto L8;
    L16:
        this.mWindow.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.title_template, OaidModel.KEY_ID, "title_template")).setVisibility(8);
        this.mIconView.setVisibility(8);
        r7.setVisibility(8);
        return;
    L8:
        if (this.mShowTitle == false) goto L16;
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(this.mWindow.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.alertTitle, OaidModel.KEY_ID, "alertTitle")), TextView.class, "com.obric.memorydata.plugin");
        this.mTitleView = r8;
        r8.setText(this.mTitle);
        int r9 = this.mIconId;
        if (r9 == 0) goto L12;
        this.mIconView.setImageResource(r9);
        return;
    L12:
        Drawable r10 = this.mIcon;
        if (r10 == null) goto L15;
        this.mIconView.setImageDrawable(r10);
        return;
    L15:
        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
        this.mIconView.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupView() {
        View r0 = this.mWindow.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.parentPanel, OaidModel.KEY_ID, "parentPanel"));
        View r1 = r0.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.topPanel, OaidModel.KEY_ID, "topPanel"));
        View r4 = r0.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.contentPanel, OaidModel.KEY_ID, "contentPanel"));
        View r6 = r0.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.buttonPanel, OaidModel.KEY_ID, "buttonPanel"));
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.customPanel, OaidModel.KEY_ID, "customPanel")), ViewGroup.class, "com.obric.memorydata.plugin");
        setupCustomContent(r2);
        View r3 = r2.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.topPanel, OaidModel.KEY_ID, "topPanel"));
        View r5 = r2.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.contentPanel, OaidModel.KEY_ID, "contentPanel"));
        View r7 = r2.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.buttonPanel, OaidModel.KEY_ID, "buttonPanel"));
        ViewGroup r8 = resolvePanel(r3, r1);
        ViewGroup r9 = resolvePanel(r5, r4);
        ViewGroup r10 = resolvePanel(r7, r6);
        setupContent(r9);
        setupButtons(r10);
        setupTitle(r8);
        int r11 = 0;
        if (r2 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r8 != null) goto L10;
    L12:
        boolean r13 = 0;
    L13:
        if (r10 != null) goto L15;
    L17:
        boolean r14 = false;
    L18:
        if (r14 == true) goto L23;
        if (r9 == null) goto L23;
        View r15 = r9.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.textSpacerNoButtons, OaidModel.KEY_ID, "textSpacerNoButtons"));
        if (r15 == null) goto L23;
        r15.setVisibility(0);
    L23:
        if (r13 == 0) goto L34;
        NestedScrollView r16 = this.mScrollView;
        if (r16 == null) goto L27;
        r16.setClipToPadding(true);
    L27:
        View r17 = null;
        if (this.mMessage == null) goto L30;
    L31:
        r17 = r8.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.titleDividerNoCustom, OaidModel.KEY_ID, "titleDividerNoCustom"));
    L32:
        if (r17 == null) goto L39;
        r17.setVisibility(0);
    L39:
        if (ZeusTransformUtils.instanceOf(this.mListView, RecycleListView.class) == false) goto L41;
        ((RecycleListView) ZeusTransformUtils.preCheckCast(this.mListView, RecycleListView.class, "com.obric.memorydata.plugin")).setHasDecor(r13, r14);
    L41:
        if (r12 == true) goto L50;
        View r18 = this.mListView;
        if (r18 != null) goto L46;
        r18 = this.mScrollView;
    L46:
        if (r18 == null) goto L50;
        if (r14 == false) goto L49;
        r11 = 2;
    L49:
        setScrollIndicators(r9, r18, r13 | r11, 3);
    L50:
        ListView r19 = this.mListView;
        if (r19 == null) goto L58;
        ListAdapter r20 = this.mAdapter;
        if (r20 == null) goto L59;
        r19.setAdapter(r20);
        int r110 = this.mCheckedItem;
        if (r110 <= (-1)) goto L60;
        r19.setItemChecked(r110, true);
        r19.setSelection(r110);
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L30:
        if (this.mListView == null) goto L32;
    L34:
        if (r9 == null) goto L39;
        View r21 = r9.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.textSpacerNoTitle, OaidModel.KEY_ID, "textSpacerNoTitle"));
        if (r21 == null) goto L39;
        r21.setVisibility(0);
        goto L39
    L15:
        if (r10.getVisibility() == 8) goto L17;
        r14 = true;
        goto L18
    L10:
        if (r8.getVisibility() == 8) goto L12;
        r13 = 1;
        goto L13
    L5:
        if (r2.getVisibility() == 8) goto L7;
        r12 = true;
        goto L8
    }

    private static boolean shouldCenterSingleButton(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        TypedValue r0 = new TypedValue();
        r5.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.alertDialogCenterButtons, "attr", "alertDialogCenterButtons"), r0, true);
        if (r0.data != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public Button getButton(int r2) {
        if (r2 == (-3)) goto L15;
        if (r2 == (-2)) goto L13;
        if (r2 == (-1)) goto L11;
        return null;
    L11:
        return this.mButtonPositive;
    L13:
        return this.mButtonNegative;
    L15:
        return this.mButtonNeutral;
    }

    public int getIconAttributeResId(int r3) {
        TypedValue r0 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(r3, r0, true);
        return r0.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        int r0 = selectContentView();
        this.mDialog.setContentView(r0);
        setupView();
    }

    public boolean onKeyDown(int r1, KeyEvent r2) {
        NestedScrollView r0 = this.mScrollView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.executeKeyEvent(r2) == false) goto L7;
        return true;
    }

    public boolean onKeyUp(int r1, KeyEvent r2) {
        NestedScrollView r0 = this.mScrollView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.executeKeyEvent(r2) == false) goto L7;
        return true;
    }

    public void setButton(int r3, CharSequence r4, DialogInterface.OnClickListener r5, Message r6, Drawable r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        DialogInterface.OnClickListener r9 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
        if (r9 == null) goto L7;
        r6 = this.mHandler.obtainMessage(r3, r9);
    L7:
        if (r3 != (-3)) goto L9;
        this.mButtonNeutralText = r8;
        this.mButtonNeutralMessage = r6;
        this.mButtonNeutralIcon = r7;
        return;
    L9:
        if (r3 != (-2)) goto L11;
        this.mButtonNegativeText = r8;
        this.mButtonNegativeMessage = r6;
        this.mButtonNegativeIcon = r7;
        return;
    L11:
        if (r3 != (-1)) goto L14;
        this.mButtonPositiveText = r8;
        this.mButtonPositiveMessage = r6;
        this.mButtonPositiveIcon = r7;
        return;
    L14:
        throw new IllegalArgumentException("Button does not exist");
    }

    public void setButtonPanelLayoutHint(int r1) {
        this.mButtonPanelLayoutHint = r1;
    }

    public void setCustomTitle(View r1) {
        this.mCustomTitleView = r1;
    }

    public void setIcon(int r2) {
        this.mIcon = null;
        this.mIconId = r2;
        ImageView r0 = this.mIconView;
        if (r0 == null) goto L8;
        if (r2 == 0) goto L6;
        r0.setVisibility(0);
        this.mIconView.setImageResource(this.mIconId);
        return;
    L6:
        r0.setVisibility(8);
        return;
    }

    public void setIcon(Drawable r3) {
        this.mIcon = r3;
        this.mIconId = 0;
        ImageView r1 = this.mIconView;
        if (r1 == null) goto L8;
        if (r3 == null) goto L6;
        r1.setVisibility(0);
        this.mIconView.setImageDrawable(r3);
        return;
    L6:
        r1.setVisibility(8);
        return;
    }

    public void setMessage(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mMessage = r4;
        TextView r2 = this.mMessageView;
        if (r2 == null) goto L6;
        r2.setText(r4);
        return;
    }

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mTitle = r4;
        TextView r2 = this.mTitleView;
        if (r2 == null) goto L6;
        r2.setText(r4);
        return;
    }

    public void setView(int r2) {
        this.mView = null;
        this.mViewLayoutResId = r2;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View r1) {
        this.mView = r1;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View r1, int r2, int r3, int r4, int r5) {
        this.mView = r1;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = r2;
        this.mViewSpacingTop = r3;
        this.mViewSpacingRight = r4;
        this.mViewSpacingBottom = r5;
    }
}
