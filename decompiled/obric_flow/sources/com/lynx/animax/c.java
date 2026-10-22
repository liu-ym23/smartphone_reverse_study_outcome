package com.lynx.animax;

import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.ui.ObjectPosition;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements hm.a, pn.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f9586b;

    public /* synthetic */ c(String r5, int r10) {
        this.f9585a = r10;
        this.f9586b = r5;
    }

    @Override // pn.g
    public HashMap a() {
        String r5 = this.f9586b;
        switch(this.f9585a) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        HashMap r10 = new HashMap();
        r10.put("component_name", r5);
        return r10;
    L6:
        int r11 = UIAnimaX.f9557p;
        HashMap r12 = new HashMap();
        r12.put("component_name", "animax-view");
        r12.put("src", r5);
        return r12;
    }

    @Override // hm.a
    public void a(AnimaXPlayer r5) {
        String r10 = this.f9586b;
        switch(this.f9585a) {
            case 0: goto L20;
            case 1: goto L18;
            default: goto L4;
        };
    L4:
        int r11 = UIAnimaX.f9557p;
        ObjectPosition r12 = ObjectPosition.f9707a;
        if (OpenPageMethod.ALIGN_LEFT.equals(r10) == false) goto L8;
        r12 = ObjectPosition.f9708b;
    L16:
        r5.setObjectPosition(r12);
        return;
    L8:
        if ("right".equals(r10) == false) goto L11;
        r12 = ObjectPosition.f9709c;
        goto L16
    L11:
        if ("top".equals(r10) == false) goto L14;
        r12 = ObjectPosition.d;
        goto L16
    L14:
        if ("bottom".equals(r10) == false) goto L16;
        r12 = ObjectPosition.e;
        goto L16
    L18:
        int r13 = UIAnimaX.f9557p;
        r5.f = !"none".equals(r10);
        return;
    L20:
        int r14 = UIAnimaX.f9557p;
        ObjectFit r15 = ObjectFit.f9706c;
        if ("cover".equals(r10) == false) goto L24;
        r15 = ObjectFit.f9705b;
    L32:
        r5.setObjectFit(r15);
        return;
    L24:
        if ("center".equals(r10) == false) goto L27;
        r15 = ObjectFit.f9704a;
        goto L32
    L27:
        if ("fill".equals(r10) == false) goto L30;
        r15 = ObjectFit.d;
        goto L32
    L30:
        if ("scale-down".equals(r10) == false) goto L32;
        r15 = ObjectFit.e;
        goto L32
    }
}
