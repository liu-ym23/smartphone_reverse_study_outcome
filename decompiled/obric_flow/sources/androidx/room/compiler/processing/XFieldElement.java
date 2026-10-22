package androidx.room.compiler.processing;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XFieldElement;", "Landroidx/room/compiler/processing/XVariableElement;", "Landroidx/room/compiler/processing/XHasModifiers;", "enclosingElement", "Landroidx/room/compiler/processing/XMemberContainer;", "getEnclosingElement", "()Landroidx/room/compiler/processing/XMemberContainer;", "fallbackLocationText", "", "getFallbackLocationText", "()Ljava/lang/String;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XFieldElement extends XVariableElement, XHasModifiers {
    @Override // androidx.room.compiler.processing.XElement
    XMemberContainer getEnclosingElement();

    @Override // androidx.room.compiler.processing.XElement
    default String getFallbackLocationText() {
        return getName() + " in " + getEnclosingElement().getFallbackLocationText();
    }
}
