package com.bytedance.android.live.revenue.platform.container.impl.core;

import android.content.Context;
import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.platform.aio.channel.js.JsBridgeChannelClient;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.WritableMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/core/AioLinkMessageModule;", "Lcom/lynx/jsbridge/LynxModule;", "context", "Landroid/content/Context;", "invoker", "", "(Landroid/content/Context;Ljava/lang/Object;)V", "onMessage", "Lcom/lynx/react/bridge/WritableMap;", "param", "", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AioLinkMessageModule extends LynxModule {
    @LynxMethod
    public final WritableMap onMessage(String r7) {
        Intrinsics.checkNotNullParameter(r7, "param");
        Object r3 = ((LynxModule) this).mParam;     // Catch: Exception -> L15
        if ((r3 instanceof NativeHostServiceImpl.a) == true) goto L7;
        r3 = null;
    L7:
        if (((NativeHostServiceImpl.a) r3) == null) goto L13;
        com.bytedance.platform.aio.channel.js.model.e r8 = (com.bytedance.platform.aio.channel.js.model.e) l97.a.a.fromJson(r7, TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.platform.aio.channel.js.model.e.class)));     // Catch: Exception -> L15
        Intrinsics.checkNotNullParameter(r8, "message");     // Catch: Exception -> L15
        l r4 = ((NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class)).b;     // Catch: Exception -> L15
        if (r4 == null) goto L13;
        RevenueJsDriver r5 = r4.a;     // Catch: Exception -> L15
        if (r5 == null) goto L13;
        Intrinsics.checkNotNullParameter(r8, "message");     // Catch: Exception -> L15
        JsBridgeChannelClient r6 = r5.a();     // Catch: Exception -> L15
        r6.getClass();     // Catch: Exception -> L15
        Intrinsics.checkNotNullParameter(r8, "message");     // Catch: Exception -> L15
        r6.g(r8, true);     // Catch: Exception -> L15
    L13:
        return JavaOnlyMap.from(MapsKt.mapOf(TuplesKt.to(Constants.OperatorKey.CODE, 1)));
    L15:
        e = move-exception;
        return JavaOnlyMap.from(MapsKt.mapOf(new Pair[]{TuplesKt.to(Constants.OperatorKey.CODE, 0), TuplesKt.to("message", e.getMessage())}));
    }

    public AioLinkMessageModule(Context r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "invoker");
        super(r2, r3);
    }
}
