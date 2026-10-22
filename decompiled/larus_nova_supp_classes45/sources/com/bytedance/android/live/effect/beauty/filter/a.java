package com.bytedance.android.live.effect.beauty.filter;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements com.bytedance.android.live.effect.beauty.makeups.a.b {
    public final /* synthetic */ LiveComposerFilterAdapter a;

    @Override // com.bytedance.android.live.effect.beauty.makeups.a.b
    public final void onError() {
    }

    public a(LiveComposerFilterAdapter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.beauty.makeups.a.b
    public final void a(Sticker r5) {
        Intrinsics.checkNotNullParameter(r5, "sticker");
        Iterator r0 = ((ArrayList) this.a.a).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((Sticker) r0.next()).getResourceId(), r5.getResourceId()) == true) goto L10;
        r1 = r1 + 1;
    L10:
        int r6 = this.a.getItemCount();
        if (r1 < 0) goto L19;
        if (r6 <= r1) goto L18;
        this.a.notifyItemChanged(r1);
        return;
    L18:
        return;
    L19:
        return;
    L9:
        r1 = -1;
        goto L10
    }
}
