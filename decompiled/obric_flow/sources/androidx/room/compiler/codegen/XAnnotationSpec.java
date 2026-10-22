package androidx.room.compiler.codegen;

import androidx.room.compiler.codegen.java.JavaAnnotationSpec;
import androidx.room.compiler.codegen.kotlin.KotlinAnnotationSpec;
import com.squareup.javapoet.b;
import com.squareup.kotlinpoet.a;
import com.squareup.kotlinpoet.c;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00032\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/codegen/XAnnotationSpec;", "Landroidx/room/compiler/codegen/TargetLanguage;", "Builder", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XAnnotationSpec extends TargetLanguage {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/codegen/XAnnotationSpec$Builder;", "Landroidx/room/compiler/codegen/TargetLanguage;", "addMember", "name", "", "code", "Landroidx/room/compiler/codegen/XCodeBlock;", "build", "Landroidx/room/compiler/codegen/XAnnotationSpec;", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Builder extends TargetLanguage {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/codegen/XAnnotationSpec$Builder$Companion;", "", "()V", "addMember", "Landroidx/room/compiler/codegen/XAnnotationSpec$Builder;", "name", "", "format", "args", "", "(Landroidx/room/compiler/codegen/XAnnotationSpec$Builder;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Landroidx/room/compiler/codegen/XAnnotationSpec$Builder;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }

            public final Builder addMember(Builder r5, String r10, String r11, Object... r12) {
                Intrinsics.checkNotNullParameter(r5, "<this>");
                Intrinsics.checkNotNullParameter(r10, "name");
                Intrinsics.checkNotNullParameter(r11, "format");
                Intrinsics.checkNotNullParameter(r12, "args");
                return r5.addMember(r10, XCodeBlock.Companion.of(r5.getLanguage(), r11, Arrays.copyOf(r12, r12.length)));
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }

        Builder addMember(String r5, XCodeBlock r10);

        XAnnotationSpec build();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/room/compiler/codegen/XAnnotationSpec$Companion;", "", "()V", "builder", "Landroidx/room/compiler/codegen/XAnnotationSpec$Builder;", "language", "Landroidx/room/compiler/codegen/CodeLanguage;", "className", "Landroidx/room/compiler/codegen/XClassName;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        public final Builder builder(CodeLanguage r5, XClassName r10) {
            Intrinsics.checkNotNullParameter(r5, "language");
            Intrinsics.checkNotNullParameter(r10, "className");
            int r11 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
            if (r11 == 1) goto L10;
            if (r11 != 2) goto L8;
            c r12 = r10.getKotlin$room_compiler_processing();
            Intrinsics.checkNotNullParameter(r12, "type");
            return new KotlinAnnotationSpec.Builder(new a(r12));
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return new JavaAnnotationSpec.Builder(b.a(r10.getJava$room_compiler_processing()));
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
