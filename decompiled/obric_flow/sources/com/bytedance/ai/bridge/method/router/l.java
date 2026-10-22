package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1.f f1964a;

    public l(o1.f r5) {
        this.f1964a = r5;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r5, Object r10, Object r11) {
        w0.f r12 = (w0.f) r5;
        boolean r13 = ((Boolean) r10).booleanValue();
        String r14 = (String) r11;
        Intrinsics.checkNotNullParameter(r14, "message");
        o1.f r15 = this.f1964a;
        if (r13 == false) goto L9;
        Intrinsics.checkNotNullParameter(AbsOpenPageMethodIDL.OpenPageResultModel.class, "<this>");
        BaseModel r16 = com.lynx.tasm.behavior.ui.utils.e.c(AbsOpenPageMethodIDL.OpenPageResultModel.class);
        AbsOpenPageMethodIDL.OpenPageResultModel r17 = (AbsOpenPageMethodIDL.OpenPageResultModel) r16;
        if (r12 == null) goto L7;
        String r18 = ((com.bytedance.ai.model.widgets.a) r12).f2331c;
    L8:
        r17.setViewId(r18);
        r17.setFloatingShowResult(StringsKt.toIntOrNull(r14));
        r15.b((ResultModel) r16, "");
    L11:
        return Unit.INSTANCE;
    L7:
        r18 = null;
        goto L8
    L9:
        r15.a(r14);
        goto L11
    }
}
