package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.TimeTransformAdapter;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m9a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002./BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u00020\tH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JQ\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0006\u0010#\u001a\u00020\u0003J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u00060"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OAppAction;", "Landroid/os/Parcelable;", "appType", "", "messageId", "", "questionId", "createTime", "content", "", "messageType", "timeoutMs", "<init>", "(IJJJLjava/lang/String;II)V", "getAppType", "()I", "getMessageId", "()J", "getQuestionId", "getCreateTime", "getContent", "()Ljava/lang/String;", "getMessageType", "getTimeoutMs", "getMpParams", "Lcom/obric/aiagent/assistant/idl/bean/OAppAction$OMpParams;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "OMpParams", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class OAppAction implements Parcelable {
    public static final Parcelable.Creator<OAppAction> CREATOR = null;
    public static final a Companion = null;
    public static final int MESSAGE_TYPE_ACK = 2;
    public static final int MESSAGE_TYPE_MSG = 1;
    private static final Lazy<Gson> gson$delegate = null;

    @SerializedName("app_type")
    private final int appType;

    @SerializedName("content")
    private final String content;

    @SerializedName("create_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private final long createTime;

    @SerializedName("message_id")
    private final long messageId;

    @SerializedName("message_type")
    private final int messageType;

    @SerializedName("question_id")
    private final long questionId;

    @SerializedName("timeout_ms")
    private final int timeoutMs;

    public OAppAction() {
        this(0, 0, 0, 0, null, 0, 0, 127, null);
    }

    public static /* synthetic */ Gson a() {
        return gson_delegate$lambda$0();
    }

    public static /* synthetic */ OAppAction copy$default(OAppAction r11, int r12, long r13, long r15, long r17, String r19, int r20, int r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        int r1 = r11.appType;
    L7:
        if ((r22 & 2) == 0) goto L9;
        long r2 = r11.messageId;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r4 = r11.questionId;
    L15:
        if ((r22 & 8) == 0) goto L17;
        long r6 = r11.createTime;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r8 = r11.content;
    L23:
        if ((r22 & 32) == 0) goto L25;
        int r9 = r11.messageType;
    L27:
        if ((r22 & 64) == 0) goto L29;
        int r10 = r11.timeoutMs;
    L31:
        return r11.copy(r1, r2, r4, r6, r8, r9, r10);
    L29:
        r10 = r21;
        goto L31
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r2 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public final int component1() {
        return this.appType;
    }

    public final long component2() {
        return this.messageId;
    }

    public final long component3() {
        return this.questionId;
    }

    public final long component4() {
        return this.createTime;
    }

    public final String component5() {
        return this.content;
    }

    public final int component6() {
        return this.messageType;
    }

    public final int component7() {
        return this.timeoutMs;
    }

    public final OAppAction copy(int r13, long r14, long r16, long r18, String r20, int r21, int r22) {
        return new OAppAction(r13, r14, r16, r18, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof OAppAction) == true) goto L8;
        return false;
    L8:
        OAppAction r9 = (OAppAction) r8;
        if (this.appType == r9.appType) goto L12;
        return false;
    L12:
        if (this.messageId == r9.messageId) goto L15;
        return false;
    L15:
        if (this.questionId == r9.questionId) goto L18;
        return false;
    L18:
        if (this.createTime == r9.createTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r9.content) == true) goto L24;
        return false;
    L24:
        if (this.messageType == r9.messageType) goto L27;
        return false;
    L27:
        if (this.timeoutMs == r9.timeoutMs) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = this.appType * 31;
        long r1 = this.messageId;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.questionId;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.createTime;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.content;
        if (r7 != null) goto L5;
        int r8 = 0;
    L7:
        return ((((r6 + r8) * 31) + this.messageType) * 31) + this.timeoutMs;
    L5:
        r8 = r7.hashCode();
        goto L7
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.appType);
        r3.writeLong(this.messageId);
        r3.writeLong(this.questionId);
        r3.writeLong(this.createTime);
        r3.writeString(this.content);
        r3.writeInt(this.messageType);
        r3.writeInt(this.timeoutMs);
    }

    static {
        Companion = new a();
        CREATOR = new b();
        gson$delegate = LazyKt.lazy(new a());
    }

    private static final Gson gson_delegate$lambda$0() {
        return new Gson();
    }

    public final c getMpParams() {
        String r0 = this.content;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        Companion.getClass();
        return (c) GsonProtectorUtils.fromJson((Gson) access$getGson$delegate$cp().getValue(), this.content, c.class);
    L11:
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public String toString() {
        return "[appType=" + this.appType + ". messageId=" + this.messageId + ", questionId=" + this.questionId + ". createTime=" + this.createTime + "messageType=" + this.messageType + ", timeoutMs=" + this.timeoutMs + ". content=" + this.content + ". ]";
    }

    public static final /* synthetic */ Lazy access$getGson$delegate$cp() {
        return gson$delegate;
    }

    public final int getAppType() {
        return this.appType;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public final int getTimeoutMs() {
        return this.timeoutMs;
    }

    public OAppAction(int r1, long r2, long r4, long r6, String r8, int r9, int r10) {
        this.appType = r1;
        this.messageId = r2;
        this.questionId = r4;
        this.createTime = r6;
        this.content = r8;
        this.messageType = r9;
        this.timeoutMs = r10;
    }

    public /* synthetic */ OAppAction(int r11, long r12, long r14, long r16, String r18, int r19, int r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 1) == 0) goto L5;
        int r0 = -1;
    L6:
        long r2 = -1;
        if ((r21 & 2) == 0) goto L9;
        long r4 = -1;
    L11:
        if ((r21 & 4) != 0) goto L15;
        r2 = r14;
    L15:
        if ((r21 & 8) == 0) goto L17;
        long r6 = System.currentTimeMillis();
    L19:
        if ((r21 & 16) == 0) goto L21;
        String r1 = "";
    L23:
        if ((r21 & 32) == 0) goto L25;
        int r8 = 1;
    L27:
        if ((r21 & 64) == 0) goto L29;
        int r9 = 0;
    L30:
        this(r0, r4, r2, r6, r1, r8, r9);
        return;
    L29:
        r9 = r20;
        goto L30
    L25:
        r8 = r19;
        goto L27
    L21:
        r1 = r18;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L9:
        r4 = r12;
        goto L11
    L5:
        r0 = r11;
        goto L6
    }
}
