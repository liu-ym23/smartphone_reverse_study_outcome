package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.a;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingsInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.privatemsg.AnchorPrivateMsgContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.bytedance.android.livesdk.sharedpref.b;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bX\u0010YJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0004J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0004J\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u0018\u0010 \u001a\u00020\u00072\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001eJ\"\u0010#\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020!2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001eJ\"\u0010$\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001eH\u0016J$\u0010'\u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110%2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eH\u0016J\u0006\u0010(\u001a\u00020\u0003J\u0006\u0010)\u001a\u00020\u0007J\b\u0010*\u001a\u00020\u0007H\u0014J\t\u0010+\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H\u0096\u0001J\r\u0010/\u001a\u00020\u0007*\u00020,H\u0096\u0001R*\u00102\u001a\u0002002\u0006\u00101\u001a\u0002008\u0006@GX\u0086.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010:\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R.\u0010B\u001a\u0004\u0018\u00010A2\b\u00101\u001a\u0004\u0018\u00010A8\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030H8\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR#\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110%0H8\u0006¢\u0006\f\n\u0004\b\u0012\u0010J\u001a\u0004\bM\u0010LR\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00050H8\u0006¢\u0006\f\n\u0004\bN\u0010J\u001a\u0004\bO\u0010LR\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00050H8\u0006¢\u0006\f\n\u0004\bP\u0010J\u001a\u0004\bP\u0010LR#\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050Q0H8\u0006¢\u0006\f\n\u0004\bR\u0010J\u001a\u0004\bS\u0010LR)\u0010V\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\r0T0H8\u0006¢\u0006\f\n\u0004\bV\u0010J\u001a\u0004\bW\u0010L¨\u0006Z"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/ShelfManagementViewModel;", "Landroidx/lifecycle/ViewModel;", "", "", "position", "", "selected", "", "changeCardSelectedStatus", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "initData", "fetchPrivateMsgData", "Lbq0/a;", "businessToolModel", "addBusinessTool", "newExplainCard", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "shelfCardInfo", "openCardLandingPage", "editExplainCard", "startEditShelf", "finishEditShelf", "selectedAll", "unselectedAll", "isSelectedAll", "isSelectedExplainingCard", "selectCard", "unselectCard", "getSelectedCount", "Lkotlin/Function0;", "onSuccess", "batchDelete", "", "exitSource", "offShelf", "modifyShelfInfo", "", "cardInfoList", "saveSort", "getEnterTimes", "recordEnterTimes", "onCleared", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "Lso0/a;", "<set-?>", "miniAppAnchorService", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "isInLive$delegate", "Lkotlin/Lazy;", "isInLive", "()Z", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "getShelfInfo", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "setShelfInfo", "(Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;)V", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "shelfAppInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "getShelfAppInfo", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "setShelfAppInfo", "(Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;)V", "Landroidx/lifecycle/MutableLiveData;", "pageCount", "Landroidx/lifecycle/MutableLiveData;", "getPageCount", "()Landroidx/lifecycle/MutableLiveData;", "getShelfCardInfo", "finish", "getFinish", "isEditing", "", "selectedList", "getSelectedList", "", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/model/BusinessToolType;", "businessToolsData", "getBusinessToolsData", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShelfManagementViewModel extends ViewModel {
    private final /* synthetic */ a $$delegate_0;
    private final MutableLiveData<Map<BusinessToolType, bq0.a>> businessToolsData;
    private final MutableLiveData<Boolean> finish;
    private final MutableLiveData<Boolean> isEditing;
    private final Lazy isInLive$delegate;
    public so0.a miniAppAnchorService;
    private final MutableLiveData<Integer> pageCount;
    private final MutableLiveData<Boolean[]> selectedList;
    private ShelfMicroAppInfo shelfAppInfo;
    private final MutableLiveData<List<ShelfCardInfo>> shelfCardInfo;
    private ShelfInfo shelfInfo;

    public void autoDispose(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.$$delegate_0.a(r2);
    }

    public void dispose() {
        this.$$delegate_0.b();
    }

    public void initData(ShelfInfo r1) {
    }

    public final boolean isInLive() {
        return ((Boolean) this.isInLive$delegate.getValue()).booleanValue();
    }

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.$$delegate_0.c(r2);
    }

    public final void fetchPrivateMsgData() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L16;
        AnchorPrivateMsgContextService r2 = (AnchorPrivateMsgContextService) r1.getService(AnchorPrivateMsgContextService.class);
        if (r2 == null) goto L17;
        ShelfMicroAppInfo r3 = this.shelfAppInfo;
        if (r3 == null) goto L13;
        String r4 = r3.appId;
        if (r4 == null) goto L13;
    L14:
        AnchorPrivateMsgContextService.f(r2, r4);
        return;
    L13:
        r4 = "";
        goto L14
    L17:
        return;
    }

    public final void finishEditShelf() {
        this.isEditing.setValue(Boolean.FALSE);
        unselectedAll();
    }

    public final int getEnterTimes() {
        return ((Number) b.C3.getValue()).intValue();
    }

    public final so0.a getMiniAppAnchorService() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        return r0;
    }

    public final int getSelectedCount() {
        Boolean[] r0 = (Boolean[]) this.selectedList.getValue();
        int r1 = 0;
        if (r0 == null) goto L15;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r1 >= r2) goto L11;
        if (r0[r1].booleanValue() == false) goto L9;
        r3 = r3 + 1;
    L9:
        r1 = r1 + 1;
        goto L5
    L11:
        return r3;
    L15:
        return 0;
    }

    public final boolean isSelectedExplainingCard() {
        Boolean[] r0 = (Boolean[]) this.selectedList.getValue();
        if (r0 == null) goto L17;
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r3 >= r2) goto L17;
        int r6 = r4 + 1;
        if (r0[r3].booleanValue() == false) goto L16;
        List r5 = (List) this.shelfCardInfo.getValue();
        if (r5 == null) goto L16;
        ShelfCardInfo r7 = (ShelfCardInfo) CollectionsKt.getOrNull(r5, r4);
        if (r7 == null) goto L16;
        if (r7.getStatus() != 1) goto L16;
        return true;
    L16:
        r3 = r3 + 1;
        r4 = r6;
    L17:
        return false;
    }

    public final void newExplainCard() {
        ShelfInfo r1 = this.shelfInfo;
        if (r1 != null) goto L5;
    L6:
        ShelfInfo r2 = this.shelfInfo;
        if (r2 != null) goto L9;
    L12:
        so0.a r3 = this.miniAppAnchorService;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L15:
        OpenPlatformContext r4 = r3.a();
        String r5 = "";
        if (r4 == null) goto L25;
        AnchorMiniAppAppLogContextService r6 = (AnchorMiniAppAppLogContextService) r4.getService(AnchorMiniAppAppLogContextService.class);
        if (r6 == null) goto L25;
        ShelfMicroAppInfo r7 = this.shelfAppInfo;
        if (r7 == null) goto L23;
        String r8 = r7.appId;
        if (r8 == null) goto L23;
    L24:
        r6.reportMpClick(r8, "shelf_setting_page");
    L23:
        r8 = "";
    L25:
        so0.a r9 = this.miniAppAnchorService;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L28:
        OpenPlatformContext r10 = r9.a();
        if (r10 == null) goto L43;
        AnchorMiniAppAppLogContextService r11 = (AnchorMiniAppAppLogContextService) r10.getService(AnchorMiniAppAppLogContextService.class);
        if (r11 == null) goto L43;
        ShelfMicroAppInfo r12 = this.shelfAppInfo;
        if (r12 == null) goto L38;
        String r13 = r12.appId;
        if (r13 == null) goto L38;
        String r14 = r13;
    L39:
        Integer r15 = (Integer) this.pageCount.getValue();
        if (r15 != null) goto L42;
        r15 = 0;
    L42:
        AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r11, r14, "click_adding_page", r15.intValue(), 0, 8, null);
    L38:
        r14 = "";
    L43:
        ShelfInfo r16 = this.shelfInfo;
        if (r16 == null) goto L53;
        so0.a r17 = this.miniAppAnchorService;
        if (r17 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L48:
        OpenPlatformContext r18 = r17.a();
        if (r18 == null) goto L53;
        AnchorShelfContextService r19 = (AnchorShelfContextService) r18.getService(AnchorShelfContextService.class);
        if (r19 == null) goto L53;
        r19.copyShelfInfoTemp(r16);
    L53:
        so0.a r20 = this.miniAppAnchorService;
        if (r20 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L56:
        ShelfMicroAppInfo r21 = this.shelfAppInfo;
        if (r21 == null) goto L62;
        String r22 = r21.schema;
        if (r22 == null) goto L62;
        r5 = r22;
    L62:
        r20.openMiniApp(r5, new ko0.b(LaunchParamConstant$Scene.a, "live", PbRequest.SwitchType.PREVIEW, "solid_entrance", "live_take_page", "shelf_setting_page", null, null, null, false, true, null, 12224));
        return;
    L9:
        if (r2.d() != true) goto L12;
    L10:
        f2.c(s1.B(2131921102), 0);
        return;
    L5:
        if (r1.e() == true) goto L10;
        goto L6
    }

    public final void recordEnterTimes() {
        e r0 = b.C3;
        Integer r1 = Integer.valueOf(((Number) r0.getValue()).intValue() + 1);
        r0.getClass();
        f.d(r0, r1);
    }

    public final void selectedAll() {
        MutableLiveData<Boolean[]> r0 = this.selectedList;
        Boolean[] r1 = (Boolean[]) r0.getValue();
        if (r1 == null) goto L5;
        ArraysKt.fill$default(r1, Boolean.TRUE, 0, 0, 6, null);
        Unit r2 = Unit.INSTANCE;
    L6:
        r0.setValue(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void startEditShelf() {
        this.isEditing.setValue(Boolean.TRUE);
    }

    public final void unselectedAll() {
        MutableLiveData<Boolean[]> r0 = this.selectedList;
        Boolean[] r1 = (Boolean[]) r0.getValue();
        if (r1 == null) goto L5;
        ArraysKt.fill$default(r1, Boolean.FALSE, 0, 0, 6, null);
        Unit r2 = Unit.INSTANCE;
    L6:
        r0.setValue(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public ShelfManagementViewModel() {
        this.$$delegate_0 = new a();
        this.isInLive$delegate = LazyKt.lazy(new C03292(this));
        this.pageCount = new MutableLiveData();
        this.shelfCardInfo = new MutableLiveData();
        this.finish = new MutableLiveData();
        this.isEditing = new MutableLiveData();
        this.selectedList = new MutableLiveData();
        this.businessToolsData = new MutableLiveData();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        setMiniAppAnchorService((so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get());
        autoDispose(m.f(xs2.b.a().b(zp0.b.class), new AnonymousClass1(this)));
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L10;
        n<lo0.b> r1 = r0.getPrivateMsgTabInfo();
        if (r1 == null) goto L11;
        Disposable r2 = i80.a.b(r1, new AnonymousClass2(this));
        if (r2 == null) goto L12;
        autoDispose(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final boolean isSelectedAll() {
        int r0 = getSelectedCount();
        Integer r1 = (Integer) this.pageCount.getValue();
        if (r1 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0 != r1.intValue()) goto L8;
        return true;
    }

    public void onCleared() {
        super.onCleared();
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L10;
        AnchorShelfContextService r2 = (AnchorShelfContextService) r1.getService(AnchorShelfContextService.class);
        if (r2 == null) goto L10;
        r2.clearShelfInfoTemp();
    L10:
        dispose();
    }

    public final MutableLiveData<Map<BusinessToolType, bq0.a>> getBusinessToolsData() {
        return this.businessToolsData;
    }

    public final MutableLiveData<Boolean> getFinish() {
        return this.finish;
    }

    public final MutableLiveData<Integer> getPageCount() {
        return this.pageCount;
    }

    public final MutableLiveData<Boolean[]> getSelectedList() {
        return this.selectedList;
    }

    public final ShelfMicroAppInfo getShelfAppInfo() {
        return this.shelfAppInfo;
    }

    public final MutableLiveData<List<ShelfCardInfo>> getShelfCardInfo() {
        return this.shelfCardInfo;
    }

    public final ShelfInfo getShelfInfo() {
        return this.shelfInfo;
    }

    public final MutableLiveData<Boolean> isEditing() {
        return this.isEditing;
    }

    public final void addBusinessTool(bq0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "businessToolModel");
        MutableLiveData<Map<BusinessToolType, bq0.a>> r0 = this.businessToolsData;
        LinkedHashMap r1 = new LinkedHashMap();
        Map r2 = (Map) this.businessToolsData.getValue();
        if (r2 != null) goto L5;
        r2 = MapsKt.emptyMap();
    L5:
        r1.putAll(r2);
        r1.put(r4.b(), r4);
        Unit r5 = Unit.INSTANCE;
        r0.setValue(r1);
    }

    public final void batchDelete(Function0<Unit> r10) {
        if (isSelectedAll() == false) goto L5;
        offShelf("all_delete", r10);
        return;
    L5:
        ShelfInfo r1 = this.shelfInfo;
        if (r1 == null) goto L32;
        List<ShelfCardInfo> r0 = r1.cardInfoList;
        if (r0 == null) goto L25;
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
        int r5 = 0;
    L11:
        if (r2.hasNext() == false) goto L24;
        Object r6 = r2.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        ShelfCardInfo r8 = (ShelfCardInfo) r6;
        Boolean[] r9 = (Boolean[]) this.selectedList.getValue();
        if (r9 != null) goto L18;
    L20:
        boolean r11 = false;
    L21:
        if (r11 == false) goto L23;
        r3.add(r6);
    L23:
        r5 = r7;
        goto L11
    L18:
        if (r9[r5].booleanValue() == true) goto L20;
        r11 = true;
        goto L21
    L24:
        List r4 = CollectionsKt.toMutableList(r3);
    L26:
        modifyShelfInfo(ShelfInfo.a(r1, null, r4, false, null, null, null, 1048573), r10);
        return;
    L25:
        r4 = null;
        goto L26
    }

    public final void editExplainCard(ShelfCardInfo r14) {
        Intrinsics.checkNotNullParameter(r14, "shelfCardInfo");
        HashMap<String, zo0.f> r0 = g.a;
        zo0.f r1 = h.b(PerformanceScene.EXPLAIN_CARD_SETTING_DIALOG);
        r1.o();
        h.a(r1, "explain_card_setting");
        so0.a r2 = this.miniAppAnchorService;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r3 = r2.a();
        if (r3 == null) goto L11;
        ExplainCardSettingContextService r4 = (ExplainCardSettingContextService) r3.getService(ExplainCardSettingContextService.class);
        if (r4 == null) goto L12;
        r4.h(new ExplainCardSettingsInfo(this.shelfAppInfo, r14, null, true, true, 0, null, null, 0, 484));
        return;
    L12:
        return;
    }

    public final void openCardLandingPage(ShelfCardInfo r19) {
        Intrinsics.checkNotNullParameter(r19, "shelfCardInfo");
        ShelfInfo r1 = this.shelfInfo;
        if (r1 == null) goto L12;
        so0.a r4 = this.miniAppAnchorService;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L7:
        OpenPlatformContext r5 = r4.a();
        if (r5 == null) goto L12;
        AnchorShelfContextService r6 = (AnchorShelfContextService) r5.getService(AnchorShelfContextService.class);
        if (r6 == null) goto L12;
        r6.copyShelfInfoTemp(r1);
    L12:
        SchemaInfo.a r2 = new SchemaInfo.a(r19.a0());
        String r3 = r19.i0();
        if (r3 != null) goto L15;
    L20:
        SchemaInfo r7 = r2.c();
        if (r7 == null) goto L24;
        String r8 = r7.h();
        if (r8 == null) goto L24;
    L25:
        so0.a r9 = this.miniAppAnchorService;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L28:
        r9.openMiniApp(r8, new ko0.b(LaunchParamConstant$Scene.a, "live", PbRequest.SwitchType.PREVIEW, "solid_entrance", "live_take_page", "shelf_setting_page", null, null, null, false, false, null, 16320));
        return;
    L24:
        r8 = "";
        goto L25
    L15:
        if ((!StringsKt.isBlank(r3)) == true) goto L18;
        r3 = null;
    L18:
        if (r3 == null) goto L20;
        r2.g(r3);
        goto L20
    }

    public final void selectCard(int r2) {
        changeCardSelectedStatus(r2, true);
    }

    @Inject
    public final void setMiniAppAnchorService(so0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.miniAppAnchorService = r2;
    }

    public final void setShelfAppInfo(ShelfMicroAppInfo r1) {
        this.shelfAppInfo = r1;
    }

    public final void setShelfInfo(ShelfInfo r1) {
        this.shelfInfo = r1;
    }

    public final void unselectCard(int r2) {
        changeCardSelectedStatus(r2, false);
    }

    private final void changeCardSelectedStatus(int r3, boolean r4) {
        if (r3 < 0) goto L15;
        Boolean[] r0 = (Boolean[]) this.selectedList.getValue();
        if (r0 == null) goto L6;
        int r1 = r0.length;
    L7:
        if (r3 >= r1) goto L16;
        MutableLiveData<Boolean[]> r2 = this.selectedList;
        Boolean[] r5 = (Boolean[]) r2.getValue();
        if (r5 == null) goto L12;
        r5[r3] = Boolean.valueOf(r4);
        Unit r6 = Unit.INSTANCE;
    L13:
        r2.setValue(r5);
        return;
    L12:
        r5 = null;
        goto L13
    L16:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    public void modifyShelfInfo(ShelfInfo r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "shelfInfo");
        this.shelfInfo = r5;
        this.shelfAppInfo = r5.appInfo;
        this.shelfCardInfo.setValue(r5.cardInfoList);
        MutableLiveData<Integer> r0 = this.pageCount;
        List<ShelfCardInfo> r7 = r5.cardInfoList;
        int r1 = 0;
        if (r7 == null) goto L5;
        int r8 = r7.size();
    L6:
        r0.setValue(Integer.valueOf(r8));
        MutableLiveData<Boolean[]> r9 = this.selectedList;
        Integer r2 = (Integer) this.pageCount.getValue();
        if (r2 != null) goto L9;
        r2 = 0;
    L9:
        int r3 = r2.intValue();
        Boolean[] r4 = new Boolean[r3];
    L10:
        if (r1 >= r3) goto L12;
        r4[r1] = Boolean.FALSE;
        r1 = r1 + 1;
        goto L10
    L12:
        r9.setValue(r4);
        if (r6 == null) goto L17;
        Unit r10 = (Unit) r6.invoke();
        return;
    L17:
        return;
    L5:
        r8 = 0;
        goto L6
    }

    public final void offShelf(String r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "exitSource");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        AnchorShelfContextService r2 = (AnchorShelfContextService) r1.getService(AnchorShelfContextService.class);
        if (r2 == null) goto L12;
        r2.offShelf(r3, r4);
        return;
    L12:
        return;
    }

    public void saveSort(List<ShelfCardInfo> r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "cardInfoList");
        Intrinsics.checkNotNullParameter(r11, "onSuccess");
        ShelfInfo r1 = this.shelfInfo;
        if (r1 == null) goto L6;
        modifyShelfInfo(ShelfInfo.a(r1, null, r10, false, null, null, null, 1048573), r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void batchDelete$default(ShelfManagementViewModel r0, Function0 r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.batchDelete(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: batchDelete");
    }

    public static /* synthetic */ void initData$default(ShelfManagementViewModel r0, ShelfInfo r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.initData(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initData");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void modifyShelfInfo$default(ShelfManagementViewModel r0, ShelfInfo r1, Function0 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.modifyShelfInfo(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyShelfInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offShelf$default(ShelfManagementViewModel r0, String r1, Function0 r2, int r3, Object r4) {
        if (r4 != null) goto L12;
        if ((r3 & 1) == 0) goto L7;
        r1 = "";
    L7:
        if ((r3 & 2) == 0) goto L9;
        r2 = null;
    L9:
        r0.offShelf(r1, r2);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offShelf");
    }
}
