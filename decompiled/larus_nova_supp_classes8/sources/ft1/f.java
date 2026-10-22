package ft1;

import android.content.Intent;
import android.os.Process;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.gw;
import com.bytedance.android.livesdk.config.mm;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements ICrashCallback {
    public final /* synthetic */ e a;
    public final /* synthetic */ WeakReference b;

    public f(e r1, WeakReference r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onCrash(CrashType r10, String r11, Thread r12) {
        Intrinsics.checkNotNullParameter(r10, "type");
        e r13 = this.a;
        f r0 = r13.b;
        Lifecycle.State r1 = null;
        if (r0 == null) goto L5;
        Npth.unregisterCrashCallback(r0, CrashType.ALL);
        r13.b = null;
    L5:
        j r14 = this.a.c;
        if (r14 == null) goto L58;
        Intrinsics.checkNotNullParameter(r10, "type");
        if (r14.d.isFinishing() == false) goto L10;
    L28:
        boolean r15 = false;
    L29:
        if (r15 == true) goto L32;
        ALogger.i(j.f, "activity not in foreground");
        j.a(1);
    L34:
        boolean r16 = false;
    L37:
        if (r16 == false) goto L57;
        int r17 = b.a;
        ALogger.i("LiveCrashTagRecorder", "LiveRoomCrashRecover handleRecover");
        if (r10 != CrashType.JAVA) goto L41;
    L44:
        ALogger.i("LiveCrashTagRecorder", "start crash recover");
        Intent r18 = new Intent();
        r18.addFlags(268435456);
        r18.putExtra("key_live_is_multi_process", true);
        r18.putExtra("multi_process_extra_process_id", Process.myPid());
        r18.putExtra("extra_crash_recover_room_id", r14.b);
        r18.putExtra("extra_crash_recover_crash_type", r10.getName());
        String r2 = r14.e.getEnterInfo().d;
        String r4 = r14.e.getEnterInfo().f;
        r18.putExtra("extra_crash_recover_enter_from_merge", r2);
        r18.putExtra("extra_crash_recover_enter_from_method", r4);
        long r5 = System.currentTimeMillis() - r14.c;
        String r3 = j.f;
        ALogger.i(r3, "live time:" + r5);
        if (r5 >= j.h) goto L47;
        boolean r6 = true;
    L49:
        if (r6 == false) goto L51;
        ALogger.i(r3, "live is too short");
        r18.putExtra("extra_crash_class_type", 0);
    L52:
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("recover_crash_type", r10.getName());
        if (r6 == false) goto L55;
        String r19 = "1";
    L56:
        r7.put("recover_type", r19);
        j0.l().sendLog("livesdk_recover_when_crash_start", r7, new Object[]{Room.class});
        r18.putExtra("extra_crash_recover_room_id", r14.b);
        r18.setClassName(r14.d, "com.ss.android.ugc.aweme.live.LiveMultiProcessCrashActivity");
        r14.d.startActivity(r18);
        goto L58
    L55:
        r19 = "0";
        goto L56
    L51:
        r18.putExtra("extra_crash_class_type", 1);
        goto L52
    L47:
        r6 = false;
        goto L49
    L41:
        if (r10 == CrashType.NATIVE) goto L44;
        if (mm.a.getValue().d() == false) goto L58;
    L57:
        int r110 = b.a;
        ALogger.i("LiveCrashTagRecorder", "LiveRoomCrashRecover cant recover");
        goto L58
    L32:
        if (r14.a.getInt("fast_boot_count_key_name", 0) <= 1) goto L35;
        ALogger.i(j.f, "enter safe mode");
        j.a(2);
        goto L34
    L35:
        r16 = true;
        goto L37
    L10:
        if (r14.d.isDestroyed() == true) goto L28;
        int r111 = b.a;
        if (mm.a.getValue().c() == false) goto L22;
        LifecycleOwner r112 = r14.e.getLifecycleOwner();
        if (r112 == null) goto L20;
        Lifecycle r113 = r112.getLifecycle();
        if (r113 == null) goto L20;
        r1 = r113.getCurrentState();
    L20:
        if (r1 != Lifecycle.State.RESUMED) goto L22;
        r15 = true;
    L22:
        View r114 = r14.d.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L27;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r8 = ThreadMethodProxy.currentThread();
        if (r8 == com.larus.home.impl.utils.c.a) goto L27;
        com.larus.home.impl.utils.c.a(r8, "getDecorView");
    L27:
        r15 = r114.hasWindowFocus();
    L58:
        int r115 = b.a;
        if (gw.a.getValue().booleanValue() == false) goto L81;
        WeakReference r116 = this.b;
        if (r116 == null) goto L66;
        RoomBaseSession r117 = (RoomBaseSession) r116.get();
        if (r117 == null) goto L66;
        if (r117.isVsRoom() != true) goto L66;
    L76:
        WeakReference r118 = this.b;
        if (r118 == null) goto L95;
        RoomBaseSession r119 = (RoomBaseSession) r118.get();
        if (r119 == null) goto L96;
        ls2.e r120 = new ls2.e(-1);
        r120.setReasonV2(EndReason.ROOM_CRASH.INSTANCE);
        Unit r121 = Unit.INSTANCE;
        r119.logRoomExit(0, r120);
        return;
    L96:
        return;
    L95:
        return;
    L66:
        WeakReference r122 = this.b;
        if (r122 == null) goto L71;
        RoomBaseSession r123 = (RoomBaseSession) r122.get();
        if (r123 == null) goto L71;
        r123.setRoomLoggerEndReason(EndReason.ROOM_CRASH.INSTANCE);
    L71:
        WeakReference r124 = this.b;
        if (r124 == null) goto L76;
        RoomBaseSession r125 = (RoomBaseSession) r124.get();
        if (r125 == null) goto L76;
        r125.logRoomDuration();
        goto L76
    L81:
        RoomBaseSession r126 = this.a.e;
        if (r126 != null) goto L84;
    L85:
        RoomBaseSession r127 = this.a.e;
        if (r127 == null) goto L88;
        r127.setRoomLoggerEndReason(EndReason.ROOM_CRASH.INSTANCE);
    L88:
        RoomBaseSession r128 = this.a.e;
        if (r128 == null) goto L91;
        r128.logRoomDuration();
    L91:
        RoomBaseSession r129 = this.a.e;
        if (r129 == null) goto L98;
        ls2.e r130 = new ls2.e(-1);
        r130.setReasonV2(EndReason.ROOM_CRASH.INSTANCE);
        Unit r131 = Unit.INSTANCE;
        r129.logRoomExit(0, r130);
        return;
    L98:
        return;
    L84:
        if (r126.isVsRoom() == true) goto L91;
        goto L85
    }
}
