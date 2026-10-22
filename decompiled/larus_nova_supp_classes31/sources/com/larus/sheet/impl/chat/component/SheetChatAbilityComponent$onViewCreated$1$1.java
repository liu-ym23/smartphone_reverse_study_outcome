package com.larus.sheet.impl.chat.component;

import com.larus.bmhome.chat.headerinfo.IDeepThinkHeaderService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.a;
import com.larus.im.bean.message.block.Block;
import com.larus.office.base.service.c;
import com.larus.sheet.sdk.api.ISheetSdkProxyService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import ic8.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.sheet.impl.chat.component.SheetChatAbilityComponent$onViewCreated$1$1", f = "SheetChatAbilityComponent.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
public final class SheetChatAbilityComponent$onViewCreated$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $convId;
    int label;
    final /* synthetic */ SheetChatAbilityComponent this$0;

    public SheetChatAbilityComponent$onViewCreated$1$1(String r1, SheetChatAbilityComponent r2, Continuation<? super SheetChatAbilityComponent$onViewCreated$1$1> r3) {
        this.$convId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SheetChatAbilityComponent$onViewCreated$1$1(this.$convId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        Message r12 = (Message) r11;
        if (r12 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L66;
        if (a.o0(r12) == false) goto L66;
        List r4 = a.m(r12);
        List r5 = a.d(r12);
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L22:
        if (r7.hasNext() == false) goto L34;
        Object r8 = r7.next();
        Block r9 = (Block) r8;
        if (r4.isEmpty() == false) goto L26;
    L25:
        boolean r10 = true;
    L32:
        if (r10 == false) goto L22;
        r6.add(r8);
        goto L22
    L26:
        Iterator r13 = r4.iterator();
    L28:
        if (r13.hasNext() == false) goto L25;
        if (Intrinsics.areEqual(((Block) r13.next()).getBlockId(), r9.getBlockId()) == false) goto L28;
        r10 = false;
        goto L32
    L34:
        FLogger r14 = FLogger.a;
        r14.i("SheetChatAbilityComponent", "Block list size: " + r6.size() + ", think block size: " + ((ArrayList) r4).size() + ", replyId=" + r12.getReplyId());
        if ((!r4.isEmpty()) == false) goto L66;
        this.this$0.t = r12.getReplyId();
        Map r15 = r12.getExt();
        if (r15 == null) goto L40;
        String r16 = (String) r15.get("cot_ref_artifacts");
        if (r16 == null) goto L40;
    L41:
        r14.d("SheetChatAbilityComponent", "adapterCotRefArtifacts curCotRefArtifacts=" + r16 + ", artifactMetaId=" + this.this$0.r);
        if (r16.length() > 0) goto L45;
        r2 = false;
    L45:
        if (r2 == false) goto L66;
        if (o0.d(this.this$0.r) == false) goto L66;
        if (StringsKt.contains$default(r16, this.this$0.r, false, 2, null) == false) goto L66;
        ISheetSdkProxyService r17 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r17 == null) goto L55;
        c r18 = r17.b();
        if (r18 == null) goto L55;
        r18.onLoadingStart();
    L55:
        mw9.a r19 = d.a(this.this$0).getAbility(mw9.a.class);
        if (r19 == null) goto L66;
        IDeepThinkHeaderService r20 = (IDeepThinkHeaderService) ServiceManager.get().getService(IDeepThinkHeaderService.class);
        if (r20 == null) goto L64;
        t r110 = r20.a(r12);
        if (r110 == null) goto L64;
        r19.s(r110);
    L64:
        return Unit.INSTANCE;
    L40:
        r16 = "";
    L66:
        return Unit.INSTANCE;
    L14:
        if (com.larus.bmhome.chat.bean.d.G0(r12) == true) goto L16;
        r3 = true;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        IChatRepoService r111 = zh8.a.a;
        IChatRepoService r112 = zh8.a.a;
        String r21 = this.$convId;
        this.label = 1;
        r11 = r112.D1(r21, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
