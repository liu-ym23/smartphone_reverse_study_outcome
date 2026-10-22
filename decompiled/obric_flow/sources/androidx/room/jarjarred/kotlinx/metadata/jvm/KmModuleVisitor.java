package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KmModuleVisitor;", "", "delegate", "<init>", "(Ljava/lang/Object;)V", "", "fqName", "", "fileFacades", "", "multiFileClassParts", "", "visitPackageParts", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "annotation", "visitAnnotation", "(Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "visitOptionalAnnotationClass", "()Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KmModuleVisitor;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmModuleVisitor {
    private final KmModuleVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public KmModuleVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void visitAnnotation(KmAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        KmModuleVisitor r10 = this.delegate;
        if (r10 == null) goto L6;
        r10.visitAnnotation(r5);
        return;
    }

    public void visitEnd() {
        KmModuleVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public KmClassVisitor visitOptionalAnnotationClass() {
        KmModuleVisitor r5 = this.delegate;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.visitOptionalAnnotationClass();
    }

    public void visitPackageParts(String r5, List<String> r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "fileFacades");
        Intrinsics.checkNotNullParameter(r11, "multiFileClassParts");
        KmModuleVisitor r12 = this.delegate;
        if (r12 == null) goto L6;
        r12.visitPackageParts(r5, r10, r11);
        return;
    }

    public KmModuleVisitor(KmModuleVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmModuleVisitor(KmModuleVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
