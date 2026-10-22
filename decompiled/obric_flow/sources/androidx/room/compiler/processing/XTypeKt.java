package androidx.room.compiler.processing;

import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u001b\u0010\u0005\u001a\u00020\u0001*\u00020\u0003\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0000\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0003ò\u0001\u0004\n\u00020\u0006¨\u0006\u000e"}, d2 = {"isAssignableWithoutVariance", "", "from", "Landroidx/room/compiler/processing/XType;", "to", "isArray", "Landroidx/room/compiler/processing/XArrayType;", "isByte", "isCollection", "isInt", "isKotlinUnit", "isLong", "isVoid", "isVoidObject", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class XTypeKt {
    public static final /* synthetic */ boolean access$isAssignableWithoutVariance(XType r5, XType r10) {
        return isAssignableWithoutVariance(r5, r10);
    }

    public static final boolean isArray(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5 instanceof XArrayType;
    }

    private static final boolean isAssignableWithoutVariance(XType r10, XType r11) {
        if (r11.isAssignableFrom(r10) == false) goto L5;
        return true;
    L5:
        List<XType> r5 = r10.getTypeArguments();
        List<XType> r12 = r11.getTypeArguments();
        if (r5.isEmpty() == false) goto L8;
    L41:
        return false;
    L8:
        if (r5.size() != r12.size()) goto L41;
        if (r11.getRawType().isAssignableFrom(r10) == true) goto L13;
        return false;
    L13:
        ArrayList r13 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r14 = r5.iterator();
    L15:
        if (r14.hasNext() == false) goto L18;
        r13.add(((XType) r14.next()).extendsBound());
        goto L15
    L18:
        if (r13.isEmpty() == true) goto L41;
        Iterator r15 = r13.iterator();
    L22:
        if (r15.hasNext() == false) goto L41;
        if (((XType) r15.next()) == null) goto L22;
        Iterable r16 = CollectionsKt.getIndices(r5);
        if ((r16 instanceof Collection) == true) goto L29;
    L31:
        Iterator r17 = r16.iterator();
    L33:
        if (r17.hasNext() == false) goto L50;
        int r18 = ((IntIterator) r17).nextInt();
        XType r19 = (XType) r13.get(r18);
        if (r19 != null) goto L38;
        r19 = r5.get(r18);
    L38:
        if (isAssignableWithoutVariance(r19, r12.get(r18)) == true) goto L33;
        return false;
    L50:
        return true;
    L29:
        if (((Collection) r16).isEmpty() == false) goto L31;
        return true;
    }

    public static final boolean isByte(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5.getTypeName(), x.f) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r5.getTypeName(), KnownTypeNames.INSTANCE.getBOXED_BYTE()) == true) goto L8;
        return false;
    }

    public static final boolean isCollection(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isTypeOf(Reflection.getOrCreateKotlinClass(List.class)) == false) goto L5;
    L8:
        return true;
    L5:
        if (r5.isTypeOf(Reflection.getOrCreateKotlinClass(Set.class)) == true) goto L8;
        return false;
    }

    public static final boolean isInt(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5.getTypeName(), x.f15023h) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r5.getTypeName(), KnownTypeNames.INSTANCE.getBOXED_INT()) == true) goto L8;
        return false;
    }

    public static final boolean isKotlinUnit(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Intrinsics.areEqual(r5.getTypeName(), KnownTypeNames.INSTANCE.getKOTLIN_UNIT());
    }

    public static final boolean isLong(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5.getTypeName(), x.f15024i) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r5.getTypeName(), KnownTypeNames.INSTANCE.getBOXED_LONG()) == true) goto L8;
        return false;
    }

    public static final boolean isVoid(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Intrinsics.areEqual(r5.getTypeName(), x.d);
    }

    public static final boolean isVoidObject(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Intrinsics.areEqual(r5.getTypeName(), KnownTypeNames.INSTANCE.getBOXED_VOID());
    }
}
