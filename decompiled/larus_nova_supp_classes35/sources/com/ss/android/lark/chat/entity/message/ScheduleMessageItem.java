package com.ss.android.lark.chat.entity.message;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0006\u0010\u0011\u001a\u00020\rJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItem;", "Ljava/io/Serializable;", "messageId", BuildConfig.FLAVOR, IPortraitService.TYPE, "Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItemType;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItemType;)V", "getMessageId", "()Ljava/lang/String;", "getType", "()Lcom/ss/android/lark/chat/entity/message/ScheduleMessageItemType;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "toString", "isPreScheduleMessage", "component1", "component2", "copy", "hashCode", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScheduleMessageItem implements Serializable {
    private final String messageId;
    private final ScheduleMessageItemType type;

    public static /* synthetic */ ScheduleMessageItem copy$default(ScheduleMessageItem r0, String r1, ScheduleMessageItemType r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.messageId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.messageId;
    }

    public final ScheduleMessageItemType component2() {
        return this.type;
    }

    public final ScheduleMessageItem copy(String r2, ScheduleMessageItemType r3) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.TYPE);
        return new ScheduleMessageItem(r2, r3);
    }

    public int hashCode() {
        return (this.messageId.hashCode() * 31) + this.type.hashCode();
    }

    public final boolean isPreScheduleMessage() {
        if (this.type != ScheduleMessageItemType.QUASI_SCHEDULE_MESSAGE) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("message id = " + this.messageId);
        r0.append(", type = " + this.type);
        return r0.toString();
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final ScheduleMessageItemType getType() {
        return this.type;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof ScheduleMessageItem) == true) goto L5;
        return false;
    L5:
        ScheduleMessageItem r5 = (ScheduleMessageItem) r4;
        if (Intrinsics.areEqual(this.messageId, r5.messageId) == true) goto L8;
        return false;
    L8:
        if (this.type != r5.type) goto L12;
        return true;
    L12:
        return false;
    }

    public ScheduleMessageItem(String r2, ScheduleMessageItemType r3) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.TYPE);
        this.messageId = r2;
        this.type = r3;
    }
}
