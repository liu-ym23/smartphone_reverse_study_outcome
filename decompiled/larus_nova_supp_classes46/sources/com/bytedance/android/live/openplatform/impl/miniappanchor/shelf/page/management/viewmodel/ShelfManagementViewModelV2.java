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
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingsInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.privatemsg.AnchorPrivateMsgContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.bytedance.android.livesdk.sharedpref.b;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zo0.d;
import zo0.f;
import zo0.g;
import zo0.h;
import zp0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001aB\u0007¢\u0006\u0004\b^\u0010_J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002JK\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\n2'\b\u0002\u0010\u0014\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0004J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0004J\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0006J\u0016\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\rJ\u000e\u0010%\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ\u0018\u0010(\u001a\u00020\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015J\"\u0010+\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020)2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015J8\u0010.\u001a\u00020\u00032\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060,2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015J\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\u0003J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\u0003H\u0014J\t\u00103\u001a\u00020\u0003H\u0096\u0001J\u0011\u00106\u001a\u00020\u00032\u0006\u00105\u001a\u000204H\u0096\u0001J\r\u00107\u001a\u00020\u0003*\u000204H\u0096\u0001R*\u0010:\u001a\u0002082\u0006\u00109\u001a\u0002088\u0006@GX\u0086.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010B\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR.\u0010J\u001a\u0004\u0018\u00010I2\b\u00109\u001a\u0004\u0018\u00010I8\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\b0P8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR#\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0,0P8\u0006¢\u0006\f\n\u0004\bV\u0010R\u001a\u0004\bW\u0010TR\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020\r0P8\u0006¢\u0006\f\n\u0004\bX\u0010R\u001a\u0004\bY\u0010TR)\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\u001a0Z0P8\u0006¢\u0006\f\n\u0004\b\\\u0010R\u001a\u0004\b]\u0010T¨\u0006b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/ShelfManagementViewModelV2;", "Landroidx/lifecycle/ViewModel;", "", "", "registerEditSellingPointEventListener", "registerEditCardEventListener", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "modifiedCardInfo", "", "modifiedCardPosition", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "getModifiedShelfInfo", "position", "", "selected", "changeCardSelectedStatus", "shelfInfo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onSuccess", "Lkotlin/Function0;", "onFail", "modifyShelfInfo", "initData", "fetchPrivateMsgData", "Lbq0/a;", "businessToolModel", "addBusinessTool", "newExplainCard", "shelfCardInfo", "openCardLandingPage", "editExplainCard", "selectedAll", "unselectedAll", "isSelectedAll", "isSelectedExplainingCard", "selectCard", "unselectCard", "getSelectedCount", "batchDelete", "", "exitSource", "offShelf", "", "cardInfoList", "saveSort", "getEnterTimes", "recordEnterTimes", "onPageFirstFrameShown", "onCleared", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "Lso0/a;", "<set-?>", "miniAppAnchorService", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "isInLive$delegate", "Lkotlin/Lazy;", "isInLive", "()Z", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "getShelfInfo", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "setShelfInfo", "(Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;)V", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "shelfAppInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "getShelfAppInfo", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "setShelfAppInfo", "(Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;)V", "Landroidx/lifecycle/MutableLiveData;", "pageCount", "Landroidx/lifecycle/MutableLiveData;", "getPageCount", "()Landroidx/lifecycle/MutableLiveData;", "Laq0/a;", "shelfCardInfoList", "getShelfCardInfoList", "finish", "getFinish", "", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/model/BusinessToolType;", "businessToolsData", "getBusinessToolsData", "<init>", "()V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShelfManagementViewModelV2 extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "ShelfManagementViewModelV2";
    private final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a $$delegate_0;
    private final MutableLiveData<Map<BusinessToolType, bq0.a>> businessToolsData;
    private final MutableLiveData<Boolean> finish;
    private final Lazy isInLive$delegate;
    public so0.a miniAppAnchorService;
    private final MutableLiveData<Integer> pageCount;
    private ShelfMicroAppInfo shelfAppInfo;
    private final MutableLiveData<List<aq0.a>> shelfCardInfoList;
    private ShelfInfo shelfInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public void autoDispose(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.$$delegate_0.a(r2);
    }

    public void dispose() {
        this.$$delegate_0.b();
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
        List r0 = (List) this.shelfCardInfoList.getValue();
        int r1 = 0;
        if (r0 == null) goto L17;
        List r2 = r0;
        if ((r2 instanceof Collection) == true) goto L7;
    L9:
        Iterator r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L17;
        if (((aq0.a) r3.next()).b == false) goto L11;
        r1 = r1 + 1;
        if (r1 >= 0) goto L11;
        CollectionsKt.throwCountOverflow();
        goto L11
    L7:
        if (r2.isEmpty() == false) goto L9;
    L17:
        return r1;
    }

    public void initData() {
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L8;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L9;
        i80.a.b(r1, new C03311(this));
        return;
    L9:
        return;
    }

    public final boolean isSelectedExplainingCard() {
        List r0 = (List) this.shelfCardInfoList.getValue();
        Object r3 = null;
        if (r0 == null) goto L16;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        Object r4 = r1.next();
        aq0.a r5 = (aq0.a) r4;
        if (r5.b == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L6;
        r3 = r4;
        goto L15
    L10:
        if (r5.a.getStatus() != 1) goto L12;
        r6 = true;
    L15:
        r3 = (aq0.a) r3;
    L16:
        if (r3 != null) goto L25;
        return false;
    L25:
        return true;
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

    public void onPageFirstFrameShown() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        OpenPlatformPerformanceReportService r2 = (OpenPlatformPerformanceReportService) r1.getService(OpenPlatformPerformanceReportService.class);
        if (r2 == null) goto L12;
        HashMap<String, f> r3 = g.a;
        f r4 = h.b(PerformanceScene.SHELF_MANAGEMENT_PAGE);
        r4.b();
        f.a(r4, new d(r2));
        return;
    L12:
        return;
    }

    public final void recordEnterTimes() {
        e r0 = b.C3;
        Integer r1 = Integer.valueOf(((Number) r0.getValue()).intValue() + 1);
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
    }

    public final void selectedAll() {
        MutableLiveData<List<aq0.a>> r0 = this.shelfCardInfoList;
        List r1 = (List) r0.getValue();
        if (r1 == null) goto L8;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        r3.add(aq0.a.a((aq0.a) r4.next(), true));
    L9:
        r0.setValue(r3);
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final void unselectedAll() {
        MutableLiveData<List<aq0.a>> r0 = this.shelfCardInfoList;
        List r1 = (List) r0.getValue();
        if (r1 == null) goto L8;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        r3.add(aq0.a.a((aq0.a) r4.next(), false));
    L9:
        r0.setValue(r3);
        return;
    L8:
        r3 = null;
        goto L9
    }

    public ShelfManagementViewModelV2() {
        this.$$delegate_0 = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.isInLive$delegate = LazyKt.lazy(new C03322(this));
        this.pageCount = new MutableLiveData();
        this.shelfCardInfoList = new MutableLiveData();
        this.finish = new MutableLiveData();
        this.businessToolsData = new MutableLiveData();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        setMiniAppAnchorService((so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get());
        registerEditSellingPointEventListener();
        registerEditCardEventListener();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L10;
        n<lo0.b> r1 = r0.getPrivateMsgTabInfo();
        if (r1 == null) goto L11;
        Disposable r2 = i80.a.b(r1, new AnonymousClass1(this));
        if (r2 == null) goto L12;
        autoDispose(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void registerEditCardEventListener() {
        autoDispose(m.f(xs2.b.a().b(zp0.b.class), new C03341(this)));
    }

    private final void registerEditSellingPointEventListener() {
        autoDispose(m.f(xs2.b.a().b(c.class), new C03351(this)));
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

    public final ShelfMicroAppInfo getShelfAppInfo() {
        return this.shelfAppInfo;
    }

    public final MutableLiveData<List<aq0.a>> getShelfCardInfoList() {
        return this.shelfCardInfoList;
    }

    public final ShelfInfo getShelfInfo() {
        return this.shelfInfo;
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

    public final void batchDelete(final Function0<Unit> r10) {
        if (isSelectedAll() == false) goto L5;
        offShelf("all_delete", r10);
        return;
    L5:
        ShelfInfo r1 = this.shelfInfo;
        if (r1 == null) goto L29;
        List r0 = (List) this.shelfCardInfoList.getValue();
        if (r0 == null) goto L19;
        ArrayList r3 = new ArrayList();
        Iterator r2 = r0.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        Object r4 = r2.next();
        if ((!((aq0.a) r4).b) == false) goto L11;
        r3.add(r4);
        goto L11
    L15:
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r6 = r3.iterator();
    L17:
        if (r6.hasNext() == false) goto L20;
        r5.add(((aq0.a) r6.next()).a);
    L20:
        modifyShelfInfo(ShelfInfo.a(r1, null, r5, false, null, null, null, 1048573), new C03301(r10), AnonymousClass2.INSTANCE);
        return;
    L19:
        r5 = null;
        goto L20
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

    private final void changeCardSelectedStatus(int r7, boolean r8) {
        MutableLiveData<List<aq0.a>> r0 = this.shelfCardInfoList;
        List r1 = (List) r0.getValue();
        if (r1 == null) goto L14;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
        int r5 = 0;
    L6:
        if (r4.hasNext() == false) goto L15;
        Object r6 = r4.next();
        int r9 = r5 + 1;
        if (r5 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        aq0.a r10 = (aq0.a) r6;
        if (r7 != r5) goto L13;
        r10 = aq0.a.a(r10, r8);
    L13:
        r3.add(r10);
        r5 = r9;
    L15:
        r0.setValue(r3);
        return;
    L14:
        r3 = null;
        goto L15
    }

    private final ShelfInfo getModifiedShelfInfo(ShelfCardInfo r10, int r11) {
        ArrayList r0 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        ShelfInfo r1 = this.shelfInfo;
        if (r1 == null) goto L24;
        List<ShelfCardInfo> r3 = r1.cardInfoList;
        if (r3 == null) goto L20;
        List<ShelfCardInfo> r4 = r3;
        r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
        int r6 = 0;
    L11:
        if (r5.hasNext() == false) goto L20;
        Object r7 = r5.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        ShelfCardInfo r9 = (ShelfCardInfo) r7;
        if (r6 != r11) goto L18;
        r9 = r10;
    L18:
        r0.add(r9);
        r6 = r8;
    L20:
        return ShelfInfo.a(r1, null, r0, false, null, null, null, 1048573);
    L24:
        return null;
    }

    public final void editExplainCard(ShelfCardInfo r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "shelfCardInfo");
        HashMap<String, f> r0 = g.a;
        f r1 = h.b(PerformanceScene.EXPLAIN_CARD_SETTING_DIALOG);
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
        r4.h(new ExplainCardSettingsInfo(this.shelfAppInfo, r14, null, true, true, 0, null, null, r15, 228));
        return;
    L12:
        return;
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

    public static final /* synthetic */ ShelfInfo access$getModifiedShelfInfo(ShelfManagementViewModelV2 r0, ShelfCardInfo r1, int r2) {
        return r0.getModifiedShelfInfo(r1, r2);
    }

    private final void modifyShelfInfo(ShelfInfo r9, final Function1<? super ShelfInfo, Unit> r10, Function0<Unit> r11) {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        AnchorShelfContextService r2 = (AnchorShelfContextService) r1.getService(AnchorShelfContextService.class);
        if (r2 == null) goto L12;
        AnchorShelfContextService.modifyShelf$default(r2, r9, false, new C03331(r10), r11, 2, null);
        return;
    L12:
        return;
    }

    public final void saveSort(List<ShelfCardInfo> r10, final Function0<Unit> r11, final Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "cardInfoList");
        ShelfInfo r1 = this.shelfInfo;
        if (r1 == null) goto L6;
        modifyShelfInfo(ShelfInfo.a(r1, null, r10, false, null, null, null, 1048573), new C03361(r11), new C03372(r12));
        return;
    }

    public static final /* synthetic */ void access$modifyShelfInfo(ShelfManagementViewModelV2 r0, ShelfInfo r1, Function1 r2, Function0 r3) {
        r0.modifyShelfInfo(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void batchDelete$default(ShelfManagementViewModelV2 r0, Function0 r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.batchDelete(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: batchDelete");
    }

    public static /* synthetic */ ShelfInfo getModifiedShelfInfo$default(ShelfManagementViewModelV2 r0, ShelfCardInfo r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = -1;
    L7:
        return r0.getModifiedShelfInfo(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getModifiedShelfInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offShelf$default(ShelfManagementViewModelV2 r0, String r1, Function0 r2, int r3, Object r4) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void modifyShelfInfo$default(ShelfManagementViewModelV2 r1, ShelfInfo r2, Function1 r3, Function0 r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.modifyShelfInfo(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyShelfInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void saveSort$default(ShelfManagementViewModelV2 r1, List r2, Function0 r3, Function0 r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.saveSort(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveSort");
    }
}
