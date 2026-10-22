package com.lynx.canvas;

import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.canvas.loader.KryptonResourceUtils;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.LynxResourceServiceRequestParams;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d7a.a;
import d8a.h;
import d8a.i;
import i8a.e;
import i8a.n;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import v7a.f;
import v7a.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CanvasLoaderService extends KryptonLoaderService {
    private static final String ASSETS2_PREFIX = "assets://";
    private static final String ASSETS_PREFIX = "assets:///";
    private static final String ASSET_PREFIX = "asset:///";
    private static final String TAG = "KryptonCanvasLoaderService";
    private final WeakReference<LynxContext> mLynxContext;
    private ILynxImageService mLynxImageService;
    private e mLynxResourceService;

    public static class LoaderResolver {
        private final KryptonLoaderService.DataResolver dataResolver;
        private final KryptonLoaderService.StreamDelegate streamDelegate;

        public boolean hasStreamDelegate() {
            if (this.streamDelegate == null) goto L5;
            return true;
        L5:
            return false;
        }

        public static /* synthetic */ KryptonLoaderService.StreamDelegate access$400(LoaderResolver r0) {
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

    private ILynxImageService getLynxImageService() {
        if (this.mLynxImageService != null) goto L6;
        this.mLynxImageService = (ILynxImageService) n.c().a(ILynxImageService.class);
    L6:
        return this.mLynxImageService;
    }

    private e getLynxResourceService() {
        if (this.mLynxResourceService != null) goto L6;
        this.mLynxResourceService = (e) n.c().a(e.class);
    L6:
        return this.mLynxResourceService;
    }

    private LynxContext lockLynxContext() {
        WeakReference<LynxContext> r0 = this.mLynxContext;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public CanvasLoaderService(WeakReference<LynxContext> r1) {
        this.mLynxContext = r1;
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

    private int getLynxResponseContentLength(i r3) {
        Map<String, List<String>> r4 = r3.c;
        if (r4 == null) goto L10;
        List<String> r5 = r4.get("content-length");
        if (r5 == null) goto L10;
        if (r5.isEmpty() == true) goto L10;
        return CastIntegerProtector.parseInt((String) ListProtector.get(r5, 0));
    L10:
        return 0;
    }

    private int getTotalLengthForLynxResResponse(i r4) {
        InputStream r0 = r4.d;
        int r1 = 0;
        if (r0 != null) goto L14;
        return 0;
    L14:
        r1 = r0.available();     // Catch: IOException -> L7
    L8:
        int r5 = getLynxResponseContentLength(r4);
        if (r1 > 0) goto L16;
        KryptonLLog.i(TAG, "no length from stream, responseContentLength = " + r5);
        if (r5 > 0) goto L13;
        return r1;
    L13:
        return r5;
    L16:
        return r1;
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
    L24:
        KryptonLLog.e(TAG, "Local, content or base64 path redirect with original url: " + r0);
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
        return r7;
    L8:
        if (KryptonResourceUtils.isContentURI(r7) == true) goto L24;
        if (KryptonResourceUtils.isDataURI(r7) == true) goto L24;
        LynxContext r2 = lockLynxContext();
        if (r2 != null) goto L16;
        KryptonLLog.e(TAG, "LynxContext null, redirect failed with url: " + r0);
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
        return r7;
    L16:
        String r3 = a.b(r2, r7, false);
        if (r3 != null) goto L19;
    L22:
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
        return r7;
    L19:
        if (r3.equals(r7) == true) goto L22;
        KryptonLLog.i(TAG, "Redirect the original url: " + r7 + " to new path: " + r3);
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
        return r3;
    }

    public static /* synthetic */ int access$100(CanvasLoaderService r0, i r1) {
        return r0.getTotalLengthForLynxResResponse(r1);
    }

    private void handleBase64Image(String r5, KryptonLoaderService.ImageResolver r6) {
        String r2 = KryptonResourceUtils.getTruncatePath(r5);
        Bitmap r7 = KryptonResourceUtils.decodeBase64Image(r5);     // Catch: Exception -> L9
        if (r7 == null) goto L7;
        KryptonLLog.i(TAG, "Decode base64 image success with image: " + r2);     // Catch: Exception -> L9
        r6.resolve(r7);     // Catch: Exception -> L9
    L12:
        return;
    L7:
        String r8 = "Empty base64 image: " + r2;     // Catch: Exception -> L9
        KryptonLLog.i(TAG, r8);     // Catch: Exception -> L9
        r6.reject(r8);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        r6.reject("Decode base64 image: " + r2 + " with error: " + e.getMessage());
    }

    private void handleBase64ImageAsync(final String r3, final KryptonLoaderService.ImageResolver r4) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new AnonymousClass6(this, r3, r4));
    }

    private void handleImageWithLynxImageService(final String r3, final KryptonLoaderService.ImageResolver r4) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new AnonymousClass4(this, r3, r4));
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
        r2.decodeImage(new f(r3), new AnonymousClass5(this, r0, r6));
    L9:
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_IMAGE_SERVICE);
        return;
    L8:
        String r7 = "load image failed with because LynxImageService is not existed, the url is :" + r0;
        KryptonLLog.e(TAG, r7);
        r6.reject(r7);
        goto L9
    }

    private void loadImageWithProperLoader(String r2, KryptonLoaderService.ImageResolver r3) {
        loadImageWithProperLoader(r2, r3, KryptonLoaderService.ImageLoadOptions.defaults());
    }

    private void loadNormalDataWithProperDownloader(String r2, LoaderResolver r3) {
        e r0 = getLynxResourceService();
        if (r0 != null) goto L5;
    L7:
        loadResWithLynxResManager(r2, r3);
        return;
    L5:
        if (r0.isReady() == false) goto L7;
        loadResWithLynxResourceService(r2, r3);
    }

    private void loadNormalDataWithProperDownloaderAsync(final String r3, final LoaderResolver r4) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new AnonymousClass1(this, r3, r4));
    }

    private void loadResWithDataUrl(final String r5, final LoaderResolver r6) {
        final String r0 = KryptonResourceUtils.getTruncatePath(r5);
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r1 = new HashMap();
        r1.put(LynxEventReporter.PROP_NAME_URL, r0);
        TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_DATA_URI, r1);
    L5:
        KryptonResourceUtils.getKryptonIOExecutor().execute(new AnonymousClass8(this, r0, r5, r6));
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

    private void loadResWithLynxResManager(final String r5, final LoaderResolver r6) {
        KryptonLLog.i(TAG, "Load url : " + r5 + " with ResManager.");
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r0 = new HashMap();
        r0.put(LynxEventReporter.PROP_NAME_URL, r5);
        TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_RES_MANAGER, r0);
    L5:
        LynxContext r1 = lockLynxContext();
        if (r1 != null) goto L8;
        Object r2 = null;
    L9:
        com.lynx.tasm.core.n.a().b(new h(r5, r2), new AnonymousClass2(this, r5, r6));
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_RES_MANAGER);
        return;
    L8:
        r2 = r1.getLynxExtraData();
        goto L9
    }

    private void loadResWithLynxResourceService(final String r7, final LoaderResolver r8) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r0 = new HashMap();
        r0.put(LynxEventReporter.PROP_NAME_URL, r7);
        TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_RESOURCE_SERVICE, r0);
    L5:
        KryptonLLog.i(TAG, "Load url : " + r7 + " with LynxResourceService.");
        final String r1 = redirectUrl(r7);
        if (KryptonResourceUtils.isLocalPath(r1) == false) goto L8;
    L18:
        KryptonLLog.i(TAG, "The redirected url is a local or content path: ," + r1 + " handle local path.");
        handleLocalPathResource(r1, r8);
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_RESOURCE_SERVICE);
        return;
    L8:
        if (KryptonResourceUtils.isContentURI(r1) == true) goto L18;
        KryptonLLog.i(TAG, "Load from remote by LynxResourceService with url: " + r1);
        LynxResourceServiceRequestParams r3 = new LynxResourceServiceRequestParams();
        e r4 = getLynxResourceService();
        if (r4 != null) goto L13;
    L15:
        KryptonLLog.e(TAG, "No LynxResourceService existed, LynxResourceService request failed with url: " + r1);
        r8.reject("No LynxResourceService existed");
    L16:
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_RESOURCE_SERVICE);
        return;
    L13:
        if (r4.isReady() == false) goto L15;
        r4.fetchResourceAsync(r1, r3, new AnonymousClass3(this, r1, r8, r7));
        goto L16
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithDataResolver(String r4, KryptonLoaderService.DataResolver r5) {
        if (r5 != null) goto L6;
        KryptonLLog.e(TAG, "Load url: " + KryptonResourceUtils.getTruncatePath(r4) + " failed with null resolver");
        return;
    L6:
        LoaderResolver r1 = new LoaderResolver(r5, null);
        if (r4 != null) goto L11;
        KryptonLLog.e(TAG, "Load data with invalid null url");
        r5.reject("Failed with invalid null url");
        return;
    L11:
        if (KryptonResourceUtils.isDataURI(r4) == false) goto L14;
        KryptonLLog.i(TAG, "Load resource with data url: " + KryptonResourceUtils.getTruncatePath(r4));
        loadResWithDataUrl(r4, r1);
        return;
    L14:
        loadNormalDataWithProperDownloaderAsync(getCompatiblePath(r4), r1);
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithImageResolver(String r3, KryptonLoaderService.ImageResolver r4) {
        if (r4 != null) goto L6;
        KryptonLLog.e(TAG, "Load image: " + KryptonResourceUtils.getTruncatePath(r3) + " failed with null resolver");
        return;
    L6:
        if (r3 != null) goto L9;
        KryptonLLog.e(TAG, "Load image with invalid null url");
        r4.reject("Failed image invalid null url");
        return;
    L9:
        loadImageWithProperLoader(getCompatiblePath(r3), r4);
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithStreamDelegate(String r4, KryptonLoaderService.StreamDelegate r5) {
        if (r5 != null) goto L6;
        KryptonLLog.e(TAG, "loadUrlWithStreamDelegate delegate null with url: " + r4);
        return;
    L6:
        LoaderResolver r1 = new LoaderResolver(null, r5);
        if (r4 != null) goto L11;
        KryptonLLog.e(TAG, "Load data with invalid null url");
        r1.reject("Failed with invalid null url");
        return;
    L11:
        if (KryptonResourceUtils.isDataURI(r4) == false) goto L14;
        r1.reject("Do not handle data url with stream loader! The url is: " + KryptonResourceUtils.getTruncatePath(r4));
        return;
    L14:
        loadNormalDataWithProperDownloaderAsync(getCompatiblePath(r4), r1);
    }

    public static /* synthetic */ void access$000(CanvasLoaderService r0, String r1, LoaderResolver r2) {
        r0.loadNormalDataWithProperDownloader(r1, r2);
    }

    public static /* synthetic */ void access$500(CanvasLoaderService r0, String r1, KryptonLoaderService.ImageResolver r2) {
        r0.loadImageWithLynxImageServiceImpl(r1, r2);
    }

    public static /* synthetic */ void access$600(CanvasLoaderService r0, String r1, KryptonLoaderService.ImageResolver r2) {
        r0.handleBase64Image(r1, r2);
    }

    private void handleImageWithoutLynxImageService(String r3, KryptonLoaderService.ImageResolver r4, boolean r5) {
        if (KryptonResourceUtils.isDataURI(r3) == false) goto L9;
        KryptonLLog.i(TAG, "Handle base64 type image with url: " + KryptonResourceUtils.getTruncatePath(r3));
        if (r5 == true) goto L7;
        handleBase64ImageAsync(r3, r4);
        return;
    L7:
        handleBase64Image(r3, r4);
        return;
    L9:
        loadImageRawDataAndDecodeWithBitmapFactory(r3, r4, r5);
    }

    private void loadImageRawDataAndDecodeWithBitmapFactory(final String r3, final KryptonLoaderService.ImageResolver r4, boolean r5) {
        KryptonLoaderService.DataResolver r0 = new AnonymousClass7(this, r3, r4);
        KryptonLLog.i(TAG, "Load raw data of image and decode it with BitmapFactory, the url: " + r3);
        if (r5 == false) goto L5;
        loadNormalDataWithProperDownloader(r3, new LoaderResolver(r0, null));
        return;
    L5:
        loadNormalDataWithProperDownloaderAsync(r3, new LoaderResolver(r0, null));
    }

    private void loadImageWithProperLoader(String r4, KryptonLoaderService.ImageResolver r5, KryptonLoaderService.ImageLoadOptions r6) {
        ILynxImageService r0 = getLynxImageService();
        boolean r1 = r6.usingBuiltinImageDecoder;
        boolean r7 = r6.decodeImageInJs;
        if (r1 == true) goto L6;
        if (r0 == null) goto L6;
        KryptonLLog.i(TAG, "Handle image load with the LynxImageService.");
        handleImageWithLynxImageService(r4, r5);
        return;
    L6:
        KryptonLLog.i(TAG, "LynxImageService is not ready, Load and decode image with BitmapFactory.");
        handleImageWithoutLynxImageService(r4, r5, r7);
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadImageWithOptions(String r3, KryptonLoaderService.ImageLoadOptions r4, KryptonLoaderService.ImageResolver r5) {
        if (r5 != null) goto L6;
        KryptonLLog.e(TAG, "Load image: " + KryptonResourceUtils.getTruncatePath(r3) + " failed with null resolver");
        return;
    L6:
        if (r3 != null) goto L8;
    L12:
        KryptonLLog.e(TAG, "Load image with invalid null url");
        r5.reject("Failed image invalid null url");
        return;
    L8:
        if (r3.isEmpty() == true) goto L12;
        loadImageWithProperLoader(getCompatiblePath(r3), r5, r4);
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithDataResolverWithPolicy(String r6, KryptonLoaderService.DataResolver r7, KryptonLoaderService.LoadPolicy r8) {
        if (r8 == KryptonLoaderService.LoadPolicy.PREFER_CURRENT_THREAD_FOR_LOCAL_OR_DATA_URI) goto L7;
        loadUrlWithDataResolver(r6, r7);
        return;
    L7:
        if (r7 != null) goto L10;
        KryptonLLog.e(TAG, "Load url: " + KryptonResourceUtils.getTruncatePath(r6) + " failed with null resolver");
        return;
    L10:
        LoaderResolver r0 = new LoaderResolver(r7, null);
        if (r6 != null) goto L15;
        KryptonLLog.e(TAG, "Load data with invalid null url");
        r7.reject("Failed with invalid null url");
        return;
    L15:
        if (KryptonResourceUtils.isDataURI(r6) == false) goto L18;
        KryptonLLog.i(TAG, "Load resource with data url in current thread: " + KryptonResourceUtils.getTruncatePath(r6));
        KryptonLLog.i(TAG, "[readFilePreferCurrentThread] policy branch=data_uri_current_thread, url=" + KryptonResourceUtils.getTruncatePath(r6) + ", thread=" + ThreadMethodProxy.currentThread().getName());
        loadResWithDataUrlSync(r6, r0);
        return;
    L18:
        String r9 = getCompatiblePath(r6);
        String r10 = redirectUrl(r9);
        if (KryptonResourceUtils.isLocalPath(r10) == false) goto L21;
    L25:
        KryptonLLog.i(TAG, "[readFilePreferCurrentThread] policy branch=local_or_content_current_thread, finalPath=" + KryptonResourceUtils.getTruncatePath(r9) + ", redirectedPath=" + KryptonResourceUtils.getTruncatePath(r10) + ", thread=" + ThreadMethodProxy.currentThread().getName());
        handleLocalPathResource(r10, r0);
        return;
    L21:
        if (KryptonResourceUtils.isContentURI(r10) == true) goto L25;
        KryptonLLog.i(TAG, "[readFilePreferCurrentThread] policy branch=remote_async_fallback, finalPath=" + KryptonResourceUtils.getTruncatePath(r9) + ", redirectedPath=" + KryptonResourceUtils.getTruncatePath(r10) + ", thread=" + ThreadMethodProxy.currentThread().getName());
        loadNormalDataWithProperDownloaderAsync(r9, r0);
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
        LoaderResolver.access$400(r7).onStart(r6);     // Catch: IOException -> L12
        byte[] r8 = new byte[KryptonResourceUtils.getPreferredBufferSize(r6)];     // Catch: IOException -> L12
    L6:
        int r9 = r5.read(r8);     // Catch: IOException -> L12
        if (r9 == (-1)) goto L10;
        if (r9 <= 0) goto L6;
        LoaderResolver.access$400(r7).onData(r8, 0, r9);     // Catch: IOException -> L12
        goto L6
    L10:
        LoaderResolver.access$400(r7).onEnd();     // Catch: IOException -> L12
        r5.close();     // Catch: IOException -> L12
    L13:
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_HANDLE_STREAM_WITH_DELEGATE);
        return;
    L12:
        LoaderResolver.access$400(r7).onError("Read stream error");
        goto L13
    }

    public static /* synthetic */ void access$200(CanvasLoaderService r0, String r1, InputStream r2, int r3, LoaderResolver r4) {
        r0.handleStreamWithDelegate(r1, r2, r3, r4);
    }

    public static /* synthetic */ void access$300(CanvasLoaderService r0, String r1, InputStream r2, int r3, LoaderResolver r4) {
        r0.HandleStreamWithResolver(r1, r2, r3, r4);
    }
}
