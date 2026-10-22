package com.obric.oui.infopanel;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n*\u0001\u000f\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u001aJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u0013J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020%J\u001a\u0010&\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010'J\u0010\u0010(\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J\u000e\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020-J\u0010\u00101\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010*J\u000e\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020*J\u000e\u00104\u001a\u00020\u00182\u0006\u00100\u001a\u00020-J\b\u00105\u001a\u00020\u0018H\u0002J\b\u00106\u001a\u00020\u0018H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/oui/infopanel/OInfoPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bottomView", "Landroid/view/View;", "contentContainer", "Landroid/view/ViewGroup;", "customContainer", "descContainer", "Landroidx/core/widget/NestedScrollView;", "fixDescHeightListener", "com/obric/oui/infopanel/OInfoPanelView$fixDescHeightListener$1", "Lcom/obric/oui/infopanel/OInfoPanelView$fixDescHeightListener$1;", "headerContainer", "ivImg", "Landroid/widget/ImageView;", "tvDesc", "Lcom/obric/oui/text/OTextView;", "tvTitle", "exImgOperation", "", "operation", "Lkotlin/Function1;", "getCustomContainer", "getTopBannerView", "getTopImgView", "insetTopImg", "setBottomActionView", "view", "Lcom/obric/oui/infopanel/action/IOInfoPanelActionView;", TrackerImpl.PARAMS, "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "withTopMargin", "", "setCustomContent", "Landroid/view/ViewGroup$LayoutParams;", "setDesc", "desc", "", "setImgSize", "width", "", "height", "setInsetTopImg", "resId", "setScrollableDesc", "setTitle", "title", "setUnInsetImg", "showDevelopTips", "unInsetTopImg", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelView extends ConstraintLayout {
    private View bottomView;
    private final ViewGroup contentContainer;
    private final ViewGroup customContainer;
    private NestedScrollView descContainer;
    private final a fixDescHeightListener;
    private final ViewGroup headerContainer;
    private final ImageView ivImg;
    private final OTextView tvDesc;
    private final OTextView tvTitle;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/oui/infopanel/OInfoPanelView$fixDescHeightListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInfoPanelView f13960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f13961b;

        a(OInfoPanelView r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.f13960a = r3;
            this.f13961b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (OInfoPanelView.access$getBottomView$p(this.f13960a) != null) goto L5;
            return;
        L5:
            int[] r0 = new int[2];
            View r1 = OInfoPanelView.access$getBottomView$p(this.f13960a);
            if (r1 == null) goto L9;
            r1.getLocationInWindow(r0);
        L9:
            View r2 = OInfoPanelView.access$getBottomView$p(this.f13960a);
            Intrinsics.checkNotNull(r2);
            int r3 = r2.getHeight() + r0[1];
            int r4 = h.b(this.f13961b);
            Log.e("jiangyunkai", Intrinsics.stringPlus("height: ", Integer.valueOf(r4)));
            Log.e("jiangyunkai", Intrinsics.stringPlus("bottom:", Integer.valueOf(r3)));
            if (r3 > r4) goto L12;
            return;
        L12:
            if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(OInfoPanelView.access$getTvDesc$p(this.f13960a).getText().toString(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L14;
            OInfoPanelView.access$showDevelopTips(this.f13960a);
            return;
        L14:
            int r5 = (r3 - r4) - h.a((View) ZeusTransformUtils.preCheckCast(this.f13960a, View.class, "com.obric.memorydata.plugin"), 12);
            int r6 = OInfoPanelView.access$getDescContainer$p(this.f13960a).getHeight() - r5;
            if (r6 >= h.a((View) ZeusTransformUtils.preCheckCast(this.f13960a, View.class, "com.obric.memorydata.plugin"), 15)) goto L17;
            OInfoPanelView.access$showDevelopTips(this.f13960a);
        L18:
            this.f13960a.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
            return;
        L17:
            View r7 = (View) ZeusTransformUtils.preCheckCast(OInfoPanelView.access$getDescContainer$p(this.f13960a), View.class, "com.obric.memorydata.plugin");
            ViewGroup.LayoutParams r8 = r7.getLayoutParams();
            Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            r8.height = r6;
            r7.setLayoutParams(r8);
            goto L18
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OInfoPanelView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OInfoPanelView(Context r7, AttributeSet r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        setMinimumHeight(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 290));
        ConstraintLayout.inflate(r9, ZeusTransformUtils.mapRes(R.layout.o_info_panel_frame, "layout", "o_info_panel_frame"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(-1, -2);
        setMinHeight(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 290));
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.header_container, OaidModel.KEY_ID, "header_container"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.header_container)");
        this.headerContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.content_container, OaidModel.KEY_ID, "content_container"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.content_container)");
        this.contentContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r13, ViewGroup.class, "com.obric.memorydata.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.desc_container, OaidModel.KEY_ID, "desc_container"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.desc_container)");
        this.descContainer = (NestedScrollView) ZeusTransformUtils.preCheckCast(r14, NestedScrollView.class, "com.obric.memorydata.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_container, OaidModel.KEY_ID, "custom_container"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.custom_container)");
        this.customContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r15, ViewGroup.class, "com.obric.memorydata.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_illustration, OaidModel.KEY_ID, "iv_illustration"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.iv_illustration)");
        this.ivImg = (ImageView) ZeusTransformUtils.preCheckCast(r16, ImageView.class, "com.obric.memorydata.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.tv_title)");
        this.tvTitle = (OTextView) ZeusTransformUtils.preCheckCast(r17, OTextView.class, "com.obric.memorydata.plugin");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_desc, OaidModel.KEY_ID, "tv_desc"));
        OTextView r0 = (OTextView) ZeusTransformUtils.preCheckCast(r18, OTextView.class, "com.obric.memorydata.plugin");
        r0.setLineHeight(MathKt.roundToInt(((double) r0.getTextSize()) * 1.4d));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById<OTextView>(…4).roundToInt()\n        }");
        this.tvDesc = (OTextView) ZeusTransformUtils.preCheckCast(r18, OTextView.class, "com.obric.memorydata.plugin");
        this.fixDescHeightListener = new a(this, r9);
    }

    public /* synthetic */ OInfoPanelView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ View access$getBottomView$p(OInfoPanelView r0) {
        return r0.bottomView;
    }

    public static final /* synthetic */ NestedScrollView access$getDescContainer$p(OInfoPanelView r0) {
        return r0.descContainer;
    }

    public static final /* synthetic */ OTextView access$getTvDesc$p(OInfoPanelView r0) {
        return r0.tvDesc;
    }

    public static final /* synthetic */ void access$showDevelopTips(OInfoPanelView r0) {
        r0.showDevelopTips();
    }

    private final void insetTopImg() {
        this.headerContainer.setPadding(0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 32), 0, 0);
        if (this.contentContainer.getLayoutParams() == null) goto L6;
        ViewGroup r0 = this.contentContainer;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r2.setMargins(r2.leftMargin, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), r2.rightMargin, r2.bottomMargin);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    }

    public static /* synthetic */ void setBottomActionView$default(OInfoPanelView r1, com.obric.oui.infopanel.action.a r2, boolean r3, int r4, Object r5) {
        com.obric.oui.infopanel.action.a r6 = (com.obric.oui.infopanel.action.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.oui.infopanel.action.a.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r1.setBottomActionView(r6, r3);
    }

    public static /* synthetic */ void setCustomContent$default(OInfoPanelView r0, View r1, ViewGroup.LayoutParams r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setCustomContent(r1, r2);
    }

    private final void showDevelopTips() {
    }

    private final void unInsetTopImg() {
        this.headerContainer.setPadding(0, 0, 0, 0);
        if (this.contentContainer.getLayoutParams() == null) goto L6;
        ViewGroup r0 = this.contentContainer;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r2.setMargins(r2.leftMargin, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 24), r2.rightMargin, r2.bottomMargin);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void exImgOperation(Function1<? super ImageView, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "operation");
        r4.invoke(this.ivImg);
    }

    public final ViewGroup getCustomContainer() {
        return this.customContainer;
    }

    public final ImageView getTopBannerView() {
        unInsetTopImg();
        return this.ivImg;
    }

    public final ImageView getTopImgView() {
        insetTopImg();
        return this.ivImg;
    }

    public final void setBottomActionView(com.obric.oui.infopanel.action.a r3, ConstraintLayout.LayoutParams r4) {
        com.obric.oui.infopanel.action.a r5 = (com.obric.oui.infopanel.action.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.infopanel.action.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        View r6 = r5.getView();
        this.bottomView = r6;
        addView(r6, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    }

    public final void setBottomActionView(com.obric.oui.infopanel.action.a r5, boolean r6) {
        com.obric.oui.infopanel.action.a r7 = (com.obric.oui.infopanel.action.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.infopanel.action.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "view");
        View r8 = r7.getView();
        this.bottomView = r8;
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(-1, -2);
        r0.startToStart = 0;
        r0.endToEnd = 0;
        r0.bottomToBottom = 0;
        r0.topToBottom = this.contentContainer.getId();
        r0.verticalBias = 1.0f;
        if (r6 == false) goto L5;
        r0.setMargins(0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), 0, 0);
    L5:
        Unit r9 = Unit.INSTANCE;
        addView(r8, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    }

    public final void setCustomContent(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        ViewGroup r1 = this.customContainer;
        if (r3 == null) goto L5;
        r1.addView(r2, r3);
        return;
    L5:
        r1.addView(r2);
    }

    public final void setDesc(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        o.b((View) ZeusTransformUtils.preCheckCast(this.tvDesc, View.class, "com.obric.memorydata.plugin"));
        ViewGroup.LayoutParams r2 = this.tvDesc.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).topMargin = 0;
        return;
    L5:
        this.tvDesc.setText(r4);
        o.a((View) ZeusTransformUtils.preCheckCast(this.tvDesc, View.class, "com.obric.memorydata.plugin"));
    }

    public final void setImgSize(int r3, int r4) {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.ivImg, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r0.width = r3;
        r0.height = r4;
        r2.setLayoutParams(r0);
    }

    public final void setInsetTopImg(int r1) {
        getTopBannerView().setImageResource(r1);
    }

    public final void setScrollableDesc(CharSequence r3) {
        setDesc((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(this.fixDescHeightListener, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "title");
        this.tvTitle.setText(r4);
    }

    public final void setUnInsetImg(int r1) {
        getTopImgView().setImageResource(r1);
    }
}
