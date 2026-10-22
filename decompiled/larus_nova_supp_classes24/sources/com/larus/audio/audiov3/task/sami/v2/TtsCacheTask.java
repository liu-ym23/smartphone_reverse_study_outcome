package com.larus.audio.audiov3.task.sami.v2;

import com.bytedance.flow_audio.api.business.tts.config.FlowAudioTtsStreamType;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsState;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class TtsCacheTask implements l68.a {
    public l68.b a;
    public z58.a b;
    public TtsState c;
    public final ReentrantLock d;
    public String e;

    @Override // l68.a
    public final void d(FlowAudioTtsStreamType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "ttsStreamType");
        Intrinsics.checkNotNullParameter(r3, "streamText");
    }

    @Override // l68.a
    public final void release() {
    }

    @Override // l68.a
    public final void cancel() {
        ReentrantLock r0 = this.d;
        if (r0 == null) goto L6;
        r0.lock();
    L6:
        if (this.c != TtsState.TTS_STARTED) goto L10;
        TtsState r1 = TtsState.TTS_STOPPED;
        this.c = r1;
        l68.b r2 = this.a;
        if (r2 == null) goto L11;
        r2.d(r1);
    L11:
        ReentrantLock r3 = this.d;
        if (r3 == null) goto L15;
        r3.unlock();
        return;
    L15:
        return;
    L10:
        int r4 = c68.b.a;
        c68.b.a("TtsCacheTask", this + " has stopped");
        goto L11
    }

    @Override // l68.a
    public final void start() {
        ReentrantLock r0 = this.d;
        if (r0 == null) goto L6;
        r0.lock();
    L6:
        if (this.c != TtsState.TTS_STOPPED) goto L25;
        int r1 = c68.b.a;
        c68.b.a("TtsCacheTask", this + " config " + this.b);
        TtsState r2 = TtsState.TTS_STARTED;
        this.c = r2;
        l68.b r3 = this.a;
        if (r3 == null) goto L10;
        r3.d(r2);
    L10:
        l68.b r4 = this.a;
        boolean r5 = true;
        if (r4 == null) goto L13;
        TtsEventEnum r6 = TtsEventEnum.TTS_START;
        JSONObject r7 = new JSONObject();
        r7.put("is_cache", true);
        Unit r8 = Unit.INSTANCE;
        l68.b.a.a(r4, r6, null, 0, r7.toString(), null, 22);
    L13:
        z58.a r9 = this.b;
        if (r9 == null) goto L26;
        int r10 = com.larus.audio.flow.client.cache.d.a;
        String r11 = r9.c;
        String r12 = r9.e;
        String r13 = r9.h;
        if (r13.length() == 0) goto L19;
        r5 = false;
    L19:
        if (r5 == false) goto L21;
        r13 = "{}";
    L21:
        String r14 = new JSONObject(r13).optString("post_process");
        if (r14 != null) goto L24;
        r14 = "";
    L24:
        this.e = com.larus.audio.flow.client.cache.d.a(r11, r12, r14, r9.v);
    L26:
        ReentrantLock r15 = this.d;
        if (r15 == null) goto L30;
        r15.unlock();
        return;
    L30:
        return;
    L25:
        int r16 = c68.b.a;
        c68.b.a("TtsCacheTask", this + " has started");
        goto L26
    }

    @Override // l68.a
    public final void stop() {
        if (this.c != TtsState.TTS_STARTED) goto L7;
        TtsState r0 = TtsState.TTS_STOPPED;
        this.c = r0;
        l68.b r1 = this.a;
        if (r1 == null) goto L9;
        r1.d(r0);
        return;
    L9:
        return;
    L7:
        int r2 = c68.b.a;
        c68.b.a("TtsCacheTask", this + " has stopped");
    }

    public TtsCacheTask() {
        this.c = TtsState.TTS_STOPPED;
        this.d = new ReentrantLock();
    }

    @Override // l68.a
    public final z58.a c() {
        return this.b;
    }

    @Override // l68.a
    public final l68.b getListener() {
        return this.a;
    }

    @Override // l68.a
    public final void a(int r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new TtsCacheTask$prepareData$1(this, r7, null), 2, null);
    }

    @Override // l68.a
    public final void b(l68.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    @Override // l68.a
    public final void e(z58.a r2, TtsTracer r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.b = r2;
        if (r3 == null) goto L8;
        l68.b r4 = this.a;
        if (r4 == null) goto L9;
        r4.a(r3);
        return;
    L9:
        return;
    }
}
