package androidx.room.compiler.processing.javac;

import androidx.exifinterface.media.ExifInterface;
import java.lang.Enum;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ/\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/room/compiler/processing/javac/EnumListVisitor;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljavax/lang/model/util/SimpleAnnotationValueVisitor8;", "", "Ljava/lang/Void;", "enumClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "visitArray", "values", "", "Ljavax/lang/model/element/AnnotationValue;", "void", "(Ljava/util/List;Ljava/lang/Void;)[Ljava/lang/Enum;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class EnumListVisitor<T extends Enum<T>> extends SimpleAnnotationValueVisitor8<T[], Void> {
    private final Class<T> enumClass;

    public EnumListVisitor(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "enumClass");
        this.enumClass = r5;
    }

    public /* bridge */ /* synthetic */ Object visitArray(List r5, Object r10) {
        return visitArray(r5, (Void) r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] visitArray(List<? extends AnnotationValue> r5, Void r10) {
        if (r5 == null) goto L7;
        ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r12 = r5.iterator();
    L5:
        if (r12.hasNext() == false) goto L8;
        r11.add(JavacAnnotationBoxKt.access$getAsEnum((AnnotationValue) r12.next(), this.enumClass));
    L8:
        Class<T> r13 = this.enumClass;
        int r14 = 0;
        if (r11 == null) goto L11;
        int r15 = r11.size();
    L12:
        Object r16 = Array.newInstance(r13, r15);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<T of androidx.room.compiler.processing.javac.EnumListVisitor>");
        T[] r17 = (T[]) ((Enum[]) r16);
        if (r11 == null) goto L21;
        Iterator r18 = r11.iterator();
    L16:
        if (r18.hasNext() == false) goto L21;
        Object r19 = r18.next();
        int r20 = r14 + 1;
        if (r14 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        r17[r14] = (Enum) r19;
        r14 = r20;
    L21:
        return r17;
    L11:
        r15 = 0;
        goto L12
    L7:
        r11 = null;
        goto L8
    }
}
