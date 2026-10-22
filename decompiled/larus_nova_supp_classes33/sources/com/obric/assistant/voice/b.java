package com.obric.assistant.voice;

import com.obric.eventkit.eventstaskmanager.AppEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final a a(ContentScene r2, AppEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        if (r3 == null) goto L6;
        String r1 = r3.getContent();
        if (r1 == null) goto L6;
    L7:
        a r0 = new a(r2, r1);
        r0.e = r3;
        return r0;
    L6:
        r1 = "";
        goto L7
    }
}
