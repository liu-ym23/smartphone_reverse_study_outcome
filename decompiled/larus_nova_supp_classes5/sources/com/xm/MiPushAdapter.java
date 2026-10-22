package com.xm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.Component;
import com.bytedance.push.utils.ManifestUtils;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ttnet.org.chromium.base.TTProcessUtils;
import com.xiaomi.MiPushSettings;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import j77.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class MiPushAdapter implements IPushAdapter {
    private static int MI_PUSH = -1;

    public MiPushAdapter() {
    }

    public boolean isPushAvailable(Context r1, int r2) {
        return true;
    }

    public void trackPush(Context r1, int r2, Object r3) {
    }

    public static int getMiPush() {
        if (MI_PUSH != (-1)) goto L6;
        MI_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(MiPushAdapter.class.getName());
    L6:
        return MI_PUSH;
    }

    private void doUpgradeMiPush(Context r3) {
        MiPushSettings r0 = (MiPushSettings) i.a(r3, MiPushSettings.class);
        if (r0.hasUpgradeTo3616() == true) goto L6;
        r0.setUpgradeTo3616(true);
        r3.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        r3.getSharedPreferences("mipush_extra", 0).edit().clear().commit();
        r3.getSharedPreferences("mipush", 0).edit().clear().commit();
        r3.getSharedPreferences("XMPushServiceConfig", 0).edit().clear().commit();
        return;
    }

    public boolean checkThirdPushConfig(String r11, Context r12) throws Exception {
        Pair r0 = PushSupporter.thirdService().getPushConfig(getMiPush());
        boolean r1 = false;
        if (r0 != null) goto L5;
    L10:
        PushSupporter.logger().e(r11, "Mipush key configuration error, missing key configuration");
        boolean r2 = false;
    L11:
        boolean r3 = r2 & ManifestUtils.checkPermissions(r12, r11, "MiPush", Arrays.asList(new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE", r12.getPackageName() + ".permission.MIPUSH_RECEIVE"}));
        boolean r4 = ManifestUtils.checkService(r12, r11, "MiPush Error", Arrays.asList(new Component[]{Component.Builder.create("com.xiaomi.push.service.XMPushService").setProcess(r12.getPackageName() + TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX).build(), Component.Builder.create("com.xiaomi.push.service.XMJobService").setProcess(r12.getPackageName() + TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX).setPermission("android.permission.BIND_JOB_SERVICE").build(), Component.Builder.create("com.xiaomi.mipush.sdk.PushMessageHandler").setProcess(r12.getPackageName()).build(), Component.Builder.create("com.xiaomi.mipush.sdk.MessageHandleService").setProcess(r12.getPackageName()).build()}));
        if (ManifestUtils.checkReceiver(r12, r11, "MiPush Error", Arrays.asList(new Component[]{Component.Builder.create("com.xiaomi.push.service.receivers.PingReceiver").setProcess(r12.getPackageName() + TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX).addIntentFilter(new Component.IntentFilter(Arrays.asList(new String[]{"com.xiaomi.push.PING_TIMER"}))).build(), Component.Builder.create("com.xiaomi.push.service.receivers.MIPushMessageHandler").setProcess(r12.getPackageName()).addIntentFilter(new Component.IntentFilter(Arrays.asList(new String[]{"com.xiaomi.mipush.RECEIVE_MESSAGE"}))).addIntentFilter(new Component.IntentFilter(Arrays.asList(new String[]{"com.xiaomi.mipush.MESSAGE_ARRIVED"}))).addIntentFilter(new Component.IntentFilter(Arrays.asList(new String[]{"com.xiaomi.mipush.ERROR"}))).build()})) == false) goto L16;
        if (r4 == false) goto L16;
        r1 = true;
    L16:
        return r3 & r1;
    L5:
        if (TextUtils.isEmpty((CharSequence) r0.first) == true) goto L10;
        if (TextUtils.isEmpty((CharSequence) r0.second) == true) goto L10;
        r2 = true;
        goto L11
    }

    public void registerPush(Context r10, int r11) {
        String r1 = null;
        if (r10 != null) goto L5;
    L24:
        if (r10 != null) goto L27;
        r1 = "context is null";
    L29:
        PushSupporter.monitor().monitorRegisterSenderFailed(r11, 101, "0", r1);
        return;
    L27:
        if (r11 == getMiPush()) goto L29;
        r1 = "channel register failed";
        goto L29
    L5:
        if (r11 != getMiPush()) goto L24;
        PushSupporter.logger().i("MiPush", "registerMiPush");
        String r2 = ToolUtils.getCurProcessName(r10);
        if (TextUtils.isEmpty(r2) == false) goto L10;
    L31:
        Pair r3 = PushSupporter.thirdService().getPushConfig(getMiPush());     // Catch: Throwable -> L21
        if (r3 != null) goto L19;
        PushSupporter.monitor().monitorRegisterSenderFailed(r11, 106, "0", "configuration is null");     // Catch: Throwable -> L21
        return;
    L19:
        doUpgradeMiPush(r10);     // Catch: Throwable -> L21
        MiPushClient.registerPush(r10, (String) r3.first, (String) r3.second);     // Catch: Throwable -> L21
        MiPushClient.resumePush(r10.getApplicationContext(), null);     // Catch: Throwable -> L21
        Logger.setLogger(r10, new a());     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L10:
        if (r2.endsWith(ToolUtils.SMP_PROCESS_SUFFIX) == false) goto L13;
        ToolUtils.setComponentEnable(r10, "com.xiaomi.push.service.receivers.MIPushMessageHandler", false);
        ToolUtils.setComponentEnable(r10, "com.xiaomi.push.service.receivers.WidgetProviderMIPushMessageHandler", false);
        ToolUtils.setComponentEnable(r10, "com.xiaomi.push.service.receivers.SmpMIPushMessageHandler", true);
        goto L31
    L13:
        if (r2.endsWith(ToolUtils.SMP_PROCESS_SUFFIX_V2) == false) goto L31;
        ToolUtils.setComponentEnable(r10, "com.xiaomi.push.service.receivers.MIPushMessageHandler", false);
        ToolUtils.setComponentEnable(r10, "com.xiaomi.push.service.receivers.SmpMIPushMessageHandler", false);
        ToolUtils.setComponentEnable(r10, "com.xiaomi.push.service.receivers.WidgetProviderMIPushMessageHandler", true);
        goto L31
    }

    public boolean requestRemoveVoipNotification(Context r1, int r2) {
        MiPushClient.removeWindow(r1);
        return true;
    }

    public void unregisterPush(Context r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != getMiPush()) goto L13;
        PushSupporter.logger().i("MiPush", "unregisterMiPush");
        MiPushClient.pausePush(r3.getApplicationContext(), null);     // Catch: Throwable -> L9
        MiPushClient.unregisterPush(r3.getApplicationContext());     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    public void setAlias(Context r5, String r6, int r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r7 != getMiPush()) goto L35;
        PushSupporter.logger().i("MiPush", "setAlias");
        List r1 = MiPushClient.getAllAlias(r5);     // Catch: Exception -> L23
        if (r1 == null) goto L24;
        Iterator r2 = r1.iterator();     // Catch: Exception -> L23
    L11:
        if (r2.hasNext() == false) goto L24;
        String r3 = (String) r2.next();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r3) == true) goto L11;
        if (r3.equals(r6) == true) goto L11;
        MiPushClient.unsetAlias(r5, r3, null);     // Catch: Exception -> L23
    L24:
        MiPushClient.setAlias(r5, r6, null);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        PushSupporter.monitor().monitorRegisterSenderFailed(r7, 105, "0", Log.getStackTraceString(e));
        e.printStackTrace();
        return;
    }
}
