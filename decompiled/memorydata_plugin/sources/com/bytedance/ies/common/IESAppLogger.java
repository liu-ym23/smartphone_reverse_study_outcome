package com.bytedance.ies.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class IESAppLogger {
    private static final String VESDK_EVENT_SECOND_APPID = "1357";
    private static final String VESDK_EVENT_SECOND_APPID_ABROAD = "2780";
    private static final String VESDK_EVENT_SECOND_APPID_KEY = "second_appid";
    private static final String VESDK_EVENT_SECOND_APPNAME = "video_editor_sdk";
    private static final String VESDK_EVENT_SECOND_APPNAME_ABROAD = "vesdk_abroad";
    private static final String VESDK_EVENT_SECOND_APPNAME_KEY = "second_appname";
    private static volatile IESAppLogger instance;
    private static final Object object = null;
    private String appId;
    private IESAppLoggerCallback appLoggerCallback;
    private Boolean initFlag;
    private Boolean isAbroad;
    private final Set<String> mSampler;

    public interface IESAppLoggerCallback {
        void onInternalEventV3(String r1, JSONObject r2, String r3);
    }

    public static final class ReportType {
        public static final int BUSINESS = 2;
        public static final int DEFAULT = 1;

        public ReportType() {
        }
    }

    static {
        object = new Object();
    }

    private IESAppLogger() {
        this.mSampler = new HashSet();
        this.appLoggerCallback = null;
        this.initFlag = false;
        this.appId = null;
        this.isAbroad = false;
    }

    private static JSONObject copyJson(JSONObject r4) {
        if (r4 == null) goto L4;
        LinkedList r0 = new LinkedList();
        Iterator<String> r1 = r4.keys();
        if (r1 != null) goto L10;
        return new JSONObject();
    L10:
        if (r1.hasNext() == false) goto L17;
        r0.add(r1.next());
        goto L10
    L17:
        return new JSONObject(r4, (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));
    L14:
        e = move-exception;
        e.printStackTrace();
        return r4;
    L4:
        return new JSONObject();
    }

    public static IESAppLogger sharedInstance() {
        if (instance != null) goto L5;
        Object r0 = object;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (instance != null) goto L11;
        instance = new IESAppLogger();     // Catch: Throwable -> L14
    L11:
        IESAppLogger r1 = instance;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L5:
        return instance;
    }

    public void appLogOnEvent(String r2, String r3, String r4) {
        appLogOnEvent(r2, r3, r4, false);
    }

    public void appLogOnEvent(String r2, String r3, String r4, int r5) {
        JSONObject r0 = new JSONObject(r3);     // Catch: JSONException -> L4
    L6:
        appLogOnEvent(r2, r0, r4, r5);
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        r0 = new JSONObject();
        goto L6
    }

    public void appLogOnEvent(String r2, String r3, String r4, boolean r5) {
        if (this.appLoggerCallback != null) goto L11;
        return;
    L11:
        JSONObject r0 = new JSONObject(r3);     // Catch: JSONException -> L7
    L9:
        appLogOnEvent(r2, r0, r4, r5);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        r0 = new JSONObject();
        goto L9
    }

    public void appLogOnEvent(String r2, JSONObject r3, String r4) {
        appLogOnEvent(r2, r3, r4, false);
    }

    public void appLogOnEvent(String r5, JSONObject r6, String r7, int r8) {
        boolean r1 = false;
        if ((r8 & 1) != 1) goto L5;
        boolean r0 = true;
    L7:
        if ((r8 & 2) != 2) goto L10;
        r1 = true;
    L10:
        if (this.appLoggerCallback != null) goto L13;
        return;
    L13:
        if (this.mSampler.isEmpty() == false) goto L15;
    L17:
        if (r1 == false) goto L19;
        this.appLoggerCallback.onInternalEventV3(r5, copyJson(r6), r7);
    L19:
        if (r0 == false) goto L34;
        JSONObject r9 = copyJson(r6);
    L28:
        e = move-exception;
        e.printStackTrace();
    L30:
        this.appLoggerCallback.onInternalEventV3(r5, r9, r7);
        return;
    L23:
        if (this.isAbroad.booleanValue() == false) goto L26;
        r9.put(VESDK_EVENT_SECOND_APPID_KEY, VESDK_EVENT_SECOND_APPID_ABROAD);     // Catch: JSONException -> L28
        String r10 = VESDK_EVENT_SECOND_APPNAME_ABROAD;
    L25:
        r9.put(VESDK_EVENT_SECOND_APPNAME_KEY, r10);     // Catch: JSONException -> L28
        goto L30
    L26:
        r9.put(VESDK_EVENT_SECOND_APPID_KEY, VESDK_EVENT_SECOND_APPID);     // Catch: JSONException -> L28
        r10 = VESDK_EVENT_SECOND_APPNAME;
        goto L25
    L34:
        return;
    L15:
        if (this.mSampler.contains(r5) == false) goto L17;
        return;
    L5:
        r0 = false;
        goto L7
    }

    public void appLogOnEvent(String r1, JSONObject r2, String r3, boolean r4) {
        if (r4 == false) goto L4;
        int r5 = 3;
    L5:
        appLogOnEvent(r1, r2, r3, r5);
        return;
    L4:
        r5 = 1;
        goto L5
    }

    public boolean isSampled(String r2) {
        if (r2 != null) goto L4;
    L10:
        return false;
    L4:
        if (r2.isEmpty() == true) goto L10;
        if (this.mSampler.isEmpty() == true) goto L10;
        if (this.mSampler.contains(r2) == false) goto L10;
        return true;
    }

    public native void nativeSetSampler(Set<String> r1);

    public void setAppLogCallback(String r3, IESAppLoggerCallback r4, boolean r5) {
        IESAppLoggerCallback r6 = (IESAppLoggerCallback) ZeusTransformUtils.wrapperContextForParams(r4, IESAppLoggerCallback.class, "com.obric.memorydata.plugin");
        if (this.initFlag.booleanValue() == false) goto L5;
        return;
    L5:
        Object r0 = object;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.initFlag.booleanValue() == true) goto L10;
        this.appId = r3;     // Catch: Throwable -> L12
        this.appLoggerCallback = r6;     // Catch: Throwable -> L12
        this.initFlag = true;     // Catch: Throwable -> L12
        this.isAbroad = Boolean.valueOf(r5);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public synchronized void setSampler(Set<String> r3) {
        monitor-enter(this);
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r4 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (r4.isEmpty() == true) goto L11;
        this.mSampler.clear();     // Catch: Throwable -> L13
        this.mSampler.addAll(r4);     // Catch: Throwable -> L13
        nativeSetSampler(this.mSampler);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
