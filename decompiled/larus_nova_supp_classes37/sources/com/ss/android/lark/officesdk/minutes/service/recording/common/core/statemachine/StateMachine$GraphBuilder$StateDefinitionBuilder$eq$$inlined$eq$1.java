package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00028\u0001*\u0002H\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "R", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "com/ss/android/lark/officesdk/minutes/service/recording/common/core/statemachine/StateMachine$Matcher$Companion$eq$1"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class StateMachine$GraphBuilder$StateDefinitionBuilder$eq$$inlined$eq$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Object $value;

    public StateMachine$GraphBuilder$StateDefinitionBuilder$eq$$inlined$eq$1(Object r1) {
        this.$value = r1;
        super(1);
    }

    public final Boolean invoke(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$where");
        return Boolean.valueOf(Intrinsics.areEqual(r2, this.$value));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m308invoke(Object r1) {
        return invoke(r1);
    }
}
