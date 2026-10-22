package com.larus.avlink.plugins;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.avlink.model.TimerScene;
import com.larus.avlink.util.PendingAuthType;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.CommandType;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraFirstPartyAuthPlugin extends com.larus.audio.call.arch.a<n4> implements y0 {
    public static final /* synthetic */ int q = 0;
    public final String f;
    public boolean g;
    public CommandType h;
    public v0 i;
    public CommandType j;
    public w0 k;
    public CommonDialog l;
    public volatile boolean m;
    public boolean n;
    public final Lazy o;
    public final b p;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ DoraFirstPartyAuthPlugin a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            this.a.w3(null);
        }

        public final void onAppForeground() {
            this.a.w3(null);
            Lazy r0 = ia8.m.a;
            ia8.m.b(DoraEvent.AppForeground);
            DoraFirstPartyAuthPlugin r1 = this.a;
            CommandType r2 = r1.h;
            if (r2 == null) goto L13;
            if (r1.n == false) goto L13;
            r1.n = false;
            if (r2.getCommandType() != 6) goto L10;
            AppHost.a.a().c(this);
            r1.u3(r2);
            goto L13
        L10:
            if (r2.getCommandType() != 9) goto L13;
            r1.m3(true);
        L13:
            if (this.a.i3() == true) goto L16;
            AppHost.a.a().c(this);
            return;
        }

        public b(DoraFirstPartyAuthPlugin r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ FragmentActivity a;

        public final void confirm() {
            Intent r0 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            r0.addFlags(268435456);
            this.a.startActivity(r0);
        }

        public c(FragmentActivity r1) {
            this.a = r1;
        }
    }

    public static final class d implements DialogInterface.OnDismissListener {
        public final /* synthetic */ DoraFirstPartyAuthPlugin a;

        public d(DoraFirstPartyAuthPlugin r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            this.a.l = null;
        }
    }

    public static final class e implements com.larus.platform.api.g1.c {
        public final /* synthetic */ DoraFirstPartyAuthPlugin a;

        public final void onGoSettingsDialogDismiss(boolean r1) {
        }

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
        }

        public e(DoraFirstPartyAuthPlugin r1) {
            this.a = r1;
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            this.a.getClass();
            this.a.s3(true);
            DoraEvent r6 = DoraEvent.LocPermissionResult;
            r6.setMessage("Loc Permission Result: " + (r2 ? 1 : 0));
            ia8.m.b(r6);
            com.larus.avlink.n1.d(this.a.f, "Has foreground permission. Is background permission granted: " + r2);
            String r7 = null;
            if (this.a.m == true) goto L11;
            DoraFirstPartyAuthPlugin r8 = this.a;
            CommandType r9 = r8.h;
            if (r9 == null) goto L9;
            ChatParam r10 = r9.getParam();
            if (r10 == null) goto L9;
            String r11 = r10.getQuestionId();
        L10:
            r8.r3(1, r11, null);
            return;
        L9:
            r11 = null;
            goto L10
        L11:
            this.a.q3().O();
            DoraFirstPartyAuthPlugin r12 = this.a;
            CommandType r13 = r12.h;
            if (r13 == null) goto L16;
            ChatParam r14 = r13.getParam();
            if (r14 == null) goto L16;
            r7 = r14.getQuestionId();
        L16:
            r12.t3(r7, false);
        }
    }

    public static final class f implements com.larus.platform.api.g1.c {
        public final /* synthetic */ DoraFirstPartyAuthPlugin a;
        public final /* synthetic */ FragmentActivity b;

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogDismiss(boolean r4) {
            com.larus.avlink.n1.d(this.a.f, "Request ForegroundPermission onGoSettingsDialogDismiss: isConfirmed = " + r4);
            if (r4 == true) goto L6;
            DoraFirstPartyAuthPlugin.j3(this.a, false, this.b);
            return;
        }

        public f(DoraFirstPartyAuthPlugin r1, FragmentActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onResult(boolean r3, List<String> r4, List<String> r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "grantedList");
            Intrinsics.checkNotNullParameter(r5, "deniedList");
            com.larus.avlink.n1.d(this.a.f, "Request ForegroundPermission onResult: allGranted = " + r3 + ", isGoSettingsDialogShown = " + r6 + ", grantedList = " + r4);
            if (r6 == true) goto L6;
            DoraFirstPartyAuthPlugin.j3(this.a, r3, this.b);
            return;
        }
    }

    public static final class g implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ DoraFirstPartyAuthPlugin b;

        public final String getName() {
            return this.a;
        }

        public g(DoraFirstPartyAuthPlugin r1) {
            this.b = r1;
            this.a = r1.f;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.avlink.plugins.u0, java.lang.Object] */
        public final void O1(jd9.c r3, jd9.c r4) {
            Intrinsics.checkNotNullParameter(r3, "oldState");
            Intrinsics.checkNotNullParameter(r4, "newState");
            if ((r4 instanceof jd9.c.a) == false) goto L8;
            boolean r5 = ia8.c.a;
            final DoraFirstPartyAuthPlugin r6 = this.b;
            ?? r7 = new u0(r6);
            Intrinsics.checkNotNullParameter(r7, "sendTrigger");
            com.larus.avlink.n1.b("AuthorizationDelegate", "reSendAuthorizationTrigger enter");
            if (ia8.c.a == false) goto L9;
            ia8.c.a = false;
            com.larus.avlink.n1.b("AuthorizationDelegate", "reSendAuthorizationTrigger: real send, type: " + ia8.c.c);
            r7.invoke(Integer.valueOf(ia8.c.c), ia8.c.d, ia8.c.e);
            return;
        L9:
            return;
        }
    }

    public static final class h extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ DoraFirstPartyAuthPlugin b;

        public final String g() {
            return this.a;
        }

        public h(DoraFirstPartyAuthPlugin r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(com.larus.im.service.audio.z0.a r8) {
            Intrinsics.checkNotNullParameter(r8, "event");
            Intrinsics.checkNotNullParameter(r8, "event");
            if ((r8 instanceof pf9.q) == false) goto L28;
            DoraFirstPartyAuthPlugin r0 = this.b;
            r0.getClass();
            List r9 = ((pf9.q) r8).a;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
            Iterator r10 = r9.iterator();
        L6:
            if (r10.hasNext() == false) goto L38;
            pf9.p r2 = (pf9.p) r10.next();
            Long r3 = r2.a;
            if (r3 == null) goto L27;
            int r4 = (int) r3.longValue();
            if (r4 == 6) goto L23;
            String r5 = null;
            switch(r4) {
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L14;
                default: goto L27;
            };
        L14:
            r0.q3().O();
            Map r6 = r2.b;
            if (r6 == null) goto L17;
            r5 = (String) r6.get("vui_auth_question_id");
        L17:
            r0.t3(r5, false);
            goto L27
        L18:
            com.larus.platform.service.l1.a.a(LocateScene.VUI_CMD, null);
            goto L27
        L19:
            r0.h = DoraFirstPartyAuthPlugin.l3(r2);
            AppHost.Companion r7 = AppHost.a;
            if (r7.a().isAppBackground() == false) goto L22;
            r0.n = true;
            r0.g = true;
            r7.a().j(r0.p);
            goto L27
        L22:
            r0.n = false;
            r0.g = false;
            r0.m3(false);
            goto L27
        L23:
            r0.h = DoraFirstPartyAuthPlugin.l3(r2);
            AppHost.Companion r11 = AppHost.a;
            if (r11.a().isAppBackground() == false) goto L26;
            r11.a().j(r0.p);
            r0.g = true;
            r0.n = true;
            goto L27
        L26:
            r0.u3(DoraFirstPartyAuthPlugin.l3(r2));
            r0.n = false;
            r0.g = false;
        L27:
            r1.add(r2);
            goto L6
        L38:
            return;
        }
    }

    public static final class i implements hq9.a3 {
        public final /* synthetic */ DoraFirstPartyAuthPlugin a;
        public final /* synthetic */ String b;

        public i(DoraFirstPartyAuthPlugin r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(LocationResult r2, Integer r3, GeoLocationInfo r4) {
            Intrinsics.checkNotNullParameter(r2, "code");
            com.larus.avlink.n1.d(this.a.f, "sendLocationAuthSuccessTrigger, after locate, code=" + r2 + ' ');
            if (r2 != LocationResult.SUCCESS) goto L13;
            JSONObject r5 = new JSONObject();
            String r6 = "1";
            r5.put("vui_auth_location", "1");
            r5.put("vui_auth_question_id", this.b);
            if (AppHost.a.a().isAppBackground() == true) goto L8;
            r6 = "0";
        L8:
            r5.put("is_app_background", r6);
            RealtimeCallUtil.a.getClass();
            r5.put("location_permission", String.valueOf(RealtimeCallUtil.n()));
            id9.d r7 = ((n4) this.a.getContext()).j();
            if (r7 == null) goto L11;
            r7.p(TriggerMode.AUTH_SUCCESS, r5.toString());
        L11:
            ((n4) this.a.getContext()).a().a1(new MajorState.i(), this.a.f);
            ((n4) this.a.getContext()).a().n2(StateTriggerEvent.RequestThinking.a);
            return;
        }
    }

    static {
    }

    public final com.larus.im.service.audio.v R2() {
        return new g(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new h(this);
    }

    public final IAiChatOpenDouyinAuthService o3() {
        return (IAiChatOpenDouyinAuthService) this.o.getValue();
    }

    public final JSONObject p3() {
        CommandType r0 = this.h;
        if (r0 == null) goto L17;
        ChatParam r1 = r0.getParam();
        if (r1 == null) goto L17;
        String r2 = r1.getFpaCommonParams();
        if (r2 == null) goto L17;
        String r3 = new JSONObject(r2).optString("location_trace_info");     // Catch: JSONException -> L13
        Intrinsics.checkNotNull(r3);     // Catch: JSONException -> L13
        if ((!StringsKt.isBlank(r3)) == false) goto L12;
        JSONObject r4 = new JSONObject(r3);     // Catch: JSONException -> L13
    L15:
        if (r4 == null) goto L17;
        return r4;
    L12:
        r4 = null;
    L13:
        e = move-exception;
        com.larus.avlink.n1.c(this.f, "plugin_scene error", e);
        r4 = new JSONObject();
    L17:
        return new JSONObject();
    }

    @Override // com.larus.avlink.plugins.y0
    public final void stop() {
        if (this.g == false) goto L13;
        CommandType r0 = this.h;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        s3(false);
        return;
    L14:
        return;
    L7:
        if (r0.getCommandType() != 9) goto L9;
        r1 = true;
        goto L10
    }

    public final void v3() {
        if (this.g == false) goto L6;
        com.larus.avlink.n1.d(this.f, "hasPendingCommand do not unregisterAuthListener");
        return;
    L6:
        com.larus.avlink.n1.d(this.f, "unregisterAuthListener");
        IAiChatOpenDouyinAuthService r0 = o3();
        if (r0 == null) goto L9;
        r0.m(this.i);
    L9:
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L12;
        r1.K0();
        com.larus.music.i.a.i(this.k);
    L12:
        AppHost.a.a().c(this.p);
    }

    public final void e3() {
        super.e3();
        this.m = true;
        AppHost.a.a().j(this.p);
    }

    public final void g3() {
        super.g3();
        this.m = false;
        boolean r1 = ia8.c.a;
        com.larus.avlink.n1.b("AuthorizationDelegate", "reset");
        if (ia8.c.b == false) goto L5;
        ia8.c.a = false;
        ia8.c.c = 0;
    L5:
        v3();
    }

    public final n3 q3() {
        return (n3) getContext().b(Reflection.getOrCreateKotlinClass(n3.class), null);
    }

    public final String T2() {
        return this.f;
    }

    public DoraFirstPartyAuthPlugin(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraFirstPartyAuthPlugin";
        this.o = LazyKt.lazy(new t0());
        this.p = new b(this);
        if (this.i != null) goto L8;
        this.i = new v0(this);
        IAiChatOpenDouyinAuthService r3 = o3();
        if (r3 == null) goto L8;
        r3.j(this.i);
    L8:
        if (this.k != null) goto L13;
        this.k = new w0(this);
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L14;
        r4.K0();
        com.larus.music.i.a.d(this.k);
        return;
    L14:
        return;
    }

    public static final void k3(DoraFirstPartyAuthPlugin r4) {
        CommandType r0 = r4.h;
        if (r0 == null) goto L10;
        ChatParam r1 = r0.getParam();
        if (r1 == null) goto L10;
        if (r4.m == true) goto L9;
        r4.r3(2, r1.getQuestionId(), r1.getAnswerId());
        return;
    L9:
        r4.getContext().b(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.j.class), null).Y1(((n4) r4.getContext()).params(), r1.getQuestionId(), r1.getAnswerId());
        return;
    L10:
        com.larus.avlink.n1.b(r4.f, "tryReSendQuery, but pendingCommandType is null");
    }

    public static CommandType l3(pf9.p r4) {
        CommandType r0 = new CommandType();
        Long r1 = r4.a;
        if (r1 == null) goto L5;
        int r2 = (int) r1.longValue();
    L6:
        r0.setCommandType(r2);
        JSONObject r3 = new JSONObject();
        Map r5 = r4.b;
        if (r5 == null) goto L12;
        Iterator r6 = r5.entrySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r7 = (Map.Entry) r6.next();
        r3.putOpt((String) r7.getKey(), r7.getValue());
    L12:
        Gson r8 = ha8.a.a;
        r0.setParam((ChatParam) ha8.a.a(r3.toString(), ChatParam.class));
        return r0;
    L5:
        r2 = -1;
        goto L6
    }

    public static boolean n3(FragmentActivity r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {"android.permission.ACCESS_COARSE_LOCATION"};
        f06.b r12 = new f06.b("auto_cert_com_larus_avlink_plugins_DoraFirstPartyAuthPlugin_androidx_fragment_app_FragmentActivity_shouldShowRequestPermissionRationale");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102609);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r16 = r7;
        int r17 = r8;
        f06.a[] r18 = r9;
        f06.d r4 = r6.preInvoke(102609, "androidx/fragment/app/FragmentActivity", "shouldShowRequestPermissionRationale", r19, r1, "boolean", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Boolean) r4.b).booleanValue();
    L21:
        return r19.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION");
    L14:
        r7 = r16 + 1;
        r8 = r17;
        r9 = r18;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final void m3(final boolean r4) {
        x3 r0 = (x3) getContext().c(Reflection.getOrCreateKotlinClass(x3.class), null);
        if (r0 == null) goto L5;
        r0.G(TimerScene.LocationAuthDialog);
    L5:
        this.g = false;
        Runnable r1 = new s0(this, r4);
        if (r4 == false) goto L8;
        long r2 = 600;
    L9:
        com.larus.utils.t0.d(r1, r2);
        return;
    L8:
        r2 = 0;
        goto L9
    }

    public final void s3(boolean r5) {
        boolean r0 = i3();
        com.larus.avlink.n1.d(this.f, "reportLocationDialogShowEvent: taskId=" + ((n4) getContext()).params().l.a + ", sessionValid=" + r0);
        JSONObject r1 = new JSONObject();
        r1.put("task_id", ((n4) getContext()).params().l.a);
        r1.put("is_session_valid", r0 ? 1 : 0);
        r1.put("has_request_permission", r5 ? 1 : 0);
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r2 = new by7.a("flow_vui_loc_permission_dialog_show");
        r2.a.merge(r6);
        r2.b();
    }

    public final void u3(CommandType r10) {
        x3 r0 = (x3) getContext().c(Reflection.getOrCreateKotlinClass(x3.class), null);
        if (r0 == null) goto L5;
        r0.G(TimerScene.AuthDialog);
    L5:
        this.j = r10;
        ChatParam r11 = r10.getParam();
        if (r11 == null) goto L20;
        String r1 = r11.getPluginId();
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        if (com.larus.utils.o0.d(r11.getPopupText()) == true) goto L13;
        return;
    L13:
        if (com.larus.utils.o0.d(r11.getJumpUrl()) == true) goto L15;
        return;
    L15:
        if (com.larus.utils.o0.d(r11.getQuestionId()) == true) goto L17;
        return;
    L17:
        if (r11.getPopupText() == null) goto L24;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DoraFirstPartyAuthPlugin$showAuthDialog$1$1$1(r11, r1, this, null), 3, null);
        return;
    L24:
        return;
    }

    public final void w3(Map<String, String> r4) {
        com.larus.call_plugins_doubao_common.i r0 = getContext().b(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.i.class), null);
        String r1 = this.f;
        if (r4 != null) goto L5;
        r4 = MapsKt.emptyMap();
    L5:
        r0.r1(r1, r4);
    }

    public final void t3(String r3, boolean r4) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.M() != true) goto L9;
    L10:
        if (r2 == false) goto L13;
        if (r4 == false) goto L13;
        w3(MapsKt.mapOf(TuplesKt.to("high_position_auth_status", "1")));
    L14:
        com.larus.avlink.n1.d(this.f, "sendLocationAuthSuccessTrigger, before locate ");
        com.larus.platform.service.l1.a.a(LocateScene.VUI_CMD, new i(this, r3));
        return;
    L13:
        w3(null);
    L9:
        r2 = false;
        goto L10
    }

    public static final void j3(DoraFirstPartyAuthPlugin r8, boolean r9, FragmentActivity r10) {
        boolean r0 = true;
        r8.s3(true);
        DoraEvent r1 = DoraEvent.LocPermissionResult;
        r1.setMessage("Loc Permission Result: " + (r9 ? 1 : 0));
        ia8.m.b(r1);
        String r2 = r8.f;
        StringBuilder r3 = new StringBuilder("Request foreground location permission， isGranted=");
        r3.append(r9);
        r3.append(", isRationale=");
        int r4 = Build.VERSION.SDK_INT;
        if (r4 >= 23) goto L5;
    L7:
        boolean r6 = false;
    L8:
        r3.append(r6);
        com.larus.avlink.n1.d(r2, r3.toString());
        String r5 = null;
        if (r9 == true) goto L11;
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r11 == null) goto L32;
        DeviceService r12 = r11.device();
        if (r12 == null) goto L32;
        if (r12.M() != true) goto L32;
    L33:
        String r7 = "";
        if (r0 == false) goto L54;
        if (r4 < 23) goto L69;
        JSONObject r13 = new JSONObject();
        CommandType r14 = r8.h;
        if (r14 == null) goto L44;
        ChatParam r15 = r14.getParam();
        if (r15 == null) goto L44;
        String r16 = r15.getRefuseText();
        if (r16 == null) goto L44;
        r7 = r16;
    L44:
        r13.put("vui_auth_refuse_text", r7);
        r13.put("scene", "location");
        CommandType r17 = r8.h;
        if (r17 == null) goto L49;
        ChatParam r18 = r17.getParam();
        if (r18 == null) goto L49;
        String r19 = r18.getQuestionId();
    L50:
        r13.put("vui_auth_question_id", r19);
        r13.put("vui_auth_location", "1");
        id9.d r20 = ((n4) r8.getContext()).j();
        if (r20 == null) goto L53;
        r20.p(TriggerMode.AUTH_DENY, r13.toString());
    L53:
        ((n4) r8.getContext()).a().a1(new MajorState.i(), r8.f);
        ((n4) r8.getContext()).a().n2(StateTriggerEvent.RequestThinking.a);
        r8.w3(MapsKt.mapOf(TuplesKt.to("high_position_auth_status", "2")));
    L49:
        r19 = null;
    L69:
        CommandType r21 = r8.h;
        if (r21 == null) goto L80;
        ChatParam r22 = r21.getParam();
        if (r22 == null) goto L81;
        String r23 = r22.getQuestionId();
        if (r23 == null) goto L82;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DoraFirstPartyAuthPlugin$tryRequestLocationAuthMessage$1(r23, r8, null), 2, null);
        return;
    L82:
        return;
    L81:
        return;
    L80:
        return;
    L54:
        if (r4 < 23) goto L69;
        if (n3(r10) == false) goto L69;
        JSONObject r110 = new JSONObject();
        CommandType r24 = r8.h;
        if (r24 == null) goto L65;
        ChatParam r25 = r24.getParam();
        if (r25 == null) goto L65;
        String r26 = r25.getRefuseText();
        if (r26 == null) goto L65;
        r7 = r26;
    L65:
        r110.put("vui_auth_refuse_text", r7);
        r110.put("scene", "location");
        id9.d r27 = ((n4) r8.getContext()).j();
        if (r27 == null) goto L68;
        r27.p(TriggerMode.AUTH_DENY, r110.toString());
    L68:
        ((n4) r8.getContext()).a().a1(new MajorState.i(), r8.f);
        ((n4) r8.getContext()).a().n2(StateTriggerEvent.RequestThinking.a);
    L32:
        r0 = false;
        goto L33
    L11:
        if (r8.m == true) goto L19;
        com.larus.avlink.n1.d(r8.f, "isGranted = true, !isInSession = true");
        CommandType r28 = r8.h;
        if (r28 == null) goto L17;
        ChatParam r29 = r28.getParam();
        if (r29 == null) goto L17;
        String r30 = r29.getQuestionId();
    L18:
        r8.r3(1, r30, null);
        return;
    L17:
        r30 = null;
        goto L18
    L19:
        com.larus.avlink.n1.d(r8.f, "isGranted = true, !isInSession = false");
        r8.q3().O();
        CommandType r31 = r8.h;
        if (r31 == null) goto L24;
        ChatParam r32 = r31.getParam();
        if (r32 == null) goto L24;
        r5 = r32.getQuestionId();
    L24:
        r8.t3(r5, true);
        return;
    L5:
        if (n3(r10) == false) goto L7;
        r6 = true;
        goto L8
    }

    public final void r3(@PendingAuthType int r3, String r4, String r5) {
        boolean r0 = ia8.c.a;
        com.larus.avlink.n1.b("AuthorizationDelegate", "pendingAuthTrigger");
        ia8.c.a = true;
        ia8.c.c = r3;
        ia8.c.d = r4;
        ia8.c.e = r5;
        Map<Function1<Boolean, Unit>, k4> r6 = x2.a;
        IDoraService r7 = x2.c();
        if (r7 == null) goto L7;
        SessionService r8 = r7.d();
        if (r8 == null) goto L7;
        Integer r9 = Integer.valueOf(r8.n());
    L8:
        if (r9 != null) goto L11;
    L12:
        com.larus.avlink.n1.b("AuthorizationDelegate", "startVUI failed, ret: " + r9);
    L13:
        ia8.c.b = true;
        v3();
        return;
    L11:
        if (r9.intValue() == 0) goto L13;
    L7:
        r9 = null;
        goto L8
    }
}
