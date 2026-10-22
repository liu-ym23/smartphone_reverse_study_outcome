package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.bmhome.chat.component.bottom.floating.collect.CollectFrom;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.list.u7$a;
import com.larus.bmhome.chat.component.push.a$a;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.praise.IAiChatPraiseTriggerService;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.im.bean.bot.ActionIcon;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.OpenPushReminderScene;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z {
    public static final /* synthetic */ int g = 0;
    public final com.larus.bmhome.chat.api.q0 a;
    public final View b;
    public final Context c;
    public final Function0<Boolean> d;
    public final com.larus.bmhome.chat.api.q0.a e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public static final void b(z r6, Message r7) {
        IAiChatPraiseTriggerService r0 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        String r3 = "";
        if (r2 == false) goto L19;
        t19.s r8 = t19.s.a;
        Context r9 = r6.c;
        r8.getClass();
        t19.s.o(r9, 2131910469, false);
        FlowCommonAppCompatActivity r10 = AppHost.a.a().getCurrentActivity();
        if ((r10 instanceof FlowCommonAppCompatActivity) == false) goto L13;
        FlowCommonAppCompatActivity r11 = r10;
    L14:
        if (r11 == null) goto L16;
        r3 = r11.k();
    L16:
        IAiChatPraiseTriggerService r12 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        if (r12 == null) goto L34;
        IAiChatPraiseTriggerService.a.a(r12, r3, null, 12);
        return;
    L34:
        return;
    L13:
        r11 = null;
        goto L14
    L19:
        com.larus.bmhome.chat.api.q0.a r4 = r6.e;
        if (r4 == null) goto L30;
        ld8.n r5 = r4.K9();
        if (r5 == null) goto L30;
        CollectFrom r13 = CollectFrom.LIKE;
        String r14 = r7.getMessageId();
        if (r14 == null) goto L28;
        r3 = r14;
    L28:
        if (r5.Ho(r13, r3) != true) goto L30;
    L31:
        if (r1 == true) goto L36;
        t19.s r15 = t19.s.a;
        Context r16 = r6.c;
        r15.getClass();
        t19.s.o(r16, 2131910469, false);
        return;
    L36:
        return;
    L30:
        r1 = false;
        goto L31
    L5:
        if (r0.a() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static final void c(final z r9, final Message r10) {
        com.larus.bmhome.chat.api.q0.a r0 = r9.e;
        BotModel r1 = null;
        if (r0 == null) goto L7;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        if (r2 == null) goto L7;
        wc9.e r4 = r2.h();
    L8:
        if (r4 == null) goto L10;
        String r3 = r4.a;
    L12:
        if (Intrinsics.areEqual(r3, r10.getConversationId()) == true) goto L14;
    L28:
        b(r9, r10);
        return;
    L14:
        if (ic8.n.v(r4) == true) goto L18;
        if (ic8.n.D(r4) == false) goto L28;
    L18:
        if (com.larus.bmhome.chat.bean.d.G0(r10) == true) goto L28;
        com.larus.bmhome.chat.api.q0.a r5 = r9.e;
        if (r5 == null) goto L27;
        com.larus.bmhome.chat.component.push.a r6 = r5.a9();
        if (r6 == null) goto L27;
        OpenPushReminderScene r7 = OpenPushReminderScene.LikeMsgForMainBot;
        com.larus.bmhome.chat.component.cvs.y r8 = r9.e.u0();
        if (r8 == null) goto L26;
        r1 = r8.j0();
    L26:
        a$a.a(r6, r7, r4, r1, null, new q(r9, r10), 8);
        return;
    L27:
        b(r9, r10);
        return;
    L10:
        r3 = null;
    L7:
        r4 = null;
        goto L8
    }

    public final rs8.j d(final Message r18, MessageActionBarAlign r19) {
        Intrinsics.checkNotNullParameter(r18, "msg");
        Intrinsics.checkNotNullParameter(r19, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("regen_next", "key");
        Context r5 = this.c;
        Drawable r6 = ContextCompat.getDrawable(r5, v19.c.b(2130971635, r5, 2131240791));
        int r13 = com.larus.utils.j0.a;
        return new rs8.j("regen_next", 2131380346, "", r6, null, 180.0f, r19, false, false, null, null, com.larus.utils.j0.d(2131898829), new o(r18, this), 1936);
    }

    public static Drawable f(Context r4, int r5, int r6) {
        int r0 = v19.c.b(r5, r4, r6);
        return ContextCompat.getDrawable(r4, r0);
    L5:
        e = move-exception;
        FLogger.a.e("ActionCreator", "getDrawableSafely failed attrId=" + r5 + " drawableRes=" + r0 + " defaultResource=" + r6, e);
        return null;
    }

    public final void g(final Message r15, long r16, String r18) {
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("performRegenerateAction msgId=");
        r2.append(r15.getMessageId());
        r2.append(" localMsgId=");
        r2.append(r15.getLocalMessageId());
        r2.append(" replyId=");
        r2.append(r15.getReplyId());
        r2.append(" clickFrom=answer chatKey=");
        r2.append(r16);
        r2.append(" hasInstruction=");
        boolean r3 = true;
        if (r18 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        r2.append(!r5);
        r1.i("ActionCreator", r2.toString());
        com.larus.bmhome.chat.api.q0.a r4 = this.e;
        if (r4 == null) goto L16;
        com.larus.bmhome.chat.component.regen.a r6 = r4.s5();
        if (r6 == null) goto L16;
        if (r6.nS(r15) != true) goto L16;
    L17:
        if (r3 == true) goto L21;
        r1.i("ActionCreator", "performRegenerateAction blocked by isRegenerateValid=false msgId=" + r15.getMessageId());
        return;
    L21:
        if (com.larus.im.bean.message.a.E(r15) == false) goto L26;
        IChatRepoService r7 = zh8.a.a;
        String r8 = r15.getLocalMessageId();
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        r7.r1(r8, new l(r15));
    L26:
        u7 r9 = this.e.u3();
        if (r9 == null) goto L37;
        com.larus.bmhome.chat.component.cvs.y r10 = this.e.u0();
        if (r10 == null) goto L31;
        wc9.e r11 = r10.h();
    L32:
        by7.e r12 = com.larus.utils.e1.k(this.b);
        if ((r12 instanceof by7.e) == false) goto L35;
        by7.e r13 = r12;
    L36:
        u7$a.c(r9, r11, r15, "answer", r13, false, null, r16, r18, 48);
        goto L37
    L35:
        r13 = null;
        goto L36
    L31:
        r11 = null;
    L37:
        u7 r14 = this.e.u3();
        if (r14 == null) goto L40;
        r14.O5(false);
    L40:
        com.larus.bmhome.chat.component.bottom.reference.a r17 = this.e.N9();
        if (r17 == null) goto L44;
        r17.xo(r15, false);
        return;
    L44:
        return;
    L16:
        r3 = false;
        goto L17
    L5:
        if (r18.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public final rs8.j e(final Message r22, MessageActionBarAlign r23, final Function0 r24, final Function0 r25) {
        Intrinsics.checkNotNullParameter(r22, "msg");
        Intrinsics.checkNotNullParameter(r23, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter("regenerate", "key");
        Intrinsics.checkNotNullParameter(r24, "chatKey");
        Intrinsics.checkNotNullParameter(r25, "isRegenEnable");
        Context r7 = this.c;
        Drawable r8 = ContextCompat.getDrawable(r7, v19.c.b(2130971801, r7, 2131241839));
        Integer r15 = Integer.valueOf(v19.c.b(2130971801, this.c, 2131241839));
        int r9 = com.larus.utils.j0.a;
        return new rs8.j("regenerate", 2131380352, "", r8, null, 0.0f, r23, false, false, r15, null, com.larus.utils.j0.d(2131898827), new f(r22, this, r25, r24), 1456);
    }

    public z(com.larus.bmhome.chat.api.q0 r2, com.larus.bmhome.chat.layout.item.i r3, Context r4, j0 r5, com.larus.bmhome.chat.api.q0.a r6) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "searchEnable");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = LazyKt.lazy(new u());
    }

    public final rs8.j a(final Message r23, final AnswerAction r24, MessageActionBarAlign r25, final String r26, final Function0<Long> r27) {
        Intrinsics.checkNotNullParameter(r23, "msg");
        Intrinsics.checkNotNullParameter(r24, "answerAction");
        Intrinsics.checkNotNullParameter(r25, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r26, "key");
        Intrinsics.checkNotNullParameter(r27, "chatKey");
        if (Intrinsics.areEqual(r26, "fork_conv") == false) goto L9;
        Drawable r1 = ContextCompat.getDrawable(this.c, 2131242701);
        if (r1 == null) goto L9;
        Drawable r2 = r1.mutate();
        if (r2 == null) goto L9;
        Context r11 = this.c;
        DrawableCompat.setTint(r2, ContextCompat.getColor(r11, v19.c.b(2130972123, r11, 2131103203)));
        Unit r12 = Unit.INSTANCE;
        Drawable r13 = r2;
    L10:
        ActionIcon r3 = r24.getIcon();
        if (r3 == null) goto L13;
        String r4 = r3.getDefault_url();
    L15:
        if (Intrinsics.areEqual(r26, "fork_conv") == true) goto L17;
        String r14 = r4;
    L19:
        if (Intrinsics.areEqual(r26, "fork_conv") == false) goto L21;
        Integer r17 = 2131242701;
    L23:
        return new rs8.j(r26, 2131380340, "", r13, r14, 0.0f, r25, false, false, r17, null, null, new y(r26, this, r23, r24, r27), 3488);
    L21:
        r17 = null;
        goto L23
    L17:
        r14 = null;
        goto L19
    L13:
        r4 = null;
    L9:
        r13 = null;
        goto L10
    }
}
