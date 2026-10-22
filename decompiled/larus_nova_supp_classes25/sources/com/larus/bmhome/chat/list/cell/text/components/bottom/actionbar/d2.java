package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.chat.model.repo.x1$b;
import com.larus.bmhome.utils.FormatSource;
import com.larus.bmhome.utils.s2;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d2 {
    public final Context a;
    public final com.larus.bmhome.chat.api.q0 b;
    public final com.larus.bmhome.chat.api.q0.a c;
    public final MessageActionBarAlign d;
    public final CustomMarkdownTextView e;
    public final Function0<Long> f;
    public final BotModel g;
    public final t1a.b h;
    public final Fragment i;
    public final boolean j;

    public static final class a {
    }

    static {
    }

    public static String c() {
        return zh8.a.a.getReceiver().c().o6();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.c2] */
    public final rs8.n e(final Message r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        z2.a.w3();
        MessageActionBarAlign r0 = this.d;
        int r1 = com.larus.utils.j0.a;
        return new rs8.n(r0, com.larus.utils.j0.d(2131898826), new c2(this, r5));
    }

    public final rs8.j f(final Function0 r19) {
        Intrinsics.checkNotNullParameter(r19, "msgGetter");
        Context r2 = this.a;
        Drawable r7 = ContextCompat.getDrawable(r2, v19.c.b(2130971770, r2, 2131241589));
        MessageActionBarAlign r10 = this.d;
        int r3 = com.larus.utils.j0.a;
        return new rs8.j("tts", 2131380350, "", r7, null, 0.0f, r10, false, false, null, null, com.larus.utils.j0.d(2131898826), new b2(this, r19), 1968);
    }

    public final rs8.g b(PlayStateEnum r10, Function0<Message> r11) {
        Intrinsics.checkNotNullParameter(r11, "msgGetter");
        boolean r1 = false;
        if (r10 == null) goto L5;
        int r12 = r10.getState();
    L6:
        Intrinsics.checkNotNullParameter(r11, "msgGetter");
        Message r0 = (Message) r11.invoke();
        IObricContinuousTalkService r2 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        if (r2 == null) goto L12;
        if (r2.a(r0.getMessageId()) != true) goto L12;
        r1 = true;
    L12:
        if (Intrinsics.areEqual(c(), r0.getMessageId()) == true) goto L15;
        if (r1 == true) goto L15;
        FLogger.a.d("TtsActionCreator", "setup action bar, reading message not equal. reading msg id: " + c() + ", cur msg id: " + r0.getMessageId() + ", replyId: " + r0.getReplyId() + ", obricContinuousTtsPlaying=" + r1 + '.');
        return f(r11);
    L15:
        FLogger.a.i("TtsActionCreator", "setup action bar, reading message equal. reading msg id: " + c() + ", cur msg id: " + r0.getMessageId() + ", replyId: " + r0.getReplyId() + ", state: " + r12 + ", obricContinuousTtsPlaying=" + r1);
        if (r1 == false) goto L19;
        return e(r0);
    L19:
        if (r12 != PlayStateEnum.PLAY_STATE_PLAYING.getState()) goto L22;
        return e(r0);
    L22:
        if (r12 != PlayStateEnum.PLAY_STATE_PREPARE.getState()) goto L25;
        return f(r11);
    L25:
        return f(r11);
    L5:
        r12 = 0;
        goto L6
    }

    public static final Object a(d2 r37, Message r38, Continuation r39) {
        r37.getClass();
        com.larus.bmhome.chat.model.repo.x1 r2 = zh8.a.a.getReceiver().c();
        com.larus.bmhome.chat.api.q0.a r1 = r37.c;
        lw8.l r3 = null;
        if (r1 == null) goto L7;
        com.larus.bmhome.chat.component.cvs.y r4 = r1.u0();
        if (r4 == null) goto L7;
        wc9.e r5 = r4.h();
    L8:
        LruCache r6 = ko8.a.a;
        if (r5 == null) goto L11;
        Integer r7 = r5.v;
    L12:
        BotModel r8 = r37.g;
        if (r8 == null) goto L15;
        Integer r9 = r8.getBotType();
    L16:
        BotModel r10 = r37.g;
        if (r10 == null) goto L21;
        BotCreatorInfo r11 = r10.getBotCreatorInfo();
        if (r11 == null) goto L21;
        String r12 = r11.getId();
    L22:
        String r13 = ko8.a.f(r7, r9, Intrinsics.areEqual(r12, AccountService.a.getUserId()));
        if (com.larus.im.bean.message.a.y0(r38) == true) goto L25;
    L51:
        Object r0 = x1$b.b(r2, r38, null, false, "click_play", r13, TtsScene.Manual_ActionView, r39, 22);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L55;
        return r0;
    L55:
        return Unit.INSTANCE;
    L25:
        if (com.larus.bmhome.chat.bean.d.j0(r38) == false) goto L51;
        if (r37.g == null) goto L51;
        gw8.c.a.getClass();
        gw8.c r14 = gw8.c.a.b();
        if (r14 == null) goto L44;
        CustomMarkdownTextView r15 = r37.e;
        boolean r16 = true;
        String r17 = hc8.b.a.a(hc8.c.a, r38, r37.g, true, 8);
        if (r38.getMessageStatusLocal() != 23) goto L33;
    L42:
        r3 = gw8.c.b.b(r14, r15, r17, r16, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31));
        goto L44
    L33:
        if (r38.getMessageStatusLocal() == 22) goto L42;
        if (com.larus.bmhome.chat.bean.d.I0(r38) == false) goto L37;
    L41:
        r16 = false;
        goto L42
    L37:
        if (r38.getMessageStatusLocal() == 20) goto L41;
        if (com.larus.bmhome.chat.bean.d.Q0(r38) == true) goto L41;
    L44:
        int r18 = s2.a;
        String r19 = s2.b(r3, FormatSource.TTS, 4);
        String r20 = r37.g.getBotId();
        if (r20 != null) goto L47;
        r20 = "";
    L47:
        Object r21 = x1$b.a(r2, r38, r19, r20, r13, false, null, TtsScene.Manual_ActionView, null, r39, 352);
        if (r21 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L56;
        return r21;
    L56:
        return Unit.INSTANCE;
    L21:
        r12 = null;
        goto L22
    L15:
        r9 = null;
        goto L16
    L11:
        r7 = null;
    L7:
        r5 = null;
        goto L8
    }

    public final void d(Message r71, com.larus.bmhome.chat.api.q0.a r72, String r73, String r74) {
        if (r72 == null) goto L8;
        com.larus.bmhome.chat.component.cvs.y r1 = r72.u0();
        if (r1 == null) goto L8;
        BotModel r2 = r1.j0();
        if (r2 == null) goto L8;
    L9:
        com.larus.bmhome.chat.api.q0 r3 = this.b;
        if (r3 == null) goto L18;
        com.larus.bmhome.chat.api.i0 r4 = r3.N7();
        if (r4 == null) goto L18;
        ry8.b r5 = (ry8.b) r4.invoke();
        if (r5 == null) goto L18;
        Boolean r6 = r5.L9();
        if (r6 == null) goto L18;
        boolean r7 = r6.booleanValue();
    L19:
        com.larus.bmhome.chat.api.q0.a r8 = this.c;
        String r9 = null;
        if (r8 == null) goto L24;
        com.larus.bmhome.chat.component.cvs.y r10 = r8.u0();
        if (r10 == null) goto L24;
        wc9.e r11 = r10.h();
    L25:
        String r12 = r2.getBotId();
        String r13 = r71.getConversationId();
        if (r13 == null) goto L28;
        Long r14 = StringsKt.toLongOrNull(r13);
    L30:
        if (com.larus.bmhome.chat.bean.d.z0(r71) == false) goto L32;
        long r15 = 1;
    L33:
        String r16 = r71.getMessageId();
        if (r7 == false) goto L36;
        String r17 = "1";
    L37:
        String r18 = r17;
        LruCache r19 = ko8.a.a;
        if (r11 == null) goto L40;
        Integer r20 = r11.v;
    L41:
        Integer r21 = r2.getBotType();
        BotCreatorInfo r22 = r2.getBotCreatorInfo();
        if (r22 == null) goto L44;
        r9 = r22.getId();
    L44:
        String r23 = ko8.a.f(r20, r21, Intrinsics.areEqual(r9, AccountService.a.getUserId()));
        boolean r24 = com.larus.bmhome.chat.bean.d.Q0(r71);
        tx9.c0.G(r12, r23, "answer", r14, Long.valueOf(r15), r16, r73, r18, Boolean.valueOf(r24), r74, "main_text", Boolean.valueOf(com.larus.bmhome.chat.bean.d.f0(r71)), Boolean.valueOf(com.larus.bmhome.chat.bean.d.K0(r71)), IAIChatControlTraceService.a.ob(((Number) this.f.invoke()).longValue()), 262752);
        return;
    L40:
        r20 = null;
        goto L41
    L36:
        r17 = "0";
        goto L37
    L32:
        r15 = 0;
        goto L33
    L28:
        r14 = null;
    L24:
        r11 = null;
    L18:
        r7 = false;
    L8:
        r2 = new BotModel("-1", "unknown", null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -132, Integer.MAX_VALUE, null);
        goto L9
    }

    public d2(Context r3, com.larus.bmhome.chat.api.q0 r4, com.larus.bmhome.chat.api.q0.a r5, MessageActionBarAlign r6, Function0 r7, BotModel r8, t1a.b r9, Fragment r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r7, "chatKey");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = null;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        ContextCompat.getDrawable(r3, v19.c.b(2130971770, r3, 2131241589));
        ActionStyle r12 = ActionStyle.NORMAL;
        rs8.i r13 = new rs8.i();
        Intrinsics.checkNotNullParameter("", "description");
        Intrinsics.checkNotNullParameter(r6, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r12, "style");
        Intrinsics.checkNotNullParameter("", "accessibilityContent");
        Intrinsics.checkNotNullParameter(r13, "onClick");
        Intrinsics.checkNotNullParameter("MainBot", "module");
        Intrinsics.checkNotNullParameter("ActionCreator", "subModule");
        Intrinsics.checkNotNullParameter("MainBot-ActionCreator", "tag");
    }
}
