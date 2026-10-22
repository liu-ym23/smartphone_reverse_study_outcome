package p82;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.message.model.bd;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r extends a {
    @Override // p82.a
    public final int e() {
        return 2131567224;
    }

    public r() {
        super(PanelItemSymbol.OPEN_MICROAPP_SYMBOL);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        com.bytedance.android.live.base.model.message.t r0 = r4.b;
        String r2 = null;
        if ((r0 instanceof bd) == true) goto L5;
        r0 = null;
    L5:
        bd r1 = (bd) r0;
        if (r1 == null) goto L8;
        com.bytedance.android.live.base.model.data.m r3 = r1.itemStyle;
    L10:
        if (com.bytedance.android.livesdk.interactivity.utils.s.a(r4) == false) goto L16;
        if (r3 == null) goto L14;
        r2 = r3.schema;
    L14:
        if (com.bytedance.android.livesdk.interactivity.utils.s.b(r2) == false) goto L16;
        return true;
    L16:
        return false;
    L8:
        r3 = null;
        goto L10
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r3) {
        super.onClick(r3);
        com.bytedance.android.livesdk.interactivity.api.entity.l r4 = this.b;
        com.bytedance.android.live.base.model.message.t r0 = null;
        if (r4 == null) goto L5;
        com.bytedance.android.live.base.model.message.t r5 = r4.b;
    L7:
        if ((r5 instanceof bd) == false) goto L10;
        r0 = r5;
    L10:
        bd r1 = (bd) r0;
        if (r1 == null) goto L22;
        com.bytedance.android.live.base.model.data.m r6 = r1.itemStyle;
        if (r6 == null) goto L24;
        String r7 = r6.schema;
        if (com.bytedance.android.livesdk.interactivity.utils.s.b(r7) == false) goto L18;
        com.bytedance.android.livesdk.interactivity.utils.s.d(r7);
    L18:
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r8 = this.c;
        if (r8 == null) goto L23;
        r8.dismissDialog();
        return;
    L23:
        return;
    L24:
        return;
    L22:
        return;
    L5:
        r5 = null;
        goto L7
    }
}
