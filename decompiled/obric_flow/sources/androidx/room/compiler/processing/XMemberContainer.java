package androidx.room.compiler.processing;

import androidx.room.compiler.codegen.XClassName;
import com.squareup.javapoet.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XMemberContainer;", "Landroidx/room/compiler/processing/XElement;", "Landroidx/room/compiler/codegen/XClassName;", "asClassName", "()Landroidx/room/compiler/codegen/XClassName;", "", "getName", "()Ljava/lang/String;", "name", "Lcom/squareup/javapoet/e;", "getClassName", "()Lcom/squareup/javapoet/e;", "className", "Landroidx/room/compiler/processing/XType;", "getType", "()Landroidx/room/compiler/processing/XType;", "type", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XMemberContainer extends XElement {
    XClassName asClassName();

    e getClassName();

    @Override // androidx.room.compiler.processing.XElement
    default String getName() {
        if ((this instanceof XTypeElement) == false) goto L6;
        return getName();
    L6:
        return getClassName().f14961y;
    }

    XType getType();
}
