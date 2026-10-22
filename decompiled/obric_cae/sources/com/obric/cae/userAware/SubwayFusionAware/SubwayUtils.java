package com.obric.cae.userAware.SubwayFusionAware;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayUtils {
    public static final int ACTION_ENTER_SUB_WAY = 1;
    public static final int ACTION_EXIT_SUB_WAY = 0;
    public static final long ALARM_DELAY_ENTER_CONFIDENCE_SCORING_MS = 120000;
    public static final long ALARM_DELAY_EXIT_CONFIDENCE_SCORING_MS = 90000;
    public static final float BRIGHT_LIGHT_THRESHOLD = 6000.0f;
    public static final float CONFIRM_THRESHOLD = 20.0f;
    public static final int CONSECUTIVE_INDOOR_COUNT_THRESHOLD = 2;
    public static final int CONSECUTIVE_OUTDOOR_COUNT_THRESHOLD = 2;
    public static final long CONTINUOUS_PRESSURE_DURATION_THRESHOLD_MS = 5000;
    public static final float ELEVATOR_DOWN_SCORE = 15.0f;
    public static final float ELEVATOR_UP_SCORE = -5.0f;
    public static final long ENTER_OUTDOOR_CHECK_TICK_MS = 2500;
    public static final long EXIT_CHECK_TRIGGER_COOLDOWN_MS = 10000;
    public static final int EXIT_CONSECUTIVE_OUTDOOR_THRESHOLD = 2;
    public static final int EXIT_MIN_STEP_COUNT = 30;
    public static final int EXIT_SHARED_BIKE_TRIGGER_MIN_COUNT = 2;
    public static final int EXIT_STEP_CHECK_TRIGGER_THRESHOLD = 20;
    public static final long EXIT_TRIGGER_EVALUATION_INTERVAL_MS = 2500;
    public static final long EXIT_WALKING_OR_RUNNING_TRIGGER_MS = 10000;
    public static final long INDOOR_CHECK_COOL_DOWN_MS = 10000;
    public static final long INDOOR_CHECK_TIMEOUT_MS = 30000;
    public static final long INDOOR_CONFIRMED_CHECK_INTERVAL_MS = 20000;
    public static final float MAX_CONTINUOUS_PRESSURE_SCORE_1 = 10.0f;
    public static final float MAX_CONTINUOUS_PRESSURE_SCORE_2 = 20.0f;
    public static final float MAX_SHARED_BIKE_ENTER_SCORE = 10.0f;
    public static final long MIN_HIGH_LIGHT_UPDATE_INTERVAL_MS = 3000;
    public static final long OUTDOOR_PUNISH_DELAY_TIME = 15000;
    public static final float OUTDOOR_PUNISH_SCORE = 4.0f;
    public static final float PRESSURE_CNT_THD = 5.0f;
    public static final float PRESSURE_SCORE = 4.0f;
    public static final float PRESSURE_THRESHOLD1 = 0.25f;
    public static final float PRESSURE_THRESHOLD2 = 0.4f;
    public static final long SENSOR_REGISTRATION_IGNORE_MS = 200;
    public static final float SHARED_BIKE_ENTER_SCORE = 3.0f;
    public static final float STAIRS_ESCALATOR_DOWN_SCORE = 20.0f;
    public static final float STAIRS_ESCALATOR_UP_SCORE = -10.0f;
    public static final int STEP_COUNT_TRIGGER_THRESHOLD = 10;
    public static final long SUBWAY_ENTER_COOLDOWN_MS = 300000;
    public static final long SUBWAY_EXIT_COOLDOWN_MS = 300000;
    private static final String TAG = "SubwayUtils";
    public static final long TIMEOUT_ENTER_CONFIDENCE_SCORING_MS = 240000;
    public static final long TIMEOUT_ENTER_PRE_FILTER_MS = 20000;
    public static final long TIMEOUT_EXIT_CONFIDENCE_SCORING_MS = 240000;
    public static final long UP_DOWN_EVENT_COOLDOWN_MS = 5000;
    public static final long WAKELOCK_EXIT_CONFIDENCE_SCORING_MS = 150000;
    public static final long WAKELOCK_EXTEND_ENTER_CONFIDENCE_SCORING_MS = 60000;
    public static final long WAKELOCK_INITIAL_ENTER_CONFIDENCE_SCORING_MS = 20000;
    public static final long WALKING_DURATION_THRESHOLD_MS = 5000;

    public SubwayUtils() {
    }

    public static boolean checkPreFilterConditions(SubwayContext r8) {
        int r10 = r8.curHarStatus;
        if (r10 == 2) goto L7;
        if (r10 == 1) goto L7;
        boolean r11 = false;
    L9:
        if ("home_indoor".equals(r8.locationState) == false) goto L11;
    L13:
        boolean r12 = false;
    L14:
        boolean r13 = !r8.isWifiConnected;
        if (r11 == false) goto L20;
        if (r12 == false) goto L21;
        if (r13 == true) goto L19;
        return false;
    L19:
        return true;
    L21:
        return false;
    L20:
        return false;
    L11:
        if ("company_indoor".equals(r8.locationState) == true) goto L13;
        r12 = true;
    L7:
        r11 = true;
        goto L9
    }

    public static long getAccumulatedDurationMs(long r8, long r10, long r11) {
        if (r10 > 0) goto L5;
    L9:
        return r8;
    L5:
        if (r11 <= r10) goto L9;
        return (r11 - r10) + r8;
    }

    public static long getExitConfidenceWakeLockDurationMs(long r8, long r10) {
        return Math.min(WAKELOCK_EXIT_CONFIDENCE_SCORING_MS, 240000 - (r10 - r8));
    }

    public static boolean isConfirmed(float r8) {
        if (r8 < 20.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean shouldConfirmExit(int r8, int r10) {
        if (r8 >= 2) goto L5;
    L7:
        return false;
    L5:
        if (r10 < 30) goto L7;
        return true;
    }

    public static boolean shouldTriggerExitSharedBikeCheck(int r8) {
        if (r8 < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean shouldTriggerStepBasedCheck(int r8, int r10, int r11) {
        if (r10 >= r8) goto L4;
    L6:
        return false;
    L4:
        if ((r10 - r8) < r11) goto L6;
        return true;
    }
}
