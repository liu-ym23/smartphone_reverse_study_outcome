package com.bytedance.android.livesdk.dslservice.slice;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.template.JsonTemplate;
import com.bytedance.android.livesdk.dslservice.util.o;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SliceViewUtilsKt {
    public static final void b(r r8, String r9, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r8, "$this$dispatchAction");
        Intrinsics.checkNotNullParameter(r9, LiveEndPageData.TAG_NAME);
        BaseSlcViewManager r0 = r8.b.f;
        Map r1 = null;
        if (r0 == null) goto L5;
        SlcElement r2 = r0.e;
    L6:
        if (r2 == null) goto L20;
        Map r3 = r2.getAction();
        if (r3 == null) goto L21;
        IAction r4 = (IAction) r3.get(r9);
        if (r4 == null) goto L22;
        Map r11 = r8.b.j;
        if ((r11 instanceof HashMap) == false) goto L15;
        r1 = r11;
    L15:
        HashMap r5 = (HashMap) r1;
        if (r5 == null) goto L18;
        r5.put("resp", r10);
    L18:
        SlcTemplateContext.e(r8.b, r4, r8.c, null, null, 16);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final void a(r r3, String r4, Map<String, ? extends Object> r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "$this$bindDataLive");
        final long r0 = System.currentTimeMillis();
        if (r5 != null) goto L7;
        if (r4 == null) goto L6;
        r5 = com.bytedance.android.livesdk.dsl.util.c.g(r4);
        goto L7
    L6:
        r5 = null;
    L7:
        if (r5 != null) goto L10;
        r5 = MapsKt.emptyMap();
    L10:
        if (r6 != 1) goto L23;
        Map r7 = r3.b.j;
        if (r7 == null) goto L17;
        Object r8 = r7.get("data");
        if (r8 == null) goto L17;
        Map<String, ? extends Object> r9 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r8);
    L18:
        if (r9 == null) goto L20;
        r9.putAll(r5);
    L20:
        if (r9 != null) goto L22;
        r5 = MapsKt.emptyMap();
        goto L23
    L22:
        r5 = r9;
    L17:
        r9 = null;
    L23:
        Map r10 = JsonTemplate.a.b(JsonTemplate.c, r5);
        r.a r11 = r.d;
        r3.a(r10, null);
        o.f.d(new SliceViewUtilsKt$bindDataLive$1(r0));
    }
}
