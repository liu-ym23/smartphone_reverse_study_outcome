package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.gift.framework.base.GiftMVIWidget;
import com.bytedance.android.livesdk.gift.platform.business.GiftPluginType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.g;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.i;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.GiftMVIPanelView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnDialogFullyShowed;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.GiftPanelViewModel;
import com.bytedance.android.livesdk.gift.platform.business.h;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.a2;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.android.livesdk.gift.util.c;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import i12.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/widget/GiftPanelWidget;", "Lcom/bytedance/android/livesdk/gift/framework/base/GiftMVIWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelState;", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPanelWidget extends GiftMVIWidget<GiftPanelState> {
    public FrameLayout d;
    public View e;
    public final Map<i<?>, a> f;
    public int g;
    public final d h;

    public static final class a {
        public Disposable a;
        public g b;

        public a(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "controllerDisposable");
            this.a = r2;
            this.b = null;
        }
    }

    public final int getLayoutId() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        Boolean r1 = (Boolean) r0.get("data_is_portrait", Boolean.TRUE);
    L6:
        boolean r2 = Intrinsics.areEqual(r1, Boolean.TRUE);
        if (PadConfigUtils.c() == true) goto L34;
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L34;
        if (v.e() == false) goto L24;
        if (v.a() == false) goto L19;
        if (r2 == false) goto L17;
        return 2131565816;
    L17:
        return 2131565817;
    L19:
        if (r2 == false) goto L21;
        return 2131565815;
    L21:
        return 2131565818;
    L24:
        if (v.a() == false) goto L29;
        if (r2 == false) goto L27;
        return 2131565813;
    L27:
        return 2131565814;
    L29:
        if (r2 == false) goto L31;
        return 2131565821;
    L31:
        return 2131565822;
    L34:
        if (v.e() == true) goto L36;
        return 2131565823;
    L36:
        if (v.a() == false) goto L39;
        return 2131565820;
    L39:
        return 2131565819;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.GiftMVIWidget
    public final GiftMVIPanelView wq() {
        Context r1 = ((Widget) this).context;
        View r2 = ((Widget) this).contentView;
        if (r2 == null) goto L7;
        return new GiftMVIPanelView(r1, (ViewGroup) r2, ((Widget) this).dataCenter);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.GiftMVIWidget
    public final void onUnload() {
        super.onUnload();
        b.e(this);
        Map<i<?>, a> r0 = this.f;
        ArrayList r1 = new ArrayList(r0.size());
        Iterator r2 = ((LinkedHashMap) r0).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add((a) ((Map.Entry) r2.next()).getValue());
        goto L4
    L6:
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L20;
        a r4 = (a) r3.next();
        r4.a.dispose();
        g r5 = r4.b;
        if (r5 == null) goto L14;
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d r6 = r5.c;
        if (r6 == null) goto L14;
        r6.a();
    L14:
        g r7 = r4.b;
        if (r7 == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d r8 = r7.c;
        if (r8 == null) goto L19;
        r8.c();
    L19:
        r4.b = null;
        goto L8
    L20:
        ((LinkedHashMap) this.f).clear();
        FrameLayout r9 = this.d;
        if (r9 == null) goto L29;
        r9.removeAllViews();
        return;
    }

    public final void yq() {
        if (c.b() == true) goto L5;
        return;
    L5:
        if (c.a() >= 1) goto L7;
        return;
    L7:
        if (this.g > 0) goto L22;
        this.g = (int) (com.bytedance.android.live.revenue.common.i.a(110) * c.a());
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L19;
        View r1 = r0.findViewById(2131373770);
        if (r1 == null) goto L20;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L21;
        r2.height += this.g;
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.GiftMVIWidget
    public final Class<? extends BaseMVIViewModel<GiftPanelState, GiftAction>> xq() {
        return GiftPanelViewModel.class;
    }

    public GiftPanelWidget(d r1) {
        this.h = r1;
        this.f = new LinkedHashMap();
    }

    public final void onConfigurationChanged(Configuration r3) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r3);
        if (FoldScreenUtils.f() == true) goto L5;
        return;
    L5:
        if (nz1.a.q().b() == true) goto L7;
        return;
    L7:
        if (FoldScreenUtils.a() != 0) goto L9;
        yq();
        return;
    L9:
        if (this.g <= 0) goto L21;
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L22;
        View r5 = r4.findViewById(2131373770);
        if (r5 == null) goto L23;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L24;
        r6.height -= this.g;
        this.g = 0;
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.GiftMVIWidget
    public final void onInit(Object[] r1) {
        this.e = findViewById(2131385810);
        this.d = (FrameLayout) findViewById(2131389241);
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.GiftMVIWidget
    public final void onLoad(Object[] r8) {
        long r0 = System.currentTimeMillis();
        super.onLoad(r8);
        if (v.e() == false) goto L5;
    L23:
        yq();
        d r9 = this.h;
        if (r9 == null) goto L28;
        a2 r10 = (a2) m.e.d(r9, a2.class);
        if (r10 == null) goto L28;
        r10.g.a(new OnDialogFullyShowed(r10.c.C()));
    L28:
        d r11 = this.h;
        if (r11 == null) goto L41;
        GiftPanelMonitorService r13 = (GiftPanelMonitorService) m.e.d(r11, GiftPanelMonitorService.class);
        if (r13 == null) goto L42;
        r13.f(r0);
        return;
    L42:
        return;
    L41:
        return;
    L5:
        if (v.a() == true) goto L7;
    L8:
        com.bytedance.android.livesdk.gift.platform.business.g r14 = b.c(false);
        if (r14 == null) goto L23;
        Map<GiftPluginType, h> r15 = r14.h();
        if (r15 == null) goto L23;
        Collection<h> r16 = r15.values();
        if (r16 == null) goto L23;
        Iterator<T> r17 = r16.iterator();
    L16:
        if (r17.hasNext() == false) goto L23;
        i<?> r2 = ((h) r17.next()).E();
        if (r2 == null) goto L16;
        if (this.f.containsKey(r2) == true) goto L16;
        a r3 = new a(Disposables.disposed());
        c02.a r4 = new c02.a(r3, this);
        Intrinsics.checkNotNullParameter(r4, "service");
        Disposable r5 = r2.a.subscribe(new com.bytedance.android.livesdk.gift.platform.business.dialog.topview.h(r2, r4));
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.a = r5;
        this.f.put(r2, r3);
        goto L16
    L7:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == true) goto L23;
        goto L8
    }
}
