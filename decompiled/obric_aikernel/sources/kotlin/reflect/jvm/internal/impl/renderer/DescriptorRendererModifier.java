package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final enum DescriptorRendererModifier extends Enum<DescriptorRendererModifier> {
    private static final /* synthetic */ DescriptorRendererModifier[] $VALUES = null;
    public static final DescriptorRendererModifier ACTUAL = null;

    @JvmField
    public static final Set<DescriptorRendererModifier> ALL = null;

    @JvmField
    public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS = null;
    public static final DescriptorRendererModifier ANNOTATIONS = null;
    public static final DescriptorRendererModifier CONST = null;
    public static final Companion Companion = null;
    public static final DescriptorRendererModifier DATA = null;
    public static final DescriptorRendererModifier EXPECT = null;
    public static final DescriptorRendererModifier FUN = null;
    public static final DescriptorRendererModifier INLINE = null;
    public static final DescriptorRendererModifier INNER = null;
    public static final DescriptorRendererModifier LATEINIT = null;
    public static final DescriptorRendererModifier MEMBER_KIND = null;
    public static final DescriptorRendererModifier MODALITY = null;
    public static final DescriptorRendererModifier OVERRIDE = null;
    public static final DescriptorRendererModifier VALUE = null;
    public static final DescriptorRendererModifier VISIBILITY = null;
    private final boolean includeByDefault;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    private static final /* synthetic */ DescriptorRendererModifier[] $values() {
        return new DescriptorRendererModifier[]{VISIBILITY, MODALITY, OVERRIDE, ANNOTATIONS, INNER, MEMBER_KIND, DATA, INLINE, EXPECT, ACTUAL, CONST, LATEINIT, FUN, VALUE};
    }

    static {
        int r10 = 0;
        VISIBILITY = new DescriptorRendererModifier("VISIBILITY", 0, true);
        MODALITY = new DescriptorRendererModifier("MODALITY", 1, true);
        OVERRIDE = new DescriptorRendererModifier("OVERRIDE", 2, true);
        ANNOTATIONS = new DescriptorRendererModifier("ANNOTATIONS", 3, false);
        INNER = new DescriptorRendererModifier("INNER", 4, true);
        MEMBER_KIND = new DescriptorRendererModifier("MEMBER_KIND", 5, true);
        DATA = new DescriptorRendererModifier("DATA", 6, true);
        INLINE = new DescriptorRendererModifier("INLINE", 7, true);
        EXPECT = new DescriptorRendererModifier("EXPECT", 8, true);
        ACTUAL = new DescriptorRendererModifier("ACTUAL", 9, true);
        CONST = new DescriptorRendererModifier("CONST", 10, true);
        LATEINIT = new DescriptorRendererModifier("LATEINIT", 11, true);
        FUN = new DescriptorRendererModifier("FUN", 12, true);
        VALUE = new DescriptorRendererModifier("VALUE", 13, true);
        $VALUES = $values();
        Companion = new Companion(null);
        DescriptorRendererModifier[] r11 = values();
        ArrayList r12 = new ArrayList();
        int r13 = r11.length;
    L3:
        if (r10 >= r13) goto L8;
        DescriptorRendererModifier r14 = r11[r10];
        if (r14.includeByDefault == false) goto L7;
        r12.add(r14);
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        ALL_EXCEPT_ANNOTATIONS = CollectionsKt.toSet(r12);
        ALL = ArraysKt.toSet(values());
    }

    private DescriptorRendererModifier(String r10, int r11, boolean r12) {
        super(r10, r11);
        this.includeByDefault = r12;
    }

    public static DescriptorRendererModifier valueOf(String r10) {
        return (DescriptorRendererModifier) Enum.valueOf(DescriptorRendererModifier.class, r10);
    }

    public static DescriptorRendererModifier[] values() {
        return (DescriptorRendererModifier[]) $VALUES.clone();
    }
}
