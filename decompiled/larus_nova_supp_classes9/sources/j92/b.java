package j92;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.config.wo0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r4) {
        BaseResponse r5 = (BaseResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "response");
        int r1 = 0;
        if (((Boolean) wo0.a.getValue()).booleanValue() == false) goto L22;
        int r0 = d.a;
        vh7.c r6 = (vh7.c) r5.data;
        vh7.c r2 = null;
        if (r6 != null) goto L7;
        r6 = null;
    L15:
        if ((r6 instanceof Object) == false) goto L18;
        r2 = r6;
    L18:
        User r3 = (User) r2;
        if (r3 == null) goto L21;
        r1 = r3.consumeDiamondLevel;
    L21:
        d.a(r1);
        return;
    L7:
        if ((r6 instanceof vh7.e) == false) goto L15;
        Object r7 = ((vh7.e) r6).getFlexInstance();
        if (r7 == null) goto L12;
        r6 = (vh7.c) r7;
        goto L15
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<T>");
    L22:
        User.a r8 = User.Companion;
        IBaseUser r9 = (IBaseUser) r5.data;
        r8.getClass();
        User r10 = User.a.a(r9);
        int r11 = d.a;
        if (r10 == null) goto L25;
        r1 = r10.consumeDiamondLevel;
    L25:
        d.a(r1);
    }
}
