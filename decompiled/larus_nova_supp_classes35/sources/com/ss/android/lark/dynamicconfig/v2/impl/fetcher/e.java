package com.ss.android.lark.dynamicconfig.v2.impl.fetcher;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.settings.v1.GetCommonSettingsRequest;
import com.bytedance.lark.pb.settings.v1.GetUserSettingsRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.api.AppSettingApiModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {

    public static class a {
        public static final e a = null;

        static {
            a = new e();
        }
    }

    public static InitSDKRequest.EnvV2 c() {
        String r0 = AppSettingApiModule.a().getBrand();
        int r1 = AppSettingApiModule.a().getType();
        if (r1 != 1) goto L5;
        InitSDKRequest.EnvV2.Type r2 = InitSDKRequest.EnvV2.Type.RELEASE;
    L12:
        String r3 = AppSettingApiModule.a().getUnit();
        Log.d("DomainFetcherImpl", "env, brand: " + r0 + ", type: " + r2 + ", unit: " + r3);
        if (TextUtils.isEmpty(r0) == true) goto L19;
        if (r2 == null) goto L19;
        if (TextUtils.isEmpty(r3) == true) goto L19;
        return new InitSDKRequest.EnvV2.Builder().brand(r0).type(r2).unit(r3).build();
    L19:
        return null;
    L5:
        if (r1 != 2) goto L7;
        r2 = InitSDKRequest.EnvV2.Type.STAGING;
        goto L12
    L7:
        if (r1 == 3) goto L9;
        Log.e("DomainFetcherImpl", "type err: " + r1);
        r2 = null;
        goto L12
    L9:
        r2 = InitSDKRequest.EnvV2.Type.PRE_RELEASE;
        goto L12
    }

    public e() {
    }

    public static void b(final e r3, final IGetDataCallback r4) {
        r3.getClass();
        GetUserSettingsRequest.Builder r0 = new GetUserSettingsRequest.Builder().fields(new ArrayList());
        r0.sync_data_strategy(SyncDataStrategy.LOCAL);
        r0.need_domain(Boolean.TRUE);
        r0.fields(CollectionUtils.asList(new String[]{"biz_domain_config"}));
        SdkSender.asynSendRequestNonWrap(Command.GET_USER_SETTINGS, r0, new DomainFetcherImpl$5(r3, r4), new d());
    }

    public static void a(final e r2, InitSDKRequest.EnvV2 r3, final IGetDataCallback r4) {
        r2.getClass();
        GetCommonSettingsRequest.Builder r0 = new GetCommonSettingsRequest.Builder().fields(new ArrayList());
        r0.sync_data_strategy(SyncDataStrategy.LOCAL);
        r0.need_domain(Boolean.TRUE);
        r0.fields(CollectionUtils.asList(new String[]{"biz_domain_config"}));
        r0.env_v2(r3);
        SdkSender.asynSendRequestNonWrap(Command.GET_COMMON_SETTINGS, r0, new DomainFetcherImpl$3(r2, r4), new c());
    }
}
