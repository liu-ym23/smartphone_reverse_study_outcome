package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.FirstScreenStatistic$recordFirstScreenEnd$5", f = "FirstScreenStatistic.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FirstScreenStatistic$recordFirstScreenEnd$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromCache;
    int label;

    public FirstScreenStatistic$recordFirstScreenEnd$5(boolean r1, Continuation r10) {
        this.$fromCache = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new FirstScreenStatistic$recordFirstScreenEnd$5(this.$fromCache, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r47) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L123;
        ResultKt.throwOnFailure(r47);
        FirstScreenStatistic r1 = FirstScreenStatistic.S;
        boolean r10 = this.$fromCache;
        r1.getClass();
        if (FirstScreenStatistic.a == false) goto L117;
        JSONObject r11 = new JSONObject();
        HashMap<String, HashMap<String, i0>> r12 = FirstScreenStatistic.g;
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<Map.Entry<String, HashMap<String, i0>>> r14 = r12.entrySet().iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        Map.Entry<String, HashMap<String, i0>> r15 = r14.next();
        if ((true ^ Intrinsics.areEqual(r15.getKey(), "ec_na_mall_other")) == false) goto L9;
        r13.put(r15.getKey(), r15.getValue());
        goto L9
    L13:
        Iterator r16 = r13.values().iterator();
        int r17 = 0;
    L15:
        if (r16.hasNext() == false) goto L17;
        r17 = r17 + ((HashMap) r16.next()).size();
        goto L15
    L17:
        HashMap<String, HashMap<String, i0>> r18 = FirstScreenStatistic.f;
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator<Map.Entry<String, HashMap<String, i0>>> r20 = r18.entrySet().iterator();
    L19:
        if (r20.hasNext() == false) goto L23;
        Map.Entry<String, HashMap<String, i0>> r21 = r20.next();
        if ((!Intrinsics.areEqual(r21.getKey(), "ec_na_mall_other")) == false) goto L19;
        r19.put(r21.getKey(), r21.getValue());
        goto L19
    L23:
        Iterator r22 = r19.values().iterator();
        int r23 = 0;
    L25:
        if (r22.hasNext() == false) goto L27;
        r23 = r23 + ((HashMap) r22.next()).size();
        goto L25
    L27:
        Iterator<T> r24 = FirstScreenStatistic.g.values().iterator();
        int r25 = 0;
    L29:
        if (r24.hasNext() == false) goto L31;
        r25 = r25 + ((HashMap) r24.next()).size();
        goto L29
    L31:
        Iterator<T> r26 = FirstScreenStatistic.f.values().iterator();
        int r27 = 0;
    L33:
        if (r26.hasNext() == false) goto L35;
        r27 = r27 + ((HashMap) r26.next()).size();
        goto L33
    L35:
        if (r25 == 0) goto L37;
        float r110 = r27 / r25;
    L38:
        if (r17 == 0) goto L40;
        float r111 = r23 / r17;
    L41:
        r11.put("load_count", r25);
        r11.put("load_success", r27);
        String r112 = "load_rate";
        r11.put("load_rate", Float.valueOf(r110));
        r11.put("load_count_mall", r17);
        String r28 = "load_success_mall";
        r11.put("load_success_mall", r23);
        String r29 = "load_rate_mall";
        r11.put("load_rate_mall", Float.valueOf(r111));
        String r30 = "from_cache";
        r11.put("from_cache", r10);
        Iterator<T> r113 = FirstScreenStatistic.g.keySet().iterator();
    L43:
        if (r113.hasNext() == false) goto L80;
        String r0 = (String) r113.next();
        boolean r114 = r10;
        HashMap<String, i0> r31 = FirstScreenStatistic.g.get(r0);
        String r115 = r30;
        HashMap<String, i0> r32 = FirstScreenStatistic.f.get(r0);
        if (r31 == null) goto L47;
        int r33 = r31.size();
    L48:
        if (r32 == null) goto L50;
        int r116 = r32.size();
    L51:
        if (r33 == 0) goto L53;
        float r117 = r116 / r33;
    L54:
        StringBuilder r34 = new StringBuilder();
        r34.append(r0);
        float r210 = r111;
        r34.append("_load_count");
        r11.put(r34.toString(), r33);
        r11.put(r0 + "_load_success", r116);
        r11.put(r0 + "_load_rate", Float.valueOf(r117));
        if (r32 == null) goto L78;
        Iterator<Map.Entry<String, i0>> r35 = r32.entrySet().iterator();
        int r36 = 0;
        int r37 = 0;
        int r118 = 0;
        int r119 = 0;
        int r120 = 0;
    L58:
        if (r35.hasNext() == false) goto L77;
        Iterator<Map.Entry<String, i0>> r211 = r35;
        int r38 = r35.next().getValue().d;
        String r212 = r28;
        if (r38 == (-1)) goto L75;
        if (r38 != 0) goto L63;
        r36 = r36 + 1;
    L76:
        r28 = r212;
        r35 = r211;
        goto L58
    L63:
        if (r38 != 1) goto L65;
    L73:
        r118 = r118 + 1;
        goto L76
    L65:
        if (r38 != 2) goto L67;
        r37 = r37 + 1;
        goto L76
    L67:
        if (r38 == 3) goto L73;
        if (r38 != 4) goto L76;
        r120 = r120 + 1;
        goto L76
    L75:
        r119 = r119 + 1;
        goto L76
    L77:
        String r213 = r28;
        Unit r39 = Unit.INSTANCE;
    L79:
        r11.put(r0 + "_load_from_net", r36);
        r11.put(r0 + "_load_from_memory", r118);
        r11.put(r0 + "_load_from_disk", r37);
        r11.put(r0 + "_load_from_bitmap_dir", r120);
        r11.put(r0 + "_load_from_unknown", r119);
        r10 = r114;
        r30 = r115;
        r112 = r112;
        r110 = r110;
        r29 = r29;
        r111 = r210;
        r28 = r213;
        goto L43
    L78:
        r213 = r28;
        r36 = 0;
        r37 = 0;
        r118 = 0;
        r119 = 0;
        r120 = 0;
        goto L79
    L53:
        r117 = 0.0f;
        goto L54
    L50:
        r116 = 0;
        goto L51
    L47:
        r33 = 0;
        goto L48
    L80:
        boolean r121 = r10;
        String r214 = r28;
        String r122 = r30;
        String r215 = r29;
        float r216 = r110;
        float r217 = r111;
        String r218 = r112;
        r11.put("other_scene", CollectionsKt.joinToString$default(FirstScreenStatistic.i, ",", null, null, 0, null, null, 62, null));
        Iterator<Map.Entry<String, HashMap<String, i0>>> r40 = FirstScreenStatistic.f.entrySet().iterator();
        long r123 = 0;
        long r310 = 0;
        long r311 = 0;
    L82:
        if (r40.hasNext() == false) goto L87;
        Map.Entry<String, HashMap<String, i0>> r41 = r40.next();
        String r42 = r41.getKey();
        Iterator<Map.Entry<String, i0>> r43 = r41.getValue().entrySet().iterator();
    L85:
        if (r43.hasNext() == false) goto L82;
        i0 r44 = r43.next().getValue();
        long r45 = r44.c;
        long r46 = r45 - r44.b;
        long r48 = r45 - 0;
        r310 = r310 + r46;
        r311 = r311 + r48;
        r123 = Math.max(r123, r48);
        r23 = r23;
        goto L85
    L87:
        int r49 = r23;
        if (r27 == 0) goto L90;
        float r50 = r27;
        float r51 = r310 / r50;
        float r52 = r311 / r50;
    L91:
        r11.put("avgLoadTime", Float.valueOf(r51));
        r11.put("avgLoadTimeToAppBegin", Float.valueOf(r52));
        r11.put("maxTimeToAppBegin", r123);
        r11.put("FirstScreenTime", FirstScreenStatistic.d - 0);
        dm.a.a("FirstScreenStatistic").a(r11.toString());
        int r53 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_image_load_rate", r11, null, null);
        if (FirstScreenStatistic.G == false) goto L116;
        ConcurrentHashMap<String, p0> r54 = FirstScreenStatistic.N;
        LinkedHashMap r55 = new LinkedHashMap();
        Iterator<Map.Entry<String, p0>> r56 = r54.entrySet().iterator();
    L95:
        if (r56.hasNext() == false) goto L102;
        Map.Entry<String, p0> r57 = r56.next();
        if (r57.getValue().e <= 0) goto L99;
        boolean r124 = true;
    L100:
        if (r124 == false) goto L95;
        r55.put(r57.getKey(), r57.getValue());
        goto L95
    L99:
        r124 = false;
        goto L100
    L102:
        int r58 = r55.size();
        JSONObject r59 = new JSONObject();
        r59.put("load_count", r25);
        r59.put("load_success", r27);
        r59.put("load_count_mall", r17);
        r59.put(r214, r49);
        r59.put(r215, Float.valueOf(r217));
        r59.put(r218, Float.valueOf(r216));
        r59.put(r122, r121);
        r59.put("hasKeva", false);
        r59.put("kevaMd5ListSize", 0);
        r59.put("kevaUrlListSize", 0);
        Iterator r60 = r55.entrySet().iterator();
        int r125 = r17;
        long r61 = 0;
        long r62 = 0;
        long r63 = 0;
        long r64 = 0;
        long r126 = 0;
        long r127 = 0;
        long r128 = 0;
        long r219 = 0;
        long r220 = 0;
        long r312 = 0;
    L104:
        if (r60.hasNext() == false) goto L106;
        Map.Entry r221 = (Map.Entry) r60.next();
        String r222 = (String) r221.getKey();
        Iterator r223 = r60;
        p0 r65 = (p0) r221.getValue();
        long r224 = r63;
        long r66 = r65.a;
        long r313 = r66 - 0;
        long r314 = r128;
        long r129 = r65.b;
        long r67 = r129 - r66;
        long r315 = r127;
        long r130 = r129 - 0;
        long r410 = r64;
        long r68 = r65.d;
        long r69 = r65.c;
        long r70 = r68 - r69;
        long r71 = r69 - r129;
        long r72 = Math.max(r62, r130);
        long r73 = r61 + r313;
        r126 = r126 + r67;
        long r131 = r410 + r130;
        r127 = r315 + r130;
        long r74 = r314 + r70;
        long r75 = r224 + r71;
        long r76 = r65.d;
        r220 = r220 + (r76 - r65.b);
        long r77 = r65.e;
        r312 = r312 + (r77 - r76);
        r219 = r219 + (r77 - 0);
        r60 = r223;
        r63 = r75;
        r61 = r73;
        r62 = r72;
        r64 = r131;
        r128 = r74;
        goto L104
    L106:
        long r225 = r63;
        long r411 = r64;
        long r316 = r127;
        long r317 = r128;
        long r78 = r312;
        if (r58 == 0) goto L109;
        int r79 = r58;
        float r80 = r79;
        float r81 = r411 / r80;
        float r132 = r316 / r80;
        float r82 = r61 / r80;
        float r83 = r126 / r80;
        float r133 = r220 / r80;
        float r84 = r78 / r80;
        float r85 = r219 / r80;
        float r134 = r317 / r80;
        float r86 = r225 / r80;
        float r135 = r132;
        float r87 = r82;
        float r88 = r81;
        float r89 = r83;
    L110:
        r59.put("FirstScreenTime", FirstScreenStatistic.d - 0);
        r59.put("avgDiskEndToPrepareTime", Float.valueOf(r88));
        r59.put("avgDiskEndToAppBeginTime", Float.valueOf(r135));
        r59.put("maxDiskEndToAppBeginTime", r62);
        r59.put("avgPreparePhaseTime", Float.valueOf(r87));
        r59.put("avgDiskPhaseTime", Float.valueOf(r89));
        r59.put("avgBitmapUsePhaseTime", Float.valueOf(r133));
        r59.put("avgBitmapSetPhaseTime", Float.valueOf(r84));
        r59.put("avgBitmapLoadCompleteTime", Float.valueOf(r85));
        r59.put("avgUseBitmapToRealLoadTime", Float.valueOf(r134));
        r59.put("avgRealLoadToDiskEndTime", Float.valueOf(r86));
        r59.put("preloadTaskPhaseTime", 0);
        r59.put("firstImageLoadToPreloadEndTime", FirstScreenStatistic.C - 0);
        int r90 = FirstScreenStatistic.q.size();
        if (r125 == 0) goto L113;
        r59.put("bitmapCacheHitRate", Float.valueOf(r90 / r125));
    L113:
        if (r90 == 0) goto L115;
        r59.put("bitmapCacheLoadRate", Float.valueOf(r79 / r90));
    L115:
        r59.put("bitmapCacheDirSize", Float.valueOf((0 / 1024.0f) / 1024.0f));
        dm.a.a("FirstScreenStatistic").a(r59.toString());
        int r91 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_bitmap_load_rate", r59, null, null);
        goto L116
    L109:
        r79 = r58;
        r88 = -1.0f;
        r87 = -1.0f;
        r89 = -1.0f;
        r84 = -1.0f;
        r85 = -1.0f;
        r86 = -1.0f;
        r133 = -1.0f;
        r134 = -1.0f;
        r135 = -1.0f;
    L116:
        FirstScreenStatistic.b = true;
        goto L117
    L90:
        r51 = -1.0f;
        r52 = -1.0f;
        goto L91
    L40:
        r111 = 0.0f;
        goto L41
    L37:
        r110 = 0.0f;
    L117:
        FirstScreenStatistic r92 = FirstScreenStatistic.S;
        a r93 = FirstScreenStatistic.Q.poll();
        if (r93 == null) goto L120;
        FirstScreenStatistic.a(r92, r93);
        goto L117
    L120:
        return Unit.INSTANCE;
    L123:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
