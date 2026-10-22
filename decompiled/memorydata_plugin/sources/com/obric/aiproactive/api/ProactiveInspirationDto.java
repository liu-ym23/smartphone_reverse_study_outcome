package com.obric.aiproactive.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0006\u0010 \u001a\u00020\u0007J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveInspirationDto;", "Landroid/os/Parcelable;", "inspirationId", "", "taskId", "recommendId", "recommendStatus", "", "feedbackAction", "userFeedback", "created", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V", "getInspirationId", "()Ljava/lang/String;", "getTaskId", "getRecommendId", "getRecommendStatus", "()I", "getFeedbackAction", "getUserFeedback", "getCreated", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveInspirationDto implements Parcelable {
    public static final Parcelable.Creator<ProactiveInspirationDto> CREATOR = null;
    private final long created;
    private final String feedbackAction;
    private final String inspirationId;
    private final String recommendId;
    private final int recommendStatus;
    private final String taskId;
    private final String userFeedback;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProactiveInspirationDto> {
        public a() {
        }

        public final ProactiveInspirationDto a(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new ProactiveInspirationDto(r10.readString(), r10.readString(), r10.readString(), r10.readInt(), r10.readString(), r10.readString(), r10.readLong());
        }

        public final ProactiveInspirationDto[] a(int r1) {
            return new ProactiveInspirationDto[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveInspirationDto createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveInspirationDto[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ProactiveInspirationDto(String r2, String r3, String r4, int r5, String r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r2, "inspirationId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "recommendId");
        Intrinsics.checkNotNullParameter(r6, "feedbackAction");
        this.inspirationId = r2;
        this.taskId = r3;
        this.recommendId = r4;
        this.recommendStatus = r5;
        this.feedbackAction = r6;
        this.userFeedback = r7;
        this.created = r8;
    }

    public /* synthetic */ ProactiveInspirationDto(String r11, String r12, String r13, int r14, String r15, String r16, long r17, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 8) == 0) goto L5;
        int r5 = 0;
    L6:
        this(r11, r12, r13, r5, r15, r16, r17);
        return;
    L5:
        r5 = r14;
        goto L6
    }

    public static /* synthetic */ ProactiveInspirationDto copy$default(ProactiveInspirationDto r9, String r10, String r11, String r12, int r13, String r14, String r15, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.inspirationId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.taskId;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r3 = r9.recommendId;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r4 = r9.recommendStatus;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r5 = r9.feedbackAction;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r6 = r9.userFeedback;
    L27:
        if ((r18 & 64) == 0) goto L29;
        long r7 = r9.created;
    L31:
        return r9.copy(r1, r2, r3, r4, r5, r6, r7);
    L29:
        r7 = r16;
        goto L31
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.inspirationId;
    }

    public final String component2() {
        return this.taskId;
    }

    public final String component3() {
        return this.recommendId;
    }

    public final int component4() {
        return this.recommendStatus;
    }

    public final String component5() {
        return this.feedbackAction;
    }

    public final String component6() {
        return this.userFeedback;
    }

    public final long component7() {
        return this.created;
    }

    public final ProactiveInspirationDto copy(String r11, String r12, String r13, int r14, String r15, String r16, long r17) {
        Intrinsics.checkNotNullParameter(r11, "inspirationId");
        Intrinsics.checkNotNullParameter(r12, "taskId");
        Intrinsics.checkNotNullParameter(r13, "recommendId");
        Intrinsics.checkNotNullParameter(r15, "feedbackAction");
        return new ProactiveInspirationDto(r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ProactiveInspirationDto.class) == true) goto L8;
        return false;
    L8:
        ProactiveInspirationDto r8 = (ProactiveInspirationDto) ZeusTransformUtils.preCheckCast(r7, ProactiveInspirationDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.inspirationId, r8.inspirationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r8.taskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.recommendId, r8.recommendId) == true) goto L18;
        return false;
    L18:
        if (this.recommendStatus == r8.recommendStatus) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.feedbackAction, r8.feedbackAction) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userFeedback, r8.userFeedback) == true) goto L27;
        return false;
    L27:
        if (this.created == r8.created) goto L29;
        return false;
    L29:
        return true;
    }

    public final long getCreated() {
        return this.created;
    }

    public final String getFeedbackAction() {
        return this.feedbackAction;
    }

    public final String getInspirationId() {
        return this.inspirationId;
    }

    public final String getRecommendId() {
        return this.recommendId;
    }

    public final int getRecommendStatus() {
        return this.recommendStatus;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getUserFeedback() {
        return this.userFeedback;
    }

    public int hashCode() {
        int r0 = ((((((((this.inspirationId.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.recommendId.hashCode()) * 31) + Integer.hashCode(this.recommendStatus)) * 31) + this.feedbackAction.hashCode()) * 31;
        String r1 = this.userFeedback;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Long.hashCode(this.created);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ProactiveInspirationDto(inspirationId=" + this.inspirationId + ", taskId=" + this.taskId + ", recommendId=" + this.recommendId + ", recommendStatus=" + this.recommendStatus + ", feedbackAction=" + this.feedbackAction + ", userFeedback=" + this.userFeedback + ", created=" + this.created + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.inspirationId);
        r3.writeString(this.taskId);
        r3.writeString(this.recommendId);
        r3.writeInt(this.recommendStatus);
        r3.writeString(this.feedbackAction);
        r3.writeString(this.userFeedback);
        r3.writeLong(this.created);
    }
}
