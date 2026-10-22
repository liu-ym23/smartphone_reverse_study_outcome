package androidx.room.compiler.codegen.kotlin;

import ai.j0;
import androidx.room.compiler.codegen.XAnnotationSpec;
import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.compiler.codegen.XFunSpec;
import androidx.room.compiler.codegen.XTypeName;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.a0;
import com.squareup.kotlinpoet.b0;
import com.squareup.kotlinpoet.d;
import com.squareup.kotlinpoet.e;
import com.squareup.kotlinpoet.j;
import com.squareup.kotlinpoet.k;
import com.squareup.kotlinpoet.s;
import io.reactivex.exceptions.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\nB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/codegen/kotlin/KotlinFunSpec;", "Landroidx/room/compiler/codegen/kotlin/KotlinLang;", "Landroidx/room/compiler/codegen/XFunSpec;", "Lcom/squareup/kotlinpoet/k;", "actual", "<init>", "(Lcom/squareup/kotlinpoet/k;)V", "Lcom/squareup/kotlinpoet/k;", "getActual$room_compiler_processing", "()Lcom/squareup/kotlinpoet/k;", "Builder", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinFunSpec extends KotlinLang implements XFunSpec {
    private final k actual;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0014\"\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/room/compiler/codegen/kotlin/KotlinFunSpec$Builder;", "Landroidx/room/compiler/codegen/kotlin/KotlinLang;", "Landroidx/room/compiler/codegen/XFunSpec$Builder;", "Lcom/squareup/kotlinpoet/j;", "actual", "<init>", "(Lcom/squareup/kotlinpoet/j;)V", "Landroidx/room/compiler/codegen/XCodeBlock;", "code", "addCode", "(Landroidx/room/compiler/codegen/XCodeBlock;)Landroidx/room/compiler/codegen/kotlin/KotlinFunSpec$Builder;", "Landroidx/room/compiler/codegen/XTypeName;", "typeName", "", "name", "", "Landroidx/room/compiler/codegen/XAnnotationSpec;", "annotations", "addParameter", "(Landroidx/room/compiler/codegen/XTypeName;Ljava/lang/String;Ljava/util/List;)Landroidx/room/compiler/codegen/kotlin/KotlinFunSpec$Builder;", "", "args", "callSuperConstructor", "([Landroidx/room/compiler/codegen/XCodeBlock;)Landroidx/room/compiler/codegen/kotlin/KotlinFunSpec$Builder;", "returns", "(Landroidx/room/compiler/codegen/XTypeName;)Landroidx/room/compiler/codegen/kotlin/KotlinFunSpec$Builder;", "Landroidx/room/compiler/codegen/kotlin/KotlinFunSpec;", "build", "()Landroidx/room/compiler/codegen/kotlin/KotlinFunSpec;", "Lcom/squareup/kotlinpoet/j;", "getActual$room_compiler_processing", "()Lcom/squareup/kotlinpoet/j;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder extends KotlinLang implements XFunSpec.Builder {
        private final j actual;

        public Builder(j r5) {
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

        public final j getActual$room_compiler_processing() {
            return this.actual;
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public /* bridge */ /* synthetic */ XFunSpec.Builder returns(XTypeName r5) {
            return returns(r5);
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public Builder addCode(XCodeBlock r5) {
            Intrinsics.checkNotNullParameter(r5, "code");
            if ((r5 instanceof KotlinCodeBlock) == false) goto L7;
            j r10 = this.actual;
            e r11 = ((KotlinCodeBlock) r5).getActual$room_compiler_processing();
            r10.getClass();
            Intrinsics.checkNotNullParameter(r11, "codeBlock");
            d r12 = r10.f15162i;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r11, "codeBlock");
            CollectionsKt.a(r12.f15113a, r11.f15131a);
            r12.f15114b.addAll(r11.f15132b);
            return this;
        L7:
            throw new IllegalArgumentException("Failed requirement.");
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public Builder addParameter(XTypeName r5, String r10, List<? extends XAnnotationSpec> r11) {
            Intrinsics.checkNotNullParameter(r5, "typeName");
            Intrinsics.checkNotNullParameter(r10, "name");
            Intrinsics.checkNotNullParameter(r11, "annotations");
            j r12 = this.actual;
            a0 r13 = r5.getKotlin$room_compiler_processing();
            KModifier[] r14 = new KModifier[0];
            Intrinsics.checkNotNullParameter(r10, "name");
            Intrinsics.checkNotNullParameter(r13, "type");
            Intrinsics.checkNotNullParameter(r14, "modifiers");
            ug.d r15 = new ug.d(r10, r13);
            KModifier[] r16 = (KModifier[]) Arrays.copyOf(r14, 0);
            Intrinsics.checkNotNullParameter(r16, "modifiers");
            CollectionsKt.c((ArrayList) r15.f, r16);
            s r17 = new s(r15);
            r12.getClass();
            Intrinsics.checkNotNullParameter(r17, "parameterSpec");
            r12.f15166m.add(r17);
            return this;
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public KotlinFunSpec build() {
            j r5 = this.actual;
            boolean r10 = r5.f15165l.isEmpty();
            String r11 = r5.f15158a;
            if (r10 == true) goto L9;
            e r12 = k.f15169q;
            if (a.o(r11) == false) goto L9;
            throw new IllegalStateException(r11.concat(" cannot have type variables").toString());
        L9:
            boolean r13 = Intrinsics.areEqual(r11, "get()");
            ArrayList r14 = r5.f15166m;
            if (r13 == false) goto L17;
            if (r14.isEmpty() == true) goto L17;
            throw new IllegalStateException(j0.j(r11, " cannot have parameters").toString());
        L17:
            if (Intrinsics.areEqual(r11, "set()") == false) goto L24;
            if (r14.size() <= 1) goto L24;
            throw new IllegalStateException(j0.j(r11, " can have at most one parameter").toString());
        L24:
            return new KotlinFunSpec(new k(r5));
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public Builder callSuperConstructor(XCodeBlock... r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            j r5 = this.actual;
            ArrayList r11 = new ArrayList(r10.length);
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            XCodeBlock r14 = r10[r13];
            if ((r14 instanceof KotlinCodeBlock) == false) goto L8;
            r11.add(((KotlinCodeBlock) r14).getActual$room_compiler_processing());
            r13 = r13 + 1;
            goto L3
        L8:
            throw new IllegalStateException("Check failed.");
        L9:
            r5.getClass();
            Intrinsics.checkNotNullParameter(r11, "args");
            e r15 = k.f15169q;
            String r16 = r5.f15158a;
            Intrinsics.checkNotNullParameter(r16, "<this>");
            if (Intrinsics.areEqual(r16, "constructor()") == false) goto L14;
            r5.g = "super";
            r5.f15161h = r11;
            return this;
        L14:
            throw new IllegalStateException("only constructors can delegate to other constructors!");
        }

        @Override // androidx.room.compiler.codegen.XFunSpec.Builder
        public Builder returns(XTypeName r5) {
            Intrinsics.checkNotNullParameter(r5, "typeName");
            if (Intrinsics.areEqual(r5.getKotlin$room_compiler_processing(), b0.f15082c) == true) goto L10;
            j r10 = this.actual;
            a0 r11 = r5.getKotlin$room_compiler_processing();
            e r12 = e.d;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r11, "returnType");
            Intrinsics.checkNotNullParameter(r12, "kdoc");
            e r13 = k.f15169q;
            String r14 = r10.f15158a;
            Intrinsics.checkNotNullParameter(r14, "<this>");
            if (Intrinsics.areEqual(r14, "constructor()") == true) goto L12;
            if (a.o(r14) == true) goto L12;
            r10.f = r11;
            r10.f15160c = r12;
        L12:
            throw new IllegalStateException(r14.concat(" cannot have a return type").toString());
        L10:
            return this;
        }
    }

    public KotlinFunSpec(k r5) {
        Intrinsics.checkNotNullParameter(r5, "actual");
        this.actual = r5;
    }

    public final k getActual$room_compiler_processing() {
        return this.actual;
    }
}
