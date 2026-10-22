package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static CustomDisplayPageUiMode a(NoPermissionType r1, InternalSecurityAction r2) {
        Intrinsics.checkNotNullParameter(r1, "noPermissionType");
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L7;
        return CustomDisplayPageUiMode.LARK;
    L7:
        if (w4c.c.a().C() == false) goto L9;
        if (r2 == null) goto L28;
        DecisionData.Action r3 = r2.getCurrentAction();
        if (r3 == null) goto L28;
        if (r1 == NoPermissionType.CUSTOM_DISPLAY) goto L17;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == true) goto L26;
        return CustomDisplayPageUiMode.LARK;
    L26:
        return CustomDisplayPageUiMode.DOUBAO;
    L17:
        if (Intrinsics.areEqual(r3.getParams().get("policyType"), "POLICY_CENTER") == false) goto L21;
        if (Intrinsics.areEqual(r3.getParams().get("containerType"), "page") == false) goto L21;
        r4 = true;
    L28:
        return CustomDisplayPageUiMode.LARK;
    L9:
        return CustomDisplayPageUiMode.LARK;
    }
}
