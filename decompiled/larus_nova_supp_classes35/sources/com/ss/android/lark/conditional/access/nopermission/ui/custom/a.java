package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.Context;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a extends j0, m0, d0, e, c, e0, f0, g0, k0, b, i0, l0 {

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.nopermission.ui.custom.a$a, reason: collision with other inner class name */
    public static final class C0157a {
        public static boolean a(a r3, CustomDisplayHandler r4, InternalSecurityAction r5, Context r6) {
            Intrinsics.checkNotNullParameter(r4, "handler");
            Intrinsics.checkNotNullParameter(r6, "context");
            String r0 = r4.type;
            if (r0 != null) goto L5;
        L63:
            int r7 = ScsLogger.a;
            ScsLogger.e("SecurityPolicy_ButtonTypeFunction", "click: unknown button type： " + r4.type);
            return false;
        L5:
            switch(r0.hashCode()) {
                case -2063279368: goto L59;
                case -2055224702: goto L53;
                case -1977847723: goto L49;
                case -1820782903: goto L44;
                case -1520881346: goto L40;
                case -119419380: goto L36;
                case 76232: goto L32;
                case 97165976: goto L28;
                case 411527979: goto L24;
                case 1022185706: goto L20;
                case 1474416494: goto L16;
                case 1584359545: goto L12;
                case 2011110042: goto L8;
                default: goto L63;
            };
        L8:
            if (r0.equals("Cancel") == false) goto L63;
            r3.KT(r4, r5, r6);
            return true;
        L12:
            if (r0.equals("GeoAuth") == false) goto L63;
            r3.QY(r4, r5, r6);
            return true;
        L16:
            if (r0.equals("VerifyLocation") == false) goto L63;
            r3.QY(r4, r5, r6);
            return true;
        L20:
            if (r0.equals("CustomAppLink") == false) goto L63;
            r3.eG(r4, r5, r6);
            return true;
        L24:
            if (r0.equals("CustomLink") == false) goto L63;
            r3.nb(r4, r6);
            return true;
        L28:
            if (r0.equals("DeviceApply") == false) goto L63;
            r3.Fw(r4, r5, r6);
            return true;
        L32:
            if (r0.equals("MFA") == false) goto L63;
            r3.To(r4, r5, r6);
            return true;
        L36:
            if (r0.equals("RetryAccess") == false) goto L63;
            r3.VB(r4, r5, r6);
            return true;
        L40:
            if (r0.equals("DeviceAuth") == false) goto L63;
            r3.Vy(r4, r5, r6);
            return true;
        L44:
            if (r0.equals("DeviceTokenClaimsChallenge") == false) goto L63;
            r3.sI(r4, r5, r6);
            return false;
        L49:
            if (r0.equals("UserConfirm") == false) goto L63;
            r3.uR(r4, r5, r6);
            return true;
        L53:
            if (r0.equals("DeviceCertAuth") == false) goto L63;
            r3.Dx(r4, r5, r6);
            return true;
        L59:
            if (r0.equals("SkipVerify") == false) goto L63;
            r3.qF(r4, r5, r6);
            return false;
        }
    }

    boolean dL(CustomDisplayHandler r1, InternalSecurityAction r2, Context r3);
}
