package k78;

import android.app.Application;
import android.os.SystemClock;
import com.larus.audio.audiov3.report.AudioDeviceMonitorScenes;
import com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter;
import com.larus.audio.audiov3.report.IAudioEventCommonParams;
import com.larus.audio.report.h;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m58.s;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements h {
    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final Function2<String, JSONObject, Unit> e;
    public long f;
    public long g;
    public boolean h;
    public long i;
    public long j;
    public boolean k;
    public long l;
    public long m;

    @Override // com.larus.audio.report.h
    public final void q() {
        this.j = SystemClock.elapsedRealtime();
    }

    @Override // com.larus.audio.report.h
    public final void s() {
        this.i = SystemClock.elapsedRealtime();
    }

    public final void a(JSONObject r8) {
        r8.put("is_business_resend", this.k);
        r8.put("bot_id", this.d);
        r8.put("conversation_id", this.c);
        r8.put("task_id", this.b);
        m58.b r0 = m58.h.k;
        if (r0 == null) goto L5;
        long r3 = r0.b();
    L7:
        if (r3 <= (-1)) goto L12;
        long r1 = this.m;
        if (r1 <= 0) goto L13;
        r8.put("time_interval_from_cold_start", r1 - r3);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r3 = -1;
        goto L7
    }

    public final void b(boolean r8) {
        this.k = r8;
        IAudioEventCommonParams r9 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r9 == null) goto L9;
        x58.a r0 = m58.h.a;
        m58.b r1 = m58.h.k;
        if (r1 == null) goto L7;
        Application r2 = r1.getApplication();
    L8:
        r9.b(r2);
        goto L9
    L7:
        r2 = null;
    L9:
        x58.a r10 = m58.h.a;
        s r11 = m58.h.b;
        if (r11 == null) goto L12;
        JSONObject r3 = new JSONObject();
        this.m = SystemClock.elapsedRealtime();
        a(r3);
        this.e.invoke("flow_im_asr_start", r3);
        r3.put("user_press_to_start_task_duration", this.m - this.a);
        Unit r4 = Unit.INSTANCE;
        r11.report("flow_im_asr_start", r3);
    L12:
        IAudioDeviceMonitorReporter r12 = (IAudioDeviceMonitorReporter) ServiceManager.get().getService(IAudioDeviceMonitorReporter.class);
        if (r12 == null) goto L16;
        r12.a(AudioDeviceMonitorScenes.ASR);
        return;
    }

    @Override // com.larus.audio.report.h
    public final void n(boolean r3) {
        if (this.h == true) goto L5;
        this.g = SystemClock.elapsedRealtime();
        this.h = r3;
    L5:
        this.f = SystemClock.elapsedRealtime();
    }

    @Override // com.larus.audio.report.h
    public final void o(boolean r6) {
        x58.a r0 = m58.h.a;
        s r1 = m58.h.b;
        if (r1 == null) goto L5;
        JSONObject r2 = new JSONObject();
        a(r2);
        this.e.invoke("flow_im_asr_end", r2);
        r2.put("result", 2);
        r2.put("is_from_server", r6);
        r2.put("is_stream_asr", this.h);
        Unit r7 = Unit.INSTANCE;
        r1.report("flow_im_asr_end", r2);
    L5:
        IAudioEventCommonParams r8 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r8 == null) goto L9;
        r8.disable();
        return;
    }

    @Override // com.larus.audio.report.h
    public final void p(int r9) {
        if (this.l != 0) goto L8;
        this.l = SystemClock.elapsedRealtime();
        x58.a r0 = m58.h.a;
        s r1 = m58.h.b;
        if (r1 == null) goto L9;
        JSONObject r2 = new JSONObject();
        a(r2);
        this.e.invoke("asr_client_start_up", r2);
        r2.put("press_to_recorde_first_pkg_duration", this.j - this.a);
        r2.put("recorde_first_pkg_to_send_first_pkg_duration", this.l - this.j);
        r2.put("duration", this.l - this.a);
        r2.put("retry_times", r9);
        Unit r10 = Unit.INSTANCE;
        r1.report("asr_client_start_up", r2);
        return;
    L9:
        return;
    }

    @Override // com.larus.audio.report.h
    public final void t(y58.b r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "result");
        s r1 = m58.h.b;
        if (r1 == null) goto L45;
        JSONObject r2 = new JSONObject();
        a(r2);
        this.e.invoke("flow_im_asr_end", r2);
        boolean r3 = true;
        if (r12 != null) goto L7;
    L10:
        boolean r13 = true;
    L11:
        r2.put("is_content_recognized", !r13);
        r2.put("result", 0);
        r2.put("tail_pkg_duration", this.f - this.i);
        if (this.h == false) goto L14;
        long r6 = this.g - this.i;
    L15:
        r2.put("tail_pkg_duration_stream", r6);
        r2.put("is_stream_asr", this.h);
        y58.c r14 = r11.i;
        if (r14 == null) goto L44;
        String r15 = r14.b;
        if (r15 == null) goto L44;
        if (r15.length() > 0) goto L23;
        r3 = false;
    L23:
        String r0 = null;
        if (r3 == true) goto L27;
        r15 = null;
    L27:
        if (r15 == null) goto L44;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L35
        JSONObject r16 = new JSONArray(r15).optJSONObject(0);     // Catch: Throwable -> L35
        if (r16 == null) goto L32;
        String r17 = r16.optString("aed_res");     // Catch: Throwable -> L35
    L33:
        Object r19 = Result.constructor-impl(r2.put("aed_res", r17));     // Catch: Throwable -> L35
    L37:
        Throwable r5 = Result.exceptionOrNull-impl(r19);
        if (r5 == null) goto L43;
        int r7 = c68.b.a;
        StringBuilder r8 = new StringBuilder("onAsrSuccess, Parse aed_res error: ");
        y58.c r110 = r11.i;
        if (r110 == null) goto L42;
        r0 = r110.b;
    L42:
        r8.append(r0);
        c68.b.c("AsrTracer", r8.toString(), r5);
    L43:
        Result.box-impl(r19);
        goto L44
    L32:
        r17 = null;
    L35:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        Unit r111 = Unit.INSTANCE;
        r1.report("flow_im_asr_end", r2);
        goto L45
    L14:
        r6 = 0;
        goto L15
    L7:
        if (r12.length() == 0) goto L10;
        r13 = false;
    L45:
        IAudioEventCommonParams r112 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r112 == null) goto L51;
        r112.disable();
        return;
    }

    @Override // com.larus.audio.report.h
    public final void r(int r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        x58.a r0 = m58.h.a;
        s r1 = m58.h.b;
        if (r1 == null) goto L5;
        JSONObject r2 = new JSONObject();
        a(r2);
        this.e.invoke("flow_im_asr_end", r2);
        r2.put("result", 1);
        r2.put("error_code", r6);
        r2.put("error_msg", r7);
        r2.put("server_error_code", r8);
        r2.put("is_stream_asr", this.h);
        Unit r9 = Unit.INSTANCE;
        r1.report("flow_im_asr_end", r2);
    L5:
        IAudioEventCommonParams r10 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r10 == null) goto L9;
        r10.disable();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(long r2, String r4, String r5, String r6, Function2<? super String, ? super JSONObject, Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "convId");
        Intrinsics.checkNotNullParameter(r6, "botId");
        Intrinsics.checkNotNullParameter(r7, "appendBizParamsCallback");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
