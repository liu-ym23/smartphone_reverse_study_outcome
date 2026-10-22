package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class StateMachine$Matcher$where$1$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Function1<Object, Boolean> $predicate;

    public StateMachine$Matcher$where$1$1(Function1<Object, Boolean> r1) {
        this.$predicate = r1;
        super(1);
    }

    public final Boolean invoke(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Boolean) this.$predicate.invoke(r2);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m316invoke(Object r1) {
        return invoke(r1);
    }
}
