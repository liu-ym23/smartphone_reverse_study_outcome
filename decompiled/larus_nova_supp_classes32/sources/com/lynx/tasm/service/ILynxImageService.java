package com.lynx.tasm.service;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import java.util.Map;
import v7a.a;
import v7a.e;
import v7a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILynxImageService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxImageService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxImageService r0) {
            return ILynxImageService.class;
        }
    }

    boolean canParseUrl(String r1);

    void decodeImage(f r1, e r2);

    void fetchImage(f r1, e r2, a r3, Context r4);

    int getImageOrigin(Object r1);

    Object getImageSRPostProcessor();

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    boolean pauseAnimation(Drawable r1);

    void prefetchImage(String r1, Object r2, Map<String, Object> r3);

    void prefetchImage(String r1, Object r2, Map<String, Object> r3, e r4);

    void releaseAnimDrawable(Drawable r1);

    void releaseImage(f r1);

    boolean resumeAnimation(Drawable r1);

    void setCacheKeyUri(Object r1, Uri r2);

    void setCustomImageDecoder(Object r1);

    void setImageCacheChoice(String r1, Object r2);

    void setImageDecodeRegion(Object r1, Rect r2);

    void setImagePlaceHolderHash(Object r1, Object r2, Object r3, String r4, String r5, int r6, int r7, int r8, int r9, boolean r10);

    void setImageSRSize(Object r1, int r2, int r3);

    void setImageSRSize(Object r1, View r2);

    void setSampleSize(Object r1, int r2);

    boolean startAnimation(Drawable r1);

    boolean stopAnimation(Drawable r1);
}
