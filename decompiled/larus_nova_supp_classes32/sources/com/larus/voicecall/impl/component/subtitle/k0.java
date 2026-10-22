package com.larus.voicecall.impl.component.subtitle;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.bmhome.view.MessageMenu;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import tx9.r1;
import tx9.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k0 implements Function1<ot8.a, Unit> {
    public final FragmentActivity a;
    public final LifecycleCoroutineScope b;
    public final com.larus.voicecall.impl.component.feedback.e c;
    public final CustomMarkdownTextView d;
    public final Message e;
    public final BotModel f;
    public final RealtimeCallSubtitleLayout g;
    public final RealtimeCallParam h;

    public static final class a {
    }

    static {
    }

    public final Object invoke(Object r51) {
        ot8.a r1 = (ot8.a) r51;
        Intrinsics.checkNotNullParameter(r1, "item");
        FLogger r2 = FLogger.a;
        r2.i("RealtimeSubtitleMenuPanelTrigger", "invoke: item = " + r1);
        if (this.a.isFinishing() == false) goto L5;
    L65:
        r2.i("RealtimeSubtitleMenuPanelTrigger", "invoke: activity is isFinishing or isDestroyed");
    L67:
        return Unit.INSTANCE;
    L5:
        if (this.a.isDestroyed() == true) goto L65;
        int r3 = r1.getId();
        String r4 = null;
        if (r3 != 2131907401) goto L29;
        Message r5 = this.e;
        if (r5 == null) goto L13;
        BuildersKt.launch$default(this.b, null, null, new RealtimeSubtitleMenuPanelTrigger$handleCopyMessage$1(this, r5, null), 3, null);
    L13:
        Message r6 = this.e;
        if (r6 == null) goto L16;
        String r7 = r6.getMessageId();
    L17:
        if (r7 != null) goto L19;
        String r10 = NameKeys.UnloadStrategy_No_Strategy;
    L20:
        String r8 = this.h.e;
        Message r9 = this.e;
        if (r9 == null) goto L23;
        String r43 = com.larus.im.bean.message.a.r(r9);
    L24:
        Message r11 = this.e;
        if (r11 == null) goto L27;
        r4 = com.larus.im.bean.message.a.s(r11);
    L27:
        tx9.j0.a(null, null, "long_press_answer", null, null, r10, null, null, null, null, null, null, null, null, null, null, null, null, "call_subtitle", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "text", r8, null, null, r43, r4, null, null, null, -536871045, 7577599);
        goto L67
    L23:
        r43 = null;
        goto L24
    L19:
        r10 = r7;
        goto L20
    L16:
        r7 = null;
        goto L17
    L29:
        if (r3 != 2131907407) goto L35;
        final CustomMarkdownTextView r12 = this.d;
        MessageMenu r13 = new MessageMenu(r12, null, null, Boolean.TRUE, null, new j0(r12), SpeechEvent.SERVER_UPLINK_EVENT_MUTE_CALL);
        r13.s = new l0(this);
        RealtimeCallSubtitleLayout r14 = this.g;
        if (r14 == null) goto L33;
        RecyclerView r15 = r14.getRecycler();
    L34:
        r13.f(r15, null, null);
        goto L67
    L33:
        r15 = null;
        goto L34
    L35:
        boolean r16 = true;
        if (r3 != 2131907405) goto L51;
        Message r17 = this.e;
        if (r17 != null) goto L40;
    L42:
        r16 = false;
    L43:
        if (r16 == false) goto L49;
        String r18 = this.e.getMessageId();
        if (r18 != null) goto L47;
        String r19 = NameKeys.UnloadStrategy_No_Strategy;
    L48:
        r1.a(null, "long_press_answer", null, r19, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, "call_subtitle", this.h.e, null, null, -265, 831);
        goto L49
    L47:
        r19 = r18;
    L49:
        BuildersKt.launch$default(this.b, null, null, new RealtimeSubtitleMenuPanelTrigger$handleLikeMessage$1(this, null), 3, null);
        goto L67
    L40:
        if (com.larus.bmhome.chat.bean.d.q0(r17) == true) goto L42;
    L51:
        if (r3 != 2131907403) goto L67;
        Message r20 = this.e;
        if (r20 != null) goto L55;
    L57:
        r16 = false;
    L58:
        if (r16 == false) goto L64;
        String r21 = this.e.getMessageId();
        if (r21 != null) goto L62;
        String r22 = NameKeys.UnloadStrategy_No_Strategy;
    L63:
        s0.a(null, "long_press_answer", null, r22, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, "call_subtitle", this.h.e, null, null, -137, 415);
        goto L64
    L62:
        r22 = r21;
    L64:
        BuildersKt.launch$default(this.b, null, null, new RealtimeSubtitleMenuPanelTrigger$handleDislikeMessage$1(this, null), 3, null);
        goto L67
    L55:
        if (com.larus.bmhome.chat.bean.d.h0(r20) == true) goto L57;
        goto L57
    }

    public k0(FragmentActivity r2, LifecycleCoroutineScope r3, com.larus.voicecall.impl.component.feedback.e r4, CustomMarkdownTextView r5, Message r6, BotModel r7, RealtimeCallSubtitleLayout r8, RealtimeCallParam r9) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r9, "callParam");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
