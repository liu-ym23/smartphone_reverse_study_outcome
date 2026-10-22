package com.larus.bmhome.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0007J\u0013\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/ChatBubbleParams;", "Landroid/os/Parcelable;", "Lcom/larus/ui/arch/context/external/VData;", "enableCompactFragmentWidthChange", "", "enableCompactFragmentForseti", "inBoxMessageMarginStartPx", "", "<init>", "(ZZI)V", "getEnableCompactFragmentWidthChange", "()Z", "setEnableCompactFragmentWidthChange", "(Z)V", "getEnableCompactFragmentForseti", "setEnableCompactFragmentForseti", "getInBoxMessageMarginStartPx", "()I", "setInBoxMessageMarginStartPx", "(I)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatBubbleParams implements Parcelable, t1a.c {
    public static final Parcelable.Creator<ChatBubbleParams> CREATOR = null;
    public final boolean a;
    public final boolean b;
    public final int c;

    public static final class a implements Parcelable.Creator<ChatBubbleParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatBubbleParams createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            boolean r2 = false;
            if (r6.readInt() == 0) goto L5;
            boolean r1 = true;
        L7:
            if (r6.readInt() == 0) goto L10;
            r2 = true;
        L10:
            return new ChatBubbleParams(r1, r2, r6.readInt());
        L5:
            r1 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ChatBubbleParams[] newArray(int r1) {
            return new ChatBubbleParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ChatBubbleParams() {
        this(false, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatBubbleParams) == true) goto L8;
        return false;
    L8:
        ChatBubbleParams r6 = (ChatBubbleParams) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.c;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatBubbleParams(enableCompactFragmentWidthChange=" + this.a + ", enableCompactFragmentForseti=" + this.b + ", inBoxMessageMarginStartPx=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.a ? 1 : 0);
        r1.writeInt(this.b ? 1 : 0);
        r1.writeInt(this.c);
    }

    public /* synthetic */ ChatBubbleParams(boolean r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = false;
    L5:
        this(r2, false, 0);
    }

    public ChatBubbleParams(boolean r1, boolean r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
