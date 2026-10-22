package com.lynx.tasm;

import com.lynx.tasm.utils.CallStackUtil;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements fo.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10070c;

    public a0(LynxSubErrorCode$Level r5, String r10, List r11) {
        this.f10069b = r5;
        this.f10068a = r10;
        this.f10070c = r11;
    }

    @Override // fo.b
    public void a(String r5) {
        com.lynx.tasm.utils.j.f(new q(this, r5, CallStackUtil.a(new Throwable("Fetch template resource failed")), 4));
    }

    @Override // fo.b
    public void b(byte[] r5) {
        LynxTemplateRender r10 = (LynxTemplateRender) this.f10070c;
        if (LynxTemplateRender.a(r10) == null) goto L6;
        LynxTemplateRender.a(r10).getClass();
    L6:
        if (LynxTemplateRender.a(r10) == null) goto L8;
        LynxTemplateRender.a(r10).getClass();
    L8:
        r10.Q.j("prepareTemplateEnd");
        String r11 = this.f10068a;
        r10.J(r5, (TemplateData) this.f10069b, r11);
    }

    public a0(LynxTemplateRender r5, String r10, TemplateData r11) {
        this.f10070c = r5;
        this.f10069b = r11;
        this.f10068a = r10;
    }
}
