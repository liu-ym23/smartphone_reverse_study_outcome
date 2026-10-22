package com.obric.memorydata;

import com.obric.aiproactive.api.ProactiveShortcutCompletion;
import com.obric.aiproactive.api.af;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000fJ*\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/ProactiveShortcutCompletionHub;", "", "resolveCompletion", "Lkotlin/Function1;", "", "Lcom/obric/aiproactive/api/ProactiveShortcutCompletion;", "reconcileOff", "", "onListenerFailure", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/aiproactive/api/ProactiveShortcutResultListener;", "addListener", "listener", "removeListener", "consumeTerminal", PendingPersonalInfoNotificationTask.KEY_GENERATION, "notifyUi", "shouldReconcileOff", "persistUserOptOutIfInactive", "notifyListeners", "completion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<Long, ProactiveShortcutCompletion> f9870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Boolean, ProactiveShortcutCompletion> f9871b;
    private final Function1<Throwable, Unit> c;
    private final CopyOnWriteArraySet<af> d;

    public g(Function1<? super Long, ? extends ProactiveShortcutCompletion> r3, Function1<? super Boolean, ? extends ProactiveShortcutCompletion> r4, Function1<? super Throwable, Unit> r5) {
        Function1<Long, ProactiveShortcutCompletion> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1<Boolean, ProactiveShortcutCompletion> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1<Throwable, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "resolveCompletion");
        Intrinsics.checkNotNullParameter(r7, "reconcileOff");
        Intrinsics.checkNotNullParameter(r8, "onListenerFailure");
        this.f9870a = r6;
        this.f9871b = r7;
        this.c = r8;
        this.d = new CopyOnWriteArraySet();
    }

    public final ProactiveShortcutCompletion a(long r2, boolean r4, boolean r5, boolean r6) {
        if (r5 == true) goto L5;
        ProactiveShortcutCompletion r3 = (ProactiveShortcutCompletion) ZeusTransformUtils.preCheckCast(this.f9870a.invoke(Long.valueOf(r2)), ProactiveShortcutCompletion.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L9;
        a(r3);
    L9:
        return r3;
    L5:
        return (ProactiveShortcutCompletion) ZeusTransformUtils.preCheckCast(this.f9871b.invoke(Boolean.valueOf(r6)), ProactiveShortcutCompletion.class, "com.obric.memorydata.plugin");
    }

    public final void a(ProactiveShortcutCompletion r5) {
        Intrinsics.checkNotNullParameter(r5, "completion");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.d, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        af r1 = (af) ZeusTransformUtils.preCheckCast(r0.next(), af.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        g r4 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r1.onResult(r5);     // Catch: Throwable -> L8
        Object r2 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Function1<Throwable, Unit> r6 = this.c;
        Throwable r7 = Result.m1424exceptionOrNullimpl(r2);
        if (r7 == null) goto L4;
        r6.invoke(r7);
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void a(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.d.add(r4);
    }

    public final void b(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.d.remove(r4);
    }
}
