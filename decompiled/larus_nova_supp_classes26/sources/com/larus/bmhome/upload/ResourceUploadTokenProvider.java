package com.larus.bmhome.upload;

import com.bytedance.keva.Keva;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import mr9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResourceUploadTokenProvider {
    public static final ResourceUploadTokenProvider a = null;

    static {
        a = new ResourceUploadTokenProvider();
    }

    public ResourceUploadTokenProvider() {
    }

    public static void b(mr9.j r5) {
        Intrinsics.checkNotNullParameter(r5, "param");
        UploadDataType r0 = r5.c;
        Intrinsics.checkNotNullParameter(r0, "dataType");
        Keva r2 = fs8.a.a;
        String r1 = r0.getType();
        Intrinsics.checkNotNullParameter(r1, "dataType");
        UploadDataType.Companion.getClass();
        String r3 = "";
        if (UploadDataType.a.a(r1) == false) goto L5;
        FLogger.a.d("UploaderCacheStrategy", "clear cache token");
        fs8.a.a.storeString("image_token_data" + r1 + fs8.a.a(), "");
    L5:
        ResourceCenter r4 = ResourceCenter.a;
        String r6 = r5.l;
        if (r6 == null) goto L9;
        r3 = r6;
    L9:
        r4.getClass();
        FlowResourceScene r7 = ResourceCenter.g(r3);
        FlowResourceType r8 = a.a(r5);
        Intrinsics.checkNotNullParameter(r7, "scene");
        Intrinsics.checkNotNullParameter(r8, "resourceType");
        if (ResourceCenter.f().a() == false) goto L14;
        com.larus.bmhome.rc.g.a r9 = new com.larus.bmhome.rc.g.a(r7, r8);
        com.larus.bmhome.rc.g.a.getClass();
        com.larus.bmhome.rc.g.b(r9);
        return;
    }

    public static boolean c(Long r5) {
        if (r5 != null) goto L5;
    L6:
        if (r5 != null) goto L9;
    L11:
        return false;
    L9:
        if (r5.longValue() != (-39982)) goto L11;
    L12:
        return true;
    L5:
        if (r5.longValue() == 100028) goto L12;
        goto L6
    }

    public final Object a(String r5, UploadDataType r6, Continuation<? super m> r7) {
        if ((r7 instanceof ResourceUploadTokenProvider$getToken$1) == false) goto L7;
        ResourceUploadTokenProvider$getToken$1 r0 = (ResourceUploadTokenProvider$getToken$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L21
    L19:
        Object r9 = Result.constructor-impl((m) r8);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r9) == false) goto L29;
        return null;
    L29:
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L21
        int r11 = com.larus.bmhome.upload.sdk.h.a;     // Catch: Throwable -> L21
        String r12 = r6.getType();     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r8 = com.larus.bmhome.upload.sdk.h.a(r5, r12, r0);     // Catch: Throwable -> L21
        if (r8 != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new ResourceUploadTokenProvider$getToken$1(this, r7);
        goto L8
    }
}
