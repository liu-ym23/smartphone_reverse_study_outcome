package com.bytedance.android.annie.business.container;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import com.bytedance.android.annie.api.card.CardCustomMonitorKey;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.business.ability.schema.model.AnnieXLiveCardModel;
import com.bytedance.android.annie.business.container.view.CustomViewUtils;
import com.bytedance.android.annie.monitor.SlardarMonitorUtils;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.lynx.tasm.q1;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLiveCard extends HybridCard {
    public final Context j;
    public final AnnieXLiveContext k;
    public final AnnieXLiveCardModel l;
    public m7.a m;
    public m7.b n;
    public m7.c o;
    public final com.bytedance.android.anniex.container.n p;
    public String q;
    public final t36.d r;
    public int s;
    public final Paint t;
    public volatile boolean u;
    public View.OnClickListener v;
    public View.OnTouchListener w;

    public static final class a extends ia.i.a {
        public final /* synthetic */ AnnieXLiveCard a;

        @Override // ia.j
        public final View b() {
            int r0 = CustomViewUtils.a;
            AnnieXLiveCard r1 = this.a;
            Context r10 = r1.getContext();
            AnnieXLiveCard r11 = this.a;
            com.bytedance.android.anniex.container.n r12 = r11.p;
            Pair[] r13 = new Pair[3];
            p r14 = r11.l.b;
            if (r14 == null) goto L6;
            String r15 = (String) ((y36.i) r14).b;
            if (r15 == null) goto L6;
        L7:
            r13[0] = TuplesKt.to("theme", r15);
            r13[1] = TuplesKt.to("is_popup", "false");
            r13[2] = TuplesKt.to("is_bottom_popup", "false");
            return CustomViewUtils.a(r1, r10, r12, MapsKt.hashMapOf(r13), this.a.getBizKey());
        L6:
            r15 = "default";
            goto L7
        }

        @Override // ia.j
        public final View c() {
            int r0 = CustomViewUtils.a;
            AnnieXLiveCard r1 = this.a;
            return CustomViewUtils.b(r1, r1.getContext(), this.a.getBizKey(), null);
        }

        public a(AnnieXLiveCard r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public static final class c extends com.bytedance.android.anniex.base.lifecycle.a {
        public final /* synthetic */ AnnieXLiveCard a;

        public c(AnnieXLiveCard r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void e(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            super.e(r10, r11);
            AnnieXLiveHybridComponent r0 = AnnieXLiveCard.h(this.a);
            if (r0 == null) goto L6;
            r0.f(r10);
        L6:
            if (this.a.v == null) goto L11;
            View r12 = r11.getKitView();
            if (r12 == null) goto L11;
            r12.setOnClickListener(this.a.v);
        L11:
            if (this.a.w == null) goto L16;
            View r13 = r11.getKitView();
            if (r13 == null) goto L17;
            r13.setOnTouchListener(this.a.w);
            return;
        L17:
            return;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void h(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            super.h(r10, r11);
            AnnieXLiveHybridComponent r12 = AnnieXLiveCard.h(this.a);
            if (r12 == null) goto L6;
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            r12.i = System.currentTimeMillis();
            return;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void i(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            super.i(r10, r11);
            this.a.setLoadSuccess(true);
            AnnieXLiveCard.h(this.a);
        }
    }

    public static final class d extends q1 {
        public d() {
        }
    }

    public static final class e extends WebViewClient {
        public e() {
        }
    }

    static {
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void e(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public /* bridge */ /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean isPopup() {
        return false;
    }

    private final c getContainerLifecycle() {
        return new c(this);
    }

    private final IHybridComponent.HybridType getHybridTypeBySchema() {
        String r0 = (String) ((y36.i) new p(this.r, com.bytedance.android.ec.core.event.a.KEY_URL, null)).b;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        return IHybridComponent.HybridType.H5;
    L11:
        return IHybridComponent.HybridType.LYNX;
    L5:
        if (StringsKt.startsWith(r0, "http", true) != true) goto L7;
        r1 = true;
        goto L7
    }

    private final d getLynxViewClient() {
        return new d();
    }

    private final e getWebViewClient() {
        return new e();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void b() {
        Set<String> r0 = SlardarMonitorUtils.a;
        String r1 = this.l.c();
        AnnieXLiveHybridComponent r10 = getAnnieXLiveComponent();
        if (r10 == null) goto L8;
        IHybridComponent.HybridType r11 = r10.hybridType();
        if (r11 == null) goto L8;
        String r12 = r11.toMonitorString();
        if (r12 == null) goto L8;
    L9:
        SlardarMonitorUtils.b(r1, "view", r12);
        return;
    L8:
        r12 = "";
        goto L9
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void d() {
        Set<String> r0 = SlardarMonitorUtils.a;
        SlardarMonitorUtils.c(this.l.c());
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public String getBizKey() {
        return this.k.getBizKey();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void release() {
        if (this.u == false) goto L5;
        return;
    L5:
        this.m = null;
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L13;
        m7.b r1 = this.n;
        if (r1 == null) goto L10;
        r1.d = null;
    L10:
        m7.c r10 = this.o;
        if (r10 == null) goto L13;
        r10.d = null;
    L13:
        this.n = null;
        this.o = null;
        this.u = true;
        super.release();
        b7.b r11 = this.k.getCommonLifecycle();
        if (r11 == null) goto L16;
        r11.onRelease();
    L16:
        IAnnieBusinessLatchService.b r12 = this.k.getLatchProcess();
        if (r12 == null) goto L19;
        r12.dispose();
    L19:
        this.s = -1;
        setMReleasedFlag(true);
        HybridLogger r13 = HybridLogger.a;
        HybridLogger.m("AnnieXLiveCard", "AnnieXLiveCard release : " + this.q, null, null, 12);
    }

    private final AnnieXLiveHybridComponent getAnnieXLiveComponent() {
        IHybridComponent r0 = getMCurrentHybridComponent();
        if ((r0 instanceof AnnieXLiveHybridComponent) == true) goto L7;
        return null;
    L7:
        return (AnnieXLiveHybridComponent) r0;
    }

    private final y6.c getJSBridgeManger() {
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean canGoBack() {
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canGoBack();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final String containerId() {
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L6;
        String r1 = r0.containerId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void goBack() {
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L6;
        r0.goBack();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void hide() {
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L6;
        r0.hide();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.p.onAttachToWindow();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void show() {
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L6;
        r0.show();
        return;
    }

    public final AnnieXLiveContext getAnnieXContext() {
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public static final /* synthetic */ AnnieXLiveHybridComponent h(AnnieXLiveCard r0) {
        return r0.getAnnieXLiveComponent();
    }

    public static final /* synthetic */ c i(AnnieXLiveCard r0) {
        return r0.getContainerLifecycle();
    }

    public static final /* synthetic */ d j(AnnieXLiveCard r0) {
        return r0.getLynxViewClient();
    }

    public static final /* synthetic */ e k(AnnieXLiveCard r0) {
        return r0.getWebViewClient();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void c(com.bytedance.android.annie.card.base.b r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxCallback");
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L6;
        r0.registerLifecycleCallback(r10);
        return;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Paint r0 = this.t;
        if (r0 == null) goto L5;
        r0.setStrokeWidth(6.0f);
        r0.setColor(ColorProtector.parseColor("#FF0000"));
        r10.drawLine(0.0f, 0.0f, getWidth(), 0.0f, r0);
        r10.drawLine(0.0f, 0.0f, 0.0f, getHeight(), r0);
        r10.drawLine(getWidth(), 0.0f, getWidth(), getHeight(), r0);
        r10.drawLine(0.0f, getHeight(), getWidth(), getHeight(), r0);
    L5:
        super.onDraw(r10);
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public void setJSBridgeListener(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L6;
        r0.setJSBridgeListener(r10);
        return;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r10) {
        super.setOnClickListener(r10);
        this.v = r10;
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L8;
        View r1 = r0.getHybridView();
        if (r1 == null) goto L9;
        r1.setOnClickListener(r10);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
        if (getAnnieXLiveComponent() == null) goto L6;
        Intrinsics.checkNotNullParameter(r10, "l");
        return;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r10) {
        super.setOnTouchListener(r10);
        this.w = r10;
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L8;
        View r1 = r0.getHybridView();
        if (r1 == null) goto L9;
        r1.setOnTouchListener(r10);
        return;
    L9:
        return;
    }

    public final void setPreRender$annie_mix_glue_release(boolean r1) {
        setPreRender(r1);
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.view.RadiusLayout, a7.b
    public void setRadius(float r10) {
        if (AnnieConfigSettingKeys.ANNIE_CARD_USE_CLIP_PATH.a().booleanValue() == false) goto L5;
        super.setRadius(r10);
        return;
    L5:
        getAnnieXLiveComponent();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L6;
        r0.updateData(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        if (r10 == null) goto L5;
        Map<String, ? extends Object> r11 = k7.b.a(r10);
        this.p.updateGlobalProps(r11);
        return;
    }

    public AnnieXLiveCard(Context r10, AnnieXLiveContext r11) {
        Intrinsics.checkNotNullParameter(r10, "mContext");
        Intrinsics.checkNotNullParameter(r11, "annieXLiveContext");
        super(r10, null, 6, 0);
        this.j = r10;
        this.k = r11;
        com.bytedance.android.anniex.assemble.a r12 = com.bytedance.android.anniex.assemble.a.a;
        Function1<com.bytedance.android.anniex.base.builder.d, Unit> r13 = new AnnieXLiveCard$viewContainer$1(this);
        Intrinsics.checkNotNullParameter(r13, "block");
        com.bytedance.android.anniex.base.builder.d r14 = new com.bytedance.android.anniex.base.builder.d();
        r13.invoke(r14);
        com.bytedance.android.anniex.container.n r15 = new com.bytedance.android.anniex.container.n(r14);
        m7.a r16 = this.m;
        if (r16 == null) goto L5;
        r16.d = r15;
    L5:
        m7.b r17 = this.n;
        if (r17 == null) goto L8;
        r17.d = r15;
    L8:
        m7.c r18 = this.o;
        if (r18 == null) goto L11;
        r18.d = r15;
    L11:
        this.p = r15;
        r11.getUri();
        String r19 = r11.getUri().toString();
        this.q = r19;
        t36.d r20 = r15.generateSchemaData(r19);
        this.r = r20;
        this.s = -1;
        HybridLogger r21 = HybridLogger.a;
        HybridLogger.m("AnnieXLiveCard", "init start: " + this.q, null, null, 12);
        Lazy r22 = SchemaService.f;
        SchemaService.a.a().getClass();
        AnnieXLiveCardModel r23 = (AnnieXLiveCardModel) SchemaService.d(r20, AnnieXLiveCardModel.class);
        if (r23 != null) goto L14;
        r23 = new AnnieXLiveCardModel();
    L14:
        this.l = r23;
        r15.r(new a(this));
        r15.q(this);
        b7.b r24 = r11.getCommonLifecycle();
        if (r24 == null) goto L17;
        r24.onContainerInitEnd();
    L17:
        HybridLogger.k("AnnieXLiveCard", "container_init_end", null, r11.getLogContext());
        getHybridTypeBySchema();
        setMCurrentHybridComponent(new AnnieXLiveHybridComponent(getContext(), this.p, this.l, this.k));     // Catch: Throwable -> L20
    L24:
        b7.b r25 = this.k.getCommonLifecycle();
        if (r25 == null) goto L27;
        r25.onPrepareComponentEnd();
    L27:
        AnnieXLiveHybridComponent r26 = getAnnieXLiveComponent();
        if (r26 == null) goto L30;
        int r27 = AnnieXLiveHybridComponent.r;
        r26.e(null);
    L30:
        setMReleasedFlag(false);
        if (AnnieConfigSettingKeys.STROKE_SWITCH.a().booleanValue() == false) goto L36;
        this.t = new Paint();
        setWillNotDraw(false);
        setPadding(6, 6, 6, 6);
        return;
    L36:
        return;
    L20:
        th = move-exception;
        this.p.showError();
        m7.a r28 = this.m;
        if (r28 == null) goto L24;
        r28.b(200, "AnnieXLiveHybridComponent error: " + th.getMessage());
        goto L24
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void a(Uri r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m("AnnieXLiveCard", "loadSchema currentSchemaString: " + this.q, null, null, 12);
        String r1 = r10.toString();
        String r12 = r10.getHost();
        boolean r13 = false;
        if (r12 != null) goto L5;
    L7:
        if (r13 == true) goto L9;
        this.q = r1;
        a7.a.a(this, null, r11, 1);
        return;
    L9:
        if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L11;
        com.bytedance.android.annie.util.c.a(r1 + "需要重定向，不支持直接加载！");
    L11:
        HybridLogger.i("AnnieXLiveCard", r1 + " needs to be redirected and should not be loaded directly!", null, 12);
        return;
    L5:
        if (StringsKt.contains$default(r12, "webcast_redirect", false, 2, null) != true) goto L7;
        r13 = true;
        goto L7
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void f(int r10, int r11) {
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L6;
        r0.updateScreenMetrics(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void g(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(AIStateLogRequest.SOURCE_PAGE, "visibleChangeReason");
        ia.c.a.a(this.p, r10);
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void load(String r13, Map<String, ? extends Object> r14) {
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m("AnnieXLiveCard", "load: " + r13, null, null, 12);
        CardCustomMonitorKey r1 = CardCustomMonitorKey.HasReload;
        Integer r10 = Integer.valueOf(this.f ? 1 : 0);
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        AnnieXLiveHybridComponent r11 = getAnnieXLiveComponent();
        if (r11 == null) goto L47;
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        String r12 = r11.containerId();
        if (r12 == null) goto L47;
        k9.d r15 = ((k9.e) r11.getService(k9.e.class)).V0();
        HybridLogger.m("AnnieXLiveHybridComponent", "setCustomMonitorKey " + r1 + ", value: " + r10 + ", monitorId: " + r12, null, null, 12);
        switch(AnnieXLiveHybridComponent.b.a[r1.ordinal()]) {
            case 1: goto L36;
            case 2: goto L30;
            case 3: goto L26;
            case 4: goto L22;
            case 5: goto L19;
            case 6: goto L16;
            case 7: goto L13;
            case 8: goto L10;
            default: goto L47;
        };
    L10:
        r15.d(r12, "hint_seclink", r10.toString());
        Bundle r16 = r11.d.getBundle();
        if (r16 == null) goto L47;
        r16.putString("hint_seclink", r10.toString());
        goto L47
    L13:
        r15.d(r12, "has_reload", r10.toString());
        Bundle r17 = r11.d.getBundle();
        if (r17 == null) goto L47;
        r17.putString("has_reload", r10.toString());
        goto L47
    L16:
        r15.d(r12, "is_prerender", r10.toString());
        Bundle r18 = r11.d.getBundle();
        if (r18 == null) goto L47;
        r18.putString("is_prerender", r10.toString());
        goto L47
    L19:
        r15.d(r12, "is_user_open", r10.toString());
        Bundle r19 = r11.d.getBundle();
        if (r19 == null) goto L47;
        r19.putString("is_user_open", r10.toString());
        goto L47
    L22:
        r15.d(r12, "is_container_preload", r10.toString());
        Bundle r20 = r11.d.getBundle();
        if (r20 == null) goto L47;
        r20.putString("is_container_preload", r10.toString());
        goto L47
    L26:
        if ((r10 instanceof Integer) == false) goto L28;
        r15.b(r12, r10.intValue());
        goto L47
    L28:
        HybridLogger.m("AnnieXLiveHybridComponent", "setCustomMonitorKey " + r1 + ", typeof value is not Int, do nothing", null, null, 12);
        goto L47
    L30:
        if ((r10 instanceof Long) == false) goto L34;
        r15.c(r12, "user_open_time", r10.longValue());
        Bundle r21 = r11.d.getBundle();
        if (r21 == null) goto L47;
        r21.putString("user_open_time", r10.toString());
        goto L47
    L34:
        HybridLogger.m("AnnieXLiveHybridComponent", "setCustomMonitorKey " + r1 + ", typeof value is not Long, do nothing", null, null, 12);
        goto L47
    L36:
        if (r11.l == true) goto L47;
        r11.l = true;
        if ((r10 instanceof Long) == false) goto L46;
        r15.c(r12, "open_time", r10.longValue());
        Bundle r22 = r11.d.getBundle();
        if (r22 == null) goto L43;
        r22.putString("has_reload", r10.toString());
    L43:
        Bundle r23 = r11.d.getBundle();
        if (r23 == null) goto L47;
        r23.putLong("real_open_time", r10.longValue());
        goto L47
    L46:
        HybridLogger.m("AnnieXLiveHybridComponent", "setCustomMonitorKey " + r1 + ", typeof value is not Long, do nothing", null, null, 12);
    L47:
        super.load(r13, r14);
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.view.RadiusLayout, a7.b
    public final void setRadius(float r10, float r11, float r12, float r13) {
        if (AnnieConfigSettingKeys.ANNIE_CARD_USE_CLIP_PATH.a().booleanValue() == false) goto L5;
        super.setRadius(r10, r11, r12, r13);
        return;
    L5:
        getAnnieXLiveComponent();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r10, int r11, int r12, int r13) {
        super.onLayout(r1, r10, r11, r12, r13);
        boolean r14 = true;
        if (com.bytedance.android.anniex.container.util.h.a(this.j) == false) goto L5;
        int r15 = 2;
    L6:
        int r16 = this.s;
        if (r16 != (-1)) goto L9;
        this.s = r15;
        return;
    L9:
        if (r15 == r16) goto L24;
        this.s = r15;
        JSONObject r17 = new JSONObject();
        int r18 = this.s;
        if (r18 == 1) goto L15;
        if (r18 == 2) goto L14;
        String r19 = "";
    L17:
        if (r19.length() > 0) goto L20;
        r14 = false;
    L20:
        if (r14 == false) goto L25;
        r17.put("screenOrientation", this.s);
        sendJsEvent("orientationChanged", r17);
        return;
    L25:
        return;
    L14:
        r19 = "landscape";
        goto L17
    L15:
        r19 = "portrait";
        goto L17
    L24:
        return;
    L5:
        r15 = 1;
        goto L6
    }
}
