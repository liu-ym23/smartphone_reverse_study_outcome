package com.obric.memorydata.middleware.api.app;

import com.bytedance.news.common.service.manager.IService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0014H&J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0003H&¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/middleware/api/app/IUserSettings;", "Lcom/bytedance/news/common/service/manager/IService;", "isDataServiceEnabled", "", "hasAgreePrivacy", "hasAgreePrivacyAndLogin", "registerAgreePrivacyListener", "", "listener", "Lcom/obric/memorydata/middleware/api/app/AgreePrivacyListener;", "unregisterAgreePrivacyListener", "getAgreePrivacyUrl", "", "getGlobalMemoryPrivacyUrl", "getUserId", "registerLoginStateListener", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "unregisterLoginStateListener", "isEnterpriseAccount", "registerEnterpriseAccountListener", "Lcom/obric/memorydata/middleware/api/app/EnterpriseAccountListener;", "unregisterEnterpriseAccountListener", "setLoginStateDispatchedListener", "Lcom/obric/memorydata/middleware/api/app/LoginStateDispatchedListener;", "updateAgreePrivacy", "agreePrivacy", "updateIsLogin", "isLogin", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IUserSettings extends IService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        @Deprecated(message = "only for algorithm package", replaceWith = @ReplaceWith(expression = "hasAgreePrivacy()", imports = {}))
        public static boolean a(IUserSettings r2) {
            return ((IUserSettings) ZeusTransformUtils.wrapperContextForParams(r2, IUserSettings.class, "com.obric.memorydata.plugin")).hasAgreePrivacy();
        }
    }

    String getAgreePrivacyUrl();

    String getGlobalMemoryPrivacyUrl();

    String getUserId();

    boolean hasAgreePrivacy();

    boolean hasAgreePrivacyAndLogin();

    @Deprecated(message = "only for algorithm package", replaceWith = @ReplaceWith(expression = "hasAgreePrivacy()", imports = {}))
    boolean isDataServiceEnabled();

    boolean isEnterpriseAccount();

    void registerAgreePrivacyListener(com.obric.memorydata.middleware.api.app.a r1);

    void registerEnterpriseAccountListener(b r1);

    void registerLoginStateListener(d r1);

    void setLoginStateDispatchedListener(c r1);

    void unregisterAgreePrivacyListener(com.obric.memorydata.middleware.api.app.a r1);

    void unregisterEnterpriseAccountListener(b r1);

    void unregisterLoginStateListener(d r1);

    void updateAgreePrivacy(boolean r1);

    void updateIsLogin(boolean r1);
}
