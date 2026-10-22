package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ MemoryContextService a;

    public a(MemoryContextService r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r18) {
        com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r18;
        qo0.a.c("MemoryContextService", "requestMemoryData success");
        String r2 = ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.g) r1.data).a();
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L37;
        qo0.a.c("MemoryContextService", "requestMemoryData, have memory data");
        ko0.a r4 = (ko0.a) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.g) r1.data).a(), ko0.a.class);
        if (r4 == null) goto L39;
        ShelfInfo r5 = ShelfInfo.a(r4.b(), null, null, true, null, null, null, 983039);
        MemoryContextService r6 = this.a;
        int r7 = MemoryContextService.c;
        AnchorShelfContextService.modifyShelf$default((AnchorShelfContextService) r6.getOpenPlatformContext().getService(AnchorShelfContextService.class), r5, false, null, null, 14, null);
        final MemoryContextService r8 = this.a;
        r8.getClass();
        List<ShelfCardInfo> r9 = r5.cardInfoList;
        if (r9 == null) goto L28;
        Disposable r10 = r8.b;
        if (r10 != null) goto L26;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r11 = AnchorMiniAppDataContext.a.a();
        if (r11 == null) goto L27;
        n<ShelfInfo> r12 = r11.m618getShelfInfo();
        if (r12 == null) goto L27;
        Observable r13 = r12.a();
        if (r13 == null) goto L27;
        Disposable r14 = m.f(r13, new MemoryContextService$upgradeCardInfoList$1(r8));
        if (r14 == null) goto L27;
        r8.autoDispose(r14);
    L27:
        ArrayList r15 = new ArrayList();
        r8.b = Observable.fromIterable(r9).concatMap(new g(r8, r5)).subscribe(new h(r8, r15, r9, r5), i.a);
        goto L28
    L26:
        r10.dispose();
    L28:
        AnchorMiniAppAppLogContextService r16 = (AnchorMiniAppAppLogContextService) this.a.getOpenPlatformContext().getService(AnchorMiniAppAppLogContextService.class);
        ShelfMicroAppInfo r17 = r5.appInfo;
        if (r17 == null) goto L32;
        String r19 = r17.appId;
        if (r19 == null) goto L32;
    L33:
        String r20 = r5.entryPagePath;
        if (r20 != null) goto L36;
        r20 = "";
    L36:
        r16.reportSmallProgramAdd(r19, "", r20, "auto");
        return;
    L32:
        r19 = "";
        goto L33
    L39:
        return;
    L37:
        qo0.a.c("MemoryContextService", "requestMemoryData, have no memory data");
        return;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r3 = false;
        goto L9
    }
}
