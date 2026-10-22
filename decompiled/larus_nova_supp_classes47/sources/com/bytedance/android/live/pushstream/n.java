package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Predicate;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Predicate {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final boolean test(Object r6) {
        File r7 = (File) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        ALogger.e("LiveStream", r7.getName());
        if (StringsKt.endsWith$default(r7.getName(), ".so", false, 2, null) == true) goto L5;
        return false;
    L5:
        if (r7.isFile() == false) goto L9;
        return true;
    L9:
        return false;
    }
}
