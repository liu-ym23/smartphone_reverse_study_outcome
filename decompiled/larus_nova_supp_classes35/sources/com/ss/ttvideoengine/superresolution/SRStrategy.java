package com.ss.ttvideoengine.superresolution;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SRStrategy {
    public static final String KEY_BITRATE_AFTER_DOWNGRADE = "bad";
    public static final String KEY_BITRATE_BEFORE_DOWNGRADE = "bbd";
    public static final String KEY_BITRATE_DOWNGRADE_TYPE = "bdt";
    public static final String KEY_CURRENT_QUALITY_DESC = "cqd";
    public static final String KEY_CURRENT_RESOLUTION = "cr";
    public static final String KEY_DISPLAY_HEIGHT = "dh";
    public static final String KEY_DISPLAY_WIDTH = "dw";
    public static final String KEY_DOWNGRADE = "do";
    public static final String KEY_ENABLE_ABR_SR = "eas";
    public static final String KEY_ENABLE_SR_STRATEGY = "ess";
    public static final String KEY_FR_PLAYER_TIME = "fpt";
    public static final String KEY_FR_TEXTURE_SET_TIME = "fts";
    public static final String KEY_FR_TEXTURE_TIME = "ftt";
    public static final String KEY_NET_STATE = "ns";
    public static final String KEY_ORIGIN_QUALITY_DESC = "oqd";
    public static final String KEY_ORIGIN_RESOLUTION = "or";
    public static final String KEY_SCREEN_HEIGHT = "sh";
    public static final String KEY_SCREEN_WIDTH = "sw";
    public static final String KEY_SR_FAIL_REASON = "sfr";
    public static final String KEY_SR_MEDIA_INFO = "smi";
    public static final String KEY_SR_OPEN = "so";
    public static final String KEY_SR_SATISFIED = "srs";
    public static final String KEY_SR_STATUS = "ss";
    public static final String KEY_SR_STRATEGY_CONFIG = "sc";
    public static final String KEY_SR_STRATEGY_MODE = "sm";
    public static final String KEY_SR_USE_TEXTURE = "sut";
    public static final String KEY_USER_EXPECTED = "ue";
    public static final String MEDIAINFO_KEY_BITRATE = "br";
    public static final String MEDIAINFO_KEY_CACHE_SIZE = "cs";
    public static final String MEDIAINFO_KEY_RESOLUTION = "res";
    public static final String MEDIAINFO_KEY_SUPPORT_SR = "ss";
    public static final String MEDIAINFO_KEY_WIDTH = "w";
    private static final int PRELOAD_INFO_CACHE_SIZE = 100;
    public static final int SCENE_DETAIL = 2;
    public static final int SCENE_FULLSCREEN = 4;
    public static final int SCENE_LIST = 1;
    public static final int SCENE_NONE = 0;
    public static final int SR_CHECK_TYPE_PLAY = 1;
    public static final int SR_CHECK_TYPE_PRELOAD = 0;
    public static final int SR_STATUS_CLOSE = 0;
    public static final int SR_STATUS_NONE = -1;
    public static final int SR_STATUS_OPEN_FAIL = 2;
    public static final int SR_STATUS_OPEN_SUCCESS = 1;
    public static final int SR_STRATEGY_MODE_AUTO = 0;
    public static final int SR_STRATEGY_MODE_USER = 1;
    private static final String TAG = "TTVideoEngine.SRStrategy";
    public static final int VIDEO_FORMAT_TYPE_DASH = 2;
    public static final int VIDEO_FORMAT_TYPE_MP4 = 1;
    private Map<Integer, List<Integer>> mSRBenchmark;
    private SRStrategyConfig mSRConfig;
    private int mSRNotUseReason;
    private boolean mSRSatisfied;
    private int mSRStatus;
    private ISRStrategyListener mSRStrategyListener;
    private int mSRStrategyMode;
    private boolean mShouldUseSRTexture;
    private Map<String, Object> mStrategyInfo;

    private void checkSatisfied() {
        this.mSRSatisfied = false;
        this.mShouldUseSRTexture = false;
        this.mSRNotUseReason = 0;
        if (2 != this.mSRStatus) goto L6;
        this.mSRNotUseReason = Error.SROpenFail;
        return;
    L6:
        Boolean r0 = this.mSRConfig.getEnableSR();
        if (r0 != null) goto L9;
    L73:
        this.mSRNotUseReason = Error.SRDisabled;
        return;
    L9:
        if (r0.booleanValue() == false) goto L73;
        Boolean r1 = this.mSRConfig.getResolutionChanged();
        if (r1 == null) goto L18;
        if (r1.booleanValue() == false) goto L18;
        this.mSRNotUseReason = Error.ResolutionChanged;
        return;
    L18:
        if (this.mSRBenchmark.size() > 0) goto L21;
        this.mSRNotUseReason = Error.NoSRBenchmark;
        return;
    L21:
        Long r2 = this.mSRConfig.getMinDuration();
        Long r3 = this.mSRConfig.getMaxDuration();
        if (r2 == null) goto L32;
        if (r3 == null) goto L32;
        Integer r4 = this.mSRConfig.getCurrentDuration();
        if (r4 != null) goto L27;
    L30:
        this.mSRNotUseReason = Error.DurationNotSupport;
        return;
    L27:
        if (r4.intValue() < r2.longValue()) goto L30;
        if (r4.intValue() > r3.longValue()) goto L30;
    L32:
        Integer r5 = this.mSRConfig.getVideoFormatType();
        if (r5 == null) goto L40;
        Integer r6 = this.mSRConfig.getCurrentVideoFormatType();
        if (r6 != null) goto L37;
    L38:
        this.mSRNotUseReason = Error.FormatNotSupport;
        return;
    L37:
        if (r6.compareTo(Integer.valueOf(r5.intValue() & r6.intValue())) != 0) goto L38;
    L40:
        Boolean r7 = this.mSRConfig.getEnableHdr();
        if (r7 == null) goto L50;
        Boolean r8 = this.mSRConfig.getIsHdr();
        if (r8 != null) goto L45;
    L48:
        this.mSRNotUseReason = Error.HdrNotSupport;
        return;
    L45:
        if (r7.booleanValue() == true) goto L50;
        if (r8.booleanValue() == true) goto L48;
    L50:
        Integer r9 = this.mSRConfig.getSupportScene();
        if (r9 == null) goto L58;
        Integer r10 = this.mSRConfig.getCurrentScene();
        if (r10 != null) goto L55;
    L56:
        this.mSRNotUseReason = Error.SceneNotSupport;
        return;
    L55:
        if (r10.compareTo(Integer.valueOf(r9.intValue() & r10.intValue())) != 0) goto L56;
    L58:
        this.mShouldUseSRTexture = true;
        Integer r11 = this.mSRConfig.getStrategyType();
        if (r11 != null) goto L61;
    L71:
        this.mSRSatisfied = true;
        return;
    L61:
        if (1 != r11.intValue()) goto L71;
        Boolean r12 = this.mSRConfig.getEnableSpeed();
        if (r12 == null) goto L71;
        Boolean r13 = this.mSRConfig.getIsSpeed();
        if (r12.booleanValue() == true) goto L71;
        if (r13 == null) goto L71;
        if (r13.booleanValue() == false) goto L71;
        this.mSRNotUseReason = Error.SpeedNotSupport;
    }

    public String configString() {
        return this.mSRConfig.toString();
    }

    public JSONObject getConfigJson() {
        return this.mSRConfig.getJson();
    }

    public Integer getMaxHeight() {
        return this.mSRConfig.getMaxHeight();
    }

    public Integer getMaxWidth() {
        return this.mSRConfig.getMaxWidth();
    }

    public boolean isSREnabled() {
        Boolean r0 = this.mSRConfig.getEnableSR();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.booleanValue();
    }

    public void resetAll() {
        this.mSRConfig.resetAll();
        this.mSRConfig.enableSR(false);
        this.mSRConfig.setEnableHdr(false);
        this.mSRConfig.setIsSpeed(false);
        this.mSRStrategyListener = null;
        this.mSRStrategyMode = 1;
        this.mSRSatisfied = false;
        this.mShouldUseSRTexture = false;
        this.mSRNotUseReason = 0;
        this.mSRStatus = -1;
        this.mStrategyInfo.clear();
    }

    public SRStrategy() {
        this.mSRConfig = new SRStrategyConfig();
        this.mSRStrategyListener = null;
        this.mSRStrategyMode = 1;
        this.mSRSatisfied = false;
        this.mShouldUseSRTexture = false;
        this.mSRNotUseReason = 0;
        this.mSRStatus = -1;
        this.mSRBenchmark = new HashMap();
        this.mStrategyInfo = new HashMap();
        resetAll();
        this.mSRBenchmark.put(2, new ArrayList(Arrays.asList(new Integer[]{3})));
    }

    public SRStrategyConfig getConfig() {
        return this.mSRConfig;
    }

    public Map<Integer, List<Integer>> getSRBenchmark() {
        return this.mSRBenchmark;
    }

    public int getSRNotUseReason() {
        return this.mSRNotUseReason;
    }

    public int getSRStatus() {
        return this.mSRStatus;
    }

    public int getSRStrategyMode() {
        return this.mSRStrategyMode;
    }

    public Map<String, Object> getStrategyInfo() {
        return this.mStrategyInfo;
    }

    public boolean isSRSatisfied() {
        return this.mSRSatisfied;
    }

    public boolean shouldUseSRTexture() {
        return this.mShouldUseSRTexture;
    }

    public static int getResolutionIndex(VideoInfo r2) {
        Resolution r0 = r2.getResolution();
        if (r0 == null) goto L5;
        int r1 = r0.getIndex();
    L6:
        String r3 = r2.getValueStr(32);
        if (r3 == null) goto L13;
        return CastIntegerProtector.parseInt(r3);
    L14:
        return r1;
    L13:
        return r1;
    L5:
        r1 = -1;
        goto L6
    }

    public void setSRStrategyListener(ISRStrategyListener r1) {
        this.mSRStrategyListener = r1;
    }

    public void setSRStrategyMode(int r1) {
        this.mSRStrategyMode = r1;
    }

    public void updateConfig(SRStrategyConfig r9) {
        if (r9 != null) goto L5;
        return;
    L5:
        this.mSRConfig.updateFrom(r9);
        String r10 = r9.getExtraConfig();
        if (r10 != null) goto L8;
    L22:
        checkSatisfied();
        return;
    L8:
        if (r10.isEmpty() == true) goto L22;
        String r11 = r10.toLowerCase();
        HashMap r1 = new HashMap();
        JSONObject r12 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r11), "sr"), "benchmark");     // Catch: Exception -> L20
        Iterator<String> r2 = r12.keys();     // Catch: Exception -> L20
    L12:
        if (r2.hasNext() == false) goto L18;
        String r3 = r2.next();     // Catch: Exception -> L20
        int r4 = CastIntegerProtector.parseInt(r3);     // Catch: Exception -> L20
        JSONArray r5 = JSONObjectProtectorUtils.getJSONArray(r12, r3);     // Catch: Exception -> L20
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L20
        int r7 = 0;
    L15:
        if (r7 >= r5.length()) goto L17;
        r6.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r5, r7)));     // Catch: Exception -> L20
        r7 = r7 + 1;     // Catch: Exception -> L20
        goto L15
    L17:
        r1.put(Integer.valueOf(r4), r6);     // Catch: Exception -> L20
        goto L12
    L18:
        this.mSRBenchmark = r1;     // Catch: Exception -> L20
        TTVideoEngineLog.i(TAG, "[SRLog]updateConfig mSRBenchmark=" + this.mSRBenchmark);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        TTVideoEngineLog.i(TAG, "[SRLog]updateConfig exception=" + e);
        e.printStackTrace();
        goto L22
    }

    public void onSRStatus(int r3, int r4) {
        int r0 = this.mSRStatus;
        if (r3 != r0) goto L6;
        return;
    L6:
        if (r3 != 0) goto L9;
        if (2 != r0) goto L9;
        return;
    L9:
        this.mSRStatus = r3;
        if (2 != r3) goto L13;
        this.mSRNotUseReason = r4;
        return;
    }

    public void setStrategyInfo(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (this.mStrategyInfo.containsKey(r2) == true) goto L9;
        this.mStrategyInfo.put(r2, r3);
        return;
    }

    public Boolean videoInfoSupportSR(VideoInfo r8, List<VideoInfo> r9) {
        int r10 = getResolutionIndex(r8);
        if (this.mSRBenchmark.containsKey(Integer.valueOf(r10)) == false) goto L5;
        Integer r0 = this.mSRConfig.getScreenWidth();
        List<Integer> r11 = this.mSRBenchmark.get(Integer.valueOf(r10));
        if (r11 == null) goto L9;
        Iterator<VideoInfo> r12 = r9.iterator();
        VideoInfo r1 = null;
    L12:
        if (r12.hasNext() == false) goto L22;
        VideoInfo r2 = r12.next();
        int r3 = getResolutionIndex(r2);
        Iterator<Integer> r4 = r11.iterator();
    L15:
        if (r4.hasNext() == false) goto L12;
        if (r4.next().intValue() != r3) goto L15;
        if (r1 == null) goto L21;
        if (r1.getValueInt(3) >= r2.getValueInt(3)) goto L15;
    L21:
        r1 = r2;
        goto L12
    L22:
        if (r1 == null) goto L30;
        if (r0 == null) goto L28;
        if (r1.getValueInt(1) <= r0.intValue()) goto L30;
    L28:
        return Boolean.TRUE;
    L30:
        return Boolean.FALSE;
    L9:
        return Boolean.FALSE;
    L5:
        return Boolean.FALSE;
    }
}
