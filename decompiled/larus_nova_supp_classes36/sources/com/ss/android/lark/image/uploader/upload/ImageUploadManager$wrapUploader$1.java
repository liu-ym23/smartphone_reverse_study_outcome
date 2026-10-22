package com.ss.android.lark.image.uploader.upload;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageUploadManager$wrapUploader$1<T> implements ObservableOnSubscribe {
    public final /* synthetic */ com.ss.android.lark.image.uploader.entity.b a;
    public final /* synthetic */ e b;

    public ImageUploadManager$wrapUploader$1(com.ss.android.lark.image.uploader.entity.b r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.android.lark.image.uploader.upload.ImageUploadManager$wrapUploader$1$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void subscribe(final ObservableEmitter<com.ss.android.lark.image.uploader.entity.b> r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        int r0 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "uploadImage:" + this.a);
        e r1 = this.b;
        final com.ss.android.lark.image.uploader.entity.b r2 = this.a;
        r1.a(r2, new AnonymousClass1(r2, r4));
    }
}
