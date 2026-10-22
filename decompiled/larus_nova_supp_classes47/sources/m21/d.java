package m21;

import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkInviteContract$View;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends i21.a {
    public Disposable d;

    @Override // i21.a
    public final void e() {
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public d(AnchorLinkInviteContract$View r1) {
        super(r1);
    }

    @Override // i21.a
    public final void f(final int r6) {
        this.d = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.SECONDS).take(r6 + 1).map(new a(r6)).observeOn(AndroidSchedulers.mainThread()).as(this.c.S90())).subscribe(new b(this), new c(this));
    }
}
