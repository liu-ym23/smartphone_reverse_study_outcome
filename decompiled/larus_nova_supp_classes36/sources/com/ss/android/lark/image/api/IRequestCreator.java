package com.ss.android.lark.image.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.ss.android.lark.image.transform.CropTransformation;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;
import rkb.g;
import xkb.a;
import xkb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IRequestCreator {
    IRequestCreator asBitmap();

    IRequestCreator asDrawable();

    IRequestCreator asFile();

    IRequestCreator asGif();

    IRequestCreator centerCrop();

    IRequestCreator decodeFormat(DecodeFormat r1);

    IRequestCreator diskCacheStrategy(DiskCacheStrategy r1);

    IRequestCreator dontAnimate(boolean r1);

    File downloadOnly(int r1, int r2) throws InterruptedException, ExecutionException;

    <R> void downloadOnly(Target<R> r1);

    IRequestCreator error(int r1);

    IRequestCreator error(Drawable r1);

    IRequestCreator fitCenter();

    Bitmap getBitmap(int r1, int r2) throws InterruptedException, ExecutionException;

    String getCacheFile(int r1, int r2);

    IRequestCreator gifFileSize(int r1);

    IRequestCreator gifMaxHeight(int r1);

    IRequestCreator gifMaxWidth(int r1);

    void into(ImageView r1);

    <R> void into(Target<R> r1);

    IRequestCreator isAsync(boolean r1);

    IRequestCreator listener(g r1);

    IRequestCreator load(Object r1);

    IRequestCreator onlyRetrieveFromCache(boolean r1);

    IRequestCreator override(int r1, int r2);

    void pauseRequests();

    IRequestCreator placeholder(int r1);

    IRequestCreator placeholder(Drawable r1);

    void resumeRequests();

    IRequestCreator setErrorScaleType(ImageView.ScaleType r1);

    IRequestCreator signature(Key r1);

    IRequestCreator skipMemoryCache(boolean r1);

    IRequestCreator sourceExecutor(GlideExecutor r1);

    IRequestCreator thumbnail(float r1);

    IRequestCreator thumbnail(IRequestCreator r1);

    IRequestCreator transform(Transformation<Bitmap> r1);

    IRequestCreator transform(CropTransformation r1);

    IRequestCreator transform(a r1);

    IRequestCreator transform(b r1);

    IRequestCreator transforms(List<Transformation<Bitmap>> r1);
}
