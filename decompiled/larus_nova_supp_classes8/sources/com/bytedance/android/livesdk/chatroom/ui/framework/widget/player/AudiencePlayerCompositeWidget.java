package com.bytedance.android.livesdk.chatroom.ui.framework.widget.player;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.chatroom.game.player.RoomGamePlayerHelper;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.h;
import com.bytedance.android.livesdk.message.model.ri;
import com.bytedance.android.livesdkapi.depend.model.live.IPlaySetting;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.model.streamcontrol.StreamControlInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.k3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/player/AudiencePlayerCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/player/PlayerCompositeWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePlayerCompositeWidget extends PlayerCompositeWidget {
    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L5;
        boolean r1 = r0.V9();
    L6:
        if (r1 == false) goto L14;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L10;
        r2.observe("cmd_current_sub_camera_state", this);
    L10:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L15;
        r3.observe("cmd_current_sub_camera_exit_online", this);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r1 = true;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final void onDestroy() {
        super.onDestroy();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    public AudiencePlayerCompositeWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final void Bq(k3 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Logger.d("PlayerCompositeWidget", "horizontal=" + r3.a + ", videoBottom=" + r3.b);
        super.Bq(r3);
        if (this.c < com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b.a) goto L10;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r4 = this.b;
        if (r4 == null) goto L7;
        ViewGroup r5 = r4.Wa();
    L8:
        if (r5 == null) goto L10;
        r5.post(new b(this, r5));
        goto L10
    L7:
        r5 = null;
    L10:
        h.b(((Widget) this).dataCenter, "updateVideoDirection");
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final void onChanged(KVData r6) {
        super.onChanged(r6);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L60;
        View r1 = null;
        if (r6 == null) goto L10;
        String r2 = r6.getKey();
    L11:
        if (r2 == null) goto L61;
        int r3 = r2.hashCode();
        if (r3 == (-297648124)) goto L44;
        if (r3 == 795622401) goto L19;
        return;
    L19:
        if (r2.equals("cmd_current_sub_camera_state") == false) goto L55;
        es0.a r7 = (es0.a) r6.getData();
        if (r7 != null) goto L24;
        return;
    L24:
        if ((r7 instanceof es0.a.d) == false) goto L34;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r4 = this.b;
        if (r4 == null) goto L28;
        View r5 = r4.b6();
    L29:
        UIUtils.setViewVisibility(r5, 4);
        com.bytedance.android.livesdk.chatroom.ui.framework.d r8 = this.b;
        if (r8 == null) goto L32;
        r1 = r8.r7();
    L32:
        UIUtils.setViewVisibility(r1, 4);
        int r9 = y.a;
        y.a(((Widget) this).dataCenter, this.e, "AudiencePlayerCompositeWidget->updateSubStreamState", new c(this, r7));
        return;
    L28:
        r5 = null;
        goto L29
    L34:
        if ((r7 instanceof es0.a.c) == false) goto L57;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r10 = this.b;
        if (r10 == null) goto L38;
        View r11 = r10.b6();
    L39:
        UIUtils.setViewVisibility(r11, 0);
        com.bytedance.android.livesdk.chatroom.ui.framework.d r12 = this.b;
        if (r12 == null) goto L42;
        r1 = r12.r7();
    L42:
        UIUtils.setViewVisibility(r1, 0);
        int r13 = y.a;
        y.a(((Widget) this).dataCenter, this.e, "AudiencePlayerCompositeWidget->updateSubStreamState", new d(this));
        return;
    L38:
        r11 = null;
        goto L39
    L57:
        return;
    L55:
        return;
    L44:
        if (r2.equals("cmd_current_sub_camera_exit_online") == false) goto L59;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r14 = this.b;
        if (r14 == null) goto L48;
        View r15 = r14.b6();
    L49:
        UIUtils.setViewVisibility(r15, 0);
        com.bytedance.android.livesdk.chatroom.ui.framework.d r16 = this.b;
        if (r16 == null) goto L52;
        r1 = r16.r7();
    L52:
        UIUtils.setViewVisibility(r1, 0);
        return;
    L48:
        r15 = null;
        goto L49
    L59:
        return;
    L61:
        return;
    L10:
        r2 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final void wq(ri r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        Room r1 = z.o(r0);
    L6:
        if (r1 == null) goto L12;
        long r2 = r1.getRoomId();
        if (r2 > 0) goto L10;
        return;
    L10:
        RoomGamePlayerHelper.a(r6, r2, this, ((Widget) this).dataCenter);
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final void xq(String r9) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        Room r1 = z.o(r0);
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a;
        if (r2 == null) goto L9;
        boolean r3 = r2.hq();
    L10:
        ALogger.d("PlayerCompositeWidget", "handleStreamControlMessage controlMessage: " + r9 + ", mRoom: " + r1 + ", mIsViewValid: " + r3);
        if (r3 == false) goto L35;
        if (r1 == null) goto L36;
        if (r9 != null) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r9) == true) goto L39;
        ILivePlayerClient r4 = LivePlatformPlayerManager.f();
        if (r4 == null) goto L38;
        long r5 = r1.getStreamId();
        if (r1.isCompoundScene() == false) goto L29;
        StreamUrl r6 = r1.getStreamUrl();
        if (r6 != null) goto L33;
    L28:
        r5 = r1.getStreamId();     // Catch: NumberFormatException -> L31
    L32:
        goto L29
    L33:
        IPlaySetting r7 = r6.getPlay();     // Catch: NumberFormatException -> L31
        if (r7 == null) goto L28;
        String r8 = r7.getVertical();     // Catch: NumberFormatException -> L31
        if (r8 == null) goto L28;
        r5 = CastLongProtector.parseLong(r8);     // Catch: NumberFormatException -> L31
    L29:
        r4.handleControlMessage(r9, r1.id, r5);
        return;
    L38:
        return;
    L39:
        return;
    L36:
        return;
    L35:
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final boolean yq(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        return Intrinsics.areEqual("pull", r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.player.PlayerCompositeWidget
    public final void zq(String r3, StreamControlInfo.ControlParams r4) {
        Intrinsics.checkNotNullParameter(r3, "controlMessage");
        Intrinsics.checkNotNullParameter(r4, "controlParams");
        super.zq(r3, r4);
        ALogger.d("PlayerCompositeWidget", "handleStreamControlMessage type: " + r4.type + ", mIsAnchor: false");
        String r5 = r4.type;
        if (r5 != null) goto L5;
    L6:
        ALogger.e("PlayerCompositeWidget", "handleStreamControlMessage type is error: " + r5);
        return;
    L5:
        if (Intrinsics.areEqual("pull", r5) == false) goto L6;
    }
}
