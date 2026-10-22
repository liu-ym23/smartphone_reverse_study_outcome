package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.nestedfile.INestedFileCacheManagerService;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import kotlin.jvm.internal.Intrinsics;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements c {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.c
    public final UplinkFileEntity a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgId");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        return NestedFileCacheManagerService.b.a(r2, r3);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.c
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgId");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        NestedFileCacheManagerService.b.b(r2, r3);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.c
    public final void c(String r2, UplinkFileEntity r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgId");
        Intrinsics.checkNotNullParameter(r3, "entity");
        NestedFileCacheManagerService.b.c(r2, r3);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.c
    public final void e(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "localMsgId");
        Intrinsics.checkNotNullParameter(r10, "fileIdentifier");
        INestedFileCacheManagerService.a.a(NestedFileCacheManagerService.b, r9, r10, UpLinkState.FAIL, null, null, 56);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.c
    public final void g(String r2, UplinkFileEntity r3) {
        Intrinsics.checkNotNullParameter(r2, "localMsgId");
        Intrinsics.checkNotNullParameter(r3, "entity");
        NestedFileCacheManagerService.b.l(r2, r3);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.c
    public final void f(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "localMsgId");
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        NestedFileCacheManagerService.b.m(r2, r3, r4);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.c
    public final void d(String r17, UplinkFileEntity r18, String r19, mr9.l r20, Boolean r21, Boolean r22) {
        Intrinsics.checkNotNullParameter(r17, "localMsgId");
        Intrinsics.checkNotNullParameter(r18, "entity");
        Intrinsics.checkNotNullParameter(r19, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r20, "uploadResult");
        NestedFileCacheManagerService r2 = NestedFileCacheManagerService.b;
        String r6 = l1.e(r18);
        String r7 = r20.a;
        String r8 = r20.c;
        ResourceUploadInstantInfo r4 = r20.g;
        String r9 = null;
        if (r4 == null) goto L5;
        String r10 = GsonProtectorUtils.toJson(new Gson(), r4);
    L6:
        mr9.d r5 = r20.d;
        int r12 = 0;
        if (r5 == null) goto L9;
        int r13 = r5.b;
    L10:
        if (r5 == null) goto L12;
        int r11 = r5.a;
    L13:
        lr8.b r14 = new lr8.b(r13, r11, r21, r22);
        mr9.n r15 = r20.e;
        if (r15 == null) goto L16;
        String r16 = r15.a;
    L17:
        if (r15 == null) goto L21;
        mr9.e r23 = r15.c;
        if (r23 == null) goto L21;
        r9 = r23.f();
    L21:
        mr9.n r24 = r20.e;
        if (r24 == null) goto L28;
        mr9.e r25 = r24.c;
        if (r25 == null) goto L28;
        Integer r26 = r25.j();
        if (r26 == null) goto L28;
        int r27 = r26.intValue();
    L29:
        mr9.n r0 = r20.e;
        if (r0 == null) goto L36;
        mr9.e r1 = r0.c;
        if (r1 == null) goto L36;
        Integer r3 = r1.h();
        if (r3 == null) goto L36;
        r12 = r3.intValue();
    L36:
        r2.f(r17, new lr8.d(r19, r6, r7, r8, r10, r14, new lr8.h(r16, r9, r12, r27)));
        String r28 = r18.getFileIdentifier();
        if (r28 != null) goto L39;
        r28 = "";
    L39:
        INestedFileCacheManagerService.a.a(r2, r17, r28, UpLinkState.SUCCESS, null, null, 56);
        return;
    L28:
        r27 = 0;
        goto L29
    L16:
        r16 = null;
        goto L17
    L12:
        r11 = 0;
        goto L13
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = null;
        goto L6
    }
}
