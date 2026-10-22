package com.bytedance.android.live.revlink.widgetservice;

import com.bytedance.android.livesdk.link.model.a6;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sc0.b;
import sc0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkAudienceLaunchParam {
    public static final /* synthetic */ int i = 0;
    public final int a;
    public final long b;
    public final Function0<Integer> c;
    public final Function0<Integer> d;
    public final a6 e;
    public final String f;
    public final b g;
    public final d h;

    public static final class Companion {
        public static RevLinkAudienceLaunchParam a(int r10, long r12) {
            return new RevLinkAudienceLaunchParam(r10, r12, RevLinkAudienceLaunchParam$Companion$genMergeSceneSwitchParam$1.INSTANCE, RevLinkAudienceLaunchParam$Companion$genMergeSceneSwitchParam$2.INSTANCE, null, null, 240);
        }
    }

    static {
    }

    public RevLinkAudienceLaunchParam() {
        throw null;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof RevLinkAudienceLaunchParam) == false) goto L22;
        RevLinkAudienceLaunchParam r7 = (RevLinkAudienceLaunchParam) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Function0<Integer> r3 = this.c;
        int r4 = 0;
        if (r3 == null) goto L5;
        int r5 = r3.hashCode();
    L6:
        int r6 = (r2 + r5) * 31;
        Function0<Integer> r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        a6 r10 = this.e;
        if (r10 == null) goto L13;
        int r12 = r10.hashCode();
    L14:
        int r13 = (r9 + r12) * 31;
        String r14 = this.f;
        if (r14 == null) goto L17;
        int r15 = r14.hashCode();
    L18:
        int r16 = (r13 + r15) * 31;
        b r17 = this.g;
        if (r17 == null) goto L21;
        int r18 = r17.hashCode();
    L22:
        int r19 = (r16 + r18) * 31;
        d r20 = this.h;
        if (r20 == null) goto L26;
        r4 = r20.hashCode();
    L26:
        return r19 + r4;
    L21:
        r18 = 0;
        goto L22
    L17:
        r15 = 0;
        goto L18
    L13:
        r12 = 0;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    public final String toString() {
        return "RevLinkAudienceLaunchParam(scene=" + this.a + ", channelID=" + this.b + ", containerWidth=" + this.c + ", containerHeight=" + this.d + ", enterContent=" + this.e + ", guestUID=" + this.f + ", multiLinkAudienceSwitchContext=" + this.g + ", pkAudienceSwitchContext=" + this.h + ")";
    }

    public RevLinkAudienceLaunchParam(int r3, long r4, Function0 r6, Function0 r7, a6 r8, com.bytedance.android.live.revlink.impl.control.launchcontext.b r9, int r10) {
        if ((r10 & 4) == 0) goto L6;
        r6 = AnonymousClass1.INSTANCE;
    L6:
        if ((r10 & 8) == 0) goto L9;
        r7 = AnonymousClass2.INSTANCE;
    L9:
        if ((r10 & 16) == 0) goto L12;
        r8 = null;
    L12:
        if ((r10 & 64) == 0) goto L14;
        r9 = null;
    L14:
        Intrinsics.checkNotNullParameter(r6, "containerWidth");
        Intrinsics.checkNotNullParameter(r7, "containerHeight");
        this.a = r3;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = null;
        this.g = r9;
        this.h = null;
    }
}
