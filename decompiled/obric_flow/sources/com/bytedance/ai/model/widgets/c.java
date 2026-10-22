package com.bytedance.ai.model.widgets;

import android.view.View;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    public final Lazy e;
    public final Lazy f;

    public c(AppletRuntime r5, final PageInfo r10) {
        Intrinsics.checkNotNullParameter(r5, "appletRuntime");
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        super(r5, r10);
        final int r11 = 0;
        this.e = LazyKt.lazy(new b(r10, this, r11));
        final int r12 = 1;
        this.f = LazyKt.lazy(new b(r10, this, r12));
    }

    @Override // com.bytedance.ai.model.widgets.a, w0.i
    public final void a(long r5, long r10) {
        w0.g r11 = (w0.g) this.f.getValue();
        if (r11 == null) goto L6;
        r11.a(r5, r10);
        return;
    }

    @Override // com.bytedance.ai.model.widgets.a, w0.g
    public final void b() {
        w0.g r5 = (w0.g) this.f.getValue();
        if (r5 == null) goto L6;
        r5.b();
        return;
    }

    @Override // w0.i
    public final View d() {
        w0.g r5 = (w0.g) this.f.getValue();
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.d();
    }

    @Override // w0.d
    public final m1.k i() {
        w0.g r5 = (w0.g) this.f.getValue();
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.i();
    }

    @Override // w0.k
    public final void onMessageToAIBridge(String r5, JsonObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        w0.g r11 = (w0.g) this.f.getValue();
        if (r11 == null) goto L6;
        r11.onMessageToAIBridge(r5, r10);
        return;
    }

    @Override // w0.k
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        w0.g r10 = (w0.g) this.f.getValue();
        if (r10 == null) goto L6;
        r10.a(r5);
        return;
    }

    @Override // com.bytedance.ai.model.widgets.a, w0.j
    public final View b(PageInfo r5, com.bytedance.ai.model.k r10, com.bytedance.ai.model.k r11) {
        Intrinsics.checkNotNullParameter(r5, "pageInfo");
        super.b(r5, null, null);
        Lazy r12 = this.e;
        if (((w0.j) r12.getValue()) == null) goto L9;
        w0.j r13 = (w0.j) r12.getValue();
        if (r13 != null) goto L7;
        return null;
    L7:
        return r13.b(r5, r10, r11);
    L9:
        String r14 = "Unable to create page, pageType=" + r5.getPageType();
        r11.invoke(r14);
        IllegalArgumentException r15 = new IllegalArgumentException(r14);
        String r16 = r15.getMessage();
        Intrinsics.checkNotNullParameter("AIPageDelegate", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L12;
        r17.e("AIPageDelegate", r16, r15);
    L12:
        return null;
    }

    @Override // m2.a
    public final m3.a d(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "groupId");
        w0.g r11 = (w0.g) this.f.getValue();
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.d(r5, r10);
    }
}
