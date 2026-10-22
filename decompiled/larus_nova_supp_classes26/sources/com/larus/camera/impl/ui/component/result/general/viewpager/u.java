package com.larus.camera.impl.ui.component.result.general.viewpager;

import com.larus.camera.api.params.OutputParam;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u {
    public static final boolean a(OutputParam r3) {
        String r0 = null;
        if (r3 == null) goto L5;
        OutputParam.ResultType r1 = r3.getResultType();
    L7:
        if (r1 != OutputParam.ResultType.PHOTO) goto L14;
        String r4 = r3.getPath();
        if (r4 == null) goto L12;
        r0 = StringsKt.substringAfterLast(r4, '.', "");
    L12:
        if (StringsKt.equals(r0, "gif", true) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r1 = null;
        goto L7
    }
}
