package r0c;

import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n implements RxScheduledExecutor.Consumer<Throwable> {
    public final /* synthetic */ k a;

    public n(k r1) {
        this.a = r1;
    }

    public final void consume(Object r3) {
        this.a.c();
        Log.e("SavePhotoUrlAction", "save edited photo failed", (Throwable) r3);
        LKUIToast.show(this.a.a, 2131892141);
        k.b(this.a, false);
    }
}
