package com.bytedance.android.livesdk.gift.grouplive.component.repo;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T, R> implements Function {
    public final /* synthetic */ GroupComponentRepo a;

    public a(GroupComponentRepo r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        ExtraResponse r5 = (ExtraResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        return GroupComponentRepo.a(this.a, (List) r5.data, System.currentTimeMillis());
    }
}
