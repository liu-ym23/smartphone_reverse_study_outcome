package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.InternalXAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XAnnotationValue;
import androidx.room.compiler.processing.XType;
import il.b;
import il.p;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR!\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(¨\u0006,"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotation;", "Landroidx/room/compiler/processing/InternalXAnnotation;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/b;", "ksAnnotated", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/b;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "annotationClass", "Landroidx/room/compiler/processing/XAnnotationBox;", "asAnnotationBox", "(Ljava/lang/Class;)Landroidx/room/compiler/processing/XAnnotationBox;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "getEnv", "()Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Lil/b;", "getKsAnnotated", "()Lil/b;", "Lil/p;", "ksType$delegate", "Lkotlin/Lazy;", "getKsType", "()Lil/p;", "ksType", "Landroidx/room/compiler/processing/XType;", "type$delegate", "getType", "()Landroidx/room/compiler/processing/XType;", "type", "", "Landroidx/room/compiler/processing/XAnnotationValue;", "annotationValues$delegate", "getAnnotationValues", "()Ljava/util/List;", "annotationValues", "", "getName", "()Ljava/lang/String;", "name", "getQualifiedName", "qualifiedName", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspAnnotation extends InternalXAnnotation {
    private final Lazy annotationValues$delegate;
    private final KspProcessingEnv env;
    private final b ksAnnotated;
    private final Lazy ksType$delegate;
    private final Lazy type$delegate;

    public KspAnnotation(KspProcessingEnv r5, b r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "ksAnnotated");
        this.env = r5;
        this.ksType$delegate = LazyKt.lazy(new KspAnnotation$ksType$2(this));
        this.type$delegate = LazyKt.lazy(new KspAnnotation$type$2(this));
        this.annotationValues$delegate = LazyKt.lazy(new KspAnnotation$annotationValues$2(this));
    }

    @Override // androidx.room.compiler.processing.InternalXAnnotation
    public <T extends Annotation> XAnnotationBox<T> asAnnotationBox(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationClass");
        return new KspAnnotationBox(this.env, r5, null);
    }

    @Override // androidx.room.compiler.processing.XAnnotation
    public List<XAnnotationValue> getAnnotationValues() {
        return (List) this.annotationValues$delegate.getValue();
    }

    public final KspProcessingEnv getEnv() {
        return this.env;
    }

    public final b getKsAnnotated() {
        return null;
    }

    public final p getKsType() {
        j0.A(this.ksType$delegate.getValue());
        return null;
    }

    @Override // androidx.room.compiler.processing.XAnnotation
    public String getName() {
        throw null;
    }

    @Override // androidx.room.compiler.processing.XAnnotation
    public String getQualifiedName() {
        getKsType();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XAnnotation
    public XType getType() {
        return (XType) this.type$delegate.getValue();
    }
}
