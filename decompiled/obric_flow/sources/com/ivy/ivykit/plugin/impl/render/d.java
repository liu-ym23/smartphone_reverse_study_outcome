package com.ivy.ivykit.plugin.impl.render;

import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends vc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f9524a;

    public d(f r5) {
        this.f9524a = r5;
    }

    @Override // vc.b, vc.c
    public final void a(Map r5) {
        ol.c r10 = this.f9524a.f21519a;
    }

    @Override // vc.c
    public final void b(com.bytedance.ies.bullet.lynx.h r5) {
        if (this.f9524a.f9527c == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L7;
        LynxView r10 = r5.g;
    L8:
        if (r10 != null) goto L11;
        r10 = null;
    L11:
        if (r10 == null) goto L15;
        r10.reloadTemplate(TemplateData.c(null));
        return;
    L15:
        return;
    L7:
        r10 = null;
        goto L8
    }

    @Override // vc.b, vc.c
    public final void f(com.bytedance.ies.bullet.lynx.h r5) {
        Map<String, Object> r10 = null;
        if (r5 != null) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L14;
        final f r11 = this.f9524a;
        Function1<Object, Unit> r12 = new PluginView$load$1$lynxClient$1$onDataUpdated$1(r11);
        Intrinsics.checkNotNullParameter(r12, "callback");
        LynxView r13 = r5.g;
        if (r13 == null) goto L10;
        r10 = r13.getPageDataByKey(new String[]{"preserve_data"});
    L10:
        if (r10 == null) goto L12;
        r12.invoke(r10);
        return;
    L12:
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("getPageDataByKey Failed", LogLevel.d, "PreserveData");
        return;
    }
}
