package com.ss.android.lark.flow.chat.page.flow.plugin;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleDestroyedException;
import androidx.lifecycle.WithLifecycleStateKt;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.ChatReadable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.FlowChatReadablePlugin$onCreate$2$1", f = "FlowChatReadablePlugin.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class FlowChatReadablePlugin$onCreate$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c $chatApp;
    final /* synthetic */ BaseStrangerRelationViewModel $it;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c a;

        public a(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r1) {
            this.a = r1;
        }

        public final Object emit(Object r12, Continuation r13) {
            int r14 = ((Number) r12).intValue();
            ChatReadable.Companion.getClass();
            boolean r0 = false;
            if (r14 != 1) goto L5;
            boolean r2 = true;
        L6:
            IMessageListComponent r3 = this.a.a(IMessageListComponent.class);
            if (r2 == false) goto L30;
            Lifecycle r5 = this.a.getFragment().getLifecycle();
            Lifecycle.State r6 = Lifecycle.State.RESUMED;
            if (r6.compareTo(Lifecycle.State.CREATED) < 0) goto L11;
            r0 = true;
        L11:
            if (r0 == false) goto L29;
            MainCoroutineDispatcher r8 = Dispatchers.getMain().getImmediate();
            boolean r7 = r8.isDispatchNeeded(r13.getContext());
            if (r7 == false) goto L15;
        L24:
            Object r15 = WithLifecycleStateKt.suspendWithStateAtLeastUnchecked(r5, r6, r7, r8, new e(r14, r3), r13);
            if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
            return r15;
        L35:
            return Unit.INSTANCE;
        L15:
            if (r5.getCurrentState() == Lifecycle.State.DESTROYED) goto L23;
            if (r5.getCurrentState().compareTo(r6) < 0) goto L24;
            Log.i("FlowChatReadablePlugin", "update message readable is true, chat readable is " + r14);
            if (r3 == null) goto L21;
            r3.z6(true);
        L21:
            Unit r16 = Unit.INSTANCE;
            goto L35
        L23:
            throw new LifecycleDestroyedException();
        L29:
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r6).toString());
        L30:
            Log.i("FlowChatReadablePlugin", "update message readable is false, chat readable is " + r14);
            if (r3 == null) goto L34;
            r3.z6(false);
        L34:
            return Unit.INSTANCE;
        L5:
            r2 = false;
            goto L6
        }
    }

    public FlowChatReadablePlugin$onCreate$2$1(BaseStrangerRelationViewModel r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, Continuation<? super FlowChatReadablePlugin$onCreate$2$1> r3) {
        this.$it = r1;
        this.$chatApp = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowChatReadablePlugin$onCreate$2$1(this.$it, this.$chatApp, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        z0 r6 = this.$it.getChatReadableFlow();
        a r2 = new a(this.$chatApp);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
