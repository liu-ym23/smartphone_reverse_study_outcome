package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.bytedance.lark.pb.feed.v1.PushNavigateToFeed;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.BackToFeedPlugin$listenNavigateToFeedPush$1", f = "BackToFeedPlugin.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
final class BackToFeedPlugin$listenNavigateToFeedPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $chatId;
    final /* synthetic */ Long $threadId;
    Object L$0;
    int label;
    final /* synthetic */ a this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.page.flow.plugin.BackToFeedPlugin$listenNavigateToFeedPush$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.BackToFeedPlugin$listenNavigateToFeedPush$1$1", f = "BackToFeedPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ a this$0;

        public AnonymousClass1(a r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3 = this.this$0.g;
            if (r3 == null) goto L8;
            r3.h();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BackToFeedPlugin$listenNavigateToFeedPush$1(a r1, Long r2, long r3, Continuation<? super BackToFeedPlugin$listenNavigateToFeedPush$1> r5) {
        this.this$0 = r1;
        this.$threadId = r2;
        this.$chatId = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BackToFeedPlugin$listenNavigateToFeedPush$1(this.this$0, this.$threadId, this.$chatId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0040 -> B:18:0x0045). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$0;
        ResultKt.throwOnFailure(r10);
        com.larksuite.rucket.job.extension.a r3 = r2;
        Object r4 = r0;
        BackToFeedPlugin$listenNavigateToFeedPush$1 r5 = this;
    L19:
        if (((Boolean) r10).booleanValue() == false) goto L45;
        com.larksuite.rucket.job.base.b r11 = r3.a();
        r11.getClass();
        if ((r11 instanceof com.larksuite.rucket.job.base.b.b) == true) goto L43;
        PushNavigateToFeed r12 = (PushNavigateToFeed) r11.b();
        Long r6 = r5.$threadId;
        if (r6 != null) goto L25;
        Long r13 = r12.chat_id;
        long r7 = r5.$chatId;
        if (r13 != null) goto L38;
    L40:
        boolean r14 = false;
    L41:
        if (r14 == false) goto L43;
        BuildersKt.launch$default(r5.this$0.j, Dispatchers.getMain(), null, new AnonymousClass1(r5.this$0, null), 2, null);
        goto L45
    L38:
        if (r13.longValue() != r7) goto L40;
    L39:
        r14 = true;
        goto L41
    L25:
        if (r12.thread_ids.contains(r6) == true) goto L39;
        Long r15 = r12.chat_id;
        long r8 = r5.$chatId;
        if (r15 == null) goto L40;
        if (r15.longValue() != r8) goto L40;
        if (r5.this$0.i == true) goto L40;
    L43:
        BackToFeedPlugin$listenNavigateToFeedPush$1 r16 = r5;
        r0 = r4;
        com.larksuite.rucket.job.extension.a r9 = r3;
    L14:
        r16.L$0 = r9;
        r16.label = 1;
        Object r17 = r9.hasNext(r16);
        if (r17 != r0) goto L17;
        return r0;
    L17:
        Object r18 = r0;
        r5 = r16;
        r10 = r17;
        r3 = r9;
        r4 = r18;
    L45:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        a.InterfaceC0034a r19 = this.this$0.h;
        if (r19 == null) goto L47;
        RucketJob<PushNavigateToFeed> r110 = r19.navigateToFeedPush();
        if (r110 == null) goto L47;
        r9 = r110.iterator();
        r16 = this;
    L47:
        return Unit.INSTANCE;
    }
}
