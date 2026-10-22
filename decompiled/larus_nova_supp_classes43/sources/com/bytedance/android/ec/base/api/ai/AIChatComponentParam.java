package com.bytedance.android.ec.base.api.ai;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB5\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J7\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AIChatComponentParam;", "", "", "component1", "", "component2", "component3", "component4", "conversationId", "useMainConv", "enterFrom", "enterMethod", "copy", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getConversationId", "()Ljava/lang/String;", "Z", "getUseMainConv", "()Z", "getEnterFrom", "getEnterMethod", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIChatComponentParam {
    public static final a Companion = null;
    public static final AIChatComponentParam DEFAULT = null;
    private final String conversationId;
    private final String enterFrom;
    private final String enterMethod;
    private final boolean useMainConv;

    public static final class a {
        public a() {
        }
    }

    public AIChatComponentParam() {
        this(null, false, null, null, 15, null);
    }

    public static /* synthetic */ AIChatComponentParam copy$default(AIChatComponentParam r0, String r1, boolean r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.conversationId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.useMainConv;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.enterFrom;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.enterMethod;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final boolean component2() {
        return this.useMainConv;
    }

    public final String component3() {
        return this.enterFrom;
    }

    public final String component4() {
        return this.enterMethod;
    }

    public final AIChatComponentParam copy(String r10, boolean r11, String r12, String r13) {
        return new AIChatComponentParam(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof AIChatComponentParam) == false) goto L14;
        AIChatComponentParam r11 = (AIChatComponentParam) r10;
        if (Intrinsics.areEqual(this.conversationId, r11.conversationId) == true) goto L8;
        return false;
    L8:
        if (this.useMainConv == r11.useMainConv) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterFrom, r11.enterFrom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterMethod, r11.enterMethod) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        String r0 = this.conversationId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        boolean r12 = this.useMainConv;
        ?? r13 = r12;
        if (r12 == false) goto L9;
        r13 = 1;
    L9:
        int r14 = (r11 + r13) * 31;
        String r15 = this.enterFrom;
        if (r15 == null) goto L12;
        int r16 = r15.hashCode();
    L13:
        int r17 = (r14 + r16) * 31;
        String r18 = this.enterMethod;
        if (r18 == null) goto L17;
        r1 = r18.hashCode();
    L17:
        return r17 + r1;
    L12:
        r16 = 0;
        goto L13
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "AIChatComponentParam(conversationId=" + this.conversationId + ", useMainConv=" + this.useMainConv + ", enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ")";
    }

    static {
        Companion = new a();
        DEFAULT = new AIChatComponentParam(null, true, null, null, 13, null);
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final boolean getUseMainConv() {
        return this.useMainConv;
    }

    public AIChatComponentParam(String r1, boolean r10, String r11, String r12) {
        this.conversationId = r1;
        this.useMainConv = r10;
        this.enterFrom = r11;
        this.enterMethod = r12;
    }

    public /* synthetic */ AIChatComponentParam(String r10, boolean r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = true;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
