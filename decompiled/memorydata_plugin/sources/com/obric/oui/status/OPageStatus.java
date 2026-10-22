package com.obric.oui.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0014\u001a\u00020\nJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/oui/status/OPageStatus;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "button", "Lcom/obric/oui/button/OButton;", "contentContainer", "loadingContainer", "Landroid/widget/FrameLayout;", "loadingResult", "Lcom/obric/oui/text/OTextView;", "loadingView", "Lcom/obric/oui/progress/ODownloadProgressView;", "messageView", "titleView", "getButton", "getLoadingResultView", "getLoadingView", "getMessageView", "getTitleView", "initAttrs", "", "initViews", "setLoadingLayout", "resId", "setLoadingResult", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "setLoadingResultColor", TypedValues.Custom.S_COLOR, "setMessage", "setMessageColor", "setTitle", "setTitleColor", "setType", "type", "showButton", "show", "", "showLoading", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPageStatus extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayout f14497b;
    private OTextView c;
    private OTextView d;
    private OButton e;
    private FrameLayout f;
    private ODownloadProgressView g;
    private OTextView h;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/status/OPageStatus$Companion;", "", "()V", "HORIZONTAL_LOADING", "", "STATUS_CONTENT", "VERTICAL_LOADING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14496a = new a(null);
    }

    public OPageStatus(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPageStatus(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OPageStatus(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r6);
        ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(R.layout.o_page_status_layout, "layout", "o_page_status_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        setGravity(1);
        a();
        if (r8 == null) goto L6;
        a(r8);
        return;
    }

    public /* synthetic */ OPageStatus(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final void a() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.content_container, OaidModel.KEY_ID, "content_container"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.content_container)");
        this.f14497b = (LinearLayout) ZeusTransformUtils.preCheckCast(r0, LinearLayout.class, "com.obric.memorydata.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.status_title, OaidModel.KEY_ID, "status_title"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.status_title)");
        this.c = (OTextView) ZeusTransformUtils.preCheckCast(r1, OTextView.class, "com.obric.memorydata.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.status_message, OaidModel.KEY_ID, "status_message"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.status_message)");
        this.d = (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.status_button, OaidModel.KEY_ID, "status_button"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.status_button)");
        this.e = (OButton) ZeusTransformUtils.preCheckCast(r3, OButton.class, "com.obric.memorydata.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.loading_container, OaidModel.KEY_ID, "loading_container"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.loading_container)");
        this.f = (FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.memorydata.plugin");
    }

    private final void a(AttributeSet r9) {
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(r10, R.styleable.OPageStatus, 0, 0);
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_type, "styleable", "OPageStatus_opagestatus_type")) == false) goto L6;
        setType(r11.getInt(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_type, "styleable", "OPageStatus_opagestatus_type"), 0));
    L6:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_title, "styleable", "OPageStatus_opagestatus_title")) == false) goto L9;
        setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_title, "styleable", "OPageStatus_opagestatus_title")), CharSequence.class, "com.obric.memorydata.plugin"));
    L9:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_titleColor, "styleable", "OPageStatus_opagestatus_titleColor")) == false) goto L12;
        setTitleColor(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_titleColor, "styleable", "OPageStatus_opagestatus_titleColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
    L12:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_message, "styleable", "OPageStatus_opagestatus_message")) == false) goto L15;
        setMessage((CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_message, "styleable", "OPageStatus_opagestatus_message")), CharSequence.class, "com.obric.memorydata.plugin"));
    L15:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_messageColor, "styleable", "OPageStatus_opagestatus_messageColor")) == false) goto L18;
        setMessageColor(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_messageColor, "styleable", "OPageStatus_opagestatus_messageColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, TypedValues.Custom.S_COLOR, "oui_basic_text_3b")));
    L18:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_showLoading, "styleable", "OPageStatus_opagestatus_showLoading")) == false) goto L21;
        a(r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_showLoading, "styleable", "OPageStatus_opagestatus_showLoading"), false));
    L21:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_loadingResult, "styleable", "OPageStatus_opagestatus_loadingResult")) == false) goto L24;
        setLoadingResult((CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_loadingResult, "styleable", "OPageStatus_opagestatus_loadingResult")), CharSequence.class, "com.obric.memorydata.plugin"));
    L24:
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_loadingResultColor, "styleable", "OPageStatus_opagestatus_loadingResultColor")) == false) goto L26;
        setLoadingResultColor(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OPageStatus_opagestatus_loadingResult, "styleable", "OPageStatus_opagestatus_loadingResult"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
    L26:
        r11.recycle();
    }

    public final void a(boolean r1) {
        ODownloadProgressView r0 = this.g;
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

    public final OButton getButton() {
        OButton r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("button");
        return null;
    L6:
        return r0;
    }

    public final OTextView getLoadingResultView() {
        return this.h;
    }

    public final ODownloadProgressView getLoadingView() {
        return this.g;
    }

    public final OTextView getMessageView() {
        OTextView r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        return null;
    L6:
        return r0;
    }

    public final OTextView getTitleView() {
        OTextView r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    L6:
        return r0;
    }

    public final void setLoadingLayout(int r6) {
        FrameLayout r1 = this.f;
        FrameLayout r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        r1 = null;
    L5:
        r1.removeAllViews();
        if (r6 == 0) goto L16;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        FrameLayout r5 = this.f;     // Catch: Exception -> L13
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");     // Catch: Exception -> L13
    L11:
        LinearLayout.inflate(r3, r6, (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L13
        return;
    L10:
        r2 = r5;
    L17:
        return;
    }

    public final void setLoadingResult(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        OTextView r2 = this.h;
        if (r2 == null) goto L7;
        r2.setText(r4);
        return;
    }

    public final void setLoadingResultColor(int r1) {
        OTextView r0 = this.h;
        if (r0 == null) goto L7;
        r0.setTextColor(r1);
        return;
    }

    public final void setMessage(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        OTextView r0 = this.d;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        r0 = null;
    L5:
        r0.setText(r5);
        OTextView r3 = this.d;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
    L9:
        int r6 = 0;
        if (r5 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        r6 = 8;
    L18:
        r1.setVisibility(r6);
        return;
    L12:
        if (r5.length() == 0) goto L15;
        r7 = false;
        goto L16
    L8:
        r1 = r3;
        goto L9
    }

    public final void setMessageColor(int r1) {
        OTextView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        OTextView r2 = this.c;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r2 = null;
    L5:
        r2.setText(r4);
    }

    public final void setTitleColor(int r1) {
        OTextView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    public final void setType(int r12) {
        FrameLayout r4 = null;
        if (r12 != 0) goto L5;
        LinearLayout r13 = this.f14497b;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r13 = null;
    L29:
        r13.setVisibility(0);
        FrameLayout r14 = this.f;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        r14 = null;
    L32:
        r14.setVisibility(8);
        setLoadingLayout(0);
        this.g = null;
        this.h = null;
        return;
    L5:
        if (r12 != 1) goto L7;
        LinearLayout r15 = this.f14497b;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r15 = null;
    L20:
        r15.setVisibility(8);
        FrameLayout r16 = this.f;
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L24:
        r4.setVisibility(0);
        int r17 = R.layout.o_page_status_vertical_loading_item;
        String r0 = "o_page_status_vertical_loading_item";
    L25:
        setLoadingLayout(ZeusTransformUtils.mapRes(r17, "layout", r0));
        this.g = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.status_loading, OaidModel.KEY_ID, "status_loading")), ODownloadProgressView.class, "com.obric.memorydata.plugin");
        this.h = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.status_loading_result, OaidModel.KEY_ID, "status_loading_result")), OTextView.class, "com.obric.memorydata.plugin");
        return;
    L23:
        r4 = r16;
        goto L24
    L7:
        if (r12 != 2) goto L35;
        LinearLayout r18 = this.f14497b;
        if (r18 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r18 = null;
    L12:
        r18.setVisibility(8);
        FrameLayout r19 = this.f;
        if (r19 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L16:
        r4.setVisibility(0);
        r17 = R.layout.o_page_status_horizontal_loading_item;
        r0 = "o_page_status_horizontal_loading_item";
        goto L25
    L15:
        r4 = r19;
        goto L16
    }
}
