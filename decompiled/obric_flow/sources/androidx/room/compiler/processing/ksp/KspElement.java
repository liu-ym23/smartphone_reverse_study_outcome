package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XEquality;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\t\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR%\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010\u000b¨\u0006&"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspElement;", "Landroidx/room/compiler/processing/XElement;", "Landroidx/room/compiler/processing/XEquality;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/a;", "declaration", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/a;)V", "", "kindName", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "validate", "()Z", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "getEnv$room_compiler_processing", "()Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Lil/a;", "getDeclaration", "()Lil/a;", "", "equalityItems$delegate", "Lkotlin/Lazy;", "getEqualityItems", "()[Ljava/lang/Object;", "equalityItems", "docComment$delegate", "getDocComment", "docComment", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspElement implements XElement, XEquality {
    private final il.a declaration;
    private final Lazy docComment$delegate;
    private final KspProcessingEnv env;
    private final Lazy equalityItems$delegate;

    public KspElement(KspProcessingEnv r5, il.a r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "declaration");
        this.env = r5;
        this.declaration = r10;
        this.equalityItems$delegate = LazyKt.lazy(new KspElement$equalityItems$2(this));
        this.docComment$delegate = LazyKt.lazy(new KspElement$docComment$2(this));
    }

    public boolean equals(Object r5) {
        return XEquality.Companion.equals(this, r5);
    }

    public il.a getDeclaration() {
        return this.declaration;
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getDocComment() {
        return (String) this.docComment$delegate.getValue();
    }

    public final KspProcessingEnv getEnv$room_compiler_processing() {
        return this.env;
    }

    @Override // androidx.room.compiler.processing.XEquality
    public final Object[] getEqualityItems() {
        return (Object[]) this.equalityItems$delegate.getValue();
    }

    public int hashCode() {
        return XEquality.Companion.hashCode(getEqualityItems());
    }

    @Override // androidx.room.compiler.processing.XElement
    public String kindName() {
        getDeclaration();
        String r5 = Reflection.getOrCreateKotlinClass(getDeclaration().getClass()).getSimpleName();
        if (r5 != null) goto L6;
        return "unknown";
    L6:
        return r5;
    }

    public String toString() {
        return getDeclaration().toString();
    }

    @Override // androidx.room.compiler.processing.XElement
    public boolean validate() {
        return com.google.devtools.ksp.a.d(getDeclaration());
    }
}
