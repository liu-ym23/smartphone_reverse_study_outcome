package com.bytedance.android.annie.business.lynx;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.business.container.AnnieXLiveFlowLoaderControl;
import com.bytedance.android.annie.business.container.AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1;
import com.bytedance.android.annie.business.container.AnnieXLiveHybridComponent;
import com.bytedance.android.annie.business.latch.l;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.lynx.h;
import com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import q26.j;
import y36.i;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends DefaultLynxDelegate {

    public static final class a {
    }

    static {
    }

    public final List<com.lynx.tasm.behavior.a> l() {
        List<com.lynx.tasm.behavior.a> r0 = super.l();
        BulletContext r1 = ((DefaultLynxDelegate) this).f;
        if (r1 != null) goto L37;
    L36:
        return r0;
    L37:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        Object r11 = Result.constructor-impl((z8.b) Annie.getService$default(z8.b.class, null, 2, null));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r11) == false) goto L12;
        r11 = null;
    L12:
        z8.b r12 = (z8.b) r11;
        if (r12 == null) goto L36;
        t36.d r13 = r1.e;
        if (r13 == null) goto L17;
        String r14 = (String) ((i) new p(r13, "annie_x_url", "")).b;
    L18:
        if (r14 != null) goto L20;
    L23:
        boolean r15 = true;
    L24:
        if (r15 == true) goto L36;
        Iterator<T> r16 = r12.M(r1.getContext(), r14).iterator();
    L27:
        if (r16.hasNext() == false) goto L36;
        Object r17 = r16.next();
        if ((r17 instanceof com.lynx.tasm.behavior.a) == false) goto L27;
        HybridLogger r18 = HybridLogger.a;
        HybridLogger.m("AnnieXLiveLynxDelegate", "add new custom behavior, name is " + r17 + ", url is " + r14, null, null, 12);
        if (TypeIntrinsics.isMutableList(r0) == false) goto L33;
        List r19 = r0;
    L34:
        if (r19 == null) goto L27;
        r19.add(r17);
        goto L27
    L33:
        r19 = null;
        goto L34
    L20:
        if (r14.length() == 0) goto L23;
        r15 = false;
        goto L24
    L17:
        r14 = null;
    L7:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final h m() {
        h r0 = s();
        r0.m = new com.bytedance.android.annie.business.lynx.a(getContext());
        return r0;
    }

    public final void g(LynxViewBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "viewBuilder");
        super.g(r10);
        Map r0 = c36.a.a;
        BulletContext r1 = ((DefaultLynxDelegate) this).f;
        l.a r11 = null;
        if (r1 == null) goto L5;
        String r12 = r1.getSessionId();
    L6:
        m16.b r13 = c36.a.a(r12);
        Object r14 = r13.c(IHybridComponent.class);
        if ((r14 instanceof AnnieXLiveHybridComponent) == false) goto L9;
        AnnieXLiveHybridComponent r15 = (AnnieXLiveHybridComponent) r14;
    L10:
        if (r15 != null) goto L12;
    L13:
        new CopyOnWriteArrayList();
    L14:
        AnnieXLiveContext r16 = (AnnieXLiveContext) r13.c(AnnieXLiveContext.class);
        if (r16 == null) goto L30;
        IAnnieBusinessLatchService.b r17 = r16.getLatchProcess();
        if ((r17 instanceof l.a) == false) goto L19;
        l.a r18 = (l.a) r17;
    L20:
        if (r18 == null) goto L28;
        List<com.bytedance.android.latch.a.c> r19 = r18.a();
        if (r19 == null) goto L28;
        Iterator<T> r20 = r19.iterator();
    L25:
        if (r20.hasNext() == false) goto L27;
        com.bytedance.android.latch.a.c r21 = (com.bytedance.android.latch.a.c) r20.next();
        r10.registerModule(r21.getName(), r21.a(), r21.getParams());
        goto L25
    L27:
        Unit r22 = Unit.INSTANCE;
    L29:
        if (r22 == null) goto L30;
        return;
    L28:
        r22 = null;
        goto L29
    L19:
        r18 = null;
    L30:
        AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1 r23 = AnnieXLiveFlowLoaderControl.a;
        BulletContext r24 = ((DefaultLynxDelegate) this).f;
        if (r24 == null) goto L33;
        String r25 = r24.getSessionId();
    L34:
        IAnnieBusinessLatchService.b r26 = AnnieXLiveFlowLoaderControl.a(String.valueOf(r25));
        if (r26 != null) goto L37;
        return;
    L37:
        if ((r26 instanceof l.a) == false) goto L39;
        r11 = (l.a) r26;
    L39:
        if (r11 == null) goto L52;
        List<com.bytedance.android.latch.a.c> r27 = r11.a();
        if (r27 == null) goto L53;
        Iterator<T> r28 = r27.iterator();
    L44:
        if (r28.hasNext() == false) goto L46;
        com.bytedance.android.latch.a.c r29 = (com.bytedance.android.latch.a.c) r28.next();
        r10.registerModule(r29.getName(), r29.a(), r29.getParams());
        goto L44
    L46:
        Unit r30 = Unit.INSTANCE;
        return;
    L53:
        return;
    L52:
        return;
    L33:
        r25 = null;
        goto L34
    L12:
        if (r15.q != null) goto L14;
    L9:
        r15 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    public final void j(LynxView r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        super.j(r10);
        BulletContext r0 = ((DefaultLynxDelegate) this).f;
        if (r0 == null) goto L7;
        boolean r11 = true;
        if (r0.G != true) goto L7;
    L8:
        if (r11 == false) goto L32;
        Map r1 = c36.a.a;
        l.a r12 = null;
        if (r0 == null) goto L12;
        String r13 = r0.getSessionId();
    L13:
        AnnieXLiveContext r14 = (AnnieXLiveContext) c36.a.a(r13).c(AnnieXLiveContext.class);
        if (r14 == null) goto L20;
        IAnnieBusinessLatchService.b r15 = r14.getLatchProcess();
        if (r15 == null) goto L18;
        r15.Y0(r10);
        Unit r16 = Unit.INSTANCE;
    L19:
        if (r16 == null) goto L20;
        return;
    L18:
        r16 = null;
    L20:
        AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1 r17 = AnnieXLiveFlowLoaderControl.a;
        BulletContext r18 = ((DefaultLynxDelegate) this).f;
        if (r18 == null) goto L23;
        String r19 = r18.getSessionId();
    L24:
        IAnnieBusinessLatchService.b r20 = AnnieXLiveFlowLoaderControl.a(String.valueOf(r19));
        if (r20 != null) goto L27;
        return;
    L27:
        if ((r20 instanceof l.a) == false) goto L29;
        r12 = (l.a) r20;
    L29:
        if (r12 == null) goto L35;
        r12.Y0(r10);
        Unit r21 = Unit.INSTANCE;
        return;
    L35:
        return;
    L23:
        r19 = null;
        goto L24
    L12:
        r13 = null;
        goto L13
    L32:
        return;
    L7:
        r11 = false;
        goto L8
    }

    public d(s26.a r10, j r11) {
        Intrinsics.checkNotNullParameter(r10, "service");
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r10, r11);
    }

    public d(s26.a r10, j r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "service");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        super(r10, r11, r12);
    }
}
