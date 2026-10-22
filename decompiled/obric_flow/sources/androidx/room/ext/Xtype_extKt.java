package androidx.room.ext;

import androidx.room.compiler.processing.XEnumTypeElementKt;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XTypeKt;
import com.squareup.javapoet.e;
import com.squareup.javapoet.x;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0002¨\u0006\u000b"}, d2 = {"implementsEqualsAndHashcode", "", "Landroidx/room/compiler/processing/XType;", "isNotByte", "isNotError", "isNotKotlinUnit", "isNotNone", "isNotVoid", "isNotVoidObject", "isSupportedMapTypeArg", "isUUID", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class Xtype_extKt {
    public static final boolean implementsEqualsAndHashcode(XType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (isSupportedMapTypeArg(r10) == false) goto L5;
        return true;
    L5:
        XTypeElement r11 = r10.getTypeElement();
        if (r11 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r11.getClassName(), e.B) == false) goto L12;
        return false;
    L12:
        if (r11.isDataClass() == false) goto L14;
        return true;
    L14:
        List<XMethodElement> r5 = r11.getDeclaredMethods();
        if (r5 != null) goto L17;
    L19:
        Iterator<T> r12 = r5.iterator();
    L21:
        if (r12.hasNext() == false) goto L18;
        XMethodElement r13 = (XMethodElement) r12.next();
        if (Intrinsics.areEqual(r13.getJvmName(), "equals") == false) goto L21;
        if (Intrinsics.areEqual(r13.getReturnType().getTypeName(), x.e) == false) goto L21;
        if (r13.getParameters().size() != 1) goto L21;
        if (Intrinsics.areEqual(r13.getParameters().get(0).getType().getTypeName(), x.f15028m) == false) goto L21;
        boolean r14 = true;
    L31:
        List<XMethodElement> r15 = r11.getDeclaredMethods();
        if (r15 != null) goto L34;
    L36:
        Iterator<T> r16 = r15.iterator();
    L38:
        if (r16.hasNext() == false) goto L35;
        XMethodElement r17 = (XMethodElement) r16.next();
        if (Intrinsics.areEqual(r17.getJvmName(), "hashCode") == false) goto L38;
        if (Intrinsics.areEqual(r17.getReturnType().getTypeName(), x.f15023h) == false) goto L38;
        if (r17.getParameters().size() != 0) goto L38;
        boolean r18 = true;
    L46:
        if (r14 == false) goto L49;
        if (r18 == false) goto L49;
        return true;
    L49:
        XType r19 = r11.getSuperClass();
        if (r19 != null) goto L52;
        return false;
    L52:
        return implementsEqualsAndHashcode(r19);
    L35:
        r18 = false;
        goto L46
    L34:
        if (r15.isEmpty() == false) goto L36;
    L18:
        r14 = false;
        goto L31
    L17:
        if (r5.isEmpty() == false) goto L19;
        goto L18
    }

    public static final boolean isNotByte(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return !XTypeKt.isByte(r5);
    }

    public static final boolean isNotError(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return !r5.isError();
    }

    public static final boolean isNotKotlinUnit(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return !XTypeKt.isKotlinUnit(r5);
    }

    public static final boolean isNotNone(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return !r5.isNone();
    }

    public static final boolean isNotVoid(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return !XTypeKt.isVoid(r5);
    }

    public static final boolean isNotVoidObject(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return !XTypeKt.isVoidObject(r5);
    }

    public static final boolean isSupportedMapTypeArg(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getTypeName().k() == false) goto L6;
        return true;
    L6:
        if (r5.getTypeName().j() == false) goto L9;
        return true;
    L9:
        if (Intrinsics.areEqual(r5.getTypeName(), CommonTypeNames.INSTANCE.getSTRING()) == false) goto L12;
        return true;
    L12:
        if (r5.isTypeOf(Reflection.getOrCreateKotlinClass(byte[].class)) == false) goto L15;
        return true;
    L15:
        if (XTypeKt.isArray(r5) == true) goto L17;
    L19:
        XTypeElement r10 = r5.getTypeElement();
        if (r10 != null) goto L23;
        return false;
    L23:
        if (XEnumTypeElementKt.isEnum(r10) == false) goto L25;
        return true;
    L25:
        return false;
    L17:
        if (XTypeKt.isByte(r5) == false) goto L19;
        return true;
    }

    public static final boolean isUUID(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Intrinsics.areEqual(r5.getTypeName(), CommonTypeNames.INSTANCE.getUUID());
    }
}
