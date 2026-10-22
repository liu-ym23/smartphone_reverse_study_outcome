package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.AIRoundInfo;
import com.bytedance.lark.pb.im.v1.PushMessageResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g1 implements Runnable {
    public final /* synthetic */ PushMessageResponse a;
    public final /* synthetic */ MessagePushV2 b;

    public g1(PushMessageResponse r1, MessagePushV2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Iterator r0 = this.a.ai_last_round_infos.iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        AIRoundInfo r1 = (AIRoundInfo) r0.next();
        if (r1 == null) goto L4;
        Long r2 = r1.chat_id;
        String r3 = BuildConfig.FLAVOR;
        if (r2 == null) goto L11;
        r3 = BuildConfig.FLAVOR + r1.chat_id;
    L11:
        Long r4 = r1.ai_chat_mode_id;
        if (r4 == null) goto L18;
        if (r4 != null) goto L16;
    L17:
        r3 = r3 + '_' + r1.ai_chat_mode_id;
        goto L18
    L16:
        if (r4.longValue() != 0) goto L17;
    L18:
        StringBuilder r5 = new StringBuilder("use key ");
        r5.append(r3);
        r5.append(" to dispatch round info ");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        StringBuilder r6 = new StringBuilder();
        r6.append("chatId:" + r1.chat_id);
        r6.append(",aiChatModeId:" + r1.ai_chat_mode_id);
        r6.append(",roundId:" + r1.round_id);
        r6.append(",roundIdPosition:" + r1.round_id_position);
        r6.append(",roundLastPosition:" + r1.round_last_position);
        r6.append(",status:" + r1.status);
        r6.append(",updateTime:" + r1.update_time);
        r5.append(r6.toString());
        Log.i("MessagePush", r5.toString());
        List r7 = (List) ((ConcurrentHashMap) this.b.e).get(r3);
        if (r7 == null) goto L4;
        Iterator r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L4;
        ((com.ss.android.lark.biz.im.api.f1) r8.next()).a(r1);
        goto L23
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
