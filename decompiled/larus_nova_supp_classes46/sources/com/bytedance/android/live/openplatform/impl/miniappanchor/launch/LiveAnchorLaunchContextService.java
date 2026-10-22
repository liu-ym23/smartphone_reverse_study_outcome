package com.bytedance.android.live.openplatform.impl.miniappanchor.launch;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.utils.h;
import com.bytedance.android.live.openplatform.impl.base.constant.OpenPlatformConstants$LaunchSource;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.OpenInfoApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.d;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.launch.LaunchContextService;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\f\u001a\u00020\u0007J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016R$\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/launch/LiveAnchorLaunchContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/launch/AnchorLaunchContextService;", "", "schema", "Lko0/b;", "launchParams", "Lkotlin/Function0;", "", "openAction", "getMicroAppOpenInfo", "", "shouldLaunchInHostProcess", "openLiveCastingMiniApp", "onSuccess", "openMiniApp", "Lcom/bytedance/android/live/openplatform/impl/base/constant/OpenPlatformConstants$LaunchSource;", "<set-?>", "launchSource", "Lcom/bytedance/android/live/openplatform/impl/base/constant/OpenPlatformConstants$LaunchSource;", "getLaunchSource", "()Lcom/bytedance/android/live/openplatform/impl/base/constant/OpenPlatformConstants$LaunchSource;", "", "requestMicroAppOpenInfoMap", "Ljava/util/Map;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorLaunchContextService extends AnchorLaunchContextService {
    public static final a Companion = null;
    public static final String TAG = "LiveAnchorLaunchContextService";
    private OpenPlatformConstants$LaunchSource launchSource;
    private final Map<String, Boolean> requestMicroAppOpenInfoMap;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveAnchorLaunchContextService a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function0 c;

        public b(LiveAnchorLaunchContextService r1, String r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r3) {
            ((AnchorShelfContextService) LiveAnchorLaunchContextService.access$getOpenPlatformContext$p(this.a).getService(AnchorShelfContextService.class)).setShelfInfoTemp(((d) ((e) r3).data).a());
            LiveAnchorLaunchContextService.access$getRequestMicroAppOpenInfoMap$p(this.a).put(this.b, Boolean.TRUE);
            Function0 r4 = this.c;
            if (r4 == null) goto L6;
            Unit r5 = (Unit) r4.invoke();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            Function0 r3 = this.a;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }
    }

    static {
        Companion = new a();
    }

    private final boolean shouldLaunchInHostProcess() {
        if (getOpenPlatformContext().isAnchor() == false) goto L6;
        return true;
    L6:
        return false;
    }

    public final void openLiveCastingMiniApp() {
        ShelfInfo r0 = ((AnchorShelfContextService) getOpenPlatformContext().getService(AnchorShelfContextService.class)).getCurShelfInfo();
        if (r0 == null) goto L13;
        List<ShelfCardInfo> r1 = r0.cardInfoList;
        if (r1 == null) goto L14;
        ShelfCardInfo r2 = (ShelfCardInfo) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L15;
        String r3 = r2.a0();
        if (r3 == null) goto L16;
        LaunchContextService.openMiniApp$default(this, r3, new ko0.b(LaunchParamConstant$Scene.a, "live", "connection_panel", "solid_entrance", "connection_panel", "connection_panel", null, null, null, false, false, null, 16320), null, 4, null);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public final OpenPlatformConstants$LaunchSource getLaunchSource() {
        return this.launchSource;
    }

    public LiveAnchorLaunchContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.launchSource = OpenPlatformConstants$LaunchSource.Panel;
        this.requestMicroAppOpenInfoMap = new LinkedHashMap();
    }

    public static final /* synthetic */ OpenPlatformConstants$LaunchSource access$getLaunchSource$p(LiveAnchorLaunchContextService r0) {
        return r0.launchSource;
    }

    public static final /* synthetic */ OpenPlatformContext access$getOpenPlatformContext$p(LiveAnchorLaunchContextService r0) {
        return r0.getOpenPlatformContext();
    }

    public static final /* synthetic */ Map access$getRequestMicroAppOpenInfoMap$p(LiveAnchorLaunchContextService r0) {
        return r0.requestMicroAppOpenInfoMap;
    }

    public static final /* synthetic */ boolean access$shouldLaunchInHostProcess(LiveAnchorLaunchContextService r0) {
        return r0.shouldLaunchInHostProcess();
    }

    public static final /* synthetic */ void access$setLaunchSource$p(LiveAnchorLaunchContextService r0, OpenPlatformConstants$LaunchSource r1) {
        r0.launchSource = r1;
    }

    private final void getMicroAppOpenInfo(String r3, ko0.b r4, Function0<Unit> r5) {
        if (r4.m.isEmpty() == false) goto L7;
        if (r5 == null) goto L14;
        Unit r6 = (Unit) r5.invoke();
        return;
    L14:
        return;
    L7:
        String r7 = h.a(r3);
        if (Intrinsics.areEqual(this.requestMicroAppOpenInfoMap.get(r7), Boolean.TRUE) == false) goto L12;
        if (r5 == null) goto L15;
        Unit r8 = (Unit) r5.invoke();
        return;
    L15:
        return;
    L12:
        Lazy r0 = LiveOpenPlatformClient.c;
        autoDispose(((OpenInfoApi) LiveOpenPlatformClient.a.a().a(OpenInfoApi.class)).getMicroAppOpenInfo(new com.bytedance.android.live.openplatform.impl.miniappanchor.api.request.a(r7, r4.m)).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r7, r5), new c(r5)));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.launch.AnchorLaunchContextService, com.bytedance.android.live.openplatform.impl.miniappcommon.launch.LaunchContextService
    public void openMiniApp(final String r2, final ko0.b r3, final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "launchParams");
        getMicroAppOpenInfo(r2, r3, new AnonymousClass1(this, r3, r2, r4));
    }

    /* JADX INFO: renamed from: access$openMiniApp$s-1738930918, reason: not valid java name */
    public static final /* synthetic */ void m687access$openMiniApp$s1738930918(LiveAnchorLaunchContextService r0, String r1, ko0.b r2, Function0 r3) {
        super.openMiniApp(r1, r2, r3);
    }
}
