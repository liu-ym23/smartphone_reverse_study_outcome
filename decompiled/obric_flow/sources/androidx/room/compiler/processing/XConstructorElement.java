package androidx.room.compiler.processing;

import ai.j0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XConstructorElement;", "Landroidx/room/compiler/processing/XExecutableElement;", "enclosingElement", "Landroidx/room/compiler/processing/XTypeElement;", "getEnclosingElement", "()Landroidx/room/compiler/processing/XTypeElement;", "executableType", "Landroidx/room/compiler/processing/XConstructorType;", "getExecutableType", "()Landroidx/room/compiler/processing/XConstructorType;", "fallbackLocationText", "", "getFallbackLocationText", "()Ljava/lang/String;", "asMemberOf", "other", "Landroidx/room/compiler/processing/XType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XConstructorElement extends XExecutableElement {
    @Override // androidx.room.compiler.processing.XExecutableElement
    XConstructorType asMemberOf(XType r5);

    @Override // androidx.room.compiler.processing.XExecutableElement, androidx.room.compiler.processing.XElement
    XTypeElement getEnclosingElement();

    @Override // androidx.room.compiler.processing.XExecutableElement
    XConstructorType getExecutableType();

    @Override // androidx.room.compiler.processing.XElement
    default String getFallbackLocationText() {
        StringBuilder r5 = new StringBuilder();
        r5.append(getEnclosingElement().getQualifiedName());
        r5.append(".<init>(");
        return j0.q(r5, CollectionsKt.q(getParameters(), ", ", null, null, 0, null, XConstructorElement$fallbackLocationText$1$1.INSTANCE, 30), ")");
    }
}
