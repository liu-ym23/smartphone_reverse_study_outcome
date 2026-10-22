package com.lynx.debugrouter.base.usb;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.debugrouter.base.MessageTransceiver;
import com.lynx.debugrouter.base.MessageTransceiverStateListener;
import com.lynx.debugrouter.base.report.DebugRouterReportServiceUtil;
import com.lynx.debugrouter.base.service.DebugRouterServiceCenter;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import y5a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001.B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\"\u0010\u001d\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\tJ\u0018\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a0 J\u0006\u0010!\u001a\u00020\rJ\u0016\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0016J\u0016\u0010$\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0018J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u000e\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\rJ\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0019\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a\u0012\u0004\u0012\u00020\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/lynx/debugrouter/base/usb/USBTransTemplateUtil;", NameKeys.UnloadStrategy_No_Strategy, "()V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "globalRequestId", NameKeys.UnloadStrategy_No_Strategy, "ipPortRegex", "Lkotlin/text/Regex;", "mIsDebugPlatformSupport", NameKeys.UnloadStrategy_No_Strategy, "mTransceiver", "Lcom/lynx/debugrouter/base/MessageTransceiver;", "mUSBIsEnabled", "requestTimeOutTask", NameKeys.UnloadStrategy_No_Strategy, "Ljava/util/concurrent/ScheduledFuture;", "responseMap", "Ljava/util/TreeSet;", "Lcom/lynx/debugrouter/base/usb/TemplateData;", "responseSize", "Lcom/lynx/debugrouter/base/usb/TemplateFileSize;", "urlMap", "Lkotlin/Pair;", "addInterceptor", NameKeys.UnloadStrategy_No_Strategy, "getTemplateData", "reqId", "getUrlSet", NameKeys.UnloadStrategy_No_Strategy, "isUSBTransTemplateAvailable", "receiveData", LynxResourceModule.DATA_KEY, "receiveResponseSize", "size", "reportOpenCardUrl", LynxEventReporter.PROP_NAME_URL, "requestData", "setDebugPlatformSupport", "support", "setUSBTransceiver", "transceiver", "updateUrlSet", "USBTransTemplateTransceiverListener", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class USBTransTemplateUtil {
    public static final USBTransTemplateUtil INSTANCE = null;
    private static final String TAG = "USBTransTemplateUtil";
    private static final ScheduledExecutorService executor = null;
    private static volatile long globalRequestId;
    private static final Regex ipPortRegex = null;
    private static boolean mIsDebugPlatformSupport;
    private static volatile MessageTransceiver mTransceiver;
    private static volatile boolean mUSBIsEnabled;
    private static Map<Long, ScheduledFuture<?>> requestTimeOutTask;
    private static Map<Long, TreeSet<TemplateData>> responseMap;
    private static Map<Long, TemplateFileSize> responseSize;
    private static final Map<Pair<String, String>, Boolean> urlMap = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/lynx/debugrouter/base/usb/USBTransTemplateUtil$USBTransTemplateTransceiverListener;", "Lcom/lynx/debugrouter/base/MessageTransceiverStateListener;", "()V", "onClose", NameKeys.UnloadStrategy_No_Strategy, "transceiver", "Lcom/lynx/debugrouter/base/MessageTransceiver;", LynxResourceModule.CODE_KEY, NameKeys.UnloadStrategy_No_Strategy, "reason", NameKeys.UnloadStrategy_No_Strategy, "onError", "t", NameKeys.UnloadStrategy_No_Strategy, "onMessage", "text", "onOpen", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class USBTransTemplateTransceiverListener implements MessageTransceiverStateListener {
        public static final USBTransTemplateTransceiverListener INSTANCE = null;

        static {
            INSTANCE = new USBTransTemplateTransceiverListener();
        }

        private USBTransTemplateTransceiverListener() {
        }

        @Override // com.lynx.debugrouter.base.MessageTransceiverStateListener
        public void onOpen(MessageTransceiver r1) {
            USBTransTemplateUtil.access$setMUSBIsEnabled$p(true);
            USBTransTemplateUtil.access$getUrlMap$p().clear();
        }

        @Override // com.lynx.debugrouter.base.MessageTransceiverStateListener
        public void onError(MessageTransceiver r1, Throwable r2) {
            USBTransTemplateUtil.access$setMUSBIsEnabled$p(false);
        }

        @Override // com.lynx.debugrouter.base.MessageTransceiverStateListener
        public void onMessage(MessageTransceiver r7, String r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            if (StringsKt.indexOf$default(r8, "OpenCard", 0, false, 6, null) == (-1)) goto L26;
            Object r9 = new JSONObject(r8).opt(LynxResourceModule.DATA_KEY);
            String r1 = null;
            if ((r9 instanceof JSONObject) == false) goto L8;
            JSONObject r10 = (JSONObject) r9;
        L9:
            if (r10 == null) goto L11;
            Object r11 = r10.opt(LynxResourceModule.DATA_KEY);
        L13:
            if ((r11 instanceof JSONObject) == false) goto L15;
            JSONObject r12 = (JSONObject) r11;
        L16:
            if (r12 == null) goto L18;
            Object r13 = r12.opt(LynxEventReporter.PROP_NAME_URL);
        L20:
            if ((r13 instanceof String) == false) goto L22;
            r1 = (String) r13;
        L22:
            if (r1 == null) goto L27;
            USBTransTemplateUtil r14 = USBTransTemplateUtil.INSTANCE;
            r14.updateUrlSet(r1);
            USBTransTemplateUtil.access$reportOpenCardUrl(r14, r1);
            return;
        L27:
            return;
        L18:
            r13 = null;
            goto L20
        L15:
            r12 = null;
            goto L16
        L11:
            r11 = null;
            goto L13
        L8:
            r10 = null;
            goto L9
        }

        @Override // com.lynx.debugrouter.base.MessageTransceiverStateListener
        public void onClose(MessageTransceiver r1, int r2, String r3) {
            USBTransTemplateUtil.access$setMUSBIsEnabled$p(false);
        }
    }

    private USBTransTemplateUtil() {
    }

    public static /* synthetic */ void a(long r0, String r2) {
        m23requestData$lambda1(r0, r2);
    }

    static {
        INSTANCE = new USBTransTemplateUtil();
        ipPortRegex = new Regex("(?:http:\\/\\/|http%3A%2F%2F)((?:[0-9]{1,3}(?:\\.|%2E)){3}[0-9]{1,3})(?::|%3A)([0-9]{1,5})(?:\\/|%2F)");
        executor = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory(TAG));
        responseMap = new ConcurrentHashMap();
        responseSize = new ConcurrentHashMap();
        requestTimeOutTask = new ConcurrentHashMap();
        urlMap = new ConcurrentHashMap();
    }

    public final Set<Pair<String, String>> getUrlSet() {
        return urlMap.keySet();
    }

    public final boolean isUSBTransTemplateAvailable() {
        if (mUSBIsEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (mIsDebugPlatformSupport == false) goto L7;
        return true;
    }

    public final void addInterceptor() {
        IUSBHijackService r0 = (IUSBHijackService) DebugRouterServiceCenter.instance().getService(IUSBHijackService.class);     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        return;
    L5:
        r0.addInterceptor();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.getMessage();
    }

    public static final /* synthetic */ Map access$getUrlMap$p() {
        return urlMap;
    }

    public static final /* synthetic */ void access$setMUSBIsEnabled$p(boolean r0) {
        mUSBIsEnabled = r0;
    }

    private final void reportOpenCardUrl(String r3) {
        JSONObject r0 = new JSONObject();
        r0.put(LynxEventReporter.PROP_NAME_URL, r3);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("USBOpenCardUrl", r0, null, null);
        return;
    L5:
        e = move-exception;
        e.toString();
        goto L7
    }

    public final Pair<TreeSet<TemplateData>, TemplateFileSize> getTemplateData(long r4) {
        TemplateFileSize r0 = responseSize.get(Long.valueOf(r4));
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.isError() == true) goto L8;
        TreeSet<TemplateData> r5 = responseMap.get(Long.valueOf(r4));
        if (r5 != null) goto L12;
    L15:
        return null;
    L12:
        if (r5.size() != r0.getSeqCount()) goto L15;
        return new Pair(r5, r0);
    L8:
        return new Pair(new TreeSet(), r0);
    }

    public final long requestData(final String r8) {
        Intrinsics.checkNotNullParameter(r8, LynxEventReporter.PROP_NAME_URL);
        final long r0 = globalRequestId;
        globalRequestId = 1 + r0;
        responseMap.put(Long.valueOf(r0), new TreeSet());
        ScheduledFuture<?> r2 = executor.schedule(new a(r0, r8), 8, TimeUnit.SECONDS);
        requestTimeOutTask.put(Long.valueOf(r0), r2);
        MessageTransceiver r3 = mTransceiver;
        if (r3 == null) goto L5;
        r3.send("{\"data\":{\"data\":{\"client_id\":-1,\"message\": \"{\\\"method\\\":\\\"DownloadTemplateByUsb\\\",\\\"params\\\":{\\\"requestId\\\":" + r0 + ", \\\"url\\\":\\\"" + r8 + "\\\"}}\",\"session_id\": -1},\"sender\": -1,\"type\": \"CDP\"},\"event\": \"Customized\"}");
    L5:
        return r0;
    }

    public final void setDebugPlatformSupport(boolean r1) {
        mIsDebugPlatformSupport = r1;
    }

    public final void setUSBTransceiver(MessageTransceiver r2) {
        Intrinsics.checkNotNullParameter(r2, "transceiver");
        mTransceiver = r2;
        MessageTransceiver r3 = mTransceiver;
        if (r3 == null) goto L6;
        r3.setStateListener(USBTransTemplateTransceiverListener.INSTANCE);
        return;
    }

    public final void updateUrlSet(String r5) {
        Intrinsics.checkNotNullParameter(r5, LynxEventReporter.PROP_NAME_URL);
        MatchResult r6 = Regex.find$default(ipPortRegex, r5, 0, 2, null);
        if (r6 == null) goto L10;
        List r7 = r6.getGroupValues();
        if (r7.size() != 3) goto L7;
        Boolean r8 = urlMap.put(new Pair(ListProtector.get(r7, 1), ListProtector.get(r7, 2)), Boolean.TRUE);
        return;
    L7:
        return;
    }

    public static final /* synthetic */ void access$reportOpenCardUrl(USBTransTemplateUtil r0, String r1) {
        r0.reportOpenCardUrl(r1);
    }

    /* JADX INFO: renamed from: requestData$lambda-1, reason: not valid java name */
    private static final void m23requestData$lambda1(long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "$url");
        requestTimeOutTask.remove(Long.valueOf(r3));
        Long r6 = Long.valueOf(r3);
        responseSize.put(r6, new TemplateFileSize(-3, -3));
        Long r4 = Long.valueOf(r3);
        responseMap.put(r4, new TreeSet());
    }

    public final void receiveData(long r3, TemplateData r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.DATA_KEY);
        if (requestTimeOutTask.get(Long.valueOf(r3)) == null) goto L8;
        TreeSet<TemplateData> r4 = responseMap.get(Long.valueOf(r3));
        if (r4 == null) goto L9;
        r4.add(r5);
        return;
    L9:
        return;
    }

    public final void receiveResponseSize(long r3, TemplateFileSize r5) {
        Intrinsics.checkNotNullParameter(r5, "size");
        ScheduledFuture<?> r0 = requestTimeOutTask.get(Long.valueOf(r3));
        if (r0 == null) goto L6;
        r0.cancel(true);
        requestTimeOutTask.remove(Long.valueOf(r3));
        Long r4 = Long.valueOf(r3);
        responseSize.put(r4, r5);
        return;
    }
}
