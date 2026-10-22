package com.larus.profile.impl.creation;

import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(UserCreation r13, gs9.b r14) {
        if (r13 != null) goto L4;
        return;
    L4:
        String r0 = r13.a;
        String r1 = zp9.d.d(r13);
        String r2 = zp9.d.b(r13);
        AuthorInfo r3 = r13.g;
        if (r3 == null) goto L7;
        String r4 = r3.b;
    L8:
        UserCreationTrackParams r15 = r13.n;
        if (r15 == null) goto L11;
        Integer r5 = r15.c;
    L12:
        if (r15 == null) goto L14;
        Integer r6 = r15.b;
    L15:
        if (r15 == null) goto L17;
        String r7 = r15.a;
    L18:
        if (r14 == null) goto L20;
        String r8 = r14.b;
    L21:
        if (r15 == null) goto L23;
        String r12 = r15.g;
    L24:
        if (r15 == null) goto L26;
        String r9 = r15.d;
    L27:
        if (r15 == null) goto L29;
        String r11 = r15.e;
    L30:
        if (r15 == null) goto L32;
        String r10 = r15.f;
    L33:
        tx9.u3.d(r0, r1, r2, r4, r5, r6, "detail_click", r7, r8, r9, r10, r11, r12);
        return;
    L32:
        r10 = null;
        goto L33
    L29:
        r11 = null;
        goto L30
    L26:
        r9 = null;
        goto L27
    L23:
        r12 = null;
        goto L24
    L20:
        r8 = null;
        goto L21
    L17:
        r7 = null;
        goto L18
    L14:
        r6 = null;
        goto L15
    L11:
        r5 = null;
        goto L12
    L7:
        r4 = null;
        goto L8
    }

    public static void b(UserCreation r26, gs9.b r27, String r28) {
        if (r26 != null) goto L5;
        return;
    L5:
        String r2 = r26.a;
        String r3 = zp9.d.d(r26);
        String r5 = zp9.d.b(r26);
        AuthorInfo r4 = r26.g;
        if (r4 == null) goto L8;
        String r8 = r4.b;
    L9:
        UserCreationTrackParams r6 = r26.n;
        if (r6 == null) goto L12;
        Integer r9 = r6.c;
    L13:
        if (r6 == null) goto L15;
        Integer r10 = r6.b;
    L16:
        if (r6 == null) goto L18;
        String r11 = r6.a;
    L19:
        if (r27 == null) goto L24;
        String r7 = r27.g;
        if (r7 == null) goto L24;
        String r12 = r7;
    L27:
        if (r6 == null) goto L29;
        String r13 = r6.g;
    L30:
        if (r6 == null) goto L32;
        String r18 = r6.d;
    L33:
        if (r6 == null) goto L35;
        String r24 = r6.e;
    L36:
        if (r6 == null) goto L38;
        String r25 = r6.f;
    L39:
        tx9.u3.e(r2, r3, r5, r8, null, r9, r10, "detail_click", r11, r12, r18, r25, r24, r13, null, null, null, null, r28, r26.i, null, null, null, 32751632);
        return;
    L38:
        r25 = null;
        goto L39
    L35:
        r24 = null;
        goto L36
    L32:
        r18 = null;
        goto L33
    L29:
        r13 = null;
    L24:
        if (r27 == null) goto L26;
        r12 = r27.b;
        goto L27
    L26:
        r12 = null;
        goto L27
    L18:
        r11 = null;
        goto L19
    L15:
        r10 = null;
        goto L16
    L12:
        r9 = null;
        goto L13
    L8:
        r8 = null;
        goto L9
    }
}
