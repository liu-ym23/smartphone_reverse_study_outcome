package com.obric.memorydata.middleware.api.app;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\t\u0010\b\u001a\u00020\u0005H\u0096\u0001J\t\u0010\t\u001a\u00020\u0005H\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000bH\u0097\u0001J\t\u0010\u000e\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0096\u0001J\u0013\u0010\u0017\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0018H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u000bH\u0096\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/middleware/api/app/UserSettings;", "Lcom/obric/memorydata/middleware/api/app/IUserSettings;", "<init>", "()V", "ACTION_USER_AGREE_STATE_CHANGED", "", "REPO_MEMORY_DATA", "getAgreePrivacyUrl", "getGlobalMemoryPrivacyUrl", "getUserId", "hasAgreePrivacy", "", "hasAgreePrivacyAndLogin", "isDataServiceEnabled", "isEnterpriseAccount", "registerAgreePrivacyListener", "", "listener", "Lcom/obric/memorydata/middleware/api/app/AgreePrivacyListener;", "registerEnterpriseAccountListener", "Lcom/obric/memorydata/middleware/api/app/EnterpriseAccountListener;", "registerLoginStateListener", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "setLoginStateDispatchedListener", "Lcom/obric/memorydata/middleware/api/app/LoginStateDispatchedListener;", "unregisterAgreePrivacyListener", "unregisterEnterpriseAccountListener", "unregisterLoginStateListener", "updateAgreePrivacy", "agreePrivacy", "updateIsLogin", "isLogin", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserSettings implements IUserSettings {
    public static final String ACTION_USER_AGREE_STATE_CHANGED = "com.obric.memorydata.ACTION_USER_AGREE_STATE_CHANGED";
    public static final UserSettings INSTANCE = null;
    public static final String REPO_MEMORY_DATA = "MemoryData";
    private final /* synthetic */ IUserSettings $$delegate_0;

    static {
        INSTANCE = new UserSettings();
    }

    private UserSettings() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IUserSettings.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IUserSettings) ZeusTransformUtils.preCheckCast(r0, IUserSettings.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public String getAgreePrivacyUrl() {
        return this.$$delegate_0.getAgreePrivacyUrl();
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public String getGlobalMemoryPrivacyUrl() {
        return this.$$delegate_0.getGlobalMemoryPrivacyUrl();
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public String getUserId() {
        return this.$$delegate_0.getUserId();
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public boolean hasAgreePrivacy() {
        return this.$$delegate_0.hasAgreePrivacy();
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public boolean hasAgreePrivacyAndLogin() {
        return this.$$delegate_0.hasAgreePrivacyAndLogin();
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    @Deprecated(message = "only for algorithm package", replaceWith = @ReplaceWith(expression = "hasAgreePrivacy()", imports = {}))
    public boolean isDataServiceEnabled() {
        return this.$$delegate_0.isDataServiceEnabled();
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public boolean isEnterpriseAccount() {
        return this.$$delegate_0.isEnterpriseAccount();
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void registerAgreePrivacyListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.registerAgreePrivacyListener(r4);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void registerEnterpriseAccountListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.registerEnterpriseAccountListener(r4);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void registerLoginStateListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.registerLoginStateListener(r4);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void setLoginStateDispatchedListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.$$delegate_0.setLoginStateDispatchedListener(r4);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void unregisterAgreePrivacyListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.unregisterAgreePrivacyListener(r4);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void unregisterEnterpriseAccountListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.unregisterEnterpriseAccountListener(r4);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void unregisterLoginStateListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.unregisterLoginStateListener(r4);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void updateAgreePrivacy(boolean r1) {
        this.$$delegate_0.updateAgreePrivacy(r1);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserSettings
    public void updateIsLogin(boolean r1) {
        this.$$delegate_0.updateIsLogin(r1);
    }
}
