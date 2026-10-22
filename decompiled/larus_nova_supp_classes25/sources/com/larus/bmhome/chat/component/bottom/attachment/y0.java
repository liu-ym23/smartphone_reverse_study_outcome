package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.service.z2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y0 extends com.larus.bmhome.chat.component.bottom.multimodal.upload.b {
    public final /* synthetic */ String K;
    public final /* synthetic */ UplinkFileEntity L;
    public final /* synthetic */ AttachmentPanelComponent M;
    public final /* synthetic */ WeakReference<AttachmentPanelComponent> N;

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.a
    public final void f() {
        z2 r0 = z2.a;
        String r1 = "";
        if (z2.c4() == false) goto L8;
        Set<Pair<String, String>> r2 = this.M.k1;
        String r3 = this.K;
        String r4 = this.L.getFileIdentifier();
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r2.add(TuplesKt.to(r3, r4));
    L8:
        NestedFileCacheManagerService r5 = NestedFileCacheManagerService.b;
        String r6 = this.K;
        String r7 = this.L.getFileIdentifier();
        if (r7 == null) goto L12;
        r1 = r7;
    L12:
        r5.b(r6, r1);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.b, com.larus.bmhome.chat.component.bottom.multimodal.upload.a, com.larus.bmhome.chat.component.bottom.multimodal.upload.m
    public final void d(ic8.n0 r13) {
        Intrinsics.checkNotNullParameter(r13, "processResult");
        super.d(r13);
        AttachmentPanelComponent r0 = this.N.get();
        if (r0 == null) goto L38;
        String r2 = this.K;
        UplinkFileEntity r1 = this.L;
        ProcessFileResultCode r14 = r13.b;
        if (r14 == null) goto L9;
        boolean r3 = true;
        if (r14.isSuccess() != true) goto L9;
    L10:
        if (r3 == true) goto L39;
        z2 r15 = z2.a;
        if (z2.c4() == false) goto L15;
        f();
    L15:
        if (z2.c4() == true) goto L17;
    L18:
        AttachmentPanelComponent.z3(r0, r1);
        if (((ArrayList) r0.J).isEmpty() == false) goto L24;
        if (r0.V.isEmpty() == false) goto L24;
        r0.V4();
    L27:
        if (z2.c4() == false) goto L40;
        int r16 = AttachmentPanelComponent.g2;
        j1 r17 = r0.Y3();
        if (r17 == null) goto L41;
        NestedFileContent r4 = NestedFileCacheManagerService.b.b6(r2);
        if (r4 == null) goto L33;
        List r5 = r4.getEntities();
    L34:
        if (r5 != null) goto L36;
        r5 = CollectionsKt.emptyList();
    L36:
        j1.a.a(r17, r2, null, r5, true, false, null, null, null, r1.getFileIdentifier(), 242);
        return;
    L33:
        r5 = null;
        goto L34
    L41:
        return;
    L40:
        return;
    L24:
        if (((ArrayList) r0.J).isEmpty() == false) goto L27;
        r0.z5(new ArrayList());
        goto L27
    L17:
        if (Intrinsics.areEqual(r0.P, r2) == false) goto L27;
    L39:
        return;
    L9:
        r3 = false;
        goto L10
    }

    public y0(String r16, UplinkFileEntity r17, boolean r18, String r19, String r20, String r21, String r22, Boolean r23, Boolean r24, AttachmentPanelComponent r25, WeakReference r26, String r27, String r28, String r29, ReferenceInfo r30) {
        this.K = r16;
        this.L = r17;
        this.M = r25;
        this.N = r26;
        super(r16, r17, r27, r28, r18, r19, r20, r21, r22, r23, r24, r29, r30);
    }
}
