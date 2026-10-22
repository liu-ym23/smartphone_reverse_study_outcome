package com.bytedance.android.livesdk.impl;

import ag1.e0;
import ag1.f0;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.room.r;
import com.bytedance.android.live.room.s;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.AutoPageChangeManager;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPlatformApiForSaas;
import com.bytedance.android.livesdk.chatroom.detail.d0;
import com.bytedance.android.livesdk.chatroom.detail.e;
import com.bytedance.android.livesdk.chatroom.detail.l;
import com.bytedance.android.livesdk.chatroom.detail.q;
import com.bytedance.android.livesdk.chatroom.detail.t;
import com.bytedance.android.livesdk.chatroom.end.relax.LiveAudienceEndRtsFragment;
import com.bytedance.android.livesdk.chatroom.end.tabliveguide.LiveEndTabGuideManager;
import com.bytedance.android.livesdk.chatroom.end.z0;
import com.bytedance.android.livesdk.chatroom.l1;
import com.bytedance.android.livesdk.chatroom.room.apm.LiveMkStallManager;
import com.bytedance.android.livesdk.chatroom.room.apm.LiveMkStallManagerForAnchor;
import com.bytedance.android.livesdk.chatroom.room.apm.LiveRoomFpsMonitor;
import com.bytedance.android.livesdk.chatroom.room.apm.RoomEnterExtensionMonitor;
import com.bytedance.android.livesdk.chatroom.room.apm.RoomExitExtensionMonitor;
import com.bytedance.android.livesdk.chatroom.room.apm.h;
import com.bytedance.android.livesdk.chatroom.room.apm.y;
import com.bytedance.android.livesdk.chatroom.room.apm.z;
import com.bytedance.android.livesdk.chatroom.room.backend.LiveRoomBackendUtils;
import com.bytedance.android.livesdk.chatroom.room.backend.g;
import com.bytedance.android.livesdk.chatroom.room.backend.g0;
import com.bytedance.android.livesdk.chatroom.room.backend.h0;
import com.bytedance.android.livesdk.chatroom.room.backend.i;
import com.bytedance.android.livesdk.chatroom.room.backend.i0;
import com.bytedance.android.livesdk.chatroom.room.backend.j0;
import com.bytedance.android.livesdk.chatroom.room.business.interact.RoomEnterDegradeHelper;
import com.bytedance.android.livesdk.chatroom.room.core.task.EnterRoomTaskV1;
import com.bytedance.android.livesdk.chatroom.room.engine.PreEnterRoomManager;
import com.bytedance.android.livesdk.chatroom.room.engine.RoomEngine;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.chatroom.room.r0;
import com.bytedance.android.livesdk.config.wt;
import com.bytedance.android.livesdk.linkvideo.d;
import com.bytedance.android.livesdk.linkvideo.ui.LinkVideoDialog;
import com.bytedance.android.livesdk.utils.n2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.model.LiveRoomAPMConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import jc1.k;
import kn1.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import q81.f;
import q81.j;
import qn2.m;
import qn2.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J*\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J8\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016JF\u0010%\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020\u000fH\u0016J\n\u0010'\u001a\u0004\u0018\u00010&H\u0016J\"\u0010.\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u001c\u00102\u001a\u0004\u0018\u0001012\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J2\u00108\u001a\u0004\u0018\u0001072\b\u00103\u001a\u0004\u0018\u00010/2\b\u00104\u001a\u0004\u0018\u00010\u00172\b\u00105\u001a\u0004\u0018\u00010\u00172\b\u00106\u001a\u0004\u0018\u000101H\u0016J\b\u0010:\u001a\u000209H\u0016J*\u0010A\u001a\u00020@2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u00112\u0006\u0010?\u001a\u00020\u000fH\u0016J\b\u0010C\u001a\u00020BH\u0016J\b\u0010E\u001a\u00020DH\u0016J\b\u0010G\u001a\u00020FH\u0016J\u0018\u0010M\u001a\u00020L2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020JH\u0016J \u0010O\u001a\u00020L2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J2\u0006\u0010N\u001a\u00020\u0004H\u0016J\u001e\u0010S\u001a\u0004\u0018\u00010R2\b\u0010P\u001a\u0004\u0018\u00010\u00172\b\u0010Q\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010U\u001a\u00020TH\u0016J\u0014\u0010X\u001a\u0004\u0018\u00010W2\b\u0010V\u001a\u0004\u0018\u00010\u0011H\u0016J\u0014\u0010Z\u001a\u0004\u0018\u00010Y2\b\u0010V\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\n\u0010^\u001a\u0004\u0018\u00010]H\u0016J\u0014\u0010b\u001a\u0004\u0018\u00010a2\b\u0010`\u001a\u0004\u0018\u00010_H\u0016J\b\u0010d\u001a\u00020cH\u0016J\b\u0010f\u001a\u00020eH\u0016J\b\u0010h\u001a\u00020gH\u0016J\u001c\u0010j\u001a\u0004\u0018\u00010i2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010l\u001a\u00020kH\u0016J\b\u0010n\u001a\u00020mH\u0016J\b\u0010p\u001a\u00020oH\u0016J\b\u0010r\u001a\u00020qH\u0016J\u001a\u0010u\u001a\f\u0012\u0006\b\u0001\u0012\u00020t\u0018\u00010s2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010w\u001a\u00020vH\u0016J\b\u0010y\u001a\u00020xH\u0016J$\u0010\u007f\u001a\u00020~2\u0006\u00103\u001a\u00020/2\b\u0010{\u001a\u0004\u0018\u00010z2\b\u0010}\u001a\u0004\u0018\u00010|H\u0016¨\u0006\u0082\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/impl/RoomModuleService;", "Lcom/bytedance/android/livesdk/api/IRoomModuleService;", BuildConfig.FLAVOR, "injectFunctions", BuildConfig.FLAVOR, "isPreload", BuildConfig.FLAVOR, "Lis2/b;", "getBackendHandlers", "Lcom/bytedance/android/live/room/r;", "getRoomManager", BuildConfig.FLAVOR, "type", "Lcom/bytedance/android/livesdk/chatroom/detail/e$a;", "listener", BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "userId", "Lcom/bytedance/android/livesdk/chatroom/detail/e;", "newRoomFetcher", "Lcom/bytedance/android/livesdk/chatroom/detail/p$a;", "labels", BuildConfig.FLAVOR, "enterInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "preloadRoom", "Lcom/bytedance/android/livesdk/chatroom/detail/p;", "newEnterRoomController", "streamId", "roomLabels", "fromFeed", "Lcom/bytedance/android/livesdk/chatroom/detail/q$a;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "nextPing", "Lcom/bytedance/android/livesdk/chatroom/detail/q;", "newLivePingController", "Lcom/bytedance/android/livesdk/chatroom/end/b;", "newLiveAudienceEndFragment", "Landroid/os/Bundle;", "arguments", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/bytedance/android/livesdkapi/feed/ILiveRoomListProvider;", "roomListProvider", "newLiveEndTabGuideManager", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lq81/a;", "newBlackScreenMonitor", "lifecycleOwner", "zygoteEventHub", "player", "blackScreenMonitor", "Lq81/f;", "newLiveRoomAPMTraceMonitor", "Lq81/c;", "getLiveMkMetricHelper", "Landroidx/fragment/app/FragmentManager;", "manager", "state", "extra", "id", "Landroidx/fragment/app/DialogFragment;", "showLinkVideoDialog", "Lcom/bytedance/android/livesdk/linkvideo/a;", "getLinkVideoManager", "Lcom/bytedance/android/livesdk/linkvideo/b;", "getLinkVideoTea", "Lcom/bytedance/android/livesdk/linkvideo/c;", "getUILinkVideoManager", "Lcom/bytedance/android/livesdkapi/service/IPerformanceManager;", "livePerformanceManager", "Lfo2/b;", "livePlayerStallManager", "Lq81/d;", "newLiveMkStallManager", "isAllInOneMode", "newAnchorMkStallManager", "roomSession", "config", "Lq81/e;", "newLiveRoomAPMMonitor", "Lq81/h;", "getLiveRoomMonitorHelper", "sessionId", "Lq81/i;", "newRoomEnterExtensionMonitor", "Lq81/j;", "newRoomExitExtensionMonitor", "Lq81/g;", "getLiveRoomFpsMonitor", "Lcom/bytedance/android/livesdk/chatroom/room/business/permission/a;", "getRoomForceLoginHelper", "Lcom/bytedance/android/livesdkapi/depend/model/live/room/RoomBaseSession;", "session", "Lis2/d;", "newRoomEngine", "Lis2/e;", "getRoomEngineHookService", "Lcom/bytedance/android/livesdk/chatroom/room/backend/g;", "getLiveRoomBackendUtils", "Lcom/bytedance/android/livesdk/chatroom/room/backend/i;", "getLiveRoomBackendMonitor", "Lcom/bytedance/android/livesdk/chatroom/room/business/interact/a;", "newRoomEnterDegradeHelper", "Lhn1/b;", "getPreEnterRoomManager", "Lln1/a;", "getLiveSplitEnterRoomUtils", "Lcom/bytedance/android/live/room/s;", "getRoomUtils", "Lkn1/d;", "getRoomALogHelper", "Ljava/lang/Class;", "Lis2/h;", "getRoomTaskClass", "Lkn1/c;", "getAppBehaviorLogManager", "Lqn2/m;", "getRoomParamsConsumeManager", "Lcom/bytedance/android/livesdk/chatroom/l1;", "viewPager", "Landroidx/viewpager/widget/PagerAdapter;", "pagerAdapter", "Lcom/bytedance/android/livesdk/chatroom/i;", "createAutoPageChangeManager", "<init>", "()V", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomModuleService implements IRoomModuleService {

    public static final class a implements e.a {
        public a() {
        }

        public final void onFetchFailed(int r1, String r2, String r3) {
        }

        public final void onFetched(IRoom r2) {
            Intrinsics.checkNotNullParameter(r2, "room");
        }
    }

    public static final class b implements e.a {
        public b() {
        }

        public final void onFetchFailed(int r1, String r2, String r3) {
        }

        public final void onFetched(IRoom r2) {
            Intrinsics.checkNotNullParameter(r2, "room");
        }
    }

    private final void injectFunctions() {
        Function0 r0 = n2.a;
        n2.a = AnonymousClass1.INSTANCE;
    }

    public hn1.b getPreEnterRoomManager() {
        Lazy r0 = PreEnterRoomManager.h;
        return PreEnterRoomManager.a.a();
    }

    public com.bytedance.android.livesdk.chatroom.end.b newLiveAudienceEndFragment() {
        z0 r0 = new z0();
        r0.a = System.currentTimeMillis();
        if (((Boolean) wt.a.getValue()).booleanValue() == true) goto L14;
        RoomPlatformApiForSaas.Companion.getClass();
        RoomPlatformApiForSaas r1 = RoomPlatformApiForSaas.access$getImpl$cp();
        if (r1 != null) goto L13;
        r1 = (RoomPlatformApiForSaas) k.f(RoomPlatformApiForSaas.class);
        if (r1 != null) goto L11;
        r1 = new RoomPlatformApiForSaas();
    L11:
        RoomPlatformApiForSaas.access$setImpl$cp(r1);
    L13:
        return r1.getAudienceEndFragment();
    L14:
        return new LiveAudienceEndRtsFragment(r0);
    }

    public RoomModuleService() {
        k.l(IRoomModuleService.class, this);
        injectFunctions();
    }

    public c getAppBehaviorLogManager() {
        return kn1.a.p;
    }

    public com.bytedance.android.livesdk.linkvideo.a getLinkVideoManager() {
        return d.a;
    }

    public com.bytedance.android.livesdk.linkvideo.b getLinkVideoTea() {
        return com.bytedance.android.livesdk.linkvideo.e.a;
    }

    public q81.c getLiveMkMetricHelper() {
        return h.a;
    }

    public i getLiveRoomBackendMonitor() {
        return i.a;
    }

    public g getLiveRoomBackendUtils() {
        return LiveRoomBackendUtils.d;
    }

    public q81.g getLiveRoomFpsMonitor() {
        return LiveRoomFpsMonitor.e;
    }

    public q81.h getLiveRoomMonitorHelper() {
        return z.a;
    }

    public ln1.a getLiveSplitEnterRoomUtils() {
        return ln1.c.h;
    }

    public kn1.d getRoomALogHelper() {
        return kn1.e.b;
    }

    public is2.e getRoomEngineHookService() {
        return com.bytedance.android.livesdk.impl.a.b;
    }

    public com.bytedance.android.livesdk.chatroom.room.business.permission.a getRoomForceLoginHelper() {
        return com.bytedance.android.livesdk.chatroom.room.business.permission.d.a;
    }

    public r getRoomManager() {
        return e0.a;
    }

    public m getRoomParamsConsumeManager() {
        return p.b;
    }

    public s getRoomUtils() {
        return f0.b;
    }

    public com.bytedance.android.livesdk.linkvideo.c getUILinkVideoManager() {
        return com.bytedance.android.livesdk.linkvideo.h.a;
    }

    public List<is2.b> getBackendHandlers(boolean r8) {
        if (r8 == true) goto L6;
        return CollectionsKt.mutableListOf(new is2.b[]{new j0(), new com.bytedance.android.livesdk.chatroom.room.backend.d(), new com.bytedance.android.livesdk.chatroom.room.backend.a(), new com.bytedance.android.livesdk.chatroom.room.backend.c(), new i0(), new com.bytedance.android.livesdk.chatroom.room.backend.e(), new com.bytedance.android.livesdk.chatroom.room.backend.e0(), new com.bytedance.android.livesdk.chatroom.room.backend.b(), new com.bytedance.android.livesdk.chatroom.room.backend.h(), new jn1.a(), new h0(), new com.bytedance.android.livesdk.chatroom.room.backend.f0(), new g0()});
    L6:
        return CollectionsKt.mutableListOf(new is2.b[]{new j0(), new com.bytedance.android.livesdk.chatroom.room.backend.d(), new com.bytedance.android.livesdk.chatroom.room.backend.e0(), new com.bytedance.android.livesdk.chatroom.room.backend.h(), new h0()});
    }

    public Class<? extends is2.h> getRoomTaskClass(int r2) {
        if (r2 != 1) goto L5;
        return com.bytedance.android.livesdk.chatroom.room.core.task.r.class;
    L5:
        if (r2 != 2) goto L7;
        return EnterRoomTaskV1.class;
    L7:
        if (r2 == 3) goto L9;
        return null;
    L9:
        return com.bytedance.android.livesdk.chatroom.room.core.task.e.class;
    }

    public is2.d newRoomEngine(RoomBaseSession r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new RoomEngine(r2);
    }

    public q81.i newRoomEnterExtensionMonitor(String r2) {
        return new RoomEnterExtensionMonitor(r2);
    }

    public j newRoomExitExtensionMonitor(String r2) {
        if (r2 != null) goto L6;
        r2 = BuildConfig.FLAVOR;
    L6:
        return new RoomExitExtensionMonitor(r2);
    }

    public q81.a newBlackScreenMonitor(LifecycleOwner r2, long r3) {
        return new com.bytedance.android.livesdk.chatroom.room.apm.c(r2, r3);
    }

    public q81.d newLiveMkStallManager(IPerformanceManager r2, fo2.b r3) {
        Intrinsics.checkNotNullParameter(r2, "livePerformanceManager");
        Intrinsics.checkNotNullParameter(r3, "livePlayerStallManager");
        return new LiveMkStallManager(r2, r3);
    }

    public q81.e newLiveRoomAPMMonitor(Object r2, Object r3) {
        if ((r2 instanceof RoomBaseSession) == true) goto L5;
        return null;
    L5:
        if ((r3 instanceof LiveRoomAPMConfig) == true) goto L8;
        return null;
    L8:
        return new com.bytedance.android.livesdk.chatroom.room.apm.p((RoomBaseSession) r2, (LiveRoomAPMConfig) r3);
    }

    public com.bytedance.android.livesdk.chatroom.room.business.interact.a newRoomEnterDegradeHelper(DataCenter r2, long r3) {
        MiddlewareRoomContext.Companion.getClass();
        MiddlewareRoomContext r4 = MiddlewareRoomContext.a.a(r2, r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new RoomEnterDegradeHelper(r4);
    }

    public com.bytedance.android.livesdk.chatroom.i createAutoPageChangeManager(LifecycleOwner r2, l1 r3, PagerAdapter r4) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        return new AutoPageChangeManager(r2, r3, r4);
    }

    public q81.d newAnchorMkStallManager(IPerformanceManager r2, fo2.b r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "livePerformanceManager");
        Intrinsics.checkNotNullParameter(r3, "livePlayerStallManager");
        LiveMkStallManagerForAnchor r0 = new LiveMkStallManagerForAnchor(r2, r3);
        if (r4 == false) goto L5;
        String r5 = "single_page";
    L6:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.n = r5;
        return r0;
    L5:
        r5 = "take_page";
        goto L6
    }

    public void newLiveEndTabGuideManager(Bundle r3, Fragment r4, ILiveRoomListProvider r5) {
        Intrinsics.checkNotNullParameter(r3, "arguments");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        LiveEndTabGuideManager.Companion.getClass();
        Intrinsics.checkNotNullParameter(r4, "fragment");
        if (r3 != null) goto L5;
        r3 = r4.getArguments();
    L5:
        if (r3 == null) goto L8;
        String r6 = r3.getString("enter_from_merge");
        if (r6 == null) goto L8;
    L10:
        if (Intrinsics.areEqual(r6, "homepage_tablive") == true) goto L14;
        LiveEndTabGuideManager r7 = com.bytedance.live.datacontext.d.b(r4, null).a(LiveEndTabGuideManager.class);
        LiveEndTabGuideManager.access$setRoomListProvider$p(r7, r5);
        com.bytedance.live.datacontext.d.c(r7, "LiveEndTabGuideManager");
        return;
    L14:
        return;
    L8:
        r6 = BuildConfig.FLAVOR;
        goto L10
    }

    public f newLiveRoomAPMTraceMonitor(LifecycleOwner r2, Object r3, Object r4, q81.a r5) {
        if ((r3 instanceof p0) == true) goto L5;
        return null;
    L5:
        if ((r4 instanceof ILivePlayerClient) == true) goto L8;
        return null;
    L8:
        return new y(r2, (p0) r3, (ILivePlayerClient) r4, r5);
    }

    public e newRoomFetcher(int r2, e.a r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L10;
        return new d0(r3, r4);
    L10:
        if (r3 != null) goto L20;
        r3 = new b();
    L20:
        return new com.bytedance.android.livesdk.chatroom.detail.g0(r3, r6);
    L14:
        if (r3 != null) goto L21;
        r3 = new a();
    L21:
        return new com.bytedance.android.livesdk.chatroom.detail.f0(r3, r4);
    L18:
        return new d0(r3, r4);
    }

    public DialogFragment showLinkVideoDialog(FragmentManager r4, int r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        String r1 = LinkVideoDialog.R;
        Intrinsics.checkNotNullParameter(r4, "manager");
        LinkVideoDialog r0 = new LinkVideoDialog();
        Bundle r2 = new Bundle();
        r2.putInt("key_state", r5);
        if (r6 != null) goto L5;
        r6 = BuildConfig.FLAVOR;
    L5:
        r2.putString("key_extra", r6);
        r2.putLong("key_preview_id", r7);
        Unit r8 = Unit.INSTANCE;
        r0.setArguments(r2);
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "LinkVideoDialog", r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r0, r9) == false) goto L12;
    L10:
        return r0;
    L12:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r0.show(r4, "LinkVideoDialog");
        goto L10
    }

    public com.bytedance.android.livesdk.chatroom.detail.p newEnterRoomController(com.bytedance.android.livesdk.chatroom.detail.p.a r9, long r10, String r13, Object r14, IRoom r15) {
        Intrinsics.checkNotNullParameter(r9, "listener");
        if ((r14 instanceof r0) == true) goto L7;
        return null;
    L7:
        return new l(r9, r10, r13, (r0) r14, jm2.a.e((vh7.c) r15));
    }

    public q newLivePingController(long r13, long r14, String r16, boolean r17, q.a r18, DataCenter r19, long r20) {
        return new t(r13, r14, r17, r18, r19, r20);
    }
}
