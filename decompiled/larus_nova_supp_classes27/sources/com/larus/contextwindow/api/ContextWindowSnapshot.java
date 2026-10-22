package com.larus.contextwindow.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\t\u00100\u001a\u00020\u0012HÆ\u0003Jy\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012HÆ\u0001J\u0006\u00102\u001a\u00020\fJ\u0013\u00103\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\fHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010%R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010%¨\u0006="}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowSnapshot;", "Landroid/os/Parcelable;", "conversationId", "", "anchorMessageId", "usageMessageId", "parts", "Lcom/larus/contextwindow/api/ContextWindowUsageParts;", "used", "", "total", "totalPercentTenths", "", "usageSource", "Lcom/larus/contextwindow/api/ContextWindowUsageSource;", "totalSource", "Lcom/larus/contextwindow/api/ContextWindowTotalSource;", "isStreaming", "", "isCompressing", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/contextwindow/api/ContextWindowUsageParts;JJILcom/larus/contextwindow/api/ContextWindowUsageSource;Lcom/larus/contextwindow/api/ContextWindowTotalSource;ZZ)V", "getConversationId", "()Ljava/lang/String;", "getAnchorMessageId", "getUsageMessageId", "getParts", "()Lcom/larus/contextwindow/api/ContextWindowUsageParts;", "getUsed", "()J", "getTotal", "getTotalPercentTenths", "()I", "getUsageSource", "()Lcom/larus/contextwindow/api/ContextWindowUsageSource;", "getTotalSource", "()Lcom/larus/contextwindow/api/ContextWindowTotalSource;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowSnapshot implements Parcelable {
    public static final Parcelable.Creator<ContextWindowSnapshot> CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public final ContextWindowUsageParts d;
    public final long e;
    public final long f;
    public final int g;
    public final ContextWindowUsageSource h;
    public final ContextWindowTotalSource i;
    public final boolean j;
    public final boolean k;

    public static final class a implements Parcelable.Creator<ContextWindowSnapshot> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContextWindowSnapshot createFromParcel(Parcel r18) {
            Intrinsics.checkNotNullParameter(r18, "parcel");
            String r3 = r18.readString();
            String r4 = r18.readString();
            String r5 = r18.readString();
            ContextWindowUsageParts r6 = ContextWindowUsageParts.CREATOR.createFromParcel(r18);
            long r7 = r18.readLong();
            long r9 = r18.readLong();
            int r11 = r18.readInt();
            ContextWindowUsageSource r12 = ContextWindowUsageSource.valueOf(r18.readString());
            ContextWindowTotalSource r13 = ContextWindowTotalSource.valueOf(r18.readString());
            boolean r15 = false;
            if (r18.readInt() == 0) goto L5;
            boolean r16 = true;
        L7:
            if (r18.readInt() == 0) goto L10;
            r15 = true;
        L10:
            return new ContextWindowSnapshot(r3, r4, r5, r6, r7, r9, r11, r12, r13, r16, r15);
        L5:
            r16 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ContextWindowSnapshot[] newArray(int r1) {
            return new ContextWindowSnapshot[r1];
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
        if ((r8 instanceof ContextWindowSnapshot) == true) goto L8;
        return false;
    L8:
        ContextWindowSnapshot r9 = (ContextWindowSnapshot) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
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
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r4 = this.e;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.f;
        int r7 = (((((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.g) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        int r8 = 1231;
        if (this.j == false) goto L9;
        int r9 = 1231;
    L10:
        int r10 = (r7 + r9) * 31;
        if (this.k == true) goto L15;
        r8 = 1237;
    L15:
        return r10 + r8;
    L9:
        r9 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContextWindowSnapshot(conversationId=" + this.a + ", anchorMessageId=" + this.b + ", usageMessageId=" + this.c + ", parts=" + this.d + ", used=" + this.e + ", total=" + this.f + ", totalPercentTenths=" + this.g + ", usageSource=" + this.h + ", totalSource=" + this.i + ", isStreaming=" + this.j + ", isCompressing=" + this.k + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeString(this.c);
        this.d.writeToParcel(r3, r4);
        r3.writeLong(this.e);
        r3.writeLong(this.f);
        r3.writeInt(this.g);
        r3.writeString(this.h.name());
        r3.writeString(this.i.name());
        r3.writeInt(this.j ? 1 : 0);
        r3.writeInt(this.k ? 1 : 0);
    }

    public static ContextWindowSnapshot a(ContextWindowSnapshot r14) {
        String r1 = r14.a;
        String r2 = r14.b;
        String r3 = r14.c;
        ContextWindowUsageParts r4 = r14.d;
        long r5 = r14.e;
        long r7 = r14.f;
        int r9 = r14.g;
        ContextWindowUsageSource r10 = r14.h;
        ContextWindowTotalSource r11 = r14.i;
        boolean r12 = r14.j;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r1, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "usageMessageId");
        Intrinsics.checkNotNullParameter(r4, "parts");
        Intrinsics.checkNotNullParameter(r10, "usageSource");
        Intrinsics.checkNotNullParameter(r11, "totalSource");
        return new ContextWindowSnapshot(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, false);
    }

    public ContextWindowSnapshot(String r2, String r3, String r4, ContextWindowUsageParts r5, long r6, long r8, int r10, ContextWindowUsageSource r11, ContextWindowTotalSource r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "usageMessageId");
        Intrinsics.checkNotNullParameter(r5, "parts");
        Intrinsics.checkNotNullParameter(r11, "usageSource");
        Intrinsics.checkNotNullParameter(r12, "totalSource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
    }
}
