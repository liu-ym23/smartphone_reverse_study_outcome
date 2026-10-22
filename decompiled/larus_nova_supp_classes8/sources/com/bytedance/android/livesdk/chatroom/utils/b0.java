package com.bytedance.android.livesdk.chatroom.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.prefs.PropertyCache;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 {
    public static boolean a;

    public static final String c() {
        return "live_echo_enabled_" + jc1.k.n(IMiddlewareUserService.class).user().n();
    }

    public static final boolean f() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L9;
        if (a(com.bytedance.android.live.core.utils.s1.getContext(), "android.permission.BLUETOOTH_CONNECT") == 0) goto L9;
        ALogger.i("headset debug", "no bt connect permission");
        return false;
    L9:
        if (r0 >= 23) goto L11;
    L14:
        BluetoothAdapter r1 = BluetoothAdapter.getDefaultAdapter();
        if (r1 != null) goto L17;
    L24:
        ALogger.i("headset debug", "close");
        return false;
    L17:
        if (r1.isEnabled() == false) goto L24;
        int r4 = r1.getProfileConnectionState(2);
        int r6 = r1.getProfileConnectionState(1);
        int r2 = r1.getProfileConnectionState(3);
        if (r4 == 2) goto L22;
        if (r6 == 2) goto L22;
        if (r2 != 2) goto L24;
    L22:
        ALogger.i("headset debug", "blue tooth open");
        return true;
    L11:
        if (a(com.bytedance.android.live.core.utils.s1.getContext(), "android.permission.BLUETOOTH") == 0) goto L14;
        ALogger.i("headset debug", "no permission");
        return false;
    }

    public static final void i() {
        if (a == true) goto L5;
        return;
    L5:
        if (b() == false) goto L10;
        com.bytedance.android.live.core.utils.f2.b(2131922912, 0);
        com.bytedance.android.livesdk.log.j0.l().f("livesdk_earphone_monitor_bluetooth_toast_show", MapsKt.emptyMap(), new Object[]{IRoom.class, am2.x.class});
        return;
    }

    public static final boolean b() {
        if (d() == true) goto L6;
        return false;
    L6:
        return PropertyCache.getBoolean(c(), false);
    }

    public static final boolean d() {
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 != null) goto L6;
        ALogger.w("HeadsetUtil", "check switch before room context");
    L6:
        if (r0 == null) goto L10;
        Boolean r2 = r0.isAnchor();
        if (r2 == null) goto L10;
        boolean r3 = r2.booleanValue();
    L11:
        if (r0 == null) goto L18;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L18;
        IRoom r4 = (IRoom) r1.getValue();
        if (r4 == null) goto L18;
        LiveMode r5 = r4.getStreamType();
        if (r5 == null) goto L18;
    L20:
        if (r5 != LiveMode.VIDEO) goto L22;
    L27:
        boolean r6 = true;
    L29:
        if (((Boolean) vm2.h.I.getValue(null, vm2.h.a[33])).booleanValue() == false) goto L34;
        if (r6 == false) goto L35;
        if (r3 == false) goto L36;
        return true;
    L36:
        return false;
    L35:
        return false;
    L34:
        return false;
    L22:
        if (r5 == LiveMode.AUDIO) goto L27;
        if (r5 == LiveMode.MEDIA) goto L27;
        r6 = false;
    L18:
        r5 = LiveMode.VIDEO;
    L10:
        r3 = false;
        goto L11
    }

    public static final void g() {
        Context r0 = com.bytedance.android.live.core.utils.s1.getContext();
        com.bytedance.live.datacontext.l r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService(DataType.AUDIO);
    L7:
        if ((r2 instanceof AudioManager) == true) goto L9;
        r2 = null;
    L9:
        AudioManager r3 = (AudioManager) r2;
        if (r3 == null) goto L91;
        Intrinsics.checkNotNullParameter(r3, "audioManager");
        if (e(r3) == false) goto L24;
        com.bytedance.android.livesdk.chatroom.o r4 = o3.f();
        if (r4 == null) goto L23;
        com.bytedance.live.datacontext.l r5 = r4.X1();
        if (r5 == null) goto L23;
        if ((!((Boolean) r5.getValue()).booleanValue()) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L23;
        r5.setValue(Boolean.TRUE);
    L23:
        xs2.b.a().post(new com.bytedance.android.livesdk.chatroom.model.a4(true));
    L36:
        if (f() == false) goto L48;
        com.bytedance.android.livesdk.chatroom.o r6 = o3.f();
        if (r6 == null) goto L47;
        com.bytedance.live.datacontext.l r7 = r6.n2();
        if (r7 == null) goto L47;
        if ((!((Boolean) r7.getValue()).booleanValue()) == true) goto L45;
        r7 = null;
    L45:
        if (r7 == null) goto L47;
        r7.setValue(Boolean.TRUE);
    L47:
        xs2.b.a().post(new com.bytedance.android.livesdk.chatroom.model.b4(true));
    L60:
        if (e(r3) == false) goto L74;
        com.bytedance.android.livesdk.chatroom.o r8 = o3.f();
        if (r8 == null) goto L71;
        com.bytedance.live.datacontext.l r9 = r8.R2();
        if (r9 == null) goto L71;
        if ((!((Boolean) r9.getValue()).booleanValue()) == false) goto L68;
        r1 = r9;
    L68:
        if (r1 == null) goto L71;
        r1.setValue(Boolean.TRUE);
    L71:
        if (d() == false) goto L92;
        h(b());
        return;
    L92:
        return;
    L74:
        if (d() == false) goto L77;
        h(false);
    L77:
        if (f() == true) goto L79;
        a = false;
        com.bytedance.android.livesdk.chatroom.o r10 = o3.f();
        if (r10 == null) goto L96;
        com.bytedance.live.datacontext.l r11 = r10.R2();
        if (r11 != null) goto L86;
        return;
    L86:
        if (((Boolean) r11.getValue()).booleanValue() == false) goto L88;
        r1 = r11;
    L88:
        if (r1 == null) goto L98;
        r1.setValue(Boolean.FALSE);
        return;
    L98:
        return;
    L96:
        return;
    L79:
        if (a == true) goto L94;
        a = true;
        i();
        return;
    L94:
        return;
    L48:
        com.bytedance.android.livesdk.chatroom.o r12 = o3.f();
        if (r12 == null) goto L58;
        com.bytedance.live.datacontext.l r13 = r12.n2();
        if (r13 == null) goto L58;
        if (((Boolean) r13.getValue()).booleanValue() == true) goto L56;
        r13 = null;
    L56:
        if (r13 == null) goto L58;
        r13.setValue(Boolean.FALSE);
    L58:
        xs2.b.a().post(new com.bytedance.android.livesdk.chatroom.model.b4(false));
        goto L60
    L24:
        com.bytedance.android.livesdk.chatroom.o r14 = o3.f();
        if (r14 == null) goto L34;
        com.bytedance.live.datacontext.l r15 = r14.X1();
        if (r15 == null) goto L34;
        if (((Boolean) r15.getValue()).booleanValue() == true) goto L32;
        r15 = null;
    L32:
        if (r15 == null) goto L34;
        r15.setValue(Boolean.FALSE);
    L34:
        xs2.b.a().post(new com.bytedance.android.livesdk.chatroom.model.a4(false));
        goto L36
    L91:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public static final boolean e(AudioManager r2) {
        Intrinsics.checkNotNullParameter(r2, "audioManager");
        boolean r3 = r2.isWiredHeadsetOn();
        ALogger.i("headset debug", "wired open: " + r3);
        return r3;
    }

    public static final void h(boolean r3) {
        ALogger.i("HeadsetUtil", "try set ongoing echo state to " + r3);
        Context r4 = com.bytedance.android.live.core.utils.s1.getContext();
        com.bytedance.android.live.pushstream.d r1 = null;
        if (r4 == null) goto L5;
        Object r5 = r4.getSystemService(DataType.AUDIO);
    L7:
        if ((r5 instanceof AudioManager) == true) goto L9;
        r5 = null;
    L9:
        AudioManager r6 = (AudioManager) r5;
        if (r6 != null) goto L12;
    L13:
        ALogger.i("HeadsetUtil", "set echo state, no wired headset");
    L29:
        com.bytedance.android.livesdk.chatroom.o r7 = o3.f();     // Catch: RuntimeException -> L26
        if (r7 == null) goto L19;
        com.bytedance.live.datacontext.j r8 = r7.getLiveStream();     // Catch: RuntimeException -> L26
        if (r8 == null) goto L19;
        r1 = (com.bytedance.android.live.pushstream.d) r8.getValue();     // Catch: RuntimeException -> L26
    L19:
        if (r1 != null) goto L22;
        ALogger.w("HeadsetUtil", "liveStream is null");     // Catch: RuntimeException -> L26
        return;
    L22:
        uf2.d0 r9 = r1.A();     // Catch: RuntimeException -> L26
        if (r9 == null) goto L30;
        r9.m0();     // Catch: RuntimeException -> L26
        return;
    L30:
        return;
    L26:
        e = move-exception;
        ALogger.e("HeadsetUtil", e.getClass().getCanonicalName());
        return;
    L12:
        if (e(r6) == true) goto L29;
    L5:
        r5 = null;
        goto L7
    }

    public static int a(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b("auto_cert_com_bytedance_android_livesdk_chatroom_utils_HeadsetUtilKt_android_content_Context_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
