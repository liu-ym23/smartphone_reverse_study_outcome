package com.larus.bmhome.upload.sdk;

import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.PrepareUploadResult;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;
import mr9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResourceCenterTokenCredentialProvider implements hs8.f {
    public ResourceCenterTokenCredentialProvider() {
    }

    @Override // hs8.f
    public final boolean b(AuthMode r2) {
        Intrinsics.checkNotNullParameter(r2, "authMode");
        if (r2 != AuthMode.ResourceCenterPrepareUpload) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // hs8.f
    public final Object a(is8.g r23, is8.a r24, Continuation<? super hs8.e> r25) {
        if ((r25 instanceof ResourceCenterTokenCredentialProvider$fetch$1) == false) goto L7;
        ResourceCenterTokenCredentialProvider$fetch$1 r4 = (ResourceCenterTokenCredentialProvider$fetch$1) r25;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r1 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        String r11 = "";
        if (r7 == 0) goto L20;
        if (r7 != 1) goto L19;
        FlowResourceScene r0 = (FlowResourceScene) r4.L$4;
        FlowResourceType r8 = (FlowResourceType) r4.L$3;
        j r9 = (j) r4.L$2;
        is8.a r14 = (is8.a) r4.L$1;
        is8.g r10 = (is8.g) r4.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L14 ResourceUploadError -> L16
    L29:
        PrepareUploadResult r2 = (PrepareUploadResult) r1;     // Catch: Throwable -> L14 ResourceUploadError -> L16
        m r12 = r2.getResourceUploadToken();     // Catch: Throwable -> L14 ResourceUploadError -> L16
        if (r12 != null) goto L36;
        String r3 = r2.getFailReason();     // Catch: Throwable -> L14 ResourceUploadError -> L16
        if (r3 != null) goto L35;
        r3 = "";
    L35:
        throw new ResourceUploadError("upload_get_auth_token_error", r3);     // Catch: Throwable -> L14 ResourceUploadError -> L16
    L36:
        r9.h = r12;     // Catch: Throwable -> L14 ResourceUploadError -> L16
        ms8.b.c(ms8.b.a, r9, "prepare_upload", "success", null, MapsKt.mapOf(new Pair[]{TuplesKt.to("auth_mode", r14.a.name()), TuplesKt.to("resource_type", r8.name()), TuplesKt.to("resource_scene", r0.name())}), 8);     // Catch: Throwable -> L14 ResourceUploadError -> L16
        FLogger.a.i("ResourceUploadSdk", "[fetchResourceCenterToken] identifier=" + r10.c.f + ", scene=" + r0 + ", resourceType=" + r8);     // Catch: Throwable -> L14 ResourceUploadError -> L16
        return new hs8.e(r14.a, MapsKt.mapOf(new Pair[]{TuplesKt.to("credential_source", "resource_center_prepare_upload"), TuplesKt.to("resource_scene", r0.name())}));
    L16:
        e = e;
    L54:
        ms8.b r13 = ms8.b.a;
        Map r15 = MapsKt.mapOf(TuplesKt.to("auth_mode", r14.a.name()));
        r13.getClass();
        ms8.b.b(r9, "prepare_upload", "fail", e, r15);
        throw e;
    L14:
        th = th;
    L47:
        String r16 = th.getMessage();
        if (r16 == null) goto L51;
        r11 = r16;
    L51:
        ResourceUploadError r17 = new ResourceUploadError("upload_get_auth_token_error", r11);
        ms8.b r18 = ms8.b.a;
        Map r19 = MapsKt.mapOf(TuplesKt.to("auth_mode", r14.a.name()));
        r18.getClass();
        ms8.b.b(r9, "prepare_upload", "fail", r17, r19);
        throw r17;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r1);
        ConcurrentHashMap<String, j> r20 = g.a;
        Intrinsics.checkNotNullParameter(r23, "request");
        String r21 = r23.c.f;
        Intrinsics.checkNotNullParameter(r21, "identifier");
        r9 = g.a.get(r21);
        if (r9 == null) goto L57;
        ms8.b.a.getClass();
        ms8.b.i(r9, "prepare_upload");
        FlowResourceType r22 = com.larus.bmhome.upload.a.a(r9);     // Catch: Throwable -> L42 ResourceUploadError -> L44
        FlowResourceScene r110 = e.a(r23, r9.l);     // Catch: Throwable -> L42 ResourceUploadError -> L44
        ResourceCenter r111 = ResourceCenter.a;     // Catch: Throwable -> L42 ResourceUploadError -> L44
        FlowResourceScene.Companion.getClass();     // Catch: Throwable -> L42 ResourceUploadError -> L44
        String r112 = FlowResourceScene.a.b(r110);     // Catch: Throwable -> L42 ResourceUploadError -> L44
        r4.L$0 = r23;     // Catch: Throwable -> L42 ResourceUploadError -> L44
        is8.a r26 = r24;
        r4.L$1 = r26;     // Catch: Throwable -> L38 ResourceUploadError -> L40
        r4.L$2 = r9;     // Catch: Throwable -> L38 ResourceUploadError -> L40
        r4.L$3 = r22;     // Catch: Throwable -> L38 ResourceUploadError -> L40
        r4.L$4 = r110;     // Catch: Throwable -> L38 ResourceUploadError -> L40
        r4.label = 1;     // Catch: Throwable -> L38 ResourceUploadError -> L40
        Object r27 = r111.j(r22, r112, r4);     // Catch: Throwable -> L38 ResourceUploadError -> L40
        if (r27 != r6) goto L28;
        return r6;
    L28:
        r10 = r23;
        r8 = r22;
        r1 = r27;
        r0 = r110;
        r14 = r26;
        goto L29
    L40:
        e = e;
    L53:
        r14 = r26;
    L38:
        th = th;
    L46:
        r14 = r26;
        goto L47
    L44:
        e = e;
        r26 = r24;
    L42:
        th = th;
        r26 = r24;
        goto L46
    L57:
        throw new ResourceUploadError("upload_get_auth_token_error", "origin param missing");
    L7:
        r4 = new ResourceCenterTokenCredentialProvider$fetch$1(this, r25);
        goto L8
    }
}
