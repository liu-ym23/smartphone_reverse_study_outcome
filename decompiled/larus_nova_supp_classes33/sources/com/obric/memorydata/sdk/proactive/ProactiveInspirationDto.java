package com.obric.memorydata.sdk.proactive;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001dJb\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u00065"}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveInspirationDto;", "Landroid/os/Parcelable;", "inspirationId", "", "taskId", "recommendId", "recommendStatus", "", "feedbackAction", "userFeedback", "created", "", "feedbackValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/Integer;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getInspirationId", "()Ljava/lang/String;", "getTaskId", "getRecommendId", "getRecommendStatus", "()I", "getFeedbackAction", "getUserFeedback", "getCreated", "()J", "getFeedbackValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "writeToParcel", "", "dest", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/Integer;)Lcom/obric/memorydata/sdk/proactive/ProactiveInspirationDto;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveInspirationDto implements Parcelable {
    public static final a CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final long g;
    public final Integer h;

    public static final class a implements Parcelable.Creator<ProactiveInspirationDto> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveInspirationDto createFromParcel(Parcel r13) {
            Intrinsics.checkNotNullParameter(r13, "parcel");
            Intrinsics.checkNotNullParameter(r13, "parcel");
            String r0 = r13.readString();
            if (r0 != null) goto L5;
            String r2 = "";
        L6:
            String r1 = r13.readString();
            if (r1 != null) goto L9;
            String r3 = "";
        L10:
            String r4 = r13.readString();
            if (r4 != null) goto L13;
            String r5 = "";
        L14:
            int r6 = r13.readInt();
            String r7 = r13.readString();
            if (r7 != null) goto L17;
            String r8 = "";
        L18:
            String r9 = r13.readString();
            long r10 = r13.readLong();
            if (r13.readInt() != 1) goto L21;
            Integer r14 = Integer.valueOf(r13.readInt());
        L23:
            return new ProactiveInspirationDto(r2, r3, r5, r6, r8, r9, r10, r14);
        L21:
            r14 = null;
            goto L23
        L17:
            r8 = r7;
            goto L18
        L13:
            r5 = r4;
            goto L14
        L9:
            r3 = r1;
            goto L10
        L5:
            r2 = r0;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveInspirationDto[] newArray(int r1) {
            return new ProactiveInspirationDto[r1];
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
        if ((r8 instanceof ProactiveInspirationDto) == true) goto L8;
        return false;
    L8:
        ProactiveInspirationDto r9 = (ProactiveInspirationDto) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        long r4 = this.g;
        int r5 = (((r0 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        Integer r6 = this.h;
        if (r6 == null) goto L11;
        r2 = r6.hashCode();
    L11:
        return r5 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProactiveInspirationDto(inspirationId=" + this.a + ", taskId=" + this.b + ", recommendId=" + this.c + ", recommendStatus=" + this.d + ", feedbackAction=" + this.e + ", userFeedback=" + this.f + ", created=" + this.g + ", feedbackValue=" + this.h + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeString(this.c);
        r3.writeInt(this.d);
        r3.writeString(this.e);
        r3.writeString(this.f);
        r3.writeLong(this.g);
        if (this.h == null) goto L5;
        r3.writeInt(1);
        r3.writeInt(this.h.intValue());
        return;
    L5:
        r3.writeInt(0);
    }

    public ProactiveInspirationDto(String r2, String r3, String r4, int r5, String r6, String r7, long r8, Integer r10) {
        Intrinsics.checkNotNullParameter(r2, "inspirationId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "recommendId");
        Intrinsics.checkNotNullParameter(r6, "feedbackAction");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r10;
    }
}
