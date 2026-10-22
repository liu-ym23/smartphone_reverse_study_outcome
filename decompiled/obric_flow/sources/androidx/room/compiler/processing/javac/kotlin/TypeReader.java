package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.KmExtensionType;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmVariance;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmTypeExtensionVisitor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ\u001c\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001e\u0010\u0017\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/TypeReader;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "output", "Lkotlin/Function1;", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "", "(ILkotlin/jvm/functions/Function1;)V", "extendsBound", "isExtensionType", "", "typeArguments", "", "visitArgument", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "visitEnd", "visitExtensions", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeExtensionVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "visitFlexibleTypeUpperBound", "typeFlexibilityId", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class TypeReader extends KmTypeVisitor {
    private KmType extendsBound;
    private final int flags;
    private boolean isExtensionType;
    private final Function1<KmType, Unit> output;
    private final List<KmType> typeArguments;

    /* JADX WARN: Multi-variable type inference failed */
    public TypeReader(int r5, Function1<? super KmType, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "output");
        super(null, 1, null);
        this.flags = r5;
        this.output = r10;
        this.typeArguments = new ArrayList();
    }

    public static final /* synthetic */ List access$getTypeArguments$p(TypeReader r5) {
        return r5.typeArguments;
    }

    public static final /* synthetic */ void access$setExtendsBound$p(TypeReader r5, KmType r10) {
        r5.extendsBound = r10;
    }

    public static final /* synthetic */ void access$setExtensionType$p(TypeReader r5, boolean r10) {
        r5.isExtensionType = r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public KmTypeVisitor visitArgument(int r5, KmVariance r10) {
        Intrinsics.checkNotNullParameter(r10, "variance");
        return new TypeReader(r5, new AnonymousClass1(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public void visitEnd() {
        this.output.invoke(new KmType(this.flags, this.typeArguments, this.extendsBound, this.isExtensionType));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public KmTypeExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (Intrinsics.areEqual(r5, JvmTypeExtensionVisitor.TYPE) == true) goto L7;
        return null;
    L7:
        return new C00991(this);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor
    public KmTypeVisitor visitFlexibleTypeUpperBound(int r5, String r10) {
        return new TypeReader(r5, new C01001(this));
    }
}
