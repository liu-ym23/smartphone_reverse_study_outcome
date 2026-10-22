package com.ss.android.lark.chameleon.api;

import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.ReflectUtils;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0015J!\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00018\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chameleon/api/AbsChameleonHandler;", "T", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "()V", "context", "Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;", "getContext", "()Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;", "setContext", "(Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;)V", IPortraitService.NAME, BuildConfig.FLAVOR, "getName", "()Ljava/lang/String;", "createCallback", "Lcom/ss/android/lark/chameleon/api/Callback;", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "handle", BuildConfig.FLAVOR, "req", "(Ljava/lang/Object;Lcom/ss/android/lark/chameleon/api/Callback;)V", Keys.API_RETURN_KEY_DATA, "(Ljava/lang/Object;Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;)V", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbsChameleonHandler<T> implements BridgeHandlerV2<T> {
    private IChameleonHandlerContext context;

    public AbsChameleonHandler() {
    }

    public abstract String getName();

    public final IChameleonHandlerContext getContext() {
        return this.context;
    }

    private final Callback createCallback(final CallBackFunction r2) {
        return new AnonymousClass1(r2);
    }

    public void handle(Callback r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.error(new LarkAPIError(-1, "native handler not implement"));
    }

    public final void setContext(IChameleonHandlerContext r1) {
        this.context = r1;
    }

    @Override // com.ss.android.lark.chameleon.bridge.JSHandler
    public void handle(T r4, CallBackFunction r5) {
        Callback r6 = createCallback(r5);
        Class r0 = ReflectUtils.getGenericClass(this);
        if (r0 != null) goto L6;
        r0 = ReflectUtils.getGenericInterfaceClass(this);
    L6:
        if (Intrinsics.areEqual(r0, Unit.class) == true) goto L20;
        if (r4 != null) goto L18;
        r6.error(new LarkAPIError(-1, "params invalid can not parsed"));
        Log.e(getName(), "params invalid can not parsed");
        return;
    L18:
        handle(r4, r6);     // Catch: Throwable -> L16
        return;
    L16:
        r6.error(new LarkAPIError(-1, "handler call unknown error"));
        Log.e(getName(), "handler call unknown error");
        return;
    L20:
        handle(r6);     // Catch: Throwable -> L9
        return;
    L9:
        r6.error(new LarkAPIError(-1, "handler call unknown error"));
        Log.e(getName(), "handler call unknown error");
    }

    public void handle(T r3, Callback r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.error(new LarkAPIError(-1, "native handler not implement"));
    }
}
