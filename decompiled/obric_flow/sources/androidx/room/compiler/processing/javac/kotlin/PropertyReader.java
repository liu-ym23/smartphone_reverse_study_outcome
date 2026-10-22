package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.compiler.processing.util.NamingUtilsKt;
import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMethodSignature;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmPropertyExtensionVisitor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J4\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u000bj\u0002`\f2\n\u0010\u0010\u001a\u00060\u000bj\u0002`\fH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/PropertyReader;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "result", "", "Landroidx/room/compiler/processing/javac/kotlin/KmProperty;", "(Ljava/util/List;)V", "getResult", "()Ljava/util/List;", "visitProperty", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "name", "", "getterFlags", "setterFlags", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class PropertyReader extends KmClassVisitor {
    private final List<KmProperty> result;

    /* JADX INFO: renamed from: androidx.room.compiler.processing.javac.kotlin.PropertyReader$visitProperty$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"androidx/room/compiler/processing/javac/kotlin/PropertyReader$visitProperty$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "returnType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getReturnType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "setReturnType", "(Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "visitEnd", "", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitReturnType", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "visitSetterParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "name", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends KmPropertyVisitor {
        final /* synthetic */ int $flags;
        final /* synthetic */ Ref.ObjectRef<JvmMethodSignature> $getter;
        final /* synthetic */ String $name;
        final /* synthetic */ Ref.ObjectRef<JvmMethodSignature> $setter;
        final /* synthetic */ Ref.ObjectRef<KmValueParameter> $setterParam;
        public KmType returnType;
        final /* synthetic */ PropertyReader this$0;

        public AnonymousClass1(PropertyReader r5, Ref.ObjectRef<JvmMethodSignature> r10, Ref.ObjectRef<JvmMethodSignature> r11, String r12, Ref.ObjectRef<KmValueParameter> r13, int r14) {
            this.this$0 = r5;
            this.$setter = r10;
            this.$getter = r11;
            this.$name = r12;
            this.$setterParam = r13;
            this.$flags = r14;
            super(null, 1, null);
        }

        public final KmType getReturnType() {
            KmType r5 = this.returnType;
            if (r5 == null) goto L5;
            return r5;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("returnType");
            return null;
        }

        public final void setReturnType(KmType r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.returnType = r5;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public void visitEnd() {
            List<KmProperty> r5 = this.this$0.getResult();
            KmType r10 = getReturnType();
            JvmMethodSignature r11 = this.$setter.element;
            KmFunction r12 = null;
            if (r11 == null) goto L8;
            Ref.ObjectRef<KmValueParameter> r13 = this.$setterParam;
            String r14 = this.$name;
            KmValueParameter r15 = r13.element;
            if (r15 != null) goto L7;
            r15 = new KmValueParameter(NamingUtilsKt.sanitizeAsJavaParameterName("set-?", 0), getReturnType(), 0);
        L7:
            KmFunction r16 = new KmFunction(r11.getName(), JvmAbi.INSTANCE.computeSetterName(r14), r11.asString(), 0, CollectionsKt.emptyList(), CollectionsKt.listOf(r15), KotlinClassMetadataUtilsKt.access$getKM_VOID_TYPE$p(), null);
        L9:
            JvmMethodSignature r17 = this.$getter.element;
            if (r17 == null) goto L12;
            String r18 = this.$name;
            r12 = new KmFunction(r17.getName(), JvmAbi.INSTANCE.computeGetterName(r18), r17.asString(), this.$flags, CollectionsKt.emptyList(), CollectionsKt.emptyList(), getReturnType(), null);
        L12:
            r5.add(new KmProperty(this.$name, r10, r12, r16));
            return;
        L8:
            r16 = null;
            goto L9
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public KmPropertyExtensionVisitor visitExtensions(KmExtensionType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            if (Intrinsics.areEqual(r5, JvmPropertyExtensionVisitor.TYPE) == true) goto L6;
            return null;
        L6:
            final Ref.ObjectRef<JvmMethodSignature> r10 = this.$getter;
            final Ref.ObjectRef<JvmMethodSignature> r11 = this.$setter;
            return new PropertyReader$visitProperty$1$visitExtensions$1(r10, r11);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public KmTypeVisitor visitReturnType(int r5) {
            return new TypeReader(r5, new PropertyReader$visitProperty$1$visitReturnType$1(this));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor
        public KmValueParameterVisitor visitSetterParameter(int r5, String r10) {
            Intrinsics.checkNotNullParameter(r10, "name");
            final Ref.ObjectRef<KmValueParameter> r11 = this.$setterParam;
            return new ValueParameterReader(r10, r5, new PropertyReader$visitProperty$1$visitSetterParameter$1(r11));
        }
    }

    public PropertyReader(List<KmProperty> r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        super(null, 1, null);
        this.result = r5;
    }

    public final List<KmProperty> getResult() {
        return this.result;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerVisitor
    public KmPropertyVisitor visitProperty(int r10, String r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "name");
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        return new AnonymousClass1(this, new Ref.ObjectRef(), r14, r11, r5, r10);
    }
}
