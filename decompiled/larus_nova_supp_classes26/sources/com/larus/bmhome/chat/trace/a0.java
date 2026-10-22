package com.larus.bmhome.chat.trace;

import com.larus.audio.AudioServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a0 implements Function0 {
    public /* synthetic */ a0() {
    }

    public final Object invoke() {
        Message r7 = ChatTTSPlayTrace.l;
        String r0 = null;
        if (r7 == null) goto L35;
        ChatTTSPlayTrace.b.getClass();
        wq8.b r1 = ChatTTSPlayTrace.d;
        if (r1 == null) goto L13;
        List<Message> r2 = r1.getCurrentList();
        if (r2 == null) goto L13;
        Message r3 = (Message) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L13;
        if (com.larus.bmhome.chat.bean.d.K0(r3) != true) goto L13;
        boolean r4 = true;
    L15:
        if ((!r4) == false) goto L36;
        long r5 = System.currentTimeMillis() - ChatTTSPlayTrace.i;
        AudioServiceDelegate r6 = AudioServiceDelegate.a;
        BotModel r8 = r6.i0().i();
        if (r8 == null) goto L21;
        SpeakerVoice r9 = r8.getVoiceType();
        if (r9 == null) goto L21;
        String r10 = r9.getId();
    L22:
        String r11 = "";
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        BotModel r12 = r6.i0().i();
        if (r12 == null) goto L30;
        SpeakerVoice r13 = r12.getVoiceType();
        if (r13 == null) goto L30;
        r0 = r13.getStyleId();
    L30:
        if (r0 == null) goto L33;
        r11 = r0;
    L33:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new ChatTTSPlayTrace$trackChatTTS$1(r7, r10, r11, r5, null), 3, null);
        return r7;
    L21:
        r10 = null;
        goto L22
    L36:
        return r7;
    L13:
        r4 = false;
        goto L15
    L35:
        return null;
    }
}
