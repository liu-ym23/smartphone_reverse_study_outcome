package com.ss.ugc.effectplatform.download;

import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class DownloadManager$Builder$build$1 extends MutablePropertyReference0 {
    public DownloadManager$Builder$build$1(f.a r1) {
        super(r1);
    }

    public String getName() {
        return "networkClient";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(f.a.class);
    }

    public String getSignature() {
        return "getNetworkClient()Lcom/ss/ugc/effectplatform/bridge/network/INetworkClient;";
    }

    public Object get() {
        INetworkClient r0 = ((f.a) ((CallableReference) this).receiver).b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("networkClient");
    L5:
        return r0;
    }

    public void set(Object r2) {
        INetworkClient r3 = (INetworkClient) r2;
        ((f.a) ((CallableReference) this).receiver).b = r3;
    }
}
