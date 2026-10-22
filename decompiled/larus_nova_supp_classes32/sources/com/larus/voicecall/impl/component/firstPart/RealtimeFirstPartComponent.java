package com.larus.voicecall.impl.component.firstPart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.im.service.audio.z0;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g1;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.larus.platform.service.i2;
import com.larus.platform.service.l1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.CommandType;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.a3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import pf9.p;
import pf9.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020/H\u0016J\b\u00102\u001a\u00020/H\u0016J\u0010\u00103\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020/H\u0002J\u0010\u00107\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020/2\u0006\u00108\u001a\u00020;H\u0002J\u0012\u0010<\u001a\u00020/2\b\u0010=\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010>\u001a\u00020/2\u0006\u0010=\u001a\u00020 H\u0002J\b\u0010?\u001a\u00020/H\u0002J\b\u0010@\u001a\u00020/H\u0002J\u0012\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020\"H\u0002J\u0018\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020/H\u0002J\b\u0010H\u001a\u00020/H\u0002J\b\u0010I\u001a\u00020JH\u0002J\u0012\u0010K\u001a\u00020/2\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\u0010\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020/H\u0002J\b\u0010R\u001a\u00020/H\u0016J\b\u0010S\u001a\u00020MH\u0002J\u0006\u0010T\u001a\u00020\"R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\n\u001a\u0004\b'\u0010(R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/larus/voicecall/impl/component/firstPart/RealtimeFirstPartComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/firstPart/IRealtimeFirstPartAbility;", "<init>", "()V", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "vlmAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "getVlmAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "vlmAbility$delegate", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "pendingCommandType", "Lcom/larus/voicecall/api/bean/CommandType;", "isCommandFromBg", NameKeys.UnloadStrategy_No_Strategy, "goSettingDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "douyinAuthService", "Lcom/larus/bmhome/auth/douyin/IAiChatOpenDouyinAuthService;", "getDouyinAuthService", "()Lcom/larus/bmhome/auth/douyin/IAiChatOpenDouyinAuthService;", "douyinAuthService$delegate", "localLifeAuthResultHandler", "Lcom/larus/bmhome/auth/douyin/IAiChatDouyinAuthResultHandler;", "musicAuthResultHandler", "Lcom/larus/platform/api/IAiChatRequestMusicListAuthResultCallback;", "onAppBackground", NameKeys.UnloadStrategy_No_Strategy, "onAppForeground", "onAttach", "onVContextReady", "onViewCreated", "view", "Landroid/view/View;", "observePluginAuthMessage", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "onCommandReplyEvent", "Lcom/larus/im/service/audio/event/FlowLLMCommandReplyEvent;", "handleCommandReplyItem", "commandType", "showAuthDialog", "initLocalLifeAuthResultHandler", "initMusicAuthResultHandler", "checkAndShowLocationAuthDialog", "isFromBg", "handleRequestForegroundPermission", "isGranted", "currentActivity", "Landroidx/fragment/app/FragmentActivity;", "sendLocationAuthFailTrigger", "tryRequestLocationAuthMessage", "getLocationPermissionTraceInfo", "Lorg/json/JSONObject;", "sendLocationAuthSuccessTrigger", "questionId", NameKeys.UnloadStrategy_No_Strategy, "onConnectionStateChanged", "state", "Lcom/larus/im/internal/audio/context/SessionState;", "updateLocationContext", "onDestroy", "getCurrentCallBackgroundMode", "isNotificationPermissionGranted", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeFirstPartComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.firstPart.a {
    public static final /* synthetic */ int y = 0;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public CommandType s;
    public boolean t;
    public CommonDialog u;
    public final Lazy v;
    public m w;
    public n x;

    public static final class a {
    }

    public static final class b implements p0 {
        public final /* synthetic */ FragmentActivity a;

        public final void confirm() {
            Intent r0 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            r0.addFlags(268435456);
            this.a.startActivity(r0);
        }

        public b(FragmentActivity r1) {
            this.a = r1;
        }
    }

    public static final class c implements g1.c {
        public final /* synthetic */ RealtimeFirstPartComponent a;
        public final /* synthetic */ FragmentActivity b;

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogDismiss(boolean r4) {
            FLogger.a.i("RealtimeFirstPartComponent", "Request ForegroundPermission onGoSettingsDialogDismiss: isConfirmed = " + r4);
            if (r4 == true) goto L6;
            RealtimeFirstPartComponent.h3(this.a, false, this.b);
            return;
        }

        public c(RealtimeFirstPartComponent r1, FragmentActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onResult(boolean r3, List<String> r4, List<String> r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "grantedList");
            Intrinsics.checkNotNullParameter(r5, "deniedList");
            FLogger.a.i("RealtimeFirstPartComponent", "Request ForegroundPermission onResult: allGranted = " + r3 + ", isGoSettingsDialogShown = " + r6 + ", grantedList = " + r4);
            if (r6 == true) goto L6;
            RealtimeFirstPartComponent.h3(this.a, r3, this.b);
            return;
        }
    }

    public static final class d implements a3 {
        public final /* synthetic */ String a;
        public final /* synthetic */ RealtimeFirstPartComponent b;

        public d(String r1, RealtimeFirstPartComponent r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(LocationResult r2, Integer r3, GeoLocationInfo r4) {
            Intrinsics.checkNotNullParameter(r2, LynxResourceModule.CODE_KEY);
            FLogger.a.i("RealtimeFirstPartComponent", "sendLocationAuthSuccessTrigger, after locate, code=" + r2 + ' ');
            if (r2 != LocationResult.SUCCESS) goto L12;
            JSONObject r5 = new JSONObject();
            String r6 = "1";
            r5.put("vui_auth_location", "1");
            r5.put("vui_auth_question_id", this.a);
            if (AppHost.a.a().isAppBackground() == true) goto L8;
            r6 = "0";
        L8:
            r5.put("is_app_background", r6);
            RealtimeCallUtil.a.getClass();
            r5.put("location_permission", String.valueOf(RealtimeCallUtil.n()));
            RealtimeFirstPartComponent r7 = this.b;
            int r8 = RealtimeFirstPartComponent.y;
            com.larus.voicecall.impl.component.core.a r9 = r7.p3();
            if (r9 == null) goto L13;
            r9.ft(r5.toString());
            return;
        L13:
            return;
        }
    }

    static {
    }

    public final void A0() {
        e3a.a r0 = (e3a.a) this.n.getValue();
        p3();
        com.larus.voicecall.impl.component.vlm.b r1 = (com.larus.voicecall.impl.component.vlm.b) this.q.getValue();
        e3a.b r2 = (e3a.b) this.o.getValue();
    }

    public final void D3() {
        FLogger.a.i("RealtimeFirstPartComponent", "updateLocationContext in RealtimeFirstPartComponent");
        com.larus.voicecall.impl.component.core.a r0 = p3();
        if (r0 == null) goto L6;
        r0.oo();
        return;
    }

    public final com.larus.voicecall.impl.component.core.a p3() {
        return (com.larus.voicecall.impl.component.core.a) this.p.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.firstPart.a.class);
    }

    public final IAiChatOpenDouyinAuthService z3() {
        return (IAiChatOpenDouyinAuthService) this.v.getValue();
    }

    public RealtimeFirstPartComponent() {
        this.n = LazyKt.lazy(new com.larus.voicecall.impl.component.firstPart.b(this));
        this.o = LazyKt.lazy(new com.larus.voicecall.impl.component.firstPart.d(this));
        this.p = LazyKt.lazy(new e(this));
        this.q = LazyKt.lazy(new f(this));
        this.r = LazyKt.lazy(new g());
        this.v = LazyKt.lazy(new h());
    }

    public final void onAppForeground() {
        D3();
        CommandType r0 = this.s;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.t == false) goto L14;
        this.t = false;
        if (r0.getCommandType() != 6) goto L10;
        C3(r0);
        return;
    L10:
        if (r0.getCommandType() != 9) goto L16;
        t0.a.post(new j(this));
        return;
    L16:
        return;
    }

    public final void onDestroy() {
        IAiChatOpenDouyinAuthService r0 = z3();
        if (r0 == null) goto L5;
        r0.m(this.w);
    L5:
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L9;
        r1.K0();
        com.larus.music.i.a.i(this.x);
        return;
    }

    public final void onAppBackground() {
        D3();
    }

    public final void B3(String r4) {
        D3();
        FLogger.a.i("RealtimeFirstPartComponent", "sendLocationAuthSuccessTrigger, before locate ");
        l1.a.a(LocateScene.REALTIME_CALL_VIDEO_CMD, new d(r4, this));
    }

    public final void C3(CommandType r5) {
        final ChatParam r6 = r5.getParam();
        if (r6 == null) goto L28;
        final String r0 = r6.getPluginId();
        if (r0 != null) goto L8;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        if (o0.d(r6.getPopupText()) == true) goto L10;
        return;
    L10:
        if (o0.d(r6.getJumpUrl()) == true) goto L12;
        return;
    L12:
        if (o0.d(r6.getQuestionId()) == true) goto L14;
        return;
    L14:
        if (this.w != null) goto L17;
        this.w = new m(this);
    L17:
        if (this.x != null) goto L21;
        this.x = new n(this);
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L21;
        r1.K0();
        com.larus.music.i.a.d(this.x);
    L21:
        IAiChatOpenDouyinAuthService r2 = z3();
        if (r2 == null) goto L25;
        r2.j(this.w);
    L25:
        if (r6.getPopupText() == null) goto L32;
        t0.d(new k(this, r6, r0), 100);
        return;
    L32:
        return;
    }

    public final void D9(z0.a r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if ((r6 instanceof q) == false) goto L35;
        Iterator r7 = ((q) r6).a.iterator();
    L6:
        if (r7.hasNext() == false) goto L55;
        p r0 = (p) r7.next();
        CommandType r1 = new CommandType();
        Long r2 = r0.a;
        if (r2 == null) goto L10;
        int r3 = (int) r2.longValue();
    L11:
        r1.setCommandType(r3);
        JSONObject r4 = new JSONObject();
        Map r5 = r0.b;
        if (r5 == null) goto L17;
        Iterator r8 = r5.entrySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L17;
        Map.Entry r9 = (Map.Entry) r8.next();
        r4.putOpt((String) r9.getKey(), r9.getValue());
    L17:
        r1.setParam((ChatParam) GsonProtectorUtils.fromJson((Gson) this.r.getValue(), r4.toString(), ChatParam.class));
        int r10 = r1.getCommandType();
        if (r10 != 6) goto L19;
        this.s = r1;
        if (AppHost.a.a().isAppBackground() == false) goto L33;
        this.t = true;
        goto L6
    L33:
        C3(r1);
        this.t = false;
        goto L6
    L19:
        String r11 = null;
        switch(r10) {
            case 9: goto L27;
            case 10: goto L26;
            case 11: goto L22;
            default: goto L6;
        };
    L22:
        this.s = r1;
        ChatParam r12 = r1.getParam();
        if (r12 == null) goto L25;
        r11 = r12.getQuestionId();
    L25:
        B3(r11);
        goto L6
    L26:
        l1.a.a(LocateScene.VUI_CMD, null);
        goto L6
    L27:
        this.s = r1;
        if (AppHost.a.a().isAppBackground() == true) goto L29;
        this.t = false;
        t0.a.post(new com.larus.voicecall.impl.component.firstPart.c(this));
        goto L6
    L29:
        this.t = true;
        goto L6
    L10:
        r3 = -1;
        goto L11
    L55:
        return;
    }

    public final void I6(jd9.c r7) {
        Intrinsics.checkNotNullParameter(r7, "state");
        if ((r7 instanceof jd9.c.a) == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), Dispatchers.getIO(), null, new RealtimeFirstPartComponent$onConnectionStateChanged$1(this, null), 2, null);
        return;
    }

    public final void m3(boolean r10) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isFinishing() == true) goto L54;
        RealtimeCallUtil.a.getClass();
        String r2 = null;
        boolean r3 = false;
        boolean r4 = true;
        if (RealtimeCallUtil.b() == true) goto L19;
        FLogger r11 = FLogger.a;
        StringBuilder r0 = new StringBuilder("The gps is not open, is setting dialog null: ");
        if (this.u == null) goto L12;
        r4 = false;
    L12:
        r0.append(r4);
        r11.i("RealtimeFirstPartComponent", r0.toString());
        if (this.u != null) goto L55;
        CommonDialog.a r12 = new CommonDialog.a();
        int r5 = j0.a;
        r12.i(j0.d(2131898616));
        r12.g(j0.d(2131898615));
        CommonDialog.a.f(r12, new b(r1), null, false, 14);
        DialogInterface.OnDismissListener r6 = new l(this);
        Intrinsics.checkNotNullParameter(r6, "listener");
        r12.x = r6;
        CommonDialog r13 = r12.a();
        this.u = r13;
        FragmentManager r7 = r1.getSupportFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, null, r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r13, r8) == true) goto L58;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
    L18:
        r13.show(r7, null);
        return;
    L58:
        return;
    L55:
        return;
    L19:
        Intrinsics.checkNotNullParameter(r1, "context");
        if (ContextCompat.checkSelfPermission(r1, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L22;
    L24:
        boolean r9 = false;
    L25:
        if (r9 == false) goto L32;
        FLogger.a.i("RealtimeFirstPartComponent", "The foreground permission is granted, sdkInt=" + Build.VERSION.SDK_INT + ", isFromBg=" + r10);
        CommandType r14 = this.s;
        if (r14 == null) goto L31;
        ChatParam r15 = r14.getParam();
        if (r15 == null) goto L31;
        r2 = r15.getQuestionId();
    L31:
        B3(r2);
        return;
    L32:
        FLogger.a.i("RealtimeFirstPartComponent", "Request foreground location permission");
        List r16 = CollectionsKt.mutableListOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        i2 r17 = i2.b;
        c r18 = new c(this, r1);
        JSONObject r19 = new JSONObject();
        r19.put("trigger_from", "query");
        r19.put("auth_type", "foreground");
        CommandType r20 = this.s;
        if (r20 == null) goto L37;
        ChatParam r21 = r20.getParam();
        if (r21 == null) goto L37;
        r2 = r21.getQuestionId();
    L37:
        r19.put("message_id", r2);
        com.larus.voicecall.impl.component.vlm.b r22 = (com.larus.voicecall.impl.component.vlm.b) this.q.getValue();
        if (r22 != null) goto L40;
    L42:
        if (r3 == false) goto L45;
        String r23 = "video_call";
    L48:
        r19.put("call_background_mode", r23);
        Unit r24 = Unit.INSTANCE;
        g1.a.b(r1, r16, r18, null, r19, 40);
        return;
    L45:
        if (((h88.b) ((e3a.b) this.o.getValue())).t == false) goto L47;
        r23 = "screen_share";
        goto L48
    L47:
        r23 = NameKeys.UnloadStrategy_No_Strategy;
        goto L48
    L40:
        if (r22.D5() != true) goto L42;
        r3 = true;
        goto L42
    L22:
        if (ContextCompat.checkSelfPermission(r1, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L24;
        r9 = true;
        goto L25
    }

    public final void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        IAiChatOpenDouyinAuthService r4 = z3();
        if (r4 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r4.o(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new i(this));
        return;
    }

    public static final void h3(RealtimeFirstPartComponent r25, boolean r26, FragmentActivity r27) {
        r25.getClass();
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("Request foreground location permission， isGranted=");
        r3.append(r26);
        r3.append(", isRationale=");
        boolean r5 = false;
        String r8 = null;
        if (Build.VERSION.SDK_INT < 23) goto L24;
        ArrayList r4 = new ArrayList();
        String r15 = "android.permission.ACCESS_COARSE_LOCATION";
        Object[] r7 = {"android.permission.ACCESS_COARSE_LOCATION"};
        f06.b r14 = new f06.b("auto_cert_com_larus_voicecall_impl_component_firstPart_RealtimeFirstPartComponent_androidx_fragment_app_FragmentActivity_shouldShowRequestPermissionRationale");
        g06.a r9 = (g06.a) ApiHookConfig.b.get(102609);
        if (r9 == null) goto L7;
        f06.a[] r10 = r9.i;
    L8:
        f06.a[] r13 = r10;
        int r12 = r13.length;
        int r11 = 0;
    L10:
        if (r11 >= r12) goto L17;
        f06.a r16 = r13[r11];
        int r21 = r11;
        int r22 = r12;
        f06.a[] r23 = r13;
        f06.b r24 = r14;
        String r6 = r15;
        f06.d r17 = r16.preInvoke(102609, "androidx/fragment/app/FragmentActivity", "shouldShowRequestPermissionRationale", r27, r7, "boolean", r24);     // Catch: Exception -> L66
        if (r17.a == true) goto L19;
        r4.add(r16);     // Catch: Exception -> L66
    L19:
        if (r17.a == false) goto L21;
        boolean r18 = ((Boolean) r17.b).booleanValue();
    L22:
        if (r18 == false) goto L24;
        boolean r19 = true;
    L25:
        r3.append(r19);
        r2.i("RealtimeFirstPartComponent", r3.toString());
        if (r26 == false) goto L33;
        CommandType r1 = r25.s;
        if (r1 == null) goto L32;
        ChatParam r20 = r1.getParam();
        if (r20 == null) goto L32;
        r8 = r20.getQuestionId();
    L32:
        r25.B3(r8);
        return;
    L33:
        JSONObject r28 = new JSONObject();
        CommandType r29 = r25.s;
        if (r29 == null) goto L39;
        ChatParam r30 = r29.getParam();
        if (r30 == null) goto L39;
        String r31 = r30.getRefuseText();
        if (r31 == null) goto L39;
    L40:
        r28.put("vui_auth_refuse_text", r31);
        r28.put("scene", "location");
        RealtimeCallUtil.a.getClass();
        r28.put("location_permission", String.valueOf(RealtimeCallUtil.n()));
        JSONObject r32 = new JSONObject();
        if (Build.VERSION.SDK_INT >= 33) goto L43;
        r5 = NotificationManagerCompat.from(AppHost.a.getApplication()).areNotificationsEnabled();
    L46:
        String r33 = "1";
        if (r5 == false) goto L49;
        Object r34 = "1";
    L50:
        r32.put("notification", r34);
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.RECORD_AUDIO") == 0) goto L54;
        r33 = "0";
    L54:
        r32.put("microphone", r33);
        Unit r35 = Unit.INSTANCE;
        r28.put("client_system_permission", r32);
        com.larus.voicecall.impl.component.core.a r36 = r25.p3();
        if (r36 == null) goto L57;
        r36.fG(r28.toString());
    L57:
        CommandType r37 = r25.s;
        if (r37 == null) goto L73;
        ChatParam r38 = r37.getParam();
        if (r38 == null) goto L74;
        String r39 = r38.getQuestionId();
        if (r39 == null) goto L75;
        Intrinsics.checkNotNullParameter(r25, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(r25, r25)), Dispatchers.getIO(), null, new RealtimeFirstPartComponent$tryRequestLocationAuthMessage$1(r39, r25, null), 2, null);
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L49:
        r34 = "0";
        goto L50
    L43:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.POST_NOTIFICATIONS") != 0) goto L46;
        r5 = true;
    L39:
        r31 = NameKeys.UnloadStrategy_No_Strategy;
        goto L40
    L21:
        r18 = r27.shouldShowRequestPermissionRationale(r6);
    L16:
        r11 = r21 + 1;
        r15 = r6;
        r12 = r22;
        r13 = r23;
        r14 = r24;
        goto L10
    L17:
        r6 = r15;
        r17 = new f06.d(false, null);
        goto L19
    L7:
        r10 = ApiHookConfig.d;
    L24:
        r19 = false;
        goto L25
    }
}
