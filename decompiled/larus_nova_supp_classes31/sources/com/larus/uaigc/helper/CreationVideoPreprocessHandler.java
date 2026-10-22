package com.larus.uaigc.helper;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.resource.access.ResourceInputType;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.trace.CopyContentTypeString;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/larus/uaigc/helper/CreationVideoPreprocessHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveReadableVideoFile", "Ljava/io/File;", "resourceInput", "Lcom/larus/bmhome/resource/access/ResourceInput;", "originUri", "Landroid/net/Uri;", "copyContentUriToVideoCache", "uri", "resolveVideoFileSuffix", "failedVideoPreprocess", "Lcom/larus/bmhome/resource/access/NodeResult$Failed;", CopyContentTypeString.CODE, "Lcom/larus/bmhome/chat/bean/ProcessFileResultCode;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationVideoPreprocessHandler implements ResourceNodeHandler {
    public final String a;
    public final String b;

    public final void getPriority() {
    }

    public CreationVideoPreprocessHandler() {
        this.a = "creation_video_preprocess";
        this.b = "preprocess";
    }

    public final String a() {
        return this.b;
    }

    public final String getKey() {
        return this.a;
    }

    public static String e(Uri r3) {
        String r0 = AppHost.a.getApplication().getContentResolver().getType(r3);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r1 = r0.toLowerCase(Locale.US);
        switch(r1.hashCode()) {
            case -1662095187: goto L20;
            case -107252314: goto L16;
            case 1331848029: goto L13;
            case 2039520277: goto L9;
            default: goto L23;
        };
    L23:
        String r4 = r3.getLastPathSegment();
        if (r4 == null) goto L33;
        String r5 = StringsKt.substringAfterLast(r4, '.', "");
        if (r5 == null) goto L33;
        if ((!StringsKt.isBlank(r5)) == true) goto L31;
        r5 = null;
    L31:
        if (r5 == null) goto L33;
        return r5;
    L33:
        return "mp4";
    L9:
        if (r1.equals("video/x-matroska") == false) goto L23;
        return "mkv";
    L13:
        if (r1.equals("video/mp4") == false) goto L23;
    L16:
        if (r1.equals("video/quicktime") == false) goto L23;
        return "mov";
    L20:
        if (r1.equals("video/webm") == false) goto L23;
        return "webm";
    }

    public final boolean b(com.larus.bmhome.resource.access.h0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (a0.b(r5) == false) goto L16;
        com.larus.bmhome.resource.access.w r0 = r5.a;
        if (r0.c == ResourceMediaType.VIDEO) goto L7;
        return false;
    L7:
        if (CollectionsKt.contains(b0.a, r0.d.c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r5.b().get("preprocess_sub_scene"), "video") == true) goto L11;
        return false;
    L11:
        if (a0.a(r5, "enable_preprocess", new c0()) == true) goto L13;
        return false;
    L13:
        if (SetsKt.setOf(new ResourceInputType[]{ResourceInputType.CONTENT_URI, ResourceInputType.LOCAL_PATH}).contains(r5.c.getType()) == false) goto L21;
        return true;
    L21:
        return false;
    L16:
        return false;
    }

    public final com.larus.bmhome.resource.access.g.b d(ProcessFileResultCode r6) {
        return new com.larus.bmhome.resource.access.g.b(new com.larus.bmhome.resource.access.r(this.b, r6.getValue(), "creation video preprocess failed", null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [long] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7, types: [com.bytedance.security.android.aopcheck.PolarisFileWrapper, java.io.File] */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    public final Object c(com.larus.bmhome.resource.access.h0 r38, Continuation<? super com.larus.bmhome.resource.access.g> r39) {
        com.larus.bmhome.resource.access.j0.a r3 = r38.c;
        boolean r0 = r3 instanceof com.larus.bmhome.resource.access.j0.a;
        if (r0 == false) goto L6;
        Uri r4 = UriProtector.parse(r3.b);
    L8:
        Intrinsics.checkNotNull(r4);
        String r5 = "";
        if (r0 == false) goto L14;
        String r6 = vqc.d.d(AppHost.a.getApplication(), r4);
        if (r6 == null) goto L23;
    L24:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r6);
        if ((!StringsKt.isBlank(r6)) == true) goto L27;
    L31:
        boolean r8 = false;
    L32:
        if (r8 == true) goto L35;
        r7 = null;
    L35:
        char r9 = '.';
        if (r7 != null) goto L40;
        if (r0 == true) goto L289;
        r7 = null;
        goto L40
    L289:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L87
        String r11 = e(r4);     // Catch: Throwable -> L87
        AppHost.Companion r16 = AppHost.a;     // Catch: Throwable -> L87
        ?? r15 = new PolarisFileWrapper(r16.getApplication().getCacheDir(), "creation_video_preprocess");     // Catch: Throwable -> L87
        if (r15.exists() == false) goto L45;
    L47:
        PolarisFileWrapper r12 = new PolarisFileWrapper(r15, "video_" + System.currentTimeMillis() + '_' + UUID.randomUUID() + '.' + r11);     // Catch: Throwable -> L87
        InputStream r13 = ContentResolverWrapper.openInputStream(r16.getApplication().getContentResolver(), r4);     // Catch: Throwable -> L87
        if (r13 != null) goto L297;
    L46:
        long r17 = 0;
    L82:
        r12 = null;
    L83:
        Object r1 = Result.constructor-impl(r12);     // Catch: Throwable -> L85
        ?? r18 = r17;
    L90:
        Throwable r14 = Result.exceptionOrNull-impl(r1);
        if (r14 == null) goto L94;
        FLogger.a.w("CreationVideoNodeHandlers", "[copyContentUriToVideoCache] failed, cause=".concat(r14.getClass().getSimpleName()));
    L94:
        if (Result.isFailure-impl(r1) == false) goto L96;
        r1 = null;
    L96:
        r7 = (File) r1;
        ?? r19 = r18;
    L97:
        if (r7 == null) goto L99;
        String r2 = r7.getAbsolutePath();
        long r20 = r7.length();
        ImFileUtil.a.getClass();
        if (ImFileUtil.A(r20) == false) goto L105;
        return d(ProcessFileResultCode.PREPARE_OVER_SIZE);
    L105:
        if (ImFileUtil.x(r20) == true) goto L107;
        Intrinsics.checkNotNull(r2);
        String r21 = AlbumHelperKt.e(r2);
        FLogger r110 = FLogger.a;
        StringBuilder r111 = new StringBuilder("[videoPreprocess] copiedToInternal=");
        if (r21 == null) goto L111;
        boolean r112 = true;
    L112:
        r111.append(r112);
        r110.i("CreationVideoNodeHandlers", r111.toString());
        if (r21 == null) goto L116;
        r2 = r21;
    L116:
        File r22 = new PolarisFileWrapper(r2);
        if (r22.exists() == false) goto L119;
        File r113 = r22;
    L120:
        if (r113 == null) goto L122;
        r20 = r113.length();
    L122:
        String r114 = r38.a.d.a;
        mr9.e r23 = AlbumHelperKt.h(Uri.fromFile(r22), r7.getName(), r20, r114);
        if (r23 == null) goto L125;
        String r24 = (String) r38.b().get("video_max_duration_seconds");
        if (r24 == null) goto L131;
        Integer r25 = StringsKt.toIntOrNull(r24);
        if (r25 == null) goto L131;
        int r26 = r25.intValue();
    L132:
        Long r115 = r23.d();
        if (r115 == null) goto L135;
        ?? r116 = r115.longValue();
    L136:
        int r117 = MathKt.roundToInt(((float) r116) / 1000.0f);
        if (r26 <= 0) goto L142;
        if (r117 <= r26) goto L142;
        return d(ProcessFileResultCode.PREPARE_OVER_DURATION);
    L142:
        if (ImFileUtil.z(r23, true) == true) goto L144;
        com.larus.bmhome.upload.h r27 = com.larus.bmhome.upload.h.a;
        com.larus.bmhome.upload.h.a(r114, r23, "CreationVideoPreprocessHandler");
        com.larus.bmhome.resource.access.j0.b r28 = new com.larus.bmhome.resource.access.j0.b(r2, r3.a(), Boxing.boxBoolean(r3 instanceof com.larus.bmhome.resource.access.j0.a), Boxing.boxLong(r20), 16);
        Long r29 = Boxing.boxLong(r20);
        mr9.h r118 = r38.f;
        Set<String> r119 = b0.a;
        UplinkFileEntity r120 = r118.c;
        if (r120 != null) goto L148;
        r20 = r20;
        mr9.h r210 = r118;
        String r121 = null;
        r28 = r28;
    L215:
        String r30 = StringsKt.substringAfterLast(r2, r9, "");
        if (r30.length() <= 0) goto L218;
        boolean r31 = true;
    L219:
        if (r31 == true) goto L222;
        r30 = r121;
    L222:
        if (r30 != null) goto L224;
        String r211 = r38.g;
    L225:
        Pair[] r32 = new Pair[7];
        r32[0] = TuplesKt.to("preprocess_result", ProcessFileResultCode.SUCCESS.getValue());
        r32[1] = TuplesKt.to("preprocess_file_size", String.valueOf(r20));
        String r33 = r23.f();
        if (r33 != null) goto L228;
        r33 = "";
    L228:
        r32[2] = TuplesKt.to("preprocess_file_type", r33);
        r32[3] = TuplesKt.to("video_local_path", r2);
        Long r34 = r23.d();
        if (r34 == null) goto L231;
        String r35 = r34.toString();
    L232:
        if (r35 != null) goto L234;
        r35 = "";
    L234:
        r32[4] = TuplesKt.to("video_duration_ms", r35);
        Integer r36 = r23.j();
        if (r36 == null) goto L237;
        String r37 = r36.toString();
    L238:
        if (r37 != null) goto L240;
        r37 = "";
    L240:
        r32[5] = TuplesKt.to("video_width", r37);
        Integer r40 = r23.h();
        if (r40 == null) goto L243;
        String r41 = r40.toString();
    L244:
        if (r41 != null) goto L246;
        r41 = "";
    L246:
        r32[6] = TuplesKt.to("video_height", r41);
        Map r42 = MapsKt.mutableMapOf(r32);
        Image r43 = r23.a;
        if (r43 == null) goto L267;
        String r44 = r43.key;
        if (r44 != null) goto L251;
        r44 = "";
    L251:
        r42.put("video_cover_key", r44);
        String r45 = r43.localResPath;
        if (r45 != null) goto L254;
        r45 = "";
    L254:
        r42.put("video_cover_local_path", r45);
        ImageObj r46 = r43.imageOri;
        if (r46 == null) goto L257;
        String r47 = Integer.valueOf(r46.width).toString();
    L258:
        if (r47 != null) goto L260;
        r47 = "";
    L260:
        r42.put("video_cover_width", r47);
        ImageObj r48 = r43.imageOri;
        if (r48 == null) goto L263;
        r121 = Integer.valueOf(r48.height).toString();
    L263:
        if (r121 == null) goto L266;
        r5 = r121;
    L266:
        r42.put("video_cover_height", r5);
        goto L267
    L257:
        r47 = r121;
    L267:
        LinkedHashMap r49 = new LinkedHashMap();
        Iterator r50 = r42.entrySet().iterator();
    L269:
        if (r50.hasNext() == false) goto L277;
        Map.Entry r51 = (Map.Entry) r50.next();
        if (((String) r51.getValue()).length() <= 0) goto L273;
        boolean r52 = true;
    L274:
        if (r52 == false) goto L269;
        r49.put(r51.getKey(), r51.getValue());
        goto L269
    L273:
        r52 = false;
        goto L274
    L277:
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(r28, null, r29, r210, r211, null, r49, 34));
    L243:
        r41 = r121;
        goto L244
    L237:
        r37 = r121;
        goto L238
    L231:
        r35 = r121;
        goto L232
    L224:
        r211 = r30;
        goto L225
    L218:
        r31 = false;
        goto L219
    L148:
        UplinkEntityContent r122 = r120.getUplinkEntityContent();
        if (r122 != null) goto L151;
        UplinkEntityContent r53 = new UplinkEntityContent(null, null, 3, null);
    L152:
        UplinkFileInfo r123 = r53.getUplinkFileInfo();
        if (r123 != null) goto L155;
        r123 = new UplinkFileInfo(null, null, null, Integer.valueOf(FileType.FileTypeVideo.getValue()), null, null, null, null, null, null, 1015, null);
    L155:
        VideoExtension r124 = r123.getVideo();
        if (r124 != null) goto L158;
        r124 = new VideoExtension(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L158:
        File r125 = new PolarisFileWrapper(r2);
        Image r126 = r23.a;
        if (r126 != null) goto L161;
        r126 = r124.getCover();
    L161:
        Image r212 = r126;
        Integer r127 = r23.j();
        if (r127 != null) goto L164;
        r127 = r124.getWidth();
    L164:
        Integer r213 = r127;
        Integer r128 = r23.h();
        if (r128 != null) goto L167;
        r128 = r124.getHeight();
    L167:
        Integer r214 = r128;
        Long r129 = r23.d();
        if (r129 == null) goto L170;
        long r54 = r129.longValue();
    L171:
        Float r55 = Float.valueOf(r54 / 1000.0f);
        if (r55.floatValue() <= 0.0f) goto L174;
        boolean r56 = true;
    L175:
        if (r56 == true) goto L178;
        r55 = null;
    L178:
        if (r55 != null) goto L180;
        r55 = r124.getDuration();
    L180:
        Float r215 = r55;
        String r57 = r23.f();
        if (r57 != null) goto L183;
        r57 = r124.getFormat();
    L183:
        VideoExtension r216 = VideoExtension.copy$default(r124, null, r2, r212, r57, null, null, r215, r214, r213, null, 561, null);
        String r58 = r123.getFileName();
        if (r58 != null) goto L188;
        r58 = r23.e();
        if (r58 != null) goto L188;
        r58 = r125.getName();
    L188:
        String r130 = r58;
        Integer r59 = r123.getFileType();
        if (r59 == null) goto L191;
        int r60 = r59.intValue();
    L192:
        Long r61 = r23.i();
        if (r61 == null) goto L195;
    L203:
        Long r217 = r61;
        String r62 = r123.getMimeType();
        if (r62 != null) goto L206;
        r62 = r23.f();
    L206:
        UplinkFileInfo r131 = r123;
        UplinkFileInfo r63 = UplinkFileInfo.copy$default(r131, r130, null, null, Integer.valueOf(r60), r217, null, r216, r62, r2, null, 550, null);
        Integer r64 = r120.getEntityType();
        if (r64 == null) goto L209;
        int r65 = r64.intValue();
    L210:
        String r132 = r120.getFileIdentifier();
        if (r132 != null) goto L213;
        String r218 = r114;
    L214:
        Uri r219 = Uri.fromFile(r125);
        r121 = null;
        r210 = mr9.h.a(r118, UplinkFileEntity.copy$default(r120, Integer.valueOf(r65), UplinkEntityContent.copy$default(r53, r63, null, 2, null), r218, null, null, null, null, null, null, false, r219, null, null, null, 15352, null));
        r9 = '.';
        goto L215
    L213:
        r218 = r132;
        goto L214
    L209:
        r65 = UplinkEntityType.EntityTypeFile.getValue();
        goto L210
    L195:
        if (r125.exists() == false) goto L197;
        File r66 = r125;
    L198:
        if (r66 == null) goto L200;
        r61 = Long.valueOf(r66.length());
    L201:
        if (r61 != null) goto L203;
        r61 = r123.getSize();
        goto L203
    L200:
        r61 = null;
        goto L201
    L197:
        r66 = null;
        goto L198
    L191:
        r60 = FileType.FileTypeVideo.getValue();
        goto L192
    L174:
        r56 = false;
        goto L175
    L170:
        r54 = 0;
        goto L171
    L151:
        r53 = r122;
        goto L152
    L144:
        return d(ProcessFileResultCode.PREPARE_OVER_META_LIMIT);
    L135:
        r116 = r19;
    L131:
        r26 = 0;
        goto L132
    L125:
        return d(ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR);
    L119:
        r113 = null;
        goto L120
    L111:
        r112 = false;
        goto L112
    L107:
        return d(ProcessFileResultCode.PREPARE_OVER_STORAGE_FREE_SPACE);
    L99:
        return d(ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR);
    L297:
        PolarisFileOutputStreamWrapper r67 = new PolarisFileOutputStreamWrapper(r12);     // Catch: Throwable -> L74
        ByteStreamsKt.copyTo$default(r13, r67, 0, 2, null);     // Catch: Throwable -> L65
        CloseableKt.closeFinally(r67, null);     // Catch: Throwable -> L74
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L87
        if (r12.exists() == true) goto L56;
    L61:
        long r133 = 0;
    L62:
        boolean r68 = false;
        r17 = r133;
    L63:
        if (r68 == false) goto L82;
    L56:
        if (r12.isFile() == false) goto L61;
        r133 = 0;
        r17 = 0;
        if (r12.length() <= 0) goto L62;
        r68 = true;
    L65:
        th = move-exception;
        r15 = 0;
        throw th;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        CloseableKt.closeFinally(r67, th);     // Catch: Throwable -> L72
        throw th;     // Catch: Throwable -> L72
    L72:
        th = th;
    L76:
        Throwable r69 = th;
        throw r69;     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        CloseableKt.closeFinally(r13, r69);     // Catch: Throwable -> L85
        throw th;     // Catch: Throwable -> L85
    L74:
        th = th;
        r15 = 0;
        goto L76
    L45:
        if (r15.mkdirs() == true) goto L47;
    L85:
        th = th;
    L89:
        Result.Companion r70 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        r18 = r15;
    L87:
        th = th;
        r15 = 0;
    L40:
        r19 = 0;
        goto L97
    L27:
        if (r7.exists() == false) goto L31;
        if (r7.isFile() == false) goto L31;
        r8 = true;
    L23:
        r6 = "";
        goto L24
    L14:
        if ((r3 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L17;
        r6 = ((com.larus.bmhome.resource.access.j0.b) r3).b;
        goto L24
    L17:
        if ((r3 instanceof com.larus.bmhome.resource.access.j0.c) == true) goto L23;
        if ((r3 instanceof com.larus.bmhome.resource.access.j0.d) == true) goto L23;
        throw new NoWhenBranchMatchedException();
    L6:
        if ((r3 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L279;
        r4 = Uri.fromFile(new PolarisFileWrapper(((com.larus.bmhome.resource.access.j0.b) r3).b));
        goto L8
    L279:
        if ((r3 instanceof com.larus.bmhome.resource.access.j0.c) == true) goto L286;
        if ((r3 instanceof com.larus.bmhome.resource.access.j0.d) == true) goto L286;
        throw new NoWhenBranchMatchedException();
    L286:
        return com.larus.bmhome.resource.access.g.e.a;
    }
}
