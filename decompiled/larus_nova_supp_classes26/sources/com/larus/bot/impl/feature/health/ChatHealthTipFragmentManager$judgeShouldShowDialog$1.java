package com.larus.bot.impl.feature.health;

import android.view.View;
import com.larus.bmhome.chat.tips.GuidePriority;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragmentManager$judgeShouldShowDialog$1", f = "ChatHealthTipFragmentManager.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
final class ChatHealthTipFragmentManager$judgeShouldShowDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $backListener;
    final /* synthetic */ Function0<Unit> $showDialogCallback;
    final /* synthetic */ WeakReference<View> $view;
    int label;

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.health.ChatHealthTipFragmentManager$judgeShouldShowDialog$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragmentManager$judgeShouldShowDialog$1$1", f = "ChatHealthTipFragmentManager.kt", i = {}, l = {GuidePriority.VLM_REALTIME_CALL_PRIORITY}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $backListener;
        final /* synthetic */ Function0<Unit> $showDialogCallback;
        final /* synthetic */ WeakReference<View> $view;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function0<Unit> r1, WeakReference<View> r2, Function1<? super String, Unit> r3, Continuation<? super AnonymousClass1> r4) {
            this.$showDialogCallback = r1;
            this.$view = r2;
            this.$backListener = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$showDialogCallback, this.$view, this.$backListener, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.bot.impl.feature.health.f] */
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            g r8 = g.a;
            final Function0<Unit> r2 = this.$showDialogCallback;
            final WeakReference<View> r3 = this.$view;
            final Function1<String, Unit> r4 = this.$backListener;
            ?? r5 = new f(r2, r3, r4);
            this.label = 1;
            if (g.a(r8, r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatHealthTipFragmentManager$judgeShouldShowDialog$1(Function0<Unit> r1, WeakReference<View> r2, Function1<? super String, Unit> r3, Continuation<? super ChatHealthTipFragmentManager$judgeShouldShowDialog$1> r4) {
        this.$showDialogCallback = r1;
        this.$view = r2;
        this.$backListener = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatHealthTipFragmentManager$judgeShouldShowDialog$1(this.$showDialogCallback, this.$view, this.$backListener, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$showDialogCallback, this.$view, this.$backListener, null);
        this.label = 1;
        if (BuildersKt.withContext(r9, r2, this) != r0) goto L12;
        return r0;
    }
}
