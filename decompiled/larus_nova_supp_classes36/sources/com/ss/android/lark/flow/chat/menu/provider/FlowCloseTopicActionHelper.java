package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.ThreadState;
import com.bytedance.lark.pb.im.v1.UpdateThreadRequest;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.ThreadStateInfo;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.api.service.impl.q1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowCloseTopicActionHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(final Context r4, String r5, final boolean r6) {
        if (r6 == false) goto L4;
        ThreadStateInfo.ThreadState r0 = ThreadStateInfo.ThreadState.CLOSED;
    L5:
        q1 r1 = q1.d.a;
        UIGetDataCallback r2 = new UIGetDataCallback(new FlowCloseTopicActionHelper$updateCloseStatus$1(r6, r4));
        UpdateThreadRequest.Builder r7 = new UpdateThreadRequest.Builder();
        UpdateThreadRequest.Builder r8 = r7.thread_id(r5);
        int r9 = q1.c.b[r0.ordinal()];
        if (r9 != 1) goto L8;
        ThreadState r10 = ThreadState.OPEN;
    L15:
        r8.thread_state(r10);
        r1.a.c(r7, r2);
        return;
    L8:
        if (r9 != 2) goto L10;
        r10 = ThreadState.CLOSED;
        goto L15
    L10:
        if (r9 == 3) goto L12;
        r10 = ThreadState.UNKNOWN_STATE;
        goto L15
    L12:
        r10 = ThreadState.UNKNOWN_STATE;
        goto L15
    L4:
        r0 = ThreadStateInfo.ThreadState.OPEN;
        goto L5
    }

    public static void b(Context r4, String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "chatId");
        Intrinsics.checkNotNullParameter(r6, "rootMessageId");
        if (r7 == false) goto L5;
        int r8 = com.ss.android.lark.statistics.thread.a.a;
        Intrinsics.checkNotNullParameter(r5, "chatId");
        Intrinsics.checkNotNullParameter(r6, "threadId");
        Statistics.sendEvent("group_topicmode_topic_reopen_click", new JSONObject().put("chat_id", r5).put("topic_id", r6));
        c(r4, r6, false);
        return;
    L5:
        int r9 = com.ss.android.lark.statistics.thread.a.a;
        Intrinsics.checkNotNullParameter(r5, "chatId");
        Intrinsics.checkNotNullParameter(r6, "threadId");
        Statistics.sendEvent("group_topicmode_topic_close_click", new JSONObject().put("chat_id", r5).put("topic_id", r6));
        UDBaseDialogBuilder.ActionBuilder r10 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(UIUtils.getString(r4, 2131891623)).textColorRes(2131102093).onClickListener(new h(r5, r6, r4));
        new UDDialogBuilder(r4).title(2131890879).titleBold(true).message(2131890845).addActionButton(2131391778, 2131890429, new g(r5, r6)).addActionButton(r10).show();
    }

    public static boolean a(Chat r1, ThreadTopic r2, Message r3, Chatter r4, boolean r5, boolean r6, boolean r7) {
        boolean r0 = false;
        if (r6 == false) goto L5;
        return false;
    L5:
        if (r1 != null) goto L7;
    L48:
        return false;
    L7:
        if (r1.isFrozen() == true) goto L48;
        if (r5 == false) goto L12;
        return true;
    L12:
        if (r7 == false) goto L14;
        return true;
    L14:
        String r8 = null;
        if (r4 == null) goto L17;
        String r9 = r4.getId();
    L18:
        if (r9 != null) goto L20;
    L23:
        boolean r10 = true;
    L24:
        if (r10 == true) goto L31;
        if (r2 == null) goto L27;
        String r11 = r2.getOwnerId();
    L29:
        if (Intrinsics.areEqual(r11, r9) == false) goto L31;
        return true;
    L27:
        r11 = null;
    L31:
        if (r2 == null) goto L33;
        String r12 = r2.getAnonymousId();
    L34:
        if (r12 != null) goto L36;
    L39:
        boolean r13 = true;
    L40:
        if (r13 == true) goto L47;
        if (r3 == null) goto L44;
        r8 = r3.getFromId();
    L44:
        if (Intrinsics.areEqual(r12, r8) == false) goto L47;
        r0 = true;
    L47:
        return r0;
    L36:
        if (r12.length() == 0) goto L39;
        r13 = false;
        goto L40
    L33:
        r12 = null;
        goto L34
    L20:
        if (r9.length() == 0) goto L23;
        r10 = false;
        goto L24
    L17:
        r9 = null;
        goto L18
    }
}
