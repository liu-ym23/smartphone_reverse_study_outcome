package ojb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends RequestManager {
    public final RequestBuilder asBitmap() {
        return (b) super.asBitmap();
    }

    public final RequestBuilder asDrawable() {
        return (b) super.asDrawable();
    }

    public final RequestBuilder asFile() {
        return (b) super.asFile();
    }

    public final RequestBuilder asGif() {
        return (b) super.asGif();
    }

    public final RequestBuilder downloadOnly() {
        return (b) super.downloadOnly();
    }

    public final RequestManager addDefaultRequestListener(RequestListener r1) {
        return (c) super.addDefaultRequestListener(r1);
    }

    public final RequestManager applyDefaultRequestOptions(RequestOptions r1) {
        monitor-enter(this);
        c r2 = (c) super.applyDefaultRequestOptions(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    public final RequestBuilder as(Class r4) {
        return new b(((RequestManager) this).glide, this, r4, ((RequestManager) this).context);
    }

    public final RequestBuilder download(Object r1) {
        return (b) super.download(r1);
    }

    public final RequestBuilder load(Bitmap r1) {
        return (b) super.load(r1);
    }

    public final RequestManager setDefaultRequestOptions(RequestOptions r1) {
        monitor-enter(this);
        c r2 = (c) super.setDefaultRequestOptions(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    public final void setRequestOptions(RequestOptions r2) {
        if ((r2 instanceof a) == false) goto L5;
        super.setRequestOptions(r2);
        return;
    L5:
        super.setRequestOptions(new a().a(r2));
    }

    public final RequestBuilder load(Drawable r1) {
        return (b) super.load(r1);
    }

    public final RequestBuilder load(Uri r1) {
        return (b) super.load(r1);
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
    public final Object m1833load(Bitmap r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1834load(Drawable r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1835load(Uri r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1836load(File r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1837load(Integer r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1838load(Object r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1839load(String r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1840load(URL r1) {
        return (b) super.load(r1);
    }

    /* JADX INFO: renamed from: load, reason: collision with other method in class */
    public final Object m1841load(byte[] r1) {
        return (b) super.load(r1);
    }

    public c(Glide r1, Lifecycle r2, RequestManagerTreeNode r3, Context r4) {
        super(r1, r2, r3, r4);
    }
}
