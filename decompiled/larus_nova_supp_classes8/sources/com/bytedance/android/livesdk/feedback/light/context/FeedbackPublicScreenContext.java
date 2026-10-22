package com.bytedance.android.livesdk.feedback.light.context;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.config.ll0;
import com.bytedance.android.livesdk.config.mv;
import com.bytedance.android.livesdk.config.s50;
import com.bytedance.android.livesdk.feedback.LightFeedbackDataManager;
import com.bytedance.android.livesdk.feedback.condition.trigger.BottomRightCardShowTrigger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.feedback.service.LiveRoomPublicScreenFeedbackConfig;
import com.bytedance.android.livesdk.feedback.service.RoomPublicScreenEmojiFeedbackConfig;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\f\u001a\u00020\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\rR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010 \u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/light/context/FeedbackPublicScreenContext;", "Lcom/bytedance/android/livesdk/feedback/light/context/LightFeedbackContext;", "", "roomId", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "feedbackInfo", "", "isEmojiFeedback", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "initFeedbackConfig", "isBottomRightCardShowing", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/live/datacontext/i;", "Lix1/a;", "_feedbackConfigService$delegate", "Lcom/bytedance/live/datacontext/p;", "get_feedbackConfigService", "()Lcom/bytedance/live/datacontext/i;", "_feedbackConfigService", "feedbackConfigService", "Lcom/bytedance/live/datacontext/i;", "getFeedbackConfigService", "", "getLynxUrl", "()Ljava/lang/String;", "lynxUrl", "getWebUrl", "webUrl", "getAutoDismissFeedbackTime", "()J", "autoDismissFeedbackTime", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackPublicScreenContext extends LightFeedbackContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p _feedbackConfigService$delegate;
    private DataCenter dataCenter;
    private final i<ix1.a> feedbackConfigService;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(FeedbackPublicScreenContext.class, "_feedbackConfigService", "get_feedbackConfigService()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0))};
    }

    private final i<ix1.a> get_feedbackConfigService() {
        return (i) this._feedbackConfigService$delegate.a(this, $$delegatedProperties[0]);
    }

    private final boolean isEmojiFeedback() {
        DataCenter r0 = this.dataCenter;
        if (r0 == null) goto L16;
        Room r1 = z.o(r0);
        if (r1 == null) goto L17;
        FeedbackCard r2 = feedbackInfo(r1.getRoomId());
        if (r2 == null) goto L9;
        Integer r3 = r2.feedbackType;
    L10:
        if (r3 != null) goto L13;
        return false;
    L13:
        if (r3.intValue() == 10) goto L15;
        return false;
    L15:
        return true;
    L9:
        r3 = null;
        goto L10
    L17:
        return false;
    L16:
        return false;
    }

    public FeedbackPublicScreenContext() {
        this._feedbackConfigService$delegate = ConstantKt.d(this, new ix1.b());
        this.feedbackConfigService = get_feedbackConfigService();
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.LightFeedbackContext
    public long getAutoDismissFeedbackTime() {
        if (isEmojiFeedback() == false) goto L9;
        Long r0 = ll0.a.getValue().b();
        if (r0 != null) goto L10;
        return 30;
    L10:
        return r0.longValue();
    L9:
        return s50.a.getValue().c();
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.LightFeedbackContext, com.bytedance.android.livesdk.feedback.light.context.a
    public String getLynxUrl() {
        if (isEmojiFeedback() == false) goto L8;
        int r0 = com.bytedance.android.livesdk.feedback.utils.a.a;
        String r1 = ll0.a.getValue().a();
        if (r1 != null) goto L9;
        return "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/community_feedback_lynx_douyin/pages/live_discuss_feedback/template.js";
    L9:
        return r1;
    L8:
        return s50.a.getValue().b();
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.LightFeedbackContext, com.bytedance.android.livesdk.feedback.light.context.a
    public String getWebUrl() {
        if (isEmojiFeedback() == false) goto L8;
        int r0 = com.bytedance.android.livesdk.feedback.utils.a.a;
        String r1 = ll0.a.getValue().c();
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L8:
        return s50.a.getValue().d();
    }

    public final boolean isBottomRightCardShowing() {
        List<com.bytedance.android.livesdk.feedback.service.d> r0 = ((ix1.a) getFeedbackConfigService().getValue()).a();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L31;
        com.bytedance.android.livesdk.feedback.service.e r2 = ((com.bytedance.android.livesdk.feedback.service.d) r1.next()).a();
        fx1.e<Object> r3 = null;
        if (r2 == null) goto L13;
        fx1.e<Object> r4 = r2.findTriggerById(TriggerId.BOTTOM_RIGHT_CARD_SHOW);
    L15:
        if ((r4 instanceof BottomRightCardShowTrigger) == false) goto L18;
        r3 = r4;
    L18:
        BottomRightCardShowTrigger r5 = (BottomRightCardShowTrigger) r3;
        if (r5 == null) goto L21;
        boolean r6 = r5.g();
    L22:
        if (r6 == false) goto L9;
        return true;
    L21:
        r6 = false;
        goto L22
    L13:
        r4 = null;
        goto L15
    L31:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.LightFeedbackContext, com.bytedance.android.livesdk.feedback.light.context.a
    public i<ix1.a> getFeedbackConfigService() {
        return this.feedbackConfigService;
    }

    private final FeedbackCard feedbackInfo(long r2) {
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r0 = LightFeedbackDataManager.a.a();
        if (r0 == null) goto L9;
        FeedItem r3 = r0.getRoomFeedback(r2);
        if (r3 == null) goto L9;
        Room r4 = r3.getRoom();
        if (r4 == null) goto L9;
        return r4.mFeedbackCard;
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.feedback.light.context.LightFeedbackContext, com.bytedance.android.livesdk.feedback.light.context.a
    public void initFeedbackConfig(DataCenter r8) {
        this.dataCenter = r8;
        if (r8 != null) goto L5;
        return;
    L5:
        if (z.m(r8, true) != true) goto L12;
        List<? extends com.bytedance.android.livesdk.feedback.service.d> r0 = CollectionsKt.mutableListOf(new com.bytedance.android.livesdk.feedback.service.d[]{new com.bytedance.android.livesdk.feedback.service.i(this, new gx1.a(z.o(r8).getRoomId(), z.o(r8).getOwnerUserIdString()), r8), new RoomPublicScreenEmojiFeedbackConfig(this, new gx1.a(z.o(r8).getRoomId(), z.o(r8).getOwnerUserIdString()), r8)});
        if (mv.a.getValue().booleanValue() == false) goto L9;
        r0.add(new LiveRoomPublicScreenFeedbackConfig(this, new gx1.a(z.o(r8).getRoomId(), z.o(r8).getOwnerUserIdString()), r8));
    L9:
        ((ix1.a) get_feedbackConfigService().getValue()).e(r0);
        return;
    }
}
