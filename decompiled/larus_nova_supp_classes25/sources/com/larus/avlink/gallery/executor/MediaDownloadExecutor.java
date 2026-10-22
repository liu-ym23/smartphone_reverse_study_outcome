package com.larus.avlink.gallery.executor;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.j;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.MediaInfo;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MediaDownloadExecutor {
    public static final /* synthetic */ int n = 0;
    public final CoroutineScope a;
    public final MediaProcessingExecutor b;
    public final MediaLifecycleStateManager c;
    public final MutexImpl d;
    public final com.larus.avlink.gallery.processor.f e;
    public final com.larus.avlink.gallery.processor.e f;
    public final AtomicInteger g;
    public final AtomicInteger h;
    public Function2<? super String, ? super MediaLifecycleState, Unit> i;
    public Function1<? super Integer, Unit> j;
    public Function0<Unit> k;
    public String l;
    public com.larus.avlink.gallery.processor.a m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaLifecycleState.values().length];
            r0[MediaLifecycleState.DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[MediaLifecycleState.DOWNLOADED_TEMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[MediaLifecycleState.PROCESSING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[MediaLifecycleState.PROCESSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {
        public final /* synthetic */ DownloadTask a;
        public final /* synthetic */ Context b;

        public c(DownloadTask r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r3) {
            Throwable r4 = (Throwable) r3;
            FLogger.a.d("MediaDownloadExecutor", "Download cancel, downloadId = " + this.a.getDownloadId());
            Downloader.getInstance(this.b).cancel(this.a.getDownloadId());
            return Unit.INSTANCE;
        }
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            FLogger.a.e("MediaDownloadExecutor", "sql execute err! msg=" + r4);
        }
    }

    static {
    }

    public final void e() {
        com.larus.avlink.gallery.processor.f r0 = this.e;
        r0.b = true;
        Iterator r2 = CollectionsKt.toList(r0.a).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Job r3 = (Job) r2.next();
        if (r3.isActive() == false) goto L4;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
        goto L4
    L8:
        r0.a.clear();
        this.h.set(0);
        this.g.set(0);
        this.m = new com.larus.avlink.gallery.processor.a(0);
        this.i = null;
        this.k = null;
        this.j = null;
    }

    public static final void a(final MediaDownloadExecutor r12) {
        if (r12.e.b == false) goto L5;
        FLogger.a.i("MediaDownloadExecutor", "Download cancelled, skipping completion check");
        return;
    L5:
        int r0 = r12.h.incrementAndGet();
        int r2 = (int) ((((double) r0) / ((double) r12.g.get())) * ((double) 100));
        FLogger.a.i("MediaDownloadExecutor", "Download progress: " + r2 + "% (" + r0 + '/' + r12.g + ')');
        Function1<? super Integer, Unit> r1 = r12.j;
        if (r1 == null) goto L9;
        r1.invoke(Integer.valueOf(r2));
    L9:
        if (r0 != r12.g.get()) goto L20;
        com.larus.avlink.gallery.processor.a r3 = r12.m;
        if ((r3.d + r3.e) != r12.g.get()) goto L13;
        int r5 = 0;
    L17:
        GalleryMobHelper r4 = GalleryMobHelper.a;
        com.larus.avlink.gallery.processor.a r6 = r12.m;
        long r7 = r6.a;
        int r8 = r6.b;
        int r9 = r6.c;
        int r10 = r6.d;
        int r11 = r6.e;
        r4.getClass();
        GalleryMobHelper.d(r5, r7, r8, r9, r10, r11);
        com.larus.avlink.gallery.processor.a r13 = r12.m;
        long r14 = r13.f;
        int r15 = r13.b;
        int r16 = r13.c;
        GalleryMobHelper.i("dora_sync_media_to_app", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("total_duration", Long.valueOf(r14)), TuplesKt.to("photo_cnt", Integer.valueOf(r15)), TuplesKt.to("video_cnt", Integer.valueOf(r16)), TuplesKt.to("total_cnt", Integer.valueOf(r15 + r16))}));
        SoftReference r17 = y.a;
        Runnable r18 = new com.larus.avlink.gallery.executor.b(r12);
        Intrinsics.checkNotNullParameter(r18, "action");
        y.d(r18, 200);
        return;
    L13:
        com.larus.avlink.gallery.processor.a r19 = r12.m;
        if ((r19.d + r19.e) <= 0) goto L16;
        r5 = 2;
        goto L17
    L16:
        r5 = 1;
        goto L17
    }

    public static String g(String r2) {
        if (Intrinsics.areEqual(j.d(r2), "live_photo") == false) goto L5;
        return "image_pack";
    L5:
        if (r2 != null) goto L9;
        return "image";
    L9:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0084: MOVE (r13 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]) (LINE:16777348), block:B:26:0x0084 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.avlink.gallery.model.MediaMetadata] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.avlink.gallery.model.MediaMetadata] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.lang.Object, java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x02ca -> B:104:0x00e0). Please report as a decompilation issue!!! */
    public final Object l(Continuation<? super List<String>> r18) {
        ?? r1 = "[Recovery] Found ";
        if ((r18 instanceof MediaDownloadExecutor$recoverIncompleteDownloads$1) == false) goto L7;
        MediaDownloadExecutor$recoverIncompleteDownloads$1 r2 = (MediaDownloadExecutor$recoverIncompleteDownloads$1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
        MediaDownloadExecutor r4 = this;
    L8:
        Object r0 = r2.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r6 = r2.label;
        int r7 = 4;
        if (r6 == 0) goto L30;
        if (r6 != 1) goto L103;
        List r8 = (List) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L90
        List r9 = r8;
    L34:
        List r10 = (List) r0;     // Catch: Exception -> L90
        if ((!r10.isEmpty()) == false) goto L87;
        FLogger.a.i("MediaDownloadExecutor", "[Recovery] Found " + r10.size() + " incomplete media in repository");     // Catch: Exception -> L90
        MediaDownloadExecutor r11 = r4;
        List r12 = r9;
        ?? r13 = r10.iterator();     // Catch: Exception -> L90
    L104:
    L85:
        e = e;
        r6 = r12;
    L91:
        FLogger.a.e("MediaDownloadExecutor", "[Recovery] Error during recovery: " + e.getMessage(), e);
        ?? r14 = r6;
    L92:
        return r14;
    L39:
        if (r13.hasNext() == false) goto L84;
        MediaMetadata r15 = (MediaMetadata) r13.next();     // Catch: Exception -> L85
        FLogger r16 = FLogger.a;     // Catch: Exception -> L77
        r16.i("MediaDownloadExecutor", "[Recovery] Recovering " + r15.getUniqId() + " (state: " + r15.getLifecycleState() + ')');     // Catch: Exception -> L77
        int r17 = b.a[r15.getLifecycleState().ordinal()];     // Catch: Exception -> L77
        if (r17 != 1) goto L44;
        r2.L$0 = r12;     // Catch: Exception -> L77
        r2.L$1 = r13;     // Catch: Exception -> L77
        r2.L$2 = r15;     // Catch: Exception -> L77
        r2.label = 2;     // Catch: Exception -> L77
        r0 = r11.k(r15, r2);     // Catch: Exception -> L77
        if (r0 != r5) goto L69;
        return r5;
    L69:
        ?? r19 = r13;
        Object r20 = r5;
        MediaDownloadExecutor$recoverIncompleteDownloads$1 r21 = r2;
        MediaDownloadExecutor r22 = r11;
        r1 = r15;
        List r110 = r12;
    L101:
        if (((Boolean) r0).booleanValue() == false) goto L73;
        Boxing.boxBoolean(r110.add(r1.getUniqId()));     // Catch: Exception -> L75
    L74:
        r11 = r22;
        r2 = r21;
        r5 = r20;
        ?? r23 = r19;
        List r111 = r110;
    L81:
        r7 = 4;
        r13 = r23;
        r12 = r111;
        goto L104
    L73:
        FLogger.a.w("MediaDownloadExecutor", "[Recovery] Skipping DOWNLOAD state: " + r1.getUniqId());     // Catch: Exception -> L75
    L75:
        e = e;
        List r112 = r110;
        ?? r113 = r19;
    L93:
        FLogger.a.e("MediaDownloadExecutor", "[Recovery] Error recovering " + r1.getUniqId() + ": " + e.getMessage(), e);     // Catch: Exception -> L82
        ?? r114 = r113;
        List r115 = r112;
    L55:
        r11 = r22;
        r2 = r21;
        r5 = r20;
        r23 = r114;
        r111 = r115;
    L82:
        e = e;
        r6 = r112;
        goto L91
    L44:
        if (r17 == 2) goto L65;
        if (r17 == 3) goto L64;
        if (r17 != r7) goto L48;
        r16.i("MediaDownloadExecutor", "Auto-syncing processed media to system album: " + r15 + ".uniqId");     // Catch: Exception -> L77
        MediaSyncExecutor r24 = MediaSyncExecutor.a;     // Catch: Exception -> L77
        r2.L$0 = r12;     // Catch: Exception -> L77
        r2.L$1 = r13;     // Catch: Exception -> L77
        r2.L$2 = r15;     // Catch: Exception -> L77
        r2.label = 3;     // Catch: Exception -> L77
        if (r24.f(r15, r2) != r5) goto L59;
        return r5;
    L59:
        MediaDownloadExecutor$recoverIncompleteDownloads$1 r116 = r2;
        r22 = r11;
        MediaMetadata r25 = r15;
        List r117 = r12;
        ?? r118 = r13;
        r20 = r5;
        r21 = r116;
    L60:
        r117.add(r25.getUniqId());     // Catch: Exception -> L62
        FLogger.a.i("MediaDownloadExecutor", "Sync completed for processed media: " + r25 + ".uniqId");     // Catch: Exception -> L62
        r114 = r118;
        r115 = r117;
        goto L55
    L48:
        if (r17 == 5) goto L50;
        r16.w("MediaDownloadExecutor", "[Recovery] Unexpected state: " + r15.getLifecycleState() + " for " + r15.getUniqId());     // Catch: Exception -> L77
        r23 = r13;
        r111 = r12;
        goto L81
    L50:
        r16.i("MediaDownloadExecutor", "Auto-syncing media to system album: " + r15 + ".uniqId");     // Catch: Exception -> L77
        MediaSyncExecutor r26 = MediaSyncExecutor.a;     // Catch: Exception -> L77
        r2.L$0 = r12;     // Catch: Exception -> L77
        r2.L$1 = r13;     // Catch: Exception -> L77
        r2.L$2 = r15;     // Catch: Exception -> L77
        r2.label = r7;     // Catch: Exception -> L77
        if (r26.f(r15, r2) != r5) goto L53;
        return r5;
    L53:
        MediaDownloadExecutor$recoverIncompleteDownloads$1 r119 = r2;
        r22 = r11;
        r1 = r15;
        r112 = r12;
        r113 = r13;
        r20 = r5;
        r21 = r119;
    L97:
        FLogger.a.i("MediaDownloadExecutor", "Sync completed for media: " + r1 + ".uniqId");     // Catch: Exception -> L62
        r114 = r113;
        r115 = r112;
    L62:
        e = e;
        goto L93
    L64:
        r11.b.a(r15.getUniqId(), true);     // Catch: Exception -> L77
        r12.add(r15.getUniqId());     // Catch: Exception -> L77
        r16.i("MediaDownloadExecutor", "[Recovery] Enqueued processing task for: " + r15.getUniqId());     // Catch: Exception -> L77
        r23 = r13;
        r111 = r12;
        goto L81
    L65:
        r11.b.a(r15.getUniqId(), true);     // Catch: Exception -> L77
        r12.add(r15.getUniqId());     // Catch: Exception -> L77
        r16.i("MediaDownloadExecutor", "[Recovery] Enqueued processing task for: " + r15.getUniqId());     // Catch: Exception -> L77
        r23 = r13;
        r111 = r12;
    L77:
        e = e;
        MediaDownloadExecutor$recoverIncompleteDownloads$1 r120 = r2;
        r22 = r11;
        r1 = r15;
        r112 = r12;
        r113 = r13;
        r20 = r5;
        r21 = r120;
        goto L93
    L84:
        r6 = r12;
    L88:
        FLogger.a.i("MediaDownloadExecutor", "[Recovery] ✅ Total recovered: " + r6.size() + " media");     // Catch: Exception -> L90
        r14 = r6;
        goto L92
    L87:
        FLogger.a.d("MediaDownloadExecutor", "[Recovery] No incomplete media found in repository");     // Catch: Exception -> L90
        r6 = r9;
        goto L88
    L103:
        if (r6 == 2) goto L22;
        if (r6 == 3) goto L19;
        if (r6 != 4) goto L18;
        MediaMetadata r27 = (MediaMetadata) r2.L$2;
        Iterator r28 = (Iterator) r2.L$1;
        List r121 = (List) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L25
        r112 = r121;
        r113 = r28;
        r20 = r5;
        r21 = r2;
        r22 = r4;
        r1 = r27;
        goto L97
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r25 = (MediaMetadata) r2.L$2;
        Iterator r29 = (Iterator) r2.L$1;
        List r122 = (List) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L25
        r117 = r122;
        r118 = r29;
        r20 = r5;
        r21 = r2;
        r22 = r4;
        goto L60
    L22:
        MediaMetadata r30 = (MediaMetadata) r2.L$2;
        Iterator r31 = (Iterator) r2.L$1;
        List r123 = (List) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L25
        r19 = r31;
        r20 = r5;
        r21 = r2;
        r22 = r4;
        r1 = r30;
        r110 = r123;
    L25:
        e = e;
        r112 = r12;
        r113 = r6;
        r20 = r5;
        r21 = r2;
        r22 = r4;
        goto L93
    L30:
        ResultKt.throwOnFailure(r0);
        ArrayList r32 = new ArrayList();
        FLogger.a.i("MediaDownloadExecutor", "[Recovery] Querying incomplete media from repository...");     // Catch: Exception -> L90
        AlbumDataBaseHelper r33 = AlbumDataBaseHelper.a;     // Catch: Exception -> L90
        MediaLifecycleState r124 = MediaLifecycleState.COMPLETED;     // Catch: Exception -> L90
        r2.L$0 = r32;     // Catch: Exception -> L90
        r2.label = 1;     // Catch: Exception -> L90
        r0 = r33.r(r124, r2);     // Catch: Exception -> L90
        r9 = r32;
        if (r0 != r5) goto L34;
        return r5;
    L90:
        e = e;
    L7:
        r4 = this;
        r2 = new MediaDownloadExecutor$recoverIncompleteDownloads$1(r4, r18);
        goto L8
    }

    public MediaDownloadExecutor(CoroutineScope r2, MediaProcessingExecutor r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "processingExecutor");
        this.a = r2;
        this.b = r3;
        this.c = MediaLifecycleStateManager.b.a();
        this.d = kotlinx.coroutines.sync.b.a();
        this.e = new com.larus.avlink.gallery.processor.f();
        this.f = new com.larus.avlink.gallery.processor.e();
        this.g = new AtomicInteger(0);
        this.h = new AtomicInteger(0);
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L7;
        IDoraService.j r5 = r4.S();
        if (r5 == null) goto L7;
        String r6 = r5.getHost();
    L8:
        this.l = r6;
        this.m = new com.larus.avlink.gallery.processor.a(0);
        return;
    L7:
        r6 = null;
        goto L8
    }

    public static final int b(MediaDownloadExecutor r0, MediaInfo r1) {
        r0.getClass();
        if (j.a(g(r1.getMediaType())) == false) goto L9;
        Integer r2 = r1.getHeight();
        if (r2 != null) goto L10;
        return 0;
    L10:
        return r2.intValue();
    L9:
        return r1.getOutVideoHeight();
    }

    public static final int c(MediaDownloadExecutor r0, MediaInfo r1) {
        r0.getClass();
        if (j.a(g(r1.getMediaType())) == false) goto L9;
        Integer r2 = r1.getWidth();
        if (r2 != null) goto L10;
        return 0;
    L10:
        return r2.intValue();
    L9:
        return r1.getOutVideoWidth();
    }

    public final Object k(MediaMetadata r32, Continuation<? super Boolean> r33) {
        if ((r33 instanceof MediaDownloadExecutor$recoverDownloadedArchive$1) == false) goto L7;
        MediaDownloadExecutor$recoverDownloadedArchive$1 r1 = (MediaDownloadExecutor$recoverDownloadedArchive$1) r33;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MediaDownloadExecutor$recoverDownloadedArchive$1 r6 = r1;
        Object r0 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        MediaMetadata r4 = (MediaMetadata) r6.L$0;
        ResultKt.throwOnFailure(r0);
    L103:
        boolean r5 = ((Boolean) r0).booleanValue();
        if (r5 == false) goto L107;
        FLogger.a.i("MediaDownloadExecutor", "[Recovery] Recovered downloaded archive and enqueued processing: " + r4.getUniqId());
    L107:
        return Boxing.boxBoolean(r5);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        int r7 = j.a;
        if (j.b(r32.getMediaType()) == false) goto L17;
        com.larus.avlink.gallery.processor.e r9 = this.f;
        String r10 = r32.getUniqId();
        String r11 = r32.getDownloadFilePath();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "uniqId");
        ArrayList r12 = new ArrayList();
        if (r11 == null) goto L21;
        r12.add(new PolarisFileWrapper(r11));
        r12.add(new PolarisFileWrapper(r11.concat(".tp")));
    L21:
        com.larus.avlink.gallery.e.a.getClass();
        File[] r13 = com.larus.avlink.gallery.e.c().listFiles();
        int r14 = com.larus.avlink.gallery.processor.e.a;
        if (r13 == null) goto L44;
        int r15 = r13.length;
        int r16 = 0;
    L24:
        if (r16 >= r15) goto L44;
        File r17 = r13[r16];
        if (r17.isFile() == true) goto L28;
    L40:
        boolean r18 = false;
    L41:
        if (r18 == false) goto L43;
        r12.add(r17);
    L43:
        r16 = r16 + 1;
        goto L24
    L28:
        if (StringsKt.contains$default(r17.getName(), "_" + r10 + '_', false, 2, null) == false) goto L40;
        String r19 = r17.getName();
        if (com.larus.avlink.gallery.processor.e.a.a(r19) == false) goto L32;
    L37:
        boolean r20 = true;
    L38:
        if (r20 == false) goto L40;
        r18 = true;
        goto L41
    L32:
        if (StringsKt.endsWith$default(r19, ".tp", false, 2, null) == true) goto L34;
    L36:
        r20 = false;
        goto L38
    L34:
        if (com.larus.avlink.gallery.processor.e.a.a(StringsKt.removeSuffix(r19, ".tp")) == false) goto L36;
    L44:
        HashSet r21 = new HashSet();
        ArrayList r22 = new ArrayList();
        Iterator r23 = r12.iterator();
    L46:
        if (r23.hasNext() == false) goto L50;
        Object r24 = r23.next();
        if (r21.add(((File) r24).getAbsolutePath()) == false) goto L46;
        r22.add(r24);
        goto L46
    L50:
        Iterator r25 = r22.iterator();
        File r26 = null;
    L52:
        if (r25.hasNext() == false) goto L93;
        File r27 = (File) r25.next();
        if (r27.exists() == true) goto L56;
    L80:
        Object r28 = com.larus.avlink.gallery.processor.e.b.C0009b.a;
    L82:
        if ((r28 instanceof com.larus.avlink.gallery.processor.e.b.c) == true) goto L98;
        if ((r28 instanceof com.larus.avlink.gallery.processor.e.b.a) == true) goto L86;
        if (Intrinsics.areEqual(r28, com.larus.avlink.gallery.processor.e.b.C0009b.a) == true) goto L52;
        throw new NoWhenBranchMatchedException();
    L86:
        if (r26 != null) goto L52;
        r26 = ((com.larus.avlink.gallery.processor.e.b.a) r28).a;
    L98:
        if ((r28 instanceof com.larus.avlink.gallery.processor.e.b.c) == false) goto L109;
        File r29 = ((com.larus.avlink.gallery.processor.e.b.c) r28).a;
        FLogger.a.i("MediaDownloadExecutor", "[Recovery] Found downloaded archive for DOWNLOAD state: " + r29.getAbsolutePath());
        String r30 = r29.getAbsolutePath();
        String r31 = r29.getName();
        String r34 = r32.getUniqId();
        MediaInfo r35 = new MediaInfo(Long.valueOf(r32.getMediaId()), r32.getMediaType(), null, null, Integer.valueOf(r32.getWidth()), Integer.valueOf(r32.getHeight()), r32.getOutVideoWidth(), r32.getOutVideoHeight(), r32.getOutputVideoCrop(), r32.getFileSize(), Long.valueOf(r32.getDuration()), null, Long.valueOf(r32.getCreateTime()), r29.getName(), null, null, null, 116748, null);
        r6.L$0 = r32;
        r6.label = 1;
        r0 = f(r30, r31, r34, r35, true, r6);
        if (r0 != r8) goto L102;
        return r8;
    L102:
        r4 = r32;
        goto L103
    L109:
        if ((r28 instanceof com.larus.avlink.gallery.processor.e.b.a) == false) goto L113;
        FLogger.a.w("MediaDownloadExecutor", "[Recovery] Archive download is not complete, keep DOWNLOAD state for retry: " + r32.getUniqId() + ", file=" + ((com.larus.avlink.gallery.processor.e.b.a) r28).a.getAbsolutePath());
        return Boxing.boxBoolean(false);
    L113:
        if (Intrinsics.areEqual(r28, com.larus.avlink.gallery.processor.e.b.C0009b.a) == false) goto L117;
        FLogger.a.w("MediaDownloadExecutor", "[Recovery] No downloaded archive found for DOWNLOAD state: " + r32.getUniqId());
        return Boxing.boxBoolean(false);
    L117:
        throw new NoWhenBranchMatchedException();
    L56:
        if (r27.isFile() == false) goto L80;
        if (com.larus.avlink.gallery.processor.e.a.a(r27.getName()) == false) goto L65;
        if (com.larus.avlink.gallery.processor.e.e(r27, r27.getName()) == false) goto L63;
        r28 = new com.larus.avlink.gallery.processor.e.b.c(r27);
        goto L82
    L63:
        r28 = new com.larus.avlink.gallery.processor.e.b.a(r27);
        goto L82
    L65:
        if (StringsKt.endsWith$default(r27.getName(), ".tp", false, 2, null) == true) goto L67;
        r28 = com.larus.avlink.gallery.processor.e.b.C0009b.a;
        goto L82
    L67:
        String r36 = StringsKt.removeSuffix(r27.getName(), ".tp");
        if (com.larus.avlink.gallery.processor.e.a.a(r36) == true) goto L71;
        r28 = com.larus.avlink.gallery.processor.e.b.C0009b.a;
        goto L82
    L71:
        if (StringsKt.endsWith(r36, ".zip", true) == true) goto L73;
    L79:
        r28 = new com.larus.avlink.gallery.processor.e.b.a(r27);
        goto L82
    L73:
        if (com.larus.avlink.gallery.processor.e.e(r27, r36) == false) goto L79;
        PolarisFileWrapper r37 = new PolarisFileWrapper(r27.getParentFile(), r36);
        if (r27.renameTo(r37) == true) goto L78;
        FLogger.a.w("DownloadArchiveProcessor", "Failed to promote temp archive download: " + r27.getAbsolutePath());
        r28 = new com.larus.avlink.gallery.processor.e.b.a(r27);
        goto L82
    L78:
        FLogger.a.i("DownloadArchiveProcessor", "Promoted temp archive download: " + r37.getAbsolutePath());
        r28 = new com.larus.avlink.gallery.processor.e.b.c(r37);
        goto L82
    L93:
        if (r26 == null) goto L95;
        Object r38 = new com.larus.avlink.gallery.processor.e.b.a(r26);
    L96:
        r28 = r38;
        goto L98
    L95:
        r38 = com.larus.avlink.gallery.processor.e.b.C0009b.a;
        goto L96
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r1 = new MediaDownloadExecutor$recoverDownloadedArchive$1(this, r33);
        goto L8
    }

    public final Job n(Context r15, MediaInfo r16, MediaSyncCoordinator.SyncMode r17) {
        return BuildersKt.launch$default(this.a, Dispatchers.getIO().plus(new d(CoroutineExceptionHandler.Key)), null, new MediaDownloadExecutor$saveMediaInternal$1(this, r15, r16, AppHost.a.getApplication().getFilesDir().getAbsolutePath() + File.separator + "doraG/" + IApplog.a.getUserID() + '/', r17, null), 2, null);
    }

    public static void j(MediaMetadata r32, String r33, String r34, String r35) {
        int r0 = com.larus.avlink.gallery.processor.e.a;
        if (com.larus.avlink.gallery.processor.e.a.a(r34) == true) goto L5;
        return;
    L5:
        MediaMetadata r1 = MediaMetadata.copy$default(r32, null, 0, null, r34, null, null, 0, 0, 0, 0, 0, 0.0d, 0, null, null, null, null, null, r33, null, null, null, null, 0, 16515063, null);
        AlbumDataBaseHelper.a.getClass();
        AlbumDataBaseHelper.A(r1);
        FLogger.a.i("MediaDownloadExecutor", "Persisted " + r35 + " archive target for recovery: " + r32.getUniqId() + ", path=" + r33);
    }

    public static final Object d(MediaDownloadExecutor r7, Context r8, MediaInfo r9, MediaSyncCoordinator.SyncMode r10, Continuation r11) {
        r7.getClass();
        if ((r11 instanceof MediaDownloadExecutor$realSaveMedia$1) == false) goto L7;
        MediaDownloadExecutor$realSaveMedia$1 r0 = (MediaDownloadExecutor$realSaveMedia$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MediaDownloadExecutor$realSaveMedia$1 r6 = r0;
        Object r12 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L44:
        String r13 = (String) r12;
        if (r13 != null) goto L48;
        return TuplesKt.to(Boxing.boxInt(2001), "");
    L48:
        return TuplesKt.to(Boxing.boxInt(0), r13);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        String r14 = r9.getMediaType();
        if (r14 != null) goto L17;
        r14 = "image";
    L17:
        String r15 = j.d(r14);
        switch(r15.hashCode()) {
            case -1617978531: goto L36;
            case -1442901379: goto L33;
            case 100313435: goto L31;
            case 112202875: goto L28;
            case 1210380575: goto L24;
            case 1333277997: goto L21;
            default: goto L40;
        };
    L31:
        r15.equals("image");
    L40:
        String r16 = ".jpeg";
    L39:
        String r4 = r16;
        r6.label = 1;
        r12 = r7.m(r8, r9, r4, r10, r6);
        if (r12 != r2) goto L44;
        return r2;
    L21:
        if (r15.equals("video_mp4") == false) goto L40;
    L30:
        r16 = ".mp4";
        goto L39
    L24:
        if (r15.equals("live_photo") == false) goto L40;
        r16 = ".zip";
        goto L39
    L28:
        if (r15.equals("video") == true) goto L30;
    L33:
        if (r15.equals("image_pack") == false) goto L40;
    L38:
        r16 = ".pack";
        goto L39
    L36:
        if (r15.equals("video_pack") == true) goto L38;
    L7:
        r0 = new MediaDownloadExecutor$realSaveMedia$1(r7, r11);
        goto L8
    }

    public final Object m(Context r66, MediaInfo r67, String r68, MediaSyncCoordinator.SyncMode r69, Continuation<? super String> r70) {
        if ((r70 instanceof MediaDownloadExecutor$saveMediaFile$1) == false) goto L7;
        MediaDownloadExecutor$saveMediaFile$1 r1 = (MediaDownloadExecutor$saveMediaFile$1) r70;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MediaDownloadExecutor$saveMediaFile$1 r15 = r1;
        Object r0 = r15.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r15.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        String r4 = (String) r15.L$14;
        Map r5 = (Map) r15.L$13;
        IDoraService.j r6 = (IDoraService.j) r15.L$12;
        MediaMetadata r7 = (MediaMetadata) r15.L$11;
        File r8 = (File) r15.L$10;
        String r9 = (String) r15.L$9;
        Long r10 = (Long) r15.L$8;
        String r11 = (String) r15.L$7;
        String r12 = (String) r15.L$6;
        String r14 = (String) r15.L$5;
        String r16 = (String) r15.L$4;
        String r17 = (String) r15.L$3;
        String r18 = (String) r15.L$2;
        MediaInfo r19 = (MediaInfo) r15.L$1;
        Context r20 = (Context) r15.L$0;
        ResultKt.throwOnFailure(r0);
    L154:
        return r0;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r110 = r15.J$2;
        long r21 = r15.J$1;
        String r111 = "";
        long r22 = r15.J$0;
        MediaMetadata r23 = (MediaMetadata) r15.L$12;
        File r24 = (File) r15.L$11;
        String r25 = (String) r15.L$10;
        Long r26 = (Long) r15.L$9;
        String r112 = (String) r15.L$8;
        String r27 = (String) r15.L$7;
        String r28 = (String) r15.L$6;
        String r29 = (String) r15.L$5;
        String r30 = (String) r15.L$4;
        MediaSyncCoordinator.SyncMode r31 = (MediaSyncCoordinator.SyncMode) r15.L$3;
        String r32 = (String) r15.L$2;
        MediaInfo r33 = (MediaInfo) r15.L$1;
        Context r34 = (Context) r15.L$0;
        ResultKt.throwOnFailure(r0);
        String r35 = r28;
        Context r113 = r34;
        String r210 = "MediaDownloadExecutor";
        long r57 = r110;
        MediaSyncCoordinator.SyncMode r36 = r31;
        MediaInfo r114 = r33;
        IDoraService.j r115 = null;
        File r116 = r24;
        String r37 = r27;
        MediaMetadata r610 = r23;
        Object r211 = r13;
        String r38 = r30;
        long r212 = r21;
        Long r117 = r26;
        String r39 = r112;
        String r118 = r29;
        final String r40 = r25;
        String r41 = r32;
    L114:
        MediaLifecycleState r42 = r610.getLifecycleState();
        final long r213 = r22;
        Function2<? super String, ? super MediaLifecycleState, Unit> r43 = this.i;
        if (r43 == null) goto L117;
        r43.invoke(r40, r42);
    L117:
        FLogger.a.i(r210, "Created metadata for media: " + r40 + " with state DOWNLOAD");
        IDoraService r44 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r44 == null) goto L120;
        IDoraService.j r45 = r44.S();
    L121:
        if (r45 == null) goto L124;
        Map r46 = r45.f();
        if (r46 == null) goto L124;
    L125:
        Map r214 = r46;
        IDoraService r47 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r47 == null) goto L133;
        VisionService r48 = r47.V();
        if (r48 == null) goto L133;
        String r49 = r48.w(r36.getValue());
        if (r49 == null) goto L133;
        String r50 = r49;
    L134:
        r15.L$0 = r113;
        r15.L$1 = r114;
        r15.L$2 = r41;
        r15.L$3 = r38;
        r15.L$4 = r118;
        r15.L$5 = r35;
        r15.L$6 = r37;
        r15.L$7 = r39;
        r15.L$8 = r117;
        r15.L$9 = r40;
        r15.L$10 = r116;
        final MediaMetadata r51 = r610;
        r15.L$11 = r51;
        r15.L$12 = r45;
        r15.L$13 = r214;
        r15.L$14 = r50;
        final String r119 = r39;
        r15.J$0 = r213;
        r15.J$1 = r212;
        final long r52 = r57;
        r15.J$2 = r52;
        r15.label = 4;
        final kotlinx.coroutines.j r53 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r15), 1);
        r53.C();
        final String r120 = r35 + '_' + r40 + "_0_" + r114.getDuration() + '_' + r114.getHeight() + '_' + r114.getWidth() + '_' + r117 + '_' + r37 + r41;
        j(r51, new PolarisFileWrapper(r116, r120).getAbsolutePath(), r120, "pending");
        if (r45 != null) goto L137;
    L139:
        boolean r54 = false;
    L140:
        DownloadTask r55 = Downloader.with(r113).url(r38);
        ArrayList r56 = new ArrayList(r214.size());
        Iterator r58 = r214.entrySet().iterator();
    L142:
        if (r58.hasNext() == false) goto L144;
        Map.Entry r59 = (Map.Entry) r58.next();
        r56.add(new HttpHeader((String) r59.getKey(), (String) r59.getValue()));
        goto L142
    L144:
        DownloadTask r60 = r55.extraHeaders(r56).savePath(r116.getAbsolutePath()).ttnetByPassProxy(true).name(r120).forceWifiBound(r54);
        if (r54 == false) goto L147;
        JSONObject r61 = new JSONObject();
        r61.put("net_lib_strategy", 1);
    L148:
        DownloadTask r121 = r60.downloadSetting(r61);
        final long r63 = r212;
        final String r62 = r50;
        final String r64 = r118;
        final MediaInfo r65 = r114;
        Object r122 = r211;
        DownloadTask r71 = r121.subThreadListener(new MediaDownloadExecutor$saveMediaFile$2$task$3(r62, r63, this, r40, r64, r213, r65, r120, r51, r53, r119, r52));
        r53.i(new c(r71, r113));
        r71.asyncDownload(null);
        r0 = r53.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L152;
        DebugProbesKt.probeCoroutineSuspended(r15);
    L152:
        if (r0 != r122) goto L154;
        return r122;
    L147:
        r61 = new JSONObject();
        goto L148
    L137:
        if (r45.h() != true) goto L139;
        r54 = true;
    L133:
        r50 = r111;
    L124:
        r46 = MapsKt.emptyMap();
        goto L125
    L120:
        r45 = r115;
        goto L121
    L18:
        r111 = "";
        long r72 = r15.J$2;
        long r73 = r15.J$1;
        long r74 = r15.J$0;
        File r75 = (File) r15.L$12;
        String r123 = (String) r15.L$11;
        Long r124 = (Long) r15.L$10;
        String r125 = (String) r15.L$9;
        String r76 = (String) r15.L$8;
        String r77 = (String) r15.L$7;
        String r78 = (String) r15.L$6;
        String r79 = (String) r15.L$5;
        String r80 = (String) r15.L$4;
        MediaSyncCoordinator.SyncMode r81 = (MediaSyncCoordinator.SyncMode) r15.L$3;
        String r82 = (String) r15.L$2;
        MediaInfo r83 = (MediaInfo) r15.L$1;
        Context r84 = (Context) r15.L$0;
        ResultKt.throwOnFailure(r0);
        String r310 = r79;
        long r510 = r74;
        r210 = "MediaDownloadExecutor";
        String r126 = r125;
        r115 = null;
        r38 = r80;
        r118 = r78;
        r37 = r76;
        String r611 = r123;
        Object r127 = r13;
        String r85 = r77;
        Context r86 = r84;
        long r612 = r73;
        r117 = r124;
        r41 = r82;
        MediaInfo r87 = r83;
        MediaSyncCoordinator.SyncMode r88 = r81;
        r116 = r75;
        long r89 = r72;
    L91:
        ThumbnailMetadata r90 = (ThumbnailMetadata) r0;
        Integer r215 = r87.getWidth();
        if (r215 == null) goto L94;
        int r311 = r215.intValue();
    L95:
        Integer r216 = r87.getHeight();
        if (r216 == null) goto L98;
        int r312 = r216.intValue();
    L99:
        Number r217 = r87.getDuration();
        if (r217 != null) goto L102;
        r217 = Boxing.boxDouble(0.0d);
    L102:
        long r313 = r217.longValue();
        if (r117 == null) goto L105;
        long r218 = r117.longValue();
    L106:
        long r410 = r218;
        MediaLifecycleState r411 = MediaLifecycleState.DOWNLOAD;
        double r314 = r87.getOutputVideoCrop();
        int r315 = r87.getOutVideoHeight();
        int r316 = r87.getOutVideoWidth();
        if (r90 == null) goto L109;
        IDoraService.j r412 = r90.getGeoLocationInfo();
    L110:
        MediaMetadata r91 = new MediaMetadata(r611, r89, null, "", Boxing.boxLong(r612), r310, r311, r312, r313, r316, r315, r314, r410, r412, r85, r411, null, null, null, null, null, null, null, 0, 16711684, null);
        Object r219 = r127;
        AlbumDataBaseHelper r128 = AlbumDataBaseHelper.a;
        r15.L$0 = r86;
        r15.L$1 = r87;
        r15.L$2 = r41;
        r15.L$3 = r88;
        r15.L$4 = r38;
        r15.L$5 = r118;
        r15.L$6 = r85;
        r15.L$7 = r37;
        r15.L$8 = r126;
        r15.L$9 = r117;
        MediaInfo r613 = r87;
        String r92 = r611;
        r15.L$10 = r92;
        r15.L$11 = r116;
        r15.L$12 = r91;
        String r614 = r85;
        long r93 = r510;
        r15.J$0 = r93;
        long r94 = r612;
        r15.J$1 = r94;
        r15.J$2 = r89;
        r15.label = 3;
        if (r128.h(r91, r15) != r219) goto L113;
        return r219;
    L113:
        r610 = r91;
        r36 = r88;
        r57 = r89;
        r211 = r219;
        r39 = r126;
        r40 = r92;
        r22 = r93;
        r212 = r94;
        r35 = r614;
        r114 = r613;
        r113 = r86;
        goto L114
    L109:
        r412 = r115;
        goto L110
    L105:
        r218 = System.currentTimeMillis();
        goto L106
    L98:
        r312 = 0;
        goto L99
    L94:
        r311 = 0;
        goto L95
    L19:
        r111 = "";
        long r95 = r15.J$2;
        long r96 = r15.J$1;
        long r97 = r15.J$0;
        String r99 = (String) r15.L$11;
        Long r129 = (Long) r15.L$10;
        String r130 = (String) r15.L$9;
        String r131 = (String) r15.L$8;
        String r100 = (String) r15.L$7;
        String r101 = (String) r15.L$6;
        String r102 = (String) r15.L$5;
        String r103 = (String) r15.L$4;
        MediaSyncCoordinator.SyncMode r104 = (MediaSyncCoordinator.SyncMode) r15.L$3;
        String r105 = (String) r15.L$2;
        MediaInfo r106 = (MediaInfo) r15.L$1;
        Context r107 = (Context) r15.L$0;
        ResultKt.throwOnFailure(r0);
        String r132 = r100;
        String r133 = "MediaDownloadExecutor";
        Long r220 = r129;
        String r317 = r131;
        String r108 = r101;
        r38 = r103;
        String r134 = r102;
        String r615 = r130;
        long r135 = r96;
        MediaSyncCoordinator.SyncMode r109 = r104;
        String r136 = r105;
        Object r137 = r0;
        Context r138 = r107;
        long r139 = r97;
        r89 = r95;
        MediaInfo r221 = r106;
        Object r222 = r13;
        String r140 = r99;
    L74:
        MediaMetadata r141 = (MediaMetadata) r137;
        if (r141 != null) goto L77;
        r115 = null;
    L87:
        com.larus.avlink.gallery.e.a.getClass();
        File r142 = com.larus.avlink.gallery.e.c();
        r142.mkdirs();
        r210 = r133;
        AlbumDataBaseHelper r143 = AlbumDataBaseHelper.a;
        r15.L$0 = r138;
        Context r223 = r138;
        r15.L$1 = r221;
        r15.L$2 = r136;
        r15.L$3 = r109;
        r15.L$4 = r38;
        r15.L$5 = r134;
        r15.L$6 = r108;
        r15.L$7 = r132;
        r15.L$8 = r317;
        String r144 = r615;
        r15.L$9 = r144;
        String r616 = r136;
        Long r145 = r220;
        r15.L$10 = r145;
        r15.L$11 = r140;
        r15.L$12 = r142;
        r15.J$0 = r139;
        r15.J$1 = r135;
        r15.J$2 = r89;
        long r617 = r139;
        r15.label = 2;
        Object r146 = r143.w(r89, r144, r15);
        r127 = r222;
        if (r146 != r127) goto L90;
        return r127;
    L90:
        r510 = r617;
        r126 = r144;
        r0 = r146;
        r611 = r140;
        r87 = r221;
        r85 = r132;
        r310 = r134;
        r117 = r145;
        r86 = r223;
        MediaSyncCoordinator.SyncMode r618 = r109;
        r41 = r616;
        r612 = r135;
        r116 = r142;
        r118 = r108;
        r37 = r317;
        r88 = r618;
        goto L91
    L77:
        if (r141.getLifecycleState() != MediaLifecycleState.DOWNLOAD) goto L79;
    L85:
        r115 = null;
        goto L87
    L79:
        if (r141.getLifecycleState() == MediaLifecycleState.FAILED) goto L85;
        FLogger.a.i(r133, "Media already exists: " + r140 + " (state: " + r141.getLifecycleState() + ')');
        MediaLifecycleState r147 = r141.getLifecycleState();
        Function2<? super String, ? super MediaLifecycleState, Unit> r148 = this.i;
        if (r148 == null) goto L83;
        r148.invoke(r140, r147);
    L83:
        i(0, r135, r108, System.currentTimeMillis() - r139, 0, String.valueOf(r89), r615);
        return null;
    L20:
        r111 = "";
        ResultKt.throwOnFailure(r0);
        String r149 = r67.getDownloadUrl();
        if (r149 != null) goto L24;
        return null;
    L24:
        String r150 = r149 + "&uuid=" + UUID.randomUUID();
        long r151 = System.currentTimeMillis();
        Long r152 = r67.getSize();
        if (r152 == null) goto L27;
        long r153 = r152.longValue();
    L28:
        r134 = g(r67.getMediaType());
        if (j.a(r134) == false) goto L31;
        String r154 = "photo";
    L32:
        String r155 = r154;
        String r156 = r67.getMediaName();
        if (r156 == null) goto L36;
        String r157 = StringsKt.substringBefore$default(r156, "_", null, 2, null);
        if (r157 == null) goto L36;
    L37:
        String r158 = r157;
        String r159 = r67.getMediaName();
        if (r159 != null) goto L40;
        r133 = "MediaDownloadExecutor";
        String r160 = null;
    L46:
        IDoraService r161 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r161 == null) goto L51;
        DeviceService r162 = r161.device();
        if (r162 == null) goto L51;
        String r163 = r162.m();
    L52:
        Long r164 = r67.getCreateTime();
        if (r164 == null) goto L55;
        long r224 = r164.longValue();
    L57:
        if (r224 >= 1735660800000L) goto L59;
        Long r165 = Boxing.boxLong(System.currentTimeMillis());
    L60:
        Long r166 = r67.getMediaId();
        if (r166 == null) goto L63;
        long r167 = r166.longValue();
    L70:
        StringBuilder r168 = new StringBuilder();
        r168.append(r167);
        r168.append('_');
        r168.append(r165);
        String r169 = r168.toString();
        AlbumDataBaseHelper r170 = AlbumDataBaseHelper.a;
        r15.L$0 = r66;
        r15.L$1 = r67;
        r15.L$2 = r68;
        r15.L$3 = r69;
        r15.L$4 = r150;
        r15.L$5 = r134;
        r15.L$6 = r155;
        r15.L$7 = r158;
        r15.L$8 = r160;
        r15.L$9 = r163;
        r15.L$10 = r165;
        r15.L$11 = r169;
        r15.J$0 = r151;
        r15.J$1 = r153;
        r15.J$2 = r167;
        long r225 = r167;
        r15.label = 1;
        Object r171 = r170.o(r169, r15);
        if (r171 != r13) goto L73;
        return r13;
    L73:
        r221 = r67;
        r317 = r160;
        r108 = r155;
        r220 = r165;
        r132 = r158;
        r38 = r150;
        r139 = r151;
        r136 = r68;
        r109 = r69;
        r138 = r66;
        r615 = r163;
        r137 = r171;
        r140 = r169;
        r135 = r153;
        r89 = r225;
        r222 = r13;
        goto L74
    L63:
        String r172 = UriProtector.getQueryParameter(UriProtector.parse(r149), "id");
        if (r172 == null) goto L66;
        Long r173 = StringsKt.toLongOrNull(r172);
    L67:
        if (r173 == null) goto L69;
        r167 = r173.longValue();
        goto L70
    L69:
        r167 = 0;
        goto L70
    L66:
        r173 = null;
        goto L67
    L59:
        r165 = r67.getCreateTime();
        goto L60
    L55:
        r224 = 0;
    L51:
        r163 = r111;
        goto L52
    L40:
        r133 = "MediaDownloadExecutor";
        MatchResult r174 = Regex.find$default(new Regex("_([^_]+)\\.(?:pack|zip)$"), r159, 0, 2, null);
        if (r174 == null) goto L45;
        List r175 = r174.getGroupValues();
        if (r175 == null) goto L45;
        r160 = (String) ListProtector.get(r175, 1);
    L45:
        r160 = null;
    L36:
        r157 = "media";
        goto L37
    L31:
        r154 = "video";
        goto L32
    L27:
        r153 = 0;
    L7:
        r1 = new MediaDownloadExecutor$saveMediaFile$1(this, r70);
        goto L8
    }

    public final Object f(String r9, String r10, String r11, MediaInfo r12, boolean r13, Continuation<? super Boolean> r14) {
        if ((r14 instanceof MediaDownloadExecutor$completeArchiveDownload$1) == false) goto L7;
        MediaDownloadExecutor$completeArchiveDownload$1 r0 = (MediaDownloadExecutor$completeArchiveDownload$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MediaDownloadExecutor$completeArchiveDownload$1 r5 = r0;
        Object r15 = r5.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r5.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r13 = r5.Z$0;
        r11 = (String) r5.L$0;
        ResultKt.throwOnFailure(r15);
    L29:
        this.b.a(r11, r13);
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        com.larus.avlink.gallery.processor.e r16 = this.f;
        String r4 = r12.getMediaType();
        this.f.getClass();
        Intrinsics.checkNotNullParameter(r10, "fileName");
        if (StringsKt.endsWith(r10, ".zip", true) == true) goto L17;
    L21:
        boolean r6 = false;
    L22:
        r16.getClass();
        final com.larus.avlink.gallery.processor.e.c r17 = com.larus.avlink.gallery.processor.e.f(r9, r10, r11, r12, r6);
        if (r17 == null) goto L25;
        FLogger.a.i("MediaDownloadExecutor", "Found displayable file: " + r17.a);
        MediaLifecycleStateManager r7 = this.c;
        MediaLifecycleState r8 = MediaLifecycleState.DOWNLOADED_TEMP;
        Function1 r18 = new com.larus.avlink.gallery.executor.a(r17);
        r5.L$0 = r11;
        r5.Z$0 = r13;
        r5.label = 1;
        if (MediaLifecycleStateManager.g(r7, r11, r8, r18, r5, 8) != r2) goto L29;
        return r2;
    L25:
        return Boxing.boxBoolean(false);
    L17:
        if (Intrinsics.areEqual(j.d(r4), "live_photo") == false) goto L19;
    L20:
        r6 = true;
        goto L22
    L19:
        if (j.b(r4) == false) goto L21;
    L7:
        r0 = new MediaDownloadExecutor$completeArchiveDownload$1(this, r14);
        goto L8
    }

    public final void i(int r17, long r18, String r20, long r21, int r23, String r24, String r25) {
        n1.d("MediaDownloadExecutor", "onDownloadEnd. id: " + r24 + ", status: " + r17 + ", errorCode: " + r23 + ", sn: " + r25);
        GalleryMobHelper.a.getClass();
        Intrinsics.checkNotNullParameter(r20, "mediaType");
        GalleryMobHelper.i("flow_gallery_single_preview_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("task_id", GalleryMobHelper.a()), TuplesKt.to("status", Integer.valueOf(r17)), TuplesKt.to("error_code", Integer.valueOf(r23)), TuplesKt.to("media_size", Long.valueOf(r18)), TuplesKt.to("media_type", r20), TuplesKt.to("retry_time", 0), TuplesKt.to("duration", Long.valueOf(r21))}));
        if (r17 != 0) goto L5;
        BuildersKt.launch$default(this.a, Dispatchers.getIO(), null, new MediaDownloadExecutor$deleteThumbnail$1(r24, r25, null), 2, null);
    L5:
        com.larus.avlink.gallery.processor.a r5 = this.m;
        monitor-enter(r5);
        com.larus.avlink.gallery.processor.a r7 = this.m;     // Catch: Throwable -> L19
        r7.a += r18;     // Catch: Throwable -> L19
        if (r17 == 0) goto L10;
    L13:
        monitor-exit(r5);
        String r2 = this.l;
        if (r2 != null) goto L17;
        n1.d("MediaDownloadExecutor", "onDownloadEnd, host is null. id: " + r24 + ", status: " + r17 + ", errorCode: " + r23);
        return;
    L17:
        BuildersKt.launch$default(this.a, Dispatchers.getIO(), null, new MediaDownloadExecutor$onDownloadEnd$2(r2, r24, this, null), 2, null);
        return;
    L10:
        if (Intrinsics.areEqual(r20, "photo") == false) goto L12;
        r7.d++;     // Catch: Throwable -> L19
        goto L13
    L12:
        r7.e++;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void h(MediaDownloadExecutor r2, long r3, String r5, int r6, int r7, long r8, int r10, int r11, long r12) {
        r2.getClass();
        GalleryMobHelper.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "mediaType");
        GalleryMobHelper.i("flow_gallery_single_task_end", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("task_id", GalleryMobHelper.a()), TuplesKt.to("status", Integer.valueOf(r6)), TuplesKt.to("error_code", Integer.valueOf(r7)), TuplesKt.to("media_size", Long.valueOf(r3)), TuplesKt.to("media_type", r5), TuplesKt.to("retry_time", 0), TuplesKt.to("duration", Long.valueOf(r8)), TuplesKt.to("width", Integer.valueOf(r10)), TuplesKt.to("height", Integer.valueOf(r11)), TuplesKt.to("media_duration", Long.valueOf(r12))}));
    }
}
