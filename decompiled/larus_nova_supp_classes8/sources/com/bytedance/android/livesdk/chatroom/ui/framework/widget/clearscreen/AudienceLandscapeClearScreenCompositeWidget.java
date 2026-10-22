package com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen;

import android.view.View;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.castscreen.utils.e;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.d;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.c;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.chatroom.widget.landscape.u;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.config.o50;
import com.bytedance.android.livesdk.utils.t1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/clearscreen/AudienceLandscapeClearScreenCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/clearscreen/ClearScreenCompositeWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLandscapeClearScreenCompositeWidget extends ClearScreenCompositeWidget {
    public boolean g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AudienceLandscapeClearScreenCompositeWidget a;

        public a(AudienceLandscapeClearScreenCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            boolean r4 = ((Boolean) r3).booleanValue();
            View r0 = this.a.Aq();
            if (r0 == null) goto L15;
            if (r4 == true) goto L7;
            return;
        L7:
            if (r0.getAlpha() == 0.0f) goto L9;
            return;
        L9:
            if (this.a.Iq() == false) goto L14;
            r0.setAlpha(1.0f);
            return;
        L14:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AudienceLandscapeClearScreenCompositeWidget a;

        public b(AudienceLandscapeClearScreenCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L8;
            View r3 = this.a.Aq();
            if (r3 == null) goto L9;
            r3.setAlpha(1.0f);
            return;
        L9:
            return;
        }
    }

    public final boolean Iq() {
        if (((Number) ((Widget) this).dataCenter.get("data_screen_change_status", 0)).intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        Room r3 = getRoom();
        if (r3 != null) goto L9;
        return false;
    L9:
        int r4 = t1.a;
        if (o50.a.getValue().booleanValue() == false) goto L22;
        if (r0 == true) goto L13;
        return false;
    L13:
        if (e.a() == false) goto L15;
        return false;
    L15:
        if (isAnchor() == false) goto L17;
        return false;
    L17:
        if (r3.isMediaRoom() == false) goto L19;
        return false;
    L19:
        if (r3.isMergeVSRoom() == true) goto L27;
        return true;
    L27:
        return false;
    L22:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final u Gq() {
        h70.b r0 = getComponentContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ho1.a.h(r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget, com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b
    public final void f7() {
        View r0 = Aq();
        if (r0 != null) goto L5;
        return;
    L5:
        u r1 = Gq();
        if (r1 != null) goto L8;
        return;
    L8:
        ALogger.d("visibilityControlTag", "toggleInteractionVisibility");
        if (Iq() == false) goto L17;
        boolean r2 = this.g;
        if (r0.getAlpha() != 0.0f) goto L13;
        boolean r3 = true;
    L15:
        if ((r2 & r3) == false) goto L17;
        r0.setAlpha(1.0f);
        r1.zj();
        return;
    L13:
        r3 = false;
    L17:
        r1.db();
        r1.Hj();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        DataCenter r0 = ((Widget) this).dataCenter;
        boolean r1 = false;
        if (r0 == null) goto L28;
        r0.observeForever("cmd_widget_loaded", this);
        if (VSMediaUIConfigHelper.b(((Widget) this).dataCenter) == true) goto L25;
        Room r3 = getRoom();
        if (r3 == null) goto L25;
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == false) goto L25;
        if (r3.isMediaRoom() == true) goto L25;
        if (r3.isMergeVSRoom() == true) goto L25;
        if (isAnchor() == true) goto L25;
        IRoomService r4 = k.f(IRoomService.class);
        if (r4 == null) goto L25;
        if (r4.isDrawerEnable(r3) != true) goto L25;
        if (r3.withAggregateColumn == true) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == false) goto L28;
        r0.observe("show_landscape_live_drawer_dialog", this);
        r0.observe("cmd_landscape_interaction_hide", this);
    L25:
        r5 = false;
    L28:
        RoomContext r2 = zq();
        if (r2 == null) goto L37;
        com.bytedance.live.datacontext.k r6 = r2.getLandscapePlayerControlInit();
        if (r6 == null) goto L37;
        PublishSubject r7 = r6.onEvent();
        if (r7 == null) goto L37;
        Disposable r8 = r7.subscribe(new a(this));
        if (r8 == null) goto L37;
        RxUtilKt.c(r8, this.e);
    L37:
        RoomContext r9 = zq();
        if (r9 == null) goto L59;
        Room r10 = getRoom();
        if (r10 != null) goto L42;
        return;
    L42:
        if (r10.isMergeVSRoom() != true) goto L61;
        IVSPlayerService r11 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r11 == null) goto L46;
        c r12 = r11.provideVSPlayerViewControlService(((Widget) this).dataCenter);
    L47:
        if (r12 == null) goto L51;
        VSPlayerViewControlContext r13 = r12.provideContext();
        if (r13 == null) goto L51;
        r1 = r13.getInitVisible();
    L51:
        if (r1 == true) goto L62;
        View r14 = Aq();
        if (r14 == null) goto L55;
        r14.setAlpha(0.0f);
    L55:
        Disposable r15 = r9.getMatchPlayerControlInitComplete().onEvent().subscribe(new b(this));
        if (r15 == null) goto L63;
        RxUtilKt.c(r15, this.e);
        return;
    L63:
        return;
    L62:
        return;
    L46:
        r12 = null;
        goto L47
    L61:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget
    public final void onDestroy() {
        super.onDestroy();
        if (gs1.b.a == true) goto L5;
        return;
    L5:
        if (ClearScreenHelper.e(((Widget) this).dataCenter) == true) goto L9;
        gs1.b.b(false);
        return;
    }

    public final void onResume() {
        super.onResume();
        boolean r1 = true;
        if (Iq() == true) goto L5;
    L10:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r0 = this.d;
        if (r0 == null) goto L28;
        PropertyOwner r2 = r0.getLoadState();
        if (r2 == null) goto L29;
        LoadState r3 = (LoadState) r2.a;
        if (r3 == null) goto L30;
        Integer r4 = Integer.valueOf(r3.getValue());
        if (r4.intValue() >= LoadState.P3_END.getValue()) goto L20;
        r1 = false;
    L20:
        if (r1 == true) goto L23;
        r4 = null;
    L23:
        if (r4 == null) goto L31;
        r4.intValue();
        u r5 = Gq();
        if (r5 == null) goto L32;
        r5.Hj();
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        if (this.g == true) goto L10;
        View r6 = Aq();
        if (r6 == null) goto L9;
        r6.setAlpha(0.0f);
    L9:
        this.g = true;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget, com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b
    public final void rf() {
        u r0 = Gq();
        if (r0 == null) goto L6;
        r0.Hj();
        return;
    }

    public AudienceLandscapeClearScreenCompositeWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget, com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b
    public final void F5(int r5) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L12;
        boolean r1 = true;
        if (VrUtils.t(r0, true) == false) goto L13;
        LayerEventDispatcher r2 = o70.c.a(Integer.valueOf(((Widget) this).dataCenter.hashCode()));
        Intrinsics.checkNotNull(r2);
        if (r5 == 8) goto L10;
        r1 = false;
    L10:
        r2.b(new s(r1));
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget
    public final void onChanged(KVData r5) {
        super.onChanged(r5);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L50;
        if (r5 == null) goto L9;
        String r1 = r5.getKey();
    L10:
        if (r1 == null) goto L51;
        int r2 = r1.hashCode();
        if (r2 == (-1836833765)) goto L32;
        if (r2 == 973431416) goto L27;
        if (r2 == 1271279689) goto L20;
        return;
    L20:
        if (r1.equals("show_landscape_live_drawer_dialog") == true) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual((Boolean) r5.getData(), Boolean.TRUE) == false) goto L41;
        u r6 = Gq();
        if (r6 == null) goto L42;
        r6.setVisibility(false);
        return;
    L42:
        return;
    L41:
        return;
    L27:
        if (r1.equals("cmd_landscape_interaction_hide") == false) goto L44;
        u r7 = Gq();
        if (r7 == null) goto L45;
        r7.setVisibility(false);
        return;
    L45:
        return;
    L44:
        return;
    L32:
        if (r1.equals("cmd_widget_loaded") == true) goto L34;
        return;
    L34:
        if (d.a(r5) == false) goto L48;
        u r8 = Gq();
        if (r8 == null) goto L49;
        r8.Hj();
        return;
    L49:
        return;
    L48:
        return;
    L51:
        return;
    L9:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }
}
