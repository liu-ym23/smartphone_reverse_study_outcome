package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.utils;

import android.view.View;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class MorePanelButtonAnimUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(View r8, float r9, float r10, boolean r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        u4.c(new MorePanelButtonAnimUtils$showGuideAnim$1(r8, r9, r10, ColorProtector.parseColor("#FFF4F7FF"), ColorProtector.parseColor("#FFC7CFE4"), r11)).c();
    }
}
