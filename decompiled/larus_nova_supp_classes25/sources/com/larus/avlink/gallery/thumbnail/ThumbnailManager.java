package com.larus.avlink.gallery.thumbnail;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.e.DoraImageManager;
import com.larus.avlink.gallery.compat.ThumbnailMetadataHelper;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.MediaInfo;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ThumbnailManager {
    public static final ThumbnailManager a = null;
    public static final Lazy b = null;
    public static Job c;
    public static final AtomicBoolean d = null;
    public static final ConcurrentLinkedQueue<MediaInfo> e = null;
    public static boolean f;
    public static final ConcurrentLinkedQueue<MediaInfo> g = null;
    public static final MutableSharedFlow<Integer> h = null;
    public static final MutableSharedFlow i = null;
    public static int j;
    public static int k;
    public static final CopyOnWriteArrayList<a> l = null;
    public static int m;
    public static Function0<Boolean> n;
    public static final AtomicBoolean o = null;
    public static ThumbnailManager$init$protocolInfoCb$1 p;
    public static k0 q;
    public static p0 r;
    public static n0 s;
    public static q0 t;

    public ThumbnailManager() {
    }

    public static final boolean b() {
        if (b98.b.b(1) == false) goto L5;
        return true;
    L5:
        if (b98.b.b(5) == false) goto L7;
        return true;
    L7:
        if (b98.b.b(4) == false) goto L9;
        return true;
    L9:
        if (b98.b.b(7) == false) goto L11;
        return true;
    L11:
        if (ArraysKt.contains(new Integer[]{1, 2}, Integer.valueOf(m)) == true) goto L19;
        return false;
    L19:
        return true;
    }

    static {
        a = new ThumbnailManager();
        b = LazyKt.lazy(new j0());
        d = new AtomicBoolean(false);
        e = new ConcurrentLinkedQueue();
        g = new ConcurrentLinkedQueue();
        MutableSharedFlow<Integer> r0 = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        h = r0;
        i = r0;
        l = new CopyOnWriteArrayList();
        o = new AtomicBoolean(false);
    }

    public static IDoraService k() {
        return (IDoraService) b.getValue();
    }

    public static PolarisFileWrapper m() {
        String r0 = AppHost.a.getApplication().getFilesDir().getAbsolutePath();
        String r1 = AccountService.a.getUserId();
        StringBuilder r3 = new StringBuilder("doraG");
        String r4 = File.separator;
        r3.append(r4);
        r3.append(r1);
        r3.append(r4);
        r3.append("thumbnail");
        return new PolarisFileWrapper(r0, r3.toString());
    }

    public static void g(a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        FLogger.a.i("ThumbnailManager", "Adding album count change listener: " + r3);
        CopyOnWriteArrayList<a> r0 = l;
        if (r0.contains(r3) == true) goto L6;
        r0.add(r3);
        r3.a(j, k);
        return;
    }

    public static String l(String r4) {
        String r5 = com.larus.avlink.gallery.j.e(r4);
        int r0 = r5.hashCode();
        if (r0 == (-1617978531)) goto L14;
        if (r0 != 100313435) goto L7;
        r5.equals("image");
    L16:
        return "image";
    L7:
        if (r0 != 112202875) goto L16;
        if (r5.equals("video") == false) goto L16;
        return "video";
    L14:
        if (r5.equals("video_pack") == false) goto L16;
        return "video";
    }

    public static boolean o(MediaInfo r5) {
        Byte[] r6 = r5.getThumbnailTypes();
        if (r6 == null) goto L33;
        int r1 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L14;
        if (r6[r2].byteValue() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L12;
        r2 = r2 + 1;
        goto L6
    L12:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L34;
        int r7 = r6.length;
        int r8 = 0;
    L17:
        if (r8 >= r7) goto L25;
        if (r6[r8].byteValue() != 1) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == true) goto L23;
        r8 = r8 + 1;
        goto L17
    L23:
        boolean r10 = true;
    L26:
        if (r10 == false) goto L35;
        return true;
    L35:
        return false;
    L21:
        r9 = false;
        goto L22
    L25:
        r10 = false;
        goto L26
    L34:
        return false;
    L10:
        r4 = false;
        goto L11
    L14:
        r3 = false;
        goto L15
    L33:
        return false;
    }

    public static void p(a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        FLogger.a.i("ThumbnailManager", "Removing album count change listener: " + r3);
        l.remove(r3);
    }

    public static void s(String r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        if (d.compareAndSet(false, true) == false) goto L5;
        FLogger.a.i("ThumbnailManager", "Starting thumbnail sync..., scene: " + r6);
        c = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ThumbnailManager$startSyncThumbnail$1(null), 3, null);
        return;
    L5:
        FLogger.a.i("ThumbnailManager", "Already syncing thumbnail, skip. scene: " + r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList] */
    public static final Object a(ThumbnailManager r5, Continuation r6) {
        r5.getClass();
        if ((r6 instanceof ThumbnailManager$getLocalThumbnailList$1) == false) goto L7;
        ThumbnailManager$getLocalThumbnailList$1 r0 = (ThumbnailManager$getLocalThumbnailList$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        r8 = new ArrayList();
        Iterator r9 = ((Iterable) r7).iterator();
    L19:
        if (r9.hasNext() == false) goto L27;
        Object r3 = r9.next();
        ThumbnailMetadata r4 = (ThumbnailMetadata) r3;
        boolean r10 = new PolarisFileWrapper(r4.getFilePath()).exists();     // Catch: Exception -> L23
    L25:
        if (r10 == false) goto L19;
        r8.add(r3);
    L23:
        e = move-exception;
        n1.c("ThumbnailManager", "local thumbnail file check exist error: " + r4.getFilePath(), e);
        r10 = false;
    L27:
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        AlbumDataBaseHelper r11 = AlbumDataBaseHelper.a;
        r0.label = 1;
        r7 = r11.n(r0);
        if (r7 != r8) goto L17;
    L7:
        r0 = new ThumbnailManager$getLocalThumbnailList$1(r5, r6);
        goto L8
    }

    public static final void c(String r10, List r11) {
        List r12 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r0.add(String.valueOf(r13.next()));
        goto L4
    L6:
        StringBuilder r14 = new StringBuilder(r10 + ": [");
        int r1 = r14.length();
        int r2 = r0.size();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L17;
        String r6 = (String) ListProtector.get(r0, r3);
        if (r3 >= (r0.size() - 1)) goto L12;
        String r7 = ", ";
    L14:
        if ((((r6.length() + r1) + r7.length()) + 1) <= 3000) goto L16;
        r14.append("...");
        FLogger r4 = FLogger.a;
        StringBuilder r8 = new StringBuilder();
        r8.append(r14);
        r8.append(']');
        r4.i("ThumbnailManager", r8.toString());
        r14 = new StringBuilder(r10 + " (cont.): [");
        r1 = r14.length();
    L16:
        r14.append(r6);
        r14.append(r7);
        r1 = r1 + (r6.length() + r7.length());
        r3 = r3 + 1;
        goto L8
    L12:
        r7 = "";
        goto L14
    L17:
        FLogger.a.i("ThumbnailManager", StringsKt.trimEnd(r14.toString(), new char[]{',', ' '}) + ']');
    }

    public static final void f(Integer r7, Integer r8) {
        int r0 = j;
        int r1 = k;
        int r2 = 0;
        if (r7 == null) goto L5;
        int r9 = r7.intValue();
    L6:
        j = r9;
        if (r8 == null) goto L9;
        r2 = r8.intValue();
    L9:
        k = r2;
        FLogger.a.i("ThumbnailManager", "Album count changed. Old: (photos=" + r0 + ", videos=" + r1 + "), New: (photos=" + j + ", videos=" + k + "). Notifying listeners...");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new ThumbnailManager$tryNotifyAlbumCountChanged$1(null), 2, null);
        return;
    L5:
        r9 = 0;
        goto L6
    }

    public static final Object d(ThumbnailManager r9, MediaInfo r10, Continuation r11) {
        r9.getClass();
        if ((r11 instanceof ThumbnailManager$processDisplayItem$1) == false) goto L7;
        ThumbnailManager$processDisplayItem$1 r0 = (ThumbnailManager$processDisplayItem$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L40:
        Serializable r13 = e.poll();
    L44:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (MediaInfo) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L35:
        byte[] r14 = (byte[]) r12;
        if (r14 == null) goto L41;
        r0.L$0 = null;
        r0.label = 2;
        if (r9.n(r14, r10, r0) != r2) goto L40;
        return r2;
    L41:
        FLogger.a.w("ThumbnailManager", "Display: Request thumbnail data failed, retry for mediaId: " + r10.getMediaId());
        ConcurrentLinkedQueue<MediaInfo> r15 = e;
        r15.poll();
        Boxing.boxBoolean(r15.offer(r10));
        goto L44
    L16:
        ResultKt.throwOnFailure(r12);
        if (Intrinsics.areEqual(r10.getHasThumbnail(), Boxing.boxBoolean(true)) == false) goto L42;
        FLogger.a.i("ThumbnailManager", "Display: hasThumbnail is true, deal with mediaId: " + r10.getMediaId());
        Byte[] r16 = r10.getThumbnailTypes();
        int r4 = 0;
        if (r16 == null) goto L32;
        int r6 = r16.length;
        int r7 = 0;
    L21:
        if (r7 >= r6) goto L29;
        if (r16[r7].byteValue() != 1) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L27;
        r7 = r7 + 1;
        goto L21
    L27:
        boolean r17 = true;
    L30:
        if (r17 != true) goto L32;
        r4 = 1;
        goto L32
    L25:
        r8 = false;
        goto L26
    L29:
        r17 = false;
    L32:
        r0.L$0 = r10;
        r0.label = 1;
        r12 = r9.q(r10, r4, r0);
        if (r12 != r2) goto L35;
        return r2;
    L42:
        FLogger.a.i("ThumbnailManager", "Display: hasThumbnail is false, skip for mediaId: " + r10.getMediaId());
        Serializable r18 = e.poll();
    L7:
        r0 = new ThumbnailManager$processDisplayItem$1(r9, r11);
        goto L8
    }

    public static final Object e(ThumbnailManager r6, MediaInfo r7, Continuation r8) {
        r6.getClass();
        if ((r8 instanceof ThumbnailManager$processUploadItem$1) == false) goto L7;
        ThumbnailManager$processUploadItem$1 r0 = (ThumbnailManager$processUploadItem$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (MediaInfo) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L19:
        byte[] r10 = (byte[]) r9;
        if (r10 == null) goto L33;
        Long r11 = r7.getMediaId();
        if (r11 == null) goto L24;
        long r4 = r11.longValue();
    L26:
        if (r4 != 0) goto L37;
        FLogger.a.e("ThumbnailManager", "Upload: Invalid imageUuid, skipping handleUploadThumbnailData.");
    L32:
        Serializable r12 = g.poll();
    L36:
        return Unit.INSTANCE;
    L37:
        t(r10, r7, r4);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        FLogger.a.e("ThumbnailManager", "Upload: Error handling thumbnail data for imageUuid=" + r4 + ": " + e.getMessage(), e);
        goto L32
    L24:
        r4 = 0;
        goto L26
    L33:
        FLogger.a.w("ThumbnailManager", "Upload: Request thumbnail data failed, retry for mediaId: " + r7.getMediaId());
        ConcurrentLinkedQueue<MediaInfo> r13 = g;
        r13.poll();
        Boxing.boxBoolean(r13.offer(r7));
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (Intrinsics.areEqual(r7.getHasThumbnail(), Boxing.boxBoolean(true)) == false) goto L34;
        FLogger.a.i("ThumbnailManager", "Upload: hasThumbnail is true, deal with mediaId: " + r7.getMediaId());
        r0.L$0 = r7;
        r0.label = 1;
        r9 = r6.q(r7, 0, r0);
        if (r9 != r2) goto L19;
        return r2;
    L34:
        FLogger.a.i("ThumbnailManager", "Upload: hasThumbnail is false, skip for mediaId: " + r7.getMediaId());
        Serializable r14 = g.poll();
    L7:
        r0 = new ThumbnailManager$processUploadItem$1(r6, r8);
        goto L8
    }

    public static void t(byte[] r23, MediaInfo r24, long r25) {
        Long r0 = r24.getCreateTime();
        if (r0 == null) goto L5;
        long r3 = r0.longValue();
    L6:
        long r5 = System.currentTimeMillis() - r3;
        boolean r4 = false;
        if (r5 > 60000) goto L20;
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L15;
        DeviceService r7 = r6.device();
        if (r7 == null) goto L15;
        if (r7.t() != 2) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L20;
        if (b98.b.b(2) == true) goto L20;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L47;
        Long r10 = r24.getMediaId();
        if (r10 != null) goto L49;
        FLogger.a.e("ThumbnailManager", "Cannot upload thumbnail, mediaId is null.");
    L46:
        FLogger.a.i("ThumbnailManager", "Triggered thumbnail upload to server: imageUuid=" + r25);
        return;
    L49:
        int r11 = (int) r10.longValue();     // Catch: Exception -> L44
        Integer r12 = r24.getWidth();     // Catch: Exception -> L44
        if (r12 == null) goto L29;
        int r13 = r12.intValue();     // Catch: Exception -> L44
    L30:
        Integer r14 = r24.getHeight();     // Catch: Exception -> L44
        if (r14 == null) goto L33;
        int r21 = r14.intValue();     // Catch: Exception -> L44
    L34:
        b49.h r15 = new b49.h(r11, r23, r13, r21, 1, 1, 0, 20, r10.longValue());     // Catch: Exception -> L44
        f98.l r22 = f98.g.b(r15, 10);     // Catch: Exception -> L44
        Map<String, com.larus.avlink.model.a> r16 = DoraImageManager.a;     // Catch: Exception -> L44
        if (DoraImageManager.a(Integer.valueOf(r11)) != null) goto L37;
        com.larus.avlink.model.a r17 = new com.larus.avlink.model.a(Integer.valueOf(r11), r13, r21, 1, 20, null, null, null, -4232, 63);     // Catch: Exception -> L44
        Intrinsics.checkNotNullParameter(r17, "model");     // Catch: Exception -> L44
        DoraImageManager.a.put(String.valueOf(r17.a), r17);     // Catch: Exception -> L44
        FLogger.a.i("ThumbnailManager", "uploadThumbnailToServer: init DoraPicModel for thumbnail upload, imageUuid=" + r10);     // Catch: Exception -> L44
    L37:
        if (r22 == null) goto L39;
        com.larus.avlink.e.l.a.b(r15, 20, CollectionsKt.listOf(r22));     // Catch: Exception -> L44
    L39:
        FLogger r1 = FLogger.a;     // Catch: Exception -> L44
        StringBuilder r18 = new StringBuilder("Called doUploadFile for thumbnail upload: imageUuid=");     // Catch: Exception -> L44
        r18.append(r10);     // Catch: Exception -> L44
        r18.append(", fileContent is null=");     // Catch: Exception -> L44
        if (r22 == null) goto L42;
        r4 = true;
    L42:
        r18.append(r4);     // Catch: Exception -> L44
        r1.i("ThumbnailManager", r18.toString());     // Catch: Exception -> L44
        goto L46
    L33:
        r21 = 0;
        goto L34
    L29:
        r13 = 0;
    L44:
        e = move-exception;
        FLogger.a.e("ThumbnailManager", "Error calling doUploadFile for imageUuid=" + r10 + ": " + e.getMessage(), e);
        goto L46
    L47:
        FLogger.a.i("ThumbnailManager", "Skip uploading thumbnail, conditions not met for imageUuid=" + r25);
        return;
    L15:
        r8 = false;
    L20:
        r9 = false;
        goto L22
    L5:
        r3 = 0;
        goto L6
    }

    public final Object h(MediaInfo r20, File r21, Continuation<? super Unit> r22) {
        if ((r22 instanceof ThumbnailManager$createMetaData$1) == false) goto L7;
        ThumbnailManager$createMetaData$1 r1 = (ThumbnailManager$createMetaData$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        ThumbnailManager$createMetaData$1 r14 = r1;
        Object r0 = r14.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r14.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r14.J$0;
        ResultKt.throwOnFailure(r0);
    L43:
        FLogger.a.i("ThumbnailManager", "Successfully created thumbnail metadata: imageUuid=" + r5);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        Long r6 = r20.getMediaId();
        long r7 = 0;
        if (r6 == null) goto L17;
        long r12 = r6.longValue();
    L18:
        ThumbnailMetadataHelper r8 = ThumbnailMetadataHelper.a;
        if (r21 == null) goto L21;
        String r9 = r21.getAbsolutePath();
    L22:
        String r10 = r20.getMediaType();
        if (r10 != null) goto L25;
        r10 = "image_pack";
    L25:
        String r11 = l(r10);
        Integer r13 = r20.getWidth();
        int r15 = 0;
        if (r13 == null) goto L28;
        int r16 = r13.intValue();
    L29:
        Integer r17 = r20.getHeight();
        if (r17 == null) goto L32;
        r15 = r17.intValue();
    L32:
        Long r18 = r20.getDuration();
        if (r18 == null) goto L35;
        long r19 = r18.longValue();
    L36:
        Long r110 = r20.getCreateTime();
        if (r110 == null) goto L39;
        r7 = r110.longValue();
    L39:
        long r111 = r7;
        AccountService.a.getUserId();
        r14.J$0 = r12;
        r14.label = 1;
        long r112 = r12;
        if (r8.a(r9, r12, r11, r16, r15, r19, r111, r14) != r3) goto L42;
        return r3;
    L42:
        r5 = r112;
        goto L43
    L35:
        r19 = 0;
        goto L36
    L28:
        r16 = 0;
        goto L29
    L21:
        r9 = null;
        goto L22
    L17:
        r12 = 0;
    L7:
        r1 = new ThumbnailManager$createMetaData$1(this, r22);
        goto L8
    }

    public final Object i(long r9, String r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof ThumbnailManager$deleteThumbnail$1) == false) goto L7;
        ThumbnailManager$deleteThumbnail$1 r0 = (ThumbnailManager$deleteThumbnail$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ThumbnailManager$deleteThumbnail$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        long r10 = r6.J$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L49
    L52:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r9 = r6.J$0;
        r11 = (String) r6.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L49
    L19:
        String r5 = r11;
        ThumbnailMetadata r14 = (ThumbnailMetadata) r13;     // Catch: Exception -> L49
        if (r14 == null) goto L47;
        ThumbnailMetadataHelper r4 = ThumbnailMetadataHelper.a;     // Catch: Exception -> L49
        String r7 = r14.getFilePath();     // Catch: Exception -> L49
        r6.L$0 = null;     // Catch: Exception -> L49
        r6.J$0 = r9;     // Catch: Exception -> L49
        r6.label = 2;     // Catch: Exception -> L49
        if (r4.d(r9, r7, r5, r6) != r2) goto L52;
        return r2;
    L47:
        FLogger.a.w("ThumbnailManager", "Thumbnail metadata not found for imageUuid: " + r9);     // Catch: Exception -> L49
        goto L52
    L20:
        ResultKt.throwOnFailure(r13);
        FLogger.a.i("ThumbnailManager", "Deleting thumbnail, imageUuid: " + r9);
        Iterator<MediaInfo> r15 = e.iterator();     // Catch: Exception -> L49
    L23:
        if (r15.hasNext() == false) goto L30;
        Long r8 = r15.next().getMediaId();     // Catch: Exception -> L49
        if (r8 == null) goto L23;
        if (r8.longValue() != r9) goto L23;
        r15.remove();     // Catch: Exception -> L49
        goto L23
    L30:
        Iterator<MediaInfo> r16 = g.iterator();     // Catch: Exception -> L49
    L32:
        if (r16.hasNext() == false) goto L39;
        Long r17 = r16.next().getMediaId();     // Catch: Exception -> L49
        if (r17 == null) goto L32;
        if (r17.longValue() != r9) goto L32;
        r16.remove();     // Catch: Exception -> L49
        goto L32
    L39:
        AlbumDataBaseHelper r18 = AlbumDataBaseHelper.a;     // Catch: Exception -> L49
        r6.L$0 = r11;     // Catch: Exception -> L49
        r6.J$0 = r9;     // Catch: Exception -> L49
        r6.label = 1;     // Catch: Exception -> L49
        r13 = r18.w(r9, r11, r6);     // Catch: Exception -> L49
        if (r13 != r2) goto L19;
        return r2;
    L49:
        e = move-exception;
        FLogger.a.e("ThumbnailManager", "Error deleting thumbnail for imageUuid=" + r9 + ": " + e.getMessage(), e);
    L7:
        r0 = new ThumbnailManager$deleteThumbnail$1(this, r12);
        goto L8
    }

    public final Object j(List<Long> r7, String r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof ThumbnailManager$deleteThumbnails$1) == false) goto L7;
        ThumbnailManager$deleteThumbnails$1 r0 = (ThumbnailManager$deleteThumbnails$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L13
    L24:
    L23:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r10);
        FLogger.a.i("ThumbnailManager", "Deleting thumbnails, imageUuids: " + r7);
        ThumbnailMetadataHelper r11 = ThumbnailMetadataHelper.a;     // Catch: Exception -> L13
        r0.label = 1;     // Catch: Exception -> L13
        if (r11.c(r7, r8, r0) != r2) goto L24;
        return r2;
    L13:
        e = move-exception;
        FLogger.a.e("ThumbnailManager", "Error batch deleting thumbnails: " + e.getMessage(), e);
    L7:
        r0 = new ThumbnailManager$deleteThumbnails$1(this, r9);
        goto L8
    }

    public final Object n(byte[] r12, MediaInfo r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof ThumbnailManager$handleDisplayThumbnailData$1) == false) goto L7;
        ThumbnailManager$handleDisplayThumbnailData$1 r2 = (ThumbnailManager$handleDisplayThumbnailData$1) r14;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r15 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        long r16 = r2.J$0;
        MediaInfo r1 = (MediaInfo) r2.L$1;
        byte[] r6 = (byte[]) r2.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L14
        long r9 = r16;
        r13 = r1;
        r12 = r6;
    L37:
        if (o(r13) == true) goto L39;
        t(r12, r13, r9);     // Catch: Exception -> L41
    L39:
        h.tryEmit(Boxing.boxInt(1));     // Catch: Exception -> L41
        FLogger.a.d("ThumbnailManager", "Display: Posted thumbnail saved event for imageUuid=" + r9);     // Catch: Exception -> L41
    L45:
        return Unit.INSTANCE;
    L14:
        Exception e2 = e;
    L43:
        FLogger.a.e("ThumbnailManager", "Display: Error handling thumbnail data for imageUuid=" + r16 + ": " + e2.getMessage(), e2);
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        Long r17 = r13.getMediaId();
        if (r17 == null) goto L21;
        r9 = r17.longValue();
    L23:
        if (r9 != 0) goto L46;
        FLogger.a.e("ThumbnailManager", "Display: Invalid imageUuid, skipping handleDisplayThumbnailData.");
        return Unit.INSTANCE;
    L46:
        Long r18 = r13.getCreateTime();     // Catch: Exception -> L41
        String r7 = r13.getMediaType();     // Catch: Exception -> L41
        if (r7 != null) goto L29;
        r7 = "image_pack";
    L29:
        PolarisFileWrapper r19 = r(r9, r18, r12, r7);     // Catch: Exception -> L41
        if (r19 != null) goto L33;
        FLogger.a.e("ThumbnailManager", "Display: Failed to save thumbnail file for imageUuid=" + r9);     // Catch: Exception -> L41
        return Unit.INSTANCE;
    L33:
        r2.L$0 = r12;     // Catch: Exception -> L41
        r2.L$1 = r13;     // Catch: Exception -> L41
        r2.J$0 = r9;     // Catch: Exception -> L41
        r2.label = 1;     // Catch: Exception -> L41
        if (u(r13, r19, r2) != r4) goto L37;
        return r4;
    L41:
        e = move-exception;
        e2 = e;
        r16 = r9;
        goto L43
    L21:
        r9 = 0;
    L7:
        r2 = new ThumbnailManager$handleDisplayThumbnailData$1(this, r14);
        goto L8
    }

    public final Object q(MediaInfo r26, int r27, Continuation<? super byte[]> r28) {
        int r0 = r27;
        if ((r28 instanceof ThumbnailManager$requestThumbnailData$1) == false) goto L7;
        ThumbnailManager$requestThumbnailData$1 r2 = (ThumbnailManager$requestThumbnailData$1) r28;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        ThumbnailManager$requestThumbnailData$1 r12 = r2;
        Object r1 = r12.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r12.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r12.J$1;
        long r7 = r12.J$0;
        r0 = r12.I$0;
        Long r8 = (Long) r12.L$2;
        Long r9 = (Long) r12.L$1;
        MediaInfo r10 = (MediaInfo) r12.L$0;
        ResultKt.throwOnFailure(r1);
    L43:
        Long r15 = r8;
        long r21 = r7;
        b49.b r11 = (b49.b) r1;
        Long r13 = r9;
        long r14 = r6;
    L45:
        long r16 = System.currentTimeMillis() - r14;
        StringBuilder r17 = new StringBuilder();
        r17.append(r13);
        r17.append('_');
        r17.append(r15);
        r17.append('_');
        r17.append(r0);
        String r18 = r17.toString();
        if ((r11 instanceof b49.b.b) == false) goto L50;
        b49.b.b r19 = (b49.b.b) r11;
        byte[] r20 = r19.a;
        GalleryMobHelper r22 = GalleryMobHelper.a;
        String r110 = r10.getMediaType();
        int r23 = r19.b;
        int r24 = r20.length;
        r22.getClass();
        GalleryMobHelper.k(r18, r16, r110, 0, 0, r21, r23, r24);
        return r20;
    L50:
        if ((r11 instanceof b49.b.a) == false) goto L52;
        FLogger.a.e("ThumbnailManager", "ThumbnailData is null or empty, skip for mediaId=" + r13);
        GalleryMobHelper r25 = GalleryMobHelper.a;
        String r111 = r10.getMediaType();
        int r29 = ((b49.b.a) r11).a;
        r25.getClass();
        GalleryMobHelper.k(r18, r16, r111, 1, r29, r21, 0, -1);
    L52:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r13 = r26.getMediaId();
        r15 = r26.getCreateTime();
        if (r13 == null) goto L53;
        if (r15 == null) goto L53;
        Byte[] r30 = r26.getThumbnailTypes();
        boolean r31 = false;
        if (r30 == null) goto L32;
        int r32 = r30.length;
        int r33 = 0;
    L21:
        if (r33 >= r32) goto L29;
        if (r30[r33].byteValue() != 1) goto L25;
        boolean r34 = true;
    L26:
        if (r34 == true) goto L27;
        r33 = r33 + 1;
        goto L21
    L27:
        boolean r35 = true;
    L30:
        if (r35 == true) goto L32;
        r31 = true;
        goto L32
    L25:
        r34 = false;
        goto L26
    L29:
        r35 = false;
    L32:
        if (r31 == true) goto L34;
        long r36 = 10000;
    L35:
        long r112 = r36;
        long r37 = System.currentTimeMillis();
        IDoraService r38 = k();
        if (r38 == null) goto L44;
        VisionService r39 = r38.V();
        if (r39 == null) goto L44;
        r12.L$0 = r26;
        r12.L$1 = r13;
        r12.L$2 = r15;
        r12.I$0 = r0;
        r12.J$0 = r112;
        r12.J$1 = r37;
        r12.label = 1;
        Object r40 = r39.v(r13.longValue(), r15.longValue(), (byte) r0, r112, r12);
        if (r40 != r4) goto L42;
        return r4;
    L42:
        r10 = r26;
        r9 = r13;
        r1 = r40;
        r8 = r15;
        r6 = r37;
        r7 = r112;
    L44:
        r10 = r26;
        r11 = null;
        r14 = r37;
        r21 = r112;
        goto L45
    L34:
        r36 = 3000;
    L53:
        FLogger.a.e("ThumbnailManager", "Invalid mediaInfo, mediaId=" + r13 + ", createTime=" + r15);
        return null;
    L7:
        r2 = new ThumbnailManager$requestThumbnailData$1(this, r28);
        goto L8
    }

    public final Object u(MediaInfo r20, PolarisFileWrapper r21, Continuation r22) {
        if ((r22 instanceof ThumbnailManager$updateMetaData$1) == false) goto L7;
        ThumbnailManager$updateMetaData$1 r1 = (ThumbnailManager$updateMetaData$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        ThumbnailManager$updateMetaData$1 r14 = r1;
        Object r0 = r14.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r14.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r14.J$0;
        ResultKt.throwOnFailure(r0);
    L43:
        FLogger.a.i("ThumbnailManager", "Successfully updated thumbnail metadata: imageUuid=" + r5);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        Long r6 = r20.getMediaId();
        long r7 = 0;
        if (r6 == null) goto L17;
        long r12 = r6.longValue();
    L18:
        ThumbnailMetadataHelper r8 = ThumbnailMetadataHelper.a;
        if (r21 == null) goto L21;
        String r9 = r21.getAbsolutePath();
    L22:
        String r10 = r20.getMediaType();
        if (r10 != null) goto L25;
        r10 = "image_pack";
    L25:
        String r11 = l(r10);
        Integer r13 = r20.getWidth();
        int r15 = 0;
        if (r13 == null) goto L28;
        int r16 = r13.intValue();
    L29:
        Integer r17 = r20.getHeight();
        if (r17 == null) goto L32;
        r15 = r17.intValue();
    L32:
        Long r18 = r20.getDuration();
        if (r18 == null) goto L35;
        long r19 = r18.longValue();
    L36:
        Long r110 = r20.getCreateTime();
        if (r110 == null) goto L39;
        r7 = r110.longValue();
    L39:
        long r111 = r7;
        AccountService.a.getUserId();
        r14.J$0 = r12;
        r14.label = 1;
        long r112 = r12;
        if (r8.e(r9, r12, r11, r16, r15, r19, r111, r14) != r3) goto L42;
        return r3;
    L42:
        r5 = r112;
        goto L43
    L35:
        r19 = 0;
        goto L36
    L28:
        r16 = 0;
        goto L29
    L21:
        r9 = null;
        goto L22
    L17:
        r12 = 0;
    L7:
        r1 = new ThumbnailManager$updateMetaData$1(this, r22);
        goto L8
    }

    public static PolarisFileWrapper r(long r6, Long r8, byte[] r9, String r10) {
        PolarisFileWrapper r3 = m();     // Catch: Exception -> L25
        if (r3.exists() == true) goto L6;
        r3.mkdirs();     // Catch: Exception -> L25
    L6:
        int r4 = r10.hashCode();     // Catch: Exception -> L25
        if (r4 == (-1617978531)) goto L20;
        if (r4 == (-1442901379)) goto L17;
        if (r4 == 1333277997) goto L14;
    L21:
        String r11 = ".jpg";
    L23:
        PolarisFileWrapper r12 = new PolarisFileWrapper(r3, "thumb_" + r6 + '_' + r8 + r11);     // Catch: Exception -> L25
        FilesKt.writeBytes(r12, r9);     // Catch: Exception -> L25
        FLogger r13 = FLogger.a;     // Catch: Exception -> L25
        StringBuilder r14 = new StringBuilder("Saved thumbnail file: ");     // Catch: Exception -> L25
        r14.append(r12.getAbsolutePath());     // Catch: Exception -> L25
        r13.i("ThumbnailManager", r14.toString());     // Catch: Exception -> L25
        return r12;
    L14:
        if (r10.equals("video_mp4") == false) goto L21;
    L22:
        r11 = ".jpeg";
        goto L23
    L17:
        if (r10.equals("image_pack") == true) goto L22;
    L20:
        if (r10.equals("video_pack") == true) goto L22;
    L25:
        e = move-exception;
        FLogger.a.e("ThumbnailManager", "Error saving thumbnail file for imageUuid=" + r6 + ": " + e.getMessage(), e);
        return null;
    }
}
