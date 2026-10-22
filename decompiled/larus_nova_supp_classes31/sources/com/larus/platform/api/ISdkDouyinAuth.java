package com.larus.platform.api;

import android.os.Bundle;
import com.bytedance.applet.impl.w1;
import com.larus.login.api.CommonDouYinLoginUtil;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J.\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0015H&J8\u0010\u0016\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0015H&J(\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u001cH&J(\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH&J?\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010#H&¢\u0006\u0002\u0010$J*\u0010%\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020&H&J\b\u0010'\u001a\u00020\u0003H&J2\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010,H&J\b\u0010-\u001a\u00020\u0003H&J\b\u0010.\u001a\u00020\u0003H&¨\u0006/"}, d2 = {"Lcom/larus/platform/api/ISdkDouyinAuth;", "", "registerAccountBindStatusListener", "", "listener", "Lcom/larus/platform/api/SdkAccountBindStatusListener;", "unregisterAccountBindStatusListener", "getCachedDouyinToken", "Lcom/larus/platform/api/SdkDouyinToken;", "requestDouyinToken", "forceRequestServer", "triggerScene", "Lcom/larus/platform/api/SdkOauthTokenTriggerScene;", "callback", "Lcom/larus/platform/api/SdkDouyinTokenCallback;", "updateDouyinAccountToken", "Lcom/larus/platform/api/SdkAccountTokenUpdateCallback;", "token", "", "isFromDelete", "extraInfo", "Landroid/os/Bundle;", "updateDouyinProviderToken", "enableBindDirect", "bindDouyin", "platformAppId", "platform", "authCode", "Lcom/larus/platform/api/SdkBindCallback;", "updateDouyinAuthorizeInfo", "startDouyinAuth", "clientKey", "scope", "state", "isMiniApplication", "Lcom/larus/platform/api/SdkDouyinAuthCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/larus/platform/api/SdkDouyinAuthCallback;)Ljava/lang/Boolean;", "checkDouyinAuthStatus", "Lcom/larus/platform/api/SdkDouyinAuthStatusCallback;", "isDouyinHeartbeatImplemented", "tryDouyinHeartbeat", "delay", "", "immediate", "Lcom/larus/platform/api/SdkDouyinHeartbeatCallback;", "clearDouyinHeartbeatTokenCache", "hasDouyinHeartbeatSucceeded", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ISdkDouyinAuth {

    public static final class a {
        public static /* synthetic */ boolean a(ISdkDouyinAuth r6, e5 r7, int r8) {
            if ((r8 & 2) == 0) goto L5;
            boolean r3 = false;
        L7:
            if ((r8 & 4) == 0) goto L9;
            SdkOauthTokenTriggerScene r5 = SdkOauthTokenTriggerScene.Request;
        L11:
            if ((r8 & 8) == 0) goto L14;
            r7 = null;
        L14:
            return r6.d(0, r3, r5, r7);
        L9:
            r5 = null;
            goto L11
        L5:
            r3 = true;
            goto L7
        }
    }

    boolean a(boolean r1, SdkOauthTokenTriggerScene r2, h5 r3);

    g5 b();

    boolean c(w1 r1);

    boolean d(long r1, boolean r3, SdkOauthTokenTriggerScene r4, e5 r5);

    boolean e();

    Boolean f(String r1, String r2, String r3, c5 r4);

    boolean g(String r1, z4 r2);

    boolean h(CommonDouYinLoginUtil.k r1, String r2, boolean r3, Bundle r4);

    boolean i(String r1, String r2, String r3, d5 r4);

    boolean j(String r1, com.larus.login.api.c0 r2);

    boolean k(com.bytedance.applet.aibridge.auth.d r1, String r2, boolean r3, boolean r4, Bundle r5);
}
