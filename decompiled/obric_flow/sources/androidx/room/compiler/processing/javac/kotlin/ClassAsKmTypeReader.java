package androidx.room.compiler.processing.javac.kotlin;

import androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmVariance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J \u0010\u0011\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0014\u0010\u0016\u001a\u00020\u00172\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J,\u0010\u0018\u001a\u00020\u00192\n\u0010\u0007\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0012\u0010\u0007\u001a\u00060\bj\u0002`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/ClassAsKmTypeReader;", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassVisitor;", "output", "Lkotlin/Function1;", "Landroidx/room/compiler/processing/javac/kotlin/KmClassTypeInfo;", "", "(Lkotlin/jvm/functions/Function1;)V", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "getOutput", "()Lkotlin/jvm/functions/Function1;", "superType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "typeParameters", "", "Landroidx/room/compiler/processing/javac/kotlin/KmTypeParameter;", "visit", "name", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "visitEnd", "visitSupertype", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitTypeParameter", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "id", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClassAsKmTypeReader extends KmClassVisitor {
    private int flags;
    private final Function1<KmClassTypeInfo, Unit> output;
    private KmType superType;
    private final List<KmTypeParameter> typeParameters;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassAsKmTypeReader(Function1<? super KmClassTypeInfo, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "output");
        super(null, 1, null);
        this.output = r5;
        this.typeParameters = new ArrayList();
    }

    public static final /* synthetic */ List access$getTypeParameters$p(ClassAsKmTypeReader r5) {
        return r5.typeParameters;
    }

    public static final /* synthetic */ void access$setSuperType$p(ClassAsKmTypeReader r5, KmType r10) {
        r5.superType = r10;
    }

    public final Function1<KmClassTypeInfo, Unit> getOutput() {
        return this.output;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visit(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        this.flags = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public void visitEnd() {
        Function1<KmClassTypeInfo, Unit> r5 = this.output;
        int r10 = this.flags;
        List<KmTypeParameter> r11 = this.typeParameters;
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(((KmTypeParameter) r13.next()).asKmType());
        goto L4
    L6:
        r5.invoke(new KmClassTypeInfo(new KmType(r10, r12, null, false), this.superType));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmTypeVisitor visitSupertype(int r5) {
        return new TypeReader(r5, new AnonymousClass1(this));
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmClassVisitor
    public KmTypeParameterVisitor visitTypeParameter(int r5, String r10, int r11, KmVariance r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r12, "variance");
        return new TypeParameterReader(r10, r5, new C00981(this));
    }
}
