package com.ss.android.lark.keyboard.biz.p000float.inject;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.keyboard.base.k;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.p3;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements k {
    public final /* synthetic */ FloatExpandPlugin.b a;
    public final /* synthetic */ d b;

    public a(FloatExpandPlugin.b r1, s5c.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ss.android.lark.keyboard.base.k
    public final void a(Message r3) {
        Intrinsics.checkNotNullParameter(r3, INotificationHitPoint.NoticeType.MESSAGE);
        Map r4 = ChatParamUtils.g(r3);
        s5c.a r0 = r.U2;
        d r1 = this.a.b;
        r0.getClass();
        Statistics.sendEvent("im_chat_ai_reply_click", d.b.b(r0, r1).plus(this.b).plus(p3.c).plus(r4).toJson());
    }
}
