package wx1;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IUserService;
import io.reactivex.functions.Consumer;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ hw.a a;

    public b(hw.a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        IBaseUser r3 = (IBaseUser) r2;
        com.bytedance.android.livesdk.user.f r4 = k.n(IUserService.class).user();
        hw.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(a.a(r4));
        return;
    }
}
