package com.obric.assistant.settings.memory;

import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.ToggleName;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricPersonalContextSettingFragment$adapter$2$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public ObricPersonalContextSettingFragment$adapter$2$1(Object r8) {
        super(1, r8, ObricPersonalContextSettingFragment.class, "handleLocalDataSearchToggleClick", "handleLocalDataSearchToggleClick(Z)V", 0);
    }

    /* JADX WARN: Type inference failed for: r15v1, types: [com.obric.assistant.settings.memory.m] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.assistant.settings.memory.n] */
    public final void invoke(boolean r15) {
        final ObricPersonalContextSettingFragment r0 = (ObricPersonalContextSettingFragment) ((CallableReference) this).receiver;
        int r1 = ObricPersonalContextSettingFragment.l;
        r0.getClass();
        SystemHiddenApiHelper r2 = SystemHiddenApiHelper.INSTANCE;
        if (r15 == true) goto L5;
        VibratorSmtFeedbackEffect r3 = VibratorSmtFeedbackEffect.EFFECT_RIGID;
    L6:
        r2.performVibratorSmtFeedback(r3);
        if (r15 == true) goto L53;
        boolean r4 = true;
        r0.U90().m(true);
        r0.V90().refresh();
        ArrayList r5 = new ArrayList();
        ObricPersonalContextSettingApiDelegate r16 = r0.U90();
        ToggleName r6 = ToggleName.CONTACTS;
        if (r16.o(r6) == true) goto L11;
        r5.addAll(com.obric.assistant.settings.i.a(r6));
    L11:
        ObricPersonalContextSettingApiDelegate r17 = r0.U90();
        ToggleName r7 = ToggleName.CALL_LOGS;
        if (r17.o(r7) == true) goto L14;
        r5.addAll(com.obric.assistant.settings.i.a(r7));
    L14:
        ObricPersonalContextSettingApiDelegate r18 = r0.U90();
        ToggleName r8 = ToggleName.MESSAGE;
        if (r18.o(r8) == true) goto L17;
        r5.addAll(com.obric.assistant.settings.i.a(r8));
    L17:
        ObricPersonalContextSettingApiDelegate r19 = r0.U90();
        ToggleName r9 = ToggleName.IMAGES;
        if (r19.o(r9) == true) goto L20;
        r5.addAll(com.obric.assistant.settings.i.a(r9));
    L20:
        ObricPersonalContextSettingApiDelegate r110 = r0.U90();
        ToggleName r10 = ToggleName.VIDEO;
        if (r110.o(r10) == true) goto L23;
        r5.addAll(com.obric.assistant.settings.i.a(r10));
    L23:
        ObricPersonalContextSettingApiDelegate r111 = r0.U90();
        ToggleName r11 = ToggleName.CALENDAR;
        if (r111.o(r11) == true) goto L26;
        r5.addAll(com.obric.assistant.settings.i.a(r11));
    L26:
        ObricPersonalContextSettingApiDelegate r112 = r0.U90();
        ToggleName r12 = ToggleName.FILE_MANAGEMENT;
        if (r112.o(r12) == true) goto L30;
        r5.addAll(com.obric.assistant.settings.i.a(r12));
    L30:
        if (r5.isEmpty() == true) goto L48;
        long r13 = r0.U90().e();
        AppHost.Companion r113 = AppHost.a;
        long r14 = r113.getAppClock().currentTimeMillis();
        if (r13 <= 0) goto L41;
        long r114 = r14 - r13;
        if (0 <= r114) goto L36;
    L38:
        boolean r20 = false;
    L39:
        if (r20 == false) goto L41;
    L42:
        FLogger.a.i("ObricPersonalContextSettingFragment", "shouldSkipLocalDataSearchInitPermissionRequest, lastRequestTimestamp: " + r13 + ", currentTimestamp: " + r14 + ", shouldSkip: " + r4);
        if (r4 == true) goto L48;
        r0.U90().b(r113.getAppClock().currentTimeMillis());
        IObricPermissionService r21 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r21 == null) goto L64;
        r21.n(r0.getActivity(), r5, false, false, false, false, new t(r0));
        return;
    L64:
        return;
    L36:
        if (r114 >= 172800000) goto L38;
        r20 = true;
    L41:
        r4 = false;
    L48:
        FLogger.a.i("ObricPersonalContextSettingFragment", "tryBatchRequestInitPermissions, return by 48h interval or systemPermissions empty");
        CoroutineScope r22 = r0.j;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L51;
        CoroutineStart r115 = CoroutineStart.UNDISPATCHED;
    L52:
        BuildersKt.launch$default(r22, null, r115, new ObricPersonalContextSettingFragment$tryRequestMultiCustomPermission$1(r0, false, null), 1, null);
        return;
    L51:
        r115 = CoroutineStart.DEFAULT;
        goto L52
    L53:
        final ?? r116 = new m(r0);
        final ?? r23 = new n(r0);
        FragmentActivity r24 = r0.getActivity();
        if (r24 == null) goto L67;
        com.obric.oui.dialog.v2.alert.g r25 = new com.obric.oui.dialog.v2.alert.g(r24);
        r25.w = false;
        AppHost.Companion r26 = AppHost.a;
        String r27 = r26.getApplication().getString(2131912555);
        r25.j = false;
        r25.h = r27;
        r25.i = r26.getApplication().getString(2131912554);
        com.obric.oui.dialog.v2.alert.g.c(r25);
        r25.e(r26.getApplication().getString(2131912552), new h(r23));
        r25.g(r26.getApplication().getString(2131912553), new i(r116), ButtonStyleController.TextColorType.Negative);
        com.obric.oui.dialog.v2.alert.c r117 = r25.a();
        if (DialogLancet.shouldBlockDialogShow(r117) == false) goto L62;
        DialogLancet.handleBlockedDialogShow(r117);
        return;
    L62:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L61
    L59:
        DialogLancet.beforeDialogShow(r117);
        r117.show();
        DialogLancet.afterDialogShow(r117);
        return;
    L67:
        return;
    L5:
        r3 = VibratorSmtFeedbackEffect.EFFECT_SOFT;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
