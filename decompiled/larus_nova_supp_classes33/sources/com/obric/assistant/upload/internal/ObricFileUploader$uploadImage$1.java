package com.obric.assistant.upload.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.collection.LruCache;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.r;
import com.obric.assistant.settings.config.CompressParam;
import com.obric.assistant.settings.config.ObricImageUploadCompressConfig;
import com.obric.assistant.t1;
import com.obric.assistant.upload.Scene;
import com.obric.capabilitykit.common.ErrorCode;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.upload.internal.ObricFileUploader$uploadImage$1", f = "ObricFileUploader.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class ObricFileUploader$uploadImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $costStartTime;
    final /* synthetic */ File $file;
    final /* synthetic */ String $identifier;
    final /* synthetic */ Scene $scene;
    int label;
    final /* synthetic */ ObricFileUploader this$0;

    public ObricFileUploader$uploadImage$1(String r1, File r2, Scene r3, ObricFileUploader r4, long r5, Continuation<? super ObricFileUploader$uploadImage$1> r7) {
        this.$identifier = r1;
        this.$file = r2;
        this.$scene = r3;
        this.this$0 = r4;
        this.$costStartTime = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ObricFileUploader$uploadImage$1(this.$identifier, this.$file, this.$scene, this.this$0, this.$costStartTime, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r54) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r54);
    L217:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r54);
        int r1 = i.a;
        String r2 = this.$identifier;
        File r3 = this.$file;
        Scene r4 = this.$scene;
        Intrinsics.checkNotNullParameter(r2, "identifier");
        Intrinsics.checkNotNullParameter(r3, "sourceFile");
        Intrinsics.checkNotNullParameter(r4, "scene");
        int r7 = m.a;
        m.c("ObricUploadPreprocessor", "[ObricUploadPreprocessor.process] identifier = " + r2 + ", scene = " + r4);
        h.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "identifier");
        Intrinsics.checkNotNullParameter(r3, "sourceFile");
        char r12 = 0;
        if (r3.exists() == true) goto L11;
    L78:
        m.b("ObricFileCache", "saveFile called, sourceFile doesn't exist or is not File");
        String r8 = null;
    L79:
        if (r8 != null) goto L81;
        r11 = r11;
        File r5 = null;
    L203:
        if (r5 != null) goto L205;
        r5 = this.$file;
    L205:
        int r6 = m.a;
        m.c("ObricFileUploader", "uploadImage called, identifier = " + this.$identifier + ", file = " + this.$file + ", scene = " + this.$scene + ", cacheFile = " + r5);
        Uri r30 = Uri.fromFile(r5);
        int r9 = UplinkEntityType.EntityTypeImage.getValue();
        UplinkEntityContent r10 = new UplinkEntityContent(null, null, 3, null);
        Image r13 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        ImFileUtil.a.getClass();
        r13.md5 = ImFileUtil.g(r5);
        r13.localResPath = r5.getPath();
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("is_marked", "0");
        r13.ext = r14;
        r13.source = "shoot";
        r10.setUplinkImageInfo(r13);
        UplinkFileEntity r15 = new UplinkFileEntity(Boxing.boxInt(r9), r10, this.$identifier, null, null, null, null, null, null, false, r30, null, null, null, 15352, null);
        boolean r16 = t1.a.getObricScreenshotUploadConfig().getUseTempBucket();
        ResourceCenter r17 = ResourceCenter.a;
        String r18 = this.$identifier;
        if (r16 == false) goto L208;
        FlowResourceScene r19 = FlowResourceScene.O_Mobile_Tmp;
    L209:
        r17.getClass();
        ResourceCenter.k(r18, r19);
        ObricUploadEntityCache$entityMap$1 r20 = ObricUploadEntityCache.a;
        String r21 = this.$identifier;
        Intrinsics.checkNotNullParameter(r21, "identifier");
        Intrinsics.checkNotNullParameter(r15, "entity");
        Object r22 = ObricUploadEntityCache.c;
        monitor-enter(r22);
        ObricUploadEntityCache.a.put(r21, r15);     // Catch: Throwable -> L218
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L218
        monitor-exit(r22);
        m.c("ObricFileUploader", "upload called, onPrepare callback, identifier = " + this.$identifier + ", entity = " + r15);
        Map<String, Set<oha.a>> r24 = e.a;
        String r25 = this.$identifier;
        Intrinsics.checkNotNullParameter(r25, "identifier");
        Intrinsics.checkNotNullParameter(r15, "entity");
        BuildersKt.launch$default(e.b, null, null, new ObricUploadDispatcher$onPrepare$1(r25, r15, null), 3, null);
        ObricFileUploader r26 = this.this$0;
        String r27 = this.$identifier;
        String r28 = r5.getPath();
        Scene r29 = this.$scene;
        UploadDataType r31 = UploadDataType.IMAGE;
        long r32 = this.$costStartTime;
        this.label = 1;
        Object r33 = ObricFileUploader.a(r26, r27, r15, r28, r29, r31, r32, this);
        Object r34 = r11;
        if (r33 != r34) goto L217;
        return r34;
    L218:
        th = move-exception;
        throw th;
    L208:
        r19 = FlowResourceScene.O_Server;
        goto L209
    L81:
        pha.b.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "targetFilePath");
        Intrinsics.checkNotNullParameter(r3, "imageFile");
        Intrinsics.checkNotNullParameter(r4, "scene");
        int r110 = m.a;
        m.c("ObricUploadImageCompress", "[compress] targetFilePath:" + r8 + ", scene:" + r4);
        String r35 = r4.getValue();
        BitmapFactory.Options r111 = new BitmapFactory.Options();
        r111.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r3.getPath(), r111);
        String r112 = r111.outMimeType;
        if (r112 != null) goto L84;
        m.c("ObricUploadImageCompress", "[checkImageType] type is null");
    L95:
        boolean r113 = false;
    L97:
        if (r113 == true) goto L99;
        CompressParam.a r36 = CompressParam.Companion;
        String r114 = Scene.DEFAULT.getValue();
        r36.getClass();
        Intrinsics.checkNotNullParameter(r114, "scene");
        CompressParam r37 = new CompressParam(r114, CompressParam.ID_NO_COMPRESS, null, null, null, 28, null);
    L123:
        if (Intrinsics.areEqual(r37.getId(), CompressParam.ID_NO_COMPRESS) == false) goto L125;
        pha.a r38 = new pha.a(r37, null);
        String r55 = "scene";
        String r39 = r8;
    L172:
        m.c("ObricUploadPreprocessor", "[ObricUploadPreprocessor.process] compress param = " + r38.a + ", final file = " + r38.b);
        r5 = r38.b;
        if (r5 != null) goto L192;
        h.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "sourceFile");
        Intrinsics.checkNotNullParameter(r39, "destFilePath");
        r5 = new PolarisFileWrapper(r39);
        if (r3.exists() == false) goto L191;
        if (r3.isFile() == false) goto L191;
        r.c(r3, r5);     // Catch: IOException -> L185
        if (r5.exists() == true) goto L182;
    L184:
        r5.delete();
    L187:
        r5 = null;
    L188:
        if (r5 != null) goto L192;
        r5 = r3;
        goto L192
    L182:
        if (r5.length() != r3.length()) goto L184;
    L185:
        e = move-exception;
        e.printStackTrace();
    L191:
        throw new IllegalArgumentException("源文件不存在或不是文件");
    L192:
        LruCache<String, l> r40 = k.a;
        String r41 = r38.a.getScene();
        String r42 = "";
        if (r41 != null) goto L195;
        r41 = "";
    L195:
        String r43 = r38.a.getId();
        if (r43 == null) goto L199;
        r42 = r43;
    L199:
        Long r44 = Long.valueOf(r.r(r3));
        Long r45 = Long.valueOf(r.r(r5));
        Intrinsics.checkNotNullParameter(r2, "identifier");
        Intrinsics.checkNotNullParameter(r41, r55);
        Intrinsics.checkNotNullParameter(r42, "compressParamId");
        l r46 = (l) k.a.get(r2);
        if (r46 == null) goto L203;
        r46.b(r41);
        r46.a(r42);
        r46.d(r44);
        r46.c(r45);
        goto L203
    L125:
        m.c("ObricUploadImageCompress", "[compress] start, compressParam = " + r37);
        String r47 = r3.getPath();
        Integer r48 = r37.getShortSize();
        if (r48 == null) goto L128;
        int r49 = r48.intValue();
    L129:
        Bitmap r115 = BitmapFactory.decodeFile(r47);
        if (r49 > 0) goto L132;
        float r116 = 1.0f;
    L138:
        if (r116 != 1.0f) goto L140;
        boolean r50 = true;
    L141:
        if (r50 == false) goto L143;
        m.c("ObricUploadImageCompress", "[scaleBitmap] not to scale");
        Intrinsics.checkNotNull(r115);
    L144:
        Bitmap r51 = r115;
        PolarisFileWrapper r52 = new PolarisFileWrapper(r8);
    L164:
        e = move-exception;
        r55 = "scene";
        r39 = r8;
        Exception r53 = e;
        BufferedOutputStream r117 = null;
    L166:
        int r56 = m.a;     // Catch: Throwable -> L223
        m.a("[compress] end, errorMsg: " + r53.getMessage(), r53);     // Catch: Throwable -> L223
        pha.a r57 = new pha.a(r37, null);     // Catch: Throwable -> L221
        if (r117 == null) goto L170;
        r117.close();
    L170:
        m5.a(r52);
    L171:
        r38 = r57;
    L221:
        th = th;
        Exception r118 = r53;
    L225:
        Exception r119 = r118;
        BufferedOutputStream r120 = r117;
    L226:
        if (r120 == null) goto L228;
        r120.close();
    L228:
        if (r119 == null) goto L230;
        m5.a(r52);
    L230:
        throw th;
    L223:
        th = th;
        r118 = null;
    L162:
        th = th;
        r120 = null;
        r119 = null;
        goto L226
    L146:
        if (r52.exists() == false) goto L148;
        r52.delete();     // Catch: Throwable -> L162 Exception -> L164
    L148:
        r117 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r52));     // Catch: Throwable -> L162 Exception -> L164
        Bitmap.CompressFormat r121 = Bitmap.CompressFormat.JPEG;     // Catch: Exception -> L159 Throwable -> L223
        Integer r122 = r37.getQuality();     // Catch: Exception -> L159 Throwable -> L223
        if (r122 == null) goto L152;
        int r123 = r122.intValue();     // Catch: Exception -> L159 Throwable -> L223
    L153:
        r51.compress(r121, r123, r117);     // Catch: Exception -> L159 Throwable -> L223
        r117.flush();     // Catch: Exception -> L159 Throwable -> L223
        StringBuilder r58 = new StringBuilder("[compress] end, file = ");     // Catch: Exception -> L159 Throwable -> L223
        r58.append(r52);     // Catch: Exception -> L159 Throwable -> L223
        r58.append(", result size = ");     // Catch: Exception -> L159 Throwable -> L223
        r55 = "scene";
        r39 = r8;
        r58.append(r.r(r52));     // Catch: Exception -> L157 Throwable -> L223
        m.c("ObricUploadImageCompress", r58.toString());     // Catch: Exception -> L157 Throwable -> L223
        r57 = new pha.a(r37, r52);     // Catch: Exception -> L157 Throwable -> L223
        r117.close();
    L157:
        e = e;
    L161:
        r53 = e;
        goto L166
    L152:
        r123 = 100;
    L159:
        e = e;
        r55 = "scene";
        r39 = r8;
        goto L161
    L143:
        Matrix r59 = new Matrix();
        r59.postScale(r116, r116);
        m.c("ObricUploadImageCompress", "[scaleBitmap] do scale shortSize: " + r49);
        r115 = Bitmap.createBitmap(r115, 0, 0, r115.getWidth(), r115.getHeight(), r59, true);
        goto L144
    L140:
        r50 = false;
        goto L141
    L132:
        if (r115.getWidth() >= r115.getHeight()) goto L134;
        float r124 = r49;
        int r125 = r115.getWidth();
    L135:
        r116 = r124 / r125;
        goto L138
    L134:
        r124 = r49;
        r125 = r115.getHeight();
        goto L135
    L128:
        r49 = 0;
        goto L129
    L99:
        LinkedHashMap r126 = new LinkedHashMap();
        ObricImageUploadCompressConfig r127 = t1.a.getObricImageUploadCompressConfig();
        m.c("ObricUploadImageCompress", "[settingsConfig] obricImageUploadCompressConfig=" + r127);
        pha.b.a(r126, r127.getScreenSemanticScene());
        pha.b.a(r126, r127.getDefaultScene());
        List r60 = (List) r126.get(r35);
        List r61 = r60;
        if (r60 != null) goto L105;
        Scene r62 = Scene.DEFAULT;
        List r63 = (List) r126.get(r62.getValue());
        List r64 = r63;
        if (r63 != null) goto L104;
        ObricImageUploadCompressConfig.Companion.getClass();
        ArrayList r65 = new ArrayList();
        CompressParam.Companion.getClass();
        r65.add(new CompressParam(r62.getValue(), CompressParam.ID_NO_COMPRESS, null, null, null, 28, null));
        r64 = r65;
    L104:
        r61 = r64;
    L105:
        CompressParam r66 = (CompressParam) CollectionsKt.firstOrNull(r61);
        if (r66 != null) goto L108;
        CompressParam.Companion.getClass();
        r66 = new CompressParam(Scene.DEFAULT.getValue(), CompressParam.ID_NO_COMPRESS, null, null, null, 28, null);
    L108:
        Integer r67 = r66.getCompressThreshold();
        long r128 = r.r(r3);
        if (r67 == null) goto L111;
        int r68 = r67.intValue();
    L112:
        int r69 = r68 * 1024;
        m.c("ObricUploadImageCompress", "[checkFileSize] imageFile size = " + r128 + ", compress threshold = " + r69);
        if (r128 < r69) goto L115;
        boolean r70 = true;
    L116:
        if (r70 == true) goto L121;
        CompressParam.a r71 = CompressParam.Companion;
        String r72 = r66.getScene();
        if (r72 != null) goto L120;
        r72 = Scene.DEFAULT.getValue();
    L120:
        r71.getClass();
        Intrinsics.checkNotNullParameter(r72, "scene");
        r66 = new CompressParam(r72, CompressParam.ID_NO_COMPRESS, null, null, null, 28, null);
    L121:
        r37 = r66;
        goto L123
    L115:
        r70 = false;
        goto L116
    L111:
        r68 = ErrorCode.ENTITY_NOT_EXIST_ERROR;
        goto L112
    L84:
        m.c("ObricUploadImageCompress", "[checkImageType] type:".concat(r112));
        String r129 = r112.toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r129, "image/jpeg") == false) goto L87;
    L96:
        r113 = true;
        goto L97
    L87:
        if (Intrinsics.areEqual(r129, "image/png") == true) goto L96;
        if (Intrinsics.areEqual(r129, "image/jpg") == true) goto L96;
        if (Intrinsics.areEqual(r129, "image/heif") == true) goto L96;
        if (Intrinsics.areEqual(r129, "image/webp") == false) goto L95;
    L11:
        if (r3.isFile() == false) goto L78;
        PolarisFileWrapper r73 = aa9.a.a.b("obric_upload_cache", true);
    L15:
        if (r73.exists() == true) goto L18;
        int r130 = m.a;
        m.b("ObricFileCache", "getFileCount called, dir does not exist: " + r73.getAbsolutePath());
    L23:
        int r131 = -1;
    L29:
        if (r131 < 5) goto L77;
        if (r73.exists() == true) goto L34;
        int r132 = m.a;
        m.b("ObricFileCache", "deleteOldestFile called, dir does not exist: " + r73.getAbsolutePath());
    L73:
        File r133 = null;
    L74:
        if (r133 == null) goto L77;
        r12 = 0;
        goto L15
    L34:
        if (r73.isDirectory() == true) goto L37;
        int r134 = m.a;
        m.b("ObricFileCache", "deleteOldestFile called, dir is not directory: " + r73.getAbsolutePath());
        goto L73
    L37:
        if (r73.canRead() == true) goto L39;
    L72:
        int r135 = m.a;
        m.b("ObricFileCache", "deleteOldestFile called, dir can not read: " + r73.getAbsolutePath());
        goto L73
    L39:
        if (r73.canWrite() == false) goto L72;
        File[] r136 = r73.listFiles(new f());
        if (r136 != null) goto L45;
        int r137 = m.a;
        m.b("ObricFileCache", "deleteOldestFile called, can not get files in dir: " + r73.getAbsolutePath());
        goto L73
    L45:
        if (r136.length != 0) goto L47;
        boolean r138 = true;
    L48:
        if (r138 == false) goto L51;
        int r139 = m.a;
        m.b("ObricFileCache", "deleteOldestFile called, files in dir is empty: " + r73.getAbsolutePath());
        goto L73
    L51:
        if (r136.length != 0) goto L53;
        boolean r140 = true;
    L54:
        if (r140 == false) goto L56;
        r133 = null;
    L67:
        if (r133 == null) goto L73;
        if (r133.delete() == false) goto L73;
        int r141 = m.a;
        m.c("ObricFileCache", "deleteOldestFile called, delete success: " + r133.getAbsolutePath());
        goto L74
    L56:
        r133 = r136[r12];
        int r142 = ArraysKt.getLastIndex(r136);
        if (r142 == 0) goto L67;
        long r143 = r133.lastModified();
        if (1 > r142) goto L67;
        int r144 = 1;
    L62:
        File r145 = r136[r144];
        long r210 = r145.lastModified();
        if (r143 <= r210) goto L65;
        r133 = r145;
        r143 = r210;
    L65:
        if (r144 == r142) goto L67;
        r144 = r144 + 1;
        goto L62
    L53:
        r140 = false;
        goto L54
    L47:
        r138 = false;
    L77:
        r8 = r73.getPath() + '/' + r2 + '_' + r3.getName();
        goto L79
    L18:
        if (r73.isDirectory() == true) goto L21;
        int r146 = m.a;
        m.b("ObricFileCache", "getFileCount called, dir is not directory: " + r73.getAbsolutePath());
        goto L23
    L21:
        if (r73.canRead() == true) goto L24;
        int r147 = m.a;
        m.b("ObricFileCache", "getFileCount called, dir can not read: " + r73.getAbsolutePath());
        goto L23
    L24:
        File[] r148 = r73.listFiles(new g());
        if (r148 == null) goto L27;
        r131 = r148.length;
        goto L29
    L27:
        r131 = 0;
        goto L29
    }
}
