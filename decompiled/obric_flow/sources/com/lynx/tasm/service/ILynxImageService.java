package com.lynx.tasm.service;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import xn.a;
import xn.d;
import xn.e;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ILynxImageService extends IServiceProvider {
    boolean canParseUrl(@NonNull String r5);

    void decodeImage(@NonNull e r5, @NonNull d r10);

    void fetchImage(@NonNull e r5, @NonNull d r10, @Nullable a r11, @NonNull Context r12);

    @Nullable
    @Deprecated
    Object getImageSRPostProcessor();

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxImageService.class;
    }

    boolean pauseAnimation(@NonNull Drawable r5);

    void prefetchImage(@NonNull String r5, @Nullable Object r10, @Nullable Map<String, Object> r11);

    void prefetchImage(@NonNull String r5, @Nullable Object r10, @Nullable Map<String, Object> r11, @Nullable d r12);

    void releaseAnimDrawable(@NonNull Drawable r5);

    void releaseImage(@NonNull e r5);

    boolean resumeAnimation(@NonNull Drawable r5);

    @Deprecated
    void setCustomImageDecoder(@NonNull Object r5);

    @Deprecated
    void setImageCacheChoice(@NonNull String r5, @NonNull Object r10);

    @Deprecated
    void setImagePlaceHolderHash(@NonNull Object r5, @NonNull Object r10, @NonNull Object r11, @NonNull String r12, @Nullable String r13, int r14, int r15, int r16, int r17, boolean r18);

    @Deprecated
    void setImageSRSize(@NonNull Object r5, @NonNull View r10);

    boolean startAnimation(@NonNull Drawable r5);

    boolean stopAnimation(@NonNull Drawable r5);
}
