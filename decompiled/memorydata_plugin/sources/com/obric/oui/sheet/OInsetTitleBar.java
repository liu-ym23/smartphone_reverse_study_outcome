package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.titlebar.OTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010-\u001a\u00020+H\u0014J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0007H\u0016J.\u00100\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001022\b\u00104\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u000102J&\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007J&\u00106\u001a\u00020+2\u0006\u00101\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u000209H\u0016R\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\"\u0010&\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\rR\"\u0010(\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\r¨\u0006:"}, d2 = {"Lcom/obric/oui/sheet/OInsetTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroid/widget/ImageView;", "endButton0", "getEndButton0", "()Landroid/widget/ImageView;", "endButton1", "getEndButton1", "mEnd0Color", "getMEnd0Color", "()I", "setMEnd0Color", "(I)V", "mEnd1Color", "getMEnd1Color", "setMEnd1Color", "mLine", "Landroid/view/View;", "mRightAction", "Landroid/widget/FrameLayout;", "getMRightAction", "()Landroid/widget/FrameLayout;", "setMRightAction", "(Landroid/widget/FrameLayout;)V", "mStart0Color", "getMStart0Color", "setMStart0Color", "mStart1Color", "getMStart1Color", "setMStart1Color", "startButton0", "getStartButton0", "startButton1", "getStartButton1", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "initAttrs", "onAttachedToWindow", "setDividerLineBackground", TypedValues.Custom.S_COLOR, "setDrawables", "start0", "Landroid/graphics/drawable/Drawable;", "start1", "end0", "end1", "setTint", "showDividerLine", "show", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInsetTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f14472a;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private View g;
    private int h;
    private int i;
    private int j;
    private int k;

    public OInsetTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OInsetTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OInsetTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        a(r6);
        if (r7 == null) goto L6;
        a(r7);
        return;
    }

    public /* synthetic */ OInsetTitleBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void a(Context r5) {
        OTitleBar.inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_inset_title_bar, "layout", "o_view_inset_title_bar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        this.c = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_start_0, OaidModel.KEY_ID, "iv_start_0")), ImageView.class, "com.obric.memorydata.plugin");
        this.d = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_start_1, OaidModel.KEY_ID, "iv_start_1")), ImageView.class, "com.obric.memorydata.plugin");
        this.f = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_end_0, OaidModel.KEY_ID, "iv_end_0")), ImageView.class, "com.obric.memorydata.plugin");
        this.e = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_end_1, OaidModel.KEY_ID, "iv_end_1")), ImageView.class, "com.obric.memorydata.plugin");
        this.f14756b = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title")), TextView.class, "com.obric.memorydata.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_right_container, OaidModel.KEY_ID, "fl_right_container"));
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.fl_right_container)");
        setMRightAction((FrameLayout) ZeusTransformUtils.preCheckCast(r6, FrameLayout.class, "com.obric.memorydata.plugin"));
        this.g = findViewById(ZeusTransformUtils.mapRes(R.id.line, OaidModel.KEY_ID, "line"));
    }

    private final void a(AttributeSet r9) {
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.OCompoundTitleBar, 0, 0);
        setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r10.getString(ZeusTransformUtils.mapRes(R.styleable.OCompoundTitleBar_oui_centerText, "styleable", "OCompoundTitleBar_oui_centerText")), CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        setTitleColor(r10.getColor(ZeusTransformUtils.mapRes(R.styleable.OCompoundTitleBar_oui_centerTextColor, "styleable", "OCompoundTitleBar_oui_centerTextColor"), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.TextPrimary, TypedValues.Custom.S_COLOR, "TextPrimary"))));     // Catch: Throwable -> L6
        setTitleSizePixel(r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OCompoundTitleBar_oui_centerTextSize, "styleable", "OCompoundTitleBar_oui_centerTextSize"), h.a(17)));     // Catch: Throwable -> L6
        int r0 = r10.getColor(ZeusTransformUtils.mapRes(R.styleable.OCompoundTitleBar_oui_dividerColor, "styleable", "OCompoundTitleBar_oui_dividerColor"), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.LinePrimary, TypedValues.Custom.S_COLOR, "LinePrimary")));     // Catch: Throwable -> L6
        a(r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCompoundTitleBar_oui_dividerVisible, "styleable", "OCompoundTitleBar_oui_dividerVisible"), false));     // Catch: Throwable -> L6
        setDividerLineBackground(r0);     // Catch: Throwable -> L6
        r10.recycle();
        return;
    L6:
        th = move-exception;
        r10.recycle();
        throw th;
    }

    public void a(boolean r1) {
        View r0 = this.g;
        if (r0 == null) goto L10;
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public final ImageView getEndButton0() {
        return this.f;
    }

    public final ImageView getEndButton1() {
        return this.e;
    }

    public final int getMEnd0Color() {
        return this.j;
    }

    public final int getMEnd1Color() {
        return this.k;
    }

    public final FrameLayout getMRightAction() {
        FrameLayout r0 = this.f14472a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightAction");
        return null;
    }

    public final int getMStart0Color() {
        return this.h;
    }

    public final int getMStart1Color() {
        return this.i;
    }

    public final ImageView getStartButton0() {
        return this.c;
    }

    public final ImageView getStartButton1() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageView r0 = this.c;
        if (r0 == null) goto L6;
        o.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), h.a(40), h.a(44), false, 4, null);
    L6:
        ImageView r1 = this.d;
        if (r1 == null) goto L10;
        o.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), h.a(40), h.a(44), false, 4, null);
    L10:
        ImageView r2 = this.f;
        if (r2 == null) goto L14;
        o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), h.a(40), h.a(44), false, 4, null);
    L14:
        ImageView r10 = this.e;
        if (r10 == null) goto L19;
        o.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), h.a(40), h.a(44), false, 4, null);
        return;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        View r0 = this.g;
        if (r0 == null) goto L7;
        r0.setBackgroundColor(r1);
        return;
    }

    public final void setMEnd0Color(int r1) {
        this.j = r1;
    }

    public final void setMEnd1Color(int r1) {
        this.k = r1;
    }

    public final void setMRightAction(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14472a = r2;
    }

    public final void setMStart0Color(int r1) {
        this.h = r1;
    }

    public final void setMStart1Color(int r1) {
        this.i = r1;
    }
}
