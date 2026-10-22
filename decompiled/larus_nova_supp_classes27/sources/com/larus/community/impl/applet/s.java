package com.larus.community.impl.applet;

import android.os.Bundle;
import com.larus.doc.sdk.api.VoiceInputFrom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements e29.c {
    public s() {
    }

    @Override // e29.c
    public final String a() {
        cy9.a r0 = cy9.a.a;
        monitor-enter(r0);
        Bundle r1 = cy9.a.b;     // Catch: Throwable -> L15
        String r2 = null;
        if (r1 == null) goto L7;
        String r3 = r1.getString("recent_enter_feed_from");     // Catch: Throwable -> L15
    L9:
        if (Intrinsics.areEqual(r3, "fixed_tab") == true) goto L12;
        if (Intrinsics.areEqual(r3, VoiceInputFrom.ACTION_BAR) == true) goto L12;
    L13:
        monitor-exit(r0);
        return r2;
    L12:
        r2 = r3;
        goto L13
    L7:
        r3 = null;
    L15:
        th = move-exception;
        throw th;
    }
}
