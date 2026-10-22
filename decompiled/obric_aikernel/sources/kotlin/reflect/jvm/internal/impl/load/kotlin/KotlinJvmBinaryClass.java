package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;

/* JADX INFO: loaded from: classes3.dex */
public interface KotlinJvmBinaryClass {

    public interface AnnotationArgumentVisitor {
        void visit(Name r10, Object r11);

        AnnotationArgumentVisitor visitAnnotation(Name r10, ClassId r11);

        AnnotationArrayArgumentVisitor visitArray(Name r10);

        void visitClassLiteral(Name r10, ClassLiteralValue r11);

        void visitEnd();

        void visitEnum(Name r10, ClassId r11, Name r12);
    }

    public interface AnnotationArrayArgumentVisitor {
        void visit(Object r10);

        AnnotationArgumentVisitor visitAnnotation(ClassId r10);

        void visitClassLiteral(ClassLiteralValue r10);

        void visitEnd();

        void visitEnum(ClassId r10, Name r11);
    }

    public interface AnnotationVisitor {
        AnnotationArgumentVisitor visitAnnotation(ClassId r10, SourceElement r11);

        void visitEnd();
    }

    public interface MemberVisitor {
        AnnotationVisitor visitField(Name r10, String r11, Object r12);

        MethodAnnotationVisitor visitMethod(Name r10, String r11);
    }

    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        AnnotationArgumentVisitor visitParameterAnnotation(int r10, ClassId r11, SourceElement r12);
    }

    KotlinClassHeader getClassHeader();

    ClassId getClassId();

    String getLocation();

    void loadClassAnnotations(AnnotationVisitor r10, byte[] r11);

    void visitMembers(MemberVisitor r10, byte[] r11);
}
