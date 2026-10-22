package com.larus.uaigc.helper;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o0 {
    public static ParcelFileDescriptor a(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public static final Long b(Uri r8, String r9) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L34
        File r2 = new PolarisFileWrapper(r9);     // Catch: Throwable -> L34
        boolean r3 = true;
        if ((!StringsKt.isBlank(r9)) == true) goto L6;
    L8:
        boolean r10 = false;
    L9:
        if (r10 == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        Long r11 = Long.valueOf(r2.length());     // Catch: Throwable -> L34
    L32:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r12) == true) goto L41;
        r0 = r12;
    L41:
        return (Long) r0;
    L14:
        ParcelFileDescriptor r13 = a(AppHost.a.getApplication().getContentResolver(), r8);     // Catch: Throwable -> L34
        if (r13 != null) goto L43;
        r11 = null;
        goto L32
    L43:
        Long r14 = Long.valueOf(r13.getStatSize());     // Catch: Throwable -> L26
    L18:
        if (r14.longValue() >= 0) goto L21;
        r3 = false;
    L21:
        if (r3 == true) goto L24;
        r14 = null;
    L24:
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L34
        r11 = r14;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L6:
        if (r2.isFile() == false) goto L8;
        r10 = true;
    L34:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    }

    public static final ResourceItemBean c(Uri r30, String r31) {
        if (r30 != null) goto L5;
        return null;
    L5:
        if (r31 == null) goto L40;
        String r4 = r31;
    L10:
        ImFileUtil.a.getClass();     // Catch: Throwable -> L7
        boolean r2 = ImFileUtil.w(r30);     // Catch: Throwable -> L7
        boolean r3 = ImFileUtil.y(r30);     // Catch: Throwable -> L7
        String r5 = vqc.d.d(AppHost.a.getApplication(), r30);     // Catch: Throwable -> L7
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        Long r24 = b(r30, r5);     // Catch: Throwable -> L7
        String r26 = StringsKt.substringAfterLast$default(r5, '.', null, 2, null);     // Catch: Throwable -> L7
        String r7 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast$default(r5, '.', null, 2, null));     // Catch: Throwable -> L7
        if (r7 != null) goto L17;
        String r27 = "";
    L19:
        if (r2 == false) goto L28;
        ItemStatus r0 = ItemStatus.UPLINKING;     // Catch: Throwable -> L7
        ResourceType r6 = ResourceType.IMAGE;     // Catch: Throwable -> L7
        Image r28 = new Image(UUID.randomUUID().toString(), "", null, null, null, r5, null, null, null, null, null, null, null, null, 16348, null);     // Catch: Throwable -> L7
        int r14 = i5.w0();     // Catch: Throwable -> L7
        HashMap r13 = new HashMap();     // Catch: Throwable -> L7
        r13.put("ext_img_show_path", r5);     // Catch: Throwable -> L7
        if (r24 == null) goto L23;
        r13.put("ext_creation_reference_file_size", Long.valueOf(r24.longValue()));     // Catch: Throwable -> L7
    L23:
        f.a.getClass();     // Catch: Throwable -> L7
        Boolean r8 = f.c().d();     // Catch: Throwable -> L7
        Boolean r9 = Boolean.TRUE;     // Catch: Throwable -> L7
        if (Intrinsics.areEqual(r8, r9) == false) goto L41;
        r13.put("ext_silent_upload", r9);     // Catch: Throwable -> L7
    L41:
        return new ResourceItemBean(r4, null, r26, r27, r28, null, 0, r0, false, r6, r14, 0, 0, 0, false, false, false, false, 0, r13, 522530, null);
    L28:
        if (r3 == false) goto L42;
        ItemStatus r23 = ItemStatus.UPLINKING;     // Catch: Throwable -> L7
        ResourceType r29 = ResourceType.VIDEO;     // Catch: Throwable -> L7
        mt8.b r210 = new mt8.b(null, 0.0f, 0, 0, r5, null, null, null, null, 492);     // Catch: Throwable -> L7
        int r15 = i5.w0();     // Catch: Throwable -> L7
        HashMap r16 = new HashMap();     // Catch: Throwable -> L7
        r16.put("ext_video_local_uri", r30.toString());     // Catch: Throwable -> L7
        if (r24 == null) goto L32;
        r16.put("ext_creation_reference_file_size", Long.valueOf(r24.longValue()));     // Catch: Throwable -> L7
    L32:
        f.a.getClass();     // Catch: Throwable -> L7
        Boolean r1 = f.c().d();     // Catch: Throwable -> L7
        Boolean r10 = Boolean.TRUE;     // Catch: Throwable -> L7
        if (Intrinsics.areEqual(r1, r10) == false) goto L37;
        r16.put("ext_silent_upload", r10);     // Catch: Throwable -> L7
    L37:
        return new ResourceItemBean(r4, null, r26, r27, null, r210, 0, r23, false, r29, r15, 0, 0, 0, false, false, false, false, 0, r16, 522514, null);
    L42:
        return null;
    L17:
        r27 = r7;
        goto L19
    L40:
        r4 = UUID.randomUUID().toString();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        com.larus.platform.service.g.a.ensureNotReachHere(th);
        return null;
    }
}
