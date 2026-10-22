package com.ss.android.lark.chameleon.bridge;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J3\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/BridgeHandler;", "T", "D", BuildConfig.FLAVOR, "handle", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "callback", "Lcom/ss/android/lark/chameleon/bridge/JsCallBack;", "extraStr", BuildConfig.FLAVOR, "context", "(Ljava/lang/Object;Lcom/ss/android/lark/chameleon/bridge/JsCallBack;Ljava/lang/String;Ljava/lang/Object;)V", "shouldRunInUIThread", BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface BridgeHandler<T, D> {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static <T, D> boolean shouldRunInUIThread(BridgeHandler<T, D> r0) {
            return true;
        }
    }

    void handle(T r1, JsCallBack r2, String r3, D r4);

    boolean shouldRunInUIThread();
}
