package com.ss.ugc.live.sdk.msg;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements vlc.c, a, com.ss.ugc.live.sdk.msg.dispatch.e, g {
    public final String a;
    public com.ss.ugc.live.sdk.msg.dispatch.e b;
    public String c;
    public boolean d;
    public boolean e;
    public final vlc.c f;
    public final g g;
    public final a h;
    public final com.ss.ugc.live.sdk.msg.utils.task.c i;
    public final amc.c j;

    @Override // vlc.c
    public final boolean a() {
        return this.f.a();
    }

    @Override // vlc.g
    public final void b(String r2, Throwable r3) {
        this.g.b(r2, r3);
    }

    @Override // vlc.g
    public final void d(long r7, JSONObject r9, JSONObject r10, JSONObject r11) {
        this.g.d(r7, r9, r10, r11);
    }

    @Override // vlc.g
    public final void e(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        this.g.e(r2, r3, r4, r5);
    }

    @Override // com.ss.ugc.live.sdk.msg.a
    public final boolean isRunning() {
        return this.h.isRunning();
    }

    @Override // vlc.c
    public final void log(String r2, String r3) {
        this.f.log(r2, r3);
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.e
    public final void c(List<? extends tlc.d> r3) {
        com.ss.ugc.live.sdk.msg.dispatch.e r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageConsumer");
    L5:
        r0.c(r3);
    }

    public c(vlc.c r2, g r3, MessageState r4, com.ss.ugc.live.sdk.msg.utils.task.c r5, amc.c r6) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        Intrinsics.checkNotNullParameter(r3, "monitor");
        Intrinsics.checkNotNullParameter(r4, "messageState");
        Intrinsics.checkNotNullParameter(r5, "taskScheduler");
        Intrinsics.checkNotNullParameter(r6, "historyMessageConfig");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.a = "0";
        this.c = "0";
        this.e = true;
    }
}
