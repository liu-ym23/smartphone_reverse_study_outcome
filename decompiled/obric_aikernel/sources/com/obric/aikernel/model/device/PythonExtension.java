package com.obric.aikernel.model.device;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.retrofit2.a0;
import com.google.gson.i;
import com.google.gson.k;
import com.obric.aee.utils.AsyncContext;
import com.obric.aee.utils.a;
import com.obric.aikernel.memory_collect.api.MemoryCollectApi;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.IAppContext;
import com.obric.aikernel.middleware.api.appcontext.receiver.e;
import com.obric.aikernel.middleware.api.appcontext.receiver.f;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model.cloud.common.CommonNetworkImpl;
import com.obric.aikernel.model.cloud.pyExt.PythonHttpReq;
import com.obric.aikernel.obric_os_feature.api.IModelPowerPerfManager;
import com.obric.aikernel.runtime.utils.DeviceUtils;
import com.obric.aikernel.service.c;
import com.obric.aikernel.service.res.PythonRuntimeService;
import com.obric.aikernel.utils.AppUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.p1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.z0;
import l7.b;
import okhttp3.u;
import okhttp3.v;
import okhttp3.y;
import org.json.JSONObject;
import u7.d;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class PythonExtension {
    public static final PythonExtension INSTANCE = null;
    private static final String TAG = "PythonExtension";
    private static final Lazy<String> _cachedSubProcTitle = null;

    /* JADX INFO: renamed from: com.obric.aikernel.model.device.PythonExtension$asyncExecuteHttpReq$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model.device.PythonExtension", f = "PythonExtension.kt", i = {}, l = {127}, m = "asyncExecuteHttpReq", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PythonExtension this$0;

        AnonymousClass1(PythonExtension r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.asyncExecuteHttpReq(null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model.device.PythonExtension$getDownloadingSummary$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.model.device.PythonExtension$getDownloadingSummary$1", f = "PythonExtension.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
    static final class C03521 extends SuspendLambda implements Function2<l0, Continuation<? super String>, Object> {
        int label;

        C03521(Continuation<? super C03521> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C03521(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super String> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super String> r11) {
            return ((C03521) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return ((k) r10).toString();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            PythonRuntimeService r13 = c.f5440a.a().d();
            this.label = 1;
            r10 = r13.x(this);
            if (r10 != r11) goto L12;
            return r11;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model.device.PythonExtension$queryMainProc$2, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model.device.PythonExtension$queryMainProc$2", f = "PythonExtension.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<l0, Continuation<? super Bundle>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Bundle> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Bundle> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            return new Bundle();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model.device.PythonExtension$watchConfigChanges$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.model.device.PythonExtension", f = "PythonExtension.kt", i = {}, l = {275}, m = "watchConfigChanges", n = {}, s = {})
    static final class C03531 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PythonExtension this$0;

        C03531(PythonExtension r10, Continuation<? super C03531> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.watchConfigChanges(null, this);
        }
    }

    static {
        INSTANCE = new PythonExtension();
        _cachedSubProcTitle = LazyKt.lazy(PythonExtension$_cachedSubProcTitle$1.INSTANCE);
    }

    private PythonExtension() {
    }

    private final k bundleToMap(Bundle r10) {
        k r11 = new k();
        Iterator<String> r12 = r10.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L30;
        String r13 = r12.next();
        Object r14 = r10.get(r13);
        if ((r14 instanceof String) == true) goto L7;
        if ((r14 instanceof Boolean) == false) goto L13;
        r11.n(r13, (Boolean) r14);
        goto L4
    L13:
        if ((r14 instanceof Integer) == true) goto L14;
        if ((r14 instanceof Long) == true) goto L14;
        if ((r14 instanceof Double) == true) goto L14;
        if ((r14 instanceof Float) == true) goto L14;
        if ((r14 instanceof k) == false) goto L27;
        r11.m(r13, (i) r14);
        goto L4
    L27:
        if (r14 == null) goto L29;
        String r15 = r14.toString();
    L8:
        r11.p(r13, r15);
        goto L4
    L29:
        r15 = null;
    L14:
        r11.o(r13, (Number) r14);
        goto L4
    L7:
        r15 = (String) r14;
        goto L8
    L30:
        return r11;
    }

    public static /* synthetic */ boolean lastScreenChangeTimeStamp$default(PythonExtension r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        return r10.lastScreenChangeTimeStamp(r11);
    }

    @a
    public final boolean appCtxIsAdminMode() {
        return AppContext.INSTANCE.isAdminMode();
    }

    @a
    public final boolean appCtxIsDebugMode() {
        return AppContext.INSTANCE.isDebug();
    }

    @a
    public final String appGetNetworkType() {
        return AppUtils.f5573a.b();
    }

    @a
    public final String appGetVersion() {
        return AppContext.INSTANCE.getVersionName();
    }

    @a(runIn = AsyncContext.IO)
    public final Object asyncExecuteHttpReq(String r12, String r13, String r14, String r15, Map<String, String> r16, String r17, Map<String, String> r18, Continuation<? super Bundle> r19) {
        if ((r19 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r10 = (AnonymousClass1) r19;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r110 = r10;
        Object r20 = r110.result;
        Object r21 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r22 = r110.label;
        if (r22 == 0) goto L17;
        if (r22 != 1) goto L16;
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L13
    L21:
        return ((com.obric.aikernel.model.cloud.common.c) r20).a();
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r20);
        PythonHttpReq r23 = PythonHttpReq.f4669a;     // Catch: Exception -> L13
        r110.label = 1;     // Catch: Exception -> L13
        r20 = r23.a(r12, r13, r14, r15, r16, r17, r18, r110);     // Catch: Exception -> L13
        if (r20 != r21) goto L21;
        return r21;
    L13:
        e = move-exception;
        Bundle r24 = new Bundle();
        r24.putInt("status", -1);
        r24.putString("error", e.toString());
        r24.putString("stacktrace", ExceptionsKt.stackTraceToString(e));
        return r24;
    L7:
        r10 = new AnonymousClass1(this, r19);
        goto L8
    }

    @a
    public final void cacheDispatchThreadTid(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        AIKLog.INSTANCE.d(TAG, "cacheDispatchThreadTid " + r10 + ", " + r11);
        AppContext.INSTANCE.cacheDispatchThreadTid(r10, r11);
    }

    @a
    public final Bundle executeHttpReq(String r10, String r11, String r12, String r13, Map<String, String> r14, String r15, Map<String, String> r16) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "host");
        Intrinsics.checkNotNullParameter(r12, "url_path");
        Intrinsics.checkNotNullParameter(r13, EnsureReportData.METHOD);
        Intrinsics.checkNotNullParameter(r14, "headers");
        Intrinsics.checkNotNullParameter(r15, "body");
        Intrinsics.checkNotNullParameter(r16, WsConstants.KEY_EXTRA);
        return PythonHttpReq.f4669a.b(r10, r11, r12, r13, r14, r15, r16).a();
    L5:
        e = move-exception;
        Bundle r17 = new Bundle();
        r17.putInt("status", -1);
        r17.putString("error", e.toString());
        r17.putString("stacktrace", ExceptionsKt.stackTraceToString(e));
        return r17;
    }

    @a
    public final String getAppChannel() {
        return AppContext.INSTANCE.getChannel();
    }

    @a
    public final String getBrand() {
        String r10 = DeviceUtils.f5383a.b();
        Intrinsics.checkNotNullExpressionValue(r10, "DeviceUtils.brand");
        return r10;
    }

    @a
    public final String getConfigValue(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        String r11 = f.f4546a.b(r10);
        if (r11 != null) goto L6;
        return "";
    L6:
        return r11;
    }

    @a(name = "getContext")
    public final Context getContext() {
        return AppContext.INSTANCE.getContext();
    }

    @a
    public final String getDevice() {
        String r10 = DeviceUtils.f5383a.d();
        Intrinsics.checkNotNullExpressionValue(r10, "DeviceUtils.device");
        return r10;
    }

    @a
    public final String getDownloadingSummary() {
        Object r10 = h.f(null, new C03521(null), 1, null);
        Intrinsics.checkNotNullExpressionValue(r10, "runBlocking {\n          …ry().toString()\n        }");
        return (String) r10;
    }

    @a
    public final Integer getMemoryCollectInterval() {
        MemoryCollectApi r10 = b.a();
        if (r10 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r10.getCollectorInterval());
    }

    @a
    public final Integer getMemoryCollectStartDelay() {
        MemoryCollectApi r10 = b.a();
        if (r10 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r10.getStartDelaySeconds());
    }

    @a
    public final Integer getNpuPowerGear(int r10) {
        int r11 = g8.a.f9004a.c(r10);
        if (d7.a.f8511a.a(r11) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(r11);
    }

    @a
    public final String getObricProject() {
        return DeviceUtils.f5383a.f();
    }

    @a
    public final String getPerfDebugMode() {
        String r10 = com.obric.aikernel.utils.k.f5601a.b("debug.aikernel.perf_mode", "");
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10;
    }

    @a
    public final long getPss() {
        Object r10 = getContext().getSystemService("activity");
        if ((r10 instanceof ActivityManager) == false) goto L5;
        ActivityManager r11 = (ActivityManager) r10;
    L7:
        if (r11 != null) goto L22;
        return -1;
    L22:
        Debug.MemoryInfo[] r12 = r11.getProcessMemoryInfo(new int[]{Process.myPid()});     // Catch: Exception -> L19
        Intrinsics.checkNotNullExpressionValue(r12, "activityManager.getProcessMemoryInfo(pids)");     // Catch: Exception -> L19
        if (r12.length != 0) goto L13;
        boolean r13 = true;
    L15:
        if ((true ^ r13) == false) goto L21;
        return ((long) r12[0].getTotalPss()) * 1024;
    L21:
        return -1;
    L13:
        r13 = false;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L5:
        r11 = null;
        goto L7
    }

    @a
    public final boolean getScreenOn() {
        return e.f4540a.d();
    }

    @a
    public final String getSubProcTitle() {
        return _cachedSubProcTitle.getValue();
    }

    @a
    public final int getThermalStatus() {
        return n7.a.f11264a.b();
    }

    @a
    public final Bitmap hardwareBufferToBitmap(HardwareBuffer r10) {
        Intrinsics.checkNotNullParameter(r10, "buffer");
        Bitmap r11 = Bitmap.wrapHardwareBuffer(r10, null);
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.copy(Bitmap.Config.ARGB_8888, false);
    }

    @a
    public final boolean lastScreenChangeTimeStamp(int r10) {
        long r11 = e.f4540a.e();
        if (r11 <= 0) goto L9;
        if (r10 > 0) goto L6;
        return false;
    L6:
        if ((SystemClock.elapsedRealtime() - r11) <= (r10 * 1000)) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    @a(runIn = AsyncContext.IO)
    public final Object listen_screen_change(Continuation<? super Boolean> r10) {
        e r11 = e.f4540a;
        final boolean r12 = r11.b().getValue().booleanValue();
        final g1<Boolean> r13 = r11.b();
        return kotlinx.coroutines.flow.e.p(new PythonExtension$listen_screen_change$$inlined$filter$1(r13, r12), r10);
    }

    @a
    public final void notifyModelUsage(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        IModelPowerPerfManager r11 = y7.a.a();
        if (r11 == null) goto L6;
        r11.notifyModelUsage(r10);
        return;
    }

    @a
    public final void postAppSignal(String r10, String r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "reason");
        AppContext.INSTANCE.postRestart(r10, r11, r12, r13);
    }

    @a(runIn = AsyncContext.IO)
    public final Object postModelCenterModel(String r10, Bundle r11, Bundle r12, Bundle r13, Continuation<? super Bundle> r14) {
        return CommonNetworkImpl.f4638a.m().e(r10, bundleToMap(r11), bundleToMap(r12), bundleToMap(r13)).a();
    L4:
        e = move-exception;
        Bundle r15 = new Bundle();
        r15.putString("error", e.toString());
        r15.putString("stacktrace", ExceptionsKt.stackTraceToString(e));
        return r15;
    }

    @a
    public final void postRestart(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "reason");
        IAppContext.a.b(AppContext.INSTANCE, r10, r11, r12, 0, 8, null);
    }

    @a
    public final Object queryMainProc(Bundle r10, Continuation<? super Bundle> r11) {
        return h.g(z0.b(), new AnonymousClass2(null), r11);
    }

    @a
    public final void reportMemoryInfo(int r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r11, "loadModelList");
        MemoryCollectApi r12 = b.a();
        if (r12 == null) goto L14;
        int r13 = 0;
        boolean r14 = true;
        if (r10 == 1) goto L8;
        r14 = false;
    L8:
        Boolean r15 = Boolean.valueOf(r14);
        ArrayList r16 = new ArrayList(r11.length);
        int r17 = r11.length;
    L9:
        if (r13 >= r17) goto L11;
        r16.add(r11[r13].toString());
        r13 = r13 + 1;
        goto L9
    L11:
        r12.reportMemoryInfo(r15, CollectionsKt.toSet(r16));
        return;
    }

    @a
    public final void sessionAddThread(int r10, int r11) {
        g8.a.f9004a.e(r10, r11);
    }

    @a
    public final Boolean sessionIsForeground(int r10) {
        return g8.a.f9004a.d(r10);
    }

    @a
    public final void sessionRemoveThread(int r10, int r11) {
        g8.a.f9004a.f(r10, r11);
    }

    @a
    public final int sessionSetInferenceInfo(int r10, String r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "modelStage");
        return g8.a.f9004a.g(r10, r11, r12, r13, r14);
    }

    @a
    public final void slardarTracker(String r10, JSONObject r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "metrics");
        Intrinsics.checkNotNullParameter(r12, "categories");
        d.a(r10, r11, r12, null);
    }

    @a
    public final void teaTracker(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "params");
        d.b(r10, r11);
    }

    @a(runIn = AsyncContext.IO)
    public final Object uploadFile(String r10, String r11, Map<String, String> r12, Map<String, String> r13, Continuation<? super Bundle> r14) {
        ArrayList r15 = new ArrayList(r12.size());     // Catch: Exception -> L9
        Iterator<Map.Entry<String, String>> r16 = r12.entrySet().iterator();     // Catch: Exception -> L9
    L5:
        if (r16.hasNext() == false) goto L7;
        Map.Entry<String, String> r17 = r16.next();     // Catch: Exception -> L9
        File r18 = new File(r17.getValue());     // Catch: Exception -> L9
        v.c r19 = v.c.f12066c.b(r17.getKey(), r18.getName(), y.f12130a.a(r18, u.f12046d.b("*.*")));     // Catch: Exception -> L9
        AIKLog.INSTANCE.i(TAG, "upload file " + r17.getKey() + " -> " + r17.getValue());     // Catch: Exception -> L9
        r15.add(TuplesKt.to(r17.getKey(), r19));     // Catch: Exception -> L9
        goto L5
    L7:
        a0<String> r20 = CommonNetworkImpl.f4638a.d(r10).doUpload(r11, MapsKt.toMap(r15), r13).execute();     // Catch: Exception -> L9
        Bundle r21 = new Bundle();     // Catch: Exception -> L9
        r21.putInt("code", r20.b());     // Catch: Exception -> L9
        r21.putString("body", r20.a());     // Catch: Exception -> L9
        r21.putString("message", r20.g());     // Catch: Exception -> L9
        return r21;
    L9:
        e = move-exception;
        AIKLog.INSTANCE.e(TAG, "postHttpFile failed", e);
        Bundle r22 = new Bundle();
        r22.putString("error", e.toString());
        r22.putString("stacktrace", ExceptionsKt.stackTraceToString(e));
        return r22;
    }

    @a(runIn = AsyncContext.IO)
    public final Object watchConfigChanges(String r10, Continuation<? super String> r11) {
        if ((r11 instanceof C03531) == false) goto L7;
        C03531 r12 = (C03531) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L20:
        String r17 = (String) r14;
        if (r17 != null) goto L24;
        return "";
    L24:
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        final p1<String> r18 = f.f4546a.a(r10);
        if (r18 != null) goto L17;
        return "";
    L17:
        final String r19 = r18.getValue();
        kotlinx.coroutines.flow.c<String> r20 = new PythonExtension$watchConfigChanges$$inlined$filter$1(r18, r19);
        r12.label = 1;
        r14 = kotlinx.coroutines.flow.e.p(r20, r12);
        if (r14 != r15) goto L20;
        return r15;
    L7:
        r12 = new C03531(this, r11);
        goto L8
    }
}
