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
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.ShelfManagementViewModel;
import com.bytedance.android.livesdk.sharedpref.b;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import np0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\bH\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/preview/PreviewShelfManagementViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/ShelfManagementViewModel;", "()V", "checkDefaultTitleOrCover", "", "checkNewShelf", "checkShelfModify", "doNotCheckDefaultTitleOrCover", "", "fetchCouponEntranceInfo", "initData", "shelfInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "openCouponPage", "context", "Landroid/content/Context;", "refreshMemoryAbilityStatus", "saveShelfModify", "onSuccess", "Lkotlin/Function0;", "startLive", "activity", "Landroid/app/Activity;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewShelfManagementViewModel extends ShelfManagementViewModel {
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

    public final boolean checkNewShelf() {
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        String r1 = null;
        if (r0 == null) goto L7;
        n<ShelfInfo> r2 = r0.m618getShelfInfo();
        if (r2 == null) goto L7;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
    L9:
        if (r3 == null) goto L11;
    L13:
        AnchorMiniAppDataContext r4 = AnchorMiniAppDataContext.a.a();
        if (r4 == null) goto L22;
        n<ShelfInfo> r5 = r4.m618getShelfInfo();
        if (r5 == null) goto L22;
        ShelfInfo r6 = (ShelfInfo) r5.getValue();
        if (r6 == null) goto L22;
        ShelfMicroAppInfo r7 = r6.appInfo;
        if (r7 == null) goto L22;
        String r8 = r7.appId;
    L23:
        ShelfInfo r9 = getShelfInfo();
        if (r9 == null) goto L29;
        ShelfMicroAppInfo r10 = r9.appInfo;
        if (r10 == null) goto L29;
        r1 = r10.appId;
    L29:
        if ((!Intrinsics.areEqual(r8, r1)) == false) goto L31;
        return true;
    L31:
        return false;
    L22:
        r8 = null;
        goto L23
    L11:
        if (getShelfInfo() == null) goto L13;
        return true;
    L7:
        r3 = null;
        goto L9
    }

    public final boolean checkShelfModify() {
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L7;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L7;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
    L9:
        return !Intrinsics.areEqual(r2, getShelfInfo());
    L7:
        r2 = null;
        goto L9
    }

    public final void doNotCheckDefaultTitleOrCover() {
        e r0 = b.B3;
        Boolean r1 = Boolean.FALSE;
        r0.getClass();
        f.d(r0, r1);
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

    public PreviewShelfManagementViewModel() {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.ShelfManagementViewModel
    public void initData(ShelfInfo r6) {
        if (r6 == null) goto L20;
        List<ShelfCardInfo> r0 = r6.cardInfoList;
        if (r0 != null) goto L6;
    L8:
        setShelfInfo(r6);
        setShelfAppInfo(r6.appInfo);
        getShelfCardInfo().setValue(r6.cardInfoList);
        MutableLiveData<Integer> r1 = getPageCount();
        List<ShelfCardInfo> r2 = r6.cardInfoList;
        int r3 = 0;
        if (r2 == null) goto L11;
        int r4 = r2.size();
    L12:
        r1.setValue(Integer.valueOf(r4));
        MutableLiveData<Boolean[]> r5 = getSelectedList();
        Integer r7 = (Integer) getPageCount().getValue();
        if (r7 != null) goto L15;
        r7 = 0;
    L15:
        int r8 = r7.intValue();
        Boolean[] r9 = new Boolean[r8];
    L16:
        if (r3 >= r8) goto L18;
        r9[r3] = Boolean.FALSE;
        r3 = r3 + 1;
        goto L16
    L18:
        r5.setValue(r9);
        fetchCouponEntranceInfo();
        fetchPrivateMsgData();
        refreshMemoryAbilityStatus();
        super.initData(r6);
        return;
    L11:
        r4 = 0;
        goto L12
    L6:
        if (r0.isEmpty() != true) goto L8;
    L20:
        ShelfManagementViewModel.offShelf$default(this, null, null, 3, null);
        getFinish().setValue(Boolean.TRUE);
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

    public final void saveShelfModify(final Function0<Unit> r9) {
        OpenPlatformContext r0 = getMiniAppAnchorService().a();
        if (r0 == null) goto L11;
        AnchorShelfContextService r1 = (AnchorShelfContextService) r0.getService(AnchorShelfContextService.class);
        if (r1 == null) goto L12;
        ShelfInfo r2 = getShelfInfo();
        if (r2 != null) goto L9;
        return;
    L9:
        AnchorShelfContextService.modifyShelf$default(r1, r2, false, new C03381(r9), null, 10, null);
        return;
    L12:
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

    public static final /* synthetic */ void access$addBusinessTool(PreviewShelfManagementViewModel r0, bq0.a r1) {
        r0.addBusinessTool(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void saveShelfModify$default(PreviewShelfManagementViewModel r0, Function0 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.saveShelfModify(r1);
    }
}
