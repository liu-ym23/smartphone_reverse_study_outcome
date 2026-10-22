package androidx.room.compiler.processing;

import androidx.room.compiler.codegen.XTypeName;
import com.squareup.javapoet.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XRawType;", "", "Landroidx/room/compiler/codegen/XTypeName;", "asTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "other", "", "isAssignableFrom", "(Landroidx/room/compiler/processing/XRawType;)Z", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/compiler/processing/XType;)Z", "Lcom/squareup/javapoet/x;", "getTypeName", "()Lcom/squareup/javapoet/x;", "typeName", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XRawType {
    XTypeName asTypeName();

    x getTypeName();

    boolean isAssignableFrom(XRawType r5);

    default boolean isAssignableFrom(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return isAssignableFrom(r5.getRawType());
    }
}
