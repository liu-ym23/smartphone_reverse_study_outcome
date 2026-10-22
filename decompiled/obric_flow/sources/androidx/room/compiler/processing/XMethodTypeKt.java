package androidx.room.compiler.processing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0000ò\u0001\u0004\n\u00020\u0003¨\u0006\u0004"}, d2 = {"isSuspendFunction", "", "Landroidx/room/compiler/processing/XMethodType;", "Landroidx/room/compiler/processing/XSuspendMethodType;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class XMethodTypeKt {
    public static final boolean isSuspendFunction(XMethodType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5 instanceof XSuspendMethodType;
    }
}
