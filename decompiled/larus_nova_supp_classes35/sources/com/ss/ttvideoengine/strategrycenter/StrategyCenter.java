package com.ss.ttvideoengine.strategrycenter;

import com.bytedance.vcloud.networkpredictor.AwemeSpeedPredictor;
import com.bytedance.vcloud.networkpredictor.DefaultSpeedPredictor;
import com.bytedance.vcloud.networkpredictor.ISpeedPredictor;
import com.bytedance.vcloud.networkpredictor.ISpeedPredictorListener;
import com.bytedance.vcloud.networkpredictor.ISpeedPredictorMLConfig;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class StrategyCenter {
    private static final String TAG = "TTVideoEngine";
    private static Map sConfigInfo;
    public static ISpeedPredictor sNetAbrSpeedPredictor;
    public static ISpeedPredictor sNetSpeedPredictor;
    private static ISpeedPredictorListener speedPredictorListener;
    private static ISpeedPredictorMLConfig speedPredictorMlConfig;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.strategrycenter.StrategyCenter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class StrategyCenterHolder {
        private static final StrategyCenter instance = null;

        private StrategyCenterHolder() {
        }

        static {
            instance = new StrategyCenter(null);
        }

        public static /* synthetic */ StrategyCenter access$100() {
            return instance;
        }
    }

    private StrategyCenter() {
    }

    public static void closeNewStartAndSelectGearSpeedPredictor() {
        sNetSpeedPredictor.release();
    }

    public static StrategyCenter getInstance() {
        return StrategyCenterHolder.access$100();
    }

    public /* synthetic */ StrategyCenter(AnonymousClass1 r1) {
        this();
    }

    public static void createNewStartAndSelectGearSpeedPredictor(int r4) {
        if (sNetSpeedPredictor == null) goto L5;
        return;
    L5:
        TTVideoEngineLog.d(TAG, String.format(Locale.US, "[IESSpeedPredictor] start new speed predictor, type:%d", new Object[]{Integer.valueOf(r4)}));
        DefaultSpeedPredictor r0 = new DefaultSpeedPredictor(r4);
        sNetSpeedPredictor = r0;
        r0.setConfigInfo(sConfigInfo);
    }

    public static void createSpeedPredictor(int r5) {
        if (sNetSpeedPredictor == null) goto L5;
        return;
    L5:
        TTVideoEngineLog.d(TAG, String.format(Locale.US, "[IESSpeedPredictor] start speed predictor, type:%d", new Object[]{Integer.valueOf(r5)}));
        if (r5 == 1) goto L17;
        if (r5 == 0) goto L17;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L17;
        AwemeSpeedPredictor r0 = new AwemeSpeedPredictor(speedPredictorListener);     // Catch: Exception -> L15
        sNetSpeedPredictor = r0;     // Catch: Exception -> L15
        AwemeSpeedPredictor r1 = r0;     // Catch: Exception -> L15
        r0.setupAlgorithmTypeAndConfig(r5, speedPredictorMlConfig);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L17:
        sNetSpeedPredictor = new DefaultSpeedPredictor(r5);
    }

    public static void setConfigInfo(Map r0) {
        sConfigInfo = r0;
    }

    public static void setSpeedPredictorListener(ISpeedPredictorListener r0) {
        speedPredictorListener = r0;
    }

    public static void setSpeedPredictorMlConfig(ISpeedPredictorMLConfig r0) {
        speedPredictorMlConfig = r0;
    }

    public static void setSpeedQueueSize(int r1) {
        ISpeedPredictor r0 = sNetSpeedPredictor;
        if (r0 == null) goto L6;
        r0.setSpeedQueueSize(r1);
        return;
    }

    public static void createAbrSpeedPredictor(int r4, int r5) {
        if (sNetAbrSpeedPredictor == null) goto L5;
        return;
    L5:
        TTVideoEngineLog.d(TAG, String.format(Locale.US, "[ABR] start speed predictor, type:%d，intervalMs:%d", new Object[]{Integer.valueOf(r4), Integer.valueOf(r5)}));
        sNetAbrSpeedPredictor = new DefaultSpeedPredictor(r4);
    }
}
