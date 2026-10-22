package androidx.room.compiler.processing;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XExecutableParameterElement;", "Landroidx/room/compiler/processing/XVariableElement;", "enclosingElement", "Landroidx/room/compiler/processing/XExecutableElement;", "getEnclosingElement", "()Landroidx/room/compiler/processing/XExecutableElement;", "enclosingMethodElement", "getEnclosingMethodElement$annotations", "()V", "getEnclosingMethodElement", "hasDefaultValue", "", "getHasDefaultValue", "()Z", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XExecutableParameterElement extends XVariableElement {
    @Deprecated(message = "use XExecutableParameterElement#enclosingElement() instead.", replaceWith = @ReplaceWith(expression = "enclosingElement", imports = {}))
    static /* synthetic */ void getEnclosingMethodElement$annotations() {
    }

    @Override // androidx.room.compiler.processing.XElement
    XExecutableElement getEnclosingElement();

    default XExecutableElement getEnclosingMethodElement() {
        return getEnclosingElement();
    }

    boolean getHasDefaultValue();
}
