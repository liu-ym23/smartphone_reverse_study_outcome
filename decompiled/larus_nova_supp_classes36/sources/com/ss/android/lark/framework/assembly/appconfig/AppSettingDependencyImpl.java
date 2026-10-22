package com.ss.android.lark.framework.assembly.appconfig;

import android.app.Application;
import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.g;
import com.ss.android.lark.storage.BaseKVStorage;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.c;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.util.share_preference.UserSP;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import idb.f;
import kotlin.jvm.internal.Intrinsics;
import yzb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(com.ss.android.lark.appsetting.api.a.class)
public class AppSettingDependencyImpl implements com.ss.android.lark.appsetting.api.a {
    private static final String DEFAULT_LARK_SETTINGS_DOMAIN = "core";
    private static final String DEFAULT_LARK_SETTINGS_NAME = "default_settings";
    private static final String TAG = "AppSettingDependencyImpl";
    gpb.a mLarkEnvironmentApi;
    b mUserListApi;

    public class a implements com.ss.android.lark.appsetting.api.a.a {
        public a() {
        }
    }

    public AppSettingDependencyImpl() {
    }

    private gpb.a getLarkEnvironmentApi() {
        if (this.mLarkEnvironmentApi != null) goto L6;
        this.mLarkEnvironmentApi = (gpb.a) ApiUtils.getApi(gpb.a.class);
    L6:
        return this.mLarkEnvironmentApi;
    }

    private b getUserListApi() {
        if (this.mUserListApi != null) goto L6;
        this.mUserListApi = (b) LarkContext.spiByDwarf(b.class);
    L6:
        return this.mUserListApi;
    }

    public com.ss.android.lark.appsetting.api.a.a getFeatureGatingDependency() {
        return new a();
    }

    public KVRepo getLarkRepo() {
        LarkKVStorage.KVStorageBuilder r0 = new LarkKVStorage.KVStorageBuilder(getContext());
        r0.b = "lark";
        LarkKVStorage.b r1 = LarkKVStorage.r(r0.b());
        com.ss.android.lark.storage.a r2 = new com.ss.android.lark.storage.a(DEFAULT_LARK_SETTINGS_DOMAIN);
        Intrinsics.checkNotNullParameter(r2, "domain");
        r1.b = r2;
        r1.c = DEFAULT_LARK_SETTINGS_NAME;
        return r1.a();
    }

    public String getBrand() {
        if (getLarkEnvironmentApi() != null) goto L7;
        return "feishu";
    L7:
        return getLarkEnvironmentApi().getTenantBrand();
    }

    public Application getContext() {
        return LarkContext.getApplication();
    }

    public int getType() {
        if (getLarkEnvironmentApi() != null) goto L7;
        return 1;
    L7:
        return getLarkEnvironmentApi().envType();
    }

    public String getUid() {
        return getUserListApi().c();
    }

    public String getUnit() {
        if (getLarkEnvironmentApi() != null) goto L7;
        return "eu_nc";
    L7:
        return getLarkEnvironmentApi().getUserUnit();
    }

    public boolean isLogin() {
        return getUserListApi().isLogin();
    }

    public KVRepo getUserRepo(String r7) {
        Context r0 = g.getContext();
        com.ss.android.lark.storage.a r2 = new com.ss.android.lark.storage.a(DEFAULT_LARK_SETTINGS_DOMAIN);
        UserSP r1 = UserSP.getUserSPById(r7);
        if (r1 == null) goto L5;
        n6c.a r4 = new n6c.a(r1);
    L6:
        c r3 = c.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r2, "domain");
        c.a.getClass();
        return BaseKVStorage.c(r0, BaseKVStorage.a(r7), r2, DEFAULT_LARK_SETTINGS_NAME, r4, false);
    L5:
        int r5 = n6c.a.c;
        r4 = null;
        goto L6
    }

    public boolean isCurrentEnable(String r2) {
        return f.a().isCurrentEnable(r2);
    }
}
