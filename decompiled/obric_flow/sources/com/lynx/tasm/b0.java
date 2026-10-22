package com.lynx.tasm;

import android.content.Context;
import android.util.DisplayMetrics;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.CallStackUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends LynxContext {
    public final /* synthetic */ LynxTemplateRender N;

    public b0(LynxTemplateRender r5, Context r10, DisplayMetrics r11) {
        this.N = r5;
        super(r10, r11);
    }

    @Override // com.lynx.tasm.behavior.LynxContext
    public final void b(LynxError r5) {
        this.N.onErrorOccurred(r5);
    }

    public final void o(Exception r11) {
        boolean r5 = LynxTemplateRender.f10015m0;
        if (r11 != null) goto L6;
        LynxLog.b(4, "LynxTemplateRender", "receive null exception");
        return;
    L6:
        String r10 = CallStackUtil.a(r11);
        LynxError r12 = new LynxError(990100, r11.getMessage(), null, "error", -3, null, false);
        r12.f9999n = r10;
        r12.g = null;
        r12.e = null;
        this.N.onErrorOccurred(r12);
    }
}
