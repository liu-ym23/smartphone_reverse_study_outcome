package androidx.room.compiler.codegen.java;

import androidx.room.compiler.codegen.XAnnotationSpec;
import androidx.room.compiler.codegen.XCodeBlock;
import com.google.android.material.color.utilities.h;
import com.squareup.javapoet.a;
import com.squareup.javapoet.b;
import com.squareup.javapoet.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB\u0013\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/room/compiler/codegen/java/JavaAnnotationSpec;", "Landroidx/room/compiler/codegen/java/JavaLang;", "Landroidx/room/compiler/codegen/XAnnotationSpec;", "Lcom/squareup/javapoet/b;", "Lcom/squareup/kotlinpoet/javapoet/JAnnotationSpec;", "actual", "<init>", "(Lcom/squareup/javapoet/b;)V", "Lcom/squareup/javapoet/b;", "getActual$room_compiler_processing", "()Lcom/squareup/javapoet/b;", "Builder", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavaAnnotationSpec extends JavaLang implements XAnnotationSpec {
    private final b actual;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/room/compiler/codegen/java/JavaAnnotationSpec$Builder;", "Landroidx/room/compiler/codegen/java/JavaLang;", "Landroidx/room/compiler/codegen/XAnnotationSpec$Builder;", "Lcom/squareup/javapoet/a;", "Landroidx/room/compiler/codegen/JAnnotationSpecBuilder;", "actual", "<init>", "(Lcom/squareup/javapoet/a;)V", "", "name", "Landroidx/room/compiler/codegen/XCodeBlock;", "code", "addMember", "(Ljava/lang/String;Landroidx/room/compiler/codegen/XCodeBlock;)Landroidx/room/compiler/codegen/java/JavaAnnotationSpec$Builder;", "Landroidx/room/compiler/codegen/XAnnotationSpec;", "build", "()Landroidx/room/compiler/codegen/XAnnotationSpec;", "Lcom/squareup/javapoet/a;", "getActual$room_compiler_processing", "()Lcom/squareup/javapoet/a;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder extends JavaLang implements XAnnotationSpec.Builder {
        private final a actual;

        public Builder(a r5) {
            Intrinsics.checkNotNullParameter(r5, "actual");
            this.actual = r5;
        }

        @Override // androidx.room.compiler.codegen.XAnnotationSpec.Builder
        public /* bridge */ /* synthetic */ XAnnotationSpec.Builder addMember(String r5, XCodeBlock r10) {
            return addMember(r5, r10);
        }

        @Override // androidx.room.compiler.codegen.XAnnotationSpec.Builder
        public XAnnotationSpec build() {
            return new JavaAnnotationSpec(this.actual.b());
        }

        public final a getActual$room_compiler_processing() {
            return this.actual;
        }

        @Override // androidx.room.compiler.codegen.XAnnotationSpec.Builder
        public Builder addMember(String r5, XCodeBlock r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "code");
            if ((r10 instanceof JavaCodeBlock) == false) goto L7;
            a r11 = this.actual;
            i r12 = ((JavaCodeBlock) r10).getActual$room_compiler_processing();
            ((List) r11.f14949b.computeIfAbsent(r5, new h(3))).add(r12);
            return this;
        L7:
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public JavaAnnotationSpec(b r5) {
        Intrinsics.checkNotNullParameter(r5, "actual");
        this.actual = r5;
    }

    public final b getActual$room_compiler_processing() {
        return this.actual;
    }
}
