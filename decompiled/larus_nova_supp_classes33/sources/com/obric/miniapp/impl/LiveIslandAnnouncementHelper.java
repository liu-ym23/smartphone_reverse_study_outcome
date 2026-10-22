package com.obric.miniapp.impl;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.d1;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LiveIslandAnnouncementHelper {
    public static final LiveIslandAnnouncementHelper a = null;
    public static final d1 b = null;
    public static final ConcurrentHashMap<String, Long> c = null;

    public LiveIslandAnnouncementHelper() {
    }

    static {
        a = new LiveIslandAnnouncementHelper();
        b = AudioServiceDelegate.a.i0();
        c = new ConcurrentHashMap();
    }

    public final Object a(JSONObject r24, Continuation<? super Unit> r25) {
        JSONObject r1 = r24;
        if ((r25 instanceof LiveIslandAnnouncementHelper$requestAndPlay$1) == false) goto L7;
        LiveIslandAnnouncementHelper$requestAndPlay$1 r3 = (LiveIslandAnnouncementHelper$requestAndPlay$1) r25;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        r1 = (JSONObject) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L17:
        k r8 = (k) r2;
        if (r8 != null) goto L22;
        return Unit.INSTANCE;
    L22:
        if (r8.a == true) goto L24;
        com.bytedance.ai.utils.g.a.i("LiveIslandAnnouncement", "playAnnouncement skip cause shouldSpeak=false");
    L118:
        return Unit.INSTANCE;
    L24:
        String r9 = r8.b;
        String r10 = null;
        if (r9 == null) goto L27;
        String r11 = StringsKt.trim(r9).toString();
    L28:
        String r12 = "";
        if (r11 != null) goto L32;
        r11 = "";
    L32:
        if (StringsKt.isBlank(r11) == false) goto L34;
        com.bytedance.ai.utils.g.a.i("LiveIslandAnnouncement", "playAnnouncement skip cause speakText is blank");
        goto L118
    L34:
        long r13 = System.currentTimeMillis();
        Long r14 = r8.d;
        if (r14 != null) goto L37;
    L42:
        r14 = null;
    L43:
        if (r14 != null) goto L45;
    L47:
        String r15 = r8.c;
        if (r15 != null) goto L50;
    L54:
        Object r16 = r1.opt("notice_id");
        if (r16 != null) goto L57;
    L83:
        r15 = r10;
    L84:
        if (r15 == null) goto L108;
        Iterator<Map.Entry<String, Long>> r17 = c.entrySet().iterator();
    L87:
        if (r17.hasNext() == false) goto L91;
        if (r17.next().getValue().longValue() > r13) goto L87;
        r17.remove();
        goto L87
    L91:
        ConcurrentHashMap<String, Long> r18 = c;
        Long r19 = r18.get(r15);
        if (r19 != null) goto L94;
    L96:
        if (r14 == null) goto L98;
        long r20 = r14.longValue();
    L99:
        r18.put(r15, Long.valueOf(r20));
        if (r18.size() <= 128) goto L105;
        String r21 = (String) CollectionsKt.firstOrNull(r18.keySet());
        if (r21 == null) goto L105;
        Long r22 = r18.remove(r21);
    L105:
        r7 = false;
    L106:
        if (r7 == false) goto L108;
        com.bytedance.ai.utils.g.a.i("LiveIslandAnnouncement", "playAnnouncement skip duplicate dedupeKey=".concat(r15));
        goto L118
    L98:
        r20 = 600000 + r13;
        goto L99
    L94:
        if (r19.longValue() <= r13) goto L96;
    L108:
        d1 r23 = b;
        String r26 = "live_island_" + System.currentTimeMillis();
        StringBuilder r27 = new StringBuilder("live_island_");
        if (r15 != null) goto L111;
        Object r28 = Long.valueOf(System.currentTimeMillis());
    L112:
        r27.append(r28);
        d1.a.a(r23, r26, null, r11, true, null, r27.toString(), null, false, true, null, null, null, null, 3792);
        com.bytedance.ai.utils.g r29 = com.bytedance.ai.utils.g.a;
        StringBuilder r30 = new StringBuilder("playAnnouncement start tts dedupeKey=");
        if (r15 == null) goto L116;
        r12 = r15;
    L116:
        r30.append(r12);
        r30.append(" textLen=");
        r30.append(r11.length());
        r29.i("LiveIslandAnnouncement", r30.toString());
        goto L118
    L111:
        r28 = r15;
        goto L112
    L57:
        if ((!Intrinsics.areEqual(r16, JSONObject.NULL)) == true) goto L60;
        r16 = null;
    L60:
        if (r16 == null) goto L83;
        String r31 = r16.toString();
        if (r31 == null) goto L83;
        if ((!StringsKt.isBlank(r31)) == true) goto L67;
        r31 = null;
    L67:
        if (r31 == null) goto L83;
        Object r32 = r1.opt("status");
        if (r32 == null) goto L83;
        if ((!Intrinsics.areEqual(r32, JSONObject.NULL)) == true) goto L74;
        r32 = null;
    L74:
        if (r32 == null) goto L83;
        String r33 = r32.toString();
        if (r33 == null) goto L83;
        if ((!StringsKt.isBlank(r33)) == true) goto L81;
        r33 = null;
    L81:
        if (r33 == null) goto L83;
        r10 = "notice_" + r31 + "_status_" + r33;
        goto L83
    L50:
        if ((!StringsKt.isBlank(r15)) == true) goto L53;
        r15 = null;
    L53:
        if (r15 != null) goto L84;
    L45:
        if (r13 <= r14.longValue()) goto L47;
        com.bytedance.ai.utils.g.a.i("LiveIslandAnnouncement", "playAnnouncement skip cause expired expireAtMs=" + r14);
        goto L118
    L37:
        if (r14.longValue() <= 0) goto L39;
        boolean r110 = true;
    L40:
        if (r110 == false) goto L42;
    L39:
        r110 = false;
        goto L40
    L27:
        r11 = null;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r3.L$0 = r1;
        r3.label = 1;
        r2 = b(r1, r3);
        if (r2 != r5) goto L17;
        return r5;
    L7:
        r3 = new LiveIslandAnnouncementHelper$requestAndPlay$1(this, r25);
        goto L8
    }

    public final Object b(JSONObject r8, Continuation<? super k> r9) {
        if ((r9 instanceof LiveIslandAnnouncementHelper$requestAnnouncement$1) == false) goto L7;
        LiveIslandAnnouncementHelper$requestAnnouncement$1 r0 = (LiveIslandAnnouncementHelper$requestAnnouncement$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L38:
        y r11 = (com.larus.network.http.a) r10;
        if (r11 != null) goto L43;
        com.bytedance.ai.utils.g.a.w("LiveIslandAnnouncement", "requestAnnouncement timeout after 3000ms path=https://platform-api.obriccloud.com/ocean/island/v1/get_tts_text");
        return null;
    L43:
        if ((r11 instanceof y) == false) goto L59;
        l r12 = (l) ((com.larus.network.http.a) r11).b;
        if (r12 != null) goto L47;
        com.bytedance.ai.utils.g.a.i("LiveIslandAnnouncement", "requestAnnouncement success but body is null");
        return null;
    L47:
        Boolean r13 = r12.d();
        if (r13 != null) goto L52;
        r13 = r12.c();
        if (r13 != null) goto L52;
        boolean r14 = false;
    L54:
        String r4 = r12.e();
        if (r4 != null) goto L64;
        r4 = r12.f();
    L64:
        return new k(r14, r4, r12.a(), r12.b());
    L52:
        r14 = r13.booleanValue();
        goto L54
    L59:
        if ((r11 instanceof com.larus.network.http.f) == false) goto L61;
        com.bytedance.ai.utils.g r5 = com.bytedance.ai.utils.g.a;
        StringBuilder r6 = new StringBuilder("requestAnnouncement failed code=");
        com.larus.network.http.f r15 = (com.larus.network.http.f) r11;
        r6.append(r15.d.getCode());
        r6.append(" msg=");
        r6.append(r15.d.getMessage());
        r5.w("LiveIslandAnnouncement", r6.toString());
        return null;
    L61:
        com.bytedance.ai.utils.g.a.w("LiveIslandAnnouncement", "requestAnnouncement unknown response=" + r11);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        LinkedHashMap r16 = new LinkedHashMap();
        AccountService r7 = AccountService.a;
        String r17 = r7.getXTTToken();
        if (r17 != null) goto L18;
        r17 = "";
    L18:
        if ((!StringsKt.isBlank(r17)) == true) goto L21;
        r17 = null;
    L21:
        if (r17 == null) goto L23;
        String r18 = (String) r16.put("X-Tt-Token", r17);
    L23:
        String r19 = r7.getUserId();
        if ((!StringsKt.isBlank(r19)) == true) goto L27;
        r19 = null;
    L27:
        if (r19 == null) goto L29;
        String r20 = (String) r16.put("user_id", r19);
    L29:
        String r21 = o.a.getDeviceId();
        if ((!StringsKt.isBlank(r21)) == true) goto L33;
        r21 = null;
    L33:
        if (r21 == null) goto L35;
        r16.put("device_id", r21);
    L35:
        LiveIslandAnnouncementHelper$requestAnnouncement$response$1 r22 = new LiveIslandAnnouncementHelper$requestAnnouncement$response$1(r8, r16, null);
        r0.label = 1;
        r10 = TimeoutKt.c(3000, r22, r0);
        if (r10 != r2) goto L38;
        return r2;
    L7:
        r0 = new LiveIslandAnnouncementHelper$requestAnnouncement$1(this, r9);
        goto L8
    }
}
