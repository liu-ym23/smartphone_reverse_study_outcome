package com.suite.lark.platform.component.widgetrenderinterceptor.interceptor;

import android.content.Context;
import com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor;
import com.suite.lark.platform.component.widgetrenderinterceptor.entity.BizInterceptorType;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CSAMImageRenderInterceptor implements IMBizImageRenderInterceptor {

    public static final class a {
    }

    static {
    }

    public CSAMImageRenderInterceptor() {
    }

    public final String toString() {
        return "CSAM interceptor";
    }

    @Override // com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor
    public final IMBizImageRenderInterceptor.Scene c() {
        return IMBizImageRenderInterceptor.Scene.BeforeRender;
    }

    @Override // com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor
    public BizInterceptorType getType() {
        return BizInterceptorType.CSAM_DELETE;
    }

    @Override // com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor
    public final Function0<Boolean> a(final Context r2, final IMBizImageRenderInterceptor.a r3, final kpc.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "targetProvider");
        Intrinsics.checkNotNullParameter(r4, "data");
        return new CSAMImageRenderInterceptor$interceptClick$1(this, r4, r3, r2);
    }

    @Override // com.suite.lark.platform.component.widgetrenderinterceptor.IMBizImageRenderInterceptor
    public final Function0<Boolean> b(final Context r8, final IMBizImageRenderInterceptor.a r9, final kpc.a r10, final IMBizImageRenderInterceptor.b r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "targetProvider");
        Intrinsics.checkNotNullParameter(r10, "data");
        return new CSAMImageRenderInterceptor$interceptRender$1(this, r10, r9, r8, r11);
    }
}
