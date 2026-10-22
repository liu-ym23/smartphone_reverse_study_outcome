package com.bytedance.android.annie.monitor.lynx.glue;

import android.text.TextUtils;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import o8.f;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MonitorHelper {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/annie/monitor/lynx/glue/MonitorHelper$SampleLevel;", "", "", "level", "I", "getLevel", "()I", "NO_SAMPLE", "SAMPLE_LEVEL_2", "annie-monitor-lynx_release"}, k = 1, mv = {1, 4, 3})
    public static final enum SampleLevel extends Enum<SampleLevel> {
        public static final SampleLevel NO_SAMPLE = null;
        public static final SampleLevel SAMPLE_LEVEL_2 = null;
        public static final /* synthetic */ SampleLevel[] a = null;
        private final int level;

        public static SampleLevel valueOf(String r1) {
            return (SampleLevel) a.a(SampleLevel.class, r1);
        }

        public static SampleLevel[] values() {
            return (SampleLevel[]) a.clone();
        }

        static {
            SampleLevel r0 = new SampleLevel("NO_SAMPLE", 0, 0);
            NO_SAMPLE = r0;
            SampleLevel r1 = new SampleLevel("SAMPLE_LEVEL_2", 1, 2);
            SAMPLE_LEVEL_2 = r1;
            a = new SampleLevel[]{r0, r1};
        }

        public final int getLevel() {
            return this.level;
        }

        public SampleLevel(String r1, int r10, int r11) {
            super(r1, r10);
            this.level = r11;
        }
    }

    static {
    }

    public static String b() {
        if (g.g == true) goto L5;
        return null;
    L5:
        if (g.b().a.a == true) goto L7;
        return null;
    L7:
        if (AnnieConfigSettingKeys.METRIC_TIMING_SWITCH.a().booleanValue() == false) goto L13;
        return "perf_ready";
    L13:
        return null;
    }

    @JvmStatic
    public static final String c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bizKey");
        com.bytedance.android.annie.ng.a r11 = g.c.get(r10);
        if (r11 == null) goto L8;
        f r12 = r11.b;
        if (r12 == null) goto L8;
        String r13 = r12.a;
        if (r13 == null) goto L8;
    L10:
        if (TextUtils.isEmpty(r13) == false) goto L13;
        return "88888";
    L13:
        return r13;
    L8:
        r13 = "88888";
        goto L10
    }

    @JvmStatic
    public static final void a(LynxView r1, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        LynxViewMonitor.b.getClass();
        LynxViewMonitor.g(r1, r10, r11);
    }

    @JvmStatic
    public static final void d(LynxView r10, String r11, String r12, JSONObject r13, JSONObject r14, JSONObject r15, JSONObject r16) {
        int r17 = SampleLevel.NO_SAMPLE.getLevel();
        LynxViewMonitor.b.getClass();
        LynxViewMonitor.j(r10, r11, r12, r13, r14, r15, r16, r17);
    }
}
