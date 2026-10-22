package androidx.room.compiler.codegen;

import androidx.room.compiler.codegen.java.JavaTypeSpec;
import androidx.room.compiler.codegen.kotlin.KotlinTypeSpec;
import com.bytedance.android.anniex.base.service.f;
import com.squareup.javapoet.TypeSpec$Kind;
import com.squareup.javapoet.e;
import com.squareup.javapoet.y;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.c;
import com.squareup.kotlinpoet.c0;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00072\u00020\u0001:\u0002\u0006\u0007R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/codegen/XTypeSpec;", "Landroidx/room/compiler/codegen/TargetLanguage;", "className", "Landroidx/room/compiler/codegen/XClassName;", "getClassName", "()Landroidx/room/compiler/codegen/XClassName;", "Builder", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XTypeSpec extends TargetLanguage {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH&JF\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "Landroidx/room/compiler/codegen/TargetLanguage;", "addAnnotation", "", "annotation", "Landroidx/room/compiler/codegen/XAnnotationSpec;", "addFunction", "functionSpec", "Landroidx/room/compiler/codegen/XFunSpec;", "addProperty", "typeName", "Landroidx/room/compiler/codegen/XTypeName;", "name", "", "visibility", "Landroidx/room/compiler/codegen/VisibilityModifier;", "isMutable", "", "initExpr", "Landroidx/room/compiler/codegen/XCodeBlock;", "annotations", "", "build", "Landroidx/room/compiler/codegen/XTypeSpec;", "superclass", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Builder extends TargetLanguage {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\f\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/room/compiler/codegen/XTypeSpec$Builder$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "Lkotlin/Function1;", "Lcom/squareup/javapoet/y;", "", "Lkotlin/ExtensionFunctionType;", "javaTypeBuilder", "Lcom/squareup/kotlinpoet/c0;", "kotlinTypeBuilder", "apply", "(Landroidx/room/compiler/codegen/XTypeSpec$Builder;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

            public final Builder apply(Builder r5, Function1<? super y, Unit> r10, Function1<? super c0, Unit> r11) {
                Intrinsics.checkNotNullParameter(r5, "<this>");
                Intrinsics.checkNotNullParameter(r10, "javaTypeBuilder");
                Intrinsics.checkNotNullParameter(r11, "kotlinTypeBuilder");
                CodeLanguage r12 = r5.getLanguage();
                int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
                if (r13 == 1) goto L13;
                if (r13 == 2) goto L8;
            L15:
                return r5;
            L8:
                if ((r5 instanceof KotlinTypeSpec.Builder) == false) goto L11;
                r11.invoke(((KotlinTypeSpec.Builder) r5).getActual$room_compiler_processing());
                goto L15
            L11:
                throw new IllegalStateException("Check failed.");
            L13:
                if ((r5 instanceof JavaTypeSpec.Builder) == false) goto L17;
                r10.invoke(((JavaTypeSpec.Builder) r5).getActual$room_compiler_processing());
                goto L15
            L17:
                throw new IllegalStateException("Check failed.");
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ Builder addProperty$default(Builder r10, XTypeName r11, String r12, VisibilityModifier r13, boolean r14, XCodeBlock r15, List r16, int r17, Object r18) {
            if (r18 != null) goto L15;
            if ((r17 & 8) == 0) goto L6;
            r14 = false;
        L6:
            boolean r5 = r14;
            if ((r17 & 16) == 0) goto L9;
            r15 = null;
        L9:
            XCodeBlock r19 = r15;
            if ((r17 & 32) == 0) goto L13;
            r16 = CollectionsKt.emptyList();
        L13:
            return r10.addProperty(r11, r12, r13, r5, r19, r16);
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addProperty");
        }

        void addAnnotation(XAnnotationSpec r5);

        Builder addFunction(XFunSpec r5);

        Builder addProperty(XTypeName r5, String r10, VisibilityModifier r11, boolean r12, XCodeBlock r13, List<? extends XAnnotationSpec> r14);

        XTypeSpec build();

        Builder superclass(XTypeName r5);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/room/compiler/codegen/XTypeSpec$Companion;", "", "()V", "classBuilder", "Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "language", "Landroidx/room/compiler/codegen/CodeLanguage;", "className", "Landroidx/room/compiler/codegen/XClassName;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        public final Builder classBuilder(CodeLanguage r5, XClassName r10) {
            Intrinsics.checkNotNullParameter(r5, "language");
            Intrinsics.checkNotNullParameter(r10, "className");
            int r11 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
            if (r11 != 1) goto L5;
            e r12 = r10.getJava$room_compiler_processing();
            f.s(r12, "className == null", new Object[0]);
            TypeSpec$Kind r13 = TypeSpec$Kind.CLASS;
            String r14 = r12.f14961y;
            f.s(r14, "name == null", new Object[0]);
            return new JavaTypeSpec.Builder(r10, new y(r13, r14, null));
        L5:
            if (r11 != 2) goto L8;
            c r15 = r10.getKotlin$room_compiler_processing();
            Intrinsics.checkNotNullParameter(r15, "className");
            String r16 = r15.e();
            Intrinsics.checkNotNullParameter(r16, "name");
            return new KotlinTypeSpec.Builder(r10, new c0(com.squareup.kotlinpoet.TypeSpec$Kind.CLASS, r16, new KModifier[0]));
        L8:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    XClassName getClassName();
}
