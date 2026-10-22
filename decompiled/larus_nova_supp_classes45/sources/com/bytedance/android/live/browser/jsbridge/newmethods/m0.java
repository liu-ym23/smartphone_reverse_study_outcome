package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.AlertResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "alert")
public final class m0 extends w20.h<w20.m7, AlertResultModel> {
    public boolean a;

    public final void onDestroy() {
        super.onDestroy();
        this.a = true;
    }

    public m0() {
    }

    public final void invoke(Object r3, CallContext r4) {
        w20.m7 r5 = (w20.m7) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (TextUtils.isEmpty(r5.a()) == false) goto L5;
    L7:
        int r0 = 1;
    L8:
        Context r6 = r4.getContext();
        if (com.bytedance.android.live.b.b.getValue().booleanValue() == true) goto L11;
    L17:
        com.bytedance.android.livesdk.chatroom.ui.c9.b r1 = new com.bytedance.android.livesdk.chatroom.ui.c9.b();
        r1.a = r6;
        r1.b = r0;
        r1.g = 17;
        r1.p = false;
        if (TextUtils.isEmpty(r5.d()) == true) goto L21;
        r1.e = r5.d();
    L21:
        if (TextUtils.isEmpty(r5.c()) == true) goto L24;
        r1.f = r5.c();
    L24:
        if (TextUtils.isEmpty(r5.a()) == true) goto L37;
        if (TextUtils.isEmpty(r5.b()) == true) goto L37;
        if (TextUtils.isEmpty(r5.b()) == false) goto L30;
        String r7 = com.bytedance.android.live.core.utils.s1.B(2131915442);
    L31:
        i0 r2 = new i0(this);
        r1.j = r7;
        r1.k = r2;
        if (TextUtils.isEmpty(r5.a()) == false) goto L34;
        String r8 = com.bytedance.android.live.core.utils.s1.B(2131920806);
    L35:
        j0 r9 = new j0(this);
        r1.l = r8;
        r1.m = r9;
        r1.s = 2131954724;
    L50:
        com.bytedance.android.livesdk.chatroom.ui.c9 r11 = new com.bytedance.android.livesdk.chatroom.ui.c9(r1.a, r1);
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L57;
        DialogLancet.handleBlockedDialogShow(r11);
        return;
    L57:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L56
    L54:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        return;
    L34:
        r8 = r5.a();
        goto L35
    L30:
        r7 = r5.b();
    L37:
        if (TextUtils.isEmpty(r5.a()) == true) goto L44;
        if (TextUtils.isEmpty(r5.a()) == false) goto L41;
        String r12 = com.bytedance.android.live.core.utils.s1.B(2131917391);
    L42:
        k0 r13 = new k0(this);
        r1.h = r12;
        r1.i = r13;
        goto L50
    L41:
        r12 = r5.a();
        goto L42
    L44:
        if (TextUtils.isEmpty(r5.b()) == true) goto L50;
        if (TextUtils.isEmpty(r5.b()) == false) goto L48;
        String r14 = com.bytedance.android.live.core.utils.s1.B(2131917391);
    L49:
        l0 r15 = new l0(this);
        r1.h = r14;
        r1.i = r15;
        goto L50
    L48:
        r14 = r5.b();
        goto L49
    L11:
        if ((r6 instanceof Activity) == true) goto L17;
        WeakReference<Activity> r16 = com.bytedance.android.live.core.utils.a.a;
        if (r16 == null) goto L17;
        Activity r17 = r16.get();
        if (r17 == null) goto L17;
        r6 = r17;
        goto L17
    L5:
        if (TextUtils.isEmpty(r5.b()) == true) goto L7;
        r0 = 2;
        goto L8
    }
}
