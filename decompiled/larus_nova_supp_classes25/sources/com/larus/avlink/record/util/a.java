package com.larus.avlink.record.util;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.larus.avlink.n1;
import com.larus.dora.api.IDoraService;
import com.larus.network.bean.BizResponse;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.larus.avlink.record.util.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0025a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RetryTrigger.values().length];
            r0[RetryTrigger.BACKOFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[RetryTrigger.NETWORK_RECOVERY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[RetryTrigger.INITIAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public a() {
    }

    public static String b(BizResponse r5) {
        if (r5 == null) goto L30;
        SsResponse r6 = r5.getSSResponse();
        if (r6 == null) goto L31;
        List r7 = r6.headers();
        if (r7 == null) goto L33;
        Iterator r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L20;
        Object r1 = r8.next();
        Header r2 = (Header) r1;
        if (r2 == null) goto L17;
        boolean r4 = true;
        if (StringsKt.equals(r2.getName(), "x-tt-logid", true) == false) goto L17;
    L18:
        if (r4 == false) goto L11;
    L21:
        Header r3 = (Header) r1;
        if (r3 != null) goto L24;
        return null;
    L24:
        return r3.getValue();
    L17:
        r4 = false;
        goto L18
    L20:
        r1 = null;
        goto L21
    L33:
        return null;
    L31:
        return null;
    L30:
        return null;
    }

    public static void d(Map r4, s r5) {
        boolean r1 = false;
        if (r5.a <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r2 = "1";
    L9:
        r4.put("is_retry", r2);
        r4.put("retry_attempt", Integer.valueOf(r5.a));
        if (r5.a <= 0) goto L12;
        r1 = true;
    L12:
        if (r1 == true) goto L14;
        return;
    L14:
        RetryTrigger r3 = r5.b;
        int r6 = C0025a.a[r3.ordinal()];
        if (r6 != 1) goto L17;
        r4.put("retry_trigger", "backoff");
        r4.put("retry_delay_sec", Integer.valueOf(r5.c));
        return;
    L17:
        if (r6 != 2) goto L19;
        r4.put("retry_trigger", "network_recovery");
        return;
    L19:
        if (r6 != 3) goto L22;
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    L8:
        r2 = "0";
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public static void e(String r2, Map r3) {
        n1.d("DoraRecordMinutesReporter", "report " + r2 + ", params=" + r3);
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L6;
        r0.A0(r2, r3);
        return;
    }

    public static Map a(boolean r4, String r5, String r6, String r7, Integer r8, long r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == false) goto L5;
        String r10 = "success";
    L6:
        r0.put("result", r10);
        boolean r11 = false;
        if (r5 != null) goto L9;
    L17:
        if (r6 != null) goto L19;
    L27:
        if (r7 != null) goto L29;
    L36:
        if (r8 == null) goto L38;
        r0.put("product_id", Integer.valueOf(r8.intValue()));
    L38:
        r0.put("cost_ms", Long.valueOf(r9));
        return r0;
    L29:
        if (r7.length() <= 0) goto L31;
        r11 = true;
    L31:
        if (r11 == true) goto L34;
        r7 = null;
    L34:
        if (r7 == null) goto L36;
        r0.put("start_type", r7);
        goto L36
    L19:
        if (r6.length() <= 0) goto L21;
        boolean r12 = true;
    L22:
        if (r12 == true) goto L25;
        r6 = null;
    L25:
        if (r6 == null) goto L27;
        r0.put("recording_id", r6);
        goto L27
    L21:
        r12 = false;
        goto L22
    L9:
        if (r5.length() <= 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L17;
        r0.put("request_id", r5);
        goto L17
    L11:
        r3 = false;
        goto L12
    L5:
        r10 = "failure";
        goto L6
    }

    public static void c(Map r4, String r5, String r6, String r7, String r8, String r9) {
        boolean r0 = false;
        if (r5 != null) goto L5;
    L13:
        if (r6 != null) goto L15;
    L23:
        if (r7 != null) goto L25;
    L33:
        if (r8 != null) goto L35;
    L43:
        if (r9 != null) goto L45;
        return;
    L45:
        if (r9.length() <= 0) goto L47;
        r0 = true;
    L47:
        if (r0 == true) goto L50;
        r9 = null;
    L50:
        if (r9 == null) goto L54;
        r4.put("server_log_id", r9);
        return;
    L54:
        return;
    L35:
        if (r8.length() <= 0) goto L37;
        boolean r10 = true;
    L38:
        if (r10 == true) goto L41;
        r8 = null;
    L41:
        if (r8 == null) goto L43;
        r4.put("error_message", r8);
        goto L43
    L37:
        r10 = false;
        goto L38
    L25:
        if (r7.length() <= 0) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == true) goto L31;
        r7 = null;
    L31:
        if (r7 == null) goto L33;
        r4.put("error_code", r7);
        goto L33
    L27:
        r11 = false;
        goto L28
    L15:
        if (r6.length() <= 0) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == true) goto L21;
        r6 = null;
    L21:
        if (r6 == null) goto L23;
        r4.put("failure_reason", r6);
        goto L23
    L17:
        r12 = false;
        goto L18
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L13;
        r4.put("failure_type", r5);
        goto L13
    L7:
        r3 = false;
        goto L8
    }

    public static void f(boolean r10, String r11, Integer r12, long r13, String r15, String r16, String r17) {
        Map r0 = a(r10, null, r11, null, r12, r13);
        if (r10 == true) goto L5;
        c(r0, "interface", "delete_recording_request_failed", r15, r16, r17);
    L5:
        e("dora_record_minutes_delete_online_result", r0);
    }

    public static void m(boolean r7, String r8, Integer r9, long r10, String r12, String r13, int r14) {
        if ((r14 & 32) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 64) == 0) goto L8;
        r13 = null;
    L8:
        Map r15 = a(r7, null, r8, null, r9, r10);
        if (r7 == true) goto L12;
        c(r15, "sdk", "sdk_upload_submit_failed", r12, r13, null);
    L12:
        e("dora_record_minutes_upload_offline_result", r15);
    }

    public static /* synthetic */ void g(boolean r10, String r11, Integer r12, long r13, String r15, String r16, String r17, int r18) {
        if ((r18 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r18 & 64) == 0) goto L13;
        String r9 = null;
    L14:
        f(r10, r11, r12, r13, r7, r8, r9);
        return;
    L13:
        r9 = r17;
        goto L14
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    public static void i(boolean r8, String r9, String r10, String r11, Integer r12, String r13, long r14, String r16, String r17, s r18) {
        Intrinsics.checkNotNullParameter(r18, "retryContext");
        Map r1 = a(r8, r9, r10, r11, r12, r14);
        if (r13 != null) goto L5;
    L13:
        d(r1, r18);
        if (r8 == true) goto L16;
        c(r1, "sdk", "sdk_retry_create_failed", r16, r17, null);
    L16:
        e("dora_record_minutes_retry_create_result", r1);
        return;
    L5:
        if (r13.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        String r3 = r13;
    L11:
        if (r3 == null) goto L13;
        r1.put("message_id", r3);
        goto L13
    L10:
        r3 = null;
        goto L11
    L7:
        r2 = false;
        goto L8
    }

    public static void j(boolean r7, String r8, String r9, String r10, Integer r11, int r12, long r13, String r15, String r16, String r17, String r18) {
        Map r0 = a(r7, r8, r9, r10, r11, r13);
        r0.put("channel_count", Integer.valueOf(r12));
        if (r7 == true) goto L5;
        c(r0, r15, r16, r17, r18, null);
    L5:
        e("dora_record_minutes_start_result", r0);
    }

    public static void k(boolean r8, String r9, String r10, String r11, Integer r12, String r13, long r14, String r16, String r17, String r18, String r19, String r20, s r21) {
        Intrinsics.checkNotNullParameter(r21, "retryContext");
        Map r1 = a(r8, r9, r10, r11, r12, r14);
        String r2 = null;
        if (r13 != null) goto L5;
    L13:
        d(r1, r21);
        if (r8 == false) goto L16;
    L19:
        e("dora_record_minutes_to_online_result", r1);
        return;
    L16:
        if (Intrinsics.areEqual(r16, "interface") == false) goto L18;
        r2 = r20;
    L18:
        c(r1, r16, r17, r18, r19, r2);
        goto L19
    L5:
        if (r13.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        String r4 = r13;
    L11:
        if (r4 == null) goto L13;
        r1.put("message_id", r4);
        goto L13
    L10:
        r4 = null;
        goto L11
    L7:
        r3 = false;
        goto L8
    }

    public static void h(boolean r14, String r15, String r16, String r17, Integer r18, String r19, long r20, String r22, String r23, String r24, String r25, String r26, s r27, int r28) {
        String r3 = null;
        if ((r28 & 128) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r28 & 256) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r28 & 512) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r28 & 1024) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r28 & 2048) == 0) goto L21;
        String r1 = null;
    L22:
        Intrinsics.checkNotNullParameter(r27, "retryContext");
        Map r7 = a(r14, r15, r16, r17, r18, r20);
        boolean r8 = true;
        if (r19 != null) goto L25;
    L33:
        d(r7, r27);
        if (r14 == false) goto L44;
        if (r2 != null) goto L37;
    L45:
        e("dora_record_minutes_lark_record_start_result", r7);
        return;
    L37:
        if (r2.length() > 0) goto L40;
        r8 = false;
    L40:
        if (r8 == false) goto L42;
        r3 = r2;
    L42:
        if (r3 == null) goto L45;
        r7.put("message_id", r3);
        goto L45
    L44:
        c(r7, "interface", r4, r5, r6, r1);
        goto L45
    L25:
        if (r19.length() <= 0) goto L27;
        boolean r10 = true;
    L28:
        if (r10 == false) goto L30;
        String r11 = r19;
    L31:
        if (r11 == null) goto L33;
        r7.put("source_message_id", r11);
        goto L33
    L30:
        r11 = null;
        goto L31
    L27:
        r10 = false;
        goto L28
    L21:
        r1 = r26;
        goto L22
    L17:
        r6 = r25;
        goto L19
    L13:
        r5 = r24;
        goto L15
    L9:
        r4 = r23;
        goto L11
    L5:
        r2 = r22;
        goto L7
    }

    public static /* synthetic */ void l(boolean r17, String r18, String r19, String r20, Integer r21, String r22, long r23, String r25, String r26, String r27, String r28, String r29, s r30, int r31) {
        if ((r31 & 128) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r31 & 256) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r31 & 512) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r31 & 1024) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r31 & 2048) == 0) goto L21;
        String r15 = null;
    L22:
        k(r17, r18, r19, r20, r21, r22, r23, r11, r12, r13, r14, r15, r30);
        return;
    L21:
        r15 = r29;
        goto L22
    L17:
        r14 = r28;
        goto L19
    L13:
        r13 = r27;
        goto L15
    L9:
        r12 = r26;
        goto L11
    L5:
        r11 = r25;
        goto L7
    }
}
