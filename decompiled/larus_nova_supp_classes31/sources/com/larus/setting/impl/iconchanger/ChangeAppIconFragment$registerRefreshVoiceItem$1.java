package com.larus.setting.impl.iconchanger;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconFragment$registerRefreshVoiceItem$1", f = "ChangeAppIconFragment.kt", i = {0, 0}, l = {823}, m = "invokeSuspend", n = {"$this$launch", "cvsId"}, s = {"L$0", "L$1"})
final class ChangeAppIconFragment$registerRefreshVoiceItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ChangeAppIconFragment this$0;

    /* JADX INFO: renamed from: com.larus.setting.impl.iconchanger.ChangeAppIconFragment$registerRefreshVoiceItem$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconFragment$registerRefreshVoiceItem$1$2", f = "ChangeAppIconFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChangeAppIconFragment this$0;

        /* JADX INFO: renamed from: com.larus.setting.impl.iconchanger.ChangeAppIconFragment$registerRefreshVoiceItem$1$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconFragment$registerRefreshVoiceItem$1$2$1", f = "ChangeAppIconFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ChangeAppIconFragment this$0;

            public AnonymousClass1(ChangeAppIconFragment r1, Continuation<? super AnonymousClass1> r2) {
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
                if (this.label != 0) goto L14;
                ResultKt.throwOnFailure(r2);
                ChangeAppIconFragment r3 = this.this$0;
                if (r3.w == true) goto L12;
                BotModel r0 = r3.r;
                if (r0 == null) goto L9;
                SpeakerVoice r1 = r0.getVoiceType();
            L10:
                r3.ba0(r1);
                goto L12
            L9:
                r1 = null;
            L12:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(ChangeAppIconFragment r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r7);
            CoroutineScope r0 = (CoroutineScope) this.L$0;
            BotServiceImpl r8 = com.larus.im.d.a();
            BotModel r1 = this.this$0.r;
            if (r1 == null) goto L8;
            String r2 = r1.getBotId();
            if (r2 == null) goto L8;
        L9:
            r8.registerBotChangeListener(r2, this.this$0.A);
            ChangeAppIconFragment r9 = this.this$0;
            r9.v = BuildersKt.launch$default(r0, null, null, new AnonymousClass1(r9, null), 3, null);
            return Unit.INSTANCE;
        L8:
            r2 = "";
            goto L9
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChangeAppIconFragment$registerRefreshVoiceItem$1(ChangeAppIconFragment r1, Continuation<? super ChangeAppIconFragment$registerRefreshVoiceItem$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChangeAppIconFragment$registerRefreshVoiceItem$1 r0 = new ChangeAppIconFragment$registerRefreshVoiceItem$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ChangeAppIconFragment r2 = (ChangeAppIconFragment) this.L$2;
        String r3 = (String) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r9);
    L21:
        BotModel r10 = (BotModel) r9;
        if (r10 != null) goto L25;
        FLogger.a.e("ChangeAppIconFragment", "Cannot find bot " + r3);
        return Unit.INSTANCE;
    L25:
        r2.r = r10;
        ChangeAppIconFragment r11 = this.this$0;
        BotModel r5 = r11.r;
        if (r5 == null) goto L28;
        String r6 = r5.getBotId();
    L29:
        if (r6 != null) goto L31;
        r6 = "";
    L31:
        r11.t = r6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(this.this$0, null), 2, null);
    L33:
        return Unit.INSTANCE;
    L28:
        r6 = null;
        goto L29
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        ChangeAppIconFragment r7 = this.this$0;
        String r8 = r7.n;
        if (r8.length() != 0) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L14;
        r3 = r7.m;
    L15:
        ChangeAppIconFragment r14 = this.this$0;
        if (r14.r != null) goto L33;
        this.L$0 = r12;
        this.L$1 = r3;
        this.L$2 = r14;
        this.label = 1;
        r9 = r14.W90(r3, false, "default", this);
        if (r9 != r0) goto L20;
        return r0;
    L20:
        r2 = r14;
        goto L21
    L14:
        r3 = r8;
        goto L15
    L11:
        r13 = false;
        goto L12
    }
}
