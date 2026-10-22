package com.obric.assistant.interaction.impl.event.processor.base;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl;
import gea.a;
import gea.b;
import gea.c;
import gea.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/obric/assistant/interaction/impl/event/processor/base/BaseProcessor;", "Lcom/obric/assistant/interaction/impl/event/processor/base/IEventProcessor;", "clazz", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "getClazz", "()Lkotlin/reflect/KClass;", "stateService", "Lcom/obric/assistant/interaction/impl/service/InteractionStateServiceImpl;", "getStateService", "()Lcom/obric/assistant/interaction/impl/service/InteractionStateServiceImpl;", "stateService$delegate", "Lkotlin/Lazy;", "scopeContext", "Lkotlin/coroutines/CoroutineContext;", "getScopeContext", "()Lkotlin/coroutines/CoroutineContext;", "scopeContext$delegate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope$delegate", "getTag", "", "getGetTag", "()Ljava/lang/String;", "getTag$delegate", "process", "", "event", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseProcessor implements IEventProcessor {
    private final KClass<?> clazz;
    private final Lazy getTag$delegate;
    private final Lazy scope$delegate;
    private final Lazy scopeContext$delegate;
    private final Lazy stateService$delegate;

    public static /* synthetic */ String a(BaseProcessor r0) {
        return getTag_delegate$lambda$3(r0);
    }

    public static /* synthetic */ CoroutineScope b(BaseProcessor r0) {
        return scope_delegate$lambda$2(r0);
    }

    public static /* synthetic */ InteractionStateServiceImpl c() {
        return stateService_delegate$lambda$0();
    }

    public static /* synthetic */ ExecutorCoroutineDispatcher d(BaseProcessor r0) {
        return scopeContext_delegate$lambda$1(r0);
    }

    private final String getGetTag() {
        return (String) this.getTag$delegate.getValue();
    }

    private final CoroutineScope getScope() {
        return (CoroutineScope) this.scope$delegate.getValue();
    }

    private final CoroutineContext getScopeContext() {
        return (CoroutineContext) this.scopeContext$delegate.getValue();
    }

    public final InteractionStateServiceImpl getStateService() {
        return (InteractionStateServiceImpl) this.stateService$delegate.getValue();
    }

    public CoroutineScope scope() {
        return getScope();
    }

    private static final InteractionStateServiceImpl stateService_delegate$lambda$0() {
        return InteractionStateServiceImpl.INSTANCE;
    }

    public final KClass<?> getClazz() {
        return this.clazz;
    }

    public BaseProcessor(KClass<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        this.clazz = r2;
        this.stateService$delegate = LazyKt.lazy(new a());
        this.scopeContext$delegate = LazyKt.lazy(new b(this));
        this.scope$delegate = LazyKt.lazy(new c(this));
        this.getTag$delegate = LazyKt.lazy(new d(this));
    }

    private static final String getTag_delegate$lambda$3(BaseProcessor r0) {
        String r1 = r0.clazz.getSimpleName();
        if (r1 != null) goto L6;
        return "BaseProcessor";
    L6:
        return r1;
    }

    private static final ExecutorCoroutineDispatcher scopeContext_delegate$lambda$1(BaseProcessor r2) {
        return w1.a(1, "ScopeContext with " + r2.clazz.getSimpleName());
    }

    private static final CoroutineScope scope_delegate$lambda$2(BaseProcessor r2) {
        return CoroutineScopeKt.CoroutineScope(r2.getScopeContext().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public void process(InteractionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        FLogger.a.d(getGetTag(), "process event: " + r5);
    }
}
