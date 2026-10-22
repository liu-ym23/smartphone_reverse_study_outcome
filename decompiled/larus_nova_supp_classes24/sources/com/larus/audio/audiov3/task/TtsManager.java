package com.larus.audio.audiov3.task;

import com.bytedance.flow_audio.api.tracer.FlowTtsTraceHelper;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.audiov3.task.sami.v2.TtsCacheTask;
import com.larus.audio.audiov3.task.sami.v2.h0;
import com.larus.audio.audiov3.task.sami.v2.l0;
import com.larus.audio.audiov3.task.tts.TtsType;
import com.larus.audio.flow.client.cache.TtsCacheManager;
import com.larus.audio.flow.client.cache.d;
import g68.e;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import l68.b;
import m58.h;
import m58.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class TtsManager implements e {
    public static final TtsManager a = null;
    public static final ConcurrentHashMap<String, l68.a> b = null;
    public static final TtsManager$mTTsMsgMap$1 c = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TtsType.values().length];
            r0[TtsType.TTS_BY_MSG_ID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TtsType.TTS_BY_TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public TtsManager() {
    }

    static {
        a = new TtsManager();
        b = new ConcurrentHashMap();
        c = new TtsManager$mTTsMsgMap$1();
    }

    public static b e(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        l68.a r2 = b.get(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getListener();
    }

    @Override // g68.e
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        b.remove(r2);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // g68.e
    public final void cancel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        l68.a r3 = b.get(r2);
        if (r3 == null) goto L6;
        r3.cancel();
        return;
    }

    @Override // g68.e
    public final void start(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        l68.a r0 = b.get(r2);
        if (r0 == null) goto L5;
        r0.start();
    L5:
        TtsTracer r3 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r2);
        if (r3 == null) goto L9;
        r3.startCallSami();
        return;
    }

    @Override // g68.e
    public final void stop(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        l68.a r3 = b.get(r2);
        if (r3 == null) goto L6;
        r3.stop();
        return;
    }

    @Override // g68.e
    public final void b(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        l68.a r4 = b.get(r2);
        if (r4 == null) goto L6;
        r4.a(r3);
        return;
    }

    @Override // g68.e
    public final void d(String r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "listener");
        l68.a r4 = b.get(r2);
        if (r4 == null) goto L6;
        r4.b(r3);
        return;
    }

    @Override // g68.e
    public final void a(String r7, z58.a r8, TtsType r9) {
        Intrinsics.checkNotNullParameter(r7, "taskId");
        Intrinsics.checkNotNullParameter(r8, "config");
        Intrinsics.checkNotNullParameter(r9, "type");
        boolean r2 = false;
        if (r7.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L48;
        Lazy r1 = TtsCacheManager.a;
        Intrinsics.checkNotNullParameter(r8, "ttsConfig");
        t r3 = h.m;
        if (r3 != null) goto L10;
    L12:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L16;
        c68.b.d("TtsCacheManager", "tts cache is disabled");
    L33:
        if (r2 == false) goto L35;
        b.put(r7, new TtsCacheTask());
    L43:
        l68.a r10 = b.get(r7);
        if (r10 == null) goto L46;
        r10.e(r8, FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r7));
    L46:
        c.put(r8.c, r7);
        return;
    L35:
        int r11 = a.a[r9.ordinal()];
        if (r11 != 1) goto L38;
        b.put(r7, new h0());
        goto L43
    L38:
        if (r11 != 2) goto L41;
        b.put(r7, new l0());
        goto L43
    L41:
        throw new NoWhenBranchMatchedException();
    L16:
        String r5 = r8.c;
        if (Intrinsics.areEqual(TtsCacheManager.g, r5) == false) goto L19;
        int r6 = c68.b.a;
        c68.b.d("TtsCacheManager", "ignore messageId = " + r5);
        goto L33
    L19:
        String r12 = r8.h;
        if (r12.length() != 0) goto L22;
        boolean r13 = true;
    L23:
        String r14 = "{}";
        if (r13 == false) goto L26;
        r12 = "{}";
    L26:
        String r15 = new JSONObject(r12).optString("post_process");
        if (r15.length() != 0) goto L29;
        r2 = true;
    L29:
        if (r2 == true) goto L32;
        r14 = r15;
    L32:
        String r16 = r8.e;
        String r17 = r8.v;
        TtsCacheManager.b = r5;
        TtsCacheManager.c = r16;
        TtsCacheManager.d = r14;
        TtsCacheManager.e = r17;
        r2 = TtsCacheManager.b(d.a(r5, r16, r14, r17));
        goto L33
    L22:
        r13 = false;
        goto L23
    L10:
        if (r3.enableTtsCache() != true) goto L12;
        r4 = true;
        goto L14
    L48:
        c68.b.b("TtsManager", "taskId is empty");
        return;
    L5:
        r0 = false;
        goto L6
    }
}
