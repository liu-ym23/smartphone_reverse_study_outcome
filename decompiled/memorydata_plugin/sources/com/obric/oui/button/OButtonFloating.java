package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.text.OBaseTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J,\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001a\u001a\u00020\u00112\b\b\u0001\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/oui/button/OButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "textView", "Lcom/obric/oui/text/OBaseTextView;", "getTextView", "()Lcom/obric/oui/text/OBaseTextView;", "setTextView", "(Lcom/obric/oui/text/OBaseTextView;)V", "applyDynamicTheme", "", "themeStyle", "getTitleView", "Landroid/widget/TextView;", "initContent", "contentView", "Landroid/widget/FrameLayout;", "typedArray", "Landroid/content/res/TypedArray;", "setTitle", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "textRes", "updateUIOnEnableChanged", "enabled", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OButtonFloating extends OShadowFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OBaseTextView f13378a;

    public OButtonFloating(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OButtonFloating(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OButtonFloating(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public OButtonFloating(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r5, r6);
    }

    public /* synthetic */ OButtonFloating(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r8, r9, r4, r5);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void a(int r1) {
        super.a(r1);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void a(Context r11, FrameLayout r12, AttributeSet r13, TypedArray r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r12, "contentView");
        if (r14 != null) goto L5;
        return;
    L5:
        CharSequence r17 = r14.getText(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetText, "styleable", "OShadowFrame_oui_widgetText"));
        int r8 = r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetTextStyle, "styleable", "OShadowFrame_oui_widgetTextStyle"), ZeusTransformUtils.mapRes(R.style.Button_2_Medium, "style", "Button_2_Medium"));
        int r0 = r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetTextColor, "styleable", "OShadowFrame_oui_widgetTextColor"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"), null));
        OBaseTextView r9 = new OBaseTextView(r15, null, 0, 6, null);
        r9.setTextAppearance(r8);
        r9.setTextColor(r0);
        r9.setText(r17);
        r9.setSingleLine();
        r9.setIncludeFontPadding(false);
        r9.setGravity(17);
        setTextView(r9);
        View r1 = (View) ZeusTransformUtils.preCheckCast(getTextView(), View.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r2.gravity = 17;
        Unit r18 = Unit.INSTANCE;
        r12.addView(r1, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        if (getMaterialApplied() == false) goto L9;
        a(r15, r14);
        return;
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void a(boolean r1) {
        super.a(r1);
        OBaseTextView r0 = getTextView();
        if (r1 == false) goto L5;
        float r2 = 1.0f;
    L6:
        r0.setAlpha(r2);
        return;
    L5:
        r2 = 0.3f;
        goto L6
    }

    public final OBaseTextView getTextView() {
        OBaseTextView r0 = this.f13378a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        return null;
    }

    public final TextView getTitleView() {
        return (TextView) ZeusTransformUtils.preCheckCast(getTextView(), TextView.class, "com.obric.memorydata.plugin");
    }

    public final void setTextView(OBaseTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f13378a = r2;
    }

    public final void setTitle(int r1) {
        getTextView().setText(r1);
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        getTextView().setText(r4);
    }
}
