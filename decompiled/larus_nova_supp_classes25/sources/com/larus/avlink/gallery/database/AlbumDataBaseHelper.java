package com.larus.avlink.gallery.database;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import com.larus.dora.api.IDoraService;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AlbumDataBaseHelper {
    public static final AlbumDataBaseHelper a = null;
    public static final Gson b = null;

    public AlbumDataBaseHelper() {
    }

    static {
        a = new AlbumDataBaseHelper();
        b = new Gson();
    }

    public static void A(MediaMetadata r14) {
        Intrinsics.checkNotNullParameter(r14, "mediaMetadata");
        long r2 = System.currentTimeMillis();
        int r4 = AlbumDatabase.a.a().c().a(k(r14));     // Catch: Exception -> L9
        FLogger.a.i("AlbumDataBaseHelper", "updateMediaDataSync: uniqId=" + r14.getUniqId() + ", mediaId=" + r14.getMediaId() + ", rows=" + r4);     // Catch: Exception -> L9
        long r9 = System.currentTimeMillis() - r2;     // Catch: Exception -> L9
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L9
        if (GalleryStoragePolicyManager.m() == false) goto L6;
        int r12 = 1;
    L7:
        l(MemoryActionTag.MEMORY_ACTION_TAG_UPDATE, "album", 1, r9, 1, r12, "");     // Catch: Exception -> L9
        return;
    L6:
        r12 = 0;
    L9:
        e = move-exception;
        FLogger.a.e("AlbumDataBaseHelper", "updateMediaDataSync: " + e.getMessage(), e);
        long r8 = System.currentTimeMillis() - r2;
        GalleryStoragePolicyManager.a.getClass();
        boolean r11 = GalleryStoragePolicyManager.m();
        String r15 = e.getMessage();
        if (r15 != null) goto L13;
        r15 = "";
    L13:
        l(MemoryActionTag.MEMORY_ACTION_TAG_UPDATE, "album", 1, r8, 0, r11 ? 1 : 0, r15);
    }

    public static a k(MediaMetadata r33) {
        String r1 = r33.getUniqId();
        long r2 = r33.getMediaId();
        Long r4 = r33.getSystemGalleryId();
        String r5 = r33.getFileName();
        Long r6 = r33.getFileSize();
        String r7 = r33.getMediaType();
        int r8 = r33.getWidth();
        int r9 = r33.getHeight();
        long r10 = r33.getDuration();
        int r12 = r33.getOutVideoWidth();
        int r13 = r33.getOutVideoHeight();
        double r14 = r33.getOutputVideoCrop();
        long r16 = r33.getCreateTime();
        GeoLocationInfo r0 = r33.getGeoLocationInfo();
        if (r0 == null) goto L5;
        String r21 = GsonProtectorUtils.toJson(b, r0);
    L6:
        String r30 = r33.getAlgorithmType();
        int r31 = r33.getLifecycleState().getValue();
        MediaLifecycleState r3 = r33.getFailureStage();
        if (r3 == null) goto L9;
        Integer r32 = Integer.valueOf(r3.getValue());
    L11:
        return new a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r16, r21, r30, r31, r32, r33.getFailureReason(), r33.getDownloadFilePath(), r33.getTempFilePath(), r33.getUnpackDirPath(), r33.getProcessedFilePath(), r33.getFinalFilePath(), r33.getActiveMask());
    L9:
        r32 = null;
        goto L11
    L5:
        r21 = null;
        goto L6
    }

    public final Object m(Continuation<? super List<MediaMetadata>> r22) {
        if ((r22 instanceof AlbumDataBaseHelper$selectAllMediaData$1) == false) goto L7;
        AlbumDataBaseHelper$selectAllMediaData$1 r3 = (AlbumDataBaseHelper$selectAllMediaData$1) r22;
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
        int r9 = r3.I$0;
        String r10 = (String) r3.L$2;
        String r11 = (String) r3.L$1;
        AlbumDataBaseHelper r8 = (AlbumDataBaseHelper) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
        String r18 = r10;
        String r19 = r11;
    L46:
        List r1 = (List) r0;     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "selectAllMediaData: result=" + r1);     // Catch: Exception -> L33
        List r2 = r1;     // Catch: Exception -> L33
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));     // Catch: Exception -> L33
        Iterator r13 = r2.iterator();     // Catch: Exception -> L33
    L25:
        if (r13.hasNext() == false) goto L27;
        r12.add(a(a, (a) r13.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r14 = r12.size();     // Catch: Exception -> L33
        long r15 = System.currentTimeMillis() - r7;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r16 = 1;
    L31:
        r8.getClass();     // Catch: Exception -> L33
        l(r19, r18, r14, r15, 1, r16, "");     // Catch: Exception -> L33
    L41:
        if (r12 == null) goto L43;
        return r12;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r16 = 0;
    L33:
        e = e;
        int r17 = r9;
        r10 = r18;
        String r20 = r19;
    L37:
        long r110 = System.currentTimeMillis() - r7;
        GalleryStoragePolicyManager.a.getClass();
        boolean r111 = GalleryStoragePolicyManager.m();
        String r21 = e.getMessage();
        if (r21 != null) goto L40;
        r21 = "";
    L40:
        r8.getClass();
        l(r20, r10, r17, r110, 0, r111 ? 1 : 0, r21);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r12 = null;
    L14:
        e = e;
        r17 = r9;
        r20 = r11;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r10 = "album";
        long r112 = System.currentTimeMillis();
        b r23 = AlbumDatabase.a.a().c();     // Catch: Exception -> L35
        r3.L$0 = this;     // Catch: Exception -> L35
        r3.L$1 = "batch_load";     // Catch: Exception -> L35
        r3.L$2 = "album";     // Catch: Exception -> L35
        r3.I$0 = 0;     // Catch: Exception -> L35
        r3.J$0 = r112;     // Catch: Exception -> L35
        r3.label = 1;     // Catch: Exception -> L35
        r0 = r23.h(r3);     // Catch: Exception -> L35
        if (r0 != r5) goto L22;
        return r5;
    L22:
        r8 = this;
        r18 = "album";
        r19 = "batch_load";
        r7 = r112;
        r9 = 0;
    L35:
        e = e;
        r8 = this;
        r20 = "batch_load";
        r7 = r112;
        r17 = 0;
    L7:
        r3 = new AlbumDataBaseHelper$selectAllMediaData$1(this, r22);
        goto L8
    }

    public final Object n(Continuation<? super List<ThumbnailMetadata>> r22) {
        if ((r22 instanceof AlbumDataBaseHelper$selectAllThumbnailData$1) == false) goto L7;
        AlbumDataBaseHelper$selectAllThumbnailData$1 r3 = (AlbumDataBaseHelper$selectAllThumbnailData$1) r22;
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
        int r9 = r3.I$0;
        String r10 = (String) r3.L$2;
        String r11 = (String) r3.L$1;
        AlbumDataBaseHelper r8 = (AlbumDataBaseHelper) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
        String r18 = r10;
        String r19 = r11;
    L46:
        List r1 = (List) r0;     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "selectAllThumbnailData: result=" + r1);     // Catch: Exception -> L33
        List r2 = r1;     // Catch: Exception -> L33
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));     // Catch: Exception -> L33
        Iterator r13 = r2.iterator();     // Catch: Exception -> L33
    L25:
        if (r13.hasNext() == false) goto L27;
        r12.add(b(a, (i) r13.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r14 = r12.size();     // Catch: Exception -> L33
        long r15 = System.currentTimeMillis() - r7;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r16 = 1;
    L31:
        r8.getClass();     // Catch: Exception -> L33
        l(r19, r18, r14, r15, 1, r16, "");     // Catch: Exception -> L33
    L41:
        if (r12 == null) goto L43;
        return r12;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r16 = 0;
    L33:
        e = e;
        int r17 = r9;
        r10 = r18;
        String r20 = r19;
    L37:
        long r110 = System.currentTimeMillis() - r7;
        GalleryStoragePolicyManager.a.getClass();
        boolean r111 = GalleryStoragePolicyManager.m();
        String r21 = e.getMessage();
        if (r21 != null) goto L40;
        r21 = "";
    L40:
        r8.getClass();
        l(r20, r10, r17, r110, 0, r111 ? 1 : 0, r21);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r12 = null;
    L14:
        e = e;
        r17 = r9;
        r20 = r11;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r10 = "album_thumbnail";
        long r112 = System.currentTimeMillis();
        j r23 = AlbumDatabase.a.a().d();     // Catch: Exception -> L35
        r3.L$0 = this;     // Catch: Exception -> L35
        r3.L$1 = "batch_load";     // Catch: Exception -> L35
        r3.L$2 = "album_thumbnail";     // Catch: Exception -> L35
        r3.I$0 = 0;     // Catch: Exception -> L35
        r3.J$0 = r112;     // Catch: Exception -> L35
        r3.label = 1;     // Catch: Exception -> L35
        r0 = r23.f(r3);     // Catch: Exception -> L35
        if (r0 != r5) goto L22;
        return r5;
    L22:
        r8 = this;
        r18 = "album_thumbnail";
        r19 = "batch_load";
        r7 = r112;
        r9 = 0;
    L35:
        e = e;
        r8 = this;
        r20 = "batch_load";
        r7 = r112;
        r17 = 0;
    L7:
        r3 = new AlbumDataBaseHelper$selectAllThumbnailData$1(this, r22);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object q(Continuation<? super Integer> r22) {
        if ((r22 instanceof AlbumDataBaseHelper$selectMediaDataCount$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataCount$1 r3 = (AlbumDataBaseHelper$selectMediaDataCount$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        int r7 = 0;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        long r8 = r3.J$0;
        int r9 = r3.I$0;
        String r10 = (String) r3.L$2;
        String r11 = (String) r3.L$1;
        AlbumDataBaseHelper r12 = (AlbumDataBaseHelper) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
        String r18 = r10;
        String r19 = r11;
    L49:
        int r1 = ((Number) r0).intValue();     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "selectMediaDataCount: count=" + r1);     // Catch: Exception -> L33
        Object r2 = Boxing.boxInt(r1);     // Catch: Exception -> L33
        if ((r2 instanceof List) == false) goto L26;
        int r13 = ((List) r2).size();     // Catch: Exception -> L33
    L27:
        long r14 = System.currentTimeMillis() - r8;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r16 = 1;
    L31:
        r12.getClass();     // Catch: Exception -> L33
        l(r19, r18, r13, r14, 1, r16, "");     // Catch: Exception -> L33
        Integer r15 = r2;
    L41:
        if (r15 == 0) goto L44;
        r7 = r15.intValue();
    L44:
        return Boxing.boxInt(r7);
    L30:
        r16 = 0;
        goto L31
    L26:
        r13 = r9;
    L33:
        e = e;
        int r17 = r9;
        r10 = r18;
        String r20 = r19;
    L37:
        long r110 = System.currentTimeMillis() - r8;
        GalleryStoragePolicyManager.a.getClass();
        boolean r111 = GalleryStoragePolicyManager.m();
        String r21 = e.getMessage();
        if (r21 != null) goto L40;
        r21 = "";
    L40:
        r12.getClass();
        l(r20, r10, r17, r110, 0, r111 ? 1 : 0, r21);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r15 = 0;
    L14:
        e = e;
        r17 = r9;
        r20 = r11;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r10 = "album";
        long r112 = System.currentTimeMillis();
        b r23 = AlbumDatabase.a.a().c();     // Catch: Exception -> L35
        r3.L$0 = this;     // Catch: Exception -> L35
        r3.L$1 = "get_one";     // Catch: Exception -> L35
        r3.L$2 = "album";     // Catch: Exception -> L35
        r3.I$0 = 0;     // Catch: Exception -> L35
        r3.J$0 = r112;     // Catch: Exception -> L35
        r3.label = 1;     // Catch: Exception -> L35
        r0 = r23.f(r3);     // Catch: Exception -> L35
        if (r0 != r5) goto L22;
        return r5;
    L22:
        r12 = this;
        r18 = "album";
        r19 = "get_one";
        r8 = r112;
        r9 = 0;
    L35:
        e = e;
        r12 = this;
        r20 = "get_one";
        r8 = r112;
        r17 = 0;
    L7:
        r3 = new AlbumDataBaseHelper$selectMediaDataCount$1(this, r22);
        goto L8
    }

    public static final MediaMetadata a(AlbumDataBaseHelper r34, a r35) {
        r34.getClass();
        String r2 = r35.a;
        long r3 = r35.b;
        Long r5 = r35.c;
        String r6 = r35.d;
        Long r7 = r35.e;
        String r8 = r35.f;
        int r9 = r35.g;
        int r10 = r35.h;
        long r11 = r35.i;
        int r13 = r35.j;
        int r14 = r35.k;
        double r15 = r35.l;
        long r16 = r35.m;
        String r1 = r35.n;
        MediaLifecycleState r19 = null;
        if (r1 != null) goto L5;
    L10:
        GeoLocationInfo r30 = null;
    L11:
        String r17 = r35.o;
        MediaLifecycleState.a r4 = MediaLifecycleState.Companion;
        int r18 = r35.p;
        r4.getClass();
        MediaLifecycleState[] r12 = MediaLifecycleState.values();
        int r110 = r12.length;
        int r111 = 0;
    L12:
        if (r111 >= r110) goto L20;
        MediaLifecycleState r24 = r12[r111];
        MediaLifecycleState[] r25 = r12;
        if (r24.getValue() != r18) goto L16;
        boolean r20 = true;
    L17:
        if (r20 == true) goto L21;
        r111 = r111 + 1;
        r12 = r25;
    L21:
        if (r24 != null) goto L23;
        MediaLifecycleState r32 = MediaLifecycleState.FAILED;
    L24:
        Integer r21 = r35.q;
        if (r21 == null) goto L36;
        int r22 = r21.intValue();
        MediaLifecycleState[] r112 = MediaLifecycleState.values();
        int r113 = r112.length;
        int r114 = 0;
    L27:
        if (r114 >= r113) goto L36;
        MediaLifecycleState r26 = r112[r114];
        MediaLifecycleState[] r27 = r112;
        if (r26.getValue() != r22) goto L31;
        boolean r115 = true;
    L32:
        if (r115 == true) goto L33;
        r114 = r114 + 1;
        r112 = r27;
        goto L27
    L33:
        r19 = r26;
        goto L36
    L31:
        r115 = false;
    L36:
        return new MediaMetadata(r2, r3, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r30, r17, r32, r19, r35.r, r35.s, r35.t, r35.u, r35.v, r35.w, r35.x);
    L23:
        r32 = r24;
        goto L24
    L16:
        r20 = false;
        goto L17
    L20:
        r24 = null;
        goto L21
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r30 = (GeoLocationInfo) GsonProtectorUtils.fromJson(b, r1, GeoLocationInfo.class);
        goto L11
    }

    public static final ThumbnailMetadata b(AlbumDataBaseHelper r28, i r29) {
        r28.getClass();
        String r2 = r29.a;
        String r3 = r29.b;
        String r4 = r29.c;
        long r5 = r29.d;
        String r7 = r29.e;
        long r8 = r29.f;
        String r10 = r29.g;
        int r11 = r29.h;
        int r12 = r29.i;
        long r13 = r29.j;
        long r14 = r29.k;
        long r15 = r29.l;
        long r16 = r29.m;
        String r1 = r29.n;
        GeoLocationInfo r21 = null;
        if (r1 == null) goto L12;
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L12;
        r21 = (GeoLocationInfo) GsonProtectorUtils.fromJson(b, r1, GeoLocationInfo.class);
    L12:
        return new ThumbnailMetadata(r2, r3, r4, r5, r7, r8, r10, r11, r12, r13, r14, r15, r16, r21, r29.o, r29.p, r29.q);
    }

    public static final i c(AlbumDataBaseHelper r27, ThumbnailMetadata r28) {
        r27.getClass();
        String r1 = r28.getFileId();
        String r2 = r28.getFilePath();
        String r3 = r28.getFileName();
        long r4 = r28.getFileSize();
        String r6 = r28.getSn();
        long r7 = r28.getImageUuid();
        String r9 = r28.getMediaType();
        int r10 = r28.getWidth();
        int r11 = r28.getHeight();
        long r12 = r28.getDuration();
        long r14 = r28.getCreateTime();
        long r16 = r28.getModifyTime();
        long r18 = r28.getDownloadTime();
        GeoLocationInfo r0 = r28.getGeoLocationInfo();
        if (r0 == null) goto L5;
        String r5 = GsonProtectorUtils.toJson(b, r0);
    L7:
        return new i(r1, r2, r3, r4, r6, r7, r9, r10, r11, r12, r14, r16, r18, r5, r28.getSourceType(), r28.getProcessingStatus(), r28.isSynced());
    L5:
        r5 = null;
        goto L7
    }

    public final Object B(ThumbnailMetadata r28, Continuation<? super Unit> r29) {
        if ((r29 instanceof AlbumDataBaseHelper$updateThumbnailData$1) == false) goto L7;
        AlbumDataBaseHelper$updateThumbnailData$1 r3 = (AlbumDataBaseHelper$updateThumbnailData$1) r29;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        String r13 = "album_thumbnail";
        if (r6 == 0) goto L24;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        long r7 = r3.J$0;
        int r8 = r3.I$0;
        r13 = (String) r3.L$3;
        String r15 = (String) r3.L$2;
        AlbumDataBaseHelper r9 = (AlbumDataBaseHelper) r3.L$1;
        ThumbnailMetadata r10 = (ThumbnailMetadata) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L15
        String r11 = ", sn=";
        String r16 = "";
    L92:
        int r1 = ((Number) r0).intValue();     // Catch: Exception -> L81
        FLogger.a.i("AlbumDataBaseHelper", "updateThumbnailData: fileId=" + r10.getFileId() + ", imageUuid=" + r10.getImageUuid() + r11 + r10.getSn() + ", rows=" + r1);     // Catch: Exception -> L81
        List r2 = Unit.INSTANCE;     // Catch: Exception -> L81
        if ((r2 instanceof List) == false) goto L74;
        int r19 = r2.size();     // Catch: Exception -> L81
    L75:
        long r20 = System.currentTimeMillis() - r7;     // Catch: Exception -> L81
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L81
        if (GalleryStoragePolicyManager.m() == false) goto L78;
        int r23 = 1;
    L79:
        r9.getClass();     // Catch: Exception -> L81
        l(r15, r13, r19, r20, 1, r23, "");     // Catch: Exception -> L81
        return r2;
    L78:
        r23 = 0;
        goto L79
    L74:
        r19 = r8;
    L81:
        e = e;
        int r12 = r8;
    L83:
        int r110 = r12;
        String r18 = r13;
        String r17 = r15;
        long r14 = r7;
    L86:
        long r21 = System.currentTimeMillis() - r14;
        GalleryStoragePolicyManager.a.getClass();
        boolean r24 = GalleryStoragePolicyManager.m();
        String r22 = e.getMessage();
        if (r22 != null) goto L89;
        String r25 = r16;
    L90:
        r9.getClass();
        l(r17, r18, r110, r21, 0, r24 ? 1 : 0, r25);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L89:
        r25 = r22;
    L15:
        e = e;
        r12 = r8;
        r16 = "";
        goto L83
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        long r26 = r3.J$0;
        int r111 = r3.I$0;
        String r27 = (String) r3.L$3;
        String r30 = (String) r3.L$2;
        AlbumDataBaseHelper r31 = (AlbumDataBaseHelper) r3.L$1;
        ThumbnailMetadata r32 = (ThumbnailMetadata) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L22
        ThumbnailMetadata r210 = r32;
        String r33 = r27;
        r11 = ", sn=";
        String r112 = r30;
        AlbumDataBaseHelper r113 = r31;
        long r34 = r26;
        r16 = "";
    L108:
    L45:
        e = e;
        r32 = r210;
        String r114 = r33;
        String r35 = r112;
        int r115 = r111;
    L57:
        long r211 = System.currentTimeMillis() - r34;
        GalleryStoragePolicyManager.a.getClass();
        boolean r212 = GalleryStoragePolicyManager.m();
        String r36 = e.getMessage();
        if (r36 != null) goto L60;
        String r213 = r16;
    L61:
        r113.getClass();
        l(r35, r114, r115, r211, 0, r212 ? 1 : 0, r213);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r0 = null;
    L62:
        i r37 = (i) r0;
        if (r37 != null) goto L66;
        FLogger.a.e("AlbumDataBaseHelper", "updateThumbnailData: thumbnailMetadata not found, imageUuid=" + r32.getImageUuid() + r11 + r32.getSn());
        return Unit.INSTANCE;
    L66:
        r14 = System.currentTimeMillis();
        j r116 = AlbumDatabase.a.a().d();     // Catch: Exception -> L84
        i r117 = c(a, r32);     // Catch: Exception -> L84
        String r38 = r37.a;     // Catch: Exception -> L84
        Intrinsics.checkNotNullParameter(r38, "<set-?>");     // Catch: Exception -> L84
        r117.a = r38;     // Catch: Exception -> L84
        r3.L$0 = r32;     // Catch: Exception -> L84
        r3.L$1 = this;     // Catch: Exception -> L84
        r3.L$2 = MemoryActionTag.MEMORY_ACTION_TAG_UPDATE;     // Catch: Exception -> L84
        r3.L$3 = "album_thumbnail";     // Catch: Exception -> L84
        r3.I$0 = 1;     // Catch: Exception -> L84
        r3.J$0 = r14;     // Catch: Exception -> L84
        r3.label = 2;     // Catch: Exception -> L84
        r0 = r116.g(r117, r3);     // Catch: Exception -> L84
        if (r0 != r5) goto L70;
        return r5;
    L70:
        r10 = r32;
        r15 = MemoryActionTag.MEMORY_ACTION_TAG_UPDATE;
        r7 = r14;
        r8 = 1;
        r9 = this;
    L84:
        e = e;
        r17 = MemoryActionTag.MEMORY_ACTION_TAG_UPDATE;
        r18 = "album_thumbnail";
        r110 = 1;
        r9 = this;
        goto L86
    L60:
        r213 = r36;
        goto L61
    L36:
        if ((r0 instanceof List) == false) goto L38;
        int r118 = ((List) r0).size();     // Catch: Exception -> L45
    L39:
        long r214 = System.currentTimeMillis() - r34;     // Catch: Exception -> L45
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L45
        if (GalleryStoragePolicyManager.m() == false) goto L42;
        int r215 = 1;
    L43:
        r113.getClass();     // Catch: Exception -> L45
        l(r112, r33, r118, r214, 1, r215, "");     // Catch: Exception -> L45
        r32 = r210;
        goto L62
    L42:
        r215 = 0;
        goto L43
    L38:
        r118 = r111;
    L22:
        e = e;
        r114 = r27;
        r11 = ", sn=";
        r115 = r111;
        r35 = r30;
        r16 = "";
        r113 = r31;
        r34 = r26;
        goto L57
    L24:
        ResultKt.throwOnFailure(r0);
        r35 = "get_one";
        long r39 = System.currentTimeMillis();
        j r40 = AlbumDatabase.a.a().d();     // Catch: Exception -> L53
        r11 = ", sn=";
        long r41 = r28.getImageUuid();     // Catch: Exception -> L51
        String r119 = r28.getSn();     // Catch: Exception -> L51
        r16 = "";
        ThumbnailMetadata r120 = r28;
        r3.L$0 = r120;     // Catch: Exception -> L49
        r3.L$1 = this;     // Catch: Exception -> L49
        r3.L$2 = "get_one";     // Catch: Exception -> L49
        r3.L$3 = "album_thumbnail";     // Catch: Exception -> L49
        r35 = "get_one";
        r3.I$0 = 1;     // Catch: Exception -> L47
        r3.J$0 = r39;     // Catch: Exception -> L47
        r3.label = 1;     // Catch: Exception -> L47
        r0 = r40.b(r41, r119, r3);     // Catch: Exception -> L47
        if (r0 != r5) goto L34;
        return r5;
    L34:
        r34 = r39;
        r210 = r120;
        r33 = "album_thumbnail";
        r112 = r35;
        r111 = 1;
        r113 = this;
    L47:
        e = e;
    L56:
        r34 = r39;
        r32 = r120;
        r114 = "album_thumbnail";
        r115 = 1;
        r113 = this;
    L49:
        e = e;
        r35 = "get_one";
    L51:
        e = e;
    L55:
        r16 = "";
        r120 = r28;
    L53:
        e = e;
        r11 = ", sn=";
    L7:
        r3 = new AlbumDataBaseHelper$updateThumbnailData$1(this, r29);
        goto L8
    }

    public final Object d(String r22, Continuation<? super Unit> r23) {
        String r0 = r22;
        if ((r23 instanceof AlbumDataBaseHelper$deleteMediaDataById$1) == false) goto L7;
        AlbumDataBaseHelper$deleteMediaDataById$1 r4 = (AlbumDataBaseHelper$deleteMediaDataById$1) r23;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r2 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        long r8 = r4.J$0;
        int r9 = r4.I$0;
        String r10 = (String) r4.L$3;
        String r11 = (String) r4.L$2;
        AlbumDataBaseHelper r12 = (AlbumDataBaseHelper) r4.L$1;
        r0 = (String) r4.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L14
        String r13 = r10;
        String r18 = r11;
        AlbumDataBaseHelper r19 = r12;
    L46:
        int r3 = ((Number) r2).intValue();     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "deleteMediaDataById: id=" + r0 + ", rows=" + r3);     // Catch: Exception -> L33
        List r1 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r1 instanceof List) == false) goto L26;
        int r14 = r1.size();     // Catch: Exception -> L33
    L27:
        long r15 = System.currentTimeMillis() - r8;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r16 = 1;
    L31:
        r19.getClass();     // Catch: Exception -> L33
        l(r18, r13, r14, r15, 1, r16, "");     // Catch: Exception -> L33
        return r1;
    L30:
        r16 = 0;
        goto L31
    L26:
        r14 = r9;
    L33:
        e = e;
        r10 = r13;
        int r17 = r9;
        String r20 = r18;
        r12 = r19;
    L37:
        long r21 = System.currentTimeMillis() - r8;
        GalleryStoragePolicyManager.a.getClass();
        boolean r110 = GalleryStoragePolicyManager.m();
        String r24 = e.getMessage();
        if (r24 != null) goto L40;
        r24 = "";
    L40:
        r12.getClass();
        l(r20, r10, r17, r21, 0, r110 ? 1 : 0, r24);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r17 = r9;
        r20 = r11;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r10 = "album";
        long r111 = System.currentTimeMillis();
        b r25 = AlbumDatabase.a.a().c();     // Catch: Exception -> L35
        r4.L$0 = r0;     // Catch: Exception -> L35
        r4.L$1 = this;     // Catch: Exception -> L35
        r4.L$2 = "delete";     // Catch: Exception -> L35
        r4.L$3 = "album";     // Catch: Exception -> L35
        r4.I$0 = 1;     // Catch: Exception -> L35
        r4.J$0 = r111;     // Catch: Exception -> L35
        r4.label = 1;     // Catch: Exception -> L35
        r2 = r25.m(r0, r4);     // Catch: Exception -> L35
        if (r2 != r6) goto L22;
        return r6;
    L22:
        r19 = this;
        r13 = "album";
        r18 = "delete";
        r8 = r111;
        r9 = 1;
    L35:
        e = e;
        r20 = "delete";
        r8 = r111;
        r17 = 1;
        r12 = this;
    L7:
        r4 = new AlbumDataBaseHelper$deleteMediaDataById$1(this, r23);
        goto L8
    }

    public final Object e(List<String> r22, Continuation<? super Unit> r23) {
        if ((r23 instanceof AlbumDataBaseHelper$deleteMediaDataByIds$1) == false) goto L7;
        AlbumDataBaseHelper$deleteMediaDataByIds$1 r3 = (AlbumDataBaseHelper$deleteMediaDataByIds$1) r23;
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
        int r8 = r3.I$0;
        String r9 = (String) r3.L$3;
        String r10 = (String) r3.L$2;
        AlbumDataBaseHelper r11 = (AlbumDataBaseHelper) r3.L$1;
        List r12 = (List) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
        String r17 = r9;
        String r18 = r10;
        AlbumDataBaseHelper r19 = r11;
    L47:
        int r1 = ((Number) r0).intValue();     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "deleteMediaDataByIds: ids=" + r12 + ", rows=" + r1);     // Catch: Exception -> L33
        List r2 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r2 instanceof List) == false) goto L26;
        int r13 = r2.size();     // Catch: Exception -> L33
    L27:
        long r14 = System.currentTimeMillis() - r7;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r15 = 1;
    L31:
        r19.getClass();     // Catch: Exception -> L33
        l(r18, r17, r13, r14, 1, r15, "");     // Catch: Exception -> L33
        return r2;
    L30:
        r15 = 0;
        goto L31
    L26:
        r13 = r8;
    L33:
        e = e;
        int r16 = r8;
        r9 = r17;
        String r20 = r18;
    L38:
        long r110 = System.currentTimeMillis() - r7;
        GalleryStoragePolicyManager.a.getClass();
        boolean r111 = GalleryStoragePolicyManager.m();
        String r21 = e.getMessage();
        if (r21 != null) goto L41;
        r21 = "";
    L41:
        r19.getClass();
        l(r20, r9, r16, r110, 0, r111 ? 1 : 0, r21);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
    L37:
        r19 = r11;
        String r24 = r10;
        r16 = r8;
        r20 = r24;
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r10 = "batch_delete";
        r9 = "album";
        ArrayList r25 = (ArrayList) r22;
        r8 = r25.size();
        long r112 = System.currentTimeMillis();
        b r26 = AlbumDatabase.a.a().c();     // Catch: Exception -> L35
        r3.L$0 = r25;     // Catch: Exception -> L35
        r3.L$1 = this;     // Catch: Exception -> L35
        r3.L$2 = "batch_delete";     // Catch: Exception -> L35
        r3.L$3 = "album";     // Catch: Exception -> L35
        r3.I$0 = r8;     // Catch: Exception -> L35
        r3.J$0 = r112;     // Catch: Exception -> L35
        r3.label = 1;     // Catch: Exception -> L35
        Object r27 = r26.c(r25, r3);     // Catch: Exception -> L35
        if (r27 != r5) goto L22;
        return r5;
    L22:
        r19 = this;
        r17 = "album";
        r18 = "batch_delete";
        r7 = r112;
        r12 = r25;
        r0 = r27;
    L35:
        e = e;
        r7 = r112;
        r11 = this;
    L7:
        r3 = new AlbumDataBaseHelper$deleteMediaDataByIds$1(this, r23);
        goto L8
    }

    public final Object h(MediaMetadata r22, Continuation<? super Unit> r23) {
        if ((r23 instanceof AlbumDataBaseHelper$insertMediaData$1) == false) goto L7;
        AlbumDataBaseHelper$insertMediaData$1 r3 = (AlbumDataBaseHelper$insertMediaData$1) r23;
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
        int r8 = r3.I$0;
        String r9 = (String) r3.L$3;
        String r10 = (String) r3.L$2;
        AlbumDataBaseHelper r11 = (AlbumDataBaseHelper) r3.L$1;
        MediaMetadata r12 = (MediaMetadata) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
        String r17 = r9;
        String r18 = r10;
        AlbumDataBaseHelper r19 = r11;
    L42:
        long r13 = ((Number) r0).longValue();     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "insertMediaData: uniqId=" + r12.getUniqId() + ", mediaId=" + r12.getMediaId() + ", rowId=" + r13);     // Catch: Exception -> L33
        List r1 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r1 instanceof List) == false) goto L26;
        int r14 = r1.size();     // Catch: Exception -> L33
    L27:
        long r15 = System.currentTimeMillis() - r7;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r16 = 1;
    L31:
        r19.getClass();     // Catch: Exception -> L33
        l(r18, r17, r14, r15, 1, r16, "");     // Catch: Exception -> L33
        return r1;
    L30:
        r16 = 0;
        goto L31
    L26:
        r14 = r8;
    L33:
        e = e;
        int r110 = r8;
        r9 = r17;
        String r20 = r18;
        r11 = r19;
    L37:
        long r2 = System.currentTimeMillis() - r7;
        GalleryStoragePolicyManager.a.getClass();
        boolean r111 = GalleryStoragePolicyManager.m();
        String r21 = e.getMessage();
        if (r21 != null) goto L40;
        r21 = "";
    L40:
        r11.getClass();
        l(r20, r9, r110, r2, 0, r111 ? 1 : 0, r21);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r110 = r8;
        r20 = r10;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r9 = "album";
        long r112 = System.currentTimeMillis();
        b r24 = AlbumDatabase.a.a().c();     // Catch: Exception -> L35
        a.getClass();     // Catch: Exception -> L35
        a r25 = k(r22);     // Catch: Exception -> L35
        r3.L$0 = r22;     // Catch: Exception -> L35
        r3.L$1 = this;     // Catch: Exception -> L35
        r3.L$2 = "save";     // Catch: Exception -> L35
        r3.L$3 = "album";     // Catch: Exception -> L35
        r3.I$0 = 1;     // Catch: Exception -> L35
        r3.J$0 = r112;     // Catch: Exception -> L35
        r3.label = 1;     // Catch: Exception -> L35
        r0 = r24.b(r25, r3);     // Catch: Exception -> L35
        if (r0 != r5) goto L22;
        return r5;
    L22:
        r19 = this;
        r12 = r22;
        r17 = "album";
        r18 = "save";
        r7 = r112;
        r8 = 1;
    L35:
        e = e;
        r20 = "save";
        r7 = r112;
        r110 = 1;
        r11 = this;
    L7:
        r3 = new AlbumDataBaseHelper$insertMediaData$1(this, r23);
        goto L8
    }

    public final Object i(List<MediaMetadata> r22, Continuation<? super Unit> r23) {
        List<MediaMetadata> r0 = r22;
        if ((r23 instanceof AlbumDataBaseHelper$insertMediaDataList$1) == false) goto L7;
        Continuation<? super List<Long>> r3 = (AlbumDataBaseHelper$insertMediaDataList$1) r23;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        long r7 = r3.J$0;
        int r9 = r3.I$0;
        String r10 = (String) r3.L$3;
        String r11 = (String) r3.L$2;
        AlbumDataBaseHelper r12 = (AlbumDataBaseHelper) r3.L$1;
        r0 = (List) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L14
        String r8 = r10;
        String r18 = r11;
        AlbumDataBaseHelper r19 = r12;
    L59:
        List r13 = (List) r2;     // Catch: Exception -> L45
        FLogger r14 = FLogger.a;     // Catch: Exception -> L45
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L45
        r15.append("insertMediaDataList: uniqIds=");     // Catch: Exception -> L45
        List<MediaMetadata> r16 = r0;     // Catch: Exception -> L45
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));     // Catch: Exception -> L45
        Iterator<T> r110 = r16.iterator();     // Catch: Exception -> L45
    L29:
        if (r110.hasNext() == false) goto L31;
        r17.add(((MediaMetadata) r110.next()).getUniqId());     // Catch: Exception -> L45
        goto L29
    L31:
        r15.append(r17);     // Catch: Exception -> L45
        r15.append(", mediaIds=");     // Catch: Exception -> L45
        List<MediaMetadata> r111 = r0;     // Catch: Exception -> L45
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));     // Catch: Exception -> L45
        Iterator<T> r20 = r111.iterator();     // Catch: Exception -> L45
    L33:
        if (r20.hasNext() == false) goto L35;
        r112.add(Boxing.boxLong(((MediaMetadata) r20.next()).getMediaId()));     // Catch: Exception -> L45
        goto L33
    L35:
        r15.append(r112);     // Catch: Exception -> L45
        r15.append(", rowIds=");     // Catch: Exception -> L45
        r15.append(r13);     // Catch: Exception -> L45
        r15.append(", total=");     // Catch: Exception -> L45
        r15.append(r0.size());     // Catch: Exception -> L45
        r15.append(", success=");     // Catch: Exception -> L45
        r15.append(r13.size());     // Catch: Exception -> L45
        r14.i("AlbumDataBaseHelper", r15.toString());     // Catch: Exception -> L45
        List r1 = Unit.INSTANCE;     // Catch: Exception -> L45
        if ((r1 instanceof List) == false) goto L38;
        int r113 = r1.size();     // Catch: Exception -> L45
    L39:
        long r114 = System.currentTimeMillis() - r7;     // Catch: Exception -> L45
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L45
        if (GalleryStoragePolicyManager.m() == false) goto L42;
        int r115 = 1;
    L43:
        r19.getClass();     // Catch: Exception -> L45
        l(r18, r8, r113, r114, 1, r115, "");     // Catch: Exception -> L45
        return r1;
    L42:
        r115 = 0;
        goto L43
    L38:
        r113 = r9;
    L45:
        e = e;
        r10 = r8;
        int r116 = r9;
        String r21 = r18;
    L50:
        long r117 = System.currentTimeMillis() - r7;
        GalleryStoragePolicyManager.a.getClass();
        boolean r118 = GalleryStoragePolicyManager.m();
        String r24 = e.getMessage();
        if (r24 != null) goto L53;
        r24 = "";
    L53:
        r19.getClass();
        l(r21, r10, r116, r117, 0, r118 ? 1 : 0, r24);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
    L49:
        r19 = r12;
        String r25 = r11;
        r116 = r9;
        r21 = r25;
        goto L50
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r11 = "batch_save";
        r10 = "album";
        r9 = r22.size();
        long r119 = System.currentTimeMillis();
        b r26 = AlbumDatabase.a.a().c();     // Catch: Exception -> L47
        List<MediaMetadata> r27 = r0;     // Catch: Exception -> L47
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));     // Catch: Exception -> L47
        Iterator<T> r28 = r27.iterator();     // Catch: Exception -> L47
    L21:
        if (r28.hasNext() == false) goto L23;
        MediaMetadata r121 = (MediaMetadata) r28.next();     // Catch: Exception -> L47
        a.getClass();     // Catch: Exception -> L47
        r120.add(k(r121));     // Catch: Exception -> L47
        goto L21
    L23:
        r3.L$0 = r0;     // Catch: Exception -> L47
        r3.L$1 = this;     // Catch: Exception -> L47
        r3.L$2 = "batch_save";     // Catch: Exception -> L47
        r3.L$3 = "album";     // Catch: Exception -> L47
        r3.I$0 = r9;     // Catch: Exception -> L47
        r3.J$0 = r119;     // Catch: Exception -> L47
        r3.label = 1;     // Catch: Exception -> L47
        r2 = r26.g(r120, r3);     // Catch: Exception -> L47
        if (r2 != r5) goto L26;
        return r5;
    L26:
        r19 = this;
        r8 = "album";
        r18 = "batch_save";
        r7 = r119;
    L47:
        e = e;
        r7 = r119;
        r12 = this;
    L7:
        r3 = new AlbumDataBaseHelper$insertMediaDataList$1(this, r23);
        goto L8
    }

    public final Object j(ThumbnailMetadata r22, Continuation<? super Unit> r23) {
        ThumbnailMetadata r0 = r22;
        if ((r23 instanceof AlbumDataBaseHelper$insertThumbnailData$1) == false) goto L7;
        AlbumDataBaseHelper$insertThumbnailData$1 r4 = (AlbumDataBaseHelper$insertThumbnailData$1) r23;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r2 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        long r8 = r4.J$0;
        int r9 = r4.I$0;
        String r10 = (String) r4.L$3;
        String r11 = (String) r4.L$2;
        AlbumDataBaseHelper r12 = (AlbumDataBaseHelper) r4.L$1;
        r0 = (ThumbnailMetadata) r4.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L14
        String r13 = r10;
        String r18 = r11;
        AlbumDataBaseHelper r19 = r12;
    L46:
        long r14 = ((Number) r2).longValue();     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "insertThumbnailData: fileId=" + r0.getFileId() + ", imageUuid=" + r0.getImageUuid() + ", sn=" + r0.getSn() + ", rowId=" + r14);     // Catch: Exception -> L33
        List r1 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r1 instanceof List) == false) goto L26;
        int r15 = r1.size();     // Catch: Exception -> L33
    L27:
        long r16 = System.currentTimeMillis() - r8;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r17 = 1;
    L31:
        r19.getClass();     // Catch: Exception -> L33
        l(r18, r13, r15, r16, 1, r17, "");     // Catch: Exception -> L33
        return r1;
    L30:
        r17 = 0;
        goto L31
    L26:
        r15 = r9;
    L33:
        e = e;
        r10 = r13;
        int r110 = r9;
        String r20 = r18;
        r12 = r19;
    L37:
        long r3 = System.currentTimeMillis() - r8;
        GalleryStoragePolicyManager.a.getClass();
        boolean r111 = GalleryStoragePolicyManager.m();
        String r21 = e.getMessage();
        if (r21 != null) goto L40;
        r21 = "";
    L40:
        r12.getClass();
        l(r20, r10, r110, r3, 0, r111 ? 1 : 0, r21);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r110 = r9;
        r20 = r11;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r10 = "album_thumbnail";
        long r112 = System.currentTimeMillis();
        j r24 = AlbumDatabase.a.a().d();     // Catch: Exception -> L35
        i r25 = c(a, r0);     // Catch: Exception -> L35
        r4.L$0 = r0;     // Catch: Exception -> L35
        r4.L$1 = this;     // Catch: Exception -> L35
        r4.L$2 = "save";     // Catch: Exception -> L35
        r4.L$3 = "album_thumbnail";     // Catch: Exception -> L35
        r4.I$0 = 1;     // Catch: Exception -> L35
        r4.J$0 = r112;     // Catch: Exception -> L35
        r4.label = 1;     // Catch: Exception -> L35
        r2 = r24.e(r25, r4);     // Catch: Exception -> L35
        if (r2 != r6) goto L22;
        return r6;
    L22:
        r19 = this;
        r13 = "album_thumbnail";
        r18 = "save";
        r8 = r112;
        r9 = 1;
    L35:
        e = e;
        r20 = "save";
        r8 = r112;
        r110 = 1;
        r12 = this;
    L7:
        r4 = new AlbumDataBaseHelper$insertThumbnailData$1(this, r23);
        goto L8
    }

    public final Object o(String r23, Continuation<? super MediaMetadata> r24) {
        String r0 = r23;
        if ((r24 instanceof AlbumDataBaseHelper$selectMediaDataById$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataById$1 r4 = (AlbumDataBaseHelper$selectMediaDataById$1) r24;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r2 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        long r8 = r4.J$0;
        int r10 = r4.I$0;
        String r11 = (String) r4.L$3;
        String r12 = (String) r4.L$2;
        AlbumDataBaseHelper r13 = (AlbumDataBaseHelper) r4.L$1;
        r0 = (String) r4.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L14
        String r9 = r11;
        String r19 = r12;
        AlbumDataBaseHelper r20 = r13;
    L48:
        a r3 = (a) r2;     // Catch: Exception -> L37
        FLogger.a.i("AlbumDataBaseHelper", "selectMediaDataById: id=" + r0 + ", result=" + r3);     // Catch: Exception -> L37
        if (r3 == null) goto L26;
        Object r1 = a(a, r3);     // Catch: Exception -> L37
    L28:
        if ((r1 instanceof List) == false) goto L30;
        int r14 = ((List) r1).size();     // Catch: Exception -> L37
    L31:
        long r15 = System.currentTimeMillis() - r8;     // Catch: Exception -> L37
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L37
        if (GalleryStoragePolicyManager.m() == false) goto L34;
        int r17 = 1;
    L35:
        r20.getClass();     // Catch: Exception -> L37
        l(r19, r9, r14, r15, 1, r17, "");     // Catch: Exception -> L37
        return r1;
    L34:
        r17 = 0;
        goto L35
    L30:
        r14 = r10;
        goto L31
    L26:
        r1 = null;
    L37:
        e = e;
        r11 = r9;
        int r16 = r10;
        String r18 = r19;
        r13 = r20;
    L41:
        long r21 = System.currentTimeMillis() - r8;
        GalleryStoragePolicyManager.a.getClass();
        boolean r110 = GalleryStoragePolicyManager.m();
        String r22 = e.getMessage();
        if (r22 != null) goto L44;
        r22 = "";
    L44:
        r13.getClass();
        l(r18, r11, r16, r21, 0, r110 ? 1 : 0, r22);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r16 = r10;
        r18 = r12;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r11 = "album";
        long r111 = System.currentTimeMillis();
        b r25 = AlbumDatabase.a.a().c();     // Catch: Exception -> L39
        r4.L$0 = r0;     // Catch: Exception -> L39
        r4.L$1 = this;     // Catch: Exception -> L39
        r4.L$2 = "get_one";     // Catch: Exception -> L39
        r4.L$3 = "album";     // Catch: Exception -> L39
        r4.I$0 = 1;     // Catch: Exception -> L39
        r4.J$0 = r111;     // Catch: Exception -> L39
        r4.label = 1;     // Catch: Exception -> L39
        r2 = r25.k(r0, r4);     // Catch: Exception -> L39
        if (r2 != r6) goto L22;
        return r6;
    L22:
        r20 = this;
        r9 = "album";
        r19 = "get_one";
        r8 = r111;
        r10 = 1;
    L39:
        e = e;
        r18 = "get_one";
        r8 = r111;
        r16 = 1;
        r13 = this;
    L7:
        r4 = new AlbumDataBaseHelper$selectMediaDataById$1(this, r24);
        goto L8
    }

    public final Object p(String r23, Continuation<? super MediaMetadata> r24) {
        String r0 = r23;
        if ((r24 instanceof AlbumDataBaseHelper$selectMediaDataByPath$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataByPath$1 r4 = (AlbumDataBaseHelper$selectMediaDataByPath$1) r24;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r2 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        long r8 = r4.J$0;
        int r10 = r4.I$0;
        String r11 = (String) r4.L$3;
        String r12 = (String) r4.L$2;
        AlbumDataBaseHelper r13 = (AlbumDataBaseHelper) r4.L$1;
        r0 = (String) r4.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L14
        String r9 = r11;
        String r19 = r12;
        AlbumDataBaseHelper r20 = r13;
    L48:
        a r3 = (a) r2;     // Catch: Exception -> L37
        FLogger.a.i("AlbumDataBaseHelper", "getMetadataByPath: filePath=" + r0 + ", result=" + r3);     // Catch: Exception -> L37
        if (r3 == null) goto L26;
        Object r1 = a(a, r3);     // Catch: Exception -> L37
    L28:
        if ((r1 instanceof List) == false) goto L30;
        int r14 = ((List) r1).size();     // Catch: Exception -> L37
    L31:
        long r15 = System.currentTimeMillis() - r8;     // Catch: Exception -> L37
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L37
        if (GalleryStoragePolicyManager.m() == false) goto L34;
        int r17 = 1;
    L35:
        r20.getClass();     // Catch: Exception -> L37
        l(r19, r9, r14, r15, 1, r17, "");     // Catch: Exception -> L37
        return r1;
    L34:
        r17 = 0;
        goto L35
    L30:
        r14 = r10;
        goto L31
    L26:
        r1 = null;
    L37:
        e = e;
        r11 = r9;
        int r16 = r10;
        String r18 = r19;
        r13 = r20;
    L41:
        long r21 = System.currentTimeMillis() - r8;
        GalleryStoragePolicyManager.a.getClass();
        boolean r110 = GalleryStoragePolicyManager.m();
        String r22 = e.getMessage();
        if (r22 != null) goto L44;
        r22 = "";
    L44:
        r13.getClass();
        l(r18, r11, r16, r21, 0, r110 ? 1 : 0, r22);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r16 = r10;
        r18 = r12;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r11 = "album";
        long r111 = System.currentTimeMillis();
        b r25 = AlbumDatabase.a.a().c();     // Catch: Exception -> L39
        r4.L$0 = r0;     // Catch: Exception -> L39
        r4.L$1 = this;     // Catch: Exception -> L39
        r4.L$2 = "get_one";     // Catch: Exception -> L39
        r4.L$3 = "album";     // Catch: Exception -> L39
        r4.I$0 = 1;     // Catch: Exception -> L39
        r4.J$0 = r111;     // Catch: Exception -> L39
        r4.label = 1;     // Catch: Exception -> L39
        r2 = r25.j(r0, r4);     // Catch: Exception -> L39
        if (r2 != r6) goto L22;
        return r6;
    L22:
        r20 = this;
        r9 = "album";
        r19 = "get_one";
        r8 = r111;
        r10 = 1;
    L39:
        e = e;
        r18 = "get_one";
        r8 = r111;
        r16 = 1;
        r13 = this;
    L7:
        r4 = new AlbumDataBaseHelper$selectMediaDataByPath$1(this, r24);
        goto L8
    }

    public final Object r(MediaLifecycleState r23, Continuation<? super List<MediaMetadata>> r24) {
        if ((r24 instanceof AlbumDataBaseHelper$selectMediaDataListByIncomplete$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataListByIncomplete$1 r3 = (AlbumDataBaseHelper$selectMediaDataListByIncomplete$1) r24;
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
        int r9 = r3.I$0;
        String r10 = (String) r3.L$3;
        String r11 = (String) r3.L$2;
        AlbumDataBaseHelper r12 = (AlbumDataBaseHelper) r3.L$1;
        MediaLifecycleState r8 = (MediaLifecycleState) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
        String r18 = r10;
        String r19 = r11;
        AlbumDataBaseHelper r20 = r12;
    L44:
        List r1 = (List) r0;     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "selectMediaDataListByIncomplete: lifecycleState=" + r8 + ", result=" + r1);     // Catch: Exception -> L33
        List r2 = r1;     // Catch: Exception -> L33
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));     // Catch: Exception -> L33
        Iterator r14 = r2.iterator();     // Catch: Exception -> L33
    L25:
        if (r14.hasNext() == false) goto L27;
        r13.add(a(a, (a) r14.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r15 = r13.size();     // Catch: Exception -> L33
        long r16 = System.currentTimeMillis() - r7;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r17 = 1;
    L31:
        r20.getClass();     // Catch: Exception -> L33
        l(r19, r18, r15, r16, 1, r17, "");     // Catch: Exception -> L33
    L41:
        if (r13 == null) goto L43;
        return r13;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r17 = 0;
    L33:
        e = e;
        int r110 = r9;
        r10 = r18;
        String r21 = r19;
        r12 = r20;
    L37:
        long r22 = System.currentTimeMillis() - r7;
        GalleryStoragePolicyManager.a.getClass();
        boolean r111 = GalleryStoragePolicyManager.m();
        String r25 = e.getMessage();
        if (r25 != null) goto L40;
        r25 = "";
    L40:
        r12.getClass();
        l(r21, r10, r110, r22, 0, r111 ? 1 : 0, r25);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r13 = null;
    L14:
        e = e;
        r110 = r9;
        r21 = r11;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r10 = "album";
        long r112 = System.currentTimeMillis();
        b r26 = AlbumDatabase.a.a().c();     // Catch: Exception -> L35
        int r27 = r23.getValue();     // Catch: Exception -> L35
        r3.L$0 = r23;     // Catch: Exception -> L35
        r3.L$1 = this;     // Catch: Exception -> L35
        r3.L$2 = "batch_load";     // Catch: Exception -> L35
        r3.L$3 = "album";     // Catch: Exception -> L35
        r3.I$0 = 0;     // Catch: Exception -> L35
        r3.J$0 = r112;     // Catch: Exception -> L35
        r3.label = 1;     // Catch: Exception -> L35
        r0 = r26.n(r27, r3);     // Catch: Exception -> L35
        if (r0 != r5) goto L22;
        return r5;
    L22:
        r20 = this;
        r8 = r23;
        r18 = "album";
        r19 = "batch_load";
        r7 = r112;
        r9 = 0;
    L35:
        e = e;
        r21 = "batch_load";
        r7 = r112;
        r110 = 0;
        r12 = this;
    L7:
        r3 = new AlbumDataBaseHelper$selectMediaDataListByIncomplete$1(this, r24);
        goto L8
    }

    public final Object s(MediaLifecycleState r23, Continuation<? super List<MediaMetadata>> r24) {
        if ((r24 instanceof AlbumDataBaseHelper$selectMediaDataListByLifecycleState$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataListByLifecycleState$1 r3 = (AlbumDataBaseHelper$selectMediaDataListByLifecycleState$1) r24;
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
        int r9 = r3.I$0;
        String r10 = (String) r3.L$3;
        String r11 = (String) r3.L$2;
        AlbumDataBaseHelper r12 = (AlbumDataBaseHelper) r3.L$1;
        MediaLifecycleState r8 = (MediaLifecycleState) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
        String r18 = r10;
        String r19 = r11;
        AlbumDataBaseHelper r20 = r12;
    L44:
        List r1 = (List) r0;     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "selectMediaDataListByLifecycleState: lifecycleState=" + r8 + ", result=" + r1);     // Catch: Exception -> L33
        List r2 = r1;     // Catch: Exception -> L33
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));     // Catch: Exception -> L33
        Iterator r14 = r2.iterator();     // Catch: Exception -> L33
    L25:
        if (r14.hasNext() == false) goto L27;
        r13.add(a(a, (a) r14.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r15 = r13.size();     // Catch: Exception -> L33
        long r16 = System.currentTimeMillis() - r7;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r17 = 1;
    L31:
        r20.getClass();     // Catch: Exception -> L33
        l(r19, r18, r15, r16, 1, r17, "");     // Catch: Exception -> L33
    L41:
        if (r13 == null) goto L43;
        return r13;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r17 = 0;
    L33:
        e = e;
        int r110 = r9;
        r10 = r18;
        String r21 = r19;
        r12 = r20;
    L37:
        long r22 = System.currentTimeMillis() - r7;
        GalleryStoragePolicyManager.a.getClass();
        boolean r111 = GalleryStoragePolicyManager.m();
        String r25 = e.getMessage();
        if (r25 != null) goto L40;
        r25 = "";
    L40:
        r12.getClass();
        l(r21, r10, r110, r22, 0, r111 ? 1 : 0, r25);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r13 = null;
    L14:
        e = e;
        r110 = r9;
        r21 = r11;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r10 = "album";
        long r112 = System.currentTimeMillis();
        b r26 = AlbumDatabase.a.a().c();     // Catch: Exception -> L35
        int r27 = r23.getValue();     // Catch: Exception -> L35
        r3.L$0 = r23;     // Catch: Exception -> L35
        r3.L$1 = this;     // Catch: Exception -> L35
        r3.L$2 = "batch_load";     // Catch: Exception -> L35
        r3.L$3 = "album";     // Catch: Exception -> L35
        r3.I$0 = 0;     // Catch: Exception -> L35
        r3.J$0 = r112;     // Catch: Exception -> L35
        r3.label = 1;     // Catch: Exception -> L35
        r0 = r26.i(r27, r3);     // Catch: Exception -> L35
        if (r0 != r5) goto L22;
        return r5;
    L22:
        r20 = this;
        r8 = r23;
        r18 = "album";
        r19 = "batch_load";
        r7 = r112;
        r9 = 0;
    L35:
        e = e;
        r21 = "batch_load";
        r7 = r112;
        r110 = 0;
        r12 = this;
    L7:
        r3 = new AlbumDataBaseHelper$selectMediaDataListByLifecycleState$1(this, r24);
        goto L8
    }

    public final Object t(List<? extends MediaLifecycleState> r23, Continuation<? super List<MediaMetadata>> r24) {
        List<? extends MediaLifecycleState> r0 = r23;
        if ((r24 instanceof AlbumDataBaseHelper$selectMediaDataListByLifecycleStates$1) == false) goto L7;
        Continuation<? super List<a>> r3 = (AlbumDataBaseHelper$selectMediaDataListByLifecycleStates$1) r24;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        long r7 = r3.J$0;
        int r10 = r3.I$0;
        String r11 = (String) r3.L$3;
        String r12 = (String) r3.L$2;
        AlbumDataBaseHelper r13 = (AlbumDataBaseHelper) r3.L$1;
        r0 = (List) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L14
        String r8 = r11;
        String r19 = r12;
        AlbumDataBaseHelper r20 = r13;
    L52:
        List r9 = (List) r2;     // Catch: Exception -> L37
        FLogger.a.i("AlbumDataBaseHelper", "selectMediaDataListByLifecycleStates: lifecycleStates=" + r0 + ", result=" + r9);     // Catch: Exception -> L37
        List r14 = r9;     // Catch: Exception -> L37
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));     // Catch: Exception -> L37
        Iterator r15 = r14.iterator();     // Catch: Exception -> L37
    L29:
        if (r15.hasNext() == false) goto L31;
        r1.add(a(a, (a) r15.next()));     // Catch: Exception -> L37
        goto L29
    L31:
        int r16 = r1.size();     // Catch: Exception -> L37
        long r17 = System.currentTimeMillis() - r7;     // Catch: Exception -> L37
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L37
        if (GalleryStoragePolicyManager.m() == false) goto L34;
        int r18 = 1;
    L35:
        r20.getClass();     // Catch: Exception -> L37
        l(r19, r8, r16, r17, 1, r18, "");     // Catch: Exception -> L37
    L45:
        if (r1 == null) goto L47;
        return r1;
    L47:
        return CollectionsKt.emptyList();
    L34:
        r18 = 0;
    L37:
        e = e;
        r11 = r8;
        int r110 = r10;
        String r111 = r19;
        r13 = r20;
    L41:
        long r21 = System.currentTimeMillis() - r7;
        GalleryStoragePolicyManager.a.getClass();
        boolean r112 = GalleryStoragePolicyManager.m();
        String r22 = e.getMessage();
        if (r22 != null) goto L44;
        r22 = "";
    L44:
        r13.getClass();
        l(r111, r11, r110, r21, 0, r112 ? 1 : 0, r22);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r1 = null;
    L14:
        e = e;
        r110 = r10;
        r111 = r12;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r11 = "album";
        long r113 = System.currentTimeMillis();
        b r25 = AlbumDatabase.a.a().c();     // Catch: Exception -> L39
        List<? extends MediaLifecycleState> r26 = r0;     // Catch: Exception -> L39
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));     // Catch: Exception -> L39
        Iterator<T> r27 = r26.iterator();     // Catch: Exception -> L39
    L21:
        if (r27.hasNext() == false) goto L23;
        r114.add(Boxing.boxInt(((MediaLifecycleState) r27.next()).getValue()));     // Catch: Exception -> L39
        goto L21
    L23:
        r3.L$0 = r0;     // Catch: Exception -> L39
        r3.L$1 = this;     // Catch: Exception -> L39
        r3.L$2 = "batch_load";     // Catch: Exception -> L39
        r3.L$3 = "album";     // Catch: Exception -> L39
        r3.I$0 = 0;     // Catch: Exception -> L39
        r3.J$0 = r113;     // Catch: Exception -> L39
        r3.label = 1;     // Catch: Exception -> L39
        r2 = r25.l(r114, r3);     // Catch: Exception -> L39
        if (r2 != r5) goto L26;
        return r5;
    L26:
        r20 = this;
        r8 = "album";
        r19 = "batch_load";
        r7 = r113;
        r10 = 0;
    L39:
        e = e;
        r111 = "batch_load";
        r7 = r113;
        r110 = 0;
        r13 = this;
    L7:
        r3 = new AlbumDataBaseHelper$selectMediaDataListByLifecycleStates$1(this, r24);
        goto L8
    }

    public final Object v(List<Long> r23, Continuation<? super List<MediaMetadata>> r24) {
        List<Long> r0 = r23;
        if ((r24 instanceof AlbumDataBaseHelper$selectMediaDataListBySystemGalleryIds$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataListBySystemGalleryIds$1 r4 = (AlbumDataBaseHelper$selectMediaDataListBySystemGalleryIds$1) r24;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r2 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        long r8 = r4.J$0;
        int r10 = r4.I$0;
        String r11 = (String) r4.L$3;
        String r12 = (String) r4.L$2;
        AlbumDataBaseHelper r13 = (AlbumDataBaseHelper) r4.L$1;
        r0 = (List) r4.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L14
        String r9 = r11;
        String r19 = r12;
        AlbumDataBaseHelper r20 = r13;
    L46:
        List r3 = (List) r2;     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "selectMediaDataListBySystemGalleryIds: systemGalleryIds=" + r0 + ", result=" + r3);     // Catch: Exception -> L33
        List r14 = r3;     // Catch: Exception -> L33
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));     // Catch: Exception -> L33
        Iterator r15 = r14.iterator();     // Catch: Exception -> L33
    L25:
        if (r15.hasNext() == false) goto L27;
        r1.add(a(a, (a) r15.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r16 = r1.size();     // Catch: Exception -> L33
        long r17 = System.currentTimeMillis() - r8;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r18 = 1;
    L31:
        r20.getClass();     // Catch: Exception -> L33
        l(r19, r9, r16, r17, 1, r18, "");     // Catch: Exception -> L33
    L41:
        if (r1 == null) goto L43;
        return r1;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r18 = 0;
    L33:
        e = e;
        r11 = r9;
        int r110 = r10;
        String r111 = r19;
        r13 = r20;
    L37:
        long r21 = System.currentTimeMillis() - r8;
        GalleryStoragePolicyManager.a.getClass();
        boolean r112 = GalleryStoragePolicyManager.m();
        String r22 = e.getMessage();
        if (r22 != null) goto L40;
        r22 = "";
    L40:
        r13.getClass();
        l(r111, r11, r110, r21, 0, r112 ? 1 : 0, r22);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r1 = null;
    L14:
        e = e;
        r110 = r10;
        r111 = r12;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r11 = "album";
        long r113 = System.currentTimeMillis();
        b r25 = AlbumDatabase.a.a().c();     // Catch: Exception -> L35
        r4.L$0 = r0;     // Catch: Exception -> L35
        r4.L$1 = this;     // Catch: Exception -> L35
        r4.L$2 = "batch_load";     // Catch: Exception -> L35
        r4.L$3 = "album";     // Catch: Exception -> L35
        r4.I$0 = 0;     // Catch: Exception -> L35
        r4.J$0 = r113;     // Catch: Exception -> L35
        r4.label = 1;     // Catch: Exception -> L35
        r2 = r25.e(r0, r4);     // Catch: Exception -> L35
        if (r2 != r6) goto L22;
        return r6;
    L22:
        r20 = this;
        r9 = "album";
        r19 = "batch_load";
        r8 = r113;
        r10 = 0;
    L35:
        e = e;
        r111 = "batch_load";
        r8 = r113;
        r110 = 0;
        r13 = this;
    L7:
        r4 = new AlbumDataBaseHelper$selectMediaDataListBySystemGalleryIds$1(this, r24);
        goto L8
    }

    public final Object y(MediaMetadata r23, Continuation<? super Unit> r24) {
        MediaMetadata r0 = r23;
        if ((r24 instanceof AlbumDataBaseHelper$updateMediaData$1) == false) goto L7;
        AlbumDataBaseHelper$updateMediaData$1 r4 = (AlbumDataBaseHelper$updateMediaData$1) r24;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r2 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        long r8 = r4.J$0;
        int r10 = r4.I$0;
        String r11 = (String) r4.L$3;
        String r12 = (String) r4.L$2;
        AlbumDataBaseHelper r13 = (AlbumDataBaseHelper) r4.L$1;
        r0 = (MediaMetadata) r4.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L14
        String r9 = r11;
        String r19 = r12;
        AlbumDataBaseHelper r20 = r13;
    L44:
        int r3 = ((Number) r2).intValue();     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "updateMediaData: uniqId=" + r0.getUniqId() + ", mediaId=" + r0.getMediaId() + ", rows=" + r3);     // Catch: Exception -> L33
        List r1 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r1 instanceof List) == false) goto L26;
        int r14 = r1.size();     // Catch: Exception -> L33
    L27:
        long r15 = System.currentTimeMillis() - r8;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r17 = 1;
    L31:
        r20.getClass();     // Catch: Exception -> L33
        l(r19, r9, r14, r15, 1, r17, "");     // Catch: Exception -> L33
        return r1;
    L30:
        r17 = 0;
        goto L31
    L26:
        r14 = r10;
    L33:
        e = e;
        r11 = r9;
        int r16 = r10;
        String r18 = r19;
        r13 = r20;
    L37:
        long r21 = System.currentTimeMillis() - r8;
        GalleryStoragePolicyManager.a.getClass();
        boolean r110 = GalleryStoragePolicyManager.m();
        String r22 = e.getMessage();
        if (r22 != null) goto L40;
        r22 = "";
    L40:
        r13.getClass();
        l(r18, r11, r16, r21, 0, r110 ? 1 : 0, r22);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r16 = r10;
        r18 = r12;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r2);
        r11 = "album";
        long r111 = System.currentTimeMillis();
        CoroutineDispatcher r25 = Dispatchers.getIO();     // Catch: Exception -> L35
        AlbumDataBaseHelper$updateMediaData$2$rows$1 r26 = new AlbumDataBaseHelper$updateMediaData$2$rows$1(r0, null);     // Catch: Exception -> L35
        r4.L$0 = r0;     // Catch: Exception -> L35
        r4.L$1 = this;     // Catch: Exception -> L35
        r4.L$2 = MemoryActionTag.MEMORY_ACTION_TAG_UPDATE;     // Catch: Exception -> L35
        r4.L$3 = "album";     // Catch: Exception -> L35
        r4.I$0 = 1;     // Catch: Exception -> L35
        r4.J$0 = r111;     // Catch: Exception -> L35
        r4.label = 1;     // Catch: Exception -> L35
        r2 = BuildersKt.withContext(r25, r26, r4);     // Catch: Exception -> L35
        if (r2 != r6) goto L22;
        return r6;
    L22:
        r20 = this;
        r9 = "album";
        r19 = MemoryActionTag.MEMORY_ACTION_TAG_UPDATE;
        r8 = r111;
        r10 = 1;
    L35:
        e = e;
        r18 = MemoryActionTag.MEMORY_ACTION_TAG_UPDATE;
        r8 = r111;
        r16 = 1;
        r13 = this;
    L7:
        r4 = new AlbumDataBaseHelper$updateMediaData$1(this, r24);
        goto L8
    }

    public final Object f(long r25, String r27, Continuation<? super Unit> r28) {
        String r0 = r27;
        if ((r28 instanceof AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1) == false) goto L7;
        AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1 r6 = (AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1) r28;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        Object r4 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r6.label;
        if (r9 == 0) goto L18;
        if (r9 != 1) goto L17;
        long r2 = r6.J$1;
        int r10 = r6.I$0;
        long r11 = r6.J$0;
        String r12 = (String) r6.L$3;
        String r13 = (String) r6.L$2;
        AlbumDataBaseHelper r14 = (AlbumDataBaseHelper) r6.L$1;
        r0 = (String) r6.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Exception -> L14
        String r15 = r13;
        AlbumDataBaseHelper r21 = r14;
    L42:
        int r5 = ((Number) r4).intValue();     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "deleteThumbnailDataByImageUuidAndSn: imageUuid=" + r11 + ", sn=" + r0 + ", rows=" + r5);     // Catch: Exception -> L33
        List r1 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r1 instanceof List) == false) goto L26;
        int r16 = r1.size();     // Catch: Exception -> L33
    L27:
        long r17 = System.currentTimeMillis() - r2;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r19 = 1;
    L31:
        r21.getClass();     // Catch: Exception -> L33
        l(r15, r12, r16, r17, 1, r19, "");     // Catch: Exception -> L33
        return r1;
    L30:
        r19 = 0;
        goto L31
    L26:
        r16 = r10;
    L33:
        e = e;
        String r18 = r15;
        int r110 = r10;
        String r111 = r12;
        r14 = r21;
    L37:
        long r3 = System.currentTimeMillis() - r2;
        GalleryStoragePolicyManager.a.getClass();
        boolean r112 = GalleryStoragePolicyManager.m();
        String r20 = e.getMessage();
        if (r20 != null) goto L40;
        r20 = "";
    L40:
        r14.getClass();
        l(r18, r111, r110, r3, 0, r112 ? 1 : 0, r20);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r111 = r12;
        r18 = r13;
        r110 = r10;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r4);
        r12 = "album_thumbnail";
        long r113 = System.currentTimeMillis();
        j r22 = AlbumDatabase.a.a().d();     // Catch: Exception -> L35
        r6.L$0 = r0;     // Catch: Exception -> L35
        r6.L$1 = this;     // Catch: Exception -> L35
        r6.L$2 = "delete";     // Catch: Exception -> L35
        r6.L$3 = "album_thumbnail";     // Catch: Exception -> L35
        r6.J$0 = r25;     // Catch: Exception -> L35
        r6.I$0 = 1;     // Catch: Exception -> L35
        r6.J$1 = r113;     // Catch: Exception -> L35
        r6.label = 1;     // Catch: Exception -> L35
        r4 = r22.a(r25, r0, r6);     // Catch: Exception -> L35
        if (r4 != r8) goto L22;
        return r8;
    L22:
        r21 = this;
        r15 = "delete";
        r10 = 1;
        r2 = r113;
        r11 = r25;
    L35:
        e = e;
        r14 = this;
        r2 = r113;
        r18 = "delete";
        r110 = 1;
        r111 = "album_thumbnail";
    L7:
        r6 = new AlbumDataBaseHelper$deleteThumbnailDataByImageUuidAndSn$1(this, r28);
        goto L8
    }

    public final Object g(List<Long> r23, String r24, Continuation<? super Unit> r25) {
        List<Long> r0 = r23;
        String r2 = r24;
        if ((r25 instanceof AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1) == false) goto L7;
        AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1 r5 = (AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1) r25;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r3 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        if (r8 == 0) goto L18;
        if (r8 != 1) goto L17;
        long r9 = r5.J$0;
        int r4 = r5.I$0;
        String r10 = (String) r5.L$4;
        String r11 = (String) r5.L$3;
        AlbumDataBaseHelper r12 = (AlbumDataBaseHelper) r5.L$2;
        String r1 = (String) r5.L$1;
        List<Long> r13 = (List) r5.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Exception -> L14
        String r18 = r10;
        String r19 = r11;
        AlbumDataBaseHelper r20 = r12;
        r2 = r1;
        r0 = r13;
        Object r14 = r3;
        int r15 = r4;
    L43:
        int r16 = ((Number) r14).intValue();     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "deleteThumbnailDataByImageUuidsAndSn: imageUuids=" + r0 + ", sn=" + r2 + ", rows=" + r16);     // Catch: Exception -> L33
        List r17 = Unit.INSTANCE;     // Catch: Exception -> L33
        if ((r17 instanceof List) == false) goto L26;
        int r110 = r17.size();     // Catch: Exception -> L33
    L27:
        long r111 = System.currentTimeMillis() - r9;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r112 = 1;
    L31:
        r20.getClass();     // Catch: Exception -> L33
        l(r19, r18, r110, r111, 1, r112, "");     // Catch: Exception -> L33
        return r17;
    L30:
        r112 = 0;
        goto L31
    L26:
        r110 = r15;
    L33:
        e = e;
        int r113 = r15;
        String r114 = r18;
        String r115 = r19;
    L38:
        long r116 = System.currentTimeMillis() - r9;
        GalleryStoragePolicyManager.a.getClass();
        boolean r117 = GalleryStoragePolicyManager.m();
        String r21 = e.getMessage();
        if (r21 != null) goto L41;
        r21 = "";
    L41:
        r20.getClass();
        l(r115, r114, r113, r116, 0, r117 ? 1 : 0, r21);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r20 = r12;
        r113 = r4;
    L37:
        String r22 = r11;
        r114 = r10;
        r115 = r22;
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        r11 = "delete";
        r10 = "album_thumbnail";
        r15 = r23.size();
        long r118 = System.currentTimeMillis();
        j r26 = AlbumDatabase.a.a().d();     // Catch: Exception -> L35
        r5.L$0 = r0;     // Catch: Exception -> L35
        r5.L$1 = r2;     // Catch: Exception -> L35
        r5.L$2 = this;     // Catch: Exception -> L35
        r5.L$3 = "delete";     // Catch: Exception -> L35
        r5.L$4 = "album_thumbnail";     // Catch: Exception -> L35
        r5.I$0 = r15;     // Catch: Exception -> L35
        r5.J$0 = r118;     // Catch: Exception -> L35
        r5.label = 1;     // Catch: Exception -> L35
        r14 = r26.c(r0, r2, r5);     // Catch: Exception -> L35
        if (r14 != r7) goto L22;
        return r7;
    L22:
        r20 = this;
        r18 = "album_thumbnail";
        r19 = "delete";
        r9 = r118;
    L35:
        e = e;
        r20 = this;
        r9 = r118;
        r113 = r15;
    L7:
        r5 = new AlbumDataBaseHelper$deleteThumbnailDataByImageUuidsAndSn$1(this, r25);
        goto L8
    }

    public final Object u(int r25, int r26, Continuation<? super List<MediaMetadata>> r27) {
        int r0 = r25;
        int r2 = r26;
        if ((r27 instanceof AlbumDataBaseHelper$selectMediaDataListByPage$1) == false) goto L7;
        AlbumDataBaseHelper$selectMediaDataListByPage$1 r5 = (AlbumDataBaseHelper$selectMediaDataListByPage$1) r27;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r3 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        if (r8 == 0) goto L18;
        if (r8 != 1) goto L17;
        long r9 = r5.J$0;
        int r4 = r5.I$2;
        int r1 = r5.I$1;
        int r11 = r5.I$0;
        String r12 = (String) r5.L$2;
        String r13 = (String) r5.L$1;
        AlbumDataBaseHelper r10 = (AlbumDataBaseHelper) r5.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Exception -> L14
        long r14 = r9;
        AlbumDataBaseHelper r15 = r10;
        Object r16 = r3;
        int r17 = r4;
        r2 = r1;
        r0 = r11;
    L46:
        List r18 = (List) r16;     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "selectMediaDataListByPage: offset=" + r0 + ", limit=" + r2 + ", result=" + r18);     // Catch: Exception -> L33
        List r19 = r18;     // Catch: Exception -> L33
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));     // Catch: Exception -> L33
        Iterator r21 = r19.iterator();     // Catch: Exception -> L33
    L25:
        if (r21.hasNext() == false) goto L27;
        r20.add(a(a, (a) r21.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r110 = r20.size();     // Catch: Exception -> L33
        long r111 = System.currentTimeMillis() - r14;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r22 = 1;
    L31:
        r15.getClass();     // Catch: Exception -> L33
        l(r13, r12, r110, r111, 1, r22, "");     // Catch: Exception -> L33
    L41:
        if (r20 == null) goto L43;
        return r20;
    L43:
        return CollectionsKt.emptyList();
    L30:
        r22 = 0;
    L33:
        e = e;
        r10 = r15;
        String r112 = r13;
        r9 = r14;
        int r113 = r17;
    L37:
        long r114 = System.currentTimeMillis() - r9;
        GalleryStoragePolicyManager.a.getClass();
        boolean r115 = GalleryStoragePolicyManager.m();
        String r23 = e.getMessage();
        if (r23 != null) goto L40;
        r23 = "";
    L40:
        r10.getClass();
        l(r112, r12, r113, r114, 0, r115 ? 1 : 0, r23);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r20 = null;
    L14:
        e = e;
        r112 = r13;
        r113 = r4;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        r13 = "batch_load";
        r12 = "album";
        r14 = System.currentTimeMillis();
        b r24 = AlbumDatabase.a.a().c();     // Catch: Exception -> L35
        r5.L$0 = this;     // Catch: Exception -> L35
        r5.L$1 = "batch_load";     // Catch: Exception -> L35
        r5.L$2 = "album";     // Catch: Exception -> L35
        r5.I$0 = r0;     // Catch: Exception -> L35
        r5.I$1 = r2;     // Catch: Exception -> L35
        r5.I$2 = 0;     // Catch: Exception -> L35
        r5.J$0 = r14;     // Catch: Exception -> L35
        r5.label = 1;     // Catch: Exception -> L35
        Object r28 = r24.d(r0, r2, r5);     // Catch: Exception -> L35
        if (r28 != r7) goto L22;
        return r7;
    L22:
        r15 = this;
        r16 = r28;
        r17 = 0;
    L35:
        e = e;
        r10 = this;
        r112 = "batch_load";
        r9 = r14;
        r113 = 0;
    L7:
        r5 = new AlbumDataBaseHelper$selectMediaDataListByPage$1(this, r27);
        goto L8
    }

    public final Object w(long r26, String r28, Continuation<? super ThumbnailMetadata> r29) {
        String r0 = r28;
        if ((r29 instanceof AlbumDataBaseHelper$selectThumbnailDataByImageUuidAndSn$1) == false) goto L7;
        AlbumDataBaseHelper$selectThumbnailDataByImageUuidAndSn$1 r6 = (AlbumDataBaseHelper$selectThumbnailDataByImageUuidAndSn$1) r29;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        Object r4 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r6.label;
        if (r9 == 0) goto L18;
        if (r9 != 1) goto L17;
        long r2 = r6.J$1;
        int r10 = r6.I$0;
        long r12 = r6.J$0;
        String r11 = (String) r6.L$3;
        String r14 = (String) r6.L$2;
        AlbumDataBaseHelper r15 = (AlbumDataBaseHelper) r6.L$1;
        r0 = (String) r6.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Exception -> L14
        String r13 = r14;
        AlbumDataBaseHelper r22 = r15;
    L48:
        i r5 = (i) r4;     // Catch: Exception -> L37
        FLogger.a.i("AlbumDataBaseHelper", "selectThumbnailDataByImageUuidAndSn: imageUuid=" + r12 + ", sn=" + r0 + ", result=" + r5);     // Catch: Exception -> L37
        if (r5 == null) goto L26;
        Object r1 = b(a, r5);     // Catch: Exception -> L37
    L28:
        if ((r1 instanceof List) == false) goto L30;
        int r16 = ((List) r1).size();     // Catch: Exception -> L37
    L31:
        long r17 = System.currentTimeMillis() - r2;     // Catch: Exception -> L37
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L37
        if (GalleryStoragePolicyManager.m() == false) goto L34;
        int r20 = 1;
    L35:
        r22.getClass();     // Catch: Exception -> L37
        l(r13, r11, r16, r17, 1, r20, "");     // Catch: Exception -> L37
        return r1;
    L34:
        r20 = 0;
        goto L35
    L30:
        r16 = r10;
        goto L31
    L26:
        r1 = null;
    L37:
        e = e;
        String r18 = r13;
        int r19 = r10;
        String r110 = r11;
        r15 = r22;
    L41:
        long r3 = System.currentTimeMillis() - r2;
        GalleryStoragePolicyManager.a.getClass();
        boolean r111 = GalleryStoragePolicyManager.m();
        String r21 = e.getMessage();
        if (r21 != null) goto L44;
        r21 = "";
    L44:
        r15.getClass();
        l(r18, r110, r19, r3, 0, r111 ? 1 : 0, r21);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L14:
        e = e;
        r110 = r11;
        r18 = r14;
        r19 = r10;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r4);
        r11 = "album_thumbnail";
        long r112 = System.currentTimeMillis();
        j r23 = AlbumDatabase.a.a().d();     // Catch: Exception -> L39
        r6.L$0 = r0;     // Catch: Exception -> L39
        r6.L$1 = this;     // Catch: Exception -> L39
        r6.L$2 = "get_one";     // Catch: Exception -> L39
        r6.L$3 = "album_thumbnail";     // Catch: Exception -> L39
        r6.J$0 = r26;     // Catch: Exception -> L39
        r6.I$0 = 1;     // Catch: Exception -> L39
        r6.J$1 = r112;     // Catch: Exception -> L39
        r6.label = 1;     // Catch: Exception -> L39
        r4 = r23.b(r26, r0, r6);     // Catch: Exception -> L39
        if (r4 != r8) goto L22;
        return r8;
    L22:
        r22 = this;
        r13 = "get_one";
        r10 = 1;
        r2 = r112;
        r12 = r26;
    L39:
        e = e;
        r15 = this;
        r2 = r112;
        r18 = "get_one";
        r19 = 1;
        r110 = "album_thumbnail";
    L7:
        r6 = new AlbumDataBaseHelper$selectThumbnailDataByImageUuidAndSn$1(this, r29);
        goto L8
    }

    public final Object x(List<Long> r23, String r24, Continuation<? super List<ThumbnailMetadata>> r25) {
        List<Long> r0 = r23;
        String r2 = r24;
        if ((r25 instanceof AlbumDataBaseHelper$selectThumbnailDataListByImageUuidsAndSn$1) == false) goto L7;
        AlbumDataBaseHelper$selectThumbnailDataListByImageUuidsAndSn$1 r5 = (AlbumDataBaseHelper$selectThumbnailDataListByImageUuidsAndSn$1) r25;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r3 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        if (r8 == 0) goto L18;
        if (r8 != 1) goto L17;
        long r9 = r5.J$0;
        int r4 = r5.I$0;
        String r10 = (String) r5.L$4;
        String r11 = (String) r5.L$3;
        AlbumDataBaseHelper r12 = (AlbumDataBaseHelper) r5.L$2;
        String r1 = (String) r5.L$1;
        List<Long> r13 = (List) r5.L$0;
        ResultKt.throwOnFailure(r3);     // Catch: Exception -> L14
        String r18 = r10;
        String r19 = r11;
        AlbumDataBaseHelper r20 = r12;
        r2 = r1;
        r0 = r13;
        Object r14 = r3;
        int r15 = r4;
    L49:
        List r16 = (List) r14;     // Catch: Exception -> L33
        FLogger.a.i("AlbumDataBaseHelper", "selectThumbnailDataListByImageUuidsAndSn: imageUuids=" + r0 + ", sn=" + r2 + ", result=" + r16);     // Catch: Exception -> L33
        List r17 = r16;     // Catch: Exception -> L33
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));     // Catch: Exception -> L33
        Iterator r22 = r17.iterator();     // Catch: Exception -> L33
    L25:
        if (r22.hasNext() == false) goto L27;
        r21.add(b(a, (i) r22.next()));     // Catch: Exception -> L33
        goto L25
    L27:
        int r110 = r21.size();     // Catch: Exception -> L33
        long r111 = System.currentTimeMillis() - r9;     // Catch: Exception -> L33
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L33
        if (GalleryStoragePolicyManager.m() == false) goto L30;
        int r112 = 1;
    L31:
        r20.getClass();     // Catch: Exception -> L33
        l(r19, r18, r110, r111, 1, r112, "");     // Catch: Exception -> L33
    L42:
        if (r21 == null) goto L44;
        return r21;
    L44:
        return CollectionsKt.emptyList();
    L30:
        r112 = 0;
    L33:
        e = e;
        int r113 = r15;
        String r114 = r18;
        String r115 = r19;
    L38:
        long r116 = System.currentTimeMillis() - r9;
        GalleryStoragePolicyManager.a.getClass();
        boolean r117 = GalleryStoragePolicyManager.m();
        String r26 = e.getMessage();
        if (r26 != null) goto L41;
        r26 = "";
    L41:
        r20.getClass();
        l(r115, r114, r113, r116, 0, r117 ? 1 : 0, r26);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r21 = null;
    L14:
        e = e;
        r20 = r12;
        r113 = r4;
    L37:
        String r27 = r11;
        r114 = r10;
        r115 = r27;
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        r11 = "batch_load";
        r10 = "album_thumbnail";
        r15 = r23.size();
        long r118 = System.currentTimeMillis();
        j r28 = AlbumDatabase.a.a().d();     // Catch: Exception -> L35
        r5.L$0 = r0;     // Catch: Exception -> L35
        r5.L$1 = r2;     // Catch: Exception -> L35
        r5.L$2 = this;     // Catch: Exception -> L35
        r5.L$3 = "batch_load";     // Catch: Exception -> L35
        r5.L$4 = "album_thumbnail";     // Catch: Exception -> L35
        r5.I$0 = r15;     // Catch: Exception -> L35
        r5.J$0 = r118;     // Catch: Exception -> L35
        r5.label = 1;     // Catch: Exception -> L35
        r14 = r28.d(r0, r2, r5);     // Catch: Exception -> L35
        if (r14 != r7) goto L22;
        return r7;
    L22:
        r20 = this;
        r18 = "album_thumbnail";
        r19 = "batch_load";
        r9 = r118;
    L35:
        e = e;
        r20 = this;
        r9 = r118;
        r113 = r15;
    L7:
        r5 = new AlbumDataBaseHelper$selectThumbnailDataListByImageUuidsAndSn$1(this, r25);
        goto L8
    }

    public final Object z(String r27, MediaLifecycleState r28, String r29, Continuation<? super Unit> r30) {
        String r2 = r27;
        if ((r30 instanceof AlbumDataBaseHelper$updateMediaDataLifecycleStateFailed$1) == false) goto L7;
        AlbumDataBaseHelper$updateMediaDataLifecycleStateFailed$1 r4 = (AlbumDataBaseHelper$updateMediaDataLifecycleStateFailed$1) r30;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r0 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        long r8 = r4.J$0;
        int r3 = r4.I$0;
        String r13 = (String) r4.L$5;
        String r14 = (String) r4.L$4;
        AlbumDataBaseHelper r15 = (AlbumDataBaseHelper) r4.L$3;
        String r9 = (String) r4.L$2;
        MediaLifecycleState r10 = (MediaLifecycleState) r4.L$1;
        String r11 = (String) r4.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L14
        int r12 = r3;
        r2 = r11;
        String r16 = r9;
        AlbumDataBaseHelper r17 = r15;
    L77:
    L37:
        e = e;
        int r18 = r12;
        String r19 = r13;
        String r110 = r14;
    L46:
        long r111 = System.currentTimeMillis() - r8;
        GalleryStoragePolicyManager.a.getClass();
        boolean r22 = GalleryStoragePolicyManager.m();
        String r20 = e.getMessage();
        if (r20 != null) goto L49;
        String r23 = "";
    L50:
        r17.getClass();
        l(r110, r19, r18, r111, 0, r22 ? 1 : 0, r23);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        r0 = null;
    L51:
        a r1 = (a) r0;
        if (r1 != null) goto L55;
        FLogger.a.e("AlbumDataBaseHelper", "updateMediaDataLifecycleStateFailed: mediaMetadata not found, id=" + r2);
        return Unit.INSTANCE;
    L55:
        long r112 = System.currentTimeMillis();
        b r21 = AlbumDatabase.a.a().c();     // Catch: Exception -> L70
        if (r10 != MediaLifecycleState.FAILED) goto L59;
        Integer r24 = Boxing.boxInt(r1.p);     // Catch: Exception -> L70
    L60:
        r1.q = r24;     // Catch: Exception -> L70
        r1.p = r10.getValue();     // Catch: Exception -> L70
        r1.r = r16;     // Catch: Exception -> L70
        int r25 = r21.a(r1);     // Catch: Exception -> L70
        FLogger.a.i("AlbumDataBaseHelper", "updateMediaDataLifecycleStateFailed: id=" + r2 + ", newState=" + r10 + ", failureReason=" + r16 + ", rows=" + r25);     // Catch: Exception -> L70
        List r26 = Unit.INSTANCE;     // Catch: Exception -> L70
        if ((r26 instanceof List) == false) goto L63;
        int r31 = r26.size();     // Catch: Exception -> L70
    L64:
        long r32 = System.currentTimeMillis() - r112;     // Catch: Exception -> L70
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L70
        if (GalleryStoragePolicyManager.m() == false) goto L67;
        int r33 = 1;
    L68:
        l(MemoryActionTag.MEMORY_ACTION_TAG_UPDATE, "album", r31, r32, 1, r33, "");     // Catch: Exception -> L70
        return r26;
    L67:
        r33 = 0;
        goto L68
    L63:
        r31 = 1;
        goto L64
    L59:
        r24 = null;
    L70:
        e = move-exception;
        long r34 = System.currentTimeMillis() - r112;
        GalleryStoragePolicyManager.a.getClass();
        boolean r35 = GalleryStoragePolicyManager.m();
        String r36 = e.getMessage();
        if (r36 != null) goto L74;
        String r37 = "";
    L75:
        l(MemoryActionTag.MEMORY_ACTION_TAG_UPDATE, "album", 1, r34, 0, r35 ? 1 : 0, r37);
        FLogger.a.e("AlbumDataBaseHelper", "runDbOperation error: " + e);
        return null;
    L74:
        r37 = r36;
        goto L75
    L49:
        r23 = r20;
        goto L50
    L28:
        if ((r0 instanceof List) == false) goto L30;
        int r113 = ((List) r0).size();     // Catch: Exception -> L37
    L31:
        long r114 = System.currentTimeMillis() - r8;     // Catch: Exception -> L37
        GalleryStoragePolicyManager.a.getClass();     // Catch: Exception -> L37
        if (GalleryStoragePolicyManager.m() == false) goto L34;
        int r210 = 1;
    L35:
        r17.getClass();     // Catch: Exception -> L37
        l(r14, r13, r113, r114, 1, r210, "");     // Catch: Exception -> L37
        goto L51
    L34:
        r210 = 0;
        goto L35
    L30:
        r113 = r12;
    L14:
        e = e;
        r18 = r3;
        r2 = r11;
        r19 = r13;
        r110 = r14;
        r16 = r9;
        r17 = r15;
        goto L46
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r14 = "get_one";
        r13 = "album";
        long r38 = System.currentTimeMillis();
        b r39 = AlbumDatabase.a.a().c();     // Catch: Exception -> L43
        r4.L$0 = r2;     // Catch: Exception -> L43
        r10 = r28;
        r4.L$1 = r10;     // Catch: Exception -> L41
        r16 = r29;
        r4.L$2 = r16;     // Catch: Exception -> L39
        r4.L$3 = this;     // Catch: Exception -> L39
        r4.L$4 = "get_one";     // Catch: Exception -> L39
        r4.L$5 = "album";     // Catch: Exception -> L39
        r4.I$0 = 1;     // Catch: Exception -> L39
        r4.J$0 = r38;     // Catch: Exception -> L39
        r4.label = 1;     // Catch: Exception -> L39
        r0 = r39.k(r2, r4);     // Catch: Exception -> L39
        if (r0 != r6) goto L26;
        return r6;
    L26:
        r8 = r38;
        r12 = 1;
        r17 = this;
    L39:
        e = e;
    L45:
        r8 = r38;
        r19 = "album";
        r110 = "get_one";
        r18 = 1;
        r17 = this;
    L41:
        e = e;
    L42:
        r16 = r29;
    L43:
        e = e;
        r10 = r28;
    L7:
        r4 = new AlbumDataBaseHelper$updateMediaDataLifecycleStateFailed$1(this, r30);
        goto L8
    }

    public static void l(String r2, String r3, int r4, long r5, int r7, int r8, String r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("op", r2);
        r0.put("store", r3);
        r0.put("count", Integer.valueOf(r4));
        r0.put("duration_ms", Long.valueOf(r5));
        r0.put("success", Integer.valueOf(r7));
        r0.put("db_transfered", Integer.valueOf(r8));
        r0.put("error_message", r9);
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L6;
        r6.A0("flow_dora_album_data_op", r0);
        return;
    }
}
