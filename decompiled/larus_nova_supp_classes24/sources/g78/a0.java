package g78;

import com.larus.audio.audiov3.asr.AsrCallBackType;
import com.larus.audio.audiov3.config.task.sami.asr.AsrResultState;
import com.larus.audio.audiov3.config.task.sami.asr.ReportType;
import com.larus.audio.audiov3.reporter.asr.AsrStep;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.audiov3.task.asr.sami.data.SamiAsrDataBin;
import com.larus.audio.flow.client.FlowAsrClientImpl;
import com.larus.audio.flow.client.mob.FlowAudioAsrAndTTSCostMobHelper;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m58.u$a;
import y58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a0 implements h68.d {
    public final /* synthetic */ FlowAsrClientImpl a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[AsrResultState.values().length];
            r0[AsrResultState.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[AsrResultState.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[AsrResultState.STREAM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[ReportType.values().length];
            r1[ReportType.ASR_ENDED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[ReportType.UPLOAD_AUDIO_ENDED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[ReportType.ASR_STREAM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    public a0(FlowAsrClientImpl r1) {
        this.a = r1;
    }

    public final void a(b r21) {
        Intrinsics.checkNotNullParameter(r21, "result");
        int r2 = c68.b.a;
        c68.b.a("FlowAsrClient", "onResult audioState:" + r21.g + ", errCode:" + r21.b + ", errorMessage:" + r21.c + ", result:" + com.larus.audio.utils.g0.a(r21.d) + ' ');
        int r3 = a.a[r21.g.ordinal()];
        String r4 = "";
        if (r3 != 1) goto L5;
        FlowAsrClientImpl r5 = this.a;
        int r6 = FlowAsrClientImpl.E;
        r5.getClass();
        AsrEventEnum r7 = r21.h;
        AsrEventEnum r15 = AsrEventEnum.ASR_CANCEL;
        boolean r19 = false;
        if (r7 != r15) goto L28;
        boolean r8 = true;
    L29:
        String r9 = r21.a;
        AsrCallBackType r10 = AsrCallBackType.AS_SUCCESS;
        if (r8 == true) goto L34;
        String r11 = r21.d;
        if (r11 == null) goto L34;
        String r12 = r11;
    L36:
        y58.a r13 = g68.a.c(r9);
        if (r13 == null) goto L39;
        String r14 = r13.e;
    L40:
        if (r14 != null) goto L42;
        String r16 = "";
    L43:
        long r17 = r21.f;
        String r110 = r21.e;
        y58.c r20 = r21.i;
        if (r20 == null) goto L46;
        String r22 = r20.a;
    L47:
        if (r20 == null) goto L49;
        String r111 = r20.b;
    L50:
        if (r20 == null) goto L52;
        String r112 = r20.c;
    L53:
        FlowAsrClientImpl.O(r5, r9, r10, r12, r16, r17, r110, 0, r22, r111, r112, 64);
        if (r21.h == r15) goto L61;
        k78.a r23 = r5.m.get(r21.a);
        String r24 = null;
        if (r23 == null) goto L58;
        r23.c(null);
    L58:
        com.larus.audio.report.h r25 = r5.B().get(r21.a);
        if (r25 == null) goto L65;
        r25.t(r21, r21.d);
    L65:
        y58.a r26 = g68.a.c(r21.a);
        if (r26 != null) goto L68;
    L70:
        if (r19 == true) goto L79;
        y58.a r27 = g68.a.c(r21.a);
        if (r27 == null) goto L74;
        String r29 = r27.e;
    L75:
        if (r29 == null) goto L78;
        r4 = r29;
    L78:
        r5.N(r4);
        goto L79
    L74:
        r29 = r24;
    L79:
        r5.y(r21.a, "handleAsrSuccess");
        r5.M(r21.a);
        r5.y.remove(r21.a);
        r5.z(r21.a);
    L80:
        h68.d r30 = this.a.f;
        if (r30 == null) goto L84;
        r30.a(r21);
        return;
    L84:
        return;
    L68:
        if (r26.h == true) goto L70;
        r19 = true;
        goto L70
    L61:
        r24 = null;
        com.larus.audio.report.h r31 = r5.B().get(r21.a);
        if (r31 == null) goto L65;
        r31.o(true);
        goto L65
    L52:
        r112 = null;
        goto L53
    L49:
        r111 = null;
        goto L50
    L46:
        r22 = null;
        goto L47
    L42:
        r16 = r14;
        goto L43
    L39:
        r14 = null;
    L34:
        r12 = "";
        goto L36
    L28:
        r8 = false;
        goto L29
    L5:
        if (r3 != 2) goto L7;
        FlowAsrClientImpl r32 = this.a;
        Integer r33 = r21.b;
        String r34 = r21.c;
        int r35 = FlowAsrClientImpl.E;
        r32.G(r21, r33, r34, "IAsrListener.onResult");
        goto L80
    L7:
        if (r3 != 3) goto L23;
        FlowAsrClientImpl r36 = this.a;
        int r37 = FlowAsrClientImpl.E;
        r36.getClass();
        String r38 = r21.a;
        AsrCallBackType r39 = AsrCallBackType.ASR_STREAM;
        String r40 = r21.d;
        if (r40 != null) goto L11;
        String r41 = "";
    L12:
        y58.a r42 = g68.a.c(r38);
        if (r42 == null) goto L15;
        String r43 = r42.e;
    L16:
        if (r43 != null) goto L18;
        String r113 = "";
    L19:
        FlowAsrClientImpl.O(r36, r38, r39, r41, r113, r21.f, r21.e, 0, null, null, null, 960);
        k78.a r44 = r36.m.get(r21.a);
        if (r44 == null) goto L80;
        r44.c(MapsKt.mapOf(TuplesKt.to("is_stream_result", "1")));
        goto L80
    L18:
        r113 = r43;
        goto L19
    L15:
        r43 = null;
        goto L16
    L11:
        r41 = r40;
        goto L12
    L23:
        throw new NoWhenBranchMatchedException();
    }

    public final void b(h68.b r2) {
        Intrinsics.checkNotNullParameter(r2, "asrStreamSentenceResp");
        h68.d r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void c(SamiAsrDataBin r2) {
        h68.d r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public final void e(AsrState r2) {
        Intrinsics.checkNotNullParameter(r2, "asrState");
        h68.d r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    public void onEvent(AsrEventEnum r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        h68.d r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.onEvent(r2);
        return;
    }

    public final void f(b r20, ReportType r21) {
        Intrinsics.checkNotNullParameter(r20, "result");
        Intrinsics.checkNotNullParameter(r21, "type");
        int r2 = a.b[r21.ordinal()];
        if (r2 != 1) goto L5;
        FlowAsrClientImpl r3 = this.a;
        int r4 = FlowAsrClientImpl.E;
        com.larus.audio.report.h r5 = r3.B().get(r20.a);
        if (r5 == null) goto L31;
        r5.n(false);
    L31:
        k78.a r6 = this.a.m.get(r20.a);
        if (r6 == null) goto L34;
        r6.f(AsrStep.ASR_RECOGNITION_DELAY.getTraceName(), null);
    L34:
        FlowAudioAsrAndTTSCostMobHelper.a(r20);
        k78.a r7 = this.a.m.get(r20.a);
        if (r7 == null) goto L37;
        r7.f(AsrStep.ASR_STREAM_TO_FINAL.getTraceName(), null);
    L37:
        m58.u r8 = m58.h.l;
        if (r8 == null) goto L40;
        u$a.b(r8, r20.a, "asr_touch_up_to_recognize_last_pkg", null, null, null, 28);
    L40:
        m58.u r12 = m58.h.l;
        if (r12 == null) goto L48;
        u$a.b(r12, r20.a, "asr_stream_pkg_to_last_pkg", null, null, null, 28);
        return;
    L48:
        return;
    L5:
        if (r2 != 2) goto L7;
        k78.a r1 = this.a.m.get(r20.a);
        if (r1 == null) goto L46;
        r1.f(AsrStep.ASR_AUDIO_UPLOAD.getTraceName(), null);
        return;
    L46:
        return;
    L7:
        if (r2 != 3) goto L24;
        FlowAsrClientImpl r9 = this.a;
        int r10 = FlowAsrClientImpl.E;
        com.larus.audio.report.h r11 = r9.B().get(r20.a);
        if (r11 == null) goto L11;
        r11.n(true);
    L11:
        k78.a r13 = this.a.m.get(r20.a);
        if (r13 == null) goto L14;
        r13.f(AsrStep.ASR_RECOGNITION_DELAY.getTraceName(), MapsKt.mapOf(TuplesKt.to("is_stream_result", "1")));
    L14:
        k78.a r14 = this.a.m.get(r20.a);
        if (r14 == null) goto L17;
        r14.e(AsrStep.ASR_STREAM_TO_FINAL.getTraceName(), null);
    L17:
        FlowAudioAsrAndTTSCostMobHelper.a(r20);
        m58.u r15 = m58.h.l;
        if (r15 == null) goto L20;
        u$a.b(r15, r20.a, "asr_touch_up_to_stream_pkg", null, null, null, 28);
    L20:
        m58.u r16 = m58.h.l;
        if (r16 == null) goto L44;
        r16.f(r20.a, "asr_stream_pkg_to_last_pkg", null);
        return;
    L44:
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    }

    public final void d(AsrLifeState r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "lifeState");
        h68.d r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.d(r2, r3, r4);
        return;
    }
}
