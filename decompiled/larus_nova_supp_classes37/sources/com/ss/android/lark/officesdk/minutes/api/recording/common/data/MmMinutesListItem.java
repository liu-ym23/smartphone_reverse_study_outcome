package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000f¨\u0006#"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmMinutesListItem;", "Ljava/io/Serializable;", "topic", "", "duration", "", "status", "", "url", "createTime", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "getTopic", "()Ljava/lang/String;", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "getCreateTime", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmMinutesListItem;", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmMinutesListItem implements Serializable {
    private final Long createTime;
    private final Long duration;
    private final Integer status;
    private final String topic;
    private final String url;

    public static /* synthetic */ MmMinutesListItem copy$default(MmMinutesListItem r3, String r4, Long r5, Integer r6, String r7, Long r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.topic;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.duration;
    L8:
        Long r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.status;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.url;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.createTime;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.topic;
    }

    public final Long component2() {
        return this.duration;
    }

    public final Integer component3() {
        return this.status;
    }

    public final String component4() {
        return this.url;
    }

    public final Long component5() {
        return this.createTime;
    }

    public final MmMinutesListItem copy(String r8, Long r9, Integer r10, String r11, Long r12) {
        return new MmMinutesListItem(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmMinutesListItem) == true) goto L8;
        return false;
    L8:
        MmMinutesListItem r6 = (MmMinutesListItem) r5;
        if (Intrinsics.areEqual(this.topic, r6.topic) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.topic;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.duration;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.status;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.url;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.createTime;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MmMinutesListItem(topic=" + this.topic + ", duration=" + this.duration + ", status=" + this.status + ", url=" + this.url + ", createTime=" + this.createTime + ')';
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final String getUrl() {
        return this.url;
    }

    public MmMinutesListItem(String r1, Long r2, Integer r3, String r4, Long r5) {
        this.topic = r1;
        this.duration = r2;
        this.status = r3;
        this.url = r4;
        this.createTime = r5;
    }
}
