package com.larus.avlink.gallery.coordinator;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.avlink.gallery.AlbumUtils;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.executor.MediaDownloadExecutor;
import com.larus.avlink.gallery.executor.MediaProcessingExecutor;
import com.larus.avlink.gallery.j;
import com.larus.avlink.gallery.l;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaList;
import com.larus.avlink.gallery.model.MediaListRequest;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.avlink.model.FlowDoraScene;
import com.larus.avlink.model.FlowDoraSceneState;
import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.MediaInfo;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.network.bean.BizResponse;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MediaSyncCoordinator {
    public static final MediaSyncCoordinator a = null;
    public static final List<u98.a> b = null;
    public static final AtomicBoolean c = null;
    public static final AtomicBoolean d = null;
    public static final AtomicBoolean e = null;
    public static SyncMode f;
    public static MediaDownloadExecutor g;
    public static MediaProcessingExecutor h;
    public static final MediaLifecycleStateManager i = null;
    public static final Lazy j = null;
    public static Job k;
    public static final Channel<Unit> l = null;
    public static z98.a m;
    public static int n;
    public static final Object o = null;
    public static final Set<String> p = null;
    public static final c q = null;
    public static final AtomicBoolean r = null;
    public static b s;
    public static final MediaSyncCoordinator$wifiStateListener$1 t = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/gallery/coordinator/MediaSyncCoordinator$SyncMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MANUAL", "SILENT", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum SyncMode extends Enum<SyncMode> {
        public static final SyncMode MANUAL = null;
        public static final SyncMode SILENT = null;
        public static final /* synthetic */ SyncMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<SyncMode> getEntries() {
            return b;
        }

        static {
            SyncMode r0 = new SyncMode("MANUAL", 0, 0);
            MANUAL = r0;
            SyncMode r1 = new SyncMode("SILENT", 1, 1);
            SILENT = r1;
            SyncMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static SyncMode[] values() {
            return (SyncMode[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SyncMode valueOf(String r1) {
            return (SyncMode) r27.a.a(SyncMode.class, r1);
        }

        public SyncMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a implements t39.i {
        public a() {
        }

        public final void a(int r1, int r2) {
        }

        public final void b(boolean r1) {
        }

        public final void c(boolean r1) {
        }

        public final void p(int r5) {
            FLogger r0 = FLogger.a;
            r0.i("MediaSyncCoordinator", "onLowPowerState state is " + r5);
            if (MediaSyncCoordinator.n != r5) goto L5;
            return;
        L5:
            MediaSyncCoordinator.n = r5;
            boolean r1 = true;
            if (r5 != 1) goto L8;
            r0.i("MediaSyncCoordinator", "onLowPowerState exit low power state");
            MediaSyncCoordinator r6 = MediaSyncCoordinator.a;
            MediaSyncCoordinator.r();
            return;
        L8:
            if (r5 != 2) goto L33;
            IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r7 == null) goto L17;
            IDoraService.j r8 = r7.S();
            if (r8 == null) goto L17;
            if (r8.d("ALBUM") != true) goto L17;
            boolean r9 = true;
        L18:
            if (r9 == true) goto L28;
            IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r10 == null) goto L26;
            IDoraService.j r11 = r10.S();
            if (r11 == null) goto L26;
            if (r11.d("ALBUM_SILENT") != true) goto L26;
        L27:
            if (r1 == true) goto L28;
            return;
        L26:
            r1 = false;
        L28:
            MediaSyncCoordinator.w("onLowPowerState", new g(), 2);
            return;
        L17:
            r9 = false;
            goto L18
        }
    }

    public static final class b implements b98.d {
        public b() {
        }

        public final void a(@FlowDoraScene int r6, @FlowDoraSceneState int r7) {
            FLogger r0 = FLogger.a;
            r0.i("MediaSyncCoordinator", "FlowDoraSceneManager onStateChange scene is " + r6 + ", state is " + r7);
            if (r6 != 3) goto L30;
            boolean r1 = true;
            if (r7 != 1) goto L7;
            IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r8 == null) goto L17;
            IDoraService.j r9 = r8.S();
            if (r9 == null) goto L17;
            if (r9.d("ALBUM") != true) goto L17;
            boolean r10 = true;
        L18:
            if (r10 == true) goto L28;
            IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r11 == null) goto L26;
            IDoraService.j r12 = r11.S();
            if (r12 == null) goto L26;
            if (r12.d("ALBUM_SILENT") != true) goto L26;
        L27:
            if (r1 == true) goto L28;
            return;
        L26:
            r1 = false;
        L28:
            MediaSyncCoordinator r13 = MediaSyncCoordinator.a;
            MediaSyncCoordinator.v("start video record", false, new h());
            return;
        L17:
            r10 = false;
            goto L18
        L7:
            if (r7 != 2) goto L33;
            r0.i("MediaSyncCoordinator", "FlowDoraSceneManager onStateChange scene is " + r6 + ", state is " + r7);
            MediaSyncCoordinator r14 = MediaSyncCoordinator.a;
            MediaSyncCoordinator.r();
            return;
        L33:
            return;
        }
    }

    public static final class c implements r98.b {
        public c() {
        }

        @Override // r98.b
        public final void a(String r2, MediaLifecycleState r3, String r4, MediaMetadata r5) {
            Intrinsics.checkNotNullParameter(r2, "mediaId");
            Intrinsics.checkNotNullParameter(r3, "failedAtState");
            Intrinsics.checkNotNullParameter(r4, "reason");
            Intrinsics.checkNotNullParameter(r5, "metadata");
            Object r6 = MediaSyncCoordinator.o;
            monitor-enter(r6);
            MediaSyncCoordinator.p.remove(r2);     // Catch: Throwable -> L7
            monitor-exit(r6);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // r98.b
        public final void b(String r2, MediaLifecycleState r3, MediaLifecycleState r4, MediaMetadata r5) {
            Intrinsics.checkNotNullParameter(r2, "mediaId");
            Intrinsics.checkNotNullParameter(r3, "oldState");
            Intrinsics.checkNotNullParameter(r4, "newState");
            Intrinsics.checkNotNullParameter(r5, "metadata");
            if (r4 != MediaLifecycleState.COMPLETED) goto L12;
            Object r6 = MediaSyncCoordinator.o;
            monitor-enter(r6);
            MediaSyncCoordinator.p.remove(r2);     // Catch: Throwable -> L9
            monitor-exit(r6);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            n1.c("MediaSyncCoordinator", "workScope error: " + r3.getMessage(), r3);
        }
    }

    public MediaSyncCoordinator() {
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.larus.avlink.gallery.coordinator.MediaSyncCoordinator$wifiStateListener$1] */
    static {
        a = new MediaSyncCoordinator();
        b = new ArrayList();
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
        f = SyncMode.MANUAL;
        i = MediaLifecycleStateManager.b.a();
        j = LazyKt.lazy(new com.larus.avlink.gallery.coordinator.a());
        l = ChannelKt.Channel$default(-1, null, null, 6, null);
        n = -1;
        o = new Object();
        p = new LinkedHashSet();
        q = new c();
        r = new AtomicBoolean(false);
        t = new MediaSyncCoordinator$wifiStateListener$1();
    }

    public static final void a() {
        List<u98.a> r0 = b;
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) r0).iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((u98.a) r1.next()).QR();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static MediaProcessingExecutor d() {
        i.e(q);
        MediaProcessingExecutor r0 = h;
        if (r0 == null) goto L5;
        r0.g();
    L7:
        if (g != null) goto L9;
        g = new MediaDownloadExecutor(e(), r0);
    L9:
        return r0;
    L5:
        r0 = new MediaProcessingExecutor(e());
        h = r0;
        goto L7
    }

    public static CoroutineScope e() {
        return (CoroutineScope) j.getValue();
    }

    public static void g() {
        if (r.compareAndSet(false, true) == true) goto L6;
        FLogger.a.i("MediaSyncCoordinator", "init: already initialized, skip");
        return;
    L6:
        BuildersKt.launch$default(e(), null, null, new MediaSyncCoordinator$startSilentSyncTriggerObserver$1(null), 3, null);
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L11;
        IDoraService.j r2 = r1.S();
        if (r2 == null) goto L11;
        r2.e(t);
    L11:
        BuildersKt.launch$default(e(), null, null, new MediaSyncCoordinator$init$1(null), 3, null);
        a r0 = new a();
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L14;
        r3.R0(r0);
    L14:
        b r4 = new b();
        s = r4;
        b98.b.c(r4);
    }

    public static boolean h() {
        int r0 = AlbumUtils.a;
        StatFs r1 = new StatFs(Environment.getDataDirectory().getPath());
        long r2 = r1.getAvailableBlocksLong() * r1.getBlockSizeLong();
        if (r2 >= 524288000) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L22;
        q();
        FLogger.a.w("MediaSyncCoordinator", "Storage insufficient: available=" + (r2 / ((long) 1048576)) + "MB");
        MediaDownloadExecutor r4 = g;
        if (r4 == null) goto L10;
        r4.e();
    L10:
        q();
        List<u98.a> r5 = b;
        monitor-enter(r5);
        Iterator r6 = ((ArrayList) r5).iterator();     // Catch: Throwable -> L19
    L14:
        if (r6.hasNext() == false) goto L16;
        ((u98.a) r6.next()).A10();     // Catch: Throwable -> L19
        goto L14
    L16:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r5);
    L19:
        th = move-exception;
        throw th;
    L22:
        return r3;
    L5:
        r3 = false;
        goto L6
    }

    public static boolean i() {
        if (c.get() == true) goto L5;
        j();
        return false;
    L5:
        return true;
    }

    public static boolean j() {
        Object r0 = o;
        monitor-enter(r0);
        monitor-exit(r0);
        return false;
    }

    public static void m() {
        m = z98.a.i.b;
        List<u98.a> r0 = b;
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) r0).iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((u98.a) r1.next()).Po();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void n() {
        m = z98.a.j.b;
        List<u98.a> r0 = b;
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) r0).iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((u98.a) r1.next()).Mv();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void q() {
        Object r0 = o;
        monitor-enter(r0);
        p.clear();     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void r() {
        List<u98.a> r0 = b;
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) r0).iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((u98.a) r1.next()).N30();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void t() {
        FLogger r0 = FLogger.a;
        r0.i("MediaSyncCoordinator", "Starting media sync");
        IDoraAVLinkService r2 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r2 == null) goto L5;
        String r3 = r2.getHost();
    L6:
        r0.i("MediaSyncCoordinator", "WiFi connected successfully, host: " + r3);
        GalleryMobHelper.a.getClass();
        GalleryMobHelper.c = System.currentTimeMillis();
        AtomicReference<l.a> r4 = l.a;
        l.a r5 = r4.get();
        boolean r9 = true;
        String r10 = "";
        String r12 = "data is null but request success";
        String r14 = "result is null";
        String r16 = "request failed";
        if (r5 != null) goto L9;
    L80:
        String r6 = null;
        r0.i("MediaSyncCoordinator", "Using getHardwareAlbumList to fetch all resources");
        if (r3 != null) goto L83;
        r0.e("MediaSyncCoordinator", "Failed to get host from IDoraAVLinkService");
        k("Failed to get host");
        return;
    L83:
        long r7 = System.currentTimeMillis();
        Request r8 = new Request.Builder().url("http://" + r3 + "/album/media_list?uid=" + AccountService.a.getUserId()).get().build();
        Type r11 = new e().getType();
        IDoraService r13 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r13 == null) goto L88;
        IDoraService.j r15 = r13.S();
        if (r15 == null) goto L88;
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r11);
        Result r17 = Result.box-impl(r15.b(r8, r11));
    L89:
        long r18 = System.currentTimeMillis() - r7;
        if (r17 != null) goto L92;
    L94:
        boolean r19 = false;
    L95:
        if (r19 == false) goto L145;
        Object r20 = r17.unbox-impl();
        if (Result.isFailure-impl(r20) == false) goto L99;
        r20 = null;
    L99:
        BizResponse r21 = (BizResponse) r20;
        if (r21 == null) goto L102;
        MediaList r22 = (MediaList) r21.getData();
    L103:
        if (r22 == null) goto L130;
        StringBuilder r23 = new StringBuilder("Got hardware album list, size: ");
        List<MediaInfo> r24 = r22.getMediaList();
        if (r24 == null) goto L107;
        Integer r25 = Integer.valueOf(r24.size());
    L108:
        r23.append(r25);
        r23.append(", mediaList: ");
        List<MediaInfo> r26 = r22.getMediaList();
        if (r26 == null) goto L119;
        List<MediaInfo> r27 = r26;
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator<T> r29 = r27.iterator();
    L112:
        if (r29.hasNext() == false) goto L118;
        MediaInfo r110 = (MediaInfo) r29.next();
        if (r110 == null) goto L116;
        Long r111 = r110.getMediaId();
    L117:
        r28.add(r111);
        goto L112
    L116:
        r111 = null;
        goto L117
    L118:
        r6 = CollectionsKt.joinToString$default(r28, ",", null, null, 0, null, null, 62, null);
    L119:
        r23.append(r6);
        r0.i("MediaSyncCoordinator", r23.toString());
        List<MediaInfo> r1 = r22.getMediaList();
        if (r1 != null) goto L122;
    L125:
        boolean r30 = true;
    L126:
        if (r30 == false) goto L128;
        l();
        c();
    L129:
        boolean r31 = true;
    L153:
        GalleryMobHelper.a.getClass();
        GalleryMobHelper.g(r18, r31, r10);
        return;
    L128:
        n();
        s(r22, f);
        goto L129
    L122:
        if (r1.isEmpty() == true) goto L125;
        r30 = false;
        goto L126
    L107:
        r25 = null;
        goto L108
    L130:
        if (r21 != null) goto L133;
        k("API call failed");
        r12 = "response is null";
    L144:
        c();
        r10 = r12;
    L152:
        r31 = false;
        goto L153
    L133:
        if (r21.getCode() == 0) goto L143;
        String r32 = r21.getMsg();
        if (r32 != null) goto L137;
        r12 = "request failed";
    L138:
        r0.e("MediaSyncCoordinator", "getHardwareAlbumList error code: " + r21.getCode() + ", msg: " + r21.getMsg());
        String r33 = r21.getMsg();
        if (r33 == null) goto L142;
        r16 = r33;
    L142:
        k(r16);
        goto L144
    L137:
        r12 = r32;
        goto L138
    L143:
        l();
        goto L144
    L102:
        r22 = null;
        goto L103
    L145:
        if (r17 != null) goto L147;
        r0.e("MediaSyncCoordinator", "doraLanRequest return null in getHardwareAlbumList");
        k("API call failed");
    L151:
        c();
        r10 = r14;
        goto L152
    L147:
        StringBuilder r34 = new StringBuilder("result error: ");
        Throwable r35 = Result.exceptionOrNull-impl(r17.unbox-impl());
        if (r35 == null) goto L150;
        r6 = r35.getMessage();
    L150:
        r34.append(r6);
        r14 = r34.toString();
        r0.e("MediaSyncCoordinator", "getHardwareAlbumList error: " + Result.exceptionOrNull-impl(r17.unbox-impl()));
        k("request failed");
        goto L151
    L92:
        if (Result.isSuccess-impl(r17.unbox-impl()) != true) goto L94;
        r19 = true;
    L88:
        r17 = null;
        goto L89
    L9:
        if ((!r5.c.isEmpty()) == false) goto L80;
        r0.i("MediaSyncCoordinator", "Using getHardwareAlbumListByIds with " + r5.c.size() + " selected UUIDs: " + CollectionsKt.joinToString$default(r5.c, ",", null, null, 0, null, null, 62, null));
        List<Long> r36 = r5.c;
        if (r3 != null) goto L15;
        r0.w("MediaSyncCoordinator", "getHardwareAlbumListByIds called with null host");
    L78:
        if (r4.getAndSet(null) == null) goto L158;
        l.b.postValue(null);
        r0.i("SyncRequestManager", "Cleared pending sync request");
        return;
    L158:
        return;
    L15:
        if (r36.isEmpty() == false) goto L17;
        r0.w("MediaSyncCoordinator", "getHardwareAlbumListByIds called with empty uuids list");
        goto L78
    L17:
        long r37 = System.currentTimeMillis();
        RequestBody r38 = RequestBody.create(MediaType.parse("application/json"), GsonProtectorUtils.toJson(new Gson(), new MediaListRequest(r36)));
        Request r39 = new Request.Builder().url("http://" + r3 + "/album/media_list").post(r38).build();
        Type r40 = new f().getType();
        IDoraService r41 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r41 == null) goto L22;
        IDoraService.j r42 = r41.S();
        if (r42 == null) goto L22;
        Intrinsics.checkNotNull(r39);
        Intrinsics.checkNotNull(r40);
        Result r43 = Result.box-impl(r42.b(r39, r40));
    L23:
        long r44 = System.currentTimeMillis() - r37;
        if (r43 != null) goto L26;
    L28:
        boolean r45 = false;
    L29:
        if (r45 == false) goto L67;
        Object r46 = r43.unbox-impl();
        if (Result.isFailure-impl(r46) == false) goto L33;
        r46 = null;
    L33:
        BizResponse r47 = (BizResponse) r46;
        if (r47 == null) goto L36;
        MediaList r48 = (MediaList) r47.getData();
    L37:
        if (r48 == null) goto L52;
        StringBuilder r49 = new StringBuilder("getHardwareAlbumListByIds succeeded: ");
        List<MediaInfo> r50 = r48.getMediaList();
        if (r50 == null) goto L41;
        Integer r51 = Integer.valueOf(r50.size());
    L42:
        r49.append(r51);
        r49.append(" items");
        r0.i("MediaSyncCoordinator", r49.toString());
        List<MediaInfo> r52 = r48.getMediaList();
        if (r52 != null) goto L45;
    L48:
        boolean r112 = true;
    L49:
        if (r112 == false) goto L51;
        l();
        c();
    L76:
        GalleryMobHelper.g(r44, r9, r10);
        goto L78
    L51:
        n();
        s(r48, f);
        goto L76
    L45:
        if (r52.isEmpty() == true) goto L48;
        r112 = false;
        goto L49
    L41:
        r51 = null;
        goto L42
    L52:
        if (r47 != null) goto L55;
        k("API call failed");
        r12 = "response is null";
    L66:
        c();
        r10 = r12;
    L75:
        r9 = false;
        goto L76
    L55:
        if (r47.getCode() == 0) goto L65;
        String r53 = r47.getMsg();
        if (r53 != null) goto L59;
        r12 = "request failed";
    L60:
        r0.e("MediaSyncCoordinator", "getHardwareAlbumListByIds error code: " + r47.getCode() + ", msg: " + r47.getMsg());
        String r54 = r47.getMsg();
        if (r54 == null) goto L64;
        r16 = r54;
    L64:
        k(r16);
        goto L66
    L59:
        r12 = r53;
        goto L60
    L65:
        l();
        goto L66
    L36:
        r48 = null;
        goto L37
    L67:
        if (r43 != null) goto L69;
        r0.e("MediaSyncCoordinator", "doraLanRequest return null in getHardwareAlbumListByIds");
        k("API call failed");
    L74:
        c();
        r10 = r14;
        goto L75
    L69:
        StringBuilder r55 = new StringBuilder("result error: ");
        Throwable r56 = Result.exceptionOrNull-impl(r43.unbox-impl());
        if (r56 == null) goto L72;
        String r57 = r56.getMessage();
    L73:
        r55.append(r57);
        r14 = r55.toString();
        r0.e("MediaSyncCoordinator", "getHardwareAlbumListByIds error: " + Result.exceptionOrNull-impl(r43.unbox-impl()));
        k("request failed");
        goto L74
    L72:
        r57 = null;
        goto L73
    L26:
        if (Result.isSuccess-impl(r43.unbox-impl()) != true) goto L28;
        r45 = true;
    L22:
        r43 = null;
        goto L23
    L5:
        r3 = null;
        goto L6
    }

    public static void c() {
        BuildersKt.launch$default(e(), null, null, new MediaSyncCoordinator$disconnectWifi$1(null), 3, null);
    }

    public static void l() {
        q();
        List<u98.a> r0 = b;
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) r0).iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L8;
        ((u98.a) r1.next()).Ff();     // Catch: Throwable -> L12
        goto L6
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        c.set(false);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean o() {
        if (com.larus.avlink.gallery.f.a() == false) goto L6;
        FLogger.a.i("MediaSyncCoordinator", "Sync operation in low battery mode, skipping callback");
        f(z98.a.e.b);
        return false;
    L6:
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L13;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L13;
        if (r1.H() != true) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L17;
        FLogger.a.w("MediaSyncCoordinator", "Video state is active, sync flow aborted");
        f(z98.a.g.b);
        return false;
    L17:
        return true;
    L13:
        r2 = false;
        goto L14
    }

    public static void f(z98.a r4) {
        m = r4;
        FLogger.a.i("MediaSyncCoordinator", "Updated banner state: " + r4.getClass());
        List<u98.a> r0 = b;
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) r0).iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((u98.a) r1.next()).m40(r4);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void k(String r3) {
        q();
        m = z98.a.n.b;
        List<u98.a> r0 = b;
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) r0).iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L8;
        ((u98.a) r1.next()).onError(r3);     // Catch: Throwable -> L12
        goto L6
    L8:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        c.set(false);
        d.set(false);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void p(u98.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        List<u98.a> r1 = b;
        monitor-enter(r1);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) r1).contains(r5) == true) goto L7;
        FLogger.a.d("MediaSyncCoordinator", "Registered state listener: " + r5.hashCode());     // Catch: Throwable -> L37
        ((ArrayList) r1).add(r5);     // Catch: Throwable -> L37
    L7:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r1);
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("Updated state listener state: ");
        z98.a r4 = m;
        if (r4 == null) goto L12;
        Class<?> r6 = r4.getClass();
    L13:
        r3.append(r6);
        r2.i("MediaSyncCoordinator", r3.toString());
        boolean r7 = true;
        if (c.get() == false) goto L16;
    L25:
        if (r7 == false) goto L27;
        z98.a r8 = m;
    L33:
        if (r8 != null) goto L35;
        r8 = z98.a.c.b;
    L35:
        r5.m40(r8);
        return;
    L27:
        r8 = m;
        if ((r8 instanceof z98.a.h) == true) goto L33;
        if ((r8 instanceof z98.a.d) == true) goto L33;
        r8 = z98.a.c.b;
        goto L33
    L16:
        if (d.get() == true) goto L25;
        Job r9 = k;
        if (r9 != null) goto L20;
    L22:
        boolean r10 = false;
    L23:
        if (r10 == true) goto L25;
        j();
        r7 = false;
        goto L25
    L20:
        if (r9.isActive() != true) goto L22;
        r10 = true;
        goto L23
    L12:
        r6 = null;
        goto L13
    }

    public static void x(u98.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        List<u98.a> r1 = b;
        monitor-enter(r1);
        FLogger.a.d("MediaSyncCoordinator", "Unregistered state listener: " + r5.hashCode());     // Catch: Throwable -> L7
        ((ArrayList) r1).remove(r5);     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void s(MediaList r11, final SyncMode r12) {
        final MediaDownloadExecutor r0 = g;
        if (r0 == null) goto L79;
        final FragmentActivity r1 = AppHost.a.getApplication();
        Function2<? super String, ? super MediaLifecycleState, Unit> r2 = new com.larus.avlink.gallery.coordinator.b();
        Function1<? super Integer, Unit> r3 = new com.larus.avlink.gallery.coordinator.c();
        Function0<Unit> r4 = new com.larus.avlink.gallery.coordinator.d(r12);
        Intrinsics.checkNotNullParameter(r11, "mediaList");
        Intrinsics.checkNotNullParameter(r12, "syncMode");
        Intrinsics.checkNotNullParameter(r2, "onMediaTracked");
        Intrinsics.checkNotNullParameter(r3, "onSingleComplete");
        Intrinsics.checkNotNullParameter(r4, "onAllComplete");
        r0.e();
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L9;
        IDoraService.j r6 = r5.S();
        if (r6 == null) goto L9;
        String r7 = r6.getHost();
    L10:
        r0.l = r7;
        r0.i = r2;
        r0.k = r4;
        r0.j = r3;
        int r8 = 0;
        r0.e.b = false;
        List<MediaInfo> r13 = r11.getMediaList();
        if (r13 == null) goto L14;
        List r14 = CollectionsKt.filterNotNull(r13);
        if (r14 == null) goto L14;
    L15:
        r0.g.set(r14.size());
        r0.h.set(0);
        com.larus.avlink.gallery.processor.a r9 = new com.larus.avlink.gallery.processor.a(0);
        List r15 = r14;
        boolean r10 = r15 instanceof Collection;
        if (r10 == true) goto L18;
    L20:
        Iterator r16 = r15.iterator();
        int r17 = 0;
    L22:
        if (r16.hasNext() == false) goto L28;
        if (j.a(MediaDownloadExecutor.g(((MediaInfo) r16.next()).getMediaType())) == false) goto L22;
        r17 = r17 + 1;
        if (r17 >= 0) goto L22;
        CollectionsKt.throwCountOverflow();
    L28:
        if (r10 == true) goto L30;
    L32:
        Iterator r18 = r15.iterator();
    L34:
        if (r18.hasNext() == false) goto L40;
        if ((!j.a(MediaDownloadExecutor.g(((MediaInfo) r18.next()).getMediaType()))) == false) goto L34;
        r8 = r8 + 1;
        if (r8 >= 0) goto L34;
        CollectionsKt.throwCountOverflow();
    L40:
        r9.b = r17;
        r9.c = r8;
        Iterator r19 = r15.iterator();
        long r20 = 0;
    L42:
        if (r19.hasNext() == false) goto L48;
        Long r21 = ((MediaInfo) r19.next()).getSize();
        if (r21 == null) goto L46;
        long r22 = r21.longValue();
    L47:
        r20 = r20 + r22;
        goto L42
    L46:
        r22 = 0;
        goto L47
    L48:
        r9.a = r20;
        Iterator r23 = r15.iterator();
        long r24 = 0;
    L50:
        if (r23.hasNext() == false) goto L56;
        Long r25 = ((MediaInfo) r23.next()).getDuration();
        if (r25 == null) goto L54;
        long r26 = r25.longValue();
    L55:
        r24 = r24 + r26;
        goto L50
    L54:
        r26 = 0;
        goto L55
    L56:
        r9.f = r24;
        r0.m = r9;
        Iterator r110 = r15.iterator();
    L58:
        if (r110.hasNext() == false) goto L105;
        final MediaInfo r27 = (MediaInfo) r110.next();
        if (r1 == null) goto L75;
        if (r27 == null) goto L75;
        if (Build.VERSION.SDK_INT <= 28) goto L67;
    L76:
        Job r28 = r0.n(r1, r27, r12);
    L77:
        if (r28 == null) goto L58;
        com.larus.avlink.gallery.processor.f r29 = r0.e;
        r29.getClass();
        Intrinsics.checkNotNullParameter(r28, "job");
        r29.a.add(r28);
        goto L58
    L67:
        if (ContextCompat.checkSelfPermission(r1, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L76;
        if ((r1 instanceof FragmentActivity) == false) goto L71;
        FragmentActivity r30 = r1;
    L72:
        if (r30 == null) goto L75;
        i2.b.a(r30, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), new com.larus.avlink.gallery.executor.c(r0, r1, r27, r12));
        goto L75
    L71:
        r30 = null;
    L75:
        r28 = null;
        goto L77
    L105:
        return;
    L30:
        if (r15.isEmpty() == false) goto L32;
    L18:
        if (r15.isEmpty() == false) goto L20;
        r17 = 0;
    L14:
        r14 = CollectionsKt.emptyList();
    L9:
        r7 = null;
        goto L10
    }

    public static void v(String r4, boolean r5, Function0 r6) {
        FLogger r0 = FLogger.a;
        r0.i("MediaSyncCoordinator", "Stopping sync operation, reason: " + r4 + ", stopProcessing: " + r5);
        q();
        c.set(false);
        d.set(false);
        Job r7 = k;
        if (r7 == null) goto L5;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L5:
        k = null;
        MediaDownloadExecutor r8 = g;
        if (r8 == null) goto L8;
        r8.e();
    L8:
        if (r5 == false) goto L45;
        MediaProcessingExecutor r9 = h;
        if (r9 == null) goto L45;
        if (r9.g.compareAndSet(true, false) == true) goto L14;
        r0.w("MediaProcessingExecutor", "Processing queue not running, skipping stop");
        goto L45
    L14:
        r0.i("MediaProcessingExecutor", "Stopping processing queue");
        Channel<MediaProcessingExecutor.b> r10 = r9.c;     // Catch: Exception -> L42
        if (r10 == null) goto L18;
        r10.close(null);     // Catch: Exception -> L42
    L18:
        Channel<MediaProcessingExecutor.b> r11 = r9.d;     // Catch: Exception -> L42
        if (r11 == null) goto L21;
        r11.close(null);     // Catch: Exception -> L42
    L21:
        r9.c = null;     // Catch: Exception -> L42
        r9.d = null;     // Catch: Exception -> L42
        Job r12 = r9.i;     // Catch: Exception -> L42
        if (r12 == null) goto L24;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);     // Catch: Exception -> L42
    L24:
        Job r13 = r9.j;     // Catch: Exception -> L42
        if (r13 == null) goto L27;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);     // Catch: Exception -> L42
    L27:
        r9.i = null;     // Catch: Exception -> L42
        r9.j = null;     // Catch: Exception -> L42
        Set<String> r14 = r9.e;     // Catch: Exception -> L42
        monitor-enter(r14);     // Catch: Exception -> L42
        r9.e.clear();     // Catch: Throwable -> L39
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(r14);     // Catch: Exception -> L42
        Set<String> r15 = r9.f;     // Catch: Exception -> L42
        monitor-enter(r15);     // Catch: Exception -> L42
        r9.f.clear();     // Catch: Throwable -> L36
        monitor-exit(r15);     // Catch: Exception -> L42
    L44:
        FLogger.a.i("MediaProcessingExecutor", "Processing queue stopped");
        goto L45
    L36:
        th = move-exception;
        throw th;     // Catch: Exception -> L42
    L39:
        th = move-exception;
        throw th;     // Catch: Exception -> L42
    L42:
        e = move-exception;
        FLogger.a.w("MediaProcessingExecutor", "Error stopping processing queue: " + e.getMessage());
    L45:
        if (r6 != null) goto L47;
        r();
    L48:
        c();
        FLogger.a.i("MediaSyncCoordinator", "Sync operation stopped");
        return;
    L47:
        r6.invoke();
        goto L48
    }

    public static /* synthetic */ void w(String r1, Function0 r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "Unknown";
    L6:
        if ((r3 & 2) == 0) goto L8;
        boolean r0 = true;
    L10:
        if ((r3 & 4) == 0) goto L12;
        r2 = null;
    L12:
        v(r1, r0, r2);
        return;
    L8:
        r0 = false;
        goto L10
    }

    public final synchronized void u(SyncMode r11, boolean r12, Integer r13, Integer r14) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "mode");     // Catch: Throwable -> L25
        FLogger r1 = FLogger.a;     // Catch: Throwable -> L25
        r1.i("MediaSyncCoordinator", "Starting sync flow with mode: " + r11);     // Catch: Throwable -> L25
        Job r0 = k;     // Catch: Throwable -> L25
        if (r0 != null) goto L7;
    L9:
        MediaDownloadExecutor r2 = g;     // Catch: Throwable -> L25
        if (r2 == null) goto L12;
        r2.e();     // Catch: Throwable -> L25
    L12:
        q();     // Catch: Throwable -> L25
        if (h() == false) goto L18;
        c.set(false);     // Catch: Throwable -> L25
        r1.i("MediaSyncCoordinator", "No space available, sync flow aborted");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L18:
        if (o() == true) goto L22;
        c.set(false);     // Catch: Throwable -> L25
        r1.w("MediaSyncCoordinator", "Pre-check failed, sync flow aborted");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L22:
        d();     // Catch: Throwable -> L25
        k = BuildersKt.launch$default(e(), null, null, new MediaSyncCoordinator$startSyncFlow$2(r11, r13, r14, r12, null), 3, null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L7:
        if (r0.isActive() == false) goto L9;
        r1.w("MediaSyncCoordinator", "Canceling previous sync task before starting new one");     // Catch: Throwable -> L25
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L25
        c.set(false);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public static final Object b(MediaSyncCoordinator r18, SyncMode r19, Integer r20, Integer r21, boolean r22, Continuation r23) {
        Integer r1 = r20;
        r18.getClass();
        if ((r23 instanceof MediaSyncCoordinator$startSyncInternal$1) == false) goto L7;
        MediaSyncCoordinator$startSyncInternal$1 r4 = (MediaSyncCoordinator$startSyncInternal$1) r23;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        int r9 = 0;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        Integer r0 = (Integer) r4.L$1;
        r1 = (Integer) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L34:
        String r8 = (String) r3;
    L36:
        d.set(false);
        n1.d("MediaSyncCoordinator", "startSyncInternal, wifiConnectResult:" + r8 + '.');
        if (r8 == null) goto L86;
        switch(r8.hashCode()) {
            case -1939875703: goto L82;
            case -1732558418: goto L78;
            case -1149187101: goto L61;
            case -774571534: goto L57;
            case -410029444: goto L54;
            case 186311881: goto L50;
            case 769870174: goto L46;
            case 2066319421: goto L42;
            default: goto L86;
        };
    L42:
        if (r8.equals("FAILED") == false) goto L86;
        f(z98.a.n.b);
        c();
        goto L86
    L46:
        if (r8.equals("P2P_FAILED_DUE_TO_WIFI_DISABLED") == false) goto L86;
        f(z98.a.m.b);
        c();
        return Unit.INSTANCE;
    L50:
        if (r8.equals("P2P_FAILED_DUE_TO_GPS_CLOSED") == false) goto L86;
        f(z98.a.b.b);
        c();
        return Unit.INSTANCE;
    L54:
        if (r8.equals("P2P_FAILED_NEARBY_PERMISSION_DENIED") == false) goto L86;
    L59:
        c();
        return Unit.INSTANCE;
    L57:
        if (r8.equals("P2P_FAILED_LOCATION_PERMISSION_DENIED") == true) goto L59;
    L61:
        if (r8.equals("SUCCESS") == false) goto L86;
        if (o() == true) goto L67;
        FLogger.a.w("MediaSyncCoordinator", "Pre-check failed, sync flow aborted");
        c();
        return Unit.INSTANCE;
    L67:
        if (c.compareAndSet(false, true) == true) goto L69;
        FLogger.a.i("MediaSyncCoordinator", "Sync operation already in progress, skipping callback");
        return Unit.INSTANCE;
    L69:
        GalleryMobHelper.a.getClass();
        Pair[] r10 = new Pair[6];
        r10[0] = TuplesKt.to("task_id", GalleryMobHelper.a());
        r10[1] = TuplesKt.to("status", 0);
        r10[2] = TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - GalleryMobHelper.b));
        r10[3] = TuplesKt.to("error_code", 0);
        if (r1 == null) goto L72;
        int r2 = r1.intValue();
    L73:
        r10[4] = TuplesKt.to("media_photo_count", Integer.valueOf(r2));
        if (r0 == null) goto L76;
        r9 = r0.intValue();
    L76:
        r10[5] = TuplesKt.to("media_video_count", Integer.valueOf(r9));
        GalleryMobHelper.i("flow_gallery_wifi_connect_end", MapsKt.mutableMapOf(r10));
        t();
        goto L86
    L72:
        r2 = 0;
        goto L73
    L78:
        if (r8.equals("P2P_FAILED_DUE_TO_VPN_ENABLED") == false) goto L86;
        f(z98.a.k.b);
        c();
        return Unit.INSTANCE;
    L82:
        if (r8.equals("P2P_FAILED_DUE_TO_HOTSPOT_ENABLED") == false) goto L86;
        f(z98.a.C0098a.b);
        c();
        return Unit.INSTANCE;
    L86:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        n1.d("MediaSyncCoordinator", "startSyncInternal, photoCnt:" + r1 + ", videoCnt:" + r21 + ", requestPermission:" + r22 + '.');
        f = r19;
        GalleryMobHelper.a.getClass();
        GalleryMobHelper.b = System.currentTimeMillis();
        GalleryMobHelper.f(r19);
        Pair[] r11 = new Pair[3];
        r11[0] = TuplesKt.to("task_id", GalleryMobHelper.a());
        if (r1 == null) goto L17;
        int r12 = r20.intValue();
    L18:
        r11[1] = TuplesKt.to("media_photo_count", Integer.valueOf(r12));
        if (r21 == null) goto L21;
        int r13 = r21.intValue();
    L22:
        r11[2] = TuplesKt.to("media_video_count", Integer.valueOf(r13));
        GalleryMobHelper.i("flow_gallery_wifi_connect_begin", MapsKt.mutableMapOf(r11));
        f(z98.a.l.b);
        d.set(true);
        IDoraService r14 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r14 == null) goto L35;
        IDoraService.j r15 = r14.S();
        if (r15 == null) goto L35;
        if (r19 != SyncMode.MANUAL) goto L29;
        String r16 = "ALBUM";
    L30:
        r4.L$0 = r1;
        r4.L$1 = r21;
        r4.label = 1;
        r3 = r15.a(r16, r4);
        if (r3 == r6) goto L94;
        r0 = r21;
        goto L34
    L94:
        return r6;
    L29:
        r16 = "ALBUM_SILENT";
    L35:
        r8 = null;
        r0 = r21;
        goto L36
    L21:
        r13 = 0;
        goto L22
    L17:
        r12 = 0;
    L7:
        r4 = new MediaSyncCoordinator$startSyncInternal$1(r18, r23);
        goto L8
    }
}
