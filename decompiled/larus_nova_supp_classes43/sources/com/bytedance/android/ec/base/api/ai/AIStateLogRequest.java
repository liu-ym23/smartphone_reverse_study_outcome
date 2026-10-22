package com.bytedance.android.ec.base.api.ai;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB5\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J=\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AIStateLogRequest;", "", "", "component1", "component2", "component3", "component4", "component5", "appKey", "bizTaskId", "content", "source", "pageId", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getAppKey", "()Ljava/lang/String;", "getBizTaskId", "getContent", "getSource", "getPageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIStateLogRequest {
    public static final a Companion = null;
    public static final String SOURCE_PAGE = "page";
    public static final String SOURCE_USER = "user";
    private final String appKey;
    private final String bizTaskId;
    private final String content;
    private final String pageId;
    private final String source;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ AIStateLogRequest copy$default(AIStateLogRequest r10, String r11, String r12, String r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.appKey;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.bizTaskId;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.content;
    L11:
        String r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.source;
    L14:
        String r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.pageId;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.appKey;
    }

    public final String component2() {
        return this.bizTaskId;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.source;
    }

    public final String component5() {
        return this.pageId;
    }

    public final AIStateLogRequest copy(String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "appKey");
        Intrinsics.checkNotNullParameter(r11, "bizTaskId");
        Intrinsics.checkNotNullParameter(r12, "content");
        Intrinsics.checkNotNullParameter(r13, "source");
        return new AIStateLogRequest(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof AIStateLogRequest) == false) goto L16;
        AIStateLogRequest r11 = (AIStateLogRequest) r10;
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizTaskId, r11.bizTaskId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r11.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.source, r11.source) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.pageId, r11.pageId) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.appKey;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.bizTaskId;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.content;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.source;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.pageId;
        if (r21 == null) goto L22;
        r1 = r21.hashCode();
    L22:
        return r20 + r1;
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "AIStateLogRequest(appKey=" + this.appKey + ", bizTaskId=" + this.bizTaskId + ", content=" + this.content + ", source=" + this.source + ", pageId=" + this.pageId + ")";
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getBizTaskId() {
        return this.bizTaskId;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getSource() {
        return this.source;
    }

    public AIStateLogRequest(String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "appKey");
        Intrinsics.checkNotNullParameter(r11, "bizTaskId");
        Intrinsics.checkNotNullParameter(r12, "content");
        Intrinsics.checkNotNullParameter(r13, "source");
        this.appKey = r10;
        this.bizTaskId = r11;
        this.content = r12;
        this.source = r13;
        this.pageId = r14;
    }

    public /* synthetic */ AIStateLogRequest(String r10, String r11, String r12, String r13, String r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 8) == 0) goto L5;
        r13 = SOURCE_PAGE;
    L5:
        String r17 = r13;
        if ((r15 & 16) == 0) goto L8;
        r14 = null;
    L8:
        this(r10, r11, r12, r17, r14);
    }
}
