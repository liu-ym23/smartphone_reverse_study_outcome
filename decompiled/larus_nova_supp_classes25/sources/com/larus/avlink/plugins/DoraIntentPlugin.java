package com.larus.avlink.plugins;

import com.google.gson.Gson;
import com.larus.audio.call.mgr.MajorState;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraIntentPlugin extends com.larus.audio.call.arch.a<n4> implements com.larus.audio.call.arch.e {
    public static DoraIntentPlugin g;
    public static final Map<Long, Long> h = null;
    public volatile boolean f;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.avlink.plugins.DoraIntentPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0020a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[DoraIntentType.values().length];
                r0[DoraIntentType.TAKE_PHOTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[DoraIntentType.START_VIDEO_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[DoraIntentType.END_SESSION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[DoraIntentType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public static void a(f1 r8) {
            DoraIntentType[] r0 = DoraIntentType.values();
            int r1 = r0.length;
            int r3 = 0;
        L4:
            if (r3 >= r1) goto L15;
            DoraIntentType r5 = r0[r3];
            int r6 = r5.getType();
            Integer r7 = r8.b();
            if (r7 != null) goto L9;
        L11:
            boolean r9 = false;
        L12:
            if (r9 == true) goto L16;
            r3 = r3 + 1;
        L16:
            if (r5 != null) goto L18;
            r5 = DoraIntentType.UNKNOWN;
        L18:
            com.larus.avlink.n1.d("DoraIntentPlugin", "handleDoraIntent param: " + r8 + ", intent: " + r5);
            int r10 = C0020a.a[r5.ordinal()];
            if (r10 != 1) goto L21;
            IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r11 == null) goto L50;
            VisionService r12 = r11.V();
            if (r12 == null) goto L51;
            r12.f();
            return;
        L51:
            return;
        L50:
            return;
        L21:
            if (r10 != 2) goto L23;
            IDoraService r13 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r13 == null) goto L47;
            VisionService r14 = r13.V();
            if (r14 == null) goto L48;
            r14.g();
            return;
        L48:
            return;
        L47:
            return;
        L23:
            if (r10 != 3) goto L25;
            IDoraService r15 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r15 == null) goto L45;
            r15.h1(DoraCallStateCode.CLIENT_INTENT, false);
            return;
        L45:
            return;
        L25:
            if (r10 != 4) goto L28;
            return;
        L28:
            throw new NoWhenBranchMatchedException();
        L9:
            if (r6 != r7.intValue()) goto L11;
            r9 = true;
            goto L12
        L15:
            r5 = null;
            goto L16
        }
    }

    public static final class b extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ DoraIntentPlugin b;

        public final String g() {
            return this.a;
        }

        public b(DoraIntentPlugin r1) {
            this.b = r1;
            r1.getClass();
            this.a = "DoraIntentPlugin";
        }

        public final void n(com.larus.im.service.audio.z0.a r12) {
            Intrinsics.checkNotNullParameter(r12, "event");
            if ((r12 instanceof pf9.o) == false) goto L6;
            this.b.getClass();
            com.larus.avlink.n1.d("DoraIntentPlugin", "onReceiveEvent FlowLLMCallStartedEvent");
            this.b.f = true;
            return;
        L6:
            if ((r12 instanceof pf9.q) == false) goto L56;
            this.b.getClass();
            List r13 = ((pf9.q) r12).a;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator r14 = r13.iterator();
        L9:
            if (r14.hasNext() == false) goto L57;
            pf9.p r2 = (pf9.p) r14.next();
            Long r3 = r2.a;
            if (r3 == null) goto L48;
            int r4 = (int) r3.longValue();
            JSONObject r5 = new JSONObject();
            Map r6 = r2.b;
            if (r6 == null) goto L19;
            Iterator r7 = r6.entrySet().iterator();
        L16:
            if (r7.hasNext() == false) goto L19;
            Map.Entry r8 = (Map.Entry) r7.next();
            r5.putOpt((String) r8.getKey(), r8.getValue());
        L19:
            if (r4 != 27) goto L48;
            Gson r9 = ha8.a.a;
            f1 r10 = (f1) ha8.a.a(r5.optString("interact_intention"), f1.class);
            if (r10 == null) goto L48;
            com.larus.avlink.n1.d("DoraIntentPlugin", "intentModel: " + r10);
            Integer r11 = r10.c();
            if (r11 != null) goto L26;
        L32:
            Long r15 = null;
        L34:
            if (r10.b() != null) goto L36;
        L47:
            DoraIntentPlugin r16 = DoraIntentPlugin.g;
            a.a(r10);
            goto L48
        L36:
            if (r10.c() == null) goto L47;
            Pair<String, Boolean> r17 = DoraETracer.a;
            Long r18 = r10.a();
            if (r18 == null) goto L40;
            long r19 = r18.longValue();
        L41:
            int r20 = r10.b().intValue();
            int r21 = r10.c().intValue();
            LinkedHashMap r22 = new LinkedHashMap();
            r22.put("intent_type", Integer.valueOf(r20));
            r22.put("intent_source", Integer.valueOf(r21));
            r22.put("intent_id", Long.valueOf(r19));
            if (r15 == null) goto L44;
            r22.put("duration", Long.valueOf(r15.longValue()));
        L44:
            IDoraService r23 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r23 == null) goto L47;
            r23.A0("dora_server_intent_received", r22);
            goto L47
        L40:
            r19 = 0;
            goto L41
        L26:
            if (r11.intValue() != 4) goto L32;
            Long r24 = r10.a();
            if (r24 == null) goto L32;
            Long r25 = DoraIntentPlugin.h.get(Long.valueOf(r24.longValue()));
            com.larus.avlink.n1.d("DoraIntentPlugin", "traceDoraIntent intentModel: " + r10 + ", intentReceivedTime: " + r25);
            if (r25 == null) goto L32;
            r15 = Long.valueOf(System.currentTimeMillis() - r25.longValue());
        L48:
            r0.add(r2);
            goto L9
        L57:
            return;
        }
    }

    public final String T2() {
        return "DoraIntentPlugin";
    }

    static {
        h = Collections.synchronizedMap(new DoraIntentPlugin$Companion$doraIntents$1());
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    public final void e3() {
        super.e3();
        g = this;
    }

    public final void g3() {
        super.g3();
        g = null;
    }

    public DoraIntentPlugin(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final h j3(int r8, long r9) {
        MajorState.d r0 = ((n4) getContext()).a().s1();
        com.larus.avlink.n1.d("DoraIntentPlugin", "tryUploadDoraIntent sessionStarted: " + this.f + " avSessionType: " + ((n4) getContext()).params().s + ", state: " + r0);
        if (this.f == true) goto L6;
        h r1 = new h(false, NotUploadReason.SESSION_NOT_STARTED);
    L25:
        if (r1.a == false) goto L30;
        h.put(Long.valueOf(r9), Long.valueOf(System.currentTimeMillis()));
        JSONObject r2 = new JSONObject();
        r2.put("intent_type", r8);
        r2.put("source", 4);
        r2.put("id", r9);
        JSONObject r10 = new JSONObject();
        r10.put("client_intent", r2.toString());
        id9.d r11 = ((n4) getContext()).j();
        if (r11 == null) goto L29;
        r11.p(TriggerMode.CLIENT_INTENT, r10.toString());
    L29:
        com.larus.avlink.n1.d("DoraIntentPlugin", "tryUploadDoraIntent trigger CLIENT_INTENT, action:" + r10);
    L30:
        return r1;
    L6:
        if (((n4) getContext()).params().s != AudioSessionType.SAMI) goto L9;
        r1 = new h(false, NotUploadReason.SESSION_TYPE_NOT_SUPPORT);
        goto L25
    L9:
        if ((r0 instanceof MajorState.d) == false) goto L17;
        MajorState.d r3 = r0;
        if (r3.d != MajorState.InterruptType.NOTHING) goto L17;
        MajorState.From r4 = r3.c;
        if (r4 != MajorState.From.PLAY_COMPLETE) goto L15;
    L16:
        boolean r5 = true;
    L19:
        if (Intrinsics.areEqual(r0, MajorState.j.c) == true) goto L23;
        if (r5 == true) goto L23;
        r1 = new h(true, NotUploadReason.UNKNOWN);
    L23:
        r1 = new h(false, NotUploadReason.BEFORE_ASR);
        goto L25
    L15:
        if (r4 == MajorState.From.TTS_ENDED) goto L16;
    L17:
        r5 = false;
        goto L19
    }
}
