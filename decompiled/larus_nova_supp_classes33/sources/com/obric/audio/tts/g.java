package com.obric.audio.tts;

import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g implements l68.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ q58.a b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[TtsLifeState.values().length];
            r0[TtsLifeState.TTS_FINISH_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            r0[TtsLifeState.TTS_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L34:
            r0[TtsLifeState.TTS_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L8:
            a = r0;
            int[] r1 = new int[TtsEventEnum.values().length];
            r1[TtsEventEnum.TTS_FIRST_PACKAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L28:
            r1[TtsEventEnum.TTS_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L36:
            r1[TtsEventEnum.TTS_TASK_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L24:
            r1[TtsEventEnum.TTS_SESSION_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L30:
            r1[TtsEventEnum.TTS_NETWORK_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L14:
            b = r1;
        }
    }

    public final void a(TtsTracer r2) {
        Intrinsics.checkNotNullParameter(r2, "tracer");
    }

    public final void d(TtsState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        int r0 = c68.b.a;
        c68.b.a("ObricTtsClient", "tts onStateChange state=" + r3 + " taskId=" + this.a);
    }

    public final void b(byte[] r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "data");
        int r7 = r5.length;
        int r0 = this.b.c();
        if (r0 > 0) goto L6;
        int r8 = c68.b.a;
        c68.b.b("ObricTtsClient", "onAudioData minBufferSize=" + r0 + " invalid");
        return;
    L6:
        int r1 = 0;
        if (r7 <= r0) goto L11;
    L8:
        int r2 = r1 + r0;
        if (r2 >= r7) goto L11;
        f.g.offer(ArraysKt.copyOfRange(r5, r1, r2));
        r1 = r2;
    L11:
        f.g.offer(ArraysKt.copyOfRange(r5, r1, r7));
    }

    public g(String r1, q58.a r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void e(TtsLifeState r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "lifeState");
        int r5 = c68.b.a;
        c68.b.a("ObricTtsClient", "tts onLifeStateChange lifeState=" + r2 + " taskId=" + r3);
        int r6 = a.a[r2.ordinal()];
        if (r6 != 1) goto L5;
    L9:
        f.a.getClass();
        f.a();
        return;
    L5:
        if (r6 == 2) goto L9;
        if (r6 == 3) goto L9;
    }

    public final void c(TtsEventEnum r7, String r8, int r9, String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r7, "event");
        Intrinsics.checkNotNullParameter(r8, "customErrorMsg");
        Intrinsics.checkNotNullParameter(r10, "ext");
        Intrinsics.checkNotNullParameter(r11, "extMap");
        int r12 = c68.b.a;
        c68.b.a("ObricTtsClient", "tts onEvent event=" + r7 + " taskId=" + this.a + " code=" + r9 + " msg=" + r8);
        int r13 = a.b[r7.ordinal()];
        if (r13 != 1) goto L5;
        Lazy r14 = MediaResourceManager.a;
        if (MediaResourceManager.i("O_CALL") == false) goto L26;
        IObricRealtimeCallExtService r15 = (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
        if (r15 != null) goto L20;
    L22:
        boolean r16 = false;
    L23:
        if (r16 == false) goto L26;
        c68.b.d("ObricTtsClient", "[OBRIC_TTS][O_CALL_PLAYING] TTS_FIRST_PACKAGE skipped by O_CALL playing");
        f.a.c("TTS_FIRST_PACKAGE skipped by O_CALL playing", true);
        return;
    L20:
        if (r15.isAssistantListening() != true) goto L22;
        r16 = true;
    L26:
        f r17 = f.a;
        final String r18 = this.a;
        final q58.a r19 = this.b;
        boolean r110 = this.c;
        r17.getClass();
        if (r110 == false) goto L29;
        com.larus.media.model.a r20 = f.o;
    L30:
        f.p = r20;
        FLogger.a.i("ObricTtsClient", "[OBRIC_TTS] requestMedia scene=" + f.p.b);
        MediaResourceManager.m(f.p, new com.obric.audio.tts.a(r18, r19), new b(), 0, 8);
        return;
    L29:
        r20 = f.n;
        goto L30
    L5:
        if (r13 != 2) goto L7;
        f.g.offer(new byte[0]);
        f.j = true;
        return;
    L7:
        if (r13 != 3) goto L9;
    L13:
        FLogger.a.e("ObricTtsClient", "tts failed event=" + r7 + " code=" + r9 + " msg=" + r8);
        f r21 = f.a;
        f.j = true;
        f.g.offer(new byte[0]);
        return;
    L9:
        if (r13 == 4) goto L13;
        if (r13 == 5) goto L13;
    }
}
