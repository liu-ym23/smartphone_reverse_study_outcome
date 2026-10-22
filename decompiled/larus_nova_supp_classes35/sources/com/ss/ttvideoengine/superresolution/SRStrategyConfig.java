package com.ss.ttvideoengine.superresolution;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SRStrategyConfig {
    public static final int KEY_EFFECT = 1;
    private Integer mCurrentDuration;
    private Float mCurrentFps;
    private Integer mCurrentHeight;
    private Integer mCurrentPower;
    private Integer mCurrentScene;
    private Integer mCurrentVideoFormatType;
    private Integer mCurrentWidth;
    private Bundle mEffectBuddle;
    private Boolean mEnableHdr;
    private Boolean mEnableSR;
    private Boolean mEnableSpeed;
    private String mExtraConfig;
    private Map<String, String> mExtraInfo;
    private Boolean mIsCharging;
    private Boolean mIsHdr;
    private Boolean mIsSpeed;
    private Long mMaxDuration;
    private Float mMaxFps;
    private Integer mMaxHeight;
    private Integer mMaxWidth;
    private Long mMinDuration;
    private Integer mMinPower;
    private Boolean mResolutionChanged;
    private Integer mSRPercent;
    private Integer mScreenWidth;
    ISRStatusListener mStatusListener;
    ISRStrategyListener mStrategyListener;
    private Integer mStrategyType;
    private Integer mSupportScene;
    private Integer mVideoFormatType;

    public void resetAll() {
        this.mEnableSR = null;
        this.mVideoFormatType = null;
        this.mMinDuration = null;
        this.mMaxDuration = null;
        this.mMinPower = null;
        this.mSupportScene = null;
        this.mEnableSpeed = null;
        this.mSRPercent = null;
        this.mMaxWidth = null;
        this.mMaxHeight = null;
        this.mMaxFps = null;
        this.mEnableHdr = null;
        this.mCurrentVideoFormatType = null;
        this.mCurrentDuration = null;
        this.mCurrentPower = null;
        this.mIsCharging = null;
        this.mCurrentScene = null;
        this.mIsSpeed = null;
        this.mCurrentWidth = null;
        this.mCurrentHeight = null;
        this.mCurrentFps = null;
        this.mIsHdr = null;
        this.mExtraConfig = null;
        this.mExtraInfo.clear();
        this.mStatusListener = null;
        this.mResolutionChanged = null;
        this.mStrategyType = null;
        this.mScreenWidth = null;
        this.mStrategyListener = null;
        this.mEffectBuddle = null;
    }

    public void resetStream() {
        this.mMaxFps = null;
        this.mCurrentVideoFormatType = null;
        this.mCurrentDuration = null;
        this.mCurrentWidth = null;
        this.mCurrentHeight = null;
        this.mCurrentFps = null;
        this.mIsHdr = null;
        this.mResolutionChanged = null;
        this.mIsSpeed = null;
        this.mStrategyType = null;
    }

    public static SRStrategyConfig newConfig() {
        return new SRStrategyConfig();
    }

    public JSONObject getJson() {
        JSONObject r0 = new JSONObject();
        Boolean r1 = this.mEnableSR;     // Catch: JSONException -> L87
        int r2 = 1;
        if (r1 != null) goto L6;
    L10:
        Integer r3 = this.mStrategyType;     // Catch: JSONException -> L87
        if (r3 == null) goto L13;
        r0.put("st", r3);     // Catch: JSONException -> L87
    L13:
        Integer r4 = this.mMaxWidth;     // Catch: JSONException -> L87
        if (r4 == null) goto L16;
        r0.put("mw", r4);     // Catch: JSONException -> L87
    L16:
        Integer r5 = this.mMaxHeight;     // Catch: JSONException -> L87
        if (r5 == null) goto L19;
        r0.put("mh", r5);     // Catch: JSONException -> L87
    L19:
        Integer r6 = this.mScreenWidth;     // Catch: JSONException -> L87
        if (r6 == null) goto L22;
        r0.put(SRStrategy.KEY_SCREEN_WIDTH, r6);     // Catch: JSONException -> L87
    L22:
        Integer r7 = this.mCurrentWidth;     // Catch: JSONException -> L87
        if (r7 == null) goto L25;
        r0.put("cw", r7);     // Catch: JSONException -> L87
    L25:
        Integer r8 = this.mCurrentHeight;     // Catch: JSONException -> L87
        if (r8 == null) goto L28;
        r0.put("ch", r8);     // Catch: JSONException -> L87
    L28:
        Integer r9 = this.mVideoFormatType;     // Catch: JSONException -> L87
        if (r9 == null) goto L31;
        r0.put("ft", r9);     // Catch: JSONException -> L87
    L31:
        Integer r10 = this.mCurrentVideoFormatType;     // Catch: JSONException -> L87
        if (r10 == null) goto L34;
        r0.put("cft", r10);     // Catch: JSONException -> L87
    L34:
        Long r11 = this.mMinDuration;     // Catch: JSONException -> L87
        if (r11 == null) goto L37;
        r0.put("mid", r11);     // Catch: JSONException -> L87
    L37:
        Long r12 = this.mMaxDuration;     // Catch: JSONException -> L87
        if (r12 == null) goto L40;
        r0.put("mad", r12);     // Catch: JSONException -> L87
    L40:
        Integer r13 = this.mCurrentDuration;     // Catch: JSONException -> L87
        if (r13 == null) goto L43;
        r0.put("cd", r13);     // Catch: JSONException -> L87
    L43:
        Integer r14 = this.mSupportScene;     // Catch: JSONException -> L87
        if (r14 == null) goto L46;
        r0.put("ss", r14);     // Catch: JSONException -> L87
    L46:
        Integer r15 = this.mCurrentScene;     // Catch: JSONException -> L87
        if (r15 == null) goto L49;
        r0.put(SRStrategy.MEDIAINFO_KEY_CACHE_SIZE, r15);     // Catch: JSONException -> L87
    L49:
        Boolean r16 = this.mEnableSpeed;     // Catch: JSONException -> L87
        if (r16 != null) goto L52;
    L56:
        Boolean r17 = this.mIsSpeed;     // Catch: JSONException -> L87
        if (r17 != null) goto L59;
    L63:
        Float r18 = this.mMaxFps;     // Catch: JSONException -> L87
        if (r18 == null) goto L66;
        r0.put("mf", r18);     // Catch: JSONException -> L87
    L66:
        Float r19 = this.mCurrentFps;     // Catch: JSONException -> L87
        if (r19 == null) goto L69;
        r0.put("cf", r19);     // Catch: JSONException -> L87
    L69:
        Boolean r20 = this.mEnableHdr;     // Catch: JSONException -> L87
        if (r20 != null) goto L72;
    L76:
        Boolean r21 = this.mIsHdr;     // Catch: JSONException -> L87
        if (r21 == null) goto L84;
        if (r21.booleanValue() == true) goto L82;
        r2 = 0;
    L82:
        r0.put("ih", r2);     // Catch: JSONException -> L87
    L84:
        if (this.mExtraInfo == null) goto L89;
        r0.put("ei", new JSONObject(this.mExtraInfo));     // Catch: JSONException -> L87
    L89:
        return r0;
    L72:
        if (r20.booleanValue() == false) goto L74;
        int r22 = 1;
    L75:
        r0.put("eh", r22);     // Catch: JSONException -> L87
        goto L76
    L74:
        r22 = 0;
        goto L75
    L59:
        if (r17.booleanValue() == false) goto L61;
        int r23 = 1;
    L62:
        r0.put("is", r23);     // Catch: JSONException -> L87
        goto L63
    L61:
        r23 = 0;
        goto L62
    L52:
        if (r16.booleanValue() == false) goto L54;
        int r24 = 1;
    L55:
        r0.put("es", r24);     // Catch: JSONException -> L87
        goto L56
    L54:
        r24 = 0;
        goto L55
    L6:
        if (r1.booleanValue() == false) goto L8;
        int r25 = 1;
    L9:
        r0.put("e", r25);     // Catch: JSONException -> L87
        goto L10
    L8:
        r25 = 0;
    L87:
        e = move-exception;
        e.printStackTrace();
        goto L89
    }

    public SRStrategyConfig() {
        this.mExtraInfo = new HashMap();
        resetAll();
    }

    public String toString() {
        return getJson().toString();
    }

    public Integer getCurrentDuration() {
        return this.mCurrentDuration;
    }

    public Float getCurrentFps() {
        return this.mCurrentFps;
    }

    public Integer getCurrentHeight() {
        return this.mCurrentHeight;
    }

    public Integer getCurrentPower() {
        return this.mCurrentPower;
    }

    public Integer getCurrentScene() {
        return this.mCurrentScene;
    }

    public Integer getCurrentVideoFormatType() {
        return this.mCurrentVideoFormatType;
    }

    public Integer getCurrentWidth() {
        return this.mCurrentWidth;
    }

    public Boolean getEnableHdr() {
        return this.mEnableHdr;
    }

    public Boolean getEnableSR() {
        return this.mEnableSR;
    }

    public Boolean getEnableSpeed() {
        return this.mEnableSpeed;
    }

    public String getExtraConfig() {
        return this.mExtraConfig;
    }

    public Map<String, String> getExtraInfo() {
        return this.mExtraInfo;
    }

    public Boolean getIsCharging() {
        return this.mIsCharging;
    }

    public Boolean getIsHdr() {
        return this.mIsHdr;
    }

    public Boolean getIsSpeed() {
        return this.mIsSpeed;
    }

    public ISRStatusListener getListener() {
        return this.mStatusListener;
    }

    public Long getMaxDuration() {
        return this.mMaxDuration;
    }

    public Float getMaxFps() {
        return this.mMaxFps;
    }

    public Integer getMaxHeight() {
        return this.mMaxHeight;
    }

    public Integer getMaxWidth() {
        return this.mMaxWidth;
    }

    public Long getMinDuration() {
        return this.mMinDuration;
    }

    public Integer getMinPower() {
        return this.mMinPower;
    }

    public Boolean getResolutionChanged() {
        return this.mResolutionChanged;
    }

    public Integer getSRPercent() {
        return this.mSRPercent;
    }

    public Integer getScreenWidth() {
        return this.mScreenWidth;
    }

    public ISRStrategyListener getStrategyListener() {
        return this.mStrategyListener;
    }

    public Integer getStrategyType() {
        return this.mStrategyType;
    }

    public Integer getSupportScene() {
        return this.mSupportScene;
    }

    public Integer getVideoFormatType() {
        return this.mVideoFormatType;
    }

    public SRStrategyConfig enableSR(boolean r1) {
        this.mEnableSR = Boolean.valueOf(r1);
        return this;
    }

    public SRStrategyConfig enableSpeed(boolean r1) {
        this.mEnableSpeed = Boolean.valueOf(r1);
        return this;
    }

    public SRStrategyConfig resolutionChanged(boolean r1) {
        this.mResolutionChanged = Boolean.valueOf(r1);
        return this;
    }

    public void setCurrentDuration(int r1) {
        this.mCurrentDuration = Integer.valueOf(r1);
    }

    public SRStrategyConfig setCurrentFps(float r1) {
        this.mCurrentFps = Float.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setCurrentHeight(int r1) {
        this.mCurrentHeight = Integer.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setCurrentPower(int r1) {
        this.mCurrentPower = Integer.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setCurrentScene(int r1) {
        this.mCurrentScene = Integer.valueOf(r1);
        return this;
    }

    public void setCurrentVideoFormatType(int r1) {
        this.mCurrentVideoFormatType = Integer.valueOf(r1);
    }

    public SRStrategyConfig setCurrentWidth(int r1) {
        this.mCurrentWidth = Integer.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setEnableHdr(boolean r1) {
        this.mEnableHdr = Boolean.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setExtraConfig(String r1) {
        this.mExtraConfig = r1;
        return this;
    }

    public SRStrategyConfig setExtraInfo(Map<String, String> r1) {
        this.mExtraInfo = r1;
        return this;
    }

    public SRStrategyConfig setIsCharging(boolean r1) {
        this.mIsCharging = Boolean.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setIsHdr(boolean r1) {
        this.mIsHdr = Boolean.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setIsSpeed(boolean r1) {
        this.mIsSpeed = Boolean.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setListener(ISRStatusListener r1) {
        this.mStatusListener = r1;
        return this;
    }

    public SRStrategyConfig setMaxFps(float r1) {
        this.mMaxFps = Float.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setMaxHeight(int r1) {
        this.mMaxHeight = Integer.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setMaxWidth(int r1) {
        this.mMaxWidth = Integer.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setMinPower(int r1) {
        this.mMinPower = Integer.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setSRPercent(int r1) {
        this.mSRPercent = Integer.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setScreenWidth(int r1) {
        this.mScreenWidth = Integer.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setStrategyListener(ISRStrategyListener r1) {
        this.mStrategyListener = r1;
        return this;
    }

    public SRStrategyConfig setStrategyType(int r1) {
        this.mStrategyType = Integer.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setSupportScene(int r1) {
        this.mSupportScene = Integer.valueOf(r1);
        return this;
    }

    public SRStrategyConfig setVideoFormatType(int r1) {
        this.mVideoFormatType = Integer.valueOf(r1);
        return this;
    }

    public void updateFrom(SRStrategyConfig r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Boolean r0 = r3.getResolutionChanged();
        if (r0 == null) goto L7;
        this.mResolutionChanged = r0;
    L7:
        Boolean r1 = r3.getEnableSR();
        if (r1 == null) goto L10;
        this.mEnableSR = r1;
    L10:
        Integer r2 = r3.getVideoFormatType();
        if (r2 == null) goto L13;
        this.mVideoFormatType = r2;
    L13:
        Long r4 = r3.getMinDuration();
        if (r4 == null) goto L16;
        this.mMinDuration = r4;
    L16:
        Long r5 = r3.getMaxDuration();
        if (r5 == null) goto L19;
        this.mMaxDuration = r5;
    L19:
        Integer r6 = r3.getMinPower();
        if (r6 == null) goto L22;
        this.mMinPower = r6;
    L22:
        Integer r7 = r3.getSupportScene();
        if (r7 == null) goto L25;
        this.mSupportScene = r7;
    L25:
        Boolean r8 = r3.getEnableSpeed();
        if (r8 == null) goto L28;
        this.mEnableSpeed = r8;
    L28:
        Integer r9 = r3.getSRPercent();
        if (r9 == null) goto L31;
        this.mSRPercent = r9;
    L31:
        Integer r10 = r3.getMaxWidth();
        if (r10 == null) goto L34;
        this.mMaxWidth = r10;
    L34:
        Integer r11 = r3.getMaxHeight();
        if (r11 == null) goto L37;
        this.mMaxHeight = r11;
    L37:
        Float r12 = r3.getMaxFps();
        if (r12 == null) goto L40;
        this.mMaxFps = r12;
    L40:
        Boolean r13 = r3.getEnableHdr();
        if (r13 == null) goto L43;
        this.mEnableHdr = r13;
    L43:
        Integer r14 = r3.getCurrentVideoFormatType();
        if (r14 == null) goto L46;
        this.mCurrentVideoFormatType = r14;
    L46:
        Integer r15 = r3.getCurrentDuration();
        if (r15 == null) goto L49;
        this.mCurrentDuration = r15;
    L49:
        Integer r16 = r3.getCurrentPower();
        if (r16 == null) goto L52;
        this.mCurrentPower = r16;
    L52:
        Boolean r17 = r3.getIsCharging();
        if (r17 == null) goto L55;
        this.mIsCharging = r17;
    L55:
        Integer r18 = r3.getCurrentScene();
        if (r18 == null) goto L58;
        this.mCurrentScene = r18;
    L58:
        Boolean r19 = r3.getIsSpeed();
        if (r19 == null) goto L61;
        this.mIsSpeed = r19;
    L61:
        Integer r20 = r3.getCurrentWidth();
        if (r20 == null) goto L64;
        this.mCurrentWidth = r20;
    L64:
        Integer r21 = r3.getCurrentHeight();
        if (r21 == null) goto L67;
        this.mCurrentHeight = r21;
    L67:
        Float r22 = r3.getCurrentFps();
        if (r22 == null) goto L70;
        this.mCurrentFps = r22;
    L70:
        Boolean r23 = r3.getIsHdr();
        if (r23 == null) goto L73;
        this.mIsHdr = r23;
    L73:
        ISRStatusListener r24 = r3.getListener();
        if (r24 == null) goto L76;
        this.mStatusListener = r24;
    L76:
        ISRStrategyListener r25 = r3.getStrategyListener();
        if (r25 == null) goto L79;
        this.mStrategyListener = r25;
    L79:
        Integer r26 = r3.getStrategyType();
        if (r26 == null) goto L82;
        this.mStrategyType = r26;
    L82:
        Integer r27 = r3.getScreenWidth();
        if (r27 == null) goto L85;
        this.mScreenWidth = r27;
    L85:
        Map<String, String> r28 = r3.getExtraInfo();
        if (r28 == null) goto L88;
        this.mExtraInfo.putAll(r28);
    L88:
        Object r29 = r3.getValue(1, null);
        if (r29 == null) goto L92;
        this.mEffectBuddle = (Bundle) r29;
        return;
    }

    public Object getValue(int r2, Object r3) {
        if (r2 == 1) goto L6;
        return r3;
    L6:
        return this.mEffectBuddle;
    }

    public SRStrategyConfig setDurationRangeSecond(long r1, long r3) {
        this.mMinDuration = Long.valueOf(r1);
        this.mMaxDuration = Long.valueOf(r3);
        return this;
    }

    public SRStrategyConfig setValue(int r2, Object r3) {
        if (r2 != 1) goto L6;
        this.mEffectBuddle = (Bundle) r3;
    L6:
        return this;
    }
}
