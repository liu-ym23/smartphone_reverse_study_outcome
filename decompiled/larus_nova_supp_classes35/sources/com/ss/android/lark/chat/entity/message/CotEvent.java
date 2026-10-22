package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/CotEvent;", "Ljava/io/Serializable;", "eventId", BuildConfig.FLAVOR, "eventType", "Lcom/ss/android/lark/chat/entity/message/CotEventType;", "content", "timestamp", BuildConfig.FLAVOR, "createdAt", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/CotEventType;Ljava/lang/String;JJ)V", "getEventId", "()Ljava/lang/String;", "getEventType", "()Lcom/ss/android/lark/chat/entity/message/CotEventType;", "getContent", "getTimestamp", "()J", "getCreatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotEvent implements Serializable {
    private final String content;
    private final long createdAt;
    private final String eventId;
    private final CotEventType eventType;
    private final long timestamp;

    public static /* synthetic */ CotEvent copy$default(CotEvent r5, String r6, CotEventType r7, String r8, long r9, long r11, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.eventId;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.eventType;
    L8:
        CotEventType r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.content;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.timestamp;
    L14:
        long r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.createdAt;
    L17:
        String r10 = r6;
        return r5.copy(r10, r15, r0, r1, r11);
    }

    public final String component1() {
        return this.eventId;
    }

    public final CotEventType component2() {
        return this.eventType;
    }

    public final String component3() {
        return this.content;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final long component5() {
        return this.createdAt;
    }

    public final CotEvent copy(String r10, CotEventType r11, String r12, long r13, long r15) {
        Intrinsics.checkNotNullParameter(r10, "eventId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        Intrinsics.checkNotNullParameter(r12, "content");
        return new CotEvent(r10, r11, r12, r13, r15);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CotEvent) == true) goto L8;
        return false;
    L8:
        CotEvent r9 = (CotEvent) r8;
        if (Intrinsics.areEqual(this.eventId, r9.eventId) == true) goto L12;
        return false;
    L12:
        if (this.eventType == r9.eventType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r9.content) == true) goto L18;
        return false;
    L18:
        if (this.timestamp == r9.timestamp) goto L21;
        return false;
    L21:
        if (this.createdAt == r9.createdAt) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.eventId.hashCode() * 31) + this.eventType.hashCode()) * 31) + this.content.hashCode()) * 31;
        long r1 = this.timestamp;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.createdAt;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public String toString() {
        return "CotEvent(eventId=" + this.eventId + ", eventType=" + this.eventType + ", content=" + this.content + ", timestamp=" + this.timestamp + ", createdAt=" + this.createdAt + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final CotEventType getEventType() {
        return this.eventType;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public CotEvent(String r2, CotEventType r3, String r4, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r2, "eventId");
        Intrinsics.checkNotNullParameter(r3, "eventType");
        Intrinsics.checkNotNullParameter(r4, "content");
        this.eventId = r2;
        this.eventType = r3;
        this.content = r4;
        this.timestamp = r5;
        this.createdAt = r7;
    }
}
