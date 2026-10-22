package bb8;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.bmhome.banner.BannerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f extends BaseControllerListener<Object> {
    public final /* synthetic */ BannerAdapter a;

    public f(BannerAdapter r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.a.e == false) goto L6;
        r3.start();
        return;
    L6:
        r3.stop();
    }
}
