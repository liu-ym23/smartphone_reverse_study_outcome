package com.obric.assistant.special_input;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.task.ObricTaskStatusManager;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/special_input/SpecialInputAutoHideComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "monitorTaskJob", "Lkotlinx/coroutines/Job;", "chatConversationAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getChatConversationAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "onCreate", "", "onDestroy", "needCloseReplayPanel", "", "dmStateInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpecialInputAutoHideComponent extends ComponentFeature {
    public static final /* synthetic */ int j = 0;
    public Job h;
    public final Lazy i;

    public static final class a {
    }

    public static final class b implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.special_input.SpecialInputAutoHideComponent$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputAutoHideComponent$onCreate$1", f = "SpecialInputAutoHideComponent.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SpecialInputAutoHideComponent this$0;

        /* JADX INFO: renamed from: com.obric.assistant.special_input.SpecialInputAutoHideComponent$onCreate$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ SpecialInputAutoHideComponent a;

            public a(SpecialInputAutoHideComponent r1) {
                this.a = r1;
            }

            public final Object emit(Object r8, Continuation r9) {
                DMStateInfo r10 = (DMStateInfo) r8;
                SpecialInputAutoHideComponent r11 = this.a;
                int r0 = SpecialInputAutoHideComponent.j;
                laa.j r1 = (laa.j) r11.i.getValue();
                boolean r2 = false;
                if (r1 == null) goto L9;
                kotlinx.coroutines.flow.b1 r3 = r1.O4();
                if (r3 == null) goto L9;
                if (((Boolean) r3.getValue()).booleanValue() != true) goto L9;
                boolean r4 = true;
            L11:
                if (r4 == false) goto L56;
                laa.j r12 = (laa.j) r11.i.getValue();
                DMTaskState r5 = null;
                T r6 = null;
                r5 = null;
                if (r12 == null) goto L18;
                kotlinx.coroutines.flow.b1 r13 = r12.i80();
                if (r13 == null) goto L18;
                laa.v r14 = (laa.v) r13.getValue();
            L19:
                if (r14 != null) goto L21;
                FLogger.a.i("SpecialInputAutoHideComponent", "needCloseReplayPanelOpen curInputStatus is null");
                goto L56
            L21:
                DMTaskState r7 = r14.a;
                if (r7 == null) goto L24;
                String r15 = r7.getTaskId();
            L25:
                if (r15 != null) goto L27;
            L30:
                boolean r16 = true;
            L31:
                if (r16 == false) goto L33;
                FLogger.a.i("SpecialInputAutoHideComponent", "needCloseReplayPanelOpen inputTaskId is null");
                goto L56
            L33:
                if (r10 == null) goto L43;
                List r17 = r10.getActiveTasks();
                if (r17 == null) goto L43;
                Iterator<T> r18 = r17.iterator();
            L38:
                if (r18.hasNext() == false) goto L42;
                T r19 = r18.next();
                if (Intrinsics.areEqual(((DMTaskState) r19).getTaskId(), r15) == false) goto L38;
                r6 = r19;
            L42:
                r5 = (DMTaskState) r6;
            L43:
                if (r5 != null) goto L45;
                FLogger.a.i("SpecialInputAutoHideComponent", "needCloseReplayPanelOpen task is null");
            L55:
                r2 = true;
                goto L56
            L45:
                StateInfo r20 = r14.b;
                if (r20 != null) goto L48;
            L50:
                boolean r21 = false;
            L51:
                if (r21 == false) goto L56;
                if (com.obric.assistant.utils.l.f(r5) == true) goto L56;
                FLogger.a.i("SpecialInputAutoHideComponent", "needCloseReplayPanelOpen task is not running");
                goto L55
            L48:
                if (r20.getRequestType() != 1) goto L50;
                r21 = true;
                goto L51
            L27:
                if (r15.length() == 0) goto L30;
                r16 = false;
                goto L31
            L24:
                r15 = null;
            L18:
                r14 = null;
            L56:
                if (r2 == false) goto L61;
                FLogger.a.i("SpecialInputAutoHideComponent", "closeSpecialInputPanel");
                laa.j r22 = (laa.j) this.a.i.getValue();
                if (r22 == null) goto L61;
                r22.e90();
            L61:
                return Unit.INSTANCE;
            L9:
                r4 = false;
                goto L11
            }
        }

        public AnonymousClass1(SpecialInputAutoHideComponent r1, Continuation<? super AnonymousClass1> r2) {
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
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ObricTaskStatusManager.a.getClass();
            StateFlowImpl r6 = ObricTaskStatusManager.f;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final void onDestroy() {
        Job r0 = this.h;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    public SpecialInputAutoHideComponent() {
        this.i = LazyKt.lazy(new b(this));
    }

    public final void onCreate() {
        this.h = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }
}
