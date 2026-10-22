package com.obric.memorydata.sdk.server.assistant;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.sdk.assistant.QueryType;
import com.obric.memorydata.sdk.assistant.WindowState;
import com.obric.memorydata.sdk.server.AssistantStateTag;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/server/assistant/AssistantStateHolder;", "", "<init>", "()V", "TAG", "", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/sdk/server/AssistantStateTag;", "Lcom/obric/memorydata/sdk/server/assistant/AssistantStateListener;", "getListeners$memoryDataSDKServer_obricRelease", "()Ljava/util/concurrent/ConcurrentHashMap;", "windowState", "Lcom/obric/memorydata/sdk/assistant/WindowState;", "queryType", "Lcom/obric/memorydata/sdk/assistant/QueryType;", "isQueryInBarWindow", "", "refreshWindowState", "", "setWindowState", "state", "setQueryType", "type", "registerAssistantStateListener", LocationMonitorConst.TAG, "listener", "unregisterAssistantStateListener", "memoryDataSDKServer_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12858a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<AssistantStateTag, b> f12859b = null;
    private static volatile WindowState c;
    private static volatile QueryType d;

    static {
        f12858a = new a();
        f12859b = new ConcurrentHashMap();
        c = WindowState.NA;
        d = QueryType.NA;
    }

    private a() {
    }

    public final ConcurrentHashMap<AssistantStateTag, b> a() {
        return f12859b;
    }

    public final void a(WindowState r1) {
        Intrinsics.checkNotNullParameter(r1, "state");
        c = r1;
    }

    public final void a(AssistantStateTag r3, b r4) {
        b r2 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((Map) ZeusTransformUtils.preCheckCast(f12859b, Map.class, "com.obric.memorydata.plugin")).put(r3, r2);
    }

    public final boolean b() {
        if (c != WindowState.CHAT_WINDOW) goto L5;
        return true;
    L5:
        return false;
    }

    public final void c() {
        c = WindowState.NA;
    }
}
