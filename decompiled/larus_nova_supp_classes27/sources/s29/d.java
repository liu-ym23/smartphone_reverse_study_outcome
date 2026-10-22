package s29;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d extends BaseControllerListener<Object> {
    public d() {
    }

    public final void onFailure(String r3, Throwable r4) {
        m29.a.c("CreationSelfPrivateViewHolder", "cover image failed");
        super.onFailure(r3, r4);
    }

    public final void onSubmit(String r3, Object r4) {
        m29.a.c("CreationSelfPrivateViewHolder", "cover image submit");
        super.onSubmit(r3, r4);
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, r2, r3);
        m29.a.c("CreationSelfPrivateViewHolder", "cover image set");
    }
}
