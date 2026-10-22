package com.larus.suggest.impl.wcb.policy;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class MainConversationDisplayFrequencyPolicy implements t {
    public static final MainConversationDisplayFrequencyPolicy a = null;

    public static final class a implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ kotlinx.coroutines.i<s> a;
        public final /* synthetic */ hx9.l b;
        public final /* synthetic */ long c;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("WcbLog", "checkMsgInterval getMessageListFromLocal failed, error: " + r4);
            if (this.a.isActive() == false) goto L6;
            kotlinx.coroutines.i<s> r5 = this.a;
            Result.Companion r0 = Result.Companion;
            MainConversationDisplayFrequencyPolicy r1 = MainConversationDisplayFrequencyPolicy.a;
            r5.resumeWith(Result.constructor-impl(MainConversationDisplayFrequencyPolicy.b(this.b.c(), this.c)));
            return;
        }

        public final void onSuccess(Object r4) {
            List r5 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            FLogger.a.w("WcbLog", "checkMsgInterval getMessageListFromLocal success, size = " + r5.size());
            if (this.a.isActive() == false) goto L6;
            kotlinx.coroutines.i<s> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            MainConversationDisplayFrequencyPolicy r2 = MainConversationDisplayFrequencyPolicy.a;
            r0.resumeWith(Result.constructor-impl(MainConversationDisplayFrequencyPolicy.b(r5, this.c)));
            return;
        }

        public a(kotlinx.coroutines.j r1, hx9.l r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        a = new MainConversationDisplayFrequencyPolicy();
    }

    public MainConversationDisplayFrequencyPolicy() {
    }

    public static final s b(List r12, long r13) {
        List r0 = r12;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L139;
        List r14 = r12;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r14.iterator();
    L13:
        if (r4.hasNext() == false) goto L49;
        Object r5 = r4.next();
        Message r6 = (Message) r5;
        if (com.larus.bmhome.social.userchat.model.b0.f(r6) == false) goto L17;
    L46:
        boolean r7 = false;
    L47:
        if (r7 == false) goto L13;
        r3.add(r5);
        goto L13
    L17:
        if (com.larus.bmhome.chat.bean.d.W0(r6) == true) goto L46;
        if (com.larus.bmhome.chat.bean.d.i0(r6) == false) goto L24;
        if (com.larus.bmhome.chat.bean.d.w(r6) == true) goto L24;
    L43:
        boolean r8 = false;
    L44:
        if (r8 == false) goto L46;
        r7 = true;
    L24:
        if (com.larus.bmhome.chat.bean.d.T(r6) == true) goto L43;
        if (com.larus.bmhome.chat.bean.d.p0(r6) == true) goto L43;
        if (com.larus.bmhome.chat.bean.d.C0(r6) == true) goto L31;
    L33:
        MessageStatus r9 = r6.getMessageStatus();
        if (r9 != null) goto L36;
    L38:
        boolean r10 = false;
    L39:
        if (r10 == false) goto L41;
    L42:
        r8 = true;
        goto L44
    L41:
        if (com.larus.bmhome.social.userchat.model.b0.f(r6) == false) goto L43;
    L36:
        if (r9.isVisible() != true) goto L38;
        r10 = true;
        goto L39
    L31:
        if (r6.getRegenVisible() == true) goto L33;
    L49:
        String r11 = null;
        if ((!r3.isEmpty()) == false) goto L52;
        ArrayList r15 = r3;
    L54:
        if (r15 == null) goto L65;
        Iterator r16 = r15.iterator();
        if (r16.hasNext() == false) goto L64;
        long r17 = ((Message) r16.next()).getCreateTime();
    L59:
        if (r16.hasNext() == false) goto L66;
        long r18 = ((Message) r16.next()).getCreateTime();
        if (r17 >= r18) goto L59;
        r17 = r18;
    L66:
        Iterator r19 = r14.iterator();
    L68:
        if (r19.hasNext() == false) goto L102;
        Object r20 = r19.next();
        Message r21 = (Message) r20;
        if (com.larus.bmhome.chat.bean.d.i0(r21) == false) goto L75;
        if (com.larus.bmhome.chat.bean.d.w(r21) == true) goto L75;
    L94:
        boolean r110 = false;
    L95:
        if (r110 == true) goto L97;
    L99:
        boolean r22 = false;
    L100:
        if (r22 == false) goto L68;
    L103:
        Message r23 = (Message) r20;
        FLogger r111 = FLogger.a;
        StringBuilder r24 = new StringBuilder("check message interval, latestMsgTime=");
        r24.append(r17);
        r24.append(" validMsgSize=");
        r24.append(r3.size());
        r24.append(" lastVisibleMsg=");
        if (r23 == null) goto L106;
        r11 = gx9.p.b(r23);
    L106:
        r24.append(r11);
        r111.i("WcbLog", r24.toString());
        if (r23 != null) goto L109;
    L111:
        if (r1 == false) goto L114;
        return new s.b("checkMsgInterval last msg firstMet");
    L114:
        if (r17 <= 0) goto L119;
        long r25 = (AppHost.a.getAppClock().currentTimeMillis() / 1000) - r17;
        r111.w("WcbLog", "check message interval, msgInterval=" + r25 + ", controlInterval=" + r13);
        if (r25 <= r13) goto L142;
        return s.a.a;
    L142:
        return new s.b("checkMsgInterval within controlInterval");
    L119:
        r111.e("WcbLog", "checkMsgInterval invalid latestMsgTime, validMessages=" + r3.size());
        if (r3.isEmpty() == false) goto L123;
        return s.a.a;
    L123:
        return new s.b("checkMsgInterval invalid latestMsgTime");
    L109:
        if (com.larus.bmhome.chat.bean.d.k0(r23) != true) goto L111;
        r1 = true;
        goto L111
    L97:
        if (com.larus.bmhome.social.userchat.model.b0.f(r21) == true) goto L99;
        r22 = true;
    L75:
        if (com.larus.bmhome.chat.bean.d.T(r21) == true) goto L94;
        if (com.larus.bmhome.chat.bean.d.p0(r21) == true) goto L94;
        if (com.larus.bmhome.chat.bean.d.C0(r21) == true) goto L82;
    L84:
        MessageStatus r112 = r21.getMessageStatus();
        if (r112 != null) goto L87;
    L89:
        boolean r113 = false;
    L90:
        if (r113 == false) goto L92;
    L93:
        r110 = true;
        goto L95
    L92:
        if (com.larus.bmhome.social.userchat.model.b0.f(r21) == false) goto L94;
    L87:
        if (r112.isVisible() != true) goto L89;
        r113 = true;
        goto L90
    L82:
        if (r21.getRegenVisible() == true) goto L84;
    L102:
        r20 = null;
        goto L103
    L64:
        throw new NoSuchElementException();
    L65:
        r17 = 0;
        goto L66
    L52:
        r15 = null;
        goto L54
    L139:
        return new s.b("checkMsgInterval messageList empty");
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.larus.suggest.impl.wcb.policy.t
    public final Object a(com.larus.suggest.impl.wcb.request.f r22, hx9.l r23, Continuation<? super s> r24) {
        hx9.l r0 = r23;
        if ((r24 instanceof MainConversationDisplayFrequencyPolicy$evaluate$1) == false) goto L7;
        MainConversationDisplayFrequencyPolicy$evaluate$1 r2 = (MainConversationDisplayFrequencyPolicy$evaluate$1) r24;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        MessageListRequest r6 = (MessageListRequest) r2.L$1;
        hx9.l r7 = (hx9.l) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L28:
        return r1;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r0 = (hx9.l) r2.L$1;
        com.larus.suggest.impl.wcb.request.f r8 = (com.larus.suggest.impl.wcb.request.f) r2.L$0;
        ResultKt.throwOnFailure(r1);
        com.larus.suggest.impl.wcb.request.f r9 = r8;
    L19:
        long r10 = r9.f.a.h().g(r9);
        if (r10 > 0) goto L23;
        FLogger.a.i("WcbLog", "[DisplayFrequencyPolicy] invalid control interval, direct consume nex pulse");
        return s.a.a;
    L23:
        MessageListRequest r11 = new MessageListRequest(r9.b, 0, 0, 10, 0, null, false, 118, null);
        r2.L$0 = r0;
        r2.L$1 = r11;
        r2.J$0 = r10;
        r2.label = 2;
        kotlinx.coroutines.j r12 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r2), 1);
        r12.C();
        com.larus.im.d.e().getMessageListFromLocal(r11, new a(r12, r0, r10));
        r1 = r12.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L26:
        if (r1 != r4) goto L28;
        return r4;
    L16:
        ResultKt.throwOnFailure(r1);
        r9 = r22;
        r2.L$0 = r9;
        r2.L$1 = r0;
        r2.label = 1;
        if (r0.i(r2) != r4) goto L19;
        return r4;
    L7:
        r2 = new MainConversationDisplayFrequencyPolicy$evaluate$1(this, r24);
        goto L8
    }
}
