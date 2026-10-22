package com.obric.memorydata.middleware.impl.phoneassistant;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.phoneassistant.IPhoneAssistantHelper;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\f*\u0002\u0012\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\b\u0010\u0017\u001a\u00020\fH\u0003J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0003J\b\u0010\u001a\u001a\u00020\fH\u0002J\u0016\u0010\u001b\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u0010\u001d\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u0010\u001e\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u0010\u001f\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000Rh\u0010\t\u001aZ\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \r*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e \r*,\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \r*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fRh\u0010\u0010\u001aZ\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \r*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e \r*,\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \r*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006 "}, d2 = {"Lcom/obric/memorydata/middleware/impl/phoneassistant/PhoneAssistantHelper;", "Lcom/obric/memorydata/middleware/api/phoneassistant/IPhoneAssistantHelper;", "<init>", "()V", "getInst", "TAG", "", "ASSISTANT_EXIT_ACTION", "ASSISTANT_INVOKE_ACTION", "assistantExitListenerSet", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "Lkotlin/Function0;", "", "kotlin.jvm.PlatformType", "", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "assistantInvokeListenerSet", "assistantExitBroadcastReceiver", "com/obric/memorydata/middleware/impl/phoneassistant/PhoneAssistantHelper$assistantExitBroadcastReceiver$1", "Lcom/obric/memorydata/middleware/impl/phoneassistant/PhoneAssistantHelper$assistantExitBroadcastReceiver$1;", "assistantInvokeBroadcastReceiver", "com/obric/memorydata/middleware/impl/phoneassistant/PhoneAssistantHelper$assistantInvokeBroadcastReceiver$1", "Lcom/obric/memorydata/middleware/impl/phoneassistant/PhoneAssistantHelper$assistantInvokeBroadcastReceiver$1;", "registerAssistantExitBroadcastReceiver", "unregisterAssistantExitBroadcastReceiver", "registerAssistantInvokeBroadcastReceiver", "unregisterAssistantInvokeBroadcastReceiver", "addAssistantExitListener", "listener", "removeAssistantExitListener", "addAssistantInvokeListener", "removeAssistantInvokeListener", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhoneAssistantHelper implements IPhoneAssistantHelper {
    private static final String ASSISTANT_EXIT_ACTION = "action_obric_assistant_exit";
    private static final String ASSISTANT_INVOKE_ACTION = "action_obric_assistant_invoke";
    public static final PhoneAssistantHelper INSTANCE = null;
    private static final String TAG = "PhoneAssistantHelper";
    private static final a assistantExitBroadcastReceiver = null;
    private static final ConcurrentHashMap.KeySetView<Function0<Unit>, Boolean> assistantExitListenerSet = null;
    private static final b assistantInvokeBroadcastReceiver = null;
    private static final ConcurrentHashMap.KeySetView<Function0<Unit>, Boolean> assistantInvokeListenerSet = null;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/middleware/impl/phoneassistant/PhoneAssistantHelper$assistantExitBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends PluginBroadcastReceiver {
        a() {
        }

        private static final void a() {
            ConcurrentHashMap.KeySetView r0 = PhoneAssistantHelper.access$getAssistantExitListenerSet$p();
            Intrinsics.checkNotNullExpressionValue(r0, "access$getAssistantExitListenerSet$p(...)");
            Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((Function0) ZeusTransformUtils.preCheckCast(r1.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();
            goto L4
        }

        /* JADX INFO: renamed from: lambda$_E_p79-XWRUPpLefGfvlbTDSaaw, reason: not valid java name */
        public static /* synthetic */ void m1033lambda$_E_p79XWRUPpLefGfvlbTDSaaw() {
            a();
        }

        public void onReceive(Context r7, Intent r8) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PhoneAssistantHelper.TAG, "onReceive AssistantExitBroadcast", false, 4, null);
            ThreadPoolContainer.Companion.getInstance().execute($$Lambda$PhoneAssistantHelper$a$_E_p79XWRUPpLefGfvlbTDSaaw.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/middleware/impl/phoneassistant/PhoneAssistantHelper$assistantInvokeBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends PluginBroadcastReceiver {
        b() {
        }

        private static final void a() {
            ConcurrentHashMap.KeySetView r0 = PhoneAssistantHelper.access$getAssistantInvokeListenerSet$p();
            Intrinsics.checkNotNullExpressionValue(r0, "access$getAssistantInvokeListenerSet$p(...)");
            Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((Function0) ZeusTransformUtils.preCheckCast(r1.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();
            goto L4
        }

        public static /* synthetic */ void lambda$1igUEag_TQzbup3_609tGWJQ7Kk() {
            a();
        }

        public void onReceive(Context r7, Intent r8) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), PhoneAssistantHelper.TAG, "onReceive AssistantInvokeBroadcast", false, 4, null);
            ThreadPoolContainer.Companion.getInstance().execute($$Lambda$PhoneAssistantHelper$b$1igUEag_TQzbup3_609tGWJQ7Kk.INSTANCE);
        }
    }

    static {
        INSTANCE = new PhoneAssistantHelper();
        assistantExitListenerSet = ConcurrentHashMap.newKeySet();
        assistantInvokeListenerSet = ConcurrentHashMap.newKeySet();
        assistantExitBroadcastReceiver = new a();
        assistantInvokeBroadcastReceiver = new b();
    }

    private PhoneAssistantHelper() {
    }

    public static final /* synthetic */ ConcurrentHashMap.KeySetView access$getAssistantExitListenerSet$p() {
        return assistantExitListenerSet;
    }

    public static final /* synthetic */ ConcurrentHashMap.KeySetView access$getAssistantInvokeListenerSet$p() {
        return assistantInvokeListenerSet;
    }

    @JvmStatic
    public static final PhoneAssistantHelper getInst() {
        return INSTANCE;
    }

    private final void registerAssistantExitBroadcastReceiver() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        IntentFilter r1 = new IntentFilter(ASSISTANT_EXIT_ACTION);     // Catch: Throwable -> L5
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(assistantExitBroadcastReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, 2, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "registerAssistantExitBroadcastReceiver done.", false, 4, null);     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L14;
        RunLog.INSTANCE.error(TAG, "registerAssistantExitBroadcastReceiver error", r7);
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void registerAssistantInvokeBroadcastReceiver() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        IntentFilter r1 = new IntentFilter(ASSISTANT_INVOKE_ACTION);     // Catch: Throwable -> L5
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(assistantInvokeBroadcastReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, 2, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "registerAssistantInvokeBroadcastReceiver done.", false, 4, null);     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L14;
        RunLog.INSTANCE.error(TAG, "registerAssistantInvokeBroadcastReceiver error", r7);
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void unregisterAssistantExitBroadcastReceiver() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(assistantExitBroadcastReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "unregisterAssistantExitBroadcastReceiver done.", false, 4, null);     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L14;
        RunLog.INSTANCE.error(TAG, "unregisterAssistantExitBroadcastReceiver error", r7);
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void unregisterAssistantInvokeBroadcastReceiver() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(assistantInvokeBroadcastReceiver, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "unregisterAssistantInvokeBroadcastReceiver done.", false, 4, null);     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L14;
        RunLog.INSTANCE.error(TAG, "unregisterAssistantInvokeBroadcastReceiver error", r7);
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.memorydata.middleware.api.phoneassistant.IPhoneAssistantHelper
    public synchronized void addAssistantExitListener(Function0<Unit> r3) {
        monitor-enter(this);
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L8
        ConcurrentHashMap.KeySetView<Function0<Unit>, Boolean> r0 = assistantExitListenerSet;     // Catch: Throwable -> L8
        r0.add(r4);     // Catch: Throwable -> L8
        if (r0.size() != 1) goto L6;
        registerAssistantExitBroadcastReceiver();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.phoneassistant.IPhoneAssistantHelper
    public synchronized void addAssistantInvokeListener(Function0<Unit> r3) {
        monitor-enter(this);
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L8
        ConcurrentHashMap.KeySetView<Function0<Unit>, Boolean> r0 = assistantInvokeListenerSet;     // Catch: Throwable -> L8
        r0.add(r4);     // Catch: Throwable -> L8
        if (r0.size() != 1) goto L6;
        registerAssistantInvokeBroadcastReceiver();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.phoneassistant.IPhoneAssistantHelper
    public synchronized void removeAssistantExitListener(Function0<Unit> r3) {
        monitor-enter(this);
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L8
        ConcurrentHashMap.KeySetView<Function0<Unit>, Boolean> r0 = assistantExitListenerSet;     // Catch: Throwable -> L8
        r0.remove(r4);     // Catch: Throwable -> L8
        if (r0.size() != 0) goto L6;
        unregisterAssistantExitBroadcastReceiver();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.phoneassistant.IPhoneAssistantHelper
    public synchronized void removeAssistantInvokeListener(Function0<Unit> r3) {
        monitor-enter(this);
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L8
        ConcurrentHashMap.KeySetView<Function0<Unit>, Boolean> r0 = assistantInvokeListenerSet;     // Catch: Throwable -> L8
        r0.remove(r4);     // Catch: Throwable -> L8
        if (r0.size() != 0) goto L6;
        unregisterAssistantInvokeBroadcastReceiver();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
