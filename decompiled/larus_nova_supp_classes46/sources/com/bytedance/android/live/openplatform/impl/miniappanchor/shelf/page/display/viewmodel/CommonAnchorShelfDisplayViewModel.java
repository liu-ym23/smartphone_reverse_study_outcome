package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.d;
import com.bytedance.android.livesdk.message.model.el;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/CommonAnchorShelfDisplayViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/BaseAnchorShelfDisplayViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/b;", "source", "", "", "buildDisplayItemInfoList", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonAnchorShelfDisplayViewModel extends BaseAnchorShelfDisplayViewModel {
    public CommonAnchorShelfDisplayViewModel() {
    }

    public List<Object> buildDisplayItemInfoList(b r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        List<Object> r0 = super.buildDisplayItemInfoList(r5);
        List<ShelfCardInfo> r1 = r5.a;
        el r6 = r5.b;
        d r2 = buildTopTradeData(r1, r6);
        if (r2 == null) goto L5;
        r0.add(r2);
    L5:
        List<ShelfCardInfo> r3 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r7 = r3.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        r4.add(convertToDisplayCardInfo((ShelfCardInfo) r7.next(), r6));
        goto L7
    L9:
        r0.addAll(r4);
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public /* bridge */ /* synthetic */ List buildDisplayItemInfoList(com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.a r1) {
        return buildDisplayItemInfoList((b) r1);
    }
}
