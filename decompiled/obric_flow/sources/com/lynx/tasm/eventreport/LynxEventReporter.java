package com.lynx.tasm.eventreport;

import androidx.annotation.AnyThread;
import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import ko.r;
import pn.a;
import pn.b;
import pn.c;
import pn.d;
import pn.e;
import pn.f;
import pn.g;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxEventReporter {
    public static final int INSTANCE_ID_UNKNOWN = -1;
    public static final String LYNX_SDK_ERROR_EVENT = "lynxsdk_error_event";
    public static final String PROP_NAME_ENABLE_SSR = "enable_ssr";
    public static final String PROP_NAME_LYNX_SDK_VERSION = "lynx_sdk_version";
    public static final String PROP_NAME_RELATIVE_PATH = "relative_path";
    public static final String PROP_NAME_THREAD_MODE = "thread_mode";
    public static final String PROP_NAME_URL = "url";
    private static final String REMOVE_GENERIC_INFO = "LynxEventReporter::removeGenericInfo";
    private static final String TAG = "LynxEventReporter";
    private static final String UPDATE_GENERIC_INFO = "LynxEventReporter::updateGenericInfo";
    private HashMap<Integer, HashMap<String, Object>> mAllExtraParams;
    private HashMap<Integer, HashMap<String, Object>> mAllGenericInfos;
    private a mEventReporterService;
    private volatile boolean mIsNativeLibraryLoaded;
    private final CopyOnWriteArrayList<a> mObserverList;

    public /* synthetic */ LynxEventReporter(e r5) {
        this();
    }

    public static /* synthetic */ void a(int r5) {
        lambda$clearCache$7(r5);
    }

    @AnyThread
    public static void addObserver(a r5) {
        getInstance().addObserverInternal(r5);
    }

    private void addObserverInternal(a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.mObserverList.contains(r5) == true) goto L8;
        this.mObserverList.add(r5);
        return;
    }

    public static /* synthetic */ void b(int r5, String r10, Map r11) {
        lambda$onEvent$0(r5, r10, r11);
    }

    public static /* synthetic */ void c(int r5) {
        lambda$removeGenericInfo$4(r5);
    }

    @CalledByNative
    public static void callRunnable(Object r5) {
        if ((r5 instanceof Runnable) == false) goto L6;
        ((Runnable) r5).run();
        return;
    L6:
        StringBuilder r10 = new StringBuilder("runnable[");
        if (r5 != null) goto L9;
        Object r11 = "null";
    L10:
        r10.append(r11);
        r10.append("] must be an instance of Runnable.");
        LynxLog.b(4, TAG, r10.toString());
        return;
    L9:
        r11 = r5.getClass();
        goto L10
    }

    @AnyThread
    public static void clearCache(int r5) {
        if (r5 >= 0) goto L4;
        return;
    L4:
        delayRunOnReportThread(new b(r5, 0), 5000);
    }

    public static /* synthetic */ void d(int r5, int r10) {
        lambda$moveExtraParams$6(r5, r10);
    }

    @AnyThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void delayRunOnReportThread(Runnable r5, long r10) {
        if (getInstance().mIsNativeLibraryLoaded == true) goto L6;
        LynxEventReporter r11 = getInstance();
        r11.mIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (getInstance().mIsNativeLibraryLoaded == false) goto L9;
        getInstance().nativeRunOnReportThread(r5, r10);
        return;
    }

    public static /* synthetic */ void e(g r5, int r10, String r11) {
        lambda$onEvent$1(r5, r10, r11);
    }

    public static /* synthetic */ void f(int r5, Map r10) {
        lambda$updateGenericInfo$3(r5, r10);
    }

    public static /* synthetic */ void g(int r5, Map r10) {
        lambda$putExtraParams$5(r5, r10);
    }

    public static HashMap<String, Object> getGenericInfo(Integer r5) {
        return new HashMap(getGenericInfoInternal(r5));
    }

    private static HashMap<String, Object> getGenericInfoInternal(Integer r5) {
        HashMap<String, Object> r10 = getInstance().mAllGenericInfos.get(r5);
        if (r10 != null) goto L6;
        HashMap<String, Object> r11 = new HashMap();
        r11.put(PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());
        getInstance().mAllGenericInfos.put(r5, r11);
        return r11;
    L6:
        return r10;
    }

    @AnyThread
    public static LynxEventReporter getInstance() {
        return f.f21375a;
    }

    public static /* synthetic */ void h(int r5, String r10, Object r11) {
        lambda$updateGenericInfo$2(r5, r10, r11);
    }

    private void handleEvent(int r10, String r11, Map<String, Object> r12) {
        if (TraceController.g == false) goto L5;
        HashMap r5 = new HashMap();
        r5.put("instance_id", String.valueOf(r10));
        r5.put("event_name", r11);
        TraceEvent.b(0, "LynxEventReporter::handleEvent", r5);
    L5:
        if (r11 != null) goto L8;
        LynxLog.b(4, TAG, "event name is null.");
        TraceEvent.a(0, "LynxEventReporter::handleEvent");
        return;
    L8:
        HashMap r13 = new HashMap();
        HashMap<String, Object> r14 = this.mAllGenericInfos.get(Integer.valueOf(r10));
        if (r14 == null) goto L11;
        r13.putAll(r14);
    L11:
        if (r12 == null) goto L13;
        r13.putAll(r12);
    L13:
        Map r15 = Collections.unmodifiableMap(r13);
        HashMap<String, Object> r16 = this.mAllExtraParams.get(Integer.valueOf(r10));
        if (r16 == null) goto L16;
        Map r17 = Collections.unmodifiableMap(r16);
    L17:
        setupEventReporterServiceIfNeeded();
        Iterator<a> r18 = this.mObserverList.iterator();
    L19:
        if (r18.hasNext() == false) goto L21;
        r18.next().onReportEvent(r11, r10, r15, r17);
        goto L19
    L21:
        TraceEvent.a(0, "LynxEventReporter::handleEvent");
        return;
    L16:
        r17 = null;
        goto L17
    }

    private static /* synthetic */ void lambda$clearCache$7(int r5) {
        LynxEventReporter r10 = getInstance();
        r10.mAllGenericInfos.remove(Integer.valueOf(r5));
        r10.mAllExtraParams.remove(Integer.valueOf(r5));
    }

    private static /* synthetic */ void lambda$moveExtraParams$6(int r5, int r10) {
        LynxEventReporter r11 = getInstance();
        HashMap<String, Object> r12 = r11.mAllExtraParams.get(Integer.valueOf(r5));
        if (r12 == null) goto L10;
        HashMap<String, Object> r13 = r11.mAllExtraParams.get(Integer.valueOf(r10));
        if (r13 == null) goto L7;
        r13.putAll(r12);
    L8:
        r11.mAllExtraParams.remove(Integer.valueOf(r5));
        return;
    L7:
        r11.mAllExtraParams.put(Integer.valueOf(r10), r12);
        goto L8
    }

    private static /* synthetic */ void lambda$onEvent$0(int r5, String r10, Map r11) {
        getInstance().handleEvent(r5, r10, r11);
    }

    private static /* synthetic */ void lambda$onEvent$1(g r5, int r10, String r11) {
        if (r5 == null) goto L4;
        HashMap r12 = r5.a();
    L5:
        if (r10 >= 0) goto L8;
        if (r12 != null) goto L8;
        return;
    L8:
        getInstance().handleEvent(r10, r11, r12);
        return;
    L4:
        r12 = null;
        goto L5
    }

    private static /* synthetic */ void lambda$putExtraParams$5(int r5, Map r10) {
        LynxEventReporter r11 = getInstance();
        HashMap<String, Object> r12 = r11.mAllExtraParams.get(Integer.valueOf(r5));
        if (r12 != null) goto L6;
        r11.mAllExtraParams.put(Integer.valueOf(r5), new HashMap(r10));
        return;
    L6:
        r12.putAll(r10);
    }

    private static void lambda$removeGenericInfo$4(int r5) {
        TraceEvent.c(REMOVE_GENERIC_INFO);
        getInstance().mAllGenericInfos.remove(Integer.valueOf(r5));
        TraceEvent.a(0, REMOVE_GENERIC_INFO);
    }

    private static void lambda$updateGenericInfo$2(int r5, String r10, Object r11) {
        TraceEvent.c(UPDATE_GENERIC_INFO);
        getGenericInfoInternal(Integer.valueOf(r5)).put(r10, r11);
        TraceEvent.a(0, UPDATE_GENERIC_INFO);
    }

    private static void lambda$updateGenericInfo$3(int r5, Map r10) {
        TraceEvent.c(UPDATE_GENERIC_INFO);
        getGenericInfoInternal(Integer.valueOf(r5)).putAll(r10);
        TraceEvent.a(0, UPDATE_GENERIC_INFO);
    }

    @AnyThread
    public static void moveExtraParams(final int r5, final int r10) {
        if (r5 < 0) goto L7;
        if (r10 < 0) goto L8;
        runOnReportThread(new d(r5, r10));
        return;
    L8:
        return;
    }

    private native void nativeRunOnReportThread(Object r5, long r10);

    @CalledByNative
    public static void onEvent(int r10, String r11, ReadableMap r12) {
        if (TraceController.g == false) goto L5;
        HashMap r5 = new HashMap();
        r5.put("instance_id", String.valueOf(r10));
        r5.put("event_name", r11);
        TraceEvent.b(0, "LynxEventReporter::OnEvent", r5);
    L5:
        getInstance().handleEvent(r10, r11, r12.asHashMap());
        TraceEvent.a(0, "LynxEventReporter::OnEvent");
    }

    @AnyThread
    public static void putExtraParams(Map<String, Object> r5, int r10) {
        if (r5 == null) goto L7;
        if (r10 < 0) goto L8;
        runOnReportThread(new c(r5, r10, 0));
        return;
    L8:
        return;
    }

    @AnyThread
    public static void removeGenericInfo(int r10) {
        if (r10 >= 0) goto L5;
        return;
    L5:
        if (TraceController.g == false) goto L7;
        HashMap r5 = new HashMap();
        r5.put("instance_id", String.valueOf(r10));
        TraceEvent.b(0, REMOVE_GENERIC_INFO, r5);
    L7:
        runOnReportThread(new b(r10, 1));
        TraceEvent.a(0, REMOVE_GENERIC_INFO);
    }

    @AnyThread
    public static void removeObserver(a r5) {
        getInstance().removeObserverInternal(r5);
    }

    private void removeObserverInternal(a r5) {
        if (r5 == null) goto L5;
        this.mObserverList.remove(r5);
        return;
    }

    @AnyThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void runOnReportThread(Runnable r5) {
        if (getInstance().mIsNativeLibraryLoaded == true) goto L6;
        LynxEventReporter r10 = getInstance();
        r10.mIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (getInstance().mIsNativeLibraryLoaded == false) goto L9;
        getInstance().nativeRunOnReportThread(r5, 0);
        return;
    }

    private void setupEventReporterServiceIfNeeded() {
        if (this.mEventReporterService == null) goto L5;
        return;
    L5:
        a r5 = (a) r.g().e(ko.a.class);
        this.mEventReporterService = r5;
        if (r5 != null) goto L9;
        LynxLog.b(4, TAG, "eventReporter service not found or event name is null.");
        return;
    L9:
        addObserverInternal(r5);
    }

    @CalledByNative
    public static void updateGenericInfo(int r10, ReadableMap r11) {
        if (TraceController.g == false) goto L5;
        HashMap r5 = new HashMap();
        r5.put("instance_id", String.valueOf(r10));
        TraceEvent.b(0, UPDATE_GENERIC_INFO, r5);
    L5:
        getGenericInfoInternal(Integer.valueOf(r10)).putAll(r11.asHashMap());
        TraceEvent.a(0, UPDATE_GENERIC_INFO);
    }

    private LynxEventReporter() {
        this.mObserverList = new CopyOnWriteArrayList();
        this.mIsNativeLibraryLoaded = false;
        this.mAllGenericInfos = new HashMap();
        this.mAllExtraParams = new HashMap();
    }

    @AnyThread
    public static void updateGenericInfo(String r10, Object r11, int r12) {
        if (r10 == null) goto L11;
        if (r11 == null) goto L12;
        if (r12 >= 0) goto L7;
        return;
    L7:
        if (TraceController.g == false) goto L9;
        HashMap r5 = new HashMap();
        r5.put(STGroup.DICT_KEY, r10);
        r5.put("instance_id", String.valueOf(r12));
        r5.put("value", r11.toString());
        TraceEvent.b(0, UPDATE_GENERIC_INFO, r5);
    L9:
        runOnReportThread(new androidx.profileinstaller.a(r10, r12, 3, r11));
        TraceEvent.a(0, UPDATE_GENERIC_INFO);
        return;
    L12:
        return;
    }

    @AnyThread
    public static void onEvent(String r10, int r11, g r12) {
        if (r10 == null) goto L11;
        if (r11 >= 0) goto L7;
        if (r12 != null) goto L7;
        return;
    L7:
        if (TraceController.g == false) goto L9;
        HashMap r5 = new HashMap();
        r5.put("event_name", r10);
        r5.put("instance_id", String.valueOf(r11));
        TraceEvent.b(0, "LynxEventReporter::OnEvent", r5);
    L9:
        runOnReportThread(new androidx.profileinstaller.a(r12, r11, r10, 4));
        TraceEvent.a(0, "LynxEventReporter::OnEvent");
        return;
    }

    @AnyThread
    public static void onEvent(String r10, Map<String, Object> r11, int r12) {
        if (r10 == null) goto L11;
        if (r12 >= 0) goto L7;
        if (r11 != null) goto L7;
        return;
    L7:
        if (TraceController.g == false) goto L9;
        HashMap r5 = new HashMap();
        r5.put("event_name", r10);
        r5.put("instance_id", String.valueOf(r12));
        TraceEvent.b(0, "LynxEventReporter::OnEvent", r5);
    L9:
        runOnReportThread(new androidx.profileinstaller.a(r10, r12, 5, r11));
        TraceEvent.a(0, "LynxEventReporter::OnEvent");
        return;
    }

    @AnyThread
    public static void updateGenericInfo(Map<String, Object> r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L18;
        if (r11 >= 0) goto L8;
        return;
    L8:
        if (TraceController.g == false) goto L14;
        HashMap r5 = new HashMap();
        r5.put("instance_id", String.valueOf(r11));
        Iterator<Map.Entry<String, Object>> r12 = r10.entrySet().iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        Map.Entry<String, Object> r13 = r12.next();
        r5.put(r13.getKey(), r13.getValue().toString());
        goto L11
    L13:
        TraceEvent.b(0, UPDATE_GENERIC_INFO, r5);
    L14:
        runOnReportThread(new c(r10, r11, 1));
        TraceEvent.a(0, UPDATE_GENERIC_INFO);
        return;
    }
}
