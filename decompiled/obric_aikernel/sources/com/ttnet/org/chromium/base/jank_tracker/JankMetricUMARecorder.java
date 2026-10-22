package com.ttnet.org.chromium.base.jank_tracker;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class JankMetricUMARecorder {

    @VisibleForTesting
    public interface Natives {
        void recordJankMetrics(String r10, long[] r11, long[] r12, long[] r13, int r14);
    }

    public JankMetricUMARecorder() {
    }

    public static void recordJankMetricsToUMA(JankMetrics r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        JankMetricUMARecorderJni.get().recordJankMetrics(scenarioToString(r11), r10.timestampsNs, r10.durationsNs, r10.jankBurstsNs, r10.skippedFrames);
    }

    public static String scenarioToString(int r10) {
        switch(r10) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L4;
        };
    L5:
        return "StartSurfaceTabSwitcher";
    L7:
        return "StartSurfaceHomepage";
    L9:
        return "OpenLinkInNewTab";
    L11:
        return "TabSwitcher";
    L13:
        return "Startup";
    L15:
        return "NewTabPage";
    L17:
        return "OmniboxFocus";
    L19:
        return "Total";
    L4:
        throw new IllegalArgumentException("Invalid scenario value");
    }
}
