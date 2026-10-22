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
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
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

    public class ActivityChooserViewAdapter extends BaseAdapter {
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

        public ActivityChooserViewAdapter(ActivityChooserView r5) {
            this.this$0 = r5;
            this.mMaxActivityCount = 4;
        }

        public int getActivityCount() {
            return this.mDataModel.getActivityCount();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r5 = this.mDataModel.getActivityCount();
            if (this.mShowDefaultActivity == false) goto L5;
        L7:
            int r10 = Math.min(r5, this.mMaxActivityCount);
            if (this.mShowFooterView == true) goto L10;
            return r10;
        L10:
            return r10 + 1;
        L5:
            if (this.mDataModel.getDefaultActivity() == null) goto L7;
            r5 = r5 - 1;
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
        public Object getItem(int r5) {
            int r10 = getItemViewType(r5);
            if (r10 == 0) goto L11;
            if (r10 != 1) goto L9;
            return null;
        L9:
            throw new IllegalArgumentException();
        L11:
            if (this.mShowDefaultActivity == true) goto L16;
            if (this.mDataModel.getDefaultActivity() == null) goto L16;
            r5 = r5 + 1;
        L16:
            return this.mDataModel.getActivity(r5);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r5) {
            return r5;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r5) {
            if (this.mShowFooterView == true) goto L5;
            return 0;
        L5:
            if (r5 != (getCount() - 1)) goto L9;
            return 1;
        L9:
            return 0;
        }

        public boolean getShowDefaultActivity() {
            return this.mShowDefaultActivity;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            int r5 = getItemViewType(r10);
            if (r5 == 0) goto L12;
            if (r5 != 1) goto L11;
            if (r11 != null) goto L7;
        L8:
            View r13 = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, r12, false);
            r13.setId(1);
            ((TextView) r13.findViewById(R.id.title)).setText(this.this$0.getContext().getString(R.string.abc_activity_chooser_view_see_all));
            return r13;
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
            PackageManager r14 = this.this$0.getContext().getPackageManager();
            ImageView r15 = (ImageView) r11.findViewById(R.id.icon);
            ResolveInfo r16 = (ResolveInfo) getItem(r10);
            r15.setImageDrawable(r16.loadIcon(r14));
            ((TextView) r11.findViewById(R.id.title)).setText(r16.loadLabel(r14));
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
            int r5 = this.mMaxActivityCount;
            this.mMaxActivityCount = Integer.MAX_VALUE;
            int r10 = 0;
            int r11 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int r12 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int r13 = getCount();
            int r14 = 0;
            View r15 = null;
        L3:
            if (r10 >= r13) goto L5;
            r15 = getView(r10, r15, null);
            r15.measure(r11, r12);
            r14 = Math.max(r14, r15.getMeasuredWidth());
            r10 = r10 + 1;
            goto L3
        L5:
            this.mMaxActivityCount = r5;
            return r14;
        }

        public void setDataModel(ActivityChooserModel r5) {
            ActivityChooserModel r10 = this.this$0.mAdapter.getDataModel();
            if (r10 != null) goto L5;
        L7:
            this.mDataModel = r5;
            if (r5 != null) goto L10;
        L12:
            notifyDataSetChanged();
            return;
        L10:
            if (this.this$0.isShown() == false) goto L12;
            r5.registerObserver(this.this$0.mModelDataSetObserver);
            goto L12
        L5:
            if (this.this$0.isShown() == false) goto L7;
            r10.unregisterObserver(this.this$0.mModelDataSetObserver);
            goto L7
        }

        public void setMaxActivityCount(int r5) {
            if (this.mMaxActivityCount == r5) goto L6;
            this.mMaxActivityCount = r5;
            notifyDataSetChanged();
            return;
        }

        public void setShowDefaultActivity(boolean r5, boolean r10) {
            if (this.mShowDefaultActivity == r5) goto L5;
        L6:
            this.mShowDefaultActivity = r5;
            this.mHighlightDefaultActivity = r10;
            notifyDataSetChanged();
            return;
        L5:
            if (this.mHighlightDefaultActivity != r10) goto L6;
        }

        public void setShowFooterView(boolean r5) {
            if (this.mShowFooterView == r5) goto L6;
            this.mShowFooterView = r5;
            notifyDataSetChanged();
            return;
        }
    }

    public class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        final /* synthetic */ ActivityChooserView this$0;

        public Callbacks(ActivityChooserView r5) {
            this.this$0 = r5;
        }

        private void notifyOnDismissListener() {
            PopupWindow.OnDismissListener r5 = this.this$0.mOnDismissListener;
            if (r5 == null) goto L6;
            r5.onDismiss();
            return;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r5) {
            ActivityChooserView r10 = this.this$0;
            if (r5 != r10.mDefaultActivityButton) goto L8;
            r10.dismissPopup();
            ResolveInfo r11 = this.this$0.mAdapter.getDefaultActivity();
            int r12 = this.this$0.mAdapter.getDataModel().getActivityIndex(r11);
            Intent r13 = this.this$0.mAdapter.getDataModel().chooseActivity(r12);
            if (r13 == null) goto L13;
            r13.addFlags(524288);
            this.this$0.getContext().startActivity(r13);
            return;
        L13:
            return;
        L8:
            if (r5 != r10.mExpandActivityOverflowButton) goto L12;
            r10.mIsSelectingDefaultActivity = false;
            r10.showPopupUnchecked(r10.mInitialActivityCount);
            return;
        L12:
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            notifyOnDismissListener();
            ActionProvider r5 = this.this$0.mProvider;
            if (r5 == null) goto L6;
            r5.subUiVisibilityChanged(false);
            return;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r5, View r10, int r11, long r12) {
            int r13 = ((ActivityChooserViewAdapter) r5.getAdapter()).getItemViewType(r11);
            if (r13 != 0) goto L5;
            this.this$0.dismissPopup();
            ActivityChooserView r14 = this.this$0;
            if (r14.mIsSelectingDefaultActivity == false) goto L14;
            if (r11 <= 0) goto L22;
            r14.mAdapter.getDataModel().setDefaultActivity(r11);
            return;
        L22:
            return;
        L14:
            if (r14.mAdapter.getShowDefaultActivity() == true) goto L17;
            r11 = r11 + 1;
        L17:
            Intent r15 = this.this$0.mAdapter.getDataModel().chooseActivity(r11);
            if (r15 == null) goto L24;
            r15.addFlags(524288);
            this.this$0.getContext().startActivity(r15);
            return;
        L24:
            return;
        L5:
            if (r13 != 1) goto L8;
            this.this$0.showPopupUnchecked(Integer.MAX_VALUE);
            return;
        L8:
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r5) {
            ActivityChooserView r10 = this.this$0;
            if (r5 != r10.mDefaultActivityButton) goto L9;
            if (r10.mAdapter.getCount() <= 0) goto L7;
            ActivityChooserView r11 = this.this$0;
            r11.mIsSelectingDefaultActivity = true;
            r11.showPopupUnchecked(r11.mInitialActivityCount);
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

        public InnerLayout(Context r5, AttributeSet r10) {
            super(r5, r10);
            TintTypedArray r11 = TintTypedArray.obtainStyledAttributes(r5, r10, TINT_ATTRS);
            setBackgroundDrawable(r11.getDrawable(0));
            r11.recycle();
        }
    }

    public ActivityChooserView(@NonNull Context r5) {
        this(r5, null);
    }

    public boolean dismissPopup() {
        if (isShowingPopup() == false) goto L9;
        getListPopupWindow().dismiss();
        ViewTreeObserver r5 = getViewTreeObserver();
        if (r5.isAlive() == false) goto L10;
        r5.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
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

    public ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow != null) goto L6;
        ListPopupWindow r5 = new ListPopupWindow(getContext());
        this.mListPopupWindow = r5;
        r5.setAdapter(this.mAdapter);
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
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel r5 = this.mAdapter.getDataModel();
        if (r5 == null) goto L5;
        r5.registerObserver(this.mModelDataSetObserver);
    L5:
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel r5 = this.mAdapter.getDataModel();
        if (r5 == null) goto L5;
        r5.unregisterObserver(this.mModelDataSetObserver);
    L5:
        ViewTreeObserver r10 = getViewTreeObserver();
        if (r10.isAlive() == false) goto L9;
        r10.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    L9:
        if (isShowingPopup() == false) goto L11;
        dismissPopup();
    L11:
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        this.mActivityChooserContent.layout(0, 0, r12 - r10, r13 - r11);
        if (isShowingPopup() == true) goto L6;
        dismissPopup();
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        View r11 = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() == 0) goto L5;
        r10 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r10), BasicMeasure.EXACTLY);
    L5:
        measureChild(r11, r5, r10);
        setMeasuredDimension(r11.getMeasuredWidth(), r11.getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel.ActivityChooserModelClient
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActivityChooserModel(ActivityChooserModel r5) {
        this.mAdapter.setDataModel(r5);
        if (isShowingPopup() == false) goto L6;
        dismissPopup();
        showPopup();
        return;
    }

    public void setDefaultActionButtonContentDescription(int r5) {
        this.mDefaultActionButtonContentDescription = r5;
    }

    public void setExpandActivityOverflowButtonContentDescription(int r5) {
        String r10 = getContext().getString(r5);
        this.mExpandActivityOverflowButtonImage.setContentDescription(r10);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable r5) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(r5);
    }

    public void setInitialActivityCount(int r5) {
        this.mInitialActivityCount = r5;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r5) {
        this.mOnDismissListener = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider r5) {
        this.mProvider = r5;
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
    public void showPopupUnchecked(int r10) {
        if (this.mAdapter.getDataModel() == null) goto L28;
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        if (this.mDefaultActivityButton.getVisibility() != 0) goto L7;
        ?? r5 = 1;
    L8:
        int r11 = this.mAdapter.getActivityCount();
        if (r10 != Integer.MAX_VALUE) goto L11;
    L13:
        this.mAdapter.setShowFooterView(false);
        this.mAdapter.setMaxActivityCount(r10);
    L14:
        ListPopupWindow r12 = getListPopupWindow();
        if (r12.isShowing() == false) goto L17;
        return;
    L17:
        if (this.mIsSelectingDefaultActivity == true) goto L21;
        if (r5 == 0) goto L21;
        this.mAdapter.setShowDefaultActivity(false, false);
    L22:
        r12.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
        r12.show();
        ActionProvider r13 = this.mProvider;
        if (r13 == null) goto L25;
        r13.subUiVisibilityChanged(true);
    L25:
        r12.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        r12.getListView().setSelector(new ColorDrawable(0));
        return;
    L21:
        this.mAdapter.setShowDefaultActivity(true, r5);
        goto L22
    L11:
        if (r11 <= (r10 + r5)) goto L13;
        this.mAdapter.setShowFooterView(true);
        this.mAdapter.setMaxActivityCount(r10 - 1);
        goto L14
    L7:
        r5 = 0;
        goto L8
    L28:
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public void updateAppearance() {
        if (this.mAdapter.getCount() <= 0) goto L5;
        this.mExpandActivityOverflowButton.setEnabled(true);
    L6:
        int r5 = this.mAdapter.getActivityCount();
        int r10 = this.mAdapter.getHistorySize();
        if (r5 == 1) goto L12;
        if (r5 <= 1) goto L11;
        if (r10 > 0) goto L12;
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
        ResolveInfo r11 = this.mAdapter.getDefaultActivity();
        PackageManager r12 = getContext().getPackageManager();
        this.mDefaultActivityButtonImage.setImageDrawable(r11.loadIcon(r12));
        if (this.mDefaultActionButtonContentDescription == 0) goto L16;
        CharSequence r13 = r11.loadLabel(r12);
        String r14 = getContext().getString(this.mDefaultActionButtonContentDescription, new Object[]{r13});
        this.mDefaultActivityButton.setContentDescription(r14);
        goto L16
    L5:
        this.mExpandActivityOverflowButton.setEnabled(false);
        goto L6
    }

    public ActivityChooserView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public ActivityChooserView(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.mModelDataSetObserver = new AnonymousClass1(this);
        this.mOnGlobalLayoutListener = new AnonymousClass2(this);
        this.mInitialActivityCount = 4;
        TypedArray r5 = r11.obtainStyledAttributes(r12, R.styleable.ActivityChooserView, r13, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r11, R.styleable.ActivityChooserView, r12, r5, r13, 0);
        this.mInitialActivityCount = r5.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable r14 = r5.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        r5.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
        Callbacks r15 = new Callbacks(this);
        this.mCallbacks = r15;
        View r10 = findViewById(R.id.activity_chooser_view_content);
        this.mActivityChooserContent = r10;
        this.mActivityChooserContentBackground = r10.getBackground();
        FrameLayout r16 = (FrameLayout) findViewById(R.id.default_activity_button);
        this.mDefaultActivityButton = r16;
        r16.setOnClickListener(r15);
        r16.setOnLongClickListener(r15);
        this.mDefaultActivityButtonImage = (ImageView) r16.findViewById(R.id.image);
        final FrameLayout r17 = (FrameLayout) findViewById(R.id.expand_activities_button);
        r17.setOnClickListener(r15);
        r17.setAccessibilityDelegate(new AnonymousClass3(this));
        r17.setOnTouchListener(new AnonymousClass4(this, r17));
        this.mExpandActivityOverflowButton = r17;
        ImageView r18 = (ImageView) r17.findViewById(R.id.image);
        this.mExpandActivityOverflowButtonImage = r18;
        r18.setImageDrawable(r14);
        ActivityChooserViewAdapter r19 = new ActivityChooserViewAdapter(this);
        this.mAdapter = r19;
        r19.registerDataSetObserver(new AnonymousClass5(this));
        Resources r110 = r11.getResources();
        this.mListPopupMaxWidth = Math.max(r110.getDisplayMetrics().widthPixels / 2, r110.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }
}
