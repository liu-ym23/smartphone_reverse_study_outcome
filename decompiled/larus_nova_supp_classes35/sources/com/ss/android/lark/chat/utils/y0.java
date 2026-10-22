package com.ss.android.lark.chat.utils;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Chat r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        Chat.RestrictedWhiteListSetting r1 = r3.getRestrictedModeSetting().getWhiteListSetting();
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L14;
        return true;
    L14:
        if (r3.getRestrictedModeSetting().getSwitch() == true) goto L16;
        return true;
    L16:
        if (r3.getRestrictedModeSetting().getCopy() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L21;
        return false;
    L21:
        return true;
    L8:
        if (r1.isHitWhiteList() != true) goto L10;
        r2 = true;
        goto L11
    }

    public static boolean b(Chat r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        Chat.RestrictedWhiteListSetting r1 = r3.getRestrictedModeSetting().getWhiteListSetting();
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L14;
        return true;
    L14:
        if (r3.getRestrictedModeSetting().getSwitch() == true) goto L16;
        return true;
    L16:
        if (r3.getRestrictedModeSetting().getDownload() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L21;
        return false;
    L21:
        return true;
    L8:
        if (r1.isHitWhiteList() != true) goto L10;
        r2 = true;
        goto L11
    }

    public static boolean c(Chat r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        Chat.RestrictedWhiteListSetting r1 = r3.getRestrictedModeSetting().getWhiteListSetting();
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L14;
        return true;
    L14:
        if (r3.getRestrictedModeSetting().getSwitch() == true) goto L16;
        return true;
    L16:
        if (r3.getRestrictedModeSetting().getForward() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L21;
        return false;
    L21:
        return true;
    L8:
        if (r1.isHitWhiteList() != true) goto L10;
        r2 = true;
        goto L11
    }

    public static boolean d(Chat r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        Chat.RestrictedWhiteListSetting r1 = r3.getRestrictedModeSetting().getWhiteListSetting();
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L14;
        return true;
    L14:
        if (r3.getRestrictedModeSetting().getSwitch() == true) goto L16;
        return true;
    L16:
        if (r3.getRestrictedModeSetting().getDownload() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L21;
        return false;
    L21:
        return true;
    L8:
        if (r1.isHitWhiteList() != true) goto L10;
        r2 = true;
        goto L11
    }

    public static boolean e(Chat r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        Chat.RestrictedWhiteListSetting r1 = r3.getRestrictedModeSetting().getWhiteListSetting();
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L14;
        return true;
    L14:
        if (r3.getRestrictedModeSetting().getSwitch() == true) goto L16;
        return true;
    L16:
        if (r3.getRestrictedModeSetting().getScreenshot() == Chat.RestrictedModeSetting.Participant.ALL_MEMBERS) goto L21;
        return false;
    L21:
        return true;
    L8:
        if (r1.isHitWhiteList() != true) goto L10;
        r2 = true;
        goto L11
    }

    public static void f(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        UDToast.show(r1, 2131891308);
    }

    public static void g(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        UDToast.show(r1, 2131891308);
    }
}
