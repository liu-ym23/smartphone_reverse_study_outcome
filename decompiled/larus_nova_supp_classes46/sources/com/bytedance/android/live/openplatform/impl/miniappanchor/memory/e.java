package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import android.content.Context;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.TextPosterHelper;
import com.bytedance.android.livesdk.utils.r2;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ MemoryContextService a;
    public final /* synthetic */ ShelfCardInfo b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Function1 d;

    public e(MemoryContextService r1, ShelfCardInfo r2, Function1 r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r51) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e r1 = (com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e) ((com.bytedance.android.live.network.response.e) r51).data;
        String r3 = null;
        if (r1.d() == false) goto L5;
        String r19 = this.b.F();
        String r22 = null;
    L6:
        int r2 = TextPosterHelper.a;
        ShelfCardInfo r4 = this.b;
        if (r4 == null) goto L9;
        ProductInfo r5 = r4.getProductInfo();
    L10:
        String r6 = TextPosterHelper.a(r5);
        if (r6 != null) goto L14;
        if (r4 == null) goto L16;
        r3 = r4.I();
    L16:
        if (r3 != null) goto L18;
        r3 = "";
    L18:
        final ShelfCardInfo r7 = ShelfCardInfo.g(this.b, null, null, null, null, false, null, 0, 0, null, null, null, 0, null, r19, null, r3, r22, 0, 0, 1610612735, 6);
        if (r2.a(r7.D()) == false) goto L22;
        this.c.invoke(ShelfCardInfo.g(r7, null, null, null, null, false, null, 0, 0, null, null, null, 0, null, null, null, null, null, 4, 0, -1, 5));
        return;
    L22:
        if (r2.a(r7.S()) == false) goto L24;
        this.c.invoke(ShelfCardInfo.g(r7, null, null, null, null, false, null, 0, 0, null, null, null, 0, null, null, null, null, null, 1, 0, -1, 5));
        return;
    L24:
        MemoryContextService r8 = this.a;
        int r9 = MemoryContextService.c;
        Context r10 = r8.getOpenPlatformContext().getContext();
        String r11 = r1.e();
        if (r11 != null) goto L27;
        r11 = "";
    L27:
        String r12 = r1.h();
        if (r12 != null) goto L30;
        String r13 = "";
    L31:
        TextPosterHelper.b(r10, r11, r3, r13, new MemoryContextService$upgradeCardInfoIfNeeded$1$1(this, r7), new MemoryContextService$upgradeCardInfoIfNeeded$1$2(this));
        return;
    L30:
        r13 = r12;
        goto L31
    L14:
        r3 = r6;
        goto L16
    L9:
        r5 = null;
        goto L10
    L5:
        r22 = this.b.F();
        r19 = null;
        goto L6
    }
}
