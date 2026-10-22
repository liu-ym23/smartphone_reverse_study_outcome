package com.larus.search.impl.common;

import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ConversationRepoManager {
    public static final ConversationRepoManager a = null;
    public static final IConversationRepoService b = null;

    public ConversationRepoManager() {
    }

    static {
        a = new ConversationRepoManager();
        b = RepoDispatcherDelegate.b.f();
    }

    public static Object a(RecommendBot r12, Continuation r13) {
        IConversationRepoService r0 = b;
        String r14 = r12.o();
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        Object r15 = IConversationRepoService.a.a(r0, r14, 2, null, null, false, null, null, null, null, r13, 508);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r15;
    L9:
        return Unit.INSTANCE;
    }

    public static Object c(String r3, ContinuationImpl r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ConversationRepoManager$findChatConversationByBot$2(r3, null), r4);
    }

    public static Object d(String r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getMain(), new ConversationRepoManager$findConversationByBot$2(r3, null), r4);
    }

    public static Object f(RecommendBot r1, Continuation r2) {
        IConversationRepoService r0 = b;
        String r3 = r1.E();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        Object r4 = r0.s(r3, r2);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r4;
    L9:
        return Unit.INSTANCE;
    }

    public final Object b(RecommendBot r6, Continuation<? super String> r7) {
        if ((r7 instanceof ConversationRepoManager$createLocalConversation$1) == false) goto L7;
        ConversationRepoManager$createLocalConversation$1 r0 = (ConversationRepoManager$createLocalConversation$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L23:
        String r9 = (String) r8;
        if (r9 != null) goto L27;
        return "";
    L27:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (r6.j0() == true) goto L17;
    L19:
        Map r10 = MapsKt.mapOf(new Pair("is_from_local_discovery", "1"));
    L20:
        IConversationRepoService r4 = b;
        r0.label = 1;
        r8 = r4.u(r6, r10, r0);
        if (r8 != r2) goto L23;
        return r2;
    L17:
        if (r6.o0() == true) goto L19;
        r10 = MapsKt.emptyMap();
    L7:
        r0 = new ConversationRepoManager$createLocalConversation$1(this, r7);
        goto L8
    }

    public static Object e(String r2, String r3, Continuation r4) {
        Object r5 = b.l(r2, ConversationDeleteMode.DeleteMode_RealDelete, r3, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static Object g(String r3, RecommendBot r4, ContinuationImpl r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getIO(), new ConversationRepoManager$updateLocalConversationFirstMet$2(r3, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }
}
