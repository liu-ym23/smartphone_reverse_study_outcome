package com.obric.oui.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\rJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\rJ\r\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001a\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\rJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\"\u0010\u0012J\u0017\u0010#\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b#\u0010\u0016J\u0015\u0010$\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b$\u0010\r¨\u0006%"}, d2 = {"Lcom/obric/oui/status/OPageStatus;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setType", "(I)V", "resId", "setLoadingLayout", "Lcom/obric/oui/text/OTextView;", "getTitleView", "()Lcom/obric/oui/text/OTextView;", "", MessageIndication.CONTENT_TYPE_TEXT, "setTitle", "(Ljava/lang/CharSequence;)V", "color", "setTitleColor", "getMessageView", "setMessage", "setMessageColor", "Lcom/obric/oui/button/OButton;", "getButton", "()Lcom/obric/oui/button/OButton;", "Lcom/obric/oui/progress/ODownloadProgressView;", "getLoadingView", "()Lcom/obric/oui/progress/ODownloadProgressView;", "getLoadingResultView", "setLoadingResult", "setLoadingResultColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPageStatus extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f14554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OTextView f14555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f14556c;
    public final OButton d;
    public final FrameLayout e;
    public ODownloadProgressView f;
    public OTextView g;

    @JvmOverloads
    public OPageStatus(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final OButton getButton() {
        OButton r5 = this.d;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("button");
        return null;
    L6:
        return r5;
    }

    public final OTextView getLoadingResultView() {
        return this.g;
    }

    public final ODownloadProgressView getLoadingView() {
        return this.f;
    }

    public final OTextView getMessageView() {
        OTextView r5 = this.f14556c;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        return null;
    L6:
        return r5;
    }

    public final OTextView getTitleView() {
        OTextView r5 = this.f14555b;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    L6:
        return r5;
    }

    public final void setLoadingLayout(int r5) {
        FrameLayout r10 = this.e;
        FrameLayout r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        r10 = null;
    L5:
        r10.removeAllViews();
        if (r5 == 0) goto L16;
        Context r12 = getContext();     // Catch: Exception -> L13
        FrameLayout r13 = this.e;     // Catch: Exception -> L13
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");     // Catch: Exception -> L13
    L11:
        View.inflate(r12, r5, r11);     // Catch: Exception -> L13
        return;
    L10:
        r11 = r13;
    L17:
        return;
    }

    public final void setLoadingResult(CharSequence r5) {
        OTextView r10 = this.g;
        if (r10 == null) goto L7;
        r10.setText(r5);
        return;
    }

    public final void setLoadingResultColor(int r5) {
        OTextView r10 = this.g;
        if (r10 == null) goto L7;
        r10.setTextColor(r5);
        return;
    }

    public final void setMessage(CharSequence r5) {
        OTextView r10 = this.f14556c;
        OTextView r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        r10 = null;
    L5:
        r10.setText(r5);
        OTextView r12 = this.f14556c;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
    L9:
        if (r5 != null) goto L11;
    L14:
        int r13 = 8;
    L15:
        r11.setVisibility(r13);
        return;
    L11:
        if (r5.length() == 0) goto L14;
        r13 = 0;
        goto L15
    L8:
        r11 = r12;
        goto L9
    }

    public final void setMessageColor(int r5) {
        OTextView r10 = this.f14556c;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        r10 = null;
    L5:
        r10.setTextColor(r5);
    }

    public final void setTitle(CharSequence r5) {
        OTextView r10 = this.f14555b;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r10 = null;
    L5:
        r10.setText(r5);
    }

    public final void setTitleColor(int r5) {
        OTextView r10 = this.f14555b;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r10 = null;
    L5:
        r10.setTextColor(r5);
    }

    public final void setType(int r10) {
        FrameLayout r5 = null;
        if (r10 != 0) goto L5;
        LinearLayout r11 = this.f14554a;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r11 = null;
    L28:
        r11.setVisibility(0);
        FrameLayout r12 = this.e;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        r12 = null;
    L31:
        r12.setVisibility(8);
        setLoadingLayout(0);
        this.f = null;
        this.g = null;
        return;
    L5:
        if (r10 != 1) goto L7;
        LinearLayout r13 = this.f14554a;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r13 = null;
    L20:
        r13.setVisibility(8);
        FrameLayout r14 = this.e;
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L24:
        r5.setVisibility(0);
        setLoadingLayout(R$layout.o_page_status_vertical_loading_item);
        this.f = (ODownloadProgressView) findViewById(R$id.status_loading);
        this.g = (OTextView) findViewById(R$id.status_loading_result);
        return;
    L23:
        r5 = r14;
        goto L24
    L7:
        if (r10 != 2) goto L35;
        LinearLayout r15 = this.f14554a;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r15 = null;
    L12:
        r15.setVisibility(8);
        FrameLayout r16 = this.e;
        if (r16 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L16:
        r5.setVisibility(0);
        setLoadingLayout(R$layout.o_page_status_horizontal_loading_item);
        this.f = (ODownloadProgressView) findViewById(R$id.status_loading);
        this.g = (OTextView) findViewById(R$id.status_loading_result);
        return;
    L15:
        r5 = r16;
        goto L16
    }

    @JvmOverloads
    public OPageStatus(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OPageStatus(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OPageStatus(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        LayoutInflater.from(r5).inflate(R$layout.o_page_status_layout, this, true);
        setGravity(1);
        this.f14554a = (LinearLayout) findViewById(R$id.content_container);
        this.f14555b = (OTextView) findViewById(R$id.status_title);
        this.f14556c = (OTextView) findViewById(R$id.status_message);
        this.d = (OButton) findViewById(R$id.status_button);
        this.e = (FrameLayout) findViewById(R$id.loading_container);
        if (r10 == null) goto L36;
        int r12 = 0;
        TypedArray r13 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OPageStatus, 0, 0);
        if (r13.hasValue(R$styleable.OPageStatus_opagestatus_type) == false) goto L8;
        setType(r13.getInt(R$styleable.OPageStatus_opagestatus_type, 0));
    L8:
        if (r13.hasValue(R$styleable.OPageStatus_opagestatus_title) == false) goto L11;
        setTitle(r13.getString(R$styleable.OPageStatus_opagestatus_title));
    L11:
        if (r13.hasValue(R$styleable.OPageStatus_opagestatus_titleColor) == false) goto L14;
        setTitleColor(r13.getColor(R$styleable.OPageStatus_opagestatus_titleColor, R$color.oui_basic_text_3));
    L14:
        if (r13.hasValue(R$styleable.OPageStatus_opagestatus_message) == false) goto L17;
        setMessage(r13.getString(R$styleable.OPageStatus_opagestatus_message));
    L17:
        if (r13.hasValue(R$styleable.OPageStatus_opagestatus_messageColor) == false) goto L20;
        setMessageColor(r13.getColor(R$styleable.OPageStatus_opagestatus_messageColor, R$color.oui_basic_text_3b));
    L20:
        if (r13.hasValue(R$styleable.OPageStatus_opagestatus_showLoading) == false) goto L29;
        boolean r14 = r13.getBoolean(R$styleable.OPageStatus_opagestatus_showLoading, false);
        ODownloadProgressView r15 = this.f;
        if (r15 == null) goto L29;
        if (r14 == true) goto L27;
        r12 = 8;
    L27:
        r15.setVisibility(r12);
    L29:
        if (r13.hasValue(R$styleable.OPageStatus_opagestatus_loadingResult) == false) goto L32;
        setLoadingResult(r13.getString(R$styleable.OPageStatus_opagestatus_loadingResult));
    L32:
        if (r13.hasValue(R$styleable.OPageStatus_opagestatus_loadingResultColor) == false) goto L34;
        setLoadingResultColor(r13.getColor(R$styleable.OPageStatus_opagestatus_loadingResult, R$color.oui_basic_text_3));
    L34:
        r13.recycle();
        return;
    }
}
