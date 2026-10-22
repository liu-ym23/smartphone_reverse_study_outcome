package com.obric.aiproactive.impl.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/SystemRemoteHostResolver;", "Lcom/obric/aiproactive/impl/bridge/RemoteHostResolver;", "<init>", "()V", "lookup", "", "Ljava/net/InetAddress;", "host", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class o implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f6433a = null;

    static {
        f6433a = new o();
    }

    private o() {
    }

    @Override // com.obric.aiproactive.impl.bridge.m
    public List<InetAddress> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        InetAddress[] r1 = InetAddress.getAllByName(r2);
        Intrinsics.checkNotNullExpressionValue(r1, "getAllByName(...)");
        return ArraysKt.toList((Object[]) ZeusTransformUtils.preCheckCast(r1, Object[].class, "com.obric.memorydata.plugin"));
    }
}
