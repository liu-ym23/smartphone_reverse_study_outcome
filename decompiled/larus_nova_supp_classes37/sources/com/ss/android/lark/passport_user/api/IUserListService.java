package com.ss.android.lark.passport_user.api;

import com.ss.android.lark.passport.assemble.l;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface IUserListService {

    public static final enum UserLoginSource extends Enum<UserLoginSource> {
        public static final UserLoginSource ByLogin = null;
        public static final UserLoginSource ByOnPushFetch = null;
        public static final UserLoginSource ByPull = null;
        public static final /* synthetic */ UserLoginSource[] a = null;

        static {
            UserLoginSource r0 = new UserLoginSource("ByPull", 0);
            ByPull = r0;
            UserLoginSource r1 = new UserLoginSource("ByOnPushFetch", 1);
            ByOnPushFetch = r1;
            UserLoginSource r3 = new UserLoginSource("ByLogin", 2);
            ByLogin = r3;
            a = new UserLoginSource[]{r0, r1, r3};
        }

        public static UserLoginSource[] values() {
            return (UserLoginSource[]) a.clone();
        }

        public static UserLoginSource valueOf(String r1) {
            return (UserLoginSource) a.a(UserLoginSource.class, r1);
        }

        public UserLoginSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    List<User> getAllValidUserList();

    User getForegroundUser();

    void q();

    List<String> r();

    l s(String r1);

    void t(List<User> r1, String r2, UserLoginSource r3);

    void u(User r1);
}
