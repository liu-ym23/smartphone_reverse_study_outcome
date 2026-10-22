package androidx.room.compiler.codegen;

import androidx.room.compiler.codegen.java.JavaCodeBlock;
import androidx.room.compiler.codegen.kotlin.KotlinCodeBlock;
import com.squareup.javapoet.g;
import com.squareup.kotlinpoet.d;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00032\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/codegen/XCodeBlock;", "Landroidx/room/compiler/codegen/TargetLanguage;", "Builder", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XCodeBlock extends TargetLanguage {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J-\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ.\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004H&J-\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ-\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0004H&J\b\u0010\u0016\u001a\u00020\u0000H&J-\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/codegen/XCodeBlock$Builder;", "Landroidx/room/compiler/codegen/TargetLanguage;", "add", "code", "Landroidx/room/compiler/codegen/XCodeBlock;", "format", "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Landroidx/room/compiler/codegen/XCodeBlock$Builder;", "addLocalVariable", "name", "typeName", "Landroidx/room/compiler/codegen/XTypeName;", "isMutable", "", "assignExpr", "addStatement", "beginControlFlow", "controlFlow", "build", "endControlFlow", "nextControlFlow", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Builder extends TargetLanguage {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\f\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/room/compiler/codegen/XCodeBlock$Builder$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/codegen/XCodeBlock$Builder;", "Lkotlin/Function1;", "Lcom/squareup/javapoet/g;", "", "Lkotlin/ExtensionFunctionType;", "javaCodeBuilder", "Lcom/squareup/kotlinpoet/d;", "kotlinCodeBuilder", "apply", "(Landroidx/room/compiler/codegen/XCodeBlock$Builder;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/room/compiler/codegen/XCodeBlock$Builder;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

            public final Builder apply(Builder r5, Function1<? super g, Unit> r10, Function1<? super d, Unit> r11) {
                Intrinsics.checkNotNullParameter(r5, "<this>");
                Intrinsics.checkNotNullParameter(r10, "javaCodeBuilder");
                Intrinsics.checkNotNullParameter(r11, "kotlinCodeBuilder");
                CodeLanguage r12 = r5.getLanguage();
                int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
                if (r13 == 1) goto L13;
                if (r13 == 2) goto L8;
            L15:
                return r5;
            L8:
                if ((r5 instanceof KotlinCodeBlock.Builder) == false) goto L11;
                r11.invoke(((KotlinCodeBlock.Builder) r5).getActual$room_compiler_processing());
                goto L15
            L11:
                throw new IllegalStateException("Check failed.");
            L13:
                if ((r5 instanceof JavaCodeBlock.Builder) == false) goto L17;
                r10.invoke(((JavaCodeBlock.Builder) r5).getActual$room_compiler_processing());
                goto L15
            L17:
                throw new IllegalStateException("Check failed.");
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }

        static /* synthetic */ Builder addLocalVariable$default(Builder r5, String r10, XTypeName r11, boolean r12, XCodeBlock r13, int r14, Object r15) {
            if (r15 != null) goto L12;
            if ((r14 & 4) == 0) goto L7;
            r12 = false;
        L7:
            if ((r14 & 8) == 0) goto L10;
            r13 = null;
        L10:
            return r5.addLocalVariable(r10, r11, r12, r13);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addLocalVariable");
        }

        Builder add(XCodeBlock r5);

        Builder add(String r5, Object... r10);

        Builder addLocalVariable(String r5, XTypeName r10, boolean r11, XCodeBlock r12);

        Builder addStatement(String r5, Object... r10);

        Builder beginControlFlow(String r5, Object... r10);

        XCodeBlock build();

        Builder endControlFlow();

        Builder nextControlFlow(String r5, Object... r10);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ=\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\n2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/compiler/codegen/XCodeBlock$Companion;", "", "()V", "builder", "Landroidx/room/compiler/codegen/XCodeBlock$Builder;", "language", "Landroidx/room/compiler/codegen/CodeLanguage;", "of", "Landroidx/room/compiler/codegen/XCodeBlock;", "format", "", "args", "", "(Landroidx/room/compiler/codegen/CodeLanguage;Ljava/lang/String;[Ljava/lang/Object;)Landroidx/room/compiler/codegen/XCodeBlock;", "ofCast", "typeName", "Landroidx/room/compiler/codegen/XTypeName;", "expressionBlock", "ofNewInstance", "argsFormat", "(Landroidx/room/compiler/codegen/CodeLanguage;Landroidx/room/compiler/codegen/XTypeName;Ljava/lang/String;[Ljava/lang/Object;)Landroidx/room/compiler/codegen/XCodeBlock;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        public static /* synthetic */ XCodeBlock ofNewInstance$default(Companion r5, CodeLanguage r10, XTypeName r11, String r12, Object[] r13, int r14, Object r15) {
            if ((r14 & 4) == 0) goto L6;
            r12 = "";
        L6:
            return r5.ofNewInstance(r10, r11, r12, r13);
        }

        public final Builder builder(CodeLanguage r5) {
            Intrinsics.checkNotNullParameter(r5, "language");
            int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
            if (r10 == 1) goto L10;
            if (r10 != 2) goto L8;
            return new KotlinCodeBlock.Builder();
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return new JavaCodeBlock.Builder();
        }

        public final XCodeBlock of(CodeLanguage r5, String r10, Object... r11) {
            Intrinsics.checkNotNullParameter(r5, "language");
            Intrinsics.checkNotNullParameter(r10, "format");
            Intrinsics.checkNotNullParameter(r11, "args");
            return builder(r5).add(r10, Arrays.copyOf(r11, r11.length)).build();
        }

        public final XCodeBlock ofCast(CodeLanguage r5, XTypeName r10, XCodeBlock r11) {
            Intrinsics.checkNotNullParameter(r5, "language");
            Intrinsics.checkNotNullParameter(r10, "typeName");
            Intrinsics.checkNotNullParameter(r11, "expressionBlock");
            Builder r12 = builder(r5);
            int r13 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
            if (r13 != 1) goto L5;
            r12.add("(%T) (%L)", new Object[]{r10, r11});
        L10:
            return r12.build();
        L5:
            if (r13 != 2) goto L10;
            r12.add("(%L) as %T", new Object[]{r11, r10});
            goto L10
        }

        public final XCodeBlock ofNewInstance(CodeLanguage r5, XTypeName r10, String r11, Object... r12) {
            Intrinsics.checkNotNullParameter(r5, "language");
            Intrinsics.checkNotNullParameter(r10, "typeName");
            Intrinsics.checkNotNullParameter(r11, "argsFormat");
            Intrinsics.checkNotNullParameter(r12, "args");
            Builder r13 = builder(r5);
            int r14 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
            if (r14 == 1) goto L8;
            if (r14 != 2) goto L7;
            String r15 = "";
        L9:
            String r16 = r15 + "%T(" + r11 + ')';
            SpreadBuilder r17 = new SpreadBuilder(2);
            r17.add(r10);
            r17.addSpread(r12);
            r13.add(r16, r17.toArray(new Object[r17.size()]));
            return r13.build();
        L7:
            throw new NoWhenBranchMatchedException();
        L8:
            r15 = "new ";
            goto L9
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
