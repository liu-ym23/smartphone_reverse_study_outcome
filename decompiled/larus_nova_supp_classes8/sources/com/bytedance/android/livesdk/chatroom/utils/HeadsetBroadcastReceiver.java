package com.bytedance.android.livesdk.chatroom.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/utils/HeadsetBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "a", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadsetBroadcastReceiver extends BroadcastReceiver {

    public static final class a {
    }

    static {
    }

    public HeadsetBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r24, Intent r25) {
        Object r9 = null;
        if (r25 == null) goto L5;
        String r1 = r25.getAction();
    L7:
        if (Intrinsics.areEqual("android.intent.action.HEADSET_PLUG", r1) == false) goto L17;
        if (r25.hasExtra("state") == true) goto L11;
        return;
    L11:
        if (r25.getIntExtra("state", 0) != 0) goto L14;
        b0.g();
        return;
    L14:
        if (r25.getIntExtra("state", 0) != 1) goto L76;
        b0.g();
        return;
    L76:
        return;
    L17:
        if (Intrinsics.areEqual("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED", r1) == false) goto L49;
        BluetoothAdapter r12 = BluetoothAdapter.getDefaultAdapter();
        if (Build.VERSION.SDK_INT < 34) goto L45;
        if (r24 == null) goto L45;
        ArrayList r13 = new ArrayList();
        Object[] r14 = {"android.permission.BLUETOOTH_CONNECT"};
        f06.b r7 = new f06.b("auto_cert_com_bytedance_android_livesdk_chatroom_utils_HeadsetBroadcastReceiver_android_content_Context_checkSelfPermission");
        g06.a r0 = (g06.a) ApiHookConfig.b.get(102608);
        if (r0 == null) goto L24;
        f06.a[] r2 = r0.i;
    L25:
        f06.a[] r6 = r2;
        int r5 = r6.length;
        int r4 = 0;
    L27:
        if (r4 >= r5) goto L34;
        f06.a r3 = r6[r4];
        int r19 = r4;
        int r20 = r5;
        f06.a[] r21 = r6;
        f06.b r22 = r7;
        f06.d r8 = r3.preInvoke(102608, "android/content/Context", "checkSelfPermission", r24, r14, "int", r7);     // Catch: Exception -> L68
        if (r8.a == true) goto L36;
        r13.add(r3);     // Catch: Exception -> L68
    L36:
        if (r8.a == false) goto L38;
        int r10 = ((Integer) r8.b).intValue();
    L39:
        if (r10 != 0) goto L45;
        if (r12.getProfileConnectionState(1) != 0) goto L43;
        b0.g();
        return;
    L43:
        b0.g();
        return;
    L38:
        r10 = r24.checkSelfPermission("android.permission.BLUETOOTH_CONNECT");
    L33:
        r4 = r19 + 1;
        r5 = r20;
        r6 = r21;
        r7 = r22;
        goto L27
    L34:
        r8 = new f06.d(false, null);
        goto L36
    L24:
        r2 = ApiHookConfig.d;
    L45:
        if (r12.getProfileConnectionState(1) != 0) goto L47;
        b0.g();
        return;
    L47:
        b0.g();
        return;
    L49:
        if (Intrinsics.areEqual("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED", r1) == false) goto L51;
    L52:
        Context r11 = com.bytedance.android.live.core.utils.s1.getContext();
        if (r11 == null) goto L55;
        Object r15 = r11.getSystemService(DataType.AUDIO);
    L57:
        if ((r15 instanceof AudioManager) == false) goto L60;
        r9 = r15;
    L60:
        AudioManager r16 = (AudioManager) r9;
        if (r16 == null) goto L83;
        Intrinsics.checkNotNullParameter(r16, "audioManager");
        com.bytedance.android.livesdk.chatroom.o r17 = o3.f();
        if (r17 == null) goto L84;
        com.bytedance.live.datacontext.m r18 = r17.N2();
        if (r18 == null) goto L85;
        r18.setValue(Boolean.valueOf(r16.isBluetoothA2dpOn()));
        return;
    L85:
        return;
    L84:
        return;
    L83:
        return;
    L55:
        r15 = null;
        goto L57
    L51:
        if (Intrinsics.areEqual("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED", r1) == true) goto L52;
        return;
    L5:
        r1 = null;
        goto L7
    }
}
