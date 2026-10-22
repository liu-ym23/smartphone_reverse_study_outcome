package com.bytedance.android.live.revlink.impl.control;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.ILinkerDetailKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00060\u0001j\u0002`\u0002:\u0002#$B\u001b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b \u0010!J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J \u0010\u0011\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u00020\nH\u0016R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/control/RevLinkLiveFeedViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/ViewModel;", "Lcom/bytedance/android/live/revlink/impl/control/RevLinkLiveFeedViewModel$FeedPkLostType;", "lostType", "", "roomId", "", "feedRoomScene", "feedRoomBuildTs", "", "reportFeedPkNotShown", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "room", "Lcom/bytedance/android/live/revlink/impl/control/c;", "enterRoomLinkInfo", "onRoomRead", "onCleared", "", "readRoomSet", "Ljava/util/Set;", "Lld/a;", "linkDataSet", "Lld/a;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lcom/bytedance/android/live/revlink/impl/service/internal/LinkRevInternalServiceContext;", "getLinkRevInternalServiceContext", "()Lcom/bytedance/android/live/revlink/impl/service/internal/LinkRevInternalServiceContext;", "linkRevInternalServiceContext", "<init>", "(Lld/a;Lcom/bytedance/android/live/revlink/impl/global/c;)V", "Companion", "a", "FeedPkLostType", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkLiveFeedViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "ttlive_revlink_feed";
    private static final ReadOnlyProperty enableReportInnerFeedPkLost$delegate = null;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final Set<Long> readRoomSet;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/control/RevLinkLiveFeedViewModel$FeedPkLostType;", "", "LINK_FINISHED", "PK_FINISHED", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum FeedPkLostType extends Enum<FeedPkLostType> {
        public static final FeedPkLostType LINK_FINISHED = null;
        public static final FeedPkLostType PK_FINISHED = null;
        public static final /* synthetic */ FeedPkLostType[] a = null;

        static {
            FeedPkLostType r1 = new FeedPkLostType("LINK_FINISHED", 0);
            LINK_FINISHED = r1;
            FeedPkLostType r2 = new FeedPkLostType("PK_FINISHED", 1);
            PK_FINISHED = r2;
            a = new FeedPkLostType[]{r1, r2};
        }

        public static FeedPkLostType valueOf(String r1) {
            return (FeedPkLostType) r27.a.a(FeedPkLostType.class, r1);
        }

        public static FeedPkLostType[] values() {
            return (FeedPkLostType[]) a.clone();
        }

        public FeedPkLostType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "enableReportInnerFeedPkLost", "getEnableReportInnerFeedPkLost()Z", 0))};
        }

        public a() {
        }
    }

    static {
        Companion = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_report_inner_feed_pk_lost", Boolean.TRUE, Boolean.TYPE, false);
        KProperty r10 = a.a[0];
        enableReportInnerFeedPkLost$delegate = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
    }

    private final LinkRevInternalServiceContext getLinkRevInternalServiceContext() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.linkFakeGlobalService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Cj();
    }

    public void onCleared() {
        super.onCleared();
        this.readRoomSet.clear();
    }

    public static final /* synthetic */ ReadOnlyProperty access$getEnableReportInnerFeedPkLost$cp() {
        return enableReportInnerFeedPkLost$delegate;
    }

    public RevLinkLiveFeedViewModel(ld.a r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.linkDataSet = r1;
        this.linkFakeGlobalService = r2;
        this.readRoomSet = new LinkedHashSet();
    }

    public final void onRoomRead(IRoom r12, c r13) {
        if (r12 == null) goto L73;
        IRoomBase r14 = (IRoomBase) r12;
        if (this.readRoomSet.contains(Long.valueOf(IRoomKtKt.getId(r14))) == true) goto L77;
        this.readRoomSet.add(Long.valueOf(IRoomKtKt.getId(r14)));
        ld.a r0 = this.linkDataSet;
        if (r0 == null) goto L12;
        NextLiveData r1 = r0.jm();
        if (r1 == null) goto L12;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L12;
    L13:
        long r8 = r2.longValue();
        ld.a r3 = this.linkDataSet;
        boolean r4 = false;
        if (r3 == null) goto L19;
        NextLiveData r5 = r3.i2();
        if (r5 == null) goto L19;
        Integer r6 = (Integer) r5.getValue();
        if (r6 == null) goto L19;
    L20:
        int r7 = r6.intValue();
        ld.a r9 = this.linkDataSet;
        if (r9 == null) goto L26;
        NextLiveData r10 = r9.Qk();
        if (r10 == null) goto L26;
        Integer r15 = (Integer) r10.getValue();
        if (r15 == null) goto L26;
    L27:
        int r16 = r15.intValue();
        if (r7 != 1) goto L30;
    L33:
        boolean r17 = true;
    L34:
        if (r17 == false) goto L74;
        if (r16 == 0) goto L75;
        if (r13 == null) goto L78;
        u r18 = r13.c;
        if (r18 == null) goto L41;
    L44:
        boolean r19 = true;
    L45:
        if (r19 == true) goto L48;
        FeedPkLostType r110 = FeedPkLostType.LINK_FINISHED;
    L47:
        FeedPkLostType r20 = r110;
        reportFeedPkNotShown(r20, IRoomKtKt.getId(r14), r7, r8);
        return;
    L48:
        if (r18 == null) goto L59;
        a9 r22 = r18.e;
        if (r22 == null) goto L59;
        ILinkMicBattleSetting r23 = r22.getBattleSetting();
        if (r23 == null) goto L59;
        if (r23.getBattleId() > 0) goto L56;
    L69:
        if (r4 == true) goto L76;
        r110 = FeedPkLostType.PK_FINISHED;
        goto L47
    L76:
        return;
    L56:
        if (((int) r23.getFinished()) != 0) goto L69;
    L68:
        r4 = true;
    L59:
        if (r13.d == null) goto L69;
        IRoomLinkExt r111 = r13.b;
        if (r111 == null) goto L69;
        z5 r112 = IRoomKt_androidKt.getLinkerDetailKt(r111);
        if (r112 == null) goto L69;
        List r113 = ILinkerDetailKt.getPlayModesEx(r112);
        if (r113 == null) goto L69;
        if (r113.contains(3L) != true) goto L69;
    L41:
        if (r13.d != null) goto L44;
        r19 = false;
        goto L45
    L78:
        return;
    L75:
        return;
    L74:
        return;
    L30:
        if (r7 == 7) goto L33;
        r17 = false;
    L26:
        r15 = 0;
    L19:
        r6 = 0;
    L12:
        r2 = 0L;
        goto L13
    L77:
        return;
    }

    private final void reportFeedPkNotShown(FeedPkLostType r4, long r5, int r7, long r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("event_type", "inner_feed_pk_not_shown");
        r0.put("status_msg", r4.toString());
        r0.put("feed_scene", String.valueOf(r7));
        i97.a r6 = i97.a.a;
        r0.put("refresh_time_gap", String.valueOf(System.currentTimeMillis() - r8));
        LinkRevInternalServiceContext r9 = getLinkRevInternalServiceContext();
        if (r9 == null) goto L5;
        int r10 = r9.getCurrentFeedLength();
    L6:
        r0.put("inner_feed_length", String.valueOf(r10));
        jy0.b.d(TAG, "feed room " + r5 + " pk not shown, " + r0);
        a r12 = Companion;
        r12.getClass();
        if (((Boolean) access$getEnableReportInnerFeedPkLost$cp().getValue(r12, a.a[0])).booleanValue() == false) goto L9;
        return;
    L9:
        mz0.n r13 = new mz0.n();
        Map<String, String> r14 = r13.a;
        Intrinsics.checkNotNullParameter(r14, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r14.putAll(r0);
        mz0.m r15 = new mz0.m();
        r15.b(LogCommon.ROOM);
        r15.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r13.b).addAll(r15.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_rd_feed_pk_event", r13.a, r13.b);
        return;
    L5:
        r10 = 0;
        goto L6
    }
}
