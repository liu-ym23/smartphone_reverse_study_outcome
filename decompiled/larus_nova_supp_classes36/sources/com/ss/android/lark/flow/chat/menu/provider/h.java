package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;

    public h(String r1, String r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        int r5 = com.ss.android.lark.statistics.thread.a.a;
        String r6 = this.a;
        String r7 = this.b;
        Intrinsics.checkNotNullParameter(r6, "chatId");
        Intrinsics.checkNotNullParameter(r7, "threadId");
        Statistics.sendEvent("group_topicmode_topic_close_click_confirm", new JSONObject().put("chat_id", r6).put("topic_id", r7));
        int r8 = FlowCloseTopicActionHelper.a;
        FlowCloseTopicActionHelper.c(this.c, this.b, true);
    }
}
