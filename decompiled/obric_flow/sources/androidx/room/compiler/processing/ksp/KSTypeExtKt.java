package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.room.compiler.processing.XNullability;
import il.d;
import il.j;
import il.p;
import il.q;
import il.s;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmSuppressWildcards;
import kotlin.jvm.JvmWildcard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\t*\u00020\u0005¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0014\u001a\u00020\t*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0016\u001a\u00020\t*\u00020\u0012H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u00020\t*\u00020\u0012H\u0000¢\u0006\u0004\b\u0018\u0010\u0017\u001a\u0013\u0010\u001a\u001a\u00020\t*\u00020\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lil/d;", "", "getNormalizedPackageName", "(Lil/d;)Ljava/lang/String;", "Lil/q;", "Lil/p;", "requireType", "(Lil/q;)Lil/p;", "Lil/s;", "", "isTypeParameterReference", "(Lil/s;)Z", "isInline", "(Lil/p;)Z", "Landroidx/room/compiler/processing/XNullability;", "nullability", "withNullability", "(Lil/p;Landroidx/room/compiler/processing/XNullability;)Lil/p;", "Lil/a;", "qName", "hasAnnotation", "(Lil/a;Ljava/lang/String;)Z", "hasJvmWildcardAnnotation", "(Lil/a;)Z", "hasSuppressJvmWildcardAnnotation", "Lil/j;", "hasSuppressWildcardsAnnotationInHierarchy", "(Lil/j;)Z", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KSTypeExtKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[XNullability.values().length];
            r5[XNullability.NULLABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r5[XNullability.NONNULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final String getNormalizedPackageName(d r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.getPackageName();
        throw null;
    }

    private static final boolean hasAnnotation(il.a r5, String r10) {
        Iterator r11 = r5.getAnnotations().iterator();
        if (r11.hasNext() == true) goto L6;
        return false;
    L6:
        j0.A(r11.next());
        throw null;
    }

    public static final boolean hasJvmWildcardAnnotation(il.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r10 = JvmWildcard.class.getCanonicalName();
        Intrinsics.checkNotNull(r10);
        return hasAnnotation(r5, r10);
    }

    public static final boolean hasSuppressJvmWildcardAnnotation(il.a r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r10 = JvmSuppressWildcards.class.getCanonicalName();
        Intrinsics.checkNotNull(r10);
        return hasAnnotation(r5, r10);
    }

    public static final boolean hasSuppressWildcardsAnnotationInHierarchy(j r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof il.a) == false) goto L5;
        il.a r10 = (il.a) r5;
    L6:
        if (r10 != null) goto L8;
    L11:
        j r11 = r5.getParent();
        if (r11 != null) goto L16;
        return false;
    L16:
        return hasSuppressWildcardsAnnotationInHierarchy(r11);
    L8:
        if (hasSuppressJvmWildcardAnnotation((il.a) r5) == false) goto L11;
        return true;
    L5:
        r10 = null;
        goto L6
    }

    public static final boolean isInline(p r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.getDeclaration();
        throw null;
    }

    public static final boolean isTypeParameterReference(s r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.resolve();
        throw null;
    }

    public static final p requireType(q r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        s r10 = r5.getType();
        if (r10 == null) goto L6;
        r10.resolve();
    L6:
        throw new IllegalStateException(("KSTypeArgument.type should not have been null, please file a bug. " + r5).toString());
    }

    public static final p withNullability(p r5, XNullability r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "nullability");
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 != 1) goto L5;
        r5.makeNullable();
        return null;
    L5:
        if (r11 != 2) goto L8;
        r5.a();
        return null;
    L8:
        throw new IllegalArgumentException("Cannot set KSType nullability to platform");
    }
}
