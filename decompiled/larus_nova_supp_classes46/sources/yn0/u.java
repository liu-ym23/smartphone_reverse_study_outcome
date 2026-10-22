package yn0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.UserExtra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.user.IUserService;
import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u implements l81.u {
    public static final u a = null;

    public u() {
    }

    static {
        a = new u();
    }

    public final User a(IBaseUser r2) {
        User.Companion.getClass();
        return User.a.a(r2);
    }

    public final Single<BaseResponse<IBaseUser, UserExtra>> r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L7;
        return r1.r(r2);
    L7:
        return null;
    }
}
