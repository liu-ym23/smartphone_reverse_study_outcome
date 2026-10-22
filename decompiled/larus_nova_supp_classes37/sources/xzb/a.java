package xzb;

import kotlin.Deprecated;
import nzb.b;
import ozb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    @Deprecated(message = "use com.ss.android.lark.passport_user.api.container.ILarkUserListApi instead")
    String getSession();

    @Deprecated(message = "use com.ss.android.lark.passport_user.api.container.ILarkUserListApi instead")
    String getTenantId();

    @Deprecated(message = "use com.ss.android.lark.passport_user.api.container.ILarkUserListApi instead")
    String getUserId();

    @Deprecated(message = "use com.ss.android.lark.passport_user.api.container.ILarkUserListApi instead")
    String getUserName();

    void registerLoginListener(b r1);

    void registerLogoutListener(c r1);

    void registerUserListChangeListener(mzb.a r1);

    void registerUserSwitchListener(qzb.a r1);

    void unregisterUserListChangeListener(mzb.a r1);

    void unregisterUserSwitchListener(qzb.a r1);
}
