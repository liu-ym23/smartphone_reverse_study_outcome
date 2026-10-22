package com.obric.oui.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.c;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002¨\u0006!"}, d2 = {"Lcom/obric/oui/status/OPageStatus;", "Landroid/widget/LinearLayout;", "", WsConstants.KEY_CONNECTION_TYPE, "", "setType", "resId", "setLoadingLayout", "Lcom/obric/oui/text/OTextView;", "getTitleView", "", "text", "setTitle", TypedValues.Custom.S_COLOR, "setTitleColor", "getMessageView", "setMessage", "setMessageColor", "Lcom/obric/oui/button/OButton;", "getButton", "Lcom/obric/oui/progress/ODownloadProgressView;", "getLoadingView", "getLoadingResultView", "setLoadingResult", "setLoadingResultColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OPageStatus extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f7442c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OTextView f7443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private OTextView f7444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private OButton f7445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private FrameLayout f7446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ODownloadProgressView f7447k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private OTextView f7448l;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OPageStatus(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OPageStatus(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OPageStatus(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        LayoutInflater.from(r10).inflate(h.o_page_status_layout, this, true);
        setGravity(1);
        b();
        if (r11 == null) goto L6;
        a(r11);
        return;
    }

    public /* synthetic */ OPageStatus(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void a(AttributeSet r10) {
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        TypedArray r12 = r11.getTheme().obtainStyledAttributes(r10, l.OPageStatus, 0, 0);
        int r13 = l.OPageStatus_opagestatus_type;
        if (r12.hasValue(r13) == false) goto L5;
        setType(r12.getInt(r13, 0));
    L5:
        int r14 = l.OPageStatus_opagestatus_title;
        if (r12.hasValue(r14) == false) goto L8;
        setTitle(r12.getString(r14));
    L8:
        int r15 = l.OPageStatus_opagestatus_titleColor;
        if (r12.hasValue(r15) == false) goto L11;
        setTitleColor(r12.getColor(r15, c.oui_basic_text_3));
    L11:
        int r16 = l.OPageStatus_opagestatus_message;
        if (r12.hasValue(r16) == false) goto L14;
        setMessage(r12.getString(r16));
    L14:
        int r17 = l.OPageStatus_opagestatus_messageColor;
        if (r12.hasValue(r17) == false) goto L17;
        setMessageColor(r12.getColor(r17, c.oui_basic_text_3b));
    L17:
        int r18 = l.OPageStatus_opagestatus_showLoading;
        if (r12.hasValue(r18) == false) goto L20;
        c(r12.getBoolean(r18, false));
    L20:
        int r19 = l.OPageStatus_opagestatus_loadingResult;
        if (r12.hasValue(r19) == false) goto L24;
        setLoadingResult(r12.getString(r19));
    L24:
        if (r12.hasValue(l.OPageStatus_opagestatus_loadingResultColor) == false) goto L26;
        setLoadingResultColor(r12.getColor(r19, c.oui_basic_text_3));
    L26:
        r12.recycle();
    }

    private final void b() {
        View r10 = findViewById(f.content_container);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.content_container)");
        this.f7442c = (LinearLayout) r10;
        View r11 = findViewById(f.status_title);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.status_title)");
        this.f7443g = (OTextView) r11;
        View r12 = findViewById(f.status_message);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.status_message)");
        this.f7444h = (OTextView) r12;
        View r13 = findViewById(f.status_button);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.status_button)");
        this.f7445i = (OButton) r13;
        View r14 = findViewById(f.loading_container);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.loading_container)");
        this.f7446j = (FrameLayout) r14;
    }

    public final void c(boolean r10) {
        ODownloadProgressView r11 = this.f7447k;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        int r12 = 0;
    L7:
        r11.setVisibility(r12);
        return;
    L6:
        r12 = 8;
        goto L7
    }

    public final OButton getButton() {
        OButton r10 = this.f7445i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("button");
    L5:
        return r10;
    }

    public final OTextView getLoadingResultView() {
        return this.f7448l;
    }

    public final ODownloadProgressView getLoadingView() {
        return this.f7447k;
    }

    public final OTextView getMessageView() {
        OTextView r10 = this.f7444h;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
    L5:
        return r10;
    }

    public final OTextView getTitleView() {
        OTextView r10 = this.f7443g;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
    L5:
        return r10;
    }

    public final void setLoadingLayout(int r10) {
        FrameLayout r11 = this.f7446j;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L5:
        r11.removeAllViews();
        if (r10 == 0) goto L15;
        Context r12 = getContext();     // Catch: Exception -> L12
        FrameLayout r13 = this.f7446j;     // Catch: Exception -> L12
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");     // Catch: Exception -> L12
    L10:
        LinearLayout.inflate(r12, r10, r13);     // Catch: Exception -> L12
        return;
    L16:
        return;
    }

    public final void setLoadingResult(CharSequence r10) {
        OTextView r11 = this.f7448l;
        if (r11 == null) goto L6;
        r11.setText(r10);
        return;
    }

    public final void setLoadingResultColor(int r10) {
        OTextView r11 = this.f7448l;
        if (r11 == null) goto L6;
        r11.setTextColor(r10);
        return;
    }

    public final void setMessage(CharSequence r10) {
        OTextView r11 = this.f7444h;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
    L5:
        r11.setText(r10);
        OTextView r12 = this.f7444h;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
    L8:
        int r13 = 0;
        if (r10 != null) goto L11;
    L14:
        boolean r14 = true;
    L15:
        if (r14 == false) goto L17;
        r13 = 8;
    L17:
        r12.setVisibility(r13);
        return;
    L11:
        if (r10.length() == 0) goto L14;
        r14 = false;
        goto L15
    }

    public final void setMessageColor(int r10) {
        OTextView r11 = this.f7444h;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
    L5:
        r11.setTextColor(r10);
    }

    public final void setTitle(CharSequence r10) {
        OTextView r11 = this.f7443g;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
    L5:
        r11.setText(r10);
    }

    public final void setTitleColor(int r10) {
        OTextView r11 = this.f7443g;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
    L5:
        r11.setTextColor(r10);
    }

    public final void setType(int r10) {
        if (r10 != 0) goto L5;
        LinearLayout r11 = this.f7442c;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
    L27:
        r11.setVisibility(0);
        FrameLayout r12 = this.f7446j;
        if (r12 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L30:
        r12.setVisibility(8);
        setLoadingLayout(0);
        OTextView r13 = null;
        this.f7447k = null;
    L31:
        this.f7448l = r13;
        return;
    L5:
        if (r10 != 1) goto L7;
        LinearLayout r14 = this.f7442c;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
    L19:
        r14.setVisibility(8);
        FrameLayout r15 = this.f7446j;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L22:
        r15.setVisibility(0);
        int r16 = h.o_page_status_vertical_loading_item;
    L23:
        setLoadingLayout(r16);
        this.f7447k = (ODownloadProgressView) findViewById(f.status_loading);
        r13 = (OTextView) findViewById(f.status_loading_result);
        goto L31
    L7:
        if (r10 != 2) goto L33;
        LinearLayout r17 = this.f7442c;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
    L12:
        r17.setVisibility(8);
        FrameLayout r18 = this.f7446j;
        if (r18 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L15:
        r18.setVisibility(0);
        r16 = h.o_page_status_horizontal_loading_item;
        goto L23
    }
}
