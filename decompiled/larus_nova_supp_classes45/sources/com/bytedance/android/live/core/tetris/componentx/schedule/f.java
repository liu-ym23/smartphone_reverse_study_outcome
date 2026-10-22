package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityCellConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityMappingConfig;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public final List<ComponentBatchPriorityCellConfig> a;
    public final j b;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Double.valueOf(((ComponentBatchPriorityCellConfig) r3).getStart()), Double.valueOf(((ComponentBatchPriorityCellConfig) r4).getStart()));
        }
    }

    public static int c(double r5) {
        if (r5 < 0.0d) goto L8;
        if (r5 > 1.0d) goto L8;
        return 0;
    L8:
        if (r5 < 1.0d) goto L13;
        if (r5 > 2.0d) goto L13;
        return 1;
    L13:
        if (r5 < 2.0d) goto L18;
        if (r5 > 3.0d) goto L18;
        return 2;
    L18:
        if (r5 < 3.0d) goto L23;
        if (r5 > 4.0d) goto L23;
        return 3;
    L23:
        if (r5 < 4.0d) goto L28;
        if (r5 > 5.0d) goto L28;
        return 4;
    L28:
        if (r5 < 5.0d) goto L33;
        if (r5 > 6.0d) goto L33;
        return 5;
    L33:
        return (int) r5;
    }

    public final boolean b() {
        SettingKey<ComponentBatchPriorityConfig> r0 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG;
        if (r0.getValue().getEnable() == false) goto L14;
        List r1 = r0.getValue().getStrategyList();
        if (r1 == null) goto L15;
        j r2 = this.b;
        if (r2 == null) goto L9;
        int r3 = r2.a;
    L11:
        if (r1.contains(Integer.valueOf(r3)) != true) goto L16;
        return true;
    L16:
        return false;
    L9:
        r3 = 0;
        goto L11
    L15:
        return false;
    L14:
        return false;
    }

    public f(j r2) {
        this.b = r2;
        this.a = CollectionsKt.emptyList();
        List r3 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG.getValue().getCells();
        if (r3 == null) goto L5;
        List<ComponentBatchPriorityCellConfig> r4 = CollectionsKt.sortedWith(r3, new a());
    L6:
        this.a = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final String a(int r6, boolean r7) {
        if (b() == false) goto L53;
        if (r7 == false) goto L26;
        SettingKey<ComponentBatchPriorityConfig> r8 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG;
        ComponentBatchPriorityMappingConfig r4 = r8.getValue().getPriorityMapping();
        if (r4 != null) goto L9;
    L11:
        ComponentBatchPriorityMappingConfig r3 = r8.getValue().getPriorityMapping();
        if (r3 != null) goto L14;
    L16:
        ComponentBatchPriorityMappingConfig r2 = r8.getValue().getPriorityMapping();
        if (r2 != null) goto L19;
    L21:
        ComponentBatchPriorityMappingConfig r9 = r8.getValue().getPriorityMapping();
        if (r9 == null) goto L47;
        if (r6 != r9.getP3_start()) goto L47;
        return "3";
    L47:
        if (LiveInfraSettingKeys.LIVE_SUBBATCH_LOAD_FIX.getValue().booleanValue() == false) goto L51;
        return "";
    L51:
        return String.valueOf(r6);
    L19:
        if (r6 != r2.getP2_start()) goto L21;
        return GamePromoteDataContext.GAME_TYPE_MINI;
    L14:
        if (r6 != r3.getP1_start()) goto L16;
        return GamePromoteDataContext.GAME_TYPE_MOBILE;
    L9:
        if (r6 != r4.getP0_start()) goto L11;
        return "0";
    L26:
        SettingKey<ComponentBatchPriorityConfig> r11 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG;
        ComponentBatchPriorityMappingConfig r5 = r11.getValue().getPriorityMapping();
        if (r5 != null) goto L29;
    L31:
        ComponentBatchPriorityMappingConfig r12 = r11.getValue().getPriorityMapping();
        if (r12 != null) goto L34;
    L36:
        ComponentBatchPriorityMappingConfig r13 = r11.getValue().getPriorityMapping();
        if (r13 != null) goto L39;
    L41:
        ComponentBatchPriorityMappingConfig r14 = r11.getValue().getPriorityMapping();
        if (r14 == null) goto L47;
        if (r6 != r14.getP3_end()) goto L47;
        return "3";
    L39:
        if (r6 != r13.getP2_end()) goto L41;
        return GamePromoteDataContext.GAME_TYPE_MINI;
    L34:
        if (r6 != r12.getP1_end()) goto L36;
        return GamePromoteDataContext.GAME_TYPE_MOBILE;
    L29:
        if (r6 != r5.getP0_end()) goto L31;
        return "0";
    L53:
        return String.valueOf(r6);
    }
}
