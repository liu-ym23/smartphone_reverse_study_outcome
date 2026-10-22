package com.obric.miniapp.alarm;

import android.os.Build;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.time.Instant;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class w implements Comparable<w> {
    public static final boolean b = false;
    public static final boolean c = false;
    public final Object a;

    public static final class a {
        public static w a() {
            if (w.c == false) goto L5;
            Object r1 = Instant.now();
        L7:
            return new w(r1);
        L5:
            r1 = new Date(System.currentTimeMillis());
            goto L7
        }

        public static w b(long r2) {
            if (w.c == false) goto L5;
            Object r3 = Instant.ofEpochMilli(r2);
        L7:
            return new w(r3);
        L5:
            r3 = new Date(r2);
            goto L7
        }
    }

    public /* synthetic */ w() {
        throw null;
    }

    static {
        int r0 = Build.VERSION.SDK_INT;
        boolean r1 = false;
        if (r0 < 34) goto L5;
        boolean r2 = true;
    L6:
        b = r2;
        if (r0 < 26) goto L9;
        r1 = true;
    L9:
        c = r1;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final long b() {
        if (c == false) goto L5;
        Object r0 = this.a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.time.Instant");
        return ((Instant) r0).toEpochMilli();
    L5:
        Object r1 = this.a;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.util.Date");
        return ((Date) r1).getTime();
    }

    public w(Object r1) {
        this.a = r1;
    }

    public final int a(w r3) {
        Intrinsics.checkNotNullParameter(r3, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
        if (c == false) goto L5;
        Object r0 = this.a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.time.Instant");
        Object r4 = r3.a;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.time.Instant");
        return ((Instant) r0).compareTo((Instant) r4);
    L5:
        Object r1 = this.a;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.util.Date");
        Object r5 = r3.a;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.util.Date");
        return ((Date) r1).compareTo((Date) r5);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(w r1) {
        return a(r1);
    }
}
