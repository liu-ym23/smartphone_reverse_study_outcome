package androidx.room.compiler.processing;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0012H&J\b\u0010\u0016\u001a\u00020\u0017H&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XExecutableElement;", "Landroidx/room/compiler/processing/XHasModifiers;", "Landroidx/room/compiler/processing/XParameterizable;", "Landroidx/room/compiler/processing/XElement;", "enclosingElement", "Landroidx/room/compiler/processing/XMemberContainer;", "getEnclosingElement", "()Landroidx/room/compiler/processing/XMemberContainer;", "executableType", "Landroidx/room/compiler/processing/XExecutableType;", "getExecutableType", "()Landroidx/room/compiler/processing/XExecutableType;", "parameters", "", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "getParameters", "()Ljava/util/List;", "thrownTypes", "Landroidx/room/compiler/processing/XType;", "getThrownTypes", "asMemberOf", "other", "isVarArgs", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XExecutableElement extends XHasModifiers, XParameterizable, XElement {
    XExecutableType asMemberOf(XType r5);

    XMemberContainer getEnclosingElement();

    XExecutableType getExecutableType();

    List<XExecutableParameterElement> getParameters();

    List<XType> getThrownTypes();

    boolean isVarArgs();
}
