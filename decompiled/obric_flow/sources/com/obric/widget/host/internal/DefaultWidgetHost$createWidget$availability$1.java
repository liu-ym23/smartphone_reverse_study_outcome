package com.obric.widget.host.internal;

import com.obric.widget.host.WidgetDefinition;
import com.obric.widget.host.runtime.WidgetAvailability;
import com.obric.widget.host.runtime.WidgetBindReason;
import com.obric.widget.host.runtime.WidgetRuntimeServices;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/widget/host/runtime/WidgetAvailability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHost$createWidget$availability$1", f = "DefaultWidgetHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultWidgetHost$createWidget$availability$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WidgetAvailability>, Object> {
    final /* synthetic */ WidgetBindReason $bindReason;
    final /* synthetic */ WidgetDefinition $definition;
    int label;
    final /* synthetic */ DefaultWidgetHost this$0;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[WidgetBindReason.values().length];
            r5[WidgetBindReason.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r5[WidgetBindReason.RESTORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public DefaultWidgetHost$createWidget$availability$1(DefaultWidgetHost r5, WidgetDefinition r10, WidgetBindReason r11, Continuation<? super DefaultWidgetHost$createWidget$availability$1> r12) {
        this.this$0 = r5;
        this.$definition = r10;
        this.$bindReason = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new DefaultWidgetHost$createWidget$availability$1(this.this$0, this.$definition, this.$bindReason, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super WidgetAvailability> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        WidgetRuntimeServices r10 = DefaultWidgetHost.access$getRuntimeServices$p(this.this$0);
        String r11 = this.$definition.getAppletId();
        String r12 = this.$definition.getWidgetId();
        Long r13 = this.$definition.getVersion();
        WidgetBindReason r14 = this.$bindReason;
        int r15 = WhenMappings.$EnumSwitchMapping$0[r14.ordinal()];
        if (r15 != 1) goto L7;
        String r16 = "add";
    L13:
        return r10.ensureWidgetAvailable(r11, r12, r13, r16);
    L7:
        if (r15 != 2) goto L10;
        r16 = "restore";
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super WidgetAvailability> r10) {
        return ((DefaultWidgetHost$createWidget$availability$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
