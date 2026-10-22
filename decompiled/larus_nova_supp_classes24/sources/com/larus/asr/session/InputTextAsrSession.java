package com.larus.asr.session;

import com.larus.asr.ChatBottomSpeakerComponent$f;
import com.larus.asr.VoiceInputType;
import com.larus.asr.x5;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class InputTextAsrSession implements o {
    public final p a;
    public final String b;
    public boolean c;
    public boolean d;
    public Long e;
    public final f2a.d f;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.h> g;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.b> h;
    public final AtomicReference<com.larus.bmhome.chat.component.bottom.core.speaker.g> i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.o
    public final void b3(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "withExtHandle");
    }

    @Override // com.larus.asr.session.o
    public final void clear() {
    }

    @Override // com.larus.asr.session.o
    public final void la(Function1<? super com.larus.audio.b, Boolean> r2, Function1<? super com.larus.audio.a, Boolean> r3, Function2<? super String, ? super byte[], Unit> r4, Function1<? super String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "successResultHandle");
        Intrinsics.checkNotNullParameter(r3, "failResultHandle");
        Intrinsics.checkNotNullParameter(r4, "audioDataHandle");
        Intrinsics.checkNotNullParameter(r5, "handle");
    }

    @Override // com.larus.asr.session.o
    public final void na(Function2<? super String, ? super Boolean, Unit> r1) {
    }

    @Override // com.larus.asr.session.o
    public final void onStop() {
    }

    @Override // com.larus.asr.session.o
    public final void sa(ChatBottomSpeakerComponent$f r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
    }

    @Override // com.larus.asr.session.o
    public final com.larus.bmhome.chat.component.bottom.core.speaker.g J5() {
        return this.i.get();
    }

    @Override // com.larus.asr.session.o
    public final boolean m0() {
        return this.c;
    }

    @Override // com.larus.asr.session.o
    public final void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h.remove(r2);
    }

    @Override // com.larus.asr.session.o
    public final void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.add(r2);
    }

    @Override // com.larus.asr.session.o
    public final void oa(com.larus.bmhome.chat.component.bottom.core.speaker.g r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        FLogger.a.i("InputTextAsrSession", "notifyStateChanged state: " + r4.getClass());
        this.i.set(r4);
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.bmhome.chat.component.bottom.core.speaker.h) r0.next()).a(r4);
        goto L4
    }

    @Override // com.larus.asr.session.o
    public final void ra(Function2<? super String, ? super String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "handle");
    }

    public InputTextAsrSession(p r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        this.a = r2;
        this.b = r3;
        this.f = new f2a.d("VoiceInput", "InputTextAsrSession");
        this.g = new CopyOnWriteArraySet();
        this.h = new CopyOnWriteArraySet();
        this.i = new AtomicReference();
    }

    @Override // com.larus.asr.session.o
    public final void qa(String r14, Message r15) {
        Intrinsics.checkNotNullParameter(r14, "taskId");
        this.d = true;
        this.a.setKeepScreenOn(false);
        e2a.e.a();
        x5.a().d(r14);
        if (x5.c().a() == false) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new InputTextAsrSession$cancel$1(null), 3, null);
    L5:
        this.c = false;
        this.a.L8(false, false, "onCancel:" + r14, VoiceInputType.TouchSpeaker, r14);
        oa(com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a);
    }

    @Override // com.larus.asr.session.o
    public final void ma(String r8, Message r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "taskId");
        FLogger.a.i("InputTextAsrSession", "ChatBottomComponentWrapper AsrClientManager.stopAsrStream 01");
        com.larus.audio.k0 r11 = x5.a();
        if (r9 == null) goto L5;
        String r12 = r9.getLocalMessageId();
    L6:
        r11.g(r8, r12, this.a.I9());
        this.a.L8(false, false, "onSubmit1:" + r8, VoiceInputType.TouchSpeaker, r8);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static void a(InputTextAsrSession r8, String r9, boolean r10, String r11, int r12) {
        if ((r12 & 16) == 0) goto L5;
        boolean r3 = true;
    L6:
        r8.getClass();
        if (r10 == false) goto L9;
        FLogger.a.i("InputTextAsrSession", "setSpeakerVisible visible isSpeaking:" + r8.c);
        r8.a.sb("ban_speaker_visible_" + r11);
        e2a.e.b();
        r8.a.L8(true, r3, r11, VoiceInputType.TouchSpeaker, r9);
        r8.a.Ja(r9, null);
    L10:
        Unit r13 = Unit.INSTANCE;
        return;
    L9:
        FLogger.a.i("InputTextAsrSession", "setSpeakerVisible invisible");
        r8.c = false;
        r8.a.L8(false, false, r11, VoiceInputType.TouchSpeaker, r9);
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [com.larus.asr.session.q] */
    @Override // com.larus.asr.session.o
    public final void pa(String r3, boolean r4, boolean r5, final com.larus.audio.asr.c0 r6, long r7, Long r9, final Integer r10, d58.a r11) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        Intrinsics.checkNotNullParameter(r6, "traceInfo");
        Intrinsics.checkNotNullParameter(r11, "durationConfig");
        wc9.e r8 = this.a.h();
        if (r8 == null) goto L5;
        String r12 = r8.a;
    L6:
        String r13 = "";
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        BotModel r14 = this.a.i();
        if (r14 == null) goto L12;
        String r15 = r14.getBotId();
    L13:
        if (r15 == null) goto L16;
        r13 = r15;
    L16:
        this.e = r9;
        BotModel r16 = this.a.i();
        if (r16 == null) goto L19;
        String r17 = r16.getBotId();
    L20:
        if (r17 == null) goto L23;
        final String r19 = "actionbar_instruction_" + System.currentTimeMillis();
        final ?? r20 = new q(this, r19, r6, r10);
        this.a.Bb(new t(this, r19, r20));
    L23:
        f2a.c r21 = this.f.b("interceptAsrToInputText");
        LinkedHashMap r22 = new LinkedHashMap();
        r22.put(new f2a.f("from_text_area"), String.valueOf(r4));
        r22.put(new f2a.f("asr_only"), "false");
        r22.put(f2a.f.h, r12);
        r22.put(f2a.f.e, r13);
        r21.d(r22);
        r21.c.d = "invokeOnSpeak";
        List r23 = CollectionsKt.listOf(r6.a);
        f2a.g r24 = r21.c;
        r24.b = r23;
        r24.e = r6.b;
        f2a.c.c(r21, null, 15);
        return;
    L19:
        r17 = null;
        goto L20
    L12:
        r15 = null;
        goto L13
    L5:
        r12 = null;
        goto L6
    }
}
