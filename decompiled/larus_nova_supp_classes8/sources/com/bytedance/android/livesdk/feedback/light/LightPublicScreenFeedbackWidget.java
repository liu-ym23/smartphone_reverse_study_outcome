package com.bytedance.android.livesdk.feedback.light;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.config.ts;
import com.bytedance.android.livesdk.feedback.light.context.FeedbackPublicScreenContext;
import com.bytedance.android.livesdk.feedback.service.FeedbackHideCode;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.PublicScreenBottomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/light/LightPublicScreenFeedbackWidget;", "Lcom/bytedance/android/livesdk/feedback/light/LiveLightFeedbackWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LightPublicScreenFeedbackWidget extends LiveLightFeedbackWidget {
    public Room g;
    public HybridCard h;
    public boolean i;
    public final Boolean j;

    public static final class a<T> implements h80.a {
        public final /* synthetic */ LightPublicScreenFeedbackWidget a;

        public a(LightPublicScreenFeedbackWidget r1) {
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
            LightPublicScreenFeedbackWidget r7 = this.a;
            HybridCard r0 = r7.h;
            if (r0 != null) goto L14;
            return;
        L14:
            if (r7.i == false) goto L19;
            r7.Iq(r0);
            this.a.i = false;
            return;
        }
    }

    public final FeedbackCard Fq() {
        com.bytedance.android.livesdk.feedback.light.context.a r0 = this.a;
        if (r0 == null) goto L11;
        n<? extends FeedItem> r1 = r0.getShowRoomFeedback();
        if (r1 == null) goto L11;
        FeedItem r2 = (FeedItem) r1.getValue();
        if (r2 == null) goto L11;
        Room r3 = r2.getRoom();
        if (r3 == null) goto L11;
        return r3.mFeedbackCard;
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.LiveLightFeedbackWidget
    public final FeedbackPublicScreenContext zq() {
        Widget.WidgetCallback r0 = ((Widget) this).widgetCallback;
        if (r0 == null) goto L9;
        WidgetManager r1 = r0.getWidgetManager();
        if (r1 == null) goto L9;
        Fragment r2 = r1.parentFragment;
        if (r2 == null) goto L9;
        return (FeedbackPublicScreenContext) com.bytedance.live.datacontext.d.b(r2, LightPublicScreenFeedbackWidget$initLightFeedbackContext$1$1.INSTANCE).a(FeedbackPublicScreenContext.class);
    L9:
        return null;
    }

    public LightPublicScreenFeedbackWidget() {
        this.j = ts.a.getValue();
    }

    public final boolean Gq() {
        FeedbackCard r0 = Fq();
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

    @Override // com.bytedance.android.livesdk.feedback.light.LiveLightFeedbackWidget
    public final void onUnload() {
        super.onUnload();
        this.g = null;
        this.h = null;
        this.i = false;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.LiveLightFeedbackWidget
    public final void Cq(HybridCard r3) {
        Intrinsics.checkNotNullParameter(r3, "hybridCard");
        this.h = r3;
        Room r0 = this.g;
        if (r0 == null) goto L13;
        PublicScreenBottomInfo r1 = r0.publicScreenBottomInfo;
        if (r1 == null) goto L12;
        List r2 = r1.getCardList();
        if (r2 == null) goto L12;
        if ((!r2.isEmpty()) != true) goto L12;
        ALogger.e("PSBottomWidget", "has card info,can't show feedback");
        return;
    L12:
        Iq(r3);
        return;
    L13:
        this.i = true;
    }

    public final void Iq(HybridCard r6) {
        Object r1 = null;
        if (Gq() == false) goto L22;
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
        if (Gq() == false) goto L26;
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
        if (r13 == null) goto L40;
        n<hx1.b> r14 = r13.getFeedbackAnimService();
        if (r14 == null) goto L40;
        ViewGroup r15 = ((Widget) this).containerView;
        if (r15 == null) goto L39;
        r1 = new hx1.a(r15, r6, ((Widget) this).dataCenter);
    L39:
        r14.setValue(r1);
    L40:
        r11.showFeedbackCardWithAnim();
        return;
    L31:
        r12 = r11;
        goto L32
    }

    @Override // com.bytedance.android.livesdk.feedback.light.LiveLightFeedbackWidget
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

    @Override // com.bytedance.android.livesdk.feedback.light.LiveLightFeedbackWidget
    public final void onLoad(Object[] r2) {
        this.d = ((Widget) this).containerView;
        super.onLoad(r2);
        runWithRoomEntered(new a(this));
    }

    @Override // com.bytedance.android.livesdk.feedback.light.LiveLightFeedbackWidget
    public final void xq(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        FeedbackCard r0 = Fq();
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
        if (Gq() == false) goto L20;
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

    @Override // com.bytedance.android.livesdk.feedback.light.LiveLightFeedbackWidget
    public final void yq(Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        if (this.j.booleanValue() == false) goto L10;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L10;
        if (z.e(r0, false) != true) goto L10;
        ((HashMap) r4).put("position", "preview_bottom_component");
    L12:
        HashMap r5 = (HashMap) r4;
        r5.put("flow_type", "room");
        FeedbackCard r1 = Fq();
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
        if (Gq() == true) goto L12;
        ((HashMap) r4).put("position", "room_public_screen");
        goto L12
    }

    @Override // com.bytedance.android.livesdk.feedback.light.LiveLightFeedbackWidget
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }
}
