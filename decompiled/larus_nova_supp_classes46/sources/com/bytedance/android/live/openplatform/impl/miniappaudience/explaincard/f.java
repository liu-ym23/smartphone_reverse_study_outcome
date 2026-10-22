package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.MiniAppHotAtmosphereView;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfSupplementInfoContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.MiniAppExplainCard;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> extends LinearLayout implements com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a<T>, com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a {
    public final boolean a;
    public boolean b;
    public long c;
    public final g d;
    public long e;
    public com.bytedance.android.livesdk.wrds.syncdata.openplatform.a f;
    public final OpenPlatformContext g;
    public final com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a<T> h;
    public final MiniAppHotAtmosphereView i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public View getExplainCardView() {
        return this.h.getExplainCardView();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public Function0<Unit> getOnBtnClickBlock() {
        return this.h.getOnBtnClickBlock();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public Function0<Unit> getOnClickBlock() {
        return this.h.getOnClickBlock();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public Function0<Unit> getOnCloseBlock() {
        return this.h.getOnCloseBlock();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setData(T r2) {
        this.h.setData(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setOnBtnClickBlock(Function0<Unit> r2) {
        this.h.setOnBtnClickBlock(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setOnClickBlock(Function0<Unit> r2) {
        this.h.setOnClickBlock(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setOnCloseBlock(Function0<Unit> r2) {
        this.h.setOnCloseBlock(r2);
    }

    public final void f() {
        if (this.a == true) goto L5;
        return;
    L5:
        qo0.a.c("AudienceExplainCard", "show hot atmosphere");
        this.b = true;
        MiniAppDataContext.Companion.getClass();
        ShelfCardInfo r2 = com.bytedance.android.live.openplatform.api.model.shelf.g.a(MiniAppDataContext.a.b());
        if (r2 == null) goto L8;
        long r3 = r2.getCardId();
    L10:
        if (this.i.o.isEmpty() == false) goto L18;
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r4 = (com.bytedance.android.livesdk.wrds.syncdata.openplatform.b) ((LinkedHashMap) ((AudienceShelfSupplementInfoContextService) this.g.getService(AudienceShelfSupplementInfoContextService.class)).a).get(Long.valueOf(r3));
        if (r4 == null) goto L14;
        setHotAtmosphereData(r4);
    L15:
        if (r4 != null) goto L18;
        boolean r5 = false;
    L19:
        if (r5 == true) goto L21;
        return;
    L21:
        this.e = r3;
        MiniAppHotAtmosphereView r6 = this.i;
        if (r6.n == true) goto L33;
        r6.animate().cancel();
        r6.n = true;
        r6.setAlpha(1.0f);
        r6.setVisibility(0);
        if (r6.o.isEmpty() == true) goto L28;
        r6.d();
    L28:
        com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a r1 = r6.r;
        if (r1 == null) goto L31;
        r1.b(r6.p);
    L31:
        r6.f = 0.0f;
        r6.removeCallbacks(r6.h);
        r6.post(r6.h);
    L33:
        if (this.c == (-1)) goto L36;
        qo0.a.c("AudienceExplainCard", "dispatch hide hot atmosphere runnable, duration: " + this.c);
        removeCallbacks(this.d);
        postDelayed(this.d, this.c * ((long) 1000));
        return;
    L36:
        return;
    L14:
        r4 = null;
    L18:
        r5 = true;
        goto L19
    L8:
        r3 = 0;
        goto L10
    }

    public com.bytedance.android.livesdk.wrds.syncdata.openplatform.b getCurrentHotAtmosphereData() {
        MiniAppHotAtmosphereView r0 = this.i;
        if (r0.n == true) goto L7;
        return null;
    L7:
        return r0.getCurrentItem();
    }

    public final void d() {
        if (getCurrentSupplementInfo() == null) goto L15;
        AudienceMiniAppAppLogContextService r0 = (AudienceMiniAppAppLogContextService) this.g.getService(AudienceMiniAppAppLogContextService.class);
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r1 = getCurrentSupplementInfo();
        if (r1 == null) goto L8;
        String r2 = r1.type;
        if (r2 == null) goto L8;
    L9:
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r3 = getCurrentSupplementInfo();
        if (r3 == null) goto L12;
        long r4 = r3.amount;
    L13:
        r0.reportSupplementInfoVisibilityChanged(false, r2, r4);
        return;
    L12:
        r4 = 0;
    L8:
        r2 = "";
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e(false);
    }

    public com.bytedance.android.livesdk.wrds.syncdata.openplatform.a getCurrentSupplementInfo() {
        return this.f;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a
    public final void a(com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r5) {
        AudienceMiniAppAppLogContextService r0 = (AudienceMiniAppAppLogContextService) this.g.getService(AudienceMiniAppAppLogContextService.class);
        if (r5 == null) goto L5;
        long r1 = r5.d();
    L6:
        r0.reportHotAtmosphereVisibilityChanged(false, "hot_sale", r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a
    public final void b(com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r5) {
        AudienceMiniAppAppLogContextService r0 = (AudienceMiniAppAppLogContextService) this.g.getService(AudienceMiniAppAppLogContextService.class);
        if (r5 == null) goto L5;
        long r1 = r5.d();
    L6:
        r0.reportHotAtmosphereVisibilityChanged(true, "hot_sale", r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void c(boolean r5) {
        qo0.a.c("AudienceExplainCard", "hide hot atmosphere");
        this.b = false;
        MiniAppHotAtmosphereView r1 = this.i;
        if (r1.n == false) goto L18;
        r1.n = false;
        Animator r0 = r1.e;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        Animator r2 = r1.g;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        r1.removeCallbacks(r1.h);
        com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a r3 = r1.r;
        if (r3 == null) goto L15;
        r3.a(r1.p);
    L15:
        if (r5 == false) goto L17;
        r1.setAlpha(1.0f);
        r1.animate().alpha(0.0f).setDuration(120).setListener(new com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.c(r1)).start();
        goto L18
    L17:
        r1.setAlpha(1.0f);
        r1.setVisibility(4);
    L18:
        this.c = -1;
        removeCallbacks(this.d);
    }

    public final void e(boolean r3) {
        if (this.a == true) goto L5;
        return;
    L5:
        qo0.a.c("AudienceExplainCard", "reset hot atmosphere status");
        c(r3);
        MiniAppHotAtmosphereView r4 = this.i;
        r4.o.clear();
        r4.p = null;
        r4.q = null;
        r4.animate().cancel();
        Animator r0 = r4.e;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        Animator r1 = r4.g;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        r4.removeCallbacks(r4.h);
        this.e = -1;
    }

    public void setHotAtmosphereData(com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r9) {
        Intrinsics.checkNotNullParameter(r9, "item");
        if (this.a == true) goto L6;
        return;
    L6:
        if (this.e == r9.a()) goto L8;
    L11:
        qo0.a.c("AudienceExplainCard", "do set hot atmosphere data");
        long r2 = -1;
        if (this.c != (-1)) goto L23;
        Long r0 = Long.valueOf(r9.b());
        if (r0.longValue() <= 0) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == true) goto L20;
        r0 = null;
    L20:
        if (r0 == null) goto L22;
        r2 = r0.longValue();
    L22:
        this.c = r2;
        goto L23
    L16:
        r1 = false;
    L23:
        this.i.setHotAtmosphereData(r9);
        if (this.b == true) goto L26;
        return;
    L26:
        if (this.i.n == true) goto L30;
        f();
        return;
    L30:
        return;
    L8:
        if (this.i.n == true) goto L11;
        int r10 = qo0.a.a;
        qo0.a.c("AudienceExplainCard", "already shown hot atmosphere, intercept repeat show, cardId: " + this.e);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setSupplementInfo(com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r7) {
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r0 = getCurrentSupplementInfo();
        if (r0 != null) goto L9;
        if (r7 == null) goto L9;
        AudienceMiniAppAppLogContextService r2 = (AudienceMiniAppAppLogContextService) this.g.getService(AudienceMiniAppAppLogContextService.class);
        String r3 = r7.type;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r2.reportSupplementInfoVisibilityChanged(true, r3, r7.amount);
    L9:
        if (r0 == null) goto L14;
        if (r7 != null) goto L12;
    L13:
        d();
        goto L14
    L12:
        if ((!Intrinsics.areEqual(r0.type, r7.type)) == true) goto L13;
    L14:
        this.f = r7;
        this.h.setSupplementInfo(r7);
    }

    public f(OpenPlatformContext r4, MiniAppExplainCard r5, MiniAppHotAtmosphereView r6) {
        Intrinsics.checkNotNullParameter(r4, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r5, "explainCard");
        Intrinsics.checkNotNullParameter(r6, "hotAtmosphere");
        super(r4.getContext());
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.c = -1;
        this.d = new g(this);
        this.e = -1;
        setOrientation(1);
        uc1 r0 = (uc1) ee0.a.getValue();
        if (r0 != null) goto L5;
    L7:
        addView(r5.getExplainCardView(), new ViewGroup.LayoutParams(-2, -2));
        return;
    L5:
        if (r0.v() != true) goto L7;
        qo0.a.c("AudienceExplainCard", "support hot atmosphere show, do init");
        this.a = true;
        r6.setVisibility(4);
        ViewGroup.MarginLayoutParams r7 = new ViewGroup.MarginLayoutParams(-2, -2);
        r7.bottomMargin = (int) fm3.e.a(getContext(), 11.0f);
        Unit r1 = Unit.INSTANCE;
        addView(r6, r7);
        r6.c();
        r6.setMaxWidth(UtilityKotlinExtentionsKt.i(112));
        r6.setCallback(this);
        goto L7
    }
}
