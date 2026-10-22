package com.obric.memorydata.sdk.proactive;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 b2\u00020\u0001:\u0001bBÝ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0004\b\u001d\u0010!J\u0018\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020\u0014H\u0016J\b\u0010C\u001a\u00020\u0014H\u0016J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\t\u0010M\u001a\u00020\u000eHÆ\u0003J\t\u0010N\u001a\u00020\u0010HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0014HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00108J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u000eHÆ\u0003J\t\u0010Y\u001a\u00020\u000eHÆ\u0003Jþ\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010[J\u0013\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_HÖ\u0003J\t\u0010`\u001a\u00020\u0014HÖ\u0001J\t\u0010a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010#R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010#R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0011\u0010\u001c\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010.¨\u0006c"}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveRecommendationDto;", "Landroid/os/Parcelable;", "recommendId", "", "taskId", "subscriptionId", "recommendText", "emoji", "actionCondition", "actionExecuteInstruction", "actionContext", "sourcePackages", "", "created", "", "score", "", WindowEvent.Params.REASON, "evidence", "recommendStatus", "", "status", "type", "expireAtMs", "inspirationId", "inspirationFeedbackAction", "inspirationUserFeedback", "inspirationUpdated", "inspirationTimestamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JDLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getRecommendId", "()Ljava/lang/String;", "getTaskId", "getSubscriptionId", "getRecommendText", "getEmoji", "getActionCondition", "getActionExecuteInstruction", "getActionContext", "getSourcePackages", "()Ljava/util/List;", "getCreated", "()J", "getScore", "()D", "getReason", "getEvidence", "getRecommendStatus", "()I", "getStatus", "getType", "getExpireAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInspirationId", "getInspirationFeedbackAction", "getInspirationUserFeedback", "getInspirationUpdated", "getInspirationTimestamp", "writeToParcel", "", "dest", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JDLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)Lcom/obric/memorydata/sdk/proactive/ProactiveRecommendationDto;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveRecommendationDto implements Parcelable {
    public static final a CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final List<String> i;
    public final long j;
    public final double k;
    public final String l;
    public final String m;
    public final int n;
    public final String o;
    public final String p;
    public final Long q;
    public final String r;
    public final String s;
    public final String t;
    public final long u;
    public final long v;

    public static final class a implements Parcelable.Creator<ProactiveRecommendationDto> {
        public a() {
        }

        public static ProactiveRecommendationDto a(Parcel r30) {
            Intrinsics.checkNotNullParameter(r30, "parcel");
            Intrinsics.checkNotNullParameter(r30, "parcel");
            String r1 = r30.readString();
            if (r1 != null) goto L5;
            String r3 = "";
        L6:
            String r2 = r30.readString();
            if (r2 != null) goto L9;
            String r4 = "";
        L10:
            String r5 = r30.readString();
            if (r5 != null) goto L13;
            String r6 = "";
        L14:
            String r7 = r30.readString();
            if (r7 != null) goto L17;
            String r8 = "";
        L18:
            String r9 = r30.readString();
            if (r9 != null) goto L21;
            String r10 = "";
        L22:
            String r11 = r30.readString();
            String r12 = r30.readString();
            String r13 = r30.readString();
            List r14 = r30.createStringArrayList();
            if (r14 != null) goto L25;
            r14 = CollectionsKt.emptyList();
        L25:
            List r15 = r14;
            long r16 = r30.readLong();
            double r17 = r30.readDouble();
            String r18 = r30.readString();
            if (r18 != null) goto L28;
            String r19 = "";
        L29:
            String r110 = r30.readString();
            int r111 = r30.readInt();
            String r20 = r30.readString();
            if (r20 != null) goto L32;
            String r112 = "";
        L33:
            String r21 = r30.readString();
            if (r21 != null) goto L36;
            String r22 = "";
        L37:
            ska.a.a.getClass();
            if (ska.a.a() == true) goto L40;
        L43:
            Long r23 = null;
        L44:
            Long r24 = r23;
            String r25 = r30.readString();
            if (r25 != null) goto L47;
            String r26 = "";
        L49:
            return new ProactiveRecommendationDto(r3, r4, r6, r8, r10, r11, r12, r13, r15, r16, r17, r19, r110, r111, r112, r22, r24, r26, r30.readString(), r30.readString(), r30.readLong(), r30.readLong());
        L47:
            r26 = r25;
            goto L49
        L40:
            if (r30.readInt() == 0) goto L43;
            r23 = Long.valueOf(r30.readLong());
            goto L44
        L36:
            r22 = r21;
            goto L37
        L32:
            r112 = r20;
            goto L33
        L28:
            r19 = r18;
            goto L29
        L21:
            r10 = r9;
            goto L22
        L17:
            r8 = r7;
            goto L18
        L13:
            r6 = r5;
            goto L14
        L9:
            r4 = r2;
            goto L10
        L5:
            r3 = r1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ProactiveRecommendationDto createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveRecommendationDto[] newArray(int r1) {
            return new ProactiveRecommendationDto[r1];
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
        if ((r8 instanceof ProactiveRecommendationDto) == true) goto L8;
        return false;
    L8:
        ProactiveRecommendationDto r9 = (ProactiveRecommendationDto) r8;
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
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (Double.compare(this.k, r9.k) == 0) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r9.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r9.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r9.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r9.t) == true) goto L69;
        return false;
    L69:
        if (this.u == r9.u) goto L72;
        return false;
    L72:
        if (this.v == r9.v) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.h;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.i.hashCode()) * 31;
        long r11 = this.j;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        long r13 = Double.doubleToLongBits(this.k);
        int r14 = (((r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31) + this.l.hashCode()) * 31;
        String r15 = this.m;
        if (r15 != null) goto L17;
        int r16 = 0;
    L18:
        int r17 = (((((((r14 + r16) * 31) + this.n) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31;
        Long r18 = this.q;
        if (r18 != null) goto L21;
        int r19 = 0;
    L22:
        int r20 = (((r17 + r19) * 31) + this.r.hashCode()) * 31;
        String r21 = this.s;
        if (r21 != null) goto L25;
        int r22 = 0;
    L26:
        int r23 = (r20 + r22) * 31;
        String r24 = this.t;
        if (r24 == null) goto L30;
        r2 = r24.hashCode();
    L30:
        int r25 = (r23 + r2) * 31;
        long r26 = this.u;
        int r27 = (r25 + ((int) (r26 ^ (r26 >>> 32)))) * 31;
        long r28 = this.v;
        return r27 + ((int) (r28 ^ (r28 >>> 32)));
    L25:
        r22 = r21.hashCode();
        goto L26
    L21:
        r19 = r18.hashCode();
        goto L22
    L17:
        r16 = r15.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProactiveRecommendationDto(recommendId=" + this.a + ", taskId=" + this.b + ", subscriptionId=" + this.c + ", recommendText=" + this.d + ", emoji=" + this.e + ", actionCondition=" + this.f + ", actionExecuteInstruction=" + this.g + ", actionContext=" + this.h + ", sourcePackages=" + this.i + ", created=" + this.j + ", score=" + this.k + ", reason=" + this.l + ", evidence=" + this.m + ", recommendStatus=" + this.n + ", status=" + this.o + ", type=" + this.p + ", expireAtMs=" + this.q + ", inspirationId=" + this.r + ", inspirationFeedbackAction=" + this.s + ", inspirationUserFeedback=" + this.t + ", inspirationUpdated=" + this.u + ", inspirationTimestamp=" + this.v + ')';
    }

    public final String getType() {
        return this.p;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeString(this.c);
        r3.writeString(this.d);
        r3.writeString(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g);
        r3.writeString(this.h);
        r3.writeStringList(this.i);
        r3.writeLong(this.j);
        r3.writeDouble(this.k);
        r3.writeString(this.l);
        r3.writeString(this.m);
        r3.writeInt(this.n);
        r3.writeString(this.o);
        r3.writeString(this.p);
        ska.a.a.getClass();
        if (ska.a.a() == false) goto L8;
        Long r5 = this.q;
        if (r5 != null) goto L7;
        r3.writeInt(0);
        goto L8
    L7:
        r3.writeInt(1);
        r3.writeLong(r5.longValue());
    L8:
        r3.writeString(this.r);
        r3.writeString(this.s);
        r3.writeString(this.t);
        r3.writeLong(this.u);
        r3.writeLong(this.v);
    }

    public ProactiveRecommendationDto(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, List<String> r21, long r22, double r24, String r26, String r27, int r28, String r29, String r30, Long r31, String r32, String r33, String r34, long r35, long r37) {
        Intrinsics.checkNotNullParameter(r13, "recommendId");
        Intrinsics.checkNotNullParameter(r14, "taskId");
        Intrinsics.checkNotNullParameter(r15, "subscriptionId");
        Intrinsics.checkNotNullParameter(r16, "recommendText");
        Intrinsics.checkNotNullParameter(r17, "emoji");
        Intrinsics.checkNotNullParameter(r21, "sourcePackages");
        Intrinsics.checkNotNullParameter(r26, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r29, "status");
        Intrinsics.checkNotNullParameter(r30, "type");
        Intrinsics.checkNotNullParameter(r32, "inspirationId");
        this.a = r13;
        this.b = r14;
        this.c = r15;
        this.d = r16;
        this.e = r17;
        this.f = r18;
        this.g = r19;
        this.h = r20;
        this.i = r21;
        this.j = r22;
        this.k = r24;
        this.l = r26;
        this.m = r27;
        this.n = r28;
        this.o = r29;
        this.p = r30;
        this.q = r31;
        this.r = r32;
        this.s = r33;
        this.t = r34;
        this.u = r35;
        this.v = r37;
    }
}
