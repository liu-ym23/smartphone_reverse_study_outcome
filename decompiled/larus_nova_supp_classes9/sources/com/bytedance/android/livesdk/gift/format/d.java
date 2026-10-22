package com.bytedance.android.livesdk.gift.format;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ GiftPlayerView a;
    public final /* synthetic */ tr.a b;

    public d(GiftPlayerView r1, tr.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r6) {
        String r7 = (String) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        GiftPlayerView r0 = this.a;
        StringBuilder r1 = new StringBuilder("is need download assets: ");
        boolean r3 = false;
        if (r7.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        String r4 = r1.toString();
        int r5 = GiftPlayerView.k;
        r0.e(r4);
        if (r7.length() != 0) goto L9;
        r3 = true;
    L9:
        if (r3 == false) goto L12;
        GiftPlayerView r8 = this.a;
        long r9 = this.b.d;
        r8.getClass();
        return Single.create(new b(r8, r9));
    L12:
        return Single.just(r7);
    L5:
        r2 = false;
        goto L6
    }
}
