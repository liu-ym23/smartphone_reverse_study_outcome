package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ DigitAvatarRecognitionDialog a;

    public u(DigitAvatarRecognitionDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.getClass();
        Intrinsics.checkNotNullParameter("上传图片失败", "msg");
        ALogger.e("KtvDigitAvatar", "上传图片失败", (Throwable) r3);
    }
}
