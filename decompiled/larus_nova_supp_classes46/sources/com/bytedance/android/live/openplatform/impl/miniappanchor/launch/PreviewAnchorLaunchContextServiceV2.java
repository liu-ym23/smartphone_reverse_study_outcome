package com.bytedance.android.live.openplatform.impl.miniappanchor.launch;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.utils.h;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.OpenInfoApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.d;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.launch.CommonLaunchContextService;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import w20.lc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J:\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J*\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/launch/PreviewAnchorLaunchContextServiceV2;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/launch/CommonLaunchContextService;", "", "schema", "Lw20/lc$a;", "params", "Lkotlin/Function0;", "", "onSuccess", "onFail", "getMicroAppOpenInfo", "openMicroApp", "", "", "requestMicroAppOpenInfoMap", "Ljava/util/Map;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewAnchorLaunchContextServiceV2 extends CommonLaunchContextService {
    private final Map<String, Boolean> requestMicroAppOpenInfoMap;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ PreviewAnchorLaunchContextServiceV2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function0 c;

        public a(PreviewAnchorLaunchContextServiceV2 r1, String r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r3) {
            ((AnchorShelfContextService) PreviewAnchorLaunchContextServiceV2.access$getOpenPlatformContext$p(this.a).getService(AnchorShelfContextService.class)).setShelfInfoTemp(((d) ((e) r3).data).a());
            PreviewAnchorLaunchContextServiceV2.access$getRequestMicroAppOpenInfoMap$p(this.a).put(this.b, Boolean.TRUE);
            Function0 r4 = this.c;
            if (r4 == null) goto L6;
            Unit r5 = (Unit) r4.invoke();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
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

    public PreviewAnchorLaunchContextServiceV2(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.requestMicroAppOpenInfoMap = new LinkedHashMap();
    }

    public static final /* synthetic */ OpenPlatformContext access$getOpenPlatformContext$p(PreviewAnchorLaunchContextServiceV2 r0) {
        return r0.getOpenPlatformContext();
    }

    public static final /* synthetic */ Map access$getRequestMicroAppOpenInfoMap$p(PreviewAnchorLaunchContextServiceV2 r0) {
        return r0.requestMicroAppOpenInfoMap;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.launch.CommonLaunchContextService
    public void openMicroApp(final String r3, final lc.a r4, final Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        getMicroAppOpenInfo(r3, r4, new AnonymousClass1(this), new AnonymousClass2(this, r3, r4, r5));
    }

    public static final /* synthetic */ void access$openMicroApp$s536659410(PreviewAnchorLaunchContextServiceV2 r0, String r1, lc.a r2, Function0 r3) {
        super.openMicroApp(r1, r2, r3);
    }

    private final void getMicroAppOpenInfo(String r3, lc.a r4, Function0<Unit> r5, Function0<Unit> r6) {
        if (r4 == null) goto L4;
        List r0 = r4.a();
    L5:
        List r1 = r0;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L16;
        if (r6 == null) goto L23;
        Unit r7 = (Unit) r6.invoke();
        return;
    L23:
        return;
    L16:
        String r8 = h.a(r3);
        if (Intrinsics.areEqual(this.requestMicroAppOpenInfoMap.get(r8), Boolean.TRUE) == false) goto L21;
        if (r6 == null) goto L24;
        Unit r9 = (Unit) r6.invoke();
        return;
    L24:
        return;
    L21:
        Lazy r10 = LiveOpenPlatformClient.c;
        OpenInfoApi r11 = (OpenInfoApi) LiveOpenPlatformClient.a.a().a(OpenInfoApi.class);
        Intrinsics.checkNotNull(r4);
        autoDispose(r11.getMicroAppOpenInfo(new com.bytedance.android.live.openplatform.impl.miniappanchor.api.request.a(r8, r4.a())).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r8, r5), new b(r6)));
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    L4:
        r0 = null;
        goto L5
    }
}
