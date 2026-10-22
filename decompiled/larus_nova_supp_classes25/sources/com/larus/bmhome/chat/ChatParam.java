package com.larus.bmhome.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010#\u001a\u00020\u0004H\u0016J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jg\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u00102\u001a\u00020(J\u0016\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/ChatParam;", "Landroid/os/Parcelable;", "Lcom/larus/ui/arch/context/external/VData;", "cvsId", "", "botId", "previousPage", "currentPage", "chatType", "useSubscribedColor", "", "fromActivityName", "fromActivityModule", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getCvsId", "()Ljava/lang/String;", "setCvsId", "(Ljava/lang/String;)V", "getBotId", "setBotId", "getPreviousPage", "setPreviousPage", "getCurrentPage", "setCurrentPage", "getChatType", "setChatType", "getUseSubscribedColor", "()Z", "setUseSubscribedColor", "(Z)V", "getFromActivityName", "setFromActivityName", "getFromActivityModule", "setFromActivityModule", "toString", "equals", "other", "", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatParam implements Parcelable, t1a.c {
    public static final Parcelable.Creator<ChatParam> CREATOR = null;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public String h;

    public static final class a implements Parcelable.Creator<ChatParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatParam createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            String r2 = r11.readString();
            String r3 = r11.readString();
            String r4 = r11.readString();
            String r5 = r11.readString();
            String r6 = r11.readString();
            if (r11.readInt() == 0) goto L5;
            boolean r7 = true;
        L7:
            return new ChatParam(r2, r3, r4, r5, r6, r7, r11.readString(), r11.readString());
        L5:
            r7 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ChatParam[] newArray(int r1) {
            return new ChatParam[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ChatParam() {
        this(null, null, null, null, null, 255);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
        r1.writeString(this.e);
        r1.writeInt(this.f ? 1 : 0);
        r1.writeString(this.g);
        r1.writeString(this.h);
    }

    public final String toString() {
        return "cvsId=" + this.a + ",botId=" + this.b + ",previousPage=" + this.c + ",currentPage=" + this.d;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof ChatParam) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(toString(), ((ChatParam) r2).toString());
    }

    public static ChatParam a(ChatParam r9, String r10, String r11, String r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r10 = r9.a;
    L5:
        String r1 = r10;
        if ((r13 & 2) == 0) goto L8;
        r11 = r9.b;
    L8:
        String r2 = r11;
        if ((r13 & 4) == 0) goto L11;
        String r3 = r9.c;
    L13:
        if ((r13 & 8) == 0) goto L15;
        String r4 = r9.d;
    L17:
        if ((r13 & 16) == 0) goto L19;
        r12 = r9.e;
    L19:
        String r5 = r12;
        if ((r13 & 32) == 0) goto L22;
        boolean r6 = r9.f;
    L24:
        if ((r13 & 64) == 0) goto L26;
        String r7 = r9.g;
    L28:
        if ((r13 & 128) == 0) goto L30;
        String r8 = r9.h;
    L32:
        return new ChatParam(r1, r2, r3, r4, r5, r6, r7, r8);
    L30:
        r8 = null;
        goto L32
    L26:
        r7 = null;
        goto L28
    L22:
        r6 = false;
        goto L24
    L15:
        r4 = null;
        goto L17
    L11:
        r3 = null;
        goto L13
    }

    public /* synthetic */ ChatParam(String r12, String r13, String r14, String r15, String r16, int r17) {
        if ((r17 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r17 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r17 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r17 & 16) == 0) goto L21;
        String r7 = null;
    L22:
        this(r3, r4, r5, r6, r7, false, null, null);
        return;
    L21:
        r7 = r16;
        goto L22
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    public ChatParam(String r1, String r2, String r3, String r4, String r5, boolean r6, String r7, String r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
