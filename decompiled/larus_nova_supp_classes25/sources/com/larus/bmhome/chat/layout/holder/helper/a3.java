package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.im.bean.bot.BotModel;
import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a3 {
    public final HashMap<String, BotModel> a;

    public static final class a {
    }

    static {
    }

    public a3() {
        this.a = new HashMap();
    }

    public final Object a(String r12, com.larus.bmhome.chat.list.cell.prompt.t0 r13, Continuation r14) {
        if ((r14 instanceof SuggestPromptBotsCreator$requireBot$1) == false) goto L7;
        SuggestPromptBotsCreator$requireBot$1 r0 = (SuggestPromptBotsCreator$requireBot$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        SuggestPromptBotsCreator$requireBot$1 r6 = r0;
        Object r15 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Function3 r16 = (Function3) r6.L$1;
        r12 = (String) r6.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L14
        Function3 r17 = r16;
    L26:
        BotModel r18 = (BotModel) r15;     // Catch: Exception -> L14
        if (r18 == null) goto L29;
        this.a.put(r12, r18);     // Catch: Exception -> L14
        r17.invoke(r18, Boxing.boxBoolean(true), "success");     // Catch: Exception -> L14
    L33:
        return Unit.INSTANCE;
    L29:
        r17.invoke(null, Boxing.boxBoolean(false), "bot model is null");     // Catch: Exception -> L14
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        if (this.a.get(r12) == null) goto L23;
        r13.invoke(this.a.get(r12), Boxing.boxBoolean(true), "cache success");     // Catch: Exception -> L14
        return Unit.INSTANCE;
    L23:
        IBotRepoService r4 = zh8.a.e;     // Catch: Exception -> L14
        r6.L$0 = r12;     // Catch: Exception -> L14
        r6.L$1 = r13;     // Catch: Exception -> L14
        r6.label = 1;     // Catch: Exception -> L14
        r15 = IBotRepoService.b.a(r4, r12, true, "default", false, r6, 16);     // Catch: Exception -> L14
        r17 = r13;
        if (r15 != r2) goto L26;
        return r2;
    L14:
        e = move-exception;
        r13.invoke(null, Boxing.boxBoolean(false), "error >>> " + e);
    L7:
        r0 = new SuggestPromptBotsCreator$requireBot$1(this, r14);
        goto L8
    }
}
