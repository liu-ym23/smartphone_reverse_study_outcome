package com.ss.android.lark.framework.assembly.rust;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.basic.v1.LeanModeCfg;
import com.bytedance.lark.pb.basic.v1.LockScreenCfg;
import com.bytedance.lark.pb.tool.v1.LeanModeConfig;
import com.bytedance.lark.pb.tool.v1.MakeUserOnlineV2Request;
import com.bytedance.lark.pb.tool.v1.NamedUserExtraInfo;
import com.bytedance.lark.pb.tool.v1.UserDeviceInfo;
import com.bytedance.lark.pb.tool.v1.UserLoginState;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.LeanModeInfo;
import com.ss.android.lark.passport.signinsdk_api.env.EnvironmentType;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p {
    public final jdb.e a;
    public final apb.a b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EnvironmentType.values().length];
            r0[EnvironmentType.RELEASE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[EnvironmentType.PRE_RELEASE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[EnvironmentType.STAGING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Inject
    public p(jdb.e r2, apb.a r3) {
        Intrinsics.checkNotNullParameter(r2, "globalFgService");
        Intrinsics.checkNotNullParameter(r3, "globalLanguageService");
        this.a = r2;
        this.b = r3;
    }

    public final MakeUserOnlineV2Request.Builder a(String r19, String r20, String r21, int r22, LeanModeInfo r23, kzb.a r24, Pair<String, String> r25) {
        Intrinsics.checkNotNullParameter(r19, "session");
        Intrinsics.checkNotNullParameter(r20, "userId");
        Intrinsics.checkNotNullParameter(r24, "userEnvironment");
        if (r25 != null) goto L5;
        Log.e("RustSDK", "deviceId installId is null");
    L5:
        String r8 = this.b.g();
        String r9 = com.suite.lark.platform.component.storage.file.dirs.k.a.a(LarkContext.getApplication(), "ImSdkInit");
        if (r23 != null) goto L8;
        LeanModeConfig r4 = null;
    L12:
        NamedUserExtraInfo.Builder r12 = new NamedUserExtraInfo.Builder();
        Map r13 = this.a.getUsedFGMap(r20, "_normal_fg");
        if (CollectionUtils.isEmpty(r13) == true) goto L15;
        Log.e("RustSDK", "usedFGMap: " + r13);
        r12.used_immutable_feature_gating(r13);
    L16:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L25;
        Set r10 = this.a.getRuntimeFGSPCache(r20, "_normal_fg");
        if (CollectionUtils.isNotEmpty(r10) == false) goto L25;
        HashMap r14 = new HashMap();
        Iterator r11 = r10.iterator();
    L22:
        if (r11.hasNext() == false) goto L24;
        r14.put((String) r11.next(), "");
        goto L22
    L24:
        r12.client_fg_data(r14);
    L25:
        r12.tenant_tag(NamedUserExtraInfo.TenantTag.fromValue(r22));
        InitSDKRequest.EnvV2.Builder r15 = new InitSDKRequest.EnvV2.Builder();
        r15.geo = r24.c;
        r15.unit = r24.b;
        r15.brand = r24.a;
        int r16 = b.a[r24.getType().ordinal()];
        if (r16 != 1) goto L28;
        r15.type = InitSDKRequest.EnvV2.Type.RELEASE;
    L36:
        r15.type = InitSDKRequest.EnvV2.Type.fromValue(r24.getType().ordinal() + 1);
        UserDeviceInfo.Builder r5 = new UserDeviceInfo.Builder();
        if (r25 == null) goto L39;
        r5.device_id = (String) r25.getFirst();
        Log.i("RustSDK", "deviceId is " + ((String) r25.getFirst()));
        r5.install_id = (String) r25.getSecond();
        Log.i("RustSDK", "installId is " + ((String) r25.getSecond()));
    L39:
        r5.device_platform = "android";
        r5.app_name = UIHelper.getAppName();
        r5.settings_queries(f3c.a.a());
        MakeUserOnlineV2Request.Builder r1 = new MakeUserOnlineV2Request.Builder().user_id(Long.valueOf(CastLongProtector.parseLong(r20))).access_token(r19).locale_identifier(r8);
        LarkAppContext.Companion.getClass();
        MakeUserOnlineV2Request.Builder r2 = r1.enable_background_mode(Boolean.valueOf(LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK())).client_avatar_path(r9).user_extra_info(r12.build());
        if (r4 == null) goto L42;
        Log.i("RustSDK", "asyncMakeUserOnline isValid: leanModeConfig not null");
        r2.lean_mode_config(r4);
    L42:
        if (r21 != null) goto L44;
    L46:
        r2.prior_user_state = UserLoginState.OFFLINE;
        r2.env_v2 = r15.build();
        r2.user_device_info = r5.build();
        int r3 = c0.a;
        Intrinsics.checkNotNullParameter(r20, "userId");
        opb.e r6 = opb.e.a.a;
        r6.getClass();
        long r7 = System.currentTimeMillis();
        if (r6.h == true) goto L49;
        boolean r17 = false;
    L56:
        if (r17 == false) goto L58;
        r6.c();
        List r18 = CollectionsKt.toList(r6.b);
    L59:
        if (r18 == null) goto L61;
        r2.settings_fields(r18);
    L61:
        AtomicLong r0 = com.bytedance.lark.sdk.refactor.p.a;
        Intrinsics.checkNotNullParameter(r20, "userId");
        long r26 = com.bytedance.lark.sdk.refactor.p.a.incrementAndGet();
        com.bytedance.lark.sdk.refactor.p.b.put(r20, Long.valueOf(r26));
        r2.client_session_id = Long.valueOf(r26);
        return r2;
    L58:
        r18 = null;
        goto L59
    L49:
        com.ss.android.lark.storage.kv.repo.a r27 = spb.a.a();
        long r28 = r27.getLong("settings_last_version_code", 0);
        long r110 = ApkUtil.getAppVersionCode(LarkContext.getApplication());
        String r111 = "sync_update_settings_" + r20 + "_" + r110;
        if (r110 == r28) goto L52;
        r27.remove("sync_update_settings_" + r20 + "_" + r28);
        r27.putLong("settings_last_version_code", r110);
    L52:
        boolean r29 = r27.getBoolean(r111, true);
        r6.h = r29;
        if (r29 == false) goto L55;
        r27.putBoolean(r111, false);
    L55:
        Log.i("AppSettingService", "isUserFirstLogin: " + r6.h + ", cost: " + (System.currentTimeMillis() - r7) + " ms");
        r17 = r6.h;
        goto L56
    L44:
        if (Intrinsics.areEqual(r21, "") == true) goto L46;
        r2.tenant_id(Long.valueOf(CastLongProtector.parseLong(r21)));
        goto L46
    L28:
        if (r16 != 2) goto L30;
        r15.type = InitSDKRequest.EnvV2.Type.PRE_RELEASE;
        goto L36
    L30:
        if (r16 != 3) goto L33;
        r15.type = InitSDKRequest.EnvV2.Type.STAGING;
        goto L36
    L33:
        throw new NoWhenBranchMatchedException();
    L15:
        Log.e("RustSDK", "usedFGMap: empty");
        goto L16
    L8:
        if (TextUtils.isEmpty(r23.lockScreenPwd) == false) goto L10;
        r23.lockScreenPwd = "";
    L10:
        r4 = new LeanModeConfig.Builder().lean_mode_cfg(new LeanModeCfg.Builder().device_have_authority(Boolean.valueOf(r23.deviceHaveAuthority)).can_use_lean_mode(Boolean.valueOf(r23.canUseLeanMode)).lean_mode_cfg_updated_at_micro_sec(Long.valueOf(r23.leanModeCfgUpdateTime)).all_devices_in_lean_mode(Boolean.valueOf(r23.allDevicesInLeanMode)).build()).lock_screen_cfg(new LockScreenCfg.Builder().is_lock_screen_enabled(Boolean.valueOf(r23.isLockScreenEnabled)).lock_screen_password(r23.lockScreenPwd).lock_screen_cfg_updated_at_micro_sec(Long.valueOf(r23.lockScreenCfgUpdateTime)).build()).build();
        goto L12
    }
}
