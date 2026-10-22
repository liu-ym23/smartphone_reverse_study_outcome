package androidx.room.compiler.codegen.kotlin;

import ai.j0;
import androidx.room.compiler.codegen.VisibilityModifier;
import androidx.room.compiler.codegen.XAnnotationSpec;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.compiler.codegen.XFunSpec;
import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.codegen.XTypeSpec;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.TypeSpec$Kind;
import com.squareup.kotlinpoet.a0;
import com.squareup.kotlinpoet.b;
import com.squareup.kotlinpoet.b0;
import com.squareup.kotlinpoet.c0;
import com.squareup.kotlinpoet.d0;
import com.squareup.kotlinpoet.k;
import com.squareup.kotlinpoet.v;
import com.squareup.kotlinpoet.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/room/compiler/codegen/kotlin/KotlinTypeSpec;", "Landroidx/room/compiler/codegen/kotlin/KotlinLang;", "Landroidx/room/compiler/codegen/XTypeSpec;", "Landroidx/room/compiler/codegen/XClassName;", "className", "Lcom/squareup/kotlinpoet/d0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeSpec;", "actual", "<init>", "(Landroidx/room/compiler/codegen/XClassName;Lcom/squareup/kotlinpoet/d0;)V", "Landroidx/room/compiler/codegen/XClassName;", "getClassName", "()Landroidx/room/compiler/codegen/XClassName;", "Lcom/squareup/kotlinpoet/d0;", "getActual$room_compiler_processing", "()Lcom/squareup/kotlinpoet/d0;", "Builder", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinTypeSpec extends KotlinLang implements XTypeSpec {
    private final d0 actual;
    private final XClassName className;

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012JG\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010&R\u001e\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Landroidx/room/compiler/codegen/kotlin/KotlinTypeSpec$Builder;", "Landroidx/room/compiler/codegen/kotlin/KotlinLang;", "Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "Landroidx/room/compiler/codegen/XClassName;", "className", "Lcom/squareup/kotlinpoet/c0;", "Landroidx/room/compiler/codegen/KTypeSpecBuilder;", "actual", "<init>", "(Landroidx/room/compiler/codegen/XClassName;Lcom/squareup/kotlinpoet/c0;)V", "Landroidx/room/compiler/codegen/XTypeName;", "typeName", "superclass", "(Landroidx/room/compiler/codegen/XTypeName;)Landroidx/room/compiler/codegen/kotlin/KotlinTypeSpec$Builder;", "Landroidx/room/compiler/codegen/XAnnotationSpec;", "annotation", "", "addAnnotation", "(Landroidx/room/compiler/codegen/XAnnotationSpec;)V", "", "name", "Landroidx/room/compiler/codegen/VisibilityModifier;", "visibility", "", "isMutable", "Landroidx/room/compiler/codegen/XCodeBlock;", "initExpr", "", "annotations", "addProperty", "(Landroidx/room/compiler/codegen/XTypeName;Ljava/lang/String;Landroidx/room/compiler/codegen/VisibilityModifier;ZLandroidx/room/compiler/codegen/XCodeBlock;Ljava/util/List;)Landroidx/room/compiler/codegen/kotlin/KotlinTypeSpec$Builder;", "Landroidx/room/compiler/codegen/XFunSpec;", "functionSpec", "addFunction", "(Landroidx/room/compiler/codegen/XFunSpec;)Landroidx/room/compiler/codegen/kotlin/KotlinTypeSpec$Builder;", "Landroidx/room/compiler/codegen/XTypeSpec;", "build", "()Landroidx/room/compiler/codegen/XTypeSpec;", "Landroidx/room/compiler/codegen/XClassName;", "Lcom/squareup/kotlinpoet/c0;", "getActual$room_compiler_processing", "()Lcom/squareup/kotlinpoet/c0;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder extends KotlinLang implements XTypeSpec.Builder {
        private final c0 actual;
        private final XClassName className;

        public Builder(XClassName r5, c0 r10) {
            Intrinsics.checkNotNullParameter(r5, "className");
            Intrinsics.checkNotNullParameter(r10, "actual");
            this.className = r5;
            this.actual = r10;
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public void addAnnotation(XAnnotationSpec r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            if ((r5 instanceof KotlinAnnotationSpec) == false) goto L7;
            c0 r10 = this.actual;
            b r11 = ((KotlinAnnotationSpec) r5).getActual$room_compiler_processing();
            r10.getClass();
            Intrinsics.checkNotNullParameter(r11, "annotationSpec");
            r10.f15107l.add(r11);
            return;
        L7:
            throw new IllegalStateException("Check failed.");
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
            XClassName r5 = this.className;
            c0 r10 = this.actual;
            boolean r11 = r10.f15106k.isEmpty();
            String r12 = r10.f15101b;
            if (r11 == false) goto L5;
        L9:
            ArrayList r13 = r10.f15109n;
            boolean r14 = r13.isEmpty();
            Set<? extends KModifier> r15 = r10.f15104i;
            if (r14 == true) goto L16;
            r10.d();
            if (r15.contains(KModifier.EXTERNAL) == false) goto L16;
            throw new IllegalStateException("delegated constructor call in external class is not allowed");
        L16:
            boolean r16 = r15.contains(KModifier.EXTERNAL);
            ArrayList r17 = r10.f15111p;
            if (r16 == false) goto L30;
            if (r17 != null) goto L20;
        L22:
            Iterator r18 = r17.iterator();
        L24:
            if (r18.hasNext() == false) goto L30;
            if (((k) r18.next()).f15179l == null) goto L24;
            throw new IllegalStateException("delegated constructor call in external class is not allowed");
        L20:
            if (r17.isEmpty() == false) goto L22;
        L30:
            if (r12 == null) goto L32;
        L38:
            boolean r19 = r15.contains(KModifier.ABSTRACT);
            TypeSpec$Kind r20 = r10.f15100a;
            if (r19 == false) goto L41;
        L48:
            boolean r21 = true;
        L49:
            Iterator r110 = r17.iterator();
        L51:
            if (r110.hasNext() == false) goto L94;
            k r111 = (k) r110.next();
            if (r21 == true) goto L60;
            if (r111.g.contains(KModifier.ABSTRACT) == false) goto L60;
            StringBuilder r22 = j0.x("non-abstract type ", r12, " cannot declare abstract function ");
            r22.append(r111.f15173b);
            throw new IllegalArgumentException(r22.toString().toString());
        L60:
            if (r20 != TypeSpec$Kind.INTERFACE) goto L80;
            Set r112 = r111.g;
            KModifier[] r113 = {KModifier.INTERNAL, KModifier.PROTECTED};
            Intrinsics.checkNotNullParameter(r112, "modifiers");
            Intrinsics.checkNotNullParameter(r113, "forbidden");
            int r114 = 0;
        L62:
            boolean r115 = r21;
            if (r114 >= 2) goto L69;
            if (r112.contains(r113[r114]) == true) goto L68;
            r114 = r114 + 1;
            r21 = r115;
            goto L62
        L68:
            throw new IllegalArgumentException(("modifiers " + r112 + " must contain none of " + Arrays.toString(r113)).toString());
        L69:
            KModifier[] r116 = {KModifier.ABSTRACT, KModifier.PRIVATE};
            Set r117 = r111.g;
            Intrinsics.checkNotNullParameter(r117, "modifiers");
            Intrinsics.checkNotNullParameter(r116, "mutuallyExclusive");
            int r118 = 0;
            int r119 = 0;
        L70:
            if (r118 >= 2) goto L76;
            if (r117.contains(r116[r118]) == false) goto L74;
            r119 = r119 + 1;
        L74:
            r118 = r118 + 1;
            goto L70
        L76:
            if (r119 <= 1) goto L77;
            throw new IllegalArgumentException(("modifiers " + r117 + " must contain none or only one of " + Arrays.toString(r116)).toString());
        L77:
            r21 = r115;
            goto L51
        L80:
            r115 = r21;
            if (r10.e() == false) goto L88;
            if (Intrinsics.areEqual(r111.g, r20.implicitFunctionModifiers$kotlinpoet(r15)) == true) goto L77;
            throw new IllegalArgumentException(("annotation class " + r12 + '.' + r111.f15173b + " requires modifiers " + r20.implicitFunctionModifiers$kotlinpoet(r15)).toString());
        L88:
            if (r15.contains(KModifier.EXPECT) == false) goto L77;
            if (r111.f15181n.f15131a.isEmpty() == true) goto L77;
            throw new IllegalArgumentException("functions in expect classes can't have bodies");
        L94:
            if (r17 != null) goto L96;
        L98:
            Iterator r23 = r17.iterator();
        L100:
            if (r23.hasNext() == false) goto L109;
            if (((k) r23.next()).d() == false) goto L100;
            if (r13.isEmpty() == true) goto L109;
            throw new IllegalArgumentException("types without a primary constructor cannot specify secondary constructors and superclass constructor parameters");
        L109:
            if (r10.g() == false) goto L120;
            if (r10.f15110o.size() <= 0) goto L118;
            if (Intrinsics.areEqual(r10.d, b0.a(Reflection.getOrCreateKotlinClass(Object.class))) == true) goto L120;
            throw new IllegalStateException("value/inline classes cannot have super classes");
        L118:
            throw new IllegalStateException("value/inline classes must have at least 1 property");
        L120:
            if (r10.f15100a == TypeSpec$Kind.INTERFACE) goto L122;
        L138:
            ArrayList r24 = r10.f15112q;
            if (r24 != null) goto L141;
        L143:
            Iterator r25 = r24.iterator();
            int r120 = 0;
        L145:
            if (r25.hasNext() == false) goto L151;
            if (((d0) r25.next()).f15121k == false) goto L145;
            r120 = r120 + 1;
            if (r120 >= 0) goto L145;
            CollectionsKt.throwCountOverflow();
        L151:
            if (r120 == 0) goto L168;
            if (r120 != 1) goto L166;
            if (r10.h() == true) goto L168;
            if (r20 == TypeSpec$Kind.INTERFACE) goto L168;
            if (r10.f() == true) goto L168;
            if (r10.e() == true) goto L168;
            throw new IllegalArgumentException((r20 + " types can't have a companion object").toString());
        L166:
            throw new IllegalArgumentException("Multiple companion objects are present but only one is allowed.");
        L168:
            return new KotlinTypeSpec(r5, new d0(r10));
        L141:
            if (r24.isEmpty() == false) goto L143;
            r120 = 0;
            goto L151
        L122:
            if (r15.contains(KModifier.FUN) == false) goto L138;
            ArrayList r26 = new ArrayList();
            Iterator r27 = r17.iterator();
        L125:
            if (r27.hasNext() == false) goto L130;
            Object r28 = r27.next();
            if (((k) r28).g.contains(KModifier.ABSTRACT) == false) goto L125;
            r26.add(r28);
            goto L125
        L130:
            if (r26.size() == 1) goto L138;
            StringBuilder r29 = new StringBuilder("Functional interfaces must have exactly one abstract function. Contained ");
            r29.append(r26.size());
            r29.append(": ");
            ArrayList r30 = new ArrayList(CollectionsKt.h(r26));
            Iterator r31 = r26.iterator();
        L134:
            if (r31.hasNext() == false) goto L136;
            r30.add(((k) r31.next()).f15173b);
            goto L134
        L136:
            r29.append(r30);
            throw new IllegalStateException(r29.toString().toString());
        L96:
            if (r17.isEmpty() == false) goto L98;
        L41:
            if (r15.contains(KModifier.SEALED) == true) goto L48;
            if (r20 != TypeSpec$Kind.CLASS) goto L48;
            if (r10.h() == false) goto L48;
            r21 = false;
            goto L49
        L32:
            if (r10.f15100a != TypeSpec$Kind.CLASS) goto L38;
            if (r10.f15108m.isEmpty() == true) goto L38;
            throw new IllegalStateException("typevariables are forbidden on anonymous types");
        L5:
            if (r10.f() == true) goto L9;
            throw new IllegalStateException(j0.j(r12, " is not an enum and cannot have enum constants").toString());
        }

        public final c0 getActual$room_compiler_processing() {
            return this.actual;
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public /* bridge */ /* synthetic */ XTypeSpec.Builder superclass(XTypeName r5) {
            return superclass(r5);
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public Builder addFunction(XFunSpec r5) {
            Intrinsics.checkNotNullParameter(r5, "functionSpec");
            if ((r5 instanceof KotlinFunSpec) == false) goto L7;
            c0 r10 = this.actual;
            k r11 = ((KotlinFunSpec) r5).getActual$room_compiler_processing();
            r10.getClass();
            Intrinsics.checkNotNullParameter(r11, "funSpec");
            r10.f15111p.add(r11);
            return this;
        L7:
            throw new IllegalArgumentException("Failed requirement.");
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public Builder addProperty(XTypeName r10, String r11, VisibilityModifier r12, boolean r13, XCodeBlock r14, List<? extends XAnnotationSpec> r15) {
            Intrinsics.checkNotNullParameter(r10, "typeName");
            Intrinsics.checkNotNullParameter(r11, "name");
            Intrinsics.checkNotNullParameter(r12, "visibility");
            Intrinsics.checkNotNullParameter(r15, "annotations");
            c0 r16 = this.actual;
            a0 r17 = r10.getKotlin$room_compiler_processing();
            KModifier[] r5 = new KModifier[0];
            Intrinsics.checkNotNullParameter(r11, "name");
            Intrinsics.checkNotNullParameter(r17, "type");
            Intrinsics.checkNotNullParameter(r5, "modifiers");
            v r18 = new v(r11, r17);
            KModifier[] r19 = (KModifier[]) Arrays.copyOf(r5, 0);
            Intrinsics.checkNotNullParameter(r19, "modifiers");
            ArrayList r20 = r18.f15199h;
            CollectionsKt.c(r20, r19);
            r18.f15198c = r13;
            KModifier[] r21 = {KotlinFunSpecKt.toKotlinVisibilityModifier(r12)};
            Intrinsics.checkNotNullParameter(r21, "modifiers");
            CollectionsKt.c(r20, r21);
            if (r14 == null) goto L10;
            if ((r14 instanceof KotlinCodeBlock) == false) goto L8;
            r18.e = ((KotlinCodeBlock) r14).getActual$room_compiler_processing();
            goto L10
        L8:
            throw new IllegalArgumentException("Failed requirement.");
        L10:
            if (r20.contains(KModifier.INLINE) == true) goto L34;
            Iterator r22 = r20.iterator();
        L13:
            if (r22.hasNext() == false) goto L15;
            ((KModifier) r22.next()).checkTarget$kotlinpoet(KModifier.Target.PROPERTY);
            goto L13
        L15:
            w r23 = new w(r18);
            r16.getClass();
            Intrinsics.checkNotNullParameter(r23, "propertySpec");
            if (r16.f15104i.contains(KModifier.EXPECT) == false) goto L23;
            if (r23.f15207i == null) goto L23;
            throw new IllegalArgumentException("properties in expect classes can't have initializers");
        L23:
            if (r16.f() == false) goto L31;
            String r24 = r23.f15205c;
            if (Intrinsics.areEqual(r24, "name") == true) goto L30;
            if (Intrinsics.areEqual(r24, "ordinal") == false) goto L31;
        L30:
            throw new IllegalArgumentException(j0.j(r24, " is a final supertype member and can't be redeclared or overridden").toString());
        L31:
            r16.f15110o.add(r23);
            return this;
        L34:
            throw new IllegalArgumentException("KotlinPoet doesn't allow setting the inline modifier on properties. You should mark either the getter, the setter, or both inline.");
        }

        @Override // androidx.room.compiler.codegen.XTypeSpec.Builder
        public Builder superclass(XTypeName r5) {
            Intrinsics.checkNotNullParameter(r5, "typeName");
            c0 r10 = this.actual;
            a0 r11 = r5.getKotlin$room_compiler_processing();
            r10.getClass();
            Intrinsics.checkNotNullParameter(r11, "superclass");
            r10.d();
            if (r10.d != b0.f15080a) goto L7;
            r10.d = r11;
            return this;
        L7:
            throw new IllegalStateException(("superclass already set to " + r10.d).toString());
        }
    }

    public KotlinTypeSpec(XClassName r5, d0 r10) {
        Intrinsics.checkNotNullParameter(r5, "className");
        Intrinsics.checkNotNullParameter(r10, "actual");
        this.className = r5;
        this.actual = r10;
    }

    public final d0 getActual$room_compiler_processing() {
        return this.actual;
    }

    @Override // androidx.room.compiler.codegen.XTypeSpec
    public XClassName getClassName() {
        return this.className;
    }
}
