package com.bytedance.android.livesdk.interactivity.interactive.episode;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.interactivity.interactive.EpisodeInteractiveContext;
import com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXHelper;
import com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import o82.h;
import pm1.f;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/episode/EpisodeInteractiveAnnieXHelper;", "Lcom/bytedance/android/livesdk/interactivity/interactive/LiveInteractiveAnnieXHelper;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeInteractiveAnnieXHelper extends LiveInteractiveAnnieXHelper {
    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXHelper
    public final String j() {
        return "episode_";
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXHelper
    public final LiveInteractivePresenter e() {
        return new EpisodeInteractivePresenter();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXHelper
    public final Map<String, String> g() {
        Long r1 = null;
        u r0 = r.u(this.q, null, 2);
        if (r0 == null) goto L15;
        Room r2 = r0.j0();
        if (r2 == null) goto L15;
        VSRoom r3 = r2.castToOrNull(VSRoom.class);
        if (r3 == null) goto L15;
        EpisodeExtraInfo r4 = r3.getEpisodeExtra();
        if (r4 == null) goto L15;
        IBaseEpisodeMod r5 = r4.getMod();
        if (r5 == null) goto L15;
        if (r5.getEpisodeStage() != EpisodeMod.EpisodeStageType.PREMIERE) goto L15;
        int r6 = 2;
    L29:
        Map<String, String> r7 = r.i().I(this.q);
        Pair[] r8 = new Pair[7];
        r8[0] = TuplesKt.to("room_type", String.valueOf(r6));
        u r9 = r.u(this.q, null, 2);
        String r10 = "0";
        if (r9 == null) goto L37;
        Room r11 = r9.j0();
        if (r11 == null) goto L37;
        IEpisodeExtraInfo r13 = r11.getEpisodeComponentData();
        if (r13 == null) goto L37;
        String r14 = String.valueOf(r13.getId());
        if (r14 == null) goto L37;
    L38:
        r8[1] = TuplesKt.to("episode_id", r14);
        r8[2] = TuplesKt.to("vs_is_merge", "1");
        if (this.p == false) goto L41;
        String r15 = "portrait";
    L42:
        r8[3] = TuplesKt.to("vs_screen_type", r15);
        nm1.r r16 = f.o();
        if (r16 == null) goto L47;
        r16.a();
        if (MultiTabManagerImpl.e.h(this.q) != true) goto L47;
        Object r17 = "1";
    L48:
        r8[4] = TuplesKt.to("is_multi_tab_room", r17);
        u r18 = r.u(this.q, null, 2);
        if (r18 == null) goto L55;
        m r19 = r18.y();
        if (r19 == null) goto L55;
        if (((Boolean) r19.getValue()).booleanValue() != true) goto L55;
        r10 = "1";
    L55:
        r8[5] = TuplesKt.to("vs_vote_icon_show", r10);
        nm1.m r20 = f.l();
        if (r20 == null) goto L68;
        u r21 = r.u(this.q, null, 2);
        if (r21 == null) goto L60;
        Room r23 = r21.j0();
    L61:
        u r24 = r.u(this.q, null, 2);
        if (r24 == null) goto L66;
        m r25 = r24.cameraId();
        if (r25 == null) goto L66;
        r1 = (Long) r25.getValue();
    L66:
        String r26 = String.valueOf(r20.k(r23, r1));
        if (r26 == null) goto L68;
    L69:
        r8[6] = TuplesKt.to("camera_group_id", r26);
        r7.putAll(MapsKt.hashMapOf(r8));
        return r7;
    L60:
        r23 = null;
    L68:
        r26 = BuildConfig.FLAVOR;
    L47:
        r17 = "0";
        goto L48
    L41:
        r15 = "landscape";
    L37:
        r14 = "0";
    L15:
        u r27 = r.u(this.q, null, 2);
        if (r27 == null) goto L28;
        Room r28 = r27.j0();
        if (r28 == null) goto L28;
        VSRoom r29 = r28.castToOrNull(VSRoom.class);
        if (r29 == null) goto L28;
        EpisodeExtraInfo r30 = r29.getEpisodeExtra();
        if (r30 == null) goto L28;
        IBaseEpisodeMod r31 = r30.getMod();
        if (r31 == null) goto L28;
        if (r31.getEpisodeStage() != EpisodeMod.EpisodeStageType.LIVE) goto L28;
        r6 = 1;
    L28:
        r6 = 0;
        goto L29
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXHelper
    public final com.bytedance.android.livesdk.interactivity.interactive.c h() {
        u r0 = r.u(this.q, null, 2);
        if (r0 == null) goto L5;
        ViewModel r1 = r0.c();
    L7:
        if ((r1 instanceof EpisodeInteractiveContext) == true) goto L9;
        r1 = null;
    L9:
        EpisodeInteractiveContext r2 = (EpisodeInteractiveContext) r1;
        if (r2 == null) goto L15;
        n<com.bytedance.android.livesdk.interactivity.interactive.c> r3 = r2.getEpisodeInteractiveAnnieXInfo();
        if (r3 != null) goto L14;
        return null;
    L14:
        return (com.bytedance.android.livesdk.interactivity.interactive.c) r3.getValue();
    L15:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXHelper
    public final boolean c() {
        boolean r1 = false;
        if (FoldScreenUtils.f() == false) goto L6;
        h.b("canInteractiveComponentShow false, this device is fold screen");
        return false;
    L6:
        nm1.m r2 = s.g();
        ViewModel r9 = null;
        if (r2 == null) goto L38;
        u r3 = r.u(this.q, null, 2);
        if (r3 == null) goto L15;
        m r4 = r3.cameraId();
        if (r4 == null) goto L15;
        Long r5 = (Long) r4.getValue();
        if (r5 == null) goto L15;
        long r6 = r5.longValue();
    L16:
        u r7 = r.u(this.q, null, 2);
        if (r7 == null) goto L23;
        Room r8 = r7.j0();
        if (r8 == null) goto L23;
        IEpisodeExtraInfo r10 = r8.getEpisodeComponentData();
        if (r10 == null) goto L23;
        Long r11 = Long.valueOf(r10.getDefaultCameraId());
    L24:
        u r13 = r.u(this.q, null, 2);
        if (r13 == null) goto L27;
        Room r14 = r13.j0();
    L28:
        u r15 = r.u(this.q, null, 2);
        if (r15 != null) goto L31;
    L33:
        boolean r16 = false;
    L35:
        if (r2.q(r6, r11, r14, r16) != true) goto L38;
        h.b("canInteractiveComponentShow false, cuz interactive component should not show in current camera.");
        return false;
    L31:
        if (r15.e0() != true) goto L33;
        r16 = true;
        goto L35
    L27:
        r14 = null;
    L23:
        r11 = null;
    L15:
        r6 = 0;
    L38:
        DataCenter r17 = this.q;
        if (r17 != null) goto L41;
    L50:
        DataCenter r18 = this.q;
        if (r18 != null) goto L53;
    L62:
        DataCenter r19 = this.q;
        if (r19 != null) goto L65;
    L66:
        s.i().a();
        if (MultiTabManagerImpl.e.i(this.q) == true) goto L69;
    L71:
        DataCenter r20 = this.q;
        if (r20 == null) goto L76;
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r20, true) != true) goto L76;
    L78:
        u r21 = r.u(this.q, null, 2);
        if (r21 == null) goto L81;
        ViewModel r23 = r21.c();
    L83:
        if ((r23 instanceof EpisodeInteractiveContext) == false) goto L86;
        r9 = r23;
    L86:
        EpisodeInteractiveContext r24 = (EpisodeInteractiveContext) r9;
        if (r24 == null) goto L93;
        m<Boolean> r25 = r24.getEnableInteractive();
        if (r25 == null) goto L93;
        if (((Boolean) r25.getValue()).booleanValue() != true) goto L93;
        r1 = true;
    L93:
        h.b("canInteractiveComponentShow by switch:" + r1);
        return r1;
    L81:
        r23 = null;
    L76:
        if (this.n == false) goto L78;
        return false;
    L69:
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.f.d().a.getValue(), Boolean.TRUE) == false) goto L71;
        return false;
    L65:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r19, true) == true) goto L71;
    L53:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r18, true) == true) goto L62;
        u r26 = r.u(this.q, null, 2);
        if (r26 == null) goto L62;
        m r27 = r26.z1();
        if (r27 == null) goto L62;
        if (((Boolean) r27.getValue()).booleanValue() != true) goto L62;
        h.b("canInteractiveComponentShow false, cuz matchRoom landscape MultiCameraPanelShowing true");
        return false;
    L41:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r17, true) != true) goto L50;
        DataCenter r28 = this.q;
        if (r28 == null) goto L45;
        Boolean r29 = (Boolean) r28.get("match_is_public_interact_tab", Boolean.TRUE);
    L47:
        if (Intrinsics.areEqual(r29, Boolean.FALSE) == false) goto L50;
        h.b("canInteractiveComponentShow false, cuz matchRoom tab is not Chat");
        return false;
    L45:
        r29 = null;
        goto L47
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXHelper
    public final void t(com.bytedance.android.livesdk.interactivity.interactive.c r4) {
        Intrinsics.checkNotNullParameter(r4, "interactiveInfo");
        ViewModel r1 = null;
        u r0 = r.u(this.q, null, 2);
        if (r0 == null) goto L5;
        ViewModel r2 = r0.c();
    L7:
        if ((r2 instanceof EpisodeInteractiveContext) == false) goto L10;
        r1 = r2;
    L10:
        EpisodeInteractiveContext r3 = (EpisodeInteractiveContext) r1;
        if (r3 == null) goto L16;
        n<com.bytedance.android.livesdk.interactivity.interactive.c> r5 = r3.getEpisodeInteractiveAnnieXInfo();
        if (r5 == null) goto L17;
        r5.setValue(r4);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public EpisodeInteractiveAnnieXHelper(boolean r2, DataCenter r3, Context r4, com.bytedance.android.livesdk.interactivity.interactive.b r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        super(r2, r3, r4, r5);
    }
}
