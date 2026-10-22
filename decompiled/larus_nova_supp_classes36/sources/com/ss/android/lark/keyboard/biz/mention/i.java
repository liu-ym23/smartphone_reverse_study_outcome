package com.ss.android.lark.keyboard.biz.mention;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.plugin.tool.at.AtKBPlugin;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements com.ss.android.lark.biz.im.api.extension.chat_window.d<com.ss.android.lark.keyboard.keyboard2.m> {
    public final boolean a;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b b;
    public AtKBPlugin c;

    public final String getName() {
        return INotificationHitPoint.NoticeType.AT;
    }

    public final void isEnable() {
    }

    public final Object getPlugin() {
        if (this.c != null) goto L15;
        com.ss.android.lark.biz.im.api.extension.chat_window.h r0 = this.b.e;
        MutableLiveData r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.b;
    L8:
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        String r11 = this.b.c.getId();
        boolean r12 = this.a;
        FragmentActivity r3 = this.b.a.requireActivity();
        String r4 = this.b.c.getId();
        com.ss.android.lark.biz.im.api.extension.chat_window.b r5 = this.b;
        Fragment r6 = r5.a;
        com.ss.android.lark.keyboard.b r7 = r5.b;
        Chat r8 = r5.c;
        com.ss.android.lark.biz.im.api.extension.chat_window.h r9 = r5.e;
        if (r9 == null) goto L13;
        r1 = r9.c;
    L13:
        String r10 = r2;
        AtKBPlugin r13 = new AtKBPlugin(r11, r12, new d(r3, r4, r6, r7, r10, r8, r1), true, r10, 4);
        r13.n = true;
        this.c = r13;
        goto L15
    L7:
        r2 = null;
    L15:
        return this.c;
    }

    public i(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.a = false;
        this.b = r2;
    }
}
