package fo1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.live.room.w;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.ui.framework.NewAudienceInteractionFragment;
import com.bytedance.android.livesdk.chatroom.ui.framework.NewAudienceInteractionFragment$executePreloadTask$4;
import com.bytedance.android.livesdk.chatroom.ui.framework.NewAudienceInteractionFragment$executePreloadTask$6;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.IComponentScheduler;
import com.bytedance.android.livesdk.chatroom.ui.framework.j;
import com.bytedance.android.livesdk.chatroom.ui.framework.l;
import com.bytedance.android.livesdk.chatroom.ui.framework.log.InteractionSlardarUtils;
import com.bytedance.android.livesdk.chatroom.ui.framework.m;
import com.bytedance.android.livesdk.chatroom.ui.framework.n;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.t;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.u;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.vscore_api.multicamera.IMultiCameraView;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.chat.OnBackPressedListener;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live.PRELOAD_STAGE;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live.RoomPreloadStage;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import hh1.v0;
import hh1.w0;
import io.reactivex.disposables.CompositeDisposable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nz.r;
import vh1.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements com.bytedance.android.live.room.h, OnBackPressedListener, IMultiCameraView {
    public final NewAudienceInteractionFragment a;
    public final h b;

    public final void VX(DataCenter r1, com.bytedance.android.live.room.h.b r2, EnterRoomExtra r3) {
        throw null;
    }

    public final /* synthetic */ void onOuterPageScrollStateChanged(int r1) {
    }

    public final void setDataContext(RoomContext r1) {
        throw null;
    }

    public final void setNestedOutside(boolean r1) {
        throw null;
    }

    public final void C60() {
        Iterator r0 = ((ArrayList) this.a.h).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r0.next()).o();
        goto L4
    }

    public final void DS() {
        this.a.stopInteractionLoad();
    }

    public final void I5() {
        NewAudienceInteractionFragment r0 = this.a;
        r0.getClass();
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#hideFloatFragment" + r0.hashCode());
        PropertyOwner<Boolean> r1 = r0.d.B;
        if ((!((Boolean) r1.a).booleanValue()) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L9;
        r1.a(Boolean.TRUE);
        return;
    }

    public final View IP() {
        n r0 = this.a.i;
        if (r0 == null) goto L13;
        e0 r1 = r0.a.d;
        if (r1 == null) goto L9;
        IAbilityCenter r2 = r1.m;
        if (r2 == null) goto L9;
        u r3 = (u) r2.getAbility(u.class);
    L10:
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.fh();
    L9:
        r3 = null;
        goto L10
    L13:
        return null;
    }

    public final Lifecycle Qy() {
        return this.a.f.Qy();
    }

    public final void R5() {
        n r0 = this.a.i;
        if (r0 == null) goto L8;
        q r1 = ho1.a.f(r0.a.d);
        if (r1 == null) goto L9;
        r1.R5();
        return;
    L9:
        return;
    }

    public final boolean V9() {
        return this.a.d.a;
    }

    public final View ff() {
        n r0 = this.a.i;
        return null;
    }

    public final boolean g1() {
        return this.a.d.a;
    }

    public final FragmentManager getChildFragmentManager() {
        NewAudienceInteractionFragment r0 = this.a;
        r0.getClass();
        return r0.getChildFragmentManager();
    }

    public final boolean isAdded() {
        NewAudienceInteractionFragment r0 = this.a;
        r0.getClass();
        return r0.isAdded();
    }

    public final boolean isScreenPortrait() {
        return this.a.d.a;
    }

    public final void ns() {
        throw new RuntimeException("[onSurfaceRenderReady] method not support, audience not support");
    }

    public final boolean o5() {
        return !this.a.d.a;
    }

    public final boolean onBackPressed() {
        return this.a.onBackPressed();
    }

    public final boolean pX() {
        n r0 = this.a.i;
        if (r0 != null) goto L7;
        return false;
    L7:
        return ((Boolean) r0.a.b().get("DATA_IS_HIDE_INTERACTION", Boolean.FALSE)).booleanValue();
    }

    public final Fragment self() {
        NewAudienceInteractionFragment r0 = this.a;
        r0.getClass();
        return r0;
    }

    public final void stopInteractionLoad() {
        this.a.stopInteractionLoad();
    }

    public final void yv() {
        throw new RuntimeException("[unloadWidgetIfNecessary] method not support, audience not support");
    }

    public f(h r7) {
        Intrinsics.checkNotNullParameter(r7, "createParams");
        this.b = r7;
        NewAudienceInteractionFragment r0 = new NewAudienceInteractionFragment();
        Intrinsics.checkNotNullParameter(r7, "initParams");
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#setInitParams" + r0.hashCode());
        b r2 = r0.d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "initParams");
        DataCenter r1 = r7.a;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r2.b = r1;
        RoomContext r3 = r7.b;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.c = r3;
        r2.t = r7.j;
        r2.a = r7.g;
        Room r4 = r7.c;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.g = r4;
        r2.h = r7.d;
        LiveMode r5 = r7.e;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r2.i = r5;
        r2.u = r7.f;
        r2.s = r7.l;
        r2.k = r7.h;
        is2.f r6 = r7.i;
        if (r6 == null) goto L6;
        ((ArrayList) r2.w).add(r6);
    L6:
        if (com.bytedance.android.live.core.tetris.widgets.d.b() == true) goto L8;
    L11:
        boolean r8 = true;
    L12:
        r2.v = r8;
        r2.d().getLiveMode().d(r2.i);
        r2.b().put("log_streaming_type", r2.i.getLogStreamingType());
        DataCenter r9 = r2.b();
        Boolean r10 = Boolean.FALSE;
        r9.put("data_is_anchor", r10);
        r2.b().put("data_is_portrait", Boolean.valueOf(r2.a));
        r2.d().isAnchor().d(r10);
        wh1.a r11 = r7.k;
        r2.A = r11;
        if (r11 == null) goto L15;
        r11.c = r2;
    L15:
        int r12 = y.a;
        DataCenter r13 = r2.b();
        com.bytedance.android.livesdk.room.b r14 = r2.t;
        if (r14 == null) goto L18;
        CompositeDisposable r15 = r14.z;
    L19:
        y.a(r13, r15, "AudienceInteractionContext#initParams", new a(r2));
        r0.i = new n(r0.d);
        Unit r16 = Unit.INSTANCE;
        this.a = r0;
        return;
    L18:
        r15 = null;
        goto L19
    L8:
        if (((Boolean) r2.b().get("cmd_interact_is_part_show", Boolean.FALSE)).booleanValue() == false) goto L11;
        r8 = false;
        goto L12
    }

    public final void Cp(v0 r2) {
        throw new RuntimeException("[setLiveVideoClientFactory] method not support, audience not support");
    }

    public final void Cz(r r2) {
        throw new RuntimeException("[setLiveBroadcastFragment] method not support, audience not support");
    }

    public final void D2(boolean r2) {
        throw new RuntimeException("[switchRecordEnable] method not support, audience not support");
    }

    public final void H3(ByteBuffer r2) {
        n r0 = this.a.i;
        if (r0 == null) goto L8;
        t r1 = ho1.a.n(r0.a.d);
        if (r1 == null) goto L9;
        r1.H3(r2);
        return;
    L9:
        return;
    }

    public final void Oz(PadOrientation r3) {
        if (r3 == null) goto L7;
        NewAudienceInteractionFragment r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "orientation");
        b r1 = r0.d;
        if (r1.a == false) goto L8;
        r1.d().getPadOrientation().setValue(r3);
        return;
    L8:
        return;
    }

    public final void R40(w0 r2) {
        throw new RuntimeException("[addRadioStateCallback] method not support, audience not support");
    }

    public final void RJ(Runnable r3) {
        n r0 = this.a.i;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNullParameter(r3, "action");
        b r1 = r0.a;
        if (r1.d == null) goto L7;
        r1.j = null;
        r3.run();
        return;
    L7:
        r1.j = r3;
        return;
    }

    public final void Sb(View.OnTouchListener r2) {
        throw new RuntimeException("[addOnTouchEventListener] method not support, audience not support");
    }

    public final void b0(String r2) {
        n r0 = this.a.i;
        if (r0 == null) goto L8;
        t r1 = ho1.a.n(r0.a.d);
        if (r1 == null) goto L9;
        r1.b0(r2);
        return;
    L9:
        return;
    }

    public final void cU(com.bytedance.android.live.room.h.a r2) {
        throw new RuntimeException("[setAnchorFlingCallback] method not support, audience not support");
    }

    public final void cx(DialogInterface.OnKeyListener r2) {
        throw new RuntimeException("[addOnKeyEventListener] method not support, audience not support");
    }

    public final void eR(LiveMode r5) {
        if (r5 == null) goto L11;
        n r0 = this.a.i;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNullParameter(r5, "mode");
        b r1 = r0.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "liveMode");
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r1.i = r5;
        r1.d().getLiveMode().d(r5);
        r1.b().put("log_streaming_type", r5.getLogStreamingType());
        int r2 = y.a;
        DataCenter r3 = r1.b();
        com.bytedance.android.livesdk.room.b r4 = r1.t;
        if (r4 == null) goto L8;
        CompositeDisposable r6 = r4.z;
    L9:
        y.a(r3, r6, "AudienceInteractionContext#updateLiveMode", new c(r1, r5));
        return;
    L8:
        r6 = null;
        goto L9
    L12:
        return;
    }

    public final void lO(com.bytedance.android.live.pushstream.d r2) {
        throw new RuntimeException("[setLiveStream] method not support, audience not support");
    }

    public final void onPageScrollStateChanged(int r3) {
        n r0 = this.a.i;
        if (r0 == null) goto L10;
        b r1 = r0.a;
        if ((!r1.a) == false) goto L11;
        jo1.h r2 = ho1.a.g(r1.d);
        if (r2 == null) goto L12;
        r2.onPageScrollStateChanged(r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onSei(String r2) {
        n r0 = this.a.i;
        if (r0 == null) goto L8;
        t r1 = ho1.a.n(r0.a.d);
        if (r1 == null) goto L9;
        r1.onSei(r2);
        return;
    L9:
        return;
    }

    public final void setArguments(Bundle r2) {
        NewAudienceInteractionFragment r0 = this.a;
        r0.getClass();
        r0.setArguments(r2);
    }

    public final void zA(EnterRoomInfoResult r7) {
        Intrinsics.checkNotNullParameter(r7, "roomInfo");
        DataCenter r1 = this.b.a;
        n r2 = this.a.i;
        if (r2 == null) goto L24;
        Intrinsics.checkNotNullParameter(r7, "roomInfo");
        if (r2.a.a == true) goto L7;
        return;
    L7:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L17;
        MiddlewareRoomContext r0 = o3.c(r1);
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.n r3 = r0.isRoomVisible();
        if (r3 == null) goto L13;
        Boolean r4 = (Boolean) r3.getValue();
    L15:
        if (Intrinsics.areEqual(r4, Boolean.FALSE) == false) goto L17;
        ALogger.e("NewAudienceInteractionFragment", "preload enter info event but room is not visible");
        return;
    L13:
        r4 = null;
    L17:
        IInteractService r5 = k.f(IInteractService.class);
        if (r5 == null) goto L22;
        ih0.b r6 = r5.dynamicService(r1);
        if (r6 == null) goto L22;
        JsonObject r8 = new JsonObject();
        Gson r9 = com.bytedance.android.annie.api.data.subscribe.d.a;
        r8.add("play_mode_info_v2", com.bytedance.android.annie.api.data.subscribe.d.b(r7.getLinkmicPlayModeInfo()).getAsJsonObject());
        ALogger.d("livesdk_audience_loading_statistics", "onUpdateEnterRoomInfo roomInfo: end" + r8);
        r6.Dk("root", "preload_enter_info", r8, false);
    L22:
        r2.a.b().put("data_room_enter_info", r7);
        return;
    }

    public final void P7(Room r4, w r5) {
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "param");
        final NewAudienceInteractionFragment r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "param");
        if (MultiRoomConfig.INSTANCE.enableComponentPreload(r2.d.c(), r2.d.b()) == false) goto L19;
        String r6 = r2.T90();
        if (r6 == null) goto L8;
        com.bytedance.android.live.core.tetris.widgets.d.g("executePreloadTask checkInteractionValid failed, reason is ".concat(r6));
        int r7 = InteractionSlardarUtils.a;
        InteractionSlardarUtils.c(r2.d, "executePreloadTask", r6);
        return;
    L8:
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#executePreloadTask" + r2.hashCode());
        RoomPreloadStage r8 = z.p(r2.d.b());
        if (r8 == null) goto L11;
        r8.updatePreloadStage(PRELOAD_STAGE.START_LOAD_PRELOAD_COMPONENT);
    L11:
        Iterator r9 = ((ArrayList) r2.h).iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        ((com.bytedance.android.livesdk.chatroom.ui.framework.base.i) r9.next()).f();
        goto L13
    L15:
        r2.X90(new com.bytedance.android.livesdk.chatroom.ui.framework.k(r2), "initRoomContextPartly");
        r2.X90(new l(r2), "initCompleteDescriptorList + initComponentScheduler");
        r2.X90(new NewAudienceInteractionFragment$executePreloadTask$4(r2), "startLoadBaseComponent");
        r2.X90(new m(r2), "initRoomContextForPreload");
        r2.X90(new NewAudienceInteractionFragment$executePreloadTask$6(r2), "startLoadPreloadComponent");
        return;
    }

    public final void T4(Room r2, w r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a.T4(r2, r3);
    }

    public final boolean interceptCloseRoom(Runnable r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "runnable");
        n r1 = this.a.i;
        if (r1 == null) goto L12;
        Intrinsics.checkNotNullParameter(r3, "runnable");
        e0 r0 = r1.a.d;
        if (r0 == null) goto L9;
        IAbilityCenter r2 = r0.a();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e r5 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e) r2.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e.class);
    L10:
        if (r5 == null) goto L12;
        return r5.interceptCloseRoom(r3, r4);
    L9:
        r5 = null;
    L12:
        return false;
    }

    public final void n9(Room r4, w r5) {
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "param");
        NewAudienceInteractionFragment r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "param");
        String r6 = r2.T90();
        if (r6 == null) goto L5;
        com.bytedance.android.live.core.tetris.widgets.d.g("executeFullTask checkInteractionValid failed, reason is ".concat(r6));
        int r7 = InteractionSlardarUtils.a;
        InteractionSlardarUtils.c(r2.d, "executeFullTask", r6);
        return;
    L5:
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#executeFullTask" + r2.hashCode());
        IComponentScheduler r8 = r2.f.f;
        if (r8 == null) goto L10;
        r8.l();
        return;
    }

    public final void show(FragmentManager r2, String r3) {
        if (r2 == null) goto L5;
        NewAudienceInteractionFragment r0 = this.a;
        r0.getClass();
        r0.show(r2, r3);
        return;
    }

    public final void F30(Room r4, EnterRoomExtra r5, w r6) {
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r6, "params");
        NewAudienceInteractionFragment r2 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r6, "params");
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#updateDataIfNeeded" + r2.hashCode());
        b r7 = r2.d;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r7.g = r4;
        r7.h = r5;
        r7.v = true;
        r7.g();
    }

    public final void Ma(boolean r2, boolean r3, IMultiCameraView.Source r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        this.a.f.Ma(r2, r3, r4);
    }

    public final void X5(boolean r2, boolean r3, IMultiCameraView.Source r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        this.a.f.X5(r2, r3, r4);
    }

    public final void bW(Room r5, EnterRoomExtra r6, Runnable r7) {
        Intrinsics.checkNotNullParameter(r5, "room");
        NewAudienceInteractionFragment r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "room");
        com.bytedance.android.live.core.tetris.widgets.d.g("update some global data on continue room enter");
        ALogger.i("NewAudienceInteractionFragment", "NewAudienceInteractionFragment#continueRoomEnter" + r1.hashCode());
        b r2 = r1.d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "room");
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r2.g = r5;
        r2.h = r6;
        r2.v = true;
        r2.g();
        j r8 = new j(r1, (c0) r7);
        if (r1.d.f == false) goto L5;
        com.bytedance.android.live.core.tetris.widgets.d.g("continue room enter due to fragment is resumed");
        r8.run();
        return;
    L5:
        com.bytedance.android.live.core.tetris.widgets.d.g("wait continue room enter util fragment is resumed");
        r1.d.x = r8;
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        NewAudienceInteractionFragment r0 = this.a;
        r0.getClass();
        r0.onActivityResult(r2, r3, r4);
    }
}
