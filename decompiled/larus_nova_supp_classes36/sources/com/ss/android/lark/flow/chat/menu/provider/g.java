package com.ss.android.lark.flow.chat.menu.provider;

import android.content.DialogInterface;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public g(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        int r6 = com.ss.android.lark.statistics.thread.a.a;
        String r7 = this.a;
        String r0 = this.b;
        Intrinsics.checkNotNullParameter(r7, "chatId");
        Intrinsics.checkNotNullParameter(r0, "threadId");
        Statistics.sendEvent("group_topicmode_topic_close_click_cancel", new JSONObject().put("chat_id", r7).put("topic_id", r0));
        r4.dismiss();
    }
}
