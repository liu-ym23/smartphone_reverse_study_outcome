package com.larus.canvas.feature.component.base;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JT\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2,\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\u0002\b\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/canvas/feature/component/base/HttpUrl;", "Lcom/larus/canvas/feature/component/base/ImageRes;", ShareType.URL, "", "<init>", "(Ljava/lang/String;)V", "loadImage", "", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "bizTag", "extra", "Lcom/larus/image/loader/ImageExtra;", "builder", "Lkotlin/Function2;", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "imageUri", "Lkotlin/ExtensionFunctionType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HttpUrl implements ImageRes {
    public final String url;

    public static /* synthetic */ HttpUrl copy$default(HttpUrl r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.url;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.url;
    }

    public final HttpUrl copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, ShareType.URL);
        return new HttpUrl(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof HttpUrl) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.url, ((HttpUrl) r4).url) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "HttpUrl(url=" + this.url + ')';
    }

    public HttpUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, ShareType.URL);
        this.url = r2;
    }

    public final void loadImage(SimpleDraweeView r2, String r3, g r4, Function2<? super PipelineDraweeControllerBuilder, ? super Uri, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Intrinsics.checkNotNullParameter(r5, "builder");
        ImageLoaderKt.v(r2, this.url, r3, r4, r5);
    }

    public static /* synthetic */ void loadImage$default(HttpUrl r1, SimpleDraweeView r2, String r3, g r4, Function2 r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.loadImage(r2, r3, r4, r5);
    }
}
