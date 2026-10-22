package com.larus.avlink.gallery.inject;

import android.media.MediaMetadataRetriever;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.api.DatasetVideoRatio;
import com.larus.avlink.api.DatasetVideoResolution;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.executor.MediaProcessingExecutor;
import com.larus.avlink.gallery.j;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.processor.e;
import com.larus.dora.api.model.MediaInfo;
import com.larus.utils.logger.FLogger;
import f06.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DatasetInjectionRunner {
    public static final DatasetInjectionRunner a = null;
    public static final CoroutineScope b = null;
    public static final MediaLifecycleStateManager c = null;
    public static final e d = null;

    public static final class a {
        public final long a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            return r1 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "MediaIdentity(mediaId=" + this.a + ", createTime=" + this.b + ')';
        }

        public a(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public static final class b {
        public final long a;
        public final long b;
        public final int c;
        public final int d;
        public final long e;
        public final String f;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31) + this.d) * 31;
            long r4 = this.e;
            return ((r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.f.hashCode();
        }

        public final String toString() {
            return "VideoModel(mediaId=" + this.a + ", createTime=" + this.b + ", width=" + this.c + ", height=" + this.d + ", durationMs=" + this.e + ", source=" + this.f + ')';
        }

        public b(long r2, long r4, int r6, int r7, long r8, String r10) {
            Intrinsics.checkNotNullParameter(r10, "source");
            this.a = r2;
            this.b = r4;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r10;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaLifecycleState.values().length];
            r0[MediaLifecycleState.COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MediaLifecycleState.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public DatasetInjectionRunner() {
    }

    static {
        a = new DatasetInjectionRunner();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = MediaLifecycleStateManager.b.a();
        d = new e();
    }

    public static a f(String r9) {
        List r0 = StringsKt.split$default(StringsKt.substringBeforeLast$default(r9, '.', null, 2, null), new char[]{'_'}, false, 0, 6, null);
        if (r0.size() >= 3) goto L5;
        return null;
    L5:
        Long r10 = StringsKt.toLongOrNull((String) ListProtector.get(r0, 1));
        if (r10 == null) goto L16;
        long r3 = r10.longValue();
        Long r11 = StringsKt.toLongOrNull((String) ListProtector.get(r0, 2));
        if (r11 == null) goto L16;
        long r5 = r11.longValue();
        if (r3 <= 0) goto L16;
        if (r5 <= 0) goto L16;
        return new a(r3, r5);
    L16:
        return null;
    }

    public static String d(MediaMetadataRetriever r18, int r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r18, r1, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.extractMetadata(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static final Object b(DatasetInjectionRunner r50, PolarisFileWrapper r51, Continuation r52) {
        DatasetInjectionRunner r0 = r50;
        r50.getClass();
        String r2 = "enqueue pack ok, uniqId=";
        String r3 = "processArchive returned null, path=";
        if ((r52 instanceof DatasetInjectionRunner$enqueuePack$1) == false) goto L7;
        DatasetInjectionRunner$enqueuePack$1 r4 = (DatasetInjectionRunner$enqueuePack$1) r52;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r1 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L31;
        if (r7 == 1) goto L25;
        if (r7 == 2) goto L20;
        if (r7 != 3) goto L19;
        String r8 = (String) r4.L$1;
        PolarisFileWrapper r9 = (File) r4.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L16
        r2 = "enqueue pack ok, uniqId=";
        PolarisFileWrapper r10 = r9;
        String r11 = "DatasetInjectionRunner";
        Object r12 = null;
    L89:
        FLogger.a.i(r11, r2 + r8 + ", path=" + r10.getAbsolutePath());     // Catch: Throwable -> L95
        PolarisFileWrapper r13 = r10;
    L129:
        Object r14 = Result.constructor-impl(r8);     // Catch: Throwable -> L93
    L110:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L144;
        FLogger.a.e(r11, "enqueue pack failed, path=" + r13.getAbsolutePath(), r15);
        return r12;
    L144:
        return r14;
    L93:
        th = th;
    L108:
        r10 = r13;
    L109:
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        r13 = r10;
    L95:
        th = th;
    L16:
        th = th;
        r13 = r9;
    L30:
        r11 = "DatasetInjectionRunner";
    L78:
        r12 = null;
        goto L108
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r13 = (File) r4.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L23
        r3 = "processArchive returned null, path=";
        String r48 = "DatasetInjectionRunner";
    L121:
        r11 = r48;
        FLogger.a.w(r11, r3 + r13.getAbsolutePath());     // Catch: Throwable -> L74
        r8 = null;
        r12 = null;
    L74:
        th = th;
    L76:
        th = th;
        r11 = r48;
    L23:
        th = th;
        goto L30
    L25:
        boolean r17 = r4.Z$0;
        long r18 = r4.J$1;
        long r19 = r4.J$0;
        DatasetInjectionRunner r20 = (DatasetInjectionRunner) r4.L$3;
        String r21 = (String) r4.L$2;
        String r22 = (String) r4.L$1;
        PolarisFileWrapper r110 = (File) r4.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L28
        String r111 = r21;
        String r23 = r22;
        r10 = r110;
        r48 = "DatasetInjectionRunner";
        boolean r24 = r17;
        r0 = r20;
    L56:
        e r25 = d;     // Catch: Throwable -> L99
        String r26 = r10.getAbsolutePath();     // Catch: Throwable -> L99
        String r27 = r10.getName();     // Catch: Throwable -> L99
        MediaInfo r112 = new MediaInfo(Boxing.boxLong(r19), r111, null, null, null, null, 0, 0, 0.0d, Boxing.boxLong(r10.length()), null, null, Boxing.boxLong(r18), r10.getName(), null, null, null, 118268, null);     // Catch: Throwable -> L99
        if (r24 == false) goto L59;
        boolean r28 = true;
    L60:
        r25.getClass();     // Catch: Throwable -> L99
        e.c r29 = e.f(r26, r27, r23, r112, r28);     // Catch: Throwable -> L99
        if (r29 != null) goto L82;
        MediaLifecycleStateManager r30 = c;     // Catch: Throwable -> L99
        r4.L$0 = r10;     // Catch: Throwable -> L99
        r4.L$1 = null;     // Catch: Throwable -> L79
        r4.L$2 = null;     // Catch: Throwable -> L79
        r4.L$3 = null;     // Catch: Throwable -> L79
        r4.label = 2;     // Catch: Throwable -> L99
        if (r30.b(r23, "No displayable file found in archive", r4) == r6) goto L143;
        r13 = r10;
        goto L121
    L143:
        return r6;
    L99:
        th = th;
    L100:
        r11 = r48;
    L81:
        r12 = null;
        r13 = r10;
    L79:
        th = th;
        goto L100
    L82:
        r11 = r48;
        r4.L$0 = r10;     // Catch: Throwable -> L97
        r4.L$1 = r23;     // Catch: Throwable -> L97
        r12 = null;
        r4.L$2 = null;     // Catch: Throwable -> L95
        r4.L$3 = null;     // Catch: Throwable -> L95
        r4.label = 3;     // Catch: Throwable -> L95
        if (r0.e(r23, r29, r4) == r6) goto L142;
        r8 = r23;
        goto L89
    L142:
        return r6;
    L97:
        th = th;
        goto L81
    L59:
        r28 = false;
    L28:
        th = th;
        r13 = r110;
        goto L30
    L31:
        ResultKt.throwOnFailure(r1);
        long r31 = System.currentTimeMillis();
        a r32 = f(r51.getName());
        if (r32 == null) goto L34;
        r19 = r32.a;
    L35:
        if (r32 == null) goto L37;
        r31 = r32.b;
    L37:
        r18 = r31;
        StringBuilder r33 = new StringBuilder();
        r33.append(r19);
        r33.append('_');
        r33.append(r18);
        r23 = r33.toString();
        if (StringsKt.endsWith(r51.getName(), ".zip", true) == false) goto L40;
        String r34 = "live_photo";
    L41:
        r24 = Intrinsics.areEqual(j.d(r34), "live_photo");
        if (r24 == false) goto L115;
        r34 = "image_pack";
    L115:
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L105
        String r210 = r51.getName();     // Catch: Throwable -> L105
        long r36 = r51.length();     // Catch: Throwable -> L105
        r48 = "DatasetInjectionRunner";
        String r37 = StringsKt.substringBefore$default(r51.getName(), "_", null, 2, null);     // Catch: Throwable -> L103
    L101:
        th = th;
        r10 = r51;
        goto L100
    L48:
        if (StringsKt.isBlank(r37) == false) goto L50;
        r37 = "media";
    L50:
        MediaLifecycleState r38 = MediaLifecycleState.DOWNLOAD;     // Catch: Throwable -> L101
        String r39 = r51.getAbsolutePath();     // Catch: Throwable -> L101
        long r113 = r19;
        MediaMetadata r40 = new MediaMetadata(r23, r113, null, r210, Boxing.boxLong(r36), r34, 0, 0, 0, 0, 0, 0.0d, r18, null, r37, r38, null, null, r39, null, null, null, null, 0, 16461764, null);     // Catch: Throwable -> L101
        AlbumDataBaseHelper r41 = AlbumDataBaseHelper.a;     // Catch: Throwable -> L101
        r10 = r51;
        r4.L$0 = r10;     // Catch: Throwable -> L99
        r4.L$1 = r23;     // Catch: Throwable -> L99
        r4.L$2 = r34;     // Catch: Throwable -> L99
        r4.L$3 = r0;     // Catch: Throwable -> L99
        r4.J$0 = r19;     // Catch: Throwable -> L99
        r4.J$1 = r18;     // Catch: Throwable -> L99
        r4.Z$0 = r24;     // Catch: Throwable -> L99
        r4.label = 1;     // Catch: Throwable -> L99
        if (r41.h(r40, r4) == r6) goto L141;
        r111 = r34;
        goto L56
    L141:
        return r6;
    L103:
        th = th;
        r10 = r51;
        r12 = null;
        r11 = r48;
    L105:
        th = th;
        r10 = r51;
        r11 = "DatasetInjectionRunner";
        goto L81
    L40:
        r34 = "image_pack";
        goto L41
    L34:
        r19 = r31;
    L7:
        r4 = new DatasetInjectionRunner$enqueuePack$1(r0, r52);
        goto L8
    }

    public static final Object c(DatasetInjectionRunner r20, PolarisFileWrapper r21, Continuation r22) {
        r20.getClass();
        if ((r22 instanceof DatasetInjectionRunner$enqueueVideoMp4$1) == false) goto L7;
        DatasetInjectionRunner$enqueueVideoMp4$1 r3 = (DatasetInjectionRunner$enqueueVideoMp4$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        DatasetInjectionRunner$enqueueVideoMp4$1 r8 = r3;
        Object r0 = r8.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r8.label;
        boolean r7 = true;
        if (r6 == 0) goto L61;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        int r1 = r8.I$3;
        int r9 = r8.I$2;
        int r10 = r8.I$1;
        int r11 = r8.I$0;
        DatasetInjectionRunner r12 = (DatasetInjectionRunner) r8.L$6;
        String r13 = (String) r8.L$5;
        Pair r14 = (Pair) r8.L$4;
        b r15 = (b) r8.L$3;
        DatasetVideoRatio r16 = (DatasetVideoRatio) r8.L$2;
        DatasetVideoResolution r17 = (DatasetVideoResolution) r8.L$1;
        File r18 = (File) r8.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L15
        String r19 = "DatasetInjectionRunner";
    L186:
        r12.getClass();     // Catch: Throwable -> L43
        MediaProcessingExecutor r2 = MediaSyncCoordinator.d();     // Catch: Throwable -> L43
        int r23 = MediaProcessingExecutor.k;     // Catch: Throwable -> L43
        r2.a(r13, false);     // Catch: Throwable -> L43
        FLogger r24 = FLogger.a;     // Catch: Throwable -> L43
        StringBuilder r25 = new StringBuilder("enqueue mp4 ok, uniqId=");     // Catch: Throwable -> L43
        r25.append(r13);     // Catch: Throwable -> L43
        r25.append(", output=");     // Catch: Throwable -> L43
        r25.append(r9);     // Catch: Throwable -> L43
        r25.append('x');     // Catch: Throwable -> L43
        r25.append(r1);     // Catch: Throwable -> L43
        r25.append(" (setting=");     // Catch: Throwable -> L43
        r25.append(r17.getDisplayName());     // Catch: Throwable -> L43
        r25.append('/');     // Catch: Throwable -> L43
        r25.append(r16.getDisplayName());     // Catch: Throwable -> L43
        r25.append(", mapped=");     // Catch: Throwable -> L43
        r25.append(r11);     // Catch: Throwable -> L43
        r25.append('x');     // Catch: Throwable -> L43
        r25.append(r10);     // Catch: Throwable -> L43
        r25.append("), encoded=");     // Catch: Throwable -> L43
        if (r14 == null) goto L32;
        Integer r26 = (Integer) r14.getFirst();     // Catch: Throwable -> L43
    L33:
        r25.append(r26);     // Catch: Throwable -> L43
        r25.append('x');     // Catch: Throwable -> L43
        if (r14 == null) goto L36;
        Integer r27 = (Integer) r14.getSecond();     // Catch: Throwable -> L43
    L37:
        r25.append(r27);     // Catch: Throwable -> L43
        r25.append(", ");     // Catch: Throwable -> L43
        r25.append(r15.e);     // Catch: Throwable -> L43
        r25.append("ms, source=");     // Catch: Throwable -> L43
        r25.append(r15.f);     // Catch: Throwable -> L43
        r25.append(", path=");     // Catch: Throwable -> L43
        r25.append(r18.getAbsolutePath());     // Catch: Throwable -> L43
        String r28 = r19;
        r24.i(r28, r25.toString());     // Catch: Throwable -> L41
        Object r29 = Result.constructor-impl(r13);     // Catch: Throwable -> L41
    L56:
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L211;
        FLogger.a.e(r28, "enqueue mp4 failed, path=" + r18.getAbsolutePath(), r30);
        return null;
    L211:
        return r29;
    L41:
        th = th;
    L54:
        File r31 = r18;
    L55:
        Result.Companion r32 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        r18 = r31;
        goto L56
    L36:
        r27 = null;
        goto L37
    L32:
        r26 = null;
    L43:
        th = th;
        r28 = r19;
    L15:
        th = th;
        r28 = "DatasetInjectionRunner";
        goto L54
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        int r33 = r8.I$3;
        int r110 = r8.I$2;
        int r111 = r8.I$1;
        int r112 = r8.I$0;
        DatasetInjectionRunner r34 = (DatasetInjectionRunner) r8.L$6;
        String r35 = (String) r8.L$5;
        Pair r36 = (Pair) r8.L$4;
        b r37 = (b) r8.L$3;
        DatasetVideoRatio r113 = (DatasetVideoRatio) r8.L$2;
        DatasetVideoResolution r114 = (DatasetVideoResolution) r8.L$1;
        final File r38 = (File) r8.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L52
        MediaLifecycleStateManager r39 = c;     // Catch: Throwable -> L49
        MediaLifecycleState r115 = MediaLifecycleState.DOWNLOADED_TEMP;     // Catch: Throwable -> L49
        r19 = "DatasetInjectionRunner";
        Function1 r116 = new com.larus.avlink.gallery.inject.a(r38);     // Catch: Throwable -> L47
        r8.L$0 = r38;     // Catch: Throwable -> L47
        r8.L$1 = r114;     // Catch: Throwable -> L47
        r8.L$2 = r113;     // Catch: Throwable -> L47
        r8.L$3 = r37;     // Catch: Throwable -> L47
        r8.L$4 = r36;     // Catch: Throwable -> L47
        r8.L$5 = r35;     // Catch: Throwable -> L47
        r8.L$6 = r34;     // Catch: Throwable -> L47
        r8.I$0 = r112;     // Catch: Throwable -> L47
        r8.I$1 = r111;     // Catch: Throwable -> L47
        r8.I$2 = r110;     // Catch: Throwable -> L47
        r8.I$3 = r33;     // Catch: Throwable -> L47
        r8.label = 2;     // Catch: Throwable -> L47
        File r117 = r38;
        if (MediaLifecycleStateManager.g(r39, r35, r115, r116, r8, 8) == r5) goto L210;
        r14 = r36;
        r12 = r34;
        r9 = r110;
        r10 = r111;
        r11 = r112;
        r18 = r117;
        r13 = r35;
        r15 = r37;
        r17 = r114;
        r16 = r113;
        r1 = r33;
        goto L186
    L210:
        return r5;
    L45:
        th = th;
    L46:
        r28 = r19;
    L51:
        r31 = r117;
    L47:
        th = th;
        r117 = r38;
    L49:
        th = th;
        r117 = r38;
        r28 = "DatasetInjectionRunner";
    L52:
        th = th;
        r28 = "DatasetInjectionRunner";
        r18 = r38;
        goto L54
    L61:
        ResultKt.throwOnFailure(r0);
        String r40 = r21.getName();
        List r41 = StringsKt.split$default(StringsKt.substringBeforeLast$default(r40, '.', null, 2, null), new char[]{'_'}, false, 0, 6, null);
        if (r41.size() < 8) goto L78;
        a r42 = f(r40);
        if (r42 == null) goto L78;
        Long r43 = StringsKt.toLongOrNull((String) ListProtector.get(r41, 4));
        if (r43 == null) goto L78;
        long r118 = r43.longValue();
        Integer r44 = StringsKt.toIntOrNull((String) ListProtector.get(r41, 5));
        if (r44 == null) goto L78;
        int r119 = r44.intValue();
        Integer r45 = StringsKt.toIntOrNull((String) ListProtector.get(r41, 6));
        if (r45 == null) goto L78;
        int r120 = r45.intValue();
        if (r120 <= 0) goto L78;
        if (r119 <= 0) goto L78;
        b r46 = new b(r42.a, r42.b, r120, r119, r118, "name");
    L80:
        if (r46 != null) goto L147;
        System.currentTimeMillis();
        MediaMetadataRetriever r47 = new MediaMetadataRetriever();
        r47.setDataSource(r21.getAbsolutePath());     // Catch: Throwable -> L133
        String r48 = d(r47, 18);     // Catch: Throwable -> L133
        if (r48 == null) goto L87;
        Integer r49 = StringsKt.toIntOrNull(r48);     // Catch: Throwable -> L133
        if (r49 == null) goto L87;
        int r50 = r49.intValue();     // Catch: Throwable -> L133
    L88:
        String r121 = d(r47, 19);     // Catch: Throwable -> L133
        if (r121 == null) goto L93;
        Integer r122 = StringsKt.toIntOrNull(r121);     // Catch: Throwable -> L133
        if (r122 == null) goto L93;
        int r123 = r122.intValue();     // Catch: Throwable -> L133
    L94:
        String r124 = d(r47, 24);     // Catch: Throwable -> L133
        if (r124 == null) goto L99;
        Integer r125 = StringsKt.toIntOrNull(r124);     // Catch: Throwable -> L133
        if (r125 == null) goto L99;
        int r126 = r125.intValue();     // Catch: Throwable -> L133
    L100:
        String r127 = d(r47, 9);     // Catch: Throwable -> L133
        if (r127 == null) goto L106;
        Long r128 = StringsKt.toLongOrNull(r127);     // Catch: Throwable -> L133
        if (r128 == null) goto L106;
        r128.longValue();     // Catch: Throwable -> L133
    L106:
        if (r126 != 90) goto L108;
    L110:
        Pair r51 = TuplesKt.to(Integer.valueOf(r123), Integer.valueOf(r50));     // Catch: Throwable -> L133
    L111:
        int r129 = ((Number) r51.component1()).intValue();     // Catch: Throwable -> L133
        int r52 = ((Number) r51.component2()).intValue();     // Catch: Throwable -> L133
        Integer r130 = Integer.valueOf(r129);     // Catch: Throwable -> L133
        if (r130.intValue() <= 0) goto L114;
        boolean r131 = true;
    L115:
        if (r131 == true) goto L118;
        r130 = null;
    L118:
        if (r130 == null) goto L120;
        r130.intValue();     // Catch: Throwable -> L133
    L120:
        Integer r53 = Integer.valueOf(r52);     // Catch: Throwable -> L133
        if (r53.intValue() > 0) goto L124;
        r7 = false;
    L124:
        if (r7 == true) goto L127;
        r53 = null;
    L127:
        if (r53 == null) goto L129;
        r53.intValue();     // Catch: Throwable -> L133
    L129:
        Intrinsics.checkNotNullParameter("probe", "source");     // Catch: Throwable -> L133
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L138
    L131:
        r47.release();     // Catch: Throwable -> L138
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L138
        goto L147
    L114:
        r131 = false;
        goto L115
    L108:
        if (r126 == 270) goto L110;
        r51 = TuplesKt.to(Integer.valueOf(r50), Integer.valueOf(r123));     // Catch: Throwable -> L133
    L99:
        r126 = 0;
    L93:
        r123 = 0;
    L87:
        r50 = 0;
    L133:
        th = move-exception;
        FLogger.a.w("DatasetInjectionRunner", "probeVideoModel failed, fallback to defaults, path=" + r21.getAbsolutePath() + ": " + th.getMessage());     // Catch: Throwable -> L140
        Intrinsics.checkNotNullParameter("default", "source");     // Catch: Throwable -> L140
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L138
    L140:
        th = move-exception;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L144
        r47.release();     // Catch: Throwable -> L144
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L144
        throw th;
    L144:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        throw th;
    L138:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L147:
        MediaMetadataRetriever r59 = new MediaMetadataRetriever();
        r59.setDataSource(r21.getAbsolutePath());     // Catch: Throwable -> L168
        String r60 = d(r59, 18);     // Catch: Throwable -> L168
        if (r60 == null) goto L153;
        Integer r61 = StringsKt.toIntOrNull(r60);     // Catch: Throwable -> L168
        if (r61 == null) goto L153;
        int r62 = r61.intValue();     // Catch: Throwable -> L168
    L154:
        String r63 = d(r59, 19);     // Catch: Throwable -> L168
        if (r63 == null) goto L159;
        Integer r64 = StringsKt.toIntOrNull(r63);     // Catch: Throwable -> L168
        if (r64 == null) goto L159;
        int r132 = r64.intValue();     // Catch: Throwable -> L168
    L160:
        if (r62 <= 0) goto L163;
        if (r132 <= 0) goto L163;
        TuplesKt.to(Integer.valueOf(r62), Integer.valueOf(r132));     // Catch: Throwable -> L168
    L163:
        Result.Companion r65 = Result.Companion;     // Catch: Throwable -> L166
        r59.release();     // Catch: Throwable -> L166
        Unit r66 = Unit.INSTANCE;     // Catch: Throwable -> L166
    L164:
        Result.constructor-impl(r66);     // Catch: Throwable -> L166
    L173:
        Intrinsics.checkNotNullParameter(null, "resolution");
        Intrinsics.checkNotNullParameter(null, "ratio");
        int r67 = w88.c.a;
        throw null;
    L159:
        r132 = 0;
    L153:
        r62 = 0;
    L166:
        th = move-exception;
        Result.Companion r68 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L168:
        th = move-exception;
        FLogger.a.w("DatasetInjectionRunner", "probeEncodedSize failed, path=" + r21.getAbsolutePath() + ": " + th.getMessage());     // Catch: Throwable -> L175
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L166
        r59.release();     // Catch: Throwable -> L166
        r66 = Unit.INSTANCE;     // Catch: Throwable -> L166
    L175:
        th = move-exception;
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L179
        r59.release();     // Catch: Throwable -> L179
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L179
        throw th;
    L179:
        th = move-exception;
        Result.Companion r71 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        throw th;
    L78:
        r46 = null;
    L7:
        r3 = new DatasetInjectionRunner$enqueueVideoMp4$1(r20, r22);
        goto L8
    }

    public final Object e(String r8, final e.c r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof DatasetInjectionRunner$completeArchive$1) == false) goto L7;
        DatasetInjectionRunner$completeArchive$1 r0 = (DatasetInjectionRunner$completeArchive$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DatasetInjectionRunner$completeArchive$1 r5 = r0;
        Object r11 = r5.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r5.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (String) r5.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        MediaProcessingExecutor r12 = MediaSyncCoordinator.d();
        int r13 = MediaProcessingExecutor.k;
        r12.a(r8, false);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (StringsKt.endsWith(StringsKt.substringAfterLast$default(r9.a, '/', null, 2, null), ".mp4", true) == false) goto L17;
        final String r14 = "video_pack";
    L18:
        MediaLifecycleStateManager r4 = c;
        MediaLifecycleState r6 = MediaLifecycleState.DOWNLOADED_TEMP;
        Function1 r7 = new com.larus.avlink.gallery.inject.b(r9, r14);
        r5.L$0 = r8;
        r5.label = 1;
        if (MediaLifecycleStateManager.g(r4, r8, r6, r7, r5, 8) != r2) goto L21;
        return r2;
    L17:
        r14 = "image_pack";
    L7:
        r0 = new DatasetInjectionRunner$completeArchive$1(this, r10);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0174 -> B:20:0x00a8). Please report as a decompilation issue!!! */
    public static final Object a(DatasetInjectionRunner r18, List r19, Function1 r20, Continuation r21) {
        r18.getClass();
        if ((r21 instanceof DatasetInjectionRunner$awaitAllProcessed$1) == false) goto L7;
        DatasetInjectionRunner$awaitAllProcessed$1 r1 = (DatasetInjectionRunner$awaitAllProcessed$1) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        String r8 = "DatasetInjectionRunner";
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        Ref.LongRef r5 = (Ref.LongRef) r1.L$3;
        HashSet r9 = (HashSet) r1.L$2;
        Function1 r10 = (Function1) r1.L$1;
        List r11 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
        List r6 = r11;
        DatasetInjectionRunner$awaitAllProcessed$1 r7 = r1;
        Function1 r12 = r10;
        String r13 = "DatasetInjectionRunner";
        Object r14 = r3;
        HashSet r15 = r9;
        Ref.LongRef r16 = r5;
    L21:
        if (r15.size() >= r6.size()) goto L53;
        Iterator r17 = r6.iterator();
        List r110 = r6;
        Function1 r111 = r12;
        HashSet r22 = r15;
        r1 = r7;
        r3 = r14;
        Ref.LongRef r23 = r16;
        r8 = r13;
        Iterator r24 = r17;
    L24:
        if (r24.hasNext() == false) goto L44;
        String r112 = (String) r24.next();
        if (r22.contains(r112) == true) goto L24;
        AlbumDataBaseHelper r113 = AlbumDataBaseHelper.a;
        r1.L$0 = r110;
        r1.L$1 = r111;
        r1.L$2 = r22;
        r1.L$3 = r23;
        r1.L$4 = r24;
        r1.L$5 = r112;
        r1.label = 1;
        Object r114 = r113.o(r112, r1);
        if (r114 == r3) goto L61;
        HashSet r115 = r22;
        r0 = r114;
        Ref.LongRef r116 = r23;
        String r25 = r112;
    L31:
        MediaMetadata r26 = (MediaMetadata) r0;
        if (r26 == null) goto L34;
        MediaLifecycleState r27 = r26.getLifecycleState();
    L35:
        if (r27 != null) goto L37;
        int r28 = -1;
    L38:
        if (r28 == 1) goto L41;
        if (r28 == 2) goto L41;
        r23 = r116;
        r22 = r115;
    L41:
        r115.add(r25);
        r116.element = System.currentTimeMillis();
        r23 = r116;
        r22 = r115;
        goto L24
    L37:
        r28 = c.a[r27.ordinal()];
        goto L38
    L34:
        r27 = null;
    L61:
        return r3;
    L44:
        if (r22.size() < r110.size()) goto L46;
    L52:
        r15 = r22;
        r13 = r8;
        r12 = r111;
        r6 = r110;
        goto L53
    L46:
        if ((System.currentTimeMillis() - r23.element) <= 300000) goto L48;
        FLogger.a.w(r8, "awaitAllProcessed stalled: " + r22.size() + '/' + r110.size() + " done, no progress for 300000ms, giving up");
        goto L52
    L48:
        r1.L$0 = r110;
        r1.L$1 = r111;
        r1.L$2 = r22;
        r1.L$3 = r23;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.label = 2;
        if (DelayKt.delay(500, r1) == r3) goto L61;
        r16 = r23;
        r13 = r8;
        r7 = r1;
        r14 = r3;
        r12 = r111;
        r15 = r22;
        r6 = r110;
    L53:
        long r29 = System.currentTimeMillis();
        FLogger.a.i(r13, "awaitAllProcessed done, terminal=" + r15.size() + '/' + r6.size() + ", endTime=" + r29);
        r12.invoke(Boxing.boxLong(r29));
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r25 = (String) r1.L$5;
        r24 = (Iterator) r1.L$4;
        r116 = (Ref.LongRef) r1.L$3;
        r115 = (HashSet) r1.L$2;
        r111 = (Function1) r1.L$1;
        r110 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
        goto L31
    L16:
        ResultKt.throwOnFailure(r0);
        if (r19.isEmpty() == false) goto L19;
        FLogger.a.i("DatasetInjectionRunner", "awaitAllProcessed skipped, nothing enqueued");
        return Unit.INSTANCE;
    L19:
        HashSet r30 = new HashSet(r19.size());
        Ref.LongRef r31 = new Ref.LongRef();
        r31.element = System.currentTimeMillis();
        r16 = r31;
        r13 = "DatasetInjectionRunner";
        r7 = r1;
        r14 = r3;
        r12 = r20;
        r15 = r30;
        r6 = r19;
    L7:
        r1 = new DatasetInjectionRunner$awaitAllProcessed$1(r18, r21);
        goto L8
    }
}
