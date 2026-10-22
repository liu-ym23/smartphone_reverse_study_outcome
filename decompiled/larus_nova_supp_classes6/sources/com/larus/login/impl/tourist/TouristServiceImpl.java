package com.larus.login.impl.tourist;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.provider.agegate.AgeGateManagerService;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.auth.ILaunchMetricService;
import com.larus.bmhome.auth.LaunchMetricDelegate;
import com.larus.bmhome.auth.h1;
import com.larus.bmhome.auth.i1;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.login.api.ITouristApi;
import com.larus.login.impl.AccountUtils;
import com.larus.network.http.w;
import com.larus.network.http.y;
import com.larus.network.http.z;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.AccountService;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.logger.InteractorReportInitializer;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import t19.s;
import uj9.d;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\bH\u0002J\u001a\u0010'\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020\bH\u0002J\u0010\u0010)\u001a\u00020 2\u0006\u0010&\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\bH\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010&\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020 H\u0016J\u0010\u0010.\u001a\u00020 2\u0006\u0010&\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\bH\u0016J\u0018\u00100\u001a\u00020 2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\bH\u0016J\u001a\u00104\u001a\u00020 2\u0006\u00101\u001a\u0002022\b\u00105\u001a\u0004\u0018\u00010%H\u0016J\b\u00106\u001a\u00020 H\u0002J\u001a\u00107\u001a\u00020 2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\u000eH\u0017J\u001a\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010%H\u0017J\b\u0010A\u001a\u00020 H\u0016J\b\u0010B\u001a\u00020 H\u0016J\b\u0010C\u001a\u00020 H\u0016J\u0018\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020%H\u0016J\u0017\u0010H\u001a\u00020 2\b\u0010=\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010IJ\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00132\u0006\u0010G\u001a\u00020%H\u0082@¢\u0006\u0002\u0010LJ$\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u00132\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%H\u0082@¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020 H\u0016J\u0010\u0010S\u001a\u00020 2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010[\u001a\u00020 2\u0006\u0010\\\u001a\u00020XH\u0016J\u0010\u0010]\u001a\u00020 2\u0006\u0010\\\u001a\u00020XH\u0016J\u0010\u0010^\u001a\u00020 2\u0006\u0010\\\u001a\u00020ZH\u0016J\u0010\u0010_\u001a\u00020 2\u0006\u0010\\\u001a\u00020ZH\u0016J\b\u0010`\u001a\u00020 H\u0016J\b\u0010a\u001a\u00020 H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\b0\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\b0\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020X0WX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0WX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/larus/login/impl/tourist/TouristServiceImpl;", "Lcom/larus/account/base/provider/agegate/IAgeGateResultCallback;", "Lcom/larus/login/api/ITouristApi;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "riskDialogShowed", "", "_launchResult", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "_riskResult", "_ageGateErrorStatus", "", "needSyncFailedMsgWhenLogin", "_launchAndRiskResult", "Landroidx/lifecycle/MediatorLiveData;", "_cvsResult", "Lcom/larus/network/http/Async;", "", "launchAndRiskResult", "Landroidx/lifecycle/LiveData;", "getLaunchAndRiskResult", "()Landroidx/lifecycle/LiveData;", "cvsResult", "getCvsResult", "baseConstrains", "isMessageLimited", "isCreateBotLimited", "isHitTouristMode", "checkAgeGate", "", "trackerJson", "Lorg/json/JSONObject;", "put", "key", "", "value", "getBoolean", "defaultValue", "markMessageLimited", "getMessageLimited", "markCreateBotLimited", "getCreateBotLimited", "revertLimit", "markRisk", "getRisk", "openLogin", "scene", "Lcom/larus/platform/model/TriggerLoginScene;", "forceFullScreenLogin", "openHalfLogin", "deepLinkSchema", "compensateDidIfNeeded", "checkIfShowRiskDialog", "context", "Landroid/content/Context;", "fm", "Landroidx/fragment/app/FragmentManager;", "handleLimitedState", "code", "handleRiskState", "shark", "msg", "onLoginIn", "onLoginOut", "onLoginFail", "requestLaunch", "scope", "Lkotlinx/coroutines/CoroutineScope;", "source", "markAgeGateError", "(Ljava/lang/Long;)V", "fetchLaunchInfoByTourist", "Lcom/larus/bmhome/auth/LaunchInfo;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchConversationInfoByTourist", "Lcom/larus/im/bean/conversation/Conversation;", "conversationId", "botId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPassAgeGateSuccess", "onPassAgeGateFailed", "errorCode", "", "callBackList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/login/api/callback/LoginCallBack;", "panelCallBackList", "Lcom/larus/login/api/callback/LoginPanelCallBack;", "addCallBack", "callBack", "removeCallBack", "addPanelCallBack", "removePanelCallBack", "onPanelOpen", "onPanelClose", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class TouristServiceImpl implements s38.b, ITouristApi {
    public static final /* synthetic */ int k = 0;
    public final Keva a;
    public boolean b;
    public final MutableLiveData<Boolean> c;
    public final MutableLiveData<Boolean> d;
    public boolean e;
    public final MutableLiveData<com.larus.network.http.a<Object>> f;
    public final MediatorLiveData g;
    public final MutableLiveData h;
    public final CopyOnWriteArrayList<tj9.a> i;
    public final CopyOnWriteArrayList<tj9.b> j;

    public static final class a {
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public static void B() {
        IApplog.Companion r0 = IApplog.a;
        String r1 = r0.getDeviceId();
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
    L9:
        r0.u(InteractorReportInitializer.REPORT_EVENT_DELAY_MS, null);
        return;
    L8:
        if (Intrinsics.areEqual(r1, "0") == true) goto L9;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void b() {
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((tj9.b) r0.next()).onClose();
        goto L4
    }

    public final void g() {
        this.a.storeBoolean("key_tourist_message_limited", false);
        this.a.storeBoolean("key_tourist_create_bot_limited", false);
    }

    public final void h() {
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((tj9.b) r0.next()).onOpen();
        goto L4
    }

    public final void j() {
        this.a.storeBoolean("key_tourist_risk", false);
        this.d.setValue(Boolean.FALSE);
        this.b = false;
        this.f.setValue(z.d);
        this.e = true;
        Iterator<tj9.a> r0 = this.i.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a();
        goto L4
    L6:
        this.i.clear();
    }

    public final void l() {
        FLogger r0 = FLogger.a;
        r0.i("TouristManager", "onPassAgeGateSuccess");
        FragmentActivity r2 = AppHost.a.a().getCurrentActivity();
        String r4 = null;
        if ((r2 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r3 = r2;
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.getSupportFragmentManager().getFragments().size() != 0) goto L10;
        return;
    L10:
        Lazy r5 = d.a;
        if (d.d() == true) goto L13;
        IAccountService.a.m();
    L13:
        Fragment r6 = (Fragment) ListProtector.get(r3.getSupportFragmentManager().getFragments(), 0);
        Bundle r7 = r6.getArguments();
        if (r7 == null) goto L16;
        r4 = r7.getString("pending_deeplink_schema");
    L16:
        String r9 = r4;
        if (o0.d(r9) == false) goto L19;
        r0.i("TouristManager", "pass uri from push when route to main page");
    L19:
        AccountUtils r8 = AccountUtils.a;
        Intrinsics.checkNotNull(r6);
        AccountUtils.l(r8, r6, true, false, r9, 4);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void n() {
        this.f.setValue(z.d);
        this.e = false;
        this.a.erase("last_send_msg_of_tourist_mode");
    }

    public final boolean t() {
        return !ILoginService.a.getAccountInfo().a;
    }

    public TouristServiceImpl() {
        Keva r0 = xg9.b.a();
        this.a = r0;
        MutableLiveData<Boolean> r1 = new MutableLiveData(Boolean.FALSE);
        this.c = r1;
        MutableLiveData<Boolean> r2 = new MutableLiveData(Boolean.valueOf(r0.getBoolean("key_tourist_risk", false)));
        this.d = r2;
        new MutableLiveData(null);
        final MediatorLiveData r3 = new MediatorLiveData();
        r3.addSource(r1, new c(new com.larus.login.impl.tourist.a(r3, this)));
        r3.addSource(r2, new c(new b(r3, this)));
        MutableLiveData<com.larus.network.http.a<Object>> r4 = new MutableLiveData(z.d);
        this.f = r4;
        this.g = r3;
        this.h = r4;
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
    }

    public final boolean a() {
        if (t() == true) goto L5;
        return false;
    L5:
        if (this.a.getBoolean("key_tourist_message_limited", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean f() {
        if (t() == false) goto L13;
        i1 r0 = h1.a();
        if (r0 == null) goto L7;
        String r1 = r0.a;
    L9:
        if (o0.d(r1) == false) goto L13;
        String r2 = com.larus.network.http.d.a;
        if (com.larus.network.http.d.e == true) goto L13;
        return true;
    L7:
        r1 = null;
    L13:
        return false;
    }

    public final boolean u() {
        if (t() == true) goto L5;
        return false;
    L5:
        if (this.a.getBoolean("key_tourist_create_bot_limited", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean c() {
        return this.e;
    }

    public final LiveData<Boolean> w() {
        return this.g;
    }

    public final LiveData<com.larus.network.http.a<Object>> y() {
        return this.h;
    }

    public final void A(int r3) {
        FLogger.a.i("TouristManager", "onPassAgeGateFailed");
    }

    public final void k(long r7) {
        if (t() == true) goto L5;
        return;
    L5:
        if (r7 != 710022013) goto L8;
        this.a.storeBoolean("key_tourist_message_limited", true);
        ITouristApi.a.a(this, TriggerLoginScene.TRIGGER_LOGIN_MESSAGE_LIMITED, false, 2);
        return;
    L8:
        if (r7 != 710022015) goto L13;
        this.a.storeBoolean("key_tourist_create_bot_limited", true);
        ITouristApi.a.a(this, TriggerLoginScene.TRIGGER_LOGIN_CREATE_BOT, false, 2);
        return;
    }

    public final void o(Long r4) {
        if (AccountService.a.isLogin().booleanValue() == true) goto L6;
        FLogger.a.i("TouristManager", "checkTouristLaunchPage ageGateErrorStatus " + r4 + ' ');
        ITouristApi.a.a(this, null, false, 3);
        return;
    }

    public final void p(tj9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.i.remove(r2);
    }

    public final void q(JSONObject r4) {
        FLogger.a.i("AccountLoginController", "checkAgeGate");
        if (AppHost.a.isOversea() == true) goto L6;
        l();
        return;
    L6:
        AgeGateManagerService.a.a(this, "visitor", r4);
    }

    public final void s(tj9.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.j.add(r2);
    }

    public final void v(tj9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.i.add(r2);
    }

    public final void z(tj9.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.j.remove(r2);
    }

    public final void d(TriggerLoginScene r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        FLogger.a.i("TouristManager", "openHalfLogin scene: " + r5);
        boolean r2 = false;
        Bundle r7 = f.c(new Pair[]{TuplesKt.to("key_from_restricted_func", Boolean.TRUE), TuplesKt.to("trigger_login_scene_tag", Integer.valueOf(r5.getValue()))});
        String r3 = null;
        if (o0.d(r6) == true) goto L6;
        r6 = null;
    L6:
        if (r6 == null) goto L16;
        r7.putString("pending_deeplink_schema", r6);
        String r8 = UriProtector.getQueryParameter(UriProtector.parse(r6), "enter_method");
        if (r8 == null) goto L16;
        if (r8.length() <= 0) goto L12;
        r2 = true;
    L12:
        if (r2 == false) goto L14;
        r3 = r8;
    L14:
        if (r3 == null) goto L16;
        r7.putString("account_enter_method", r3);
    L16:
        B();
        i r9 = SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), "//flow/half_account_login");
        r9.c.putExtras(r7);
        r9.d();
    }

    public final boolean i(boolean r9, String r10) {
        boolean r1 = false;
        if (t() == true) goto L5;
        return false;
    L5:
        if (r9 == false) goto L7;
        this.a.storeBoolean("key_tourist_risk", true);
        this.d.setValue(Boolean.TRUE);
    L13:
        ITouristApi.a.a(this, null, true, 1);
        return true;
    L7:
        if (r10 != null) goto L9;
    L10:
        r1 = true;
    L11:
        if (r1 == true) goto L13;
        s.j(s.a, AppHost.a.getApplication(), r10, null, false, 28);
        goto L13
    L9:
        if (r10.length() != 0) goto L11;
        goto L10
    }

    public final void m(Context r5, FragmentManager r6) {
        Intrinsics.checkNotNullParameter(r6, "fm");
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.b == false) goto L7;
        return;
    L7:
        if (this.a.getBoolean("key_tourist_risk", false) == true) goto L10;
        return;
    L10:
        if (r6.isStateSaved() == false) goto L12;
        return;
    L12:
        if (r6.isDestroyed() == true) goto L34;
        CommonDialog.a r0 = new CommonDialog.a();
        r0.i(r5.getString(2131906277));
        r0.g(r5.getString(2131906276));
        CommonDialog.a.f(r0, new b(), r5.getString(2131906275), false, 12);
        r0.w = true;
        CommonDialog r1 = r0.a();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L22
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "tourist_risk_dialog", r2);     // Catch: Exception -> L22
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r1, r2) == false) goto L28;
    L20:
        this.b = true;     // Catch: Exception -> L22
        return;
    L28:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L19:
        r1.show(r6, "tourist_risk_dialog");     // Catch: Exception -> L22
    L22:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "tourist limit dialog show Error");
        return;
    }

    public final void r(LifecycleCoroutineScope r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "source");
        if ((this.f.getValue() instanceof y) == false) goto L5;
        return;
    L5:
        this.c.setValue(Boolean.FALSE);
        this.f.setValue(new w(null));
        BuildersKt.launch$default(r10, Dispatchers.getIO(), null, new requestLaunch.1(this, r11, null), 2, null);
    }

    public final void x(TriggerLoginScene r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "scene");
        FLogger.a.i("TouristManager", "openLogin scene: " + r7 + "  forceFullScreenLogin: " + r8);
        if (r8 == true) goto L5;
        B();
        i r9 = SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), "//flow/half_account_login");
        r9.c.putExtras(f.c(new Pair[]{TuplesKt.to("key_from_restricted_func", Boolean.TRUE), TuplesKt.to("trigger_login_scene_tag", Integer.valueOf(r7.getValue()))}));
        r9.d();
        return;
    L5:
        i r10 = SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), "//flow/account_login");
        r10.c.putExtras(f.c(new Pair[]{TuplesKt.to("key_from_restricted_func", Boolean.TRUE), TuplesKt.to("trigger_login_scene_tag", Integer.valueOf(r7.getValue()))}));
        r10.c.addFlags(67108864);
        r10.d();
    }

    public static final Object e(TouristServiceImpl r5, String r6, String r7, Continuation r8) {
        r5.getClass();
        if ((r8 instanceof fetchConversationInfoByTourist.1) == false) goto L7;
        fetchConversationInfoByTourist.1 r0 = (fetchConversationInfoByTourist.1) r8;
        int r1 = r0.label;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r0.label = r1 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r9 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r7 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L17:
        r10 = (com.larus.network.http.a) r9;
        e r11 = null;
        if ((r10 instanceof y) == false) goto L20;
        y r12 = (y) r10;
    L21:
        if (r12 == null) goto L24;
        r11 = (e) ((com.larus.network.http.a) r12).b;
    L24:
        if (r11 != null) goto L26;
        LaunchMetricDelegate.b.a("conversation_fetch_end", false, "Invalid conversation info: " + r11 + " for " + r7);
    L27:
        return r10;
    L26:
        ILaunchMetricService.a.a(LaunchMetricDelegate.b, "conversation_fetch_end", true, 8);
        goto L27
    L20:
        r12 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ILaunchMetricService.a.a(LaunchMetricDelegate.b, "conversation_fetch_start", false, 12);
        IConversationRepoService r13 = RepoDispatcherDelegate.b.f();
        r0.L$0 = r7;
        r0.label = 1;
        r9 = IConversationRepoService.a.e(r13, r6, r7, r0, 4);
        if (r9 != r10) goto L17;
    L7:
        r0 = new fetchConversationInfoByTourist.1(r5, r8);
        goto L8
    }
}
