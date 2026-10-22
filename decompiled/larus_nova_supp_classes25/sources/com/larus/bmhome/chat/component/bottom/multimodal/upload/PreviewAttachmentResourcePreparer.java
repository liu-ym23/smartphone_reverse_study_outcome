package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.api.z3;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.platform.model.preview.ResourceRefKind;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PreviewAttachmentResourcePreparer {
    public static final PreviewAttachmentResourcePreparer a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceRefKind.values().length];
            r0[ResourceRefKind.LOCAL_URI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ResourceRefKind.REMOTE_URL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements Function1<String, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<String> a;

        public b(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            String r3 = (String) r2;
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r3));
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
        a = new PreviewAttachmentResourcePreparer();
    }

    public PreviewAttachmentResourcePreparer() {
    }

    public static String b(MediaMetadataRetriever r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {12};
        f06.b r12 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r16 = r7;
        int r17 = r8;
        f06.a[] r18 = r9;
        f06.d r4 = r6.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r19, r1, "java.lang.String", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r19.extractMetadata(12);
    L14:
        r7 = r16 + 1;
        r8 = r17;
        r9 = r18;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static final Uri a(PolarisFileWrapper r7, UplinkFileEntity r8) {
        Uri r0 = Uri.fromFile(r7);
        if (n1.e(r8) == false) goto L23;
        ImFileUtil.a.getClass();
        if (ImFileUtil.y(r0) == true) goto L28;
        MediaMetadataRetriever r9 = new MediaMetadataRetriever();
        r9.setDataSource(r7.getAbsolutePath());     // Catch: Throwable -> L20
        String r1 = b(r9);     // Catch: Throwable -> L20
        r9.release();
        boolean r2 = false;
        if (r1 != null) goto L12;
    L14:
        if (r2 == false) goto L26;
        String r3 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r1);
        if (r3 == null) goto L26;
        PolarisFileWrapper r10 = new PolarisFileWrapper(AppHost.a.getApplication().getCacheDir(), "preview_video_" + UUID.randomUUID() + '.' + r3);
        FilesKt.copyTo$default(r7, r10, false, 0, 6, null);
        return Uri.fromFile(r10);
    L26:
        return null;
    L12:
        if (StringsKt.startsWith$default(r1, "video/", false, 2, null) != true) goto L14;
        r2 = true;
    L20:
        th = move-exception;
        r9.release();
        throw th;
    L28:
        return r0;
    L23:
        return r0;
    }

    public final Object c(UplinkFileEntity r5, Continuation<? super Uri> r6) {
        if ((r6 instanceof PreviewAttachmentResourcePreparer$localUri$1) == false) goto L7;
        PreviewAttachmentResourcePreparer$localUri$1 r0 = (PreviewAttachmentResourcePreparer$localUri$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L18;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L13 CancellationException -> L15
    L23:
    L30:
        return (Uri) r7;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;     // Catch: Exception -> L13 CancellationException -> L15
        r7 = d(r5, r0);     // Catch: Exception -> L13 CancellationException -> L15
        if (r7 != r2) goto L23;
        return r2;
    L15:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        FLogger.a.w("PreviewAttachmentResource", "prepare failed: ".concat(e.getClass().getSimpleName()));
        return null;
    L7:
        r0 = new PreviewAttachmentResourcePreparer$localUri$1(this, r6);
        goto L8
    }

    public final Object d(UplinkFileEntity r10, Continuation<? super Uri> r11) {
        if ((r11 instanceof PreviewAttachmentResourcePreparer$resolveLocalUri$1) == false) goto L7;
        PreviewAttachmentResourcePreparer$resolveLocalUri$1 r0 = (PreviewAttachmentResourcePreparer$resolveLocalUri$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        ResultKt.throwOnFailure(r12);
    L60:
        return (Uri) r12;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = (UplinkFileEntity) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L46:
        String r13 = (String) r12;
    L48:
        CoroutineDispatcher r4 = Dispatchers.getIO();
        PreviewAttachmentResourcePreparer$resolveLocalUri$localUri$1 r5 = new PreviewAttachmentResourcePreparer$resolveLocalUri$localUri$1(r13, r10, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 4;
        r12 = BuildersKt.withContext(r4, r5, r0);
        if (r12 != r2) goto L60;
        return r2;
    L18:
        ResourceRef r14 = (ResourceRef) r0.L$1;
        r10 = (UplinkFileEntity) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L38:
        r13 = (String) r12;
        goto L48
    L19:
        ResultKt.throwOnFailure(r12);
    L59:
        return r12;
    L20:
        ResultKt.throwOnFailure(r12);
        Uri r15 = r10.getUri();
        if (r15 == null) goto L23;
        String r16 = r15.toString();
    L24:
        ResourceRef r17 = dr9.a.c(r16, 0, 0, 14);
        if (r17 != null) goto L27;
        return null;
    L27:
        int r6 = a.a[r17.getKind().ordinal()];
        if (r6 == 1) goto L52;
        if (r6 == 2) goto L32;
        return null;
    L32:
        if (n1.d(r10) == false) goto L40;
        r0.L$0 = r10;
        r0.L$1 = r17;
        r0.label = 2;
        kotlinx.coroutines.j r7 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r7.C();
        ImageSave.j(ImageSave.a, r17.getUri(), "preview_attachment_" + UUID.randomUUID(), new b(r7));
        r12 = r7.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L36:
        if (r12 != r2) goto L38;
        return r2;
    L40:
        if (n1.e(r10) == false) goto L47;
        Lazy r8 = q3.a;
        z3 r9 = q3.a();
        if (r9 == null) goto L47;
        String r18 = r17.getUri();
        String r19 = UUID.nameUUIDFromBytes(r17.getUri().getBytes(Charsets.UTF_8)).toString();
        r0.L$0 = r10;
        r0.label = 3;
        r12 = r9.h(r18, r19, r0);
        if (r12 != r2) goto L46;
        return r2;
    L47:
        r13 = null;
        goto L48
    L52:
        String r20 = dr9.a.a(r17);
        if (r20 == null) goto L55;
        CoroutineDispatcher r110 = Dispatchers.getIO();
        PreviewAttachmentResourcePreparer$resolveLocalUri$2 r21 = new PreviewAttachmentResourcePreparer$resolveLocalUri$2(r20, r10, null);
        r0.label = 1;
        r12 = BuildersKt.withContext(r110, r21, r0);
        if (r12 != r2) goto L59;
        return r2;
    L55:
        return UriProtector.parse(r17.getUri());
    L23:
        r16 = null;
    L7:
        r0 = new PreviewAttachmentResourcePreparer$resolveLocalUri$1(this, r11);
        goto L8
    }
}
