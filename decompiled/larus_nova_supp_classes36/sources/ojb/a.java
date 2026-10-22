package ojb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends RequestOptions {
    public final BaseRequestOptions autoClone() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.autoClone();
    }

    public final BaseRequestOptions centerCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.centerCrop();
    }

    public final BaseRequestOptions centerInside() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.centerInside();
    }

    public final BaseRequestOptions circleCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.circleCrop();
    }

    public final BaseRequestOptions clone() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.clone();
    }

    public final BaseRequestOptions disallowHardwareConfig() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.disallowHardwareConfig();
    }

    public final BaseRequestOptions dontAnimate() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.dontAnimate();
    }

    public final BaseRequestOptions dontTransform() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.dontTransform();
    }

    public final BaseRequestOptions fitCenter() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.fitCenter();
    }

    public final BaseRequestOptions lock() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.lock();
    }

    public final BaseRequestOptions optionalCenterCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalCenterCrop();
    }

    public final BaseRequestOptions optionalCenterInside() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalCenterInside();
    }

    public final BaseRequestOptions optionalCircleCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalCircleCrop();
    }

    public final BaseRequestOptions optionalFitCenter() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalFitCenter();
    }

    public a() {
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final Object m1820clone() throws CloneNotSupportedException {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.clone();
    }

    public final a a(BaseRequestOptions<?> r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.apply(r1);
    }

    public final /* bridge */ /* synthetic */ BaseRequestOptions apply(BaseRequestOptions r1) {
        return a(r1);
    }

    public final BaseRequestOptions decode(Class r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.decode(r1);
    }

    public final BaseRequestOptions diskCacheStrategy(DiskCacheStrategy r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.diskCacheStrategy(r1);
    }

    public final BaseRequestOptions downsample(DownsampleStrategy r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.downsample(r1);
    }

    public final BaseRequestOptions encodeFormat(Bitmap.CompressFormat r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.encodeFormat(r1);
    }

    public final BaseRequestOptions encodeQuality(int r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.encodeQuality(r1);
    }

    public final BaseRequestOptions error(int r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.error(r1);
    }

    public final BaseRequestOptions fallback(int r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.fallback(r1);
    }

    public final BaseRequestOptions format(DecodeFormat r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.format(r1);
    }

    public final BaseRequestOptions frame(long r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.frame(r1);
    }

    public final BaseRequestOptions onlyRetrieveFromCache(boolean r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.onlyRetrieveFromCache(r1);
    }

    public final BaseRequestOptions optionalTransform(Transformation r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalTransform(r1);
    }

    public final BaseRequestOptions override(int r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.override(r1);
    }

    public final BaseRequestOptions placeholder(int r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.placeholder(r1);
    }

    public final BaseRequestOptions priority(Priority r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.priority(r1);
    }

    public final BaseRequestOptions signature(Key r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.signature(r1);
    }

    public final BaseRequestOptions sizeMultiplier(float r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.sizeMultiplier(r1);
    }

    public final BaseRequestOptions skipMemoryCache(boolean r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.skipMemoryCache(r1);
    }

    public final BaseRequestOptions theme(Resources.Theme r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.theme(r1);
    }

    public final BaseRequestOptions timeout(int r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.timeout(r1);
    }

    public final BaseRequestOptions transform(Transformation r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(r1);
    }

    @SafeVarargs
    public final BaseRequestOptions transforms(Transformation[] r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transforms(r1);
    }

    public final BaseRequestOptions useAnimationPool(boolean r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.useAnimationPool(r1);
    }

    public final BaseRequestOptions useUnlimitedSourceGeneratorsPool(boolean r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.useUnlimitedSourceGeneratorsPool(r1);
    }

    public final BaseRequestOptions error(Drawable r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.error(r1);
    }

    public final BaseRequestOptions fallback(Drawable r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.fallback(r1);
    }

    public final BaseRequestOptions placeholder(Drawable r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.placeholder(r1);
    }

    @SafeVarargs
    public final BaseRequestOptions transform(Transformation[] r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(r1);
    }

    public final BaseRequestOptions optionalTransform(Class r1, Transformation r2) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalTransform(r1, r2);
    }

    public final BaseRequestOptions override(int r1, int r2) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.override(r1, r2);
    }

    public final BaseRequestOptions set(Option r1, Object r2) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.set(r1, r2);
    }

    public final BaseRequestOptions transform(Class r1, Transformation r2) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(r1, r2);
    }

    public final BaseRequestOptions gifLimit(int r1, int r2, int r3) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.gifLimit(r1, r2, r3);
    }

    public final BaseRequestOptions transform(Class r1, Transformation r2, boolean r3) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(r1, r2, r3);
    }
}
