package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import androidx.lifecycle.ViewModel;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SubscribedSharedFlow;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u00072\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00050\bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00028\u0001H\u0096@¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020-H\u0016J9\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020\u00122\"\u00103\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020-05\u0012\u0006\u0012\u0004\u0018\u00010604H\u0016¢\u0006\u0002\u00107J\u0016\u00108\u001a\u00020-2\u0006\u0010.\u001a\u00028\u0001H\u0082@¢\u0006\u0002\u0010/J\u001f\u00109\u001a\u00020-2\u0017\u0010:\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000;¢\u0006\u0002\b<J\r\u0010=\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010>J\u001a\u0010?\u001a\u00020-2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020-0;J\u000e\u0010A\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010BJS\u0010C\u001a\u00020-\"\u0004\b\u0003\u0010D2\u0006\u00102\u001a\u00020\u00122\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HD0F2\"\u00103\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002HD\u0012\n\u0012\b\u0012\u0004\u0012\u00020-05\u0012\u0006\u0012\u0004\u0018\u00010604H\u0016¢\u0006\u0002\u0010GJs\u0010C\u001a\u00020-\"\u0004\b\u0003\u0010D\"\u0004\b\u0004\u0010H2\u0006\u00102\u001a\u00020\u00122\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HD0F2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HH0F2(\u00103\u001a$\b\u0001\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HH\u0012\n\u0012\b\u0012\u0004\u0012\u00020-05\u0012\u0006\u0012\u0004\u0018\u0001060JH\u0016¢\u0006\u0002\u0010KJ\u0093\u0001\u0010C\u001a\u00020-\"\u0004\b\u0003\u0010D\"\u0004\b\u0004\u0010H\"\u0004\b\u0005\u0010\u00052\u0006\u00102\u001a\u00020\u00122\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HD0F2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HH0F2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00050F2.\u00103\u001a*\b\u0001\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HH\u0012\u0004\u0012\u0002H\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020-05\u0012\u0006\u0012\u0004\u0018\u0001060MH\u0016¢\u0006\u0002\u0010NJ³\u0001\u0010C\u001a\u00020-\"\u0004\b\u0003\u0010D\"\u0004\b\u0004\u0010H\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010O2\u0006\u00102\u001a\u00020\u00122\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HD0F2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HH0F2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00050F2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HO0F24\u00103\u001a0\b\u0001\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HH\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002HO\u0012\n\u0012\b\u0012\u0004\u0012\u00020-05\u0012\u0006\u0012\u0004\u0018\u0001060QH\u0016¢\u0006\u0002\u0010RJ\r\u0010S\u001a\u00028\u0000H&¢\u0006\u0002\u0010>J\b\u0010T\u001a\u00020-H\u0014J\b\u0010U\u001a\u00020\fH\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0019\u001a*\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a0\u0016j\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001a`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR!\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%R!\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b)\u0010*¨\u0006V"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/MviViewModel;", "S", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/VMState;", "E", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/VMEvent;", "C", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/UIEvent;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/IViewModel;", "<init>", "()V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "setLogTag", "(Ljava/lang/String;)V", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "getViewModelScope", "()Lkotlinx/coroutines/CoroutineScope;", "componentVMEventSubscriptionMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pendingVmEventsMap", "", "handledPendingVMEvents", "uiEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getUiEventFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "uiEventFlow$delegate", "Lkotlin/Lazy;", "store", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/StateStore;", "getStore", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/StateStore;", "store$delegate", "composeViewModel", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/MviComposeViewModel;", "getComposeViewModel", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/MviComposeViewModel;", "composeViewModel$delegate", "sendVMEvent", "", "event", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/VMEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onVmEventsSubscriptionComplete", "selectSubscribeVMEvent", "scope", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)V", "savePendingVmEvents", "setState", "reducer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getState", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/VMState;", "withState", "block", "awaitState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectSubscribe", "A", "prop1", "Lkotlin/reflect/KProperty1;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/reflect/KProperty1;Lkotlin/jvm/functions/Function2;)V", "B", "prop2", "Lkotlin/Function3;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/jvm/functions/Function3;)V", "prop3", "Lkotlin/Function4;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/jvm/functions/Function4;)V", "D", "prop4", "Lkotlin/Function5;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/jvm/functions/Function5;)V", "defaultState", "onCleared", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class MviViewModel<S extends l, E extends k, C extends j> extends ViewModel implements a<S, E, C> {
    private final HashMap<String, Boolean> componentVMEventSubscriptionMap;
    private final Lazy composeViewModel$delegate;
    private final List<E> handledPendingVMEvents;
    private String logTag;
    private final HashMap<String, List<E>> pendingVmEventsMap;
    private final Lazy store$delegate;
    private final Lazy uiEventFlow$delegate;
    private final CoroutineScope viewModelScope;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel$savePendingVmEvents$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel$savePendingVmEvents$2", f = "MviViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ E $event;
        int label;
        final /* synthetic */ MviViewModel<S, E, C> this$0;

        public AnonymousClass2(MviViewModel<S, E, C> r1, E r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$event, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r6);
            Set r7 = MviViewModel.access$getPendingVmEventsMap$p(this.this$0).keySet();
            MviViewModel<S, E, C> r0 = this.this$0;
            E r1 = this.$event;
            Iterator r8 = r7.iterator();
        L6:
            if (r8.hasNext() == false) goto L13;
            String r2 = (String) r8.next();
            if (Intrinsics.areEqual(MviViewModel.access$getComponentVMEventSubscriptionMap$p(r0).get(r2), Boxing.boxBoolean(false)) == false) goto L6;
            List r3 = (List) MviViewModel.access$getPendingVmEventsMap$p(r0).get(r2);
            if (r3 == null) goto L6;
            Boxing.boxBoolean(r3.add(r1));
            goto L6
        L13:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel$selectSubscribeVMEvent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel$selectSubscribeVMEvent$1", f = "MviViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Unit>, Object> $action;
        int label;
        final /* synthetic */ MviViewModel<S, E, C> this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel$selectSubscribeVMEvent$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "E", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/VMEvent;", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel$selectSubscribeVMEvent$1$1", f = "MviViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00161 extends SuspendLambda implements Function2<FlowCollector<? super E>, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MviViewModel<S, E, C> this$0;

            public C00161(MviViewModel<S, E, C> r1, Continuation<? super C00161> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00161(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((FlowCollector) r1, (Continuation) r2);
            }

            public final Object invoke(FlowCollector<? super E> r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.this$0.onVmEventsSubscriptionComplete();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel$selectSubscribeVMEvent$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MviViewModel<S, E, C> a;
            public final /* synthetic */ Function2<E, Continuation<? super Unit>, Object> b;

            /* JADX WARN: Multi-variable type inference failed */
            public a(MviViewModel<S, E, C> r1, Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r2, Continuation r3) {
                k r4 = (k) r2;
                if ((!MviViewModel.access$getPendingVmEventsMap$p(this.a).values().isEmpty()) == false) goto L5;
                MviViewModel.access$getHandledPendingVMEvents$p(this.a).add(r4);
            L5:
                Object r5 = this.b.invoke(r4, r3);
                if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
                return r5;
            L9:
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(MviViewModel<S, E, C> r1, Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$action = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$action, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            SubscribedSharedFlow r3 = new SubscribedSharedFlow(MviViewModel.access$getUiEventFlow(this.this$0), new C00161(this.this$0, null));
            a r7 = new a(this.this$0, this.$action);
            this.label = 1;
            if (r3.collect(r7, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel$sendVMEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel", f = "MviViewModel.kt", i = {0, 0}, l = {55, 56}, m = "sendVMEvent$suspendImpl", n = {"$this", "event"}, s = {"L$0", "L$1"})
    public static final class C02151<S extends l, E extends k, C extends j> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MviViewModel<S, E, C> this$0;

        public C02151(MviViewModel<S, E, C> r1, Continuation<? super C02151> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MviViewModel.sendVMEvent$suspendImpl(this.this$0, null, this);
        }
    }

    public Object awaitState(Continuation<? super S> r1) {
        return awaitState$suspendImpl(this, r1);
    }

    public abstract S defaultState();

    public abstract /* synthetic */ void dispatchEvent(j r1);

    public void onVmEventsSubscriptionComplete() {
    }

    public Object sendVMEvent(E r1, Continuation<? super Unit> r2) {
        return sendVMEvent$suspendImpl(this, r1, r2);
    }

    private final c<S> getStore() {
        return (c) this.store$delegate.getValue();
    }

    private final MutableSharedFlow<E> getUiEventFlow() {
        return (MutableSharedFlow) this.uiEventFlow$delegate.getValue();
    }

    public final b<S> getComposeViewModel() {
        return (b) this.composeViewModel$delegate.getValue();
    }

    public MviViewModel() {
        this.logTag = getClass().getSimpleName() + '_' + hashCode();
        this.viewModelScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.componentVMEventSubscriptionMap = new HashMap();
        this.pendingVmEventsMap = new HashMap();
        this.handledPendingVMEvents = new ArrayList();
        this.uiEventFlow$delegate = LazyKt.lazy(MviViewModel$uiEventFlow$2.INSTANCE);
        this.store$delegate = LazyKt.lazy(new MviViewModel$store$2(this));
        this.composeViewModel$delegate = LazyKt.lazy(new MviViewModel$composeViewModel$2(this));
    }

    public S getState() {
        return getStore().e;
    }

    public void onCleared() {
        lvb.a.e(getLogTag(), "onCleared");
        CoroutineScopeKt.cancel$default(this.viewModelScope, null, 1, null);
    }

    public String toString() {
        return getLogTag();
    }

    public String getLogTag() {
        return this.logTag;
    }

    public final CoroutineScope getViewModelScope() {
        return this.viewModelScope;
    }

    public static final /* synthetic */ HashMap access$getComponentVMEventSubscriptionMap$p(MviViewModel r0) {
        return r0.componentVMEventSubscriptionMap;
    }

    public static final /* synthetic */ List access$getHandledPendingVMEvents$p(MviViewModel r0) {
        return r0.handledPendingVMEvents;
    }

    public static final /* synthetic */ HashMap access$getPendingVmEventsMap$p(MviViewModel r0) {
        return r0.pendingVmEventsMap;
    }

    public static final /* synthetic */ c access$getStore(MviViewModel r0) {
        return r0.getStore();
    }

    public static final /* synthetic */ MutableSharedFlow access$getUiEventFlow(MviViewModel r0) {
        return r0.getUiEventFlow();
    }

    public void setLogTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.logTag = r2;
    }

    public final void setState(Function1<? super S, ? extends S> r3) {
        Intrinsics.checkNotNullParameter(r3, "reducer");
        c<S> r1 = getStore();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "reducer");
        r1.b.trySend-JP2dKIU(r3);
    }

    public final void withState(Function1<? super S, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        c<S> r0 = getStore();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "action");
        r0.c.trySend-JP2dKIU(r3);
    }

    public static <S extends l, E extends k, C extends j> Object awaitState$suspendImpl(MviViewModel<S, E, C> r3, Continuation<? super S> r4) {
        c<S> r5 = r3.getStore();
        r5.getClass();
        CompletableDeferred r0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        StateStore$awaitState$2 r1 = new StateStore$awaitState$2(r0);
        Intrinsics.checkNotNullParameter(r1, "action");
        r5.c.trySend-JP2dKIU(r1);
        return r0.await(r4);
    }

    private final Object savePendingVmEvents(E r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a
    public void selectSubscribeVMEvent(CoroutineScope r8, Function2<? super E, ? super Continuation<? super Unit>, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r9, "action");
        BuildersKt.launch$default(r8, null, null, new AnonymousClass1(this, r9, null), 3, null);
    }

    public static final /* synthetic */ Object access$savePendingVmEvents(MviViewModel r0, k r1, Continuation r2) {
        return r0.savePendingVmEvents(r1, r2);
    }

    public static /* synthetic */ <S extends l, E extends k, C extends j> Object sendVMEvent$suspendImpl(MviViewModel<S, E, C> r5, E r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof C02151) == false) goto L7;
        C02151 r0 = (C02151) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (E) r0.L$1;
        r5 = (MviViewModel) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        MutableSharedFlow<E> r9 = r5.getUiEventFlow();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (r9.emit(r6, r0) != r2) goto L23;
        return r2;
    L16:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 1;
        if (r5.savePendingVmEvents(r6, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new C02151(r5, r7);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a
    public <A> void selectSubscribe(CoroutineScope r5, final KProperty1<S, ? extends A> r6, Function2<? super A, ? super Continuation<? super Unit>, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r6, "prop1");
        Intrinsics.checkNotNullParameter(r7, "action");
        c<S> r3 = getStore();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r6, "prop1");
        Intrinsics.checkNotNullParameter(r7, "action");
        final a1 r0 = r3.f;
        c.a(r3, kotlinx.coroutines.flow.e.n(new StateStore$selectSubscribe$$inlined$map$1(r0, r6)), r5, new StateStore$selectSubscribe$2(r7, null));
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a
    public <A, B> void selectSubscribe(CoroutineScope r6, final KProperty1<S, ? extends A> r7, final KProperty1<S, ? extends B> r8, Function3<? super A, ? super B, ? super Continuation<? super Unit>, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r7, "prop1");
        Intrinsics.checkNotNullParameter(r8, "prop2");
        Intrinsics.checkNotNullParameter(r9, "action");
        c<S> r4 = getStore();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r7, "prop1");
        Intrinsics.checkNotNullParameter(r8, "prop2");
        Intrinsics.checkNotNullParameter(r9, "action");
        final a1 r0 = r4.f;
        c.a(r4, kotlinx.coroutines.flow.e.n(new StateStore$selectSubscribe$$inlined$map$2(r0, r7, r8)), r6, new StateStore$selectSubscribe$4(r9, null));
    }

    public <A, B, C> void selectSubscribe(CoroutineScope r7, final KProperty1<S, ? extends A> r8, final KProperty1<S, ? extends B> r9, final KProperty1<S, ? extends C> r10, Function4<? super A, ? super B, ? super C, ? super Continuation<? super Unit>, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(r8, "prop1");
        Intrinsics.checkNotNullParameter(r9, "prop2");
        Intrinsics.checkNotNullParameter(r10, "prop3");
        Intrinsics.checkNotNullParameter(r11, "action");
        c<S> r5 = getStore();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(r8, "prop1");
        Intrinsics.checkNotNullParameter(r9, "prop2");
        Intrinsics.checkNotNullParameter(r10, "prop3");
        Intrinsics.checkNotNullParameter(r11, "action");
        final a1 r0 = r5.f;
        c.a(r5, kotlinx.coroutines.flow.e.n(new StateStore$selectSubscribe$$inlined$map$3(r0, r8, r9, r10)), r7, new StateStore$selectSubscribe$6(r11, null));
    }

    public <A, B, C, D> void selectSubscribe(CoroutineScope r14, final KProperty1<S, ? extends A> r15, final KProperty1<S, ? extends B> r16, final KProperty1<S, ? extends C> r17, final KProperty1<S, ? extends D> r18, Function5<? super A, ? super B, ? super C, ? super D, ? super Continuation<? super Unit>, ? extends Object> r19) {
        Intrinsics.checkNotNullParameter(r14, "scope");
        Intrinsics.checkNotNullParameter(r15, "prop1");
        Intrinsics.checkNotNullParameter(r16, "prop2");
        Intrinsics.checkNotNullParameter(r17, "prop3");
        Intrinsics.checkNotNullParameter(r18, "prop4");
        Intrinsics.checkNotNullParameter(r19, "action");
        c<S> r12 = getStore();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r14, "scope");
        Intrinsics.checkNotNullParameter(r15, "prop1");
        Intrinsics.checkNotNullParameter(r16, "prop2");
        Intrinsics.checkNotNullParameter(r17, "prop3");
        Intrinsics.checkNotNullParameter(r18, "prop4");
        Intrinsics.checkNotNullParameter(r19, "action");
        final a1 r2 = r12.f;
        c.a(r12, kotlinx.coroutines.flow.e.n(new StateStore$selectSubscribe$$inlined$map$4(r2, r15, r16, r17, r18)), r14, new StateStore$selectSubscribe$8(r19, null));
    }
}
