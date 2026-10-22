package com.ss.android.lark.framework.assembly.imageloader;

import androidx.collection.LruCache;
import com.bumptech.glide.IGlideDependency;
import com.bumptech.glide.monitor.GlideDiskCacheMonitor;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.google.gson.Gson;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.LogSafetyTools;
import com.larksuite.framework.utils.e0;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.videosend.tools.j;
import com.ss.lark.android.encryption.CipherManager;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(IGlideDependency.class)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006%"}, d2 = {"Lcom/ss/android/lark/framework/assembly/imageloader/LarkGlideDependency;", "Lcom/bumptech/glide/IGlideDependency;", "<init>", "()V", "fgCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "glideStorage", "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "getGlideStorage", "()Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "glideStorage$delegate", "Lkotlin/Lazy;", "isEnable", "featureName", "getCurrentScene", "isWeakNet", "isOpenEncrypt", "getFileHeader", "data", "Ljava/nio/ByteBuffer;", "runInIOExecutor", "", "runnable", "Ljava/lang/Runnable;", "writeDiskCacheInfo", "info", "Lcom/bumptech/glide/monitor/GlideDiskCacheMonitor$DiskCacheInfo;", "readDiskCacheInfo", "getLeftSpace", "", "report", "eventName", "json", "Lorg/json/JSONObject;", "Companion", "imageloader-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkGlideDependency implements IGlideDependency {
    private static final a Companion = null;
    private static final float FILE_SIZE_UNITY = 1024.0f;
    private static final String KEY_GLIDE_DISK_CACHE_INFO = "GLIDE_DISK_CACHE_INFO";
    private static final String TAG = "LarkGlideDependency";
    private final ConcurrentHashMap<String, Boolean> fgCache;
    private final Lazy glideStorage$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public GlideDiskCacheMonitor.DiskCacheInfo readDiskCacheInfo() {
        String r1 = getGlideStorage().getString(KEY_GLIDE_DISK_CACHE_INFO, null);     // Catch: Exception -> L7
        if (r1 == null) goto L8;
        return (GlideDiskCacheMonitor.DiskCacheInfo) new Gson().fromJson(r1, GlideDiskCacheMonitor.DiskCacheInfo.class);
    L8:
        return null;
    L7:
        Log.e(TAG, "readDiskCacheInfo failed");
        goto L8
    }

    private final KVRepo getGlideStorage() {
        return (KVRepo) this.glideStorage$delegate.getValue();
    }

    public LarkGlideDependency() {
        this.fgCache = new ConcurrentHashMap();
        this.glideStorage$delegate = LazyKt.lazy(LarkGlideDependency$glideStorage$2.INSTANCE);
    }

    public String getCurrentScene() {
        String r0 = MonitorModule.e().d();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public float getLeftSpace() {
        return (j.a() / FILE_SIZE_UNITY) / FILE_SIZE_UNITY;
    }

    public boolean isOpenEncrypt() {
        if (CipherManager.d() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isWeakNet() {
        return pac.a.a();
    }

    public String getFileHeader(ByteBuffer r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        LruCache r0 = ImageUtils.a;
        if (r4 != null) goto L5;
    L11:
        return null;
    L5:
        if (r4.limit() < 12) goto L11;
        byte[] r1 = new byte[12];
        r4.position(0);
        r4.get(r1, 0, 12);
        String r5 = e0.a(r1);
        if (r5 != null) goto L13;
        return "";
    L13:
        return r5.toUpperCase();
    }

    public boolean isEnable(String r4) {
        Intrinsics.checkNotNullParameter(r4, "featureName");
        Boolean r0 = this.fgCache.get(r4);
        if (r0 != null) goto L5;
        r0 = Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable(r4));
        this.fgCache.put(r4, r0);
    L5:
        Log.i(TAG, "featureName:" + r4 + ", isEnable:" + r0);
        return r0.booleanValue();
    }

    public void runInIOExecutor(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(r2);
    }

    public void writeDiskCacheInfo(GlideDiskCacheMonitor.DiskCacheInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        getGlideStorage().putString(KEY_GLIDE_DISK_CACHE_INFO, new Gson().toJson(r4).toString());     // Catch: Exception -> L5
        return;
    L5:
        Log.e(TAG, "writeDiskCacheInfo failed");
    }

    public void report(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "json");
        Log.i(TAG, "report, eventName:" + r4 + ",msg:" + LogSafetyTools.a(r5.toString()));
        Statistics.sendEvent(r4, r5);
    }
}
