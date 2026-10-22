package androidx.room.compiler.codegen.java;

import androidx.room.compiler.codegen.PoetExtKt;
import androidx.room.compiler.codegen.XAnnotationSpec;
import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.compiler.codegen.XFunSpec;
import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.KnownTypeNames;
import androidx.room.compiler.processing.XNullability;
import com.squareup.javapoet.i;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.u;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Modifier;
import jk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\nB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/codegen/java/JavaFunSpec;", "Landroidx/room/compiler/codegen/java/JavaLang;", "Landroidx/room/compiler/codegen/XFunSpec;", "Lcom/squareup/javapoet/t;", "actual", "<init>", "(Lcom/squareup/javapoet/t;)V", "Lcom/squareup/javapoet/t;", "getActual$room_compiler_processing", "()Lcom/squareup/javapoet/t;", "Builder", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavaFunSpec extends JavaLang implements XFunSpec {
    private final t actual;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0014\"\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/room/compiler/codegen/java/JavaFunSpec$Builder;", "Landroidx/room/compiler/codegen/java/JavaLang;", "Landroidx/room/compiler/codegen/XFunSpec$Builder;", "Lcom/squareup/javapoet/s;", "actual", "<init>", "(Lcom/squareup/javapoet/s;)V", "Landroidx/room/compiler/codegen/XCodeBlock;", "code", "addCode", "(Landroidx/room/compiler/codegen/XCodeBlock;)Landroidx/room/compiler/codegen/java/JavaFunSpec$Builder;", "Landroidx/room/compiler/codegen/XTypeName;", "typeName", "", "name", "", "Landroidx/room/compiler/codegen/XAnnotationSpec;", "annotations", "addParameter", "(Landroidx/room/compiler/codegen/XTypeName;Ljava/lang/String;Ljava/util/List;)Landroidx/room/compiler/codegen/java/JavaFunSpec$Builder;", "", "args", "callSuperConstructor", "([Landroidx/room/compiler/codegen/XCodeBlock;)Landroidx/room/compiler/codegen/java/JavaFunSpec$Builder;", "returns", "(Landroidx/room/compiler/codegen/XTypeName;)Landroidx/room/compiler/codegen/java/JavaFunSpec$Builder;", "Landroidx/room/compiler/codegen/java/JavaFunSpec;", "build", "()Landroidx/room/compiler/codegen/java/JavaFunSpec;", "Lcom/squareup/javapoet/s;", "getActual$room_compiler_processing", "()Lcom/squareup/javapoet/s;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder extends JavaLang implements XFunSpec.Builder {
        private final s actual;

        public Builder(s r5) {
            Intrinsics.checkNotNullParameter(r5, "actual");
            this.actual = r5;
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public /* bridge */ /* synthetic */ XFunSpec.Builder addCode(XCodeBlock r5) {
            return addCode(r5);
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public /* bridge */ /* synthetic */ XFunSpec.Builder addParameter(XTypeName r5, String r10, List r11) {
            return addParameter(r5, r10, r11);
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public /* bridge */ /* synthetic */ XFunSpec build() {
            return build();
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public /* bridge */ /* synthetic */ XFunSpec.Builder callSuperConstructor(XCodeBlock[] r5) {
            return callSuperConstructor(r5);
        }

        public final s getActual$room_compiler_processing() {
            return this.actual;
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public /* bridge */ /* synthetic */ XFunSpec.Builder returns(XTypeName r5) {
            return returns(r5);
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public Builder addCode(XCodeBlock r5) {
            Intrinsics.checkNotNullParameter(r5, "code");
            if ((r5 instanceof JavaCodeBlock) == false) goto L7;
            this.actual.j(((JavaCodeBlock) r5).getActual$room_compiler_processing());
            return this;
        L7:
            throw new IllegalArgumentException("Failed requirement.");
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public Builder addParameter(XTypeName r5, String r10, List<? extends XAnnotationSpec> r11) {
            Intrinsics.checkNotNullParameter(r5, "typeName");
            Intrinsics.checkNotNullParameter(r10, "name");
            Intrinsics.checkNotNullParameter(r11, "annotations");
            s r12 = this.actual;
            a r13 = u.a(r5.getJava$room_compiler_processing(), r10, new Modifier[]{Modifier.FINAL});
            if (r5.getNullability$room_compiler_processing() != XNullability.NULLABLE) goto L6;
            r13.k(ClassNamesKt.getNULLABLE_ANNOTATION());
        L8:
            r12.m(r13.n());
            return this;
        L6:
            if (r5.getNullability$room_compiler_processing() != XNullability.NONNULL) goto L8;
            r13.k(ClassNamesKt.getNONNULL_ANNOTATION());
            goto L8
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public JavaFunSpec build() {
            s r5 = this.actual;
            r5.getClass();
            return new JavaFunSpec(new t(r5));
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public Builder callSuperConstructor(XCodeBlock... r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            s r5 = this.actual;
            String r11 = "super(" + PoetExtKt.getL() + ')';
            ArrayList r12 = new ArrayList(r10.length);
            int r13 = r10.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L9;
            XCodeBlock r15 = r10[r14];
            if ((r15 instanceof JavaCodeBlock) == false) goto L8;
            r12.add(((JavaCodeBlock) r15).getActual$room_compiler_processing());
            r14 = r14 + 1;
            goto L3
        L8:
            throw new IllegalStateException("Check failed.");
        L9:
            r5.o(r11, new Object[]{i.c(", ", r12)});
            return this;
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public Builder returns(XTypeName r5) {
            Intrinsics.checkNotNullParameter(r5, "typeName");
            if (Intrinsics.areEqual(r5.getJava$room_compiler_processing(), x.d) == false) goto L5;
        L16:
            return this;
        L5:
            if (Intrinsics.areEqual(r5.getJava$room_compiler_processing(), KnownTypeNames.INSTANCE.getKOTLIN_UNIT()) == true) goto L16;
            if (this.actual.f15008j.contains(Modifier.PRIVATE) == false) goto L10;
        L15:
            this.actual.v(r5.getJava$room_compiler_processing());
            goto L16
        L10:
            if (r5.getNullability$room_compiler_processing() != XNullability.NULLABLE) goto L13;
            this.actual.i(ClassNamesKt.getNULLABLE_ANNOTATION());
            goto L15
        L13:
            if (r5.getNullability$room_compiler_processing() != XNullability.NONNULL) goto L15;
            this.actual.i(ClassNamesKt.getNONNULL_ANNOTATION());
            goto L15
        }
    }

    public JavaFunSpec(t r5) {
        Intrinsics.checkNotNullParameter(r5, "actual");
        this.actual = r5;
    }

    public final t getActual$room_compiler_processing() {
        return this.actual;
    }
}
