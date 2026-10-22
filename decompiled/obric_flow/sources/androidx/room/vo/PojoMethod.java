package androidx.room.vo;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XMethodType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/vo/PojoMethod;", "", "element", "Landroidx/room/compiler/processing/XMethodElement;", "resolvedType", "Landroidx/room/compiler/processing/XMethodType;", "(Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XMethodType;)V", "getElement", "()Landroidx/room/compiler/processing/XMethodElement;", "getResolvedType", "()Landroidx/room/compiler/processing/XMethodType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PojoMethod {
    private final XMethodElement element;
    private final XMethodType resolvedType;

    public PojoMethod(XMethodElement r5, XMethodType r10) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "resolvedType");
        this.element = r5;
        this.resolvedType = r10;
    }

    public final XMethodElement getElement() {
        return this.element;
    }

    public final XMethodType getResolvedType() {
        return this.resolvedType;
    }
}
