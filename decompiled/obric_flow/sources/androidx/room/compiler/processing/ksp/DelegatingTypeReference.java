package androidx.room.compiler.processing.ksp;

import com.google.devtools.ksp.symbol.Modifier;
import com.google.devtools.ksp.symbol.Origin;
import il.b;
import il.j;
import il.o;
import il.p;
import il.s;
import il.v;
import il.w;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J8\u0010\f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Landroidx/room/compiler/processing/ksp/DelegatingTypeReference;", "Lil/s;", "original", "Lil/p;", "resolved", "<init>", "(Lil/s;Lil/p;)V", "D", "R", "Lil/v;", "visitor", "data", "accept", "(Lil/v;Ljava/lang/Object;)Ljava/lang/Object;", "resolve", "()Lil/p;", "Lil/s;", "getOriginal", "()Lil/s;", "Lil/p;", "getResolved", "Lkotlin/sequences/Sequence;", "Lil/b;", "getAnnotations", "()Lkotlin/sequences/Sequence;", "annotations", "Lil/o;", "getElement", "()Lil/o;", "element", "Lil/w;", "getLocation", "()Lil/w;", "location", "", "Lcom/google/devtools/ksp/symbol/Modifier;", "getModifiers", "()Ljava/util/Set;", "modifiers", "Lcom/google/devtools/ksp/symbol/Origin;", "getOrigin", "()Lcom/google/devtools/ksp/symbol/Origin;", "origin", "Lil/j;", "getParent", "()Lil/j;", "parent", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class DelegatingTypeReference implements s {
    private final s original;
    private final p resolved;

    public DelegatingTypeReference(s r5, p r10) {
        Intrinsics.checkNotNullParameter(r5, "original");
        Intrinsics.checkNotNullParameter(r10, "resolved");
        this.original = r5;
    }

    @Override // il.j
    public <D, R> R accept(v r5, D r10) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        return (R) this.original.accept(r5, r10);
    }

    @Override // il.a
    public Sequence<b> getAnnotations() {
        return this.original.getAnnotations();
    }

    @Override // il.s
    public o getElement() {
        this.original.getElement();
        return null;
    }

    @Override // il.j
    public w getLocation() {
        return this.original.getLocation();
    }

    @Override // il.h
    public Set<Modifier> getModifiers() {
        return this.original.getModifiers();
    }

    @Override // il.j
    public Origin getOrigin() {
        return this.original.getOrigin();
    }

    public final s getOriginal() {
        return this.original;
    }

    @Override // il.j
    public j getParent() {
        return this.original.getParent();
    }

    public final p getResolved() {
        return null;
    }

    @Override // il.s
    public p resolve() {
        return null;
    }
}
