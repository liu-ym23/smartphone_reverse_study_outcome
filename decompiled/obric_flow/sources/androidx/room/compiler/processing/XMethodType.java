package androidx.room.compiler.processing;

import com.squareup.javapoet.a0;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XMethodType;", "Landroidx/room/compiler/processing/XExecutableType;", "Landroidx/room/compiler/processing/XType;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "returnType", "", "Lcom/squareup/javapoet/a0;", "getTypeVariableNames", "()Ljava/util/List;", "typeVariableNames", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XMethodType extends XExecutableType {
    XType getReturnType();

    List<a0> getTypeVariableNames();
}
