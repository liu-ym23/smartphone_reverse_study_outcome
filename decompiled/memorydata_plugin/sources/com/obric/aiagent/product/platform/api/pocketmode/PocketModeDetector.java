package com.obric.aiagent.product.platform.api.pocketmode;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.feature.b.a;
import com.obric.aiagent.product.platform.impl.pocketmode.GRPocketModeDetector;
import com.obric.aiagent.product.platform.impl.pocketmode.ObricPocketModeDetector;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J&\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\n*\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/aiagent/product/platform/api/pocketmode/PocketModeDetector;", "Lcom/obric/aiagent/product/platform/api/pocketmode/IPocketModeDetector;", "<init>", "()V", "TAG", "", "instance", "checkAsync", "", "isCheckPassed", "", "showProximityNearAlert", "onUserActionBlocked", "needVibrate", "isAppBackground", "showToastAction", "Lkotlin/Function0;", "awaitCheckPassed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CommonConsts.APM_INNER_EVENT_COST_INIT, "isPocketModeManuallyDismissed", "isPocketModeEnabled", "logAndReturn", "methodName", "defaultValue", "logErrorOnNull", "(Ljava/lang/Boolean;Ljava/lang/String;ZZ)Z", "hideProximityNearAlert", "isProximityNearAlertShowing", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PocketModeDetector implements IPocketModeDetector {
    public static final PocketModeDetector INSTANCE = null;
    private static final String TAG = "PocketModeDetector";
    private static IPocketModeDetector instance;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.api.pocketmode.PocketModeDetector$awaitCheckPassed$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiagent.product.platform.api.pocketmode.PocketModeDetector", f = "PocketModeDetector.kt", i = {}, l = {69}, m = "awaitCheckPassed", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PocketModeDetector this$0;

        AnonymousClass1(PocketModeDetector r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitCheckPassed((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        INSTANCE = new PocketModeDetector();
    L20:
        th = move-exception;
        d.f5954a.b(TAG, "init IPocketModeDetector failed", th);     // Catch: Throwable -> L24
    L22:
        instance = (IPocketModeDetector) ZeusTransformUtils.preCheckCast(f.a().a(IPocketModeDetector.class, false), IPocketModeDetector.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        d.f5954a.b(TAG, "IPocketModeDetector instance: " + instance);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        instance = null;
        d.f5954a.b(TAG, "init IPocketModeDetector failed", th);
        return;
    L4:
        if (a.f5977b.a().e() == false) goto L11;
        f.a().a(IPocketModeDetector.class, (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$PocketModeDetector$0GmwxbKgtNrM7icFvF9ndVED_54.INSTANCE), g.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
    L18:
        d.f5954a.b(TAG, "bind IPocketModeDetector isOs=" + a.f5977b.a().e());     // Catch: Throwable -> L20
    L7:
        th = th;
        d.b r4 = d.f5954a;     // Catch: Throwable -> L20
        String r5 = "bind ObricPocketModeDetector failed";
    L9:
        r4.b(TAG, r5, th);     // Catch: Throwable -> L20
        goto L18
    L11:
        if (Intrinsics.areEqual(a.f5977b.a().c(), "Genesis-R") == false) goto L13;
    L32:
        f.a().a(IPocketModeDetector.class, (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$PocketModeDetector$gvZdf8X5dEr5plY6MRQoBt5IgIg.INSTANCE), g.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
    L16:
        th = th;
        r4 = d.f5954a;     // Catch: Throwable -> L20
        r5 = "bind GRPocketModeDetector failed";
        goto L9
    L13:
        if (Intrinsics.areEqual(a.f5977b.a().c(), "Genesis-M") == false) goto L18;
        goto L18
    }

    private PocketModeDetector() {
    }

    private static final Object _init_$lambda$0() {
        return new ObricPocketModeDetector();
    }

    private static final Object _init_$lambda$1() {
        return new GRPocketModeDetector();
    }

    public static /* synthetic */ Object lambda$0GmwxbKgtNrM7icFvF9ndVED_54() {
        return _init_$lambda$0();
    }

    public static /* synthetic */ Object lambda$gvZdf8X5dEr5plY6MRQoBt5IgIg() {
        return _init_$lambda$1();
    }

    private final boolean logAndReturn(Boolean r2, String r3, boolean r4, boolean r5) {
        if (r2 != null) goto L9;
        String r6 = "instance?." + r3 + "() is null, return " + r4;
        d.b r7 = d.f5954a;
        if (r5 == false) goto L7;
        r7.d(TAG, r6);
    L8:
        return r4;
    L7:
        r7.b(TAG, r6);
        goto L8
    L9:
        d.f5954a.b(TAG, r3 + ": " + r2);
        return r2.booleanValue();
    }

    static /* synthetic */ boolean logAndReturn$default(PocketModeDetector r1, Boolean r2, String r3, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r5 = false;
    L9:
        return r1.logAndReturn(r2, r3, r4, r5);
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public Object awaitCheckPassed(Continuation<? super Boolean> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r7, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        PocketModeDetector this = (PocketModeDetector) ZeusTransformUtils.preCheckCast(r0.L$0, PocketModeDetector.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L19:
        Boolean r9 = (Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin");
    L22:
        return Boxing.boxBoolean(this.logAndReturn(r9, "awaitCheckPassed", true, true));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        IPocketModeDetector r10 = instance;
        if (r10 == null) goto L20;
        r0.L$0 = this;
        r0.label = 1;
        r8 = r10.awaitCheckPassed(r0);
        if (r8 != r2) goto L19;
        return r2;
    L20:
        r9 = null;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void checkAsync() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L6;
        r0.checkAsync();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void hideProximityNearAlert() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L6;
        r0.hideProximityNearAlert();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void init() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L6;
        r0.init();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isCheckPassed() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isCheckPassed());
    L7:
        return logAndReturn(r1, "isCheckPassed", true, true);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeEnabled() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isPocketModeEnabled());
    L7:
        return logAndReturn$default(this, r1, "isPocketModeEnabled", false, false, 6, null);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeManuallyDismissed() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isPocketModeManuallyDismissed());
    L7:
        return logAndReturn$default(this, r1, "isPocketModeManuallyDismissed", false, false, 6, null);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isProximityNearAlertShowing() {
        IPocketModeDetector r0 = instance;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isProximityNearAlertShowing();
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void onUserActionBlocked(boolean r2, boolean r3, Function0<Unit> r4) {
        Function0<Unit> r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "showToastAction");
        IPocketModeDetector r5 = instance;
        if (r5 == null) goto L6;
        r5.onUserActionBlocked(r2, r3, r1);
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void showProximityNearAlert() {
        IPocketModeDetector r0 = instance;
        if (r0 == null) goto L6;
        r0.showProximityNearAlert();
        return;
    }
}
