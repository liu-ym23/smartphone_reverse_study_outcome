package com.larus.business.multitask_management.impl.floatwindow;

import androidx.core.content.ContextCompat;
import com.larus.business.multitask_management.impl.component.OngoingTaskListAdapter;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kl9.u;
import kl9.x;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.floatwindow.TaskManagementFloatWindowView$onAdded$1", f = "TaskManagementFloatWindowView.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
final class TaskManagementFloatWindowView$onAdded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TaskManagementFloatWindowView this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ TaskManagementFloatWindowView a;

        public a(TaskManagementFloatWindowView r1) {
            this.a = r1;
        }

        public final Object emit(Object r14, Continuation r15) {
            List<u> r16 = (List) r14;
            OngoingTaskListAdapter r17 = this.a.g;
            if (r17 == null) goto L5;
            r17.C2(r16);
        L5:
            final TaskManagementFloatWindowView r18 = this.a;
            r18.post(new o(r18));
            TaskManagementFloatWindowView r19 = this.a;
            u r110 = (u) CollectionsKt.firstOrNull(r16);
            r19.getClass();
            if (r110 == null) goto L8;
            x r1 = r110.i;
        L9:
            if (r110 == null) goto L13;
            Map r2 = r110.s;
            if (r2 == null) goto L13;
            String r3 = (String) r2.get("drag_handle_icon");
        L14:
            boolean r4 = true;
            if (r3 != null) goto L17;
        L20:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L44;
            if (r110 == null) goto L27;
            x r6 = r110.i;
            if (r6 == null) goto L27;
            r3 = r6.c;
        L28:
            if (r110 == null) goto L32;
            x r111 = r110.i;
            if (r111 == null) goto L32;
            String r112 = r111.d;
        L33:
            boolean r7 = v19.h.a;
            if (v19.h.b(r19.getContext()) == false) goto L44;
            if (r112 != null) goto L37;
        L40:
            boolean r8 = true;
        L41:
            if (r8 == true) goto L44;
            r3 = r112;
            goto L44
        L37:
            if (r112.length() == 0) goto L40;
            r8 = false;
        L32:
            r112 = null;
        L27:
            r3 = null;
        L44:
            boolean r113 = v19.h.a;
            if (v19.h.b(r19.getContext()) == false) goto L60;
            if (r1 == null) goto L48;
            String r114 = r1.g;
        L49:
            if (r114 != null) goto L51;
        L54:
            boolean r115 = true;
        L55:
            if (r115 == false) goto L58;
            if (r1 == null) goto L62;
            String r116 = r1.f;
        L64:
            if (r1 == null) goto L68;
            Double r9 = r1.e;
            if (r9 == null) goto L68;
            int r10 = c7.b(Double.valueOf(RangesKt.coerceAtLeast(r9.doubleValue(), 0.0d)));
        L69:
            TaskManagementFloatWindowView.b r11 = new TaskManagementFloatWindowView.b(r3, r116, r10);
            FLogger.a.d("TaskManagementFloatWindowView", "updateDragHandleBlur iconUrl: " + r3 + ", appliedBlurKey: " + r19.D + ", loadingBlurKey: " + r19.E);
            if (r3 != null) goto L72;
        L75:
            if (r4 == false) goto L77;
            r19.d();
            r19.D = null;
            r19.c.setImageDrawable(null);
            r19.c.setBackgroundColor(ContextCompat.getColor(r19.getContext(), v19.c.b(2130972081, r19.getContext(), 2131103143)));
        L92:
            return Unit.INSTANCE;
        L77:
            StringBuilder r0 = new StringBuilder();
            if (r3 != null) goto L80;
            r3 = "";
        L80:
            r0.append(r3);
            r0.append('#');
            if (r116 != null) goto L83;
            r116 = "";
        L83:
            r0.append(r116);
            r0.append('#');
            r0.append(r10);
            String r12 = r0.toString();
            if (Intrinsics.areEqual(r12, r19.D) == false) goto L88;
            if (r19.c.getDrawable() != null) goto L92;
        L88:
            if (Intrinsics.areEqual(r12, r19.E) == true) goto L92;
            r19.d();
            long r13 = r19.F;
            r19.E = r12;
            r19.i = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new TaskManagementFloatWindowView$updateDragHandleBlur$1(r13, r19, r12, r11, null), 3, null);
            goto L92
        L72:
            if (r3.length() == 0) goto L75;
            r4 = false;
        L68:
            r10 = 0;
        L62:
            r116 = null;
            goto L64
        L58:
            if (r1 == null) goto L62;
            r116 = r1.g;
            goto L64
        L51:
            if (r114.length() == 0) goto L54;
            r115 = false;
            goto L55
        L48:
            r114 = null;
            goto L49
        L60:
            if (r1 == null) goto L62;
            r116 = r1.f;
            goto L64
        L17:
            if (r3.length() == 0) goto L20;
            r5 = false;
        L13:
            r3 = null;
            goto L14
        L8:
            r1 = null;
            goto L9
        }
    }

    public TaskManagementFloatWindowView$onAdded$1(TaskManagementFloatWindowView r1, Continuation<? super TaskManagementFloatWindowView$onAdded$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TaskManagementFloatWindowView$onAdded$1(this.this$0, r3);
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
        i1<List<u>> r6 = com.larus.business.multitask_management.impl.component.g.a;
        i1<List<u>> r7 = com.larus.business.multitask_management.impl.component.g.a;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
