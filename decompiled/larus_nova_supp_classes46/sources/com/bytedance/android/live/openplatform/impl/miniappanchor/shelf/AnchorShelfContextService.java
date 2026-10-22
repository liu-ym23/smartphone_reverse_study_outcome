package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.broadcastgame.api.model.f0;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductJumpSetting;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.impl.base.context.ContextServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.ImageUtils;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.MiniAppExplainCardApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingDialog;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingsInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.TextPosterHelper;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.CoexistAnchorShelfDisplayDialog;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.CommonAnchorShelfDisplayDialog;
import com.bytedance.android.live.openplatform.impl.miniappcommon.bridge.BridgeContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.monitor.MiniAppMonitor;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.ShelfInfoContextService;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mh1.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ContextServiceImpl(liveAnchorService = "com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.LiveAnchorShelfContextService", previewAnchorService = "com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.PreviewAnchorShelfContextService")
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 A2\u00020\u0001:\u0001BB\u000f\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0016\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J \u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aJ\u0010\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ \u0010 \u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\t2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aJ \u0010\"\u001a\u00020\u00062\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010!J \u0010$\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\tH&J\u001a\u0010%\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\tJ\u0006\u0010&\u001a\u00020\u0006J\b\u0010'\u001a\u00020\u0006H\u0016JF\u0010*\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\u00172\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010!2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aH&J$\u0010,\u001a\u00020\u00062\b\b\u0002\u0010+\u001a\u00020\t2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aH&J4\u0010-\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010!2\b\b\u0002\u0010(\u001a\u00020\u0017H\u0016J\u001a\u0010.\u001a\u00020\u00062\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aH\u0016J\u0016\u00101\u001a\u00020\r2\u0006\u00100\u001a\u00020/2\u0006\u0010\u000e\u001a\u00020\rJ$\u00106\u001a\u00020\u00062\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\n\b\u0002\u00105\u001a\u0004\u0018\u000104H\u0016R$\u00107\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b\u001f\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00108¨\u0006C"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/AnchorShelfContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/ShelfInfoContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingsInfo;", "explainCardSettingsInfo", "Lorg/json/JSONObject;", "mountParams", "", "saveCard", "", "", "getCustomMap", "appId", "copyShelfInfoTemp", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "clearShelfInfoTemp", "page", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/c;", "getPageConfig", "Landroid/os/Bundle;", "extraData", "onMountPage", "getCurShelfInfo", "", "isMounted", "interceptAddPage", "Lkotlin/Function0;", "onSuccess", "putCardOnShelf", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/m;", "presetCardList", "setShelfInfoTemp", "takeCardOffFromShelf", "Lkotlin/Function1;", "saveShelf", "source", "openShelfManagementPage", "openShelfDisplayPage", "closeShelfManagementPage", "clickAnchorToolbarMiniApp", "isBeforeStart", "onFail", "modifyShelf", "exitSource", "offShelf", "onModifyShelfSuccess", "onOffShelfSuccess", "", "anchorLiveStatus", "updateAnchorLiveStatus", "clickSource", "liveType", "Lmh1/p;", "miniAppOuterHelper", "openChoosePage", "shelfInfoTemp", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "getShelfInfoTemp", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "(Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;)V", "initShelfInfo", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AnchorShelfContextService extends ShelfInfoContextService {
    public static final a Companion = null;
    private static final String TAG = "AnchorShelfContextService";
    private ShelfInfo initShelfInfo;
    private ShelfInfo shelfInfoTemp;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorShelfContextService a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ ExplainCardSettingsInfo c;

        public b(AnchorShelfContextService r1, JSONObject r2, ExplainCardSettingsInfo r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r14) {
            e r15 = (e) r14;
            int r0 = qo0.a.a;
            qo0.a.c(AnchorShelfContextService.TAG, "fetch preset data success, has set: " + ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e) r15.data).d());
            com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e r16 = (com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e) r15.data;
            ProductInfo r1 = r16.g();
            String r2 = null;
            if (r1 == null) goto L5;
            ProductInfo r3 = new ProductInfo(r1.productId, r1.title, r1.imgUrl, r1.introductionList, r1.labelList, r1.price, r1.actionText, r1.isShow, new ProductJumpSetting(this.b.optBoolean("isJumpToOtherPage", false), this.b.optString("jumpToOtherPageAppId", ""), null, AnchorShelfContextService.access$getCustomMap(this.a, this.b)));
        L6:
            final com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e r17 = com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e.a(r16, r3);
            int r4 = TextPosterHelper.a;
            ShelfCardInfo r5 = this.c.shelfCardInfo;
            Intrinsics.checkNotNullParameter(r17, "data");
            String r6 = TextPosterHelper.a(r17.g());
            if (r6 != null) goto L9;
            r6 = r17.c();
        L9:
            if (r6 != null) goto L12;
            if (r5 == null) goto L13;
            r2 = r5.I();
        L13:
            if (r2 != null) goto L15;
            final String r7 = "";
        L16:
            Context r8 = AnchorShelfContextService.access$getOpenPlatformContext$p(this.a).getContext();
            String r9 = r17.e();
            if (r9 != null) goto L19;
            String r10 = "";
        L20:
            String r11 = r17.h();
            if (r11 != null) goto L23;
            String r12 = "";
        L24:
            Disposable r18 = TextPosterHelper.b(r8, r10, r7, r12, new AnchorShelfContextService$saveCard$1$1(this, r17, r7), AnchorShelfContextService$saveCard$1$2.INSTANCE);
            if (r18 == null) goto L28;
            this.a.autoDispose(r18);
            return;
        L28:
            return;
        L23:
            r12 = r11;
            goto L24
        L19:
            r10 = r9;
            goto L20
        L15:
            r7 = r2;
            goto L16
        L12:
            r2 = r6;
            goto L13
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            Object r4 = (Throwable) r3;
            int r0 = qo0.a.a;
            StringBuilder r1 = new StringBuilder("fetch preset data fail, error: ");
            if (r4 != null) goto L6;
            r4 = "null";
        L6:
            r1.append(r4);
            qo0.a.b(AnchorShelfContextService.TAG, r1.toString(), null);
            f2.b(2131920444, 0);
        }
    }

    static {
        Companion = new a();
    }

    public final void clearShelfInfoTemp() {
        this.shelfInfoTemp = null;
        this.initShelfInfo = null;
    }

    public void clickAnchorToolbarMiniApp() {
    }

    public abstract void modifyShelf(ShelfInfo r1, boolean r2, Function1<? super ShelfInfo, Unit> r3, Function0<Unit> r4);

    public abstract void offShelf(String r1, Function0<Unit> r2);

    public void openChoosePage(String r1, String r2, p r3) {
        Intrinsics.checkNotNullParameter(r1, "clickSource");
        Intrinsics.checkNotNullParameter(r2, "liveType");
    }

    public abstract void openShelfManagementPage(ShelfInfo r1, String r2);

    public final ShelfInfo getCurShelfInfo() {
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L7;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L7;
        return (ShelfInfo) r1.getValue();
    L7:
        return null;
    }

    public final boolean interceptAddPage() {
        ShelfInfo r0 = this.shelfInfoTemp;
        if (r0 == null) goto L7;
        List<ShelfCardInfo> r1 = r0.cardInfoList;
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        if (r2 <= 0) goto L19;
        ShelfInfo r3 = this.shelfInfoTemp;
        if (r3 != null) goto L12;
    L13:
        ShelfInfo r4 = this.shelfInfoTemp;
        if (r4 != null) goto L16;
        return false;
    L16:
        if (r4.d() != true) goto L21;
    L17:
        return true;
    L21:
        return false;
    L12:
        if (r3.e() == true) goto L17;
    L19:
        return false;
    L7:
        r2 = 0;
        goto L8
    }

    public final void closeShelfManagementPage() {
        xs2.b.a().post(new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.b());
    }

    public final boolean isMounted() {
        if (getCurShelfInfo() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ShelfInfo getShelfInfoTemp() {
        return this.shelfInfoTemp;
    }

    public AnchorShelfContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public static final /* synthetic */ OpenPlatformContext access$getOpenPlatformContext$p(AnchorShelfContextService r0) {
        return r0.getOpenPlatformContext();
    }

    private final Map<String, String> getCustomMap(JSONObject r2) {
        JSONObject r3 = r2.optJSONObject("jumpToOtherPageQuery");
        if (r3 == null) goto L11;
        if (r3.toString().length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return MapsKt.mapOf(TuplesKt.to("custom_params", r3.toString()));
    L7:
        r0 = false;
    L11:
        return MapsKt.emptyMap();
    }

    public final void copyShelfInfoTemp(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appId");
        if (this.shelfInfoTemp == null) goto L5;
        return;
    L5:
        ShelfInfo r1 = getCurShelfInfo();
        ShelfInfo r0 = null;
        if (r1 == null) goto L10;
        ShelfMicroAppInfo r2 = r1.appInfo;
        if (r2 == null) goto L10;
        String r3 = r2.appId;
    L12:
        if (Intrinsics.areEqual(r3, r10) == false) goto L14;
        ShelfInfo r4 = ShelfInfo.a(r1, null, null, false, null, null, null, 1048575);
    L15:
        this.shelfInfoTemp = r4;
        if (r4 == null) goto L18;
        r0 = ShelfInfo.a(r4, null, null, false, null, null, null, 1048575);
    L18:
        this.initShelfInfo = r0;
        return;
    L14:
        r4 = null;
    L10:
        r3 = null;
        goto L12
    }

    public final com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.c getPageConfig(String r10) {
        Intrinsics.checkNotNullParameter(r10, "page");
        ShelfInfo r0 = this.shelfInfoTemp;
        Object r1 = null;
        if (r0 == null) goto L14;
        List<ShelfCardInfo> r2 = r0.cardInfoList;
        if (r2 == null) goto L14;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (m.a(r10, ((ShelfCardInfo) r4).i0()) == false) goto L8;
        r1 = r4;
    L12:
        r1 = (ShelfCardInfo) r1;
    L14:
        if (r1 == null) goto L16;
        boolean r5 = true;
    L17:
        ShelfInfo r6 = this.shelfInfoTemp;
        if (r6 == null) goto L22;
        List<ShelfCardInfo> r7 = r6.cardInfoList;
        if (r7 == null) goto L22;
        int r8 = r7.size();
    L24:
        return new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.c(r5, r8, !Intrinsics.areEqual(this.shelfInfoTemp, this.initShelfInfo), getOpenPlatformContext().getRoomId(), 8);
    L22:
        r8 = 0;
        goto L24
    L16:
        r5 = false;
        goto L17
    }

    public final void onMountPage(final Bundle r6) {
        Intrinsics.checkNotNullParameter(r6, "extraData");
        String r0 = r6.getString("mount_params");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(new JSONObject(r0));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        final JSONObject r3 = (JSONObject) r2;
        if (r3 != null) goto L14;
        int r7 = MiniAppMonitor.a;
        SafetyGuard.a("ttlive_miniapp_monitor", new Throwable("onMountPage, mountParamsStr = " + r0), null);
        MiniAppMonitor.a(MiniAppMonitor.ExceptionType.Mount, "mountParamsStr is invalid");
        int r8 = qo0.a.a;
        qo0.a.b(TAG, "onMountPage, mountParamsStr = " + r0, null);
        return;
    L14:
        int r4 = qo0.a.a;
        qo0.a.c(TAG, "onMountPage, mountParams = " + r3);
        int r5 = ImageUtils.a;
        Context r9 = getOpenPlatformContext().getContext();
        String r10 = r3.optString("snapshotPath");
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        ImageUtils.b(r9, r10, new AnonymousClass1(this, r3, r6), AnonymousClass2.INSTANCE, true);
        return;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public void onOffShelfSuccess(Function0<Unit> r8) {
        qo0.a.c(TAG, "onOffShelfSuccess");
        if (r8 == null) goto L5;
        Unit r9 = (Unit) r8.invoke();
    L5:
        xs2.b r10 = xs2.b.a();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L15;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L15;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L15;
        ShelfMicroAppInfo r3 = r2.appInfo;
        if (r3 == null) goto L15;
        String r4 = r3.appId;
        if (r4 == null) goto L15;
    L16:
        r10.post(new f0(r4, ReloadPanelType.FROM_CAHCE, false, false, 12));
        xs2.b.a().post(new ExplainCardSettingDialog.a());
        AnchorMiniAppDataContext r11 = AnchorMiniAppDataContext.a.a();
        if (r11 == null) goto L22;
        n<ShelfInfo> r12 = r11.m618getShelfInfo();
        if (r12 == null) goto L23;
        r12.setValue(null);
        return;
    L23:
        return;
    L22:
        return;
    L15:
        r4 = "";
        goto L16
    }

    public final void saveShelf(final Function1<? super ShelfInfo, Unit> r8) {
        ShelfInfo r1 = this.shelfInfoTemp;
        if (r1 == null) goto L10;
        List<ShelfCardInfo> r3 = r1.cardInfoList;
        if (r3 != null) goto L7;
    L9:
        offShelf$default(this, null, new AnchorShelfContextService$saveShelf$$inlined$let$lambda$1(this, r8), 1, null);
        return;
    L7:
        if ((!r3.isEmpty()) != true) goto L9;
        modifyShelf$default(this, r1, false, r8, null, 10, null);
        return;
    L10:
        offShelf$default(this, null, new C03212(r8), 1, null);
    }

    public final void setShelfInfoTemp(com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.m r10) {
        if (r10 == null) goto L5;
        ShelfMicroAppInfo r1 = r10.b(getOpenPlatformContext().isInLive());
    L6:
        if (r10 == null) goto L8;
        List<ShelfCardInfo> r2 = r10.a(getOpenPlatformContext().isInLive());
    L9:
        this.shelfInfoTemp = new ShelfInfo(r1, r2, 0, null, null, null, 1048572);
        return;
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void copyShelfInfoTemp(ShelfInfo r14) {
        Intrinsics.checkNotNullParameter(r14, "shelfInfo");
        this.shelfInfoTemp = ShelfInfo.a(r14, null, null, false, null, null, null, 1048575);
        this.initShelfInfo = ShelfInfo.a(r14, null, null, false, null, null, null, 1048575);
    }

    public final void setShelfInfoTemp(ShelfInfo r1) {
        this.shelfInfoTemp = r1;
    }

    public static final /* synthetic */ Map access$getCustomMap(AnchorShelfContextService r0, JSONObject r1) {
        return r0.getCustomMap(r1);
    }

    private final void saveCard(ExplainCardSettingsInfo r6, JSONObject r7) {
        Lazy r0 = LiveOpenPlatformClient.c;
        MiniAppExplainCardApi r1 = (MiniAppExplainCardApi) LiveOpenPlatformClient.a.a().a(MiniAppExplainCardApi.class);
        ShelfMicroAppInfo r2 = r6.g();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.appId;
    L6:
        ShelfCardInfo r5 = r6.shelfCardInfo;
        if (r5 == null) goto L9;
        String r8 = r5.a0();
    L10:
        ShelfCardInfo r9 = r6.shelfCardInfo;
        if (r9 == null) goto L13;
        r3 = r9.i0();
    L13:
        autoDispose(r1.getPresetCard(r4, r8, r3, true).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r7, r6), c.a));
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void openShelfDisplayPage(ShelfInfo r3, String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L15;
        if (((Boolean) ud0.a.getValue()).booleanValue() == false) goto L13;
        r4 = "more_btn_panel";
        goto L15
    L13:
        r4 = "operate_panel";
    L15:
        if (g.c(r3) == false) goto L17;
        Fragment r5 = new CoexistAnchorShelfDisplayDialog();
    L18:
        Bundle r1 = new Bundle();
        r1.putString("click_source", r4);
        Unit r6 = Unit.INSTANCE;
        r5.setArguments(r1);
        Context r7 = getOpenPlatformContext().getContext();
        if (r7 == null) goto L23;
        r5.aa0((FragmentActivity) r7);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L17:
        r5 = new CommonAnchorShelfDisplayDialog();
        goto L18
    L4:
        if (StringsKt.isBlank(r4) == true) goto L7;
        r0 = false;
        goto L8
    }

    public final void putCardOnShelf(ExplainCardSettingsInfo r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "explainCardSettingsInfo");
        ShelfInfo r1 = this.shelfInfoTemp;
        if (r1 != null) goto L5;
        this.shelfInfoTemp = r10.j();
    L12:
        BridgeContextService.g((BridgeContextService) getOpenPlatformContext().getService(BridgeContextService.class), "update_anchor_btn_state");
        if (r11 == null) goto L16;
        Unit r12 = (Unit) r11.invoke();
        return;
    L16:
        return;
    L5:
        ShelfCardInfo r13 = r10.shelfCardInfo;
        if (r13 == null) goto L12;
        List<ShelfCardInfo> r0 = r1.cardInfoList;
        if (r0 == null) goto L10;
        List r14 = CollectionsKt.plus(r0, r13);
    L11:
        this.shelfInfoTemp = ShelfInfo.a(r1, null, r14, false, null, null, null, 1048573);
        goto L12
    L10:
        r14 = null;
        goto L11
    }

    public final void takeCardOffFromShelf(String r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "page");
        ShelfInfo r0 = this.shelfInfoTemp;
        if (r0 == null) goto L22;
        List<ShelfCardInfo> r1 = r0.cardInfoList;
        if (r1 == null) goto L22;
        Iterator<T> r2 = r1.iterator();
    L7:
        ShelfInfo r3 = null;
        List r4 = null;
        if (r2.hasNext() == false) goto L12;
        Object r5 = r2.next();
        if (m.a(r12, ((ShelfCardInfo) r5).i0()) == false) goto L7;
    L13:
        ShelfCardInfo r6 = (ShelfCardInfo) r5;
        if (r6 == null) goto L22;
        ShelfInfo r7 = this.shelfInfoTemp;
        if (r7 == null) goto L21;
        List<ShelfCardInfo> r14 = r7.cardInfoList;
        if (r14 == null) goto L20;
        r4 = CollectionsKt.minus(r14, r6);
    L20:
        r3 = ShelfInfo.a(r7, null, r4, false, null, null, null, 1048573);
    L21:
        this.shelfInfoTemp = r3;
        goto L22
    L12:
        r5 = null;
    L22:
        BridgeContextService.g((BridgeContextService) getOpenPlatformContext().getService(BridgeContextService.class), "update_anchor_btn_state");
        if (r13 == null) goto L29;
        Unit r15 = (Unit) r13.invoke();
        return;
    }

    public final ShelfInfo updateAnchorLiveStatus(int r11, ShelfInfo r12) {
        Intrinsics.checkNotNullParameter(r12, "shelfInfo");
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        ShelfMicroAppInfo r1 = null;
        if (r0 == null) goto L11;
        n<ShelfInfo> r2 = r0.m618getShelfInfo();
        if (r2 == null) goto L11;
        ShelfInfo r3 = (ShelfInfo) r2.getValue();
        if (r3 == null) goto L11;
        ShelfMicroAppInfo r4 = r3.appInfo;
        if (r4 == null) goto L11;
        String r5 = r4.appId;
    L12:
        ShelfMicroAppInfo r6 = r12.appInfo;
        if (r6 == null) goto L15;
        String r7 = r6.appId;
    L17:
        if ((!Intrinsics.areEqual(r5, r7)) == false) goto L21;
        ShelfMicroAppInfo r8 = r12.appInfo;
        if (r8 == null) goto L23;
        r1 = ShelfMicroAppInfo.a(r8, null, r11, 47);
    L23:
        return ShelfInfo.a(r12, r1, null, false, null, null, null, 1048574);
    L21:
        r1 = r12.appInfo;
        goto L23
    L15:
        r7 = null;
    L11:
        r5 = null;
        goto L12
    }

    public static final /* synthetic */ void access$saveCard(AnchorShelfContextService r0, ExplainCardSettingsInfo r1, JSONObject r2) {
        r0.saveCard(r1, r2);
    }

    public void onModifyShelfSuccess(ShelfInfo r9, Function1<? super ShelfInfo, Unit> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "shelfInfo");
        qo0.a.c(TAG, "onModifyShelfSuccess");
        if (r10 == null) goto L5;
        Unit r12 = (Unit) r10.invoke(r9);
    L5:
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r13 = AnchorMiniAppDataContext.a.a();
        if (r13 == null) goto L10;
        n<ShelfInfo> r14 = r13.m618getShelfInfo();
        if (r14 == null) goto L10;
        r14.setValue(ShelfInfo.a(r9, null, null, false, null, null, null, 1048575));
    L10:
        List<ShelfCardInfo> r15 = r9.cardInfoList;
        if (r15 == null) goto L18;
        Iterator<T> r16 = r15.iterator();
    L14:
        if (r16.hasNext() == false) goto L18;
        ShelfCardInfo r17 = (ShelfCardInfo) r16.next();
        if (r17.K() == false) goto L14;
        ((AnchorMiniAppAppLogContextService) getOpenPlatformContext().getService(AnchorMiniAppAppLogContextService.class)).reportPageShelfAuditResult(r17);
    L18:
        xs2.b r18 = xs2.b.a();
        ShelfMicroAppInfo r19 = r9.appInfo;
        if (r19 == null) goto L22;
        String r20 = r19.appId;
        if (r20 == null) goto L22;
    L23:
        r18.post(new f0(r20, ReloadPanelType.FROM_CAHCE, true, false, 8));
        return;
    L22:
        r20 = "";
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onOffShelfSuccess$default(AnchorShelfContextService r0, Function0 r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.onOffShelfSuccess(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onOffShelfSuccess");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void saveShelf$default(AnchorShelfContextService r0, Function1 r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.saveShelf(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveShelf");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offShelf$default(AnchorShelfContextService r0, String r1, Function0 r2, int r3, Object r4) {
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

    public static /* synthetic */ void openShelfManagementPage$default(AnchorShelfContextService r0, ShelfInfo r1, String r2, int r3, Object r4) {
        if (r4 != null) goto L12;
        if ((r3 & 1) == 0) goto L7;
        r1 = r0.shelfInfoTemp;
    L7:
        if ((r3 & 2) == 0) goto L9;
        r2 = null;
    L9:
        r0.openShelfManagementPage(r1, r2);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openShelfManagementPage");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void putCardOnShelf$default(AnchorShelfContextService r0, ExplainCardSettingsInfo r1, Function0 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.putCardOnShelf(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: putCardOnShelf");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void takeCardOffFromShelf$default(AnchorShelfContextService r0, String r1, Function0 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.takeCardOffFromShelf(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeCardOffFromShelf");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onModifyShelfSuccess$default(AnchorShelfContextService r0, ShelfInfo r1, Function1 r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = null;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        r0.onModifyShelfSuccess(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onModifyShelfSuccess");
    }

    public static /* synthetic */ void openChoosePage$default(AnchorShelfContextService r0, String r1, String r2, p r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        r0.openChoosePage(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openChoosePage");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void modifyShelf$default(AnchorShelfContextService r1, ShelfInfo r2, boolean r3, Function1 r4, Function0 r5, int r6, Object r7) {
        if (r7 != null) goto L15;
        if ((r6 & 2) == 0) goto L7;
        r3 = false;
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = null;
    L10:
        if ((r6 & 8) == 0) goto L12;
        r5 = null;
    L12:
        r1.modifyShelf(r2, r3, r4, r5);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyShelf");
    }
}
