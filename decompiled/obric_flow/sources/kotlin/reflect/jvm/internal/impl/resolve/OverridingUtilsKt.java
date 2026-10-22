package kotlin.reflect.jvm.internal.impl.resolve;

import a1.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\noverridingUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 overridingUtils.kt\norg/jetbrains/kotlin/resolve/OverridingUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,84:1\n1620#2,3:85\n847#2,2:88\n*S KotlinDebug\n*F\n+ 1 overridingUtils.kt\norg/jetbrains/kotlin/resolve/OverridingUtilsKt\n*L\n40#1:85,3\n72#1:88,2\n*E\n"})
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> r10, Function1<? super H, ? extends CallableDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "descriptorByHandle");
        if (r10.size() > 1) goto L5;
        return r10;
    L5:
        LinkedList r5 = new LinkedList(r10);
        SmartSet r12 = SmartSet.Companion.create();
    L7:
        if (r5.isEmpty() == true) goto L23;
        Object r13 = CollectionsKt.first(r5);
        final SmartSet r14 = SmartSet.Companion.create();
        Collection r15 = OverridingUtil.extractMembersOverridableInBothWays(r13, r5, r11, new OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(r14));
        if (r15.size() != 1) goto L13;
        if (r14.isEmpty() == false) goto L13;
        r12.add(CollectionsKt.single(r15));
    L13:
        b r16 = (Object) OverridingUtil.selectMostSpecificMember(r15, r11);
        CallableDescriptor r17 = r11.invoke(r16);
        Iterator r18 = r15.iterator();
    L15:
        if (r18.hasNext() == false) goto L20;
        b r19 = (Object) r18.next();
        if (OverridingUtil.isMoreSpecific(r17, r11.invoke(r19)) == true) goto L15;
        r14.add(r19);
        goto L15
    L20:
        if (r14.isEmpty() == true) goto L22;
        r12.addAll(r14);
    L22:
        r12.add(r16);
        goto L7
    L23:
        return r12;
    }
}
