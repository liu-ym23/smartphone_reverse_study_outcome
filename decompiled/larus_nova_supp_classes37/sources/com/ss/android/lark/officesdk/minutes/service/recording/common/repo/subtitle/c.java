package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int g = 0;
    public final String a;
    public final String b;
    public final MmParticipantType c;
    public final MmSubtitleSpeakerType d;
    public final String e;
    public final b f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public c() {
        this("", "", MmParticipantType.UNKNOWN, MmSubtitleSpeakerType.UNKNOWN, "", b.c.a);
    }

    public final String toString() {
        return "MmDisplaySpeaker(userId='" + this.a + "', speakerType=" + this.d + ", name='" + this.e + "', avatar=" + this.f + ')';
    }

    public final String a(Function1<? super String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "numberFormatter");
        String r0 = this.e;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L16;
        Long r2 = StringsKt.toLongOrNull(this.a);
        if (r2 == null) goto L13;
        long r3 = r2.longValue();
        if (r3 <= 0) goto L13;
        String r4 = String.valueOf(r3);
    L15:
        return (String) r6.invoke(r4);
    L13:
        r4 = "1";
        goto L15
    L16:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public final c b(i r12) {
        Intrinsics.checkNotNullParameter(r12, "info");
        b r0 = this.f;
        boolean r2 = false;
        if ((r0 instanceof b.d) == false) goto L5;
    L20:
        b r10 = r0;
        String r1 = this.e;
        if (r1.length() != 0) goto L23;
        r2 = true;
    L23:
        if (r2 == false) goto L25;
        String r9 = r12.f;
    L26:
        String r5 = this.a;
        String r6 = this.b;
        MmParticipantType r7 = this.c;
        MmSubtitleSpeakerType r8 = this.d;
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r6, "deviceId");
        Intrinsics.checkNotNullParameter(r7, "participantType");
        Intrinsics.checkNotNullParameter(r8, "speakerType");
        Intrinsics.checkNotNullParameter(r9, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r10, "avatar");
        return new c(r5, r6, r7, r8, r9, r10);
    L25:
        r9 = r1;
        goto L26
    L5:
        if ((r0 instanceof b.C0046b) == true) goto L20;
        if (r12.g.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        r0 = new b.C0046b(r12.g, r12.a);
        goto L20
    L14:
        if (this.a.length() <= 0) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L19;
        r0 = new b.e(this.a);
        goto L20
    L19:
        r0 = b.c.a;
        goto L20
    L16:
        r4 = false;
        goto L17
    L10:
        r3 = false;
        goto L11
    }

    public c(String r2, String r3, MmParticipantType r4, MmSubtitleSpeakerType r5, String r6, b r7) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "deviceId");
        Intrinsics.checkNotNullParameter(r4, "participantType");
        Intrinsics.checkNotNullParameter(r5, "speakerType");
        Intrinsics.checkNotNullParameter(r6, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r7, "avatar");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
