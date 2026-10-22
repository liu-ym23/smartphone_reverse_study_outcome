package com.ss.android.lark.forwardv3.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010%\u001a\u00020\u001bJ\u0006\u0010&\u001a\u00020\u001bJ\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006-"}, d2 = {"Lcom/ss/android/lark/forwardv3/data/ForwardTargetGroupChatInfo;", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "chatMode", "Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "getChatMode", "()Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "setChatMode", "(Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;)V", "chatDisplayModeSetting", "Lcom/ss/android/lark/chat/entity/chat/ChatDisplayModeSetting;", "getChatDisplayModeSetting", "()Lcom/ss/android/lark/chat/entity/chat/ChatDisplayModeSetting;", "setChatDisplayModeSetting", "(Lcom/ss/android/lark/chat/entity/chat/ChatDisplayModeSetting;)V", "isShield", "", "()Z", "setShield", "(Z)V", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "isThreadGroup", "isChatDisplayModeSetting", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardTargetGroupChatInfo extends ForwardTargetBaseInfoNew {
    public static final b CREATOR = null;
    public int f;
    public Chat.ChatMode g;
    public ChatDisplayModeSetting h;
    public boolean i;
    public String j;

    public static final class a {
        public Chat.ChatMode a;
        public ChatDisplayModeSetting b;
        public boolean c;
        public String d;

        public a() {
            this.a = Chat.ChatMode.UNKNOWN;
            this.b = ChatDisplayModeSetting.UNKNOWN;
            this.d = "";
        }
    }

    public static final class b implements Parcelable.Creator<ForwardTargetGroupChatInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetGroupChatInfo createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            ForwardTargetGroupChatInfo r1 = new ForwardTargetGroupChatInfo();
            r1.a(r4);
            r1.g = Chat.ChatMode.forNumber(r4.readInt());
            ChatDisplayModeSetting.a r0 = ChatDisplayModeSetting.Companion;
            int r2 = r4.readInt();
            r0.getClass();
            r1.h = ChatDisplayModeSetting.a.a(r2);
            if (r4.readByte() == 0) goto L5;
            boolean r3 = true;
        L6:
            r1.i = r3;
            String r5 = r4.readString();
            if (r5 != null) goto L9;
            r5 = "";
        L9:
            r1.j = r5;
            return r1;
        L5:
            r3 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetGroupChatInfo[] newArray(int r1) {
            return new ForwardTargetGroupChatInfo[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardTargetGroupChatInfo() {
        this.f = 1;
        this.g = Chat.ChatMode.UNKNOWN;
        this.h = ChatDisplayModeSetting.UNKNOWN;
        this.j = "";
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew
    public int getType() {
        return this.f;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew
    public final void b(int r1) {
        this.f = r1;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeInt(this.g.getNumber());
        r2.writeInt(this.h.getNumber());
        r2.writeByte(this.i ? 1 : 0);
        r2.writeString(this.j);
    }
}
