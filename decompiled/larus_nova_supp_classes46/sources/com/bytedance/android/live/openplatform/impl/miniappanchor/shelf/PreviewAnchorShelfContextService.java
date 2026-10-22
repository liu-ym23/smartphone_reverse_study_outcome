package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf;

import android.content.Context;
import android.content.Intent;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.LiveToolbarMountType;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.PreviewMountApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.PreviewMiniAppChooseActivity;
import com.bytedance.android.live.openplatform.impl.miniappanchor.context.PreviewAnchorMiniAppContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview.PreviewShelfManagementActivity;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview.PreviewShelfManagementActivityV2;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mh1.p;
import zo0.f;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J@\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0016J0\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0016J\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/PreviewAnchorShelfContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/AnchorShelfContextService;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "", "source", "", "openShelfManagementPage", "", "isBeforeStart", "Lkotlin/Function1;", "onSuccess", "Lkotlin/Function0;", "onFail", "modifyShelf", "exitSource", "offShelf", "onModifyShelfSuccess", "onOffShelfSuccess", "clickSource", "liveType", "Lmh1/p;", "miniAppOuterHelper", "openChoosePage", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewAnchorShelfContextService extends AnchorShelfContextService {
    public static final a Companion = null;
    private static final String TAG = "PreviewAnchorShelfContextService";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            e r3 = (e) r2;
            qo0.a.c(PreviewAnchorShelfContextService.TAG, "request pre/app/start success");
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
            qo0.a.b(PreviewAnchorShelfContextService.TAG, "request pre/app/start fail", (Throwable) r3);
        }
    }

    static {
        Companion = new a();
    }

    public PreviewAnchorShelfContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void onOffShelfSuccess(Function0<Unit> r3) {
        ShelfInfo r0 = getCurShelfInfo();
        if (r0 != null) goto L5;
    L12:
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r1 = AnchorMiniAppDataContext.a.a();
        if (r1 == null) goto L24;
        n<ShelfInfo> r2 = r1.m618getShelfInfo();
        if (r2 == null) goto L24;
        ShelfInfo r4 = (ShelfInfo) r2.getValue();
        if (r4 == null) goto L24;
        IInteractGameService r5 = k.n(IInteractGameService.class);
        ShelfMicroAppInfo r6 = r4.appInfo;
        if (r6 == null) goto L22;
        String r7 = r6.appId;
        if (r7 == null) goto L22;
    L23:
        r5.deleteData(r7);
    L22:
        r7 = "";
    L24:
        super.onOffShelfSuccess(r3);
        xs2.b.a().post(new d10.d());
        return;
    L5:
        if (r0.e() != true) goto L12;
        OpenPlatformContext r8 = getOpenPlatformContext();
        if ((r8 instanceof PreviewAnchorMiniAppContext) == true) goto L9;
        r8 = null;
    L9:
        PreviewAnchorMiniAppContext r9 = (PreviewAnchorMiniAppContext) r8;
        if (r9 == null) goto L12;
        r9.clearTalentPayload();
        goto L12
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void offShelf(String r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "exitSource");
        onOffShelfSuccess(r3);
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).removeToolbarComponent(3);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void openShelfManagementPage(ShelfInfo r3, String r4) {
        if (((uc1) ee0.a.getValue()).g() == false) goto L5;
        int r5 = PreviewShelfManagementActivityV2.l;
        Context r6 = getOpenPlatformContext().getContext();
        Intrinsics.checkNotNullParameter(r6, "context");
        r6.startActivity(new Intent(r6, PreviewShelfManagementActivityV2.class));
        return;
    L5:
        int r7 = PreviewShelfManagementActivity.k;
        Context r8 = getOpenPlatformContext().getContext();
        if (r3 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r3, "shelfInfo");
        Intent r0 = new Intent(r8, PreviewShelfManagementActivity.class);
        r0.putExtra("key_shelf_info_data", r3);
        Unit r9 = Unit.INSTANCE;
        r8.startActivity(r0);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void onModifyShelfSuccess(ShelfInfo r3, Function1<? super ShelfInfo, Unit> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "shelfInfo");
        if (r3.e() == true) goto L14;
        ShelfInfo r0 = getCurShelfInfo();
        if (r0 == null) goto L14;
        if (r0.e() != true) goto L14;
        OpenPlatformContext r1 = getOpenPlatformContext();
        if ((r1 instanceof PreviewAnchorMiniAppContext) == true) goto L11;
        r1 = null;
    L11:
        PreviewAnchorMiniAppContext r2 = (PreviewAnchorMiniAppContext) r1;
        if (r2 == null) goto L14;
        r2.clearTalentPayload();
    L14:
        ShelfInfo r6 = updateAnchorLiveStatus(0, r3);
        super.onModifyShelfSuccess(r6, r4, r5);
        IInteractGameService r7 = k.n(IInteractGameService.class);
        ShelfMicroAppInfo r8 = r6.appInfo;
        if (r8 == null) goto L18;
        String r9 = r8.appId;
        if (r9 == null) goto L18;
    L19:
        r7.addItemToDataCacheHelper(r9);
        return;
    L18:
        r9 = "";
        goto L19
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void openChoosePage(String r3, String r4, p r5) {
        Intrinsics.checkNotNullParameter(r3, "clickSource");
        Intrinsics.checkNotNullParameter(r4, "liveType");
        HashMap<String, f> r6 = g.a;
        PerformanceScene r7 = PerformanceScene.CHOOSE_PAGE;
        h.b(r7).o();
        zo0.a.a(r7).a();
        Context r8 = getOpenPlatformContext().getContext();
        Intent r0 = new Intent(r8, PreviewMiniAppChooseActivity.class);
        r0.putExtra("extra_key_click_source", r3);
        r0.putExtra("extra_key_live_type", r4);
        Unit r9 = Unit.INSTANCE;
        r8.startActivity(r0);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService
    public void modifyShelf(ShelfInfo r1, boolean r2, Function1<? super ShelfInfo, Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "shelfInfo");
        onModifyShelfSuccess(r1, r3, r2);
        qo0.a.c(TAG, "request pre/app/start begin");
        Lazy r5 = LiveOpenPlatformClient.c;
        PreviewMountApi r6 = (PreviewMountApi) LiveOpenPlatformClient.a.a().a(PreviewMountApi.class);
        ShelfMicroAppInfo r7 = r1.appInfo;
        if (r7 == null) goto L6;
        String r8 = r7.appId;
        if (r8 == null) goto L6;
    L7:
        autoDispose(r6.preAppStart(r8).compose(RxUtil.rxSchedulerHelper()).subscribe(b.a, c.a));
        IBroadcastService r9 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r1.isAutoMount == false) goto L10;
        LiveToolbarMountType r10 = LiveToolbarMountType.AUTO;
    L11:
        r9.mountToolbarComponent(3, r10);
        return;
    L10:
        r10 = LiveToolbarMountType.MANUAL;
    L6:
        r8 = "";
        goto L7
    }
}
