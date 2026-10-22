package com.larus.xbridge.custom;

import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.xbridge.custom.ui.CommonAlertDialog;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.commonAlert";
    }

    public j() {
    }

    public final void a(dx7.b r13, ux7.d.d r14, IvyBridgePlatformType r15) {
        Intrinsics.checkNotNullParameter(r13, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r14, "callback");
        Intrinsics.checkNotNullParameter(r15, "type");
        AppHost.Companion r16 = AppHost.a;
        FragmentActivity r0 = r16.a().getCurrentActivity();
        int r2 = 0;
        if ((r0 instanceof FragmentActivity) == false) goto L18;
        String r3 = cx7.a.d(r13, "title", NameKeys.UnloadStrategy_No_Strategy);
        String r4 = cx7.a.d(r13, "desc", NameKeys.UnloadStrategy_No_Strategy);
        dx7.e r17 = cx7.a.a(r13, "actions");
        ArrayList r5 = new ArrayList();
        if (r17 == null) goto L13;
        dx7.e r18 = r17;
        int r6 = r18.b();
    L7:
        if (r2 >= r6) goto L13;
        dx7.b r7 = r18.getMap(r2);
        if (r7 == null) goto L12;
        r5.add(new Action(cx7.a.d(r7, "id", NameKeys.UnloadStrategy_No_Strategy), cx7.a.d(r7, "title", NameKeys.UnloadStrategy_No_Strategy), Integer.valueOf(cx7.a.c(r7, "style"))));
    L12:
        r2 = r2 + 1;
    L13:
        CommonAlertData r19 = new CommonAlertData(r3, r4, r5);
        int r110 = CommonAlertDialog.f;
        Intrinsics.checkNotNullParameter(r19, LynxResourceModule.DATA_KEY);
        Bundle r111 = new Bundle();
        r111.putSerializable("key_data", r19);
        CommonAlertDialog r112 = new CommonAlertDialog();
        r112.setArguments(r111);
        r112.e = r14;
        FragmentManager r113 = r0.getSupportFragmentManager();
        LandscapeRestrictionOperation r114 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r112, null, r114);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r113, r112, r114) == true) goto L27;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L17:
        r112.show(r113, null);
        return;
    L27:
        return;
    L18:
        t19.s r115 = t19.s.a;
        Application r116 = r16.getApplication();
        r115.getClass();
        t19.s.s(r116, 2131910343);
        FLogger.a.e("AppCommonAlertMethod", "current activity " + r0 + " is not FragmentActivity");
        LinkedHashMap r117 = new LinkedHashMap();
        r117.put(LynxResourceModule.CODE_KEY, 0);
        r14.invoke(r117);
    }
}
