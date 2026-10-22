package com.bytedance.android.anniex.lite.task;

import android.app.Application;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import com.bytedance.android.anniex.ability.XBridgeHelper;
import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.engine.AnnieXLynxEngineManager;
import com.bytedance.android.anniex.optimize.UsageLynxOptimize;
import com.bytedance.android.anniex.utils.IAnnieXLatchService;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.navigator.NavigationModule;
import com.lynx.tasm.t;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1 implements FlowCollector<ra.a> {
    public final /* synthetic */ qa.b a;
    public final /* synthetic */ CoroutineScope b;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {"T", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Lkotlin/coroutines/Continuation;", "", "continuation", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "emit"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1", f = "AnnieXLynxEnginePreloadTask.kt", i = {0, 0, 0}, l = {136}, m = "emit", n = {"this", "_model", "engine"}, s = {"L$0", "L$1", "L$2"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1 this$0;

        public AnonymousClass1(AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1 r1, Continuation r10) {
            this.this$0 = r1;
            super(r10);
        }

        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1(qa.b r1, CoroutineScope r10) {
        this.a = r1;
        this.b = r10;
    }

    public final Object emit(Object r17, Continuation r18) {
        if ((r18 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r10 = (AnonymousClass1) r18;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r0 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        AnnieXLynxEngine r14 = (AnnieXLynxEngine) r10.L$2;
        ra.a r15 = (ra.a) r10.L$1;
        AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1 r16 = (AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1) r10.L$0;
        ResultKt.throwOnFailure(r0);
    L52:
        CoroutineScope r1 = r16.b;
        s26.d r19 = s26.d.c;
        v16.a r20 = s26.d.c.d(r15.c, v16.b.class);
        if ((r20 instanceof v16.a) == false) goto L55;
        v16.a r110 = r20;
    L57:
        if (h.u0() == true) goto L60;
        r110 = null;
    L60:
        if (r110 == null) goto L62;
        String r21 = r15.a;
        int r22 = v16.a.b;
        Intrinsics.checkNotNullParameter(r21, com.bytedance.android.ec.core.event.a.KEY_URL);
    L62:
        int r23 = c.a;
        throw null;
    L55:
        r110 = null;
        goto L57
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        ra.a r24 = (ra.a) r17;
        Application r25 = com.bytedance.ies.bullet.core.h.h.b;
        if (r25 == null) goto L68;
        if (r24 == null) goto L68;
        int r26 = com.bytedance.android.anniex.api.b.a;
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r24, "lynxModel");
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r24, "lynxModel");
        TraceEvent.beginSection("AnnieXApi:createLynxEngine");
        com.bytedance.android.monitorV2.lynx.jsb.a r27 = new com.bytedance.android.monitorV2.lynx.jsb.a(0);     // Catch: Throwable -> L64
        t r28 = r24.f.c(r24.g, r24.c, r24.t);     // Catch: Throwable -> L64
        TraceEvent.beginSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L64
        r28.registerModule(NavigationModule.NAME, NavigationModule.class, null);     // Catch: Throwable -> L64
        r28.registerModule("hybridMonitor", LynxViewMonitorModule.class, r27);     // Catch: Throwable -> L64
        com.bytedance.android.anniex.assemble.a r111 = com.bytedance.android.anniex.assemble.a.a;     // Catch: Throwable -> L64
        IAnnieXLatchService r112 = (IAnnieXLatchService) com.bytedance.android.anniex.assemble.a.g(r24.c, IAnnieXLatchService.class);     // Catch: Throwable -> L64
        if (r112 == null) goto L21;
        r112.Y();     // Catch: Throwable -> L64
    L21:
        TraceEvent.endSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L64
        MutableContextWrapper r113 = new MutableContextWrapper(r25.getApplicationContext());     // Catch: Throwable -> L64
        if (r24.n == false) goto L24;
        LynxBDXBridge r114 = XBridgeHelper.a(r113, r24, r28);     // Catch: Throwable -> L64
    L25:
        Resources r115 = r25.getResources();     // Catch: Throwable -> L64
        r28.setPresetMeasuredSpec(View.MeasureSpec.makeMeasureSpec(WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Throwable -> L64
        ra.b r29 = r24.f;     // Catch: Throwable -> L64
        float r116 = r29.x;     // Catch: Throwable -> L64
        if (r116 != 1.0f) goto L28;
        boolean r117 = true;
    L29:
        if (r117 == true) goto L44;
        int r118 = r29.l;     // Catch: Throwable -> L64
        if (r118 == (-1)) goto L33;
    L40:
        if (r118 == (-1)) goto L44;
        int r30 = r29.m;     // Catch: Throwable -> L64
        if (r30 == (-1)) goto L44;
        r28.setScreenSize((int) (r118 * r116), (int) (r30 * r116));     // Catch: Throwable -> L64
        goto L44
    L33:
        if (r29.m != (-1)) goto L40;
        Display r31 = i16.a.c(r25);     // Catch: Throwable -> L64
        if (r31 == null) goto L44;
        Point r32 = new Point();     // Catch: Exception -> L38 Throwable -> L64
        r31.getSize(r32);     // Catch: Exception -> L38 Throwable -> L64
        float r33 = r32.x;     // Catch: Exception -> L38 Throwable -> L64
        float r34 = r29.x;     // Catch: Exception -> L38 Throwable -> L64
        r28.setScreenSize((int) (r33 * r34), (int) (r32.y * r34));     // Catch: Exception -> L38 Throwable -> L64
    L38:
        e = move-exception;
        HybridLogger r35 = HybridLogger.a;     // Catch: Throwable -> L64
        HybridLogger.i("AnnieX", ": " + e, null, 12);     // Catch: Throwable -> L64
        Unit r36 = Unit.INSTANCE;     // Catch: Throwable -> L64
    L44:
        int r37 = UsageLynxOptimize.a;     // Catch: Throwable -> L64
        UsageLynxOptimize.a(r24.f, r28, r24.a);     // Catch: Throwable -> L64
        TraceEvent.endSection("LynxViewBuilderParams:toLynxEngineBuilder");     // Catch: Throwable -> L64
        com.bytedance.android.anniex.engine.c r38 = new com.bytedance.android.anniex.engine.c(0);     // Catch: Throwable -> L64
        if (r114 == null) goto L47;
        r38.a = r114;     // Catch: Throwable -> L64
    L47:
        r38.b = r27;     // Catch: Throwable -> L64
        AnnieXLynxEngine r39 = r38.a(r24.c, r113, r28, r24.g);     // Catch: Throwable -> L64
        AnnieXLynxEngineManager.a.d(r24.c, r24.g, r39);     // Catch: Throwable -> L64
        TraceEvent.endSection("AnnieXApi:createLynxEngine");
        qa.b r40 = this.a;
        r10.L$0 = this;
        r10.L$1 = r24;
        r10.L$2 = r39;
        r10.label = 1;
        r40.e.setValue(r39);
        Unit r41 = Unit.INSTANCE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r41 != r12) goto L51;
        return r12;
    L51:
        r16 = this;
        r15 = r24;
        goto L52
    L28:
        r117 = false;
        goto L29
    L24:
        r114 = null;
    L64:
        th = move-exception;
        TraceEvent.endSection("AnnieXApi:createLynxEngine");
        throw th;
    L68:
        return Unit.INSTANCE;
    L7:
        r10 = new AnonymousClass1(this, r18);
        goto L8
    }
}
