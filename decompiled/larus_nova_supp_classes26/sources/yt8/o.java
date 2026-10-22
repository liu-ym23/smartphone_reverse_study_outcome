package yt8;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.bmhome.viewholder.PhotoVH;
import com.larus.utils.e1;
import com.larus.utils.z0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o extends BaseControllerListener<Object> {
    public final /* synthetic */ PhotoVH a;
    public final /* synthetic */ Function1<Boolean, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public o(PhotoVH r1, Function1<? super Boolean, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r1, Throwable r2) {
        super.onFailure(r1, r2);
        this.b.invoke(Boolean.FALSE);
    }

    public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
        super.onFinalImageSet(r3, r4, r5);
        View r6 = this.a.l;
        if (r6 == null) goto L6;
        e1.o(r6);
    L6:
        if ((r4 instanceof CloseableStaticBitmap) == false) goto L16;
        Bitmap r7 = ((CloseableStaticBitmap) r4).getUnderlyingBitmap();
        if (r7.isRecycled() == false) goto L11;
        this.b.invoke(Boolean.FALSE);
        return;
    L11:
        PhotoVH r8 = this.a;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L14
        ScalingUtils.ScaleType r10 = r8.k.getHierarchy().getActualImageScaleType();     // Catch: Throwable -> L14
        Bitmap r11 = r7.copy(z0.b(r7.getConfig()), r7.isMutable());     // Catch: Throwable -> L14
        r8.k.getHierarchy().setPlaceholderImage(new BitmapDrawable(r11), r10);     // Catch: Throwable -> L14
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        this.b.invoke(Boolean.TRUE);
    }
}
