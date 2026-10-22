package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.livesdk.message.model.el;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import xp0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/CoexistAnchorShelfDisplayViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/BaseAnchorShelfDisplayViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/b;", "source", "", "", "buildDisplayItemInfoList", "", "hasReportedBannerShow", "Z", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CoexistAnchorShelfDisplayViewModel extends BaseAnchorShelfDisplayViewModel {
    private boolean hasReportedBannerShow;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ShelfCardInfo) r1).U()), Integer.valueOf(((ShelfCardInfo) r2).U()));
        }
    }

    public CoexistAnchorShelfDisplayViewModel() {
    }

    public List<Object> buildDisplayItemInfoList(b r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        List<Object> r0 = super.buildDisplayItemInfoList(r7);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.O3.getValue()).booleanValue() == false) goto L16;
        r0.add(new d());
        if (this.hasReportedBannerShow == true) goto L16;
        this.hasReportedBannerShow = true;
        OpenPlatformContext r1 = getMiniAppAnchorService().a();
        if (r1 == null) goto L16;
        AnchorMiniAppAppLogContextService r2 = (AnchorMiniAppAppLogContextService) r1.getService(AnchorMiniAppAppLogContextService.class);
        if (r2 == null) goto L16;
        ShelfMicroAppInfo r3 = (ShelfMicroAppInfo) getShelfMicroAppInfo().getValue();
        if (r3 == null) goto L14;
        String r4 = r3.appId;
        if (r4 == null) goto L14;
    L15:
        r2.reportCoexistShelfDisplayDialogBannerShow(r4);
    L14:
        r4 = "";
    L16:
        List<ShelfCardInfo> r5 = r7.a;
        el r8 = r7.b;
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.d r6 = buildTopTradeData(r5, r8);
        if (r6 == null) goto L19;
        r0.add(r6);
    L19:
        List r9 = CollectionsKt.sortedWith(r5, new a());
        r0.add(new yp0.b(s1.B(2131920410), 0));
        r0.add(convertToDisplayCardInfo((ShelfCardInfo) ListProtector.get(r9, 0), r8));
        if (r9.size() <= 1) goto L26;
        r0.add(new yp0.b(s1.B(2131920411), UtilityKotlinExtentionsKt.i(8)));
        List r10 = CollectionsKt.minus(r9, ListProtector.get(r9, 0));
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        r11.add(convertToDisplayCardInfo((ShelfCardInfo) r12.next(), r8));
        goto L23
    L25:
        r0.addAll(r11);
    L26:
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public /* bridge */ /* synthetic */ List buildDisplayItemInfoList(com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.a r1) {
        return buildDisplayItemInfoList((b) r1);
    }
}
