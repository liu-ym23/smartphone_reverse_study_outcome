package com.ivy.ivykit.plugin.impl.jsb;

import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.HashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f9515c;

    public a() {
        this.f9515c = new HashSet();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final String b() {
        return "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final IDLXBridgeMethod f(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return (IDLXBridgeMethod) SequencesKt.firstOrNull(SequencesKt.filter(CollectionsKt.asSequence(this.f9515c), new BulletViewMethodFinder$loadMethod$1(r5)));
    }
}
