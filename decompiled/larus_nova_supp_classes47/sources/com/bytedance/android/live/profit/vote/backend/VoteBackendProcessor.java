package com.bytedance.android.live.profit.vote.backend;

import com.bytedance.android.livesdk.revenue.service.room.b;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VoteBackendProcessor {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(long r12, final Function1 r13, final Function0 r14, CompositeDisposable r15) {
        Intrinsics.checkNotNullParameter(r13, "onSuccess");
        Intrinsics.checkNotNullParameter(r14, "onError");
        Intrinsics.checkNotNullParameter(r15, "cd");
        b.a.a(c.b(b.class), r12, com.bytedance.android.live.profit.vote.transfer.a.class, new VoteBackendProcessor$processWithBackendData$1(r14), null, new VoteBackendProcessor$processWithBackendData$2(r13), null, r15, 40);
    }
}
