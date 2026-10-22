package androidx.room.compiler.processing.javac;

import javax.lang.model.type.TypeMirror;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"extendsBound", "Ljavax/lang/model/type/TypeMirror;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TypeMirrorExtKt {
    public static final TypeMirror extendsBound(TypeMirror r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return (TypeMirror) r5.accept(new AnonymousClass1(), null);
    }
}
