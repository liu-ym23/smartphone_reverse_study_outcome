package u82;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public k(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Function1 r0 = this.a;
        User.Companion.getClass();
        r0.invoke(User.a.a((IBaseUser) r3));
    }
}
