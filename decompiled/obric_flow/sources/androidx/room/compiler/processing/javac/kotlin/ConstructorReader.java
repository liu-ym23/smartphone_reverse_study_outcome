package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructorExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmConstructorExtensionVisitor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/ConstructorReader;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "result", "", "Landroidx/room/compiler/processing/javac/kotlin/KmConstructor;", "(Ljava/util/List;)V", "getResult", "()Ljava/util/List;", "visitConstructor", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ConstructorReader extends KmClassVisitor {
    private final List<KmConstructor> result;

    /* JADX INFO: renamed from: androidx.room.compiler.processing.javac.kotlin.ConstructorReader$visitConstructor$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"androidx/room/compiler/processing/javac/kotlin/ConstructorReader$visitConstructor$1", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "descriptor", "", "getDescriptor", "()Ljava/lang/String;", "setDescriptor", "(Ljava/lang/String;)V", "parameters", "", "Landroidx/room/compiler/processing/javac/kotlin/KmValueParameter;", "getParameters", "()Ljava/util/List;", "visitEnd", "", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitValueParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "name", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends KmConstructorVisitor {
        final /* synthetic */ int $flags;
        public String descriptor;
        private final List<KmValueParameter> parameters;
        final /* synthetic */ ConstructorReader this$0;

        public AnonymousClass1(ConstructorReader r5, int r10) {
            this.this$0 = r5;
            this.$flags = r10;
            super(null, 1, null);
            this.parameters = new ArrayList();
        }

        public final String getDescriptor() {
            String r5 = this.descriptor;
            if (r5 == null) goto L5;
            return r5;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("descriptor");
            return null;
        }

        public final List<KmValueParameter> getParameters() {
            return this.parameters;
        }

        public final void setDescriptor(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.descriptor = r5;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor
        public void visitEnd() {
            this.this$0.getResult().add(new KmConstructor(getDescriptor(), this.$flags, this.parameters));
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor
        public KmConstructorExtensionVisitor visitExtensions(KmExtensionType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            if (Intrinsics.areEqual(r5, JvmConstructorExtensionVisitor.TYPE) == false) goto L7;
            return new ConstructorReader$visitConstructor$1$visitExtensions$1(this);
        L7:
            throw new IllegalStateException(("Unsupported extension type: " + r5).toString());
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmConstructorVisitor
        public KmValueParameterVisitor visitValueParameter(int r5, String r10) {
            Intrinsics.checkNotNullParameter(r10, "name");
            return new ValueParameterReader(r10, r5, new ConstructorReader$visitConstructor$1$visitValueParameter$1(this));
        }
    }

    public ConstructorReader(List<KmConstructor> r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        super(null, 1, null);
        this.result = r5;
    }

    public final List<KmConstructor> getResult() {
        return this.result;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmConstructorVisitor visitConstructor(int r5) {
        return new AnonymousClass1(this, r5);
    }
}
