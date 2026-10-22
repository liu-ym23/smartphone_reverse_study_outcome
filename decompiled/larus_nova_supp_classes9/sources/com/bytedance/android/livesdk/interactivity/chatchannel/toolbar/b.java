package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoadResultType;
import com.bytedance.android.livesdk.chatroom.utils.a4;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements a4 {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void a(Disposable r2) {
        RxUtilKt.c(r2, this.a.b);
    }

    public final void b(SkinLoadResultType r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "result");
        Intrinsics.checkNotNullParameter(r1, "result");
    }
}
