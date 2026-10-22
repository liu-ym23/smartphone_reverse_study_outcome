package com.obric.aiproactive.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchCoordinator;", "", "gateway", "Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchGateway;", "<init>", "(Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchGateway;)V", "currentEnabled", "", "()Ljava/lang/Boolean;", "updateEnabled", "Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchUpdateResult;", "targetEnabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f6858a;

    public d(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "gateway");
        this.f6858a = r4;
    }

    public final Boolean a() {
        return this.f6858a.a();
    }

    public final Object a(boolean r7, Continuation<? super g> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ProactiveFeatureSwitchCoordinator$updateEnabled$1.class) == false) goto L7;
        ProactiveFeatureSwitchCoordinator$updateEnabled$1 r0 = (ProactiveFeatureSwitchCoordinator$updateEnabled$1) ZeusTransformUtils.preCheckCast(r9, ProactiveFeatureSwitchCoordinator$updateEnabled$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = r0.Z$0;
        d this = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L24:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L26;
        Boolean r6 = this.f6858a.a();
        boolean r11 = Intrinsics.areEqual(r6, Boxing.boxBoolean(r7));
        return new g(r6, r11, r11);
    L26:
        return new g(this.f6858a.a(), false, false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Boolean r12 = this.f6858a.a();
        if (r12 == null) goto L30;
        boolean r13 = r12.booleanValue();
        if (r13 == r7) goto L19;
        e r14 = this.f6858a;
        r0.L$0 = this;
        r0.Z$0 = r7;
        r0.label = 1;
        r10 = r14.a(r7, r0);
        if (r10 != r2) goto L24;
        return r2;
    L19:
        return new g(Boxing.boxBoolean(r13), true, false);
    L30:
        return new g(null, false, false);
    L7:
        r0 = new ProactiveFeatureSwitchCoordinator$updateEnabled$1(this, r9);
        goto L8
    }
}
