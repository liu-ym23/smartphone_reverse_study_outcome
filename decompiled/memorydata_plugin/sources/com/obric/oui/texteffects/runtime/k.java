package com.obric.oui.texteffects.runtime;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.Ext;
import com.obric.oui.texteffects.core.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\b\u0000\u0018\u00002\u00020\u0001Bn\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012K\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\u0010\u0011J\u001e\u0010#\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u0004\u0018\u00010(J\b\u0010)\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010*\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010+\u001a\u00020\rJ\b\u0010,\u001a\u0004\u0018\u00010\u0010J\u0010\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010/R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/obric/oui/texteffects/runtime/TextEffectRuntime;", "", "logTag", "", "onFrame", "Lkotlin/Function3;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "effectName", "", "playTimeMs", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "spec", "", "onFinished", "Lkotlin/Function1;", "Lcom/obric/oui/texteffects/runtime/TextEffectSession;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "durationScale", "", "getDurationScale", "()F", "setDurationScale", "(F)V", "isRunning", "", "()Z", "player", "Lcom/obric/oui/texteffects/runtime/TextEffectPlayer;", "reusableFrame", "Lcom/obric/oui/texteffects/runtime/ReusableTextEffectFrame;", "<set-?>", "session", "getSession", "()Lcom/obric/oui/texteffects/runtime/TextEffectSession;", "installForTest", LBSLightLocationTraceLogger.PREPARE, Ext.KEY_REQUEST, "Lcom/obric/oui/texteffects/runtime/TextEffectPlayRequest;", "sampleImmutable", "Lcom/obric/oui/texteffects/runtime/TextEffectFrame;", "sampleReusable", "seek", "startPrepared", "stop", "updateFinalText", "finalText", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3<String, Long, u, Unit> f14706b;
    private final Function1<l, Unit> c;
    private final j d;
    private final f e;
    private l f;
    private float g;

    public k(String r3, Function3<? super String, ? super Long, ? super u, Unit> r4, Function1<? super l, Unit> r5) {
        Function3<String, Long, u, Unit> r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Function1<l, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "logTag");
        Intrinsics.checkNotNullParameter(r6, "onFrame");
        Intrinsics.checkNotNullParameter(r7, "onFinished");
        this.f14705a = r3;
        this.f14706b = r6;
        this.c = r7;
        this.d = new j(r3);
        this.e = new f(0, 1, null);
        this.g = 1.0f;
    }

    public static final /* synthetic */ Function3 a(k r0) {
        return r0.f14706b;
    }

    public static final /* synthetic */ void a(k r0, l r1) {
        r0.f = r1;
    }

    public static final /* synthetic */ Function1 b(k r0) {
        return r0.c;
    }

    public final l a() {
        return this.f;
    }

    public final l a(i r10) {
        Intrinsics.checkNotNullParameter(r10, Ext.KEY_REQUEST);
        if (r10.c() == true) goto L5;
        this.d.a();
    L5:
        l r0 = new l(r10.a(), r10.b(), r10.d(), 0, 8, null);
        this.f = r0;
        return r0;
    }

    public final void a(float r1) {
        this.g = r1;
    }

    public final void a(long r7) {
        l r6 = this.f;
        if (r6 != null) goto L5;
        return;
    L5:
        r6.a(RangesKt.coerceIn(r7, 0, RangesKt.coerceAtLeast(r6.a().b(), 1)));
    }

    public final void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        l r2 = this.f;
        if (r2 == null) goto L7;
        r2.a(r4);
        return;
    }

    public final void b() {
        final l r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        this.d.a(r0.a(), this.g, (Function1) ZeusTransformUtils.preCheckCast(new TextEffectRuntime$startPrepared$1(r0, this), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new TextEffectRuntime$startPrepared$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public final l c() {
        this.d.a();
        l r0 = this.f;
        this.f = null;
        return r0;
    }

    public final f d() {
        l r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return m.f14709a.a(r0.a(), r0.d(), this.e);
    }
}
