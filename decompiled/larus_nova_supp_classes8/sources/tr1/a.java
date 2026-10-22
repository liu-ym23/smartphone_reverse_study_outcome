package tr1;

import android.animation.ObjectAnimator;
import com.bytedance.android.livesdk.chatroom.vs_impl.widget.BusinessScreenBarWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ BusinessScreenBarWidget a;

    public a(BusinessScreenBarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        ObjectAnimator r3 = this.a.h;
        if (r3 == null) goto L5;
        r3.cancel();
    L5:
        ObjectAnimator r4 = this.a.i;
        if (r4 == null) goto L9;
        r4.start();
        return;
    }
}
