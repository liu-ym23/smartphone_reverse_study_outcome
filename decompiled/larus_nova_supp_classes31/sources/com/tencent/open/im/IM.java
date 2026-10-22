package com.tencent.open.im;

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
import com.tencent.open.utils.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class IM extends BaseApi {
    public static final String CHAT_TYPE_AIO = "thirdparty2c";
    public static final String CHAT_TYPE_AUDIO_CHAT = "audio_chat";
    public static final String CHAT_TYPE_VIDEO_CHAT = "video_chat";
    public static final int IM_LENGTH_SHORT = -3;
    public static final int IM_SHOULD_DOWNLOAD = -2;
    public static final int IM_SUCCESS = 0;
    public static final int IM_UIN_EMPTY = -1;
    public static final int IM_UIN_NOT_DIGIT = -4;
    public static final int IM_UNKNOWN_TYPE = -5;

    public IM(QQToken r1) {
        super(r1);
    }

    public static void INVOKEVIRTUAL_com_tencent_open_im_IM_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(TDialog r1) {
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

    public IM(Context r1, QQToken r2) {
        super(r2);
    }

    public IM(Context r1, c r2, QQToken r3) {
        super(r2, r3);
    }

    public int startIMConversation(Activity r10, String r11, String r12, String r13) {
        if (a.a("ImApi", null) == false) goto L5;
        return -5;
    L5:
        if (r11 != null) goto L7;
    L43:
        return -5;
    L7:
        if (r11.equals(CHAT_TYPE_AIO) == true) goto L14;
        if (r11.equals(CHAT_TYPE_AUDIO_CHAT) == true) goto L14;
        if (r11.equals(CHAT_TYPE_VIDEO_CHAT) == false) goto L43;
    L14:
        if (r11.equals(CHAT_TYPE_AUDIO_CHAT) == true) goto L18;
        r11.equals(CHAT_TYPE_VIDEO_CHAT);
    L18:
        if (TextUtils.isEmpty(r12) == false) goto L22;
        return -1;
    L22:
        if (r12.length() >= 5) goto L25;
        return -3;
    L25:
        int r2 = 0;
    L27:
        if (r2 >= r12.length()) goto L34;
        if (Character.isDigit(r12.charAt(r2)) == false) goto L30;
        r2 = r2 + 1;
        goto L27
    L30:
        return -4;
    L34:
        if (m.d(r10) == false) goto L44;
        Intent r3 = new Intent("android.intent.action.VIEW");
        r3.setData(UriProtector.parse(String.format("mqqapi://im/chat?chat_type=%1$s&uin=%2$s&version=1&src_type=app&open_id=%3$s&app_id=%4$s&app_pkg_name=%5$s", new Object[]{r11, r12, m.k(((BaseApi) this).c.getOpenId()), m.k(((BaseApi) this).c.getAppId()), m.k(r13)})));
        r3.setPackage("com.tencent.mobileqq");
        r3.putExtra("pkg_name", r13);
        r10.startActivity(r3);
        return 0;
    L44:
        INVOKEVIRTUAL_com_tencent_open_im_IM_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new TDialog(r10, "", a(""), null, ((BaseApi) this).c));     // Catch: RuntimeException -> L39
        return -2;
    L39:
        e = move-exception;
        e.printStackTrace();
        return -2;
    }
}
