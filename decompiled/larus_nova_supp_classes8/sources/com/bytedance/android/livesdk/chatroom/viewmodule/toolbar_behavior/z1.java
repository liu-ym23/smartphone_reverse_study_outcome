package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ToolBarCouponExtraData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z1 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public ToolBarCouponExtraData a;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s b;
    public DataCenter c;
    public HSImageView d;
    public TextView e;

    public static final class a {
    }

    static {
    }

    public z1() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r5) {
        String r0 = null;
        if (r5 != null) goto L25;
        ToolBarCouponExtraData r1 = null;
    L13:
        this.a = r1;
        this.b = r5;
        HSImageView r6 = this.d;
        if (r6 == null) goto L23;
        PipelineDraweeControllerBuilder r2 = Fresco.newDraweeControllerBuilder();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3 = this.b;
        if (r3 == null) goto L22;
        py.k r4 = r3.c;
        if (r4 == null) goto L22;
        List r7 = r4.getUrls();
        if (r7 == null) goto L22;
        r0 = (String) CollectionsKt.firstOrNull(r7);
    L22:
        r6.setController(r2.setUri(r0).setControllerListener(new a2(this)).build());
    L23:
        b("coupon_bottom_icon_show");
        a("live_coupon_bottom_icon_show");
        return;
    L25:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L6
        Object r9 = Result.constructor-impl(GsonHelper.get().fromJson(r5.d, ToolBarCouponExtraData.class));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r9) == false) goto L11;
        r9 = null;
    L11:
        r1 = (ToolBarCouponExtraData) r9;
    L6:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final void a(String r12) {
        DataCenter r1 = this.c;
        Unit r3 = null;
        if (r1 == null) goto L5;
        String r2 = (String) r1.get("log_enter_params", "{}");
    L6:
        DataCenter r4 = this.c;
        if (r4 == null) goto L9;
        Room r5 = com.bytedance.android.live.core.utils.z.o(r4);
    L11:
        if (r2 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == true) goto L35;
        if (r5 == null) goto L36;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L30
        JSONObject r9 = new JSONObject(r2);     // Catch: Throwable -> L30
        String r6 = r9.optString("creative_id");     // Catch: Throwable -> L30
        if (r6.length() != 0) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == false) goto L25;
        return;
    L25:
        String r11 = r9.optString("log_extra", "{}");     // Catch: Throwable -> L30
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L30
        r13.put("anchor_id", r5.getOwnerUserIdString());     // Catch: Throwable -> L30
        r13.put("room_id", String.valueOf(r5.getRoomId()));     // Catch: Throwable -> L30
        String r14 = r13.toString();     // Catch: Throwable -> L30
        ILiveDouPlusService r15 = jc1.k.f(ILiveDouPlusService.class);     // Catch: Throwable -> L30
        if (r15 == null) goto L28;
        r15.logEvent(false, r12, "", MapsKt.mapOf(new Pair[]{TuplesKt.to("tag", "live_ad"), TuplesKt.to("is_ad_event", "1"), TuplesKt.to("category", "umeng"), TuplesKt.to("log_extra", r11), TuplesKt.to("value", r6), TuplesKt.to("ad_extra_data", r14)}));     // Catch: Throwable -> L30
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        Result.constructor-impl(r3);     // Catch: Throwable -> L30
        return;
    L22:
        r10 = false;
    L30:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L36:
        return;
    L35:
        return;
    L13:
        if (r2.length() == 0) goto L16;
        r7 = false;
        goto L17
    L9:
        r5 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final void b(String r7) {
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        LinkedHashMap r1 = new LinkedHashMap();
        DataCenter r2 = this.c;
        if (r2 == null) goto L8;
        Room r3 = com.bytedance.android.live.core.utils.z.o(r2);
        if (r3 == null) goto L8;
        String r4 = String.valueOf(r3.getRoomId());
        if (r4 == null) goto L8;
    L9:
        r1.put("anchor_id", r4);
        DataCenter r5 = this.c;
        if (r5 == null) goto L15;
        Room r6 = com.bytedance.android.live.core.utils.z.o(r5);
        if (r6 == null) goto L15;
        String r8 = r6.getOwnerUserIdString();
        if (r8 == null) goto L15;
    L16:
        r1.put("room_id", r8);
        if (r0 == null) goto L22;
        Map r9 = r0.getMap();
        if (r9 == null) goto L22;
        String r10 = (String) r9.get("enter_from_merge");
        if (r10 == null) goto L22;
    L23:
        r1.put("enter_from_merge", r10);
        if (r0 == null) goto L29;
        Map r11 = r0.getMap();
        if (r11 == null) goto L29;
        String r12 = (String) r11.get("enter_method");
        if (r12 == null) goto L29;
    L30:
        r1.put("enter_method", r12);
        if (r0 == null) goto L36;
        Map r13 = r0.getMap();
        if (r13 == null) goto L36;
        String r14 = (String) r13.get("action_type");
        if (r14 == null) goto L36;
    L37:
        r1.put("action_type", r14);
        ToolBarCouponExtraData r15 = this.a;
        if (r15 == null) goto L40;
        Integer r16 = Integer.valueOf(r15.getCouponPrice());
    L41:
        r1.put("bubble_text", String.valueOf(r16));
        DataCenter r17 = this.c;
        if (r17 == null) goto L55;
        String r18 = (String) r17.get("qcpx_coupon_point_info", "");
        if (r18 == null) goto L55;
        if (r18.length() <= 0) goto L48;
        boolean r19 = true;
    L49:
        if (r19 == false) goto L55;
        JSONObject r20 = new JSONObject(r18);
        Iterator<String> r21 = r20.keys();
    L52:
        if (r21.hasNext() == false) goto L54;
        String r22 = r21.next();
        r1.put(r22, r20.get(r22).toString());
        goto L52
    L54:
        r1.put("scene_id", "live_bar_exchange_coupon");
        goto L55
    L48:
        r19 = false;
    L55:
        com.bytedance.android.livesdk.log.u.l().sendLog(r7, r1, new Object[0]);
        return;
    L40:
        r16 = null;
    L36:
        r14 = "";
    L29:
        r12 = "";
    L22:
        r10 = "";
    L15:
        r8 = "";
    L8:
        r4 = "";
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (r7 == null) goto L47;
        Context r8 = r7.getContext();
        if (r8 == null) goto L47;
        ILiveActionHandler r0 = jc1.k.n(IRoomService.class).actionHandler();
        com.bytedance.android.livesdk.log.filter.o r1 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2 = this.b;
        String r3 = "";
        if (r2 == null) goto L9;
        String r4 = r2.e;
        if (r4 == null) goto L9;
    L10:
        Uri.Builder r5 = UriProtector.parse(r4).buildUpon();
        DataCenter r6 = this.c;
        if (r6 == null) goto L16;
        Room r9 = com.bytedance.android.live.core.utils.z.o(r6);
        if (r9 == null) goto L16;
        String r10 = String.valueOf(r9.getRoomId());
        if (r10 == null) goto L16;
    L17:
        Uri.Builder r11 = r5.appendQueryParameter("anchor_id", r10);
        DataCenter r12 = this.c;
        if (r12 == null) goto L23;
        Room r13 = com.bytedance.android.live.core.utils.z.o(r12);
        if (r13 == null) goto L23;
        String r14 = r13.getOwnerUserIdString();
        if (r14 == null) goto L23;
    L24:
        Uri.Builder r15 = r11.appendQueryParameter("room_id", r14);
        if (r1 == null) goto L30;
        Map r16 = r1.getMap();
        if (r16 == null) goto L30;
        String r17 = (String) r16.get("enter_from_merge");
        if (r17 == null) goto L30;
    L31:
        Uri.Builder r18 = r15.appendQueryParameter("enter_from_merge", r17);
        if (r1 == null) goto L37;
        Map r19 = r1.getMap();
        if (r19 == null) goto L37;
        String r20 = (String) r19.get("enter_method");
        if (r20 == null) goto L37;
    L38:
        Uri.Builder r21 = r18.appendQueryParameter("enter_method", r20);
        if (r1 == null) goto L46;
        Map r22 = r1.getMap();
        if (r22 == null) goto L46;
        String r23 = (String) r22.get("action_type");
        if (r23 == null) goto L46;
        r3 = r23;
    L46:
        r0.handle(r8, r21.appendQueryParameter("action_type", r3).build().toString());
    L37:
        r20 = "";
    L30:
        r17 = "";
    L23:
        r14 = "";
    L16:
        r10 = "";
    L9:
        r4 = "";
    L47:
        b("coupon_bottom_icon_click");
        a("live_coupon_bottom_icon_click");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.c = r3;
        this.d = r2.findViewById(2131368089);
        this.e = (TextView) r2.findViewById(2131368090);
    }
}
