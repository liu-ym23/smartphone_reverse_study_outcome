package com.larus.agents.impl.webfetch;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.larus.im.internal.jni.bean.DispatchErrorCode;
import com.larus.im.internal.jni.bean.WebpageContent;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q {
    public static final Gson a = null;

    static {
        a = new GsonBuilder().registerTypeAdapter(WebpageContent.class, new p()).create();
    }

    public static final s a(i r12, l r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "command");
        Intrinsics.checkNotNullParameter(r13, "outcome");
        Intrinsics.checkNotNullParameter(r14, "localDeviceId");
        String r1 = r12.b;
        int r2 = r12.c;
        Gson r3 = a;
        String r5 = r12.a;
        String r16 = r13.b;
        boolean r4 = false;
        if (r16 == null) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L8;
        DispatchErrorCode r8 = DispatchErrorCode.DISPATCH_ERROR_CODE_SUCCESS;
    L9:
        int r9 = r8.value;
        int r10 = r13.a;
        if (r16 == null) goto L12;
        r4 = true;
    L12:
        if (r4 == false) goto L17;
        String r17 = r13.b;
        if (r17 != null) goto L16;
        r17 = "";
    L16:
        List r19 = CollectionsKt.listOf(new WebpageContent(null, r17, 1, null));
    L19:
        return new s(r1, r2, GsonProtectorUtils.toJson(r3, new r(r5, r14, r15, r9, new n(new o(r10, r19)), 32)));
    L17:
        r19 = CollectionsKt.emptyList();
        goto L19
    L8:
        r8 = DispatchErrorCode.DISPATCH_ERROR_CODE_GET_WEBPAGE_FAILED;
        goto L9
    L5:
        r7 = false;
        goto L6
    }
}
