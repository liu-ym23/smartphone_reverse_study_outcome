package com.larus.bmhome.social.userchat.model;

import com.larus.home.impl.sdk.h1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.CaseMessageReceiverModel$init$3", f = "CaseMessageReceiverModel.kt", i = {}, l = {51, 61}, m = "invokeSuspend", n = {}, s = {})
final class CaseMessageReceiverModel$init$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ b this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.social.userchat.model.CaseMessageReceiverModel$init$3$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.userchat.model.CaseMessageReceiverModel$init$3$2", f = "CaseMessageReceiverModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ b this$0;

        public AnonymousClass2(b r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r6);
            b r7 = this.this$0;
            List<Message> r0 = r7.b;
            if (r0 == null) goto L10;
            ChatMessageReceiverModel.c r8 = r7.c;
            if (r8 == null) goto L10;
            ChatMessageReceiverModel.c.a.a(r8, new com.larus.bmhome.social.page.datasource.event.c(r0, 0, CollectionsKt.listOf(new com.larus.bmhome.social.page.datasource.event.b.d(true))));
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CaseMessageReceiverModel$init$3(b r1, Continuation<? super CaseMessageReceiverModel$init$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CaseMessageReceiverModel$init$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r53) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r5 = true;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r53);
    L44:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r53);
        Object r3 = r53;
    L15:
        List r4 = (List) r3;
    L17:
        List r6 = r4;
        if (r6 != null) goto L20;
    L23:
        if (r5 == true) goto L25;
        b r7 = this.this$0;
        Iterator r8 = r4.iterator();
    L28:
        if (r8.hasNext() == false) goto L40;
        Message r9 = (Message) r8.next();
        List<Message> r10 = r7.b;
        if (r10 == null) goto L28;
        if (com.larus.bmhome.chat.bean.d.G0(r9) == false) goto L34;
        int r12 = 11;
    L35:
        Map r15 = r9.getBusinessExt();
        if (r15 != null) goto L38;
        r15 = new LinkedHashMap();
    L38:
        r15.put("message_case_mode", "1");
        Unit r11 = Unit.INSTANCE;
        ArrayList r13 = (ArrayList) r10;
        Boxing.boxBoolean(r13.add(Message.copy$default(r9, null, null, null, 0, r12, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, r15, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194321, 31, null)));
        goto L28
    L34:
        r12 = 21;
        goto L35
    L40:
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass2 r16 = new AnonymousClass2(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r14, r16, this) != r1) goto L44;
        return r1;
    L25:
        return Unit.INSTANCE;
    L20:
        if (r6.isEmpty() == true) goto L23;
        r5 = false;
        goto L23
    L10:
        ResultKt.throwOnFailure(r53);
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L16;
        r17.h0();
        h1 r18 = h1.a;
        String r19 = this.this$0.a.getCaseId();
        boolean r20 = this.this$0.a.isFromRecommend();
        this.label = 1;
        r3 = r18.g(r19, r20, this);
        if (r3 != r1) goto L15;
        return r1;
    L16:
        r4 = null;
        goto L17
    }
}
