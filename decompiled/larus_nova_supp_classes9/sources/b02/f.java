package b02;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboIconAnimationView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ ComboIconAnimationView a;

    public f(ComboIconAnimationView r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        ComboIconAnimationView r0 = this.a;
        r0.d = r5;
        r0.d(r5, r0.g.nextInt(10));
    }
}
