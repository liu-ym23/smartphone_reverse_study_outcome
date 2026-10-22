package com.obric.oui.titlebar;

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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "请使用 OCTitleBar")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0007H\u0016J$\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u000100J\u001e\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007J&\u00103\u001a\u00020*2\u0006\u0010/\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007J\u0010\u00106\u001a\u00020*2\u0006\u00107\u001a\u000208H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010 \u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u0010\u0010#\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b&\u0010\fR\u0013\u0010'\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b(\u0010\f¨\u00069"}, d2 = {"Lcom/obric/oui/titlebar/OContainerTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "endButton", "Landroid/widget/ImageView;", "getEndButton", "()Landroid/widget/ImageView;", "endContainer", "Landroid/widget/FrameLayout;", "getEndContainer", "()Landroid/widget/FrameLayout;", "mEnd0Color", "getMEnd0Color", "()I", "setMEnd0Color", "(I)V", "mEnd1Color", "getMEnd1Color", "setMEnd1Color", "mEndButton1", "mEndContainer", "mLine", "Landroid/view/View;", "mStart0Color", "getMStart0Color", "setMStart0Color", "mStart1Color", "getMStart1Color", "setMStart1Color", "mStartButton0", "mStartButton1", "startButton0", "getStartButton0", "startButton1", "getStartButton1", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "initAttrs", "setDividerLineBackground", TypedValues.Custom.S_COLOR, "setDrawables", "start0", "Landroid/graphics/drawable/Drawable;", "start1", "end", "setTint", "end0", "end1", "showDividerLine", "show", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OContainerTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f14734a;
    private ImageView c;
    private FrameLayout d;
    private ImageView e;
    private View f;
    private int g;
    private int h;
    private int i;
    private int j;

    public OContainerTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OContainerTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OContainerTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        a(r6);
        if (r7 == null) goto L6;
        a(r7);
        return;
    }

    public /* synthetic */ OContainerTitleBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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
        OTitleBar.inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_container_title_bar, "layout", "o_view_container_title_bar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        this.f14734a = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_start_0, OaidModel.KEY_ID, "iv_start_0")), ImageView.class, "com.obric.memorydata.plugin");
        this.c = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_start_1, OaidModel.KEY_ID, "iv_start_1")), ImageView.class, "com.obric.memorydata.plugin");
        this.d = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.end_container, OaidModel.KEY_ID, "end_container")), FrameLayout.class, "com.obric.memorydata.plugin");
        this.e = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_end_1, OaidModel.KEY_ID, "iv_end_1")), ImageView.class, "com.obric.memorydata.plugin");
        this.f14756b = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title")), TextView.class, "com.obric.memorydata.plugin");
        this.f = findViewById(ZeusTransformUtils.mapRes(R.id.line, OaidModel.KEY_ID, "line"));
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
        View r0 = this.f;
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

    public final ImageView getEndButton() {
        return this.e;
    }

    public final FrameLayout getEndContainer() {
        return this.d;
    }

    public final int getMEnd0Color() {
        return this.i;
    }

    public final int getMEnd1Color() {
        return this.j;
    }

    public final int getMStart0Color() {
        return this.g;
    }

    public final int getMStart1Color() {
        return this.h;
    }

    public final ImageView getStartButton0() {
        return this.f14734a;
    }

    public final ImageView getStartButton1() {
        return this.c;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        View r0 = this.f;
        if (r0 == null) goto L7;
        r0.setBackgroundColor(r1);
        return;
    }

    public final void setMEnd0Color(int r1) {
        this.i = r1;
    }

    public final void setMEnd1Color(int r1) {
        this.j = r1;
    }

    public final void setMStart0Color(int r1) {
        this.g = r1;
    }

    public final void setMStart1Color(int r1) {
        this.h = r1;
    }
}
