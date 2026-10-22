package com.bytedance.android.livesdk.interactivity.comment.share;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.live.datacontext.j;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a b;

    public d(long r1, com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r7) {
        Response r8 = (Response) r7;
        com.bytedance.android.livesdk.interactivity.comment.share.model.c r0 = (com.bytedance.android.livesdk.interactivity.comment.share.model.c) ((BaseResponse) r8).data;
        if (r0 == null) goto L14;
        m1 r9 = f.c(m1.class);
        m0 r1 = f.c(m0.class);
        r1.setCreateTime(System.currentTimeMillis());
        r1.setRoomId(this.a);
        r1.setMessageId(-1);
        r1.setShowMsg(true);
        r1.setMethod("WebcastItemShareMessage");
        r1.setMessageId(r0.c());
        Unit r4 = Unit.INSTANCE;
        r9.setBaseMessage(r1);
        r9.setShareText(r0.a());
        r9.setItemStyle(r0.b());
        r9.setPublicAreaCommon(r0.d());
        r9.setTrackingParams(this.b.j());
        r9.setMessageMethod("WebcastItemShareMessage");
        IRoomContextService r2 = k.f(IRoomContextService.class);
        if (r2 == null) goto L13;
        o r3 = IRoomContextService.a.a(r2, null, 0, 3);
        if (r3 == null) goto L13;
        j r5 = r3.getMessageManager();
        if (r5 == null) goto L13;
        vlc.d r6 = (vlc.d) r5.getValue();
        if (r6 == null) goto L13;
        r6.j(r9, true);
    L13:
        final com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r10 = this.b;
        int r11 = InteractivityShareAppLogger.a;
        Intrinsics.checkNotNullParameter(r10, "item");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_audience_live_message", new InteractivityShareAppLogger$sendShare$1(r10));
        return;
    L14:
        RequestError r13 = ((BaseResponse) r8).error;
        if (r13 == null) goto L18;
        String r14 = r13.prompts;
        if (r14 == null) goto L18;
    L19:
        f2.c(r14, 0);
        return;
    L18:
        r14 = s1.B(2131923435);
        goto L19
    }
}
