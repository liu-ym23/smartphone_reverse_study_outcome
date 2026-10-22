package com.larus.voicecall.impl.util;

import android.os.Bundle;
import com.larus.audio.realtimecall.IRealtimeCallStrategy;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.utils.f;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\u0012"}, d2 = {"Lcom/larus/voicecall/impl/util/RealtimeCallStrategy;", "Lcom/larus/audio/realtimecall/IRealtimeCallStrategy;", "<init>", "()V", "realtimeCallAutoHelloParam", "Landroid/os/Bundle;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "lastMsg", "Lcom/larus/im/bean/message/Message;", "realtimeCallAutoHelloParamByCvsId", "cvsId", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnreadCount", NameKeys.UnloadStrategy_No_Strategy, "item", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallStrategy implements IRealtimeCallStrategy {

    public static final class a {
    }

    static {
    }

    public RealtimeCallStrategy() {
    }

    public final Bundle a(e r3, Message r4) {
        if (z2.a.isAutoSayHelloInCallBot() == false) goto L22;
        if (r3 == null) goto L22;
        if (r4 == null) goto L22;
        Integer r0 = r3.l;
        if (r0 == null) goto L9;
        int r1 = r0.intValue();
    L10:
        Integer r5 = r3.m;
        if (r5 == null) goto L13;
        int r6 = r5.intValue();
    L15:
        if ((r1 - r6) <= 0) goto L22;
        Regex r7 = d.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (d.x(r4).getProactiveBotMessage() == true) goto L23;
        if (d.z0(r4) == false) goto L22;
    L23:
        return f.c(new Pair[]{TuplesKt.to("enter_method", "read_latest_message"), TuplesKt.to("trigger_hello", "true")});
    L13:
        r6 = 0;
        goto L15
    L9:
        r1 = 0;
    L22:
        return f.c(new Pair[0]);
    }

    public final Object b(String r11, Continuation<? super Bundle> r12) {
        if ((r12 instanceof RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1) == false) goto L7;
        RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1 r0 = (RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        e r14 = (e) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L35:
        return a(r14, (Message) r13);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        e r15 = (e) r13;
        IChatRepoService r3 = RepoDispatcherDelegate.b.e();
        r0.L$0 = r15;
        r0.label = 2;
        Object r16 = r3.D1(r11, r0);
        if (r16 != r7) goto L33;
        return r7;
    L33:
        r13 = r16;
        r14 = r15;
        goto L35
    L16:
        ResultKt.throwOnFailure(r13);
        if (r11 != null) goto L19;
    L22:
        boolean r4 = true;
    L23:
        if (r4 == true) goto L37;
        if (StringsKt.contains$default(r11, "local", false, 2, null) == true) goto L37;
        IConversationRepoService r5 = RepoDispatcherDelegate.b.f();
        r0.L$0 = r11;
        r0.label = 1;
        r13 = IConversationRepoService.a.c(r5, r11, true, null, r0, 4);
        if (r13 != r7) goto L30;
        return r7;
    L37:
        return f.c(new Pair[0]);
    L19:
        if (r11.length() == 0) goto L22;
        r4 = false;
    L7:
        r0 = new RealtimeCallStrategy$realtimeCallAutoHelloParamByCvsId$1(this, r12);
        goto L8
    }
}
