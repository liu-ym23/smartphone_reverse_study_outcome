package com.obric.memorydata;

import android.app.Activity;
import android.content.Context;
import com.obric.aiproactive.api.IProactiveShortcutService;
import com.obric.aiproactive.api.ProactiveShortcutRequestResult;
import com.obric.aiproactive.api.ProactiveShortcutState;
import com.obric.aiproactive.api.af;
import com.obric.memorydata.memory.ui.settings.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/ProactiveShortcutServiceImpl;", "Lcom/obric/aiproactive/api/IProactiveShortcutService;", "<init>", "()V", "getInst", "initializeDefaultOnHome", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryState", "Lcom/obric/aiproactive/api/ProactiveShortcutState;", "context", "Landroid/content/Context;", "requestPin", "Lcom/obric/aiproactive/api/ProactiveShortcutRequestResult;", "disableByUser", "isResidualOnLauncher", "", "registerResultListener", "listener", "Lcom/obric/aiproactive/api/ProactiveShortcutResultListener;", "unregisterResultListener", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveShortcutServiceImpl implements IProactiveShortcutService {
    public static final ProactiveShortcutServiceImpl INSTANCE = null;

    static {
        INSTANCE = new ProactiveShortcutServiceImpl();
    }

    private ProactiveShortcutServiceImpl() {
    }

    @JvmStatic
    public static final ProactiveShortcutServiceImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.aiproactive.api.IProactiveShortcutService
    public ProactiveShortcutState disableByUser(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        return l.f11479a.a().c(r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveShortcutService
    public Object initializeDefaultOnHome(Activity r2, Continuation<? super Unit> r3) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        Object r5 = l.f11479a.a().a(r1, r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.aiproactive.api.IProactiveShortcutService
    public boolean isResidualOnLauncher(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        return l.f11479a.a().d(r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveShortcutService
    public ProactiveShortcutState queryState(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        return l.f11479a.a().b(r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveShortcutService
    public void registerResultListener(af r2) {
        af r1 = (af) ZeusTransformUtils.wrapperContextForParams(r2, af.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        h.f9872a.a(r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveShortcutService
    public ProactiveShortcutRequestResult requestPin(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "activity");
        return l.f11479a.a().a(r1);
    }

    @Override // com.obric.aiproactive.api.IProactiveShortcutService
    public void unregisterResultListener(af r2) {
        af r1 = (af) ZeusTransformUtils.wrapperContextForParams(r2, af.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        h.f9872a.b(r1);
    }
}
