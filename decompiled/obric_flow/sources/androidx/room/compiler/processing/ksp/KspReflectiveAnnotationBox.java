package androidx.room.compiler.processing.ksp;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001c*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ \u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003\"\b\b\u0001\u0010\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J+\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0012\"\b\b\u0001\u0010\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J!\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\b\b\u0001\u0010\u0019*\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u001bR\u0010\u0010\b\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspReflectiveAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/room/compiler/processing/XAnnotationBox;", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "annotationClass", "Ljava/lang/Class;", "annotation", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Ljava/lang/Class;Ljava/lang/annotation/Annotation;)V", "Ljava/lang/annotation/Annotation;", "value", "getValue", "()Ljava/lang/annotation/Annotation;", "getAsAnnotationBox", "methodName", "", "getAsAnnotationBoxArray", "", "(Ljava/lang/String;)[Landroidx/room/compiler/processing/XAnnotationBox;", "getAsType", "Landroidx/room/compiler/processing/XType;", "getAsTypeList", "", "getFieldValue", "R", "", "(Ljava/lang/String;)Ljava/lang/Object;", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspReflectiveAnnotationBox<T extends Annotation> implements XAnnotationBox<T> {
    public static final Companion Companion = null;
    private final T annotation;
    private final Class<T> annotationClass;
    private final KspProcessingEnv env;
    private final T value;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\fJ=\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000f0\u000e\"\b\b\u0001\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspReflectiveAnnotationBox$Companion;", "", "()V", "createFromDefaultValue", "Landroidx/room/compiler/processing/ksp/KspReflectiveAnnotationBox;", "R", "", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "annotationClass", "Ljava/lang/Class;", "methodName", "", "createFromDefaultValues", "", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Ljava/lang/Class;Ljava/lang/String;)[Landroidx/room/compiler/processing/XAnnotationBox;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final <R extends Annotation> KspReflectiveAnnotationBox<R> createFromDefaultValue(KspProcessingEnv r5, Class<?> r10, String r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "annotationClass");
            Intrinsics.checkNotNullParameter(r11, "methodName");
            Method[] r12 = r10.getMethods();
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L8;
            Method r15 = r12[r14];
            if (Intrinsics.areEqual(r15.getName(), r11) == true) goto L9;
            r14 = r14 + 1;
        L9:
            if (r15 == null) goto L17;
            Object r16 = r15.getDefaultValue();
            if (r16 == null) goto L15;
            Class<?> r17 = r15.getReturnType();
            Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type java.lang.Class<R of androidx.room.compiler.processing.ksp.KspReflectiveAnnotationBox.Companion.createFromDefaultValue>");
            return new KspReflectiveAnnotationBox(r5, r17, (Annotation) r16);
        L15:
            throw new IllegalStateException((r10 + '.' + r15 + " does not have a default value and is not set").toString());
        L17:
            throw new IllegalStateException((r10 + " does not contain " + r11).toString());
        L8:
            r15 = null;
            goto L9
        }

        public final <R extends Annotation> XAnnotationBox<R>[] createFromDefaultValues(KspProcessingEnv r10, Class<?> r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "env");
            Intrinsics.checkNotNullParameter(r11, "annotationClass");
            Intrinsics.checkNotNullParameter(r12, "methodName");
            Method[] r13 = r11.getMethods();
            int r5 = r13.length;
            int r14 = 0;
        L3:
            if (r14 >= r5) goto L8;
            Method r15 = r13[r14];
            if (Intrinsics.areEqual(r15.getName(), r12) == true) goto L9;
            r14 = r14 + 1;
        L9:
            if (r15 == null) goto L24;
            if (r15.getReturnType().isArray() == false) goto L22;
            Object r16 = r15.getDefaultValue();
            if (r16 == null) goto L20;
            Annotation[] r17 = (Annotation[]) r16;
            ArrayList r18 = new ArrayList(r17.length);
            int r19 = r17.length;
            int r20 = 0;
        L15:
            if (r20 >= r19) goto L17;
            Annotation r21 = r17[r20];
            Class<?> r22 = r15.getReturnType().getComponentType();
            Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type java.lang.Class<R of androidx.room.compiler.processing.ksp.KspReflectiveAnnotationBox.Companion.createFromDefaultValues$lambda$3>");
            r18.add(new KspReflectiveAnnotationBox(r10, r22, r21));
            r20 = r20 + 1;
            goto L15
        L17:
            Object[] r23 = r18.toArray(new XAnnotationBox[0]);
            Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (XAnnotationBox[]) r23;
        L20:
            throw new IllegalStateException((r11 + '.' + r15 + " does not have a default value and is not set").toString());
        L22:
            throw new IllegalStateException(("expected " + r15.getReturnType() + " to be an array. " + r15).toString());
        L24:
            throw new IllegalStateException((r11 + " does not contain " + r12).toString());
        L8:
            r15 = null;
            goto L9
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KspReflectiveAnnotationBox(KspProcessingEnv r5, Class<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "annotationClass");
        Intrinsics.checkNotNullParameter(r11, "annotation");
        this.env = r5;
        this.annotationClass = r10;
        this.annotation = r11;
        this.value = r11;
    }

    private final <R> R getFieldValue(String r10) {
        Method[] r5 = this.annotationClass.getMethods();
        int r11 = r5.length;
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L9;
        Method r13 = r5[r12];
        if (Intrinsics.areEqual(r13.getName(), r10) == true) goto L10;
        r12 = r12 + 1;
    L10:
        if (r13 == null) goto L12;
        R r14 = (R) r13.invoke(this.annotation, null);
    L13:
        if (r14 != null) goto L15;
        return null;
    L15:
        return r14;
    L12:
        r14 = null;
        goto L13
    L9:
        r13 = null;
        goto L10
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public <T extends Annotation> XAnnotationBox<T> getAsAnnotationBox(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return Companion.createFromDefaultValue(this.env, this.annotationClass, r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public <T extends Annotation> XAnnotationBox<T>[] getAsAnnotationBoxArray(String r11) {
        Intrinsics.checkNotNullParameter(r11, "methodName");
        Method[] r5 = this.annotationClass.getMethods();
        int r10 = r5.length;
        int r12 = 0;
    L3:
        Annotation[] r13 = null;
        if (r12 >= r10) goto L9;
        Method r14 = r5[r12];
        if (Intrinsics.areEqual(r14.getName(), r11) == true) goto L10;
        r12 = r12 + 1;
    L10:
        if (r14 == null) goto L23;
        Object r15 = r14.invoke(this.annotation, null);
        if ((r15 instanceof Annotation[]) == false) goto L14;
        r13 = (Annotation[]) r15;
    L14:
        if (r13 == null) goto L16;
        ArrayList r16 = new ArrayList(r13.length);
        int r17 = r13.length;
        int r18 = 0;
    L18:
        if (r18 >= r17) goto L20;
        Annotation r19 = r13[r18];
        KspProcessingEnv r20 = this.env;
        Class<?> r21 = r14.getReturnType().getComponentType();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.compiler.processing.ksp.KspReflectiveAnnotationBox.getAsAnnotationBoxArray$lambda$2>");
        r16.add(new KspReflectiveAnnotationBox(r20, r21, r19));
        r18 = r18 + 1;
        goto L18
    L20:
        Object[] r110 = r16.toArray(new XAnnotationBox[0]);
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (XAnnotationBox[]) r110;
    L16:
        return new XAnnotationBox[0];
    L23:
        throw new IllegalStateException((this.annotationClass + " does not contain " + r11).toString());
    L9:
        r14 = null;
        goto L10
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public XType getAsType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Class r10 = (Class) getFieldValue(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return this.env.findType(JvmClassMappingKt.getKotlinClass(r10));
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public List<XType> getAsTypeList(String r10) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Object[] r11 = (Object[]) getFieldValue(r10);
        if (r11 == null) goto L17;
        ArrayList r5 = new ArrayList();
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        Object r14 = r11[r13];
        if ((r14 instanceof Class) == false) goto L9;
        r5.add(r14);
    L9:
        r13 = r13 + 1;
        goto L5
    L10:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r5.iterator();
    L12:
        if (r16.hasNext() == false) goto L26;
        Class r17 = (Class) r16.next();
        XType r18 = this.env.findType(JvmClassMappingKt.getKotlinClass(r17));
        if (r18 == null) goto L12;
        r15.add(r18);
        goto L12
    L26:
        return r15;
    L17:
        return CollectionsKt.emptyList();
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotationBox
    public T getValue() {
        return this.value;
    }
}
