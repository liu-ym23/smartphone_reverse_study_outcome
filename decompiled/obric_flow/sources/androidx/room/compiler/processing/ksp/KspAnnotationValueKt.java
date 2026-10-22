package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XArrayType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeKt;
import il.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotation;", "Landroidx/room/compiler/processing/XType;", "valueType", "Lil/t;", "valueArgument", "", "unwrap", "(Landroidx/room/compiler/processing/ksp/KspAnnotation;Landroidx/room/compiler/processing/XType;Lil/t;)Ljava/lang/Object;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KspAnnotationValueKt {
    public static final Object unwrap(KspAnnotation r10, XType r11, t r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "valueType");
        Intrinsics.checkNotNullParameter(r12, "valueArgument");
        Object r5 = unwrap$unwrap(r10, r12.getValue());
        if (XTypeKt.isArray(r11) == true) goto L5;
        return r5;
    L5:
        if ((r5 instanceof List) == true) goto L7;
        List r13 = CollectionsKt.listOf(r5);
    L8:
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator r15 = r13.iterator();
    L10:
        if (r15.hasNext() == false) goto L13;
        final Object r16 = r15.next();
        r14.add(new KspAnnotationValue(r10.getEnv(), r10, ((XArrayType) r11).getComponentType(), r12, new KspAnnotationValueKt$unwrap$1$1$1(r16)));
        goto L10
    L13:
        return r14;
    L7:
        r13 = (List) r5;
        goto L8
    }

    private static final Object unwrap$unwrap(KspAnnotation r5, Object r10) {
        if ((r10 instanceof List) == false) goto L10;
        Iterable r11 = (Iterable) r10;
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        r12.add(unwrap$unwrap(r5, r13.next()));
        goto L6
    L11:
        return r12;
    L10:
        if ((r10 instanceof Enum) == false) goto L15;
        r5.getEnv().getResolver();
        String r14 = r10.getClass().getCanonicalName();
        Intrinsics.checkNotNullParameter(null, "<this>");
        Intrinsics.checkNotNullParameter(r14, "name");
        throw null;
    L15:
        return r10;
    }
}
