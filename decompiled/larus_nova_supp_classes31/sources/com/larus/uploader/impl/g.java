package com.larus.uploader.impl;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.bmhome.upload.ResourceUploadTokenProvider;
import com.larus.bmhome.upload.h;
import com.larus.bmhome.upload.l;
import com.larus.bmhome.upload.sdk.ResourceUploadEngine;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.b4;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.service.o3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.ss.bduploader.BDVideoInfo;
import com.ss.bduploader.BDVideoUploader;
import com.ss.bduploader.BDVideoUploaderListener;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mr9.j;
import mr9.k;
import mr9.m;
import mr9.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g implements b4 {
    public static final com.larus.platform.model.chat.e i = null;
    public j a;
    public final String b;
    public BDVideoUploader c;
    public b4.a d;
    public boolean e;
    public final long[] f;
    public final long[] g;
    public long h;

    public static final class a {
    }

    public final class b implements BDVideoUploaderListener {
        public final j a;
        public final /* synthetic */ g b;

        public final String getStringFromExtern(int r1) {
            return null;
        }

        public final int videoUploadCheckNetState(int r1, int r2) {
            return 1;
        }

        public b(g r2, j r3) {
            Intrinsics.checkNotNullParameter(r3, "param");
            this.b = r2;
            this.a = r3;
        }

        public final void onUploadVideoStage(int r5, long r6) {
            FLogger.a.i(this.b.b, "[onUploadVideoStage] what:" + r5 + ", p1:" + r6);
        }

        public final void onLog(int r5, int r6, String r7) {
            FLogger.a.d(this.b.b, "[onLog] what:" + r5 + ", code:" + r6 + ", info:" + r7);
        }

        public final void onNotify(int r31, long r32, BDVideoInfo r34) {
            FLogger r5 = FLogger.a;
            r5.i(this.b.b, "[onNotify] what: " + r31 + ", parameter: " + r32);
            if (r32 == 0) goto L10;
            long r6 = (long) ((r32 * 0.7f) + 30.000002f);
            g r9 = this.b;
            if (r6 == r9.h) goto L10;
            r5.i(r9.b, "[onNotify] upload progress: " + r32 + ", mapped: " + r6);
            g r2 = this.b;
            r2.h = r6;
            b4.a r3 = r2.d;
            if (r3 == null) goto L10;
            r3.b(new k(Long.valueOf(r6), false));
        L10:
            if (r31 != 0) goto L12;
            if (r34 == null) goto L93;
            this.b.g[1] = System.currentTimeMillis();
            g r0 = this.b;
            long[] r7 = r0.g;
            long r10 = r7[1] - r7[0];
            r5.i(r0.b, "[handleUploadSuccess] cost:" + r10 + "ms, uri:" + r34.mTosKey);
            m r1 = this.a.h;
            if (r1 == null) goto L46;
            String r4 = r1.b();
        L48:
            if (r4 != null) goto L50;
            String r8 = "";
        L51:
            b4.a r11 = this.b.d;
            if (r11 == null) goto L91;
            String r12 = "vod://" + r8 + '/' + r34.mVideoId;
            String r13 = r34.mVideoId;
            if (r13 != null) goto L56;
            String r14 = "";
        L57:
            Ref.ObjectRef r15 = new Ref.ObjectRef();
            h r16 = h.a;
            String r17 = this.a.l;
            if (r17 != null) goto L60;
            r17 = "";
        L60:
            r15.element = r16.query(r17);
            g r18 = this.b;
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L77
            JSONObject r110 = new JSONObject(r34.mVideoMediaInfo);     // Catch: Throwable -> L77
            r5.d(r18.b, "[onNotify] metaObj:" + r110);     // Catch: Throwable -> L77
            mr9.e r111 = (mr9.e) r15.element;     // Catch: Throwable -> L77
            if (r111 == null) goto L79;
            int r20 = JSONObjectProtectorUtils.getInt(r110, "Bitrate");     // Catch: Throwable -> L77
            int r21 = p0.a;     // Catch: Throwable -> L77
            String r22 = p0.a(l.a(JSONObjectProtectorUtils.getString(r110, "Codec")));     // Catch: Throwable -> L77
            if (r22 != null) goto L69;
            mr9.e r23 = (mr9.e) r15.element;     // Catch: Throwable -> L77
            if (r23 == null) goto L68;
            r22 = r23.c();     // Catch: Throwable -> L77
            goto L69
        L68:
            String r24 = null;
        L70:
            long r25 = (long) (1000 * JSONObjectProtectorUtils.getDouble(r110, "Duration"));     // Catch: Throwable -> L77
            long r112 = JSONObjectProtectorUtils.getLong(r110, "Size");     // Catch: Throwable -> L77
            int r26 = JSONObjectProtectorUtils.getInt(r110, "Width");     // Catch: Throwable -> L77
            int r113 = JSONObjectProtectorUtils.getInt(r110, "Height");     // Catch: Throwable -> L77
            mr9.e r27 = mr9.e.a(r111, Long.valueOf(r25), null, Long.valueOf(r112), JSONObjectProtectorUtils.getString(r110, "Format"), r24, Integer.valueOf(r113), Integer.valueOf(r26), Integer.valueOf(r20), 15371);     // Catch: Throwable -> L77
            if (o0.d(this.a.l) == false) goto L80;
            String r28 = this.a.l;     // Catch: Throwable -> L77
            if (r28 != null) goto L75;
            String r29 = "";
        L76:
            h.a(r29, r27, "BDVideoUploader#parseVideoMeta");     // Catch: Throwable -> L77
            goto L80
        L75:
            r29 = r28;
        L80:
            r15.element = r27;     // Catch: Throwable -> L77
            Object r30 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L77
        L83:
            g r33 = this.b;
            if (Result.exceptionOrNull-impl(r30) == null) goto L86;
            FLogger.a.e(r33.b, "[parseVideoMeta] failed, error(" + r34.mErrorCode + ", " + r34.mTosKey + ')');
        L86:
            mr9.e r35 = (mr9.e) r15.element;
            if (r35 != null) goto L89;
            r35 = new mr9.e(null, null, null, null, null, null, null, null, null, null, null, null, 16383);
        L89:
            r11.c(new mr9.l(r12, null, null, null, new n(r14, r8, r35), false, null, 110));
        L69:
            r24 = r22;
            goto L70
        L79:
            r27 = null;
        L77:
            th = move-exception;
            Result.Companion r36 = Result.Companion;
            r30 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L83
        L56:
            r14 = r13;
        L91:
            if (this.b.e == false) goto L96;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new VideoUploaderImpl$VideoUploadListener$handleUploadSuccess$1(this, null), 3, null);
        L96:
            this.b.c();
            return;
        L50:
            r8 = r4;
            goto L51
        L46:
            r4 = null;
            goto L48
        L93:
            b4.a r37 = this.b.d;
            if (r37 == null) goto L96;
            r37.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "upload response BDVideoInfo is null"));
            goto L96
        L12:
            if (r31 != 2) goto L14;
            StringBuilder r38 = new StringBuilder("upload failed, what:");
            r38.append(r31);
            r38.append(", error code(");
            if (r34 == null) goto L23;
            Long r39 = Long.valueOf(r34.mErrorCode);
        L24:
            r38.append(r39);
            r38.append("), error msg(");
            if (r34 == null) goto L27;
            String r40 = r34.mErrorMsg;
        L28:
            r38.append(r40);
            r38.append(')');
            String r41 = r38.toString();
            r5.e(this.b.b, "[handleOnUploadFailed] " + r41);
            ResourceUploadTokenProvider r42 = ResourceUploadTokenProvider.a;
            if (r34 == null) goto L31;
            Long r43 = Long.valueOf(r34.mErrorCode);
        L32:
            r42.getClass();
            if (ResourceUploadTokenProvider.c(r43) == false) goto L35;
            ResourceUploadTokenProvider.b(this.a);
        L35:
            b4.a r44 = this.b.d;
            if (r44 == null) goto L38;
            r44.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, r41));
        L38:
            BDVideoUploader r45 = this.b.c;
            if (r45 == null) goto L41;
            r45.close();
        L41:
            this.b.c();
            return;
        L31:
            r43 = null;
            goto L32
        L27:
            r40 = null;
            goto L28
        L23:
            r39 = null;
            goto L24
        L14:
            if (r31 != 3) goto L102;
            b4.a r46 = this.b.d;
            if (r46 == null) goto L19;
            r46.a(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "upload canceled"));
        L19:
            this.b.c();
            return;
        }
    }

    static {
        i = z2.a.getBDVideoUploaderConfig();
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [com.larus.uploader.impl.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v21, types: [com.larus.uploader.impl.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.uploader.impl.f, java.lang.Object] */
    @Override // com.larus.platform.api.b4
    public final void a() {
        com.larus.bmhome.upload.j.a.getClass();
        if (com.larus.bmhome.upload.j.a().a() == false) goto L122;
        FLogger r1 = FLogger.a;
        r1.i(this.b, "[uploadAfterTranscoding] start");
        this.f[0] = System.currentTimeMillis();
        h r3 = h.a;
        String r4 = this.a.l;
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        mr9.e r5 = r3.query(r4);
        if (r5 == null) goto L121;
        String r6 = this.a.l;
        if (r6 != null) goto L12;
    L15:
        boolean r7 = true;
    L16:
        if (r7 == true) goto L121;
        Intrinsics.checkNotNullParameter(r5, "videoMeta");
        Integer r8 = r5.j();
        if (r8 == null) goto L42;
        int r9 = RangesKt.coerceAtLeast(r8.intValue(), 1);
        Integer r10 = r5.h();
        if (r10 == null) goto L41;
        int r11 = RangesKt.coerceAtLeast(r10.intValue(), 1);
        Integer r12 = com.larus.bmhome.upload.j.a().e();
        if (r12 == null) goto L25;
        int r13 = r12.intValue();
    L26:
        Integer r14 = com.larus.bmhome.upload.j.a().g();
        if (r14 == null) goto L29;
        int r15 = r14.intValue();
    L30:
        float r16 = r9 / r11;
        if (r16 <= 0.0f) goto L37;
        if (r16 > 1.0f) goto L37;
        if (r9 <= r15) goto L37;
        com.larus.bmhome.upload.j.a r17 = new com.larus.bmhome.upload.j.a(Integer.valueOf(r15), Integer.valueOf((int) (r15 / r16)));
    L44:
        Integer r18 = r17.a;
        Integer r19 = r17.b;
        Integer r20 = com.larus.bmhome.upload.j.a().d();
        if (r20 == null) goto L51;
        int r21 = r20.intValue();
        Float r22 = r5.g();
        if (r22 == null) goto L51;
        if (((int) r22.floatValue()) <= r21) goto L51;
        Integer r110 = Integer.valueOf(r21);
    L52:
        Integer r23 = r5.b();
        if (r23 == null) goto L59;
        int r24 = r23.intValue();
        Long r25 = com.larus.bmhome.upload.j.a().b();
        if (r25 == null) goto L59;
        long r111 = r25.longValue();
        if (r24 <= r111) goto L59;
        Long r112 = Long.valueOf(r111);
    L60:
        String r26 = r5.f();
        if (r26 == null) goto L65;
        String r27 = StringsKt.substringAfterLast$default(r26, '/', null, 2, null);
        if (r27 == null) goto L65;
        String r28 = r27.toLowerCase(Locale.getDefault());
    L66:
        if (r28 != null) goto L69;
        r28 = "";
    L69:
        if (r28.length() <= 0) goto L71;
        boolean r29 = true;
    L72:
        if (r29 == true) goto L74;
    L76:
        String r30 = null;
    L77:
        pq9.l r31 = new pq9.l(r18, r19, r110, r112, null, r30);
        if (pq9.m.a(r31) == false) goto L80;
        r1.i("VideoTranscodeHelper", "[buildVideoTranscodeParam] all empty, ignore codec");
    L96:
        final pq9.l r113 = r31;
        if (pq9.m.a(r113) == false) goto L99;
        r1.i("VideoUploaderImpl", "[uploadAfterTranscoding] no need to transcode");
        this.g[0] = System.currentTimeMillis();
        d();
        return;
    L99:
        j r32 = this.a;
        String r33 = r32.l;
        if (r33 != null) goto L102;
        String r114 = "";
    L103:
        String r115 = r32.a;
        ?? r34 = new d(this);
        ?? r35 = new e(this, r113);
        ?? r36 = new f(this);
        Intrinsics.checkNotNullParameter(r114, "identifier");
        Intrinsics.checkNotNullParameter(r115, "videoPath");
        Intrinsics.checkNotNullParameter(r113, "transcodeParam");
        Intrinsics.checkNotNullParameter(r34, "onProgress");
        Intrinsics.checkNotNullParameter(r35, "onComplete");
        Intrinsics.checkNotNullParameter(r36, "onError");
        r1.i("VideoTranscodeHelper", "[tryTranscodeVideo] identifier:".concat(r114));
        int r2 = r115.length() - 1;
        if (r2 < 0) goto L114;
    L105:
        int r37 = r2 - 1;
        if (r115.charAt(r2) != '.') goto L108;
        boolean r38 = true;
    L109:
        if (r38 == true) goto L115;
        if (r37 < 0) goto L114;
        r2 = r37;
    L115:
        if (r2 == (-1)) goto L117;
        String r116 = r115.substring(0, r2) + "_formatted" + r115.substring(r2);
    L119:
        if (o3.b.j(r114, r115, r116, r113, new com.larus.bmhome.upload.k(r36, r35, r116, r34)) == true) goto L127;
        r36.invoke("transcodeVideo exec failed");
        return;
    L127:
        return;
    L117:
        r116 = r115;
        goto L119
    L108:
        r38 = false;
    L114:
        r2 = -1;
        goto L115
    L102:
        r114 = r33;
        goto L103
    L80:
        String r39 = r5.c();
        if (r39 == null) goto L83;
        String r40 = r39.toLowerCase(Locale.getDefault());
    L85:
        if (o0.d(r40) == true) goto L87;
    L89:
        String r41 = null;
    L90:
        r31 = pq9.l.a(r31, null, null, r41, 47);
        if (r31.a != null) goto L94;
        r31 = pq9.l.a(r31, r5.j(), null, null, 62);
    L94:
        if (r31.b != null) goto L96;
        r31 = pq9.l.a(r31, null, r5.h(), null, 61);
        goto L96
    L87:
        if (Intrinsics.areEqual(r40, com.larus.bmhome.upload.j.a().c()) == true) goto L89;
        r41 = com.larus.bmhome.upload.j.a().c();
        goto L90
    L83:
        r40 = null;
        goto L85
    L74:
        if (Intrinsics.areEqual(r28, com.larus.bmhome.upload.j.a().f()) == true) goto L76;
        r30 = com.larus.bmhome.upload.j.a().f();
        goto L77
    L71:
        r29 = false;
    L65:
        r28 = null;
    L59:
        r112 = null;
    L51:
        r110 = null;
    L37:
        if (r16 <= 1.0f) goto L40;
        if (r11 <= r13) goto L40;
        r17 = new com.larus.bmhome.upload.j.a(Integer.valueOf((int) (r13 * r16)), Integer.valueOf(r13));
    L40:
        com.larus.bmhome.upload.j.a r42 = new com.larus.bmhome.upload.j.a(null, null);
    L43:
        r17 = r42;
        goto L44
    L29:
        r15 = r9;
        goto L30
    L25:
        r13 = r11;
        goto L26
    L41:
        r42 = new com.larus.bmhome.upload.j.a(null, null);
        goto L43
    L42:
        r42 = new com.larus.bmhome.upload.j.a(null, null);
        goto L43
    L12:
        if (r6.length() == 0) goto L15;
        r7 = false;
    L121:
        this.a.f.invoke(new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "videoMeta is null"));
        return;
    L122:
        this.g[0] = System.currentTimeMillis();
        d();
    }

    public final void c() {
        FLogger.a.i(this.b, "[cancel]");
        BDVideoUploader r0 = this.c;
        if (r0 == null) goto L5;
        r0.close();
    L5:
        this.c = null;
        this.d = null;
    }

    public final void d() {
        FLogger r0 = FLogger.a;
        r0.i(this.b, "[uploadToServer] start");
        j r1 = this.a;
        r0.i(this.b, "[createBDVideoUploader], params:" + r1);
        BDVideoUploader r2 = new BDVideoUploader();
        if (r1.g == false) goto L5;
        r2.setMediaDataReader(new com.larus.uploader.impl.a(r1.getContext(), r1.a));
    L6:
        m r3 = r1.h;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == null) goto L20;
        r2.setUploadDomain(r3.c());
        mr9.b r4 = r3.a();
        String r5 = null;
        if (r4 == null) goto L11;
        String r6 = r4.a();
    L12:
        r2.setTopAccessKey(r6);
        mr9.b r7 = r3.a();
        if (r7 == null) goto L15;
        String r8 = r7.c();
    L16:
        r2.setTopSecretKey(r8);
        mr9.b r9 = r3.a();
        if (r9 == null) goto L19;
        r5 = r9.d();
    L19:
        r2.setTopSessionToken(r5);
        r2.setSpaceName(r3.b());
        goto L20
    L15:
        r8 = null;
        goto L16
    L11:
        r6 = null;
    L20:
        com.larus.platform.model.chat.e r10 = i;
        r2.setSocketNum(r10.h());
        r2.setSliceReTryCount(r10.g());
        r2.setFileRetryCount(r10.e());
        r2.setSDKMaxRetryTimeout(r10.f());
        r2.setCustomNetworkTimeoutParams(r10.a(), r10.b(), r10.d(), r10.c(), 0);
        r2.setOpenBoe(HttpExtKt.e().a);
        this.c = r2;
        r2.setListener(new b(this, r1));
        BDVideoUploader r11 = this.c;
        if (r11 == null) goto L24;
        r11.start();
        return;
    L24:
        return;
    L5:
        r2.setPathName(r1.a);
        goto L6
    }

    public g(j r3) {
        Intrinsics.checkNotNullParameter(r3, "uploadParam");
        this.a = r3;
        this.b = "VideoUploaderImpl_" + this.a.l;
        this.f = new long[2];
        this.g = new long[2];
        this.h = -1;
    }

    @Override // com.larus.platform.api.b4
    public final void b(ResourceUploadEngine.upload.2.1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d = r2;
    }

    @Override // com.larus.platform.api.b4
    public final void cancel(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        FLogger r0 = FLogger.a;
        r0.i(this.b, "[cancel]");
        com.larus.bmhome.upload.j r1 = com.larus.bmhome.upload.j.a;
        String r2 = this.a.l;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "identifier");
        r0.i("VideoTranscodeHelper", "[cancelTranscoding] identifier:".concat(r2));
        o3.b.b(r2);
        b4.a r3 = this.d;
        if (r3 == null) goto L8;
        r3.a(new ResourceUploadError(ResourceUploadError.CANCELED, r5));
    L8:
        BDVideoUploader r7 = this.c;
        if (r7 == null) goto L11;
        r7.cancelUpload();
    L11:
        if (r6 == false) goto L14;
        c();
        return;
    }
}
