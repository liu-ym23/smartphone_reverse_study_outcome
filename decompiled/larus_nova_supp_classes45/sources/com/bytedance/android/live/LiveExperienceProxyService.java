package com.bytedance.android.live;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import ca0.o;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.room.api.ILiveExperienceProxyService;
import com.bytedance.android.live.room.util.AudienceInflateUtil;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.lk;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.android.livesdkapi.model.BackendItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J*\u0010\u001d\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001c\u0010!\u001a\u00020\n2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0002H\u0016JH\u0010/\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¨\u00062"}, d2 = {"Lcom/bytedance/android/live/LiveExperienceProxyService;", "Lcom/bytedance/android/live/room/api/ILiveExperienceProxyService;", "", "rankType", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", NewBroadcastMonitor.PAGE.ROOM, "", "showUserDialog", "", "pcu", "", "roomId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "anchor", "Lcom/bytedance/live/datacontext/DataContext;", "dataContext", "Lcom/bytedance/android/live/core/tetris/task/a;", "widgetLoadTask", "Landroid/view/View;", "contentView", "scheduleP0WidgetLoadTask", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lw71/c;", "listener", "requestRankBackend", "", "", "data", "collectReportTask", "statusHeight", "repotTopSpaceHeight", "logTag", "resId", "nitaTag", "Landroid/app/Activity;", "activity", "Landroid/view/ViewGroup;", KtvSubElement.CONTAINER, "", "attach", "Landroid/view/LayoutInflater;", "fallbackInflater", "tryNitaInflate", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveExperienceProxyService implements ILiveExperienceProxyService {
    public LiveExperienceProxyService() {
    }

    public void collectReportTask(Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class).B1(ProfitCheckType.DRESS_SHOW, r4, null);
    }

    public void repotTopSpaceHeight(int r5) {
        ALogger.d("LiveTopSpaceHeightCheck", "statusHeight=" + r5);
        if (r5 != 0) goto L7;
        if (((h81.a) g81.j.a.getValue()).a() == false) goto L7;
    L8:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("status_height", String.valueOf(r5));
        j0.l().f("livesdk_top_space_height", r0, new Object[]{IRoom.class, x.class});
        return;
    L7:
        if (((h81.a) g81.j.a.getValue()).b() == true) goto L8;
    }

    public void scheduleP0WidgetLoadTask(DataContext r2, final com.bytedance.android.live.core.tetris.task.a r3, final View r4) {
        Intrinsics.checkNotNullParameter(r2, "dataContext");
        Intrinsics.checkNotNullParameter(r3, "widgetLoadTask");
        Intrinsics.checkNotNullParameter(r4, "contentView");
        if ((r2 instanceof RoomContext) == true) goto L5;
        r2 = null;
    L5:
        RoomContext r5 = (RoomContext) r2;
        if (r5 == null) goto L11;
        com.bytedance.live.datacontext.j r6 = r5.getWidgetLoadTaskScheduler();
        if (r6 == null) goto L12;
        r6.c(new C03031(r3, r4));
        return;
    L12:
        return;
    }

    public void requestRankBackend(DataContext r18, final long r19, LifecycleOwner r21, final w71.c r22) {
        Intrinsics.checkNotNullParameter(r21, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r22, "listener");
        DataContext r3 = r18;
        Boolean r5 = null;
        if ((r3 instanceof RoomContext) == true) goto L5;
        r3 = null;
    L5:
        final RoomContext r14 = (RoomContext) r3;
        if (r14 == null) goto L33;
        n r4 = r14.getHasRankBackendRequest();
        if (r4 == null) goto L10;
        Boolean r6 = (Boolean) r4.getValue();
    L11:
        Boolean r15 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r6, r15)) == false) goto L29;
        n r7 = r14.getHasRankShown();
        if (r7 == null) goto L17;
        r5 = (Boolean) r7.getValue();
    L17:
        if ((!Intrinsics.areEqual(r5, r15)) == false) goto L29;
        ALogger.d("LiveExperienceProxyService", "requestRankBackend, roomId = " + r19);
        IRoomModuleService r8 = k.f(IRoomModuleService.class);
        if (r8 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.room.backend.g r9 = r8.getLiveRoomBackendUtils();
        if (r9 == null) goto L29;
        Function3<lk, BackendGeneratedData, BackendItem, Unit> r11 = new AnonymousClass1(r19, r14, r22);
        Function0<Unit> r12 = new AnonymousClass2(r19);
        a50.a r0 = LiveInfraSettingKeys.LIVE_ROOM_BACKEND_BUSINESS_SWITCH.getValue();
        if (r0 != null) goto L25;
    L27:
        boolean r13 = false;
    L28:
        com.bytedance.android.livesdk.chatroom.room.backend.g.a.a(r9, r19, r14, lk.class, r12, null, r11, null, r21, null, r13, false, 3152);
        goto L29
    L25:
        if (r0.j() != true) goto L27;
        r13 = true;
    L29:
        n r1 = r14.getHasRankBackendRequest();
        if (r1 == null) goto L34;
        r1.setValue(r15);
        return;
    L34:
        return;
    L10:
        r6 = null;
        goto L11
    }

    public void showUserDialog(int r11, Context r12, DataCenter r13, IRoom r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        Intrinsics.checkNotNullParameter(r14, NewBroadcastMonitor.PAGE.ROOM);
        long r6 = System.currentTimeMillis();
        IKtvService r0 = k.f(IKtvService.class);
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isInKtvState(8));
    L6:
        HashMap r2 = new HashMap();
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L9;
        r2.put("live_type", "voice_live");
        r2.put("function_type", "ktv");
    L9:
        b91.a.a(r2);
        IGiftServiceExternal r3 = (IGiftServiceExternal) k.f(IGiftServiceExternal.class);
        if (r3 == null) goto L14;
        o r4 = r3.getRevenueEventCenter();
        if (r4 == null) goto L14;
        r4.d();
    L14:
        int r5 = 0;
        Integer r15 = (Integer) r13.get("data_member_count", 0);
        if (r15 == null) goto L17;
        r5 = r15.intValue();
    L17:
        av0.a r7 = yt0.c.j();
        if (r7 == null) goto L21;
        av0.a.a.a(r7, r12, r11, r14, String.valueOf(r5), r6, C03042.INSTANCE);
        return;
    L21:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void showUserDialog(int r8, Context r9, String r11, long r12, IBaseUser r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "pcu");
        Intrinsics.checkNotNullParameter(r13, "anchor");
        System.currentTimeMillis();
        int r14 = b91.a.a;
        b91.a.a(new LinkedHashMap());
        av0.a r0 = yt0.c.j();
        if (r0 == null) goto L6;
        AnonymousClass3 r15 = AnonymousClass3.INSTANCE;
        r0.U5(r9, r12, r13, r11, null);
        return;
    }

    public View tryNitaInflate(String r2, int r3, String r4, Activity r5, ViewGroup r6, boolean r7, LayoutInflater r8) {
        Intrinsics.checkNotNullParameter(r2, "logTag");
        Intrinsics.checkNotNullParameter(r4, "nitaTag");
        if (r5 != null) goto L7;
        return null;
    L7:
        return AudienceInflateUtil.b(r2, r3, r4, r5, r6, r7, r8);
    }
}
