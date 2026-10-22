package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BatchTogetherConditionManager extends com.bytedance.android.live.core.tetris.componentx.schedule.b {
    public final String a;
    public Map<Integer, Set<BatchLoadConditionType>> b;
    public final Map<Integer, Map<BatchLoadConditionType, Boolean>> c;
    public final b d;
    public final LinkedHashMap<Integer, m> e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/schedule/BatchTogetherConditionManager$BatchLoadConditionType;", "", "END_WIDGET", "END_DELAY_TIME", "END_BATCH_ONLOAD", "END_ROOM_ENTER", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum BatchLoadConditionType extends Enum<BatchLoadConditionType> {
        public static final BatchLoadConditionType END_BATCH_ONLOAD = null;
        public static final BatchLoadConditionType END_DELAY_TIME = null;
        public static final BatchLoadConditionType END_ROOM_ENTER = null;
        public static final BatchLoadConditionType END_WIDGET = null;
        public static final /* synthetic */ BatchLoadConditionType[] a = null;

        static {
            BatchLoadConditionType r1 = new BatchLoadConditionType("END_WIDGET", 0);
            END_WIDGET = r1;
            BatchLoadConditionType r2 = new BatchLoadConditionType("END_DELAY_TIME", 1);
            END_DELAY_TIME = r2;
            BatchLoadConditionType r3 = new BatchLoadConditionType("END_BATCH_ONLOAD", 2);
            END_BATCH_ONLOAD = r3;
            BatchLoadConditionType r4 = new BatchLoadConditionType("END_ROOM_ENTER", 3);
            END_ROOM_ENTER = r4;
            a = new BatchLoadConditionType[]{r1, r2, r3, r4};
        }

        public static BatchLoadConditionType valueOf(String r1) {
            return (BatchLoadConditionType) r27.a.a(BatchLoadConditionType.class, r1);
        }

        public static BatchLoadConditionType[] values() {
            return (BatchLoadConditionType[]) a.clone();
        }

        public BatchLoadConditionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(int r1);
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.b
    public final void a(Map<Integer, Set<BatchLoadConditionType>> r6) {
        Intrinsics.checkNotNullParameter(r6, "conditionsMap");
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        this.b.clear();
        this.b = r6;
        Iterator<Map.Entry<Integer, Set<BatchLoadConditionType>>> r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L13;
        Map.Entry<Integer, Set<BatchLoadConditionType>> r0 = r7.next();
        int r1 = r0.getKey().intValue();
        Set<BatchLoadConditionType> r2 = r0.getValue();
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<BatchLoadConditionType> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        r3.put(r4.next(), Boolean.FALSE);
        goto L10
    L12:
        this.c.put(Integer.valueOf(r1), r3);
        goto L7
    L13:
        b(0, BatchLoadConditionType.END_BATCH_ONLOAD);
    }

    public final boolean d(int r9) {
        Map r0 = (Map) ((LinkedHashMap) this.c).get(Integer.valueOf(r9));
        boolean r1 = false;
        if (r0 != null) goto L5;
        ALogger.i(this.a, "Stage " + r9 + ": Condition status not found.");
    L23:
        return r1;
    L5:
        if (r0.isEmpty() == false) goto L7;
    L6:
        r1 = true;
    L12:
        if (r1 == false) goto L14;
        ALogger.i(this.a, "Stage " + r9 + ": All conditions met. currentTimeMillis = " + System.currentTimeMillis());
        goto L23
    L14:
        ALogger.i(this.a, "Stage " + r9 + ": Not all conditions met. currentTimeMillis = " + System.currentTimeMillis());
        Iterator r2 = r0.entrySet().iterator();
    L16:
        if (r2.hasNext() == false) goto L23;
        Map.Entry r3 = (Map.Entry) r2.next();
        BatchLoadConditionType r4 = (BatchLoadConditionType) r3.getKey();
        boolean r5 = ((Boolean) r3.getValue()).booleanValue();
        String r6 = this.a;
        StringBuilder r7 = new StringBuilder("Stage ");
        r7.append(r9);
        r7.append(": Condition ");
        r7.append(r4);
        r7.append(" is ");
        if (r5 == false) goto L20;
        String r8 = "met";
    L21:
        r7.append(r8);
        r7.append(". currentTimeMillis = ");
        r7.append(System.currentTimeMillis());
        ALogger.i(r6, r7.toString());
        goto L16
    L20:
        r8 = "not met";
        goto L21
    L7:
        Iterator r11 = r0.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L6;
        if (((Boolean) ((Map.Entry) r11.next()).getValue()).booleanValue() == true) goto L9;
        goto L12
    }

    public final void e(int r4) {
        ALogger.i(this.a, "Stage " + r4 + ": All conditions met, notifying LoadListener...");
        b r0 = this.d;
        if (r0 == null) goto L6;
        r0.a(r4);
        return;
    }

    public BatchTogetherConditionManager(h r2, LinkedHashMap r3) {
        Intrinsics.checkNotNullParameter(r3, "componentSchedulingList");
        this.d = r2;
        this.e = r3;
        this.a = "BatchTogetherConditionManager";
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.b
    public final void b(int r7, BatchLoadConditionType r8) {
        if (r8 == null) goto L25;
        Map r1 = (Map) ((LinkedHashMap) this.c).get(Integer.valueOf(r7));
        if (r1 == null) goto L25;
        if (r1.containsKey(r8) != true) goto L25;
        if (LiveInfraSettingKeys.LIVE_COMPONENTS_BATCH_CONDITIONS_FIX.getValue().booleanValue() == true) goto L11;
        Map r0 = (Map) ((LinkedHashMap) this.c).get(Integer.valueOf(r7));
        if (r0 == null) goto L22;
        r0.put(r8, Boolean.TRUE);
    L22:
        ALogger.i(this.a, "stage " + r7 + ": Condition updated: " + r8);
        if (d(r7) == false) goto L30;
        e(r7);
        return;
    L30:
        return;
    L11:
        if (d(r7) == true) goto L18;
        ALogger.i(this.a, "Stage " + r7 + ": 当前不满足条件，需要更新加载条件");
        Map r2 = (Map) ((LinkedHashMap) this.c).get(Integer.valueOf(r7));
        if (r2 == null) goto L15;
        r2.put(r8, Boolean.TRUE);
    L15:
        ALogger.i(this.a, "stage " + r7 + ": Condition updated: " + r8);
        if (d(r7) == false) goto L27;
        ALogger.i(this.a, "Stage " + r7 + ": 满足所有条件，触发加载");
        e(r7);
        return;
    L27:
        return;
    L18:
        ALogger.i(this.a, "Stage " + r7 + ": 已经满足过条件，不用再次更新&加载");
        return;
    L25:
        ALogger.i(this.a, "Stage " + r7 + ": Invalid or null condition provided: " + r8);
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.b
    public final void c(int r2, BatchLoadConditionType r3) {
        if (r3 != BatchLoadConditionType.END_BATCH_ONLOAD) goto L8;
        int r0 = d80.a.a;
        Integer r4 = (Integer) d80.a.a(this.e, Integer.valueOf(r2));
        if (r4 == null) goto L7;
        r2 = r4.intValue();
        goto L8
    L7:
        r2 = Integer.MAX_VALUE;
    L8:
        b(r2, r3);
    }
}
