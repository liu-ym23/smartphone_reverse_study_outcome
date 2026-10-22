package com.larus.chat.job.impl.component;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.chat.job.impl.page.ChatJobListAdapter;
import com.larus.chat.job.impl.page.ChatJobListViewModel;
import com.larus.chat.job.impl.page.y;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.job.impl.component.ChatJobListComponent$observe$1", f = "ChatJobListComponent.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
final class ChatJobListComponent$observe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $hostFragment;
    int label;
    final /* synthetic */ ChatJobListComponent this$0;

    /* JADX INFO: renamed from: com.larus.chat.job.impl.component.ChatJobListComponent$observe$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.chat.job.impl.component.ChatJobListComponent$observe$1$1", f = "ChatJobListComponent.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatJobListComponent this$0;

        /* JADX INFO: renamed from: com.larus.chat.job.impl.component.ChatJobListComponent$observe$1$1$a */
        public /* synthetic */ class a implements FlowCollector, FunctionAdapter {
            public final /* synthetic */ ChatJobListComponent a;

            public a(ChatJobListComponent r1) {
                this.a = r1;
            }

            public final boolean equals(Object r3) {
                if ((r3 instanceof FlowCollector) == true) goto L5;
                return false;
            L5:
                if ((r3 instanceof FunctionAdapter) == true) goto L7;
                return false;
            L7:
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
            }

            public final Function<?> getFunctionDelegate() {
                return new AdaptedFunctionReference(2, this.a, ChatJobListComponent.class, "render", "render(Lcom/larus/chat/job/impl/page/ChatJobListUiState;)V", 4);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            public final Object emit(Object r2, Continuation r3) {
                ChatJobListComponent r0 = this.a;
                Object r4 = AnonymousClass1.access$invokeSuspend$render(r0, (y) r2, r3);
                if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r4;
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(ChatJobListComponent r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ChatJobListViewModel r6 = this.this$0.o;
            if (r6 == null) goto L18;
            i1<y> r7 = r6.getUiState();
            if (r7 == null) goto L18;
            a r3 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r3, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }

        public static final Object access$invokeSuspend$render(final ChatJobListComponent r5, y r6, Continuation r7) {
            final RecyclerView r8 = r5.r;
            ChatJobListAdapter r0 = r5.n;
            if (r0 == null) goto L5;
            r0.submitList(r6.a, new f(r8, r5));
        L5:
            SwipeRefreshLayout r9 = r5.q;
            if (r9 == null) goto L8;
            r9.setRefreshing(r6.e);
        L8:
            SwipeRefreshLayout r10 = r5.q;
            boolean r1 = true;
            int r2 = 0;
            if (r10 == null) goto L18;
            if (r6.b == false) goto L13;
        L15:
            boolean r3 = false;
        L16:
            r10.setEnabled(r3);
            goto L18
        L13:
            if (r6.c == true) goto L15;
            r3 = true;
        L18:
            if (r6.b == false) goto L20;
        L22:
            boolean r11 = false;
        L23:
            SwipeRefreshLayout r4 = r5.q;
            if (r4 == null) goto L29;
            if (r11 == false) goto L27;
            int r12 = 0;
        L28:
            r4.setVisibility(r12);
            goto L29
        L27:
            r12 = 8;
        L29:
            RecyclerView r13 = r5.r;
            if (r13 == null) goto L40;
            if (r11 == true) goto L33;
        L35:
            r1 = false;
        L36:
            if (r1 == false) goto L38;
            int r14 = 0;
        L39:
            r13.setVisibility(r14);
            goto L40
        L38:
            r14 = 8;
            goto L39
        L33:
            if (r6.d == true) goto L35;
        L40:
            View r15 = r5.t;
            if (r15 != null) goto L43;
        L47:
            View r16 = r5.u;
            if (r16 != null) goto L50;
        L54:
            View r17 = r5.v;
            if (r17 == null) goto L62;
            if (r6.d == true) goto L60;
            r2 = 8;
        L60:
            r17.setVisibility(r2);
        L62:
            return Unit.INSTANCE;
        L50:
            if (r6.c == false) goto L52;
            int r18 = 0;
        L53:
            r16.setVisibility(r18);
            goto L54
        L52:
            r18 = 8;
            goto L53
        L43:
            if (r6.b == false) goto L45;
            int r19 = 0;
        L46:
            r15.setVisibility(r19);
            goto L47
        L45:
            r19 = 8;
            goto L46
        L20:
            if (r6.c == true) goto L22;
            r11 = true;
            goto L23
        }
    }

    public ChatJobListComponent$observe$1(Fragment r1, ChatJobListComponent r2, Continuation<? super ChatJobListComponent$observe$1> r3) {
        this.$hostFragment = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatJobListComponent$observe$1(this.$hostFragment, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

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
        LifecycleOwner r8 = this.$hostFragment.getViewLifecycleOwner();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
