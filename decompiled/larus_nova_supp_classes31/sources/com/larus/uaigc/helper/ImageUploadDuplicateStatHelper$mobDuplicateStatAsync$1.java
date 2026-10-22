package com.larus.uaigc.helper;

import android.net.Uri;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.ImageUploadDuplicateStatHelper$mobDuplicateStatAsync$1", f = "ImageUploadDuplicateStatHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageUploadDuplicateStatHelper$mobDuplicateStatAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isCachedFile;
    final /* synthetic */ ic8.n0 $processFileResult;
    final /* synthetic */ long $processTime;
    final /* synthetic */ String $scene;
    final /* synthetic */ Uri $uri;
    int label;

    public ImageUploadDuplicateStatHelper$mobDuplicateStatAsync$1(ic8.n0 r1, Uri r2, String r3, boolean r4, long r5, Continuation<? super ImageUploadDuplicateStatHelper$mobDuplicateStatAsync$1> r7) {
        this.$processFileResult = r1;
        this.$uri = r2;
        this.$scene = r3;
        this.$isCachedFile = r4;
        this.$processTime = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ImageUploadDuplicateStatHelper$mobDuplicateStatAsync$1(this.$processFileResult, this.$uri, this.$scene, this.$isCachedFile, this.$processTime, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L106;
        ResultKt.throwOnFailure(r26);
        ic8.m0 r0 = this.$processFileResult.a;
        if (r0 == null) goto L8;
        String r1 = r0.d;
        if (r1 == null) goto L8;
    L9:
        String r2 = r1;
        String r3 = vqc.d.d(AppHost.a.getApplication(), this.$uri);
        if (r3 == null) goto L12;
        PolarisFileWrapper r4 = new PolarisFileWrapper(r3);
        long r5 = r4.length();
        long r6 = System.currentTimeMillis();
        ImFileUtil.a.getClass();
        final String r7 = ImFileUtil.g(r4);
        if (r7 == null) goto L16;
        long r8 = System.currentTimeMillis() - r6;
        n0 r10 = n0.a;
        long r11 = System.currentTimeMillis();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r7, "fileHash");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L38
        if (StringsKt.isBlank(r7) == false) goto L21;
        n0.a r9 = null;
    L44:
        ImageUploadDuplicateStatHelper.a r12 = ImageUploadDuplicateStatHelper.a(r4);
        if (r12 == null) goto L47;
        int r13 = r12.a;
    L48:
        if (r12 == null) goto L50;
        int r15 = r12.b;
    L51:
        Ref.LongRef r16 = new Ref.LongRef();
        ProcessFileResultCode r17 = this.$processFileResult.b;
        if (r17 != null) goto L54;
    L56:
        boolean r18 = false;
    L58:
        if (r18 == false) goto L66;
        ic8.m0 r19 = this.$processFileResult.a;
        if (r19 == null) goto L62;
        String r110 = r19.e;
    L63:
        if (r110 != null) goto L65;
        r110 = "";
    L65:
        PolarisFileWrapper r111 = new PolarisFileWrapper(r110);
        r16.element = r111.length();
        ImageUploadDuplicateStatHelper.a r112 = ImageUploadDuplicateStatHelper.a(r111);
    L67:
        if (r112 == null) goto L69;
        int r113 = r112.a;
    L70:
        if (r112 == null) goto L72;
        int r114 = r112.b;
    L73:
        if (r112 == null) goto L76;
        String r115 = r112.c;
        if (r115 == null) goto L76;
    L77:
        JSONObject r116 = new JSONObject();
        String r20 = this.$scene;
        boolean r21 = this.$isCachedFile;
        long r22 = this.$processTime;
        ic8.n0 r23 = this.$processFileResult;
        if (r20 != null) goto L80;
        r20 = "";
    L80:
        r116.put("scene", r20);
        r116.put("ori_file_size", r5);
        r116.put("ori_image_width", r13);
        r116.put("ori_image_height", r15);
        if (r2 != null) goto L83;
        r2 = r15;
    L83:
        r116.put("ori_mime_type", r2);
        r116.put("file_size", r16.element);
        r116.put("image_width", r113);
        r116.put("image_height", r114);
        r116.put("mime_type", r115);
        if (r9 == null) goto L86;
        int r24 = 1;
    L87:
        r116.put("is_duplicate", r24);
        r116.put("is_cached_file", r21 ? 1 : 0);
        r116.put("hash_cost_ms", r8);
        if (r9 == null) goto L90;
        long r25 = r9.b;
    L91:
        r116.put("gap_ms", r6 - r25);
        r116.put("process_cost_ms", r22);
        ProcessFileResultCode r27 = r23.b;
        if (r27 == null) goto L97;
        String r28 = r27.getValue();
        if (r28 == null) goto L97;
        String r117 = r28;
    L98:
        r116.put("result_code", r117);
        Unit r29 = Unit.INSTANCE;
        com.larus.platform.service.o.a.reportEvent("album_upload_duplicate_check", r116);     // Catch: Exception -> L101
        FLogger.a.i("ImageUploadDuplicateStatHelper", "album_upload_duplicate_check:\t " + r116);     // Catch: Exception -> L101
    L104:
        return Unit.INSTANCE;
    L101:
        e = move-exception;
        FLogger.a.e("ImageUploadDuplicateStatHelper", "reportEvent error", e);
    L97:
        r117 = r15;
        goto L98
    L90:
        r25 = r6;
        goto L91
    L86:
        r24 = 0;
    L76:
        r115 = r15;
        goto L77
    L72:
        r114 = 0;
        goto L73
    L69:
        r113 = 0;
        goto L70
    L62:
        r110 = null;
        goto L63
    L66:
        r112 = null;
        goto L67
    L54:
        if (r17.isSuccess() != true) goto L56;
        r18 = true;
        goto L58
    L50:
        r15 = 0;
        goto L51
    L47:
        r13 = 0;
        goto L48
    L21:
        List r118 = CollectionsKt.toMutableList(n0.a());     // Catch: Throwable -> L38
        Iterator r119 = r118.iterator();     // Catch: Throwable -> L38
    L23:
        if (r119.hasNext() == false) goto L27;
        Object r120 = r119.next();     // Catch: Throwable -> L38
        if (Intrinsics.areEqual(((n0.a) r120).a, r7) == false) goto L23;
    L28:
        n0.a r121 = (n0.a) r120;     // Catch: Throwable -> L38
        CollectionsKt.removeAll(r118, new m0(r7));     // Catch: Throwable -> L38
        r118.add(new n0.a(r7, r11));     // Catch: Throwable -> L38
    L30:
        if (r118.size() <= ((Number) n0.b.getValue()).intValue()) goto L33;
        ListProtector.remove(r118, 0);     // Catch: Throwable -> L38
        goto L30
    L33:
        if (r118.isEmpty() == false) goto L35;
        n0.c.erase("key_duplicate_entries");     // Catch: Throwable -> L38
    L36:
        Object r30 = Result.constructor-impl(r121);     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r30) == false) goto L43;
        r30 = null;
    L43:
        r9 = (n0.a) r30;
        goto L44
    L35:
        n0.c.storeString("key_duplicate_entries", GsonProtectorUtils.toJson((Gson) n0.d.getValue(), r118));     // Catch: Throwable -> L38
        goto L36
    L27:
        r120 = null;
    L38:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L16:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L8:
        ImFileUtil r31 = ImFileUtil.a;
        Uri r32 = this.$uri;
        r31.getClass();
        r1 = ImFileUtil.i(r32);
        goto L9
    L106:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
