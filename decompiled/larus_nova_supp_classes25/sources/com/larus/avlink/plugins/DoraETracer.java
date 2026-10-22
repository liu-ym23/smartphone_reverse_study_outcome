package com.larus.avlink.plugins;

import com.larus.avlink.annoatation.DoraImageMode;
import com.larus.avlink.e.DoraImageManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraETracer {
    public static Pair<String, Boolean> a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/plugins/DoraETracer$DoraEMessageType;", "", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DoraEMessageType {
        public static final a Companion = null;
        public static final String IMAGE = "visual_query";
        public static final String VOICE = "voice_query";
        public static final String VOICE_AND_IMAGE = "voice_and_visual_query";

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @DoraEMessageType
            public static String a(Integer r2) {
                if (r2 == null) goto L15;
                r2.intValue();
                if (r2.intValue() != 1) goto L8;
                return DoraEMessageType.VOICE;
            L8:
                if (r2.intValue() != 6) goto L12;
                return DoraEMessageType.IMAGE;
            L12:
                if (r2.intValue() != 20) goto L17;
                return DoraEMessageType.VOICE_AND_IMAGE;
            L17:
                return null;
            L15:
                return null;
            }
        }

        static {
            Companion = a.a;
        }
    }

    static {
        a = TuplesKt.to("", Boolean.FALSE);
    }

    public static void a(Map r4, com.larus.avlink.model.a r5) {
        r4.put("pic_id", r5.a);
        r4.put("image_mode", Integer.valueOf(r5.m));
        r4.put("intent_mode", r5.n);
        r4.put("width", Integer.valueOf(r5.b));
        r4.put("height", Integer.valueOf(r5.c));
        StringBuilder r0 = new StringBuilder();
        r0.append(r5.b);
        r0.append('_');
        r0.append(r5.c);
        r4.put("resolution", r0.toString());
        DoraImageMode.a r1 = DoraImageMode.Companion;
        Integer r2 = Integer.valueOf(r5.m);
        r1.getClass();
        r4.put("is_env_observer", Integer.valueOf(DoraImageMode.a.a(r2) ? 1 : 0));
        r4.put("is_live_ai", Integer.valueOf(r5.f));
        r4.put("quality_value", Integer.valueOf(r5.d));
        r4.put("definition_value", Integer.valueOf(r5.e));
        r4.put("link_type", Integer.valueOf(r5.C));
        r4.put("format", Integer.valueOf(r5.D));
        Integer r3 = Integer.valueOf(r5.m);
        if (r3 != null) goto L6;
    L8:
        String r6 = "dora_call";
    L9:
        r4.put("scene", r6);
        r4.put("count", Integer.valueOf(r5.k));
        Iterator r7 = CollectionsKt.filterNotNull(r5.l).iterator();
        long r8 = 0;
    L11:
        if (r7.hasNext() == false) goto L13;
        r8 = r8 + ((long) ((byte[]) r7.next()).length);
        goto L11
    L13:
        r4.put("size", Long.valueOf(r8));
        return;
    L6:
        if (r3.intValue() != 6) goto L8;
        r6 = "dora_radio";
        goto L9
    }

    public static void b(Map r3, a5 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        r3.put("is_rtc", Integer.valueOf(r4.a ? 1 : 0));
        r3.put("is_mmt", Integer.valueOf(r4.b ? 1 : 0));
        r3.put("av_session_type", Integer.valueOf(r4.c));
        int r0 = r4.e;
        r3.put("is_live_ai", Integer.valueOf(v88.a.c(Integer.valueOf(r0)) ? 1 : 0));
        r3.put("is_env_observer", Integer.valueOf(v88.a.b(Integer.valueOf(r0)) ? 1 : 0));
        if (r4.d == false) goto L7;
        String r5 = "video";
    L8:
        r3.put("trans_mode", r5);
        return;
    L7:
        r5 = "image";
        goto L8
    }

    public static void c(int r3, int r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("status", 0);
        r0.put("type", Integer.valueOf(r3));
        r0.put("reason", Integer.valueOf(r4));
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L6;
        r5.A0("dora_g_observation_status", r0);
        return;
    }

    public static void d(int r11, Map r12) {
        Intrinsics.checkNotNullParameter(r12, "map");
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, com.larus.avlink.model.a> r1 = DoraImageManager.a;
        com.larus.avlink.model.a r2 = DoraImageManager.a(Integer.valueOf(r11));
        com.larus.avlink.n1.d("DoraETracer", "reportOCRResult picModel: " + r2);
        if (r2 != null) goto L5;
        return;
    L5:
        Long r3 = r2.t;
        if (r3 == null) goto L8;
        long r4 = r3.longValue();
    L9:
        Long r5 = r2.u;
        if (r5 == null) goto L12;
        long r6 = r5.longValue();
    L13:
        Long r7 = r2.v;
        if (r7 == null) goto L16;
        long r8 = r7.longValue();
    L17:
        Long r9 = r2.w;
        if (r9 == null) goto L20;
        long r10 = r9.longValue();
    L21:
        r0.put("pic_id", Integer.valueOf(r11));
        r0.put("image_mode", Integer.valueOf(r2.m));
        r0.put("upload_duration", Long.valueOf(r10 - r8));
        r0.put("transmit_duration", Long.valueOf(r6 - r4));
        r0.put("total_duration", Long.valueOf(r10 - r4));
        r0.putAll(r12);
        IDoraService r13 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r13 == null) goto L25;
        r13.A0("flow_dora_vision_image_ocr_result", r0);
        return;
    L25:
        return;
    L20:
        r10 = System.currentTimeMillis();
        goto L21
    L16:
        r8 = System.currentTimeMillis();
        goto L17
    L12:
        r6 = System.currentTimeMillis();
        goto L13
    L8:
        r4 = System.currentTimeMillis();
        goto L9
    }

    public static void e(String r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("scene", r2);
        r1.put("intention_mode", Integer.valueOf(r3));
        r1.put("duration", Long.valueOf(r4));
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L6;
        r5.A0("flow_dora_vision_intention_identification", r1);
        return;
    }
}
