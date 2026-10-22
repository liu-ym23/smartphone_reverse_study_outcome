package com.larus.bmhome.upload.sdk.impl;

import com.larus.bmhome.upload.sdk.ResourceCenterRegisterPostAction;
import com.larus.bmhome.upload.sdk.ResourceUploadEngine;
import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import com.larus.bmhome.upload.sdk.f;
import com.larus.bmhome.upload.sdk.impl.core.UploadOrchestrator;
import com.larus.bmhome.upload.sdk.impl.core.UploadPreprocessChain;
import com.larus.bmhome.upload.sdk.impl.core.e;
import com.larus.bmhome.upload.sdk.impl.engine.SkeletonUploadEngine;
import com.larus.bmhome.upload.sdk.impl.post.PostUploadActionChain;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements hs8.b {
    public final List<com.larus.bmhome.upload.sdk.impl.core.c> a;
    public final List<js8.c> b;
    public final List<com.larus.bmhome.upload.sdk.impl.engine.c> c;
    public final List<com.larus.bmhome.upload.sdk.impl.post.b> d;

    public final c e() {
        CoroutineScope r0 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        ks8.a r3 = new ks8.a();
        ArrayList r2 = (ArrayList) this.a;
        boolean r4 = r2.isEmpty();
        List r5 = r2;
        if (r4 == false) goto L5;
        r5 = CollectionsKt.listOf(new com.larus.bmhome.upload.sdk.impl.core.b());
    L5:
        List r6 = r5;
        List<js8.c> r7 = this.b;
        List r1 = CollectionsKt.plus(this.c, CollectionsKt.listOf(new SkeletonUploadEngine[]{new SkeletonUploadEngine(UploadEngineType.IMAGE), new SkeletonUploadEngine(UploadEngineType.VIDEO), new SkeletonUploadEngine(UploadEngineType.FILE)}));
        if (((ArrayList) this.d).isEmpty() == false) goto L8;
        List<com.larus.bmhome.upload.sdk.impl.post.b> r8 = CollectionsKt.listOf(new com.larus.bmhome.upload.sdk.impl.post.a());
    L10:
        return new c(r0, new e(), new UploadOrchestrator(r3, new js8.a(r7), new com.larus.bmhome.upload.sdk.impl.engine.a(r1), new PostUploadActionChain(r8), new UploadPreprocessChain(r6)));
    L8:
        r8 = this.d;
        goto L10
    }

    public a() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    @Override // hs8.b
    public final a a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "module");
        r2.a(this);
        return this;
    }

    @Override // hs8.b
    public final a b(hs8.f r3) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        ApiCredentialProviderAdapter r1 = new ApiCredentialProviderAdapter(r3);
        Intrinsics.checkNotNullParameter(r1, "provider");
        ((ArrayList) this.b).add(r1);
        return this;
    }

    public final a c(ResourceUploadEngine r3) {
        Intrinsics.checkNotNullParameter(r3, "engine");
        ApiUploadEngineAdapter r1 = new ApiUploadEngineAdapter(r3);
        Intrinsics.checkNotNullParameter(r1, "engine");
        ((ArrayList) this.c).add(r1);
        return this;
    }

    public final a d(ResourceCenterRegisterPostAction r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        ApiPostUploadActionAdapter r1 = new ApiPostUploadActionAdapter(r3);
        Intrinsics.checkNotNullParameter(r1, "action");
        ((ArrayList) this.d).add(r1);
        return this;
    }
}
