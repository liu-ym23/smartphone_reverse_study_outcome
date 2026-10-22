package com.ss.android.lark.image.impl.compress2;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ImageCompressor {
    private final Context mContext;
    private IParamsProvider mParamsProvider;
    private String mTargetDir;

    private void notifyError(Throwable r1, boolean r2) {
    }

    private void notifyStart(boolean r1) {
    }

    private void notifySuccess(CompressResult r1, boolean r2) {
    }

    private ImageCompressor(Context r1) {
        this.mContext = r1;
    }

    private CompressRequest buildRequest(IImageSource r2) {
        return CompressRequest.newBuilder().iImageSource(r2).build();
    }

    public static ImageCompressor with(Context r1) {
        return new ImageCompressor(r1);
    }

    public ImageCompressor paramsProvider(IParamsProvider r1) {
        this.mParamsProvider = r1;
        return this;
    }

    public CompressResult startCompress(File r2) {
        return doCompress(new FileImageSource(r2), false);
    }

    public ImageCompressor targetDir(String r1) {
        this.mTargetDir = r1;
        return this;
    }

    private CompressResult doCompress(IImageSource r4, boolean r5) {
        notifyStart(r5);
        CompressResult r6 = new CompressEngine(new CompressImageCache(this.mContext, this.mTargetDir), new CompressStrategy(this.mParamsProvider)).compress(buildRequest(r4));     // Catch: Exception -> L5
        notifySuccess(r6, r5);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        e.printStackTrace();
        notifyError(e, r5);
        return new CompressResult(e);
    }
}
