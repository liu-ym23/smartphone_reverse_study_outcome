package z19;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ k a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ CircleSimpleDraweeView c;

    public final void onFailure(String r2, Throwable r3) {
        this.c.setCurrentUrl("");
        k r4 = this.a;
        if (r4 == null) goto L6;
        r4.onFailure(r3);
        return;
    }

    public final void onSubmit(String r1, Object r2) {
        super.onSubmit(r1, r2);
        k r3 = this.a;
        if (r3 == null) goto L6;
        r3.b();
        return;
    }

    public h(k r1, Ref.BooleanRef r2, CircleSimpleDraweeView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, (ImageInfo) r2, r3);
        k r4 = this.a;
        if (r4 == null) goto L6;
        r4.a(this.b.element);
        return;
    }
}
