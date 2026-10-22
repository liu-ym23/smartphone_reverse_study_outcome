package com.ss.android.lark.intent.export.entity.input;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "chatId", "", "chatterId", "type", "Lcom/ss/android/lark/intent/export/entity/input/SendChatInfoType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/SendChatInfoType;)V", "getChatId", "()Ljava/lang/String;", "getChatterId", "getType", "()Lcom/ss/android/lark/intent/export/entity/input/SendChatInfoType;", "toString", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SendChatInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<SendChatInfo> CREATOR = null;
    private final String chatId;
    private final String chatterId;
    private final SendChatInfoType type;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<SendChatInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChatInfo createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            return new SendChatInfo(r4.readString(), r4.readString(), SendChatInfoType.valueOf(r4.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChatInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChatInfo[] newArray(int r1) {
            return new SendChatInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChatInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ SendChatInfo copy$default(SendChatInfo r0, String r1, String r2, SendChatInfoType r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.chatId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.chatterId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.type;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.chatId;
    }

    public final String component2() {
        return this.chatterId;
    }

    public final SendChatInfoType component3() {
        return this.type;
    }

    public final SendChatInfo copy(String r2, String r3, SendChatInfoType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        return new SendChatInfo(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendChatInfo) == true) goto L8;
        return false;
    L8:
        SendChatInfo r6 = (SendChatInfo) r5;
        if (Intrinsics.areEqual(this.chatId, r6.chatId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterId, r6.chatterId) == true) goto L15;
        return false;
    L15:
        if (this.type == r6.type) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.chatId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.chatterId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.type.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.chatId);
        r1.writeString(this.chatterId);
        r1.writeString(this.type.name());
    }

    public String toString() {
        return "SendChatInfo(chatId=" + this.chatId + ", chatterId=" + this.chatterId + ", type=" + this.type + ')';
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final String getChatterId() {
        return this.chatterId;
    }

    public final SendChatInfoType getType() {
        return this.type;
    }

    public SendChatInfo(String r2, String r3, SendChatInfoType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        this.chatId = r2;
        this.chatterId = r3;
        this.type = r4;
    }
}
