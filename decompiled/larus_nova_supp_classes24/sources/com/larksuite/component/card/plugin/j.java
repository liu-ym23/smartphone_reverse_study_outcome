package com.larksuite.component.card.plugin;

import android.content.DialogInterface;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j implements DialogInterface.OnClickListener {
    public final /* synthetic */ j18.f<CallbackProcessResponse> a;
    public final /* synthetic */ Ref.ObjectRef<ILynxBridgeContext> b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Ref.ObjectRef<com.larksuite.component.card.cardcontainer.c> e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Map<String, String> g;
    public final /* synthetic */ Ref.ObjectRef<OPTrace> h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ String j;

    public j(j18.f r1, Ref.ObjectRef r2, String r3, Ref.ObjectRef r4, String r5, Map r6, Ref.ObjectRef r7) {
        this.a = r1;
        this.b = r2;
        this.c = "";
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = false;
        this.j = "input";
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r10, int r11) {
        this.a.callback(new CallbackProcessResponse());
        int r12 = k.a;
        k.b((ILynxBridgeContext) this.b.element, this.c, this.d, (com.larksuite.component.card.cardcontainer.c) this.e.element, this.f, this.g, (OPTrace) this.h.element, this.i, this.j);
    }
}
