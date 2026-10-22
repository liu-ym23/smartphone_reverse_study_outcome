package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends SingleLineScrollElement {
    public final ElementType f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.f;
    }

    public c(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
        this.f = ElementType.Extend;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.SingleLineScrollElement, kp1.b
    public final /* bridge */ /* synthetic */ void h(lp1.b r1) {
        m((ip1.d) r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.SingleLineScrollElement
    public final void m(ip1.d r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        super.m(r4);
        if (r4.c < 2) goto L15;
        MoreMixSharePanelUtils r5 = MoreMixSharePanelUtils.INSTANCE;
        DataCenter r0 = this.e.getDataCenter();
        boolean r1 = false;
        if (r0 == null) goto L7;
        r1 = z.e(r0, false);
    L7:
        DataCenter r2 = this.e.getDataCenter();
        boolean r3 = true;
        if (r2 == null) goto L11;
        r3 = z.m(r2, true);
    L11:
        if (r5.isMoreMixShareMode(r1, r3) == false) goto L15;
        View r6 = this.a;
        if (r6 == null) goto L19;
        a1.o(r6, UtilityKotlinExtentionsKt.i(16));
        return;
    L19:
        return;
    L15:
        View r7 = this.a;
        if (r7 == null) goto L21;
        a1.o(r7, UtilityKotlinExtentionsKt.i(12));
        return;
    }
}
