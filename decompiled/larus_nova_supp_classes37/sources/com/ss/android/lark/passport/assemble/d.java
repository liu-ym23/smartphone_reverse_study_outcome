package com.ss.android.lark.passport.assemble;

import com.ss.android.lark.passport.signinsdk_api.account.TenantInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport_user.api.IUserListService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class d implements yzb.b {
    public final IUserListService a;

    @Override // yzb.b
    public final String c() {
        User r0 = this.a.getForegroundUser();
        if (r0 == null) goto L6;
        String r1 = r0.userId;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // yzb.b
    public final List<User> getAllValidUserList() {
        return this.a.getAllValidUserList();
    }

    @Override // yzb.b
    public final User getForegroundUser() {
        return this.a.getForegroundUser();
    }

    @Override // yzb.b
    public final String d() {
        User r0 = getForegroundUser();
        if (r0 == null) goto L6;
        String r1 = r0.userId;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // yzb.b
    public final boolean isLogin() {
        if (getForegroundUser() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Inject
    public d(IUserListService r2) {
        Intrinsics.checkNotNullParameter(r2, "userListService");
        this.a = r2;
    }

    @Override // yzb.b
    public final User a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        l r3 = this.a.s(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.a;
    }

    @Override // yzb.b
    public final TenantInfo b(User r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        return new TenantInfo();
    }
}
