package androidx.room.compiler.processing.ksp;

import ai.j0;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u0007\u001a\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lil/a;", "", "qName", "", "hasAnnotationWithQName", "(Lil/a;Ljava/lang/String;)Z", "hasJvmStaticAnnotation", "(Lil/a;)Z", "hasJvmTransientAnnotation", "hasJvmFieldAnnotation", "hasJvmDefaultAnnotation", "Landroidx/room/compiler/processing/ksp/OriginatingElementWrapper;", "wrapAsOriginatingElement", "(Lil/a;)Landroidx/room/compiler/processing/ksp/OriginatingElementWrapper;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KSAnnotatedExtKt {
    private static final boolean hasAnnotationWithQName(il.a r5, String r10) {
        Iterator r11 = r5.getAnnotations().iterator();
        if (r11.hasNext() == true) goto L6;
        return false;
    L6:
        j0.A(r11.next());
        throw null;
    }

    public static final boolean hasJvmDefaultAnnotation(il.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return hasAnnotationWithQName(r5, "kotlin.jvm.JvmDefault");
    }

    public static final boolean hasJvmFieldAnnotation(il.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return hasAnnotationWithQName(r5, "kotlin.jvm.JvmField");
    }

    public static final boolean hasJvmStaticAnnotation(il.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return hasAnnotationWithQName(r5, "kotlin.jvm.JvmStatic");
    }

    public static final boolean hasJvmTransientAnnotation(il.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return hasAnnotationWithQName(r5, "kotlin.jvm.Transient");
    }

    public static final OriginatingElementWrapper wrapAsOriginatingElement(il.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return null;
    }
}
