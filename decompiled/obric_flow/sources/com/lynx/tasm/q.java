package com.lynx.tasm;

import com.lynx.tasm.behavior.LynxContext;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f10936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10937c;
    public final /* synthetic */ Object d;

    public /* synthetic */ q(Object r5, Serializable r10, Object r11, int r12) {
        this.f10935a = r12;
        this.d = r5;
        this.f10936b = r10;
        this.f10937c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10935a) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        LynxError r5 = new LynxError(10203, "Error occurred while fetching app bundle resource", "", "error");
        r5.f10000o = (String) this.f10936b;
        r5.g = null;
        r5.f9999n = (String) this.f10937c;
        ((LynxTemplateRender) ((a0) this.d).f10070c).onErrorOccurred(r5);
        return;
    L6:
        LynxError r10 = new LynxError(10203, "Error occurred while fetching app bundle resource", "", "error");
        r10.f10000o = (String) this.f10936b;
        r10.g = null;
        r10.f9999n = (String) this.f10937c;
        ((LynxTemplateRender) ((ug.d) this.d).g).onErrorOccurred(r10);
        return;
    L8:
        byte[] r11 = (byte[]) this.f10936b;
        TemplateData r12 = (TemplateData) this.f10937c;
        ((LynxTemplateRender) this.d).I(r11, r12);
        return;
    L10:
        byte[] r13 = (byte[]) this.f10936b;
        Map r14 = (Map) this.f10937c;
        ((LynxTemplateRender) this.d).L(r13, r14);
        return;
    L12:
        Iterator r15 = ((r) this.d).f.iterator();
    L14:
        if (r15.hasNext() == false) goto L40;
        d r16 = (d) r15.next();
        if ((r16 instanceof com.lynx.tasm.behavior.w) == false) goto L25;
        LynxContext r17 = (LynxContext) ((com.lynx.tasm.behavior.w) r16).f10806w.get();
        if (r17 == null) goto L25;
        u0 r18 = r17.K;
        if (r18 == null) goto L22;
        boolean r19 = r18.E;
    L23:
        if (r19 == false) goto L25;
    L22:
        r19 = false;
    L25:
        com.lynx.tasm.behavior.w r20 = (com.lynx.tasm.behavior.w) r16;
        if (r20.f10805v.size() == 0) goto L14;
        EventEmitter$LynxEventType r21 = EventEmitter$LynxEventType.f9957b;
        EventEmitter$LynxEventType r22 = (EventEmitter$LynxEventType) this.f10936b;
        if (r22 == r21) goto L39;
        if (r22 != EventEmitter$LynxEventType.f9956a) goto L14;
        String r23 = ((on.c) this.f10937c).f20780b;
        if ("scroll".equals(r23) == true) goto L39;
        if ("scrolltoupper".equals(r23) == true) goto L39;
        if ("scrolltolower".equals(r23) == false) goto L14;
    L39:
        com.lynx.tasm.utils.j.f(new com.lynx.tasm.behavior.v(r20, 0));
        goto L14
    }
}
