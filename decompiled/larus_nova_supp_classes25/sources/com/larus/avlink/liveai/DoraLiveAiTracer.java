package com.larus.avlink.liveai;

import a98.a;
import com.larus.avlink.plugins.k4;
import com.larus.avlink.plugins.n4;
import com.larus.avlink.plugins.x2;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w98.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraLiveAiTracer {
    public static long a;
    public static boolean b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/liveai/DoraLiveAiTracer$ModelProactiveFailReason;", "", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ModelProactiveFailReason {
        public static final a Companion = null;
        public static final String EMPTY = "";
        public static final String EMPTY_QUEUE_ID = "empty_queue_id";
        public static final String EMPTY_SESSION = "empty_session";
        public static final String IN_INTERACTING = "in_interacting";
        public static final String NOT_IN_LIVE_AI = "not_in_live_ai";
        public static final String REPEAT_QUEUE_ID = "repeat_queue_id";

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/liveai/DoraLiveAiTracer$ModelProactiveStage;", "", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ModelProactiveStage {
        public static final a Companion = null;
        public static final int RECEIVE_COMMAND = 2;
        public static final int TRIGGER = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/liveai/DoraLiveAiTracer$ModelProactiveStatus;", "", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ModelProactiveStatus {
        public static final a Companion = null;
        public static final int FAIL = 0;
        public static final int SUCCESS = 1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    static {
    }

    public static int f() {
        Map<Function1<Boolean, Unit>, k4> r0 = x2.a;
        IDoraService r1 = x2.c();
        if (r1 == null) goto L9;
        AbilityService r2 = r1.o0();
        if (r2 == null) goto L9;
        boolean r3 = true;
        if (r2.k() != true) goto L9;
    L10:
        if (r3 == false) goto L13;
        return 2;
    L13:
        return 0;
    L9:
        r3 = false;
        goto L10
    }

    public static long a(Long r5, Long r6) {
        if (r5 == null) goto L7;
        if (r6 == null) goto L7;
        if (r5.longValue() < r6.longValue()) goto L7;
        return r5.longValue() - r6.longValue();
    L7:
        return -1;
    }

    public static void b(d r7, n4 r8) {
        Intrinsics.checkNotNullParameter(r7, "model");
        Intrinsics.checkNotNullParameter(r8, "context");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("frame_received_count", Integer.valueOf(r7.g()));
        r0.put("frame_upload_count", Integer.valueOf(r7.h()));
        r0.put("frame_upload_count_before_compensation", Integer.valueOf(r7.a()));
        Object r2 = r7.d;
        monitor-enter(r2);
        long r3 = r7.f;     // Catch: Throwable -> L12
        int r5 = r7.e;     // Catch: Throwable -> L12
        if (r5 <= 0) goto L8;
        int r4 = (int) (r3 / ((long) r5));
    L9:
        monitor-exit(r2);
        r0.put("frame_width", Integer.valueOf(r4));
        r0.put("frame_height", Integer.valueOf(r7.b()));
        r0.put("frame_upload_duration", Integer.valueOf(r7.e()));
        r0.put("frame_transmit_duration", Integer.valueOf(r7.d()));
        r0.put("ocr_count", Integer.valueOf(r7.f()));
        r0.put("ocr_transmit_duration", Integer.valueOf(r7.c()));
        r0.put("conversation_duration", Long.valueOf(System.currentTimeMillis() - r7.a));
        r0.put("mode", Integer.valueOf(r7.b));
        r0.put("trans_type", Integer.valueOf(f()));
        r0.put("av_session_type", Integer.valueOf(r8.params().s.getType()));
        Map<Function1<Boolean, Unit>, k4> r9 = x2.a;
        x2.e("dora_conversation_frame_info", r0);
        return;
    L8:
        r4 = 0;
    L12:
        th = move-exception;
        throw th;
    }

    public static void e(String r3, String r4, int r5) {
        a = System.currentTimeMillis();
        b = true;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("start_type", r4);
        String r6 = a.b;
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r0.put("conversation_id", r6);
        String r7 = a.a;
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r0.put("bot_id", r7);
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r0.put("call_id", r3);
        r0.put("mode", Integer.valueOf(r5));
        Map<Function1<Boolean, Unit>, k4> r8 = x2.a;
        x2.e("dora_companion_mode_start", r0);
    }

    public static void c(@ModelProactiveStage int r3, String r4, @ModelProactiveStatus int r5, @ModelProactiveFailReason String r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("dora_proactive_type", "model_proactive");
        r0.put("dora_proactive_stage", Integer.valueOf(r3));
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.put("dora_proactive_id", r4);
        r0.put("status", Integer.valueOf(r5));
        r0.put("fail_reason", r6);
        Map<Function1<Boolean, Unit>, k4> r7 = x2.a;
        x2.e("dora_model_proactive_client_receive", r0);
    }

    public static void d(String r6, String r7, int r8, Integer r9) {
        Intrinsics.checkNotNullParameter(r7, "startType");
        if (b == true) goto L6;
        return;
    L6:
        if (a <= 0) goto L8;
        long r0 = System.currentTimeMillis() - a;
        a = 0;
    L9:
        LinkedHashMap r2 = new LinkedHashMap();
        String r3 = a.b;
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        r2.put("conversation_id", r3);
        String r4 = a.a;
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        r2.put("bot_id", r4);
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        r2.put("call_id", r6);
        r2.put("start_type", r7);
        if (r9 != null) goto L22;
    L24:
        if (r9 != null) goto L27;
    L29:
        if (r9 != null) goto L32;
    L34:
        if (r9 != null) goto L37;
    L39:
        if (r9 != null) goto L42;
    L44:
        if (r9 != null) goto L47;
    L49:
        if (r9 != null) goto L52;
    L54:
        String r10 = "gesture";
    L55:
        r2.put("end_type", r10);
        r2.put("duration", Long.valueOf(r0));
        r2.put("mode", Integer.valueOf(r8));
        Map<Function1<Boolean, Unit>, k4> r11 = x2.a;
        x2.e("dora_companion_mode_end", r2);
        b = false;
        return;
    L52:
        if (r9.intValue() != 130) goto L54;
        r10 = "vui_error";
        goto L55
    L47:
        if (r9.intValue() != 101) goto L49;
        r10 = "wear_state";
        goto L55
    L42:
        if (r9.intValue() != 111) goto L44;
    L43:
        r10 = "voice_command";
        goto L55
    L37:
        if (r9.intValue() != 113) goto L39;
    L32:
        if (r9.intValue() != 115) goto L34;
    L27:
        if (r9.intValue() != 100) goto L29;
        r10 = "headset_disconnected";
        goto L55
    L22:
        if (r9.intValue() != 11) goto L24;
        r10 = "long_press";
        goto L55
    L8:
        r0 = -1;
        goto L9
    }
}
