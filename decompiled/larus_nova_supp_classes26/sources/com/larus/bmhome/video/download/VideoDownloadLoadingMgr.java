package com.larus.bmhome.video.download;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.video.IVideoDownloadLoadingMgrService;
import com.larus.bmhome.video.bean.VideoType;
import com.larus.common.apphost.AppHost;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.home.impl.sdk.b1;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.audit.BehaviorAuditApi;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.i2;
import com.larus.platform.service.o;
import com.larus.platform.service.o3;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.r;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.t0;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import nr9.g;
import org.json.JSONObject;
import t19.s;
import tx9.a2;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0002JÁ\u0001\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"2(\u0010#\u001a$\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\r\u0018\u00010$2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e2\u001e\u0010'\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050)\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010(2\u0006\u0010+\u001a\u00020 H\u0016¢\u0006\u0002\u0010,J\u0012\u0010-\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010/\u001a\u00020\u0005H\u0002J±\u0001\u00100\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2(\u00101\u001a$\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\r\u0018\u00010$2\u0006\u0010\u001f\u001a\u00020 2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"2\b\b\u0002\u0010+\u001a\u00020 2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e2\u001e\u0010'\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050)\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010(H\u0002¢\u0006\u0002\u00102J7\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\u0019\u001a\u00020\u001a2\u001e\u0010'\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050)\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010(H\u0002¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\u0005H\u0002Jh\u00108\u001a\u0002092\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u00052\u0016\b\u0002\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010+\u001a\u00020 H\u0082@¢\u0006\u0002\u0010>J<\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010\u00052\b\u0010B\u001a\u0004\u0018\u00010\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010DJ2\u0010E\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010FJ8\u0010G\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010DJ\"\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0002J:\u0010L\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010NJ*\u0010O\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u00052\u0006\u0010P\u001a\u00020 2\b\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u001aH\u0002J\u0010\u0010]\u001a\u00020\r2\u0006\u0010^\u001a\u00020\u001aH\u0002J*\u0010_\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r0(H\u0096@¢\u0006\u0002\u0010aJ.\u0010b\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020%X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0W0VX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0(X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010Y\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020[0Zj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020[`\\X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/larus/bmhome/video/download/VideoDownloadLoadingMgr;", "Lcom/larus/bmhome/video/IVideoDownloadLoadingMgrService;", "<init>", "()V", "TAG", "", "DIRECTORY_GENERATE_VIDEO", "MIME_VIDEO_MP4", "downloadContinuationMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/coroutines/CancellableContinuation;", "resumeDownloadContinuation", "", "downloadId", MusicAppletPage.KEY_PATH, "RESULT_CODE_FAILED_DOWNLOAD_VIDEO", "RESULT_CODE_FAILED_CRASH", "RESULT_CODE_FAILED_NO_WRITE_EXTERNAL_PERMISSION", "RESULT_CODE_FAILED_REQUEST_AUDIO", "RESULT_CODE_SUCCESS", "saveVideoAndLoading", "context", "Landroid/content/Context;", "downloadTaskKey", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "traceBlk", "Lkotlin/Function0;", "enableUseSRDownLoad", "", "metaDataMap", "", "finishCallback", "Lkotlin/Function4;", "", "saveCreationTaskIdBlk", "onInterceptUrl", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "isAIGC", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/platform/model/video/VideoPlayData;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;ZLjava/util/Map;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "canDownload", "videoContent", "getSavePath", "saveVideoAndLoadingInternal", "dismissLoadingCallback", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/platform/model/video/VideoPlayData;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function4;ZLjava/util/Map;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "createCreationVideoPerf", "Lcom/larus/platform/service/watermark/WatermarkPerfLogger$Tracker;", "(Lcom/larus/platform/model/video/VideoPlayData;Lkotlin/jvm/functions/Function1;)Lcom/larus/platform/service/watermark/WatermarkPerfLogger$Tracker;", "cleanCacheFileAfterQ", "cacheFilepath", "saveVideo", "Lcom/larus/platform/model/video/SaveVideoResult;", "resultPath", "metaData", "downloadFilehash", "originalDownloadUrl", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveVideoByMdlCache", "Lcom/larus/platform/model/video/MdlCacheSaveResult;", "cacheKey", "downloadUrl", "suffix", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyCompleteMdlCache", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyMdlCacheFile", "localFilePath", "saveVideoToAlbumBeforeQ", "Landroid/net/Uri;", "videoFile", "saveVideoFile", ShareType.URL, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobDownloadResult", "success", "errorMsg", "getFileSuffix", "contentData", "MIN_TRIGGER_LOADING_DURATION", "downloadingVideoDatas", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "downloadFinishBlk", "uploadLoadingJobMap", "Ljava/util/HashMap;", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/HashMap;", "cancelUpdateLoadingJob", "data", "collectLoadingStatus", "urlLoadingAction", "(Lcom/larus/platform/model/video/VideoPlayData;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMetaDataToVideo", "originFilePath", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoDownloadLoadingMgr implements IVideoDownloadLoadingMgrService {
    public final String b;
    public final String c;
    public final String d;
    public final ConcurrentHashMap<Integer, i<String>> e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final long j;
    public final StateFlowImpl k;
    public final com.larus.bmhome.video.download.b l;
    public final HashMap<g, Job> m;

    public static final class a implements Function1<Throwable, Unit> {
        public final /* synthetic */ VideoDownloadLoadingMgr a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ Ref.ObjectRef<Job> e;

        public a(VideoDownloadLoadingMgr r1, Ref.IntRef r2, String r3, Context r4, Ref.ObjectRef<Job> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object invoke(Object r4) {
            Throwable r5 = (Throwable) r4;
            this.a.e.remove(Integer.valueOf(this.b.element));
            FLogger.a.i(this.a.b, "Download video cancel, downloadId = " + this.b.element + ", downloadTaskKey " + this.c);
            Downloader.getInstance(this.d).cancel(this.b.element);
            Job r6 = (Job) this.e.element;
            if (r6 == null) goto L6;
            Job.DefaultImpls.cancel$default(r6, null, 1, null);
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class b extends AbsDownloadListener {
        public final /* synthetic */ VideoDownloadLoadingMgr a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Ref.IntRef c;
        public final /* synthetic */ Ref.ObjectRef<Job> d;
        public final /* synthetic */ String e;
        public final /* synthetic */ i<String> f;
        public final /* synthetic */ Context g;

        public final void onCanceled(DownloadInfo r4) {
            super.onCanceled(r4);
            FLogger.a.i(this.a.b, "Download video canceled, downloadTaskKey " + this.b);
            Job r5 = (Job) this.d.element;
            if (r5 == null) goto L6;
            Job.DefaultImpls.cancel$default(r5, null, 1, null);
            return;
        }

        public final void onProgress(DownloadInfo r9) {
            super.onProgress(r9);
            FLogger r0 = FLogger.a;
            String r1 = this.a.b;
            StringBuilder r2 = new StringBuilder("Download video progress: ");
            if (r9 == null) goto L5;
            Integer r10 = Integer.valueOf(r9.getDownloadProcess());
        L6:
            r2.append(r10);
            r0.i(r1, r2.toString());
            VideoDownloadLoadingMgr.f(this.d, this.f, this.a, this.b, this.g, this.c);
            return;
        L5:
            r10 = null;
            goto L6
        }

        public final void onStart(DownloadInfo r9) {
            super.onStart(r9);
            FLogger.a.i(this.a.b, "Download video start");
            VideoDownloadLoadingMgr.f(this.d, this.f, this.a, this.b, this.g, this.c);
        }

        public final void onSuccessed(DownloadInfo r13) {
            FLogger.a.i(this.a.b, "Download video success: downloadTaskKey " + this.b);
            VideoDownloadLoadingMgr r0 = this.a;
            int r1 = this.c.element;
            String r2 = null;
            if (r13 == null) goto L5;
            String r3 = r13.getTargetFilePath();
        L6:
            VideoDownloadLoadingMgr.d(r0, r1, r3);
            Job r4 = (Job) this.d.element;
            if (r4 == null) goto L9;
            Job.DefaultImpls.cancel$default(r4, null, 1, null);
        L9:
            VideoDownloadLoadingMgr.c(this.a, this.b, this.e, true, null);
            if (r13 == null) goto L12;
            String r7 = r13.getName();
        L13:
            if (r13 == null) goto L15;
            Long r8 = Long.valueOf(r13.getTotalBytes());
        L16:
            if (r13 == null) goto L18;
            r2 = r13.getMd5();
        L18:
            BehaviorAuditApi.c(new com.larus.platform.audit.b(null, r7, r8, r2, StringsKt.removePrefix(this.a.d, "."), 1), MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", "video"), TuplesKt.to("task_key", this.b), TuplesKt.to(ShareType.URL, this.e)}));
            return;
        L15:
            r8 = null;
            goto L16
        L12:
            r7 = null;
            goto L13
        L5:
            r3 = null;
            goto L6
        }

        public final void onFailed(DownloadInfo r16, BaseException r17) {
            FLogger r1 = FLogger.a;
            String r2 = this.a.b;
            StringBuilder r3 = new StringBuilder("Download video failed: ");
            String r4 = null;
            if (r17 == null) goto L5;
            String r5 = r17.getMessage();
        L6:
            r3.append(r5);
            r3.append(", downloadTaskKey ");
            r3.append(this.b);
            r1.e(r2, r3.toString());
            VideoDownloadLoadingMgr.d(this.a, this.c.element, null);
            Job r6 = (Job) this.d.element;
            if (r6 == null) goto L9;
            Job.DefaultImpls.cancel$default(r6, null, 1, null);
        L9:
            VideoDownloadLoadingMgr r7 = this.a;
            String r8 = this.b;
            String r9 = this.e;
            if (r17 == null) goto L12;
            String r10 = r17.getMessage();
        L13:
            VideoDownloadLoadingMgr.c(r7, r8, r9, false, r10);
            if (r16 == null) goto L16;
            String r11 = r16.getName();
        L17:
            if (r16 == null) goto L19;
            Long r12 = Long.valueOf(r16.getTotalBytes());
        L20:
            if (r16 == null) goto L22;
            r4 = r16.getMd5();
        L22:
            com.larus.platform.audit.b r13 = new com.larus.platform.audit.b(null, r11, r12, r4, StringsKt.removePrefix(this.a.d, "."), 1);
            Pair[] r14 = new Pair[4];
            r14[0] = TuplesKt.to("scene", "video");
            r14[1] = TuplesKt.to("task_key", this.b);
            r14[2] = TuplesKt.to(ShareType.URL, this.e);
            if (r17 == null) goto L26;
            String r15 = r17.getMessage();
            if (r15 == null) goto L26;
        L27:
            r14[3] = TuplesKt.to("error_msg", r15);
            BehaviorAuditApi.c(r13, MapsKt.mapOf(r14));
            return;
        L26:
            r15 = "";
            goto L27
        L19:
            r12 = null;
            goto L20
        L16:
            r11 = null;
            goto L17
        L12:
            r10 = null;
            goto L13
        L5:
            r5 = null;
            goto L6
        }

        public final void onRetry(DownloadInfo r8, BaseException r9) {
            super.onRetry(r8, r9);
            FLogger r10 = FLogger.a;
            String r0 = this.a.b;
            StringBuilder r1 = new StringBuilder("Download video retry: ");
            if (r8 == null) goto L5;
            Integer r11 = Integer.valueOf(r8.getRetryCount());
        L6:
            r1.append(r11);
            r10.i(r0, r1.toString());
            VideoDownloadLoadingMgr.f(this.d, this.f, this.a, this.b, this.g, this.c);
            return;
        L5:
            r11 = null;
            goto L6
        }

        public b(VideoDownloadLoadingMgr r1, String r2, Ref.IntRef r3, Ref.ObjectRef r4, String r5, j r6, Context r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public VideoDownloadLoadingMgr() {
        this.b = "VideoSave";
        this.c = "/nova_video/";
        this.d = ".mp4";
        this.e = new ConcurrentHashMap();
        this.f = 2001;
        this.g = -1;
        this.h = 601;
        this.i = 101;
        this.j = 200;
        this.k = j1.a(CollectionsKt.emptyList());
        this.l = new com.larus.bmhome.video.download.b(this);
        this.m = new HashMap();
    }

    public final String g(g r3) {
        if (Intrinsics.areEqual(r3.f, VideoType.MP4) == false) goto L6;
        return this.d;
    L6:
        return "." + r3.f;
    }

    public static final void d(VideoDownloadLoadingMgr r0, int r1, String r2) {
        i<String> r3 = r0.e.remove(Integer.valueOf(r1));
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.isActive() == false) goto L11;
        r3.resumeWith(Result.constructor-impl(r2));
        return;
    }

    @Override // com.larus.bmhome.video.IVideoDownloadLoadingMgrService
    public final Object a(g r5, com.larus.bmhome.bigimg.download.b r6, Continuation r7) {
        if ((r7 instanceof VideoDownloadLoadingMgr$collectLoadingStatus$1) == false) goto L7;
        VideoDownloadLoadingMgr$collectLoadingStatus$1 r0 = (VideoDownloadLoadingMgr$collectLoadingStatus$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L12;
        ResultKt.throwOnFailure(r8);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        StateFlowImpl r9 = this.k;
        e r4 = new e(r6, this, r5);
        r0.label = 1;
        if (r9.collect(r4, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new VideoDownloadLoadingMgr$collectLoadingStatus$1(this, r7);
        goto L8
    }

    public static final void c(VideoDownloadLoadingMgr r2, String r3, String r4, boolean r5, String r6) {
        r2.getClass();
        o r7 = o.a;
        JSONObject r0 = new JSONObject();
        r0.putOpt("task_key", r3);
        r0.putOpt(ShareType.URL, r4);
        r0.putOpt("success", l3.f(Boolean.valueOf(r5)));
        r0.putOpt("error_msg", r6);
        Unit r8 = Unit.INSTANCE;
        r7.reportEvent("larus_video_download_result", r0);
    }

    public static final void f(Ref.ObjectRef r9, i r10, VideoDownloadLoadingMgr r11, String r12, Context r13, Ref.IntRef r14) {
        Job r0 = (Job) r9.element;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        r9.element = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r10.getContext()), null, null, new VideoDownloadLoadingMgr$saveVideoFile$2$startTimer$1(r11, r12, r13, r14, null), 3, null);
    }

    public final Object i(String r18, String r19, String r20, String r21, String r22, Continuation<? super nr9.c> r23) {
        if ((r23 instanceof VideoDownloadLoadingMgr$saveVideoByMdlCache$1) == false) goto L7;
        VideoDownloadLoadingMgr$saveVideoByMdlCache$1 r1 = (VideoDownloadLoadingMgr$saveVideoByMdlCache$1) r23;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        VideoDownloadLoadingMgr$saveVideoByMdlCache$1 r9 = r1;
        Object r0 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r9.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r0);
        Object r13 = null;
    L74:
        String r4 = (String) r0;
        if (r4 == null) goto L78;
        return new nr9.c(r4);
    L78:
        return r13;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r5 = (String) r9.L$3;
        String r6 = (String) r9.L$2;
        String r7 = (String) r9.L$1;
        String r8 = (String) r9.L$0;
        ResultKt.throwOnFailure(r0);
        String r11 = r5;
        r13 = null;
        String r12 = r8;
    L17:
        String r14 = r6;
        String r15 = (String) r0;
        if (r15 != null) goto L64;
    L67:
        boolean r16 = true;
    L68:
        if (r16 == false) goto L71;
        FLogger.a.i(this.b, "[saveVideoByMdlCache] mdl download failed, key=" + r7 + ", downloadTaskKey=" + r12);
        return r13;
    L71:
        r9.L$0 = r13;
        r9.L$1 = r13;
        r9.L$2 = r13;
        r9.L$3 = r13;
        r9.label = 3;
        r0 = BuildersKt.withContext(Dispatchers.getIO(), new VideoDownloadLoadingMgr$copyMdlCacheFile$2(r15, this, r7, r14, r11, r12, null), r9);
        if (r0 != r10) goto L74;
        return r10;
    L64:
        if (r15.length() == 0) goto L67;
        r16 = false;
        goto L68
    L18:
        String r17 = (String) r9.L$4;
        r6 = (String) r9.L$3;
        String r24 = (String) r9.L$2;
        String r25 = (String) r9.L$1;
        String r26 = (String) r9.L$0;
        ResultKt.throwOnFailure(r0);
        r13 = null;
    L41:
        String r27 = (String) r0;
        if (r27 != null) goto L44;
        z2 r28 = z2.a;
        if (r28.enableVideoDownloadMdl() == true) goto L49;
        FLogger.a.i(this.b, "[saveVideoByMdlCache] mdl download disabled, key=" + r25 + ", downloadTaskKey=" + r26);
        return r13;
    L49:
        if (r24 != null) goto L51;
    L54:
        boolean r29 = true;
    L55:
        if (r29 == false) goto L57;
        return r13;
    L57:
        long r30 = r28.getCreationVideoMdlDownloadTimeoutMs();
        VideoDownloadLoadingMgr$saveVideoByMdlCache$downloadedLocalFilePath$1 r31 = new VideoDownloadLoadingMgr$saveVideoByMdlCache$downloadedLocalFilePath$1(r24, r25, this, r26, null);
        r9.L$0 = r26;
        r9.L$1 = r25;
        r9.L$2 = r6;
        r9.L$3 = r17;
        r9.L$4 = r13;
        r9.label = 2;
        r0 = TimeoutKt.c(r30, r31, r9);
        if (r0 != r10) goto L60;
        return r10;
    L60:
        r7 = r25;
        r12 = r26;
        r11 = r17;
        goto L17
    L51:
        if (r24.length() == 0) goto L54;
        r29 = false;
        goto L55
    L44:
        return new nr9.c(r27);
    L19:
        ResultKt.throwOnFailure(r0);
        if (r19 != null) goto L22;
    L25:
        boolean r32 = true;
    L26:
        if (r32 == false) goto L28;
        return null;
    L28:
        r9.L$0 = r18;
        r9.L$1 = r19;
        r9.L$2 = r20;
        r9.L$3 = r21;
        r9.L$4 = r22;
        r9.label = 1;
        if (r19 != null) goto L31;
    L34:
        boolean r33 = true;
    L35:
        if (r33 == false) goto L37;
        r0 = null;
        r13 = null;
    L38:
        if (r0 != r10) goto L40;
        return r10;
    L40:
        r26 = r18;
        r24 = r20;
        r6 = r21;
        r17 = r22;
        r25 = r19;
        goto L41
    L37:
        r13 = null;
        r0 = BuildersKt.withContext(Dispatchers.getIO(), new VideoDownloadLoadingMgr$copyCompleteMdlCache$2(this, r19, r18, r21, r22, null), r9);
        goto L38
    L31:
        if (r19.length() == 0) goto L34;
        r33 = false;
        goto L35
    L22:
        if (r19.length() == 0) goto L25;
        r32 = false;
    L7:
        r1 = new VideoDownloadLoadingMgr$saveVideoByMdlCache$1(this, r23);
        goto L8
    }

    public final Object j(Context r14, String r15, String r16, String r17, String r18, Continuation<? super String> r19) {
        i<String> r8 = new j(IntrinsicsKt.intercepted(r19), 1);
        r8.C();
        Ref.IntRef r10 = new Ref.IntRef();
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        b r12 = new b(this, r15, r10, r11, r16, r8, r14);
        DownloadTask r0 = Downloader.with(r14).taskKey(r15);
        t0 r1 = z2.a.getCreationDownloaderConfig();
        if (r1 == null) goto L7;
        Integer r2 = r1.retryCount;
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        DownloadTask r4 = r0.retryCount(r3).autoSetHashCodeForSameTask(true).url(r16).savePath(r17).name(System.currentTimeMillis() + r18).subThreadListener(r12);
        int r5 = r4.getDownloadId();
        r10.element = r5;
        this.e.put(Boxing.boxInt(r5), r8);
        r8.i(new a(this, r10, r15, r14, r11));
        r4.asyncDownload(null);
        f(r11, r8, this, r15, r14, r10);
        Object r6 = r8.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r19);
    L11:
        return r6;
    L7:
        r3 = 3;
        goto L8
    }

    public final void h(Context r18, String r19, g r20, CoroutineScope r21, Function4 r22, Map r23, boolean r24, Function0 r25, Function1 r26) {
        if (r26 != null) goto L4;
        WatermarkPerfLogger.a r10 = null;
    L21:
        BuildersKt.launch$default(r21, new f(CoroutineExceptionHandler.Key, r19, r10, r22, this, r20), null, new VideoDownloadLoadingMgr$saveVideoAndLoadingInternal$1(this, r.h() + this.c, r20, r10, r18, r19, r23, r24, r22, r25, r26, null), 2, null);
        return;
    L4:
        DownloadWatermarkService.a.getClass();
        boolean r0 = DownloadWatermarkService.d();
        int r1 = WatermarkPerfLogger.a;
        if (r0 == false) goto L7;
        WatermarkPerfLogger.Version r2 = WatermarkPerfLogger.Version.ENTERPRISE;
    L8:
        WatermarkPerfLogger.a r3 = WatermarkPerfLogger.a("creation_video_save", r2, DownloadWatermarkScene.CI_GEN_VIDEO_DOWNLOAD);
        if (r0 == false) goto L19;
        String r4 = r20.c;
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L19;
        WatermarkPerfLogger.Path r6 = WatermarkPerfLogger.Path.A;
    L20:
        r3.c(r6);
        r10 = r3;
        goto L21
    L13:
        if (r4.length() == 0) goto L16;
        r5 = false;
    L19:
        r6 = WatermarkPerfLogger.Path.NONE;
        goto L20
    L7:
        r2 = WatermarkPerfLogger.Version.PERSONAL;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [int] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static final Object e(VideoDownloadLoadingMgr r21, Context r22, String r23, g r24, String r25, Map r26, String r27, String r28, boolean r29, Continuation r30) {
        String r9 = r23;
        g r10 = r24;
        Map r11 = r26;
        boolean r12 = r29;
        r21.getClass();
        if ((r30 instanceof VideoDownloadLoadingMgr$saveVideo$1) == false) goto L7;
        VideoDownloadLoadingMgr$saveVideo$1 r2 = (VideoDownloadLoadingMgr$saveVideo$1) r30;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        VideoDownloadLoadingMgr$saveVideo$1 r13 = r2;
        Object r1 = r13.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        boolean r5 = true;
        String r6 = " with downloadTaskKey ";
        String r15 = "";
        if (r4 == 0) goto L21;
        if (r4 == 1) goto L20;
        if (r4 == 2) goto L19;
        if (r4 != 3) goto L14;
        int r0 = r13.I$0;
        boolean r7 = r13.Z$0;
        Map r8 = (Map) r13.L$3;
        g r16 = (g) r13.L$2;
        String r17 = (String) r13.L$1;
        Context r18 = (Context) r13.L$0;
        ResultKt.throwOnFailure(r1);
        r12 = r7;
        r11 = r8;
        boolean r31 = false;
        int r19 = r0;
        String r20 = r17;
    L62:
        String r32 = (String) r1;
        if (r32 == null) goto L124;
        Context r33 = r18;
        ?? r34 = r19;
    L71:
        FLogger r35 = FLogger.a;
        r35.i(r21.b, "[saveVideo] save " + r32 + r6 + r20);
        String r36 = r21.g(r16);
        if (r11 != null) goto L74;
    L77:
        boolean r37 = true;
    L78:
        if (r37 == false) goto L80;
        r32 = r32;
        int r38 = 0;
        r5 = true;
    L107:
        String r39 = r32;
    L108:
        CoroutineDispatcher r40 = Dispatchers.getIO();
        VideoDownloadLoadingMgr$saveVideo$2 r41 = new VideoDownloadLoadingMgr$saveVideo$2(r21, r39, r12, r33, r16, null);
        r13.L$0 = r39;
        r13.L$1 = null;
        r13.L$2 = null;
        r13.L$3 = null;
        r13.L$4 = null;
        r13.L$5 = null;
        r13.I$0 = r34;
        r13.label = 4;
        if (BuildersKt.withContext(r40, r41, r13) == r14) goto L128;
        ?? r42 = r34;
    L113:
        if (r42 != 0) goto L117;
        r5 = false;
    L117:
        return new nr9.e(r38, r39, Boxing.boxBoolean(r5));
    L128:
        return r14;
    L80:
        StringBuilder r43 = new StringBuilder();
        r43.append(r.h() + r21.c);
        r43.append(System.currentTimeMillis());
        r43.append(r36);
        String r44 = r43.toString();
        if (ICreationMetadataService.a.M(r11) == true) goto L120;
        r32 = r32;
        r38 = 0;
        r5 = true;
        r35.i(r21.b, "isSuccess:false, metaData is invalid:" + HttpExtKt.p(r11));
        goto L107
    L120:
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L84
        Object r46 = Result.constructor-impl(o3.b.e(r32));     // Catch: Throwable -> L84
    L86:
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L90;
        FLogger.a.i(r21.b, "getMetaData error" + r47.getMessage());
        r46 = null;
    L90:
        Map r48 = (Map) r46;
        HashMap r49 = new HashMap();
        if (r48 == null) goto L93;
        r49.putAll(r48);
    L93:
        r49.putAll(r11);
        FLogger r50 = FLogger.a;
        String r51 = r21.b;
        StringBuilder r110 = new StringBuilder("addMetaDataToVideo origin:");
        if (r48 == null) goto L96;
        String r52 = HttpExtKt.p(r48);
    L97:
        r110.append(r52);
        r110.append(", incoming:");
        r110.append(HttpExtKt.p(r11));
        r110.append(", merged:");
        r110.append(HttpExtKt.p(r49));
        r50.i(r51, r110.toString());
        long r53 = SystemClock.elapsedRealtime();
        boolean r54 = o3.b.i(r32, r44, r49);     // Catch: Exception -> L100
    L102:
        FLogger.a.i(r21.b, "isSuccess:" + r54 + ", metaData:" + HttpExtKt.p(r49));
        if (r54 == false) goto L105;
        r5 = true;
        a2.a(1, "video", Long.valueOf(SystemClock.elapsedRealtime() - r53));
        r39 = r44;
        r38 = 0;
        goto L108
    L105:
        r5 = true;
        r38 = 0;
        a2.a(0, "video", Long.valueOf(SystemClock.elapsedRealtime() - r53));
    L100:
        e = move-exception;
        FLogger.a.i(r21.b, "setMetaData error" + e.getMessage() + '}');
        r54 = false;
        goto L102
    L96:
        r52 = null;
    L84:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        r46 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L74:
        if (r11.isEmpty() == true) goto L77;
        r37 = false;
        goto L78
    L124:
        return new nr9.e(r21.f, "", Boxing.boxBoolean(r31));
    L14:
        if (r4 != 4) goto L17;
        int r56 = r13.I$0;
        r39 = (String) r13.L$0;
        ResultKt.throwOnFailure(r1);
        r38 = 0;
        r42 = r56;
        goto L113
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        int r57 = r13.I$0;
        boolean r58 = r13.Z$0;
        Map r59 = (Map) r13.L$3;
        r16 = (g) r13.L$2;
        r9 = (String) r13.L$1;
        Context r111 = (Context) r13.L$0;
        ResultKt.throwOnFailure(r1);
        r6 = " with downloadTaskKey ";
        boolean r310 = false;
        Object r112 = null;
    L53:
        r32 = (String) r1;
        if (r32 == null) goto L123;
        ?? r60 = r57;
        r11 = r59;
        r33 = r111;
    L57:
        r20 = r9;
        r12 = r58;
        r34 = r60;
        goto L71
    L123:
        return new nr9.e(r21.f, "", Boxing.boxBoolean(r310));
    L20:
        int r61 = r13.I$0;
        r58 = r13.Z$0;
        String r62 = (String) r13.L$5;
        Map r63 = (Map) r13.L$4;
        String r113 = (String) r13.L$3;
        g r114 = (g) r13.L$2;
        String r115 = (String) r13.L$1;
        r33 = (Context) r13.L$0;
        ResultKt.throwOnFailure(r1);
        String r116 = r62;
        r310 = false;
        int r64 = r61;
        String r65 = r113;
        r10 = r114;
        r11 = r63;
        r9 = r115;
        r112 = null;
    L46:
        nr9.c r66 = (nr9.c) r1;
        if (r66 == null) goto L49;
        boolean r67 = r66.b;
        r32 = r66.a;
        r60 = r67;
        r16 = r10;
        goto L57
    L49:
        String r68 = r21.g(r10);
        r13.L$0 = r33;
        r13.L$1 = r9;
        r13.L$2 = r10;
        r13.L$3 = r11;
        r13.L$4 = r112;
        r13.L$5 = r112;
        r13.Z$0 = r58;
        r13.I$0 = r64;
        r13.label = 2;
        r1 = r21.j(r33, r9, r116, r65, r68, r13);
        if (r1 == r14) goto L126;
        r57 = r64;
        r16 = r10;
        r59 = r11;
        r111 = r33;
        goto L53
    L126:
        return r14;
    L21:
        ResultKt.throwOnFailure(r1);
        char r69 = r.a;
        if (r.k(r10.h) == true) goto L66;
        FLogger.a.i(r21.b, "[saveVideo] start to download:" + r10.c + " with downloadTaskKey " + r9);
        String r70 = r10.c;
        if (r70 == null) goto L122;
        if (r27 != null) goto L28;
    L31:
        boolean r71 = true;
    L32:
        if (r71 == false) goto L34;
    L36:
        boolean r72 = false;
    L37:
        if (r72 == false) goto L39;
        String r73 = r27;
    L41:
        if (z2.a.enableCreationVideoDownloadOpt() == false) goto L58;
        String r117 = r21.g(r10);
        r13.L$0 = r22;
        r13.L$1 = r9;
        r13.L$2 = r10;
        r13.L$3 = r25;
        r13.L$4 = r11;
        r13.L$5 = r70;
        r13.Z$0 = r12;
        r13.I$0 = 0;
        r13.label = 1;
        r310 = false;
        r112 = null;
        r116 = r70;
        r1 = r21.i(r23, r73, r70, r25, r117, r13);
        if (r1 == r14) goto L125;
        r58 = r29;
        r33 = r22;
        r64 = 0;
        r65 = r25;
        goto L46
    L125:
        return r14;
    L58:
        String r74 = r21.g(r10);
        r13.L$0 = r22;
        r13.L$1 = r9;
        r13.L$2 = r10;
        r13.L$3 = r11;
        r12 = r29;
        r13.Z$0 = r12;
        r13.I$0 = 0;
        r13.label = 3;
        r31 = false;
        r1 = r21.j(r22, r23, r70, r25, r74, r13);
        if (r1 == r14) goto L127;
        r16 = r10;
        r19 = 0;
        r18 = r22;
        r20 = r23;
        goto L62
    L127:
        return r14;
    L39:
        r73 = null;
        goto L41
    L34:
        if (Intrinsics.areEqual(r70, r28) == false) goto L36;
        r72 = true;
        goto L37
    L28:
        if (r27.length() == 0) goto L31;
        r71 = false;
        goto L32
    L122:
        return new nr9.e(r21.f, "", Boxing.boxBoolean(false));
    L66:
        r6 = " with downloadTaskKey ";
        String r75 = r10.h;
        if (r75 == null) goto L70;
        r15 = r75;
    L70:
        r33 = r22;
        r16 = r10;
        r32 = r15;
        r34 = 0;
        r20 = r23;
    L7:
        r2 = new VideoDownloadLoadingMgr$saveVideo$1(r21, r30);
        goto L8
    }

    @Override // com.larus.bmhome.video.IVideoDownloadLoadingMgrService
    public final void b(Context r20, final String r21, final g r22, final CoroutineScope r23, Function0<Unit> r24, final boolean r25, final Map<String, String> r26, final Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r27, final Function0<Unit> r28, final Function1<? super Continuation<? super String>, ? extends Object> r29, final boolean r30) {
        Intrinsics.checkNotNullParameter(r21, "downloadTaskKey");
        Intrinsics.checkNotNullParameter(r23, "scope");
        FragmentActivity r2 = null;
        if (r20 == null) goto L71;
        boolean r7 = false;
        if (r22 == null) goto L23;
        String r9 = r22.c;
        if (r9 != null) goto L10;
    L13:
        boolean r10 = true;
    L14:
        if (r10 == false) goto L24;
        String r11 = r22.h;
        if (r11 != null) goto L18;
    L21:
        boolean r12 = true;
    L22:
        if (r12 == false) goto L24;
    L18:
        if (r11.length() == 0) goto L21;
        r12 = false;
    L24:
        boolean r13 = true;
    L25:
        if (r13 == false) goto L71;
        FlowFileProtectionService r14 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r14 != null) goto L30;
    L32:
        if (r7 == false) goto L43;
        o r3 = o.a;
        JSONObject r4 = new JSONObject();
        r4.put("action", "save_album");
        r4.put("entry", "video_download_manager");
        r4.put("channel", "album");
        r4.put("content_type", "video");
        Unit r5 = Unit.INSTANCE;
        r3.reportEvent("flow_enterprise_file_egress_block", r4);
        String r6 = r14.H0();
        if (r6 != null) goto L36;
    L41:
        r27.invoke(602, "", 0L, null);
        return;
    L36:
        if ((!StringsKt.isBlank(r6)) == true) goto L39;
        r6 = null;
    L39:
        if (r6 == null) goto L41;
        s.j(s.a, r20, r6, null, false, 28);
        goto L41
    L43:
        if (r22 != null) goto L73;
        return;
    L73:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L51
        if (r24 == null) goto L48;
        r24.invoke();     // Catch: Throwable -> L51
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L51
    L49:
        Result.constructor-impl(r1);     // Catch: Throwable -> L51
    L53:
        Job r8 = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new VideoDownloadLoadingMgr$saveVideoAndLoading$updateLoadingJob$1(this, r22, null), 3, null);
        r8.invokeOnCompletion(new c(this, r21, r22));
        this.m.put(r22, r8);
        String r15 = r22.c;
        if (r15 == null) goto L59;
        IFlowSdkDepend r16 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r16 == null) goto L59;
        r16.D0();
        b1.a.d(r15);
    L59:
        if (Build.VERSION.SDK_INT <= 28) goto L61;
    L69:
        h(AppHost.a.getApplication().getApplicationContext(), r21, r22, r23, r27, r26, r30, r28, r29);
        return;
    L61:
        if (ContextCompat.checkSelfPermission(r20, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L69;
        if ((r20 instanceof FragmentActivity) == false) goto L65;
        r2 = (FragmentActivity) r20;
    L65:
        FragmentActivity r17 = r2;
        if (r17 != null) goto L68;
        return;
    L68:
        i2.b.a(r17, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), new d(this, r21, r22, r23, r27, r25, r26, r30, r28, r29));
        return;
    L48:
        r1 = null;
    L51:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L53
    L30:
        if (r14.I0() != true) goto L32;
        r7 = true;
        goto L32
    L10:
        if (r9.length() == 0) goto L13;
        r10 = false;
    L23:
        r13 = false;
    L71:
        r27.invoke(Integer.valueOf(this.i), "no context", 0L, null);
    }
}
