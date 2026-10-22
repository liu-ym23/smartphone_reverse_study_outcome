package androidx.room.compiler.codegen.java;

import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.TargetLanguage;
import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.compiler.codegen.XFunSpec;
import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.codegen.XTypeSpec;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB\u0013\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/room/compiler/codegen/java/JavaCodeBlock;", "Landroidx/room/compiler/codegen/java/JavaLang;", "Landroidx/room/compiler/codegen/XCodeBlock;", "Lcom/squareup/javapoet/i;", "Landroidx/room/compiler/codegen/JCodeBlock;", "actual", "<init>", "(Lcom/squareup/javapoet/i;)V", "Lcom/squareup/javapoet/i;", "getActual$room_compiler_processing", "()Lcom/squareup/javapoet/i;", "Builder", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavaCodeBlock extends JavaLang implements XCodeBlock {
    private final i actual;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0010\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0012J/\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J1\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00052\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001d\u0010\u0012J/\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00052\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001e\u0010\u0012J\u000f\u0010\u001f\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\"R\"\u0010%\u001a\n $*\u0004\u0018\u00010#0#8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroidx/room/compiler/codegen/java/JavaCodeBlock$Builder;", "Landroidx/room/compiler/codegen/java/JavaLang;", "Landroidx/room/compiler/codegen/XCodeBlock$Builder;", "<init>", "()V", "", "format", "processFormatString", "(Ljava/lang/String;)Ljava/lang/String;", "", "", "args", "processArgs", "([Ljava/lang/Object;)[Ljava/lang/Object;", "Landroidx/room/compiler/codegen/XCodeBlock;", "code", "add", "(Landroidx/room/compiler/codegen/XCodeBlock;)Landroidx/room/compiler/codegen/java/JavaCodeBlock$Builder;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroidx/room/compiler/codegen/java/JavaCodeBlock$Builder;", "addStatement", "name", "Landroidx/room/compiler/codegen/XTypeName;", "typeName", "", "isMutable", "assignExpr", "addLocalVariable", "(Ljava/lang/String;Landroidx/room/compiler/codegen/XTypeName;ZLandroidx/room/compiler/codegen/XCodeBlock;)Landroidx/room/compiler/codegen/java/JavaCodeBlock$Builder;", "controlFlow", "beginControlFlow", "nextControlFlow", "endControlFlow", "()Landroidx/room/compiler/codegen/java/JavaCodeBlock$Builder;", "build", "()Landroidx/room/compiler/codegen/XCodeBlock;", "Lcom/squareup/javapoet/g;", "kotlin.jvm.PlatformType", "actual", "Lcom/squareup/javapoet/g;", "getActual$room_compiler_processing", "()Lcom/squareup/javapoet/g;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder extends JavaLang implements XCodeBlock.Builder {
        private final g actual;

        public Builder() {
            int r5 = i.f14970c;
            this.actual = new g();
        }

        private final Object[] processArgs(Object[] r10) {
            int r5 = r10.length;
            Object[] r11 = new Object[r5];
            int r12 = 0;
        L3:
            if (r12 >= r5) goto L24;
            Object r13 = r10[r12];
            if ((r13 instanceof TargetLanguage) == false) goto L12;
            if (((TargetLanguage) r13).getLanguage() == CodeLanguage.JAVA) goto L12;
            throw new IllegalStateException((r13 + " is not JavaCode").toString());
        L12:
            if ((r13 instanceof XTypeName) == false) goto L15;
            r13 = ((XTypeName) r13).getJava$room_compiler_processing();
        L23:
            r11[r12] = r13;
            r12 = r12 + 1;
            goto L3
        L15:
            if ((r13 instanceof XTypeSpec) == false) goto L18;
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.room.compiler.codegen.java.JavaTypeSpec");
            r13 = ((JavaTypeSpec) r13).getActual$room_compiler_processing();
            goto L23
        L18:
            if ((r13 instanceof XFunSpec) == false) goto L21;
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.room.compiler.codegen.java.JavaFunSpec");
            r13 = ((JavaFunSpec) r13).getActual$room_compiler_processing();
            goto L23
        L21:
            if ((r13 instanceof XCodeBlock) == false) goto L23;
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.room.compiler.codegen.java.JavaCodeBlock");
            r13 = ((JavaCodeBlock) r13).getActual$room_compiler_processing();
            goto L23
        L24:
            return r11;
        }

        private final String processFormatString(String r5) {
            return StringsKt.E(r5, '%', Typography.dollar);
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public /* bridge */ /* synthetic */ XCodeBlock.Builder add(XCodeBlock r5) {
            return add(r5);
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public /* bridge */ /* synthetic */ XCodeBlock.Builder addLocalVariable(String r5, XTypeName r10, boolean r11, XCodeBlock r12) {
            return addLocalVariable(r5, r10, r11, r12);
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public /* bridge */ /* synthetic */ XCodeBlock.Builder addStatement(String r5, Object[] r10) {
            return addStatement(r5, r10);
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public /* bridge */ /* synthetic */ XCodeBlock.Builder beginControlFlow(String r5, Object[] r10) {
            return beginControlFlow(r5, r10);
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public XCodeBlock build() {
            g r5 = this.actual;
            r5.getClass();
            return new JavaCodeBlock(new i(r5));
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public /* bridge */ /* synthetic */ XCodeBlock.Builder endControlFlow() {
            return endControlFlow();
        }

        public final g getActual$room_compiler_processing() {
            return this.actual;
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public /* bridge */ /* synthetic */ XCodeBlock.Builder nextControlFlow(String r5, Object[] r10) {
            return nextControlFlow(r5, r10);
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public /* bridge */ /* synthetic */ XCodeBlock.Builder add(String r5, Object[] r10) {
            return add(r5, r10);
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public Builder addLocalVariable(String r5, XTypeName r10, boolean r11, XCodeBlock r12) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "typeName");
            if (r11 == false) goto L5;
            String r13 = "";
        L6:
            if (r12 != null) goto L8;
            this.actual.c(r13.concat("$T $L"), new Object[]{r10.getJava$room_compiler_processing(), r5});
        L13:
            return this;
        L8:
            if ((r12 instanceof JavaCodeBlock) == false) goto L11;
            this.actual.c(r13.concat("$T $L = $L"), new Object[]{r10.getJava$room_compiler_processing(), r5, ((JavaCodeBlock) r12).getActual$room_compiler_processing()});
            goto L13
        L11:
            throw new IllegalArgumentException("Failed requirement.");
        L5:
            r13 = "final ";
            goto L6
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public Builder addStatement(String r5, Object... r10) {
            Intrinsics.checkNotNullParameter(r5, "format");
            Intrinsics.checkNotNullParameter(r10, "args");
            String r11 = processFormatString(r5);
            Object[] r12 = processArgs(r10);
            this.actual.c(r11, Arrays.copyOf(r12, r12.length));
            return this;
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public Builder beginControlFlow(String r5, Object... r10) {
            Intrinsics.checkNotNullParameter(r5, "controlFlow");
            Intrinsics.checkNotNullParameter(r10, "args");
            String r11 = processFormatString(r5);
            Object[] r12 = processArgs(r10);
            this.actual.e(r11, Arrays.copyOf(r12, r12.length));
            return this;
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public Builder endControlFlow() {
            this.actual.g();
            return this;
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public Builder nextControlFlow(String r5, Object... r10) {
            Intrinsics.checkNotNullParameter(r5, "controlFlow");
            Intrinsics.checkNotNullParameter(r10, "args");
            String r11 = processFormatString(r5);
            Object[] r12 = processArgs(r10);
            this.actual.h(r11, Arrays.copyOf(r12, r12.length));
            return this;
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public Builder add(XCodeBlock r5) {
            Intrinsics.checkNotNullParameter(r5, "code");
            if ((r5 instanceof JavaCodeBlock) == false) goto L7;
            this.actual.a(((JavaCodeBlock) r5).getActual$room_compiler_processing());
            return this;
        L7:
            throw new IllegalArgumentException("Failed requirement.");
        }

        @Override // androidx.room.compiler.codegen.XCodeBlock.Builder
        public Builder add(String r5, Object... r10) {
            Intrinsics.checkNotNullParameter(r5, "format");
            Intrinsics.checkNotNullParameter(r10, "args");
            String r11 = processFormatString(r5);
            Object[] r12 = processArgs(r10);
            this.actual.b(r11, Arrays.copyOf(r12, r12.length));
            return this;
        }
    }

    public JavaCodeBlock(i r5) {
        Intrinsics.checkNotNullParameter(r5, "actual");
        this.actual = r5;
    }

    public final i getActual$room_compiler_processing() {
        return this.actual;
    }
}
