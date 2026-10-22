package com.ss.android.lark.chameleon.widgetv2.emptyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EmptyView extends LinearLayout implements EmptyViewController, View.OnClickListener {
    private Config mConfig;
    private SpaceEmptyState mEmptyState;
    private LinearLayout mLoadingTip;
    private View mLoadingView;
    private OnRetryListener mOnRetryListener;

    public interface OnRetryListener {
        void onFailedRetry();
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void hide() {
        setVisibility(4);
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void show() {
        setVisibility(0);
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void showLoading() {
        setIsLoadingView(true);
        this.mConfig.getIcons().get(0).intValue();
        CharSequence r0 = this.mConfig.getTips().get(0);
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void showNoContent() {
        setIsLoadingView(false);
        int r1 = this.mConfig.getIcons().get(1).intValue();
        CharSequence r2 = this.mConfig.getTips().get(1);
        String r3 = getResources().getString(2131887752);
        if (r2.toString().equals(r3) == true) goto L5;
    L7:
        this.mEmptyState.setImageRes(Integer.valueOf(r1));
        this.mEmptyState.setDesc(r2);
        this.mEmptyState.setOnClickListener(null);
        this.mEmptyState.setClickable(false);
        return;
    L5:
        if (TextUtils.equals(this.mConfig.getLanguage(), Locale.CHINESE.getLanguage()) == false) goto L7;
        StringBuilder r4 = new StringBuilder(r2);
        r4.insert(r2.length() / 2, "\n");
        r2 = r4.toString();
        goto L7
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void showNoFound() {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(5));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(5));
        this.mEmptyState.setOnClickListener(null);
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void showNoNetworkError() {
        setIsLoadingView(false);
        int r0 = this.mConfig.getIcons().get(4).intValue();
        CharSequence r1 = this.mConfig.getTips().get(4);
        this.mEmptyState.setImageRes(Integer.valueOf(r0));
        this.mEmptyState.setDesc(r1);
        this.mEmptyState.setOnClickListener(null);
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void showNoPermission() {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(99));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(99));
        this.mEmptyState.setOnClickListener(this);
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void showNoSupport() {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(10));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(10));
        this.mEmptyState.setOnClickListener(this);
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void showTimeout() {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(7));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(7));
        this.mEmptyState.setOnClickListener(this);
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void showWikiDeleted() {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(9));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(9));
        this.mEmptyState.setOnClickListener(this);
    }

    public void hideLoading() {
        this.mLoadingTip.setVisibility(8);
        this.mEmptyState.setVisibility(8);
    }

    public void hideLoadingAndShowErrorPage() {
        this.mLoadingTip.setVisibility(8);
        this.mEmptyState.setVisibility(0);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public EmptyView(Context r2) {
        super(r2);
        init(r2, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void setIsLoadingView(boolean r5) {
        LinearLayout r0 = this.mLoadingTip;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        UDEmptyState r2 = this.mEmptyState;
        if (r5 == false) goto L9;
        int r4 = 8;
    L10:
        r2.setVisibility(r4);
        if (this.mEmptyState.getImageView() == null) goto L16;
        View r6 = this.mEmptyState.getImageView();
        if (r5 == false) goto L15;
        r1 = 8;
    L15:
        r6.setVisibility(r1);
    L16:
        this.mEmptyState.showDescription(!r5);
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = 8;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        OnRetryListener r2 = this.mOnRetryListener;
        if (r2 == null) goto L6;
        r2.onFailedRetry();
        return;
    }

    public void setConfig(Config r2) {
        setConfig(r2, null);
    }

    public void setLoadViewMarginTop(int r2) {
        if (this.mLoadingView != null) goto L5;
        this.mLoadingView = findViewById(2131377166);
    L5:
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mLoadingView.getLayoutParams();
        r0.topMargin = r2;
        this.mLoadingView.setLayoutParams(r0);
    }

    public void setOnRetryListener(OnRetryListener r1) {
        this.mOnRetryListener = r1;
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void showLoadError(Throwable r3) {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(3));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(3));
        setOnClickListener(this);
    }

    public EmptyView(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1, r2);
    }

    private void init(Context r5, AttributeSet r6) {
        int r0 = 2131559839;
        if (r6 == null) goto L5;
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130969617});
        r0 = r7.getResourceId(0, 2131559839);
        r7.recycle();
    L5:
        LayoutInflater.from(r5).inflate(r0, this);
        this.mLoadingTip = (LinearLayout) findViewById(2131378741);
        this.mEmptyState = (SpaceEmptyState) findViewById(2131372043);
        this.mConfig = (Config) new DefaultConfig(r5).getDefault().invoke();
    }

    public void setConfig(Config r3, ViewGroup.LayoutParams r4) {
        this.mConfig = r3;
        int r5 = r3.getLoadingView();
        if (r5 <= 0) goto L9;
        this.mLoadingTip.removeAllViews();
        View r6 = LayoutInflater.from(getContext()).inflate(r5, null);
        if (r4 == null) goto L7;
        this.mLoadingTip.addView(r6, r4);
        return;
    L7:
        this.mLoadingTip.addView(r6);
        return;
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyViewController
    public void showCustomError(int r2, CharSequence r3) {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(Integer.valueOf(r2));
        this.mEmptyState.setDesc(r3);
        setOnClickListener(this);
    }

    public EmptyView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1, r2);
    }
}
