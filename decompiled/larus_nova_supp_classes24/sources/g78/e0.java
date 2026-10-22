package g78;

import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.f.android.quality.impl.Scene;
import com.google.gson.Gson;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.flow.client.FlowTtsClientImpl;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l68.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e0 implements b {
    public final /* synthetic */ FlowTtsClientImpl a;
    public final /* synthetic */ b b;
    public final /* synthetic */ z58.a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ TtsTracer e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[TtsLifeState.values().length];
            r0[TtsLifeState.TTS_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L35:
            r0[TtsLifeState.TTS_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L47:
            r0[TtsLifeState.TTS_PAUSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r0[TtsLifeState.TTS_STOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L10:
            a = r0;
            int[] r1 = new int[TtsEventEnum.values().length];
            r1[TtsEventEnum.TTS_END.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L41:
            r1[TtsEventEnum.TTS_FIRST_PACKAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L29:
            r1[TtsEventEnum.CHAT_RESPONSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L39:
            r1[TtsEventEnum.TTS_TASK_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L33:
            r1[TtsEventEnum.TTS_SESSION_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L43:
            r1[TtsEventEnum.TTS_NETWORK_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L17:
            b = r1;
        }
    }

    @Override // l68.b
    public final void a(TtsTracer r2) {
        Intrinsics.checkNotNullParameter(r2, "tracer");
    }

    @Override // l68.b
    public final void d(TtsState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        int r0 = c68.b.a;
        c68.b.a(this.a.b, "onStateChange on tts state change " + r4);
        b r1 = this.b;
        if (r1 == null) goto L5;
        r1.d(r4);
    L5:
        com.larus.audio.flow.client.cache.f.b.tryEmit(r4);
    }

    @Override // l68.b
    public final void b(byte[] r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "data");
        m58.r r0 = m58.h.c;
        if (r0 == null) goto L5;
        r0.e(r6);
    L5:
        int r1 = r6.length;
        FlowTtsClientImpl r2 = this.a;
        int r3 = r2.k.e;
        if (r3 <= 0) goto L13;
        int r4 = 0;
        if (r1 <= r3) goto L12;
    L9:
        int r5 = r4 + r3;
        if (r5 >= r1) goto L12;
        l78.a.a();
        l78.a.h++;
        this.a.m.offer(ArraysKt.copyOfRange(r6, r4, r5));
        r4 = r5;
    L12:
        l78.a.a();
        l78.a.h++;
        this.a.m.offer(ArraysKt.copyOfRange(r6, r4, r1));
        this.a.H(this.d);
    L14:
        b r8 = this.b;
        if (r8 == null) goto L19;
        r8.b(r6, r7);
        return;
    L19:
        return;
    L13:
        int r9 = c68.b.a;
        c68.b.b(r2.b, "onAudioData AudioPlayer MinBufferSize: " + r3 + " error");
        goto L14
    }

    @Override // l68.b
    public final void e(TtsLifeState r4, String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r4, "lifeState");
        int r0 = c68.b.a;
        c68.b.a(this.a.b, "onLifeStateChange lifeState=" + r4 + " taskId=" + r5 + " extraMap=" + GsonProtectorUtils.toJson(new Gson(), r6) + ' ');
        b r1 = this.b;
        if (r1 == null) goto L5;
        r1.e(r4, r5, r6);
    L5:
        int r7 = a.a[r4.ordinal()];
        if (r7 != 1) goto L8;
        m58.r r8 = m58.h.c;
        if (r8 == null) goto L49;
        if (r5 != null) goto L43;
        r5 = "";
    L43:
        r8.h(r5, this.c);
        return;
    L49:
        return;
    L8:
        if (r7 != 2) goto L10;
        m58.r r9 = m58.h.c;
        if (r9 == null) goto L35;
        if (r5 != null) goto L33;
        String r10 = "";
    L34:
        r9.i(r10, this.c);
        goto L35
    L33:
        r10 = r5;
    L35:
        fa9.e r11 = fa9.e.a;
        if (r5 != null) goto L38;
        r5 = "";
    L38:
        r11.f("tts", r5);
        return;
    L10:
        if (r7 != 3) goto L12;
        m58.r r12 = m58.h.c;
        if (r12 == null) goto L46;
        if (r5 != null) goto L28;
        r5 = "";
    L28:
        r12.a(r5, this.c);
        return;
    L46:
        return;
    L12:
        if (r7 != 4) goto L50;
        m58.r r13 = m58.h.c;
        if (r13 == null) goto L20;
        if (r5 != null) goto L18;
        String r14 = "";
    L19:
        r13.d(r14, this.c);
        goto L20
    L18:
        r14 = r5;
    L20:
        fa9.e r15 = fa9.e.a;
        if (r5 != null) goto L23;
        r5 = "";
    L23:
        r15.f("tts", r5);
        return;
    }

    public e0(FlowTtsClientImpl r1, b r2, z58.a r3, String r4, TtsTracer r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // l68.b
    public final void c(TtsEventEnum r9, String r10, int r11, String r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r9, "event");
        Intrinsics.checkNotNullParameter(r10, "customErrorMsg");
        Intrinsics.checkNotNullParameter(r12, "ext");
        Intrinsics.checkNotNullParameter(r13, "extMap");
        int r0 = c68.b.a;
        c68.b.a(this.a.b, "onEvent on tts event " + r9 + ", code:" + r11 + ", msg:" + r10 + ',');
        b r2 = this.b;
        if (r2 == null) goto L5;
        r2.c(r9, r10, r11, r12, r13);
    L5:
        com.larus.audio.flow.client.cache.f.a.tryEmit(r9);
        switch(a.b[r9.ordinal()]) {
            case 1: goto L56;
            case 2: goto L53;
            case 3: goto L52;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            default: goto L65;
        };
    L52:
        this.a.H(this.d);
        return;
    L53:
        this.a.H(this.d);
        TtsTracer r14 = this.e;
        if (r14 == null) goto L62;
        r14.receiveFirstPkg();
        return;
    L62:
        return;
    L56:
        this.a.m.offer(new byte[0]);
        FlowTtsClientImpl r15 = this.a;
        r15.D = true;
        r15.D();
        k78.c r16 = this.a.q;
        if (r16 == null) goto L64;
        r16.c(MapsKt.mapOf(TuplesKt.to("success_scene", "tts_end")));
        return;
    L64:
        return;
    L65:
        return;
    L9:
        if (r11 != (-1)) goto L11;
        r11 = r9.getCode();
    L11:
        TtsErrorType.a r17 = TtsErrorType.Companion;
        Integer r1 = Integer.valueOf(r11);
        r17.getClass();
        TtsErrorType r19 = TtsErrorType.a.a(r1);
        if (r19 == null) goto L16;
        n68.a r3 = this.a.p;
        if (r3 == null) goto L16;
        r3.e(r19);
    L16:
        this.a.v(PlayStateEnum.PLAY_STATE_FAIL);
        if (r10.length() != 0) goto L19;
        boolean r110 = true;
    L20:
        if (r110 == false) goto L22;
        r10 = r9.getMassage();
    L22:
        TtsTracer r20 = this.e;
        if (r20 == null) goto L25;
        r20.onPlayErr(false, r10);
    L25:
        k78.c r21 = this.a.q;
        if (r21 == null) goto L51;
        Intrinsics.checkNotNullParameter(r10, LKBaseResponseModel.ERROR_MSG_KEY);
        if (r21.a.length() != 0) goto L30;
        boolean r111 = true;
    L31:
        if (r111 == true) goto L51;
        if (r21.e == false) goto L51;
        r21.e = false;
        Scene r112 = r21.d;
        if (r112 == null) goto L46;
        f68.a r4 = r21.c;
        if (r4 == null) goto L44;
        Map<String, Object> r5 = r4.a();
        if (r5 == null) goto L44;
        Map r6 = MapsKt.toMutableMap(r5);
        if (r6 == null) goto L44;
        Unit r7 = Unit.INSTANCE;
    L45:
        rt7.c.a.a(r112, r11, r10, r6);
    L44:
        r6 = null;
    L46:
        String r22 = r21.b;
        if (r22 == null) goto L51;
        m58.u r113 = m58.h.l;
        if (r113 == null) goto L51;
        r113.k(r22, Integer.valueOf(r11), "tts_failed", r10);
        goto L51
    L30:
        r111 = false;
    L51:
        FlowTtsClientImpl r23 = this.a;
        r23.D = true;
        r23.m.offer(new byte[0]);
        this.a.D();
        return;
    L19:
        r110 = false;
        goto L20
    }
}
