package com.lynx.canvas.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.larus.utils.logger.FLogger;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonLoaderService;
import com.obric.assistant.network.okhttp.a;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CanvasResourceLoader {
    private static final String TAG = "KryptonCanvasResourceLoader";
    WeakReference<KryptonApp> mWeakKryptonApp;

    private KryptonLoaderService getLoaderService() {
        KryptonApp r0 = this.mWeakKryptonApp.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return (KryptonLoaderService) r0.getService(KryptonLoaderService.class);
    }

    public CanvasResourceLoader(KryptonApp r2) {
        this.mWeakKryptonApp = new WeakReference(r2);
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_lynx_canvas_loader_CanvasResourceLoader_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        a.b(a.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r7.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private KryptonLoaderService.LoadPolicy parseLoadPolicy(int r3) {
        KryptonLoaderService.LoadPolicy[] r0 = KryptonLoaderService.LoadPolicy.values();
        if (r3 < 0) goto L10;
        if (r3 >= r0.length) goto L10;
        return r0[r3];
    L10:
        return KryptonLoaderService.LoadPolicy.DEFAULT_ASYNC;
    }

    public Bitmap decodeDataURLSync(String r6) {
        if (r6.startsWith("data:") == true) goto L5;
    L15:
        KryptonLLog.e(TAG, "decode DataURL failed, not data url");
        return null;
    L5:
        if (r6.indexOf("base64,") == (-1)) goto L15;
        byte[] r7 = Base64.decode(r6.substring(r6.indexOf("base64,") + 7), 0);     // Catch: Exception -> L9
        Bitmap r8 = BitmapFactory.decodeByteArray(r7, 0, r7.length);     // Catch: Exception -> L9
    L11:
        if (r8 != null) goto L14;
        KryptonLLog.e(TAG, "decode data url failed, bitmap = null ");
        return null;
    L14:
        return r8;
    L9:
        e = move-exception;
        KryptonLLog.e(TAG, "decode data url failed, throw exception " + e);
        r8 = null;
        goto L11
    }

    public Bitmap loadImageSync(String r5) {
        if (r5 != null) goto L6;
        KryptonLLog.e(TAG, "url empty");
        return null;
    L6:
        KryptonLoaderService r2 = getLoaderService();
        if (r2 != null) goto L10;
        KryptonLLog.e(TAG, "loaderService not found");
        return null;
    L10:
        byte[] r6 = r2.loadUrlSync(r5);
        if (r6 != null) goto L14;
        KryptonLLog.e(TAG, "loadUrlSync return null");
        return null;
    L14:
        Bitmap r7 = BitmapFactory.decodeByteArray(r6, 0, r6.length);
        if (r7 != null) goto L18;
        KryptonLLog.e(TAG, "loadImageSync failed, bitmap = null ");
        return null;
    L18:
        return r7;
    }

    public void onGetSupportedExtensions(String[] r2) {
        KryptonLoaderService r0 = getLoaderService();
        if (r0 == null) goto L6;
        r0.onGetSupportedExtensions(r2);
        return;
    }

    public String redirectUrl(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        KryptonLoaderService r0 = getLoaderService();
        if (r0 == null) goto L10;
        String r1 = r0.redirectUrl(r2);
        if (r1 == null) goto L10;
        return r1;
    L10:
        return r2;
    }

    public void loadImage(String r2, long r3) {
        final CanvasResourceResolver r0 = new CanvasResourceResolver(r3, r2);
        if (r2 != null) goto L6;
        rejectWithErrorMessage("url empty", r0, false);
        return;
    L6:
        KryptonLoaderService r4 = getLoaderService();
        if (r4 != null) goto L10;
        rejectWithErrorMessage("loaderService not found", r0, false);
        return;
    L10:
        r4.loadUrlWithImageResolver(r2, new AnonymousClass1(this, r0));
    }

    private void rejectWithErrorMessage(String r2, CanvasResourceResolver r3, boolean r4) {
        KryptonLLog.e(TAG, r2);
        if (r4 == false) goto L5;
        r3.resolveStreamLoadEnd(false, r2);
        return;
    L5:
        r3.reject(r2);
    }

    private void streamLoadAssets(String r2, final CanvasResourceResolver r3, KryptonLoaderService r4) {
        r4.loadUrlWithStreamDelegate(r2, new AnonymousClass5(this, r3));
    }

    public void loadAssets(String r8, long r9, boolean r11) {
        loadAssetsWithPolicy(r8, r9, r11, KryptonLoaderService.LoadPolicy.DEFAULT_ASYNC.ordinal());
    }

    public static /* synthetic */ void access$000(CanvasResourceLoader r0, String r1, CanvasResourceResolver r2, boolean r3) {
        r0.rejectWithErrorMessage(r1, r2, r3);
    }

    public void loadAssetsWithPolicy(String r5, long r6, final boolean r8, int r9) {
        final CanvasResourceResolver r0 = new CanvasResourceResolver(r6, r5);
        if (r5 != null) goto L6;
        KryptonLLog.e(TAG, "Url is required!");
        rejectWithErrorMessage("url empty", r0, r8);
        return;
    L6:
        KryptonLoaderService r7 = getLoaderService();
        if (r7 != null) goto L10;
        KryptonLLog.e(TAG, "Loader service not founded!");
        rejectWithErrorMessage("loaderService not found", r0, r8);
        return;
    L10:
        if (r8 == true) goto L16;
    L14:
        KryptonLoaderService.LoadPolicy r10 = parseLoadPolicy(r9);
        KryptonLLog.i(TAG, "[readFilePreferCurrentThread] loadAssetsWithPolicy enter, policy=" + r10 + ", streamLoad=" + r8 + ", url=" + KryptonResourceUtils.getTruncatePath(r5) + ", thread=" + ThreadMethodProxy.currentThread().getName());
        StringBuilder r1 = new StringBuilder("[readFilePreferCurrentThread] dispatch to loaderService=");
        r1.append(r7.getClass().getSimpleName());
        r1.append(", policy=");
        r1.append(r10);
        KryptonLLog.i(TAG, r1.toString());
        r7.loadUrlWithDataResolverWithPolicy(r5, new AnonymousClass3(this, r0, r8), r10);
        return;
    L16:
        KryptonLLog.i(TAG, "Load stream assets.");     // Catch: UnsupportedOperationException -> L13
        streamLoadAssets(r5, r0, r7);     // Catch: UnsupportedOperationException -> L13
        return;
    L13:
        KryptonLLog.i(TAG, "do not support stream load");
        goto L14
    }

    public void loadImageWithOptions(String r4, boolean r5, boolean r6, long r7) {
        final CanvasResourceResolver r2 = new CanvasResourceResolver(r7, r4);
        if (r4 != null) goto L5;
    L16:
        rejectWithErrorMessage("url empty", r2, false);
        return;
    L5:
        if (r4.isEmpty() == true) goto L16;
        KryptonLoaderService r8 = getLoaderService();
        if (r8 != null) goto L11;
        rejectWithErrorMessage("loaderService not found", r2, false);
        return;
    L11:
        KryptonLoaderService.ImageResolver r9 = new AnonymousClass2(this, r2);
        KryptonLoaderService.ImageLoadOptions r3 = new KryptonLoaderService.ImageLoadOptions(r5, r6);
        KryptonLLog.i(TAG, "loadImageWithOptions " + r4 + " " + r3);     // Catch: UnsupportedOperationException -> L14
        r8.loadImageWithOptions(r4, r3, r9);     // Catch: UnsupportedOperationException -> L14
        return;
    L14:
        KryptonLLog.e(TAG, "loadImageWithOptions not supported, fallback to loadUrlWithImageResolver ".concat(r4));
        r8.loadUrlWithImageResolver(r4, r9);
    }

    public byte[] encodeBitmap(ByteBuffer r3, int r4, int r5, int r6, float r7) {
        if (r4 != 0) goto L6;
        Bitmap.CompressFormat r8 = Bitmap.CompressFormat.PNG;
    L8:
        Bitmap r1 = Bitmap.createBitmap(r5, r6, Bitmap.Config.ARGB_8888);
        r1.copyPixelsFromBuffer(r3);
        ByteArrayOutputStream r9 = new ByteArrayOutputStream(((r5 * r6) / 4) + 256);
        if (r1.compress(r8, Math.round(r7 * 100.0f), r9) == true) goto L11;
    L12:
        return null;
    L11:
        return r9.toByteArray();
    L6:
        if (r4 != 1) goto L12;
        r8 = Bitmap.CompressFormat.JPEG;
        goto L8
    }

    public void loadAssetsRange(String r9, final int r10, final int r11, long r12, final boolean r14) {
        final CanvasResourceResolver r4 = new CanvasResourceResolver(r12, r9);
        if (r9 != null) goto L6;
        KryptonLLog.e(TAG, "Url is required!");
        rejectWithErrorMessage("url empty", r4, r14);
        return;
    L6:
        KryptonLoaderService r13 = getLoaderService();
        if (r13 != null) goto L10;
        KryptonLLog.e(TAG, "Loader service not founded!");
        rejectWithErrorMessage("loaderService not found", r4, r14);
        return;
    L10:
        if (r11 >= r10) goto L14;
        KryptonLLog.e(TAG, "end less than start!");
        rejectWithErrorMessage("end less than start", r4, r14);
        return;
    L14:
        if (r9.startsWith("asset") == false) goto L30;
        r13.loadUrlWithDataResolver(r9, new AnonymousClass4(this, r4, r10, r11, r14));
        return;
    L30:
        HttpURLConnection r15 = (HttpURLConnection) INVOKEVIRTUAL_com_lynx_canvas_loader_CanvasResourceLoader_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r9));     // Catch: IOException -> L28
        r15.setRequestMethod("GET");     // Catch: IOException -> L28
        r15.setRequestProperty("Range", "bytes=" + r10 + "-" + r11);     // Catch: IOException -> L28
        r15.connect();     // Catch: IOException -> L28
        int r16 = r15.getResponseCode();     // Catch: IOException -> L28
        if (r16 != 206) goto L25;
        BufferedInputStream r17 = new BufferedInputStream(r15.getInputStream());     // Catch: IOException -> L28
        ByteArrayOutputStream r18 = new ByteArrayOutputStream();     // Catch: IOException -> L28
        byte[] r19 = new byte[1024];     // Catch: IOException -> L28
    L21:
        int r110 = r17.read(r19);     // Catch: IOException -> L28
        if (r110 == (-1)) goto L24;
        r18.write(r19, 0, r110);     // Catch: IOException -> L28
        goto L21
    L24:
        r4.resolve(r18.toByteArray(), 0, r18.toByteArray().length);     // Catch: IOException -> L28
        r18.close();     // Catch: IOException -> L28
        r17.close();     // Catch: IOException -> L28
    L26:
        r15.disconnect();     // Catch: IOException -> L28
        return;
    L25:
        r4.reject("load failed " + r16);     // Catch: IOException -> L28
    L28:
        rejectWithErrorMessage("load from net failed", r4, false);
    }

    public byte[] overrideTextureUpload(int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, int r37, long r38, long r40, int r42, long r43, ByteBuffer r45) {
        KryptonLoaderService r0 = getLoaderService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.overrideTextureUpload(new KryptonLoaderService.TextureUploadRequest(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r40, r42, r43, r45));
    }
}
