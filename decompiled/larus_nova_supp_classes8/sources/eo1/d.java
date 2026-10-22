package eo1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.live.room.h;
import com.bytedance.android.live.room.w;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.ui.framework.NewAnchorInteractionFragment;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.q;
import com.bytedance.android.livesdk.floatview.p;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.chat.OnBackPressedListener;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import hh1.v0;
import hh1.w0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nz.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements h, OnBackPressedListener {
    public final NewAnchorInteractionFragment a;

    public final /* synthetic */ void F30(Room r1, EnterRoomExtra r2, w r3) {
    }

    public final /* synthetic */ void P7(Room r1, w r2) {
    }

    public final /* synthetic */ void T4(Room r1, w r2) {
    }

    public final boolean V9() {
        return false;
    }

    public final void VX(DataCenter r1, h.b r2, EnterRoomExtra r3) {
        throw null;
    }

    public final /* synthetic */ void n9(Room r1, w r2) {
    }

    public final boolean o5() {
        return false;
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
        throw new RuntimeException("[onScreenRotation] method not support, anchor not support");
    }

    public final void DS() {
        throw new RuntimeException("[hideInteractionView] method not support, anchor not support");
    }

    public final void I5() {
        PropertyOwner<Boolean> r0 = this.a.d.A;
        if ((!((Boolean) r0.a).booleanValue()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        r0.a(Boolean.TRUE);
        return;
    }

    public final View IP() {
        throw new RuntimeException("[getToolbarCloseView] method not support, anchor not support");
    }

    public final void R5() {
        throw new RuntimeException("[disposePlayControlTimer] method not support, anchor not support");
    }

    public final View ff() {
        throw new RuntimeException("[getOrientationSwitch] method not support, anchor not support");
    }

    public final boolean g1() {
        return this.a.d.a;
    }

    public final FragmentManager getChildFragmentManager() {
        NewAnchorInteractionFragment r0 = this.a;
        r0.getClass();
        return r0.getChildFragmentManager();
    }

    public final boolean isAdded() {
        NewAnchorInteractionFragment r0 = this.a;
        r0.getClass();
        return r0.isAdded();
    }

    public final boolean isScreenPortrait() {
        return this.a.d.a;
    }

    public final void ns() {
        PropertyOwner<Boolean> r0 = this.a.d.z;
        if ((!((Boolean) r0.a).booleanValue()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        r0.a(Boolean.TRUE);
        return;
    }

    public final boolean onBackPressed() {
        return this.a.onBackPressed();
    }

    public final boolean pX() {
        throw new RuntimeException("[isHideInteractLayout] method not support, anchor not support");
    }

    public final Fragment self() {
        NewAnchorInteractionFragment r0 = this.a;
        r0.getClass();
        return r0;
    }

    public final void stopInteractionLoad() {
        throw new RuntimeException("[stopInteractionLoad] method not support, anchor not support");
    }

    public final void yv() {
        this.a.getClass();
    }

    public d(e r6) {
        Intrinsics.checkNotNullParameter(r6, "createParams");
        NewAnchorInteractionFragment r0 = new NewAnchorInteractionFragment();
        Intrinsics.checkNotNullParameter(r6, "initParams");
        b r2 = r0.d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "initParams");
        DataCenter r1 = r6.a;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r2.b = r1;
        RoomContext r3 = r6.b;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.c = r3;
        r2.a = true;
        Room r4 = r6.c;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.g = r4;
        r2.h = r6.d;
        LiveMode r5 = r6.e;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r2.i = r5;
        r2.k = r6.h;
        r2.u = r6.g;
        r2.t = r6.f;
        r2.d().getLiveMode().d(r2.i);
        r2.b().put("log_streaming_type", r2.i.getLogStreamingType());
        ILinkServiceExternal r7 = k.f(ILinkServiceExternal.class);
        if (r7 == null) goto L5;
        r7.updateLiveMode(r2.i);
    L5:
        LiveMode r8 = r2.i;
        LiveMode r9 = LiveMode.MEDIA;
        if (r8 != r9) goto L10;
        o r10 = u.l().c(am2.w.class);
        if (r10 == null) goto L10;
        r10.setData(new am2.w(r9, "1"));
    L10:
        r2.b();
        boolean r11 = p.a;
        DataCenter r12 = r2.b();
        Boolean r13 = Boolean.TRUE;
        r12.put("data_is_anchor", r13);
        r2.b().put("data_is_portrait", Boolean.valueOf(r2.a));
        r2.d().isAnchor().d(r13);
        r2.d().isRoomVisible().setValue(r13);
        r0.i = new com.bytedance.android.livesdk.chatroom.ui.framework.h(r0.d);
        Unit r14 = Unit.INSTANCE;
        this.a = r0;
    }

    public final void Cp(v0 r3) {
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.ui.framework.h r0 = this.a.i;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNullParameter(r3, "factory");
        b r1 = r0.a;
        r1.u = r3;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.p r2 = ho1.a.j(r1.d);
        if (r2 == null) goto L11;
        r2.vq(r3);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void Cz(r r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.h r0 = this.a.i;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "liveBroadcastFragment");
        r0.a.s = r3;
        return;
    }

    public final void D2(boolean r4) {
        com.bytedance.android.livesdk.chatroom.ui.framework.h r0 = this.a.i;
        if (r0 == null) goto L14;
        e0 r1 = r0.a.d;
        if (r1 == null) goto L9;
        IAbilityCenter r2 = r1.m;
        if (r2 == null) goto L9;
        q r3 = (q) r2.getAbility(q.class);
    L10:
        if (r3 == null) goto L12;
        r3.D2(r4);
        return;
    L12:
        r0.a.d().getAnchorRecordEnableTempState().setValue(new h80.c(Boolean.valueOf(r4)));
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void H3(ByteBuffer r2) {
        throw new RuntimeException("[onBinarySei] method not support, anchor not support");
    }

    public final void Oz(PadOrientation r2) {
        throw new RuntimeException("[adjustMatchRoomForPad] method not support, anchor not support");
    }

    public final void R40(w0 r3) {
        if (r3 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.h r0 = this.a.i;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "callback");
        ((ArrayList) r0.a.l).add(r3);
        return;
    L8:
        return;
    }

    public final void RJ(Runnable r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.h r0 = this.a.i;
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

    public final void Sb(View.OnTouchListener r3) {
        if (r3 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.h r0 = this.a.i;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) r0.a.w).add(r3);
        return;
    L8:
        return;
    }

    public final void b0(String r2) {
        throw new RuntimeException("[notifySeiForMonitor] method not support, anchor not support");
    }

    public final void cU(h.a r2) {
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.h r0 = this.a.i;
        if (r0 == null) goto L8;
        r0.a.v = r2;
        return;
    L8:
        return;
    }

    public final void cx(DialogInterface.OnKeyListener r3) {
        if (r3 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.h r0 = this.a.i;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) r0.a.x).add(r3);
        return;
    L8:
        return;
    }

    public final void eR(LiveMode r2) {
        throw new RuntimeException("[setLiveMode] method not support, use InitParams");
    }

    public final void lO(com.bytedance.android.live.pushstream.d r3) {
        if (r3 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.h r0 = this.a.i;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "liveStream");
        r0.a.t = r3;
        return;
    L8:
        return;
    }

    public final void onPageScrollStateChanged(int r2) {
        throw new RuntimeException("[onPageScrollStateChanged] method not support, anchor not support");
    }

    public final void onSei(String r2) {
        throw new RuntimeException("[onSei] method not support, anchor not support");
    }

    public final void setArguments(Bundle r2) {
        NewAnchorInteractionFragment r0 = this.a;
        r0.getClass();
        r0.setArguments(r2);
    }

    public final void zA(EnterRoomInfoResult r2) {
        Intrinsics.checkNotNullParameter(r2, "roomInfo");
        throw new RuntimeException("[onUpdateEnterRoomInfo] method not support, anchor not support");
    }

    public final boolean interceptCloseRoom(Runnable r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "runnable");
        throw new RuntimeException("[interceptCloseRoom] method not support, anchor not support");
    }

    public final void show(FragmentManager r2, String r3) {
        if (r2 == null) goto L5;
        NewAnchorInteractionFragment r0 = this.a;
        r0.getClass();
        r0.show(r2, r3);
        return;
    }

    public final void bW(Room r1, EnterRoomExtra r2, Runnable r3) {
        Intrinsics.checkNotNullParameter(r1, "room");
        throw new RuntimeException("[continueRoomEnter] method not support, anchor not support");
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        NewAnchorInteractionFragment r0 = this.a;
        r0.getClass();
        r0.onActivityResult(r2, r3, r4);
    }
}
