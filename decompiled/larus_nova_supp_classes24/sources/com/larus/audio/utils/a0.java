package com.larus.audio.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a0 {
    public static final a0 b = null;
    public static final a0 c = null;
    public static final a0 d = null;
    public static final a0 e = null;
    public final String a;

    public static final class a {
    }

    static {
        new a0("call_id");
        b = new a0("task_id");
        new a0("session_id");
        new a0("log_id");
        new a0("style_id");
        new a0("audio_scene");
        new a0("session_category");
        new a0("session_mode");
        new a0("session_options");
        new a0("result");
        c = new a0("reason");
        new a0("bot_id");
        new a0("bot_name");
        d = new a0("conversation_id");
        e = new a0("message_id");
        new a0("voice_id");
        new a0("text");
        new a0("error_msg");
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public a0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "rawValue");
        this.a = r2;
    }

    public final boolean equals(Object r3) {
        String r1 = null;
        if ((r3 instanceof a0) == false) goto L5;
        a0 r4 = (a0) r3;
    L6:
        if (r4 == null) goto L9;
        r1 = r4.a;
    L9:
        return Intrinsics.areEqual(r1, this.a);
    L5:
        r4 = null;
        goto L6
    }
}
