package com.larus.uaigc.helper;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0018\u001a\u00020\u000b*\u0004\u0018\u00010\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/larus/uaigc/helper/CreationImageRemoteDownloadHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveRemoteFallbackLocalPath", "url", "fallbackLocalPath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadByImageSave", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decodeRemoteImageToLocalPath", "isUploadableImagePath", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationImageRemoteDownloadHandler implements ResourceNodeHandler {
    public final String a;
    public final String b;

    public final void getPriority() {
    }

    public CreationImageRemoteDownloadHandler() {
        this.a = "creation_image_remote_download";
        this.b = "remote_download";
    }

    public final String a() {
        return this.b;
    }

    public final String getKey() {
        return this.a;
    }

    public static boolean e(String r5) {
        if (r5 == null) goto L22;
        boolean r2 = true;
        String r3 = null;
        if ((!StringsKt.isBlank(r5)) == true) goto L8;
        r5 = null;
    L8:
        if (r5 != null) goto L11;
        return false;
    L11:
        if (new PolarisFileWrapper(r5).exists() == true) goto L13;
        return false;
    L13:
        String r6 = StringsKt.substringAfterLast(r5, '.', "").toLowerCase(Locale.ROOT);
        if (r6.length() > 0) goto L17;
        r2 = false;
    L17:
        if (r2 == false) goto L19;
        r3 = r6;
    L19:
        if (r3 != null) goto L21;
        return false;
    L21:
        return i.a.contains(r3);
    L22:
        return false;
    }

    public final boolean b(com.larus.bmhome.resource.access.h0 r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (a0.b(r4) == false) goto L13;
        com.larus.bmhome.resource.access.w r0 = r4.a;
        if (r0.c != ResourceMediaType.IMAGE) goto L13;
        if (r0.d.k.e == false) goto L13;
        if (r4.h != null) goto L13;
        if ((r4.c instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final Object c(com.larus.bmhome.resource.access.h0 r25, Continuation<? super com.larus.bmhome.resource.access.g> r26) {
        if ((r26 instanceof CreationImageRemoteDownloadHandler$execute$1) == false) goto L7;
        CreationImageRemoteDownloadHandler$execute$1 r3 = (CreationImageRemoteDownloadHandler$execute$1) r26;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        com.larus.bmhome.resource.access.j0.c r1 = (com.larus.bmhome.resource.access.j0.c) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L25:
        String r7 = (String) r2;
        if (r7 != null) goto L28;
    L31:
        boolean r8 = true;
    L32:
        if (r8 == true) goto L34;
        File r9 = new PolarisFileWrapper(r7);
        String r10 = r1.b;
        Boolean r11 = Boxing.boxBoolean(false);
        if (r9.exists() == false) goto L38;
        File r12 = r9;
    L39:
        if (r12 == null) goto L41;
        Long r13 = Boxing.boxLong(r12.length());
    L42:
        com.larus.bmhome.resource.access.j0.b r15 = new com.larus.bmhome.resource.access.j0.b(r7, r10, r11, r13, 16);
        if (r9.exists() == true) goto L46;
        r9 = null;
    L46:
        if (r9 == null) goto L48;
        Long r17 = Boxing.boxLong(r9.length());
    L49:
        String r14 = StringsKt.substringAfterLast(r7, '.', "");
        if (r14.length() <= 0) goto L52;
        boolean r16 = true;
    L53:
        if (r16 == false) goto L55;
        String r19 = r14;
    L57:
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(r15, null, r17, null, r19, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("remote_fallback", CreationRemoteFallbackState.DOWNLOAD.getValue()), TuplesKt.to("remote_fallback_path", r7)}), 42));
    L55:
        r19 = null;
        goto L57
    L52:
        r16 = false;
        goto L53
    L48:
        r17 = null;
        goto L49
    L41:
        r13 = null;
        goto L42
    L38:
        r12 = null;
        goto L39
    L34:
        return new com.larus.bmhome.resource.access.g.b(new com.larus.bmhome.resource.access.r(this.b, "remote_download_failed", "remote image download failed", null));
    L28:
        if (StringsKt.isBlank(r7) == true) goto L31;
        r8 = false;
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        com.larus.bmhome.resource.access.j0.c r18 = r25.c;
        if ((r18 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L17;
        com.larus.bmhome.resource.access.j0.c r20 = r18;
    L18:
        if (r20 == null) goto L20;
        String r21 = r20.b;
        String r22 = (String) r25.a.d.n.get("remote_detect_local_path");
        r3.L$0 = r20;
        r3.label = 1;
        Object r23 = f(r21, r22, r3);
        if (r23 != r5) goto L24;
        return r5;
    L24:
        com.larus.bmhome.resource.access.j0.c r24 = r20;
        r2 = r23;
        r1 = r24;
        goto L25
    L20:
        return com.larus.bmhome.resource.access.g.e.a;
    L17:
        r20 = null;
    L7:
        r3 = new CreationImageRemoteDownloadHandler$execute$1(this, r26);
        goto L8
    }

    public final Object d(String r9, Continuation<? super String> r10) {
        if ((r10 instanceof CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1) == false) goto L7;
        CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1 r1 = (CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1) r10;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r11 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        String r6 = null;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        CloseableReference r12 = (CloseableReference) r1.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L15
    L38:
        File r13 = (File) r11;     // Catch: Throwable -> L15
        if (r13 != null) goto L41;
    L46:
        CloseableReference.closeSafely(r12);
        return r6;
    L41:
        if (r13.exists() == true) goto L44;
        r13 = null;
    L44:
        if (r13 == null) goto L46;
        r6 = r13.getAbsolutePath();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableReference r14 = r12;
        th = th;
    L52:
        CloseableReference.closeSafely(r14);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r11);
    L23:
        r14 = (CloseableReference) r11;
        if (r14 != null) goto L54;
        return null;
    L54:
        Object r15 = r14.get();     // Catch: Throwable -> L51
        if ((r15 instanceof CloseableStaticBitmap) == false) goto L29;
        CloseableStaticBitmap r16 = (CloseableStaticBitmap) r15;     // Catch: Throwable -> L51
    L30:
        if (r16 == null) goto L49;
        Bitmap r17 = r16.getUnderlyingBitmap();     // Catch: Throwable -> L51
        if (r17 == null) goto L49;
        String r0 = "remote_fallback_" + UUID.randomUUID() + ".jpeg";     // Catch: Throwable -> L51
        r1.L$0 = r14;     // Catch: Throwable -> L51
        r1.label = 2;     // Catch: Throwable -> L51
        Object r18 = BitmapHelperKt.f(r17, r0, r1);     // Catch: Throwable -> L51
        if (r18 != r3) goto L37;
        return r3;
    L37:
        r11 = r18;
        r12 = r14;
    L49:
        CloseableReference.closeSafely(r14);
        return null;
    L29:
        r16 = null;
    L51:
        th = th;
        goto L52
    L20:
        ResultKt.throwOnFailure(r11);
        Function1 r19 = new o();
        r1.label = 1;
        r11 = ImageLoaderKt.i(r9, "creation_remote_fallback", r19, r1, 28);
        if (r11 != r3) goto L23;
        return r3;
    L7:
        r1 = new CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1(this, r10);
        goto L8
    }

    public final Object f(String r8, String r9, Continuation<? super String> r10) {
        if ((r10 instanceof CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1) == false) goto L7;
        CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1 r0 = (CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L42:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (String) r0.L$1;
        r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        String r12 = (String) r11;
        if (e(r12) == false) goto L25;
        return r12;
    L25:
        if (r12 == null) goto L33;
        if ((true ^ StringsKt.isBlank(r12)) == true) goto L30;
        r12 = null;
    L30:
        if (r12 == null) goto L33;
        FLogger.a.i("CreationImageNodeHandlers", "[remoteDownload] image cache path cannot preprocess, path=".concat(r12));
    L33:
        if (e(r9) == true) goto L36;
        r9 = null;
    L36:
        if (r9 == null) goto L39;
        FLogger.a.i("CreationImageNodeHandlers", "[remoteDownload] use fallback local path, path=".concat(r9));
        return r9;
    L39:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r11 = d(r8, r0);
        if (r11 != r2) goto L42;
        return r2;
    L16:
        ResultKt.throwOnFailure(r11);
        r0.L$0 = r8;
        r0.L$1 = r9;
        r0.label = 1;
        kotlinx.coroutines.j r13 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r13.C();
        ImageSave r4 = ImageSave.a;
        p r5 = new p(r13);
        r4.getClass();
        ImageSave.m(r8, r5);
        r11 = r13.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L19:
        if (r11 != r2) goto L21;
        return r2;
    L7:
        r0 = new CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1(this, r10);
        goto L8
    }
}
