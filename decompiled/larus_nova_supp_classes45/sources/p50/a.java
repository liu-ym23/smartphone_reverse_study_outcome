package p50;

import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    public final /* synthetic */ c a;
    public final /* synthetic */ Function4 b;
    public final /* synthetic */ Uri c;

    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
    }

    public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r9) {
        Intrinsics.checkNotNullParameter(r9, "dataSource");
        if (r9.hasResult() == false) goto L24;
        CloseableReference r11 = (CloseableReference) r9.getResult();
        if (r11 == null) goto L30;
        CloseableAnimatedImage r12 = (CloseableImage) r11.get();
        if (r12 == null) goto L31;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L9:
        if ((r12 instanceof CloseableAnimatedImage) == false) goto L17;
        AnimatedImage r0 = r12.getImage();     // Catch: Throwable -> L19
        if (r0 == null) goto L13;
        int r1 = r0.getFrameCount();     // Catch: Throwable -> L19
    L14:
        int r7 = 0;
    L15:
        if (r7 >= r1) goto L17;
        c.a(this.a, r12, this.b, this.c, r1, r7);     // Catch: Throwable -> L19
        r7 = r7 + 1;     // Catch: Throwable -> L19
        goto L15
    L13:
        r1 = 0;
    L17:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r12, null);
        return;
    L31:
        return;
    L30:
        return;
    }

    public a(c r1, Function4 r2, Uri r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
