package com.bytedance.ai.resource.security;

import android.content.Context;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.lynx.service.security.LynxSecurityErrorCode;
import com.bytedance.lynx.service.security.LynxSecurityService;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.service.security.ILynxSecurityService;
import i8a.n;
import java.nio.ByteBuffer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final e a = null;
    public static volatile d b;

    public static final class a implements com.bytedance.lynx.service.security.a {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public final boolean a() {
            return this.a;
        }

        public final j8a.b b(com.bytedance.lynx.service.security.f r10) {
            Intrinsics.checkNotNullParameter(r10, "verification");
            if (r10.f == false) goto L33;
            String r0 = r10.j;
            boolean r11 = true;
            if (r0 != null) goto L7;
        L10:
            boolean r12 = true;
        L11:
            if (r12 == false) goto L14;
            com.bytedance.ai.utils.g.a.e("AIPackageManager", "extraConfig is NULL");
            return j8a.b.a("extraConfig is NULL");
        L14:
            JSONObject r13 = new JSONObject(r0);
            String r1 = r13.optString(com.bytedance.android.ec.core.event.a.KEY_APP_ID);
            String r14 = r13.optString("bundle_id");
            String r15 = this.b;
            if (r15 != null) goto L22;
            String r16 = r10.c;
            if (r16 != null) goto L19;
        L21:
            boolean r17 = false;
        L24:
            if (Intrinsics.areEqual(r1, this.c) == false) goto L27;
            if (r17 == false) goto L27;
        L28:
            if (r11 == true) goto L31;
            String r18 = "extraConfig is incorrect. expected appId:" + this.c + ", actual:" + r1 + ", expected bundle_id: " + this.b + ", actual: " + r14;
            com.bytedance.ai.utils.g.a.e("AIPackageManager", r18);
            return j8a.b.a(r18);
        L31:
            com.bytedance.ai.utils.g.a.i("AIPackageManager", "verify signature successfully. packageName:" + this.c + ", bundleId: " + this.b);
            return j8a.b.b();
        L27:
            r11 = false;
            goto L28
        L19:
            if (StringsKt.endsWith$default(r16, r14 + "/template.js", false, 2, null) != true) goto L21;
            r17 = true;
            goto L24
        L22:
            r17 = Intrinsics.areEqual(r14, r15);
            goto L24
        L7:
            if (r0.length() == 0) goto L10;
            r12 = false;
            goto L11
        L33:
            String r19 = r10.g;
            if (r19 != null) goto L36;
            r19 = "failed to verify signature of template}";
        L36:
            com.bytedance.ai.utils.g.a.e("AIPackageManager", r19);
            return j8a.b.a(r19 + ". url:" + r10.c);
        }

        public a(boolean r1, String r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public e() {
    }

    static {
        a = new e();
        b = new d();
    }

    public static boolean c(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (StringsKt.endsWith$default(r10, "/template.js", false, 2, null) != true) goto L7;
    L12:
        boolean r11 = true;
    L13:
        if (r11 != true) goto L17;
        return true;
    L17:
        return false;
    L7:
        if (StringsKt.endsWith$default(r10, "template.js", false, 2, null) == true) goto L12;
        if (StringsKt.endsWith$default(r10, ".template.js", false, 2, null) == true) goto L12;
        r11 = false;
        goto L13
    }

    public static boolean e(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        if (com.bytedance.ai.resource.security.a.a(r10) == 827542348) goto L6;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "invalid keystore magic");
        return false;
    L6:
        int r11 = r10[4] & 255;
        if (r11 == 1) goto L10;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "unsupported keystore version: " + r11);
        return false;
    L10:
        return true;
    }

    public static boolean a(Context r10, String r11, long r12, byte[] r13) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Intrinsics.checkNotNullParameter(r13, "keystoreBytes");
        if (e(r13) == true) goto L11;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "deriveAndStoreDek failed: invalid keystore. package=" + r11 + " version=" + r12);
        return false;
    L11:
        j.a.getClass();     // Catch: Exception -> L8
        byte[] r14 = j.c(r11, r13);     // Catch: Exception -> L8
        c.a.getClass();     // Catch: Exception -> L8
        c.d(r10, r11, r12, r14);     // Catch: Exception -> L8
        com.bytedance.ai.utils.g.a.i("AIPackageManager", "DEK derived and stored successfully. package=" + r11 + " version=" + r12);     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "deriveAndStoreDek exception. package=" + r11 + " version=" + r12 + ", error=" + e);
        return false;
    }

    public static void d(j8a.a r10, boolean r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "target");
        if (r12 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        com.bytedance.ai.utils.g.a.i("AIPackageManager", "skip to set lynxServiceDelegate");
        return;
    L12:
        LynxSecurityService r1 = n.c().a(ILynxSecurityService.class);
        if ((r1 instanceof LynxSecurityService) == false) goto L15;
        LynxSecurityService r14 = r1;
    L16:
        if (r14 == null) goto L19;
        r14.setSecurityDelegateForTarget(r10, new a(r11, r13, r12));
        return;
    L19:
        return;
    L15:
        r14 = null;
        goto L16
    L5:
        if (r12.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static boolean f(String r10, String r11, byte[] r12, long r13) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "manifestData");
        Intrinsics.checkNotNullParameter(r12, "signature");
        com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;     // Catch: Exception -> L32
        r14.i("AIPackageManager", "manifestDataLength: " + r11.length() + "， hash: " + r11.hashCode() + ", signature size: " + r12.length + ", versionCode: " + r13);     // Catch: Exception -> L32
        ByteBuffer r15 = ByteBuffer.wrap(r12);     // Catch: Exception -> L32
        ByteBuffer r16 = ByteBuffer.wrap(r11.getBytes(Charsets.UTF_8));     // Catch: Exception -> L32
        LynxSecurityService r17 = n.c().a(ILynxSecurityService.class);     // Catch: Exception -> L32
        Integer r18 = null;
        if ((r17 instanceof LynxSecurityService) == false) goto L6;
        LynxSecurityService r19 = r17;     // Catch: Exception -> L32
    L7:
        if (r19 == null) goto L30;
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L32
        Intrinsics.checkNotNull(r15);     // Catch: Exception -> L32
        com.bytedance.lynx.service.security.b r110 = r19.verifyPayload(r16, r15);     // Catch: Exception -> L32
        if (r110.b() == false) goto L25;
        String r111 = r110.a();     // Catch: Exception -> L32
        if (r111 != null) goto L13;
    L16:
        boolean r112 = true;
    L17:
        if (r112 == false) goto L20;
        r14.e("AIPackageManager", "extraConfig is NULL");     // Catch: Exception -> L32
        return false;
    L20:
        String r113 = new JSONObject(r111).optString(com.bytedance.android.ec.core.event.a.KEY_APP_ID);     // Catch: Exception -> L32
        boolean r114 = Intrinsics.areEqual(r113, r10);     // Catch: Exception -> L32
        if (r114 == true) goto L23;
        r14.e("AIPackageManager", "extraConfig is incorrect. expected:" + r10 + ", actual:" + r113);     // Catch: Exception -> L32
    L24:
        return r114;
    L23:
        h.a.getClass();     // Catch: Exception -> L32
        Intrinsics.checkNotNullParameter(r10, "packageName");     // Catch: Exception -> L32
        h.b.put(r10 + '_' + r13, Boolean.TRUE);     // Catch: Exception -> L32
        goto L24
    L13:
        if (r111.length() == 0) goto L16;
        r112 = false;
        goto L17
    L25:
        StringBuilder r20 = new StringBuilder("failed to verifySignature. errorCode: ");     // Catch: Exception -> L32
        LynxSecurityErrorCode r115 = r110.getErrorCode();     // Catch: Exception -> L32
        if (r115 == null) goto L28;
        r18 = Integer.valueOf(r115.getCode());     // Catch: Exception -> L32
    L28:
        r20.append(r18);     // Catch: Exception -> L32
        r20.append(", errorMessage: ");     // Catch: Exception -> L32
        r20.append(r110.getErrorMsg());     // Catch: Exception -> L32
        r20.append(", signId:");     // Catch: Exception -> L32
        r20.append(r110.c());     // Catch: Exception -> L32
        r14.e("AIPackageManager", r20.toString());     // Catch: Exception -> L32
        return false;
    L30:
        r14.e("AIPackageManager", "securityService is NULL");     // Catch: Exception -> L32
        return false;
    L6:
        r19 = null;
    L32:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "verifySignature error: " + e);
        return false;
    }

    public static TemplateBundle g(byte[] r1, boolean r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r1, "templateJS");
        TemplateBundle r0 = new TemplateBundle();
        d(r0, r10, r11, r12);
        r0.e(r1, null);
        if (r0.i() == false) goto L6;
        return r0;
    L6:
        return null;
    }

    public static void b(String r19, long r20, byte[] r22, Function0 r23, Function1 r24) {
        Intrinsics.checkNotNullParameter(r19, "packageName");
        Intrinsics.checkNotNullParameter(r22, "keystoreBytes");
        Intrinsics.checkNotNullParameter(r23, "resolve");
        Intrinsics.checkNotNullParameter(r24, "reject");
        if (e(r22) == true) goto L6;
        r24.invoke(new IllegalArgumentException("invalid debug keystore"));
        return;
    L6:
        j.a.getClass();
        Intrinsics.checkNotNullParameter(r19, "packageName");
        Intrinsics.checkNotNullParameter(r22, "wrappedDekBytes");
        Intrinsics.checkNotNullParameter(r23, "resolve");
        Intrinsics.checkNotNullParameter(r24, "reject");
        j.a r10 = j.a(r22);     // Catch: Exception -> L13
        Job r11 = BuildersKt.launch$default(j.c, null, null, new OpenPlatformSecurityClient$deriveAndStoreDekForDebug$timeoutJob$1(r10, r19, r20, null), 3, null);
        j.b.put(r10.a, new j.b(r19, r20, r10, r23, r24, r11));
        IAISDKDebugService.a.I(r10.b, -1);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "deriveAndStoreDekForDebug send failed. package=" + r19 + " version=" + r20 + ", error=" + e);
        j.b.remove(r10.a);
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
        r24.invoke(e);
        return;
    L13:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "deriveAndStoreDekForDebug build request failed. package=" + r19 + " version=" + r20 + ", error=" + e);
        r24.invoke(e);
    }
}
