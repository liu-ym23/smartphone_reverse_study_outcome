package com.bytedance.android.livesdk.dslservice.slice;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.livesdk.dsl.recyclerview.i;
import com.bytedance.android.livesdk.dslservice.util.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.q;
import yt1.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends com.bytedance.android.livesdk.dslservice.a {
    public static final /* synthetic */ int g = 0;
    public r c;
    public com.bytedance.android.livesdk.dslservice.slice.action.a d;
    public final com.bytedance.android.ecom.arch.slice.render.r e;
    public final q f;

    public static final class a {
    }

    static {
    }

    @Override // yt1.k
    public final View getView() {
        return this.e.c;
    }

    @Override // yt1.k
    public final void release() {
        Function2<? super q, ? super k, Unit> r0 = this.a;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke(this.f, this);
    L6:
        if (((Boolean) n0.a.getValue()).booleanValue() == false) goto L9;
        this.c = null;
        this.d = null;
        return;
    }

    @Override // yt1.k
    public final void a(i r2) {
        com.bytedance.android.livesdk.dslservice.slice.action.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.b = r2;
        return;
    }

    public b(com.bytedance.android.ecom.arch.slice.render.r r2, q r3) {
        Intrinsics.checkNotNullParameter(r2, "sliceView");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.e = r2;
        this.f = r3;
    }

    @Override // yt1.k
    public final void b(au1.a r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "lifeType");
        r r0 = this.c;
        if (r0 != null) goto L5;
    L6:
        if (r8 == false) goto L18;
    L7:
        String r9 = r7.a;
        BaseSlcViewManager r10 = this.e.b.f;
        if (r10 == null) goto L10;
        SlcElement r11 = r10.e;
    L11:
        if (r11 == null) goto L19;
        Map r12 = r11.getAction();
        if (r12 == null) goto L20;
        IAction r1 = (IAction) r12.get(r9);
        if (r1 == null) goto L21;
        com.bytedance.android.ecom.arch.slice.render.r r13 = this.e;
        SlcTemplateContext r2 = r13.b;
        SlcTemplateContext.e(r2, r1, r13.c, r2.j, null, 24);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r11 = null;
        goto L11
    L18:
        return;
    L5:
        if (r0.b == true) goto L7;
        goto L6
    }

    @Override // yt1.k
    public final void c(String r4, Map<String, ? extends Object> r5, int r6) {
        long r0 = System.currentTimeMillis();
        SliceViewUtilsKt.a(this.e, r4, r5, r6);
        long r7 = System.currentTimeMillis() - r0;
        o.f.i(r7, this.f.a, "BindData");
    }
}
