package com.larus.video.impl.sdk;

import com.bytedance.applet.aibridge.AIBridgePreloadMediaResourceMethod;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.k0;
import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import com.larus.platform.constants.media.DataLoaderPreloadPriority;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.launch.ObricLazyInitSettingsServiceDelegate;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.PreloaderURLItem;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.download.DownloadTask;
import com.ss.ttvideoengine.download.DownloadURLTask;
import com.ss.ttvideoengine.download.Downloader;
import com.ss.ttvideoengine.download.IDownloaderListener;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.utils.Error;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class TTVideoEngineStaticServiceImpl implements z3 {
    public static final ConcurrentHashMap<String, kotlinx.coroutines.i<String>> a = null;
    public static final ConcurrentHashMap<String, kotlinx.coroutines.i<Boolean>> b = null;
    public static final a c = null;

    public static final class a implements IDownloaderListener {
        public a() {
        }

        public final void downloaderWriteData(Downloader r1, DownloadTask r2, long r3, long r5) {
        }

        public final void downloaderDidComplete(Downloader r7, DownloadTask r8, Error r9) {
            String r0 = null;
            if ((r8 instanceof DownloadURLTask) == false) goto L5;
            DownloadURLTask r10 = (DownloadURLTask) r8;
        L6:
            if (r10 == null) goto L8;
            String r11 = r10.getKey();
        L9:
            if (r11 != null) goto L11;
            r11 = NameKeys.UnloadStrategy_No_Strategy;
        L11:
            boolean r2 = true;
            if (r11.length() != 0) goto L14;
            boolean r1 = true;
        L15:
            if (r1 == false) goto L17;
            return;
        L17:
            FLogger r3 = FLogger.a;
            StringBuilder r4 = new StringBuilder("[downloadUrlUseDataLoader] complete, key=");
            r4.append(r11);
            r4.append(", errorCode=");
            if (r9 == null) goto L20;
            Integer r5 = Integer.valueOf(r9.code);
        L21:
            r4.append(r5);
            r4.append(", errorMsg=");
            if (r9 == null) goto L24;
            String r6 = r9.description;
        L25:
            r4.append(r6);
            r3.i("TTVideoEngineStaticServiceImpl", r4.toString());
            ConcurrentHashMap<String, kotlinx.coroutines.i<String>> r12 = TTVideoEngineStaticServiceImpl.a;
            if (r8 == null) goto L28;
            String r13 = r8.getAvailableLocalFilePath();
        L29:
            if (r9 != null) goto L38;
            if (r13 != null) goto L32;
        L35:
            boolean r14 = true;
        L36:
            if (r14 == true) goto L38;
        L39:
            if (r2 == false) goto L41;
            r0 = r13;
        L41:
            kotlinx.coroutines.i<String> r15 = TTVideoEngineStaticServiceImpl.a.remove(r11);
            if (r15 != null) goto L45;
            return;
        L45:
            if (r15.isActive() == false) goto L48;
            r15.resumeWith(Result.constructor-impl(r0));
            return;
        L48:
            return;
        L32:
            if (r13.length() == 0) goto L35;
            r14 = false;
        L38:
            r2 = false;
            goto L39
        L28:
            r13 = null;
            goto L29
        L24:
            r6 = null;
            goto L25
        L20:
            r5 = null;
            goto L21
        L14:
            r1 = false;
            goto L15
        L8:
            r11 = null;
            goto L9
        L5:
            r10 = null;
            goto L6
        }

        public final void downloaderDidLoadAllTask(Downloader r3, List<DownloadTask> r4, Error r5) {
            FLogger r6 = FLogger.a;
            StringBuilder r0 = new StringBuilder("[downloadUrlUseDataLoader] load all tasks, taskSize=");
            String r1 = null;
            if (r4 == null) goto L5;
            Integer r7 = Integer.valueOf(r4.size());
        L6:
            r0.append(r7);
            r0.append(", errorCode=");
            if (r5 == null) goto L9;
            Integer r8 = Integer.valueOf(r5.code);
        L10:
            r0.append(r8);
            r0.append(", errorMsg=");
            if (r5 == null) goto L13;
            r1 = r5.description;
        L13:
            r0.append(r1);
            r6.i("TTVideoEngineStaticServiceImpl", r0.toString());
            ConcurrentHashMap<String, kotlinx.coroutines.i<String>> r9 = TTVideoEngineStaticServiceImpl.a;
            if (r5 != null) goto L16;
            boolean r10 = true;
        L17:
            Iterator<Map.Entry<String, kotlinx.coroutines.i<Boolean>>> r11 = TTVideoEngineStaticServiceImpl.b.entrySet().iterator();
        L19:
            if (r11.hasNext() == false) goto L23;
            Map.Entry<String, kotlinx.coroutines.i<Boolean>> r12 = r11.next();
            String r2 = r12.getKey();
            kotlinx.coroutines.i<Boolean> r13 = r12.getValue();
            TTVideoEngineStaticServiceImpl.b.remove(r2);
            if (r13.isActive() == false) goto L19;
            r13.resumeWith(Result.constructor-impl(Boolean.valueOf(r10)));
            goto L19
        L23:
            return;
        L16:
            r10 = false;
            goto L17
        L9:
            r8 = null;
            goto L10
        L5:
            r7 = null;
            goto L6
        }

        public final void downloaderStateChanged(Downloader r3, DownloadTask r4, int r5) {
            FLogger r6 = FLogger.a;
            StringBuilder r0 = new StringBuilder("[downloadUrlUseDataLoader] state=");
            r0.append(r5);
            r0.append(", key=");
            String r1 = null;
            if ((r4 instanceof DownloadURLTask) == false) goto L5;
            DownloadURLTask r7 = (DownloadURLTask) r4;
        L6:
            if (r7 == null) goto L8;
            r1 = r7.getKey();
        L8:
            r0.append(r1);
            r6.d("TTVideoEngineStaticServiceImpl", r0.toString());
            return;
        L5:
            r7 = null;
            goto L6
        }

        public final void downloaderDidResume(Downloader r4, DownloadTask r5, long r6, long r8) {
            FLogger r7 = FLogger.a;
            StringBuilder r0 = new StringBuilder("[downloadUrlUseDataLoader] resume, key=");
            String r2 = null;
            if ((r5 instanceof DownloadURLTask) == false) goto L5;
            DownloadURLTask r9 = (DownloadURLTask) r5;
        L6:
            if (r9 == null) goto L8;
            r2 = r9.getKey();
        L8:
            r0.append(r2);
            r0.append(", offset=");
            r0.append(r6);
            r0.append(", total=");
            r0.append(r8);
            r7.i("TTVideoEngineStaticServiceImpl", r0.toString());
            return;
        L5:
            r9 = null;
            goto L6
        }

        public final void downloaderProgress(Downloader r4, DownloadTask r5, long r6, long r8) {
            FLogger r7 = FLogger.a;
            StringBuilder r0 = new StringBuilder("[downloadUrlUseDataLoader] progress, key=");
            String r2 = null;
            if ((r5 instanceof DownloadURLTask) == false) goto L5;
            DownloadURLTask r9 = (DownloadURLTask) r5;
        L6:
            if (r9 == null) goto L8;
            r2 = r9.getKey();
        L8:
            r0.append(r2);
            r0.append(", received=");
            r0.append(r6);
            r0.append(", total=");
            r0.append(r8);
            r7.d("TTVideoEngineStaticServiceImpl", r0.toString());
            return;
        L5:
            r9 = null;
            goto L6
        }
    }

    public static final class b {
    }

    public static final class c implements Function1<Throwable, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ DownloadURLTask b;

        public c(String r1, TTVideoEngineStaticServiceImpl r2, DownloadURLTask r3) {
            this.a = r1;
            this.b = r3;
        }

        public final Object invoke(Object r5) {
            Throwable r6 = (Throwable) r5;
            TTVideoEngineStaticServiceImpl.a.remove(this.a);
            DownloadURLTask r7 = this.b;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            r7.suspend();     // Catch: Throwable -> L5
            Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            String r1 = this.a;
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L11;
            FLogger.a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] suspend task failed, key=" + r1 + ", " + r9);
        L11:
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public TTVideoEngineStaticServiceImpl() {
    }

    public final void o() {
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new a();
    }

    public final void j() {
        if (ObricLazyInitSettingsServiceDelegate.a.b() == false) goto L6;
        FLogger.a.i("BackgroundLazyInit", "event=component_init_request, component=VideoEngine, trigger=first_use");
        n2a.c.a.getClass();
        n2a.c.a();
        return;
    }

    public final void switchToCellularNetwork() {
        List<o> r0 = o.l;
        TTVideoEngine.switchToCellularNetwork();
    }

    public final void switchToDefaultNetwork() {
        List<o> r0 = o.l;
        TTVideoEngine.switchToDefaultNetwork();
    }

    public final int e(com.larus.video.impl.sdk.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        List<o> r1 = o.l;
        Intrinsics.checkNotNullParameter(r3, "model");
        IVideoModel r4 = r3.a;
        if (r4 != null) goto L5;
        r4 = null;
    L5:
        if (r4 != null) goto L8;
        return 0;
    L8:
        return r4.getVideoRefInt(3);
    }

    public final yq9.a g(String r8) {
        Intrinsics.checkNotNullParameter(r8, "key");
        DataLoaderHelper.DataLoaderCacheInfo r9 = TTVideoEngine.getCacheInfo(r8);
        if (r9 != null) goto L7;
        return new yq9.a(0);
    L7:
        return new yq9.a(r9.mMediaSize, r9.mCacheSizeFromZero, r9.mLocalFilePath);
    }

    public final void k(Function1<? super IVideoController, Boolean> r5) {
        List<o> r0 = o.l;
        List<o> r1 = o.l;
        if (((ArrayList) r1).size() == 0) goto L30;
        monitor-enter(r1);
        Iterator r2 = ((ArrayList) r1).iterator();     // Catch: Throwable -> L20
    L8:
        if (r2.hasNext() == false) goto L17;
        o r3 = (o) r2.next();     // Catch: Throwable -> L20
        if (r5 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L8;
        r3.b();     // Catch: Throwable -> L20
        goto L8
    L12:
        if (((Boolean) r5.invoke(r3)).booleanValue() == true) goto L14;
        r4 = true;
        goto L15
    L17:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r1);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void n(Function1<? super IVideoController, Boolean> r5) {
        List<o> r0 = o.l;
        List<o> r1 = o.l;
        if (((ArrayList) r1).size() == 0) goto L30;
        monitor-enter(r1);
        Iterator r2 = ((ArrayList) r1).iterator();     // Catch: Throwable -> L20
    L8:
        if (r2.hasNext() == false) goto L17;
        o r3 = (o) r2.next();     // Catch: Throwable -> L20
        if (r5 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L8;
        r3.stop();     // Catch: Throwable -> L20
        goto L8
    L12:
        if (((Boolean) r5.invoke(r3)).booleanValue() == true) goto L14;
        r4 = true;
        goto L15
    L17:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r1);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void f(String r2, l4 r3) {
        List<o> r0 = o.l;
        if (r2 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        ThreadPlus.submitRunnable(new k(r2, r3));
        return;
    L13:
        return;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void i(yq9.d r9, final AIBridgePreloadMediaResourceMethod.b r10) {
        Intrinsics.checkNotNullParameter(r9, "item");
        List<o> r1 = o.l;
        Intrinsics.checkNotNullParameter(r9, "item");
        PreloaderURLItem r0 = new PreloaderURLItem(r9.a, null, r9.b, new String[]{r9.c});
        r0.setPriorityLevel(r9.d.getValue());
        r0.setCallBackListener(new n(r10));
        TTVideoEngine.addTask(r0);
    }

    public final Object h(String r18, String r19, Continuation<? super String> r20) {
        String r2 = r19;
        if ((r20 instanceof TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1) == false) goto L7;
        TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1 r4 = (TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1) r20;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r0 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        Downloader r3 = (Downloader) r4.L$2;
        String r8 = (String) r4.L$1;
        String r9 = (String) r4.L$0;
        ResultKt.throwOnFailure(r0);
    L87:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Downloader r10 = (Downloader) r4.L$2;
        String r11 = (String) r4.L$1;
        String r13 = (String) r4.L$0;
        ResultKt.throwOnFailure(r0);
        Downloader r12 = r10;
        r2 = r11;
    L49:
        if (((Boolean) r0).booleanValue() == true) goto L52;
        FLogger.a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] load all tasks failed, key=" + r2);
        return null;
    L52:
        r4.L$0 = r13;
        r4.L$1 = r2;
        r4.L$2 = r12;
        r4.label = 2;
        kotlinx.coroutines.i<String> r14 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r14.C();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L55
        Object r15 = Result.constructor-impl(r12.urlTask(new String[]{r13}, r2, null));     // Catch: Throwable -> L55
    L57:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L61;
        FLogger.a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] create task failed, key=" + r2 + ", " + r16);
    L61:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        DownloadURLTask r17 = (DownloadURLTask) r15;
        if (r17 != null) goto L66;
        FLogger.a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] create task returned null, key=" + r2);
        r14.resumeWith(Result.constructor-impl(null));
    L82:
        r0 = r14.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L85;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L85:
        if (r0 != r6) goto L87;
        return r6;
    L66:
        kotlinx.coroutines.i<String> r21 = a.put(r2, r14);
        if (r21 != null) goto L69;
    L71:
        r14.i(new c(r2, this, r17));
        FLogger.a.i("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] start, key=" + r2 + ", url=" + r13);     // Catch: Throwable -> L74
        r17.resume();     // Catch: Throwable -> L74
        Object r22 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L74
    L76:
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L82;
        a.remove(r2);
        if (r14.isActive() == false) goto L81;
        r14.resumeWith(Result.constructor-impl(null));
    L81:
        FLogger.a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] resume task failed, key=" + r2 + ", " + r23);
    L74:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L76
    L69:
        if (r21.isActive() == false) goto L71;
        r21.resumeWith(Result.constructor-impl(null));
    L55:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L57
    L16:
        ResultKt.throwOnFailure(r0);
        if (r18.length() != 0) goto L19;
        boolean r26 = true;
    L20:
        if (r26 == false) goto L22;
    L88:
        boolean r27 = true;
        FLogger r28 = FLogger.a;
        StringBuilder r29 = new StringBuilder("[downloadUrlUseDataLoader] invalid params, urlEmpty=");
        if (r18.length() != 0) goto L91;
        boolean r30 = true;
    L92:
        r29.append(r30);
        r29.append(", cacheKeyEmpty=");
        if (r19.length() == 0) goto L96;
        r27 = false;
    L96:
        r29.append(r27);
        r28.e("TTVideoEngineStaticServiceImpl", r29.toString());
        return null;
    L91:
        r30 = false;
        goto L92
    L22:
        if (r19.length() != 0) goto L24;
        boolean r31 = true;
    L25:
        if (r31 == true) goto L88;
        r12 = Downloader.getInstance();
        r12.setListener(c);
        Intrinsics.checkNotNull(r12);
        r13 = r18;
        r4.L$0 = r13;
        r4.L$1 = r2;
        r4.L$2 = r12;
        r4.label = 1;
        kotlinx.coroutines.i<Boolean> r110 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r110.C();
        kotlinx.coroutines.i<Boolean> r32 = b.put(r2, r110);
        if (r32 != null) goto L30;
    L32:
        r110.i(new p(r2));
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L35
        r12.loadAllTasks(AppHost.a.getApplication());     // Catch: Throwable -> L35
        Object r34 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r35 = Result.exceptionOrNull-impl(r34);
        if (r35 == null) goto L43;
        b.remove(r2);
        if (r110.isActive() == false) goto L42;
        r110.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
    L42:
        FLogger.a.e("TTVideoEngineStaticServiceImpl", "[downloadUrlUseDataLoader] load all tasks exception, key=" + r2 + ", " + r35);
    L43:
        r0 = r110.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L46:
        if (r0 != r6) goto L49;
        return r6;
    L35:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L30:
        if (r32.isActive() == false) goto L32;
        Result.Companion r112 = Result.Companion;
        r32.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        goto L32
    L24:
        r31 = false;
        goto L25
    L19:
        r26 = false;
    L7:
        r4 = new TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1(this, r20);
        goto L8
    }

    public final o m(String r3, boolean r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        List<o> r1 = o.l;
        Intrinsics.checkNotNullParameter(r3, "tag");
        o r2 = new o(r5);
        Intrinsics.checkNotNullParameter(r3, "tag");
        r2.d.setTag(r3);
        r2.y(r4, "getNewInstance");
        return r2;
    }

    public final void l(com.larus.video.impl.sdk.a r2, String r3, long r4, DataLoaderPreloadPriority r6, k0 r7) {
        Intrinsics.checkNotNullParameter(r6, "priority");
        List<o> r0 = o.l;
        o.a.a(r2, r3, r4, r6, r7);
    }
}
