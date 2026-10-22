package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.tts.TtsScene;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c2 implements x1 {
    public String b;
    public boolean c;

    public c2() {
    }

    public final void i6(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "stopReason");
    }

    public final void k6(String r3, Map r4, Function0 r5, Function1 r6) {
        Intrinsics.checkNotNullParameter("doc", "type");
        Intrinsics.checkNotNullParameter(r3, "uniId");
        Intrinsics.checkNotNullParameter(r4, "payloadParam");
        Intrinsics.checkNotNullParameter(r5, "onNext");
        Intrinsics.checkNotNullParameter(r6, "onFailed");
    }

    public final void l6() {
        this.c = false;
    }

    public final void p6(Message r1, String r2, CoroutineScope r3, TtsScene r4) {
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r2, "ttsText");
    }

    public final String q6() {
        return null;
    }

    public final boolean n6() {
        return this.c;
    }

    public final String o6() {
        return this.b;
    }

    public final void r6(String r1) {
        this.b = r1;
    }

    public final Object j6(Message r1, SpeakerVoice r2, boolean r3, String r4, CoroutineScope r5, String r6, TtsScene r7, Continuation<? super Unit> r8) {
        return Unit.INSTANCE;
    }

    public final Object m6(Message r1, String r2, String r3, String r4, String r5, boolean r6, JSONObject r7, TtsScene r8, String r9, Continuation<? super Unit> r10) {
        return Unit.INSTANCE;
    }
}
