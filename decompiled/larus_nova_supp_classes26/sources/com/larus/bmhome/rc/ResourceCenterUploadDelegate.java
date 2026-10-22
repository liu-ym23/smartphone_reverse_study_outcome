package com.larus.bmhome.rc;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import mr9.j;
import mr9.k;
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResourceCenterUploadDelegate implements i {
    public final CoroutineScope a;
    public final h b;
    public final com.larus.bmhome.rc.a c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.rc.i
    public final void a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "processResult");
        this.c.b.invoke(r2);
    }

    @Override // com.larus.bmhome.rc.i
    public final void b(ResourceUploadError r12) {
        Intrinsics.checkNotNullParameter(r12, "processError");
        this.c.c.invoke(r12);     // Catch: Throwable -> L6
        ms8.b r2 = ms8.b.a;
        ms8.b.g(r2, this.b.a, "callback_fail", "fail", null, r12, 40);
        ms8.b.d(r2, this.b.a, "fail", r12, 8);
        return;
    L6:
        th = move-exception;
        ms8.b r10 = ms8.b.a;
        ms8.b.g(r10, this.b.a, "callback_fail", "fail", null, r12, 40);
        ms8.b.d(r10, this.b.a, "fail", r12, 8);
        throw th;
    }

    @Override // com.larus.bmhome.rc.i
    public final void c(l r12) {
        Intrinsics.checkNotNullParameter(r12, "uploadResult");
        if (r12.a != null) goto L11;
        ResourceUploadError r13 = new ResourceUploadError("upload_imagex_error", "tosKey is null");
        this.c.c.invoke(r13);     // Catch: Throwable -> L8
        ms8.b r9 = ms8.b.a;
        ms8.b.g(r9, this.b.a, "callback_fail", "fail", null, r13, 40);
        ms8.b.d(r9, this.b.a, "fail", r13, 8);
        return;
    L8:
        th = move-exception;
        ms8.b r10 = ms8.b.a;
        ms8.b.g(r10, this.b.a, "callback_fail", "fail", null, r13, 40);
        ms8.b.d(r10, this.b.a, "fail", r13, 8);
        throw th;
    L11:
        this.c.b.invoke(new k(99L, false));
        BuildersKt.launch$default(this.a, null, null, new ResourceCenterUploadDelegate$onUploadSuccess$1(this, r12, null), 3, null);
    }

    public final void e(ResourceUploadError r11, Map<String, ? extends Object> r12) {
        ms8.b r7 = ms8.b.a;
        h r0 = this.b;
        j r1 = r0.a;
        FlowResourceScene.a r3 = FlowResourceScene.Companion;
        String r2 = r0.d;
        r3.getClass();
        Map r13 = MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_scene", FlowResourceScene.a.a(r2).name()), TuplesKt.to("register_type", "normal_after_upload"), TuplesKt.to("api_name", "resource_register"), TuplesKt.to("api_path", "/alice/resource/register")}), r12);
        r7.getClass();
        ms8.b.b(r1, "resource_register", "fail", r11, r13);
        FLogger.a.e("ResourceCenterUploadDelegate", "[registerResource] failed, error=" + r11);
        this.c.c.invoke(r11);     // Catch: Throwable -> L6
        ms8.b.g(r7, this.b.a, "callback_fail", "fail", null, r11, 40);
        ms8.b.d(r7, this.b.a, "fail", r11, 8);
        return;
    L6:
        th = move-exception;
        ms8.b r9 = ms8.b.a;
        ms8.b.g(r9, this.b.a, "callback_fail", "fail", null, r11, 40);
        ms8.b.d(r9, this.b.a, "fail", r11, 8);
        throw th;
    }

    public ResourceCenterUploadDelegate(CoroutineScope r2, h r3, com.larus.bmhome.rc.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "uploadContext");
        Intrinsics.checkNotNullParameter(r4, "bizCallback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static final Object d(ResourceCenterUploadDelegate r13, l r14, Continuation r15) {
        r13.getClass();
        if ((r15 instanceof ResourceCenterUploadDelegate$registerResource$1) == false) goto L7;
        ResourceCenterUploadDelegate$registerResource$1 r0 = (ResourceCenterUploadDelegate$registerResource$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ResourceCenterUploadDelegate$registerResource$1 r9 = r0;
        Object r16 = r9.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r9.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r16);     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
    L19:
        ResourceRegisterData r17 = (ResourceRegisterData) r16;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        ms8.b r4 = ms8.b.a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        h r18 = r13.b;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        j r5 = r18.a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        FlowResourceScene.a r7 = FlowResourceScene.Companion;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        String r19 = r18.d;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        r7.getClass();     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        ms8.b.c(r4, r5, "resource_register", "success", null, MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_scene", FlowResourceScene.a.a(r19).name()), TuplesKt.to("register_type", "normal_after_upload"), TuplesKt.to("api_name", "resource_register"), TuplesKt.to("api_path", "/alice/resource/register")}), 8);     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
    L30:
        return (ResourceRegisterData) r16;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        ms8.b r110 = ms8.b.a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        j r6 = r13.b.a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        r110.getClass();     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        ms8.b.i(r6, "resource_register");     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        ResourceCenterPostUploadSupport r111 = ResourceCenterPostUploadSupport.a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        h r112 = r13.b;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        UplinkFileEntity r8 = r112.c;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        ResourceAttachmentExtra r10 = r112.b;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        String r11 = r112.d;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        j r113 = r112.a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        String r12 = r113.l;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        FlowResourceType r20 = com.larus.bmhome.upload.a.a(r113);     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        Long r21 = r13.b.a.t;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        r9.label = 1;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        r16 = ResourceCenterPostUploadSupport.b(r14, r8, r10, r11, r12, r20, null, r21, r9, 64);     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        if (r16 != r2) goto L19;
        return r2;
    L23:
        e = move-exception;
        r13.e(e.getUploadError(), e.getTraceExtra());
    L26:
        return null;
    L21:
        e = move-exception;
        r13.e(e, MapsKt.emptyMap());
    L7:
        r0 = new ResourceCenterUploadDelegate$registerResource$1(r13, r15);
        goto L8
    }
}
