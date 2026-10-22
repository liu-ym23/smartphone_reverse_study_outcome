package com.larus.avlink.gallery.compat;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.polaris.PolarisFile;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.g;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.service.l1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ThumbnailMetadataHelper {
    public static final ThumbnailMetadataHelper a = null;

    static {
        a = new ThumbnailMetadataHelper();
    }

    public ThumbnailMetadataHelper() {
    }

    public final Object c(List<Long> r13, String r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof ThumbnailMetadataHelper$deleteBatchThumbnailData$1) == false) goto L7;
        ThumbnailMetadataHelper$deleteBatchThumbnailData$1 r0 = (ThumbnailMetadataHelper$deleteBatchThumbnailData$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        r13 = (List) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L53
    L51:
        FLogger.a.i("ThumbnailMetadataHelper", "Batch deleted " + r13.size() + " thumbnail data");     // Catch: Exception -> L53
    L56:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r17 = (String) r0.L$2;
        r14 = (String) r0.L$1;
        List<Long> r4 = (List) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L53
        String r18 = r17;
        r13 = r4;
        Object r5 = r16;
    L24:
        Iterable r6 = (Iterable) r5;     // Catch: Exception -> L53
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));     // Catch: Exception -> L53
        Iterator r8 = r6.iterator();     // Catch: Exception -> L53
    L26:
        if (r8.hasNext() == false) goto L28;
        r7.add(((ThumbnailMetadata) r8.next()).getFilePath());     // Catch: Exception -> L53
        goto L26
    L28:
        Iterator r9 = r7.iterator();     // Catch: Exception -> L53
    L30:
        if (r9.hasNext() == false) goto L48;
        String r10 = (String) r9.next();     // Catch: Exception -> L53
        if (r10 == null) goto L39;
    L34:
        if (r10.length() == 0) goto L39;
        boolean r11 = false;
    L40:
        if (r11 == true) goto L30;
        Intrinsics.checkNotNull(r18);     // Catch: Exception -> L37
        File r12 = PolarisFile.getSafeFileOrNullUnderAllowedFolder(r10, r18);     // Catch: Exception -> L37
        if (r12 == null) goto L30;
        if (r12.exists() == false) goto L30;
        r12.delete();     // Catch: Exception -> L37
        FLogger.a.i("ThumbnailMetadataHelper", "Deleted thumbnail file: " + r10);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        FLogger.a.e("ThumbnailMetadataHelper", "Error deleting thumbnail file: " + r10 + ", " + e.getMessage());     // Catch: Exception -> L53
    L39:
        r11 = true;
        goto L40
    L48:
        AlbumDataBaseHelper r19 = AlbumDataBaseHelper.a;     // Catch: Exception -> L53
        r0.L$0 = r13;     // Catch: Exception -> L53
        r0.L$1 = null;     // Catch: Exception -> L53
        r0.L$2 = null;     // Catch: Exception -> L53
        r0.label = 2;     // Catch: Exception -> L53
        if (r19.g(r13, r14, r0) != r2) goto L51;
        return r2;
    L20:
        ResultKt.throwOnFailure(r16);
        r18 = AppHost.a.getApplication().getFilesDir().getAbsolutePath();
        AlbumDataBaseHelper r20 = AlbumDataBaseHelper.a;     // Catch: Exception -> L53
        r0.L$0 = r13;     // Catch: Exception -> L53
        r0.L$1 = r14;     // Catch: Exception -> L53
        r0.L$2 = r18;     // Catch: Exception -> L53
        r0.label = 1;     // Catch: Exception -> L53
        r5 = r20.x(r13, r14, r0);     // Catch: Exception -> L53
        if (r5 != r2) goto L24;
        return r2;
    L53:
        e = move-exception;
        FLogger.a.e("ThumbnailMetadataHelper", "Error batch deleting thumbnail data: " + e.getMessage(), e);
    L7:
        r0 = new ThumbnailMetadataHelper$deleteBatchThumbnailData$1(this, r15);
        goto L8
    }

    public final Object d(long r8, String r10, String r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof ThumbnailMetadataHelper$deleteThumbnailData$1) == false) goto L7;
        ThumbnailMetadataHelper$deleteThumbnailData$1 r2 = (ThumbnailMetadataHelper$deleteThumbnailData$1) r12;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r13 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = true;
        if (r5 == 0) goto L16;
        if (r5 != 1) goto L15;
        r8 = r2.J$0;
        r10 = (String) r2.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L31
    L20:
        if (r10 != null) goto L22;
    L25:
        if (r6 == true) goto L29;
        PolarisFileWrapper r14 = new PolarisFileWrapper(r10);     // Catch: Exception -> L31
        if (r14.exists() == false) goto L29;
        r14.delete();     // Catch: Exception -> L31
        FLogger.a.i("ThumbnailMetadataHelper", "Deleted thumbnail file: " + r10);     // Catch: Exception -> L31
    L29:
        FLogger.a.i("ThumbnailMetadataHelper", "Deleted thumbnail data for imageUuid: " + r8);     // Catch: Exception -> L31
    L34:
        return Unit.INSTANCE;
    L22:
        if (r10.length() == 0) goto L25;
        r6 = false;
        goto L25
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r13);
        AlbumDataBaseHelper r15 = AlbumDataBaseHelper.a;     // Catch: Exception -> L31
        r2.L$0 = r10;     // Catch: Exception -> L31
        r2.J$0 = r8;     // Catch: Exception -> L31
        r2.label = 1;     // Catch: Exception -> L31
        if (r15.f(r8, r11, r2) != r4) goto L20;
        return r4;
    L31:
        e = move-exception;
        FLogger.a.e("ThumbnailMetadataHelper", "Error deleting thumbnail data: " + e.getMessage(), e);
    L7:
        r2 = new ThumbnailMetadataHelper$deleteThumbnailData$1(this, r12);
        goto L8
    }

    public static ThumbnailMetadata b(String r26, long r27, String r29, int r30, int r31, long r32, long r34) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r26);
        long r19 = System.currentTimeMillis();
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        int r2 = 0;
        if (r1 == null) goto L9;
        VisionService r3 = r1.V();
        if (r3 == null) goto L9;
        if (r3.p() != true) goto L9;
        int r4 = 1;
    L10:
        boolean r5 = g.a();
        if (r4 == 0) goto L14;
        if (r5 == false) goto L14;
        boolean r6 = true;
    L15:
        FLogger.a.i("ThumbnailMetadataHelper", "createThumbnailMetadataObject isRecordLocationEnabled: " + r6);
        if (r6 == false) goto L18;
        GeoLocationInfo r7 = l1.a.e(r34);
    L19:
        GeoLocationInfo r21 = r7;
        GalleryMobHelper.a.getClass();
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("has_auth", Integer.valueOf(r5 ? 1 : 0));
        r8.put("switch_open", Integer.valueOf(r4));
        r8.put("time_out", 0);
        r8.put("success", 1);
        if (r21 == null) goto L29;
        String r9 = r21.getPoi();
        if (r9 == null) goto L29;
        if (r9.length() <= 0) goto L26;
        boolean r10 = true;
    L27:
        if (r10 != true) goto L29;
        r2 = 1;
        goto L29
    L26:
        r10 = false;
    L29:
        r8.put("has_poi", Integer.valueOf(r2));
        GalleryMobHelper.i("dora_album_location_save", r8);
        String r11 = UUID.randomUUID().toString();
        String r12 = r0.getName();
        long r13 = r0.length();
        IDoraService r14 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r14 == null) goto L34;
        DeviceService r15 = r14.device();
        if (r15 == null) goto L34;
        String r16 = r15.m();
    L36:
        return new ThumbnailMetadata(r11, r26, r12, r13, r16, r27, r29, r30, r31, r32, r34, r19, r19, r21, "thumbnail", 0, false);
    L34:
        r16 = "";
        goto L36
    L18:
        r7 = null;
    L14:
        r6 = false;
    L9:
        r4 = 0;
        goto L10
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final Object a(String r20, long r21, String r23, int r24, int r25, long r26, long r28, Continuation r30) {
        long r11 = r21;
        String r14 = "Created thumbnail metadata: fileId=";
        if ((r30 instanceof ThumbnailMetadataHelper$createThumbnailMetadata$1) == false) goto L7;
        ThumbnailMetadataHelper$createThumbnailMetadata$1 r1 = (ThumbnailMetadataHelper$createThumbnailMetadata$1) r30;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        ThumbnailMetadataHelper$createThumbnailMetadata$1 r0 = r1;
        Object r3 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 != 0) goto L55;
        ResultKt.throwOnFailure(r3);
        if (r20 != null) goto L28;
        String r5 = "";
    L29:
        String r15 = "ThumbnailMetadataHelper";
        ThumbnailMetadata r6 = b(r5, r21, r23, r24, r25, r26, r28);     // Catch: Exception -> L48
        AlbumDataBaseHelper r7 = AlbumDataBaseHelper.a;     // Catch: Exception -> L45
        String r8 = r6.getSn();     // Catch: Exception -> L45
        r0.L$0 = r6;     // Catch: Exception -> L45
        r0.J$0 = r11;     // Catch: Exception -> L45
        r0.label = 1;     // Catch: Exception -> L45
        Object r9 = r7.w(r11, r8, r0);     // Catch: Exception -> L45
        Object r12 = r10;
        if (r9 != r12) goto L34;
        return r12;
    L34:
        ThumbnailMetadata r13 = r6;
        r3 = r9;
    L36:
        if (((ThumbnailMetadata) r3) == null) goto L39;
        FLogger.a.i(r15, "createThumbnailMetadata: metadata already exists, imageUuid=" + r11 + ", sn=" + r13.getSn());     // Catch: Exception -> L45
        return Unit.INSTANCE;
    L39:
        AlbumDataBaseHelper r16 = AlbumDataBaseHelper.a;     // Catch: Exception -> L45
        r0.L$0 = r13;     // Catch: Exception -> L45
        r0.J$0 = r11;     // Catch: Exception -> L45
        r0.label = 2;     // Catch: Exception -> L45
        if (r16.j(r13, r0) != r12) goto L42;
        return r12;
    L42:
        ThumbnailMetadata r17 = r13;
        long r18 = r11;
    L43:
        FLogger.a.i(r15, r14 + r17.getFileId() + ", imageUuid=" + r18);     // Catch: Exception -> L45
    L51:
        return Unit.INSTANCE;
    L45:
        e = e;
    L46:
        FLogger.a.e(r15, "Error creating thumbnail metadata: " + e.getMessage(), e);     // Catch: Exception -> L48
    L48:
        e = move-exception;
        FLogger.a.e(r15, "Error creating thumbnail metadata process: " + e.getMessage(), e);
        goto L51
    L28:
        r5 = r20;
        goto L29
    L55:
        if (r4 == 1) goto L17;
        if (r4 != 2) goto L16;
        r18 = r0.J$0;
        r17 = (ThumbnailMetadata) r0.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Exception -> L20
        r14 = "Created thumbnail metadata: fileId=";
        r15 = "ThumbnailMetadataHelper";
        goto L43
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r19 = r0.J$0;
        r13 = (ThumbnailMetadata) r0.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Exception -> L20
        r11 = r19;
        r12 = r10;
        r15 = "ThumbnailMetadataHelper";
    L20:
        e = e;
        r15 = "ThumbnailMetadataHelper";
    L7:
        r1 = new ThumbnailMetadataHelper$createThumbnailMetadata$1(this, r30);
        goto L8
    }

    public final Object e(String r20, long r21, String r23, int r24, int r25, long r26, long r28, Continuation r30) {
        if ((r30 instanceof ThumbnailMetadataHelper$updateThumbnailMetadata$1) == false) goto L7;
        ThumbnailMetadataHelper$updateThumbnailMetadata$1 r3 = (ThumbnailMetadataHelper$updateThumbnailMetadata$1) r30;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        long r7 = r3.J$0;
        ThumbnailMetadata r8 = (ThumbnailMetadata) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
    L29:
        FLogger.a.i("ThumbnailMetadataHelper", "Updated thumbnail metadata: fileId=" + r8.getFileId() + ", imageUuid=" + r7);     // Catch: Exception -> L14
    L35:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        if (r20 != null) goto L23;
        String r9 = "";
    L24:
        ThumbnailMetadata r1 = b(r9, r21, r23, r24, r25, r26, r28);     // Catch: Exception -> L21
        AlbumDataBaseHelper r10 = AlbumDataBaseHelper.a;     // Catch: Exception -> L14
        r3.L$0 = r1;     // Catch: Exception -> L14
        r3.J$0 = r21;     // Catch: Exception -> L14
        r3.label = 1;     // Catch: Exception -> L14
        if (r10.B(r1, r3) != r5) goto L28;
        return r5;
    L28:
        r8 = r1;
        r7 = r21;
        goto L29
    L23:
        r9 = r20;
    L21:
        e = move-exception;
        FLogger.a.e("ThumbnailMetadataHelper", "Error updating thumbnail metadata process: " + e.getMessage(), e);
    L14:
        e = move-exception;
        FLogger.a.e("ThumbnailMetadataHelper", "Error updating thumbnail metadata: " + e.getMessage(), e);     // Catch: Exception -> L21
    L7:
        r3 = new ThumbnailMetadataHelper$updateThumbnailMetadata$1(this, r30);
        goto L8
    }
}
