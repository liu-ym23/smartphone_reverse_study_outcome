package com.ss.android.lark.chat.preview.entity.component.property;

import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.tangram.base.props.Props;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000bJ\u0006\u0010\"\u001a\u00020\u0011J\u0006\u0010#\u001a\u00020\u000bJ\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ButtonComponentProps;", "Lcom/ss/android/lark/tangram/base/props/Props;", "<init>", "()V", "textSizeSP", BuildConfig.FLAVOR, "getTextSizeSP", "()F", "setTextSizeSP", "(F)V", "textColor", BuildConfig.FLAVOR, "getTextColor", "()I", "setTextColor", "(I)V", "text", BuildConfig.FLAVOR, "textResId", "strokeColor", "getStrokeColor", "setStrokeColor", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "setText", BuildConfig.FLAVOR, "resId", "getText", "getTestResId", "applyToView", "view", "Lcom/larksuite/component/universe_design/button/UDButton;", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonComponentProps extends Props {
    private Drawable drawable;
    private int strokeColor;
    private int strokeWidth;
    private String text;
    private int textColor;
    private int textResId;
    private float textSizeSP;

    public ButtonComponentProps() {
        this.textSizeSP = 18.0f;
        this.textColor = 2131103449;
        this.text = BuildConfig.FLAVOR;
        this.textResId = -1;
        this.strokeColor = -1;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeWidth() {
        return this.strokeWidth;
    }

    public final int getTestResId() {
        return this.textResId;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final float getTextSizeSP() {
        return this.textSizeSP;
    }

    public final void applyToView(UDButton r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.applyToView(r3);
        int r0 = this.textResId;
        if (r0 <= (-1)) goto L5;
        r3.setText(r0);
    L6:
        r3.setTextColor(this.textColor);
        r3.setTextSize(this.textSizeSP);
        r3.setStrokeColor(this.strokeColor);
        r3.setStrokeWidth(this.strokeWidth);
        return;
    L5:
        r3.setText(this.text);
        goto L6
    }

    public final void setDrawable(Drawable r1) {
        this.drawable = r1;
    }

    public final void setStrokeColor(int r1) {
        this.strokeColor = r1;
    }

    public final void setStrokeWidth(int r1) {
        this.strokeWidth = r1;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.text = r2;
        this.textResId = -1;
    }

    public final void setTextColor(int r1) {
        this.textColor = r1;
    }

    public final void setTextSizeSP(float r1) {
        this.textSizeSP = r1;
    }

    public final void setText(int r1) {
        this.textResId = r1;
        this.text = BuildConfig.FLAVOR;
    }
}
