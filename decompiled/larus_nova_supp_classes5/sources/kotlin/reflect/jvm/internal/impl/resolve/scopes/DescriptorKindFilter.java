package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DescriptorKindFilter {
    public static final DescriptorKindFilter ALL = null;
    private static final int ALL_KINDS_MASK = 0;
    public static final DescriptorKindFilter CALLABLES = null;
    private static final int CALLABLES_MASK = 0;
    public static final DescriptorKindFilter CLASSIFIERS = null;
    private static final int CLASSIFIERS_MASK = 0;
    public static final Companion Companion = null;
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES = null;
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES = null;
    public static final DescriptorKindFilter FUNCTIONS = null;
    private static final int FUNCTIONS_MASK = 0;
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS = null;
    private static final int NON_SINGLETON_CLASSIFIERS_MASK = 0;
    public static final DescriptorKindFilter PACKAGES = null;
    private static final int PACKAGES_MASK = 0;
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS = null;
    private static final int SINGLETON_CLASSIFIERS_MASK = 0;
    public static final DescriptorKindFilter TYPE_ALIASES = null;
    private static final int TYPE_ALIASES_MASK = 0;
    public static final DescriptorKindFilter VALUES = null;
    private static final int VALUES_MASK = 0;
    public static final DescriptorKindFilter VARIABLES = null;
    private static final int VARIABLES_MASK = 0;
    private static int nextMaskValue;
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;

    public static final class Companion {

        public static final class MaskToName {
            private final int mask;
            private final String name;

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }

            public MaskToName(int r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
                this.mask = r2;
                this.name = r3;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final int nextMask() {
            int r0 = DescriptorKindFilter.access$getNextMaskValue$cp();
            DescriptorKindFilter.access$setNextMaskValue$cp(DescriptorKindFilter.access$getNextMaskValue$cp() << 1);
            return r0;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.access$getALL_KINDS_MASK$cp();
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.access$getCLASSIFIERS_MASK$cp();
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.access$getFUNCTIONS_MASK$cp();
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.access$getNON_SINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.access$getPACKAGES_MASK$cp();
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.access$getSINGLETON_CLASSIFIERS_MASK$cp();
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.access$getTYPE_ALIASES_MASK$cp();
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.access$getVARIABLES_MASK$cp();
        }

        public static final /* synthetic */ int access$nextMask(Companion r0) {
            return r0.nextMask();
        }
    }

    static {
        DefaultConstructorMarker r1 = null;
        Companion r0 = new Companion(r1);
        Companion = r0;
        nextMaskValue = 1;
        int r3 = Companion.access$nextMask(r0);
        NON_SINGLETON_CLASSIFIERS_MASK = r3;
        int r4 = Companion.access$nextMask(r0);
        SINGLETON_CLASSIFIERS_MASK = r4;
        int r5 = Companion.access$nextMask(r0);
        TYPE_ALIASES_MASK = r5;
        int r6 = Companion.access$nextMask(r0);
        PACKAGES_MASK = r6;
        int r7 = Companion.access$nextMask(r0);
        FUNCTIONS_MASK = r7;
        int r8 = Companion.access$nextMask(r0);
        VARIABLES_MASK = r8;
        int r2 = Companion.access$nextMask(r0) - 1;
        ALL_KINDS_MASK = r2;
        int r9 = (r3 | r4) | r5;
        CLASSIFIERS_MASK = r9;
        int r10 = (r4 | r7) | r8;
        VALUES_MASK = r10;
        int r11 = r7 | r8;
        CALLABLES_MASK = r11;
        int r13 = 2;
        ALL = new DescriptorKindFilter(r2, r1, r13, r1);
        CALLABLES = new DescriptorKindFilter(r11, r1, r13, r1);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(r3, r1, r13, r1);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(r4, r1, r13, r1);
        TYPE_ALIASES = new DescriptorKindFilter(r5, r1, r13, r1);
        CLASSIFIERS = new DescriptorKindFilter(r9, r1, r13, r1);
        PACKAGES = new DescriptorKindFilter(r6, r1, r13, r1);
        FUNCTIONS = new DescriptorKindFilter(r7, r1, r13, r1);
        VARIABLES = new DescriptorKindFilter(r8, r1, r13, r1);
        VALUES = new DescriptorKindFilter(r10, r1, r13, r1);
        Field[] r12 = DescriptorKindFilter.class.getFields();
        ArrayList r14 = new ArrayList();
        int r15 = r12.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L8;
        Field r17 = r12[r16];
        if (Modifier.isStatic(r17.getModifiers()) == false) goto L7;
        r14.add(r17);
    L7:
        r16 = r16 + 1;
        goto L3
    L8:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r14.iterator();
    L10:
        if (r19.hasNext() == false) goto L20;
        Field r20 = (Field) r19.next();
        Object r21 = r20.get(null);
        if ((r21 instanceof DescriptorKindFilter) == false) goto L14;
        DescriptorKindFilter r22 = (DescriptorKindFilter) r21;
    L15:
        if (r22 == null) goto L17;
        Companion.MaskToName r23 = new Companion.MaskToName(r22.kindMask, r20.getName());
    L18:
        if (r23 == null) goto L10;
        r18.add(r23);
        goto L10
    L17:
        r23 = null;
        goto L18
    L14:
        r22 = null;
        goto L15
    L20:
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = r18;
        Field[] r24 = DescriptorKindFilter.class.getFields();
        ArrayList r25 = new ArrayList();
        int r26 = r24.length;
        int r27 = 0;
    L21:
        if (r27 >= r26) goto L26;
        Field r28 = r24[r27];
        if (Modifier.isStatic(r28.getModifiers()) == false) goto L25;
        r25.add(r28);
    L25:
        r27 = r27 + 1;
        goto L21
    L26:
        ArrayList r29 = new ArrayList();
        Iterator r30 = r25.iterator();
    L28:
        if (r30.hasNext() == false) goto L32;
        Object r31 = r30.next();
        if (Intrinsics.areEqual(((Field) r31).getType(), Integer.TYPE) == false) goto L28;
        r29.add(r31);
        goto L28
    L32:
        ArrayList r32 = new ArrayList();
        Iterator r33 = r29.iterator();
    L34:
        if (r33.hasNext() == false) goto L44;
        Field r34 = (Field) r33.next();
        Object r35 = r34.get(null);
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type kotlin.Int");
        int r36 = ((Integer) r35).intValue();
        if (r36 != ((-r36) & r36)) goto L38;
        boolean r37 = true;
    L39:
        if (r37 == false) goto L41;
        Companion.MaskToName r38 = new Companion.MaskToName(r36, r34.getName());
    L42:
        if (r38 == null) goto L34;
        r32.add(r38);
        goto L34
    L41:
        r38 = null;
        goto L42
    L38:
        r37 = false;
        goto L39
    L44:
        DEBUG_MASK_BIT_NAMES = r32;
    }

    public int hashCode() {
        return (this.excludes.hashCode() * 31) + this.kindMask;
    }

    public String toString() {
        Iterator<T> r0 = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((Companion.MaskToName) r1).getMask() != this.kindMask) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        Companion.MaskToName r2 = (Companion.MaskToName) r1;
        if (r2 == null) goto L15;
        String r4 = r2.getName();
    L16:
        if (r4 != null) goto L28;
        List<Companion.MaskToName> r5 = DEBUG_MASK_BIT_NAMES;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L19:
        if (r7.hasNext() == false) goto L26;
        Companion.MaskToName r8 = (Companion.MaskToName) r7.next();
        if (acceptsKinds(r8.getMask()) == false) goto L23;
        String r9 = r8.getName();
    L24:
        if (r9 == null) goto L19;
        r6.add(r9);
        goto L19
    L23:
        r9 = null;
        goto L24
    L26:
        r4 = CollectionsKt.joinToString$default(r6, " | ", null, null, 0, null, null, 62, null);
    L28:
        return "DescriptorKindFilter(" + r4 + ", " + this.excludes + ')';
    L15:
        r4 = null;
        goto L16
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public static final /* synthetic */ int access$getALL_KINDS_MASK$cp() {
        return ALL_KINDS_MASK;
    }

    public static final /* synthetic */ int access$getCLASSIFIERS_MASK$cp() {
        return CLASSIFIERS_MASK;
    }

    public static final /* synthetic */ int access$getFUNCTIONS_MASK$cp() {
        return FUNCTIONS_MASK;
    }

    public static final /* synthetic */ int access$getNON_SINGLETON_CLASSIFIERS_MASK$cp() {
        return NON_SINGLETON_CLASSIFIERS_MASK;
    }

    public static final /* synthetic */ int access$getNextMaskValue$cp() {
        return nextMaskValue;
    }

    public static final /* synthetic */ int access$getPACKAGES_MASK$cp() {
        return PACKAGES_MASK;
    }

    public static final /* synthetic */ int access$getSINGLETON_CLASSIFIERS_MASK$cp() {
        return SINGLETON_CLASSIFIERS_MASK;
    }

    public static final /* synthetic */ int access$getTYPE_ALIASES_MASK$cp() {
        return TYPE_ALIASES_MASK;
    }

    public static final /* synthetic */ int access$getVARIABLES_MASK$cp() {
        return VARIABLES_MASK;
    }

    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public static final /* synthetic */ void access$setNextMaskValue$cp(int r0) {
        nextMaskValue = r0;
    }

    public final boolean acceptsKinds(int r2) {
        if ((r2 & this.kindMask) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(DescriptorKindFilter.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        DescriptorKindFilter r6 = (DescriptorKindFilter) r5;
        if (Intrinsics.areEqual(this.excludes, r6.excludes) == true) goto L16;
        return false;
    L16:
        if (this.kindMask == r6.kindMask) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final DescriptorKindFilter restrictedToKindsOrNull(int r3) {
        int r4 = r3 & this.kindMask;
        if (r4 != 0) goto L7;
        return null;
    L7:
        return new DescriptorKindFilter(r4, this.excludes);
    }

    public DescriptorKindFilter(int r2, List<? extends DescriptorKindExclude> r3) {
        Intrinsics.checkNotNullParameter(r3, "excludes");
        this.excludes = r3;
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r2 = r2 & (~((DescriptorKindExclude) r4.next()).getFullyExcludedDescriptorKinds());
        goto L4
    L6:
        this.kindMask = r2;
    }

    public /* synthetic */ DescriptorKindFilter(int r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        this(r1, r2);
    }
}
