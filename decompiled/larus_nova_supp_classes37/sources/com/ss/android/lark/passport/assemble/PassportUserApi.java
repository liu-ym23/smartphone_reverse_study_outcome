package com.ss.android.lark.passport.assemble;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.entity.LoginInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import com.ss.android.lark.utils.LarkContext;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(xzb.a.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010!\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\"H\u0016¨\u0006%"}, d2 = {"Lcom/ss/android/lark/passport/assemble/PassportUserApi;", "Lcom/ss/android/lark/passport_user/api/IPassportUserApi;", "<init>", "()V", "getUserId", "", "getForegroundUser", "Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "getSessions", "", "Lcom/ss/android/lark/passport/signinsdk_api/account/SessionInfo;", "getTenantId", "isCustomer", "", "isPrimaryHost", "isSmallBUser", "getLoginInfo", "Lcom/ss/android/lark/passport/signinsdk_api/entity/LoginInfo;", "getSession", "getTenantName", "getUserName", "isLogin", "registerLoginListener", "", "listener", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/login/OnLoginListener;", "unregisterLoginListener", "registerLogoutListener", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/logout/OnLogoutListener;", "unregisterLogoutListener", "registerUserSwitchListener", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/OnUserSwitchListener;", "unregisterUserSwitchListener", "registerUserListChangeListener", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/OnUserListChangeListener;", "unregisterUserListChangeListener", "Companion", "passport-officesdk-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PassportUserApi implements xzb.a {
    public static final a Companion = null;
    public static final String TAG = "PassportUserApi";
    private static final Set<nzb.b> loginListeners = null;
    private static final Set<ozb.c> logoutListeners = null;
    private static final Set<mzb.a> userListChangeListeners = null;

    public static final class a {
        public a() {
        }
    }

    public PassportUserApi() {
    }

    @Override // xzb.a
    public void registerUserSwitchListener(qzb.a r1) {
    }

    @Override // xzb.a
    public void unregisterUserSwitchListener(qzb.a r1) {
    }

    static {
        Companion = new a();
        LinkedHashSet r0 = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        loginListeners = Collections.synchronizedSet(r0);
        LinkedHashSet r1 = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        logoutListeners = Collections.synchronizedSet(r1);
        LinkedHashSet r2 = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        userListChangeListeners = Collections.synchronizedSet(r2);
    }

    public User getForegroundUser() {
        User r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new User();
    }

    @Override // xzb.a
    public String getUserId() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).c();
    }

    public boolean isLogin() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin();
    }

    public LoginInfo getLoginInfo() {
        User r0 = getForegroundUser();
        String r1 = null;
        if (r0 == null) goto L16;
        LoginInfo r2 = new LoginInfo();
        r2.setSession(r0.getSession());
        r2.setSessionUuid(r0.getSessionUuid());
        r2.setSessionInfoMap(r0.getSessionWithDomainMap());
        r2.setUserId(r0.userId);
        r2.setUserName(b0c.a.a(r0));
        r2.setUserNameEn(r0.getUserNameEn());
        r2.setAvatarUrl(r0.avatarUrl);
        r2.setAvatarKey(r0.avatarKey);
        Tenant r3 = r0.tenant;
        if (r3 == null) goto L8;
        String r4 = r3.tenantId;
    L9:
        r2.setTenantId(r4);
        Tenant r5 = r0.tenant;
        if (r5 == null) goto L14;
        r1 = r5.localizedName(((zzb.a) e0c.k.a(com.larksuite.framework.utils.b.a, zzb.a.class)).getLanguageSetting());
        if (r1 != null) goto L14;
        r1 = "";
    L14:
        r2.setTenantName(r1);
        r2.setTenantIconUrl(r0.getTenantIconUrl());
        r2.setTenantCode(r0.getTenantCode());
        ((zzb.a) e0c.k.a(com.larksuite.framework.utils.b.a, zzb.a.class)).a();
        r2.setIdpType("");
        return r2;
    L8:
        r4 = null;
        goto L9
    L16:
        return null;
    }

    @Override // xzb.a
    public String getSession() {
        String r0 = getForegroundUser().getSession();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public Map<String, SessionInfo> getSessions() {
        Map<String, SessionInfo> r0 = getForegroundUser().getSessionWithDomainMap();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return MapsKt.emptyMap();
    }

    @Override // xzb.a
    public String getTenantId() {
        return getForegroundUser().getTenantId();
    }

    public String getTenantName() {
        Tenant r0 = getForegroundUser().tenant;
        if (r0 == null) goto L6;
        String r1 = r0.localizedName(((zzb.a) e0c.k.a(com.larksuite.framework.utils.b.a, zzb.a.class)).getLanguageSetting());
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // xzb.a
    public String getUserName() {
        User r0 = getForegroundUser();
        if (r0 == null) goto L6;
        String r1 = r0.localizedName(((zzb.a) e0c.k.a(com.larksuite.framework.utils.b.a, zzb.a.class)).getLanguageSetting());
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public boolean isCustomer() {
        String r0 = getTenantId();
        int r1 = com.ss.android.lark.passport.signinsdk_api.contants.a.a;
        return Intrinsics.areEqual(r0, UserInfo.NONE_NAME_CARD_ID);
    }

    public boolean isPrimaryHost() {
        String r0 = getTenantId();
        int r1 = com.ss.android.lark.passport.signinsdk_api.contants.a.a;
        return Intrinsics.areEqual(r0, "1");
    }

    public boolean isSmallBUser() {
        return getForegroundUser().isSmallB();
    }

    public static final /* synthetic */ Set access$getLoginListeners$cp() {
        return loginListeners;
    }

    public static final /* synthetic */ Set access$getLogoutListeners$cp() {
        return logoutListeners;
    }

    public static final /* synthetic */ Set access$getUserListChangeListeners$cp() {
        return userListChangeListeners;
    }

    @Override // xzb.a
    public void registerLoginListener(nzb.b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        loginListeners.add(r2);
    }

    @Override // xzb.a
    public void registerLogoutListener(ozb.c r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        logoutListeners.add(r2);
    }

    @Override // xzb.a
    public void registerUserListChangeListener(mzb.a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        userListChangeListeners.add(r2);
    }

    public void unregisterLoginListener(nzb.b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        loginListeners.remove(r2);
    }

    public void unregisterLogoutListener(ozb.c r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        logoutListeners.remove(r2);
    }

    @Override // xzb.a
    public void unregisterUserListChangeListener(mzb.a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        userListChangeListeners.remove(r2);
    }
}
