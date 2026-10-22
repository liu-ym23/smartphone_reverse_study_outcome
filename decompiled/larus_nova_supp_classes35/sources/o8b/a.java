package o8b;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import kotlin.jvm.internal.Intrinsics;
import w4c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    static {
    }

    public static boolean a(InternalSecurityAction r3) {
        if (r3 == null) goto L6;
        DecisionData.Action r0 = r3.getCurrentAction();
        if (r0 == null) goto L6;
        String r1 = r0.getName();
    L8:
        if (Intrinsics.areEqual(r1, "ACCESS_CONTROL_ACTION_COMMON") == true) goto L10;
        return false;
    L10:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L14;
        return false;
    L14:
        if (c.a().i() == true) goto L16;
        return true;
    L16:
        if (r3 != null) goto L18;
        return false;
    L18:
        if (r3.getSource() != 1) goto L22;
        return true;
    L22:
        return false;
    L6:
        r1 = null;
        goto L8
    }
}
