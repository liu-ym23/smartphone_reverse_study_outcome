package com.larus.avlink.gallery.silent;

import b49.e;
import b49.f;
import b98.d;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.annotation.DoraScene;
import com.larus.dora.api.model.FlowDoraGlassOpenState;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.dora.impl.serviceimpl.h;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h49.i;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SilentSyncManager {
    public static Job a;
    public static Timer b;
    public static final IDoraService c = null;
    public static final CoroutineScope d = null;
    public static volatile int e;
    public static volatile int f;
    public static volatile Pair<Integer, Integer> g;
    public static boolean h;
    public static final AtomicBoolean i = null;
    public static SilentSyncManager$init$linkListener$1 j;
    public static com.larus.avlink.gallery.silent.a k;
    public static final c l = null;
    public static final a m = null;
    public static final SilentSyncManager$appBackgroundListener$1 n = null;
    public static final b o = null;

    public static final class a implements u39.a {
        public a() {
        }

        public final void a(Set<? extends DoraScene> r13) {
            Intrinsics.checkNotNullParameter(r13, "scene");
            FLogger r0 = FLogger.a;
            r0.i("SilentSyncManager", "Dora scene changed: " + CollectionsKt.joinToString$default(r13, ",", null, null, 0, null, null, 62, null));
            if ((!r13.isEmpty()) == false) goto L5;
            Job r14 = SilentSyncManager.a;
            SilentSyncManager.d("OTA Or Feedback");
            return;
        L5:
            r0.i("SilentSyncManager", "OTA Or Feedback exit, try start silent sync");
            IDoraService r15 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r15 == null) goto L10;
            VisionService r16 = r15.V();
            if (r16 == null) goto L10;
            Pair r17 = r16.l();
        L11:
            int r1 = 0;
            if (r17 == null) goto L14;
            int r3 = ((Number) r17.getFirst()).intValue();
        L15:
            if (r17 == null) goto L17;
            r1 = ((Number) r17.getSecond()).intValue();
        L17:
            if (r3 > 0) goto L19;
            if (r1 > 0) goto L19;
            return;
        L19:
            r0.i("SilentSyncManager", "Has media when OTA Or Feedback exit, triggering silent sync");
            Job r18 = SilentSyncManager.a;
            SilentSyncManager.c();
            return;
        L14:
            r3 = 0;
        L10:
            r17 = null;
            goto L11
        }
    }

    public static final class b implements d {
        public b() {
        }

        public final void a(int r4, int r5) {
            FLogger r0 = FLogger.a;
            r0.i("SilentSyncManager", "Scene state changed: scene:" + r4 + ", state:" + r5);
            if (r4 != 1) goto L25;
            if (r5 != 1) goto L6;
            Job r6 = SilentSyncManager.a;
            SilentSyncManager.d("Live AI");
            return;
        L6:
            if (r5 != 2) goto L28;
            r0.i("SilentSyncManager", "Live AI exit, try start silent sync");
            IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r7 == null) goto L13;
            VisionService r8 = r7.V();
            if (r8 == null) goto L13;
            Pair r9 = r8.l();
        L14:
            int r10 = 0;
            if (r9 == null) goto L17;
            int r1 = ((Number) r9.getFirst()).intValue();
        L18:
            if (r9 == null) goto L20;
            r10 = ((Number) r9.getSecond()).intValue();
        L20:
            if (r1 > 0) goto L22;
            if (r10 > 0) goto L22;
            return;
        L22:
            r0.i("SilentSyncManager", "Has media when Live AI exit, triggering silent sync");
            Job r11 = SilentSyncManager.a;
            SilentSyncManager.c();
            return;
        L17:
            r1 = 0;
        L13:
            r9 = null;
            goto L14
        L28:
            return;
        }
    }

    public static final class c implements i {
        public c() {
        }

        public final void c() {
            if (SilentSyncManager.e != 1) goto L6;
            FLogger.a.i("SilentSyncManager", "Silent transfer status already on in the mode, skipping");
            return;
        L6:
            Job r0 = SilentSyncManager.a;
            SilentSyncManager.e = 1;
            FLogger.a.i("SilentSyncManager", "Silent transfer status always on in the mode");
            Job r1 = SilentSyncManager.a;
            boolean r2 = SilentSyncManager.b();
            GalleryMobHelper.a.getClass();
            LinkedHashMap r3 = new LinkedHashMap();
            r3.put("silent_sync_switch", Integer.valueOf(r2 ? 1 : 0));
            GalleryMobHelper.i("flow_album_silent_sync_switch", r3);
            BuildersKt.launch$default(SilentSyncManager.d, null, null, new SilentSyncManager$wifiStateListener$1$onAlbumSilentTrans$1(r2, null), 3, null);
        }

        public final void a(FlowDoraGlassOpenState r5) {
            Intrinsics.checkNotNullParameter(r5, "state");
            Intrinsics.checkNotNullParameter(r5, "state");
            FLogger r0 = FLogger.a;
            r0.i("SilentSyncManager", "Glass open state changed: " + r5);
            if (SilentSyncManager.f != r5.getValue()) goto L6;
            r0.d("SilentSyncManager", "Glass open state unchanged " + r5.getValue() + ", skipping");
            return;
        L6:
            Job r1 = SilentSyncManager.a;
            SilentSyncManager.f = r5.getValue();
            if (r5 != FlowDoraGlassOpenState.CLOSE) goto L14;
            Job r6 = SilentSyncManager.a;
            if (SilentSyncManager.b() == true) goto L12;
            r0.i("SilentSyncManager", "Auto sync feature is disabled, skipping");
            return;
        L12:
            r0.i("SilentSyncManager", "Glass folded detected - triggering silent sync");
            SilentSyncManager.c();
            return;
        }

        @Deprecated(message = "使用ThumbnailManager")
        public final void b(e r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final void d(f r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
        }

        public final void e(FlowDoraGlassOpenState r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void f(int r3, int r4, String r5) {
            FLogger.a.i("SilentSyncManager", "WiFi state changed: " + r3 + " -> " + r4);
            if (r4 != 0) goto L6;
            Job r6 = SilentSyncManager.a;
            SilentSyncManager.d("Wifi Disconnected");
            return;
        }
    }

    public SilentSyncManager() {
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.avlink.gallery.silent.SilentSyncManager$appBackgroundListener$1] */
    static {
        c = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        d = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        e = -1;
        f = -1;
        g = new Pair(0, 0);
        h = true;
        i = new AtomicBoolean(false);
        l = new c();
        m = new a();
        n = new SilentSyncManager$appBackgroundListener$1();
        o = new b();
    }

    public static boolean b() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        h r1 = r0.debug();
        if (r1 == null) goto L7;
        boolean r2 = r1.i();
    L8:
        FLogger.a.i("SilentSyncManager", "isOSilentTransferEnabled: " + r2 + ' ');
        if (r2 == true) goto L11;
    L13:
        return false;
    L11:
        if (e != 1) goto L13;
        return true;
    L7:
        r2 = true;
        goto L8
    }

    public static void c() {
        String r0 = UUID.randomUUID().toString();
        Ref.BooleanRef r1 = new Ref.BooleanRef();
        boolean r5 = false;
        if (b() == true) goto L5;
        FLogger.a.i("SilentSyncManager", "preCheck: Silent sync switch is off, skipping silent media sync");
        GalleryMobHelper r2 = GalleryMobHelper.a;
        GalleryMobHelper.AlbumSyncInterceptionReason r6 = GalleryMobHelper.AlbumSyncInterceptionReason.SILENT_SYNC_OFF;
        r2.getClass();
        GalleryMobHelper.h(false, r0, r6);
        boolean r3 = false;
    L7:
        if (com.larus.avlink.gallery.f.a() == false) goto L9;
        FLogger.a.i("SilentSyncManager", "preCheck: Battery level is too low, skipping silent media sync");
        GalleryMobHelper r4 = GalleryMobHelper.a;
        GalleryMobHelper.AlbumSyncInterceptionReason r7 = GalleryMobHelper.AlbumSyncInterceptionReason.LOW_BATTERY;
        r4.getClass();
        GalleryMobHelper.h(false, r0, r7);
        r3 = false;
    L9:
        MediaSyncCoordinator r8 = MediaSyncCoordinator.a;
        if (MediaSyncCoordinator.i() == false) goto L12;
        FLogger.a.i("SilentSyncManager", "preCheck: Silent sync is disabled during another media sync in progress");
        GalleryMobHelper r9 = GalleryMobHelper.a;
        GalleryMobHelper.AlbumSyncInterceptionReason r10 = GalleryMobHelper.AlbumSyncInterceptionReason.IS_GETTING_MEDIAS;
        r9.getClass();
        GalleryMobHelper.h(false, r0, r10);
        r3 = false;
    L12:
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r11 == null) goto L19;
        DeviceService r12 = r11.device();
        if (r12 == null) goto L19;
        if (r12.e0() != true) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == false) goto L22;
        FLogger.a.i("SilentSyncManager", "preCheck: Silent sync is disabled during OTA");
        GalleryMobHelper r14 = GalleryMobHelper.a;
        GalleryMobHelper.AlbumSyncInterceptionReason r15 = GalleryMobHelper.AlbumSyncInterceptionReason.OTA_ACTIVE;
        r14.getClass();
        GalleryMobHelper.h(false, r0, r15);
        r3 = false;
    L22:
        IDoraService r16 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r16 == null) goto L29;
        DeviceService r17 = r16.device();
        if (r17 == null) goto L29;
        if (r17.U() != true) goto L29;
        boolean r18 = true;
    L30:
        if (r18 == false) goto L33;
        FLogger.a.i("SilentSyncManager", "preCheck: Silent sync is disabled during Feedback");
        GalleryMobHelper r19 = GalleryMobHelper.a;
        GalleryMobHelper.AlbumSyncInterceptionReason r20 = GalleryMobHelper.AlbumSyncInterceptionReason.FEEDBACK_ACTIVE;
        r19.getClass();
        GalleryMobHelper.h(false, r0, r20);
        r3 = false;
    L33:
        if (b98.b.b(1) == false) goto L36;
        FLogger.a.i("SilentSyncManager", "preCheck: Silent sync is disabled during Live AI mode");
        GalleryMobHelper r21 = GalleryMobHelper.a;
        GalleryMobHelper.AlbumSyncInterceptionReason r22 = GalleryMobHelper.AlbumSyncInterceptionReason.LIVE_AI;
        r21.getClass();
        GalleryMobHelper.h(false, r0, r22);
        r3 = false;
    L36:
        if (b98.b.b(3) == false) goto L38;
        FLogger.a.i("SilentSyncManager", "preCheck: Silent sync is disabled during recording");
        GalleryMobHelper r23 = GalleryMobHelper.a;
        GalleryMobHelper.AlbumSyncInterceptionReason r24 = GalleryMobHelper.AlbumSyncInterceptionReason.RECORDING;
        r23.getClass();
        GalleryMobHelper.h(false, r0, r24);
    L39:
        r1.element = r5;
        if (r5 == true) goto L42;
        FLogger.a.i("SilentSyncManager", "Silent sync pre check failed, skip this job.");
    L42:
        FLogger.a.i("SilentSyncManager", "startSyncWithDiff called - checking for new media");
        a = BuildersKt.launch$default(d, null, null, new SilentSyncManager$startSyncWithDiff$1(r0, r1, null), 3, null);
        return;
    L38:
        r5 = r3;
    L29:
        r18 = false;
    L19:
        r13 = false;
        goto L20
    L5:
        r3 = true;
        goto L7
    }

    public static final void a(String r9) {
        if (b == null) goto L7;
        FLogger.a.d("SilentSyncManager", "Cancelling previous auto sync schedule");
        Timer r0 = b;
        if (r0 == null) goto L7;
        r0.cancel();
    L7:
        FLogger.a.i("SilentSyncManager", "Scheduling auto sync in 600000ms for reason: ".concat(r9));
        Timer r1 = TimersKt.timer("DoraGSilentSync", false);
        r1.scheduleAtFixedRate(new com.larus.avlink.gallery.silent.b(r9), 0, 600000);
        b = r1;
    }

    public static void d(String r5) {
        FLogger r0 = FLogger.a;
        r0.i("SilentSyncManager", "Stopping silent sync operation");
        Job r2 = a;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r3 == false) goto L13;
        r0.d("SilentSyncManager", "Cancelling current sync job");
        Job r4 = a;
        if (r4 == null) goto L13;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L13:
        r0.d("SilentSyncManager", "Cancelling auto sync timer");
        Timer r6 = b;
        if (r6 == null) goto L16;
        r6.cancel();
    L16:
        r0.d("SilentSyncManager", "Delegating sync stop to HardwareMediaLoadService");
        MediaSyncCoordinator r7 = MediaSyncCoordinator.a;
        if (MediaSyncCoordinator.i() == true) goto L19;
    L21:
        r0.i("SilentSyncManager", "Silent sync operation stopped successfully");
        return;
    L19:
        if (MediaSyncCoordinator.f != MediaSyncCoordinator.SyncMode.SILENT) goto L21;
        MediaSyncCoordinator.w(r5, null, 6);
        goto L21
    L5:
        if (r2.isActive() != true) goto L7;
        r3 = true;
        goto L9
    }
}
