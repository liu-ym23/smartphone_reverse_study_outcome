package com.bytedance.map.api.monitor;

import android.content.Context;
import android.text.TextUtils;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.amap.depend.MonitorDependImpl;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdkmonitor.e;
import com.bytedance.framwork.core.sdkmonitor.f;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.map.api.utils.JsonUtil;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MapMonitorUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f6934b;

    public static void a(Context r5, MonitorDependImpl r10) {
        if (f6933a == true) goto L13;
        if (r5 == null) goto L14;
        if (r10 == null) goto L15;
        ArrayList r11 = new ArrayList();
        r11.add("https://mon.snssdk.com/monitor/appmonitor/v2/settings");
        f.d("366174", r11);
        ArrayList r12 = new ArrayList();
        r12.add("https://mon.snssdk.com/monitor/collect/");
        f.e("366174", r12);
        JSONObject r13 = new JSONObject();
        JsonUtil.a(r13, WsConstants.KEY_SDK_VERSION, "1.10.0-rc.20");
        if (TextUtils.isEmpty("") == true) goto L10;
        String r14 = "";
    L11:
        JsonUtil.a(r13, "host_aid", r14);
        JsonUtil.a(r13, WsConstants.KEY_DEVICE_ID, r10.a());
        JsonUtil.a(r13, Constant.PACKAGE_NAME, "");
        JsonUtil.a(r13, LynxMonitorService.KEY_CHANNEL, "");
        JsonUtil.a(r13, "app_version", "");
        JsonUtil.a(r13, "update_version_code", "");
        f.c(r5, "366174", r13, new AnonymousClass1());
        f6934b = f.b("366174");
        f6933a = true;
        return;
    L10:
        r14 = "1128";
        goto L11
    L15:
        return;
    L14:
        return;
    }

    public static void a(String r5, JSONObject r10, JSONObject r11) {
        e r12 = f6934b;
        if (r12 == null) goto L6;
        r12.p(r5, r10, r11, null);
        return;
    }
}
