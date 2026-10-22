package com.ss.android.lark.image;

import android.app.Fragment;
import android.content.Context;
import android.view.View;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.Request;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.impl.GlideImageLoader;
import com.ss.android.lark.image.impl.RequestCreatorContainer;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ImageLoader {
    private static final String TAG = "ImageLoader";
    private static a sDependency;
    private static final rkb.c sImagerLoaderProxy = null;

    public interface a {
        GlideExecutor getCustomSourceExecutor(Object r1);

        boolean hasImageCache(String r1);

        void reportError(String r1, String r2);
    }

    public ImageLoader() {
    }

    static {
        sImagerLoaderProxy = new GlideImageLoader();
        sDependency = (a) ApiUtils.getApi(a.class);
    }

    public static a getDependency() {
        return sDependency;
    }

    public static void clear(View r1) {
        sImagerLoaderProxy.clear(r1);
    }

    public static void clearMemoryCache(Context r1) {
        sImagerLoaderProxy.clearMemoryCache(r1);
    }

    public static Request getRequest(View r2) {
        Object r3 = r2.getTag(2131373828);
        if (r3 != null) goto L5;
    L8:
        return null;
    L5:
        if ((r3 instanceof Request) == true) goto L10;
        Log.w(TAG, "getRequest:" + r3.getClass());
        goto L8
    L10:
        return (Request) r3;
    }

    public static IRequestCreator with(Fragment r2) {
        return new RequestCreatorContainer(sImagerLoaderProxy, r2);
    }

    public static IRequestCreator with(Context r2) {
        return new RequestCreatorContainer(sImagerLoaderProxy, r2);
    }

    public static IRequestCreator with(androidx.fragment.app.Fragment r2) {
        return new RequestCreatorContainer(sImagerLoaderProxy, r2);
    }

    public static void setRequest(View r1, Request r2) {
        r1.setTag(2131373828, r2);
    }

    public static <T extends Key, Y> void registerLoadModelHook(Context r1, Class<T> r2, Class<Y> r3, rkb.e<T, Y> r4) {
        sImagerLoaderProxy.registerLoadModelHook(r1, r2, r3, r4);
    }
}
