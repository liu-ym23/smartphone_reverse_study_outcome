package com.ss.android.lark.glide;

import android.content.Context;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.diskmanage.storage.d;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.executor.GlideHighSpeedExecutor;
import com.ss.android.lark.image.i;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.resource.service.ResourceRecordManager;
import com.ss.android.lark.storage.a;
import idb.f;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(ImageLoader.a.class)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/glide/ImageLoaderDependency;", "Lcom/ss/android/lark/image/ImageLoader$IDependency;", "<init>", "()V", "getImageCacheDirPath", "", "context", "Landroid/content/Context;", "getImageResizeService", "Ljava/util/concurrent/ExecutorService;", "reportError", "", "tag", "msg", "isEnable", "", TabAppInfo.IMAGE_JSON_KEY, "hasImageCache", "getCustomSourceExecutor", "Lcom/bumptech/glide/load/engine/executor/GlideExecutor;", "loadModel", "", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageLoaderDependency implements ImageLoader.a {
    public ImageLoaderDependency() {
        i.a();
    }

    public ExecutorService getImageResizeService() {
        return CoreThreadPool.getDefault().getFixedThreadPool();
    }

    @Override // com.ss.android.lark.image.ImageLoader.a
    public GlideExecutor getCustomSourceExecutor(Object r3) {
        if ((r3 instanceof AvatarImage) == false) goto L8;
        a r4 = GlideHighSpeedExecutor.a;
        if (((GlideHighSpeedExecutor.SceneEnable) GlideHighSpeedExecutor.e.getValue()).getFeedAvatarEnable() == 1) goto L14;
    L12:
        return null;
    L14:
        return GlideHighSpeedExecutor.a();
    L8:
        if ((r3 instanceof EncryptImage) == false) goto L12;
        a r5 = GlideHighSpeedExecutor.a;
        if (((GlideHighSpeedExecutor.SceneEnable) GlideHighSpeedExecutor.e.getValue()).getChatEncryptEnable() != 1) goto L12;
        return GlideHighSpeedExecutor.a();
    }

    public String getImageCacheDirPath(Context r1) {
        return d.g(r1);
    }

    @Override // com.ss.android.lark.image.ImageLoader.a
    public boolean hasImageCache(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        if (ResourceRecordManager.a(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEnable(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return f.a().isEnable(r2);
    }

    @Override // com.ss.android.lark.image.ImageLoader.a
    public void reportError(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.e(r2 + '_' + r3, new Exception(r3), true);
    }
}
