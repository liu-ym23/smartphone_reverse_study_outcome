package androidx.room.compiler.processing.ksp;

import com.google.devtools.ksp.symbol.Variance;
import hl.d;
import il.p;
import il.q;
import il.r;
import il.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\f\u001a\u00020\u0006*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ7\u0010\f\u001a\u00020\u000e*\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\u0011J'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/room/compiler/processing/ksp/KSTypeVarianceResolver;", "", "Lhl/d;", "resolver", "<init>", "(Lhl/d;)V", "Lil/p;", "declarationType", "Landroidx/room/compiler/processing/ksp/KSTypeVarianceResolver$WildcardMode;", "wildcardMode", "Landroidx/room/compiler/processing/ksp/ReferenceStack;", "referenceStack", "inheritVariance", "(Lil/p;Lil/p;Landroidx/room/compiler/processing/ksp/KSTypeVarianceResolver$WildcardMode;Landroidx/room/compiler/processing/ksp/ReferenceStack;)Lil/p;", "Lil/q;", "Lil/r;", "param", "(Lil/q;Lil/q;Landroidx/room/compiler/processing/ksp/KSTypeVarianceResolver$WildcardMode;Lil/r;Landroidx/room/compiler/processing/ksp/ReferenceStack;)Lil/q;", "ksType", "applyTypeVariance", "(Lil/p;Landroidx/room/compiler/processing/ksp/KSTypeVarianceResolver$WildcardMode;Lil/p;)Lil/p;", "Lhl/d;", "WildcardMode", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KSTypeVarianceResolver {
    private final d resolver;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/compiler/processing/ksp/KSTypeVarianceResolver$WildcardMode;", "", "(Ljava/lang/String;I)V", "FORCED", "PREFERRED", "SUPPRESSED", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum WildcardMode extends Enum<WildcardMode> {
        private static final /* synthetic */ WildcardMode[] $VALUES = null;
        public static final WildcardMode FORCED = null;
        public static final WildcardMode PREFERRED = null;
        public static final WildcardMode SUPPRESSED = null;

        private static final /* synthetic */ WildcardMode[] $values() {
            return new WildcardMode[]{FORCED, PREFERRED, SUPPRESSED};
        }

        static {
            FORCED = new WildcardMode("FORCED", 0);
            PREFERRED = new WildcardMode("PREFERRED", 1);
            SUPPRESSED = new WildcardMode("SUPPRESSED", 2);
            $VALUES = $values();
        }

        private WildcardMode(String r5, int r10) {
            super(r5, r10);
        }

        public static WildcardMode valueOf(String r5) {
            return (WildcardMode) Enum.valueOf(WildcardMode.class, r5);
        }

        public static WildcardMode[] values() {
            return (WildcardMode[]) $VALUES.clone();
        }
    }

    public KSTypeVarianceResolver(d r5) {
        Intrinsics.checkNotNullParameter(r5, "resolver");
    }

    public static final /* synthetic */ q access$inheritVariance(KSTypeVarianceResolver r5, q r10, q r11, WildcardMode r12, r r13, ReferenceStack r14) {
        return r5.inheritVariance(r10, r11, r12, r13, r14);
    }

    private final p inheritVariance(p r5, p r10, WildcardMode r11, ReferenceStack r12) {
        if (r5.getArguments().isEmpty() == false) goto L10;
        return r5;
    L10:
        r12.get_queue().addLast(r5);     // Catch: Throwable -> L7
        r5.getDeclaration();     // Catch: Throwable -> L7
        throw null;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r12.get_queue().removeLast();
        throw th;
    }

    public final p applyTypeVariance(p r5, WildcardMode r10, p r11) {
        Intrinsics.checkNotNullParameter(r5, "ksType");
        Intrinsics.checkNotNullParameter(r10, "wildcardMode");
        inheritVariance(r5, r11, r10, new ReferenceStack());
        return null;
    }

    private final q inheritVariance(q r5, q r10, WildcardMode r11, r r12, ReferenceStack r13) {
        if (r12 != null) goto L4;
        return r5;
    L4:
        s r14 = r5.getType();
        if (r14 != null) goto L7;
        return r5;
    L7:
        r14.resolve();
        if (r13.contains(null) == false) goto L11;
        return r5;
    L11:
        if (r5.getVariance() == Variance.INVARIANT) goto L18;
        if (r10 == null) goto L16;
        s r15 = r10.getType();
        if (r15 == null) goto L16;
        r15.resolve();
    L16:
        inheritVariance(null, null, r11, r13);
        KSTypeReferenceExtKt.createTypeReference(null);
        r5.getVariance();
        throw null;
    L18:
        boolean r16 = true;
        if (KSTypeExtKt.hasJvmWildcardAnnotation(r5) == false) goto L22;
    L34:
        if (r10 == null) goto L36;
        Variance r17 = r10.getVariance();
    L38:
        if (r17 == Variance.STAR) goto L49;
        if (r10 == null) goto L44;
        s r18 = r10.getType();
        if (r18 == null) goto L44;
        r18.resolve();
    L44:
        if (r10 == null) goto L46;
        Variance r19 = r10.getVariance();
    L47:
        if (r19 != null) goto L49;
        r12.getVariance();
        goto L49
    L46:
        r19 = null;
    L49:
        if (r16 == false) goto L56;
        if (r10 == null) goto L54;
        s r20 = r10.getType();
        if (r20 == null) goto L54;
        r20.resolve();
    L54:
        inheritVariance(null, null, r11, r13);
        KSTypeReferenceExtKt.createTypeReference(null);
        throw null;
    L56:
        inheritVariance(null, null, r11, r13);
        KSTypeReferenceExtKt.createTypeReference(null);
        r5.getVariance();
        throw null;
    L36:
        r17 = null;
        goto L38
    L22:
        if (r11 != WildcardMode.SUPPRESSED) goto L25;
    L23:
        r16 = false;
        goto L34
    L25:
        if (r11 == WildcardMode.FORCED) goto L34;
        if (KSTypeExtKt.hasSuppressWildcardsAnnotationInHierarchy(r5) == true) goto L23;
        if (r10 != null) goto L34;
        if (r12.getVariance() == Variance.CONTRAVARIANT) goto L34;
        throw null;
    }
}
