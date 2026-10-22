package com.lynx.tasm.ui.image;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f11042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f11044c;

    public g(i r5, Context r10, String r11) {
        this.f11044c = r5;
        this.f11042a = r10;
        this.f11043b = r11;
    }

    @Override // com.lynx.tasm.ui.image.b0
    public final void b(LynxError r10, int r11, int r12) {
        Context r5 = this.f11042a;
        if ((r5 instanceof LynxContext) == false) goto L26;
        LynxContext r13 = (LynxContext) r5;
        String r14 = this.f11043b;
        r13.f(r14, "image", r10);
        i r15 = this.f11044c;
        WeakReference r16 = r15.f11050i;
        if (r16 != null) goto L8;
        return;
    L8:
        if (r16.get() == null) goto L27;
        LynxBaseUI r17 = (LynxBaseUI) r15.f11050i.get();
        if (r17.getEvents() != null) goto L13;
        return;
    L13:
        if (r17.getEvents().containsKey("bgerror") == false) goto L25;
        com.lynx.animax.i r18 = new com.lynx.animax.i(r17.getSign(), "bgerror");
        StringBuilder r19 = new StringBuilder();
        String r20 = r10.f9993h;
        String r21 = "";
        if (r20 != null) goto L17;
        r20 = "";
    L17:
        r19.append(r20);
        r19.append(": ");
        String r22 = r10.f10000o;
        if (r22 == null) goto L21;
        r21 = r22;
    L21:
        r19.append(r21);
        r18.a("errMsg", r19.toString());
        r18.a("url", r14);
        r18.a("lynx_categorized_code", Integer.valueOf(r11));
        r18.a(WsConstants.ERROR_CODE, Integer.valueOf(r12));
        r13.g.b(r18);
        return;
    L25:
        return;
    L27:
        return;
    }

    @Override // com.lynx.tasm.ui.image.b0
    public final void d(int r5, int r10) {
        i r11 = this.f11044c;
        r11.e = r5;
        r11.f = r10;
        Context r12 = this.f11042a;
        if ((r12 instanceof LynxContext) == false) goto L15;
        WeakReference r13 = r11.f11050i;
        if (r13 != null) goto L7;
        return;
    L7:
        if (r13.get() == null) goto L19;
        LynxBaseUI r14 = (LynxBaseUI) r11.f11050i.get();
        if (r14.getEvents() != null) goto L12;
        return;
    L12:
        if (r14.getEvents().containsKey("bgload") == false) goto L18;
        com.lynx.animax.i r15 = new com.lynx.animax.i(r14.getSign(), "bgload");
        r15.a("height", Integer.valueOf(r10));
        r15.a("width", Integer.valueOf(r5));
        r15.a("url", this.f11043b);
        ((LynxContext) r12).g.b(r15);
        return;
    L18:
        return;
    L19:
        return;
    }
}
