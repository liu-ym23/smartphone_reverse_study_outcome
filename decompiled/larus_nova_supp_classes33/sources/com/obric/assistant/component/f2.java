package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.assistant.voice.ObricVoiceServiceImpl$b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f2 implements Runnable {
    public final /* synthetic */ ObricIntercomComponent a;
    public final /* synthetic */ laa.n b;

    public /* synthetic */ f2(ObricIntercomComponent r1, laa.n r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricIntercomComponent r0 = this.a;
        laa.n r1 = this.b;
        int r2 = ObricIntercomComponent.h1;
        com.obric.assistant.view.listening.f r3 = r0.V3();
        com.obric.assistant.view.listening.b r4 = r3.d(r3.e);
        com.obric.assistant.view.listening.b r5 = r3.d(r1);
        if (r5 != null) goto L7;
        if (r4 != null) goto L6;
        r5 = new com.obric.assistant.view.listening.i(com.obric.assistant.view.listening.f.l.incrementAndGet());
        goto L7
    L6:
        r5 = r4;
    L7:
        boolean r6 = true;
        if (r4 != null) goto L10;
    L12:
        boolean r7 = false;
    L14:
        if ((r5 instanceof com.obric.assistant.view.listening.i) == false) goto L17;
        r6 = r7;
    L40:
        r3.c(r5, "loading_terminal");
        Intrinsics.checkNotNullParameter(r5, "handle");
        Set r8 = r0.O.entrySet();
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L42:
        if (r10.hasNext() == false) goto L46;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((Map.Entry) r11).getValue(), r5) == false) goto L42;
        r9.add(r11);
        goto L42
    L46:
        Iterator r12 = r9.iterator();
    L48:
        if (r12.hasNext() == false) goto L50;
        Map.Entry r13 = (Map.Entry) r12.next();
        r0.O.remove(r13.getKey(), r13.getValue());
        goto L48
    L50:
        ObricIntercomComponent$c r14 = r0.L;
        if (r14 == null) goto L53;
        laa.n r15 = r14.b;
    L55:
        if (Intrinsics.areEqual(r15, r5) == false) goto L57;
        r0.L = null;
    L57:
        if (r6 == false) goto L60;
        FLogger.a.i("OrionIntercomComponent", "ignore stale listening UI terminal");
        return;
    L60:
        if (r0.X == false) goto L62;
        ObricIntercomComponent.G4(r0, false, null, false, 6);
    L63:
        Function1 r16 = r0.S;
        if (r16 == null) goto L66;
        r16.invoke(Boolean.FALSE);
    L66:
        r0.T.invoke(Boolean.FALSE);
        return;
    L62:
        com.larus.utils.e1.o(r0.W3());
        goto L63
    L53:
        r15 = null;
        goto L55
    L17:
        if ((r5 instanceof com.obric.assistant.view.listening.a) == false) goto L69;
        IObricVoiceService.a.getClass();
        IObricVoiceService r17 = IObricVoiceService.a.a();
        if (r17 == null) goto L21;
        ObricVoiceServiceImpl$b r18 = r17.f();
    L22:
        com.obric.assistant.view.listening.b r19 = r3.e;
        if ((r19 instanceof com.obric.assistant.view.listening.a) == false) goto L25;
        com.obric.assistant.view.listening.a r20 = (com.obric.assistant.view.listening.a) r19;
    L26:
        if (r20 == null) goto L28;
        com.obric.assistant.voice.d r21 = r20.a;
    L29:
        if (r7 == true) goto L40;
        com.obric.assistant.view.listening.a r22 = (com.obric.assistant.view.listening.a) r5;
        if (r22.a.b() == true) goto L39;
        if (r21 != null) goto L34;
    L35:
        if (r18 == null) goto L39;
        if (Intrinsics.areEqual(r18, r22.a) == true) goto L39;
    L34:
        if (Intrinsics.areEqual(r21, r22.a) == false) goto L40;
    L39:
        r6 = false;
        goto L40
    L28:
        r21 = null;
        goto L29
    L25:
        r20 = null;
        goto L26
    L21:
        r18 = null;
        goto L22
    L69:
        throw new NoWhenBranchMatchedException();
    L10:
        if (Intrinsics.areEqual(r4, r5) == true) goto L12;
        r7 = true;
        goto L14
    }
}
