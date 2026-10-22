package com.bytedance.android.live.liveinteract.animation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/animation/tasklet/d;", "p1", "", "p2", "", "invoke", "(Lcom/bytedance/android/live/liveinteract/animation/tasklet/d;Z)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class InteractFlyMicAnimationTask$buildTasklet$1 extends FunctionReferenceImpl implements Function2<com.bytedance.android.live.liveinteract.animation.tasklet.d, Boolean, Unit> {
    public InteractFlyMicAnimationTask$buildTasklet$1(InteractFlyMicAnimationTask r8) {
        super(2, r8, InteractFlyMicAnimationTask.class, "onTaskletExecuteFunc", "onTaskletExecuteFunc(Lcom/bytedance/android/live/liveinteract/animation/tasklet/ITasklet;Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((com.bytedance.android.live.liveinteract.animation.tasklet.d) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(com.bytedance.android.live.liveinteract.animation.tasklet.d r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        InteractFlyMicAnimationTask.m((InteractFlyMicAnimationTask) ((CallableReference) this).receiver, r2, r3);
    }
}
