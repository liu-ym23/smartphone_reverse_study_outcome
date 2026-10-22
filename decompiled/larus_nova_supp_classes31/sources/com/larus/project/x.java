package com.larus.project;

import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.internal.jni.bean.OmniProjectFolder;
import com.larus.im.internal.jni.bean.OmniProjectStatus;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x {
    public static final i a(OmniProject r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        String r2 = null;
        if (r12.status != OmniProjectStatus.OmniProjectStatus_DELETED) goto L5;
        return null;
    L5:
        String r0 = r12.projectId;
        if (r0 != null) goto L8;
    L33:
        return null;
    L8:
        if ((!StringsKt.isBlank(r0)) == false) goto L10;
        String r4 = r0;
    L11:
        if (r4 == null) goto L33;
        List r1 = r12.folders;
        if (r1 != null) goto L16;
        r1 = CollectionsKt.emptyList();
    L16:
        OmniProjectFolder r3 = (OmniProjectFolder) CollectionsKt.firstOrNull(r1);
        String r13 = r12.name;
        if (r13 != null) goto L19;
        r13 = "";
    L19:
        String r5 = r13;
        boolean r6 = r1.isEmpty();
        if (r3 == null) goto L22;
        String r7 = r3.folderName;
    L23:
        if (r3 == null) goto L25;
        String r8 = r3.workspace;
    L26:
        if (r3 == null) goto L28;
        String r9 = r3.folderDeviceId;
    L29:
        if (r3 == null) goto L32;
        r2 = r3.folderDeviceName;
    L32:
        return new i(r4, r5, r6, r7, r8, r9, r2);
    L28:
        r9 = null;
        goto L29
    L25:
        r8 = null;
        goto L26
    L22:
        r7 = null;
        goto L23
    L10:
        r4 = null;
        goto L11
    }
}
