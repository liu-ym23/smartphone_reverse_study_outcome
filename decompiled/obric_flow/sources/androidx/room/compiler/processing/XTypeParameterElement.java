package androidx.room.compiler.processing;

import com.squareup.javapoet.a0;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0004\u001a\u00020\u00018&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XTypeParameterElement;", "Landroidx/room/compiler/processing/XElement;", "getEnclosingElement", "()Landroidx/room/compiler/processing/XElement;", "enclosingElement", "", "Landroidx/room/compiler/processing/XType;", "getBounds", "()Ljava/util/List;", "bounds", "Lcom/squareup/javapoet/a0;", "getTypeVariableName", "()Lcom/squareup/javapoet/a0;", "typeVariableName", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XTypeParameterElement extends XElement {
    List<XType> getBounds();

    @Override // androidx.room.compiler.processing.XElement
    XElement getEnclosingElement();

    a0 getTypeVariableName();
}
