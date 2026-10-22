package com.obric.aiproactive.ui.settings;

import com.obric.aiproactive.api.IProactiveService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\fR\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchServiceGateway;", "Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchGateway;", "serviceProvider", "Lkotlin/Function0;", "Lcom/obric/aiproactive/api/IProactiveService;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "readEnabled", "", "()Ljava/lang/Boolean;", "writeEnabled", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f6859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<IProactiveService> f6860b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchServiceGateway$Companion;", "", "<init>", "()V", "DB_READY_TIMEOUT_MS", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6859a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public f(Function0<? extends IProactiveService> r3) {
        Function0<IProactiveService> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "serviceProvider");
        this.f6860b = r4;
    }

    public /* synthetic */ f(Function0 r2, int r3, DefaultConstructorMarker r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$f$GD2JZ6byL3mAgtEmOlyZxSKKdQ.INSTANCE;
    L5:
        this(r5);
    }

    private static final IProactiveService b() {
        return (IProactiveService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IProactiveService.class), IProactiveService.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$GD2JZ6byL3mAgtEm-OlyZxSKKdQ, reason: not valid java name */
    public static /* synthetic */ IProactiveService m350lambda$GD2JZ6byL3mAgtEmOlyZxSKKdQ() {
        return b();
    }

    @Override // com.obric.aiproactive.ui.settings.e
    public Boolean a() {
        IProactiveService r2 = (IProactiveService) ZeusTransformUtils.preCheckCast(this.f6860b.invoke(), IProactiveService.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r2.isAiProactiveWakeUpEnabled());
    }

    @Override // com.obric.aiproactive.ui.settings.e
    public Object a(boolean r5, Continuation<? super Boolean> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        IProactiveService r4 = (IProactiveService) ZeusTransformUtils.preCheckCast(this.f6860b.invoke(), IProactiveService.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return Boxing.boxBoolean(false);
    L7:
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new ProactiveFeatureSwitchServiceGateway$writeEnabled$2(r5, r4, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }
}
