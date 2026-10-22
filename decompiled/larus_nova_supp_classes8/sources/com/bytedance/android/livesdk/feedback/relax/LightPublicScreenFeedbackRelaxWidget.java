package com.bytedance.android.livesdk.feedback.relax;

import am2.x;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.config.ov;
import com.bytedance.android.livesdk.config.ts;
import com.bytedance.android.livesdk.feedback.light.context.FeedbackPublicScreenContext;
import com.bytedance.android.livesdk.feedback.service.FeedbackHideCode;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.PublicScreenBottomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import w20.e8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/relax/LightPublicScreenFeedbackRelaxWidget;", "Lcom/bytedance/android/livesdk/feedback/relax/LiveLightFeedbackRelaxWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LightPublicScreenFeedbackRelaxWidget extends LiveLightFeedbackRelaxWidget {
    public Room g;
    public d03.b<p> h;
    public boolean i;
    public final Boolean j;

    public final class a implements k {
        public final /* synthetic */ LightPublicScreenFeedbackRelaxWidget a;

        public a(LightPublicScreenFeedbackRelaxWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.feedback.relax.k
        public final void a(Map<String, Object> r6) {
            Intrinsics.checkNotNullParameter(r6, "params");
            ALogger.d("[Relax handleSelected]", "RelaxFeedbacProps");
            e8 r0 = new e8();
            Object r2 = r6.get("feedback");
            com.bytedance.android.livesdk.feedback.light.context.a r4 = null;
            if ((r2 instanceof Integer) == true) goto L5;
            r2 = null;
        L5:
            r0.d((Integer) r2);
            Object r3 = r6.get("action");
            if ((r3 instanceof String) == true) goto L8;
            r3 = null;
        L8:
            r0.c((String) r3);
            Object r7 = r6.get("toast_info");
            if ((r7 instanceof String) == true) goto L11;
            r7 = null;
        L11:
            r0.e((String) r7);
            ALogger.d("[Relax handleSelected]", "paramsModel");
            com.bytedance.android.livesdk.feedback.light.context.a r8 = this.a.a;
            if ((r8 instanceof FeedbackPublicScreenContext) == false) goto L15;
            r4 = r8;
        L15:
            FeedbackPublicScreenContext r5 = (FeedbackPublicScreenContext) r4;
            if (r5 == null) goto L18;
            r5.relaxCallback(r0);
        L18:
            ALogger.d("[Relax handleSelected]", "relaxCallback");
        }
    }

    public static final class b<T> implements h80.a {
        public final /* synthetic */ LightPublicScreenFeedbackRelaxWidget a;

        public b(LightPublicScreenFeedbackRelaxWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Room r4 = (Room) r3;
            this.a.g = r4;
            if (r4 == null) goto L11;
            PublicScreenBottomInfo r5 = r4.publicScreenBottomInfo;
            if (r5 == null) goto L11;
            List r6 = r5.getCardList();
            if (r6 == null) goto L11;
            if ((!r6.isEmpty()) != true) goto L11;
            ALogger.e("PSBottomWidget", "realRoom has card info,can't show feedback");
            return;
        L11:
            LightPublicScreenFeedbackRelaxWidget r7 = this.a;
            d03.b<p> r0 = r7.h;
            if (r0 != null) goto L14;
            return;
        L14:
            if (r7.i == false) goto L19;
            r7.Gq(r0);
            this.a.i = false;
            return;
        }
    }

    public final FeedbackCard Eq() {
        com.bytedance.android.livesdk.feedback.light.context.a r0 = this.a;
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n<? extends FeedItem> r1 = r0.getShowRoomFeedback();
        if (r1 == null) goto L11;
        FeedItem r2 = (FeedItem) r1.getValue();
        if (r2 == null) goto L11;
        Room r3 = r2.getRoom();
        if (r3 == null) goto L11;
        return r3.mFeedbackCard;
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdk.feedback.relax.LiveLightFeedbackRelaxWidget
    public final FeedbackPublicScreenContext yq() {
        Widget.WidgetCallback r0 = ((Widget) this).widgetCallback;
        if (r0 == null) goto L9;
        WidgetManager r1 = r0.getWidgetManager();
        if (r1 == null) goto L9;
        Fragment r2 = r1.parentFragment;
        if (r2 == null) goto L9;
        return (FeedbackPublicScreenContext) com.bytedance.live.datacontext.d.b(r2, LightPublicScreenFeedbackRelaxWidget$initLightFeedbackContext$1$1.INSTANCE).a(FeedbackPublicScreenContext.class);
    L9:
        return null;
    }

    public LightPublicScreenFeedbackRelaxWidget() {
        this.j = ts.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.feedback.relax.LiveLightFeedbackRelaxWidget
    public final void Aq() {
        super.Aq();
        com.bytedance.android.livesdk.log.filter.o r0 = u.l().c(x.class);
        String r2 = null;
        if ((r0 instanceof n0) == true) goto L5;
        r0 = null;
    L5:
        n0 r1 = (n0) r0;
        HashMap r3 = new HashMap();
        com.bytedance.android.livesdk.feedback.light.context.a r4 = this.a;
        if (r4 == null) goto L14;
        com.bytedance.live.datacontext.n<? extends FeedItem> r5 = r4.getShowRoomFeedback();
        if (r5 == null) goto L14;
        FeedItem r6 = (FeedItem) r5.getValue();
        if (r6 == null) goto L14;
        Room r7 = r6.getRoom();
        if (r7 == null) goto L14;
        FeedbackCard r8 = r7.mFeedbackCard;
    L15:
        String r9 = "";
        if (r8 == null) goto L19;
        String r10 = GsonProtectorUtils.toJson(GsonHelper.get(), r8);
        if (r10 == null) goto L19;
    L20:
        r3.put("feedbackData", r10);
        r3.put("room_id", String.valueOf(z.o(((Widget) this).dataCenter).id));
        if (r1 == null) goto L26;
        Map r11 = ((com.bytedance.android.livesdk.log.filter.a) r1).b;
        if (r11 == null) goto L26;
        String r12 = (String) r11.get("enter_from_merge");
        if (r12 == null) goto L26;
    L27:
        r3.put("enter_from_merge", r12);
        if (r1 == null) goto L33;
        Map r13 = ((com.bytedance.android.livesdk.log.filter.a) r1).b;
        if (r13 == null) goto L33;
        String r14 = (String) r13.get("enter_method");
        if (r14 == null) goto L33;
    L34:
        r3.put("enter_method", r14);
        if (r1 == null) goto L40;
        Map r15 = ((com.bytedance.android.livesdk.log.filter.a) r1).b;
        if (r15 == null) goto L40;
        String r16 = (String) r15.get("action_type");
        if (r16 == null) goto L40;
    L41:
        r3.put("action_type", r16);
        String r17 = z.o(((Widget) this).dataCenter).getRequestId();
        if (r17 != null) goto L44;
        r17 = "";
    L44:
        r3.put("request_id", r17);
        User r18 = z.o(((Widget) this).dataCenter).getOwner();
        if (r18 == null) goto L47;
        r2 = r18.getIdStr();
    L47:
        r3.put("anchor_id", String.valueOf(r2));
        r3.put("flow_type", "room");
        if (r8 == null) goto L51;
        String r19 = r8.getLogInfo();
        if (r19 == null) goto L51;
    L52:
        r3.put("question_text", r19);
        r3.put("question_type", "single");
        if (r8 == null) goto L58;
        Integer r20 = r8.getIndex();
        if (r20 == null) goto L58;
        String r21 = String.valueOf(r20.intValue());
        if (r21 == null) goto L58;
    L59:
        r3.put("draw_order", r21);
        ILiveFeedbackService r22 = jc1.k.f(ILiveFeedbackService.class);
        if (r22 == null) goto L65;
        String r23 = r22.getRecentRoomIds();
        if (r23 == null) goto L65;
        r9 = r23;
    L65:
        r3.put("recent_room_ids", r9);
        r3.put("pk_id", Long.valueOf(jc1.k.n(ILinkServiceExternal.class).getMultiDataHolderExternal().getPkId()));
        Cq(r3);
        int r24 = 0;
        d03.b<p> r25 = new d03.b(((Widget) this).context, new p(new RTSRelaxFeedbackLightData(MapsKt.toMutableMap(r3)), new a(this)), false, 12);
        this.b = r25;
        FrameLayout r26 = r25.a();
        if (r26 == null) goto L68;
        r26.removeAllViews();
    L68:
        com.bytedance.android.livesdk.feedback.light.context.a r27 = this.a;
        if (r27 == null) goto L82;
        com.bytedance.live.datacontext.n<? extends FeedItem> r28 = r27.getShowRoomFeedback();
        if (r28 == null) goto L82;
        FeedItem r29 = (FeedItem) r28.getValue();
        if (r29 == null) goto L82;
        Room r30 = r29.getRoom();
        if (r30 == null) goto L82;
        FeedbackCard r31 = r30.mFeedbackCard;
        if (r31 == null) goto L82;
        Integer r32 = r31.feedbackType;
        if (r32 == null) goto L82;
        r24 = r32.intValue();
    L82:
        if (r24 != 10) goto L96;
        if (ov.a.getValue().booleanValue() == false) goto L90;
        Lambda r33 = EntryKt.d;
        FrameLayout r34 = r25.a();
        if (r34 == null) goto L89;
        r25.c(r33, r34, new FrameLayout.LayoutParams(-1, -2));
    L105:
        Intrinsics.checkNotNullParameter(r25, "relaxCard");
        this.h = r25;
        Room r35 = this.g;
        if (r35 == null) goto L115;
        PublicScreenBottomInfo r36 = r35.publicScreenBottomInfo;
        if (r36 == null) goto L114;
        List r37 = r36.getCardList();
        if (r37 == null) goto L114;
        if ((!r37.isEmpty()) != true) goto L114;
        ALogger.e("PSBottomWidget", "has card info,can't show feedback");
        return;
    L114:
        Gq(r25);
        return;
    L115:
        this.i = true;
        return;
    L89:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L90:
        Lambda r38 = EntryKt.b;
        FrameLayout r39 = r25.a();
        if (r39 == null) goto L94;
        r25.c(r38, r39, new FrameLayout.LayoutParams(-1, -2));
        goto L105
    L94:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L96:
        if (ov.a.getValue().booleanValue() == false) goto L102;
        Lambda r40 = EntryKt.c;
        FrameLayout r41 = r25.a();
        if (r41 == null) goto L101;
        r25.c(r40, r41, new FrameLayout.LayoutParams(-1, -2));
        goto L105
    L101:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L102:
        Lambda r42 = EntryKt.a;
        FrameLayout r43 = r25.a();
        if (r43 == null) goto L118;
        r25.c(r42, r43, new FrameLayout.LayoutParams(-1, -2));
        goto L105
    L118:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L58:
        r21 = "0";
    L51:
        r19 = "";
    L40:
        r16 = "";
    L33:
        r14 = "";
    L26:
        r12 = "";
    L19:
        r10 = "";
    L14:
        r8 = null;
        goto L15
    }

    public final boolean Fq() {
        FeedbackCard r0 = Eq();
        if (r0 == null) goto L5;
        Integer r1 = r0.feedbackType;
    L6:
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.intValue() != 10) goto L11;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feedback.relax.LiveLightFeedbackRelaxWidget
    public final void onUnload() {
        super.onUnload();
        this.g = null;
        this.h = null;
        this.i = false;
    }

    public final void Cq(Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        if (this.j.booleanValue() == false) goto L10;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L10;
        if (z.e(r0, false) != true) goto L10;
        ((HashMap) r4).put("position", "preview_bottom_component");
    L12:
        HashMap r5 = (HashMap) r4;
        r5.put("flow_type", "room");
        FeedbackCard r1 = Eq();
        if (r1 == null) goto L15;
        Integer r2 = r1.feedbackType;
    L16:
        if (r2 != null) goto L19;
    L21:
        String r3 = "live_banner_horizontal";
    L22:
        r5.put("card_type", r3);
        return;
    L19:
        if (r2.intValue() != 10) goto L21;
        r3 = "face_live_banner_horizontal";
        goto L22
    L15:
        r2 = null;
    L10:
        if (Fq() == true) goto L12;
        ((HashMap) r4).put("position", "room_public_screen");
        goto L12
    }

    public final void Gq(d03.b<p> r6) {
        Object r1 = null;
        if (Fq() == false) goto L22;
        com.bytedance.android.livesdk.feedback.light.context.a r0 = this.a;
        if ((r0 instanceof FeedbackPublicScreenContext) == true) goto L7;
        r0 = null;
    L7:
        FeedbackPublicScreenContext r2 = (FeedbackPublicScreenContext) r0;
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L22;
        int r7 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r8 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LightPublicScreenFeedbackWidget", "page");
        r8.a = "LightPublicScreenFeedbackWidget";
        r8.c("展示问卷失败，右下角有卡片正在展示");
        Pair[] r4 = new Pair[1];
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L19;
        Room r9 = z.o(r5);
        if (r9 == null) goto L19;
        r1 = r9.getIdStr();
    L19:
        r4[0] = TuplesKt.to("roomId", r1);
        r8.b(r4);
        r8.d();
        return;
    L10:
        if (r2.isBottomRightCardShowing() != true) goto L12;
        r3 = true;
    L22:
        if (Fq() == false) goto L26;
        ViewGroup r10 = ((Widget) this).containerView;
        if (r10 == null) goto L26;
        r10.setPadding(0, UtilityKotlinExtentionsKt.i(3), 0, 0);
    L26:
        com.bytedance.android.livesdk.feedback.light.context.a r11 = this.a;
        if (r11 != null) goto L29;
        return;
    L29:
        if ((r11 instanceof FeedbackPublicScreenContext) == true) goto L31;
        com.bytedance.android.livesdk.feedback.light.context.a r12 = null;
    L32:
        FeedbackPublicScreenContext r13 = (FeedbackPublicScreenContext) r12;
        if (r13 == null) goto L44;
        com.bytedance.live.datacontext.n<hx1.b> r14 = r13.getFeedbackAnimService();
        if (r14 == null) goto L44;
        ViewGroup r15 = ((Widget) this).containerView;
        if (r15 == null) goto L43;
        FrameLayout r16 = r6.a();
        if (r16 == null) goto L42;
        r1 = new hx1.a(r15, r16, ((Widget) this).dataCenter);
        goto L43
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L43:
        r14.setValue(r1);
    L44:
        r11.showFeedbackCardWithAnim();
        return;
    L31:
        r12 = r11;
        goto L32
    }

    @Override // com.bytedance.android.livesdk.feedback.relax.LiveLightFeedbackRelaxWidget
    public final void onChanged(KVData r5) {
        com.bytedance.android.livesdk.feedback.light.context.a r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == (-2068819755)) goto L12;
        return;
    L12:
        if (r1.equals("DATA_IS_HIDE_INTERACTION") == false) goto L26;
        com.bytedance.android.livesdk.feedback.light.context.a r2 = this.a;
        if (r2 != null) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual((Boolean) r5.getData(Boolean.FALSE), Boolean.TRUE) == true) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L23;
        r0 = r2;
    L23:
        if (r0 == null) goto L28;
        r0.dismissFeedbackWithAnim(FeedbackHideCode.CLEAR_MODE);
        return;
    L28:
        return;
    L18:
        if (((Boolean) r2.isFeedbackCardShowing().getValue()).booleanValue() == false) goto L20;
        r6 = true;
        goto L21
    L26:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feedback.relax.LiveLightFeedbackRelaxWidget
    public final void onLoad(Object[] r2) {
        this.d = ((Widget) this).containerView;
        super.onLoad(r2);
        runWithRoomEntered(new b(this));
    }

    @Override // com.bytedance.android.livesdk.feedback.relax.LiveLightFeedbackRelaxWidget
    public final void xq(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        FeedbackCard r0 = Eq();
        FeedbackHideCode r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = r0.feedbackType;
    L6:
        if (r2 != null) goto L9;
    L11:
        String r3 = "live_banner_horizontal";
    L12:
        r4.put("card_type", r3);
        r4.put("flow_type", "room");
        if (Fq() == false) goto L20;
        com.bytedance.android.livesdk.feedback.light.context.a r5 = this.a;
        if (r5 == null) goto L18;
        r1 = r5.getDismissCode();
    L18:
        if (r1 != FeedbackHideCode.RIGHT_BOTTOM_CARD_SHOW) goto L20;
        String r6 = "1";
    L21:
        r4.put("is_show_priority_close", r6);
        return;
    L20:
        r6 = "0";
        goto L21
    L9:
        if (r2.intValue() != 10) goto L11;
        r3 = "face_live_banner_horizontal";
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feedback.relax.LiveLightFeedbackRelaxWidget
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }
}
