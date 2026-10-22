package com.obric.assistant.component;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricSkillComponent$onParentViewCreated$1 extends FunctionReferenceImpl implements Function1<ic8.w, String> {
    public ObricSkillComponent$onParentViewCreated$1(Object r8) {
        super(1, r8, ObricSkillComponent.a.class, "buildAttachmentLocalFilePathExt", "buildAttachmentLocalFilePathExt(Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;)Ljava/lang/String;", 0);
    }

    public final String invoke(ic8.w r6) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        ((ObricSkillComponent.a) ((CallableReference) this).receiver).getClass();
        if ((r6 instanceof ai8.f) == false) goto L5;
        ai8.f r7 = (ai8.f) r6;
    L6:
        if (r7 == null) goto L54;
        NestedFileContent r8 = r7.a;
        if (r8 == null) goto L56;
        LinkedHashMap r0 = new LinkedHashMap();
        List r9 = r8.getEntities();
        if (r9 != null) goto L13;
        r9 = CollectionsKt.emptyList();
    L13:
        Iterator r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L35;
        UplinkFileEntity r2 = (UplinkFileEntity) r10.next();
        String r3 = r2.getFileIdentifier();
        if (r3 == null) goto L15;
        if ((!StringsKt.isBlank(r3)) == true) goto L22;
        r3 = null;
    L22:
        if (r3 == null) goto L15;
        String r4 = l1.d(r2);
        if (r4 == null) goto L15;
        if ((!StringsKt.isBlank(r4)) == true) goto L29;
        r4 = null;
    L29:
        if (r4 == null) goto L15;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r4);
        if (r5.isAbsolute() == false) goto L15;
        r0.put(r3, r5.getAbsolutePath());
        goto L15
    L35:
        if ((!r0.isEmpty()) == true) goto L38;
        r0 = null;
    L38:
        if (r0 != null) goto L40;
        return null;
    L40:
        return GsonProtectorUtils.toJson((Gson) ObricSkillComponent.C.getValue(), r0);
    L56:
        return null;
    L54:
        return null;
    L5:
        r7 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((ic8.w) r1);
    }
}
