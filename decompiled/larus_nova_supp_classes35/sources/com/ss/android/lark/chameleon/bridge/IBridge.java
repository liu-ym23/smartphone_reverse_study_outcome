package com.ss.android.lark.chameleon.bridge;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH&J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/IBridge;", BuildConfig.FLAVOR, "addBridgeMsgInterceptor", BuildConfig.FLAVOR, "interceptor", "Lcom/ss/android/lark/chameleon/bridge/BridgeMsgInterceptor;", "bindBridgeHandler", "handlerName", BuildConfig.FLAVOR, "handler", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "dispatchBridgeMsg", Keys.API_RETURN_KEY_DATA, "callBack", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "removeBridgeMsgInterceptor", "unbindBridgeHandler", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IBridge {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void dispatchBridgeMsg$default(IBridge r1, String r2, Object r3, CallBackFunction r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 2) == 0) goto L7;
            r3 = null;
        L7:
            if ((r5 & 4) == 0) goto L9;
            r4 = null;
        L9:
            r1.dispatchBridgeMsg(r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchBridgeMsg");
        }
    }

    void addBridgeMsgInterceptor(BridgeMsgInterceptor r1);

    void bindBridgeHandler(String r1, BridgeHandlerV2<?> r2);

    void dispatchBridgeMsg(String r1, Object r2, CallBackFunction r3);

    void removeBridgeMsgInterceptor(BridgeMsgInterceptor r1);

    void unbindBridgeHandler(String r1);
}
