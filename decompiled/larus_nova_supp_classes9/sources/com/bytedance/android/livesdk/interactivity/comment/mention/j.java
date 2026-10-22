package com.bytedance.android.livesdk.interactivity.comment.mention;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        ALogger.e("MentionSectionController", " query user failed.");
    }
}
