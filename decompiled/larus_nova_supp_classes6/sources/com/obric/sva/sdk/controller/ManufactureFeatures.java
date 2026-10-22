package com.obric.sva.sdk.controller;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\b\u0010\u000f\u001a\u00020\u0007H\u0007J\b\u0010\u0010\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/sva/sdk/controller/ManufactureFeatures;", "", "<init>", "()V", "TAG", "", "BREATH_WAKEUP_DEFAULT_VALUE", "", "FASTER_VOICE_COMMAND_DEFAULT_VALUE", "VIP_PID_DEFAULT_VALUE", "breathFeatureMaps", "", "voiceCommandFasterFeatureMaps", "vipPidFeatureMaps", "isFeatureBreathWakeupEnable", "isFeatureVoiceCommandFasterFeatureEnable", "isFeatureVipPidEnable", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ManufactureFeatures {
    private static final boolean BREATH_WAKEUP_DEFAULT_VALUE = true;
    private static final boolean FASTER_VOICE_COMMAND_DEFAULT_VALUE = true;
    public static final ManufactureFeatures INSTANCE = null;
    public static final String TAG = "ManufactureFeatures";
    private static final boolean VIP_PID_DEFAULT_VALUE = true;
    private static final Map<String, Boolean> breathFeatureMaps = null;
    private static final Map<String, Boolean> vipPidFeatureMaps = null;
    private static final Map<String, Boolean> voiceCommandFasterFeatureMaps = null;

    private ManufactureFeatures() {
    }

    static {
        INSTANCE = new ManufactureFeatures();
        Boolean r2 = Boolean.TRUE;
        Boolean r4 = Boolean.FALSE;
        breathFeatureMaps = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("default", r2), TuplesKt.to("genesis-r", r4)});
        voiceCommandFasterFeatureMaps = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("default", r2), TuplesKt.to("genesis-r", r4)});
        vipPidFeatureMaps = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("default", r2), TuplesKt.to("genesis-r", r4)});
    }

    @JvmStatic
    public static final boolean isFeatureBreathWakeupEnable() {
        Map<String, Boolean> r0 = breathFeatureMaps;
        KtUtils r1 = KtUtils.INSTANCE;
        Boolean r2 = r0.get(r1.getPlatformName());
        if (r2 == null) goto L5;
        boolean r3 = r2.booleanValue();
    L6:
        LogUtils.d(TAG, "isFeatureBreathWakeupEnable " + r3 + " with platform " + r1.getPlatformName(), new Object[0]);
        return r3;
    L5:
        r3 = true;
        goto L6
    }

    @JvmStatic
    public static final boolean isFeatureVipPidEnable() {
        Map<String, Boolean> r0 = vipPidFeatureMaps;
        KtUtils r1 = KtUtils.INSTANCE;
        Boolean r2 = r0.get(r1.getPlatformName());
        if (r2 == null) goto L5;
        boolean r3 = r2.booleanValue();
    L6:
        LogUtils.d(TAG, "isFeatureVipPidEnable " + r3 + " with platform " + r1.getPlatformName(), new Object[0]);
        return r3;
    L5:
        r3 = true;
        goto L6
    }

    @JvmStatic
    public static final boolean isFeatureVoiceCommandFasterFeatureEnable() {
        Map<String, Boolean> r0 = voiceCommandFasterFeatureMaps;
        KtUtils r1 = KtUtils.INSTANCE;
        Boolean r2 = r0.get(r1.getPlatformName());
        if (r2 == null) goto L5;
        boolean r3 = r2.booleanValue();
    L6:
        LogUtils.d(TAG, "isFeatureVoiceCommandFasterFeatureEnable " + r3 + " with platform " + r1.getPlatformName(), new Object[0]);
        return r3;
    L5:
        r3 = true;
        goto L6
    }
}
