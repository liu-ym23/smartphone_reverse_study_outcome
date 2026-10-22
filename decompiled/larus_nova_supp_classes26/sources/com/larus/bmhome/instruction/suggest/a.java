package com.larus.bmhome.instruction.suggest;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.HashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Fragment a;
    public final String b;
    public final String c;

    public static final void b(a r2, String r3) {
        if (r3 == null) goto L8;
        Fragment r4 = r2.a;
        if (r4 == null) goto L6;
        Context r5 = r4.getContext();
    L7:
        SmartRouter.buildRoute(r5, "sslocal://flow/chat?bot_id=" + r3 + "&enter_method=click_spring_suggest").d();
        return;
    L6:
        r5 = null;
        goto L7
    L8:
        r2.getClass();
    }

    public a(Fragment r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.String] */
    public static final Object a(a r10, String r11, BotModel r12, Continuation r13) {
        r10.getClass();
        if ((r13 instanceof JumpUgcBotAction$checkAndCreateConversation$1) == false) goto L7;
        JumpUgcBotAction$checkAndCreateConversation$1 r0 = (JumpUgcBotAction$checkAndCreateConversation$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = false;
        if (r2 == 0) goto L21;
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L19;
        if (r2 == 3) goto L18;
        if (r2 != 4) goto L17;
        String r16 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L15:
        r15 = r16;
        FLogger.a.i("JumpUgcBotAction", "conversationId:" + r15);
    L65:
        return r15;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r16 = (String) r0.L$1;
        r12 = (BotModel) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L44:
        wc9.e r17 = (wc9.e) r14;
    L45:
        if (r17 == null) goto L52;
        Integer r4 = r17.f;
        if (r4 == null) goto L52;
        if (r4.intValue() != 1) goto L52;
        r3 = true;
    L52:
        if (r3 == false) goto L15;
        Map r5 = r17.x;
        if (r5 == null) goto L57;
        Map r6 = MapsKt.toMutableMap(r5);
        if (r6 == null) goto L57;
    L58:
        r6.put("is_from_local_discovery", "1");
        RepoDispatcherDelegate.b.f().c(r17, r6);
        FLogger.a.i("JumpUgcBotAction", "conversation is local");
        r0.L$0 = r16;
        r0.L$1 = null;
        r0.label = 4;
        Object r18 = BuildersKt.withContext(Dispatchers.getIO(), new JumpUgcBotAction$updateLocalConversationFirstMet$2(r16, r12, null), r0);
        if (r18 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
        r18 = Unit.INSTANCE;
    L62:
        if (r18 != r15) goto L15;
    L57:
        r6 = new HashMap();
        goto L58
    L19:
        BotModel r19 = (BotModel) r0.L$1;
        String r110 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
        r12 = r19;
        r11 = r110;
    L37:
        String r111 = (String) r14;
        if (r111 != null) goto L40;
        r111 = "";
    L40:
        FLogger.a.i("JumpUgcBotAction", "createLocalConversation");
        r0.L$0 = r12;
        r0.L$1 = r111;
        r0.label = 3;
        Object r112 = RepoDispatcherDelegate.b.f().a(r11, r0);
        if (r112 == r15) goto L65;
        r16 = r111;
        r14 = r112;
        goto L44
    L20:
        r12 = (BotModel) r0.L$1;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L24:
        r17 = (wc9.e) r14;
        if (r17 == null) goto L31;
        String r7 = r17.a;
        if (r7 == null) goto L31;
        if (o0.d(r7) != true) goto L31;
        boolean r8 = true;
    L32:
        if (r8 == false) goto L34;
        r16 = r17.a;
        FLogger.a.i("JumpUgcBotAction", "already has conversationId:" + r16);
        goto L45
    L34:
        IConversationRepoService r113 = RepoDispatcherDelegate.b.f();
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.label = 2;
        r14 = IConversationRepoService.a.b(r113, r12, null, r0, 4);
        if (r14 != r15) goto L37;
    L31:
        r8 = false;
        goto L32
    L21:
        ResultKt.throwOnFailure(r14);
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.label = 1;
        r14 = RepoDispatcherDelegate.b.f().a(r11, r0);
        if (r14 != r15) goto L24;
    L7:
        r0 = new JumpUgcBotAction$checkAndCreateConversation$1(r10, r13);
        goto L8
    }
}
