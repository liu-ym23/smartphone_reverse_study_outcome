package com.larus.contextwindow.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003Jq\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020%HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016¨\u00060"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowMessageSnapshot;", "Landroid/os/Parcelable;", "conversationId", "", "messageId", "logicalIndex", "", "isFromCurrentUser", "", "isAvailable", "isVisible", "isStreaming", "replyId", "contextWindowUsageRaw", "isCompressing", "<init>", "(Ljava/lang/String;Ljava/lang/String;JZZZZLjava/lang/String;Ljava/lang/String;Z)V", "getConversationId", "()Ljava/lang/String;", "getMessageId", "getLogicalIndex", "()J", "()Z", "getReplyId", "getContextWindowUsageRaw", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowMessageSnapshot implements Parcelable {
    public static final Parcelable.Creator<ContextWindowMessageSnapshot> CREATOR = null;
    public final String a;
    public final String b;
    public final long c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final String i;
    public final boolean j;

    public static final class a implements Parcelable.Creator<ContextWindowMessageSnapshot> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContextWindowMessageSnapshot createFromParcel(Parcel r15) {
            Intrinsics.checkNotNullParameter(r15, "parcel");
            String r2 = r15.readString();
            String r3 = r15.readString();
            long r4 = r15.readLong();
            if (r15.readInt() == 0) goto L5;
            boolean r8 = true;
        L7:
            if (r15.readInt() == 0) goto L9;
            boolean r9 = true;
        L11:
            if (r15.readInt() == 0) goto L13;
            boolean r10 = true;
        L15:
            if (r15.readInt() == 0) goto L17;
            boolean r11 = true;
        L18:
            String r12 = r15.readString();
            String r13 = r15.readString();
            if (r15.readInt() == 0) goto L21;
            boolean r16 = true;
        L23:
            return new ContextWindowMessageSnapshot(r2, r3, r4, r8, r9, r10, r11, r12, r13, r16);
        L21:
            r16 = false;
            goto L23
        L17:
            r11 = false;
            goto L18
        L13:
            r10 = false;
            goto L15
        L9:
            r9 = false;
            goto L11
        L5:
            r8 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ContextWindowMessageSnapshot[] newArray(int r1) {
            return new ContextWindowMessageSnapshot[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ContextWindowMessageSnapshot) == true) goto L8;
        return false;
    L8:
        ContextWindowMessageSnapshot r9 = (ContextWindowMessageSnapshot) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        int r3 = 1231;
        if (this.d == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (r2 + r4) * 31;
        if (this.e == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r5 + r6) * 31;
        if (this.f == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        if (this.g == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        String r12 = this.h;
        int r13 = 0;
        if (r12 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r11 + r14) * 31;
        String r16 = this.i;
        if (r16 == null) goto L26;
        r13 = r16.hashCode();
    L26:
        int r17 = (r15 + r13) * 31;
        if (this.j == true) goto L31;
        r3 = 1237;
    L31:
        return r17 + r3;
    L21:
        r14 = r12.hashCode();
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "ContextWindowMessageSnapshot(conversationId=" + this.a + ", messageId=" + this.b + ", logicalIndex=" + this.c + ", isFromCurrentUser=" + this.d + ", isAvailable=" + this.e + ", isVisible=" + this.f + ", isStreaming=" + this.g + ", replyId=" + this.h + ", contextWindowUsageRaw=" + this.i + ", isCompressing=" + this.j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeLong(this.c);
        r3.writeInt(this.d ? 1 : 0);
        r3.writeInt(this.e ? 1 : 0);
        r3.writeInt(this.f ? 1 : 0);
        r3.writeInt(this.g ? 1 : 0);
        r3.writeString(this.h);
        r3.writeString(this.i);
        r3.writeInt(this.j ? 1 : 0);
    }

    public ContextWindowMessageSnapshot(String r2, String r3, long r4, boolean r6, boolean r7, boolean r8, boolean r9, String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }
}
