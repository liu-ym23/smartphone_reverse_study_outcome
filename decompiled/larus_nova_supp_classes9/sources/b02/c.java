package b02;

import android.graphics.Bitmap;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboIconAnimationView;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ ComboIconAnimationView a;

    public c(ComboIconAnimationView r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        ComboIconAnimationView r6 = this.a;
        Bitmap r0 = r6.d;
        if (r0 == null) goto L5;
        r6.d(r0, r6.g.nextInt(10));
        return;
    L5:
        h2 r1 = GiftManagerKt.l(r6.a);
        if (r1 == null) goto L10;
        py.k r2 = r1.getImage();
        if (r2 == null) goto L10;
        Disposable r3 = a1.k(r2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r6));
    L11:
        r6.c = r3;
        return;
    L10:
        r3 = null;
        goto L11
    }
}
