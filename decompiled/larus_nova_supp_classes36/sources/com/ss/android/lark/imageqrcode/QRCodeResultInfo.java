package com.ss.android.lark.imageqrcode;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/ss/android/lark/imageqrcode/QRCodeResultInfo;", "Ljava/io/Serializable;", "content", "", "left", "", "top", "right", "bottom", "codeType", "", "<init>", "(Ljava/lang/String;FFFFI)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getLeft", "()F", "setLeft", "(F)V", "getTop", "setTop", "getRight", "setRight", "getBottom", "setBottom", "getCodeType", "()I", "setCodeType", "(I)V", "toString", "isEmpty", "", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class QRCodeResultInfo implements Serializable {
    private float bottom;
    private int codeType;
    private String content;
    private float left;
    private float right;
    private float top;

    public QRCodeResultInfo() {
        this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0, 63, null);
    }

    public final boolean isEmpty() {
        if (this.content.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (this.right > this.left) goto L10;
        return true;
    L10:
        if (this.bottom <= this.top) goto L16;
        return false;
    L16:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public String toString() {
        return "content:" + this.content + ",left:" + this.left + ",top:" + this.top + ",right" + this.right + ",bottom:" + this.bottom + ",codeType:" + this.codeType;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final int getCodeType() {
        return this.codeType;
    }

    public final String getContent() {
        return this.content;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public final void setBottom(float r1) {
        this.bottom = r1;
    }

    public final void setCodeType(int r1) {
        this.codeType = r1;
    }

    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setLeft(float r1) {
        this.left = r1;
    }

    public final void setRight(float r1) {
        this.right = r1;
    }

    public final void setTop(float r1) {
        this.top = r1;
    }

    public QRCodeResultInfo(String r2, float r3, float r4, float r5, float r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.content = r2;
        this.left = r3;
        this.top = r4;
        this.right = r5;
        this.bottom = r6;
        this.codeType = r7;
    }

    public /* synthetic */ QRCodeResultInfo(String r5, float r6, float r7, float r8, float r9, int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = "";
    L5:
        float r0 = 0.0f;
        if ((r11 & 2) == 0) goto L8;
        float r13 = 0.0f;
    L10:
        if ((r11 & 4) == 0) goto L12;
        float r1 = 0.0f;
    L14:
        if ((r11 & 8) == 0) goto L16;
        float r2 = 0.0f;
    L18:
        if ((r11 & 16) != 0) goto L22;
        r0 = r9;
    L22:
        if ((r11 & 32) == 0) goto L24;
        int r3 = 0;
    L25:
        this(r5, r13, r1, r2, r0, r3);
        return;
    L24:
        r3 = r10;
        goto L25
    L16:
        r2 = r8;
        goto L18
    L12:
        r1 = r7;
        goto L14
    L8:
        r13 = r6;
        goto L10
    }
}
