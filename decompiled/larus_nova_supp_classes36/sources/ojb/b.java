package ojb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<TranscodeType> extends RequestBuilder<TranscodeType> {
    public final RequestBuilder getDownloadOnlyRequest() {
        return (b) super.apply(RequestBuilder.DOWNLOAD_ONLY_OPTIONS);
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

    public final RequestBuilder clone() {
        return (b) super.clone();
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

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final BaseRequestOptions m1822clone() {
        return (b) super.clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final Object m1823clone() throws CloneNotSupportedException {
        return (b) super.clone();
    }

    public final RequestBuilder addListener(RequestListener r1) {
        return (b) super.addListener(r1);
    }

    public final RequestBuilder apply(BaseRequestOptions r1) {
        return (b) super.apply(r1);
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

    public final RequestBuilder error(RequestBuilder r1) {
        return (b) super.error(r1);
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

    public final RequestBuilder listener(RequestListener r1) {
        return (b) super.listener(r1);
    }

    public final RequestBuilder load(Bitmap r1) {
        return (b) super.load(r1);
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

    public final RequestBuilder thumbnail(float r1) {
        return (b) super.thumbnail(r1);
    }

    public final BaseRequestOptions timeout(int r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.timeout(r1);
    }

    public final BaseRequestOptions transform(Transformation r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(r1);
    }

    public final BaseRequestOptions transforms(Transformation[] r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transforms(r1);
    }

    public final RequestBuilder transition(TransitionOptions r1) {
        return (b) super.transition(r1);
    }

    public final BaseRequestOptions useAnimationPool(boolean r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.useAnimationPool(r1);
    }

    public final BaseRequestOptions useUnlimitedSourceGeneratorsPool(boolean r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.useUnlimitedSourceGeneratorsPool(r1);
    }

    /* JADX INFO: renamed from: apply, reason: collision with other method in class */
    public final BaseRequestOptions m1821apply(BaseRequestOptions r1) {
        return (b) super.apply(r1);
    }

    public final BaseRequestOptions error(int r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.error(r1);
    }

    public final BaseRequestOptions fallback(Drawable r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.fallback(r1);
    }

    public final RequestBuilder load(Drawable r1) {
        return (b) super.load(r1);
    }

    public final BaseRequestOptions placeholder(Drawable r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.placeholder(r1);
    }

    public final RequestBuilder thumbnail(RequestBuilder r1) {
        return (b) super.thumbnail(r1);
    }

    public final BaseRequestOptions transform(Transformation[] r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(r1);
    }

    public final BaseRequestOptions error(Drawable r1) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.error(r1);
    }

    public final RequestBuilder load(Uri r1) {
        return (b) super.load(r1);
    }

    @SafeVarargs
    public final RequestBuilder thumbnail(RequestBuilder[] r1) {
        return (b) super.thumbnail(r1);
    }

    public final RequestBuilder load(File r1) {
        return (b) super.load(r1);
    }

    public final RequestBuilder load(Integer r1) {
        return (b) super.load(r1);
    }

    public final RequestBuilder load(Object r1) {
        return (b) super.load(r1);
    }

    public final RequestBuilder load(String r1) {
        return (b) super.load(r1);
    }

    public final RequestBuilder load(URL r1) {
        return (b) super.load(r1);
    }

    public final RequestBuilder load(byte[] r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1824load(Bitmap r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1825load(Drawable r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1826load(Uri r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1827load(File r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1828load(Integer r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1829load(Object r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1830load(String r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1831load(URL r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1832load(byte[] r1) {
        return (b) super.load(r1);
    }

    public b(Class<TranscodeType> r1, RequestBuilder<?> r2) {
        super(r1, r2);
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

    public b(Glide r1, RequestManager r2, Class<TranscodeType> r3, Context r4) {
        super(r1, r2, r3, r4);
    }
}
