package com.bytedance.lego.init;

import com.bytedance.lego.init.model.DelayTaskInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 13})
final class DelayTaskDispatcher$dispatchTask$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DelayTaskInfo $task;

    public DelayTaskDispatcher$dispatchTask$1(DelayTaskInfo r5) {
        this.$task = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DelayTaskInfo r5 = this.$task;
        if (r5.mustRunInMainThread == true) goto L5;
        c.b(r5, false);
        return;
    L5:
        c.e.post(new a(this, 0));
    }
}
