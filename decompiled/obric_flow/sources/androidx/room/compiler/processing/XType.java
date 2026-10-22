package androidx.room.compiler.processing;

import androidx.room.compiler.codegen.XTypeName;
import com.squareup.javapoet.x;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0000H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\u000bJ\u001b\u0010\u0014\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0000H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0010J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\u0000H&¢\u0006\u0004\b\u0019\u0010\u0010J\u000f\u0010\u001a\u001a\u00020\u0000H&¢\u0006\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001e\u001a\u00020\u001b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000'8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00000'8&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010)ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XType;", "", "Landroidx/room/compiler/codegen/XTypeName;", "asTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "other", "", "isAssignableFrom", "(Landroidx/room/compiler/processing/XType;)Z", "isAssignableFromWithoutVariance", "isError", "()Z", "", "defaultValue", "()Ljava/lang/String;", "boxed", "()Landroidx/room/compiler/processing/XType;", "isList", "isNone", "Lkotlin/reflect/KClass;", "isTypeOf", "(Lkotlin/reflect/KClass;)Z", "isSameType", "extendsBoundOrSelf", "extendsBound", "makeNullable", "makeNonNullable", "Lcom/squareup/javapoet/x;", "getTypeName", "()Lcom/squareup/javapoet/x;", "typeName", "Landroidx/room/compiler/processing/XRawType;", "getRawType", "()Landroidx/room/compiler/processing/XRawType;", "rawType", "Landroidx/room/compiler/processing/XNullability;", "getNullability", "()Landroidx/room/compiler/processing/XNullability;", "nullability", "", "getSuperTypes", "()Ljava/util/List;", "superTypes", "Landroidx/room/compiler/processing/XTypeElement;", "getTypeElement", "()Landroidx/room/compiler/processing/XTypeElement;", "typeElement", "getTypeArguments", "typeArguments", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XType {
    XTypeName asTypeName();

    XType boxed();

    String defaultValue();

    XType extendsBound();

    default XType extendsBoundOrSelf() {
        XType r5 = extendsBound();
        if (r5 != null) goto L6;
        return this;
    L6:
        return r5;
    }

    XNullability getNullability();

    XRawType getRawType();

    List<XType> getSuperTypes();

    List<XType> getTypeArguments();

    XTypeElement getTypeElement();

    x getTypeName();

    boolean isAssignableFrom(XType r5);

    default boolean isAssignableFromWithoutVariance(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return XTypeKt.access$isAssignableWithoutVariance(r5, this);
    }

    boolean isError();

    default boolean isList() {
        return isTypeOf(Reflection.getOrCreateKotlinClass(List.class));
    }

    boolean isNone();

    boolean isSameType(XType r5);

    boolean isTypeOf(KClass<?> r5);

    XType makeNonNullable();

    XType makeNullable();
}
