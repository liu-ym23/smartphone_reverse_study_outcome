package com.obric.aiagent.product.platform.api.notification;

import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/product/platform/api/notification/ToastShowInfo;", "", "type", "", Params.CONTENT, "timestampMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getType", "()Ljava/lang/String;", "getContent", "getTimestampMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ToastShowInfo {
    private final String content;
    private final long timestampMs;
    private final String type;

    public ToastShowInfo(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        this.type = r2;
        this.content = r3;
        this.timestampMs = r4;
    }

    public /* synthetic */ ToastShowInfo(String r1, String r2, long r3, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        this(r1, r2, r3);
    }

    public static /* synthetic */ ToastShowInfo copy$default(ToastShowInfo r0, String r1, String r2, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.timestampMs;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.content;
    }

    public final long component3() {
        return this.timestampMs;
    }

    public final ToastShowInfo copy(String r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        return new ToastShowInfo(r1, r2, r3);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ToastShowInfo.class) == true) goto L8;
        return false;
    L8:
        ToastShowInfo r8 = (ToastShowInfo) ZeusTransformUtils.preCheckCast(r7, ToastShowInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.type, r8.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r8.content) == true) goto L15;
        return false;
    L15:
        if (this.timestampMs == r8.timestampMs) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String r0 = this.type;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.timestampMs);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ToastShowInfo(type=" + this.type + ", content=" + this.content + ", timestampMs=" + this.timestampMs + ')';
    }
}
