package com.larus.bmhome.utils;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sx5.b;
import v19.c;
import v19.j5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z2 {
    public static final Keva a = null;
    public static final Keva b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ExternalRedirectPromptFrequencyConfig.values().length];
            r0[ExternalRedirectPromptFrequencyConfig.NEVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ExternalRedirectPromptFrequencyConfig.FIRST_USE_ONLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ExternalRedirectPromptFrequencyConfig.EACH_DOMAIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = Keva.getRepo("safety_domain_confirm_cache", 0);
        b = Keva.getRepo("safety_permission_confirm_cache", 0);
    }

    public static ExternalRedirectPromptFrequencyConfig a() {
        String r0 = com.larus.platform.service.z2.a.Z3();
        if (r0 != null) goto L14;
        r0 = oo8.a.c;
    L14:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(ExternalRedirectPromptFrequencyConfig.valueOf(r0));     // Catch: Throwable -> L7
    L9:
        ExternalRedirectPromptFrequencyConfig r3 = ExternalRedirectPromptFrequencyConfig.FIRST_USE_ONLY;
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = r3;
    L13:
        return (ExternalRedirectPromptFrequencyConfig) r2;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static void b(String r21, Function0 r22) {
        String r0 = r21;
        Intrinsics.checkNotNullParameter(r22, "onConfirm");
        if (r0 != null) goto L6;
        return;
    L6:
        if (com.larus.utils.y0.e(r21) == false) goto L8;
        String r2 = r0;
    L9:
        String r3 = com.larus.utils.y0.h(r2).getHost();
        if (r3 == null) goto L17;
        List r4 = StringsKt.split$default(r3, new char[]{'.'}, false, 0, 6, null);
        if (r4 == null) goto L17;
        if (r4.size() <= 2) goto L22;
        r3 = CollectionsKt.joinToString$default(CollectionsKt.takeLast(r4, 2), ".", null, null, 0, null, null, 62, null);
    L22:
        if (AppHost.a.isOversea() == false) goto L69;
        String r1 = b.g().a;
        Intrinsics.checkNotNull(r1);
        FLogger.a.i("SafetyOpenLinkManager", "shouldUrlSafeCheck currentRegion: " + r1);
        List<String> r5 = com.larus.platform.service.z2.a.Z0();
        if (r5 != null) goto L27;
        r5 = oo8.a.b;
    L27:
        List<String> r6 = r5;
        if ((r6 instanceof Collection) == true) goto L30;
    L32:
        Iterator<T> r7 = r6.iterator();
    L34:
        if (r7.hasNext() == false) goto L38;
        if (StringsKt.equals(r1, (String) r7.next(), true) == false) goto L34;
        boolean r8 = true;
    L39:
        if (r8 == false) goto L69;
        FLogger.a.i("SafetyOpenLinkManager", "tryUrlSafeCheck domain: " + r3);
        List<String> r9 = com.larus.platform.service.z2.a.T0();
        if (r9 != null) goto L44;
        r9 = oo8.a.a;
    L44:
        List<String> r10 = r9;
        if ((r10 instanceof Collection) == true) goto L47;
    L49:
        Iterator<T> r11 = r10.iterator();
    L51:
        if (r11.hasNext() == false) goto L55;
        if (StringsKt.equals(r3, (String) r11.next(), true) == false) goto L51;
        boolean r12 = true;
    L56:
        if (r12 == false) goto L58;
        FLogger.a.i("SafetyOpenLinkManager", "isDomainInWhitelist");
        goto L69
    L58:
        int r13 = a.a[a().ordinal()];
        if (r13 == 1) goto L68;
        if (r13 != 2) goto L62;
        FLogger.a.i("SafetyOpenLinkManager", "promptFrequency FIRST_USE_ONLY");
        boolean r14 = b.getBoolean("safety_domain_confirm_permission", false);
    L67:
        boolean r15 = !r14;
    L70:
        if (r15 == true) goto L73;
        r22.invoke();
        return;
    L73:
        FLogger.a.i("SafetyOpenLinkManager", "showSafetyConfirmDialog");
        AppHost.Companion r16 = AppHost.a;
        FragmentActivity r17 = r16.a().getCurrentActivity();
        if ((r17 instanceof FragmentActivity) == false) goto L76;
        FragmentActivity r18 = r17;
    L77:
        if (r18 == null) goto L97;
        CommonDialog.a r19 = new CommonDialog.a();
        if (r16.isOversea() == false) goto L81;
        String r20 = j5.a(r16.getApplication(), 2131894310, 2131901968);
    L82:
        r19.i(r20);
        r19.m = true;
        a3 r23 = new a3(r3, r22);
        int r24 = com.larus.utils.j0.a;
        CommonDialog.a.f(r19, r23, com.larus.utils.j0.d(2131907689), false, 12);
        CommonDialog.a.e(r19, new b3(), com.larus.utils.j0.d(2131907688), 4);
        CommonDialog r25 = r19.d(ContextCompat.getColor(r18, c.b(2130972079, r18, 2131103136)));
        FragmentManager r26 = r18.getSupportFragmentManager();
        LandscapeRestrictionOperation r27 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r25, null, r27);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r26, r25, r27) == true) goto L98;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L88
    L86:
        r25.show(r26, null);
        return;
    L98:
        return;
    L81:
        int r28 = com.larus.utils.j0.a;
        r20 = com.larus.utils.j0.d(2131907690);
        goto L82
    L97:
        return;
    L76:
        r18 = null;
        goto L77
    L62:
        if (r13 != 3) goto L65;
        FLogger.a.i("SafetyOpenLinkManager", "promptFrequency EACH_DOMAIN");
        r14 = a.getBoolean(r3, false);
        goto L67
    L65:
        throw new NoWhenBranchMatchedException();
    L68:
        FLogger.a.i("SafetyOpenLinkManager", "promptFrequency NEVER");
    L55:
        r12 = false;
        goto L56
    L47:
        if (r10.isEmpty() == false) goto L49;
    L38:
        r8 = false;
        goto L39
    L30:
        if (r6.isEmpty() == false) goto L32;
    L69:
        r15 = false;
    L17:
        if (r3 == null) goto L20;
        r0 = r3;
    L20:
        r3 = r0;
        goto L22
    L8:
        r2 = "https://".concat(r0);
        goto L9
    }
}
