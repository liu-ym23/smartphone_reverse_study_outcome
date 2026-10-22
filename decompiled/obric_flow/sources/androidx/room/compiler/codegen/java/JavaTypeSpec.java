package androidx.room.compiler.codegen.java;

import androidx.room.compiler.codegen.VisibilityModifier;
import androidx.room.compiler.codegen.XAnnotationSpec;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.compiler.codegen.XFunSpec;
import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.codegen.XTypeSpec;
import androidx.room.compiler.processing.XNullability;
import com.bytedance.android.anniex.base.service.f;
import com.squareup.javapoet.b;
import com.squareup.javapoet.l;
import com.squareup.javapoet.m;
import com.squareup.javapoet.y;
import com.squareup.javapoet.z;
import java.util.List;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/room/compiler/codegen/java/JavaTypeSpec;", "Landroidx/room/compiler/codegen/java/JavaLang;", "Landroidx/room/compiler/codegen/XTypeSpec;", "Landroidx/room/compiler/codegen/XClassName;", "className", "Lcom/squareup/javapoet/z;", "Lcom/squareup/kotlinpoet/javapoet/JTypeSpec;", "actual", "<init>", "(Landroidx/room/compiler/codegen/XClassName;Lcom/squareup/javapoet/z;)V", "Landroidx/room/compiler/codegen/XClassName;", "getClassName", "()Landroidx/room/compiler/codegen/XClassName;", "Lcom/squareup/javapoet/z;", "getActual$room_compiler_processing", "()Lcom/squareup/javapoet/z;", "Builder", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavaTypeSpec extends JavaLang implements XTypeSpec {
    private final z actual;
    private final XClassName className;

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012JG\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010&R\u001e\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Landroidx/room/compiler/codegen/java/JavaTypeSpec$Builder;", "Landroidx/room/compiler/codegen/java/JavaLang;", "Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "Landroidx/room/compiler/codegen/XClassName;", "className", "Lcom/squareup/javapoet/y;", "Landroidx/room/compiler/codegen/JTypeSpecBuilder;", "actual", "<init>", "(Landroidx/room/compiler/codegen/XClassName;Lcom/squareup/javapoet/y;)V", "Landroidx/room/compiler/codegen/XTypeName;", "typeName", "superclass", "(Landroidx/room/compiler/codegen/XTypeName;)Landroidx/room/compiler/codegen/java/JavaTypeSpec$Builder;", "Landroidx/room/compiler/codegen/XAnnotationSpec;", "annotation", "", "addAnnotation", "(Landroidx/room/compiler/codegen/XAnnotationSpec;)V", "", "name", "Landroidx/room/compiler/codegen/VisibilityModifier;", "visibility", "", "isMutable", "Landroidx/room/compiler/codegen/XCodeBlock;", "initExpr", "", "annotations", "addProperty", "(Landroidx/room/compiler/codegen/XTypeName;Ljava/lang/String;Landroidx/room/compiler/codegen/VisibilityModifier;ZLandroidx/room/compiler/codegen/XCodeBlock;Ljava/util/List;)Landroidx/room/compiler/codegen/java/JavaTypeSpec$Builder;", "Landroidx/room/compiler/codegen/XFunSpec;", "functionSpec", "addFunction", "(Landroidx/room/compiler/codegen/XFunSpec;)Landroidx/room/compiler/codegen/java/JavaTypeSpec$Builder;", "Landroidx/room/compiler/codegen/XTypeSpec;", "build", "()Landroidx/room/compiler/codegen/XTypeSpec;", "Landroidx/room/compiler/codegen/XClassName;", "Lcom/squareup/javapoet/y;", "getActual$room_compiler_processing", "()Lcom/squareup/javapoet/y;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder extends JavaLang implements XTypeSpec.Builder {
        private final y actual;
        private final XClassName className;

        public Builder(XClassName r5, y r10) {
            Intrinsics.checkNotNullParameter(r5, "className");
            Intrinsics.checkNotNullParameter(r10, "actual");
            this.className = r5;
            this.actual = r10;
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public void addAnnotation(XAnnotationSpec r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            if ((r5 instanceof JavaAnnotationSpec) == false) goto L7;
            y r10 = this.actual;
            b r11 = ((JavaAnnotationSpec) r5).getActual$room_compiler_processing();
            r10.getClass();
            f.s(r11, "annotationSpec == null", new Object[0]);
            r10.f15044i.add(r11);
            return;
        L7:
            throw new IllegalArgumentException("Failed requirement.");
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public /* bridge */ /* synthetic */ XTypeSpec.Builder addFunction(XFunSpec r5) {
            return addFunction(r5);
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public /* bridge */ /* synthetic */ XTypeSpec.Builder addProperty(XTypeName r5, String r10, VisibilityModifier r11, boolean r12, XCodeBlock r13, List r14) {
            return addProperty(r5, r10, r11, r12, r13, r14);
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public XTypeSpec build() {
            return new JavaTypeSpec(this.className, this.actual.e());
        }

        public final y getActual$room_compiler_processing() {
            return this.actual;
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public /* bridge */ /* synthetic */ XTypeSpec.Builder superclass(XTypeName r5) {
            return superclass(r5);
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public Builder addFunction(XFunSpec r5) {
            Intrinsics.checkNotNullParameter(r5, "functionSpec");
            if ((r5 instanceof JavaFunSpec) == false) goto L7;
            this.actual.b(((JavaFunSpec) r5).getActual$room_compiler_processing());
            return this;
        L7:
            throw new IllegalArgumentException("Failed requirement.");
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public Builder addProperty(XTypeName r5, String r10, VisibilityModifier r11, boolean r12, XCodeBlock r13, List<? extends XAnnotationSpec> r14) {
            Intrinsics.checkNotNullParameter(r5, "typeName");
            Intrinsics.checkNotNullParameter(r10, "name");
            Intrinsics.checkNotNullParameter(r11, "visibility");
            Intrinsics.checkNotNullParameter(r14, "annotations");
            y r15 = this.actual;
            l r16 = m.a(r5.getJava$room_compiler_processing(), r10, new Modifier[0]);
            Modifier r17 = JavaFunSpecKt.toJavaVisibilityModifier(r11);
            if (r17 != Modifier.PRIVATE) goto L5;
        L10:
            r16.b(new Modifier[]{r17});
            if (r12 == true) goto L13;
            r16.b(new Modifier[]{Modifier.FINAL});
        L13:
            if (r13 != null) goto L15;
        L19:
            r15.a(r16.c());
            return this;
        L15:
            if ((r13 instanceof JavaCodeBlock) == false) goto L18;
            r16.d(((JavaCodeBlock) r13).getActual$room_compiler_processing());
            goto L19
        L18:
            throw new IllegalArgumentException("Failed requirement.");
        L5:
            if (r5.getNullability$room_compiler_processing() != XNullability.NULLABLE) goto L8;
            r16.a(ClassNamesKt.getNULLABLE_ANNOTATION());
            goto L10
        L8:
            if (r5.getNullability$room_compiler_processing() != XNullability.NONNULL) goto L10;
            r16.a(ClassNamesKt.getNONNULL_ANNOTATION());
            goto L10
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public Builder superclass(XTypeName r5) {
            Intrinsics.checkNotNullParameter(r5, "typeName");
            this.actual.f(r5.getJava$room_compiler_processing());
            return this;
        }
    }

    public JavaTypeSpec(XClassName r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "className");
        Intrinsics.checkNotNullParameter(r10, "actual");
        this.className = r5;
        this.actual = r10;
    }

    public final z getActual$room_compiler_processing() {
        return this.actual;
    }

    @Override // androidx.room.compiler.codegen.XTypeSpec
    public XClassName getClassName() {
        return this.className;
    }
}
