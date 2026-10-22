package com.bytedance.android.live.room.share.summersinging;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T, R> implements Function {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final Object apply(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        ALogger.e("GroupPhotoDialogLauncher", "download avatar error: " + r4.getMessage());
        return sh6.a.a;
    }
}
