package a0c;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.internal.p;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a implements p {
    public final yzb.b a;

    @Inject
    public a(yzb.b r2) {
        Intrinsics.checkNotNullParameter(r2, "userListApi");
        this.a = r2;
    }

    @Override // com.ss.android.lark.passportc.internal.p
    public final User a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.a.a(r2);
    }
}
