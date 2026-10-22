package com.ss.android.lark.keyboard.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import com.ss.android.lark.videosend.compress.m;
import com.ss.android.lark.videosend.tools.VideoCompressTools;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMediaCompressHelper {
    public static final FlowMediaCompressHelper a = null;

    public static final class a extends com.ss.android.lark.videosend.compress.f {
        public final void b() {
            com.ss.android.lark.videosend.compress.f.a r0 = new com.ss.android.lark.videosend.compress.f.a(this);
            r0.e(((com.ss.android.lark.videosend.compress.f) this).c);
            Log.i("MediaCompressTask", "startCompressWithoutLock isStartSuccess: " + VideoCompressTools.d(((com.ss.android.lark.videosend.compress.f) this).b, ((com.ss.android.lark.videosend.compress.f) this).d, r0, ((com.ss.android.lark.videosend.compress.f) this).a.i));
        }

        public a(com.ss.android.lark.videosend.compress.a r2) {
            Intrinsics.checkNotNullParameter(r2, "param");
            super(r2);
        }
    }

    public static final class b extends m {
        public final Function1<Boolean, Unit> a;

        public final void a(float r1) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Boolean, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            this.a = r2;
        }

        public final void b(ErrorResult r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Log.e("FlowMediaCompressHelper", "onCompressError, error: " + r4.getErrorCode() + ", " + r4.getMessage() + ", " + r4.getDebugMsg());
            this.a.invoke(Boolean.FALSE);
        }

        public final void c(VideoCompressResult r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            Log.i("FlowMediaCompressHelper", "compressVideo success: " + r3.a().m);
            this.a.invoke(Boolean.TRUE);
        }
    }

    static {
        a = new FlowMediaCompressHelper();
    }

    public FlowMediaCompressHelper() {
    }

    public static String b(Context r10, String r11, ImageInfo r12, com.ss.android.lark.image.uploader.entity.b r13) {
        if (r12 != null) goto L7;
        Log.e("FlowMediaCompressHelper", "failed to get imageInfo, uploadImage:" + r13 + ", skip compress");
        return "";
    L7:
        if (r13.b == false) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L17;
        Log.i("FlowMediaCompressHelper", "uploadImage:" + r13 + ", skip compress");
        return r11;
    L17:
        int[] r1 = blb.a.a(r12, null);
        int r4 = r1[0];
        int r7 = r1[1];
        if (r4 >= Math.min(r12.a, r12.b)) goto L20;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == false) goto L28;
        Log.i("FlowMediaCompressHelper", "uploadImage:" + r13 + ", cal no need compress, skip compress");
        return r11;
    L28:
        zkb.a r6 = zkb.a.a;
        String r8 = zkb.a.a(r10, r11, r1[0], r1[1]);
        if (new PolarisFileWrapper(r8).exists() == false) goto L31;
        Log.i("FlowMediaCompressHelper", "uploadImage:" + r13 + ", compress cache exist:" + r8);
    L34:
        return r8;
    L31:
        String r9 = r6.b(r8);
        blb.b r2 = blb.d.a(blb.e.a(r11, r12, r1[0]), r13, r12, r1[1], r9);
        if (r2 == null) goto L36;
        Log.i("FlowMediaCompressHelper", "compress finish, outputPath:" + r2.a);
        Log.i("FlowMediaCompressHelper", "rename ret:" + r6.c(r9, r8) + ", tempPath:" + r9 + ", finalPath:" + r8);
        goto L34
    L36:
        if (r13.i == false) goto L42;
        r13.i = false;
        if (new PolarisFileWrapper(r9).exists() == false) goto L41;
        Log.e("FlowMediaCompressHelper", "delete last file");
        new PolarisFileWrapper(r9).delete();
    L41:
        return b(r10, r11, r12, r13);
    L42:
        return "";
    L20:
        if (r7 < r12.d) goto L24;
        if (r12.h != ImageUtils.ImageType.TYPE_JPG) goto L24;
        r5 = true;
        goto L25
    L9:
        if (r12.i == true) goto L12;
        r3 = false;
        goto L14
    }

    public final Object a(Context r9, UplinkFileEntity r10, String r11, String r12, Continuation<? super String> r13) {
        if ((r13 instanceof FlowMediaCompressHelper$compress$1) == false) goto L7;
        FlowMediaCompressHelper$compress$1 r1 = (FlowMediaCompressHelper$compress$1) r13;
        int r2 = r1.label;
        if ((r2 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r1.label = r2 - Target.SIZE_ORIGINAL;
    L8:
        Object r14 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L22;
        if (r4 == 1) goto L17;
        if (r4 != 2) goto L16;
        UplinkFileEntity r15 = (UplinkFileEntity) r1.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L20
    L45:
        return r14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        UplinkFileEntity r16 = (UplinkFileEntity) r1.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L20
    L39:
        return r14;
    L22:
        ResultKt.throwOnFailure(r14);
        if (r9 != null) goto L25;
    L48:
        Log.e("FlowMediaCompressHelper", "compress context or localPath is empty");
        return null;
    L25:
        if (r11.length() != 0) goto L27;
        boolean r17 = true;
    L28:
        if (r17 == true) goto L48;
        if (new PolarisFileWrapper(r11).exists() == true) goto L35;
        Log.e("FlowMediaCompressHelper", "compress localPath file not exists: " + r11);     // Catch: Throwable -> L20
        return null;
    L35:
        if (wxa.f.d(r10) == false) goto L41;
        r1.L$0 = r10;     // Catch: Throwable -> L20
        r1.label = 1;     // Catch: Throwable -> L20
        r14 = BuildersKt.withContext(Dispatchers.getIO(), new FlowMediaCompressHelper$compressImage$2(r11, r9, null), r1);     // Catch: Throwable -> L20
        if (r14 != r3) goto L39;
        return r3;
    L41:
        if (wxa.f.e(r10) == false) goto L47;
        r1.L$0 = r10;     // Catch: Throwable -> L20
        r1.label = 2;     // Catch: Throwable -> L20
        r14 = BuildersKt.withContext(Dispatchers.getIO(), new FlowMediaCompressHelper$compressVideo$2(r11, r10, r12, null), r1);     // Catch: Throwable -> L20
        if (r14 != r3) goto L45;
        return r3;
    L47:
        return null;
    L27:
        r17 = false;
    L20:
        th = move-exception;
        Log.e("FlowMediaCompressHelper", "compress error, entity: " + r10 + ", message: " + th.getMessage());
    L7:
        r1 = new FlowMediaCompressHelper$compress$1(this, r13);
        goto L8
    }
}
