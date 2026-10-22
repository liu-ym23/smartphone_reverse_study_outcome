package h7;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends com.bytedance.android.anniex.base.lifecycle.a {
    public final b7.b a;

    public c(h8.c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void a(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        if (r11.getKitType() != KitType.LYNX) goto L5;
        IHybridComponent.HybridType r12 = IHybridComponent.HybridType.LYNX;
    L6:
        View r0 = r11.getKitView();
        if (r0 == null) goto L12;
        b7.b r1 = this.a;
        if (r1 == null) goto L13;
        r1.onAttachView(r0, r12, r11.getViewType());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r12 = IHybridComponent.HybridType.H5;
        goto L6
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void h(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.h(r10, r11);
        b7.b r12 = this.a;
        if (r12 == null) goto L6;
        r12.onLoadStart(r11.getKitView(), false);
        return;
    }
}
