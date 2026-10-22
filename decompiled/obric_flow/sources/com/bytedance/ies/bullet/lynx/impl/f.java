package com.bytedance.ies.bullet.lynx.impl;

import com.bytedance.ai.ex.widget.WidgetView;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.bytedance.ies.bullet.core.a {
    public com.ivy.ivykit.plugin.impl.utils.b e;
    public final ArrayList f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f5665h;

    public f() {
        this.f = new ArrayList();
        this.g = new ArrayList();
        new ArrayList();
        this.f5665h = new ArrayList();
    }

    @Override // com.bytedance.ies.bullet.core.a
    public final void c() {
        super.c();
        LinkedHashMap r5 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r10 = this.d;
        if (r10 == null) goto L5;
        String r11 = r10.getSessionId();
    L6:
        rb.b r12 = cd.a.a(r11);
        LinkedHashMap r13 = this.f5270a;
        Iterator r14 = this.f.iterator();
    L8:
        if (r14.hasNext() == false) goto L11;
        ((com.ivy.ivykit.plugin.impl.utils.b) r14.next()).getClass();
        Intrinsics.checkNotNullParameter(r12, "providerFactory");
        Map r15 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appTheme", WidgetView.UI_MODE_LIGHT), TuplesKt.to("isOverSea", Boolean.FALSE), TuplesKt.to(WsConstants.KEY_APP_ID, 0)});
        r15.putAll(MapsKt.emptyMap());
        r13.putAll(r15);
        goto L8
    L11:
        if (this.e == null) goto L15;
        Intrinsics.checkNotNullParameter(r12, "providerFactory");
        Map r16 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appTheme", WidgetView.UI_MODE_LIGHT), TuplesKt.to("isOverSea", Boolean.FALSE), TuplesKt.to(WsConstants.KEY_APP_ID, 0)});
        r16.putAll(MapsKt.emptyMap());
        r13.putAll(r16);
        return;
    L15:
        return;
    L5:
        r11 = null;
        goto L6
    }
}
