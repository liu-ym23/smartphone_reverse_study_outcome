package com.lynx.tasm.eventreport;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import i8a.n;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import n7a.c;
import n7a.d;
import n7a.e;
import n7a.f;
import n7a.g;
import n7a.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
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
    private ILynxEventReportObserver mEventReporterService;
    private volatile boolean mIsNativeLibraryLoaded;
    private final CopyOnWriteArrayList<ILynxEventReportObserver> mObserverList;

    public interface PropsBuilder {
        Map<String, Object> build();
    }

    public static /* synthetic */ class a {
    }

    public static class b {
        public static final LynxEventReporter a = null;

        static {
            a = new LynxEventReporter(null);
        }
    }

    public static /* synthetic */ void a(int r0, Map r1) {
        lambda$updateGenericInfo$3(r0, r1);
    }

    public static /* synthetic */ void b(int r0) {
        lambda$removeGenericInfo$4(r0);
    }

    public static /* synthetic */ void c(PropsBuilder r0, int r1, String r2) {
        lambda$onEvent$1(r0, r1, r2);
    }

    public static /* synthetic */ void d(int r0, String r1, Object r2) {
        lambda$updateGenericInfo$2(r0, r1, r2);
    }

    public static /* synthetic */ void e(int r0) {
        lambda$clearCache$7(r0);
    }

    public static /* synthetic */ void f(int r0, int r1) {
        lambda$moveExtraParams$6(r0, r1);
    }

    public static /* synthetic */ void g(int r0, Map r1) {
        lambda$putExtraParams$5(r0, r1);
    }

    public static /* synthetic */ void h(int r0, String r1, Map r2) {
        lambda$onEvent$0(r0, r1, r2);
    }

    private native void nativeRunOnReportThread(Object r1, long r2);

    private void setupEventReporterServiceIfNeeded() {
        if (this.mEventReporterService == null) goto L5;
        return;
    L5:
        ILynxEventReportObserver r0 = (ILynxEventReportObserver) n.c().a(i8a.a.class);
        this.mEventReporterService = r0;
        if (r0 != null) goto L8;
        LLog.e(TAG, "eventReporter service not found or event name is null.");
        return;
    L8:
        addObserverInternal(r0);
    }

    private LynxEventReporter() {
        this.mObserverList = new CopyOnWriteArrayList();
        this.mIsNativeLibraryLoaded = false;
        this.mAllGenericInfos = new HashMap();
        this.mAllExtraParams = new HashMap();
    }

    public static LynxEventReporter getInstance() {
        return b.a;
    }

    public /* synthetic */ LynxEventReporter(a r1) {
        this();
    }

    public static void addObserver(ILynxEventReportObserver r1) {
        getInstance().addObserverInternal(r1);
    }

    private void addObserverInternal(ILynxEventReportObserver r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mObserverList.contains(r2) == true) goto L8;
        this.mObserverList.add(r2);
        return;
    }

    public static void callRunnable(Object r2) {
        if ((r2 instanceof Runnable) == false) goto L5;
        ((Runnable) r2).run();
        return;
    L5:
        StringBuilder r0 = new StringBuilder("runnable[");
        if (r2 != null) goto L8;
        Object r3 = "null";
    L9:
        r0.append(r3);
        r0.append("] must be an instance of Runnable.");
        LLog.e(TAG, r0.toString());
        return;
    L8:
        r3 = r2.getClass();
        goto L9
    }

    public static void clearCache(final int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        delayRunOnReportThread(new f(r3), 5000);
    }

    private static HashMap<String, Object> getGenericInfoInternal(Integer r3) {
        HashMap<String, Object> r0 = getInstance().mAllGenericInfos.get(r3);
        if (r0 != null) goto L6;
        HashMap<String, Object> r1 = new HashMap();
        r1.put(PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());
        getInstance().mAllGenericInfos.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public static HashMap<String, Object> getGenericInfoWithExtraParams(Integer r2) {
        HashMap<String, Object> r0 = new HashMap();
        if (r2.intValue() >= 0) goto L5;
        return r0;
    L5:
        HashMap<String, Object> r1 = getInstance().mAllExtraParams.get(r2);
        if (r1 == null) goto L8;
        r0.putAll(r1);
    L8:
        HashMap<String, Object> r3 = getGenericInfoInternal(r2);
        if (r3 == null) goto L11;
        r0.putAll(r3);
    L11:
        return r0;
    }

    private static /* synthetic */ void lambda$clearCache$7(int r3) {
        LynxEventReporter r0 = getInstance();
        r0.mAllGenericInfos.remove(Integer.valueOf(r3));
        r0.mAllExtraParams.remove(Integer.valueOf(r3));
    }

    private static /* synthetic */ void lambda$removeGenericInfo$4(int r2) {
        TraceEvent.beginSection(REMOVE_GENERIC_INFO);
        getInstance().mAllGenericInfos.remove(Integer.valueOf(r2));
        TraceEvent.endSection(REMOVE_GENERIC_INFO);
    }

    public static void removeGenericInfo(final int r4) {
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (TraceEvent.isTracingStarted() == false) goto L7;
        HashMap r0 = new HashMap();
        r0.put("instance_id", String.valueOf(r4));
        TraceEvent.beginSection(REMOVE_GENERIC_INFO, r0);
    L7:
        runOnReportThread(new d(r4));
        TraceEvent.endSection(REMOVE_GENERIC_INFO);
    }

    public static void removeObserver(ILynxEventReportObserver r1) {
        getInstance().removeObserverInternal(r1);
    }

    private void removeObserverInternal(ILynxEventReportObserver r2) {
        if (r2 == null) goto L5;
        this.mObserverList.remove(r2);
        return;
    }

    public static void runOnReportThread(Runnable r3) {
        if (getInstance().mIsNativeLibraryLoaded == true) goto L6;
        LynxEventReporter r0 = getInstance();
        r0.mIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (getInstance().mIsNativeLibraryLoaded == false) goto L9;
        getInstance().nativeRunOnReportThread(r3, 0);
        return;
    }

    public static void delayRunOnReportThread(Runnable r2, long r3) {
        if (getInstance().mIsNativeLibraryLoaded == true) goto L6;
        LynxEventReporter r0 = getInstance();
        r0.mIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
    L6:
        if (getInstance().mIsNativeLibraryLoaded == false) goto L9;
        getInstance().nativeRunOnReportThread(r2, r3);
        return;
    }

    private static /* synthetic */ void lambda$moveExtraParams$6(int r4, int r5) {
        LynxEventReporter r0 = getInstance();
        HashMap<String, Object> r1 = r0.mAllExtraParams.get(Integer.valueOf(r4));
        if (r1 == null) goto L10;
        HashMap<String, Object> r2 = r0.mAllExtraParams.get(Integer.valueOf(r5));
        if (r2 == null) goto L7;
        r2.putAll(r1);
    L8:
        r0.mAllExtraParams.remove(Integer.valueOf(r4));
        return;
    L7:
        r0.mAllExtraParams.put(Integer.valueOf(r5), r1);
        goto L8
    }

    private static /* synthetic */ void lambda$putExtraParams$5(int r3, Map r4) {
        LynxEventReporter r0 = getInstance();
        HashMap<String, Object> r1 = r0.mAllExtraParams.get(Integer.valueOf(r3));
        if (r1 != null) goto L5;
        r0.mAllExtraParams.put(Integer.valueOf(r3), new HashMap(r4));
        return;
    L5:
        r1.putAll(r4);
    }

    private static /* synthetic */ void lambda$updateGenericInfo$3(int r1, Map r2) {
        TraceEvent.beginSection(UPDATE_GENERIC_INFO);
        getGenericInfoInternal(Integer.valueOf(r1)).putAll(r2);
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    public static void moveExtraParams(final int r1, final int r2) {
        if (r1 < 0) goto L7;
        if (r2 < 0) goto L8;
        runOnReportThread(new g(r1, r2));
        return;
    L8:
        return;
    }

    public static void putExtraParams(final Map<String, Object> r1, final int r2) {
        if (r1 == null) goto L7;
        if (r2 < 0) goto L8;
        runOnReportThread(new n7a.b(r2, r1));
        return;
    L8:
        return;
    }

    public static void updateGenericInfo(final Map<String, Object> r5, final int r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L18;
        if (r6 >= 0) goto L8;
        return;
    L8:
        if (TraceEvent.isTracingStarted() == false) goto L14;
        HashMap r0 = new HashMap();
        r0.put("instance_id", String.valueOf(r6));
        Iterator<Map.Entry<String, Object>> r2 = r5.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        Map.Entry<String, Object> r3 = r2.next();
        r0.put(r3.getKey(), r3.getValue().toString());
        goto L11
    L13:
        TraceEvent.beginSection(UPDATE_GENERIC_INFO, r0);
    L14:
        runOnReportThread(new n7a.a(r6, r5));
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
        return;
    }

    public static void updateGenericInfo(int r4, ReadableMap r5) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r0 = new HashMap();
        r0.put("instance_id", String.valueOf(r4));
        TraceEvent.beginSection(UPDATE_GENERIC_INFO, r0);
    L5:
        getGenericInfoInternal(Integer.valueOf(r4)).putAll(r5.asHashMap());
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    private void handleEvent(int r5, String r6, Map<String, Object> r7) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r0 = new HashMap();
        r0.put("instance_id", String.valueOf(r5));
        r0.put("event_name", r6);
        TraceEvent.beginSection("LynxEventReporter::handleEvent", r0);
    L5:
        if (r6 != null) goto L8;
        LLog.e(TAG, "event name is null.");
        TraceEvent.endSection("LynxEventReporter::handleEvent");
        return;
    L8:
        HashMap r1 = new HashMap();
        HashMap<String, Object> r2 = this.mAllGenericInfos.get(Integer.valueOf(r5));
        if (r2 == null) goto L11;
        r1.putAll(r2);
    L11:
        if (r7 == null) goto L13;
        r1.putAll(r7);
    L13:
        Map<String, ? extends Object> r8 = Collections.unmodifiableMap(r1);
        HashMap<String, Object> r3 = this.mAllExtraParams.get(Integer.valueOf(r5));
        if (r3 == null) goto L16;
        Map<String, ? extends Object> r4 = Collections.unmodifiableMap(r3);
    L17:
        setupEventReporterServiceIfNeeded();
        Iterator<ILynxEventReportObserver> r9 = this.mObserverList.iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        r9.next().onReportEvent(r6, r5, r8, r4);
        goto L19
    L21:
        TraceEvent.endSection("LynxEventReporter::handleEvent");
        return;
    L16:
        r4 = null;
        goto L17
    }

    private static /* synthetic */ void lambda$onEvent$0(int r1, String r2, Map r3) {
        getInstance().handleEvent(r1, r2, r3);
    }

    private static /* synthetic */ void lambda$onEvent$1(PropsBuilder r1, int r2, String r3) {
        if (r1 == null) goto L4;
        Map<String, Object> r4 = r1.build();
    L5:
        if (r2 >= 0) goto L8;
        if (r4 != null) goto L8;
        return;
    L8:
        getInstance().handleEvent(r2, r3, r4);
        return;
    L4:
        r4 = null;
        goto L5
    }

    private static /* synthetic */ void lambda$updateGenericInfo$2(int r1, String r2, Object r3) {
        TraceEvent.beginSection(UPDATE_GENERIC_INFO);
        getGenericInfoInternal(Integer.valueOf(r1)).put(r2, r3);
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
    }

    public static void onEvent(final String r4, final int r5, final PropsBuilder r6) {
        if (r4 == null) goto L11;
        if (r5 >= 0) goto L7;
        if (r6 != null) goto L7;
        return;
    L7:
        if (TraceEvent.isTracingStarted() == false) goto L9;
        HashMap r0 = new HashMap();
        r0.put("event_name", r4);
        r0.put("instance_id", String.valueOf(r5));
        TraceEvent.beginSection("LynxEventReporter::OnEvent", r0);
    L9:
        runOnReportThread(new e(r6, r5, r4));
        TraceEvent.endSection("LynxEventReporter::OnEvent");
        return;
    }

    public static void updateGenericInfo(final String r4, final Object r5, final int r6) {
        if (r4 == null) goto L11;
        if (r5 == null) goto L12;
        if (r6 >= 0) goto L7;
        return;
    L7:
        if (TraceEvent.isTracingStarted() == false) goto L9;
        HashMap r0 = new HashMap();
        r0.put("key", r4);
        r0.put("instance_id", String.valueOf(r6));
        r0.put("value", r5.toString());
        TraceEvent.beginSection(UPDATE_GENERIC_INFO, r0);
    L9:
        runOnReportThread(new c(r6, r4, r5));
        TraceEvent.endSection(UPDATE_GENERIC_INFO);
        return;
    L12:
        return;
    }

    public static void onEvent(final String r4, final Map<String, Object> r5, final int r6) {
        if (r4 == null) goto L11;
        if (r6 >= 0) goto L7;
        if (r5 != null) goto L7;
        return;
    L7:
        if (TraceEvent.isTracingStarted() == false) goto L9;
        HashMap r0 = new HashMap();
        r0.put("event_name", r4);
        r0.put("instance_id", String.valueOf(r6));
        TraceEvent.beginSection("LynxEventReporter::OnEvent", r0);
    L9:
        runOnReportThread(new h(r6, r4, r5));
        TraceEvent.endSection("LynxEventReporter::OnEvent");
        return;
    }

    public static void onEvent(int r4, String r5, ReadableMap r6) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r0 = new HashMap();
        r0.put("instance_id", String.valueOf(r4));
        r0.put("event_name", r5);
        TraceEvent.beginSection("LynxEventReporter::OnEvent", r0);
    L5:
        getInstance().handleEvent(r4, r5, r6.asHashMap());
        TraceEvent.endSection("LynxEventReporter::OnEvent");
    }
}
