package com.larus.setting.impl.iconchanger;

import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.auth.CocoSetting;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.e0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.home.api.main.AppIconsType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconManager$tryShowSyncDialog$1", f = "ChangeAppIconManager.kt", i = {}, l = {108, 108}, m = "invokeSuspend", n = {}, s = {})
final class ChangeAppIconManager$tryShowSyncDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $useLocalBot;
    int label;

    public static final class a implements IIMCallback<BotModel> {
        public a() {
        }

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.i("SettingServiceImpl", "IIMError:" + r4);
        }

        public final void onSuccess(Object r4) {
            BotModel r5 = (BotModel) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            String r6 = r5.getBotIconMappedAppIcon();
            if (r6 == null) goto L5;
            Integer r7 = StringsKt.toIntOrNull(r6);
        L6:
            LinkedHashSet r0 = new LinkedHashSet();
            c1 r1 = (c1) AuthModelDelegate.b.c().getValue();
            if (r1 == null) goto L16;
            e0 r2 = (e0) r1.d;
            if (r2 == null) goto L16;
            List r3 = r2.p();
            if (r3 == null) goto L16;
            Iterator r8 = r3.iterator();
        L14:
            if (r8.hasNext() == false) goto L16;
            r0.add(((CocoSetting) r8.next()).a());
        L16:
            if (r7 != null) goto L19;
            WeakReference<CommonDialog> r9 = ChangeAppIconManager.a;
            ChangeAppIconManager.h(AppIconsType.DEFAULT.getAppIconId());
        L19:
            if (r0.contains(r7) == true) goto L22;
            WeakReference<CommonDialog> r10 = ChangeAppIconManager.a;
            ChangeAppIconManager.h(AppIconsType.DEFAULT.getAppIconId());
        L22:
            if (r0.contains(r7) == false) goto L28;
            AppIconsType.Companion.getClass();
            AppIconsType r11 = AppIconsType.a.a(r7);
            if (r11 == null) goto L29;
            WeakReference<CommonDialog> r12 = ChangeAppIconManager.a;
            ChangeAppIconManager.h(r11.getAppIconId());
            return;
        L29:
            return;
        L28:
            return;
        L5:
            r7 = null;
            goto L6
        }
    }

    public ChangeAppIconManager$tryShowSyncDialog$1(boolean r1, Continuation<? super ChangeAppIconManager$tryShowSyncDialog$1> r2) {
        this.$useLocalBot = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChangeAppIconManager$tryShowSyncDialog$1(this.$useLocalBot, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L18:
        List r12 = (List) r11;
        if (r12 == null) goto L23;
        String r13 = (String) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L23;
    L24:
        String r5 = r13;
        if (this.$useLocalBot == true) goto L27;
    L30:
        boolean r6 = true;
    L32:
        if (AppHost.a.isTestChannel() == false) goto L38;
        by7.a r14 = new by7.a("get_bot_list_v2_call_scene");
        r14.d("scene", "ChangeAppIconManager");
        if (r6 == false) goto L36;
        String r2 = "1";
    L37:
        r14.d("force_new", r2);
        r14.b();
        goto L38
    L36:
        r2 = "0";
    L38:
        IActionBarService r15 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r15 != null) goto L41;
    L43:
        r3 = false;
    L44:
        if (r3 == false) goto L50;
        IActionBarService r16 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r16 == null) goto L49;
        r16.b(false);
    L49:
        return Unit.INSTANCE;
    L50:
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r5, r6, null, new a(), 12);
        return Unit.INSTANCE;
    L41:
        if (r15.c() != true) goto L43;
    L27:
        if (com.larus.platform.exp.c.c == false) goto L30;
        r6 = false;
    L23:
        r13 = "";
        goto L24
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L13:
        wc9.e r17 = (wc9.e) r11;
        if (r17 == null) goto L23;
        this.label = 2;
        r11 = ic8.n.c(r17, this);
        if (r11 != r0) goto L18;
        return r0;
    L10:
        ResultKt.throwOnFailure(r11);
        Flow r18 = FlowLiveDataConversions.asFlow(AuthModelDelegate.b.y());
        ChangeAppIconManager$tryShowSyncDialog$1$mainBotId$1 r4 = new ChangeAppIconManager$tryShowSyncDialog$1$mainBotId$1(null);
        this.label = 1;
        r11 = kotlinx.coroutines.flow.e.u(r18, r4, this);
        if (r11 != r0) goto L13;
        return r0;
    }
}
