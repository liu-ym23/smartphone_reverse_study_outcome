package com.ss.android.lark.intent.export.entity.output;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.File;
import java.io.Serializable;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0015\u001a\u00020\u0004H\u0016J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/SendChat;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "id", "", "createTime", "", "updateTime", "chatName", "avatar", "Ljava/io/File;", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/io/File;)V", "getId", "()Ljava/lang/String;", "getCreateTime", "()J", "getUpdateTime", "getChatName", "getAvatar", "()Ljava/io/File;", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SendChat implements Serializable, Parcelable {
    public static final Parcelable.Creator<SendChat> CREATOR = null;
    private final File avatar;
    private final String chatName;
    private final long createTime;
    private final String id;
    private final long updateTime;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<SendChat> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChat createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new SendChat(r10.readString(), r10.readLong(), r10.readLong(), r10.readString(), (File) r10.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChat createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChat[] newArray(int r1) {
            return new SendChat[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChat[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ SendChat copy$default(SendChat r5, String r6, long r7, long r9, String r11, File r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.id;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.createTime;
    L8:
        long r0 = r7;
        if ((r13 & 4) == 0) goto L11;
        r9 = r5.updateTime;
    L11:
        long r2 = r9;
        if ((r13 & 8) == 0) goto L14;
        r11 = r5.chatName;
    L14:
        String r15 = r11;
        if ((r13 & 16) == 0) goto L17;
        r12 = r5.avatar;
    L17:
        String r8 = r6;
        return r5.copy(r8, r0, r2, r15, r12);
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
        return this.chatName;
    }

    public final File component5() {
        return this.avatar;
    }

    public final SendChat copy(String r10, long r11, long r13, String r15, File r16) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r15, "chatName");
        return new SendChat(r10, r11, r13, r15, r16);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SendChat) == true) goto L8;
        return false;
    L8:
        SendChat r9 = (SendChat) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r9.createTime) goto L15;
        return false;
    L15:
        if (this.updateTime == r9.updateTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.chatName, r9.chatName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.avatar, r9.avatar) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.id.hashCode() * 31;
        long r1 = this.createTime;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.updateTime;
        int r4 = (((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.chatName.hashCode()) * 31;
        File r5 = this.avatar;
        if (r5 != null) goto L5;
        int r6 = 0;
    L7:
        return r4 + r6;
    L5:
        r6 = r5.hashCode();
        goto L7
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.id);
        r3.writeLong(this.createTime);
        r3.writeLong(this.updateTime);
        r3.writeString(this.chatName);
        r3.writeSerializable(this.avatar);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("SendChat(id='");
        r0.append(this.id);
        r0.append("', createTime=");
        r0.append(this.createTime);
        r0.append(", updateTime=");
        r0.append(this.updateTime);
        r0.append(", chatName='");
        r0.append(a.a(this.chatName));
        r0.append("', avatar=");
        File r1 = this.avatar;
        if (r1 == null) goto L5;
        Uri r2 = Uri.fromFile(r1);
    L6:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final File getAvatar() {
        return this.avatar;
    }

    public final String getChatName() {
        return this.chatName;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getId() {
        return this.id;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public SendChat(String r2, long r3, long r5, String r7, File r8) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r7, "chatName");
        this.id = r2;
        this.createTime = r3;
        this.updateTime = r5;
        this.chatName = r7;
        this.avatar = r8;
    }
}
