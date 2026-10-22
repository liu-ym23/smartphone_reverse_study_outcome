package com.ss.android.lark.image.uploader.upload;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends j {
    public final boolean a;

    public d(boolean r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.ss.android.lark.image.uploader.upload.EncryptImageUploader$uploadImage$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.image.uploader.upload.e
    public final void a(com.ss.android.lark.image.uploader.entity.b r8, final ImageUploadManager$wrapUploader$1.AnonymousClass1 r9) {
        Intrinsics.checkNotNullParameter(r8, LoadParams.ImageFormat.IMAGE);
        Intrinsics.checkNotNullParameter(r9, "callback");
        PolarisFileWrapper r2 = new PolarisFileWrapper(r8.a);
        ImageInfo r10 = r8.k;
        if (r10 == null) goto L5;
        int r3 = r10.a;
    L6:
        if (r10 == null) goto L8;
        int r4 = r10.b;
    L9:
        ykb.b.a.d(r2, r3, r4, this.a, new EncryptImageUploader$uploadImage$1(r9));
        return;
    L8:
        r4 = 0;
        goto L9
    L5:
        r3 = 0;
        goto L6
    }
}
