package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;

/* JADX INFO: loaded from: classes3.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
    final /* synthetic */ Name $name;
    private final ArrayList<ConstantValue<?>> elements;
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor this$1;

    BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1(BinaryClassAnnotationAndConstantLoaderImpl r10, Name r11, BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor r12) {
        this.this$0 = r10;
        this.$name = r11;
        this.this$1 = r12;
        this.elements = new ArrayList();
    }

    public static final /* synthetic */ ArrayList access$getElements$p(BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 r10) {
        return r10.elements;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visit(Object r10) {
        this.elements.add(BinaryClassAnnotationAndConstantLoaderImpl.access$createConstant(this.this$0, this.$name, r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId r10) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        final ArrayList r11 = new ArrayList();
        BinaryClassAnnotationAndConstantLoaderImpl r12 = this.this$0;
        SourceElement r13 = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(r13, "NO_SOURCE");
        final KotlinJvmBinaryClass.AnnotationArgumentVisitor r14 = r12.loadAnnotation(r10, r13, r11);
        Intrinsics.checkNotNull(r14);
        return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1$visitAnnotation$1(r14, this, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visitClassLiteral(ClassLiteralValue r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        this.elements.add(new KClassValue(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visitEnd() {
        this.this$1.visitArrayValue(this.$name, this.elements);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visitEnum(ClassId r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "enumClassId");
        Intrinsics.checkNotNullParameter(r11, "enumEntryName");
        this.elements.add(new EnumValue(r10, r11));
    }
}
