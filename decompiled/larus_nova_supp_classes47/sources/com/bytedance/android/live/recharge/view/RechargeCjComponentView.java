package com.bytedance.android.live.recharge.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.android.ttcjpaysdk.base.service.IErrorInfo;
import com.android.ttcjpaysdk.base.service.IHostApi;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import com.android.ttcjpaysdk.base.service.PayMsg;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.core.f;
import com.bytedance.android.live.recharge.platform.service.m;
import com.bytedance.android.live.recharge.util.g;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.live.revenue.common.reactive.e;
import com.bytedance.android.livesdkapi.depend.model.IDiamondRenderDataInfo;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.EventsListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@LynxBehavior(tagName = {"live-cj-pay"})
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/recharge/view/RechargeCjComponentView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/view/View;", "", "scene", "", "setCurrentScene", "info", "setRenderInfo", "", "panelHeight", "setPanelHeight", "", "showMask", "setPayMethodMask", "animUp", "setPayMethodAnimUp", "block", "setBlockUserInteraction", "a", "b", "c", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeCjComponentView extends LynxUI<View> {
    public static final /* synthetic */ int i = 0;
    public View a;
    public ITTCJPayComponent b;
    public ClickInterceptorFrameLayout c;
    public Integer d;
    public Set<String> e;
    public String f;
    public boolean g;
    public boolean h;

    public final class a implements IHostApi {
        public final /* synthetic */ RechargeCjComponentView a;

        public final boolean changePayTypeAnimUp() {
            return this.a.g;
        }

        public final boolean changePayTypeNeedMask() {
            return this.a.h;
        }

        public final void clickConfirmBtn() {
            RechargeCjComponentView r0 = this.a;
            int r1 = RechargeCjComponentView.i;
            r0.sendEvent("ClickConfirmBtn", new LinkedHashMap());
        }

        public final void fetchRenderData() {
            RechargeCjComponentView r0 = this.a;
            int r1 = RechargeCjComponentView.i;
            r0.sendEvent("FetchRenderData", new LinkedHashMap());
        }

        public Activity getContext() {
            Activity r0 = this.a.getLynxContext().getActivity();
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new RuntimeException("context not activity!");
        }

        public final int getPageHeight() {
            Integer r0 = this.a.d;
            if (r0 != null) goto L7;
            return 470;
        L7:
            return r0.intValue();
        }

        public a(RechargeCjComponentView r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public final class c implements IPayLifecycle {
        public final /* synthetic */ RechargeCjComponentView a;

        public final void onInitEnd(IErrorInfo r1) {
        }

        public final void onInitStart() {
        }

        public final void onRefreshEnd(IErrorInfo r1) {
        }

        public final void onRefreshStart() {
        }

        public final void onPayMethodChange() {
            if (((Boolean) g.k.getValue(null, g.a[9])).booleanValue() == false) goto L5;
            this.a.onPropsUpdated();
        L5:
            RechargeCjComponentView r0 = this.a;
            int r1 = RechargeCjComponentView.i;
            r0.sendEvent("PayMethodChange", new LinkedHashMap());
        }

        public c(RechargeCjComponentView r1) {
            this.a = r1;
        }

        public final void onConfirm(IErrorInfo r6) {
            RechargeCjComponentView r0 = this.a;
            Pair[] r1 = new Pair[2];
            String r2 = null;
            if (r6 == null) goto L5;
            Integer r3 = Integer.valueOf(r6.getCode());
        L6:
            r1[0] = TuplesKt.to(Constants.OperatorKey.CODE, r3);
            if (r6 == null) goto L9;
            r2 = r6.getMsg();
        L9:
            r1[1] = TuplesKt.to(Constants.OperatorKey.MSG, r2);
            Map<String, Object> r7 = MapsKt.mutableMapOf(r1);
            int r4 = RechargeCjComponentView.i;
            r0.sendEvent("PayConfirm", r7);
            return;
        L5:
            r3 = null;
            goto L6
        }

        public final void onPayMsgUpdate(Map<PayMsg, ? extends Object> r5) {
            RechargeCjComponentView r0 = this.a;
            if (r5 == null) goto L9;
            LinkedHashMap r1 = new LinkedHashMap(MapsKt.mapCapacity(r5.size()));
            Iterator<T> r6 = r5.entrySet().iterator();
        L6:
            if (r6.hasNext() == false) goto L8;
            Map.Entry r2 = (Map.Entry) r6.next();
            r1.put(((PayMsg) r2.getKey()).toString(), r2.getValue());
            goto L6
        L8:
            Map<String, Object> r7 = MapsKt.toMutableMap(r1);
        L10:
            int r3 = RechargeCjComponentView.i;
            r0.sendEvent("PayMsgUpdate", r7);
            return;
        L9:
            r7 = null;
            goto L10
        }
    }

    static {
        i.a(66);
    }

    public final void destroy() {
        super.destroy();
        m r0 = f.h(RechargeServices.b());
        String r1 = this.f;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.a(r1);
        this.f = null;
        this.b = null;
        this.e = null;
        this.a = null;
        this.d = null;
    }

    public final void onPropsUpdated() {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.onPropsUpdated();
        ((LynxUI) this).mView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r0 = ((LynxUI) this).mView.getMeasuredHeight();
        LynxContext r1 = getLynxContext();
        ShadowNode r2 = null;
        if (r1 == null) goto L5;
        ShadowNode r3 = r1.findShadowNodeBySign(getSign());
    L7:
        if ((r3 instanceof CJShadowNode) == false) goto L10;
        r2 = r3;
    L10:
        CJShadowNode r4 = (CJShadowNode) r2;
        if (r4 == null) goto L18;
        float r5 = r0;
        if (r4.v != r5) goto L15;
        return;
    L15:
        if (r5 < 0.0f) goto L20;
        r4.v = r5;
        r4.q();
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public RechargeCjComponentView(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final View createView(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        ITTCJPayComponent r0 = f.h(RechargeServices.b()).L(new c(this), new a(this));
        this.b = r0;
        if (r0 == null) goto L5;
        View r1 = r0.getPayView(new JSONObject());
    L6:
        this.a = r1;
        if (r1 != null) goto L9;
        View r2 = new View(r6);
        UtilityKotlinExtentionsKt.t(r2);
        return r2;
    L9:
        if (kx0.a.a == false) goto L13;
        ClickInterceptorFrameLayout r3 = new ClickInterceptorFrameLayout(r6, null, 6, 0);
        r3.addView(r1);
        this.c = r3;
        return r3;
    L13:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @LynxProp(name = "block-user-interaction")
    public final void setBlockUserInteraction(boolean r2) {
        ClickInterceptorFrameLayout r0 = this.c;
        if (r0 == null) goto L6;
        r0.setIntercept(r2);
        return;
    }

    @LynxProp(name = "scene")
    public final void setCurrentScene(String r8) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        ITTCJPayComponent r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (r8.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (f.h(RechargeServices.b()).f(r8) != null) goto L57;
        this.f = r8;
        f.h(RechargeServices.b()).s1(r8, r0);
        if (Intrinsics.areEqual(this.f, "custom_recharge") == false) goto L58;
        com.bytedance.android.live.recharge.panel.context.c r9 = com.bytedance.android.live.recharge.panel.g.a();
        String r3 = null;
        if (r9 == null) goto L19;
        e<com.bytedance.android.live.recharge.deal.i> r10 = r9.g();
        if (r10 == null) goto L19;
        com.bytedance.android.live.recharge.deal.i r12 = r10.getValue();
    L20:
        if (r12 == null) goto L24;
        IPrePayCashierInfo r13 = r12.n();
        if (r13 == null) goto L24;
        Map r14 = r13.getRenderDataMap();
    L25:
        String r4 = "";
        if (r14 == null) goto L31;
        IDiamondRenderDataInfo r15 = (IDiamondRenderDataInfo) r14.get(0L);
        if (r15 == null) goto L31;
        String r16 = r15.getRenderData();
        if (r16 == null) goto L31;
    L33:
        if (com.bytedance.android.live.recharge.model.g.a.j1() == true) goto L35;
    L54:
        setRenderInfo(r16);
        return;
    L35:
        if (r16.length() != 0) goto L37;
        boolean r6 = true;
    L38:
        if (r6 == false) goto L54;
        ConcurrentHashMap<Long, IRenderDataInfoBase> r17 = sw0.a.a;
        IRenderDataInfoBase r18 = sw0.a.a.get(0L);
        StringBuilder r5 = new StringBuilder("cache write, price: 0, data is null: ");
        if (r18 == null) goto L42;
        r3 = r18.getRenderData();
    L42:
        if (r3 != null) goto L44;
    L47:
        r5.append(r2);
        jy0.b.a("Recharge/PreCashierInfoMemoryCache", r5.toString());
        if (r18 == null) goto L53;
        String r19 = r18.getRenderData();
        if (r19 == null) goto L53;
        r4 = r19;
    L53:
        r16 = r4;
        goto L54
    L44:
        if (r3.length() == 0) goto L47;
        r2 = false;
        goto L47
    L37:
        r6 = false;
    L31:
        r16 = "";
    L24:
        r14 = null;
    L19:
        r12 = null;
        goto L20
    L58:
        return;
    L57:
        return;
    L8:
        r1 = false;
        goto L9
    }

    public final void setEvents(Map<String, EventsListener> r1) {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.setEvents(r1);
        if (r1 == null) goto L5;
        Set<String> r2 = r1.keySet();
    L6:
        this.e = r2;
        return;
    L5:
        r2 = null;
        goto L6
    }

    @LynxProp(name = "panel-height")
    public final void setPanelHeight(double r4) {
        if (r4 <= 0) goto L6;
        this.d = Integer.valueOf(MathKt.roundToInt(r4));
        return;
    }

    @LynxProp(name = "pay-method-anim-up")
    public final void setPayMethodAnimUp(boolean r1) {
        this.g = r1;
    }

    @LynxProp(name = "pay-method-mask")
    public final void setPayMethodMask(boolean r1) {
        this.h = r1;
    }

    @LynxProp(name = "render-info")
    public final void setRenderInfo(String r4) {
        if (r4 != null) goto L26;
        return;
    L26:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        ITTCJPayComponent r2 = this.b;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        boolean r5 = r2.refresh(new JSONObject(r4));     // Catch: Throwable -> L11
    L9:
        Object r6 = Result.constructor-impl(Boolean.valueOf(r5));     // Catch: Throwable -> L11
    L13:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L16;
        r6 = r3;
    L16:
        Pair[] r7 = new Pair[2];
        r7[0] = TuplesKt.to("is_success", m2.b(((Boolean) r6).booleanValue()));
        ITTCJPayComponent r8 = this.b;
        if (r8 == null) goto L21;
        JSONObject r9 = r8.getDynamicBizParams();
        if (r9 == null) goto L21;
        String r10 = r9.toString();
    L22:
        if (r10 != null) goto L24;
        r10 = "";
    L24:
        r7[1] = TuplesKt.to("caijing_pay_params", r10);
        sendEvent("RefreshResult", MapsKt.mutableMapOf(r7));
        return;
    L21:
        r10 = null;
        goto L22
    L8:
        r5 = false;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void sendEvent(String r4, Map<String, Object> r5) {
        Set<String> r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.contains(r4) != true) goto L9;
        getLynxContext().getEventEmitter().sendCustomEvent(new com.lynx.tasm.event.a(getSign(), r4, r5));
        return;
    }

    public final void updateLayoutInfo(int r19, int r20, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r210, int r30, int r32, int r33, int r34, int r35, Rect r36) {
        ((LynxUI) this).mView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r4 = ((LynxUI) this).mView.getMeasuredHeight();
        LynxContext r0 = getLynxContext();
        ShadowNode r1 = null;
        if (r0 == null) goto L5;
        ShadowNode r2 = r0.findShadowNodeBySign(getSign());
    L7:
        if ((r2 instanceof CJShadowNode) == false) goto L10;
        r1 = r2;
    L10:
        CJShadowNode r3 = (CJShadowNode) r1;
        if (r3 == null) goto L17;
        float r5 = r4;
        if (r3.v == r5) goto L17;
        if (r5 < 0.0f) goto L17;
        r3.v = r5;
        r3.q();
    L17:
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updateLayoutInfo(r19, r20, r22, r4, r24, r25, r26, r27, r28, r29, r210, r30, r32, r33, r34, r35, r36);
        return;
    L5:
        r2 = null;
        goto L7
    }
}
