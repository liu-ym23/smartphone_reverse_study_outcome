package com.obric.assistant.omnidetailpage.localmedia;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LocalMediaShareHelper {
    public static final LocalMediaShareHelper a = null;

    static {
        a = new LocalMediaShareHelper();
    }

    public LocalMediaShareHelper() {
    }

    public static void e(Context r2) {
        Toast.makeText(r2.getApplicationContext(), "分享失败", 0).show();
    }

    public final void c(final Context r20, ifa.c r21) {
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r21, "item");
        boolean r2 = r21 instanceof ifa.c.a;
        if (r2 == false) goto L6;
        String r3 = "image";
    L8:
        FlowFileProtectionService r4 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        boolean r5 = false;
        if (r4 != null) goto L11;
    L13:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L25;
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r6 = new JSONObject();
        r6.put("action", "share");
        r6.put("entry", "omni_detail_local_media");
        r6.put("channel", "system_share");
        r6.put("content_type", r3);
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("flow_enterprise_file_egress_block", r6);
        String r1 = r4.A0();
        if (r1 != null) goto L19;
        return;
    L19:
        if ((!StringsKt.isBlank(r1)) == false) goto L21;
        String r9 = r1;
    L22:
        if (r9 == null) goto L51;
        t19.s.j(t19.s.a, r20, r9, null, false, 28);
        return;
    L51:
        return;
    L21:
        r9 = null;
        goto L22
    L25:
        if (r2 == false) goto L29;
        String r10 = ((ifa.c.a) r21).c;
    L27:
        String r11 = r10;
        final String r12 = r3.concat("/*");
        String r13 = a(r20, r11, false);
        if (r13 != null) goto L44;
        if (r2 == true) goto L35;
    L42:
        e(r20);
        return;
    L35:
        if (StringsKt.startsWith$default(r11, "http://", false, 2, null) == false) goto L37;
    L38:
        r5 = true;
    L39:
        if (r5 == false) goto L42;
        ImageSave.z(ImageSave.a, r11, null, null, null, false, false, null, new e(this, r20, r12), 126);
        return;
    L37:
        if (StringsKt.startsWith$default(r11, "https://", false, 2, null) == false) goto L39;
    L44:
        d(r20, r13, r12);
        return;
    L29:
        if ((r21 instanceof ifa.c.b) == false) goto L47;
        r10 = ((ifa.c.b) r21).c;
        goto L27
    L47:
        throw new NoWhenBranchMatchedException();
    L11:
        if (r4.I0() != true) goto L13;
        r7 = true;
        goto L15
    L6:
        if ((r21 instanceof ifa.c.b) == false) goto L49;
        r3 = "video";
        goto L8
    L49:
        throw new NoWhenBranchMatchedException();
    }

    public static String a(Context r8, String r9, boolean r10) {
        l.a.getClass();
        String r11 = l.b(r9);
        if (r11 != null) goto L56;
        return null;
    L56:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(new PolarisFileWrapper(r11).getCanonicalFile());     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r12) == false) goto L12;
        r12 = null;
    L12:
        File r13 = (File) r12;
        if (r13 != null) goto L15;
        return null;
    L15:
        String r2 = r13.getPath();
        a.getClass();
        Context r14 = r8.getApplicationContext();
        boolean r4 = false;
        List r15 = CollectionsKt.listOfNotNull(new File[]{r14.getFilesDir(), r14.getCacheDir(), r14.getExternalFilesDir(null), r14.getExternalFilesDir(Environment.DIRECTORY_DCIM), r14.getExternalCacheDir()});
        if (r10 == false) goto L22;
        List r16 = r15;
        String r17 = com.larus.utils.r.h();
        if (r17 == null) goto L20;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r17);
    L21:
        r15 = CollectionsKt.plus(r16, CollectionsKt.listOfNotNull(r3));
        goto L22
    L20:
        r3 = null;
    L22:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r15.iterator();
    L24:
        if (r19.hasNext() == false) goto L37;
        File r5 = (File) r19.next();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L28
        Object r7 = Result.constructor-impl(r5.getCanonicalFile());     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r7) == false) goto L33;
        r7 = null;
    L33:
        File r20 = (File) r7;
        if (r20 == null) goto L24;
        r18.add(r20);
    L28:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L37:
        if (r18.isEmpty() == true) goto L51;
        Iterator r22 = r18.iterator();
    L41:
        if (r22.hasNext() == false) goto L51;
        File r110 = (File) r22.next();
        a.getClass();
        if (Intrinsics.areEqual(r13.getPath(), r110.getPath()) == false) goto L45;
    L48:
        boolean r111 = true;
    L49:
        if (r111 == false) goto L41;
        r4 = true;
        goto L51
    L45:
        if (StringsKt.startsWith$default(r13.getPath(), r110.getPath() + File.separator, false, 2, null) == true) goto L48;
        r111 = false;
    L51:
        if (r4 == true) goto L53;
        return null;
    L53:
        return r2;
    L7:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static void d(Context r4, String r5, String r6) {
        OmniDetailLocalFileOpenHelper r0 = OmniDetailLocalFileOpenHelper.a;
        String r1 = StringsKt.substringAfterLast$default(r5, '/', null, 2, null);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r1, "fileName");
        OmniDetailLocalFileOpenHelper.a r7 = OmniDetailLocalFileOpenHelper.d(r4, r5, r1);
        if (r7 == null) goto L5;
        Uri r8 = r7.a;
    L6:
        if (r8 != null) goto L9;
        e(r4);
        return;
    L9:
        Intent r2 = new Intent("android.intent.action.SEND");
        r2.setType(r6);
        r2.putExtra("android.intent.extra.STREAM", r8);
        r2.addFlags(1);
        Iterator<T> r3 = r4.getPackageManager().queryIntentActivities(r2, 0).iterator();
    L11:
        if (r3.hasNext() == false) goto L21;
        r4.grantUriPermission(((ResolveInfo) r3.next()).activityInfo.packageName, r8, 1);
        goto L11
    L21:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L15
        Intent r10 = Intent.createChooser(r2, null);     // Catch: Throwable -> L15
        r10.addFlags(268435456);     // Catch: Throwable -> L15
        r10.addFlags(1);     // Catch: Throwable -> L15
        r4.startActivity(r10);     // Catch: Throwable -> L15
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L18:
        if (Result.exceptionOrNull-impl(r11) == null) goto L23;
        a.getClass();
        e(r4);
        return;
    L23:
        return;
    L15:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        r8 = null;
        goto L6
    }

    public final Object b(Context r23, ifa.c r24, Continuation<? super Boolean> r25) {
        if ((r25 instanceof LocalMediaShareHelper$save$1) == false) goto L7;
        LocalMediaShareHelper$save$1 r3 = (LocalMediaShareHelper$save$1) r25;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = false;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        Context r0 = (Context) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L57:
        String r11 = (String) r2;
    L59:
        if (r11 == null) goto L61;
        String r8 = r11;
    L65:
        if (com.larus.utils.r.u(r0, r8, true) == null) goto L83;
        r7 = true;
    L83:
        return Boxing.boxBoolean(r7);
    L61:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        boolean r9 = r24 instanceof ifa.c.a;
        if (r9 == false) goto L18;
        String r10 = "image";
    L20:
        FlowFileProtectionService r12 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r12 != null) goto L23;
    L25:
        boolean r13 = false;
    L26:
        r11 = null;
        if (r13 == false) goto L37;
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r14 = new JSONObject();
        r14.put("action", "save_album");
        r14.put("entry", "omni_detail_local_media");
        r14.put("channel", "album");
        r14.put("content_type", r10);
        Unit r15 = Unit.INSTANCE;
        r1.reportEvent("flow_enterprise_file_egress_block", r14);
        String r16 = r12.H0();
        if (r16 != null) goto L31;
    L36:
        return null;
    L31:
        if ((!StringsKt.isBlank(r16)) == false) goto L33;
        String r17 = r16;
    L34:
        if (r17 == null) goto L36;
        t19.s.j(t19.s.a, r23, r17, null, false, 28);
        goto L36
    L33:
        r17 = null;
        goto L34
    L37:
        if (r9 == false) goto L69;
        ifa.c.a r18 = (ifa.c.a) r24;
        r8 = a(r23, r18.c, false);
        if (r8 != null) goto L63;
        String r19 = r18.c;
        a.getClass();
        if (StringsKt.startsWith$default(r19, "http://", false, 2, null) == false) goto L43;
    L46:
        boolean r20 = true;
    L47:
        if (r20 == false) goto L49;
        String r110 = r19;
    L50:
        if (r110 == null) goto L58;
        r3.L$0 = r23;
        r3.label = 1;
        kotlinx.coroutines.j r21 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r3), 1);
        r21.C();
        ImageSave.z(ImageSave.a, r110, null, null, null, false, false, null, new f(r21, r23), 126);
        r2 = r21.B();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L54;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L54:
        if (r2 != r5) goto L56;
        return r5;
    L56:
        r0 = r23;
        goto L57
    L58:
        r0 = r23;
        goto L59
    L49:
        r110 = null;
        goto L50
    L43:
        if (StringsKt.startsWith$default(r19, "https://", false, 2, null) == true) goto L46;
        r20 = false;
        goto L47
    L63:
        r0 = r23;
        goto L65
    L69:
        if ((r24 instanceof ifa.c.b) == false) goto L80;
        String r22 = a(r23, ((ifa.c.b) r24).c, false);
        if (r22 != null) goto L75;
        return Boxing.boxBoolean(false);
    L75:
        if (com.larus.utils.r.u(r23, r22, false) == null) goto L78;
        r7 = true;
    L78:
        return Boxing.boxBoolean(r7);
    L80:
        throw new NoWhenBranchMatchedException();
    L23:
        if (r12.I0() != true) goto L25;
        r13 = true;
        goto L26
    L18:
        if ((r24 instanceof ifa.c.b) == false) goto L82;
        r10 = "video";
        goto L20
    L82:
        throw new NoWhenBranchMatchedException();
    L7:
        r3 = new LocalMediaShareHelper$save$1(this, r25);
        goto L8
    }
}
