package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;

/* JADX INFO: loaded from: classes3.dex */
public interface KotlinJvmBinaryClass {

    public interface AnnotationArgumentVisitor {
        void visit(Name r5, Object r10);

        AnnotationArgumentVisitor visitAnnotation(Name r5, ClassId r10);

        AnnotationArrayArgumentVisitor visitArray(Name r5);

        void visitClassLiteral(Name r5, ClassLiteralValue r10);

        void visitEnd();

        void visitEnum(Name r5, ClassId r10, Name r11);
    }

    public interface AnnotationArrayArgumentVisitor {
        void visit(Object r5);

        AnnotationArgumentVisitor visitAnnotation(ClassId r5);

        void visitClassLiteral(ClassLiteralValue r5);

        void visitEnd();

        void visitEnum(ClassId r5, Name r10);
    }

    public interface AnnotationVisitor {
        AnnotationArgumentVisitor visitAnnotation(ClassId r5, SourceElement r10);

        void visitEnd();
    }

    public interface MemberVisitor {
        AnnotationVisitor visitField(Name r5, String r10, Object r11);

        MethodAnnotationVisitor visitMethod(Name r5, String r10);
    }

    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        AnnotationArgumentVisitor visitParameterAnnotation(int r5, ClassId r10, SourceElement r11);
    }

    KotlinClassHeader getClassHeader();

    ClassId getClassId();

    String getLocation();

    void loadClassAnnotations(AnnotationVisitor r5, byte[] r10);

    void visitMembers(MemberVisitor r5, byte[] r10);
}
