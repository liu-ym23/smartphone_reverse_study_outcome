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
public final class x0 extends com.larus.bmhome.chat.component.bottom.multimodal.upload.a {
    public final /* synthetic */ AttachmentPanelComponent A;
    public final /* synthetic */ WeakReference<AttachmentPanelComponent> B;
    public final /* synthetic */ String y;
    public final /* synthetic */ UplinkFileEntity z;

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.a
    public final void f() {
        z2 r0 = z2.a;
        String r1 = "";
        if (z2.c4() == false) goto L8;
        Set<Pair<String, String>> r2 = this.A.k1;
        String r3 = this.y;
        String r4 = this.z.getFileIdentifier();
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r2.add(TuplesKt.to(r3, r4));
    L8:
        NestedFileCacheManagerService r5 = NestedFileCacheManagerService.b;
        String r6 = this.y;
        String r7 = this.z.getFileIdentifier();
        if (r7 == null) goto L12;
        r1 = r7;
    L12:
        r5.b(r6, r1);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.a, com.larus.bmhome.chat.component.bottom.multimodal.upload.m
    public final void d(ic8.n0 r13) {
        Intrinsics.checkNotNullParameter(r13, "processResult");
        super.d(r13);
        AttachmentPanelComponent r0 = this.B.get();
        if (r0 == null) goto L35;
        String r2 = this.y;
        UplinkFileEntity r1 = this.z;
        ProcessFileResultCode r14 = r13.b;
        if (r14 == null) goto L9;
        boolean r3 = true;
        if (r14.isSuccess() != true) goto L9;
    L10:
        if (r3 == true) goto L36;
        z2 r15 = z2.a;
        if (z2.c4() == true) goto L14;
    L15:
        AttachmentPanelComponent.z3(r0, r1);
        if (((ArrayList) r0.J).isEmpty() == false) goto L21;
        if (r0.V.isEmpty() == false) goto L21;
        r0.V4();
    L24:
        if (z2.c4() == false) goto L37;
        int r16 = AttachmentPanelComponent.g2;
        j1 r17 = r0.Y3();
        if (r17 == null) goto L38;
        NestedFileContent r4 = NestedFileCacheManagerService.b.b6(r2);
        if (r4 == null) goto L30;
        List r5 = r4.getEntities();
    L31:
        if (r5 != null) goto L33;
        r5 = CollectionsKt.emptyList();
    L33:
        j1.a.a(r17, r2, null, r5, true, false, null, null, null, r1.getFileIdentifier(), 242);
        return;
    L30:
        r5 = null;
        goto L31
    L38:
        return;
    L37:
        return;
    L21:
        if (((ArrayList) r0.J).isEmpty() == false) goto L24;
        r0.z5(new ArrayList());
        goto L24
    L14:
        if (Intrinsics.areEqual(r0.P, r2) == false) goto L24;
    L36:
        return;
    L9:
        r3 = false;
        goto L10
    }

    public x0(String r26, UplinkFileEntity r27, boolean r28, String r29, String r30, String r31, String r32, String r33, AttachmentPanelComponent r34, WeakReference<AttachmentPanelComponent> r35, String r36, String r37, Boolean r38, Boolean r39, String r40, ReferenceInfo r41, String r42, String r43) {
        this.y = r26;
        this.z = r27;
        this.A = r34;
        this.B = r35;
        super(r26, r27, r36, r37, r28, r29, r30, r31, r32, r33, r38, r39, r40, r41, r42, r43, null, null, null, null, null, 2031616);
    }
}
