package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\nH\u0016J\u0014\u0010\u000f\u001a\u00020\u00102\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/TypeParameterReader;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "name", "", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "output", "Lkotlin/Function1;", "Landroidx/room/compiler/processing/javac/kotlin/KmTypeParameter;", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "upperBound", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "visitEnd", "visitUpperBound", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class TypeParameterReader extends KmTypeParameterVisitor {
    private final int flags;
    private final String name;
    private final Function1<KmTypeParameter, Unit> output;
    private KmType upperBound;

    /* JADX WARN: Multi-variable type inference failed */
    public TypeParameterReader(String r5, int r10, Function1<? super KmTypeParameter, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r11, "output");
        super(null, 1, null);
        this.name = r5;
        this.flags = r10;
        this.output = r11;
    }

    public static final /* synthetic */ void access$setUpperBound$p(TypeParameterReader r5, KmType r10) {
        r5.upperBound = r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor
    public void visitEnd() {
        this.output.invoke(new KmTypeParameter(this.name, this.flags, this.upperBound));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor
    public KmTypeVisitor visitUpperBound(int r5) {
        return new TypeReader(r5, new AnonymousClass1(this));
    }
}
