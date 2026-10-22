package z19;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b extends BaseControllerListener<Object> {
    public b() {
    }

    public final void onFailure(String r3, Throwable r4) {
        super.onFailure(r3, r4);
        FLogger.a.e("AvatarTagView", "[setupAvatarTag] onFailure, e:" + r4);
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, r2, r3);
        FLogger.a.i("AvatarTagView", "[setupAvatarTag] onFinalImageSet");
    }
}
