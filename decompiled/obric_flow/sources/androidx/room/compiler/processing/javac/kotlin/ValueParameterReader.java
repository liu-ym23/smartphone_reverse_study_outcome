package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\nH\u0016J\u0014\u0010\u0019\u001a\u00020\u001a2\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/ValueParameterReader;", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "name", "", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "output", "Lkotlin/Function1;", "Landroidx/room/compiler/processing/javac/kotlin/KmValueParameter;", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "getFlags", "()I", "getName", "()Ljava/lang/String;", "getOutput", "()Lkotlin/jvm/functions/Function1;", "type", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "setType", "(Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "visitEnd", "visitType", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ValueParameterReader extends KmValueParameterVisitor {
    private final int flags;
    private final String name;
    private final Function1<KmValueParameter, Unit> output;
    public KmType type;

    /* JADX WARN: Multi-variable type inference failed */
    public ValueParameterReader(String r5, int r10, Function1<? super KmValueParameter, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r11, "output");
        super(null, 1, null);
        this.name = r5;
        this.flags = r10;
        this.output = r11;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final String getName() {
        return this.name;
    }

    public final Function1<KmValueParameter, Unit> getOutput() {
        return this.output;
    }

    public final KmType getType() {
        KmType r5 = this.type;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public final void setType(KmType r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.type = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor
    public void visitEnd() {
        this.output.invoke(new KmValueParameter(this.name, getType(), this.flags));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmValueParameterVisitor
    public KmTypeVisitor visitType(int r5) {
        return new TypeReader(r5, new AnonymousClass1(this));
    }
}
