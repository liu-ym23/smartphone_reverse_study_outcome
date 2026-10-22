package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.lynx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBasePagerFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c;
import com.bytedance.live.datacontext.n;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zo0.f;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/lynx/MiniAppChooseLynxFragment;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/MiniAppChooseBasePagerFragment;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/c;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseLynxFragment extends MiniAppChooseBasePagerFragment implements c {
    public static final /* synthetic */ int j = 0;
    public lp0.a f;
    public ViewGroup g;
    public HybridCard h;
    public String i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBasePagerFragment
    public final void S90() {
        HashMap<String, f> r0 = g.a;
        f r1 = h.b(PerformanceScene.CHOOSE_PAGE_LYNX);
        Function0<Unit> r3 = new MiniAppChooseLynxFragment$loadData$1(this);
        int r4 = f.d;
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter("list_request_data_begin", "beginEvent");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter("list_request_data_end", "endEvent");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r3, "action");     // Catch: Throwable -> L7
        r1.l("list_request_data_begin", null);     // Catch: Throwable -> L7
        r3.invoke();     // Catch: Throwable -> L7
        r1.l("list_request_data_end", null);     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public MiniAppChooseLynxFragment() {
        this.i = "";
    }

    public final void onDestroy() {
        super.onDestroy();
        lp0.a r0 = this.f;
        if (r0 == null) goto L7;
        b r1 = r0.getContainer();
        if (r1 == null) goto L7;
        r1.j30(this);
    L7:
        ViewGroup r2 = this.g;
        if (r2 == null) goto L10;
        r2.removeAllViews();
    L10:
        HybridCard r3 = this.h;
        if (r3 == null) goto L14;
        r3.release();
        return;
    }

    public final void onResume() {
        super.onResume();
        HybridCard r0 = this.h;
        if (r0 == null) goto L6;
        r0.sendJsEvent("onShow", "{}");
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c
    public final void MX(int r3) {
        if (r3 == 0) goto L7;
        HybridCard r4 = this.h;
        if (r4 == null) goto L8;
        r4.sendJsEvent("onTalentTabChange", "{}");
        return;
    L8:
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L12;
        n<MiniAppEntrancePermissionResponse> r1 = r0.getEntranceInfo();
        if (r1 == null) goto L12;
        MiniAppEntrancePermissionResponse r2 = (MiniAppEntrancePermissionResponse) r1.getValue();
        if (r2 == null) goto L12;
        Map r4 = r2.getUrl_list();
        if (r4 == null) goto L12;
        String r5 = (String) r4.get("talent_h5_url");
        if (r5 == null) goto L12;
    L13:
        this.i = r5;
        lp0.a r6 = this.f;
        if (r6 == null) goto L18;
        b r7 = r6.getContainer();
        if (r7 == null) goto L18;
        r7.Iz(this);
    L18:
        if (r3 != null) goto L20;
        HashMap<String, f> r8 = g.a;
        h.b(PerformanceScene.CHOOSE_PAGE_LYNX).o();
        return;
    L20:
        HashMap<String, f> r9 = g.a;
        h.b(PerformanceScene.CHOOSE_PAGE_LYNX).n();
        return;
    L12:
        r5 = "";
        goto L13
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBasePagerFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.g = (ViewGroup) r2.findViewById(2131379312);
        super.onViewCreated(r2, r3);
        HashMap<String, f> r4 = g.a;
        f r5 = h.b(PerformanceScene.CHOOSE_PAGE_LYNX);
        int r6 = f.d;
        r5.l("view_created", null);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566942, r3, false);
    }
}
