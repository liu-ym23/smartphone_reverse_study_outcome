package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter$Companion\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,261:1\n1855#2,2:262\n1726#2,3:264\n288#2,2:267\n1603#2,9:269\n1855#2:278\n1856#2:280\n1612#2:281\n1603#2,9:286\n1855#2:295\n1856#2:297\n1612#2:298\n766#2:303\n857#2,2:304\n1603#2,9:306\n1855#2:315\n1856#2:317\n1612#2:318\n1#3:279\n1#3:296\n1#3:316\n210#4:282\n210#4:299\n3792#5:283\n4307#5,2:284\n3792#5:300\n4307#5,2:301\n*S KotlinDebug\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter\n*L\n98#1:262,2\n103#1:264,3\n129#1:267,2\n131#1:269,9\n131#1:278\n131#1:280\n131#1:281\n197#1:286,9\n197#1:295\n197#1:297\n197#1:298\n203#1:303\n203#1:304,2\n204#1:306,9\n204#1:315\n204#1:317\n204#1:318\n131#1:279\n197#1:296\n204#1:316\n196#1:282\n202#1:299\n196#1:283\n196#1:284,2\n202#1:300\n202#1:301,2\n*E\n"})
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

    @SourceDebugExtension({"SMAP\nMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,261:1\n1#2:262\n3792#3:263\n4307#3,2:264\n*S KotlinDebug\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter$Companion\n*L\n210#1:263\n210#1:264,2\n*E\n"})
    public static final class Companion {

        public static final class MaskToName {
            private final int mask;
            private final String name;

            public MaskToName(int r5, String r10) {
                Intrinsics.checkNotNullParameter(r10, "name");
                this.mask = r5;
                this.name = r10;
            }

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ int access$nextMask(Companion r5) {
            return r5.nextMask();
        }

        private final int nextMask() {
            int r5 = DescriptorKindFilter.access$getNextMaskValue$cp();
            DescriptorKindFilter.access$setNextMaskValue$cp(DescriptorKindFilter.access$getNextMaskValue$cp() << 1);
            return r5;
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

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion r5 = new Companion(null);
        Companion = r5;
        nextMaskValue = 1;
        int r10 = Companion.access$nextMask(r5);
        NON_SINGLETON_CLASSIFIERS_MASK = r10;
        int r11 = Companion.access$nextMask(r5);
        SINGLETON_CLASSIFIERS_MASK = r11;
        int r12 = Companion.access$nextMask(r5);
        TYPE_ALIASES_MASK = r12;
        int r13 = Companion.access$nextMask(r5);
        PACKAGES_MASK = r13;
        int r14 = Companion.access$nextMask(r5);
        FUNCTIONS_MASK = r14;
        int r15 = Companion.access$nextMask(r5);
        VARIABLES_MASK = r15;
        int r16 = Companion.access$nextMask(r5) - 1;
        ALL_KINDS_MASK = r16;
        int r17 = (r10 | r11) | r12;
        CLASSIFIERS_MASK = r17;
        int r18 = (r11 | r14) | r15;
        VALUES_MASK = r18;
        int r19 = r14 | r15;
        CALLABLES_MASK = r19;
        int r110 = 2;
        ALL = new DescriptorKindFilter(r16, 0 == true ? 1 : 0, r110, 0 == true ? 1 : 0);
        CALLABLES = new DescriptorKindFilter(r19, 0 == true ? 1 : 0, r110, 0 == true ? 1 : 0);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(r10, 0 == true ? 1 : 0, r110, 0 == true ? 1 : 0);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(r11, 0 == true ? 1 : 0, r110, 0 == true ? 1 : 0);
        TYPE_ALIASES = new DescriptorKindFilter(r12, 0 == true ? 1 : 0, r110, 0 == true ? 1 : 0);
        CLASSIFIERS = new DescriptorKindFilter(r17, 0 == true ? 1 : 0, r110, 0 == true ? 1 : 0);
        PACKAGES = new DescriptorKindFilter(r13, 0 == true ? 1 : 0, r110, 0 == true ? 1 : 0);
        FUNCTIONS = new DescriptorKindFilter(r14, 0 == true ? 1 : 0, r110, 0 == true ? 1 : 0);
        VARIABLES = new DescriptorKindFilter(r15, 0 == true ? 1 : 0, r110, 0 == true ? 1 : 0);
        VALUES = new DescriptorKindFilter(r18, 0 == true ? 1 : 0, r110, 0 == true ? 1 : 0);
        Field[] r20 = DescriptorKindFilter.class.getFields();
        ArrayList r21 = new ArrayList();
        int r22 = r20.length;
        int r23 = 0;
        int r24 = 0;
    L3:
        if (r24 >= r22) goto L8;
        Field r25 = r20[r24];
        if (Modifier.isStatic(r25.getModifiers()) == false) goto L7;
        r21.add(r25);
    L7:
        r24 = r24 + 1;
        goto L3
    L8:
        ArrayList r26 = new ArrayList();
        Iterator r27 = r21.iterator();
    L10:
        if (r27.hasNext() == false) goto L20;
        Field r28 = (Field) r27.next();
        Object r29 = r28.get(null);
        if ((r29 instanceof DescriptorKindFilter) == false) goto L14;
        DescriptorKindFilter r30 = (DescriptorKindFilter) r29;
    L15:
        if (r30 == null) goto L17;
        Companion.MaskToName r31 = new Companion.MaskToName(r30.kindMask, r28.getName());
    L18:
        if (r31 == null) goto L10;
        r26.add(r31);
        goto L10
    L17:
        r31 = null;
        goto L18
    L14:
        r30 = null;
        goto L15
    L20:
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = r26;
        Field[] r32 = DescriptorKindFilter.class.getFields();
        ArrayList r33 = new ArrayList();
        int r34 = r32.length;
    L21:
        if (r23 >= r34) goto L26;
        Field r35 = r32[r23];
        if (Modifier.isStatic(r35.getModifiers()) == false) goto L25;
        r33.add(r35);
    L25:
        r23 = r23 + 1;
        goto L21
    L26:
        ArrayList r36 = new ArrayList();
        Iterator r37 = r33.iterator();
    L28:
        if (r37.hasNext() == false) goto L32;
        Object r38 = r37.next();
        if (Intrinsics.areEqual(((Field) r38).getType(), Integer.TYPE) == false) goto L28;
        r36.add(r38);
        goto L28
    L32:
        ArrayList r39 = new ArrayList();
        Iterator r40 = r36.iterator();
    L34:
        if (r40.hasNext() == false) goto L41;
        Field r41 = (Field) r40.next();
        Object r42 = r41.get(null);
        Intrinsics.checkNotNull(r42, "null cannot be cast to non-null type kotlin.Int");
        int r43 = ((Integer) r42).intValue();
        if (r43 != ((-r43) & r43)) goto L38;
        Companion.MaskToName r44 = new Companion.MaskToName(r43, r41.getName());
    L39:
        if (r44 == null) goto L34;
        r39.add(r44);
        goto L34
    L38:
        r44 = null;
        goto L39
    L41:
        DEBUG_MASK_BIT_NAMES = r39;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DescriptorKindFilter(int r5, List<? extends DescriptorKindExclude> r10) {
        Intrinsics.checkNotNullParameter(r10, "excludes");
        this.excludes = r10;
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r5 = r5 & (~((DescriptorKindExclude) r11.next()).getFullyExcludedDescriptorKinds());
        goto L4
    L6:
        this.kindMask = r5;
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

    public static final /* synthetic */ void access$setNextMaskValue$cp(int r5) {
        nextMaskValue = r5;
    }

    public final boolean acceptsKinds(int r5) {
        if ((this.kindMask & r5) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r10 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(DescriptorKindFilter.class, r10) == true) goto L11;
        return false;
    L11:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        DescriptorKindFilter r11 = (DescriptorKindFilter) r5;
        if (Intrinsics.areEqual(this.excludes, r11.excludes) == true) goto L15;
        return false;
    L15:
        if (this.kindMask == r11.kindMask) goto L17;
        return false;
    L17:
        return true;
    L7:
        r10 = null;
        goto L9
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

    public final DescriptorKindFilter restrictedToKindsOrNull(int r5) {
        int r10 = r5 & this.kindMask;
        if (r10 != 0) goto L7;
        return null;
    L7:
        return new DescriptorKindFilter(r10, this.excludes);
    }

    public String toString() {
        Iterator<T> r5 = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r10 = r5.next();
        if (((Companion.MaskToName) r10).getMask() != this.kindMask) goto L4;
    L9:
        Companion.MaskToName r11 = (Companion.MaskToName) r10;
        if (r11 == null) goto L12;
        String r12 = r11.getName();
    L13:
        if (r12 != null) goto L25;
        List<Companion.MaskToName> r13 = DEBUG_MASK_BIT_NAMES;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L16:
        if (r15.hasNext() == false) goto L23;
        Companion.MaskToName r16 = (Companion.MaskToName) r15.next();
        if (acceptsKinds(r16.getMask()) == false) goto L20;
        String r17 = r16.getName();
    L21:
        if (r17 == null) goto L16;
        r14.add(r17);
        goto L16
    L20:
        r17 = null;
        goto L21
    L23:
        r12 = CollectionsKt.q(r14, " | ", null, null, 0, null, null, 62);
    L25:
        return a.v(j0.x("DescriptorKindFilter(", r12, ", "), this.excludes, ')');
    L12:
        r12 = null;
        goto L13
    L8:
        r10 = null;
        goto L9
    }

    public /* synthetic */ DescriptorKindFilter(int r5, List r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = CollectionsKt.emptyList();
    L5:
        this(r5, r10);
    }
}
