package kx9;

import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import hx9.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final AtomicInteger b = null;
    public final l a;

    /* JADX INFO: renamed from: kx9.a$a, reason: collision with other inner class name */
    public static final class C0065a {
    }

    static {
        b = new AtomicInteger(0);
    }

    public a(hx9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public static void a(JSONObject r4, jx9.a r5) {
        r4.put("conversation_id", r5.a);
        r4.put("nex_pulse_scene", r5.b);
        r4.put("api_time", r5.f - r5.e);
        r4.put("total_time", Math.max(r5.g - r5.e, 0));
        NexPulseResponseData r0 = r5.i;
        int r1 = 0;
        if (r0 == null) goto L7;
        List r2 = r0.getCandidateList();
        if (r2 == null) goto L7;
        int r3 = r2.size();
    L8:
        r4.put("candidate_cnt", r3);
        NexPulseResponseData r6 = r5.i;
        if (r6 == null) goto L13;
        Integer r7 = r6.getNexPulseType();
        if (r7 == null) goto L13;
        r1 = r7.intValue();
    L13:
        r4.put("nex_pulse_type", r1);
        r4.put("req_src", r5.d);
        r4.put("enter_chat_times", b.get());
        r4.put("is_from_push", o0.d(r5.c.a()));
        NexPulseResponseData r8 = r5.i;
        if (r8 == null) goto L20;
        NexPulseConf r9 = r8.getConf();
        if (r9 == null) goto L20;
        Long r10 = r9.getFreqControlInterval();
        if (r10 == null) goto L20;
        long r11 = r10.longValue();
    L21:
        r4.put("freq_control_interval", r11);
        NexPulseResponseData r12 = r5.i;
        if (r12 == null) goto L26;
        NexPulseConf r13 = r12.getConf();
        if (r13 == null) goto L26;
        String r14 = r13.getThroughToken();
    L27:
        r4.put("through_token", String.valueOf(r14));
        String r15 = r5.c.a();
        if (r15 == null) goto L30;
        r4.put("push_content_id", r15);
    L30:
        String r16 = r5.c.b();
        if (r16 == null) goto L34;
        r4.put("ug_advertise_schema", r16);
        return;
    L34:
        return;
    L26:
        r14 = null;
    L20:
        r11 = -1;
    L7:
        r3 = 0;
        goto L8
    }

    public static void b(JSONObject r5, jx9.a r6) {
        Long r7 = Long.valueOf(r6.h);
        if (r7.longValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r7 = null;
    L9:
        if (r7 == null) goto L12;
        long r1 = r7.longValue();
        r5.put("wcb_update_interval", (System.currentTimeMillis() - r1) / 1000);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void c(jx9.a r5, String r6, long r7, boolean r9) {
        Intrinsics.checkNotNullParameter(r5, "traceData");
        Intrinsics.checkNotNullParameter(r6, "errorMessage");
        FLogger r0 = FLogger.a;
        r0.d("WcbLog", "[monitorException] intercept nexPulse resp: " + r6);
        JSONObject r1 = new JSONObject();
        r1.put("success", "0");
        r1.put("error_code", r7);
        r1.put("error_msg", r6);
        b(r1, r5);
        a(r1, r5);
        if (r9 == false) goto L5;
        r0.e("WcbLog", "intercept nexPulse resp: " + r6);
    L5:
        o.a.reportEvent("dev_wcb_monitor_event", r1);
    }

    public static /* synthetic */ void d(a r2, jx9.a r3, String r4, boolean r5, int r6) {
        if ((r6 & 8) == 0) goto L5;
        r5 = false;
    L5:
        r2.getClass();
        c(r3, r4, 0, r5);
    }
}
