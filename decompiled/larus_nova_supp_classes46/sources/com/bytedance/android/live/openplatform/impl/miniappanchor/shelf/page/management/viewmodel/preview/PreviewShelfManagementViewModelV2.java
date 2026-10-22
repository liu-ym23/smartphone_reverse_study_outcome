package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.preview;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.coupon.AnchorCouponContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.memory.MemoryContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.ShelfManagementViewModelV2;
import com.bytedance.android.livesdk.sharedpref.b;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import np0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\nH\u0002J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/preview/PreviewShelfManagementViewModelV2;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/ShelfManagementViewModelV2;", "()V", "showOpenExplainCardGuide", "Landroidx/lifecycle/MutableLiveData;", "", "getShowOpenExplainCardGuide", "()Landroidx/lifecycle/MutableLiveData;", "checkDefaultTitleOrCover", "doNotCheckDefaultTitleOrCover", "", "fetchCouponEntranceInfo", "initData", "onPageFirstFrameShown", "openCouponPage", "context", "Landroid/content/Context;", "refreshMemoryAbilityStatus", "startLive", "activity", "Landroid/app/Activity;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewShelfManagementViewModelV2 extends ShelfManagementViewModelV2 {
    private final MutableLiveData<Boolean> showOpenExplainCardGuide;

    public final boolean checkDefaultTitleOrCover() {
        if (((Boolean) b.B3.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        ShelfInfo r0 = getShelfInfo();
        if (r0 == null) goto L31;
        List<ShelfCardInfo> r1 = r0.cardInfoList;
        if (r1 == null) goto L31;
        ShelfInfo r2 = getShelfInfo();
        if (r2 == null) goto L15;
        ShelfMicroAppInfo r3 = r2.appInfo;
        if (r3 == null) goto L15;
        String r4 = r3.name;
        if (r4 == null) goto L15;
    L16:
        Iterator<ShelfCardInfo> r5 = r1.iterator();
    L18:
        if (r5.hasNext() == false) goto L31;
        ShelfCardInfo r6 = r5.next();
        String r7 = r6.h();
        String r8 = r6.i(r4);
        Iterator<ShelfCardInfo> r9 = r1.iterator();
    L21:
        if (r9.hasNext() == false) goto L18;
        ShelfCardInfo r10 = r9.next();
        if (r6 == r10) goto L21;
        if (Intrinsics.areEqual(r7, r10.h()) == false) goto L21;
        if (Intrinsics.areEqual(r8, r10.i(r4)) == false) goto L21;
        return true;
    L15:
        r4 = "";
    L31:
        return false;
    }

    public final void doNotCheckDefaultTitleOrCover() {
        e r0 = b.B3;
        Boolean r1 = Boolean.FALSE;
        r0.getClass();
        f.d(r0, r1);
    }

    public PreviewShelfManagementViewModelV2() {
        this.showOpenExplainCardGuide = new MutableLiveData();
    }

    private final void fetchCouponEntranceInfo() {
        OpenPlatformContext r0 = getMiniAppAnchorService().a();
        if (r0 == null) goto L10;
        AnchorCouponContextService r1 = (AnchorCouponContextService) r0.getService(AnchorCouponContextService.class);
        if (r1 == null) goto L11;
        Disposable r2 = AnchorCouponContextService.f(r1, 2, new AnonymousClass1(this));
        if (r2 == null) goto L12;
        autoDispose(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void refreshMemoryAbilityStatus() {
        OpenPlatformContext r0 = getMiniAppAnchorService().a();
        if (r0 == null) goto L13;
        MemoryContextService r1 = (MemoryContextService) r0.getService(MemoryContextService.class);
        if (r1 == null) goto L14;
        ShelfMicroAppInfo r2 = getShelfAppInfo();
        if (r2 == null) goto L10;
        String r3 = r2.appId;
        if (r3 == null) goto L10;
    L11:
        r1.f(r3);
        return;
    L10:
        r3 = "";
        goto L11
    L14:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.ShelfManagementViewModelV2
    public void initData() {
        super.initData();
        fetchCouponEntranceInfo();
        fetchPrivateMsgData();
        refreshMemoryAbilityStatus();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.ShelfManagementViewModelV2
    public void onPageFirstFrameShown() {
        super.onPageFirstFrameShown();
        this.showOpenExplainCardGuide.setValue(Boolean.TRUE);
    }

    public final MutableLiveData<Boolean> getShowOpenExplainCardGuide() {
        return this.showOpenExplainCardGuide;
    }

    public final void openCouponPage(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        OpenPlatformContext r0 = getMiniAppAnchorService().a();
        String r1 = "";
        if (r0 == null) goto L14;
        AnchorCouponContextService r2 = (AnchorCouponContextService) r0.getService(AnchorCouponContextService.class);
        if (r2 == null) goto L14;
        String[] r3 = new String[1];
        ShelfInfo r4 = getShelfInfo();
        if (r4 == null) goto L12;
        ShelfMicroAppInfo r5 = r4.appInfo;
        if (r5 == null) goto L12;
        String r7 = r5.appId;
        if (r7 == null) goto L12;
    L13:
        r3[0] = r7;
        r2.h(r6, 2, CollectionsKt.arrayListOf(r3));
    L12:
        r7 = "";
    L14:
        OpenPlatformContext r8 = getMiniAppAnchorService().a();
        if (r8 == null) goto L26;
        AnchorMiniAppAppLogContextService r9 = (AnchorMiniAppAppLogContextService) r8.getService(AnchorMiniAppAppLogContextService.class);
        if (r9 == null) goto L27;
        ShelfMicroAppInfo r10 = getShelfAppInfo();
        if (r10 == null) goto L24;
        String r11 = r10.appId;
        if (r11 == null) goto L24;
        r1 = r11;
    L24:
        r9.reportCouponEntranceClick(r1, "shelf_setting_page");
        return;
    L27:
        return;
    }

    public final void startLive(Activity r32) {
        Intrinsics.checkNotNullParameter(r32, "activity");
        ShelfInfo r1 = getShelfInfo();
        if (r1 == null) goto L38;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r2 = AnchorMiniAppDataContext.a.a();
        ArrayList r3 = null;
        if (r2 == null) goto L9;
        n<ShelfInfo> r4 = r2.m618getShelfInfo();
        if (r4 == null) goto L9;
        ShelfInfo r5 = (ShelfInfo) r4.getValue();
    L11:
        if ((!Intrinsics.areEqual(r1, r5)) == false) goto L38;
        if (getMiniAppAnchorService().getMemoryStatus().b() == false) goto L33;
        List<ShelfCardInfo> r6 = r1.cardInfoList;
        if (r6 == null) goto L20;
        ShelfCardInfo r7 = (ShelfCardInfo) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L20;
        if (r7.getStatus() == 1) goto L33;
    L20:
        List<ShelfCardInfo> r8 = r1.cardInfoList;
        if (r8 == null) goto L32;
        List<ShelfCardInfo> r9 = r8;
        r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
        int r11 = 0;
    L24:
        if (r10.hasNext() == false) goto L32;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        ShelfCardInfo r14 = (ShelfCardInfo) r12;
        if (r11 != 0) goto L31;
        r14 = ShelfCardInfo.g(r14, null, null, null, null, false, null, 1, 0, null, null, null, 0, null, null, null, null, null, 0, 0, -8193, 7);
    L31:
        r3.add(r14);
        r11 = r13;
    L32:
        r1 = ShelfInfo.a(r1, null, r3, false, null, null, null, 1048573);
    L33:
        ShelfInfo r15 = r1;
        OpenPlatformContext r16 = getMiniAppAnchorService().a();
        if (r16 == null) goto L38;
        AnchorShelfContextService r17 = (AnchorShelfContextService) r16.getService(AnchorShelfContextService.class);
        if (r17 == null) goto L38;
        AnchorShelfContextService.modifyShelf$default(r17, r15, false, null, null, 14, null);
    L9:
        r5 = null;
    L38:
        a.a(false);
        getFinish().setValue(Boolean.TRUE);
    }

    public static final /* synthetic */ void access$addBusinessTool(PreviewShelfManagementViewModelV2 r0, bq0.a r1) {
        r0.addBusinessTool(r1);
    }
}
