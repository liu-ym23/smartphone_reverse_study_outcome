package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.n0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends pm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f9937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ReadableArray f9938c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ReadableMap e;
    public final /* synthetic */ Callback f;
    public final /* synthetic */ LynxUIMethodModule g;

    public q(LynxUIMethodModule r5, com.lynx.tasm.behavior.f r10, String r11, ReadableArray r12, String r13, ReadableMap r14, Callback r15) {
        this.g = r5;
        this.f9937b = r11;
        this.f9938c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        super(r10);
    }

    @Override // pm.g
    public final void a() {
        String r5 = this.f9937b;
        if (r5.isEmpty() == false) goto L6;
        r5 = "-1";
    L6:
        LynxContext r10 = this.g.mLynxContext;
        Callback r11 = LynxUIMethodModule.access$000(this.f);
        n0 r12 = (n0) r10.f10147o.get();
        if (r12 == null) goto L50;
        LynxBaseUI r13 = r12.B(r5);
        StringBuilder r14 = new StringBuilder("component not found, nodes: ");
        ReadableArray r15 = this.f9938c;
        r14.append(r15.toString());
        r14.append(", method: ");
        String r16 = this.d;
        r14.append(r16);
        String r17 = r14.toString();
        ReadableMap r18 = this.e;
        if (r13 == null) goto L39;
        int r19 = 0;
    L12:
        if (r19 >= r15.size()) goto L39;
        String r20 = r15.getString(r19);
        if (r18 != null) goto L16;
    L22:
        boolean r21 = false;
    L24:
        if (r20.startsWith("#") == true) goto L29;
        if (r21 == true) goto L29;
        if (r11 == null) goto L51;
        r11.invoke(new Object[]{5, r20.concat(" not support, only support id selector currently")});
        return;
    L51:
        return;
    L29:
        String r22 = r20.substring(1);
        if (r21 == false) goto L32;
        r13 = n0.C(r20, r13);
    L33:
        if (r13 == null) goto L34;
        if (r13.getIdSelector() == null) goto L38;
        r13.getIdSelector().equals(r22);
    L38:
        r19 = r19 + 1;
        goto L12
    L34:
        r17 = "not found ".concat(r20);
        goto L39
    L32:
        r13 = n0.d(r22, r13);
        goto L33
    L16:
        if (r18.size() <= 0) goto L22;
        if (r18.hasKey("_isCallByRefId") == false) goto L22;
        if (r18.getBoolean("_isCallByRefId") == false) goto L22;
        r21 = true;
    L39:
        if (r13 == null) goto L42;
        com.lynx.tasm.behavior.utils.c.a(r13, r16, r18, r11);
        return;
    L42:
        if (r11 == null) goto L52;
        r11.invoke(new Object[]{2, r17});
        return;
    L52:
        return;
    }
}
