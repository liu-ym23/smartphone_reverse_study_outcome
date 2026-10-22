package com.larus.bot.impl.feature.edit.feature.firstmet;

import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements n68.a {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    public final void d(PlayStateEnum r1) {
    }

    public final void e(TtsErrorType r1) {
    }

    public final void c(PlayStateEnum r3) {
        this.a.c.dispatchUIAction(new l.d(r3));
    }

    public final void a(boolean r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    public final void b(boolean r1, String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }
}
