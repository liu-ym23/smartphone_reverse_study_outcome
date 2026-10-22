package com.ss.android.lark.chameleon;

import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.officesdk.utils.ReflectUtils;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00018\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0016H\u0016J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonHandler;", "T", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "<init>", "()V", IPortraitService.NAME, com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "getName", "()Ljava/lang/String;", "context", "Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", "getContext", "()Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", "setContext", "(Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;)V", "handle", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "(Ljava/lang/Object;Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;)V", "req", "Lcom/ss/android/lark/chameleon/Callback;", "(Ljava/lang/Object;Lcom/ss/android/lark/chameleon/Callback;)V", "createCallback", "authType", "Lcom/bytedance/ee/bear/jsbridge/auth/BridgeAuthType;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsChameleonHandler<T> implements i<T> {
    private IChameleonHandlerContext context;

    public AbsChameleonHandler() {
    }

    public abstract String getName();

    public BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public final IChameleonHandlerContext getContext() {
        return this.context;
    }

    private final Callback createCallback(final m r2) {
        return new AnonymousClass1(r2);
    }

    public void handle(Callback r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.error(new LKAPIError(-1, "native handler not implement"));
    }

    public final void setContext(IChameleonHandlerContext r1) {
        this.context = r1;
    }

    public void handle(T r4, m r5) {
        Callback r6 = createCallback(r5);
        Class r0 = ReflectUtils.a(this);
        if (r0 != null) goto L6;
        r0 = ReflectUtils.b(this);
    L6:
        if (Intrinsics.areEqual(r0, Unit.class) == true) goto L20;
        if (r4 != null) goto L18;
        r6.error(new LKAPIError(-1, "params invalid can not parsed"));
        j.b(getName(), "params invalid can not parsed");
        return;
    L18:
        handle(r4, r6);     // Catch: Throwable -> L16
        return;
    L16:
        r6.error(new LKAPIError(-1, "handler call unknown error"));
        j.b(getName(), "handler call unknown error");
        return;
    L20:
        handle(r6);     // Catch: Throwable -> L9
        return;
    L9:
        r6.error(new LKAPIError(-1, "handler call unknown error"));
        j.b(getName(), "handler call unknown error");
    }

    public void handle(T r3, Callback r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.error(new LKAPIError(-1, "native handler not implement"));
    }
}
