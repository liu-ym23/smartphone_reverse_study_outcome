package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.larus.dora.impl.nl.AppListItem;
import com.obric.oui.status.OPageStatus;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsAppListActivity$setupObserver$2", f = "DoraObricEarbudsAppListActivity.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricEarbudsAppListActivity$setupObserver$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraObricEarbudsAppListActivity this$0;

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsAppListActivity$setupObserver$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsAppListActivity$setupObserver$2$1", f = "DoraObricEarbudsAppListActivity.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraObricEarbudsAppListActivity this$0;

        /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsAppListActivity$setupObserver$2$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ DoraObricEarbudsAppListActivity a;

            public a(DoraObricEarbudsAppListActivity r1) {
                this.a = r1;
            }

            /* JADX WARN: Type inference failed for: r4v6, types: [android.app.Activity, com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsAppListActivity] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            public final Object emit(Object r4, Continuation r5) {
                List<? extends AppListItem> r6 = (List) r4;
                DoraObricEarbudsAppListActivity.EarbudsAppListAdapter r7 = this.a.h;
                r7.getClass();
                Intrinsics.checkNotNullParameter(r6, "data");
                r7.b = r6;
                r7.notifyDataSetChanged();
                if (r6.isEmpty() == true) goto L5;
            L7:
                boolean r8 = false;
            L8:
                OPageStatus r1 = this.a.j;
                if (r1 == null) goto L14;
                if (r8 == false) goto L12;
                int r2 = 0;
            L13:
                r1.setVisibility(r2);
                goto L14
            L12:
                r2 = 8;
            L14:
                if (r8 == false) goto L19;
                ?? r9 = this.a;
                OPageStatus r3 = r9.j;
                if (r3 == null) goto L19;
                r3.setTitle(r9.getString(2131902236, new Object[]{r9.O1().getQuery()}));
            L19:
                return Unit.INSTANCE;
            L5:
                if (this.a.k == false) goto L7;
                r8 = true;
                goto L8
            }
        }

        public AnonymousClass1(DoraObricEarbudsAppListActivity r1, Continuation<? super AnonymousClass1> r2) {
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
            DoraObricEarbudsAppListActivity r6 = this.this$0;
            int r2 = DoraObricEarbudsAppListActivity.m;
            kotlinx.coroutines.flow.i1<List<AppListItem>> r7 = r6.O1().getAppListStateFlow();
            a r3 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public DoraObricEarbudsAppListActivity$setupObserver$2(DoraObricEarbudsAppListActivity r1, Continuation<? super DoraObricEarbudsAppListActivity$setupObserver$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraObricEarbudsAppListActivity$setupObserver$2(this.this$0, r3);
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
        Lifecycle r8 = this.this$0.getLifecycle();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
