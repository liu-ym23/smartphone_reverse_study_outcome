package com.larus.bmhome.share.api;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.bot.share.ShareBotController;
import com.larus.bmhome.chat.detail.AbstractCommonDetailFragment;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.a;
import com.larus.bmhome.share.panel.b;
import com.larus.bmhome.share.panel.d;
import com.larus.bmhome.share.panel.h;
import com.larus.im.bean.bot.BotModel;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class IShareService$a {
    public static /* synthetic */ void f(ShareServiceDelegate r7, String r8, String r9, String r10, boolean r11, AbstractCommonDetailFragment r12) {
        r7.l(r8, r9, r10, r11, null, r12);
    }

    public static /* synthetic */ void d(IShareService r8, Context r9, String r10, String r11, b r12, Function1 r13, int r14) {
        if ((r14 & 16) == 0) goto L5;
        boolean r6 = true;
    L7:
        if ((r14 & 32) == 0) goto L9;
        r13 = null;
    L9:
        r8.b(r9, r10, r11, r12, r6, r13);
        return;
    L5:
        r6 = false;
        goto L7
    }

    public static /* synthetic */ a a(ShareServiceDelegate r11, Context r12, ShareScene r13, b r14, boolean r15, h r16, d r17, List r18, int r19) {
        if ((r19 & 16) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r19 & 128) == 0) goto L9;
        List r8 = null;
    L11:
        return r11.q(r12, r13, r14, false, r5, r16, r17, r8, null, null);
    L9:
        r8 = r18;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    public static /* synthetic */ void b(ShareServiceDelegate r10, Context r11, e r12, BotModel r13, ShareScene r14, String r15, by7.e r16, ShareBotController.performShareBot.1 r17, int r18) {
        if ((r18 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        by7.e r8 = null;
    L11:
        if ((r18 & 64) == 0) goto L13;
        ShareBotController.performShareBot.1 r9 = null;
    L14:
        r10.f(r11, r12, r13, r14, r7, r8, r9);
        return;
    L13:
        r9 = r17;
        goto L14
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    public static /* synthetic */ DialogFragment g(IShareService r12, FragmentActivity r13, ShareScene r14, b r15, h r16, d r17, by7.e r18, boolean r19, int r20) {
        if ((r20 & 8) == 0) goto L5;
        h r7 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        d r8 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        by7.e r9 = null;
    L15:
        if ((r20 & 64) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r20 & 128) == 0) goto L21;
        boolean r11 = true;
    L23:
        return r12.c(r13, r14, r15, r7, r8, r9, r10, r11);
    L21:
        r11 = false;
        goto L23
    L17:
        r10 = r19;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    public static /* synthetic */ void c(IShareService r10, Context r11, String r12, String r13, String r14, ShareScene r15, h r16, by7.e r17, d r18, int r19) {
        if ((r19 & 64) == 0) goto L5;
        h r7 = null;
    L7:
        if ((r19 & 128) == 0) goto L9;
        by7.e r8 = null;
    L11:
        if ((r19 & 256) == 0) goto L13;
        d r9 = null;
    L14:
        r10.r(r11, r12, r13, r14, r15, null, r7, r8, r9);
        return;
    L13:
        r9 = r18;
        goto L14
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    public static /* synthetic */ void e(ShareServiceDelegate r13, boolean r14, String r15, String r16, String r17, String r18, String r19, Integer r20, String r21, by7.e r22, JSONObject r23, int r24) {
        if ((r24 & 256) == 0) goto L5;
        String r9 = null;
    L7:
        if ((r24 & 2048) == 0) goto L9;
        JSONObject r12 = null;
    L10:
        r13.e(r14, r15, r16, r17, r18, r19, r20, "bot", r9, r22, false, r12);
        return;
    L9:
        r12 = r23;
        goto L10
    L5:
        r9 = r21;
        goto L7
    }
}
