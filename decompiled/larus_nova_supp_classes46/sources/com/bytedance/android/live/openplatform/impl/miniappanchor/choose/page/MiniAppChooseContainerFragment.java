package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.intro.MiniAppChooseIntroFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.MiniAppChooseListFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.lynx.MiniAppChooseLynxFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search.MiniAppChooseSearchFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.MiniAppChooseTalentSettingUtil;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.MiniAppChooseTitleBar;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import e33.k;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/MiniAppChooseContainerFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/b;", "", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseContainerFragment extends BaseFragment implements com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b {
    public static final /* synthetic */ int r = 0;
    public Map<Integer, View> d;
    public so0.a e;
    public com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a f;
    public lp0.c g;
    public final List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c> h;
    public TabLayout i;
    public ViewPager j;
    public MiniAppChooseContainerTabPagerAdapter k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public int p;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a q;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MiniAppChooseContainerFragment a;

        public b(MiniAppChooseContainerFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ep0.a r2 = (ep0.a) r1;
            com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a r3 = this.a.f;
            if (r3 == null) goto L6;
            r3.close();
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MiniAppChooseContainerFragment a;

        public c(MiniAppChooseContainerFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            zo0.a.a(PerformanceScene.CHOOSE_PAGE).b((zo0.b.a) lp0.b.b(this.a.T90(), OpenPlatformPerformanceReportService.class));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b
    public final void Cx() {
        MiniAppChooseContainerTabPagerAdapter r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L5:
        MiniAppChooseSearchFragment r1 = (MiniAppChooseSearchFragment) this.m.getValue();
        if (r1 == null) goto L8;
        ListProtector.remove(r0.a, 0);
        ListProtector.add(r0.a, 0, r1);
        r0.notifyDataSetChanged();
        return;
    L8:
        r0.getClass();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b
    public final void Eq() {
        MiniAppChooseContainerTabPagerAdapter r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L5:
        MiniAppChooseListFragment r1 = (MiniAppChooseListFragment) this.n.getValue();
        if (r1 == null) goto L8;
        ListProtector.remove(r0.a, 0);
        ListProtector.add(r0.a, 0, r1);
        r0.notifyDataSetChanged();
        return;
    L8:
        r0.getClass();
    }

    public final lp0.a T90() {
        lp0.c r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L5:
        return r0;
    }

    public final void U90() {
        qo0.a.c("choose_container", "reportLandingPageShow");
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L7;
        n<MiniAppEntrancePermissionResponse> r1 = r0.getEntranceInfo();
        if (r1 == null) goto L7;
        MiniAppEntrancePermissionResponse r2 = (MiniAppEntrancePermissionResponse) r1.getValue();
    L9:
        if (r2 != null) goto L11;
    L16:
        String r3 = "normal_info";
    L18:
        if (MiniAppChooseTalentSettingUtil.b() == false) goto L20;
        String r4 = "bind_taskset";
    L21:
        lp0.c r5 = this.g;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L24:
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.c r6 = lp0.b.c(r5);
        if (r6 == null) goto L28;
        String r7 = r6.a;
        if (r7 == null) goto L28;
    L29:
        lp0.c r8 = this.g;
        if (r8 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L32:
        mp0.a r9 = lp0.b.a(r8);
        if (r9 == null) goto L40;
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "tabModule");
        Intrinsics.checkNotNullParameter(r7, "clickSource");
        g r10 = u.l();
        Pair[] r11 = new Pair[6];
        r11[0] = TuplesKt.to("_param_for_special", "micro_app");
        r11[1] = TuplesKt.to("show_module", "bind");
        r11[2] = TuplesKt.to("show_content", r3);
        if (lp0.b.d(r9.d) == false) goto L37;
        String r12 = "in_live";
    L38:
        r11[3] = TuplesKt.to("live_status", r12);
        r11[4] = TuplesKt.to("tab_module", r4);
        r11[5] = TuplesKt.to("click_source", r7);
        r10.e("mp_live_bind_landing_page_show", MapsKt.mutableMapOf(r11), new Object[]{Room.class});
        return;
    L37:
        r12 = "before_live";
        goto L38
    L40:
        return;
    L28:
        r7 = "";
        goto L29
    L20:
        r4 = "bind_only";
        goto L21
    L11:
        if (r2.getShowIntroPanel() != true) goto L16;
        if (r2.getPermit() == false) goto L15;
        r3 = "satisfied";
        goto L18
    L15:
        r3 = "not_satisfied";
    L7:
        r2 = null;
        goto L9
    }

    public MiniAppChooseContainerFragment() {
        this.q = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.d = new LinkedHashMap();
        this.h = new ArrayList();
        this.l = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseContainerFragment$chooseIntroFragment$2(this));
        this.m = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseContainerFragment$chooseSearchFragment$2(this));
        this.n = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseContainerFragment$chooseListFragment$2(this));
        this.o = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseContainerFragment$chooseLynxFragment$2(this));
        this.p = -1;
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r0 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.e = r0;
    }

    public final void onDestroy() {
        super.onDestroy();
        qo0.a.c("choose_container", "container fragment destroyed, leave scope");
        lp0.c r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L5:
        l.c(r0);
        this.q.b();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b
    public final void Iz(com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.h).add(r2);
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b
    public final void j30(com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.h).remove(r2);
    }

    public final void onAttach(Context r7) {
        String r0 = "context";
        Intrinsics.checkNotNullParameter(r7, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r7);
        qo0.a.c("choose_container", "container fragment attached, create scope");
        so0.a r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a r3 = this.f;
        Intrinsics.checkNotNullParameter(r1, "anchorService");
        Intrinsics.checkNotNullParameter(r7, "ctx");
        Intrinsics.checkNotNullParameter(this, "chooseContainer");
        m.e.getClass();
        lp0.c r4 = new lp0.c(m.d);
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r1, "value");
        r4.e = r1;
        Intrinsics.checkNotNullParameter(r7, "value");
        r4.f = r7;
        r4.g = r3;
        Intrinsics.checkNotNullParameter(this, "value");
        r4.h = this;
        Object r8 = k.a;
        if (r4.e != r8) goto L9;
        r0 = "miniAppAnchorService";
    L17:
        if (r0 != null) goto L21;
        this.g = r4;
        return;
    L21:
        throw new UninitializedPropertyAccessException(r0);
    L9:
        if (r4.f == r8) goto L17;
        if (r4.g != r8) goto L14;
        r0 = "root";
        goto L17
    L14:
        if (this != r8) goto L16;
        r0 = "container";
        goto L17
    L16:
        r0 = null;
        goto L17
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        qo0.a.c("choose_container", "container fragment created, enter scope");
        lp0.c r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L5:
        l.a(r0);
        Disposable r1 = xs2.b.a().b(ep0.a.class).subscribe(new b(this));
        Intrinsics.checkNotNullParameter(r1, "$this$autoDispose");
        this.q.a(r1);
        if (r4 == null) goto L8;
        HashMap<String, zo0.f> r5 = zo0.g.a;
        h.b(PerformanceScene.CHOOSE_PAGE).n();
    L8:
        lp0.c r6 = this.g;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L11:
        mp0.a r7 = lp0.b.a(r6);
        if (r7 == null) goto L15;
        mp0.a.c(r7, "container_loaded", null, null, 14);
        return;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r9 = AnchorMiniAppDataContext.a.a();
        if (r9 == null) goto L7;
        n<MiniAppEntrancePermissionResponse> r10 = r9.getEntranceInfo();
        if (r10 == null) goto L7;
        final MiniAppEntrancePermissionResponse r11 = (MiniAppEntrancePermissionResponse) r10.getValue();
    L8:
        ((MiniAppChooseTitleBar) S90(2131388807)).setCloseBtnOnClickListener(new MiniAppChooseContainerFragment$initTitleBar$1(this));
        ((MiniAppChooseTitleBar) S90(2131388807)).setHelpBtnOnClickListener(new MiniAppChooseContainerFragment$initTitleBar$2(this, r11));
        if (v.a() == false) goto L11;
        ((MiniAppChooseTitleBar) S90(2131388807)).setHelpBtnOnLongClickListener(new MiniAppChooseContainerFragment$initTitleBar$3(this));
    L11:
        MiniAppChooseTitleBar r0 = (MiniAppChooseTitleBar) S90(2131388807);
        if (r11 != null) goto L14;
    L17:
        boolean r12 = true;
    L18:
        r0.d(r12);
        this.i = ((MiniAppChooseTitleBar) S90(2131388807)).findViewById(2131388030);
        this.j = ((LinearLayout) S90(2131365673)).findViewById(2131392567);
        this.k = new MiniAppChooseContainerTabPagerAdapter(getChildFragmentManager());
        AnchorMiniAppDataContext r1 = AnchorMiniAppDataContext.a.a();
        if (r1 == null) goto L30;
        n<MiniAppEntrancePermissionResponse> r2 = r1.getEntranceInfo();
        if (r2 == null) goto L30;
        MiniAppEntrancePermissionResponse r3 = (MiniAppEntrancePermissionResponse) r2.getValue();
        if (r3 == null) goto L30;
        if (r3.getShowIntroPanel() != true) goto L30;
        MiniAppChooseContainerTabPagerAdapter r4 = this.k;
        if (r4 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L29:
        r4.f((MiniAppChooseIntroFragment) this.l.getValue(), s1.B(2131920379));
    L34:
        TabLayout r5 = this.i;
        if (r5 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L37:
        r5.addTab(r5.newTab().setText(s1.B(2131920379)));
        if (MiniAppChooseTalentSettingUtil.b() == false) goto L69;
        lp0.c r6 = this.g;
        if (r6 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L42:
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.c r13 = lp0.b.c(r6);
        if (r13 == null) goto L69;
        if (r13.c != true) goto L69;
        lp0.c r14 = this.g;
        if (r14 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L50:
        if (lp0.b.d(r14) == false) goto L62;
        lp0.c r15 = this.g;
        if (r15 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L55:
        if (lp0.b.d(r15) == false) goto L69;
        AnchorMiniAppDataContext r16 = AnchorMiniAppDataContext.a.a();
        if (r16 == null) goto L62;
        com.bytedance.live.datacontext.m<Boolean> r17 = r16.getMicroAppMountPunishing();
        if (r17 == null) goto L62;
        if (((Boolean) r17.getValue()).booleanValue() == true) goto L69;
    L62:
        MiniAppChooseContainerTabPagerAdapter r18 = this.k;
        if (r18 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L65:
        r18.f((MiniAppChooseLynxFragment) this.o.getValue(), s1.B(2131920378));
        TabLayout r19 = this.i;
        if (r19 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L68:
        r19.addTab(r19.newTab().setText(s1.B(2131920378)));
        ((MiniAppChooseTitleBar) S90(2131388807)).post(new d(this));
    L69:
        ViewPager r20 = this.j;
        if (r20 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L72:
        MiniAppChooseContainerTabPagerAdapter r21 = this.k;
        if (r21 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L75:
        r20.setAdapter(r21);
        TabLayout r22 = this.i;
        if (r22 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L78:
        ViewPager r23 = this.j;
        if (r23 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L81:
        r22.setupWithViewPager(r23);
        int r24 = MiniAppChooseTalentSettingUtil.a();
        ViewPager r25 = this.j;
        if (r25 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L84:
        r25.setCurrentItem(r24);
        this.p = r24;
        if (r24 != 0) goto L87;
        U90();
    L87:
        TabLayout r26 = this.i;
        if (r26 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L90:
        r26.addOnTabSelectedListener(new e(this));
        ((LinearLayout) S90(2131365673)).post(new c(this));
        HashMap<String, zo0.f> r27 = zo0.g.a;
        h.b(PerformanceScene.CHOOSE_PAGE).b();
        return;
    L30:
        MiniAppChooseContainerTabPagerAdapter r28 = this.k;
        if (r28 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L33:
        r28.f((MiniAppChooseListFragment) this.n.getValue(), s1.B(2131920379));
        goto L34
    L14:
        if (r11.getPermitStatus() != 0) goto L17;
        r12 = false;
    L7:
        r11 = null;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566935, r3, false);
    }
}
