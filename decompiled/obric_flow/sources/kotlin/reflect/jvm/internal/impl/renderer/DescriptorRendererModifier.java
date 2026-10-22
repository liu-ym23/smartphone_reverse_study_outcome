package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDescriptorRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorRenderer.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererModifier\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,318:1\n3792#2:319\n4307#2,2:320\n*S KotlinDebug\n*F\n+ 1 DescriptorRenderer.kt\norg/jetbrains/kotlin/renderer/DescriptorRendererModifier\n*L\n312#1:319\n312#1:320,2\n*E\n"})
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
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ DescriptorRendererModifier[] $values() {
        return new DescriptorRendererModifier[]{VISIBILITY, MODALITY, OVERRIDE, ANNOTATIONS, INNER, MEMBER_KIND, DATA, INLINE, EXPECT, ACTUAL, CONST, LATEINIT, FUN, VALUE};
    }

    static {
        int r5 = 0;
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
        DescriptorRendererModifier[] r10 = values();
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
    L3:
        if (r5 >= r12) goto L8;
        DescriptorRendererModifier r13 = r10[r5];
        if (r13.includeByDefault == false) goto L7;
        r11.add(r13);
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        ALL_EXCEPT_ANNOTATIONS = CollectionsKt.toSet(r11);
        ALL = ArraysKt.toSet(values());
    }

    private DescriptorRendererModifier(String r5, int r10, boolean r11) {
        super(r5, r10);
        this.includeByDefault = r11;
    }

    public static DescriptorRendererModifier valueOf(String r5) {
        return (DescriptorRendererModifier) Enum.valueOf(DescriptorRendererModifier.class, r5);
    }

    public static DescriptorRendererModifier[] values() {
        return (DescriptorRendererModifier[]) $VALUES.clone();
    }
}
