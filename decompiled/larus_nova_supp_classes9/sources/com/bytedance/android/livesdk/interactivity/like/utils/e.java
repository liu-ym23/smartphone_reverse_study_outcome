package com.bytedance.android.livesdk.interactivity.like.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements ObservableOnSubscribe {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void subscribe(ObservableEmitter<Pair<Uri, Uri>> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        ArrayList r0 = com.bytedance.android.livesdk.gecko.offline.f.a;
        String r1 = j.m;
        File r2 = com.bytedance.android.livesdk.gecko.offline.f.a(r1);
        String r3 = j.l;
        File r4 = com.bytedance.android.livesdk.gecko.offline.f.a(r3);
        if (r2 == null) goto L6;
        if (r4 == null) goto L6;
        r5.onNext(new Pair(Uri.fromFile(r2), Uri.fromFile(r4)));
    L7:
        r5.onComplete();
        return;
    L6:
        r5.onNext(new Pair(UriProtector.parse(r1), UriProtector.parse(r3)));
        goto L7
    }
}
