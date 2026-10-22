package com.bytedance.ai.widget.contianer;

import com.bytedance.ai.widget.models.OAppletWrap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3049c;
    public final String d;
    public final String e;
    public final String f;
    public final Map g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f3050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f3051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f3052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f3053k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f3054l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3055m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final OAppletWrap f3056n;

    public h(String r10, String r11, String r12, String r13, String r14, String r15, Map r16, LinkedHashMap r17, String r18, String r19, Map r110, String r111, String r20, OAppletWrap r21, int r22) {
        if ((r22 & 131072) == 0) goto L5;
        OAppletWrap r5 = null;
    L6:
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "widgetId");
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r14, "messageId");
        this.f3047a = r10;
        this.f3048b = r11;
        this.f3049c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.f3050h = r17;
        this.f3051i = r18;
        this.f3052j = r19;
        this.f3053k = r110;
        this.f3054l = r111;
        this.f3055m = r20;
        this.f3056n = r5;
        return;
    L5:
        r5 = r21;
        goto L6
    }

    public final String a() {
        String r5 = this.f3051i;
        if (r5 == null) goto L9;
        if (r5.length() == 0) goto L9;
        return r5;
    L9:
        return this.e;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L8;
        return false;
    L8:
        h r11 = (h) r10;
        String r5 = r11.f3047a;
        if (Intrinsics.areEqual(this.f3047a, r5) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3048b, r11.f3048b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f3049c, r11.f3049c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(null, null) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f3050h, r11.f3050h) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f3051i, r11.f3051i) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f3052j, r11.f3052j) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(null, null) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f3053k, r11.f3053k) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(null, null) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f3054l, r11.f3054l) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f3055m, r11.f3055m) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(null, null) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f3056n, r11.f3056n) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r5 = kk.a.b(this.f3048b, this.f3047a.hashCode() * 31, 31);
        int r10 = 0;
        String r11 = this.f3049c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = kk.a.b(this.e, kk.a.b(this.d, (r5 + r12) * 31, 31), 31);
        String r14 = this.f;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 961;
        Map r17 = this.g;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (this.f3050h.hashCode() + ((r16 + r18) * 31)) * 31;
        String r20 = this.f3051i;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.f3052j;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 961;
        Map r26 = this.f3053k;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 961;
        String r29 = this.f3054l;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.f3055m;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 961;
        OAppletWrap r35 = this.f3056n;
        if (r35 == null) goto L39;
        r10 = r35.hashCode();
    L39:
        return r34 + r10;
    L33:
        r33 = r32.hashCode();
        goto L34
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
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
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "WidgetContainerData(packageName=" + this.f3047a + ", widgetId=" + this.f3048b + ", widgetData=" + this.f3049c + ", botId=" + this.d + ", messageId=" + this.e + ", sectionId=" + this.f + ", replyId=null, ext=" + this.g + ", params=" + this.f3050h + ", mixtureCardId=" + this.f3051i + ", conversationId=" + this.f3052j + ", liteTemplateUrl=null, globalProps=" + this.f3053k + ", extra=null, mcpName=" + this.f3054l + ", fullScreenRefresh=" + this.f3055m + ", isLongClickable=null, oAppletWrap=" + this.f3056n + ')';
    }
}
