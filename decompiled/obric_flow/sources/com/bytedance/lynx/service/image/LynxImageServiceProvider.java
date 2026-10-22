package com.bytedance.lynx.service.image;

import an.c;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import java.util.Map;
import xn.a;
import xn.d;
import xn.e;
import zf.h;
import zf.i;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxImageServiceProvider implements ILynxImageService, ILynxImageServiceExtension {
    public LynxImageServiceProvider() {
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public boolean canParseUrl(@NonNull String r5) {
        return h.a().canParseUrl(r5);
    }

    @Override // com.lynx.tasm.service.ILynxImageServiceExtension
    @Nullable
    public c createBackgroundImageDrawable(@NonNull Context r5, @NonNull String r10) {
        return h.a().createBackgroundImageDrawable(r5, r10);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void decodeImage(@NonNull e r5, @NonNull d r10) {
        h.a().decodeImage(r5, r10);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void fetchImage(@NonNull e r5, @NonNull d r10, @Nullable a r11, @NonNull Context r12) {
        h.a().fetchImage(r5, r10, r11, r12);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    @Nullable
    public Object getImageSRPostProcessor() {
        h.a().getClass();
        return i.a();
    }

    @Override // com.lynx.tasm.service.ILynxImageServiceExtension
    public void onLynxEnvSetup() {
        h.a().getClass();
        mn.h.i().execute(new so.e(10));
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public boolean pauseAnimation(@NonNull Drawable r5) {
        return h.a().pauseAnimation(r5);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void prefetchImage(@NonNull String r5, @Nullable Object r10, @Nullable Map<String, Object> r11, @Nullable d r12) {
        h.a().prefetchImage(r5, r10, r11, r12);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void releaseAnimDrawable(@NonNull Drawable r5) {
        h.a().getClass();
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void releaseImage(@NonNull e r5) {
        h.a().releaseImage(r5);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public boolean resumeAnimation(@NonNull Drawable r5) {
        return h.a().resumeAnimation(r5);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setCustomImageDecoder(@NonNull Object r5) {
        h.a().setCustomImageDecoder(r5);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setImageCacheChoice(@NonNull String r5, @NonNull Object r10) {
        h.a().setImageCacheChoice(r5, r10);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setImagePlaceHolderHash(@NonNull Object r12, @NonNull Object r13, @NonNull Object r14, @NonNull String r15, @Nullable String r16, int r17, int r18, int r19, int r20, boolean r21) {
        h.a().setImagePlaceHolderHash(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void setImageSRSize(@NonNull Object r5, @NonNull View r10) {
        h.a().setImageSRSize(r5, r10);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public boolean startAnimation(@NonNull Drawable r5) {
        return h.a().startAnimation(r5);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public boolean stopAnimation(@NonNull Drawable r5) {
        return h.a().stopAnimation(r5);
    }

    @Override // com.lynx.tasm.service.ILynxImageService
    public void prefetchImage(@NonNull String r5, @Nullable Object r10, @Nullable Map<String, Object> r11) {
        h.a().prefetchImage(r5, r10, r11, null);
    }
}
