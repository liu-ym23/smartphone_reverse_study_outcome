package com.bytedance.ai.widget;

import com.bytedance.ai.model.objects.WidgetInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/widget/m;", "", "", "a", "Ljava/lang/String;", "getMessageId", "()Ljava/lang/String;", "messageId", "c", "getWidgetId", "widgetId", "d", "getContext", "setContext", "(Ljava/lang/String;)V", "context", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("message_id")
    private final String f3075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient String f3076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("widget_id")
    private final String f3077c;

    @SerializedName("context")
    private String d;
    public final transient Integer e;
    public final transient WidgetInfo f;

    public m() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r10 = (m) r5;
        if (Intrinsics.areEqual(this.f3075a, r10.f3075a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3076b, r10.f3076b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f3077c, r10.f3077c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f3075a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f3076b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f3077c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.e;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        WidgetInfo r25 = this.f;
        if (r25 == null) goto L27;
        r10 = r25.hashCode();
    L27:
        return r24 + r10;
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        return "InnerWidgetContext(messageId=" + this.f3075a + ", sectionId=" + this.f3076b + ", widgetId=" + this.f3077c + ", context=" + this.d + ", position=" + this.e + ", widgetInfo=" + this.f + ')';
    }

    public m(String r5, String r10, String r11, String r12, Integer r13, WidgetInfo r14) {
        this.f3075a = r5;
        this.f3076b = r10;
        this.f3077c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
