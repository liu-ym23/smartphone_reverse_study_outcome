package com.larus.bmhome.view.actionbar.bot;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.trace.z;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.conversation.Templates;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements g {
    public final /* synthetic */ ActionBarPanelAdapter a;

    public h(ActionBarPanelAdapter r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.bot.g
    public final void a(Templates r23, int r24) {
        Intrinsics.checkNotNullParameter(r23, "templates");
        String r10 = UUID.randomUUID().toString();
        z.a.d(r10);
        RepoDispatcher.a.getClass();
        ChatRepo r0 = RepoDispatcher.d;
        r0.d.b(this.a.a);
        ChatSender r3 = r0.e;
        String r4 = String.valueOf(r23.getTemplateName());
        String r5 = this.a.a;
        ChatSendUtils r1 = ChatSendUtils.a;
        Pair[] r7 = new Pair[1];
        Long r8 = r23.getId();
        long r19 = 0;
        if (r8 == null) goto L5;
        long r9 = r8.longValue();
    L6:
        r7[0] = TuplesKt.to("msg_template_id", String.valueOf(r9));
        r1.getClass();
        Map r11 = ChatSendUtils.p(r7);
        Function0<ChatPageContext> r2 = this.a.d;
        if (r2 == null) goto L9;
        ChatPageContext r15 = (ChatPageContext) r2.invoke();
    L10:
        u1.a.f(r3, r4, r5, "chat_action_bar_discover", r11, null, null, r10, false, null, "ActionBarPanelAdapter", null, r15, null, false, 27496);
        String r6 = String.valueOf(r23.getBotId());
        ChatParam r12 = this.a.c;
        if (r12 == null) goto L15;
        String r13 = r12.a;
        if (r13 == null) goto L15;
        Long r14 = Long.valueOf(k.a(r13));
    L16:
        Long r16 = r23.getId();
        if (r16 == null) goto L19;
        r19 = r16.longValue();
    L19:
        long r17 = ((long) r24) + 1;
        String r18 = r23.getRequestId();
        ChatParam r20 = this.a.c;
        if (r20 == null) goto L22;
        String r21 = r20.c;
    L23:
        if (r20 == null) goto L25;
        String r22 = r20.d;
    L26:
        Long r25 = Long.valueOf(r17);
        Long r26 = Long.valueOf(r19);
        JSONObject r110 = new JSONObject();
        Intrinsics.checkNotNullParameter(r110, "params");
        r110.put("bot_id", r6);     // Catch: JSONException -> L42
        if (r25 == null) goto L30;
        r110.put("click_position", r25.longValue());     // Catch: JSONException -> L42
    L30:
        if (r14 == null) goto L32;
        r110.put(MusicAppletPage.KEY_CONVERSATION_ID, r14.longValue());     // Catch: JSONException -> L42
    L32:
        if (r22 == null) goto L34;
        r110.put("current_page", r22);     // Catch: JSONException -> L42
    L34:
        if (r21 == null) goto L36;
        r110.put("previous_page", r21);     // Catch: JSONException -> L42
    L36:
        r110.put("recommend_from", "chat_action_bar_discover");     // Catch: JSONException -> L42
        if (r18 == null) goto L39;
        r110.put("req_id", r18);     // Catch: JSONException -> L42
    L39:
        if (r26 == null) goto L44;
        r110.put("template_id", r26.longValue());     // Catch: JSONException -> L42
    L44:
        TrackParams r27 = new TrackParams().merge(r110);
        by7.a r28 = new by7.a("chat_action_bar_discover_click");
        r28.a.merge(r27);
        r28.b();
        this.a.e.invoke(String.valueOf(r23.getTemplateName()));
        Dialog r29 = this.a.b;
        Handler r30 = DialogLancet.resolveDialogHandler(r29);
        if (r30 != null) goto L47;
    L49:
        DialogLancet.beforeDialogDismiss(r29);
        r29.dismiss();     // Catch: Throwable -> L52 Exception -> L54
    L59:
        DialogLancet.afterDialogDismiss(r29);
        return;
    L54:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L52
        Throwable r31 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L52
        if (r31 == null) goto L59;
        com.bytedance.crash.d.d(r31, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r29);
        throw th;
    L47:
        if (Looper.myLooper() == r30.getLooper()) goto L49;
        r30.post(DialogLancet.createDismissRunnable(r29));
        return;
    L42:
        e = move-exception;
        FLogger.a.e("ChatEventHelper", "error in ChatEventHelper chatActionBarDiscoverClick " + e.getLocalizedMessage());
        goto L44
    L25:
        r22 = null;
        goto L26
    L22:
        r21 = null;
    L15:
        r14 = null;
        goto L16
    L9:
        r15 = null;
        goto L10
    L5:
        r9 = 0;
        goto L6
    }
}
