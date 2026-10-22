package com.bytedance.android.live.room.share.summersinging;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T, R> implements Function {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final Object apply(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        ALogger.e("GroupPhotoDialogLauncher", "download photo error: " + r4.getMessage());
        return sh6.a.a;
    }
}
