package com.ss.android.lark.keyboard.biz.mention;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static volatile String a;
    public static final Object b = null;

    public f() {
    }

    static {
        b = new Object();
    }

    public static void a(hob.c r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "chatterId");
        if (r5.i == false) goto L6;
        r5.j = true;
        return;
    L6:
        boolean r2 = false;
        if (r6.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return;
    L12:
        Intrinsics.checkNotNullParameter(r6, "chatterId");
        String r1 = a;
        if (r1 != null) goto L30;
        Object r3 = b;
        monitor-enter(r3);
        String r4 = a;     // Catch: Throwable -> L40
        if (r4 == null) goto L21;
        monitor-exit(r3);
    L20:
        r1 = r4;
        goto L30
    L21:
        r4 = (String) BuildersKt.runBlocking$default(null, new DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1(null), 1, null);     // Catch: Throwable -> L40
        if (r4 != null) goto L25;
        r4 = "";
    L25:
        if ((!StringsKt.isBlank(r4)) == false) goto L27;
        a = r4;     // Catch: Throwable -> L40
    L27:
        monitor-exit(r3);
    L40:
        th = move-exception;
        throw th;
    L30:
        if (r1.length() <= 0) goto L32;
        boolean r7 = true;
    L33:
        if (r7 == true) goto L35;
    L37:
        if (r2 == false) goto L45;
        r5.i = true;
        r5.j = true;
        return;
    L45:
        return;
    L35:
        if (Intrinsics.areEqual(r1, r6) == false) goto L37;
        r2 = true;
        goto L37
    L32:
        r7 = false;
        goto L33
    L9:
        r0 = false;
        goto L10
    }
}
