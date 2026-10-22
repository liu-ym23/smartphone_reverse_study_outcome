package com.larus.canvas.feature.component.base;

import android.net.Uri;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JH\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2,\u0010\f\u001a(\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0002\b\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/canvas/feature/component/base/LocalFilePath;", "Lcom/larus/canvas/feature/component/base/ImageRes;", MusicAppletPage.KEY_PATH, "", "<init>", "(Ljava/lang/String;)V", "loadImage", "", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "extra", "Lcom/larus/image/loader/ImageExtra;", "builder", "Lkotlin/Function2;", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "imageUri", "Lkotlin/ExtensionFunctionType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalFilePath implements ImageRes {
    public final String path;

    public static /* synthetic */ LocalFilePath copy$default(LocalFilePath r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.path;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.path;
    }

    public final LocalFilePath copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, MusicAppletPage.KEY_PATH);
        return new LocalFilePath(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof LocalFilePath) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.path, ((LocalFilePath) r4).path) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.path.hashCode();
    }

    public String toString() {
        return "LocalFilePath(path=" + this.path + ')';
    }

    public LocalFilePath(String r2) {
        Intrinsics.checkNotNullParameter(r2, MusicAppletPage.KEY_PATH);
        this.path = r2;
    }

    public final void loadImage(SimpleDraweeView r3, g r4, Function2<? super PipelineDraweeControllerBuilder, ? super Uri, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "imageView");
        Intrinsics.checkNotNullParameter(r5, "builder");
        ImageLoaderKt.v(r3, com.larus.canvas.feature.component.logic.helper.a.a(this.path), null, r4, r5);
    }

    public static /* synthetic */ void loadImage$default(LocalFilePath r0, SimpleDraweeView r1, g r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.loadImage(r1, r2, r3);
    }
}
