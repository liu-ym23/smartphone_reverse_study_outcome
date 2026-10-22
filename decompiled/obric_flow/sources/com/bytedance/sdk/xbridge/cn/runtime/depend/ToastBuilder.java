package com.bytedance.sdk.xbridge.cn.runtime.depend;

import ai.j0;
import android.content.Context;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003JT\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ToastBuilder;", "", "context", "Landroid/content/Context;", "message", "", "type", "duration", "", "icon", "customIcon", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getCustomIcon", "()Ljava/lang/String;", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "getMessage", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ToastBuilder;", "equals", "", "other", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ToastBuilder {
    private final Context context;
    private final String customIcon;
    private final Integer duration;
    private final String icon;
    private final String message;
    private final String type;

    public ToastBuilder(Context r5, String r10, String r11, Integer r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.context = r5;
        this.message = r10;
        this.type = r11;
        this.duration = r12;
        this.icon = r13;
        this.customIcon = r14;
    }

    public static /* synthetic */ ToastBuilder copy$default(ToastBuilder r5, Context r10, String r11, String r12, Integer r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.context;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.message;
    L8:
        String r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.type;
    L11:
        String r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.duration;
    L14:
        Integer r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.icon;
    L17:
        String r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.customIcon;
    L20:
        Context r22 = r10;
        return r5.copy(r22, r18, r19, r20, r21, r15);
    }

    public final Context component1() {
        return this.context;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.type;
    }

    public final Integer component4() {
        return this.duration;
    }

    public final String component5() {
        return this.icon;
    }

    public final String component6() {
        return this.customIcon;
    }

    public final ToastBuilder copy(Context r10, String r11, String r12, Integer r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return new ToastBuilder(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ToastBuilder) == true) goto L8;
        return false;
    L8:
        ToastBuilder r10 = (ToastBuilder) r5;
        if (Intrinsics.areEqual(this.context, r10.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r10.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.duration, r10.duration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.icon, r10.icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.customIcon, r10.customIcon) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getCustomIcon() {
        return this.customIcon;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r5 = this.context.hashCode() * 31;
        String r10 = this.message;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.type;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.duration;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.icon;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.customIcon;
        if (r23 == null) goto L23;
        r11 = r23.hashCode();
    L23:
        return r22 + r11;
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("ToastBuilder(context=");
        r5.append(this.context);
        r5.append(", message=");
        r5.append(this.message);
        r5.append(", type=");
        r5.append(this.type);
        r5.append(", duration=");
        r5.append(this.duration);
        r5.append(", icon=");
        r5.append(this.icon);
        r5.append(", customIcon=");
        return j0.p(r5, this.customIcon, ')');
    }

    public /* synthetic */ ToastBuilder(Context r10, String r11, String r12, Integer r13, String r14, String r15, int r16, DefaultConstructorMarker r17) {
        String r5 = null;
        if ((r16 & 2) == 0) goto L5;
        String r18 = null;
    L7:
        if ((r16 & 4) == 0) goto L9;
        String r19 = "success";
    L11:
        if ((r16 & 8) == 0) goto L13;
        Integer r20 = null;
    L15:
        if ((r16 & 16) == 0) goto L17;
        String r21 = null;
    L19:
        if ((r16 & 32) != 0) goto L22;
        r5 = r15;
    L22:
        this(r10, r18, r19, r20, r21, r5);
        return;
    L17:
        r21 = r14;
        goto L19
    L13:
        r20 = r13;
        goto L15
    L9:
        r19 = r12;
        goto L11
    L5:
        r18 = r11;
        goto L7
    }
}
