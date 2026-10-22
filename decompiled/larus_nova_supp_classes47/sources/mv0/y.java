package mv0;

import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostDouyinIm;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y extends com.bytedance.android.livesdk.user.h<IBaseUser> {
    public final /* synthetic */ IHostDouyinIm a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ com.bytedance.android.live.base.model.user.b0 c;
    public final /* synthetic */ HashMap d;
    public final /* synthetic */ IHostDouyinIm.IDouyinImLoadingListener e;

    public final void onNext(Object r5) {
        Intrinsics.checkNotNullParameter((IBaseUser) r5, "iUser");
        if (jc1.k.n(IUserService.class).user().isLogin() == false) goto L7;
        this.a.openDouyinImHomePageToUser(this.b.getContext(), this.c.getBaseProfileInfo().getIdStr(), this.d, this.e);
        return;
    }

    public y(IHostDouyinIm r1, Fragment r2, com.bytedance.android.live.base.model.user.b0 r3, HashMap r4, z r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
