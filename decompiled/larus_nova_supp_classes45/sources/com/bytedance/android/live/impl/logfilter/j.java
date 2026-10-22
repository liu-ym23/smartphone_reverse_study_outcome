package com.bytedance.android.live.impl.logfilter;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.utils.TimeUtils;
import com.bytedance.android.live.impl.utils.json.JsonHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Map b;

    public j(boolean r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ArrayList r1 = new ArrayList();
        String r2 = UserFeatureInRoomFilter.y1.g().d("definition_sensitivity_count", r1.toString());
        SparseIntArray r3 = new SparseIntArray();
        SparseIntArray r5 = new SparseIntArray();
        SparseArray r6 = new SparseArray();
        SparseArray r7 = new SparseArray();
        if (r2 == null) goto L170;
        SimpleDateFormat r8 = TimeUtils.a;
        String r9 = TimeUtils.b(UserFeatureInRoomFilter.Q);
        int r11 = JsonHelper.a;
        List r4 = JsonHelper.e(r2, JsonItemType.DEFINITION_ITEM);
        if ((r4 instanceof List) == true) goto L7;
        r4 = null;
    L7:
        if (r4 == null) goto L141;
        int r12 = 1;
        if (this.a == true) goto L62;
        Map r13 = this.b;
        if (r13 == null) goto L14;
        String r14 = (String) r13.get("definition");
        if (r14 == null) goto L14;
    L15:
        int r15 = UserFeatureInRoomFilter.Y.indexOf(r14);
        int r16 = ((Number) FeatureManager.u.getFeature("live_watch_duration", 0)).intValue();
        Iterator r17 = r4.iterator();
        boolean r18 = false;
    L17:
        if (r17.hasNext() == false) goto L58;
        JsonItemHelper.DefinitionItem r19 = (JsonItemHelper.DefinitionItem) r17.next();
        if (Intrinsics.areEqual(r19.getDate(), r9) == false) goto L42;
        List<Integer> r110 = r19.getDefinitionPvList();
        if (r110 == null) goto L30;
        ListProtector.set(r110, r15, Integer.valueOf(((Number) ListProtector.get(r110, r15)).intValue() + r12));
        int r111 = 0;
    L24:
        if (r111 >= r110.size()) goto L29;
        if (r111 != r15) goto L27;
        r3.put(r15, ((Number) ListProtector.get(r110, r15)).intValue());
        r5.put(r15, r5.get(r15, 0) + ((Number) ListProtector.get(r110, r15)).intValue());
    L28:
        r111 = r111 + 1;
        goto L24
    L27:
        r3.put(r111, ((Number) ListProtector.get(r110, r111)).intValue());
        r5.put(r111, r5.get(r111, 0) + ((Number) ListProtector.get(r110, r111)).intValue());
        goto L28
    L29:
        Unit r112 = Unit.INSTANCE;
    L30:
        List<Long> r113 = r19.getDefinitionDurationList();
        if (r113 == null) goto L41;
        ListProtector.set(r113, r15, Long.valueOf(((Number) ListProtector.get(r113, r15)).longValue() + ((long) r16)));
        int r21 = 0;
    L34:
        if (r21 >= r113.size()) goto L39;
        if (r21 != r15) goto L37;
        r6.put(r15, ListProtector.get(r113, r15));
        r7.put(r15, Long.valueOf(((Number) r7.get(r15, 0L)).longValue() + ((Number) ListProtector.get(r113, r15)).longValue()));
    L38:
        r21 = r21 + 1;
        goto L34
    L37:
        r6.put(r21, ListProtector.get(r113, r21));
        r7.put(r21, Long.valueOf(((Number) r7.get(r21, 0L)).longValue() + ((Number) ListProtector.get(r113, r21)).longValue()));
        goto L38
    L39:
        Unit r22 = Unit.INSTANCE;
    L41:
        r1.add(JsonHelper.f(r19));
        r18 = true;
    L57:
        r3 = r3;
        r17 = r17;
        r12 = 1;
        goto L17
    L42:
        r17 = r17;
        r3 = r3;
        List<Integer> r23 = r19.getDefinitionPvList();
        if (r23 == null) goto L49;
        int r24 = 0;
    L46:
        if (r24 >= r23.size()) goto L48;
        r5.put(r24, r5.get(r24, 0) + ((Number) ListProtector.get(r23, r24)).intValue());
        r24 = r24 + 1;
        goto L46
    L48:
        Unit r25 = Unit.INSTANCE;
    L49:
        List<Long> r26 = r19.getDefinitionDurationList();
        if (r26 == null) goto L56;
        int r27 = 0;
    L53:
        if (r27 >= r26.size()) goto L55;
        r7.put(r27, Long.valueOf(((Number) r7.get(r27, 0L)).longValue() + ((Number) ListProtector.get(r26, r27)).longValue()));
        r27 = r27 + 1;
        goto L53
    L55:
        Unit r28 = Unit.INSTANCE;
    L56:
        r1.add(JsonHelper.f(r19));
        goto L57
    L58:
        SparseIntArray r114 = r3;
        if (r18 == true) goto L61;
        List r29 = CollectionsKt.mutableListOf(new Integer[]{0, 0, 0, 0, 0});
        List r31 = CollectionsKt.mutableListOf(new Long[]{0L, 0L, 0L, 0L, 0L});
        ListProtector.set(r29, r15, 1);
        long r115 = r16;
        ListProtector.set(r31, r15, Long.valueOf(r115));
        int r116 = JsonHelper.a;
        r1.add(JsonHelper.f(new JsonItemHelper.DefinitionItem(r9, r29, r31)));
        r3 = r114;
        r3.put(r15, 1);
        r5.put(r15, r5.get(r15, 0) + 1);
        r6.put(r15, Long.valueOf(r115));
        r7.put(r15, Long.valueOf(((Number) r7.get(r15, 0L)).longValue() + r115));
    L101:
        FeatureManager r32 = FeatureManager.u;
        int r33 = ((Number) r32.getFeature("preview_show_pv_today", 0)).intValue();
        int r117 = ((Number) r32.getFeature("preview_click_pv_today", 0)).intValue();
        int r118 = ((Number) r32.getFeature("preview_show_pv_week_avg", 0)).intValue();
        int r34 = ((Number) r32.getFeature("preview_show_pv_week_avg", 0)).intValue();
        if (r33 != 0) goto L104;
        float r119 = r117 / r33;
    L105:
        if (r118 != 0) goto L107;
        float r35 = r34 / r118;
    L108:
        int r0 = 5;
        int r36 = 0;
        int r37 = 0;
        int r120 = 0;
        long r121 = 0;
        long r122 = 0;
    L109:
        if (r37 >= r0) goto L111;
        long r123 = r121 + ((Number) r6.get(r37, 0L)).longValue();
        int r38 = r36 + r3.get(r37, 0);
        long r124 = r122 + ((Number) r7.get(r37, 0L)).longValue();
        int r125 = r120 + r5.get(r37, 0);
        FeatureManager r39 = FeatureManager.u;
        StringBuilder r41 = new StringBuilder("watch_");
        HashMap<Integer, String> r126 = UserFeatureInRoomFilter.X;
        r41.append(r126.get(Integer.valueOf(r37)));
        r41.append("_pv_today");
        String r42 = r41.toString();
        Integer r127 = Integer.valueOf(r3.get(r37, 0));
        FeatureType r128 = FeatureType.DYNAMIC;
        r39.i(r42, r127, r128);
        r39.i("watch_" + r126.get(Integer.valueOf(r37)) + "_pv_week", Integer.valueOf(r5.get(r37, 0)), r128);
        r39.i("watch_" + r126.get(Integer.valueOf(r37)) + "_duration_today", r6.get(r37, 0L), r128);
        r39.i("watch_" + r126.get(Integer.valueOf(r37)) + "_duration_week", r7.get(r37, 0L), r128);
        r37 = r37 + 1;
        r36 = r38;
        r120 = r125;
        r121 = r123;
        r122 = r124;
        r0 = 5;
        goto L109
    L111:
        FeatureManager r43 = FeatureManager.u;
        Integer r44 = Integer.valueOf(r36);
        FeatureType r45 = FeatureType.DYNAMIC_MONITOR;
        r43.i("watch_pv_today", r44, r45);
        r43.i("watch_pv_week", Integer.valueOf(r120), r45);
        r43.i("watch_duration_today", Long.valueOf(r121), r45);
        r43.i("watch_duration_week", Long.valueOf(r122), r45);
        List r46 = CollectionsKt.mutableListOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f)});
        List r47 = CollectionsKt.mutableListOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f)});
        int r48 = 0;
        int r49 = 5;
        int r129 = 0;
        float r130 = Float.MIN_VALUE;
        float r131 = Float.MIN_VALUE;
        int r210 = 0;
    L112:
        if (r48 >= r49) goto L140;
        if (r36 != 0) goto L115;
    L125:
        r46 = r46;
        r35 = r35;
        SparseArray r211 = r6;
        int r310 = r36;
        long r212 = r121;
        r3 = r3;
    L126:
        if (r120 != 0) goto L128;
    L138:
        r7 = r7;
    L139:
        r48 = r48 + 1;
        r7 = r7;
        r3 = r3;
        r6 = r211;
        r121 = r212;
        r35 = r35;
        r46 = r46;
        r36 = r310;
        r49 = 5;
        goto L112
    L128:
        if (r122 == 0) goto L138;
        if (r5.get(r48, 0) == 0) goto L138;
        float r51 = (5 * r35) + ((((Number) r7.get(r48, 0L)).floatValue() / r122) / (r5.get(r48, 0) / r120));
        if (r51 <= 0.0f) goto L136;
        double r52 = r51;
        ListProtector.set(r47, r48, Float.valueOf((float) Math.log(r52)));
        FeatureManager.u.i(UserFeatureInRoomFilter.X.get(Integer.valueOf(r48)) + "_sensitivity_score_week", Float.valueOf((float) Math.log(r52)), FeatureType.DYNAMIC_MONITOR);
    L136:
        if (r51 <= r130) goto L139;
        r210 = r48;
        r130 = r51;
        goto L139
    L115:
        if (r121 == 0) goto L125;
        if (r3.get(r48, 0) == 0) goto L125;
        r211 = r6;
        r212 = r121;
        float r132 = (5 * r119) + ((((Number) r6.get(r48, 0L)).floatValue() / r121) / (r3.get(r48, 0) / r36));
        if (r132 <= 0.0f) goto L121;
        int r53 = r36;
        double r54 = r132;
        ListProtector.set(r46, r48, Float.valueOf((float) Math.log(r54)));
        FeatureManager r55 = FeatureManager.u;
        StringBuilder r56 = new StringBuilder();
        r310 = r53;
        r56.append(UserFeatureInRoomFilter.X.get(Integer.valueOf(r48)));
        r56.append("_sensitivity_score_today");
        r55.i(r56.toString(), Float.valueOf((float) Math.log(r54)), FeatureType.DYNAMIC_MONITOR);
    L123:
        if (r132 <= r131) goto L126;
        r129 = r48;
        r131 = r132;
        goto L126
    L121:
        r310 = r36;
        goto L123
    L140:
        FeatureManager r57 = FeatureManager.u;
        Float r58 = Float.valueOf(r130);
        FeatureType r59 = FeatureType.DYNAMIC_MONITOR;
        r57.i("max_definition_sensitivity_score_week", r58, r59);
        r57.i("max_definition_sensitivity_score_today", Float.valueOf(r131), r59);
        UserFeatureInRoomFilter r61 = UserFeatureInRoomFilter.y1;
        HashMap<Integer, String> r62 = UserFeatureInRoomFilter.W;
        r57.i("max_sensitivity_definition_week", r62.get(Integer.valueOf(r210)), r59);
        r57.i("max_sensitivity_definition_today", r62.get(Integer.valueOf(r129)), r59);
        r61.g().e("definition_sensitivity_count", r1.toString());
        Unit r63 = Unit.INSTANCE;
        goto L141
    L107:
        r35 = 0.0f;
        goto L108
    L104:
        r119 = 0.0f;
        goto L105
    L61:
        r3 = r114;
    L14:
        r14 = "其他";
        goto L15
    L62:
        Iterator r64 = r4.iterator();
    L64:
        if (r64.hasNext() == false) goto L101;
        JsonItemHelper.DefinitionItem r65 = (JsonItemHelper.DefinitionItem) r64.next();
        String r66 = r65.getDate();
        if (r66 == null) goto L68;
        long r67 = TimeUtils.c(r66);
    L69:
        SimpleDateFormat r133 = TimeUtils.a;
        int r134 = UserFeatureInRoomFilter.b;
        long r135 = TimeUtils.a(r67, UserFeatureInRoomFilter.Q);
        FeatureManager.u.getClass();
        if (r135 >= FeatureManager.j) goto L85;
        r1.add(JsonHelper.f(r65));
        List<Integer> r136 = r65.getDefinitionPvList();
        if (r136 == null) goto L78;
        int r137 = 0;
    L75:
        if (r137 >= r136.size()) goto L77;
        r5.put(r137, r5.get(r137, 0) + ((Number) ListProtector.get(r136, r137)).intValue());
        r137 = r137 + 1;
        goto L75
    L77:
        Unit r138 = Unit.INSTANCE;
    L78:
        List<Long> r139 = r65.getDefinitionDurationList();
        if (r139 == null) goto L85;
        int r140 = 0;
    L82:
        if (r140 >= r139.size()) goto L84;
        r7.put(r140, Long.valueOf(((Number) r7.get(r140, 0L)).longValue() + ((Number) ListProtector.get(r139, r140)).longValue()));
        r140 = r140 + 1;
        goto L82
    L84:
        Unit r141 = Unit.INSTANCE;
    L85:
        SimpleDateFormat r142 = TimeUtils.a;
        int r143 = UserFeatureInRoomFilter.b;
        if (TimeUtils.a(r67, UserFeatureInRoomFilter.Q) > 1) goto L64;
        List<Integer> r68 = r65.getDefinitionPvList();
        if (r68 == null) goto L94;
        int r144 = 0;
    L91:
        if (r144 >= r68.size()) goto L93;
        r3.put(r144, ((Number) ListProtector.get(r68, r144)).intValue());
        r144 = r144 + 1;
        goto L91
    L93:
        Unit r69 = Unit.INSTANCE;
    L94:
        List<Long> r71 = r65.getDefinitionDurationList();
        if (r71 == null) goto L64;
        int r72 = 0;
    L98:
        if (r72 >= r71.size()) goto L100;
        r6.put(r72, ListProtector.get(r71, r72));
        r72 = r72 + 1;
        goto L98
    L100:
        Unit r73 = Unit.INSTANCE;
        goto L64
    L68:
        r67 = 0;
    L141:
        Unit r74 = Unit.INSTANCE;
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
