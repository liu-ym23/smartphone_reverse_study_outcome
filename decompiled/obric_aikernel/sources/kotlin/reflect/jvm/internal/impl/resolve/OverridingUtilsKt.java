package kotlin.reflect.jvm.internal.impl.resolve;

import a1.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes3.dex */
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> r10, Function1<? super H, ? extends CallableDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "descriptorByHandle");
        if (r10.size() > 1) goto L5;
        return r10;
    L5:
        LinkedList r12 = new LinkedList(r10);
        SmartSet r13 = SmartSet.Companion.create();
    L7:
        if ((!r12.isEmpty()) == false) goto L23;
        Object r14 = CollectionsKt.first(r12);
        final SmartSet r15 = SmartSet.Companion.create();
        Collection r16 = OverridingUtil.extractMembersOverridableInBothWays(r14, r12, r11, new OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(r15));
        Intrinsics.checkNotNullExpressionValue(r16, "conflictedHandles = Smar…nflictedHandles.add(it) }");
        if (r16.size() != 1) goto L13;
        if (r15.isEmpty() == false) goto L13;
        Object r17 = CollectionsKt.single(r16);
        Intrinsics.checkNotNullExpressionValue(r17, "overridableGroup.single()");
        r13.add(r17);
    L13:
        b r18 = (Object) OverridingUtil.selectMostSpecificMember(r16, r11);
        Intrinsics.checkNotNullExpressionValue(r18, "selectMostSpecificMember…roup, descriptorByHandle)");
        CallableDescriptor r19 = r11.invoke(r18);
        Iterator r20 = r16.iterator();
    L15:
        if (r20.hasNext() == false) goto L20;
        b r21 = (Object) r20.next();
        Intrinsics.checkNotNullExpressionValue(r21, "it");
        if (OverridingUtil.isMoreSpecific(r19, r11.invoke(r21)) == true) goto L15;
        r15.add(r21);
        goto L15
    L20:
        if ((!r15.isEmpty()) == false) goto L22;
        r13.addAll(r15);
    L22:
        r13.add(r18);
        goto L7
    L23:
        return r13;
    }
}
