package com.ss.android.lark.flow.chat.menu.interceptor;

import android.graphics.Point;
import android.view.View;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;
import yya.n;
import yya.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements p {
    public b() {
    }

    public final String getTAG() {
        return getMessageType().name() + "_interceptor";
    }

    public final Message.Type getMessageType() {
        return Message.Type.DOUBAO;
    }

    public final boolean a(MessageActionType r5, yya.a r6) {
        Intrinsics.checkNotNullParameter(r5, "actionType");
        Intrinsics.checkNotNullParameter(r6, "actionContext");
        if (r5 != MessageActionType.REPLY_IN_THREAD) goto L5;
        return true;
    L5:
        if (r5 != MessageActionType.REPLY) goto L8;
        return true;
    L8:
        if (r5 != MessageActionType.SELECT_TEXT) goto L28;
        IDoubaoTextSelectService r7 = OfficeSDKManager.getHostUserService(((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d(), IDoubaoTextSelectService.class);
        if (r7 != null) goto L12;
        return false;
    L12:
        y6b.a r2 = null;
        if ((r6 instanceof yya.g) == false) goto L15;
        yya.g r0 = (yya.g) r6;
    L16:
        if (r0 == null) goto L18;
        n r1 = r0.d;
    L19:
        v5b.c r8 = r6.m();
        if ((r8 instanceof y6b.a) == false) goto L22;
        r2 = (y6b.a) r8;
    L22:
        if (r1 == null) goto L28;
        if (r2 == null) goto L28;
        View r9 = r1.a();
        Point r3 = r1.c();
        if (r3 != null) goto L27;
        r3 = new Point();
    L27:
        r7.Y(r2, r9, r3);
        goto L28
    L18:
        r1 = null;
        goto L19
    L15:
        r0 = null;
    L28:
        return false;
    }
}
