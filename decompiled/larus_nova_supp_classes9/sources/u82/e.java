package u82;

import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.MediaAnchorLinkInviteFragment;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends t82.b {
    public Disposable d;

    @Override // t82.b
    public final void c() {
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public e(MediaAnchorLinkInviteFragment r1) {
        super(r1);
    }

    @Override // t82.b
    public final void d(int r5) {
        this.d = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.SECONDS).take(11).map(new b()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.c.d.getLifecycleOwner()))).subscribe(new c(this), new d(this));
    }
}
