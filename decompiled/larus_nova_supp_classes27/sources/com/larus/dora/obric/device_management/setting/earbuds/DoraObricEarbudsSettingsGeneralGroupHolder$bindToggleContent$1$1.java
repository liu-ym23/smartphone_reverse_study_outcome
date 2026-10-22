package com.larus.dora.obric.device_management.setting.earbuds;

import com.obric.oui.oswitch.OSwitch;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.DoraObricEarbudsSettingsGeneralGroupHolder$bindToggleContent$1$1", f = "DoraObricEarbudsSettingsGeneralGroupHolder.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricEarbudsSettingsGeneralGroupHolder$bindToggleContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OSwitch $switch;
    int label;
    final /* synthetic */ DoraObricEarbudsSettingsGeneralGroupHolder this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsSettingsGeneralGroupHolder a;
        public final /* synthetic */ OSwitch b;

        public a(DoraObricEarbudsSettingsGeneralGroupHolder r1, OSwitch r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            boolean r5 = ((Boolean) r3).booleanValue();
            DoraObricEarbudsSettingsGeneralGroupHolder r6 = this.a;
            OSwitch r0 = this.b;
            int r1 = DoraObricEarbudsSettingsGeneralGroupHolder.e;
            r6.Z3(r0, r5);
            return Unit.INSTANCE;
        }
    }

    public DoraObricEarbudsSettingsGeneralGroupHolder$bindToggleContent$1$1(DoraObricEarbudsSettingsGeneralGroupHolder r1, OSwitch r2, Continuation<? super DoraObricEarbudsSettingsGeneralGroupHolder$bindToggleContent$1$1> r3) {
        this.this$0 = r1;
        this.$switch = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricEarbudsSettingsGeneralGroupHolder$bindToggleContent$1$1(this.this$0, this.$switch, r4);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DoraObricEarbudsSettingsGeneralGroupHolder r7 = this.this$0;
        int r2 = DoraObricEarbudsSettingsGeneralGroupHolder.e;
        r7.getClass();
        Flow r8 = kotlinx.coroutines.flow.e.w(new c1(new DoraObricEarbudsSettingsGeneralGroupHolder$getMultiUserModeStateFlow$1(null)), Dispatchers.getIO());
        a r3 = new a(this.this$0, this.$switch);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
