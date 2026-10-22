package com.larus.bmhome.utils;

import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/utils/SimpleConvInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.utils.LaunchLandingConfigHelper$findOrCreateConversationByBot$2", f = "LaunchLandingConfigHelper.kt", i = {}, l = {49, 60}, m = "invokeSuspend", n = {}, s = {})
final class LaunchLandingConfigHelper$findOrCreateConversationByBot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super q3>, Object> {
    final /* synthetic */ String $botId;
    int label;

    public LaunchLandingConfigHelper$findOrCreateConversationByBot$2(String r1, Continuation<? super LaunchLandingConfigHelper$findOrCreateConversationByBot$2> r2) {
        this.$botId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LaunchLandingConfigHelper$findOrCreateConversationByBot$2(this.$botId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super q3> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
        Object r1 = r14;
    L26:
        wc9.e r2 = (wc9.e) r1;
        if (r2 == null) goto L34;
        Map r3 = r2.x;
        if (r3 == null) goto L32;
        Map r4 = MapsKt.toMutableMap(r3);
        if (r4 == null) goto L32;
    L33:
        r4.put("is_from_local_discovery", "1");
        RepoDispatcherDelegate.b.f().c(r2, r4);
    L32:
        r4 = new HashMap();
    L34:
        if (r2 == null) goto L37;
        String r5 = r2.a;
        if (r5 == null) goto L37;
    L39:
        return new q3(r5);
    L37:
        r5 = "";
        goto L39
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        Object r6 = r14;
    L13:
        wc9.e r7 = (wc9.e) r6;
        if (r7 != null) goto L16;
    L18:
        String r8 = null;
    L19:
        if (r8 != null) goto L21;
    L23:
        RepoDispatcher.a.getClass();
        ConversationRepo r9 = RepoDispatcher.f;
        String r10 = this.$botId;
        this.label = 2;
        r1 = IConversationRepoService.a.a(r9, r10, 2, null, null, false, null, null, null, null, this, 508);
        if (r1 != r12) goto L26;
        return r12;
    L21:
        if (StringsKt.contains$default(r8, "local", false, 2, null) == true) goto L23;
        return new q3(r8);
    L16:
        if (r7.h() == true) goto L18;
        r8 = r7.a;
        goto L19
    L10:
        ResultKt.throwOnFailure(r14);
        String r11 = this.$botId;
        Intrinsics.checkNotNullParameter(r11, "convId");
        StringsKt.contains$default(r11, "local", false, 2, null);
        RepoDispatcher.a.getClass();
        ConversationRepo r13 = RepoDispatcher.f;
        String r15 = this.$botId;
        this.label = 1;
        r6 = r13.a(r15, this);
        if (r6 != r12) goto L13;
        return r12;
    }
}
