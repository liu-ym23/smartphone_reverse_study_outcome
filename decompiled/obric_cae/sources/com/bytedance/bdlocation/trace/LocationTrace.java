package com.bytedance.bdlocation.trace;

import android.util.Log;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationTrace implements LocateCallback {
    private static final int THROWABLES_LENGTH = 16;
    private boolean isCache;
    private TraceCallback mCallback;
    private BDLocationException mError;
    private long mFirstCallbackTimeMs;
    private long mGeocodeDuration;
    private BDLocation mLocation;
    private long mStartTimeMs;
    private long mStopTimeMs;
    private final String mTag;
    private List<Throwable> mThrowables;

    public LocationTrace(String r8) {
        this.mTag = r8;
        this.mThrowables = Collections.synchronizedList(new ArrayList(3));
    }

    private void reset() {
        this.isCache = false;
        this.mStopTimeMs = 0;
        this.mFirstCallbackTimeMs = 0;
        this.mLocation = null;
        this.mError = null;
        this.mGeocodeDuration = 0;
    }

    public void addGeocodeDuration(long r8) {
        if (this.mGeocodeDuration != 0) goto L6;
        this.mGeocodeDuration = r8;
        return;
    }

    public void addTraceInfo(BDLocation r8) {
        TraceCallback r10 = this.mCallback;
        if (r10 == null) goto L5;
        r10.onLocationChanged(new BDLocation(r8));
    L5:
        this.mLocation = r8;
        this.isCache = r8.isCache();
        if (this.mFirstCallbackTimeMs != 0) goto L9;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
        return;
    }

    public void clearCauses() {
        this.mThrowables.clear();
    }

    public void endTrace() {
        endTrace(false);
    }

    public BDLocationException getAllCauses() {
        if (this.mThrowables.isEmpty() == true) goto L7;
        return new BDLocationException(new ArrayList(this.mThrowables));
    L7:
        return this.mError;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public String getTag() {
        return this.mTag;
    }

    public long getTraceTimeMs() {
        return this.mStopTimeMs - this.mStartTimeMs;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateChange(String r8, BDLocation r10) {
        TraceCallback r11 = this.mCallback;
        if (r11 == null) goto L6;
        r11.onLocateChange(r8, r10);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateError(String r8, BDLocationException r10) {
        TraceCallback r11 = this.mCallback;
        if (r11 == null) goto L6;
        r11.onLocateError(r8, r10);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStart(String r8) {
        TraceCallback r10 = this.mCallback;
        if (r10 == null) goto L6;
        r10.onLocateStart(r8);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStop(String r8) {
        TraceCallback r10 = this.mCallback;
        if (r10 == null) goto L6;
        r10.onLocateStop(r8);
        return;
    }

    public void reduce(BDLocationException r8) {
        addTraceInfo(r8);
        endTrace(true);
        reset();
    }

    public void setTraceCallback(TraceCallback r8) {
        this.mCallback = r8;
    }

    public void startTrace() {
        TraceCallback r8 = this.mCallback;
        if (r8 == null) goto L5;
        r8.onStart(this);
    L5:
        this.mStartTimeMs = System.currentTimeMillis();
        if (BDLocationConfig.isDebug() == false) goto L9;
        Log.d("BDLocation", this.mTag);
        return;
    }

    public String toString() {
        return "LocationTrace{mTag='" + this.mTag + "', mStartTimeMs=" + this.mStartTimeMs + ", isCache=" + this.isCache + ", mStopTimeMs=" + this.mStopTimeMs + ", mLocation=" + this.mLocation + ", mError=" + this.mError + '}';
    }

    private void endTrace(boolean r14) {
        TraceCallback r8 = this.mCallback;
        if (r8 == null) goto L6;
        if (r14 == true) goto L6;
        r8.onStop();
    L6:
        this.mStopTimeMs = System.currentTimeMillis();
        BDLocation r10 = this.mLocation;
        BDLocationException r11 = this.mError;
        if (BDLocationConfig.isDebug() == false) goto L10;
        Log.d("BDLocation", toString());
    L10:
        if (this.mFirstCallbackTimeMs != 0) goto L12;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
    L12:
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        r12.put(TraceCons.METRIC_BIZ, this.mTag);     // Catch: Exception -> L28
        if (LocationUtil.isBackground() == false) goto L16;
        int r15 = 1;
    L17:
        r12.put(TraceCons.METRIC_BACKGROUND, r15);     // Catch: Exception -> L28
        if (r10 == null) goto L21;
        r12.put("total_duration", this.mFirstCallbackTimeMs - this.mStartTimeMs);     // Catch: Exception -> L28
        r12.put(TraceCons.METRIC_GEO_COST, this.mGeocodeDuration);     // Catch: Exception -> L28
        r12.put(TraceCons.METRIC_REDUCE, r14);     // Catch: Exception -> L28
        r12.put("status", 1);     // Catch: Exception -> L28
        return;
    L21:
        if (r11 == null) goto L31;
        r12.put("total_duration", this.mFirstCallbackTimeMs - this.mStartTimeMs);     // Catch: Exception -> L28
        r12.put("status", 0);     // Catch: Exception -> L28
        r12.put(TraceCons.METRIC_REDUCE, r14);     // Catch: Exception -> L28
        r13.put(TraceCons.EXTRA_FAIL_CODE, r11.getCode());     // Catch: Exception -> L28
        r13.put(TraceCons.EXTRA_FAIL_MESSAGE, r11.getMessage());     // Catch: Exception -> L28
        Iterator<Map.Entry<String, String>> r16 = r11.getExtra().entrySet().iterator();     // Catch: Exception -> L28
    L24:
        if (r16.hasNext() == false) goto L33;
        Map.Entry<String, String> r17 = r16.next();     // Catch: Exception -> L28
        r13.put(r17.getKey(), r17.getValue());     // Catch: Exception -> L28
        goto L24
    L33:
        return;
    L31:
        return;
    L16:
        r15 = 0;
        goto L17
    }

    public void addTraceInfo(BDLocationException r8) {
        TraceCallback r10 = this.mCallback;
        if (r10 == null) goto L5;
        r10.onError(r8);
    L5:
        this.mError = r8;
        if (this.mThrowables.size() >= 16) goto L10;
        this.mThrowables.add(r8);     // Catch: Exception -> L13
    L10:
        if (this.mFirstCallbackTimeMs != 0) goto L16;
        this.mFirstCallbackTimeMs = System.currentTimeMillis();
        return;
    }
}
