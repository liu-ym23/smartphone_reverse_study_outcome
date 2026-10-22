package com.ss.ugc.effectplatform.preload;

import com.ss.ugc.effectplatform.download.k;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class PreloadDownloadManager$Builder$build$2 extends MutablePropertyReference0 {
    public PreloadDownloadManager$Builder$build$2(d.a r1) {
        super(r1);
    }

    public String getName() {
        return "writeDisk";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(d.a.class);
    }

    public String getSignature() {
        return "getWriteDisk()Lcom/ss/ugc/effectplatform/download/IWriteDisk;";
    }

    public Object get() {
        k r0 = ((d.a) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("writeDisk");
    L5:
        return r0;
    }

    public void set(Object r2) {
        k r3 = (k) r2;
        ((d.a) ((CallableReference) this).receiver).a = r3;
    }
}
