package i11;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final IBaseUser a;
    public final String b;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("InviteeUser{");
        r0.append("user=" + this.a);
        r0.append(",");
        r0.append("panelType=" + this.b);
        r0.append("}");
        return r0.toString();
    }

    public d(IBaseUser r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        this.a = r2;
        this.b = r3;
    }
}
