package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmVariance;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmFunctionExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMethodSignature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/FunctionReader;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "result", "", "Landroidx/room/compiler/processing/javac/kotlin/KmFunction;", "(Ljava/util/List;)V", "getResult", "()Ljava/util/List;", "visitFunction", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "name", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class FunctionReader extends KmClassVisitor {
    private final List<KmFunction> result;

    /* JADX INFO: renamed from: androidx.room.compiler.processing.javac.kotlin.FunctionReader$visitFunction$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000s\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\u000b\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u00020\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00102\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0#8\u0006¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101¨\u00065"}, d2 = {"androidx/room/compiler/processing/javac/kotlin/FunctionReader$visitFunction$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "id", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "visitTypeParameter", "(ILjava/lang/String;ILandroidx/room/jarjarred/kotlinx/metadata/KmVariance;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "visitValueParameter", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitReceiverParameterType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;", "visitReturnType", "", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "methodSignature", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "getMethodSignature", "()Ljava/lang/Object;", "setMethodSignature", "(Ljava/lang/Object;)V", "", "Landroidx/room/compiler/processing/javac/kotlin/KmTypeParameter;", "typeParameters", "Ljava/util/List;", "Landroidx/room/compiler/processing/javac/kotlin/KmValueParameter;", "parameters", "getParameters", "()Ljava/util/List;", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "returnType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getReturnType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "setReturnType", "(Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "receiverType", "getReceiverType", "setReceiverType", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends KmFunctionVisitor {
        final /* synthetic */ int $flags;
        final /* synthetic */ String $name;
        public JvmMethodSignature methodSignature;
        private final List<KmValueParameter> parameters;
        private KmType receiverType;
        public KmType returnType;
        final /* synthetic */ FunctionReader this$0;
        private final List<KmTypeParameter> typeParameters;

        public AnonymousClass1(FunctionReader r5, String r10, int r11) {
            this.this$0 = r5;
            this.$name = r10;
            this.$flags = r11;
            super(null, 1, null);
            this.typeParameters = new ArrayList();
            this.parameters = new ArrayList();
        }

        public static final /* synthetic */ List access$getTypeParameters$p(AnonymousClass1 r5) {
            return r5.typeParameters;
        }

        public final JvmMethodSignature getMethodSignature() {
            JvmMethodSignature r5 = this.methodSignature;
            if (r5 == null) goto L5;
            return r5;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("methodSignature");
            return null;
        }

        public final List<KmValueParameter> getParameters() {
            return this.parameters;
        }

        public final KmType getReceiverType() {
            return this.receiverType;
        }

        public final KmType getReturnType() {
            KmType r5 = this.returnType;
            if (r5 == null) goto L5;
            return r5;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("returnType");
            return null;
        }

        public final void setMethodSignature(JvmMethodSignature r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.methodSignature = r5;
        }

        public final void setReceiverType(KmType r5) {
            this.receiverType = r5;
        }

        public final void setReturnType(KmType r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.returnType = r5;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public void visitEnd() {
            List<KmFunction> r5 = this.this$0.getResult();
            String r10 = getMethodSignature().getName();
            String r11 = getMethodSignature().asString();
            List<KmTypeParameter> r12 = this.typeParameters;
            ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
            Iterator<T> r14 = r12.iterator();
        L4:
            if (r14.hasNext() == false) goto L6;
            r13.add(((KmTypeParameter) r14.next()).asKmType());
            goto L4
        L6:
            List<KmValueParameter> r15 = this.parameters;
            KmType r16 = getReturnType();
            KmType r17 = this.receiverType;
            r5.add(new KmFunction(r10, this.$name, r11, this.$flags, r13, r15, r16, r17));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmFunctionExtensionVisitor visitExtensions(KmExtensionType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            if (Intrinsics.areEqual(r5, JvmFunctionExtensionVisitor.TYPE) == false) goto L7;
            return new FunctionReader$visitFunction$1$visitExtensions$1(this);
        L7:
            throw new IllegalStateException(("Unsupported extension type: " + r5).toString());
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmTypeVisitor visitReceiverParameterType(int r5) {
            return new TypeReader(r5, new FunctionReader$visitFunction$1$visitReceiverParameterType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmTypeVisitor visitReturnType(int r5) {
            return new TypeReader(r5, new FunctionReader$visitFunction$1$visitReturnType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmTypeParameterVisitor visitTypeParameter(int r5, String r10, int r11, KmVariance r12) {
            Intrinsics.checkNotNullParameter(r10, "name");
            Intrinsics.checkNotNullParameter(r12, "variance");
            return new TypeParameterReader(r10, r5, new FunctionReader$visitFunction$1$visitTypeParameter$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmFunctionVisitor
        public KmValueParameterVisitor visitValueParameter(int r5, String r10) {
            Intrinsics.checkNotNullParameter(r10, "name");
            return new ValueParameterReader(r10, r5, new FunctionReader$visitFunction$1$visitValueParameter$1(this));
        }
    }

    public FunctionReader(List<KmFunction> r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        super(null, 1, null);
        this.result = r5;
    }

    public final List<KmFunction> getResult() {
        return this.result;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmFunctionVisitor visitFunction(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        return new AnonymousClass1(this, r10, r5);
    }
}
