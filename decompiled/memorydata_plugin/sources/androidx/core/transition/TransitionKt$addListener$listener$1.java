package androidx.core.transition;

import android.transition.Transition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1<Transition, Unit> $onCancel;
    final /* synthetic */ Function1<Transition, Unit> $onEnd;
    final /* synthetic */ Function1<Transition, Unit> $onPause;
    final /* synthetic */ Function1<Transition, Unit> $onResume;
    final /* synthetic */ Function1<Transition, Unit> $onStart;

    public TransitionKt$addListener$listener$1(Function1<? super Transition, Unit> r3, Function1<? super Transition, Unit> r4, Function1<? super Transition, Unit> r5, Function1<? super Transition, Unit> r6, Function1<? super Transition, Unit> r7) {
        Function1<Transition, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1<Transition, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1<Transition, Unit> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Function1<Transition, Unit> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function1<Transition, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        this.$onEnd = r8;
        this.$onResume = r9;
        this.$onPause = r10;
        this.$onCancel = r11;
        this.$onStart = r12;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition r1) {
        this.$onCancel.invoke(r1);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition r1) {
        this.$onEnd.invoke(r1);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition r1) {
        this.$onPause.invoke(r1);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition r1) {
        this.$onResume.invoke(r1);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition r1) {
        this.$onStart.invoke(r1);
    }
}
