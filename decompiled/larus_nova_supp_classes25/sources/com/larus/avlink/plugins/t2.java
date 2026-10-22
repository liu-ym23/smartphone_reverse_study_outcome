package com.larus.avlink.plugins;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t2 extends com.larus.audio.call.arch.a<n4> {
    public static boolean f;
    public static boolean g;
    public static TriggerMode h;
    public static Map<String, ? extends Object> i;
    public static t2 j;
    public static Map<String, ? extends Object> k;

    public static final class a {
        public static Map a() {
            Activity r0 = AppHost.a.a().getCurrentActivity();
            IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            FLogger r2 = FLogger.a;
            StringBuilder r3 = new StringBuilder("consumeNewcomerGuideStartSessionExtra: pendingTriggerType=");
            r3.append(t2.h);
            r3.append(", param=");
            r3.append(t2.i);
            r3.append("，isOnboarding=");
            if (r1 == null) goto L7;
            com.larus.dora.impl.serviceimpl.t r5 = r1.U();
            if (r5 == null) goto L7;
            Boolean r6 = Boolean.valueOf(r5.b());
        L8:
            r3.append(r6);
            r2.i("DoraPendingTriggerPlugin", r3.toString());
            int r7 = 0;
            if (r1 == null) goto L15;
            com.larus.dora.impl.serviceimpl.t r8 = r1.U();
            if (r8 == null) goto L15;
            if (r8.b() != true) goto L15;
            boolean r9 = true;
        L17:
            if (r9 == true) goto L19;
        L22:
            if (r1 == null) goto L26;
            com.larus.dora.impl.serviceimpl.t r10 = r1.U();
            if (r10 == null) goto L26;
            boolean r11 = r10.a();
        L28:
            if ((r0 instanceof t39.k) == false) goto L40;
            if (r11 == false) goto L40;
            Pair[] r4 = new Pair[3];
            if (r1 == null) goto L34;
            int r12 = r1.W0();
        L35:
            r4[0] = TuplesKt.to("today_wakeup_count", String.valueOf(r12));
            if (r1 == null) goto L38;
            r7 = r1.O();
        L38:
            r4[1] = TuplesKt.to("auto_wakeoff", String.valueOf(r7));
            r4[2] = TuplesKt.to("dora_disable_audio_duplex", Boolean.TRUE);
            return MapsKt.mapOf(r4);
        L34:
            r12 = 0;
        L40:
            StringBuilder r13 = new StringBuilder("consumeNewcomerGuideStartSessionExtra: check failed, isNewOrInactiveUser=");
            r13.append(r11);
            r13.append(", activity=");
            if (r0 == null) goto L43;
            String r14 = r0.getClass().getSimpleName();
        L44:
            r13.append(r14);
            r2.i("DoraPendingTriggerPlugin", r13.toString());
            return null;
        L43:
            r14 = null;
        L26:
            r11 = false;
            goto L28
        L19:
            if (t2.h != TriggerMode.FULL_TEXT_QUERY) goto L22;
            return MapsKt.mapOf(TuplesKt.to("dora_disable_audio_duplex", Boolean.TRUE));
        L15:
            r9 = false;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class b implements com.larus.im.service.audio.v {
        public final /* synthetic */ t2 a;

        public final String getName() {
            return "DoraPendingTriggerPlugin";
        }

        public b(t2 r1) {
            this.a = r1;
            r1.getClass();
        }

        public final void O1(jd9.c r5, jd9.c r6) {
            Intrinsics.checkNotNullParameter(r5, "oldState");
            Intrinsics.checkNotNullParameter(r6, "newState");
            FLogger r7 = FLogger.a;
            this.a.getClass();
            r7.i("DoraPendingTriggerPlugin", "onConnectionStateChanged status=" + r6);
            JSONObject r3 = null;
            if ((r6 instanceof jd9.c.a) == false) goto L23;
            t2 r8 = this.a;
            r8.getClass();
            r7.e("DoraPendingTriggerPlugin", "reSendTrigger enter");
            if (t2.f == false) goto L29;
            t2.f = false;
            r7.e("DoraPendingTriggerPlugin", "reSendTrigger: real send, type: " + t2.h);
            TriggerMode r9 = t2.h;
            if (r9 == null) goto L30;
            r8.getContext().b(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.k.class), null).m1(new s2());
            Map<String, ? extends Object> r10 = t2.i;
            if (r10 == null) goto L15;
            r3 = new JSONObject();
            Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();
        L13:
            if (r11.hasNext() == false) goto L15;
            Map.Entry<String, ? extends Object> r0 = r11.next();
            r3.put(r0.getKey(), r0.getValue());
        L15:
            t2 r12 = t2.j;
            if (r12 == null) goto L31;
            n4 r13 = (n4) r12.getContext();
            if (r13 == null) goto L32;
            id9.d r14 = r13.j();
            if (r14 == null) goto L33;
            r14.p(r9, String.valueOf(r3));
            return;
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L29:
            return;
        L23:
            if ((r6 instanceof jd9.c.d) == false) goto L35;
            this.a.getClass();
            r7.e("DoraPendingTriggerPlugin", "reset");
            if (t2.g == false) goto L36;
            t2.f = false;
            t2.h = null;
            return;
        L36:
            return;
        }
    }

    static {
    }

    public final String T2() {
        return "DoraPendingTriggerPlugin";
    }

    public final com.larus.im.service.audio.v R2() {
        return new b(this);
    }

    public final void e3() {
        super.e3();
        j = this;
    }

    public final void g3() {
        super.g3();
        FLogger.a.e("DoraPendingTriggerPlugin", "reset");
        if (g == false) goto L5;
        f = false;
        h = null;
    L5:
        j = null;
    }

    public t2(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
