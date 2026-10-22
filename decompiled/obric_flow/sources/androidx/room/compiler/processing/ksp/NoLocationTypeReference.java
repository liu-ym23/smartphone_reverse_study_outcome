package androidx.room.compiler.processing.ksp;

import bd.d;
import com.google.devtools.ksp.symbol.Modifier;
import com.google.devtools.ksp.symbol.Origin;
import il.b;
import il.j;
import il.o;
import il.p;
import il.s;
import il.v;
import il.w;
import il.x;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\u000b\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Landroidx/room/compiler/processing/ksp/NoLocationTypeReference;", "Lil/s;", "Lil/p;", "resolved", "<init>", "(Lil/p;)V", "D", "R", "Lil/v;", "visitor", "data", "accept", "(Lil/v;Ljava/lang/Object;)Ljava/lang/Object;", "resolve", "()Lil/p;", "Lil/p;", "getResolved", "Lkotlin/sequences/Sequence;", "Lil/b;", "getAnnotations", "()Lkotlin/sequences/Sequence;", "annotations", "Lil/o;", "getElement", "()Lil/o;", "element", "Lil/w;", "getLocation", "()Lil/w;", "location", "", "Lcom/google/devtools/ksp/symbol/Modifier;", "getModifiers", "()Ljava/util/Set;", "modifiers", "Lcom/google/devtools/ksp/symbol/Origin;", "getOrigin", "()Lcom/google/devtools/ksp/symbol/Origin;", "origin", "Lil/j;", "getParent", "()Lil/j;", "parent", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class NoLocationTypeReference implements s {
    private final p resolved;

    public NoLocationTypeReference(p r5) {
        Intrinsics.checkNotNullParameter(r5, "resolved");
    }

    @Override // il.j
    public <D, R> R accept(v r5, D r10) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        ((d) r5).getClass();
        j r11 = (j) r10;
        Intrinsics.checkNotNullParameter(this, "typeReference");
        resolve();
        throw null;
    }

    @Override // il.a
    public Sequence<b> getAnnotations() {
        return SequencesKt.emptySequence();
    }

    @Override // il.s
    public o getElement() {
        return null;
    }

    @Override // il.j
    public w getLocation() {
        return x.f17575a;
    }

    @Override // il.h
    public Set<Modifier> getModifiers() {
        return SetsKt.emptySet();
    }

    @Override // il.j
    public Origin getOrigin() {
        return Origin.SYNTHETIC;
    }

    @Override // il.j
    public j getParent() {
        return null;
    }

    public final p getResolved() {
        return null;
    }

    @Override // il.s
    public p resolve() {
        return null;
    }
}
