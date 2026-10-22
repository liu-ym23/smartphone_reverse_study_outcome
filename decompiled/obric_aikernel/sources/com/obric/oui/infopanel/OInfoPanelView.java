package com.obric.oui.infopanel;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.obric.oui.common.util.f;
import com.obric.oui.common.util.k;
import com.obric.oui.text.OTextView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001)\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u001a\u0010\u0012\u001a\u00020\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0013J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001f\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020!J\u0016\u0010#\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020$R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00102¨\u0006="}, d2 = {"Lcom/obric/oui/infopanel/OInfoPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "insetTopImg", "unInsetTopImg", "showDevelopTips", "Landroid/widget/ImageView;", "getTopBannerView", "getTopImgView", "", "resId", "setInsetTopImg", "setUnInsetImg", "width", "height", "setImgSize", "Lkotlin/Function1;", "operation", "exImgOperation", "Landroid/view/ViewGroup;", "getCustomContainer", "Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "params", "setCustomContent", "", "title", "setTitle", "desc", "setDesc", "setScrollableDesc", "Lt9/a;", "", "withTopMargin", "setBottomActionView", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "ivImg", "Landroid/widget/ImageView;", "bottomView", "Landroid/view/View;", "com/obric/oui/infopanel/OInfoPanelView$a", "fixDescHeightListener", "Lcom/obric/oui/infopanel/OInfoPanelView$a;", "contentContainer", "Landroid/view/ViewGroup;", "customContainer", "headerContainer", "Lcom/obric/oui/text/OTextView;", "tvDesc", "Lcom/obric/oui/text/OTextView;", "Landroidx/core/widget/NestedScrollView;", "descContainer", "Landroidx/core/widget/NestedScrollView;", "tvTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
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

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInfoPanelView f6836c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f6837g;

        a(OInfoPanelView r10, Context r11) {
            this.f6836c = r10;
            this.f6837g = r11;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (OInfoPanelView.access$getBottomView$p(this.f6836c) != null) goto L5;
            return;
        L5:
            int[] r10 = new int[2];
            View r11 = OInfoPanelView.access$getBottomView$p(this.f6836c);
            if (r11 == null) goto L8;
            r11.getLocationInWindow(r10);
        L8:
            View r12 = OInfoPanelView.access$getBottomView$p(this.f6836c);
            Intrinsics.checkNotNull(r12);
            int r13 = r12.getHeight() + r10[1];
            int r14 = f.d(this.f6837g);
            Log.e("jiangyunkai", "height: " + r14);
            Log.e("jiangyunkai", "bottom:" + r13);
            if (r13 > r14) goto L11;
            return;
        L11:
            if (TextUtils.isEmpty(OInfoPanelView.access$getTvDesc$p(this.f6836c).getText().toString()) == false) goto L13;
            OInfoPanelView.access$showDevelopTips(this.f6836c);
            return;
        L13:
            Resources r15 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
            int r16 = OInfoPanelView.access$getDescContainer$p(this.f6836c).getHeight() - ((r13 - r14) - MathKt.roundToInt(TypedValue.applyDimension(1, 12, r15.getDisplayMetrics())));
            Resources r17 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
            if (r16 >= MathKt.roundToInt(TypedValue.applyDimension(1, 15, r17.getDisplayMetrics()))) goto L16;
            OInfoPanelView.access$showDevelopTips(this.f6836c);
        L19:
            this.f6836c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        L16:
            NestedScrollView r18 = OInfoPanelView.access$getDescContainer$p(this.f6836c);
            ViewGroup.LayoutParams r19 = r18.getLayoutParams();
            if (r19 == null) goto L21;
            r19.height = r16;
            r18.setLayoutParams(r19);
            goto L19
        L21:
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OInfoPanelView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OInfoPanelView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        float r12 = 290;
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        setMinimumHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics())));
        ViewGroup.inflate(r10, h.o_info_panel_frame, this);
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(-1, -2);
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        setMinHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r12, r15.getDisplayMetrics())));
        Unit r16 = Unit.INSTANCE;
        setLayoutParams(r14);
        View r17 = findViewById(u8.f.header_container);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.header_container)");
        this.headerContainer = (ViewGroup) r17;
        View r18 = findViewById(u8.f.content_container);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.content_container)");
        this.contentContainer = (ViewGroup) r18;
        View r19 = findViewById(u8.f.desc_container);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.desc_container)");
        this.descContainer = (NestedScrollView) r19;
        View r20 = findViewById(u8.f.custom_container);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.custom_container)");
        this.customContainer = (ViewGroup) r20;
        View r21 = findViewById(u8.f.iv_illustration);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.iv_illustration)");
        this.ivImg = (ImageView) r21;
        View r22 = findViewById(u8.f.tv_title);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.tv_title)");
        this.tvTitle = (OTextView) r22;
        View r23 = findViewById(u8.f.tv_desc);
        OTextView r24 = (OTextView) r23;
        r24.setLineHeight(MathKt.roundToInt(((double) r24.getTextSize()) * 1.4d));
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById<OTextView>(…4).roundToInt()\n        }");
        this.tvDesc = r24;
        this.fixDescHeightListener = new a(this, r10);
    }

    public /* synthetic */ OInfoPanelView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ View access$getBottomView$p(OInfoPanelView r10) {
        return r10.bottomView;
    }

    public static final /* synthetic */ NestedScrollView access$getDescContainer$p(OInfoPanelView r10) {
        return r10.descContainer;
    }

    public static final /* synthetic */ OTextView access$getTvDesc$p(OInfoPanelView r10) {
        return r10.tvDesc;
    }

    public static final /* synthetic */ void access$setBottomView$p(OInfoPanelView r10, View r11) {
        r10.bottomView = r11;
    }

    public static final /* synthetic */ void access$setDescContainer$p(OInfoPanelView r10, NestedScrollView r11) {
        r10.descContainer = r11;
    }

    public static final /* synthetic */ void access$showDevelopTips(OInfoPanelView r10) {
        r10.showDevelopTips();
    }

    private final void insetTopImg() {
        ViewGroup r10 = this.headerContainer;
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        r10.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 32, r11.getDisplayMetrics())), 0, 0);
        if (this.contentContainer.getLayoutParams() == null) goto L6;
        ViewGroup r12 = this.contentContainer;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        int r15 = r14.leftMargin;
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r14.setMargins(r15, MathKt.roundToInt(TypedValue.applyDimension(1, 16, r16.getDisplayMetrics())), r14.rightMargin, r14.bottomMargin);
        Unit r17 = Unit.INSTANCE;
        r12.setLayoutParams(r14);
        return;
    }

    public static /* synthetic */ void setBottomActionView$default(OInfoPanelView r10, t9.a r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = true;
    L5:
        r10.setBottomActionView(r11, r12);
    }

    public static /* synthetic */ void setCustomContent$default(OInfoPanelView r10, View r11, ViewGroup.LayoutParams r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.setCustomContent(r11, r12);
    }

    private final void showDevelopTips() {
    }

    private final void unInsetTopImg() {
        this.headerContainer.setPadding(0, 0, 0, 0);
        if (this.contentContainer.getLayoutParams() == null) goto L6;
        ViewGroup r10 = this.contentContainer;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        int r13 = r12.leftMargin;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        r12.setMargins(r13, MathKt.roundToInt(TypedValue.applyDimension(1, 24, r14.getDisplayMetrics())), r12.rightMargin, r12.bottomMargin);
        Unit r15 = Unit.INSTANCE;
        r10.setLayoutParams(r12);
        return;
    }

    public final void exImgOperation(Function1<? super ImageView, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "operation");
        r10.invoke(this.ivImg);
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

    public final void setBottomActionView(t9.a r10, ConstraintLayout.LayoutParams r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "params");
        View r12 = r10.a();
        this.bottomView = r12;
        addView(r12, r11);
    }

    public final void setBottomActionView(t9.a r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        View r12 = r10.a();
        this.bottomView = r12;
        ConstraintLayout.LayoutParams r13 = new ConstraintLayout.LayoutParams(-1, -2);
        r13.startToStart = 0;
        r13.endToEnd = 0;
        r13.bottomToBottom = 0;
        r13.topToBottom = this.contentContainer.getId();
        r13.verticalBias = 1.0f;
        if (r11 == false) goto L5;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        r13.setMargins(0, MathKt.roundToInt(TypedValue.applyDimension(1, 12, r14.getDisplayMetrics())), 0, 0);
    L5:
        Unit r15 = Unit.INSTANCE;
        addView(r12, r13);
    }

    public final void setCustomContent(View r10, ViewGroup.LayoutParams r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        ViewGroup r12 = this.customContainer;
        if (r11 == null) goto L5;
        r12.addView(r10, r11);
        return;
    L5:
        r12.addView(r10);
    }

    public final void setDesc(CharSequence r10) {
        if (r10 != null) goto L4;
        k.f(this.tvDesc);
        ViewGroup.LayoutParams r11 = this.tvDesc.getLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r11).topMargin = 0;
        return;
    L4:
        this.tvDesc.setText(r10);
        k.h(this.tvDesc);
    }

    public final void setImgSize(int r10, int r11) {
        ImageView r12 = this.ivImg;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L7;
        r13.width = r10;
        r13.height = r11;
        r12.setLayoutParams(r13);
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setInsetTopImg(int r10) {
        getTopBannerView().setImageResource(r10);
    }

    public final void setScrollableDesc(CharSequence r10) {
        setDesc(r10);
        getViewTreeObserver().addOnGlobalLayoutListener(this.fixDescHeightListener);
    }

    public final void setTitle(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        this.tvTitle.setText(r10);
    }

    public final void setUnInsetImg(int r10) {
        getTopImgView().setImageResource(r10);
    }
}
