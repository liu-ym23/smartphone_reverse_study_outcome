package com.larus.community.impl.publish;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.PublisherCreation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.publish.CreationPublisherLauncher$preCreateIfAbsent$1$1", f = "CreationPublisherLauncher.kt", i = {0, 0}, l = {62, 63}, m = "invokeSuspend", n = {"messageId", "currentCreationTypeFromIM"}, s = {"L$0", "L$1"})
public final class CreationPublisherLauncher$preCreateIfAbsent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PublisherCreation $publisherCreation;
    Object L$0;
    Object L$1;
    int label;

    public CreationPublisherLauncher$preCreateIfAbsent$1$1(PublisherCreation r1, Continuation<? super CreationPublisherLauncher$preCreateIfAbsent$1$1> r2) {
        this.$publisherCreation = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationPublisherLauncher$preCreateIfAbsent$1$1(this.$publisherCreation, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r11 = null;
        boolean r12 = false;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r18);
        Object r1 = r18;
    L30:
        zp9.a r2 = (zp9.a) r1;
        if (r2 != null) goto L33;
    L35:
        if (r12 == false) goto L37;
        m29.a.c("CreationPublisherLauncher", "preCreateIfAbsent success");
    L42:
        return Unit.INSTANCE;
    L37:
        boolean r3 = m29.a.a;
        StringBuilder r4 = new StringBuilder("preCreateIfAbsent fail, error:");
        if (r2 == null) goto L40;
        r11 = r2.c;
    L40:
        r4.append(r11);
        m29.a.c("CreationPublisherLauncher", r4.toString());
        goto L42
    L33:
        if (r2.a != true) goto L35;
        r12 = true;
        goto L35
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Integer r5 = (Integer) this.L$1;
        String r6 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r7 = r18;
    L18:
        Message r8 = (Message) r7;
        com.larus.platform.service.e0 r9 = com.larus.platform.service.e0.a;
        String r13 = String.valueOf(this.$publisherCreation.getIndex());
        String r14 = this.$publisherCreation.getTaskId();
        if (r8 != null) goto L21;
    L23:
        boolean r15 = false;
    L24:
        if (r15 == false) goto L26;
        int r16 = 4;
    L27:
        String r17 = this.$publisherCreation.getMaterialId();
        int r20 = r5.intValue();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        r1 = r9.l(r6, r20, r13, 2, r14, r16, r17, this);
        if (r1 != r10) goto L30;
        return r10;
    L26:
        r16 = 1;
        goto L27
    L21:
        if (com.larus.bmhome.chat.bean.d.k(r8) != true) goto L23;
        r15 = true;
        goto L24
    L10:
        ResultKt.throwOnFailure(r18);
        m29.a.c("CreationPublisherLauncher", "start preCreateIfAbsent");
        String r21 = this.$publisherCreation.getMessageId();
        Integer r22 = this.$publisherCreation.getFromIMCreationType();
        m29.a.c("CreationPublisherLauncher", "messageId:" + r21 + ",creationType:" + r22);
        if (r21 == null) goto L44;
        if (r22 == null) goto L44;
        IChatRepoService r23 = RepoDispatcherDelegate.b.e();
        this.L$0 = r21;
        this.L$1 = r22;
        this.label = 1;
        r7 = r23.E1(r21, this);
        if (r7 != r10) goto L17;
        return r10;
    L17:
        r6 = r21;
        r5 = r22;
    L44:
        return Unit.INSTANCE;
    }
}
