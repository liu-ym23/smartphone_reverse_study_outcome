package com.obric.audio.continuous_talk.session.impl.plugin;

import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.z0;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricContTalkPlugin extends com.larus.audio.call.arch.a<com.obric.audio.continuous_talk.session.impl.a> implements b {
    public final String f;
    public hia.a.b g;
    public Job h;
    public Job i;
    public final MutableSharedFlow<hia.b> j;
    public volatile String k;
    public String l;
    public String m;
    public String n;
    public Long o;
    public String p;
    public final a q;
    public boolean r;
    public float[] s;

    public static final class a implements nf9.b {
        public final /* synthetic */ ObricContTalkPlugin a;

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public a(ObricContTalkPlugin r1) {
            this.a = r1;
        }

        public final void b(String r8, MessageListState r9, List<Message> r10) {
            Intrinsics.checkNotNullParameter(r8, "cid");
            Intrinsics.checkNotNullParameter(r9, "state");
            Intrinsics.checkNotNullParameter(r10, "msgList");
            if (r9 == MessageListState.INSERT) goto L5;
            return;
        L5:
            Message r11 = (Message) CollectionsKt.firstOrNull(r10);
            if (r11 != null) goto L8;
            return;
        L8:
            ObricContTalkPlugin r12 = this.a;
            boolean r1 = false;
            if (r12.j3(r8, r11) == false) goto L24;
            String r13 = r11.getMessageId();
            if (r13 != null) goto L14;
        L17:
            boolean r3 = true;
        L18:
            if (r3 == false) goto L21;
            r13 = null;
        L21:
            if (r13 == null) goto L24;
            ((com.obric.audio.continuous_talk.session.impl.a) r12.getContext()).g(r13);
            goto L24
        L14:
            if (r13.length() == 0) goto L17;
            r3 = false;
        L24:
            ObricContTalkPlugin r14 = this.a;
            r14.getClass();
            Map r15 = r11.getExt();
            if (r15 == null) goto L27;
            String r16 = (String) r15.get("is_obric_continuous_talk");
        L28:
            boolean r17 = Intrinsics.areEqual(r16, "1");
            if (com.larus.bmhome.chat.bean.d.G0(r11) == false) goto L62;
            if (r17 == false) goto L65;
            Map r18 = r11.getExt();
            if (r18 == null) goto L35;
            String r19 = (String) r18.get("obric_continuous_task_id");
        L36:
            if (r19 != null) goto L38;
        L41:
            boolean r110 = true;
        L42:
            if (r110 == false) goto L66;
            String r20 = r11.getMessageId();
            String r111 = r14.k;
            FLogger.a.i(r14.f, "continuousTaskIdObserver currentAsrTaskId=" + r111 + ", messageId=" + r20);
            if (r111 != null) goto L47;
        L50:
            boolean r4 = true;
        L51:
            if (r4 == true) goto L63;
            if (r20 != null) goto L54;
        L55:
            r1 = true;
        L56:
            if (r1 == true) goto L67;
            CoroutineScope r2 = ((com.obric.audio.continuous_talk.session.impl.a) r14.getContext()).r();
            if (r2 == null) goto L64;
            BuildersKt.launch$default(r2, null, null, new ObricContTalkPlugin$updateContinuousTaskIdIfNeeded$1(r20, r111, null), 3, null);
            return;
        L64:
            return;
        L67:
            return;
        L54:
            if (r20.length() != 0) goto L56;
        L63:
            return;
        L47:
            if (r111.length() == 0) goto L50;
            r4 = false;
            goto L51
        L66:
            return;
        L38:
            if (r19.length() == 0) goto L41;
            r110 = false;
            goto L42
        L35:
            r19 = null;
            goto L36
        L65:
            return;
        L62:
            return;
        L27:
            r16 = null;
            goto L28
        }
    }

    public final z0 S2() {
        return new ObricContTalkPlugin$createSessionListener$1(this);
    }

    public final void e3() {
        super.e3();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        com.larus.im.d.e().registerOnGlobalMessageObserver(this.q);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Job r1 = this.i;
        Job r2 = null;
        if (r1 == null) goto L10;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L10:
        CoroutineScope r3 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).r();
        if (r3 == null) goto L13;
        r2 = BuildersKt.launch$default(r3, null, null, new ObricContTalkPlugin$onStart$2(this, null), 3, null);
    L13:
        this.i = r2;
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void g3() {
        super.g3();
        Job r0 = this.h;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.h = null;
        Job r1 = this.i;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.i = null;
        this.s = new float[0];
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        com.larus.im.d.e().unregisterOnGlobalMessageObserver(this.q);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final String T2() {
        return this.f;
    }

    @Override // com.obric.audio.continuous_talk.session.impl.plugin.b
    public final MutableSharedFlow s() {
        return this.j;
    }

    public ObricContTalkPlugin(com.obric.audio.continuous_talk.session.impl.a r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.f = "ObricContTalkPlugin";
        this.j = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, null);
        this.q = new a(this);
        this.s = new float[0];
    }

    @Override // com.obric.audio.continuous_talk.session.impl.plugin.b
    public final void B0(com.obric.audio.continuous_talk.i r1) {
        this.g = r1;
    }

    @Override // com.obric.audio.continuous_talk.session.impl.plugin.b
    public final void H1(float[] r6) {
        Intrinsics.checkNotNullParameter(r6, "featureValues");
        boolean r2 = true;
        if (r6.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (r6.length < 2) goto L36;
        float[] r1 = this.s;
        if (r1.length != 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L17;
        this.r = true;
        this.j.tryEmit(hia.b.h.a);
    L33:
        this.s = Arrays.copyOf(r6, r6.length);
        return;
    L17:
        if (r1.length >= 2) goto L20;
        return;
    L20:
        if (r1[r1.length - 2] != r6[r6.length - 2]) goto L22;
        boolean r3 = true;
    L23:
        if (r3 == true) goto L26;
        this.r = true;
        this.j.tryEmit(hia.b.h.a);
        goto L33
    L26:
        if (r6[r6.length - 1] == 0.0f) goto L29;
        r2 = false;
    L29:
        if (r2 == true) goto L33;
        if (this.r == false) goto L33;
        this.r = false;
        this.j.tryEmit(hia.b.i.a);
        goto L33
    L22:
        r3 = false;
        goto L23
    L13:
        r4 = false;
        goto L14
    L36:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.audio.continuous_talk.session.impl.plugin.b
    public final boolean I0(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        id9.d r0 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).j();
        if (r0 == null) goto L6;
        r0.p(TriggerMode.CHAT_REQUEST, r3.toString());
        return true;
    L6:
        return false;
    }

    public final boolean j3(String r4, Message r5) {
        if (com.larus.bmhome.chat.bean.d.G0(r5) == false) goto L5;
        return false;
    L5:
        Map r6 = r5.getExt();
        String r0 = null;
        if (r6 == null) goto L8;
        String r7 = (String) r6.get("is_obric_continuous_talk");
    L10:
        if (Intrinsics.areEqual(r7, "1") == true) goto L12;
        return false;
    L12:
        String r8 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).params().o.c;
        if ((!StringsKt.isBlank(r8)) == false) goto L15;
        r0 = r8;
    L15:
        if (r0 != null) goto L18;
        r0 = ((com.obric.audio.continuous_talk.session.impl.a) getContext()).params().l.c;
    L18:
        return Intrinsics.areEqual(r4, r0);
    L8:
        r7 = null;
        goto L10
    }
}
