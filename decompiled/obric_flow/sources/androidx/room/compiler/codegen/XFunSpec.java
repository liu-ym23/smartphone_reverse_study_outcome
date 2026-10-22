package androidx.room.compiler.codegen;

import androidx.room.compiler.codegen.java.JavaFunSpec;
import androidx.room.compiler.codegen.java.JavaFunSpecKt;
import androidx.room.compiler.codegen.kotlin.KotlinFunSpec;
import androidx.room.compiler.codegen.kotlin.KotlinFunSpecKt;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.e;
import com.squareup.kotlinpoet.j;
import com.squareup.kotlinpoet.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00032\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/codegen/XFunSpec;", "Landroidx/room/compiler/codegen/TargetLanguage;", "Builder", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XFunSpec extends TargetLanguage {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J(\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\b\u0010\r\u001a\u00020\u000eH&J!\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0011\"\u00020\u0004H&¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/codegen/XFunSpec$Builder;", "Landroidx/room/compiler/codegen/TargetLanguage;", "addCode", "code", "Landroidx/room/compiler/codegen/XCodeBlock;", "addParameter", "typeName", "Landroidx/room/compiler/codegen/XTypeName;", "name", "", "annotations", "", "Landroidx/room/compiler/codegen/XAnnotationSpec;", "build", "Landroidx/room/compiler/codegen/XFunSpec;", "callSuperConstructor", "args", "", "([Landroidx/room/compiler/codegen/XCodeBlock;)Landroidx/room/compiler/codegen/XFunSpec$Builder;", "returns", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Builder extends TargetLanguage {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Landroidx/room/compiler/codegen/XFunSpec$Builder$Companion;", "", "()V", "addStatement", "Landroidx/room/compiler/codegen/XFunSpec$Builder;", "format", "", "args", "", "(Landroidx/room/compiler/codegen/XFunSpec$Builder;Ljava/lang/String;[Ljava/lang/Object;)Landroidx/room/compiler/codegen/XFunSpec$Builder;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }

            public final Builder addStatement(Builder r5, String r10, Object... r11) {
                Intrinsics.checkNotNullParameter(r5, "<this>");
                Intrinsics.checkNotNullParameter(r10, "format");
                Intrinsics.checkNotNullParameter(r11, "args");
                return r5.addCode(XCodeBlock.Companion.builder(r5.getLanguage()).addStatement(r10, Arrays.copyOf(r11, r11.length)).build());
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ Builder addParameter$default(Builder r5, XTypeName r10, String r11, List r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 4) == 0) goto L7;
            r12 = CollectionsKt.emptyList();
        L7:
            return r5.addParameter(r10, r11, r12);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addParameter");
        }

        Builder addCode(XCodeBlock r5);

        Builder addParameter(XTypeName r5, String r10, List<? extends XAnnotationSpec> r11);

        XFunSpec build();

        Builder callSuperConstructor(XCodeBlock... r5);

        Builder returns(XTypeName r5);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000f"}, d2 = {"Landroidx/room/compiler/codegen/XFunSpec$Companion;", "", "()V", "builder", "Landroidx/room/compiler/codegen/XFunSpec$Builder;", "language", "Landroidx/room/compiler/codegen/CodeLanguage;", "name", "", "visibility", "Landroidx/room/compiler/codegen/VisibilityModifier;", "isOpen", "", "isOverridden", "constructorBuilder", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[CodeLanguage.values().length];
                r5[CodeLanguage.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r5[CodeLanguage.KOTLIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r5;
            }
        }

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public static /* synthetic */ Builder builder$default(Companion r10, CodeLanguage r11, String r12, VisibilityModifier r13, boolean r14, boolean r15, int r16, Object r17) {
            if ((r16 & 8) == 0) goto L5;
            boolean r5 = false;
        L7:
            if ((r16 & 16) == 0) goto L9;
            boolean r18 = false;
        L11:
            return r10.builder(r11, r12, r13, r5, r18);
        L9:
            r18 = r15;
            goto L11
        L5:
            r5 = r14;
            goto L7
        }

        public final Builder builder(CodeLanguage r5, String r10, VisibilityModifier r11, boolean r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r5, "language");
            Intrinsics.checkNotNullParameter(r10, "name");
            Intrinsics.checkNotNullParameter(r11, "visibility");
            int r14 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
            if (r14 != 1) goto L5;
            s r15 = new s(r10);
            r15.l(new Modifier[]{JavaFunSpecKt.toJavaVisibilityModifier(r11)});
            if (r13 == false) goto L18;
            r15.h();
        L18:
            return new JavaFunSpec.Builder(r15);
        L5:
            if (r14 != 2) goto L13;
            e r16 = k.f15169q;
            Intrinsics.checkNotNullParameter(r10, "name");
            j r17 = new j(r10);
            KModifier[] r18 = {KotlinFunSpecKt.toKotlinVisibilityModifier(r11)};
            Intrinsics.checkNotNullParameter(r18, "modifiers");
            ArrayList r19 = r17.f15164k;
            CollectionsKt.c(r19, r18);
            if (r12 == false) goto L9;
            KModifier[] r20 = {KModifier.OPEN};
            Intrinsics.checkNotNullParameter(r20, "modifiers");
            CollectionsKt.c(r19, r20);
        L9:
            if (r13 == false) goto L19;
            KModifier[] r21 = {KModifier.OVERRIDE};
            Intrinsics.checkNotNullParameter(r21, "modifiers");
            CollectionsKt.c(r19, r21);
        L19:
            return new KotlinFunSpec.Builder(r17);
        L13:
            throw new NoWhenBranchMatchedException();
        }

        public final Builder constructorBuilder(CodeLanguage r5, VisibilityModifier r10) {
            Intrinsics.checkNotNullParameter(r5, "language");
            Intrinsics.checkNotNullParameter(r10, "visibility");
            int r11 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
            if (r11 != 1) goto L5;
            s r12 = t.a();
            r12.l(new Modifier[]{JavaFunSpecKt.toJavaVisibilityModifier(r10)});
            return new JavaFunSpec.Builder(r12);
        L5:
            if (r11 != 2) goto L8;
            e r13 = k.f15169q;
            j r14 = new j("constructor()");
            KModifier[] r15 = {KotlinFunSpecKt.toKotlinVisibilityModifier(r10)};
            Intrinsics.checkNotNullParameter(r15, "modifiers");
            CollectionsKt.c(r14.f15164k, r15);
            return new KotlinFunSpec.Builder(r14);
        L8:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
