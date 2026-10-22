package com.ss.android.lark.chameleon.bridge;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/JsCallBack;", BuildConfig.FLAVOR, "onCallBack", BuildConfig.FLAVOR, "status", "Lcom/ss/android/lark/chameleon/bridge/Status;", "param", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface JsCallBack {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void onCallBack(JsCallBack r0, Status r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "status");
        }

        public static /* synthetic */ void onCallBack$default(JsCallBack r0, Status r1, Object r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 1) == 0) goto L6;
            r1 = Status.SUCCESS;
        L6:
            r0.onCallBack(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCallBack");
        }
    }

    void onCallBack(Status r1, Object r2);
}
