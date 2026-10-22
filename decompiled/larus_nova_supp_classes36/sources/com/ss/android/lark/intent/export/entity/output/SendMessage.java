package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0017\u001a\u00020\u0004H\u0016J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u001f\u001a\u00020\nJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006*"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "id", "", "createTime", "", "updateTime", "msg", "position", "", "chatId", "<init>", "(Ljava/lang/String;JJLjava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getCreateTime", "()J", "getUpdateTime", "getMsg", "getPosition", "()I", "getChatId", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SendMessage implements Serializable, Parcelable {
    public static final Parcelable.Creator<SendMessage> CREATOR = null;
    private final String chatId;
    private final long createTime;
    private final String id;
    private final String msg;
    private final int position;
    private final long updateTime;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<SendMessage> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendMessage createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            return new SendMessage(r11.readString(), r11.readLong(), r11.readLong(), r11.readString(), r11.readInt(), r11.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendMessage createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendMessage[] newArray(int r1) {
            return new SendMessage[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendMessage[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ SendMessage copy$default(SendMessage r9, String r10, long r11, long r13, String r15, int r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.id;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r2 = r9.createTime;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r4 = r9.updateTime;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r6 = r9.msg;
    L19:
        if ((r18 & 16) == 0) goto L21;
        int r7 = r9.position;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r8 = r9.chatId;
    L27:
        return r9.copy(r1, r2, r4, r6, r7, r8);
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final long component2() {
        return this.createTime;
    }

    public final long component3() {
        return this.updateTime;
    }

    public final String component4() {
        return this.msg;
    }

    public final int component5() {
        return this.position;
    }

    public final String component6() {
        return this.chatId;
    }

    public final SendMessage copy(String r11, long r12, long r14, String r16, int r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "id");
        return new SendMessage(r11, r12, r14, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SendMessage) == true) goto L8;
        return false;
    L8:
        SendMessage r9 = (SendMessage) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r9.createTime) goto L15;
        return false;
    L15:
        if (this.updateTime == r9.updateTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.msg, r9.msg) == true) goto L21;
        return false;
    L21:
        if (this.position == r9.position) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.chatId, r9.chatId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.id.hashCode() * 31;
        long r1 = this.createTime;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.updateTime;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.msg;
        int r6 = 0;
        if (r5 != null) goto L5;
        int r7 = 0;
    L6:
        int r8 = (((r4 + r7) * 31) + this.position) * 31;
        String r9 = this.chatId;
        if (r9 == null) goto L11;
        r6 = r9.hashCode();
    L11:
        return r8 + r6;
    L5:
        r7 = r5.hashCode();
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.id);
        r3.writeLong(this.createTime);
        r3.writeLong(this.updateTime);
        r3.writeString(this.msg);
        r3.writeInt(this.position);
        r3.writeString(this.chatId);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("SendMessage(id='");
        r0.append(this.id);
        r0.append("', createTime=");
        r0.append(this.createTime);
        r0.append(", updateTime=");
        r0.append(this.updateTime);
        r0.append(", msg=");
        String r1 = this.msg;
        if (r1 == null) goto L5;
        String r2 = a.a(r1);
    L6:
        r0.append(r2);
        r0.append(", position=");
        r0.append(this.position);
        r0.append(", chatId=");
        r0.append(this.chatId);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getPosition() {
        return this.position;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public SendMessage(String r2, long r3, long r5, String r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.id = r2;
        this.createTime = r3;
        this.updateTime = r5;
        this.msg = r7;
        this.position = r8;
        this.chatId = r9;
    }

    public /* synthetic */ SendMessage(String r11, long r12, long r14, String r16, int r17, String r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 16) == 0) goto L5;
        int r8 = -1;
    L6:
        this(r11, r12, r14, r16, r8, r18);
        return;
    L5:
        r8 = r17;
        goto L6
    }
}
