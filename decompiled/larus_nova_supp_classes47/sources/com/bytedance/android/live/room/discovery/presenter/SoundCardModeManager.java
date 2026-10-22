package com.bytedance.android.live.room.discovery.presenter;

import android.content.SharedPreferences;
import android.hardware.usb.UsbManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.room.utils.UsbDeviceUtils;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.live.ILiveExternalCameraServiceForOther;
import com.bytedance.live.datacontext.j;
import java.util.ArrayList;
import jc1.a;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SoundCardModeManager {
    public static SharedPreferences a;
    public static final Lazy b = null;
    public static final SoundCardModeManager c = null;

    public SoundCardModeManager() {
    }

    static {
        c = new SoundCardModeManager();
        b = LazyKt.lazy(SoundCardModeManager$_soundCardModeIsOpen$2.INSTANCE);
    }

    public static SharedPreferences b() {
        if (a != null) goto L6;
        a = a.b().getSharedPreferences("sound_card_manager_sp", 0);
    L6:
        return a;
    }

    public static void c() {
        ILiveExternalCameraServiceForOther r0 = k.f(ILiveExternalCameraServiceForOther.class);
        if (r0 != null) goto L5;
    L7:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L17;
        j r2 = r1.getLiveStream();
        if (r2 == null) goto L18;
        d r3 = (d) r2.getValue();
        if (r3 == null) goto L19;
        d0 r4 = r3.A();
        if (r4 == null) goto L20;
        r4.h();
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (r0.isConnected() != true) goto L7;
    }

    public final boolean a() {
        c();
        SharedPreferences r0 = b();
        String r1 = "";
        if (r0 == null) goto L8;
        String r2 = r0.getString("last_connected_device_id", "");
        if (r2 == null) goto L8;
        r1 = r2;
    L8:
        SharedPreferences r3 = b();
        if (r3 == null) goto L11;
        boolean r4 = r3.getBoolean("last_connected_status", false);
    L12:
        UsbManager r5 = UsbDeviceUtils.a;
        boolean r6 = ((ArrayList) UsbDeviceUtils.b()).contains(r1);
        if (r4 == true) goto L15;
    L21:
        if (r6 == false) goto L28;
        SharedPreferences r7 = b();
        if (r7 == null) goto L28;
        if (r7.getBoolean("last_connected_status", false) != true) goto L28;
    L26:
        e(true);
        d(true, r1);
        u.l().sendLog("livesdk_live_soundcard_button_on", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_page", "auto_on"), TuplesKt.to("capability_button_action", "on")}), new Object[]{Room.class});
        return true;
    L28:
        return false;
    L15:
        if (UsbDeviceUtils.a() == false) goto L21;
        if (r1.length() != 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == true) goto L26;
    L19:
        r8 = false;
        goto L20
    L11:
        r4 = false;
        goto L12
    }

    public static void e(boolean r4) {
        if (r4 == false) goto L9;
        ILiveExternalCameraServiceForOther r5 = k.f(ILiveExternalCameraServiceForOther.class);
        if (r5 == null) goto L9;
        if (r5.isConnected() != true) goto L9;
        f2.c("相机连接过程中暂不支持设置", 0);
        return;
    L9:
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L19;
        j r7 = r6.getLiveStream();
        if (r7 == null) goto L20;
        d r8 = (d) r7.getValue();
        if (r8 == null) goto L21;
        d0 r9 = r8.A();
        if (r9 == null) goto L22;
        r9.h();
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public static void d(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "deviceId");
        SharedPreferences r0 = b();
        if (r0 == null) goto L8;
        SharedPreferences.Editor r1 = r0.edit();
        if (r1 == null) goto L9;
        r1.putString("last_connected_device_id", r3);
        r1.putBoolean("last_connected_status", r2);
        r1.apply();
        return;
    L9:
        return;
    }
}
