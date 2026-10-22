package com.bytedance.ai.bridge.service;

import android.content.Context;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003JT\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006$"}, d2 = {"Lcom/bytedance/ai/bridge/service/ToastBuilder;", "", "context", "Landroid/content/Context;", a.KEY_MSG, "", "type", a.KEY_DURATION, "", "icon", "customIcon", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getMessage", "()Ljava/lang/String;", "getType", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "getCustomIcon", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/bridge/service/ToastBuilder;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastBuilder {
    private final Context context;
    private final String customIcon;
    private final Integer duration;
    private final String icon;
    private final String message;
    private final String type;

    public static /* synthetic */ ToastBuilder copy$default(ToastBuilder r10, Context r11, String r12, String r13, Integer r14, String r15, String r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.context;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.message;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.type;
    L11:
        String r0 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.duration;
    L14:
        Integer r1 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.icon;
    L17:
        String r20 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.customIcon;
    L20:
        Context r21 = r11;
        return r10.copy(r21, r19, r0, r1, r20, r16);
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

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ToastBuilder) == true) goto L8;
        return false;
    L8:
        ToastBuilder r11 = (ToastBuilder) r10;
        if (Intrinsics.areEqual(this.context, r11.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r11.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r11.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.duration, r11.duration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.icon, r11.icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.customIcon, r11.customIcon) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.context.hashCode() * 31;
        String r1 = this.message;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.type;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.duration;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.icon;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        String r22 = this.customIcon;
        if (r22 == null) goto L23;
        r10 = r22.hashCode();
    L23:
        return r21 + r10;
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
        r11 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ToastBuilder(context=" + this.context + ", message=" + this.message + ", type=" + this.type + ", duration=" + this.duration + ", icon=" + this.icon + ", customIcon=" + this.customIcon + ')';
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

    public ToastBuilder(Context r10, String r11, String r12, Integer r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.context = r10;
        this.message = r11;
        this.type = r12;
        this.duration = r13;
        this.icon = r14;
        this.customIcon = r15;
    }

    public /* synthetic */ ToastBuilder(Context r10, String r11, String r12, Integer r13, String r14, String r15, int r16, DefaultConstructorMarker r17) {
        String r1 = null;
        if ((r16 & 2) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r16 & 4) == 0) goto L9;
        String r18 = "success";
    L11:
        if ((r16 & 8) == 0) goto L13;
        Integer r19 = null;
    L15:
        if ((r16 & 16) == 0) goto L17;
        String r20 = null;
    L19:
        if ((r16 & 32) != 0) goto L22;
        r1 = r15;
    L22:
        this(r10, r0, r18, r19, r20, r1);
        return;
    L17:
        r20 = r14;
        goto L19
    L13:
        r19 = r13;
        goto L15
    L9:
        r18 = r12;
        goto L11
    L5:
        r0 = r11;
        goto L7
    }
}
