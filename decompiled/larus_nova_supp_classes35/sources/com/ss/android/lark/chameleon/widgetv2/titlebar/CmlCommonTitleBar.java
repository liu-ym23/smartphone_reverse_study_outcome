package com.ss.android.lark.chameleon.widgetv2.titlebar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import swb.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CmlCommonTitleBar extends LinearLayout implements IActionTitlebar, View.OnClickListener {
    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    private static final String TAG = "CmlCommonTitleBar";
    private boolean isCenterAlways;
    private boolean isLeftAlignMode;
    private final List<IActionTitlebar.Action> mActionList;
    private final int mBackIconRes;
    private final int mBackground;
    private LinearLayout mCenterLayout;
    private TextView mCenterText;
    private final Context mContext;
    private View mDividerView;
    private boolean mDividerVisible;
    private int mHeight;
    private boolean mImmersive;
    private int mLeftDrawablePadding;
    private LinearLayout mLeftLayout;
    protected TextView mLeftText;
    private int mLeftTextPadding;
    private int mMinSidePadding;
    private int mOutLeftPadding;
    private int mOutPadding;
    protected LinearLayout mRightLayout;
    private int mScreenWidth;
    protected TextView mSecLeftText;
    private int mStatusBarHeight;
    private TextView mSubTitleText;
    private String mTitle;
    private final int mTitleColor;
    private OnDoubleTapListener mTitleDoubleTapListener;

    public static class ActionList extends LinkedList<IActionTitlebar.Action> {
        public ActionList() {
        }
    }

    public interface OnDoubleTapListener {
        void onDoubleTapClick(View r1);
    }

    public TextView getRightText() {
        return getRightText(0);
    }

    private void adjustSecLeftTextPadding() {
        TextView r0 = this.mSecLeftText;
        int r1 = this.mLeftTextPadding;
        r0.setPadding(r1, 0, r1, 0);
    }

    private void detectTitleTap() {
        if (this.mCenterLayout != null) goto L5;
        return;
    L5:
        Handler r0 = new Handler(Looper.getMainLooper());
        final GestureDetector r1 = new GestureDetector(getContext(), new AnonymousClass3(this), r0);
        View.OnTouchListener r2 = new AnonymousClass4(this, r1);
        this.mCenterLayout.setOnTouchListener(r2);
    }

    public int getActionCount() {
        return this.mRightLayout.getChildCount();
    }

    public List<IActionTitlebar.Action> getAllActions() {
        return new ArrayList(this.mActionList);
    }

    public Drawable getLeftDrawable() {
        return this.mLeftText.getCompoundDrawables()[0];
    }

    public void hideRightAndRemoveActions() {
        this.mRightLayout.setVisibility(8);
        this.mActionList.clear();
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar
    public void removeAllActions() {
        this.mRightLayout.removeAllViews();
        this.mActionList.clear();
    }

    public static int getStatusBarHeight() {
        Resources r0 = Resources.getSystem();
        p.a r1 = p.a;
        Intrinsics.checkNotNullParameter(r0, SRStrategy.MEDIAINFO_KEY_RESOLUTION);
        int r2 = r0.getIdentifier(STATUS_BAR_HEIGHT_RES_NAME, "dimen", "android");
        if (r2 > 0) goto L7;
        return 0;
    L7:
        return r0.getDimensionPixelSize(r2);
    }

    public LinearLayout getCenterLayout() {
        return this.mCenterLayout;
    }

    public TextView getCenterText() {
        return this.mCenterText;
    }

    public int getLeftDrawablePadding() {
        return this.mLeftDrawablePadding;
    }

    public LinearLayout getLeftLayout() {
        return this.mLeftLayout;
    }

    public TextView getLeftText() {
        return this.mLeftText;
    }

    public LinearLayout getRightLayout() {
        return this.mRightLayout;
    }

    public CmlCommonTitleBar(Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ Context access$000(CmlCommonTitleBar r0) {
        return r0.mContext;
    }

    public static /* synthetic */ int access$100(CmlCommonTitleBar r0) {
        return r0.mStatusBarHeight;
    }

    public static /* synthetic */ OnDoubleTapListener access$200(CmlCommonTitleBar r0) {
        return r0.mTitleDoubleTapListener;
    }

    public static /* synthetic */ LinearLayout access$300(CmlCommonTitleBar r0) {
        return r0.mCenterLayout;
    }

    private int getVisibleWidth(View r3) {
        if (r3 != null) goto L4;
        return 0;
    L4:
        if (r3.getVisibility() != 8) goto L6;
        return 0;
    L6:
        return r3.getMeasuredWidth();
    }

    private void init(Context r5) {
        this.mOutPadding = ActionTitleBarHelper.getActionOutPaddingInPixel();
        this.mOutLeftPadding = ActionTitleBarHelper.getActionOutLeftPaddingInPixel();
        this.mLeftTextPadding = 0;
        this.mLeftDrawablePadding = p.a(getContext(), 6.0f);
        this.mMinSidePadding = p.a(getContext(), 8.0f);
        this.mHeight = r5.getResources().getDimensionPixelSize(2131168457);
        setPadding(p.a(getContext(), 8.0f), 0, p.a(getContext(), 8.0f), 0);
        initView(r5);
    }

    private void initView(Context r8) {
        setOrientation(0);
        this.mLeftText = new TextView(r8);
        this.mSecLeftText = new TextView(r8);
        this.mCenterLayout = new LinearLayout(r8);
        this.mRightLayout = new LinearLayout(r8);
        this.mLeftLayout = new LinearLayout(r8);
        this.mDividerView = new View(r8);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -1);
        setDefaultTextStyle(this.mLeftText);
        TextView r2 = this.mLeftText;
        int r4 = CommonTitleBarConstants.DEFAULT_LEFT_TEXT_SIZE;
        r2.setTextSize(r4);
        this.mLeftText.setTextColor(getResources().getColorStateList(2131101057));
        this.mLeftText.setPadding(this.mOutPadding, 0, 0, 0);
        this.mLeftText.setOnClickListener(new AnonymousClass1(this));
        setDefaultTextStyle(this.mSecLeftText);
        this.mSecLeftText.setTextSize(r4);
        this.mSecLeftText.setTextColor(getResources().getColorStateList(2131101057));
        this.mCenterText = new TextView(r8);
        this.mSubTitleText = new TextView(r8);
        this.mCenterLayout.addView(this.mCenterText);
        this.mCenterLayout.addView(this.mSubTitleText);
        this.mCenterLayout.setGravity(17);
        setDefaultTextStyle(this.mCenterText);
        setDefaultTextStyle(this.mSubTitleText);
        this.mCenterText.setTextSize(CommonTitleBarConstants.DEFAULT_MAIN_TEXT_SIZE);
        this.mCenterText.setTextColor(this.mTitleColor);
        this.mCenterText.setGravity(17);
        this.mSubTitleText.setTextSize(CommonTitleBarConstants.DEFAULT_SUB_TEXT_SIZE);
        this.mSubTitleText.setTextColor(r8.getResources().getColor(2131106622));
        this.mSubTitleText.setGravity(17);
        this.mRightLayout.setPadding(0, 0, 0, 0);
        this.mLeftLayout.setPadding(this.mOutPadding, 0, 0, 0);
        this.mLeftLayout.setGravity(16);
        this.mDividerView.setBackgroundColor(r8.getResources().getColor(2131103353));
        addView(this.mLeftText, r1);
        addView(this.mSecLeftText, r1);
        addView(this.mLeftLayout, r1);
        addView(this.mCenterLayout, r1);
        addView(this.mRightLayout, r1);
        addView(this.mDividerView, new LinearLayout.LayoutParams(-1, 1));
        setBackgroundColor(this.mBackground);
        setTitle(this.mTitle);
        setLeftImageResource(this.mBackIconRes);
        setDividerVisible(this.mDividerVisible);
        detectTitleTap();
    }

    private void setDefaultTextStyle(TextView r3) {
        Context r0 = this.mContext;
        if (r0 == null) goto L6;
        r3.setTextColor(r0.getResources().getColor(2131106622));
        r3.setSingleLine();
        r3.setGravity(16);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        return;
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar
    public View addAction(IActionTitlebar.Action r2) {
        return addAction(r2, this.mRightLayout.getChildCount());
    }

    public void addActions(ActionList r4) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addAction(r4.get(r1));
        r1 = r1 + 1;
        goto L3
    }

    public TextView getRightText(int r2) {
        View r3 = getRightView(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if ((r3 instanceof TextView) == true) goto L7;
        return null;
    L7:
        return (TextView) r3;
    }

    public View getRightView(int r3) {
        if (r3 >= 0) goto L5;
        return null;
    L5:
        if (r3 >= this.mActionList.size()) goto L13;
        IActionTitlebar.Action r4 = (IActionTitlebar.Action) ListProtector.get(this.mActionList, r3);
        if (r4 != null) goto L10;
        return null;
    L10:
        return getViewByAction(r4);
    L13:
        return null;
    }

    public View getViewByAction(IActionTitlebar.Action r1) {
        return findViewWithTag(r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        Object r0 = r3.getTag();
        if ((r0 instanceof IActionTitlebar.Action) == false) goto L6;
        ((IActionTitlebar.Action) r0).performAction(r3);
        return;
    }

    public void registerTitleDoubleTapListener(OnDoubleTapListener r1) {
        this.mTitleDoubleTapListener = r1;
    }

    public void removeAction(IActionTitlebar.Action r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = this.mRightLayout.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        View r2 = this.mRightLayout.getChildAt(r1);
        if (r2 == null) goto L13;
        Object r3 = r2.getTag();
        if ((r3 instanceof IActionTitlebar.Action) == false) goto L13;
        if (r3.equals(r6) == false) goto L13;
        this.mRightLayout.removeView(r2);
        this.mActionList.remove(r3);
    L13:
        r1 = r1 + 1;
        goto L5
    }

    public void removeActionAt(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        this.mRightLayout.removeViewAt(r2);
        ListProtector.remove(this.mActionList, r2);
    }

    public void setCenterClickListener(View.OnClickListener r2) {
        this.mCenterLayout.setOnClickListener(r2);
    }

    public void setCenterViewVisible(int r2) {
        this.mCenterLayout.setVisibility(r2);
    }

    public void setCustomTitleView(View r4) {
        r4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mCenterLayout.removeAllViews();
        this.mCenterLayout.addView(r4);
    }

    public void setDivider(int r2) {
        this.mDividerView.setBackgroundResource(r2);
    }

    public void setDividerColor(int r2) {
        this.mDividerView.setBackgroundColor(r2);
    }

    public void setDividerHeight(int r2) {
        this.mDividerView.getLayoutParams().height = r2;
    }

    public void setDividerVisible(boolean r2) {
        View r0 = this.mDividerView;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setHeight(int r2) {
        this.mHeight = r2;
        setMeasuredDimension(getMeasuredWidth(), this.mHeight);
    }

    public void setImmersive(boolean r2) {
        if (this.mImmersive != r2) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass2(this));
        ViewCompat.requestApplyInsets(this);
    L8:
        this.mImmersive = r2;
        return;
    L7:
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        this.mStatusBarHeight = 0;
        goto L8
    }

    public void setIsCenterAlways(boolean r1) {
        this.isCenterAlways = r1;
        invalidate();
    }

    public void setLeftAlignMode(boolean r1) {
        this.isLeftAlignMode = r1;
    }

    public void setLeftClickListener(View.OnClickListener r2) {
        this.mLeftText.setOnClickListener(r2);
    }

    public void setLeftImageDrawable(Drawable r3) {
        this.mLeftText.setCompoundDrawablesWithIntrinsicBounds(r3, null, null, null);
    }

    public void setLeftImageResource(int r2) {
        setLeftImageResource(r2, 2131102418);
    }

    public void setLeftText(CharSequence r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.mLeftText.setCompoundDrawablePadding(this.mLeftDrawablePadding);
        this.mLeftText.setText(r3);
    }

    public void setLeftTextBackground(int r2) {
        this.mLeftText.setBackgroundResource(r2);
    }

    public void setLeftTextColor(int r2) {
        this.mLeftText.setTextColor(r2);
    }

    public void setLeftTextOnly(int r1) {
        setLeftText(r1);
        setLeftImageDrawable(null);
    }

    public void setLeftTextSize(float r2) {
        this.mLeftText.setTextSize(r2);
    }

    public void setLeftVisible(boolean r2) {
        TextView r0 = this.mLeftText;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setMainTitleBackground(int r2) {
        this.mCenterText.setBackgroundResource(r2);
    }

    public void setMainTitleColor(int r2) {
        this.mCenterText.setTextColor(r2);
    }

    public void setMainTitleSize(float r2) {
        this.mCenterText.setTextSize(r2);
    }

    public void setMainTitleTextStyle(int r3) {
        TextView r0 = this.mCenterText;
        r0.setTypeface(r0.getTypeface(), r3);
    }

    public void setMainTitleVisible(boolean r2) {
        TextView r0 = this.mCenterText;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setRightImage(Drawable r2) {
        setRightImage(0, r2);
    }

    public void setRightText(String r2) {
        setRightText(0, r2);
    }

    public void setRightVisible(boolean r2) {
        LinearLayout r0 = this.mRightLayout;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setSecLeftClickListener(View.OnClickListener r2) {
        this.mSecLeftText.setOnClickListener(r2);
    }

    public void setSecLeftImageDrawable(Drawable r3) {
        this.mSecLeftText.setCompoundDrawablesWithIntrinsicBounds(r3, null, null, null);
        adjustSecLeftTextPadding();
    }

    public void setSecLeftImageResource(int r3) {
        Context r0 = getContext();
        p.a r1 = p.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Drawable r4 = AppCompatResources.getDrawable(r0, r3);
        this.mSecLeftText.setCompoundDrawablesWithIntrinsicBounds(r4, null, null, null);
        adjustSecLeftTextPadding();
    }

    public void setSecLeftText(CharSequence r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.mSecLeftText.setCompoundDrawablePadding(this.mLeftDrawablePadding);
        this.mSecLeftText.setText(r3);
        adjustSecLeftTextPadding();
    }

    public void setSecLeftTextColor(int r2) {
        this.mSecLeftText.setTextColor(r2);
    }

    public void setSecLeftTextSize(float r2) {
        this.mSecLeftText.setTextSize(r2);
    }

    public void setSecLeftTextTypeface(int r2) {
        this.mSecLeftText.setTypeface(Typeface.defaultFromStyle(r2));
    }

    public void setSecLeftVisible(boolean r2) {
        TextView r0 = this.mSecLeftText;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setSubTitleBackground(int r2) {
        this.mSubTitleText.setBackgroundResource(r2);
    }

    public void setSubTitleColor(int r2) {
        this.mSubTitleText.setTextColor(r2);
    }

    public void setSubTitleSize(float r2) {
        this.mSubTitleText.setTextSize(r2);
    }

    public void setSubTitleVisible(boolean r2) {
        TextView r0 = this.mSubTitleText;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setTitle(int r4) {
        Context r0 = getContext();
        p.a r1 = p.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        setTitle(r1.getResources(r0).getString(r4));
    }

    public void setTitleMaxLines(int r2) {
        if (r2 != 1) goto L5;
        this.mCenterText.setSingleLine();
    L5:
        this.mCenterText.setMaxLines(r2);
    }

    public void updateTitleBarWidth(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        this.mScreenWidth = r1;
        requestLayout();
    }

    public void setLeftText(int r3) {
        this.mLeftText.setCompoundDrawablePadding(this.mLeftDrawablePadding);
        this.mLeftText.setText(r3);
    }

    public void setLeftTextColor(ColorStateList r2) {
        this.mLeftText.setTextColor(r2);
    }

    public void setLeftTextOnly(CharSequence r1) {
        setLeftText(r1);
        setLeftImageDrawable(null);
    }

    public void setSecLeftTextColor(ColorStateList r2) {
        this.mSecLeftText.setTextColor(r2);
    }

    @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar
    public void setTitle(CharSequence r2) {
        setTitle(r2, false);
    }

    public CmlCommonTitleBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static /* synthetic */ int access$102(CmlCommonTitleBar r0, int r1) {
        r0.mStatusBarHeight = r1;
        return r1;
    }

    public View addAction(IActionTitlebar.Action r4, ViewGroup.LayoutParams r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = this.mRightLayout.getChildCount();
        View r1 = ActionTitleBarHelper.inflateAction(getContext(), r4);
        r1.setTag(r4);
        r1.setOnClickListener(this);
        ViewGroup.LayoutParams r6 = r5;
        if (r5 != null) goto L8;
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -1);
        r7.gravity = 16;
        r6 = r7;
    L8:
        this.mRightLayout.addView(r1, r0, r6);
        return r1;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        int r0 = View.MeasureSpec.getMode(r9);
        int r1 = View.MeasureSpec.getSize(r8);
        if (1073741824 != r0) goto L5;
        int r2 = View.MeasureSpec.getSize(r9);
        int r3 = this.mStatusBarHeight;
    L6:
        int r4 = r2 + r3;
        measureChild(this.mLeftText, r8, r9);
        measureChild(this.mSecLeftText, r8, r9);
        measureChild(this.mRightLayout, r8, r9);
        int r5 = getVisibleWidth(this.mRightLayout) + this.mMinSidePadding;
        measureChild(this.mLeftLayout, View.MeasureSpec.makeMeasureSpec(r1 - r5, PluginList.LEVEL_NOT_SET), r9);
        int r6 = Math.max(getVisibleWidth(this.mLeftText) + getVisibleWidth(this.mSecLeftText), getVisibleWidth(this.mLeftLayout)) + this.mMinSidePadding;
        if (this.isCenterAlways == false) goto L11;
        if (r6 >= r5) goto L10;
        this.mCenterLayout.measure(View.MeasureSpec.makeMeasureSpec(r1 - (r5 * 2), 1073741824), r9);
    L12:
        measureChild(this.mDividerView, r8, r9);
        setMeasuredDimension(View.MeasureSpec.getSize(r8), r4);
        return;
    L10:
        this.mCenterLayout.measure(View.MeasureSpec.makeMeasureSpec(r1 - (r6 * 2), 1073741824), r9);
        goto L12
    L11:
        this.mCenterLayout.measure(View.MeasureSpec.makeMeasureSpec((r1 - r6) - r5, PluginList.LEVEL_NOT_SET), r9);
        goto L12
    L5:
        r9 = View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824);
        r2 = this.mHeight;
        r3 = this.mStatusBarHeight;
        goto L6
    }

    public void setLeftImageResource(int r2, TitleBarIconSize r3) {
        setLeftImageResource(r2, 2131102418, r3);
    }

    public void setRightImage(int r2, Drawable r3) {
        if (r2 >= 0) goto L4;
    L5:
        r2 = 0;
    L7:
        if (this.mActionList.isEmpty() == false) goto L10;
        addAction(new IActionTitlebar.ImageAction(r3));
        return;
    L10:
        IActionTitlebar.Action r4 = (IActionTitlebar.Action) ListProtector.get(this.mActionList, r2);
        if (r4 == null) goto L18;
        View r5 = getViewByAction(r4);
        if (r5 != null) goto L15;
        return;
    L15:
        if ((r5 instanceof ImageView) == false) goto L20;
        ImageView r6 = (ImageView) r5;
        r6.setImageDrawable(r3);
        r6.setImageTintList(getContext().getResources().getColorStateList(2131102418));
        return;
    L20:
        return;
    L18:
        return;
    L4:
        if (r2 < this.mActionList.size()) goto L7;
        goto L5
    }

    public void setRightText(int r2, String r3) {
        IActionTitlebar.Action r4 = (IActionTitlebar.Action) ListProtector.get(this.mActionList, r2);
        if (r4 == null) goto L10;
        View r5 = getViewByAction(r4);
        if (r5 != null) goto L7;
        return;
    L7:
        if ((r5 instanceof TextView) == false) goto L12;
        ((TextView) r5).setText(r3);
        return;
    L12:
        return;
    }

    public void setSecLeftImageResource(int r5, int r6) {
        Context r0 = getContext();
        Context r1 = getContext();
        p.a r2 = p.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Drawable r7 = UDIconUtils.getIconDrawable(r0, r5, r2.getResources(r1).getColor(r6));
        this.mSecLeftText.setCompoundDrawablesWithIntrinsicBounds(r7, null, null, null);
        adjustSecLeftTextPadding();
    }

    public void setTitle(CharSequence r6, boolean r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r7 == false) goto L6;
        this.mCenterLayout.removeAllViews();
        this.mCenterLayout.addView(this.mCenterText);
        this.mCenterLayout.addView(this.mSubTitleText);
    L6:
        int r8 = r6.toString().indexOf("\n");
        if (r8 <= 0) goto L9;
        setTitle(r6.subSequence(0, r8), r6.subSequence(r8 + 1, r6.length()), 1);
        return;
    L9:
        int r9 = r6.toString().indexOf("\t");
        if (r9 <= 0) goto L12;
        setTitle(r6.subSequence(0, r9), " " + r6.subSequence(r9 + 1, r6.length()), 0);
        return;
    L12:
        this.mCenterText.setText(r6);
        this.mSubTitleText.setVisibility(8);
    }

    public View addAction(IActionTitlebar.Action r2, int r3) {
        return addAction(r2, r3, null);
    }

    public void setLeftImageResource(int r2, int r3) {
        setLeftImageResource(r2, r3, TitleBarIconSize.NORMAL);
    }

    public CmlCommonTitleBar(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mActionList = new ArrayList();
        this.isCenterAlways = false;
        this.mTitle = BuildConfig.FLAVOR;
        this.mDividerVisible = false;
        this.isLeftAlignMode = false;
        TypedArray r6 = getContext().obtainStyledAttributes(r4, new int[]{2130974484, 2130974485, 2130974486, 2130974487, 2130974488});
        this.mTitle = r6.getString(3);
        this.mBackground = r6.getColor(1, r3.getResources().getColor(2131100548));
        this.mTitleColor = r6.getColor(4, r3.getResources().getColor(2131106622));
        this.mBackIconRes = r6.getResourceId(0, CommonTitleBarConstants.ICON_BACK);
        this.mDividerVisible = r6.getBoolean(2, false);
        r6.recycle();
        this.mContext = r3;
        init(r3);
    }

    private void setTitle(CharSequence r2, CharSequence r3, int r4) {
        this.mCenterText.setText(r2);
        this.mCenterText.setVisibility(0);
        this.mCenterLayout.setOrientation(r4);
        this.mSubTitleText.setVisibility(0);
        this.mSubTitleText.setText(r3);
    }

    public View addAction(IActionTitlebar.Action r4, int r5, ViewGroup.LayoutParams r6) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ListProtector.add(this.mActionList, r5, r4);
        ViewGroup.LayoutParams r7 = r6;
        if (r6 != null) goto L8;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(p.a(getContext(), 44.0f), p.a(getContext(), 44.0f));
        r8.gravity = 16;
        r7 = r8;
    L8:
        View r0 = ActionTitleBarHelper.inflateAction(getContext(), r4);
        r0.setTag(r4);
        r0.setOnClickListener(this);
        this.mRightLayout.addView(r0, r5, r7);
        return r0;
    }

    public void setLeftImageResource(int r5, int r6, TitleBarIconSize r7) {
        Context r0 = getContext();
        Context r1 = getContext();
        p.a r2 = p.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Drawable r8 = UDIconUtils.getIconDrawable(r0, r5, r2.getResources(r1).getColor(r6));
        float r9 = r7.leftIconSize(getContext()) / TitleBarIconSize.NORMAL.leftIconSize(getContext());
        if (r9 <= 1.0f) goto L5;
        r9 = 1.0f;
    L5:
        ScaleDrawable r3 = new ScaleDrawable(r8, 17, 1.0f, 1.0f);
        r3.setLevel((int) (r9 * 10000.0f));
        this.mLeftText.setCompoundDrawablesWithIntrinsicBounds(r3, null, null, null);
    }

    public void setRightText(int r2, String r3, int r4) {
        IActionTitlebar.Action r5 = (IActionTitlebar.Action) ListProtector.get(this.mActionList, r2);
        if (r5 == null) goto L10;
        View r6 = getViewByAction(r5);
        if (r6 != null) goto L7;
        return;
    L7:
        if ((r6 instanceof TextView) == false) goto L12;
        TextView r7 = (TextView) r6;
        r7.setText(r3);
        r7.setTextColor(r4);
        return;
    L12:
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.mScreenWidth == r1) goto L6;
        this.mScreenWidth = r1;
        requestLayout();
        return;
    }

    public void setLeftTextPadding(int r3, int r4, int r5, int r6) {
        this.mLeftText.setPadding(p.a(getContext(), r3), p.a(getContext(), r4), p.a(getContext(), r5), p.a(getContext(), r6));
    }

    public void setSecLeftTextPadding(int r3, int r4, int r5, int r6) {
        this.mSecLeftText.setPadding(p.a(getContext(), r3), p.a(getContext(), r4), p.a(getContext(), r5), p.a(getContext(), r6));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = getMeasuredWidth();
        LinearLayout r10 = this.mLeftLayout;
        r10.layout(0, this.mStatusBarHeight, r10.getMeasuredWidth(), this.mStatusBarHeight + this.mLeftLayout.getMeasuredHeight());
        LinearLayout r11 = this.mRightLayout;
        int r12 = r9 - r11.getMeasuredWidth();
        int r13 = this.mStatusBarHeight;
        r11.layout(r12, r13, r9, this.mRightLayout.getMeasuredHeight() + r13);
        TextView r14 = this.mLeftText;
        r14.layout(0, this.mStatusBarHeight, r14.getMeasuredWidth(), this.mLeftText.getMeasuredHeight() + this.mStatusBarHeight);
        this.mSecLeftText.layout(this.mLeftText.getMeasuredWidth(), this.mStatusBarHeight, this.mLeftText.getMeasuredWidth() + this.mSecLeftText.getMeasuredWidth(), this.mSecLeftText.getMeasuredHeight() + this.mStatusBarHeight);
        int r15 = Math.max(getVisibleWidth(this.mLeftText) + getVisibleWidth(this.mSecLeftText), getVisibleWidth(this.mLeftLayout)) + this.mMinSidePadding;
        int r16 = getVisibleWidth(this.mRightLayout) + this.mMinSidePadding;
        if (this.isLeftAlignMode == false) goto L6;
        LinearLayout r17 = this.mCenterLayout;
        r17.layout(r15, this.mStatusBarHeight, r17.getMeasuredWidth() + r15, getMeasuredHeight());
        return;
    L6:
        if (this.isCenterAlways == false) goto L11;
        if (r15 <= r16) goto L9;
        this.mCenterLayout.layout(r15, this.mStatusBarHeight, r9 - r15, getMeasuredHeight());
    L10:
        this.mDividerView.layout(0, getMeasuredHeight() - this.mDividerView.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
        return;
    L9:
        this.mCenterLayout.layout(r16, this.mStatusBarHeight, r9 - r16, getMeasuredHeight());
        goto L10
    L11:
        int r18 = r9 / 2;
        int r19 = r18 - r15;
        int r0 = r18 - r16;
        int r1 = Math.min(r19, r0) * 2;
        int r2 = this.mCenterLayout.getMeasuredWidth();
        if (r2 > r1) goto L14;
        int r3 = r2 / 2;
        this.mCenterLayout.layout(r18 - r3, this.mStatusBarHeight, r18 + r3, getMeasuredHeight());
        return;
    L14:
        if (r19 <= r0) goto L16;
        this.mCenterLayout.layout((r9 - r2) - r16, this.mStatusBarHeight, r9 - r16, getMeasuredHeight());
        return;
    L16:
        this.mCenterLayout.layout(r15, this.mStatusBarHeight, r2 + r15, getMeasuredHeight());
    }
}
