package com.lynx.canvas;

import android.graphics.Bitmap;
import com.lynx.canvas.loader.KryptonResourceUtils;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.service.ILynxImageService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f8a.a;
import i8a.n;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import v7a.f;
import v7a.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxKryptonLoaderServiceImpl extends KryptonLoaderService {
    private static final String ASSETS2_PREFIX = "assets://";
    private static final String ASSETS_PREFIX = "assets:///";
    private static final String ASSET_PREFIX = "asset:///";
    private static final String TAG = "LynxKryptonLoaderServiceImpl";
    private final WeakReference<LynxContext> mLynxContextWeak;
    private ILynxImageService mLynxImageService;

    public static class LoaderResolver {
        private final KryptonLoaderService.DataResolver dataResolver;
        private final KryptonLoaderService.StreamDelegate streamDelegate;

        public boolean hasStreamDelegate() {
            if (this.streamDelegate == null) goto L5;
            return true;
        L5:
            return false;
        }

        public static /* synthetic */ KryptonLoaderService.StreamDelegate access$200(LoaderResolver r0) {
            return r0.streamDelegate;
        }

        public void reject(String r2) {
            KryptonLoaderService.StreamDelegate r0 = this.streamDelegate;
            if (r0 == null) goto L5;
            r0.onError(r2);
            return;
        L5:
            KryptonLoaderService.DataResolver r1 = this.dataResolver;
            if (r1 == null) goto L10;
            r1.reject(r2);
            return;
        }

        public LoaderResolver(KryptonLoaderService.DataResolver r1, KryptonLoaderService.StreamDelegate r2) {
            this.dataResolver = r1;
            this.streamDelegate = r2;
        }

        public void resolve(byte[] r2, int r3, int r4) {
            KryptonLoaderService.StreamDelegate r5 = this.streamDelegate;
            if (r5 == null) goto L5;
            r5.onStart(r2.length);
            this.streamDelegate.onData(r2, 0, r2.length);
            this.streamDelegate.onEnd();
            return;
        L5:
            KryptonLoaderService.DataResolver r6 = this.dataResolver;
            if (r6 == null) goto L10;
            r6.resolve(r2, 0, r2.length);
            return;
        }
    }

    @Override // com.lynx.canvas.KryptonService
    public void onBootstrap(KryptonApp r1) {
    }

    @Override // com.lynx.canvas.KryptonService
    public void onDestroy() {
    }

    private a getLynxGenericResourceFetcher() {
        LynxContext r0 = this.mLynxContextWeak.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getGenericResourceFetcher();
    }

    private ILynxImageService getLynxImageService() {
        if (this.mLynxImageService != null) goto L6;
        this.mLynxImageService = (ILynxImageService) n.c().a(ILynxImageService.class);
    L6:
        return this.mLynxImageService;
    }

    private g8a.a getLynxMediaResourceFetcher() {
        LynxContext r0 = this.mLynxContextWeak.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getMediaResourceFetcher();
    }

    public LynxKryptonLoaderServiceImpl(WeakReference<LynxContext> r1) {
        this.mLynxContextWeak = r1;
    }

    private String getCompatiblePath(String r4) {
        if (r4.startsWith(ASSETS_PREFIX) == false) goto L6;
        return r4.replace(ASSETS_PREFIX, ASSET_PREFIX);
    L6:
        if (r4.startsWith(ASSETS2_PREFIX) == true) goto L8;
        return r4;
    L8:
        return r4.replace(ASSETS2_PREFIX, ASSET_PREFIX);
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public byte[] loadUrlSync(String r4) {
        return KryptonResourceUtils.decodeDataURI(r4);
    L4:
        e = move-exception;
        KryptonLLog.e(TAG, "loadUrlSync with error message: " + e.getMessage() + " ,the url is: " + KryptonResourceUtils.getTruncatePath(r4));
        return null;
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public String redirectUrl(String r6) {
        String r0 = KryptonResourceUtils.getTruncatePath(r6);
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r1 = new HashMap();
        r1.put(LynxEventReporter.PROP_NAME_URL, r0);
        TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL, r1);
    L5:
        String r7 = getCompatiblePath(r6);
        if (KryptonResourceUtils.isLocalPath(r7) == false) goto L8;
    L22:
        KryptonLLog.e(TAG, "Local, content or base64 path redirect with original url: " + r0);
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
        return r7;
    L8:
        if (KryptonResourceUtils.isContentURI(r7) == true) goto L22;
        if (KryptonResourceUtils.isDataURI(r7) == true) goto L22;
        g8a.a r2 = getLynxMediaResourceFetcher();
        if (r2 == null) goto L20;
        String r3 = r2.c(new LynxResourceRequest(r7, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage));
        if (r3 == null) goto L18;
        KryptonLLog.i(TAG, "Redirect URL with LynxMediaResourceFetcher, the original url: " + r7 + " redirected url: " + r3);
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
        return r3;
    L18:
        KryptonLLog.e(TAG, "Redirect URL with LynxMediaResourceFetcher return null url,  redirected url: " + r3);
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
        return r7;
    L20:
        KryptonLLog.e(TAG, "Redirect URL: " + r7 + " failed because there is no LynxMediaResourceFetcher existed.");
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
        return r7;
    }

    private void handleBase64Image(final String r3, final KryptonLoaderService.ImageResolver r4) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new AnonymousClass3(this, r3, r4));
    }

    private void handleImageWithLynxImageService(final String r3, final KryptonLoaderService.ImageResolver r4) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new AnonymousClass7(this, r3, r4));
    }

    private void handleLocalPathResource(String r6, LoaderResolver r7) {
        KryptonLLog.i(TAG, "Handle local path resource: " + r6);
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r0 = new HashMap();
        r0.put(SVGRenderEngine.PATH, r6);
        TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_LOCAL_PATH_RESOURCE, r0);
    L5:
        InputStream r1 = KryptonResourceUtils.loadResourceFromLocalPath(r6);
        if (r1 == null) goto L15;
        KryptonLLog.i(TAG, "Handle local path resource success, the resource path : " + r6);
    L13:
        e = move-exception;
        String r8 = "Handle local path resource with exception: " + e.toString() + " url: " + r6;
        KryptonLLog.e(TAG, r8);
        r7.reject(r8);
    L16:
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_LOCAL_PATH_RESOURCE);
        return;
    L9:
        if (r7.hasStreamDelegate() == false) goto L11;
        handleStreamWithDelegate(r6, r1, r1.available(), r7);     // Catch: Exception -> L13
    L18:
        goto L16
    L11:
        HandleStreamWithResolver(r6, r1, r1.available(), r7);     // Catch: Exception -> L13
        goto L18
    L15:
        String r9 = "Handle local path resource failed.  path: " + r6;
        KryptonLLog.e(TAG, r9);
        r7.reject(r9);
        goto L16
    }

    private void handleNormalDataLoader(final String r3, final LoaderResolver r4) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new AnonymousClass5(this, r3, r4));
    }

    private void loadImageRawDataAndDecodeWithBitmapFactory(final String r4, final KryptonLoaderService.ImageResolver r5) {
        if (KryptonResourceUtils.isDataURI(r4) == false) goto L6;
        KryptonLLog.i(TAG, "Handle base64 type image with url: " + KryptonResourceUtils.getTruncatePath(r4));
        handleBase64Image(r4, r5);
        return;
    L6:
        KryptonLoaderService.DataResolver r0 = new AnonymousClass2(this, r4, r5);
        KryptonLLog.i(TAG, "Load raw data of image and decode it with BitmapFactory, the url: " + r4);
        handleNormalDataLoader(r4, new LoaderResolver(r0, null));
    }

    private void loadImageWithLynxImageServiceImpl(String r5, final KryptonLoaderService.ImageResolver r6) {
        final String r0 = KryptonResourceUtils.getTruncatePath(r5);
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r1 = new HashMap();
        r1.put(LynxEventReporter.PROP_NAME_URL, r0);
        TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_IMAGE_SERVICE, r1);
    L5:
        ILynxImageService r2 = getLynxImageService();
        if (r2 == null) goto L8;
        g r3 = new g();
        r3.a = r5;
        r3.e = Bitmap.Config.ARGB_8888;
        r3.o = true;
        r3.p = false;
        r2.decodeImage(new f(r3), new AnonymousClass8(this, r0, r6));
    L9:
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_IMAGE_SERVICE);
        return;
    L8:
        String r7 = "load image failed with because LynxImageService is not existed, the url is :" + r0;
        KryptonLLog.e(TAG, r7);
        r6.reject(r7);
        goto L9
    }

    private void loadResWithDataUrl(final String r5, final LoaderResolver r6) {
        final String r0 = KryptonResourceUtils.getTruncatePath(r5);
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r1 = new HashMap();
        r1.put(LynxEventReporter.PROP_NAME_URL, r0);
        TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_DATA_URI, r1);
    L5:
        KryptonResourceUtils.getKryptonIOExecutor().execute(new AnonymousClass4(this, r0, r5, r6));
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_DATA_URI);
    }

    private void loadResWithDataUrlSync(String r10, LoaderResolver r11) {
        String r5 = KryptonResourceUtils.getTruncatePath(r10);
        if (TraceEvent.isTracingStarted() == false) goto L14;
        HashMap r6 = new HashMap();
        r6.put(LynxEventReporter.PROP_NAME_URL, r5);
        TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_DATA_URI, r6);
    L14:
        KryptonLLog.i(TAG, "Load resource start decode the data url, the url: " + r5);     // Catch: IllegalArgumentException -> L10
        byte[] r12 = KryptonResourceUtils.decodeDataURI(r10);     // Catch: IllegalArgumentException -> L10
        if (r12 == null) goto L8;
        KryptonLLog.i(TAG, "Load resource with data url success, the url: " + r5);     // Catch: IllegalArgumentException -> L10
        r11.resolve(r12, 0, r12.length);     // Catch: IllegalArgumentException -> L10
    L12:
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_DATA_URI);
        return;
    L8:
        KryptonLLog.e(TAG, "Load resource with data url failed, the url: " + r5);     // Catch: IllegalArgumentException -> L10
        r11.reject("Decoder return null data with url: " + r5);     // Catch: IllegalArgumentException -> L10
    L10:
        e = move-exception;
        KryptonLLog.e(TAG, "Load resource with data url with exception, the url: " + r5);
        r11.reject(e.toString());
        goto L12
    }

    private void loadWitLynxGenericFetcher(final String r4, final LoaderResolver r5) {
        KryptonLLog.i(TAG, "Load remote resource with LynxGenericFetcher, url: " + r4);
        a r0 = getLynxGenericResourceFetcher();
        if (r0 == null) goto L5;
        r0.a(new LynxResourceRequest(r4, LynxResourceRequest.LynxResourceType.LynxResourceTypeGeneric), new AnonymousClass6(this, r4, r5));
        return;
    L5:
        r5.reject("No LynxGenericResourceFetcher existed. Load failed with url: " + r4);
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithDataResolver(String r5, KryptonLoaderService.DataResolver r6) {
        String r0 = KryptonResourceUtils.getTruncatePath(r5);
        if (r6 != null) goto L6;
        KryptonLLog.e(TAG, "loadUrlWithDataResolver resolver null, the url is :" + r0);
        return;
    L6:
        LoaderResolver r2 = new LoaderResolver(r6, null);
        if (KryptonResourceUtils.isDataURI(r5) == false) goto L10;
        KryptonLLog.i(TAG, "Load base64 type data url: " + r0);
        loadResWithDataUrl(r5, r2);
        return;
    L10:
        handleNormalDataLoader(getCompatiblePath(r5), r2);
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithImageResolver(String r2, KryptonLoaderService.ImageResolver r3) {
        String r4 = getCompatiblePath(r2);
        if (getLynxImageService() == null) goto L5;
        handleImageWithLynxImageService(r4, r3);
        return;
    L5:
        loadImageRawDataAndDecodeWithBitmapFactory(r4, r3);
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithStreamDelegate(String r3, KryptonLoaderService.StreamDelegate r4) {
        if (r4 != null) goto L5;
        KryptonLLog.e(TAG, "loadUrlWithStreamDelegate delegate null");
        return;
    L5:
        final LoaderResolver r0 = new LoaderResolver(null, r4);
        loadUrlWithDataResolver(r3, new AnonymousClass1(this, r0));
    }

    public static /* synthetic */ void access$000(LynxKryptonLoaderServiceImpl r0, String r1, LoaderResolver r2) {
        r0.handleLocalPathResource(r1, r2);
    }

    public static /* synthetic */ void access$100(LynxKryptonLoaderServiceImpl r0, String r1, LoaderResolver r2) {
        r0.loadWitLynxGenericFetcher(r1, r2);
    }

    public static /* synthetic */ void access$300(LynxKryptonLoaderServiceImpl r0, String r1, KryptonLoaderService.ImageResolver r2) {
        r0.loadImageWithLynxImageServiceImpl(r1, r2);
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithDataResolverWithPolicy(String r6, KryptonLoaderService.DataResolver r7, KryptonLoaderService.LoadPolicy r8) {
        if (r8 == KryptonLoaderService.LoadPolicy.PREFER_CURRENT_THREAD_FOR_LOCAL_OR_DATA_URI) goto L6;
        loadUrlWithDataResolver(r6, r7);
        return;
    L6:
        String r9 = KryptonResourceUtils.getTruncatePath(r6);
        if (r7 != null) goto L10;
        KryptonLLog.e(TAG, "loadUrlWithDataResolver resolver null, the url is :" + r9);
        return;
    L10:
        LoaderResolver r1 = new LoaderResolver(r7, null);
        if (KryptonResourceUtils.isDataURI(r6) == false) goto L14;
        KryptonLLog.i(TAG, "Load base64 type data url in current thread: " + r9);
        KryptonLLog.i(TAG, "[readFilePreferCurrentThread] policy branch=data_uri_current_thread, url=" + r9 + ", thread=" + ThreadMethodProxy.currentThread().getName());
        loadResWithDataUrlSync(r6, r1);
        return;
    L14:
        String r10 = getCompatiblePath(r6);
        String r11 = redirectUrl(r10);
        if (KryptonResourceUtils.isLocalPath(r11) == false) goto L17;
    L21:
        KryptonLLog.i(TAG, "[readFilePreferCurrentThread] policy branch=local_or_content_current_thread, finalPath=" + KryptonResourceUtils.getTruncatePath(r10) + ", redirectedPath=" + KryptonResourceUtils.getTruncatePath(r11) + ", thread=" + ThreadMethodProxy.currentThread().getName());
        handleLocalPathResource(r11, r1);
        return;
    L17:
        if (KryptonResourceUtils.isContentURI(r11) == true) goto L21;
        KryptonLLog.i(TAG, "[readFilePreferCurrentThread] policy branch=remote_async_fallback, finalPath=" + KryptonResourceUtils.getTruncatePath(r10) + ", redirectedPath=" + KryptonResourceUtils.getTruncatePath(r11) + ", thread=" + ThreadMethodProxy.currentThread().getName());
        handleNormalDataLoader(r10, r1);
    }

    private void HandleStreamWithResolver(String r6, InputStream r7, int r8, LoaderResolver r9) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r0 = new HashMap();
        r0.put(LynxEventReporter.PROP_NAME_URL, r6);
        TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_HANDLE_STREAM_WITH_RESOLVER, r0);
    L5:
        byte[] r10 = KryptonResourceUtils.getByteArrayFromInputStream(r7, r8);
        if (r10 == null) goto L8;
        KryptonLLog.i(TAG, "Load from stream success with content length: " + r10.length + " from url: " + r6);
        r9.resolve(r10, 0, r8);
    L9:
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_HANDLE_STREAM_WITH_RESOLVER);
        return;
    L8:
        KryptonLLog.e(TAG, "Load stream failed from url: " + r6);
        r9.reject("Load stream failed from url!");
        goto L9
    }

    private void handleStreamWithDelegate(String r4, InputStream r5, int r6, LoaderResolver r7) {
        if (TraceEvent.isTracingStarted() == false) goto L15;
        HashMap r0 = new HashMap();
        r0.put(LynxEventReporter.PROP_NAME_URL, r4);
        TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_HANDLE_STREAM_WITH_DELEGATE, r0);
    L15:
        LoaderResolver.access$200(r7).onStart(r6);     // Catch: IOException -> L12
        byte[] r8 = new byte[KryptonResourceUtils.getPreferredBufferSize(r6)];     // Catch: IOException -> L12
    L6:
        int r9 = r5.read(r8);     // Catch: IOException -> L12
        if (r9 == (-1)) goto L10;
        if (r9 <= 0) goto L6;
        LoaderResolver.access$200(r7).onData(r8, 0, r9);     // Catch: IOException -> L12
        goto L6
    L10:
        LoaderResolver.access$200(r7).onEnd();     // Catch: IOException -> L12
        r5.close();     // Catch: IOException -> L12
    L13:
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_HANDLE_STREAM_WITH_DELEGATE);
        return;
    L12:
        LoaderResolver.access$200(r7).onError("Read stream error");
        goto L13
    }
}
