package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.CoexistAnchorShelfDisplayViewModel;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/CoexistAnchorShelfDisplayDialog;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/BaseAnchorShelfDisplayDialog;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CoexistAnchorShelfDisplayDialog extends BaseAnchorShelfDisplayDialog {
    public static final /* synthetic */ int p = 0;
    public final a o;

    public static final class a implements xp0.a {
        public final /* synthetic */ CoexistAnchorShelfDisplayDialog a;

        @Override // xp0.a
        public final void onClose() {
            CoexistAnchorShelfDisplayDialog r0 = this.a;
            int r1 = CoexistAnchorShelfDisplayDialog.p;
            MultiTypeAdapter r2 = r0.V90();
            List r3 = r2.a;
            Iterator r4 = r3.iterator();
            int r5 = 0;
        L4:
            if (r4.hasNext() == false) goto L9;
            if ((r4.next() instanceof xp0.d) == true) goto L10;
            r5 = r5 + 1;
        L10:
            if (r5 == (-1)) goto L24;
            ListProtector.remove(r3, r5);
            r2.notifyItemRemoved(r5);
            com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.O3;
            Boolean r7 = Boolean.FALSE;
            r6.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r6, r7);
            OpenPlatformContext r8 = this.a.ca0().a();
            if (r8 == null) goto L25;
            AnchorMiniAppAppLogContextService r9 = (AnchorMiniAppAppLogContextService) r8.getService(AnchorMiniAppAppLogContextService.class);
            if (r9 == null) goto L26;
            ShelfMicroAppInfo r10 = (ShelfMicroAppInfo) this.a.W90().getShelfMicroAppInfo().getValue();
            if (r10 == null) goto L19;
            String r11 = r10.appId;
            if (r11 == null) goto L19;
        L20:
            r9.reportCoexistShelfDisplayDialogBannerClick(r11);
            return;
        L19:
            r11 = "";
            goto L20
        L26:
            return;
        L25:
            return;
        L24:
            return;
        L9:
            r5 = -1;
            goto L10
        }

        public a(CoexistAnchorShelfDisplayDialog r1) {
            this.a = r1;
        }
    }

    public CoexistAnchorShelfDisplayDialog() {
        this.o = new a(this);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final CommonShelfDisplayViewModel Z90() {
        return (CoexistAnchorShelfDisplayViewModel) ViewModelProviders.of(this).get(CoexistAnchorShelfDisplayViewModel.class);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.BaseAnchorShelfDisplayDialog
    public final void da0() {
        super.da0();
        V90().z2(xp0.d.class, new xp0.b(this.o));
        V90().z2(yp0.b.class, new yp0.a());
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.BaseAnchorShelfDisplayDialog, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.AnchorShelfDisplayItemViewHolder.c
    public final void l50(int r29, long r30) {
        super.l50(r29, r30);
        if (r29 != 3) goto L34;
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r1 = MiniAppDataContext.a.b();
        if (r1 == null) goto L32;
        List<ShelfCardInfo> r0 = r1.cardInfoList;
        if (r0 == null) goto L19;
        List<ShelfCardInfo> r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L20;
        ShelfCardInfo r5 = (ShelfCardInfo) r4.next();
        if (r5.getCardId() != r30) goto L15;
        ShelfCardInfo r6 = ShelfCardInfo.g(r5, null, null, null, null, false, null, 0, 0, null, null, null, 2, null, null, null, null, null, 0, 0, -33554433, 7);
    L18:
        r3.add(r6);
        goto L10
    L15:
        if (r5.p0() == 0) goto L17;
        r5 = ShelfCardInfo.g(r5, null, null, null, null, false, null, 0, 0, null, null, null, 0, null, null, null, null, null, 0, 0, -33562625, 7);
    L17:
        r6 = r5;
    L20:
        ShelfInfo r10 = ShelfInfo.a(r1, null, r3, false, null, null, null, 1048573);
        OpenPlatformContext r7 = ca0().a();
        if (r7 == null) goto L26;
        AnchorShelfContextService r9 = (AnchorShelfContextService) r7.getService(AnchorShelfContextService.class);
        if (r9 == null) goto L26;
        AnchorShelfContextService.modifyShelf$default(r9, r10, false, null, new CoexistAnchorShelfDisplayDialog$onExplainButtonClick$1(this), 4, null);
    L26:
        OpenPlatformContext r8 = ca0().a();
        if (r8 == null) goto L38;
        AnchorMiniAppAppLogContextService r11 = (AnchorMiniAppAppLogContextService) r8.getService(AnchorMiniAppAppLogContextService.class);
        if (r11 == null) goto L39;
        r11.reportAnchorStartExplain(true);
        return;
    L39:
        return;
    L38:
        return;
    L19:
        r3 = null;
        goto L20
    L32:
        return;
    }
}
