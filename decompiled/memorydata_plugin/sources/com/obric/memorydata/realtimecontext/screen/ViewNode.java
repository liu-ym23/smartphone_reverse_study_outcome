package com.obric.memorydata.realtimecontext.screen;

import android.graphics.Rect;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u0010J\u0016\u0010&\u001a\u00020'2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003JE\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u000eHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018¨\u00064"}, d2 = {"Lcom/obric/memorydata/realtimecontext/screen/ViewNode;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "rect", "Landroid/graphics/Rect;", "left", "", "top", "width", "height", "<init>", "(Ljava/lang/String;Landroid/graphics/Rect;FFFF)V", "windowWidth", "", "windowHeight", "(Ljava/lang/String;Landroid/graphics/Rect;II)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getLeft", "()F", "setLeft", "(F)V", "getTop", "setTop", "getWidth", "setWidth", "getHeight", "setHeight", "lastSubRect", "getLastSubRect", "setLastSubRect", "rectToFloat", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewNode {
    private transient float height;
    private transient Rect lastSubRect;
    private transient float left;
    private transient Rect rect;
    private String text;
    private transient float top;
    private transient float width;

    public ViewNode(String r2, Rect r3, float r4, float r5, float r6, float r7) {
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r3, "rect");
        this.text = r2;
        this.rect = r3;
        this.left = r4;
        this.top = r5;
        this.width = r6;
        this.height = r7;
    }

    public /* synthetic */ ViewNode(String r8, Rect r9, float r10, float r11, float r12, float r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = new Rect();
    L5:
        Rect r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        float r3 = 0.0f;
    L10:
        if ((r14 & 8) == 0) goto L12;
        float r4 = 0.0f;
    L14:
        if ((r14 & 16) == 0) goto L16;
        float r5 = 0.0f;
    L18:
        if ((r14 & 32) == 0) goto L20;
        float r6 = 0.0f;
    L21:
        this(r8, r2, r3, r4, r5, r6);
        return;
    L20:
        r6 = r13;
        goto L21
    L16:
        r5 = r12;
        goto L18
    L12:
        r4 = r11;
        goto L14
    L8:
        r3 = r10;
        goto L10
    }

    public ViewNode(String r11, Rect r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r12, "rect");
        this(r11, r12, 0.0f, 0.0f, 0.0f, 0.0f, 60, null);
        rectToFloat(r13, r14);
    }

    public static /* synthetic */ ViewNode copy$default(ViewNode r4, String r5, Rect r6, float r7, float r8, float r9, float r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.text;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.rect;
    L8:
        Rect r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.left;
    L11:
        float r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.top;
    L14:
        float r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.width;
    L17:
        float r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.height;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.text;
    }

    public final Rect component2() {
        return this.rect;
    }

    public final float component3() {
        return this.left;
    }

    public final float component4() {
        return this.top;
    }

    public final float component5() {
        return this.width;
    }

    public final float component6() {
        return this.height;
    }

    public final ViewNode copy(String r8, Rect r9, float r10, float r11, float r12, float r13) {
        Intrinsics.checkNotNullParameter(r8, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r9, "rect");
        return new ViewNode(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ViewNode.class) == true) goto L8;
        return false;
    L8:
        ViewNode r6 = (ViewNode) ZeusTransformUtils.preCheckCast(r5, ViewNode.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rect, r6.rect) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.left, r6.left) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.top, r6.top) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.width, r6.width) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.height, r6.height) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public final float getHeight() {
        return this.height;
    }

    public final Rect getLastSubRect() {
        return this.lastSubRect;
    }

    public final float getLeft() {
        return this.left;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final String getText() {
        return this.text;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((this.text.hashCode() * 31) + this.rect.hashCode()) * 31) + Float.hashCode(this.left)) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.width)) * 31) + Float.hashCode(this.height);
    }

    public final void rectToFloat(int r3, int r4) {
        float r5 = r3;
        this.left = (this.rect.left * 1.0f) / r5;
        float r6 = r4;
        this.top = (this.rect.top * 1.0f) / r6;
        this.width = (this.rect.width() * 1.0f) / r5;
        this.height = (this.rect.height() * 1.0f) / r6;
    }

    public final void setHeight(float r1) {
        this.height = r1;
    }

    public final void setLastSubRect(Rect r1) {
        this.lastSubRect = r1;
    }

    public final void setLeft(float r1) {
        this.left = r1;
    }

    public final void setRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rect = r2;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public final void setTop(float r1) {
        this.top = r1;
    }

    public final void setWidth(float r1) {
        this.width = r1;
    }

    public String toString() {
        return "ViewNode(text=" + this.text + ", rect=" + this.rect + ", left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + ')';
    }
}
