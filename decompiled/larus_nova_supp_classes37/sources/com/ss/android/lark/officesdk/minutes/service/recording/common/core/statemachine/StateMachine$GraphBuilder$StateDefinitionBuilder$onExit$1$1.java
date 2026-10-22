package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "STATE", "", "EVENT", "state", "cause", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class StateMachine$GraphBuilder$StateDefinitionBuilder$onExit$1$1 extends Lambda implements Function2<Object, Object, Unit> {
    final /* synthetic */ Function2<Object, Object, Unit> $listener;

    public StateMachine$GraphBuilder$StateDefinitionBuilder$onExit$1$1(Function2<Object, Object, Unit> r1) {
        this.$listener = r1;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m312invoke(Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "cause");
        this.$listener.invoke(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        m312invoke(r1, r2);
        return Unit.INSTANCE;
    }
}
