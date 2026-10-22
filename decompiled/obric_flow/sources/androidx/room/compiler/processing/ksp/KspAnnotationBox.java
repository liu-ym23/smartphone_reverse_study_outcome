package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XType;
import il.b;
import il.p;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0011\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\r*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00162\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0001\u0010\r*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u001b\"\b\b\u0001\u0010\r*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010 R\u0014\u0010!\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotationBox;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/compiler/processing/XAnnotationBox;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Ljava/lang/Class;", "annotationClass", "Lil/b;", "annotation", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Ljava/lang/Class;Lil/b;)V", "", "R", "", "methodName", "returnType", "getFieldValue", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Landroidx/room/compiler/processing/XType;", "getAsType", "(Ljava/lang/String;)Landroidx/room/compiler/processing/XType;", "", "getAsTypeList", "(Ljava/lang/String;)Ljava/util/List;", "getAsAnnotationBox", "(Ljava/lang/String;)Landroidx/room/compiler/processing/XAnnotationBox;", "", "getAsAnnotationBoxArray", "(Ljava/lang/String;)[Landroidx/room/compiler/processing/XAnnotationBox;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Ljava/lang/Class;", "Lil/b;", "valueProxy", "Ljava/lang/annotation/Annotation;", "getValue", "()Ljava/lang/annotation/Annotation;", "value", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspAnnotationBox<T extends Annotation> implements XAnnotationBox<T> {
    private final b annotation;
    private final Class<T> annotationClass;
    private final KspProcessingEnv env;
    private final T valueProxy;

    public KspAnnotationBox(KspProcessingEnv r5, Class<T> r10, b r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "annotationClass");
        Intrinsics.checkNotNullParameter(r11, "annotation");
        this.env = r5;
        this.annotationClass = r10;
        Object r12 = Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new androidx.room.compiler.processing.javac.a(this, 1));
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type T of androidx.room.compiler.processing.ksp.KspAnnotationBox");
        this.valueProxy = (T) r12;
    }

    public static /* synthetic */ Object a(KspAnnotationBox r5, Object r10, Method r11, Object[] r12) {
        return valueProxy$lambda$6(r5, r10, r11, r12);
    }

    private final <R> R getFieldValue(String r5, Class<R> r10) {
        throw null;
    }

    private static final Object valueProxy$lambda$6(KspAnnotationBox r5, Object r10, Method r11, Object[] r12) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Object r13 = r5.getFieldValue(r11.getName(), r11.getReturnType());
        if (r13 == null) goto L5;
        return r13;
    L5:
        return r11.getDefaultValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public <R extends Annotation> XAnnotationBox<R> getAsAnnotationBox(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        j0.A(getFieldValue(r5, b.class));
        return KspReflectiveAnnotationBox.Companion.createFromDefaultValue(this.env, this.annotationClass, r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public <R extends Annotation> XAnnotationBox<R>[] getAsAnnotationBoxArray(String r10) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Object[] r5 = (Object[]) getFieldValue(r10, Object[].class);
        if (r5 == null) goto L5;
        Method[] r11 = this.annotationClass.getMethods();
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L21;
        Method r14 = r11[r13];
        if (Intrinsics.areEqual(r14.getName(), r10) == true) goto L10;
        r13 = r13 + 1;
        goto L7
    L10:
        Class<?> r15 = r14.getReturnType().getComponentType();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.lang.Class<R of androidx.room.compiler.processing.ksp.KspAnnotationBox.getAsAnnotationBoxArray>");
        if (r5.length == 0) goto L13;
        ArrayList r16 = new ArrayList(r5.length);
        int r17 = r5.length;
        int r18 = 0;
    L15:
        if (r18 >= r17) goto L17;
        Object r19 = r5[r18];
        KspProcessingEnv r20 = this.env;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.google.devtools.ksp.symbol.KSAnnotation");
        j0.A(r19);
        r16.add(new KspAnnotationBox(r20, r15, null));
        r18 = r18 + 1;
        goto L15
    L17:
        Object[] r21 = r16.toArray(new XAnnotationBox[0]);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (XAnnotationBox[]) r21;
    L13:
        return KspReflectiveAnnotationBox.Companion.createFromDefaultValues(this.env, this.annotationClass, r10);
    L21:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L5:
        return new XAnnotationBox[0];
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public XType getAsType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        j0.A(getFieldValue(r5, p.class));
        return null;
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public List<XType> getAsTypeList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Object[] r10 = (Object[]) getFieldValue(r5, Object[].class);
        if (r10 == null) goto L5;
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L9;
        Object r14 = r10[r13];
        r13 = r13 + 1;
        goto L7
    L9:
        ArrayList r15 = new ArrayList(CollectionsKt.h(r11));
        Iterator r16 = r11.iterator();
    L11:
        if (r16.hasNext() == false) goto L17;
        if (r16.next() != null) goto L16;
        r15.add(this.env.wrap(null, true));
        goto L11
    L16:
        throw new ClassCastException();
    L17:
        return r15;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public T getValue() {
        return this.valueProxy;
    }
}
