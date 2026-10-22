package com.bytedance.applog.params.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.applog.log.q;
import com.bytedance.applog.params.e;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applog/params/lifecycle/LifecycleValueObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "Lkotlin/Function0;", "", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;)V", "loggerTag", "", "", "getOnDestroy", "()Lkotlin/jvm/functions/Function0;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "destroy", "onStateChanged", AILabCheckPermissionTask.KEY_SOURCE, "event", "Landroidx/lifecycle/Lifecycle$Event;", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifecycleValueObserver implements LifecycleEventObserver {
    private final List<String> loggerTag;
    private final Function0<Unit> onDestroy;
    private final LifecycleOwner owner;

    public LifecycleValueObserver(LifecycleOwner r3, Function0<Unit> r4) {
        LifecycleOwner r5 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "owner");
        Intrinsics.checkNotNullParameter(r6, "onDestroy");
        this.owner = r5;
        this.onDestroy = r6;
        this.loggerTag = CollectionsKt.listOf("LifecycleValueObserver");
        e.a((Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ List access$getLoggerTag$p(LifecycleValueObserver r0) {
        return r0.loggerTag;
    }

    public final void destroy() {
        e.a((Function0) ZeusTransformUtils.preCheckCast(new C09771(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public final Function0<Unit> getOnDestroy() {
        return this.onDestroy;
    }

    public final LifecycleOwner getOwner() {
        return this.owner;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin"), AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4 != Lifecycle.Event.ON_DESTROY) goto L6;
        q.a().a(this.loggerTag, "params with lifecycle owner destroyed and onDestroy callback invoke start...", new Object[0]);
        this.onDestroy.invoke();
        destroy();
        return;
    }
}
