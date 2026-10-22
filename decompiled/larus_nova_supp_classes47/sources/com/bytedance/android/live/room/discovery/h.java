package com.bytedance.android.live.room.discovery;

import android.content.SharedPreferences;
import android.hardware.usb.UsbManager;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.room.discovery.presenter.SoundCardModeManager;
import com.bytedance.android.live.room.utils.UsbDeviceUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.live.ILiveExternalCameraServiceForOther;
import com.bytedance.dux.duxswitch.DuxSwitch;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ AnchorPerfMonitorDialogNew a;

    public h(AnchorPerfMonitorDialogNew r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        ILiveExternalCameraServiceForOther r0 = jc1.k.f(ILiveExternalCameraServiceForOther.class);
        if (r0 != null) goto L5;
    L8:
        UsbManager r1 = UsbDeviceUtils.a;
        List r2 = UsbDeviceUtils.b();
        if (((ArrayList) r2).size() != 1) goto L11;
        this.a.n = (String) CollectionsKt.first(r2);
    L12:
        if (r12 == null) goto L22;
        DuxSwitch r13 = (DuxSwitch) r12;
        r13.isChecked();
        SharedPreferences r3 = SoundCardModeManager.a;
        SoundCardModeManager.e(r13.isChecked());
        SoundCardModeManager.d(r13.isChecked(), this.a.n);
        AnchorPerfMonitorDialogNew r4 = this.a;
        boolean r14 = r13.isChecked();
        r4.getClass();
        com.bytedance.android.livesdk.log.g r5 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r6 = new Pair[2];
        r6[0] = TuplesKt.to("event_page", "capability_panel");
        if (r14 == false) goto L16;
        String r8 = "on";
    L17:
        r6[1] = TuplesKt.to("capability_button_action", r8);
        r5.sendLog("livesdk_live_soundcard_button_click", MapsKt.mapOf(r6), new Object[]{Room.class});
        if (r14 == false) goto L23;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_soundcard_button_on", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_page", "capability_panel"), TuplesKt.to("capability_button_action", "on")}), new Object[]{Room.class});
        return;
    L23:
        return;
    L16:
        r8 = "off";
        goto L17
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.dux.duxswitch.DuxSwitch");
    L11:
        this.a.n = "";
        goto L12
    L5:
        if (r0.isConnected() != true) goto L8;
        f2.c("相机连接过程中暂不支持设置", 0);
    }
}
