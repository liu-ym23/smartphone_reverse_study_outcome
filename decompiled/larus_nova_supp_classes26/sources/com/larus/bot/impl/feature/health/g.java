package com.larus.bot.impl.feature.health;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.bmhome.chat.component.bottom.t0;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.common_ui.dialog.m0;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.setting.api.u;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.larus.vesdk.api.IVeSDK;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final g a = null;
    public static Job b;
    public static Job c;
    public static Job d;
    public static Job e;
    public static l0 f;
    public static m0 g;

    static {
        a = new g();
    }

    public g() {
    }

    public static void d(WeakReference r3) {
        if (r3 == null) goto L6;
        View r4 = (View) r3.get();
        if (r4 == null) goto L6;
        e1.o(r4);
    L6:
        m0 r5 = g;
        if (r5 == null) goto L25;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r5);
        goto L25
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r1 == null) goto L22;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        goto L22
    L11:
        if (Looper.myLooper() == r0.getLooper()) goto L13;
        r0.post(DialogLancet.createDismissRunnable(r5));
    L25:
        Job r6 = d;
        if (r6 == null) goto L28;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L28:
        g = null;
        d = null;
    }

    public static void e(WeakReference r4) {
        if (r4 == null) goto L6;
        View r5 = (View) r4.get();
        if (r5 == null) goto L6;
        e1.o(r5);
    L6:
        Job r6 = b;
        if (r6 == null) goto L9;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L9:
        l0 r7 = f;
        if (r7 == null) goto L28;
        Handler r1 = DialogLancet.resolveDialogHandler(r7);
        if (r1 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r7);
        goto L28
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r2 == null) goto L25;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L14:
        if (Looper.myLooper() == r1.getLooper()) goto L16;
        r1.post(DialogLancet.createDismissRunnable(r7));
    L28:
        f = null;
        b = null;
    }

    public static JSONObject b(g r6, String r7) {
        r6.getClass();
        String r8 = u.a;
        String r9 = String.valueOf(AppHost.a.getAppId());
        Intrinsics.checkNotNullParameter("{}", "params");
        Intrinsics.checkNotNullParameter("fpa_medical", "pluginName");
        Intrinsics.checkNotNullParameter("7411069252570120192", "botId");
        Intrinsics.checkNotNullParameter(r7, "funName");
        Intrinsics.checkNotNullParameter("7416241477438718015", "pluginID");
        Intrinsics.checkNotNullParameter(r9, "connectorId");
        JSONObject r0 = new JSONObject();
        r0.put("Parameters", "{}");
        r0.put("PluginName", "fpa_medical");
        r0.put("BotId", "7411069252570120192");
        r0.put("APIName", r7);
        r0.put("PluginID", "7416241477438718015");
        r0.put("ConnectorId", r9);
        return r0;
    }

    public static final Object a(g r18, f r19, Continuation r20) {
        r18.getClass();
        if ((r20 instanceof ChatHealthTipFragmentManager$fetchShouldShowDialog$1) == false) goto L7;
        ChatHealthTipFragmentManager$fetchShouldShowDialog$1 r2 = (ChatHealthTipFragmentManager$fetchShouldShowDialog$1) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        Continuation r0 = null;
        if (r4 == 0) goto L23;
        if (r4 == 1) goto L22;
        if (r4 == 2) goto L21;
        if (r4 == 3) goto L17;
        if (r4 != 4) goto L16;
        ResultKt.throwOnFailure(r1);
    L50:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Function2 r5 = (Function2) r2.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Exception -> L20
    L20:
        Function2 r6 = r5;
        r0 = r0;
    L46:
        MainCoroutineDispatcher r7 = Dispatchers.getMain();
        ChatHealthTipFragmentManager$fetchShouldShowDialog$4 r8 = new ChatHealthTipFragmentManager$fetchShouldShowDialog$4(r6, r0);
        r2.L$0 = r0;
        r2.L$1 = r0;
        r2.label = 4;
        if (BuildersKt.withContext(r7, r8, r2) != r15) goto L50;
        return r15;
    L21:
        com.larus.network.http.a r9 = (com.larus.network.http.a) r2.L$1;
        r6 = (Function2) r2.L$0;
        ResultKt.throwOnFailure(r1);
        com.larus.network.http.a r10 = r9;
        r0 = r0;
    L33:
        if ((r10 instanceof y) == false) goto L50;
        zs9.g r11 = (zs9.g) ((com.larus.network.http.a) ((y) r10)).b;     // Catch: Exception -> L45
        if (r11 == null) goto L37;
        Continuation r12 = r11.a();     // Catch: Exception -> L45
    L38:
        if (r12 != null) goto L40;
        r12 = "";
    L40:
        GetSafetyInstructionResponse r13 = (GetSafetyInstructionResponse) new Gson().fromJson(r12, GetSafetyInstructionResponse.class);     // Catch: Exception -> L45
        if (r13 == null) goto L50;
        MainCoroutineDispatcher r14 = Dispatchers.getMain();     // Catch: Exception -> L45
        ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1 r16 = new ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1(r13, r6, r0);     // Catch: Exception -> L45
        r2.L$0 = r6;     // Catch: Exception -> L45
        r2.L$1 = r0;     // Catch: Exception -> L45
        r2.label = 3;     // Catch: Exception -> L45
        if (BuildersKt.withContext(r14, r16, r2) != r15) goto L50;
        return r15;
    L37:
        r12 = r0;
        goto L38
    L22:
        Function2 r17 = (Function2) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r6 = r17;
        Object r21 = r1;
        int r22 = 2;
    L27:
        r10 = (com.larus.network.http.a) r21;
        if ((r10 instanceof com.larus.network.http.f) == false) goto L33;
        MainCoroutineDispatcher r23 = Dispatchers.getMain();
        ChatHealthTipFragmentManager$fetchShouldShowDialog$2 r24 = new ChatHealthTipFragmentManager$fetchShouldShowDialog$2(r6, r0);
        r2.L$0 = r6;
        r2.L$1 = r10;
        r2.label = r22;
        if (BuildersKt.withContext(r23, r24, r2) != r15) goto L33;
        return r15;
    L23:
        ResultKt.throwOnFailure(r1);
        JSONObject r25 = b(r18, "safety_instruction");
        String r26 = u.g;
        r2.L$0 = r19;
        r2.label = 1;
        r22 = 2;
        Object r27 = HttpExtKt.k("Basic", zs9.g.class, r26, r25, null, null, false, null, null, null, r2, 1008);
        if (r27 == r15) goto L55;
        r21 = r27;
        r6 = r19;
        goto L27
    L55:
        return r15;
    L7:
        r2 = new ChatHealthTipFragmentManager$fetchShouldShowDialog$1(r18, r20);
        goto L8
    }

    public static void c(final t0 r9, final WeakReference r10, final FragmentManager r11, final BotModel r12) {
        Intrinsics.checkNotNullParameter(r9, "backListener");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "fragmentManager");
        Intrinsics.checkNotNullParameter(r12, "botModel");
        Function0 r0 = new e(r12, r9, r11, r10);
        String r13 = r12.getBotId();
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        e10 r14 = e10.a;
        List r15 = e10.X().getHealthBotList();
        if (r15 == null) goto L13;
        Iterator r16 = r15.iterator();
    L9:
        if (r16.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(r13, (String) r16.next()) == false) goto L9;
        boolean r17 = true;
    L14:
        if (r17 == false) goto L18;
        IVeSDK r18 = (IVeSDK) ServiceManager.get().getService(IVeSDK.class);
        if (r18 == null) goto L18;
        r18.c();
    L18:
        if (r17 == false) goto L23;
        Keva r19 = h.a;
        String r110 = AccountService.a.getUserId();
        Intrinsics.checkNotNullParameter(r110, "uid");
        if (h.a.getBoolean("have_agree_health".concat(r110), false) == true) goto L23;
        e(null);
        GlobalScope r111 = GlobalScope.INSTANCE;
        b = BuildersKt.launch$default(r111, null, null, new ChatHealthTipFragmentManager$tryShowLoadingTask$1(null), 3, null);
        d = BuildersKt.launch$default(r111, Dispatchers.getMain(), null, new ChatHealthTipFragmentManager$tryShowNoInteract$1(null), 2, null);
        c = BuildersKt.launch$default(r111, null, null, new ChatHealthTipFragmentManager$judgeShouldShowDialog$1(r0, r10, r9, null), 3, null);
        return;
    L23:
        View r20 = (View) r10.get();
        if (r20 == null) goto L31;
        e1.o(r20);
        return;
    L31:
        return;
    L13:
        r17 = false;
        goto L14
    }
}
