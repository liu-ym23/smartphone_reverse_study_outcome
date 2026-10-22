package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.SetMessageBoardDataResultModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.oe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setMessageBoardData")
public final class hc extends w20.h6<oe, SetMessageBoardDataResultModel> {

    public static final class a {
    }

    static {
    }

    public hc() {
    }

    public final void invoke(Object r5, CallContext r6) {
        oe r7 = (oe) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r8 = r7.a();
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r8, "likeRelation") == false) goto L38;
        nm1.e r9 = pm1.f.c();
        com.bytedance.android.livesdk.chatroom.msgboard.a r1 = null;
        if (r9 == null) goto L18;
        ReplayDataContext r11 = r9.h(null);
        if (r11 == null) goto L18;
        com.bytedance.live.datacontext.j r12 = r11.getVsMsgBoardDataContext();
    L20:
        if ((r12 instanceof com.bytedance.live.datacontext.j) == true) goto L22;
        r12 = null;
    L22:
        if (r12 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.msgboard.a r13 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r12.getValue();
        if (r13 == null) goto L27;
        r1 = r13;
    L32:
        if (r1 == null) goto L36;
        com.bytedance.live.datacontext.n r14 = r1.getCommentLikeRelation();
        if (r14 == null) goto L36;
        r14.setValue(r7.b());
    L36:
        SetMessageBoardDataResultModel r15 = new SetMessageBoardDataResultModel();
        r15.a(SetMessageBoardDataResultModel.Code.Success);
        Unit r16 = Unit.INSTANCE;
        finishWithResult(r15);
        return;
    L27:
        RoomContext r17 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r17 == null) goto L32;
        com.bytedance.live.datacontext.j r18 = r17.getVsMsgBoardDataContext();
        if (r18 == null) goto L32;
        r1 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r18.getValue();
    L18:
        r12 = null;
        goto L20
    L38:
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
