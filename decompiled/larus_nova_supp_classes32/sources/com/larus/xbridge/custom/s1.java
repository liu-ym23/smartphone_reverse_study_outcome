package com.larus.xbridge.custom;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.util.Base64;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.canvas.camera.CameraSize;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.UUID;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s1 extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "media.getVideoThumbnail";
    }

    public s1() {
    }

    public static final Object f(s1 r11, String r12, Continuation r13) {
        r11.getClass();
        if ((r13 instanceof MediaGetVideoThumbnailMethod$getVideoFrameBase64$1) == false) goto L7;
        MediaGetVideoThumbnailMethod$getVideoFrameBase64$1 r1 = (MediaGetVideoThumbnailMethod$getVideoFrameBase64$1) r13;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r14 = r1.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        File r16 = (File) r1.L$1;
        Bitmap r17 = (Bitmap) r1.L$0;
        ResultKt.throwOnFailure(r14);
    L39:
        ByteArrayOutputStream r18 = new ByteArrayOutputStream();
        if (r17 == null) goto L42;
        Boxing.boxBoolean(r17.compress(Bitmap.CompressFormat.PNG, 100, r18));
    L42:
        byte[] r19 = Base64.encode(r18.toByteArray(), 0);
        r18.close();
        Intrinsics.checkNotNull(r19);
        return new Pair(new String(r19, Charsets.UTF_8), r16.getAbsolutePath());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        int r110 = l4a.a.a;
        String r111 = l4a.a.a(AppHost.a.getApplication(), UriProtector.parse(r12));
        MediaMetadataRetriever r4 = new MediaMetadataRetriever();     // Catch: Exception -> L17
        r4.setDataSource(r111);     // Catch: Exception -> L17
        Bitmap r112 = r4.getFrameAtTime();     // Catch: Exception -> L17
    L19:
        if (r112 == null) goto L44;
        int r5 = r112.getWidth();
        int r6 = r112.getHeight();
        float r7 = Math.max(r5, r6);
        float r8 = Math.min(r5, r6);
        if (r7 > 0.0f) goto L23;
    L25:
        float r9 = 1.0f;
    L27:
        if (r112.isRecycled() == false) goto L29;
    L35:
        Intrinsics.checkNotNullParameter("png", "formatSuffix");
        File r0 = aa9.a.a.d("thumbnail", "image_" + UUID.randomUUID() + ".png");
        r1.L$0 = r112;
        r1.L$1 = r0;
        r1.label = 1;
        if (BuildersKt.withContext(Dispatchers.getIO(), new MediaGetVideoThumbnailMethod$convertImageToJpeg$2(r0, r112, null), r1) == r15) goto L50;
        r17 = r112;
        r16 = r0;
        goto L39
    L50:
        return r15;
    L29:
        if (r9 <= 1.0f) goto L35;
        Matrix r10 = new Matrix();     // Catch: Exception -> L33
        float r20 = 1.0f / r9;     // Catch: Exception -> L33
        r10.setScale(r20, r20);     // Catch: Exception -> L33
        Bitmap r21 = Bitmap.createBitmap(r112, 0, 0, r112.getWidth(), r112.getHeight(), r10, true);     // Catch: Exception -> L33
        r21.setConfig(com.larus.utils.z0.b(r112.getConfig()));     // Catch: Exception -> L33
        r112 = r21;
    L33:
        e = move-exception;
        FLogger.a.e("MediaGetVideoThumbnailMethod", "compressBitmapByMatrix error: " + e.getMessage());
        goto L35
    L23:
        if (r8 <= 0.0f) goto L25;
        float r22 = CameraSize.mediumWidth;
        r9 = Math.max(Math.max(r7 / r22, r8 / r22), 1.0f);
        goto L27
    L44:
        return null;
    L17:
        e = move-exception;
        FLogger.a.e("MediaGetVideoThumbnailMethod", "getVideoFrameBase64 error: " + e.getMessage());
        r112 = null;
    L7:
        r1 = new MediaGetVideoThumbnailMethod$getVideoFrameBase64$1(r11, r13);
        goto L8
    }

    public final void a(dx7.b r8, ux7.d.d r9, IvyBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "type");
        String r11 = cx7.a.d(r8, "filePath", NameKeys.UnloadStrategy_No_Strategy);
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L13;
        bx7.c.c(this, r9, -3, null, 12);
        return;
    L13:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new MediaGetVideoThumbnailMethod$handle$1(this, r11, r9, null), 2, null);
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L10
    }
}
