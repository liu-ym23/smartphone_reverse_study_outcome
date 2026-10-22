package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmClass;
import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0001J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J2\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001cH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/KmModule;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KmModuleVisitor;", "()V", "annotations", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "getAnnotations", "()Ljava/util/List;", "optionalAnnotationClasses", "Landroidx/room/jarjarred/kotlinx/metadata/KmClass;", "getOptionalAnnotationClasses", "packageParts", "", "", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/KmPackageParts;", "getPackageParts", "()Ljava/util/Map;", "accept", "", "visitor", "visitAnnotation", "annotation", "visitOptionalAnnotationClass", "visitPackageParts", "fqName", "fileFacades", "", "multiFileClassParts", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmModule extends KmModuleVisitor {
    private final List<KmAnnotation> annotations;
    private final List<KmClass> optionalAnnotationClasses;
    private final Map<String, KmPackageParts> packageParts;

    public KmModule() {
        super(null, 1, null);
        this.packageParts = new LinkedHashMap();
        this.annotations = new ArrayList(0);
        this.optionalAnnotationClasses = new ArrayList(0);
    }

    public final void accept(KmModuleVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        Iterator<Map.Entry<String, KmPackageParts>> r10 = this.packageParts.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<String, KmPackageParts> r11 = r10.next();
        String r12 = r11.getKey();
        KmPackageParts r13 = r11.getValue();
        r5.visitPackageParts(r12, r13.getFileFacades(), r13.getMultiFileClassParts());
        goto L4
    L6:
        Iterator<T> r14 = this.annotations.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r5.visitAnnotation((KmAnnotation) r14.next());
        goto L8
    L10:
        Iterator<T> r15 = this.optionalAnnotationClasses.iterator();
    L12:
        if (r15.hasNext() == false) goto L16;
        KmClass r16 = (KmClass) r15.next();
        KmClassVisitor r17 = r5.visitOptionalAnnotationClass();
        if (r17 == null) goto L12;
        r16.accept(r17);
        goto L12
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final List<KmClass> getOptionalAnnotationClasses() {
        return this.optionalAnnotationClasses;
    }

    public final Map<String, KmPackageParts> getPackageParts() {
        return this.packageParts;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.KmModuleVisitor
    public void visitAnnotation(KmAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        this.annotations.add(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.KmModuleVisitor
    public /* bridge */ /* synthetic */ KmClassVisitor visitOptionalAnnotationClass() {
        return visitOptionalAnnotationClass();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.KmModuleVisitor
    public void visitPackageParts(String r5, List<String> r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "fileFacades");
        Intrinsics.checkNotNullParameter(r11, "multiFileClassParts");
        this.packageParts.put(r5, new KmPackageParts(CollectionsKt.toMutableList(r10), MapsKt.toMutableMap(r11)));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.KmModuleVisitor
    public KmClass visitOptionalAnnotationClass() {
        KmClass r5 = new KmClass();
        this.optionalAnnotationClasses.add(r5);
        return r5;
    }
}
