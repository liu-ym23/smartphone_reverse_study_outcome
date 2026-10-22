package com.bytedance.android.live.saas.middleware;

import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R1\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/BDLiveSdkSubject;", "", "()V", "idSubject", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "", "getIdSubject", "()Lio/reactivex/subjects/PublishSubject;", "idSubject$delegate", "Lkotlin/Lazy;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BDLiveSdkSubject {
    public static final BDLiveSdkSubject INSTANCE = null;
    private static final Lazy idSubject$delegate = null;

    private BDLiveSdkSubject() {
    }

    public final PublishSubject<Pair<String, String>> getIdSubject() {
        return (PublishSubject) idSubject$delegate.getValue();
    }

    static {
        INSTANCE = new BDLiveSdkSubject();
        idSubject$delegate = LazyKt.lazy(BDLiveSdkSubject$idSubject$2.INSTANCE);
    }
}
