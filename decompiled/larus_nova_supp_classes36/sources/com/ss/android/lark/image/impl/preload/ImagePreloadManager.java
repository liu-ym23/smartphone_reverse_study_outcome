package com.ss.android.lark.image.impl.preload;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.impl.cache.ImageCacheFinder;
import com.ss.android.lark.image.utils.ChatImageSettings;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import pac.a;
import qpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u001c\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J$\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/ImagePreloadManager;", "", "<init>", "()V", "TAG", "", "DRAFT_RESOURCE_SOURCE_UNKNOWN", "", "resultCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/ss/android/lark/image/impl/preload/PreloadResult;", "executor", "Ljava/util/concurrent/Executor;", "preload", "", "scene", "sceneID", TabAppInfo.IMAGE_JSON_KEY, "fsUnit", "crypto", "Lokio/ByteString;", "onIntercept", "", "load", "getEncryptImage", "getResult", "isLimitCount", "hasFileCache", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImagePreloadManager {
    public static final int $stable = 0;
    public static final ImagePreloadManager INSTANCE = null;
    private static final Executor executor = null;
    private static final ConcurrentHashMap<String, PreloadResult> resultCache = null;

    private ImagePreloadManager() {
    }

    static {
        INSTANCE = new ImagePreloadManager();
        resultCache = new ConcurrentHashMap();
        executor = CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk-image-preload");
        $stable = 8;
    }

    @JvmStatic
    public static final PreloadResult getResult(String r11) {
        ConcurrentHashMap<String, PreloadResult> r0 = resultCache;
        if (r11 != null) goto L5;
        String r1 = "";
    L6:
        PreloadResult r2 = r0.get(r1);
        if (r2 != null) goto L9;
        PreloadResult r3 = null;
    L16:
        Log.i("ImagePreloadManager", "getResult, key:" + r11 + ", outResult:" + r3);
        return r3;
    L9:
        if (r2.getState() != ResultState.PRELOADING) goto L11;
        int r4 = (int) (System.currentTimeMillis() - r2.getStartTime());
    L12:
        r2.setPreloadingDuration(r4);
        r3 = new PreloadResult(r2.getScene(), r2.getSceneID(), r2.getImageKey(), r2.getStartTime(), r2.getPreloadingDuration(), r2.getState());
        if (r2.getState() != ResultState.PRELOADED) goto L16;
        r2.setState(ResultState.CONSUMED);
        goto L16
    L11:
        r4 = 0;
        goto L12
    L5:
        r1 = r11;
        goto L6
    }

    private final boolean hasFileCache(String r3) {
        File r4 = ImageCacheFinder.findImageCacheFile(r3);
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.exists() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean isLimitCount(String r8) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        PreloadStrategy r0 = ImagePreloadSettings.INSTANCE.getStrategy(r8);
        ConcurrentHashMap<String, PreloadResult> r1 = resultCache;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, PreloadResult>> r3 = r1.entrySet().iterator();
    L3:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L16;
        Map.Entry<String, PreloadResult> r5 = r3.next();
        if (Intrinsics.areEqual(r5.getValue().getScene(), r8) == true) goto L8;
    L12:
        r4 = false;
    L13:
        if (r4 == false) goto L3;
        r2.put(r5.getKey(), r5.getValue());
        goto L3
    L8:
        if (r5.getValue().getState() == ResultState.PENDING) goto L13;
        if (r5.getValue().getState() != ResultState.PRELOADING) goto L12;
    L16:
        if (r2.size() > r0.getMaxCount()) goto L25;
        return false;
    L25:
        return true;
    }

    private final boolean onIntercept(String r7, String r8) {
        ImagePreloadSettings r0 = ImagePreloadSettings.INSTANCE;
        ImagePreloadConfig r1 = r0.getConfig();
        ConcurrentHashMap<String, PreloadResult> r2 = resultCache;
        if (r2.size() <= r1.getPreloadCacheCount()) goto L6;
        r2.clear();
    L6:
        if (r8 != null) goto L8;
    L11:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L17;
        Log.e("ImagePreloadManager", "key:" + r8 + " is null");
        return true;
    L17:
        if (r1.getPreloadEnable() == 1) goto L21;
        Log.e("ImagePreloadManager", "remote close preload");
        return true;
    L21:
        if (r0.getStrategy(r7).getPreloadEnable() == 1) goto L24;
        Log.e("ImagePreloadManager", "scene:" + r7 + ", close preload");
        return true;
    L24:
        int r9 = (int) CpuCallbackManager.a().c;
        if (r9 <= r1.getCpuLimit()) goto L29;
        Log.e("ImagePreloadManager", "cpu:" + r9 + " is too busy");
        return true;
    L29:
        if (r1.getNetworkLimit() != 1) goto L35;
        if (a.a() == false) goto L35;
        Log.e("ImagePreloadManager", "networkLimit is 1, only well net preload");
        return true;
    L35:
        if (r1.getNetworkLimit() != 2) goto L45;
        NetworkInfo r10 = ((ConnectivityManager) LarkContext.getApplication().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (r10 != null) goto L39;
    L41:
        boolean r11 = false;
    L42:
        if (r11 == false) goto L45;
        Log.e("ImagePreloadManager", "networkLimit is 2, only wifi preload");
        return true;
    L39:
        if (r10.getType() != 0) goto L41;
        r11 = true;
    L45:
        return false;
    L8:
        if (r8.length() == 0) goto L11;
        r4 = false;
        goto L13
    }

    private final String getEncryptImage(String r11, String r12, ByteString r13) {
        if (ChatImageSettings.getGlideImageCache().getNoCachePreload() != 1) goto L12;
        e r0 = (e) ApiUtils.getApi(e.class);
        if (r0 == null) goto L7;
        qpc.a r3 = r0.getImageService();
    L8:
        if (r3 == null) goto L16;
        Resource r14 = r3.getEncryptImage(null, r11, r12, r13, "", true);
        if (r14 != null) goto L18;
        return null;
    L18:
        return r14.b;
    L16:
        return null;
    L7:
        r3 = null;
        goto L8
    L12:
        File r15 = ImageLoader.with(LarkContext.getApplication()).load(new EncryptImage(r11, r12, r13)).downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
        if (r15 != null) goto L15;
        return null;
    L15:
        return r15.getPath();
    }

    private final void load(String r6, String r7, ByteString r8) {
        PreloadResult r0 = resultCache.get(r6);
        if (hasFileCache(r6) == false) goto L8;
        Log.e("ImagePreloadManager", "key:" + r6 + " has file cache, no need preload");
        if (r0 == null) goto L21;
        r0.setState(ResultState.NEEDLESS);
        return;
    L21:
        return;
    L8:
        long r3 = System.currentTimeMillis();
        if (r0 == null) goto L11;
        r0.setState(ResultState.PRELOADING);
    L11:
        if (r0 == null) goto L13;
        r0.setStartTime(r3);
    L13:
        String r9 = getEncryptImage(r6, r7, r8);
        boolean r10 = FileUtils.r(r9);
        if (r0 == null) goto L19;
        if (r10 == false) goto L17;
        ResultState r1 = ResultState.PRELOADED;
    L18:
        r0.setState(r1);
        goto L19
    L17:
        r1 = ResultState.FAILED;
    L19:
        int r2 = (int) (System.currentTimeMillis() - r3);
        Log.i("ImagePreloadManager", "load key:" + r6 + ", isSuccess:" + r10 + ", latency:" + r2 + ", path:" + r9);
        ImagePreloadMonitor.onPreloadFinish(r10, r2);
    }

    public static final /* synthetic */ void access$load(ImagePreloadManager r0, String r1, String r2, ByteString r3) {
        r0.load(r1, r2, r3);
    }

    @JvmStatic
    public static final void preload(String r10, String r11, final String r12, final String r13, final ByteString r14) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r11, "sceneID");
        Log.i("ImagePreloadManager", "scene:" + r10 + ", sceneID:" + r11 + ", key:" + r12);
        ImagePreloadManager r0 = INSTANCE;
        if (r0.onIntercept(r10, r12) == false) goto L5;
        return;
    L5:
        if (r12 != null) goto L7;
    L10:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L23;
        ConcurrentHashMap<String, PreloadResult> r8 = resultCache;
        if (r8.containsKey(r12) == true) goto L23;
        if (r0.hasFileCache(r12) == false) goto L19;
        Log.e("ImagePreloadManager", "key:" + r12 + " has file cache, no need preload");
        r8.put(r12, new PreloadResult(r10, r11, r12, 0, 0, ResultState.NEEDLESS));
        return;
    L19:
        r8.put(r12, new PreloadResult(r10, r11, r12, 0, 0, ResultState.PENDING));
        Executor r1 = executor;
        if (r1 == null) goto L26;
        r1.execute(new AnonymousClass1(r12, r13, r14));
        return;
    L26:
        return;
    L23:
        Log.e("ImagePreloadManager", "key:" + r12 + " has result cache");
        return;
    L7:
        if (r12.length() == 0) goto L10;
        r4 = false;
        goto L12
    }
}
