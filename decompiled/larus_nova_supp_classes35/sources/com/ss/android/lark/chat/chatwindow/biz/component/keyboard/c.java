package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(OpenApp r2) {
        if (r2 == null) goto L5;
        boolean r3 = Intrinsics.areEqual(r2.getCanEdit(), Boolean.TRUE);
    L6:
        if (r3 == true) goto L8;
        return false;
    L8:
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("open_app.bot.without_callback_owner_show_input") == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r3 = false;
        goto L6
    }

    public static boolean b(Chat r3, Chatter r4, OpenApp r5) {
        if (r4 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L33;
        if (r3 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L34;
        if (r5 != null) goto L18;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == true) goto L35;
        if (r3 != null) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == true) goto L36;
        return false;
    L36:
        return true;
    L26:
        if (r3.isFrozen() == false) goto L28;
        r9 = true;
        goto L29
    L35:
        return true;
    L18:
        if (r5.getChatable() != OpenApp.Chatable.UNCHATABLE) goto L22;
        if (a(r5) == true) goto L22;
        r8 = true;
        goto L23
    L34:
        return true;
    L11:
        if (r3.isChatable() == false) goto L14;
        r7 = false;
        goto L15
    L33:
        return true;
    L5:
        if (r4.isDimission() == false) goto L7;
        r6 = true;
        goto L8
    }
}
