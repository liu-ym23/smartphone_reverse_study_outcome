package com.tencent.open.miniapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class MiniApp extends BaseApi {
    public static final int MINIAPP_CONTEXT_NULL = -6;
    public static final int MINIAPP_ID_EMPTY = -1;
    public static final int MINIAPP_ID_NOT_DIGIT = -4;
    public static final int MINIAPP_SHOULD_DOWNLOAD = -2;
    public static final String MINIAPP_SRC_ID = "21";
    public static final int MINIAPP_SRC_ID_NOT_DIGIT = -3;
    public static final int MINIAPP_SUCCESS = 0;
    public static final String MINIAPP_TYPE_NORMAL = "mini_program_or_game";
    public static final int MINIAPP_UNKNOWN_TYPE = -5;
    public static final String MINIAPP_VERSION_DEVELOP = "develop";
    public static final String MINIAPP_VERSION_RELEASE = "release";
    public static final String MINIAPP_VERSION_TRIAL = "trial";
    public static final int MINIAPP_VERSION_WRONG = -7;
    public static final List<String> OPEN_CONNECT_DEMO_MINI_APP_VERSIONS = null;

    static {
        OPEN_CONNECT_DEMO_MINI_APP_VERSIONS = Arrays.asList(new String[]{MINIAPP_VERSION_DEVELOP, MINIAPP_VERSION_TRIAL, MINIAPP_VERSION_RELEASE});
    }

    public MiniApp(QQToken r1) {
        super(r1);
    }

    public static void INVOKEVIRTUAL_com_tencent_open_miniapp_MiniApp_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(TDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public MiniApp(Context r1, QQToken r2) {
        super(r2);
    }

    public MiniApp(Context r1, c r2, QQToken r3) {
        super(r2, r3);
    }

    public int startMiniApp(Activity r9, String r10, String r11, String r12, String r13, String r14) {
        if (a.a("openSDK_LOG.MiniApp", null) == false) goto L5;
        return -5;
    L5:
        if (r9 != null) goto L9;
        SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_CONTEXT_NULL : -6");
        return -6;
    L9:
        if (MINIAPP_TYPE_NORMAL.equals(r10) == true) goto L13;
        SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_UNKNOWN_TYPE : -5");
        return -5;
    L13:
        if (TextUtils.isEmpty(r11) == false) goto L16;
        SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_EMPTY : -1");
        return -1;
    L16:
        int r2 = 0;
    L18:
        if (r2 >= r11.length()) goto L25;
        if (Character.isDigit(r11.charAt(r2)) == false) goto L21;
        r2 = r2 + 1;
        goto L18
    L21:
        SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_NOT_DIGIT : -4");
        return -4;
    L25:
        if (r13 != null) goto L28;
        r13 = "";
    L28:
        if (OPEN_CONNECT_DEMO_MINI_APP_VERSIONS.contains(r14) == true) goto L32;
        SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_VERSION_WRONG : -7");
        return -7;
    L32:
        if (m.e(r9) == false) goto L41;
        Intent r3 = new Intent("android.intent.action.VIEW");
        r3.setPackage("com.tencent.mobileqq");
        r3.setData(UriProtector.parse(String.format("mqqapi://connect_miniapp/launch?app_type=%1$s&mini_app_id=%2$s&version=1&src_type=app&app_name=%3$s&app_id=%4$s&src_id=%5$s&mini_app_path=%6$s&mini_app_type=%7$s&open_id=%8$s", new Object[]{r10, r11, m.k(k.a(r9)), m.k(((BaseApi) this).c.getAppId()), r12, m.k(r13), m.k(r14), m.k(((BaseApi) this).c.getOpenId())})));
        r3.putExtra("pkg_name", r9.getPackageName());
        r9.startActivity(r3);
        SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_SUCCESS : 0");
        return 0;
    L41:
        INVOKEVIRTUAL_com_tencent_open_miniapp_MiniApp_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new TDialog(r9, "", a(""), null, ((BaseApi) this).c));     // Catch: RuntimeException -> L37
    L39:
        SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_SHOULD_DOWNLOAD : -2");
        return -2;
    L37:
        e = move-exception;
        SLog.e("openSDK_LOG.MiniApp", "Show download dialog exception:" + e.getMessage());
        goto L39
    }
}
