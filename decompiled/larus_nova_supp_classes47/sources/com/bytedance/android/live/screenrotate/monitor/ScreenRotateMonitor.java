package com.bytedance.android.live.screenrotate.monitor;

import am2.x;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.screenrotate.rotate.ScreenRotateContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.ig1;
import com.bytedance.android.livesdk.config.jg1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.IScreenRotateMonitor;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ScreenRotateMonitor implements IScreenRotateMonitor {
    public int a;
    public Integer b;
    public Integer c;
    public final StringBuilder d;
    public WeakReference<Function0<Boolean>> e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public boolean j;

    public static final class a {
    }

    static {
    }

    public final void release() {
        this.e = null;
        boolean r1 = true;
        if (this.j == false) goto L32;
        if (this.d.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L32;
        if (c(false) == true) goto L32;
        int r2 = e.m;
        e.a r3 = e.b.a("screen_rotate_trace", "live_screen_rotate");
        r3.c = "webcast_client_community";
        r3.h = 0;
        String r4 = "";
        r3.i = "";
        z71.a r5 = a();
        if (r5 == null) goto L19;
        DataCenter r6 = r5.getDataCenter();
        if (r6 == null) goto L19;
        Room r7 = z.o(r6);
        if (r7 == null) goto L19;
        String r8 = String.valueOf(r7.getRoomId());
        if (r8 == null) goto L19;
    L20:
        r3.e = r8;
        r3.g = k.n(IUserService.class).user().n();
        z71.a r9 = a();
        if (r9 == null) goto L30;
        DataCenter r10 = r9.getDataCenter();
        if (r10 == null) goto L30;
        Room r12 = z.o(r10);
        if (r12 == null) goto L30;
        String r13 = r12.getOwnerUserIdString();
        if (r13 == null) goto L30;
        r4 = r13;
    L30:
        r3.f = r4;
        e r14 = r3.a();
        JSONObject r15 = new JSONObject();
        r15.put("log", this.d.toString());
        Unit r16 = Unit.INSTANCE;
        c.b(r14, r15);
    L19:
        r8 = "";
        goto L20
    L7:
        r0 = false;
    L32:
        if (v.a() == true) goto L34;
    L39:
        StringsKt.clear(this.d);
        return;
    L34:
        if (this.d.length() > 0) goto L37;
        r1 = false;
    L37:
        if (r1 == false) goto L39;
        ALogger.i("LiveScreenRotateMonitor", this.d.toString());
        goto L39
    }

    public static z71.a a() {
        ScreenRotateContext.Companion.getClass();
        return ScreenRotateContext.Companion.b(null);
    }

    public ScreenRotateMonitor() {
        Context r0 = s1.getContext();
        if (r0 == null) goto L9;
        Resources r1 = r0.getResources();
        if (r1 == null) goto L9;
        Configuration r2 = r1.getConfiguration();
        if (r2 == null) goto L9;
        int r3 = r2.orientation;
    L10:
        this.a = r3;
        this.d = new StringBuilder();
        this.f = LazyKt.lazy(ScreenRotateMonitor$orientationDelayCheckTime$2.INSTANCE);
        this.g = LazyKt.lazy(ScreenRotateMonitor$interactionDelayCheckTime$2.INSTANCE);
        this.h = LazyKt.lazy(ScreenRotateMonitor$stackInfoLength$2.INSTANCE);
        this.i = LazyKt.lazy(ScreenRotateMonitor$enableMonitor$2.INSTANCE);
        return;
    L9:
        r3 = 0;
        goto L10
    }

    public static String b(Integer r2) {
        if (r2 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
    L12:
        if (r2 != null) goto L15;
    L17:
        return "unknown";
    L15:
        if (r2.intValue() != 2) goto L17;
        return "反向横屏";
    L10:
        if (r2.intValue() != 1) goto L12;
        return "横屏";
    L5:
        if (r2.intValue() != 0) goto L7;
        return "竖屏";
    }

    public static boolean c(boolean r12) {
        if (v.a() == false) goto L5;
        return false;
    L5:
        ig1 r0 = ig1.a;
        if (((jg1) r0.getValue()).i().contains(k.n(IUserService.class).user().n()) == false) goto L8;
        return false;
    L8:
        double r2 = Random.Default.nextDouble();
        double r5 = 0.1d;
        Double r7 = null;
        if (r12 == false) goto L26;
        if (((jg1) r0.getValue()).d() == false) goto L40;
        Double r13 = Double.valueOf(((jg1) r0.getValue()).e());
        double r8 = r13.doubleValue();
        if (r8 > 0) goto L15;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L20;
        r7 = r13;
    L20:
        if (r7 == null) goto L23;
        r5 = r7.doubleValue();
    L23:
        if (r2 > r5) goto L40;
        return false;
    L15:
        if (r8 >= 1) goto L17;
        r1 = true;
    L40:
        return true;
    L26:
        if (((jg1) r0.getValue()).g() == false) goto L40;
        Double r14 = Double.valueOf(((jg1) r0.getValue()).h());
        double r9 = r14.doubleValue();
        if (r9 > 0) goto L30;
    L32:
        boolean r3 = false;
    L33:
        if (r3 == false) goto L35;
        r7 = r14;
    L35:
        if (r7 == null) goto L38;
        r5 = r7.doubleValue();
    L38:
        if (r2 > r5) goto L40;
        return false;
    L30:
        if (r9 >= 1) goto L32;
        r3 = true;
        goto L33
    }

    public final void bindInteractionCallback(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "checkUIShow");
        WeakReference<Function0<Boolean>> r0 = this.e;
        if (r0 == null) goto L8;
        if (r0 == null) goto L6;
        Function0<Boolean> r1 = r0.get();
    L7:
        if (r1 == null) goto L8;
        return;
    L6:
        r1 = null;
    L8:
        this.e = new WeakReference(r2);
    }

    public final void markClickToRotate(int r4) {
        this.d.append("click to " + b(Integer.valueOf(r4)) + "\n");
    }

    public final void markSensorToRotate(int r4) {
        this.b = Integer.valueOf(r4);
        this.d.append("sensor to " + b(Integer.valueOf(r4)) + "\n");
    }

    public final void onActivityReqOrientationChanged(int r12) {
        if (((Boolean) this.i.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        StringBuilder r0 = this.d;
        StringBuilder r1 = new StringBuilder("请求activity旋转至 ");
        Integer r13 = Integer.valueOf(r12);
        if (r13 != null) goto L9;
    L11:
        if (r13 != null) goto L14;
    L16:
        if (r13 != null) goto L19;
    L21:
        if (r13 != null) goto L24;
    L26:
        if (r13 != null) goto L29;
    L31:
        if (r13 != null) goto L34;
    L36:
        if (r13 != null) goto L39;
    L41:
        if (r13 != null) goto L44;
    L46:
        if (r13 != null) goto L49;
    L51:
        if (r13 != null) goto L54;
    L56:
        if (r13 != null) goto L59;
    L61:
        if (r13 != null) goto L64;
    L66:
        if (r13 != null) goto L69;
    L71:
        if (r13 != null) goto L74;
    L76:
        if (r13 != null) goto L79;
    L81:
        if (r13 != null) goto L84;
    L86:
        String r14 = "unknown";
    L87:
        r1.append(r14);
        r1.append('\n');
        r0.append(r1.toString());
        boolean r15 = c(true);
        if (this.c != null) goto L135;
        Integer r2 = this.b;
        if (r2 != null) goto L93;
    L94:
        this.j = true;
        this.d.append("【error】未经过直播转屏处理直接调用activity api进行转屏\n");
        if (r15 == true) goto L135;
        Integer r16 = Integer.valueOf(((Number) this.h.getValue()).intValue());
        StringBuilder r3 = new StringBuilder();
        StackTraceElement[] r6 = ThreadMethodProxy.currentThread().getStackTrace();     // Catch: Exception -> L101
        int r7 = r6.length;     // Catch: Exception -> L101
        int r8 = 0;
    L98:
        if (r8 >= r7) goto L103;
        StackTraceElement r9 = r6[r8];     // Catch: Exception -> L101
        r3.append(r9.getClassName());     // Catch: Exception -> L101
        r3.append(".");     // Catch: Exception -> L101
        r3.append(r9.getMethodName());     // Catch: Exception -> L101
        r3.append("(");     // Catch: Exception -> L101
        r3.append(r9.getFileName());     // Catch: Exception -> L101
        r3.append(":");     // Catch: Exception -> L101
        r3.append(r9.getLineNumber());     // Catch: Exception -> L101
        r3.append(")\n");     // Catch: Exception -> L101
        r8 = r8 + 1;
    L103:
        if (r16 != null) goto L105;
    L114:
        String r17 = r3.toString();
    L115:
        this.d.append("堆栈信息：" + r17 + "\n\n");
        Pair[] r18 = new Pair[3];
        z71.a r4 = a();
        String r5 = "";
        if (r4 == null) goto L123;
        DataCenter r10 = r4.getDataCenter();
        if (r10 == null) goto L123;
        Room r19 = z.o(r10);
        if (r19 == null) goto L123;
        String r20 = String.valueOf(r19.getRoomId());
        if (r20 == null) goto L123;
    L124:
        r18[0] = TuplesKt.to("room_id", r20);
        z71.a r22 = a();
        if (r22 == null) goto L134;
        DataCenter r23 = r22.getDataCenter();
        if (r23 == null) goto L134;
        Room r24 = z.o(r23);
        if (r24 == null) goto L134;
        String r25 = r24.getOwnerUserIdString();
        if (r25 == null) goto L134;
        r5 = r25;
    L134:
        r18[1] = TuplesKt.to("anchor_id", r5);
        r18[2] = TuplesKt.to(Constants.OperatorKey.MSG, this.d.toString());
        u.l().sendLog("livesdk_screen_rotate_monitor_rotate_directly", MapsKt.mapOf(r18), new Object[]{Room.class, x.class});
    L123:
        r20 = "";
        goto L124
    L105:
        if (r3.length() <= r16.intValue()) goto L107;
        boolean r26 = true;
    L108:
        if (r26 == true) goto L111;
        r16 = null;
    L111:
        if (r16 == null) goto L114;
        r17 = r3.substring(0, r16.intValue());
        if (r17 != null) goto L115;
    L107:
        r26 = false;
    L101:
        e = move-exception;
        ALogger.e("LiveScreenRotateMonitor", e);
        goto L103
    L93:
        if (r2.intValue() != 2) goto L94;
    L135:
        this.b = null;
        this.c = null;
        return;
    L84:
        if (r13.intValue() != 14) goto L86;
        r14 = "locked";
        goto L87
    L79:
        if (r13.intValue() != 13) goto L81;
        r14 = "full_user";
        goto L87
    L74:
        if (r13.intValue() != 12) goto L76;
        r14 = "user_portrait";
        goto L87
    L69:
        if (r13.intValue() != 11) goto L71;
        r14 = "user_landscape";
        goto L87
    L64:
        if (r13.intValue() != 10) goto L66;
        r14 = "full_sensor";
        goto L87
    L59:
        if (r13.intValue() != 9) goto L61;
        r14 = "reverse_portrait";
        goto L87
    L54:
        if (r13.intValue() != 8) goto L56;
        r14 = "reverse_landscape";
        goto L87
    L49:
        if (r13.intValue() != 7) goto L51;
        r14 = "sensor_portrait";
        goto L87
    L44:
        if (r13.intValue() != 6) goto L46;
        r14 = "sensor_landscape";
        goto L87
    L39:
        if (r13.intValue() != 5) goto L41;
        r14 = "nosensor";
        goto L87
    L34:
        if (r13.intValue() != 4) goto L36;
        r14 = "sensor";
        goto L87
    L29:
        if (r13.intValue() != 3) goto L31;
        r14 = "behind";
        goto L87
    L24:
        if (r13.intValue() != 2) goto L26;
        r14 = "user";
        goto L87
    L19:
        if (r13.intValue() != 1) goto L21;
        r14 = "portrait";
        goto L87
    L14:
        if (r13.intValue() != 0) goto L16;
        r14 = "landscape";
        goto L87
    L9:
        if (r13.intValue() != (-1)) goto L11;
        r14 = "unspecified";
        goto L87
    }

    public final void onConfigurationChanged(Configuration r6) {
        Intrinsics.checkNotNullParameter(r6, "newConfig");
        int r7 = r6.orientation;
        if (this.a == r7) goto L27;
        StringBuilder r0 = this.d;
        StringBuilder r1 = new StringBuilder("onConfigurationChanged回调，屏幕方向为：");
        Integer r2 = Integer.valueOf(r7);
        if (r2 != null) goto L8;
    L10:
        if (r2 != null) goto L13;
    L15:
        if (r2 != null) goto L18;
    L20:
        if (r2 != null) goto L23;
    L25:
        String r3 = "unknown";
    L26:
        r1.append(r3);
        r1.append('\n');
        r0.append(r1.toString());
        goto L27
    L23:
        if (r2.intValue() != 3) goto L25;
        r3 = "square";
        goto L26
    L18:
        if (r2.intValue() != 2) goto L20;
        r3 = "横屏";
        goto L26
    L13:
        if (r2.intValue() != 1) goto L15;
        r3 = "竖屏";
        goto L26
    L8:
        if (r2.intValue() != 0) goto L10;
        r3 = "undefined";
    L27:
        this.a = r7;
    }

    public final void markHandledRotateEvent(int r3, String r4) {
        this.c = Integer.valueOf(r3);
        this.d.append("处理直播转屏事件：".concat(b(Integer.valueOf(r3))));
        if (r4 != null) goto L5;
    L12:
        this.d.append("\n");
        return;
    L5:
        if (k81.c.b(r4) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L12;
        String r5 = "，来源：".concat(r4);
        if (r5 == null) goto L12;
        this.d.append(r5);
        goto L12
    }
}
