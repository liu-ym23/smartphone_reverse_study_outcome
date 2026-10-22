package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface KotlinJvmBinaryClass {

    public interface AnnotationArgumentVisitor {
        void visit(Name r1, Object r2);

        AnnotationArgumentVisitor visitAnnotation(Name r1, ClassId r2);

        AnnotationArrayArgumentVisitor visitArray(Name r1);

        void visitClassLiteral(Name r1, ClassLiteralValue r2);

        void visitEnd();

        void visitEnum(Name r1, ClassId r2, Name r3);
    }

    public interface AnnotationArrayArgumentVisitor {
        void visit(Object r1);

        AnnotationArgumentVisitor visitAnnotation(ClassId r1);

        void visitClassLiteral(ClassLiteralValue r1);

        void visitEnd();

        void visitEnum(ClassId r1, Name r2);
    }

    public interface AnnotationVisitor {
        AnnotationArgumentVisitor visitAnnotation(ClassId r1, SourceElement r2);

        void visitEnd();
    }

    KotlinClassHeader getClassHeader();

    ClassId getClassId();

    String getLocation();

    void loadClassAnnotations(AnnotationVisitor r1, byte[] r2);

    void visitMembers(MemberVisitor r1, byte[] r2);
}
