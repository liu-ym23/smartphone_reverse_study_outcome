package com.obric.assistant.cocreationreview;

import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b5 {
    public final String a;
    public final String b;
    public final FeedbackMediaType c;
    public final String d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final FeedbackMediaUploadState h;
    public final int i;
    public final String j;
    public final String k;
    public final String l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b5) == true) goto L8;
        return false;
    L8:
        b5 r9 = (b5) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
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
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        int r3 = 1231;
        if (this.f == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (r2 + r4) * 31;
        if (this.g == true) goto L10;
        r3 = 1237;
    L10:
        int r6 = (((((r5 + r3) * 31) + this.h.hashCode()) * 31) + this.i) * 31;
        String r7 = this.j;
        int r8 = 0;
        if (r7 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r6 + r9) * 31;
        String r11 = this.k;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.l;
        if (r14 == null) goto L23;
        r8 = r14.hashCode();
    L23:
        return r13 + r8;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r7.hashCode();
        goto L14
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "FeedbackMediaDraft(id=" + this.a + ", uri=" + this.b + ", type=" + this.c + ", displayName=" + this.d + ", durationMillis=" + this.e + ", isMarked=" + this.f + ", isCropped=" + this.g + ", uploadState=" + this.h + ", uploadProgress=" + this.i + ", uploadIdentifier=" + this.j + ", remoteUri=" + this.k + ", uploadError=" + this.l + ')';
    }

    public final FeedbackMediaType getType() {
        return this.c;
    }

    public /* synthetic */ b5(String r17, String r18, FeedbackMediaType r19, String r20, long r21, FeedbackMediaUploadState r23, int r24, String r25, int r26) {
        if ((r26 & 1) == 0) goto L5;
        String r3 = UUID.randomUUID().toString();
    L7:
        if ((r26 & 16) == 0) goto L9;
        long r7 = 0;
    L11:
        if ((r26 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L13;
        FeedbackMediaUploadState r11 = FeedbackMediaUploadState.READY;
    L15:
        if ((r26 & 256) == 0) goto L17;
        int r12 = 0;
    L19:
        if ((r26 & 1024) == 0) goto L21;
        String r14 = null;
    L22:
        this(r3, r18, r19, r20, r7, false, false, r11, r12, null, r14, null);
        return;
    L21:
        r14 = r25;
        goto L22
    L17:
        r12 = r24;
        goto L19
    L13:
        r11 = r23;
        goto L15
    L9:
        r7 = r21;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }

    public static b5 a(b5 r18, String r19, String r20, boolean r21, boolean r22, FeedbackMediaUploadState r23, int r24, String r25, String r26, String r27, int r28) {
        FeedbackMediaType r3 = null;
        if ((r28 & 1) == 0) goto L5;
        String r5 = r18.a;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r6 = r18.b;
    L11:
        if ((r28 & 4) == 0) goto L13;
        r3 = r18.c;
    L13:
        FeedbackMediaType r7 = r3;
        if ((r28 & 8) == 0) goto L16;
        String r8 = r18.d;
    L18:
        if ((r28 & 16) == 0) goto L20;
        long r2 = r18.e;
    L21:
        long r9 = r2;
        if ((r28 & 32) == 0) goto L24;
        boolean r11 = r18.f;
    L26:
        if ((r28 & 64) == 0) goto L28;
        boolean r12 = r18.g;
    L30:
        if ((r28 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L32;
        FeedbackMediaUploadState r13 = r18.h;
    L34:
        if ((r28 & 256) == 0) goto L36;
        int r14 = r18.i;
    L38:
        if ((r28 & 512) == 0) goto L40;
        String r15 = r18.j;
    L42:
        if ((r28 & 1024) == 0) goto L44;
        String r16 = r18.k;
    L46:
        if ((r28 & 2048) == 0) goto L48;
        String r17 = r18.l;
    L49:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r7, "type");
        Intrinsics.checkNotNullParameter(r8, "displayName");
        Intrinsics.checkNotNullParameter(r13, "uploadState");
        return new b5(r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17);
    L48:
        r17 = r27;
        goto L49
    L44:
        r16 = r26;
        goto L46
    L40:
        r15 = r25;
        goto L42
    L36:
        r14 = r24;
        goto L38
    L32:
        r13 = r23;
        goto L34
    L28:
        r12 = r22;
        goto L30
    L24:
        r11 = r21;
        goto L26
    L20:
        r2 = 0;
        goto L21
    L16:
        r8 = r20;
        goto L18
    L9:
        r6 = r19;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public b5(String r2, String r3, FeedbackMediaType r4, String r5, long r6, boolean r8, boolean r9, FeedbackMediaUploadState r10, int r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "displayName");
        Intrinsics.checkNotNullParameter(r10, "uploadState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
