package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/anchorsetting/LiveAudioCommentDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lcom/bytedance/android/livesdk/interactivity/api/anchorsetting/p;", "Lcom/bytedance/android/livesdk/chatroom/ui/LiveSwitchButton$e;", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAudioCommentDialog extends AppCompatDialog implements p, LiveSwitchButton.e {
    public DataCenter a;
    public View b;
    public LiveSwitchButton c;
    public LiveSwitchButton d;
    public View e;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.interactivity.api.anchorsetting.p
    public final void a() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        show();
        DialogLancet.afterDialogShow(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.app.Dialog*/.onAttachedToWindow();
        View r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        this.e = r0.findViewById(2131363408);
        this.c = r0.findViewById(2131365113);
        this.d = r0.findViewById(2131364571);
        LiveSwitchButton r1 = this.c;
        Intrinsics.checkNotNull(r1);
        LiveSwitchButton r2 = this.d;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r1, "canSendAudioSwitch");
        Intrinsics.checkNotNullParameter(r2, "audioAutoPlaySwitch");
        DataCenter r3 = this.a;
        if (r3 == null) goto L22;
        r1.setOnCheckedChangeListener(this);
        Boolean r4 = Boolean.TRUE;
        r1.setChecked(((Boolean) r3.get("data_room_audio_comment_enable", r4)).booleanValue());
        r2.setOnCheckedChangeListener(this);
        r2.setChecked(((Boolean) r3.get("data_room_audio_comment_auto_play", r4)).booleanValue());
        Room r5 = null;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L13;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L13;
        r5 = (Room) r7.getValue();
    L13:
        if (r5 == null) goto L17;
        if (r5.isThirdParty() != true) goto L17;
    L18:
        UIUtils.setViewVisibility(this.e, 4);
        return;
    L17:
        if (r1.isChecked() == false) goto L18;
        UIUtils.setViewVisibility(this.e, 0);
        return;
    }

    public LiveAudioCommentDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 2131954639);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setGravity(80);
    L5:
        View r5 = LayoutInflater.from(getContext()).inflate(2131565394, null);
        this.b = r5;
        if (r5 != null) goto L8;
        return;
    L8:
        setContentView(r5);
        Window r6 = getWindow();
        if (r6 == null) goto L12;
        r6.setLayout(-1, -2);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.anchorsetting.p
    public final void setDataCenter(DataCenter r1) {
        this.a = r1;
    }

    public final void d0(LiveSwitchButton r7, boolean r8) {
        Integer r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L43;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L44;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L49;
        if (r7 == null) goto L12;
        r4 = Integer.valueOf(r7.getId());
    L12:
        if (r4 != null) goto L15;
    L28:
        if (r4 != null) goto L31;
        return;
    L31:
        if (r4.intValue() != 2131364571) goto L47;
        AudioCommentApi r3 = (AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class);
        long r5 = r2.id;
        if (r8 == false) goto L35;
        int r6 = 28;
    L36:
        AudioCommentApi.a.a(r3, r5, r6, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.user.h());
        if (r8 == false) goto L39;
        com.bytedance.android.livesdk.log.u.l().d("livesdk_open_vocal_message_autoplay", new Object[]{new am2.x(), Room.class});
    L39:
        DataCenter r9 = this.a;
        if (r9 == null) goto L48;
        r9.put("data_room_audio_comment_auto_play", Boolean.valueOf(r8));
        return;
    L48:
        return;
    L35:
        r6 = 29;
        goto L36
    L47:
        return;
    L15:
        if (r4.intValue() != 2131365113) goto L28;
        if (r8 == false) goto L18;
        com.bytedance.android.livesdk.log.u.l().d("livesdk_open_vocal_message", new Object[]{new am2.x(), Room.class});
        f2.b(2131915101, 0);
        int r10 = 26;
    L19:
        AudioCommentApi.a.a((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class), r2.id, r10, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.user.h());
        if (r8 == true) goto L22;
    L24:
        UIUtils.setViewVisibility(this.e, 4);
    L25:
        DataCenter r11 = this.a;
        if (r11 == null) goto L45;
        r11.put("data_room_audio_comment_enable", Boolean.valueOf(r8));
        return;
    L45:
        return;
    L22:
        if (r2.isThirdParty() == true) goto L24;
        UIUtils.setViewVisibility(this.e, 0);
        goto L25
    L18:
        f2.b(2131915099, 0);
        r10 = 27;
        goto L19
    L49:
        return;
    L44:
        return;
    }
}
