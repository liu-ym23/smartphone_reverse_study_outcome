package com.larus.uaigc.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.i1;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public static boolean c(String r4) {
        if (r4 == null) goto L5;
        String r5 = StringsKt.trim(r4).toString();
    L6:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        if (StringsKt.startsWith$default(r5, "content://", false, 2, null) == false) goto L11;
    L14:
        return true;
    L11:
        if (StringsKt.startsWith$default(r5, "file://", false, 2, null) == true) goto L14;
        if (StringsKt.startsWith$default(r5, "/", false, 2, null) == true) goto L14;
        return false;
    L5:
        r5 = null;
        goto L6
    }

    public static boolean b(Context r9, String r10) {
        FlowFileProtectionService r0 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
        return false;
    L10:
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r4 = new JSONObject();
        r4.put("action", "share");
        r4.put("entry", "generated_local_media");
        r4.put("channel", "more");
        r4.put("content_type", r10);
        Unit r11 = Unit.INSTANCE;
        r1.reportEvent("flow_enterprise_file_egress_block", r4);
        String r12 = r0.A0();
        if (r12 != null) goto L13;
    L19:
        return true;
    L13:
        if ((!StringsKt.isBlank(r12)) == true) goto L16;
        r12 = null;
    L16:
        String r5 = r12;
        if (r5 == null) goto L19;
        t19.s.j(t19.s.a, r9, r5, null, false, 28);
        goto L19
    L5:
        if (r0.I0() != true) goto L7;
        r3 = true;
        goto L8
    }

    public static boolean d(Context r2, Uri r3, String r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Intent r1 = new Intent("android.intent.action.SEND");     // Catch: Throwable -> L4
        r1.setType(r4);     // Catch: Throwable -> L4
        r1.putExtra("android.intent.extra.STREAM", r3);     // Catch: Throwable -> L4
        r1.addFlags(1);     // Catch: Throwable -> L4
        r1.addFlags(268435456);     // Catch: Throwable -> L4
        Intent r5 = Intent.createChooser(r1, null);     // Catch: Throwable -> L4
        r5.addFlags(268435456);     // Catch: Throwable -> L4
        r2.startActivity(r5);     // Catch: Throwable -> L4
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L10;
        FLogger.a.e("LocalMediaMenuShareHelper", "shareLocal failed, mimeType=".concat(r4), r7);
    L10:
        return Result.isSuccess-impl(r6);
    L4:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static final Object a(u r7, Context r8, Uri r9, boolean r10, Continuation r11) {
        r7.getClass();
        if ((r11 instanceof LocalMediaMenuShareHelper$resolveLocalShareUri$1) == false) goto L7;
        LocalMediaMenuShareHelper$resolveLocalShareUri$1 r0 = (LocalMediaMenuShareHelper$resolveLocalShareUri$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L17;
        if (r2 == 1) goto L16;
        if (r2 != 2) goto L15;
        ResultKt.throwOnFailure(r12);
    L61:
        return r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r14 = (String) r0.L$1;
        Context r15 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L47:
        r12 = (Uri) r12;
        if (r12 != null) goto L61;
        Uri r16 = i1.c(r15, new PolarisFileWrapper(r14));
        if (r16 == null) goto L60;
        return r16;
    L60:
        return null;
    L17:
        ResultKt.throwOnFailure(r12);
        if (r9 == null) goto L60;
        if (Intrinsics.areEqual(r9.getScheme(), "content") == true) goto L63;
        String r17 = r9.getScheme();
        if (r17 != null) goto L26;
    L31:
        String r18 = r9.toString();
        Intrinsics.checkNotNull(r18);
        if (StringsKt.startsWith$default(r18, "/", false, 2, null) == true) goto L35;
        r18 = null;
    L35:
        if (r18 == null) goto L60;
        if (StringsKt.isBlank(r18) == true) goto L60;
        if (new PolarisFileWrapper(r18).exists() == false) goto L60;
        if (r10 == false) goto L53;
        ImageSave r19 = ImageSave.a;
        String r110 = new PolarisFileWrapper(r18).getName();
        r0.L$0 = r8;
        r0.L$1 = r18;
        r0.label = 1;
        Object r20 = ImageSave.l(r19, r8, r18, r110, r0);
        if (r20 == r13) goto L62;
        r14 = r18;
        r12 = r20;
        r15 = r8;
    L62:
        return r13;
    L53:
        Uri r21 = i1.c(r8, new PolarisFileWrapper(r18));
        if (r21 != null) goto L65;
        ImageSave r22 = ImageSave.a;
        String r111 = new PolarisFileWrapper(r18).getName();
        r0.label = 2;
        r12 = ImageSave.l(r22, r8, r18, r111, r0);
        if (r12 != r13) goto L61;
    L65:
        return r21;
    L26:
        if (r17.hashCode() != 3143036) goto L31;
        if (r17.equals("file") == false) goto L31;
        r18 = r9.getPath();
        goto L35
    L63:
        return r9;
    L7:
        r0 = new LocalMediaMenuShareHelper$resolveLocalShareUri$1(r7, r11);
        goto L8
    }
}
