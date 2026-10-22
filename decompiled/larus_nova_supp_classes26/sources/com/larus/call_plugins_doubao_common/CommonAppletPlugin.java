package com.larus.call_plugins_doubao_common;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.audio.call.arch.c;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.v;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IVoiceCallService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class CommonAppletPlugin<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> implements i {
    public final String f;
    public CommonAppletPlugin$initAppletPayloadChangeListener$1 g;
    public ConcurrentHashMap<String, String> h;
    public final b i;

    public static final class a implements v {
        public final String a;
        public final /* synthetic */ CommonAppletPlugin<C> b;

        public final String getName() {
            return this.a;
        }

        public a(CommonAppletPlugin<C> r1) {
            this.b = r1;
            this.a = r1.T2();
        }

        public final void O1(jd9.c r4, jd9.c r5) {
            Intrinsics.checkNotNullParameter(r4, "oldState");
            Intrinsics.checkNotNullParameter(r5, "newState");
            FLogger.a.i(this.b.T2(), "onConnectionStateChanged status=" + r5);
            if ((r5 instanceof jd9.c.a) == false) goto L5;
            this.b.k3();
            return;
        L5:
            boolean r6 = r5 instanceof jd9.c.d;
        }
    }

    public static final class b implements e78.b {
        public final /* synthetic */ C a;
        public final /* synthetic */ CommonAppletPlugin<C> b;

        public final void a() {
            CoroutineScope r1 = this.a.r();
            if (r1 == null) goto L6;
            BuildersKt.launch$default(r1, Dispatchers.getIO(), null, new CommonAppletPlugin$musicStreamVolumeChangedListener$1$onVolumeChanged$1(this.a, this.b, null), 2, null);
            return;
        }

        public b(C r1, CommonAppletPlugin<C> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public void j3(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "obj");
    }

    public final v R2() {
        return new a(this);
    }

    public final void b3() {
        AppletPayloadProviderDelegate.a.a(this.g);
        this.g = null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.call_plugins_doubao_common.CommonAppletPlugin$initAppletPayloadChangeListener$1] */
    public final void e3() {
        super.e3();
        AppletPayloadProviderDelegate r0 = AppletPayloadProviderDelegate.a;
        r0.a(this.g);
        ?? r1 = new CommonAppletPlugin$initAppletPayloadChangeListener$1(this);
        this.g = r1;
        r0.c(r1);
        GlobalAudioController.a.k(this.i);
    }

    public final void g3() {
        super.g3();
        GlobalAudioController.a.n(this.i);
    }

    public void k3() {
        CoroutineScope r1 = getContext().r();
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, Dispatchers.getIO(), null, new CommonAppletPlugin$onSessionStarted$1(this, null), 2, null);
        return;
    }

    public String T2() {
        return this.f;
    }

    public CommonAppletPlugin(C r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "CommonAppletPlugin";
        this.h = new ConcurrentHashMap();
        this.i = new b(r2, this);
    }

    @Override // com.larus.call_plugins_doubao_common.i
    public final void updateScreenshotForAsr(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tosKey");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        JSONObject r1 = new JSONObject();
        r1.put("image_url", r4);
        r1.put("update_nonstream_context_finish", true);
        JSONObject r5 = new JSONObject();
        r5.put("context_data", r1);
        id9.d r2 = getContext().j();
        if (r2 == null) goto L11;
        jd9.c r3 = r2.state();
    L13:
        if ((r3 instanceof jd9.c.a) == false) goto L18;
        id9.d r6 = getContext().j();
        if (r6 == null) goto L19;
        r6.p(TriggerMode.UPDATE_PERSONAL_CONTEXT, r5.toString());
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r3 = null;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.call_plugins_doubao_common.i
    public final void r1(String r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r7, MusicAppletPage.KEY_SOURCE);
        if (r8 != null) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        j3(r0);
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L10;
        Map.Entry<String, String> r1 = r9.next();
        r0.put(r1.getKey(), r1.getValue());
        goto L7
    L10:
        if (AppHost.a.a().isAppBackground() == false) goto L12;
        String r10 = "1";
    L13:
        r0.put("is_app_background", r10);
        IVoiceCallService r11 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        jd9.c r2 = null;
        if (r11 == null) goto L16;
        Integer r12 = Integer.valueOf(r11.N());
    L17:
        r0.put("location_permission", String.valueOf(r12));
        r0.put("obric_launch_method", kga.b.a().a());
        ConcurrentHashMap<String, String> r13 = this.h;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<String> r4 = r0.keys();
    L19:
        if (r4.hasNext() == false) goto L21;
        String r5 = r4.next();
        Intrinsics.checkNotNull(r5);
        r3.put(r5, JSONObjectProtectorUtils.getString(r0, r5));
        goto L19
    L21:
        Map r14 = MapsKt.plus(r13, r3);
        this.h = new ConcurrentHashMap(r14);
        JSONObject r6 = new JSONObject();
        r6.put("applet_payload", new JSONObject(r14));
        FLogger r15 = FLogger.a;
        r15.i(T2(), "updateAppletPayload in " + r7 + " >>>>" + r14);
        String r16 = T2();
        StringBuilder r17 = new StringBuilder("updateContext: ");
        r17.append(r6);
        r15.i(r16, r17.toString());
        id9.d r18 = getContext().j();
        if (r18 == null) goto L25;
        r2 = r18.state();
    L25:
        if ((r2 instanceof jd9.c.a) == false) goto L32;
        id9.d r19 = getContext().j();
        if (r19 == null) goto L33;
        r19.p(TriggerMode.UPDATE_UI_CONTEXT, r6.toString());
        return;
    L33:
        return;
    L32:
        return;
    L16:
        r12 = null;
        goto L17
    L12:
        r10 = TriggerSendLoading.NO_LOADING;
        goto L13
    }
}
