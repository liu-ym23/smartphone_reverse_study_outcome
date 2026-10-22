package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.service.impl.MessageTenantConfService;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            int r3 = com.ss.android.lark.statistics.thread.a.a;
            Statistics.sendEvent("group_topicmode_topic_delete_cancel");
            r1.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ v b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function0<Unit> d;

        public b(Context r1, v r2, String r3, Function0<Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r5, int r6) {
            int r7 = com.ss.android.lark.statistics.thread.a.a;
            Statistics.sendEvent("group_topicmode_topic_delete_confirm");
            int r8 = q.a;
            final Context r9 = this.a;
            v r10 = this.b;
            String r0 = this.c;
            final Function0<Unit> r1 = this.d;
            r10.K().Dd(r0, new UIGetDataCallback(new FlowRecallTopicActionHelper$deleteTopic$1(r9, r1)));
        }
    }

    static {
    }

    public static void b(Context r2, v r3, String r4, String r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatContainer");
        Intrinsics.checkNotNullParameter(r4, "threadId");
        Intrinsics.checkNotNullParameter(r5, "location");
        int r1 = com.ss.android.lark.statistics.thread.a.a;
        Intrinsics.checkNotNullParameter(r5, "location");
        Statistics.sendEvent("group_topicmode_topic_delete", new JSONObject().put("location", r5));
        UDBaseDialogBuilder.ActionBuilder r7 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(UIUtils.getString(r2, 2131890409)).textColorRes(2131102093).onClickListener(new b(r2, r3, r4, r6));
        new UDDialogBuilder(r2).title(2131890411).titleBold(true).message(2131890410).addActionButton(2131391778, 2131891541, a.a).addActionButton(r7).show();
    }

    public static boolean a(Chat r1, v r2, ThreadTopic r3, Message r4, Chatter r5, boolean r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        boolean r0 = false;
        if (r7 == false) goto L5;
        return false;
    L5:
        if (r1 != null) goto L7;
    L56:
        return false;
    L7:
        if (r1.isFrozen() == true) goto L56;
        if (r6 == false) goto L12;
        return true;
    L12:
        if (r8 == true) goto L48;
        String r9 = null;
        if (r5 == null) goto L16;
        String r10 = r5.getId();
    L17:
        if (r10 != null) goto L19;
    L22:
        boolean r11 = true;
    L23:
        if (r11 == true) goto L30;
        if (r3 == null) goto L26;
        String r12 = r3.getOwnerId();
    L28:
        if (Intrinsics.areEqual(r12, r10) == false) goto L30;
    L44:
        boolean r13 = true;
    L46:
        if (r13 == true) goto L48;
        return false;
    L26:
        r12 = null;
    L30:
        if (r3 == null) goto L32;
        String r14 = r3.getAnonymousId();
    L33:
        if (r14 != null) goto L35;
    L38:
        boolean r15 = true;
    L39:
        if (r15 == true) goto L45;
        if (r4 == null) goto L43;
        r9 = r4.getFromId();
    L43:
        if (Intrinsics.areEqual(r14, r9) == true) goto L44;
    L45:
        r13 = false;
        goto L46
    L35:
        if (r14.length() == 0) goto L38;
        r15 = false;
        goto L39
    L32:
        r14 = null;
        goto L33
    L19:
        if (r10.length() == 0) goto L22;
        r11 = false;
        goto L23
    L16:
        r10 = null;
    L48:
        MessageTenantConfService.c r16 = (MessageTenantConfService.c) r2.f0().getConfig().getValue();
        if (r16 != null) goto L52;
        return true;
    L52:
        if (r16.a == 0) goto L55;
        r0 = true;
    L55:
        return r0;
    }
}
