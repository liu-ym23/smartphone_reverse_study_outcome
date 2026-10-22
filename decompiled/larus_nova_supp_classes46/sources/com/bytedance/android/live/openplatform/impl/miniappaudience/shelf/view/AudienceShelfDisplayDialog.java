package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ListView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.MicroAppLabel;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAudienceServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfInfoService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.viewmodel.AudienceShelfDisplayViewModel;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.MicroAppLabelListAdapter;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qq0.h;
import qq0.k;
import qq0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/view/AudienceShelfDisplayDialog;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonShelfDisplayDialog;", "Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/viewmodel/AudienceShelfDisplayViewModel;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AudienceShelfDisplayDialog extends CommonShelfDisplayDialog<AudienceShelfDisplayViewModel> {
    public static final /* synthetic */ int v = 0;
    public Map<Integer, View> j;
    public to0.a k;
    public OpenPlatformContext l;
    public boolean m;
    public final List<ShelfCardInfo> n;
    public int o;
    public int p;
    public final MicroAppLabelListAdapter q;
    public final e r;
    public final com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d s;
    public final b t;
    public final d u;

    public static final class a {
    }

    public static final class b extends IHostAppMonitorListener.Stub {
        public final /* synthetic */ AudienceShelfDisplayDialog a;

        public b(AudienceShelfDisplayDialog r1) {
            this.a = r1;
        }

        public final void appEnterBackground(boolean r2, boolean r3) {
            super.appEnterBackground(r2, r3);
            if (r2 == false) goto L5;
            qo0.a.c("AudienceShelfDisplayDialog", "transit event EnterBackground, caused by app enter background");
            this.a.s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.C0173b.a);
            return;
        L5:
            qo0.a.c("AudienceShelfDisplayDialog", "transit event EnterForeground, caused by app enter foreground");
            this.a.s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.c.a);
            Iterator r4 = ((ArrayList) this.a.n).iterator();
        L7:
            if (r4.hasNext() == false) goto L11;
            ShelfCardInfo r5 = (ShelfCardInfo) r4.next();
            this.a.ca0(r5);
            goto L7
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ AudienceShelfDisplayDialog a;

        public c(AudienceShelfDisplayDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            to0.a r0 = this.a.k;     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            OpenPlatformContext r1 = r0.a();     // Catch: Throwable -> L10
            if (r1 != null) goto L7;
            return;
        L7:
            if (((OpenPlatformPerformanceReportService) r1.getService(OpenPlatformPerformanceReportService.class)) == null) goto L18;
            OpenPlatformPerformanceReportService.j(false);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class d implements OnMiniAppLifecycleChangeListener {
        public final /* synthetic */ AudienceShelfDisplayDialog a;

        @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener
        public final void a() {
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener
        public final void c() {
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener
        public final void b() {
            qo0.a.c("AudienceShelfDisplayDialog", "transit event OpenMiniApp, caused by open miniapp");
            this.a.s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.C0174d.a);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener
        public final void d() {
            qo0.a.c("AudienceShelfDisplayDialog", "transit event CloseMiniApp, caused by close miniapp");
            this.a.s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.a.a);
        }

        public d(AudienceShelfDisplayDialog r1) {
            this.a = r1;
        }
    }

    public static final class e implements k {
        public final /* synthetic */ AudienceShelfDisplayDialog a;

        public e(AudienceShelfDisplayDialog r1) {
            this.a = r1;
        }

        @Override // qq0.k
        public final void a(rq0.a r5, MountedMiniAppSource r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "cardInfo");
            Intrinsics.checkNotNullParameter(r6, "source");
            if (r6 != MountedMiniAppSource.ShelfPageCardActionButton) goto L5;
            String r0 = "view";
        L6:
            OpenPlatformContext r1 = this.a.l;
            if (r1 == null) goto L11;
            AudienceMiniAppAppLogContextService r2 = (AudienceMiniAppAppLogContextService) r1.getService(AudienceMiniAppAppLogContextService.class);
            if (r2 == null) goto L11;
            r2.reportMpLiveLinkShelfCardClick(r5.a, r0, r7, this.a.da0());
        L11:
            OpenPlatformContext r8 = this.a.l;
            if (r8 == null) goto L16;
            AudienceLaunchContextService r9 = (AudienceLaunchContextService) r8.getService(AudienceLaunchContextService.class);
            if (r9 == null) goto L16;
            r9.openMiniApp(r6, r5.a);
        L16:
            OpenPlatformContext r10 = this.a.l;
            if (r10 == null) goto L22;
            AudienceShelfInfoService r11 = (AudienceShelfInfoService) r10.getService(AudienceShelfInfoService.class);
            if (r11 == null) goto L23;
            r11.m(3, r5.getCardId());
            return;
        L23:
            return;
        L22:
            return;
        L5:
            r0 = "card";
            goto L6
        }
    }

    public static final class f implements com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.a {
        public final /* synthetic */ AudienceShelfDisplayDialog a;

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.a
        public final void a() {
            OpenPlatformContext r0 = this.a.l;
            if (r0 == null) goto L8;
            AudienceMiniAppAppLogContextService r1 = (AudienceMiniAppAppLogContextService) r0.getService(AudienceMiniAppAppLogContextService.class);
            if (r1 == null) goto L9;
            r1.reportMpLiveLinkShelfShow(this.a.da0());
            return;
        L9:
            return;
        }

        public f(AudienceShelfDisplayDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.a
        public final void b(long r3, long r5) {
            OpenPlatformContext r0 = this.a.l;
            if (r0 == null) goto L8;
            AudienceMiniAppAppLogContextService r1 = (AudienceMiniAppAppLogContextService) r0.getService(AudienceMiniAppAppLogContextService.class);
            if (r1 == null) goto L9;
            r1.reportMpLiveLinkShelfStayTime(r3, r5);
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void S90() {
        this.j.clear();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final int U90() {
        ee0 r0 = ee0.a;
        int r1 = ((uc1) r0.getValue()).p();
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L9;
        MiniAppDataContext.Companion.getClass();
        if (g.d(MiniAppDataContext.a.b()) == true) goto L11;
    L9:
        return 0;
    L11:
        return UtilityKotlinExtentionsKt.i(((uc1) r0.getValue()).r());
    }

    public AudienceShelfDisplayDialog() {
        this.j = new LinkedHashMap();
        this.m = true;
        this.n = new ArrayList();
        this.o = -1;
        this.p = -1;
        this.q = new MicroAppLabelListAdapter(new ArrayList());
        this.r = new e(this);
        this.s = new com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d(new f(this));
        this.t = new b(this);
        this.u = new d(this);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final CommonShelfDisplayViewModel Z90() {
        return (AudienceShelfDisplayViewModel) ViewModelProviders.of(this).get(AudienceShelfDisplayViewModel.class);
    }

    public final boolean da0() {
        ShelfMicroAppInfo r0 = (ShelfMicroAppInfo) W90().getShelfMicroAppInfo().getValue();
        if (r0 == null) goto L5;
        List<MicroAppLabel> r1 = r0.label;
    L6:
        List<MicroAppLabel> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        return !r3;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void initView() {
        super.initView();
        View r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        r0.setBackgroundResource(2131250108);
        X90().setOnClickListener(new qq0.e(this));
        ((ListView) X90().findViewById(2131377098)).setAdapter(this.q);
        W90().getShelfMicroAppInfo().observe(this, new qq0.f(this));
        W90().getShelfCardInfoList().observe(this, new qq0.a(this));
        W90().getCardListChanged().observe(this, new qq0.b(this));
        W90().getDisplayItemInfoList().observe(this, new qq0.c(this));
        V90().z2(lo0.a.class, new l(new qq0.d(this)));
        V90().z2(rq0.a.class, new h(this.r));
        T90(2131386216).addOnScrollListener(new AudienceShelfDisplayDialog$initListView$5(this));
        T90(2131386216).post(new c(this));
        OpenPlatformContext r1 = this.l;
        int r2 = 1;
        if (r1 != null) goto L8;
    L10:
        int r3 = no0.a.a;
        no0.a.d(2, r2, 5, "", "");
        return;
    L8:
        if (r1.isInLive() != true) goto L10;
        r2 = 2;
        goto L10
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void onDestroyView() {
        super.onDestroyView();
        OpenPlatformContext r0 = this.l;
        if ((r0 instanceof MiniAppContext) == true) goto L5;
        r0 = null;
    L5:
        MiniAppContext r1 = (MiniAppContext) r0;
        if (r1 == null) goto L8;
        r1.unregisterMiniAppLifecycleChangeListener(this.u);
    L8:
        Lazy r2 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().b(this.t);
        qo0.a.c("AudienceShelfDisplayDialog", "transit event EnterBackground, caused by close shelf");
        this.s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.C0173b.a);
        S90();
    }

    public static final void ba0(AudienceShelfDisplayDialog r12) {
        LinearLayoutManager r1 = r12.T90(2131386216).getLayoutManager();
        if (r1 == null) goto L40;
        int r2 = r1.findFirstVisibleItemPosition();
        LinearLayoutManager r0 = r12.T90(2131386216).getLayoutManager();
        if (r0 == null) goto L38;
        int r3 = r0.findLastVisibleItemPosition();
        List r4 = (List) r12.W90().getDisplayItemInfoList().getValue();
        if (r4 != null) goto L9;
        return;
    L9:
        if (r3 >= r4.size()) goto L53;
        if (r2 > r3) goto L29;
        int r5 = r2;
    L12:
        Object r6 = ListProtector.get(r4, r5);
        if ((r6 instanceof rq0.a) == false) goto L27;
        Iterator r7 = ((ArrayList) r12.n).iterator();
    L16:
        if (r7.hasNext() == false) goto L23;
        Object r8 = r7.next();
        if (((ShelfCardInfo) r8).getCardId() != ((rq0.a) r6).a.getCardId()) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L16;
    L25:
        if (((ShelfCardInfo) r8) != null) goto L27;
        r12.ca0(((rq0.a) r6).a);
        goto L27
    L20:
        r9 = false;
        goto L21
    L23:
        r8 = null;
    L27:
        if (r5 == r3) goto L29;
        r5 = r5 + 1;
    L29:
        ((ArrayList) r12.n).clear();
        Iterator r10 = r4.subList(r2, r3 + 1).iterator();
    L31:
        if (r10.hasNext() == false) goto L35;
        Object r11 = r10.next();
        if ((r11 instanceof rq0.a) == false) goto L31;
        List<ShelfCardInfo> r13 = r12.n;
        ArrayList r14 = (ArrayList) r13;
        r14.add(((rq0.a) r11).a);
        goto L31
    L35:
        r12.o = r2;
        r12.p = r3;
        return;
    L53:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final View T90(int r3) {
        if (this.j != null) goto L5;
        this.j = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.j).get(2131386216);
        if (r4 != null) goto L14;
        View r5 = getView();
        if (r5 == null) goto L12;
        View r6 = r5.findViewById(2131386216);
        if (r6 == null) goto L12;
        this.j.put(2131386216, r6);
        return r6;
    L12:
        return null;
    L14:
        return r4;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final View Y90(View r3) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        ViewStub r4 = (ViewStub) r3.findViewById(2131389242);
        r4.setLayoutResource(2131566970);
        View r5 = r4.inflate();
        int r0 = UtilityKotlinExtentionsKt.i(60);
        Intrinsics.checkNotNullParameter(r5, "$this$setHeight");
        r5.getLayoutParams().height = r0;
        r5.requestLayout();
        return r5;
    }

    public final void ca0(ShelfCardInfo r4) {
        OpenPlatformContext r0 = this.l;
        if (r0 == null) goto L8;
        AudienceMiniAppAppLogContextService r1 = (AudienceMiniAppAppLogContextService) r0.getService(AudienceMiniAppAppLogContextService.class);
        if (r1 == null) goto L9;
        r1.reportMpLiveLinkShelfCardShow(r4, W90().isPinCard(r4), da0());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        OpenPlatformAudienceServiceImpl.Companion.getClass();
        po0.a.b r4 = (po0.a.b) OpenPlatformAudienceServiceImpl.access$getDiComponent$cp();
        r4.getClass();
        to0.a r5 = (to0.a) r4.a.d.get();
        this.k = r5;
        OpenPlatformContext r6 = null;
        if (r5 == null) goto L5;
        OpenPlatformContext r7 = r5.a();
    L6:
        this.l = r7;
        if ((r7 instanceof MiniAppContext) == false) goto L10;
        r6 = r7;
    L10:
        MiniAppContext r8 = (MiniAppContext) r6;
        if (r8 == null) goto L13;
        r8.registerMiniAppLifecycleChangeListener(this.u);
    L13:
        qo0.a.c("AudienceShelfDisplayDialog", "transit event EnterForeground, caused by open shelf");
        this.s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.c.a);
        Lazy r9 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().a(this.t);
        return;
    L5:
        r7 = null;
        goto L6
    }
}
