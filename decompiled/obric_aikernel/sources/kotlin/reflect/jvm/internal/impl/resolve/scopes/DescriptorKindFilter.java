package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorKindFilter {

    @JvmField
    public static final DescriptorKindFilter ALL = null;
    private static final int ALL_KINDS_MASK = 0;

    @JvmField
    public static final DescriptorKindFilter CALLABLES = null;
    private static final int CALLABLES_MASK = 0;

    @JvmField
    public static final DescriptorKindFilter CLASSIFIERS = null;
    private static final int CLASSIFIERS_MASK = 0;
    public static final Companion Companion = null;
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES = null;
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES = null;

    @JvmField
    public static final DescriptorKindFilter FUNCTIONS = null;
    private static final int FUNCTIONS_MASK = 0;

    @JvmField
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS = null;
    private static final int NON_SINGLETON_CLASSIFIERS_MASK = 0;

    @JvmField
    public static final DescriptorKindFilter PACKAGES = null;
    private static final int PACKAGES_MASK = 0;

    @JvmField
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS = null;
    private static final int SINGLETON_CLASSIFIERS_MASK = 0;

    @JvmField
    public static final DescriptorKindFilter TYPE_ALIASES = null;
    private static final int TYPE_ALIASES_MASK = 0;

    @JvmField
    public static final DescriptorKindFilter VALUES = null;
    private static final int VALUES_MASK = 0;

    @JvmField
    public static final DescriptorKindFilter VARIABLES = null;
    private static final int VARIABLES_MASK = 0;
    private static int nextMaskValue;
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;

    public static final class Companion {

        private static final class MaskToName {
            private final int mask;
            private final String name;

            public MaskToName(int r10, String r11) {
                Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
                this.mask = r10;
                this.name = r11;
            }

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ int access$nextMask(Companion r10) {
            return r10.nextMask();
        }

        private final int nextMask() {
            int r10 = DescriptorKindFilter.access$getNextMaskValue$cp();
            Companion r11 = DescriptorKindFilter.Companion;
            DescriptorKindFilter.access$setNextMaskValue$cp(DescriptorKindFilter.access$getNextMaskValue$cp() << 1);
            return r10;
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion r10 = new Companion(null);
        Companion = r10;
        nextMaskValue = 1;
        int r11 = Companion.access$nextMask(r10);
        NON_SINGLETON_CLASSIFIERS_MASK = r11;
        int r12 = Companion.access$nextMask(r10);
        SINGLETON_CLASSIFIERS_MASK = r12;
        int r13 = Companion.access$nextMask(r10);
        TYPE_ALIASES_MASK = r13;
        int r14 = Companion.access$nextMask(r10);
        PACKAGES_MASK = r14;
        int r15 = Companion.access$nextMask(r10);
        FUNCTIONS_MASK = r15;
        int r16 = Companion.access$nextMask(r10);
        VARIABLES_MASK = r16;
        int r17 = Companion.access$nextMask(r10) - 1;
        ALL_KINDS_MASK = r17;
        int r18 = (r11 | r12) | r13;
        CLASSIFIERS_MASK = r18;
        int r19 = (r12 | r15) | r16;
        VALUES_MASK = r19;
        int r110 = r15 | r16;
        CALLABLES_MASK = r110;
        int r111 = 2;
        ALL = new DescriptorKindFilter(r17, 0 == true ? 1 : 0, r111, 0 == true ? 1 : 0);
        CALLABLES = new DescriptorKindFilter(r110, 0 == true ? 1 : 0, r111, 0 == true ? 1 : 0);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(r11, 0 == true ? 1 : 0, r111, 0 == true ? 1 : 0);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(r12, 0 == true ? 1 : 0, r111, 0 == true ? 1 : 0);
        TYPE_ALIASES = new DescriptorKindFilter(r13, 0 == true ? 1 : 0, r111, 0 == true ? 1 : 0);
        CLASSIFIERS = new DescriptorKindFilter(r18, 0 == true ? 1 : 0, r111, 0 == true ? 1 : 0);
        PACKAGES = new DescriptorKindFilter(r14, 0 == true ? 1 : 0, r111, 0 == true ? 1 : 0);
        FUNCTIONS = new DescriptorKindFilter(r15, 0 == true ? 1 : 0, r111, 0 == true ? 1 : 0);
        VARIABLES = new DescriptorKindFilter(r16, 0 == true ? 1 : 0, r111, 0 == true ? 1 : 0);
        VALUES = new DescriptorKindFilter(r19, 0 == true ? 1 : 0, r111, 0 == true ? 1 : 0);
        Field[] r20 = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(r20, "T::class.java.fields");
        ArrayList r21 = new ArrayList();
        int r22 = r20.length;
        int r23 = 0;
    L3:
        if (r23 >= r22) goto L8;
        Field r24 = r20[r23];
        if (Modifier.isStatic(r24.getModifiers()) == false) goto L7;
        r21.add(r24);
    L7:
        r23 = r23 + 1;
        goto L3
    L8:
        ArrayList r25 = new ArrayList();
        Iterator r26 = r21.iterator();
    L10:
        if (r26.hasNext() == false) goto L20;
        Field r27 = (Field) r26.next();
        Object r28 = r27.get(null);
        if ((r28 instanceof DescriptorKindFilter) == false) goto L14;
        DescriptorKindFilter r29 = (DescriptorKindFilter) r28;
    L15:
        if (r29 == null) goto L17;
        int r30 = r29.kindMask;
        String r31 = r27.getName();
        Intrinsics.checkNotNullExpressionValue(r31, "field.name");
        Companion.MaskToName r112 = new Companion.MaskToName(r30, r31);
    L18:
        if (r112 == null) goto L10;
        r25.add(r112);
        goto L10
    L17:
        r112 = null;
        goto L18
    L14:
        r29 = null;
        goto L15
    L20:
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = r25;
        Field[] r32 = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(r32, "T::class.java.fields");
        ArrayList r33 = new ArrayList();
        int r34 = r32.length;
        int r35 = 0;
    L21:
        if (r35 >= r34) goto L26;
        Field r36 = r32[r35];
        if (Modifier.isStatic(r36.getModifiers()) == false) goto L25;
        r33.add(r36);
    L25:
        r35 = r35 + 1;
        goto L21
    L26:
        ArrayList r37 = new ArrayList();
        Iterator r38 = r33.iterator();
    L28:
        if (r38.hasNext() == false) goto L32;
        Object r39 = r38.next();
        if (Intrinsics.areEqual(((Field) r39).getType(), Integer.TYPE) == false) goto L28;
        r37.add(r39);
        goto L28
    L32:
        ArrayList r40 = new ArrayList();
        Iterator r41 = r37.iterator();
    L34:
        if (r41.hasNext() == false) goto L44;
        Field r42 = (Field) r41.next();
        Object r43 = r42.get(null);
        Intrinsics.checkNotNull(r43, "null cannot be cast to non-null type kotlin.Int");
        int r44 = ((Integer) r43).intValue();
        if (r44 != ((-r44) & r44)) goto L38;
        Object[] r45 = true;
    L39:
        if (r45 == false) goto L41;
        String r46 = r42.getName();
        Intrinsics.checkNotNullExpressionValue(r46, "field.name");
        Companion.MaskToName r47 = new Companion.MaskToName(r44, r46);
    L42:
        if (r47 == null) goto L34;
        r40.add(r47);
        goto L34
    L41:
        r47 = null;
        goto L42
    L38:
        r45 = false;
        goto L39
    L44:
        DEBUG_MASK_BIT_NAMES = r40;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DescriptorKindFilter(int r10, List<? extends DescriptorKindExclude> r11) {
        Intrinsics.checkNotNullParameter(r11, "excludes");
        this.excludes = r11;
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r10 = r10 & (~((DescriptorKindExclude) r12.next()).getFullyExcludedDescriptorKinds());
        goto L4
    L6:
        this.kindMask = r10;
    }

    public /* synthetic */ DescriptorKindFilter(int r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        this(r10, r11);
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

    public static final /* synthetic */ void access$setNextMaskValue$cp(int r10) {
        nextMaskValue = r10;
    }

    public final boolean acceptsKinds(int r10) {
        if ((this.kindMask & r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if (Intrinsics.areEqual(DescriptorKindFilter.class, r11) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        DescriptorKindFilter r12 = (DescriptorKindFilter) r10;
        if (Intrinsics.areEqual(this.excludes, r12.excludes) == true) goto L16;
        return false;
    L16:
        if (this.kindMask == r12.kindMask) goto L18;
        return false;
    L18:
        return true;
    L8:
        r11 = null;
        goto L10
    }

    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public int hashCode() {
        return (this.excludes.hashCode() * 31) + this.kindMask;
    }

    public final DescriptorKindFilter restrictedToKindsOrNull(int r10) {
        int r11 = r10 & this.kindMask;
        if (r11 != 0) goto L7;
        return null;
    L7:
        return new DescriptorKindFilter(r11, this.excludes);
    }

    public String toString() {
        Iterator<T> r10 = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Object r11 = r10.next();
        if (((Companion.MaskToName) r11).getMask() != this.kindMask) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == false) goto L4;
    L12:
        Companion.MaskToName r13 = (Companion.MaskToName) r11;
        if (r13 == null) goto L15;
        String r14 = r13.getName();
    L16:
        if (r14 != null) goto L28;
        List<Companion.MaskToName> r15 = DEBUG_MASK_BIT_NAMES;
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L19:
        if (r17.hasNext() == false) goto L26;
        Companion.MaskToName r18 = (Companion.MaskToName) r17.next();
        if (acceptsKinds(r18.getMask()) == false) goto L23;
        String r19 = r18.getName();
    L24:
        if (r19 == null) goto L19;
        r16.add(r19);
        goto L19
    L23:
        r19 = null;
        goto L24
    L26:
        r14 = CollectionsKt.joinToString$default(r16, " | ", null, null, 0, null, null, 62, null);
    L28:
        return "DescriptorKindFilter(" + r14 + ", " + this.excludes + ')';
    L15:
        r14 = null;
        goto L16
    L8:
        r12 = false;
        goto L9
    L11:
        r11 = null;
        goto L12
    }
}
