package com.ss.android.lark.image.impl.cache;

import android.util.LruCache;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.b;
import com.ss.android.lark.image.entity.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000fH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/image/impl/cache/ImageCacheFinder;", "", "<init>", "()V", "TAG", "", "sMemoryCache", "Landroid/util/LruCache;", "findImageCache", "Lcom/ss/android/lark/image/entity/ImageCache;", "keyOrder", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/image/entity/FindKey;", "Lkotlin/collections/ArrayList;", "monitor", "Lkotlin/Function1;", "Lcom/ss/android/lark/image/impl/cache/FindMonitorInfo;", "findImageCacheFile", "Ljava/io/File;", TabAppInfo.IMAGE_JSON_KEY, "findImageCacheFile2", "width", "", "height", "findImageCacheFileInner", "find", "Lkotlin/Function0;", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageCacheFinder {
    public static final int $stable = 0;
    public static final ImageCacheFinder INSTANCE = null;
    private static final LruCache<String, String> sMemoryCache = null;

    private ImageCacheFinder() {
    }

    static {
        INSTANCE = new ImageCacheFinder();
        sMemoryCache = new LruCache(300);
        $stable = 8;
    }

    @JvmStatic
    public static final File findImageCacheFile(final String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return INSTANCE.findImageCacheFileInner(r2, new AnonymousClass1(r2));
    }

    @JvmStatic
    public static final c findImageCache(ArrayList<b> r20, Function1<? super FindMonitorInfo, ? extends Object> r21) {
        Intrinsics.checkNotNullParameter(r20, "keyOrder");
        Intrinsics.checkNotNullParameter(r21, "monitor");
        Log.i("ImageCacheFinder", "start findImageCache");
        Iterator<T> r1 = r20.iterator();
    L4:
        if (r1.hasNext() == false) goto L26;
        b r2 = (b) r1.next();
        String r4 = r2.a();
        if (r4 == null) goto L4;
        long r5 = System.currentTimeMillis();
        FindMonitorInfo r14 = new FindMonitorInfo(null, false, null, null, 0, 0, 63, null);
        File r7 = findImageCacheFile(r4);
        r14.setCostTime(System.currentTimeMillis() - r5);
        boolean r6 = true;
        if (r7 != null) goto L10;
    L12:
        boolean r9 = false;
    L13:
        r14.setHasCache(r9);
        r14.setCacheKey(r4);
        r14.setCacheLevel(r2.b());
        if (r7 == null) goto L16;
        long r10 = r7.length();
    L17:
        r14.setCacheSize(r10);
        r21.invoke(r14);
        if (r7 != null) goto L20;
    L22:
        r6 = false;
    L23:
        if (r6 == false) goto L4;
        Log.i("ImageCacheFinder", "findImageCache, key:" + r2 + ", cache:" + r7.getPath());
        return new c(r4, r7);
    L20:
        if (r7.exists() != true) goto L22;
    L16:
        r10 = 0;
        goto L17
    L10:
        if (r7.exists() != true) goto L12;
        r9 = true;
        goto L13
    L26:
        Log.i("ImageCacheFinder", "findImageCache, has no cache");
        return null;
    }

    private final File findImageCacheFileInner(String r4, Function0<String> r5) {
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return null;
    L9:
        LruCache<String, String> r1 = sMemoryCache;
        String r2 = r1.get(r4);
        if (r2 != null) goto L12;
        r2 = (String) r5.invoke();
    L12:
        if (r2 != null) goto L14;
    L16:
        r1.remove(r4);
        return null;
    L14:
        if (FileUtils.r(r2) == false) goto L16;
        r1.put(r4, r2);
        return new PolarisFileWrapper(r2);
    L5:
        r0 = false;
        goto L7
    }
}
