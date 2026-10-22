package com.larus.bmhome.chat.component.list;

import androidx.lifecycle.Lifecycle;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.a;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponentViewModel$a implements ChatMessageReceiverModel.d {
    public final String a;
    public String b;
    public boolean c;
    public final /* synthetic */ ChatListComponentViewModel d;

    public static TextContent c(Message r12) {
        if (r12.getContentType() == 1) goto L11;
        if (r12.getContentType() == 9999) goto L11;
        if (d.a0(r12) == true) goto L11;
        return null;
    L11:
        if (a.b0(r12) == true) goto L16;
        Regex r0 = d.a;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r12, "<this>");
        return vd9.r.b(r12);
    L16:
        return new TextContent(a.e(r12), null, null, null, null, null, null, null, DoraCallStateCode.DOUBAO_STOP_CALL_BY_SPRING_DEGRADE, null);
    }

    public final void A5(boolean r5) {
        FLogger.a.i(this.a, "ttsEnable from " + this.c + " to " + r5);
        this.c = r5;
        es8.d.a = r5;
    }

    public ChatListComponentViewModel$a(ChatListComponentViewModel r2, Function0<wc9.e> r3) {
        this.d = r2;
        String r4 = "ChatMessageTtsPlayer_" + hashCode();
        this.a = r4;
        this.b = "";
        if (r3 == null) goto L5;
        wc9.e r5 = (wc9.e) r3.invoke();
    L6:
        if (r5 == null) goto L8;
        boolean r6 = r5.i;
    L9:
        es8.d.a = r6;
        this.c = r6;
        FLogger.a.i(r4, "init");
        return;
    L8:
        r6 = true;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    public final void a(Message r12, TtsScene r13) {
        Intrinsics.checkNotNullParameter(r12, "msg");
        Intrinsics.checkNotNullParameter(r13, "fromScene");
        BuildersKt.launch$default(ChatListComponentViewModel.access$getViewModelScope(this.d), null, null, new ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1(this, r12, false, this.d, r13, null), 3, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x013e -> B:48:0x0140). Please report as a decompilation issue!!! */
    public static final Object b(ChatListComponentViewModel$a r16, Message r17, boolean r18, Continuation r19) {
        r16.getClass();
        if ((r19 instanceof ChatListComponentViewModel$ChatMessageTtsPlayer$obricCanStartTts$1) == false) goto L7;
        ChatListComponentViewModel$ChatMessageTtsPlayer$obricCanStartTts$1 r2 = (ChatListComponentViewModel$ChatMessageTtsPlayer$obricCanStartTts$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        String r9 = "";
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r6 = r2.I$0;
        Message r11 = (Message) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L48:
        int r7 = r6 + 1;
        Message r8 = r11;
    L39:
        if (r7 < ChatListComponentViewModel.access$getTtsWaitCount$p(r16.d)) goto L41;
    L49:
        FLogger.a.i(r16.a, "[TTS][NOT_PLAY_LIFE] endLifecycle: " + r16.d.getLifecycle().getCurrentState() + ", waitCount: " + r7 + ", totalWaitTime: " + (((long) r7) * ChatListComponentViewModel.access$getTtsWaitInterval$p(r16.d)));
    L51:
        if (r16.d.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L58;
        f2a.c r0 = ChatListComponentViewModel.access$getLogger$p(r16.d).b("[TTS][NOT_PLAY_LIFE_STATE] lifecycle: " + r16.d.getLifecycle().getCurrentState());
        r0.c.b = CollectionsKt.listOf("TtsPlay");
        f2a.f r10 = f2a.f.i;
        String r12 = r8.getMessageId();
        if (r12 == null) goto L56;
        r9 = r12;
    L56:
        r0.d(MapsKt.mapOf(TuplesKt.to(r10, r9)));
        f2a.c.c(r0, null, 15);
        return Boxing.boxBoolean(false);
    L58:
        return Boxing.boxBoolean(true);
    L41:
        if (r16.d.getLifecycle().getCurrentState() != Lifecycle.State.CREATED) goto L43;
    L44:
        long r13 = ChatListComponentViewModel.access$getTtsWaitInterval$p(r16.d);
        r2.L$0 = r8;
        r2.I$0 = r7;
        r2.label = 1;
        if (DelayKt.delay(r13, r2) == r4) goto L60;
        r11 = r8;
        r6 = r7;
        goto L48
    L60:
        return r4;
    L43:
        if (r16.d.getLifecycle().getCurrentState() != Lifecycle.State.STARTED) goto L49;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        ChatMessageReceiverModel.d r14 = ChatListComponentViewModel.access$getTtsPlayListener$p(r16.d);
        if (r14 != r16) goto L17;
        r8 = r17;
        if (ObricTtsControlDelegate.b.j(r8) == true) goto L58;
        FLogger r15 = FLogger.a;
        r15.i(r16.a, "[TTS][NOT_OBRIC_BACKGROUND_PLAY_CASE], shouldPlayInBackground = false");
        if (r18 == true) goto L51;
        if (r16.d.getLifecycle().getCurrentState() != Lifecycle.State.CREATED) goto L36;
    L37:
        Lifecycle.State r110 = r16.d.getLifecycle().getCurrentState();
        r15.i(r16.a, "[TTS][NOT_PLAY_LIFE] beginLifecycle: " + r110);
        r7 = 0;
        goto L39
    L36:
        if (r16.d.getLifecycle().getCurrentState() != Lifecycle.State.STARTED) goto L51;
    L17:
        if ((r14 instanceof ChatListComponentViewModel$a) == false) goto L19;
        ChatListComponentViewModel$a r20 = (ChatListComponentViewModel$a) r14;
    L20:
        if (r20 == null) goto L23;
        String r21 = r20.a;
        if (r21 == null) goto L23;
    L24:
        f2a.c r22 = ChatListComponentViewModel.access$getLogger$p(r16.d).b("[TTS][SKIP_OLD_PLAYER] ignore stale tts player");
        r22.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r23 = new Pair[3];
        f2a.f r24 = f2a.f.i;
        String r111 = r17.getMessageId();
        if (r111 == null) goto L28;
        r9 = r111;
    L28:
        r23[0] = TuplesKt.to(r24, r9);
        r23[1] = TuplesKt.to(new f2a.f("latest_player"), r21);
        r23[2] = TuplesKt.to(new f2a.f("current_player"), r16.a);
        r22.d(MapsKt.mapOf(r23));
        f2a.c.c(r22, null, 15);
        return Boxing.boxBoolean(false);
    L23:
        r21 = "null";
        goto L24
    L19:
        r20 = null;
    L7:
        r2 = new ChatListComponentViewModel$ChatMessageTtsPlayer$obricCanStartTts$1(r16, r19);
        goto L8
    }
}
