package com.obric.oui.dialog.v2.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/J\u0010\u00100\u001a\u00020\b2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J(\u00104\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0002J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020\bH\u0016J\u0016\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020/2\u0006\u00105\u001a\u00020;J\u0010\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\bH\u0016J\u0010\u0010>\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010@J\u0010\u0010A\u001a\u00020+2\b\u0010?\u001a\u0004\u0018\u00010@J\u0010\u0010B\u001a\u00020+2\b\u0010C\u001a\u0004\u0018\u00010DJ\u000e\u0010E\u001a\u00020+2\u0006\u0010:\u001a\u00020/J\u0016\u0010E\u001a\u00020+2\u0006\u0010:\u001a\u00020/2\u0006\u00105\u001a\u000206J\b\u0010F\u001a\u00020\bH\u0016J\u000e\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020\bJ\u0010\u0010I\u001a\u00020+2\u0006\u0010H\u001a\u00020\bH\u0002J\u0016\u0010J\u001a\u00020+*\u00020\u001f2\b\u0010K\u001a\u0004\u0018\u00010@H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001a\u0010'\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000e¨\u0006L"}, d2 = {"Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isShowDivider", "", "leadingContainer", "Landroid/widget/FrameLayout;", "getLeadingContainer", "()Landroid/widget/FrameLayout;", "setLeadingContainer", "(Landroid/widget/FrameLayout;)V", "lineColor", "", "getLineColor", "()I", "lineColor$delegate", "Lkotlin/Lazy;", "lineHeight", "getLineHeight", "lineHeight$delegate", "listItemRoot", "Lcom/obric/oui/layout/OUILinearLayout;", "getListItemRoot", "()Lcom/obric/oui/layout/OUILinearLayout;", "setListItemRoot", "(Lcom/obric/oui/layout/OUILinearLayout;)V", "subtitleView", "Landroid/widget/TextView;", "getSubtitleView", "()Landroid/widget/TextView;", "setSubtitleView", "(Landroid/widget/TextView;)V", "titleView", "getTitleView", "setTitleView", "trailingContainer", "getTrailingContainer", "setTrailingContainer", "addChildToParent", "", "parent", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", CommonConsts.APM_INNER_EVENT_COST_INIT, "setChildToParent", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setEnabled", "enabled", "setLeadingView", "view", "Landroid/widget/FrameLayout$LayoutParams;", "setSelected", BuildConfig.FLAVOR, "setSubtitle", "str", "", "setTitle", "setTrailingImageView", "drawable", "Landroid/graphics/drawable/Drawable;", "setTrailingView", "shouldUpdateDividerColorOnPress", "showDivider", "show", "updateBottomDividerInternal", "updateText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ODialogListItemView extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OUILinearLayout f13828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f13829b;
    public FrameLayout c;
    public TextView d;
    public TextView e;
    private boolean f;
    private final Lazy g;
    private final Lazy h;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 6, 0})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f13830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ODialogListItemView f13831b;
        final /* synthetic */ boolean c;

        public a(View r1, ODialogListItemView r2, boolean r3) {
            this.f13830a = r1;
            this.f13831b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ODialogListItemView.a(this.f13831b, this.c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ODialogListItemView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public ODialogListItemView(Context r10, AttributeSet r11) {
        final Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r4, 0, null, 12, null);
        this.g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new ODialogListItemView$lineColor$2(r12), Function0.class, "com.obric.memorydata.plugin"));
        this.h = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new ODialogListItemView$lineHeight$2(this), Function0.class, "com.obric.memorydata.plugin"));
        a(r12);
    }

    public /* synthetic */ ODialogListItemView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private final void a(Context r6) {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_dialog_listitem_view, "layout", "o_dialog_listitem_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.list_item_root, OaidModel.KEY_ID, "list_item_root"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.list_item_root)");
        setListItemRoot((OUILinearLayout) ZeusTransformUtils.preCheckCast(r7, OUILinearLayout.class, "com.obric.memorydata.plugin"));
        OUILinearLayout r8 = getListItemRoot();
        r8.setRadius(h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 12));
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -1);
        r2.topMargin = h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 2);
        r2.bottomMargin = h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 2);
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r8.setChangeAlphaWhenPress(true);
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.list_item_title, OaidModel.KEY_ID, "list_item_title"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.list_item_title)");
        setTitleView((TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.memorydata.plugin"));
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.list_item_subtitle, OaidModel.KEY_ID, "list_item_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.list_item_subtitle)");
        setSubtitleView((TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.memorydata.plugin"));
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.list_leading_element, OaidModel.KEY_ID, "list_leading_element"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.list_leading_element)");
        setLeadingContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r11, FrameLayout.class, "com.obric.memorydata.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.list_trailing_element, OaidModel.KEY_ID, "list_trailing_element"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.list_trailing_element)");
        setTrailingContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin"));
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
    }

    private final void a(ViewGroup r2, View r3, ViewGroup.LayoutParams r4) {
        if (r3 == null) goto L17;
        if (r2 == null) goto L7;
        o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
    L7:
        if (r2 == null) goto L10;
        r2.removeAllViews();
    L10:
        if (r4 != null) goto L14;
        if (r2 == null) goto L23;
        r2.addView(r3);
        return;
    L23:
        return;
    L14:
        if (r2 == null) goto L24;
        r2.addView(r3, r4);
        return;
    L24:
        return;
    L17:
        if (r2 == null) goto L25;
        o.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        return;
    }

    private final void a(TextView r2, CharSequence r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        o.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        r2.setText(r1);
        o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public static final /* synthetic */ void a(ODialogListItemView r0, boolean r1) {
        r0.b(r1);
    }

    private final void b(boolean r4) {
        if (r4 == false) goto L5;
        updateBottomDivider(getListItemRoot().getPaddingLeft() + getLeadingContainer().getMeasuredWidth(), 0, getLineHeight(), getLineColor());
        return;
    L5:
        updateBottomDivider(getListItemRoot().getPaddingLeft(), 0, 0, getLineColor());
    }

    private final int getLineColor() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.g.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final int getLineHeight() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.h.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public final void a(View r4, ViewGroup.LayoutParams r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "layoutParams");
        a((ViewGroup) ZeusTransformUtils.preCheckCast(getTrailingContainer(), ViewGroup.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public final void a(boolean r4) {
        this.f = r4;
        getLeadingContainer().measure(0, 0);
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(r0, (Runnable) ZeusTransformUtils.preCheckCast(new a(r0, this, r4), Runnable.class, "com.obric.memorydata.plugin")), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r2);
    }

    public final FrameLayout getLeadingContainer() {
        FrameLayout r0 = this.f13829b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("leadingContainer");
        return null;
    }

    public final OUILinearLayout getListItemRoot() {
        OUILinearLayout r0 = this.f13828a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("listItemRoot");
        return null;
    }

    public final TextView getSubtitleView() {
        TextView r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        return null;
    }

    public final TextView getTitleView() {
        TextView r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    }

    public final FrameLayout getTrailingContainer() {
        FrameLayout r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingContainer");
        return null;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        getListItemRoot().setEnabled(r1);
    }

    public final void setLeadingContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f13829b = r2;
    }

    public final void setListItemRoot(OUILinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f13828a = r2;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r4) {
        super.setSelected(r4);
        getListItemRoot().getAlphaHelper().onSelectedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void setSubtitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        a(getSubtitleView(), r4);
    }

    public final void setSubtitleView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        a(getTitleView(), r4);
    }

    public final void setTitleView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setTrailingContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setTrailingImageView(Drawable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ImageView r0 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r0.setImageDrawable(r5);
        setTrailingView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
    }

    public final void setTrailingView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        a((ViewGroup) ZeusTransformUtils.preCheckCast(getTrailingContainer(), ViewGroup.class, "com.obric.memorydata.plugin"), r5, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public boolean shouldUpdateDividerColorOnPress() {
        return true;
    }
}
