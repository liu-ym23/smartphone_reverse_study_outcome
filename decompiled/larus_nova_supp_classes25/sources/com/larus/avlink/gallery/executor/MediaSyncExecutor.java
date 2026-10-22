package com.larus.avlink.gallery.executor;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import w88.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MediaSyncExecutor {
    public static final MediaSyncExecutor a = null;
    public static final ContentResolver b = null;
    public static final MediaLifecycleStateManager c = null;
    public static final Set<Uri> d = null;
    public static final Object e = null;
    public static Job f;
    public static Job g;
    public static final CoroutineScope h = null;
    public static w88.a i;

    public static final class a extends ContentObserver {
        public a(Handler r1) {
            super(r1);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r8, Uri r9) {
            super.onChange(r8, r9);
            FLogger.a.d("MediaSyncExecutor", "Image content changed, uri: " + r9);
            MediaSyncExecutor r10 = MediaSyncExecutor.a;
            MediaSyncExecutor.c(r9);
            MediaAdditionReconciler r11 = MediaAdditionReconciler.a;
            com.larus.avlink.gallery.e.a.getClass();
            if (com.larus.avlink.gallery.e.i() == false) goto L29;
            if (r9 == null) goto L24;
            String r12 = r9.getLastPathSegment();
            if (r12 == null) goto L27;
            Long r13 = StringsKt.toLongOrNull(r12);
            if (r13 == null) goto L28;
            long r14 = r13.longValue();
            if (r14 <= 0) goto L30;
            Object r0 = MediaAdditionReconciler.e;
            monitor-enter(r0);
            MediaAdditionReconciler.d.add(Long.valueOf(r14));     // Catch: Throwable -> L21
            Job r15 = MediaAdditionReconciler.f;     // Catch: Throwable -> L21
            if (r15 == null) goto L18;
            Job.DefaultImpls.cancel$default(r15, null, 1, null);     // Catch: Throwable -> L21
        L18:
            MediaAdditionReconciler.f = BuildersKt.launch$default(MediaAdditionReconciler.g, null, null, new MediaAdditionReconciler$onImageContentChanged$1$1(null), 3, null);     // Catch: Throwable -> L21
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r0);
            return;
        L21:
            th = move-exception;
            throw th;
        L30:
            return;
        L28:
            return;
        L27:
            return;
        L24:
            return;
        }
    }

    public static final class b extends ContentObserver {
        public b(Handler r1) {
            super(r1);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r3, Uri r4) {
            super.onChange(r3, r4);
            FLogger.a.d("MediaSyncExecutor", "Video content changed, uri: " + r4);
            MediaSyncExecutor r5 = MediaSyncExecutor.a;
            MediaSyncExecutor.c(r4);
        }
    }

    public MediaSyncExecutor() {
    }

    static {
        a = new MediaSyncExecutor();
        ContentResolver r0 = AppHost.a.getApplication().getContentResolver();
        b = r0;
        c = MediaLifecycleStateManager.b.a();
        d = new LinkedHashSet();
        e = new Object();
        h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        a r3 = new a(new Handler(Looper.getMainLooper()));
        b r4 = new b(new Handler(Looper.getMainLooper()));
        r0.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, r3);
        r0.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, r4);
    }

    public static void c(Uri r7) {
        Object r0 = e;
        monitor-enter(r0);
        boolean r1 = true;
        if (r7 != null) goto L22;
        Job r8 = f;     // Catch: Throwable -> L28
        if (r8 == null) goto L9;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);     // Catch: Throwable -> L28
    L9:
        f = null;     // Catch: Throwable -> L28
        d.clear();     // Catch: Throwable -> L28
        Job r9 = g;     // Catch: Throwable -> L28
        if (r9 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L19;
        FLogger.a.d("MediaSyncExecutor", "Full check already in progress, skipping");     // Catch: Throwable -> L28
        monitor-exit(r0);
        return;
    L19:
        g = BuildersKt.launch$default(h, null, null, new MediaSyncExecutor$checkDeletedMedia$1$1(null), 3, null);     // Catch: Throwable -> L28
        monitor-exit(r0);
        return;
    L12:
        if (r9.isActive() != true) goto L14;
    L22:
        d.add(r7);     // Catch: Throwable -> L28
        Job r10 = f;     // Catch: Throwable -> L28
        if (r10 == null) goto L25;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);     // Catch: Throwable -> L28
    L25:
        f = BuildersKt.launch$default(h, null, null, new MediaSyncExecutor$checkDeletedMedia$1$2(null), 3, null);     // Catch: Throwable -> L28
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r0);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public static void d(String[] r14) {
        Intrinsics.checkNotNullParameter(r14, "mediaIds");
        if (r14.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        FLogger r1 = FLogger.a;
        r1.i("MediaSyncExecutor", "deleteFromAlbum: deleting " + r14.length + " items: " + ArraysKt.joinToString$default(r14, ",", null, null, 0, null, null, 62, null));
        ContentResolver r3 = b;
        int r2 = com.larus.avlink.gallery.c.d(r3, r14, false);
        int r15 = com.larus.avlink.gallery.c.d(r3, r14, true);
        r1.i("MediaSyncExecutor", "deleteFromAlbum: deleted " + (r2 + r15) + " items (" + r2 + " images, " + r15 + " videos)");
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static String e(MediaMetadata r7, PolarisFileWrapper r8) {
        String r0 = FilesKt.getExtension(r8);
        boolean r9 = com.larus.avlink.gallery.c.k(r8.getName());
        int r1 = ia8.d.a;
        long r2 = r7.getCreateTime();
        if (r2 != 0) goto L5;
        String r3 = "";
    L6:
        String r4 = r7.getAlgorithmType();
        if (r4 != null) goto L9;
    L27:
        int r5 = 0;
    L29:
        if (r9 == false) goto L32;
        return "VID_" + r3 + '_' + r7.getMediaId() + '_' + r7.getActiveMask() + r5 + '.' + r0;
    L32:
        return "IMG_" + r3 + '_' + r7.getMediaId() + '_' + r7.getActiveMask() + r5 + '.' + r0;
    L9:
        switch(r4.hashCode()) {
            case -1068318794: goto L24;
            case 103158: goto L20;
            case 3348765: goto L16;
            case 103060854: goto L12;
            default: goto L27;
        };
    L12:
        if (r4.equals("llhdr") == false) goto L27;
        r5 = 2;
        goto L29
    L16:
        if (r4.equals("mfnr") == false) goto L27;
        r5 = 3;
        goto L29
    L20:
        if (r4.equals("hdr") == false) goto L27;
        r5 = 1;
        goto L29
    L24:
        if (r4.equals("motion") == false) goto L27;
        r5 = 4;
        goto L29
    L5:
        Calendar r6 = Calendar.getInstance();
        r6.setTimeInMillis(r2);
        r3 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.getDefault()).format(r6.getTime());
        goto L6
    }

    public final Object f(MediaMetadata r28, Continuation<? super Unit> r29) {
        if ((r29 instanceof MediaSyncExecutor$syncToAlbum$1) == false) goto L7;
        MediaSyncExecutor$syncToAlbum$1 r5 = (MediaSyncExecutor$syncToAlbum$1) r29;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r0 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r11 = ": ";
        String r9 = "Media ";
        switch(r5.label) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L29;
            case 5: goto L24;
            case 6: goto L21;
            case 7: goto L16;
            case 8: goto L13;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r0);
    L201:
        return Unit.INSTANCE;
    L13:
        String r1 = (String) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L32
        r9 = "Media ";
        String r10 = "MediaSyncExecutor";
        String r7 = ": ";
    L210:
        FLogger.a.i(r10, r9 + r1 + " synced skipped, uniqId: " + r1);     // Catch: Exception -> L187
    L187:
        e = e;
        String r12 = r1;
    L197:
        FLogger.a.e(r10, "Exception syncing media " + r12 + r7 + e.getMessage(), e);
        MediaLifecycleStateManager r2 = c;
        StringBuilder r3 = new StringBuilder("Sync exception: ");
        r3.append(e.getMessage());
        String r4 = r3.toString();
        r5.L$0 = null;
        r5.L$1 = null;
        r5.label = 9;
        if (r2.b(r12, r4, r5) != r13) goto L201;
        return r13;
    L16:
        long r8 = r5.J$0;
        String r14 = (String) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L19
        r9 = "Media ";
        r10 = "MediaSyncExecutor";
        r7 = ": ";
    L206:
        FLogger.a.i(r10, r9 + r14 + " synced successfully, systemGalleryId: " + r8);     // Catch: Exception -> L176
    L176:
        e = e;
    L193:
        r12 = r14;
    L19:
        e = e;
    L34:
        r10 = "MediaSyncExecutor";
        r7 = ": ";
        goto L193
    L21:
        String r15 = (String) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L32
        r10 = "MediaSyncExecutor";
        String r16 = ": ";
    L208:
        return Unit.INSTANCE;
    L156:
        e = e;
        r14 = r15;
        r7 = r16;
        goto L193
    L24:
        long r17 = r5.J$0;
        String r18 = (String) r5.L$1;
        String r19 = (String) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L27
        String r20 = r19;
        r9 = "Media ";
        r10 = "MediaSyncExecutor";
        String r110 = ", systemGalleryId: ";
        String r21 = r18;
        long r22 = r17;
        String r23 = ": ";
    L230:
        FLogger.a.i(r10, r9 + r20 + " synced to public album: " + r21 + r110 + r22);     // Catch: Exception -> L115
        return Unit.INSTANCE;
    L115:
        e = e;
    L116:
        r12 = r20;
    L121:
        r7 = r23;
    L117:
        e = e;
    L27:
        e = e;
        r14 = r19;
        goto L34
    L29:
        String r24 = (String) r5.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L32
        r10 = "MediaSyncExecutor";
    L212:
        return Unit.INSTANCE;
    L86:
        e = e;
        r12 = r24;
    L104:
        r23 = r11;
        goto L121
    L35:
        ResultKt.throwOnFailure(r0);
    L71:
        return Unit.INSTANCE;
    L36:
        ResultKt.throwOnFailure(r0);
    L60:
        return Unit.INSTANCE;
    L37:
        String r25 = (String) r5.L$1;
        MediaMetadata r26 = (MediaMetadata) r5.L$0;
        ResultKt.throwOnFailure(r0);
        r12 = r25;
    L43:
        if (r26.getSystemGalleryId() == null) goto L62;
        Long r27 = r26.getSystemGalleryId();
        if (r27 != null) goto L48;
    L49:
        Long r30 = r26.getSystemGalleryId();
        if (r30 != null) goto L53;
    L54:
        String r31 = r26.getSystemGalleryId().toString();
        if (com.larus.avlink.gallery.c.i(b, r31) == false) goto L61;
        FLogger.a.i("MediaSyncExecutor", "Media already synced to album: " + r12 + ", systemGalleryId: " + r31);
        MediaLifecycleStateManager r32 = c;
        MediaLifecycleState r33 = MediaLifecycleState.COMPLETED;
        r5.L$0 = null;
        r5.L$1 = null;
        r5.label = 2;
        if (MediaLifecycleStateManager.g(r32, r12, r33, null, r5, 12) != r13) goto L60;
        return r13;
    L61:
        FLogger.a.i(r10, "Media was deleted from album, re-syncing: " + r12);
        goto L62
    L53:
        if (r30.longValue() == (-1)) goto L62;
    L48:
        if (r27.longValue() != 0) goto L49;
    L62:
        String r34 = r26.getProcessedFilePath();
        if (r34 != null) goto L65;
        r34 = r26.getFilePath();
    L65:
        PolarisFileWrapper r35 = new PolarisFileWrapper(r34);
        if (r35.exists() == true) goto L72;
        FLogger.a.e(r10, "File not found for media " + r12 + ": " + r34);
        MediaLifecycleStateManager r36 = c;
        StringBuilder r37 = new StringBuilder("File not found: ");
        r37.append(r34);
        String r38 = r37.toString();
        r5.L$0 = null;
        r5.L$1 = null;
        r5.label = 3;
        if (r36.b(r12, r38, r5) != r13) goto L71;
        return r13;
    L72:
        r11 = r11;
        com.larus.avlink.gallery.e.a.getClass();     // Catch: Exception -> L194
        r7 = "Failed to insert media file: ";
        if (com.larus.avlink.gallery.e.i() == true) goto L202;
        String r39 = r12;
        r16 = r11;
        PolarisFileWrapper r40 = com.larus.avlink.gallery.e.d();     // Catch: Exception -> L178
        r40.mkdirs();     // Catch: Exception -> L178
        final PolarisFileWrapper r41 = new PolarisFileWrapper(r40, e(r26, r35));     // Catch: Exception -> L191
        if (Intrinsics.areEqual(r35.getAbsolutePath(), r41.getAbsolutePath()) == true) goto L132;
        FilesKt.copyTo$default(r35, r41, true, 0, 4, null);     // Catch: Exception -> L191
        FLogger.a.i(r10, "Copied to final directory: " + r41.getAbsolutePath());     // Catch: Exception -> L191
    L133:
        String r42 = ia8.b.a;     // Catch: Exception -> L191
        if (ia8.b.a(AppHost.a.getApplication()) == false) goto L180;
        IDoraService r43 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L191
        if (r43 == null) goto L142;
        VisionService r44 = r43.V();     // Catch: Exception -> L191
        if (r44 == null) goto L142;
        if (r44.q() != true) goto L142;
        boolean r45 = true;
    L143:
        if (r45 == false) goto L180;
        Uri r46 = com.larus.avlink.gallery.c.f(b, r41.getName(), r41.getAbsolutePath(), r26);     // Catch: Exception -> L191
        if (r46 != null) goto L160;
        FLogger.a.e(r10, "Failed to insert media file: " + r41.getName());     // Catch: Exception -> L191
        MediaLifecycleStateManager r47 = c;     // Catch: Exception -> L191
        r5.L$0 = r39;     // Catch: Exception -> L191
        r5.L$1 = null;     // Catch: Exception -> L158
        r5.label = 6;     // Catch: Exception -> L191
        if (r47.b(r39, "Failed to insert to system album", r5) != r13) goto L153;
        return r13;
    L153:
        r15 = r39;
    L158:
        e = e;
    L159:
        r7 = r16;
    L196:
        r12 = r39;
        goto L197
    L160:
        String r48 = r46.getLastPathSegment();     // Catch: Exception -> L191
        if (r48 == null) goto L165;
        Long r49 = StringsKt.toLongOrNull(r48);     // Catch: Exception -> L191
        if (r49 == null) goto L165;
        final long r50 = r49.longValue();     // Catch: Exception -> L191
    L166:
        FLogger.a.i(r10, "Successfully inserted media: uri = " + r46 + ", file = " + r41.getName() + ", systemGalleryId = " + r50);     // Catch: Exception -> L191
        MediaLifecycleStateManager r51 = c;     // Catch: Exception -> L191
        MediaLifecycleState r52 = MediaLifecycleState.COMPLETED;     // Catch: Exception -> L191
        Function1 r111 = new f(r50, r41);     // Catch: Exception -> L191
        r5.L$0 = r39;     // Catch: Exception -> L191
        r5.L$1 = null;     // Catch: Exception -> L178
        r5.J$0 = r50;     // Catch: Exception -> L178
        r5.label = 7;     // Catch: Exception -> L178
        r7 = r16;
        if (MediaLifecycleStateManager.g(r51, r39, r52, r111, r5, 8) != r13) goto L173;
        return r13;
    L173:
        long r210 = r50;
        r14 = r39;
        r8 = r210;
    L165:
        r50 = 0;
    L142:
        r45 = false;
    L180:
        r7 = r16;
        MediaLifecycleStateManager r53 = c;     // Catch: Exception -> L189
        MediaLifecycleState r54 = MediaLifecycleState.COMPLETED;     // Catch: Exception -> L189
        Function1 r112 = new g(r41);     // Catch: Exception -> L189
        r5.L$0 = r39;     // Catch: Exception -> L189
        r5.L$1 = null;     // Catch: Exception -> L189
        r5.label = 8;     // Catch: Exception -> L189
        if (MediaLifecycleStateManager.g(r53, r39, r54, r112, r5, 8) != r13) goto L184;
        return r13;
    L184:
        r1 = r39;
    L189:
        e = e;
        goto L196
    L132:
        FLogger.a.i(r10, "File already in final directory, skipping copy: " + r41.getAbsolutePath());     // Catch: Exception -> L191
    L191:
        e = e;
        r7 = r16;
        r14 = r39;
    L178:
        e = e;
        goto L159
    L202:
        ContentResolver r55 = b;     // Catch: Exception -> L124
        Uri r56 = com.larus.avlink.gallery.c.f(r55, e(r26, r35), r35.getAbsolutePath(), r26);     // Catch: Exception -> L124
        if (r56 != null) goto L224;
        FLogger.a.e(r10, "Failed to insert media file: " + r35.getName());     // Catch: Exception -> L124
        MediaLifecycleStateManager r57 = c;     // Catch: Exception -> L124
        r5.L$0 = r12;     // Catch: Exception -> L124
        r5.L$1 = null;     // Catch: Exception -> L95
        r5.label = 4;     // Catch: Exception -> L95
        if (r57.b(r12, "Failed to insert to system album", r5) != r13) goto L83;
        return r13;
    L83:
        r24 = r12;
        goto L212
    L224:
        String r58 = r56.getLastPathSegment();     // Catch: Exception -> L122
        if (r58 == null) goto L97;
        Long r59 = StringsKt.toLongOrNull(r58);     // Catch: Exception -> L95
        if (r59 == null) goto L97;
        final long r60 = r59.longValue();     // Catch: Exception -> L95
    L98:
        String r61 = com.larus.avlink.gallery.c.l(r55, r56);     // Catch: Exception -> L122
        if (r61 != null) goto L101;
        FLogger.a.w(r10, "Query public path failed for " + r56 + ", fallback to source path");     // Catch: Exception -> L95
    L101:
        if (r61 != null) goto L105;
        r61 = r35.getAbsolutePath();     // Catch: Exception -> L95
    L105:
        final String r62 = r61;
        MediaLifecycleStateManager r63 = c;     // Catch: Exception -> L122
        MediaLifecycleState r64 = MediaLifecycleState.COMPLETED;     // Catch: Exception -> L122
        Function1 r113 = new e(r60, r62);     // Catch: Exception -> L122
        r5.L$0 = r12;     // Catch: Exception -> L122
        r5.L$1 = r62;     // Catch: Exception -> L122
        r5.J$0 = r60;     // Catch: Exception -> L122
        r5.label = 5;     // Catch: Exception -> L122
        long r114 = r60;
        r23 = r11;
        String r65 = r12;
        if (MediaLifecycleStateManager.g(r63, r12, r64, r113, r5, 8) != r13) goto L111;
        return r13;
    L111:
        r20 = r65;
        r21 = r62;
        r22 = r114;
    L119:
        e = e;
    L120:
        r12 = r65;
    L97:
        r60 = 0;
    L122:
        e = e;
        r23 = r11;
        r65 = r12;
    L95:
        e = e;
    L124:
        e = e;
        r7 = r11;
        r14 = r12;
    L194:
        e = e;
        r7 = r11;
        r39 = r12;
        goto L196
    L38:
        ResultKt.throwOnFailure(r0);
        String r66 = r28.getUniqId();
        FLogger.a.i("MediaSyncExecutor", "Syncing media to album: " + r66);
        MediaLifecycleStateManager r67 = c;
        MediaLifecycleState r115 = MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM;
        r5.L$0 = r28;
        r5.L$1 = r66;
        r5.label = 1;
        if (MediaLifecycleStateManager.g(r67, r66, r115, null, r5, 12) != r13) goto L41;
        return r13;
    L41:
        r26 = r28;
        r12 = r66;
        goto L43
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L32:
        e = e;
        r14 = "Successfully inserted media: uri = ";
    L7:
        r5 = new MediaSyncExecutor$syncToAlbum$1(this, r29);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x01ba -> B:56:0x01c0). Please report as a decompilation issue!!! */
    public static final Object a(MediaSyncExecutor r13, List r14, Continuation r15) {
        r13.getClass();
        if ((r15 instanceof MediaSyncExecutor$checkAllDeletedMedia$1) == false) goto L7;
        MediaSyncExecutor$checkAllDeletedMedia$1 r0 = (MediaSyncExecutor$checkAllDeletedMedia$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L15;
        List r18 = (List) r0.L$2;
        List r19 = (List) r0.L$1;
        List r3 = (List) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L68:
        com.larus.avlink.gallery.business.a.a(r18, r19, "system_album_full_check");
        FLogger.a.i("MediaSyncExecutor", "Full check completed: " + r3.size() + " files, " + r18.size() + " metadata records deleted");
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r110 = (String) r0.L$5;
        MediaMetadata r4 = (MediaMetadata) r0.L$4;
        Iterator r5 = (Iterator) r0.L$3;
        List r6 = (List) r0.L$2;
        List r7 = (List) r0.L$1;
        List r8 = (List) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L56:
        o r111 = (o) r16;
        if (r111.a <= 0) goto L59;
        r8.add(new PolarisFileWrapper(r110));
    L59:
        FLogger.a.i("MediaSyncExecutor", "cleanup deleted media result=" + r111 + ", uniqId=" + r4.getUniqId());
        Object r112 = r17;
        r19 = r6;
        r14 = r8;
    L51:
        if (r5.hasNext() == false) goto L60;
        r4 = (MediaMetadata) r5.next();
        String r9 = r4.getCurrentFilePath();
        r19.add(r9);
        GalleryStoragePolicyManager r10 = GalleryStoragePolicyManager.a;
        r0.L$0 = r14;
        r0.L$1 = r7;
        r0.L$2 = r19;
        r0.L$3 = r5;
        r0.L$4 = r4;
        r0.L$5 = r9;
        r0.label = 2;
        r10.getClass();
        Object r11 = GalleryStoragePolicyManager.h(r4, "system_album_delete", r0);
        if (r11 == r112) goto L87;
        List r12 = r19;
        r17 = r112;
        r16 = r11;
        r8 = r14;
        r110 = r9;
        r6 = r12;
    L87:
        return r112;
    L60:
        List r20 = r7;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
    L62:
        if (r22.hasNext() == false) goto L64;
        r21.add(((MediaMetadata) r22.next()).getUniqId());
        goto L62
    L64:
        AlbumDataBaseHelper r23 = AlbumDataBaseHelper.a;
        r0.L$0 = r14;
        r0.L$1 = r19;
        r0.L$2 = r21;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.L$5 = null;
        r0.label = 3;
        if (r23.e(r21, r0) == r112) goto L87;
        r3 = r14;
        r18 = r21;
        goto L68
    L17:
        r14 = (List) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L21:
        List r113 = (List) r16;
        FLogger.a.i("MediaSyncExecutor", "=== Full Delete Check Started: " + r113.size() + " completed media ===");
        ArrayList r24 = new ArrayList();
        Iterator r114 = r113.iterator();
    L23:
        if (r114.hasNext() == false) goto L33;
        Object r25 = r114.next();
        Long r26 = ((MediaMetadata) r25).getSystemGalleryId();
        if (r26 != null) goto L27;
    L29:
        boolean r27 = false;
    L30:
        if (r27 == false) goto L23;
        r24.add(r25);
        goto L23
    L27:
        if (r26.longValue() <= 0) goto L29;
        r27 = true;
        goto L30
    L33:
        if (r24.isEmpty() == false) goto L35;
        FLogger.a.i("MediaSyncExecutor", "No valid media to check");
        return Unit.INSTANCE;
    L35:
        FLogger.a.d("MediaSyncExecutor", "Checking " + r24.size() + " valid media");
        ArrayList r115 = new ArrayList();
        Iterator r28 = r24.iterator();
    L37:
        if (r28.hasNext() == false) goto L47;
        MediaMetadata r29 = (MediaMetadata) r28.next();
        Long r30 = r29.getSystemGalleryId();
        if (r30 == null) goto L37;
        String r31 = r30.toString();
        if (r31 == null) goto L37;
        if (com.larus.avlink.gallery.c.j(b, r31) == true) goto L37;
        r115.add(r29);
        FLogger.a.d("MediaSyncExecutor", "✗ Media " + r29.getUniqId() + " (systemGalleryId: " + r31 + ") no longer in Doubao album");
        goto L37
    L47:
        if (r115.isEmpty() == false) goto L49;
        FLogger.a.i("MediaSyncExecutor", "All media still exist in album");
        return Unit.INSTANCE;
    L49:
        FLogger.a.i("MediaSyncExecutor", "Found " + r115.size() + " deleted media, removing local files");
        ArrayList r32 = new ArrayList();
        r5 = r115.iterator();
        r7 = r115;
        r112 = r17;
        r19 = r32;
        goto L51
    L18:
        ResultKt.throwOnFailure(r16);
        AlbumDataBaseHelper r116 = AlbumDataBaseHelper.a;
        MediaLifecycleState r33 = MediaLifecycleState.COMPLETED;
        r0.L$0 = r14;
        r0.label = 1;
        r16 = r116.s(r33, r0);
        if (r16 != r17) goto L21;
        return r17;
    L7:
        r0 = new MediaSyncExecutor$checkAllDeletedMedia$1(r13, r15);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x01e4 -> B:66:0x01ea). Please report as a decompilation issue!!! */
    public static final Object b(MediaSyncExecutor r17, List r18, Continuation r19) {
        r17.getClass();
        if ((r19 instanceof MediaSyncExecutor$checkAndDeleteBatch$1) == false) goto L7;
        MediaSyncExecutor$checkAndDeleteBatch$1 r1 = (MediaSyncExecutor$checkAndDeleteBatch$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        List r5 = (List) r1.L$2;
        List r6 = (List) r1.L$1;
        List r7 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L78:
        com.larus.avlink.gallery.business.a.a(r5, r6, "system_album_incremental");
        FLogger.a.i("MediaSyncExecutor", "Batch delete completed: " + r7.size() + " files, " + r5.size() + " metadata records");
        return r7;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r8 = (String) r1.L$5;
        MediaMetadata r9 = (MediaMetadata) r1.L$4;
        Iterator r10 = (Iterator) r1.L$3;
        List r11 = (List) r1.L$2;
        List r12 = (List) r1.L$1;
        List r13 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L66:
        o r14 = (o) r0;
        if (r14.a <= 0) goto L69;
        r12.add(new PolarisFileWrapper(r8));
    L69:
        FLogger.a.i("MediaSyncExecutor", "cleanup deleted media result=" + r14 + ", uniqId=" + r9.getUniqId());
        r6 = r11;
    L61:
        if (r10.hasNext() == false) goto L70;
        r9 = (MediaMetadata) r10.next();
        String r15 = r9.getCurrentFilePath();
        r6.add(r15);
        GalleryStoragePolicyManager r16 = GalleryStoragePolicyManager.a;
        r1.L$0 = r13;
        r1.L$1 = r12;
        r1.L$2 = r6;
        r1.L$3 = r10;
        r1.L$4 = r9;
        r1.L$5 = r15;
        r1.label = 2;
        r16.getClass();
        Object r20 = GalleryStoragePolicyManager.h(r9, "system_album_delete", r1);
        if (r20 == r3) goto L100;
        List r110 = r6;
        r8 = r15;
        r0 = r20;
        r11 = r110;
        goto L66
    L100:
        return r3;
    L70:
        List r111 = r13;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r22 = r111.iterator();
    L72:
        if (r22.hasNext() == false) goto L74;
        r21.add(((MediaMetadata) r22.next()).getUniqId());
        goto L72
    L74:
        AlbumDataBaseHelper r23 = AlbumDataBaseHelper.a;
        r1.L$0 = r12;
        r1.L$1 = r6;
        r1.L$2 = r21;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.label = 3;
        if (r23.e(r21, r1) == r3) goto L101;
        r5 = r21;
        r7 = r12;
        goto L78
    L101:
        return r3;
    L17:
        ResultKt.throwOnFailure(r0);
    L43:
        List r24 = (List) r0;
        FLogger.a.d("MediaSyncExecutor", "Found " + r24.size() + " metadata records");
        if (r24.isEmpty() == true) goto L97;
        ArrayList r25 = new ArrayList();
        Iterator r26 = r24.iterator();
    L48:
        if (r26.hasNext() == false) goto L57;
        MediaMetadata r27 = (MediaMetadata) r26.next();
        Long r112 = r27.getSystemGalleryId();
        if (r112 == null) goto L48;
        if (r112.longValue() <= 0) goto L48;
        if (com.larus.avlink.gallery.c.j(b, r112.toString()) == true) goto L48;
        r25.add(r27);
        FLogger.a.d("MediaSyncExecutor", "✗ Media " + r27.getUniqId() + " no longer in Doubao album (deleted or moved out)");
        goto L48
    L57:
        if (r25.isEmpty() == false) goto L59;
        FLogger.a.d("MediaSyncExecutor", "All media still exist in album");
        return CollectionsKt.emptyList();
    L59:
        FLogger.a.i("MediaSyncExecutor", "Deleting " + r25.size() + " media files and metadata");
        ArrayList r28 = new ArrayList();
        ArrayList r29 = new ArrayList();
        r10 = r25.iterator();
        r12 = r28;
        r13 = r25;
        r6 = r29;
        goto L61
    L97:
        return CollectionsKt.emptyList();
    L18:
        ResultKt.throwOnFailure(r0);
        if (r18.isEmpty() == true) goto L95;
        ArrayList r30 = new ArrayList();
        Iterator r31 = r18.iterator();
    L23:
        if (r31.hasNext() == false) goto L38;
        String r113 = ((Uri) r31.next()).getLastPathSegment();
        if (r113 == null) goto L34;
        Long r114 = StringsKt.toLongOrNull(r113);
        if (r114 == null) goto L34;
        if (r114.longValue() <= 0) goto L31;
        boolean r115 = true;
    L32:
        if (r115 == false) goto L34;
    L35:
        if (r114 == null) goto L23;
        r30.add(r114);
        goto L23
    L31:
        r115 = false;
    L34:
        r114 = null;
        goto L35
    L38:
        if (r30.isEmpty() == false) goto L40;
        FLogger.a.w("MediaSyncExecutor", "No valid systemGalleryIds found in URIs");
        return CollectionsKt.emptyList();
    L40:
        FLogger.a.d("MediaSyncExecutor", "Batch checking " + r30.size() + " gallery IDs");
        AlbumDataBaseHelper r32 = AlbumDataBaseHelper.a;
        r1.label = 1;
        r0 = r32.v(r30, r1);
        if (r0 != r3) goto L43;
        return r3;
    L95:
        return CollectionsKt.emptyList();
    L7:
        r1 = new MediaSyncExecutor$checkAndDeleteBatch$1(r17, r19);
        goto L8
    }
}
