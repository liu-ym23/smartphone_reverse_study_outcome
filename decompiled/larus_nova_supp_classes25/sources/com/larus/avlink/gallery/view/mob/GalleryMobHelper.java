package com.larus.avlink.gallery.view.mob;

import androidx.core.content.ContextCompat;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.g;
import com.larus.avlink.gallery.j;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.platform.model.GeoLocationInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class GalleryMobHelper {
    public static final GalleryMobHelper a = null;
    public static volatile long b;
    public static volatile long c;
    public static volatile String d;
    public static volatile String e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/avlink/gallery/view/mob/GalleryMobHelper$AlbumSyncInterceptionReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SILENT_SYNC_OFF", "IS_GETTING_MEDIAS", "HAS_NO_CONTENT", "RECORDING", "LIVE_AI", "OTA_ACTIVE", "FEEDBACK_ACTIVE", "LOW_BATTERY", "SUCCESS", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum AlbumSyncInterceptionReason extends Enum<AlbumSyncInterceptionReason> {
        public static final AlbumSyncInterceptionReason FEEDBACK_ACTIVE = null;
        public static final AlbumSyncInterceptionReason HAS_NO_CONTENT = null;
        public static final AlbumSyncInterceptionReason IS_GETTING_MEDIAS = null;
        public static final AlbumSyncInterceptionReason LIVE_AI = null;
        public static final AlbumSyncInterceptionReason LOW_BATTERY = null;
        public static final AlbumSyncInterceptionReason OTA_ACTIVE = null;
        public static final AlbumSyncInterceptionReason RECORDING = null;
        public static final AlbumSyncInterceptionReason SILENT_SYNC_OFF = null;
        public static final AlbumSyncInterceptionReason SUCCESS = null;
        public static final /* synthetic */ AlbumSyncInterceptionReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<AlbumSyncInterceptionReason> getEntries() {
            return b;
        }

        static {
            AlbumSyncInterceptionReason r0 = new AlbumSyncInterceptionReason("SILENT_SYNC_OFF", 0, "silent_sync_off");
            SILENT_SYNC_OFF = r0;
            AlbumSyncInterceptionReason r1 = new AlbumSyncInterceptionReason("IS_GETTING_MEDIAS", 1, "is_getting_medias");
            IS_GETTING_MEDIAS = r1;
            AlbumSyncInterceptionReason r2 = new AlbumSyncInterceptionReason("HAS_NO_CONTENT", 2, "has_no_content");
            HAS_NO_CONTENT = r2;
            AlbumSyncInterceptionReason r4 = new AlbumSyncInterceptionReason("RECORDING", 3, "recording");
            RECORDING = r4;
            AlbumSyncInterceptionReason r6 = new AlbumSyncInterceptionReason("LIVE_AI", 4, "live_ai");
            LIVE_AI = r6;
            AlbumSyncInterceptionReason r8 = new AlbumSyncInterceptionReason("OTA_ACTIVE", 5, "ota_active");
            OTA_ACTIVE = r8;
            AlbumSyncInterceptionReason r10 = new AlbumSyncInterceptionReason("FEEDBACK_ACTIVE", 6, "feedback_active");
            FEEDBACK_ACTIVE = r10;
            AlbumSyncInterceptionReason r12 = new AlbumSyncInterceptionReason("LOW_BATTERY", 7, "low_battery");
            LOW_BATTERY = r12;
            AlbumSyncInterceptionReason r14 = new AlbumSyncInterceptionReason("SUCCESS", 8, "");
            SUCCESS = r14;
            AlbumSyncInterceptionReason[] r13 = {r0, r1, r2, r4, r6, r8, r10, r12, r14};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static AlbumSyncInterceptionReason[] values() {
            return (AlbumSyncInterceptionReason[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AlbumSyncInterceptionReason valueOf(String r1) {
            return (AlbumSyncInterceptionReason) r27.a.a(AlbumSyncInterceptionReason.class, r1);
        }

        public AlbumSyncInterceptionReason(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/gallery/view/mob/GalleryMobHelper$AlbumSyncMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SILENT", "MANUAL", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum AlbumSyncMode extends Enum<AlbumSyncMode> {
        public static final AlbumSyncMode MANUAL = null;
        public static final AlbumSyncMode SILENT = null;
        public static final /* synthetic */ AlbumSyncMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<AlbumSyncMode> getEntries() {
            return b;
        }

        static {
            AlbumSyncMode r0 = new AlbumSyncMode("SILENT", 0, "album_silent");
            SILENT = r0;
            AlbumSyncMode r1 = new AlbumSyncMode("MANUAL", 1, "album");
            MANUAL = r1;
            AlbumSyncMode[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static AlbumSyncMode[] values() {
            return (AlbumSyncMode[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AlbumSyncMode valueOf(String r1) {
            return (AlbumSyncMode) r27.a.a(AlbumSyncMode.class, r1);
        }

        public AlbumSyncMode(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaSyncCoordinator.SyncMode.values().length];
            r0[MediaSyncCoordinator.SyncMode.SILENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public GalleryMobHelper() {
    }

    static {
        a = new GalleryMobHelper();
        d = AlbumSyncMode.MANUAL.getValue();
        new ConcurrentHashMap();
    }

    public static String a() {
        String r0 = e;
        if (r0 != null) goto L6;
        String r1 = UUID.randomUUID().toString();
        e = r1;
        return r1;
    L6:
        return r0;
    }

    public static void f(MediaSyncCoordinator.SyncMode r1) {
        Intrinsics.checkNotNullParameter(r1, "mode");
        if (a.a[r1.ordinal()] != 1) goto L5;
        String r2 = AlbumSyncMode.SILENT.getValue();
    L6:
        d = r2;
        return;
    L5:
        r2 = AlbumSyncMode.MANUAL.getValue();
        goto L6
    }

    public static /* synthetic */ void e(GalleryMobHelper r7, int r8) {
        r7.getClass();
        d(r8, 0, 0, 0, 0, 0);
    }

    public static void i(String r2, Map r3) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L6;
        r0.A0(r2, r3);
        return;
    }

    public static void g(long r1, boolean r3, String r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("duration", Long.valueOf(r1));
        r0.put("success", Integer.valueOf(r3 ? 1 : 0));
        r0.put("err_info", r4);
        i("flow_dora_album_get_list", r0);
    }

    public static void h(boolean r3, String r4, AlbumSyncInterceptionReason r5) {
        Intrinsics.checkNotNullParameter(r4, "silentTaskId");
        Intrinsics.checkNotNullParameter(r5, "reason");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("success", Integer.valueOf(r3 ? 1 : 0));
        r1.put("silent_task_id", r4);
        r1.put("reason", r5.getValue());
        i("flow_album_silent_sync_check", r1);
    }

    public static void c(int r7, double r8, MediaMetadata r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "metadata");
        Intrinsics.checkNotNullParameter(r11, "algorithms");
        String r1 = a();
        int r3 = 0;
        if (g.a() == false) goto L6;
        String r2 = "authorized";
    L12:
        Pair[] r5 = new Pair[9];
        r5[0] = TuplesKt.to("task_id", r1);
        r5[1] = TuplesKt.to("status", Integer.valueOf(r7));
        r5[2] = TuplesKt.to("duration", Double.valueOf(r8));
        String r9 = r10.getMediaType();
        if (r9 != null) goto L15;
        r9 = "image";
    L15:
        r5[3] = TuplesKt.to("media_type", r9);
        Long r12 = r10.getFileSize();
        if (r12 == null) goto L18;
        long r13 = r12.longValue();
    L19:
        r5[4] = TuplesKt.to("media_size", Long.valueOf(r13));
        r5[5] = TuplesKt.to("algorithms", r11);
        if (r10.getGeoLocationInfo() == null) goto L22;
        int r14 = 1;
    L23:
        r5[6] = TuplesKt.to("has_location_info", Integer.valueOf(r14));
        r5[7] = TuplesKt.to("location_auth_state", r2);
        IDoraService r15 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r15 == null) goto L30;
        VisionService r16 = r15.V();
        if (r16 == null) goto L30;
        if (r16.p() != true) goto L30;
        r3 = 1;
    L30:
        r5[8] = TuplesKt.to("location_switch_state", Integer.valueOf(r3));
        i("flow_gallery_single_processed_show", MapsKt.mutableMapOf(r5));
        return;
    L22:
        r14 = 0;
        goto L23
    L18:
        r13 = 0;
        goto L19
    L6:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.ACCESS_FINE_LOCATION") != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r2 = "fine_location_authorized";
        goto L12
    L11:
        r2 = "denied";
        goto L12
    L8:
        r4 = false;
        goto L9
    }

    public static void j(String r3, GeoLocationInfo r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "mediaType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("media_type", r3);
        int r7 = 1;
        r0.put("has_location_info", 1);
        r0.put("success", Integer.valueOf(r5 ? 1 : 0));
        r0.put("err_info", r6);
        String r8 = r4.getPoi();
        if (r8 != null) goto L5;
    L10:
        r7 = 0;
    L11:
        r0.put("has_poi", Integer.valueOf(r7));
        i("dora_album_add_location", r0);
        return;
    L5:
        if (r8.length() <= 0) goto L7;
        boolean r9 = true;
    L8:
        if (r9 != true) goto L10;
    L7:
        r9 = false;
        goto L8
    }

    public static void l(int r2, long r3, int r5, int r6, int r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("media_count", Integer.valueOf(r2));
        r0.put("duration", Long.valueOf(r3));
        r0.put("success", Integer.valueOf(r5));
        r0.put("code", Integer.valueOf(r6));
        r0.put("timeout_interval", 20000);
        r0.put("retry_count", Integer.valueOf(r7));
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L6;
        r4.A0("flow_dora_thumbnail_get_list", r0);
        return;
    }

    public static void d(int r10, long r11, int r13, int r14, int r15, int r16) {
        String r0 = a();
        long r1 = System.currentTimeMillis();
        if (c <= 0) goto L5;
        long r3 = r1 - c;
    L7:
        if (b <= 0) goto L9;
        long r2 = r1 - b;
    L10:
        i("flow_gallery_sync_task_end", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("task_id", r0), TuplesKt.to("status", Integer.valueOf(r10)), TuplesKt.to("duration", Long.valueOf(r3)), TuplesKt.to("total_duration", Long.valueOf(r2)), TuplesKt.to("with_no_permission", Boolean.FALSE), TuplesKt.to("total_size", Long.valueOf(r11 / ((long) 1024))), TuplesKt.to("media_photo_count", Integer.valueOf(r13)), TuplesKt.to("media_video_count", Integer.valueOf(r14)), TuplesKt.to("media_photo_success_count", Integer.valueOf(r15)), TuplesKt.to("media_video_success_count", Integer.valueOf(r16)), TuplesKt.to("media_count", Integer.valueOf(r13 + r14)), TuplesKt.to("media_success_count", Integer.valueOf(r15 + r16)), TuplesKt.to("scene", d)}));
        e = null;
        b = 0;
        c = 0;
        d = AlbumSyncMode.MANUAL.getValue();
        return;
    L9:
        r2 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L7
    }

    public static void k(String r2, long r3, String r5, int r6, int r7, long r8, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r2, "id");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("id", r2);
        r1.put("duration", Long.valueOf(r3));
        String r4 = j.e(r5);
        String r9 = "image";
        if (Intrinsics.areEqual(r4, "image") == true) goto L9;
        r9 = "video";
        if (Intrinsics.areEqual(r4, "video") == true) goto L9;
        r9 = "unknown";
    L9:
        r1.put("media_type", r9);
        r1.put("code", Integer.valueOf(r7));
        r1.put("timeout_interval", Long.valueOf(r8));
        r1.put("success", Integer.valueOf(r6));
        r1.put("retry_count", Integer.valueOf(r10));
        r1.put("media_size", Integer.valueOf(r11));
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L13;
        r12.A0("flow_dora_thumbnail_get_item", r1);
        return;
    }

    public static void b(int r10, double r11, long r13, String r15, long r16, String r18, int r19, String r20, String r21, String r22, int r23, int r24, long r25) {
        Intrinsics.checkNotNullParameter(r15, "mediaType");
        Intrinsics.checkNotNullParameter(r18, "algorithms");
        Intrinsics.checkNotNullParameter(r20, "resultAlgorithm");
        Intrinsics.checkNotNullParameter(r21, "sdkVersion");
        Intrinsics.checkNotNullParameter(r22, "background");
        Pair[] r8 = new Pair[14];
        r8[0] = TuplesKt.to("task_id", a());
        r8[1] = TuplesKt.to("status", Integer.valueOf(r10));
        r8[2] = TuplesKt.to("duration", Double.valueOf(r11));
        r8[3] = TuplesKt.to("process_duration", Long.valueOf(r13));
        String r5 = j.e(r15);
        String r7 = "image";
        if (Intrinsics.areEqual(r5, "image") == true) goto L9;
        r7 = "video";
        if (Intrinsics.areEqual(r5, "video") == true) goto L9;
        r7 = "unknown";
    L9:
        r8[4] = TuplesKt.to("media_type", r7);
        r8[5] = TuplesKt.to("media_size", Long.valueOf(r16));
        r8[6] = TuplesKt.to("algorithms", r18);
        r8[7] = TuplesKt.to("code", Integer.valueOf(r19));
        r8[8] = TuplesKt.to("result_algorithm", r20);
        r8[9] = TuplesKt.to("sdk_version", r21);
        r8[10] = TuplesKt.to("background", r22);
        r8[11] = TuplesKt.to("width", Integer.valueOf(r23));
        r8[12] = TuplesKt.to("height", Integer.valueOf(r24));
        r8[13] = TuplesKt.to("media_duration", Long.valueOf(r25));
        i("flow_gallery_single_algorithm_processing_end", MapsKt.mutableMapOf(r8));
    }
}
