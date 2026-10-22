package com.bytedance.crash.upload;

import com.bytedance.crash.util.DateUtils;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NetState {
    static final String AID = "aid";
    static final String ALOG_STRATEGY = "alog_strategy";
    static final String PATH = "path";
    static final String REDIRECT = "redirect";
    static final String RETREAT_COUNT = "retreatCount";
    static final String STRATEGY = "strategy";
    static final String UPDATE_TIME = "update_time";
    static final String UPDATE_TIME_FORMAT = "update_time_format";
    private String mAid;
    private int mAlogStrategy;
    private long mDelayTime;
    private JSONObject mJson;
    private String mKeyId;
    private String mPath;
    private String mRedirect;
    private int mRetreatCount;
    private int mStrategy;
    private long mUpdateTime;
    private String mUpdateTimeFormat;

    public NetState(String r10, String r11) {
        this.mAid = r10;
        this.mPath = r11;
        this.mStrategy = 0;
        this.mAlogStrategy = 0;
        this.mUpdateTime = 0;
        this.mUpdateTimeFormat = "";
        this.mRetreatCount = 0;
        this.mDelayTime = 0;
        this.mRedirect = "";
        this.mJson = new JSONObject();
        this.mKeyId = NetworkDisasterManager.getNetKeyId(this.mAid, this.mPath);
        this.mJson.put("aid", this.mAid);     // Catch: Throwable -> L5
        this.mJson.put(PATH, this.mPath);     // Catch: Throwable -> L5
        return;
    }

    public NetState(JSONObject r10) {
        if (r10 == null) goto L7;
        this.mAid = r10.optString("aid");
        this.mPath = r10.optString(PATH);
        this.mStrategy = r10.optInt(STRATEGY);
        this.mAlogStrategy = r10.optInt(ALOG_STRATEGY);
        this.mUpdateTime = r10.optLong(UPDATE_TIME);
        this.mUpdateTimeFormat = r10.optString(UPDATE_TIME_FORMAT);
        this.mRetreatCount = r10.optInt(RETREAT_COUNT);
        this.mRedirect = r10.optString(REDIRECT);
        this.mJson = new JSONObject(r10.toString());
        this.mKeyId = NetworkDisasterManager.getNetKeyId(this.mAid, this.mPath);
        return;
    L7:
        throw new IllegalArgumentException("json can't be null");
    }

    public String getAid() {
        return this.mAid;
    }

    public int getAlogStrategy() {
        return this.mAlogStrategy;
    }

    public long getDelayTime() {
        return this.mDelayTime;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getRetreatCount() {
        int r10 = this.mStrategy;
        if (r10 == 1) goto L8;
        if (r10 != 0) goto L7;
        return 0;
    L7:
        return this.mRetreatCount;
    L8:
        return 0;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public void setAlogStrategy(int r10) {
        this.mAlogStrategy = r10;
    }

    public void setDelayTime(long r10) {
        this.mDelayTime = r10;
    }

    public void setStrategy(int r10) {
        int r11 = 1;
        if (r10 == 1) goto L10;
        if (r10 == 0) goto L10;
        if (r10 != this.mStrategy) goto L11;
        this.mRetreatCount++;
    L12:
        this.mStrategy = r10;
        return;
    L11:
        this.mRetreatCount = r11;
    L10:
        r11 = 0;
        goto L11
    }

    public void setUpdateTime(long r10) {
        this.mUpdateTime = r10;
        this.mUpdateTimeFormat = DateUtils.getFileDateInstanceMs().format(new Date(this.mUpdateTime));     // Catch: Throwable -> L5
        return;
    }

    public JSONObject toJson() {
        JSONObject r10 = new JSONObject();
        this.mJson.put("aid", this.mAid);     // Catch: Throwable -> L9
        this.mJson.put(PATH, this.mPath);     // Catch: Throwable -> L9
        this.mJson.put(UPDATE_TIME, this.mUpdateTime);     // Catch: Throwable -> L9
        this.mJson.put(UPDATE_TIME_FORMAT, DateUtils.getFileDateInstanceMs().format(new Date(this.mUpdateTime)));     // Catch: Throwable -> L6
    L7:
        this.mJson.put(STRATEGY, this.mStrategy);     // Catch: Throwable -> L9
        this.mJson.put(ALOG_STRATEGY, this.mAlogStrategy);     // Catch: Throwable -> L9
        this.mJson.put(RETREAT_COUNT, this.mRetreatCount);     // Catch: Throwable -> L9
        this.mJson.put(REDIRECT, this.mRedirect);     // Catch: Throwable -> L9
        r10.put(this.mKeyId, this.mJson);     // Catch: Throwable -> L9
        goto L8
    L6:
        this.mJson.put(UPDATE_TIME_FORMAT, "");     // Catch: Throwable -> L9
    L8:
        return r10;
    }

    public String toString() {
        return "[" + this.mKeyId + " " + this.mStrategy + " " + this.mAlogStrategy + " " + this.mRetreatCount + " " + this.mDelayTime + "]";
    }
}
