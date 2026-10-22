package com.larus.bmhome.view.actionbar.custom;

import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.view.actionbar.custom.cache.ActionBarCacheStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.ActionBarServiceImpl$updateConfigFromRemote$1", f = "ActionBarServiceImpl.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
public final class ActionBarServiceImpl$updateConfigFromRemote$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Function1<List<com.larus.bmhome.actionbar.model.z0>, Unit> $callback;
    final /* synthetic */ String $langCode;
    int label;
    final /* synthetic */ ActionBarServiceImpl this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.ActionBarServiceImpl$updateConfigFromRemote$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.ActionBarServiceImpl$updateConfigFromRemote$1$1", f = "ActionBarServiceImpl.kt", i = {1}, l = {229, 242, 243}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ Function1<List<com.larus.bmhome.actionbar.model.z0>, Unit> $callback;
        final /* synthetic */ String $langCode;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ActionBarServiceImpl this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.ActionBarServiceImpl$updateConfigFromRemote$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.ActionBarServiceImpl$updateConfigFromRemote$1$1$1", f = "ActionBarServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<List<com.larus.bmhome.actionbar.model.z0>, Unit> $callback;
            final /* synthetic */ List<com.larus.bmhome.actionbar.model.z0> $result;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public C00461(Function1<? super List<com.larus.bmhome.actionbar.model.z0>, Unit> r1, List<com.larus.bmhome.actionbar.model.z0> r2, Continuation<? super C00461> r3) {
                this.$callback = r1;
                this.$result = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00461(this.$callback, this.$result, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.$callback.invoke(this.$result);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(ActionBarServiceImpl r1, String r2, String r3, Function1<? super List<com.larus.bmhome.actionbar.model.z0>, Unit> r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$langCode = r2;
            this.$botId = r3;
            this.$callback = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.this$0, this.$langCode, this.$botId, this.$callback, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((wc9.e) r1, (Continuation) r2);
        }

        public final Object invoke(wc9.e r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r11);
        L75:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            final List r2 = (List) this.L$0;
            ResultKt.throwOnFailure(r11);
        L71:
            MainCoroutineDispatcher r12 = Dispatchers.getMain();
            C00461 r3 = new C00461(this.$callback, r2, null);
            this.L$0 = null;
            this.label = 3;
            if (BuildersKt.withContext(r12, r3, this) != r0) goto L75;
            return r0;
        L11:
            ResultKt.throwOnFailure(r11);
        L36:
            com.larus.network.http.y r13 = (com.larus.network.http.a) r11;
            if ((r13 instanceof com.larus.network.http.y) == false) goto L75;
            String r4 = wa8.n0.a;
            com.larus.network.http.y r14 = r13;
            com.larus.bmhome.actionbar.model.x0 r5 = (com.larus.bmhome.actionbar.model.x0) ((com.larus.network.http.a) r14).b;
            if (r5 == null) goto L41;
            String r6 = r5.e;
        L42:
            wa8.n0.a = r6;
            com.larus.im.internal.delegate.c0.b.d("ActionBarRedDot", "set redDotText = " + r6);
            int r7 = y2.a;
            com.larus.bmhome.actionbar.model.x0 r15 = (com.larus.bmhome.actionbar.model.x0) ((com.larus.network.http.a) r14).b;
            if (r15 == null) goto L45;
            ArrayList r16 = r15.a;
        L46:
            y2.a(r16);
            if (r16 == null) goto L61;
            ActionBarServiceImpl r8 = this.this$0;
            ArrayList r9 = new ArrayList();
            Iterator r17 = r16.iterator();
        L50:
            if (r17.hasNext() == false) goto L54;
            Object r10 = r17.next();
            Integer r18 = ((com.larus.bmhome.actionbar.model.z0) r10).g;
            int r19 = ActionBarServiceImpl.e;
            r8.getClass();
            if (ActionBarServiceImpl.p(r18) == false) goto L50;
            r9.add(r10);
            goto L50
        L54:
            ArrayList r110 = new ArrayList();
            Iterator r20 = r9.iterator();
        L56:
            if (r20.hasNext() == false) goto L60;
            Object r21 = r20.next();
            if (com.larus.utils.o0.d(((com.larus.bmhome.actionbar.model.z0) r21).e) == false) goto L56;
            r110.add(r21);
            goto L56
        L60:
            r2 = r110;
        L62:
            final ActionBarServiceImpl r111 = this.this$0;
            final String r22 = this.$botId;
            this.L$0 = r2;
            this.label = 2;
            int r23 = ActionBarServiceImpl.e;
            r111.getClass();
            if (com.larus.platform.exp.a.c == false) goto L68;
            Object r112 = ActionBarCacheStore.a.j(new m(r111, r2, r22), this);
            if (r112 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L69;
            r112 = Unit.INSTANCE;
        L69:
            if (r112 != r0) goto L71;
            return r0;
        L68:
            r111.q(r2, r22);
            r112 = Unit.INSTANCE;
            goto L69
        L61:
            r2 = null;
            goto L62
        L45:
            r16 = null;
            goto L46
        L41:
            r6 = null;
            goto L42
        L12:
            ResultKt.throwOnFailure(r11);
            wc9.e r113 = (wc9.e) this.L$0;
            if (r113 == null) goto L15;
            String r114 = r113.a;
        L16:
            if (r114 != null) goto L18;
        L21:
            boolean r24 = true;
        L22:
            if (r24 == true) goto L24;
            BotRepo r25 = this.this$0.b;
            String r26 = this.$langCode;
            if (r26 != null) goto L28;
            r26 = "";
        L28:
            String r27 = this.$botId;
            if (r27 != null) goto L31;
            r27 = "";
        L31:
            if (r114 != null) goto L33;
            r114 = "";
        L33:
            IBotRepoService.a r28 = new IBotRepoService.a(r26, r27, r114);
            this.label = 1;
            r11 = r25.b(r28, this);
            if (r11 != r0) goto L36;
            return r0;
        L24:
            return Unit.INSTANCE;
        L18:
            if (r114.length() == 0) goto L21;
            r24 = false;
            goto L22
        L15:
            r114 = null;
            goto L16
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarServiceImpl$updateConfigFromRemote$1(ActionBarServiceImpl r1, String r2, String r3, Function1<? super List<com.larus.bmhome.actionbar.model.z0>, Unit> r4, Continuation<? super ActionBarServiceImpl$updateConfigFromRemote$1> r5) {
        this.this$0 = r1;
        this.$langCode = r2;
        this.$botId = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ActionBarServiceImpl$updateConfigFromRemote$1(this.this$0, this.$langCode, this.$botId, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ActionBarServiceImpl r11 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(r11, this.$langCode, this.$botId, this.$callback, null);
        this.label = 1;
        if (ActionBarServiceImpl.o(r11, r2, this) != r0) goto L12;
        return r0;
    }
}
