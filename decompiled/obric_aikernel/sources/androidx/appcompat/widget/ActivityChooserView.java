package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
    private final View mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    final ActivityChooserViewAdapter mAdapter;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    final DataSetObserver mModelDataSetObserver;
    PopupWindow.OnDismissListener mOnDismissListener;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    ActionProvider mProvider;

    private class ActivityChooserViewAdapter extends BaseAdapter {
        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        private static final int ITEM_VIEW_TYPE_COUNT = 3;
        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        private ActivityChooserModel mDataModel;
        private boolean mHighlightDefaultActivity;
        private int mMaxActivityCount;
        private boolean mShowDefaultActivity;
        private boolean mShowFooterView;
        final /* synthetic */ ActivityChooserView this$0;

        ActivityChooserViewAdapter(ActivityChooserView r10) {
            this.this$0 = r10;
            this.mMaxActivityCount = 4;
        }

        public int getActivityCount() {
            return this.mDataModel.getActivityCount();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r10 = this.mDataModel.getActivityCount();
            if (this.mShowDefaultActivity == false) goto L5;
        L7:
            int r11 = Math.min(r10, this.mMaxActivityCount);
            if (this.mShowFooterView == true) goto L10;
            return r11;
        L10:
            return r11 + 1;
        L5:
            if (this.mDataModel.getDefaultActivity() == null) goto L7;
            r10 = r10 - 1;
            goto L7
        }

        public ActivityChooserModel getDataModel() {
            return this.mDataModel;
        }

        public ResolveInfo getDefaultActivity() {
            return this.mDataModel.getDefaultActivity();
        }

        public int getHistorySize() {
            return this.mDataModel.getHistorySize();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r10) {
            int r11 = getItemViewType(r10);
            if (r11 == 0) goto L11;
            if (r11 != 1) goto L9;
            return null;
        L9:
            throw new IllegalArgumentException();
        L11:
            if (this.mShowDefaultActivity == true) goto L16;
            if (this.mDataModel.getDefaultActivity() == null) goto L16;
            r10 = r10 + 1;
        L16:
            return this.mDataModel.getActivity(r10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r10) {
            if (this.mShowFooterView == true) goto L5;
            return 0;
        L5:
            if (r10 != (getCount() - 1)) goto L9;
            return 1;
        L9:
            return 0;
        }

        public boolean getShowDefaultActivity() {
            return this.mShowDefaultActivity;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            int r13 = getItemViewType(r10);
            if (r13 == 0) goto L12;
            if (r13 != 1) goto L11;
            if (r11 != null) goto L7;
        L8:
            View r14 = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, r12, false);
            r14.setId(1);
            ((TextView) r14.findViewById(R.id.title)).setText(this.this$0.getContext().getString(R.string.abc_activity_chooser_view_see_all));
            return r14;
        L7:
            if (r11.getId() != 1) goto L8;
            return r11;
        L11:
            throw new IllegalArgumentException();
        L12:
            if (r11 != null) goto L14;
        L15:
            r11 = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, r12, false);
        L16:
            PackageManager r15 = this.this$0.getContext().getPackageManager();
            ImageView r16 = (ImageView) r11.findViewById(R.id.icon);
            ResolveInfo r17 = (ResolveInfo) getItem(r10);
            r16.setImageDrawable(r17.loadIcon(r15));
            ((TextView) r11.findViewById(R.id.title)).setText(r17.loadLabel(r15));
            if (this.mShowDefaultActivity == false) goto L22;
            if (r10 != 0) goto L22;
            if (this.mHighlightDefaultActivity == false) goto L22;
            r11.setActivated(true);
        L23:
            return r11;
        L22:
            r11.setActivated(false);
            goto L23
        L14:
            if (r11.getId() == R.id.list_item) goto L16;
            goto L15
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public int measureContentWidth() {
            int r10 = this.mMaxActivityCount;
            this.mMaxActivityCount = Integer.MAX_VALUE;
            int r11 = 0;
            int r12 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int r13 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int r14 = getCount();
            int r15 = 0;
            View r16 = null;
        L3:
            if (r11 >= r14) goto L5;
            r16 = getView(r11, r16, null);
            r16.measure(r12, r13);
            r15 = Math.max(r15, r16.getMeasuredWidth());
            r11 = r11 + 1;
            goto L3
        L5:
            this.mMaxActivityCount = r10;
            return r15;
        }

        public void setDataModel(ActivityChooserModel r10) {
            ActivityChooserModel r11 = this.this$0.mAdapter.getDataModel();
            if (r11 != null) goto L5;
        L7:
            this.mDataModel = r10;
            if (r10 != null) goto L10;
        L12:
            notifyDataSetChanged();
            return;
        L10:
            if (this.this$0.isShown() == false) goto L12;
            r10.registerObserver(this.this$0.mModelDataSetObserver);
            goto L12
        L5:
            if (this.this$0.isShown() == false) goto L7;
            r11.unregisterObserver(this.this$0.mModelDataSetObserver);
            goto L7
        }

        public void setMaxActivityCount(int r10) {
            if (this.mMaxActivityCount == r10) goto L6;
            this.mMaxActivityCount = r10;
            notifyDataSetChanged();
            return;
        }

        public void setShowDefaultActivity(boolean r10, boolean r11) {
            if (this.mShowDefaultActivity == r10) goto L5;
        L6:
            this.mShowDefaultActivity = r10;
            this.mHighlightDefaultActivity = r11;
            notifyDataSetChanged();
            return;
        L5:
            if (this.mHighlightDefaultActivity != r11) goto L6;
        }

        public void setShowFooterView(boolean r10) {
            if (this.mShowFooterView == r10) goto L6;
            this.mShowFooterView = r10;
            notifyDataSetChanged();
            return;
        }
    }

    private class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        final /* synthetic */ ActivityChooserView this$0;

        Callbacks(ActivityChooserView r10) {
            this.this$0 = r10;
        }

        private void notifyOnDismissListener() {
            PopupWindow.OnDismissListener r10 = this.this$0.mOnDismissListener;
            if (r10 == null) goto L6;
            r10.onDismiss();
            return;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            ActivityChooserView r11 = this.this$0;
            if (r10 != r11.mDefaultActivityButton) goto L8;
            r11.dismissPopup();
            ResolveInfo r12 = this.this$0.mAdapter.getDefaultActivity();
            int r13 = this.this$0.mAdapter.getDataModel().getActivityIndex(r12);
            Intent r14 = this.this$0.mAdapter.getDataModel().chooseActivity(r13);
            if (r14 == null) goto L13;
            r14.addFlags(524288);
            this.this$0.getContext().startActivity(r14);
            return;
        L13:
            return;
        L8:
            if (r10 != r11.mExpandActivityOverflowButton) goto L12;
            r11.mIsSelectingDefaultActivity = false;
            r11.showPopupUnchecked(r11.mInitialActivityCount);
            return;
        L12:
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            notifyOnDismissListener();
            ActionProvider r10 = this.this$0.mProvider;
            if (r10 == null) goto L6;
            r10.subUiVisibilityChanged(false);
            return;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r10, View r11, int r12, long r13) {
            int r14 = ((ActivityChooserViewAdapter) r10.getAdapter()).getItemViewType(r12);
            if (r14 != 0) goto L5;
            this.this$0.dismissPopup();
            ActivityChooserView r15 = this.this$0;
            if (r15.mIsSelectingDefaultActivity == false) goto L14;
            if (r12 <= 0) goto L22;
            r15.mAdapter.getDataModel().setDefaultActivity(r12);
            return;
        L22:
            return;
        L14:
            if (r15.mAdapter.getShowDefaultActivity() == true) goto L17;
            r12 = r12 + 1;
        L17:
            Intent r16 = this.this$0.mAdapter.getDataModel().chooseActivity(r12);
            if (r16 == null) goto L24;
            r16.addFlags(524288);
            this.this$0.getContext().startActivity(r16);
            return;
        L24:
            return;
        L5:
            if (r14 != 1) goto L8;
            this.this$0.showPopupUnchecked(Integer.MAX_VALUE);
            return;
        L8:
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r10) {
            ActivityChooserView r11 = this.this$0;
            if (r10 != r11.mDefaultActivityButton) goto L9;
            if (r11.mAdapter.getCount() <= 0) goto L7;
            ActivityChooserView r12 = this.this$0;
            r12.mIsSelectingDefaultActivity = true;
            r12.showPopupUnchecked(r12.mInitialActivityCount);
        L7:
            return true;
        L9:
            throw new IllegalArgumentException();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {
        private static final int[] TINT_ATTRS = null;

        static {
            TINT_ATTRS = new int[]{android.R.attr.background};
        }

        public InnerLayout(Context r10, AttributeSet r11) {
            super(r10, r11);
            TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(r10, r11, TINT_ATTRS);
            setBackgroundDrawable(r12.getDrawable(0));
            r12.recycle();
        }
    }

    public ActivityChooserView(@NonNull Context r10) {
        this(r10, null);
    }

    public ActivityChooserView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ActivityChooserView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mModelDataSetObserver = new AnonymousClass1(this);
        this.mOnGlobalLayoutListener = new AnonymousClass2(this);
        this.mInitialActivityCount = 4;
        int[] r13 = R.styleable.ActivityChooserView;
        TypedArray r14 = r10.obtainStyledAttributes(r11, r13, r12, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r10, r13, r11, r14, r12, 0);
        this.mInitialActivityCount = r14.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable r15 = r14.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        r14.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
        Callbacks r16 = new Callbacks(this);
        this.mCallbacks = r16;
        View r17 = findViewById(R.id.activity_chooser_view_content);
        this.mActivityChooserContent = r17;
        this.mActivityChooserContentBackground = r17.getBackground();
        FrameLayout r18 = (FrameLayout) findViewById(R.id.default_activity_button);
        this.mDefaultActivityButton = r18;
        r18.setOnClickListener(r16);
        r18.setOnLongClickListener(r16);
        int r19 = R.id.image;
        this.mDefaultActivityButtonImage = (ImageView) r18.findViewById(r19);
        final FrameLayout r20 = (FrameLayout) findViewById(R.id.expand_activities_button);
        r20.setOnClickListener(r16);
        r20.setAccessibilityDelegate(new AnonymousClass3(this));
        r20.setOnTouchListener(new AnonymousClass4(this, r20));
        this.mExpandActivityOverflowButton = r20;
        ImageView r110 = (ImageView) r20.findViewById(r19);
        this.mExpandActivityOverflowButtonImage = r110;
        r110.setImageDrawable(r15);
        ActivityChooserViewAdapter r111 = new ActivityChooserViewAdapter(this);
        this.mAdapter = r111;
        r111.registerDataSetObserver(new AnonymousClass5(this));
        Resources r112 = r10.getResources();
        this.mListPopupMaxWidth = Math.max(r112.getDisplayMetrics().widthPixels / 2, r112.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    public boolean dismissPopup() {
        if (isShowingPopup() == false) goto L9;
        getListPopupWindow().dismiss();
        ViewTreeObserver r10 = getViewTreeObserver();
        if (r10.isAlive() == false) goto L10;
        r10.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }

    ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow != null) goto L6;
        ListPopupWindow r10 = new ListPopupWindow(getContext());
        this.mListPopupWindow = r10;
        r10.setAdapter(this.mAdapter);
        this.mListPopupWindow.setAnchorView(this);
        this.mListPopupWindow.setModal(true);
        this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
        this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
    L6:
        return this.mListPopupWindow;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel r10 = this.mAdapter.getDataModel();
        if (r10 == null) goto L5;
        r10.registerObserver(this.mModelDataSetObserver);
    L5:
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel r10 = this.mAdapter.getDataModel();
        if (r10 == null) goto L5;
        r10.unregisterObserver(this.mModelDataSetObserver);
    L5:
        ViewTreeObserver r11 = getViewTreeObserver();
        if (r11.isAlive() == false) goto L9;
        r11.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    L9:
        if (isShowingPopup() == false) goto L11;
        dismissPopup();
    L11:
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        this.mActivityChooserContent.layout(0, 0, r13 - r11, r14 - r12);
        if (isShowingPopup() == true) goto L6;
        dismissPopup();
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        View r12 = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() == 0) goto L5;
        r11 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r11), 1073741824);
    L5:
        measureChild(r12, r10, r11);
        setMeasuredDimension(r12.getMeasuredWidth(), r12.getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel.ActivityChooserModelClient
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActivityChooserModel(ActivityChooserModel r10) {
        this.mAdapter.setDataModel(r10);
        if (isShowingPopup() == false) goto L6;
        dismissPopup();
        showPopup();
        return;
    }

    public void setDefaultActionButtonContentDescription(int r10) {
        this.mDefaultActionButtonContentDescription = r10;
    }

    public void setExpandActivityOverflowButtonContentDescription(int r10) {
        String r11 = getContext().getString(r10);
        this.mExpandActivityOverflowButtonImage.setContentDescription(r11);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable r10) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(r10);
    }

    public void setInitialActivityCount(int r10) {
        this.mInitialActivityCount = r10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r10) {
        this.mOnDismissListener = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider r10) {
        this.mProvider = r10;
    }

    public boolean showPopup() {
        if (isShowingPopup() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mIsAttachedToWindow == false) goto L9;
        this.mIsSelectingDefaultActivity = false;
        showPopupUnchecked(this.mInitialActivityCount);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void showPopupUnchecked(int r10) {
        if (this.mAdapter.getDataModel() == null) goto L28;
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        if (this.mDefaultActivityButton.getVisibility() != 0) goto L7;
        ?? r11 = 1;
    L8:
        int r12 = this.mAdapter.getActivityCount();
        if (r10 != Integer.MAX_VALUE) goto L11;
    L13:
        this.mAdapter.setShowFooterView(false);
        ActivityChooserViewAdapter r13 = this.mAdapter;
    L14:
        r13.setMaxActivityCount(r10);
        ListPopupWindow r14 = getListPopupWindow();
        if (r14.isShowing() == false) goto L17;
        return;
    L17:
        if (this.mIsSelectingDefaultActivity == true) goto L21;
        if (r11 == 0) goto L21;
        this.mAdapter.setShowDefaultActivity(false, false);
    L22:
        r14.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
        r14.show();
        ActionProvider r15 = this.mProvider;
        if (r15 == null) goto L25;
        r15.subUiVisibilityChanged(true);
    L25:
        r14.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        r14.getListView().setSelector(new ColorDrawable(0));
        return;
    L21:
        this.mAdapter.setShowDefaultActivity(true, r11);
        goto L22
    L11:
        if (r12 <= (r10 + r11)) goto L13;
        this.mAdapter.setShowFooterView(true);
        r13 = this.mAdapter;
        r10 = r10 - 1;
        goto L14
    L7:
        r11 = 0;
        goto L8
    L28:
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    void updateAppearance() {
        if (this.mAdapter.getCount() <= 0) goto L5;
        this.mExpandActivityOverflowButton.setEnabled(true);
    L6:
        int r10 = this.mAdapter.getActivityCount();
        int r11 = this.mAdapter.getHistorySize();
        if (r10 == 1) goto L12;
        if (r10 <= 1) goto L11;
        if (r11 > 0) goto L12;
    L11:
        this.mDefaultActivityButton.setVisibility(8);
    L16:
        if (this.mDefaultActivityButton.getVisibility() != 0) goto L18;
        this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
        return;
    L18:
        this.mActivityChooserContent.setBackgroundDrawable(null);
        return;
    L12:
        this.mDefaultActivityButton.setVisibility(0);
        ResolveInfo r12 = this.mAdapter.getDefaultActivity();
        PackageManager r13 = getContext().getPackageManager();
        this.mDefaultActivityButtonImage.setImageDrawable(r12.loadIcon(r13));
        if (this.mDefaultActionButtonContentDescription == 0) goto L16;
        CharSequence r14 = r12.loadLabel(r13);
        this.mDefaultActivityButton.setContentDescription(getContext().getString(this.mDefaultActionButtonContentDescription, new Object[]{r14}));
        goto L16
    L5:
        this.mExpandActivityOverflowButton.setEnabled(false);
        goto L6
    }
}
