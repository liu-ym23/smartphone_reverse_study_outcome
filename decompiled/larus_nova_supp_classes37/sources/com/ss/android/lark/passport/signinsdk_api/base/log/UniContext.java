package com.ss.android.lark.passport.signinsdk_api.base.log;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UniContext implements Serializable, Parcelable {
    public static final UniContext CONTEXT_DEVICES = null;
    public static final UniContext CONTEXT_EMPTY = null;
    public static final UniContext CONTEXT_GLOBAL = null;
    public static final UniContext CONTEXT_QR_CODE = null;
    public static final UniContext CONTEXT_START_UP = null;
    public static final UniContext CONTEXT_SWITCH = null;
    public static final Parcelable.Creator<UniContext> CREATOR = null;
    public static final String KEY_OF_BIZ_CODE = "biz_code";
    public static final String KEY_OF_CP = "cp";
    public static final String KEY_OF_ERROR_CODE = "error_code";
    public static final String KEY_OF_ERROR_MSG = "error_msg";
    public static final String KEY_OF_UNI_CONTEXT = "key_of_uni_context";
    public transient Bundle a;
    private String curCountryCode;
    private String curUserName;
    private String mCp;
    private String mMonitorScene;
    private OPTrace mOPTraceScene;
    private final Map<String, String> mOneSceneMonitorParams;
    private final Map<String, String> mOneTimeParams;
    private String mSubDomain;
    private String mTraceId;
    private String mUseId;
    private String requestHost;

    public class a implements Parcelable.Creator<UniContext> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UniContext createFromParcel(Parcel r2) {
            return new UniContext(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final UniContext[] newArray(int r1) {
            return new UniContext[r1];
        }
    }

    public synchronized void clearOneSceneMonitorParams() {
        monitor-enter(this);
        this.mOneSceneMonitorParams.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void clearOneTimeParams() {
        monitor-enter(this);
        this.mOneTimeParams.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public synchronized Map<String, Object> getOneSceneMonitorParams() {
        monitor-enter(this);
        ArrayMap r0 = new ArrayMap();     // Catch: Throwable -> L6
        r0.putAll(this.mOneSceneMonitorParams);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Map<String, String> getOneTimeParams() {
        monitor-enter(this);
        ArrayMap r0 = new ArrayMap();     // Catch: Throwable -> L6
        r0.putAll(this.mOneTimeParams);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        CONTEXT_GLOBAL = newInstance("global", true);
        CONTEXT_START_UP = newInstance("startUp", true);
        CONTEXT_EMPTY = newInstance("unknown", true);
        CONTEXT_DEVICES = newInstance("devices", true);
        CONTEXT_QR_CODE = newInstance("qrCode", true);
        CONTEXT_SWITCH = newInstance("switch", true);
        CREATOR = new a();
    }

    public Bundle getBundle() {
        return this.a;
    }

    public String getCp() {
        return this.mCp;
    }

    public String getCurCountryCode() {
        return this.curCountryCode;
    }

    public String getCurUserName() {
        return this.curUserName;
    }

    public String getMonitorScene() {
        return this.mMonitorScene;
    }

    public OPTrace getOPTraceScene() {
        return this.mOPTraceScene;
    }

    public String getRequestHost() {
        return this.requestHost;
    }

    public String getSubDomain() {
        return this.mSubDomain;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public String getUseId() {
        return this.mUseId;
    }

    public UniContext(Parcel r2) {
        this.mOneTimeParams = new HashMap();
        this.curUserName = "";
        this.curCountryCode = "";
        this.requestHost = "";
        this.mOneSceneMonitorParams = new HashMap();
        this.mTraceId = r2.readString();
        this.mUseId = r2.readString();
        this.mCp = r2.readString();
        this.mSubDomain = r2.readString();
        this.curUserName = r2.readString();
        this.curCountryCode = r2.readString();
        this.requestHost = r2.readString();
        this.mMonitorScene = r2.readString();
        this.a = r2.readBundle(UniContext.class.getClassLoader());
    }

    public void setBundle(Bundle r1) {
        this.a = r1;
    }

    public synchronized UniContext setCp(String r1) {
        monitor-enter(this);
        this.mCp = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setCurCountryCode(String r2) {
        monitor-enter(this);
        this.curCountryCode = r2;     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r2) == false) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (r2.startsWith("+") == true) goto L8;
        this.curCountryCode = "+".concat(this.curCountryCode);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized UniContext setCurUserName(String r1) {
        monitor-enter(this);
        this.curUserName = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public void setRequestHost(String r1) {
        this.requestHost = r1;
    }

    public void setTraceId(String r1) {
        this.mTraceId = r1;
    }

    public synchronized UniContext setUseId(String r1) {
        monitor-enter(this);
        this.mUseId = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public UniContext(String r2, OPTrace r3) {
        this.mOneTimeParams = new HashMap();
        this.curUserName = "";
        this.curCountryCode = "";
        this.requestHost = "";
        this.mOneSceneMonitorParams = new HashMap();
        this.mTraceId = gyb.a.a().getTracingID();
        this.mMonitorScene = r2;
        this.mOPTraceScene = r3;
    }

    public static UniContext newInstance(String r1, boolean r2) {
        return new UniContext(r1, r2);
    }

    public static UniContext newMonitorContext(String r1, OPTrace r2) {
        return new UniContext(r1, r2);
    }

    public synchronized UniContext appendOneSceneMonitorParam(String r2, String r3) {
        monitor-enter(this);
        this.mOneSceneMonitorParams.put(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized UniContext appendOneTimeParam(String r2, String r3) {
        monitor-enter(this);
        this.mOneTimeParams.put(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mTraceId);
        r1.writeString(this.mUseId);
        r1.writeString(this.mCp);
        r1.writeString(this.mSubDomain);
        r1.writeString(this.curUserName);
        r1.writeString(this.curCountryCode);
        r1.writeString(this.requestHost);
        r1.writeString(this.mMonitorScene);
        r1.writeBundle(this.a);
    }

    public UniContext(String r2, boolean r3) {
        this.mOneTimeParams = new HashMap();
        this.curUserName = "";
        this.curCountryCode = "";
        this.requestHost = "";
        this.mOneSceneMonitorParams = new HashMap();
        if (r3 == false) goto L5;
        this.mTraceId = gyb.a.a().getTracingID();
    L5:
        this.mSubDomain = r2;
    }
}
